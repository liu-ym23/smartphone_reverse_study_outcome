package com.android.server.voiceinteraction;

import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.app.AppGlobals;
import android.app.IActivityManager;
import android.app.IActivityTaskManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ServiceInfo;
import android.database.ContentObserver;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.hardware.soundtrigger.IRecognitionStatusCallback;
import android.hardware.soundtrigger.SoundTrigger;
import android.media.permission.Identity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SharedMemory;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings;
import android.service.voice.IMicrophoneHotwordDetectionVoiceInteractionCallback;
import android.service.voice.IVisualQueryDetectionVoiceInteractionCallback;
import android.service.voice.IVoiceInteractionService;
import android.service.voice.IVoiceInteractionSession;
import android.service.voice.VoiceInteractionManagerInternal;
import android.service.voice.VoiceInteractionServiceInfo;
import android.system.OsConstants;
import android.util.PrintWriterPrinter;
import android.util.Slog;
import android.view.IWindowManager;
import com.android.internal.app.IHotwordRecognitionStatusCallback;
import com.android.internal.app.IVisualQueryDetectionAttentionListener;
import com.android.internal.app.IVoiceActionCheckCallback;
import com.android.internal.app.IVoiceInteractionAccessibilitySettingsListener;
import com.android.internal.app.IVoiceInteractionSessionShowCallback;
import com.android.internal.app.IVoiceInteractor;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.LocalServices;
import com.android.server.wm.ActivityAssistInfo;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class VoiceInteractionManagerServiceImpl implements VoiceInteractionSessionConnection.Callback {
    private static final long BACKOFF_MILLIS = 500;
    static final String CLOSE_REASON_VOICE_INTERACTION = "voiceinteraction";
    static final boolean DEBUG = false;
    private static final long DEFERRED_CALLBACK_MILLIS = 10000;
    private static final long MAX_BACKOFF_MILLIS = 600000;
    private static final long REQUEST_DIRECT_ACTIONS_RETRY_TIME_MS = 200;
    private static final boolean SYSPROP_VISUAL_QUERY_SERVICE_ENABLED = false;
    static final String TAG = "VoiceInteractionServiceManager";
    final ArrayList<IVoiceInteractionAccessibilitySettingsListener> mAccessibilitySettingsListeners;
    VoiceInteractionSessionConnection mActiveSession;
    final IActivityManager mAm;
    final IActivityTaskManager mAtm;
    volatile boolean mBound;
    final BroadcastReceiver mBroadcastReceiver;
    final ComponentName mComponent;
    final ServiceConnection mConnection;
    private int mConnectionBackoffAttempts;
    private final Runnable mConnectionRunnable;
    final Context mContext;
    private final Runnable mDeferredConnectionCallback;
    final Handler mDirectActionsHandler;
    int mDisabledShowContext;
    final Handler mHandler;
    final ComponentName mHotwordDetectionComponentName;
    volatile HotwordDetectionConnection mHotwordDetectionConnection;
    final IWindowManager mIWindowManager;
    final VoiceInteractionServiceInfo mInfo;
    private volatile boolean mIsTemporaryBound;
    final PackageManagerInternal mPackageManagerInternal;
    IVoiceInteractionService mService;
    final VoiceInteractionManagerService.VoiceInteractionManagerServiceStub mServiceStub;
    final ComponentName mSessionComponentName;
    private boolean mShutDown;
    final int mUser;
    final boolean mValid;
    final ComponentName mVisualQueryDetectionComponentName;

    private final class AccessibilitySettingsContentObserver extends ContentObserver {
        private Uri mAccessibilitySettingsEnabledUri;
        final /* synthetic */ VoiceInteractionManagerServiceImpl this$0;

        public static /* synthetic */ void $r8$lambda$u9gFC16sXlNsOSwANGKKijqoM8U(boolean r0, IVoiceInteractionAccessibilitySettingsListener r1) {
            lambda$onChange$0(r0, r1);
        }

        AccessibilitySettingsContentObserver(VoiceInteractionManagerServiceImpl r1) {
            this.this$0 = r1;
            super(null);
            this.mAccessibilitySettingsEnabledUri = Settings.Secure.getUriFor("visual_query_accessibility_detection_enabled");
        }

        public void register(ContentResolver contentResolver) {
            contentResolver.registerContentObserver(this.mAccessibilitySettingsEnabledUri, false, this, -1);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            Slog.i(VoiceInteractionManagerServiceImpl.TAG, "OnChange called with uri:" + uri);
            if (this.mAccessibilitySettingsEnabledUri.equals(uri) == false) goto L9;
            final boolean enable = false;
            if (Settings.Secure.getIntForUser(this.this$0.mContext.getContentResolver(), "visual_query_accessibility_detection_enabled", 0, this.this$0.mUser) != 1) goto L7;
            enable = true;
        L7:
            Slog.i(VoiceInteractionManagerServiceImpl.TAG, "Notifying listeners with Accessibility setting set to " + enable);
            this.this$0.mAccessibilitySettingsListeners.forEach(new VoiceInteractionManagerServiceImpl$AccessibilitySettingsContentObserver$$ExternalSyntheticLambda0(enable));
            return;
        }

        private static /* synthetic */ void lambda$onChange$0(boolean enable, IVoiceInteractionAccessibilitySettingsListener listener) {
            listener.onAccessibilityDetectionChanged(enable);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            e.rethrowFromSystemServer();
        }
    }

    interface DetectorRemoteExceptionListener {
        void onDetectorRemoteException(IBinder r1, int r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$2OJZXKm-rRaTf_5BwUBRk6qbXsQ, reason: not valid java name */
    public static /* synthetic */ void m9433$r8$lambda$2OJZXKmrRaTf_5BwUBRk6qbXsQ(VoiceInteractionManagerServiceImpl r0) {
        r0.lambda$new$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$BtjEYsbz0xcg-F7Wf6BRVH9sEIk, reason: not valid java name */
    public static /* synthetic */ void m9434$r8$lambda$BtjEYsbz0xcgF7Wf6BRVH9sEIk(VoiceInteractionManagerServiceImpl r0, IBinder r1, int r2) {
        r0.lambda$initAndVerifyDetectorLocked$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$IaCpIGhtbbs4vktzu3_pvA1ffm8(VoiceInteractionManagerServiceImpl r0, IBinder r1, int r2, IBinder r3, RemoteCallback r4, RemoteCallback r5) {
        r0.retryRequestDirectActions(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$WhypTXr0ykj6HIszEABNynrEHyQ(VoiceInteractionManagerServiceImpl r0) {
        r0.retryConnectionWithBackoff();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeferredConnectionCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m9435$$Nest$fgetmDeferredConnectionCallback(VoiceInteractionManagerServiceImpl r0) {
        return r0.mDeferredConnectionCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsTemporaryBound, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9436$$Nest$fgetmIsTemporaryBound(VoiceInteractionManagerServiceImpl r0) {
        return r0.mIsTemporaryBound;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmShutDown, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9437$$Nest$fgetmShutDown(VoiceInteractionManagerServiceImpl r0) {
        return r0.mShutDown;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmConnectionBackoffAttempts, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9438$$Nest$fputmConnectionBackoffAttempts(VoiceInteractionManagerServiceImpl r0, int r1) {
        r0.mConnectionBackoffAttempts = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsTemporaryBound, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9439$$Nest$fputmIsTemporaryBound(VoiceInteractionManagerServiceImpl r0, boolean r1) {
        r0.mIsTemporaryBound = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mretryConnectionWithBackoff, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9440$$Nest$mretryConnectionWithBackoff(VoiceInteractionManagerServiceImpl r0) {
        r0.retryConnectionWithBackoff();
    }

    static {
        SYSPROP_VISUAL_QUERY_SERVICE_ENABLED = SystemProperties.getBoolean("ro.hotword.visual_query_service_enabled", false);
    }

    VoiceInteractionManagerServiceImpl(Context context, Handler handler, VoiceInteractionManagerService.VoiceInteractionManagerServiceStub stub, int userHandle, ComponentName service) {
        this.mBound = false;
        this.mBroadcastReceiver = new AnonymousClass1(this);
        this.mConnection = new AnonymousClass2(this);
        this.mAccessibilitySettingsListeners = new ArrayList();
        this.mShutDown = false;
        this.mIsTemporaryBound = false;
        this.mDeferredConnectionCallback = new VoiceInteractionManagerServiceImpl$$ExternalSyntheticLambda0(this);
        this.mConnectionRunnable = new VoiceInteractionManagerServiceImpl$$ExternalSyntheticLambda1(this);
        this.mContext = context;
        this.mHandler = handler;
        this.mDirectActionsHandler = new Handler(true);
        this.mServiceStub = stub;
        this.mUser = userHandle;
        this.mComponent = service;
        this.mAm = ActivityManager.getService();
        this.mAtm = ActivityTaskManager.getService();
        PackageManagerInternal r0 = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        r0.getClass();
        this.mPackageManagerInternal = r0;
        ComponentName r4 = null;
        VoiceInteractionServiceInfo info = new VoiceInteractionServiceInfo(context.getPackageManager(), service, this.mUser);     // Catch: PackageManager.NameNotFoundException -> L18
        this.mInfo = info;
        if (this.mInfo.getParseError() == null) goto L8;
        Slog.w(TAG, "Bad voice interaction service: " + this.mInfo.getParseError());
        this.mSessionComponentName = null;
        this.mHotwordDetectionComponentName = null;
        this.mVisualQueryDetectionComponentName = null;
        this.mIWindowManager = null;
        this.mValid = false;
        return;
    L8:
        this.mValid = true;
        this.mSessionComponentName = new ComponentName(service.getPackageName(), this.mInfo.getSessionService());
        String hotwordDetectionServiceName = this.mInfo.getHotwordDetectionService();
        if (hotwordDetectionServiceName == null) goto L11;
        ComponentName r2 = new ComponentName(service.getPackageName(), hotwordDetectionServiceName);
    L12:
        this.mHotwordDetectionComponentName = r2;
        String visualQueryDetectionServiceName = this.mInfo.getVisualQueryDetectionService();
        if (visualQueryDetectionServiceName == null) goto L16;
        r4 = new ComponentName(service.getPackageName(), visualQueryDetectionServiceName);
    L16:
        this.mVisualQueryDetectionComponentName = r4;
        this.mIWindowManager = IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        this.mContext.registerReceiver(this.mBroadcastReceiver, filter, null, handler, 2);
        new AccessibilitySettingsContentObserver(this).register(this.mContext.getContentResolver());
        return;
    L11:
        r2 = null;
    L18:
        e = move-exception;
        Slog.w(TAG, "Voice interaction service not found: " + service, e);
        this.mInfo = null;
        this.mSessionComponentName = null;
        this.mHotwordDetectionComponentName = null;
        this.mVisualQueryDetectionComponentName = null;
        this.mIWindowManager = null;
        this.mValid = false;
    }

    public void grantImplicitAccessLocked(int grantRecipientUid, Intent intent) {
        int grantRecipientAppId = UserHandle.getAppId(grantRecipientUid);
        int grantRecipientUserId = UserHandle.getUserId(grantRecipientUid);
        int voiceInteractionUid = this.mInfo.getServiceInfo().applicationInfo.uid;
        this.mPackageManagerInternal.grantImplicitAccess(grantRecipientUserId, intent, grantRecipientAppId, voiceInteractionUid, true);
    }

    public boolean showSessionLocked(Bundle args, int flags, String attributionTag, IVoiceInteractionSessionShowCallback showCallback, IBinder activityToken) {
        int sessionId = this.mServiceStub.getNextShowSessionId();
        if (args != null) goto L5;
        Bundle r1 = new Bundle();
    L6:
        Bundle newArgs = r1;
        newArgs.putInt("android.service.voice.SHOW_SESSION_ID", sessionId);
        StringBuilder r0 = new StringBuilder();
        r0.append("[AI KEY] showSessionLocked enter sessionId=");
        r0.append(sessionId);
        r0.append(" flags=");
        r0.append(flags);
        r0.append(" invocation_type=");
        r0.append(newArgs.getInt("invocation_type", -999));
        r0.append(" activeSession=");
        r0.append(this.mActiveSession);
        r0.append(" mShown=");
        Boolean r2 = null;
        if (this.mActiveSession == null) goto L9;
        Boolean r3 = Boolean.valueOf(this.mActiveSession.mShown);
    L10:
        r0.append(r3);
        r0.append(" mBound=");
        if (this.mActiveSession == null) goto L13;
        Boolean r4 = Boolean.valueOf(this.mActiveSession.mBound);
    L14:
        r0.append(r4);
        r0.append(" mSessionNull=");
        if (this.mActiveSession != null) goto L17;
    L21:
        r0.append(r2);
        Slog.d(TAG, r0.toString());
    L26:
        e = move-exception;
        Slog.w(TAG, "RemoteException while calling prepareToShowSession", e);
    L31:
        if (this.mActiveSession != null) goto L34;
        this.mActiveSession = new VoiceInteractionSessionConnection(this.mServiceStub, this.mSessionComponentName, this.mUser, this.mContext, this, this.mInfo.getServiceInfo().applicationInfo.uid, this.mHandler);
    L34:
        if (this.mActiveSession.mBound == false) goto L55;
    L43:
        List<ActivityAssistInfo> allVisibleActivities = ((ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class)).getTopVisibleActivities();
        if (activityToken == null) goto L52;
        List<ActivityAssistInfo> visibleActivities = new ArrayList();
        int activitiesCount = allVisibleActivities.size();
        int i = 0;
    L46:
        if (i >= activitiesCount) goto L51;
        ActivityAssistInfo info = allVisibleActivities.get(i);
        if (info.getActivityToken() == activityToken) goto L49;
        i = i + 1;
        goto L46
    L49:
        visibleActivities.add(info);
    L51:
        List<ActivityAssistInfo> visibleActivities2 = visibleActivities;
    L54:
        return this.mActiveSession.showLocked(newArgs, flags, attributionTag, this.mDisabledShowContext, showCallback, visibleActivities2);
    L52:
        visibleActivities2 = allVisibleActivities;
        goto L54
    L55:
    L39:
        e = move-exception;
        Slog.w(TAG, "RemoteException while calling showSessionFailed", e);
        goto L43
    L36:
        if (this.mService == null) goto L43;
        Bundle failedArgs = new Bundle();     // Catch: RemoteException -> L39
        failedArgs.putInt("android.service.voice.SHOW_SESSION_ID", sessionId);     // Catch: RemoteException -> L39
        this.mService.showSessionFailed(failedArgs);     // Catch: RemoteException -> L39
        goto L43
    L23:
        if (this.mService == null) goto L31;
        this.mService.prepareToShowSession(newArgs, flags);     // Catch: RemoteException -> L26
        goto L31
    L17:
        if (this.mActiveSession.mSession != null) goto L19;
        boolean r5 = true;
    L20:
        r2 = Boolean.valueOf(r5);
        goto L21
    L19:
        r5 = false;
        goto L20
    L13:
        r4 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = args;
        goto L6
    }

    public void getActiveServiceSupportedActions(List<String> commands, IVoiceActionCheckCallback callback) {
        if (this.mService != null) goto L16;
        Slog.w(TAG, "Not bound to voice interaction service " + this.mComponent);
        callback.onComplete(null);     // Catch: RemoteException -> L7
        return;
    L8:
        return;
    L16:
        this.mService.getActiveServiceSupportedActions(commands, callback);     // Catch: RemoteException -> L11
        return;
    L11:
        e = move-exception;
        Slog.w(TAG, "RemoteException while calling getActiveServiceSupportedActions", e);
    }

    public boolean hideSessionLocked() {
        Slog.d(TAG, "[AI KEY] hideSessionLocked called, activeSession=" + this.mActiveSession);
        if (this.mActiveSession != null) goto L5;
        return false;
    L5:
        return this.mActiveSession.hideLocked();
    }

    public boolean deliverNewSessionLocked(IBinder token, IVoiceInteractionSession session, IVoiceInteractor interactor) {
        if (this.mActiveSession != null) goto L5;
    L9:
        Slog.w(TAG, "deliverNewSession does not match active session");
        return false;
    L5:
        if (token != this.mActiveSession.mToken) goto L9;
        this.mActiveSession.deliverNewSessionLocked(session, interactor);
        return true;
    }

    public int startVoiceActivityLocked(String callingFeatureId, int callingPid, int callingUid, IBinder token, Intent intent, String resolvedType) {
    L29:
        e = e;
    L36:
        throw new IllegalStateException("Unexpected remote error", e);
    L43:
        if (this.mActiveSession == null) goto L32;
        if (token != this.mActiveSession.mToken) goto L32;
    L27:
        e = e;
        goto L36
    L11:
        if (this.mActiveSession.mShown == false) goto L39;
        Intent intent2 = new Intent(intent);     // Catch: RemoteException -> L25
        intent2.addCategory("android.intent.category.VOICE");     // Catch: RemoteException -> L23
        intent2.addFlags(AudioFormat.MP2);     // Catch: RemoteException -> L23
        return this.mAtm.startVoiceActivity(this.mComponent.getPackageName(), callingFeatureId, callingPid, callingUid, intent2, resolvedType, this.mActiveSession.mSession, this.mActiveSession.mInteractor, 0, null, null, this.mUser);
    L23:
        e = e;
        goto L36
    L39:
        Slog.w(TAG, "startVoiceActivity not allowed on hidden session");     // Catch: RemoteException -> L15
        return -100;
    L15:
        e = e;
    L32:
        Slog.w(TAG, "startVoiceActivity does not match active session");     // Catch: RemoteException -> L25
        return -99;
    L25:
        e = e;
        goto L36
    }

    public int startAssistantActivityLocked(String callingFeatureId, int callingPid, int callingUid, IBinder token, Intent intent, String resolvedType, Bundle bundle) {
    L25:
        e = e;
    L32:
        throw new IllegalStateException("Unexpected remote error", e);
    L34:
        if (this.mActiveSession == null) goto L28;
        if (token != this.mActiveSession.mToken) goto L28;
    L13:
        e = e;
        goto L32
    L10:
        if (this.mActiveSession.mShown == true) goto L17;
        Slog.w(TAG, "startAssistantActivity not allowed on hidden session");     // Catch: RemoteException -> L13
        return -90;
    L17:
        Intent intent2 = new Intent(intent);     // Catch: RemoteException -> L23
        intent2.addFlags(268435456);     // Catch: RemoteException -> L21
        bundle.putInt("android.activity.activityType", 4);     // Catch: RemoteException -> L21
        return this.mAtm.startAssistantActivity(this.mComponent.getPackageName(), callingFeatureId, callingPid, callingUid, intent2, resolvedType, bundle, this.mUser);
    L21:
        e = e;
    L28:
        Slog.w(TAG, "startAssistantActivity does not match active session");     // Catch: RemoteException -> L23
        return -89;
    L23:
        e = e;
        goto L32
    }

    public void requestDirectActionsLocked(IBinder token, int taskId, IBinder assistToken, RemoteCallback cancellationCallback, RemoteCallback callback) {
        if (this.mActiveSession != null) goto L5;
    L19:
        Slog.w(TAG, "requestDirectActionsLocked does not match active session");
        callback.sendResult(null);
        return;
    L5:
        if (token != this.mActiveSession.mToken) goto L19;
        ActivityTaskManagerInternal.ActivityTokens tokens = ((ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class)).getAttachedNonFinishingActivityForTask(taskId, null);
        if (tokens != null) goto L10;
    L17:
        Slog.w(TAG, "Unknown activity to query for direct actions");
        this.mDirectActionsHandler.sendMessageDelayed(PooledLambda.obtainMessage(new VoiceInteractionManagerServiceImpl$$ExternalSyntheticLambda2(), this, token, Integer.valueOf(taskId), assistToken, cancellationCallback, callback), REQUEST_DIRECT_ACTIONS_RETRY_TIME_MS);
        return;
    L10:
        if (tokens.getAssistToken() != assistToken) goto L17;
        grantImplicitAccessLocked(tokens.getUid(), null);
        tokens.getApplicationThread().requestDirectActions(tokens.getActivityToken(), this.mActiveSession.mInteractor, cancellationCallback, callback);     // Catch: RemoteException -> L15
        return;
    L15:
        e = move-exception;
        Slog.w("Unexpected remote error", e);
        callback.sendResult(null);
    }

    private void retryRequestDirectActions(IBinder token, int taskId, IBinder assistToken, RemoteCallback cancellationCallback, RemoteCallback callback) {
        VoiceInteractionManagerService.VoiceInteractionManagerServiceStub r0 = this.mServiceStub;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mActiveSession == null) goto L23;
        if (token != this.mActiveSession.mToken) goto L23;
        ActivityTaskManagerInternal.ActivityTokens tokens = ((ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class)).getAttachedNonFinishingActivityForTask(taskId, null);     // Catch: Throwable -> L16
        if (tokens != null) goto L12;
    L20:
        Slog.w(TAG, "Unknown activity to query for direct actions during retrying");     // Catch: Throwable -> L16
        callback.sendResult(null);     // Catch: Throwable -> L16
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L12:
        if (tokens.getAssistToken() != assistToken) goto L20;
        tokens.getApplicationThread().requestDirectActions(tokens.getActivityToken(), this.mActiveSession.mInteractor, cancellationCallback, callback);     // Catch: Throwable -> L16 RemoteException -> L18
    L18:
        e = move-exception;
        Slog.w("Unexpected remote error", e);     // Catch: Throwable -> L16
        callback.sendResult(null);     // Catch: Throwable -> L16
    L23:
        Slog.w(TAG, "retryRequestDirectActions does not match active session");     // Catch: Throwable -> L16
        callback.sendResult(null);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    void performDirectActionLocked(IBinder token, String actionId, Bundle arguments, int taskId, IBinder assistToken, RemoteCallback cancellationCallback, RemoteCallback resultCallback) {
        if (this.mActiveSession == null) goto L25;
        if (token != this.mActiveSession.mToken) goto L25;
        ActivityTaskManagerInternal.ActivityTokens tokens = ((ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class)).getAttachedNonFinishingActivityForTask(taskId, null);
        if (tokens == null) goto L22;
        if (tokens.getAssistToken() != assistToken) goto L22;
        tokens.getApplicationThread().performDirectAction(tokens.getActivityToken(), actionId, arguments, cancellationCallback, resultCallback);     // Catch: RemoteException -> L16
        return;
    L16:
        e = e;
    L20:
        Slog.w("Unexpected remote error", e);
        resultCallback.sendResult(null);
        return;
    L18:
        e = e;
    L22:
        Slog.w(TAG, "Unknown activity to perform a direct action");
        resultCallback.sendResult(null);
        return;
    L25:
        Slog.w(TAG, "performDirectActionLocked does not match active session");
        resultCallback.sendResult(null);
    }

    public void setKeepAwakeLocked(IBinder token, boolean keepAwake) {
    L9:
        e = move-exception;
        throw new IllegalStateException("Unexpected remote error", e);
    L3:
        if (this.mActiveSession == null) goto L11;
        if (token != this.mActiveSession.mToken) goto L11;
        this.mAtm.setVoiceKeepAwake(this.mActiveSession.mSession, keepAwake);     // Catch: RemoteException -> L9
        return;
    L11:
        Slog.w(TAG, "setKeepAwake does not match active session");     // Catch: RemoteException -> L9
    }

    public void closeSystemDialogsLocked(IBinder token) {
    L9:
        e = move-exception;
        throw new IllegalStateException("Unexpected remote error", e);
    L3:
        if (this.mActiveSession == null) goto L11;
        if (token != this.mActiveSession.mToken) goto L11;
        this.mAm.closeSystemDialogs(CLOSE_REASON_VOICE_INTERACTION);     // Catch: RemoteException -> L9
        return;
    L11:
        Slog.w(TAG, "closeSystemDialogs does not match active session");     // Catch: RemoteException -> L9
    }

    public void finishLocked(IBinder token, boolean finishTask) {
        if (this.mActiveSession == null) goto L10;
        if (finishTask == false) goto L6;
    L8:
        this.mActiveSession.cancelLocked(finishTask);
        this.mActiveSession = null;
        return;
    L6:
        if (token == this.mActiveSession.mToken) goto L8;
    L10:
        Slog.w(TAG, "finish does not match active session");
    }

    public void setDisabledShowContextLocked(int callingUid, int flags) {
        int activeUid = this.mInfo.getServiceInfo().applicationInfo.uid;
        if (callingUid != activeUid) goto L7;
        this.mDisabledShowContext = flags;
        return;
    L7:
        throw new SecurityException("Calling uid " + callingUid + " does not match active uid " + activeUid);
    }

    public int getDisabledShowContextLocked(int callingUid) {
        int activeUid = this.mInfo.getServiceInfo().applicationInfo.uid;
        if (callingUid != activeUid) goto L7;
        return this.mDisabledShowContext;
    L7:
        throw new SecurityException("Calling uid " + callingUid + " does not match active uid " + activeUid);
    }

    public int getUserDisabledShowContextLocked(int callingUid) {
        int activeUid = this.mInfo.getServiceInfo().applicationInfo.uid;
        if (callingUid != activeUid) goto L10;
        if (this.mActiveSession != null) goto L11;
        return 0;
    L11:
        return this.mActiveSession.getUserDisabledShowContextLocked();
    L10:
        throw new SecurityException("Calling uid " + callingUid + " does not match active uid " + activeUid);
    }

    public boolean supportsLocalVoiceInteraction() {
        return this.mInfo.getSupportsLocalInteraction();
    }

    public ApplicationInfo getApplicationInfo() {
        return this.mInfo.getServiceInfo().applicationInfo;
    }

    public void startListeningVisibleActivityChangedLocked(IBinder token) {
        if (this.mActiveSession != null) goto L5;
    L9:
        Slog.w(TAG, "startListeningVisibleActivityChangedLocked does not match active session");
        return;
    L5:
        if (token != this.mActiveSession.mToken) goto L9;
        this.mActiveSession.startListeningVisibleActivityChangedLocked();
    }

    public void stopListeningVisibleActivityChangedLocked(IBinder token) {
        if (this.mActiveSession != null) goto L5;
    L9:
        Slog.w(TAG, "stopListeningVisibleActivityChangedLocked does not match active session");
        return;
    L5:
        if (token != this.mActiveSession.mToken) goto L9;
        this.mActiveSession.stopListeningVisibleActivityChangedLocked();
    }

    public void notifyActivityDestroyedLocked(IBinder activityToken) {
        if (this.mActiveSession != null) goto L5;
        return;
    L5:
        if (this.mActiveSession.mShown == false) goto L10;
        this.mActiveSession.notifyActivityDestroyedLocked(activityToken);
        return;
    }

    public void notifyActivityEventChangedLocked(IBinder activityToken, int type) {
        if (this.mActiveSession != null) goto L5;
        return;
    L5:
        if (this.mActiveSession.mShown == false) goto L10;
        this.mActiveSession.notifyActivityEventChangedLocked(activityToken, type);
        return;
    }

    public void updateStateLocked(PersistableBundle options, SharedMemory sharedMemory, IBinder token) {
        Slog.v(TAG, "updateStateLocked");
        if (sharedMemory == null) goto L10;
        if (sharedMemory.setProtect(OsConstants.PROT_READ) == true) goto L10;
        Slog.w(TAG, "Can't set sharedMemory to be read-only");
        throw new IllegalStateException("Can't set sharedMemory to be read-only");
    L10:
        if (this.mHotwordDetectionConnection == null) goto L19;
        Object r0 = this.mHotwordDetectionConnection.mLock;
        monitor-enter(r0);
        this.mHotwordDetectionConnection.updateStateLocked(options, sharedMemory, token);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    L19:
        Slog.w(TAG, "update State, but no hotword detection connection");
        throw new IllegalStateException("Hotword detection connection not found");
    }

    private void verifyDetectorForHotwordDetectionLocked(SharedMemory sharedMemory, IHotwordRecognitionStatusCallback callback, int detectorType) {
        Slog.v(TAG, "verifyDetectorForHotwordDetectionLocked");
        int voiceInteractionServiceUid = this.mInfo.getServiceInfo().applicationInfo.uid;
        if (this.mHotwordDetectionComponentName == null) goto L28;
        ServiceInfo hotwordDetectionServiceInfo = getServiceInfoLocked(this.mHotwordDetectionComponentName, this.mUser);
        if (hotwordDetectionServiceInfo != null) goto L7;
        Slog.w(TAG, "Hotword detection service info not found");
        logDetectorCreateEventIfNeeded(callback, detectorType, false, voiceInteractionServiceUid);
        throw new IllegalStateException("Hotword detection service info not found");
    L7:
        if (isIsolatedProcessLocked(hotwordDetectionServiceInfo) == true) goto L9;
        Slog.w(TAG, "Hotword detection service not in isolated process");
        logDetectorCreateEventIfNeeded(callback, detectorType, false, voiceInteractionServiceUid);
        throw new IllegalStateException("Hotword detection service not in isolated process");
    L9:
        if ("android.permission.BIND_HOTWORD_DETECTION_SERVICE".equals(hotwordDetectionServiceInfo.permission) == true) goto L11;
        Slog.w(TAG, "Hotword detection service does not require permission android.permission.BIND_HOTWORD_DETECTION_SERVICE");
        logDetectorCreateEventIfNeeded(callback, detectorType, false, voiceInteractionServiceUid);
        throw new SecurityException("Hotword detection service does not require permission android.permission.BIND_HOTWORD_DETECTION_SERVICE");
    L11:
        if (this.mContext.getPackageManager().checkPermission("android.permission.BIND_HOTWORD_DETECTION_SERVICE", this.mInfo.getServiceInfo().packageName) == 0) goto L20;
        if (sharedMemory != null) goto L14;
    L18:
        logDetectorCreateEventIfNeeded(callback, detectorType, true, voiceInteractionServiceUid);
        return;
    L14:
        if (sharedMemory.setProtect(OsConstants.PROT_READ) == true) goto L18;
        Slog.w(TAG, "Can't set sharedMemory to be read-only");
        logDetectorCreateEventIfNeeded(callback, detectorType, false, voiceInteractionServiceUid);
        throw new IllegalStateException("Can't set sharedMemory to be read-only");
    L20:
        Slog.w(TAG, "Voice interaction service should not hold permission android.permission.BIND_HOTWORD_DETECTION_SERVICE");
        logDetectorCreateEventIfNeeded(callback, detectorType, false, voiceInteractionServiceUid);
        throw new SecurityException("Voice interaction service should not hold permission android.permission.BIND_HOTWORD_DETECTION_SERVICE");
    L28:
        Slog.w(TAG, "Hotword detection service name not found");
        logDetectorCreateEventIfNeeded(callback, detectorType, false, voiceInteractionServiceUid);
        throw new IllegalStateException("Hotword detection service name not found");
    }

    private void verifyDetectorForVisualQueryDetectionLocked(SharedMemory sharedMemory) {
        Slog.v(TAG, "verifyDetectorForVisualQueryDetectionLocked");
        if (this.mVisualQueryDetectionComponentName == null) goto L27;
        ServiceInfo visualQueryDetectionServiceInfo = getServiceInfoLocked(this.mVisualQueryDetectionComponentName, this.mUser);
        if (visualQueryDetectionServiceInfo != null) goto L7;
        Slog.w(TAG, "Visual query detection service info not found");
        throw new IllegalStateException("Visual query detection service name not found");
    L7:
        if (isIsolatedProcessLocked(visualQueryDetectionServiceInfo) == true) goto L9;
        Slog.w(TAG, "Visual query detection service not in isolated process");
        throw new IllegalStateException("Visual query detection not in isolated process");
    L9:
        if ("android.permission.BIND_VISUAL_QUERY_DETECTION_SERVICE".equals(visualQueryDetectionServiceInfo.permission) == true) goto L11;
        Slog.w(TAG, "Visual query detection does not require permission android.permission.BIND_VISUAL_QUERY_DETECTION_SERVICE");
        throw new SecurityException("Visual query detection does not require permission android.permission.BIND_VISUAL_QUERY_DETECTION_SERVICE");
    L11:
        if (this.mContext.getPackageManager().checkPermission("android.permission.BIND_VISUAL_QUERY_DETECTION_SERVICE", this.mInfo.getServiceInfo().packageName) == 0) goto L19;
        if (sharedMemory != null) goto L14;
        return;
    L14:
        if (sharedMemory.setProtect(OsConstants.PROT_READ) == true) goto L29;
        Slog.w(TAG, "Can't set sharedMemory to be read-only");
        throw new IllegalStateException("Can't set sharedMemory to be read-only");
    L29:
        return;
    L19:
        Slog.w(TAG, "Voice interaction service should not hold permission android.permission.BIND_VISUAL_QUERY_DETECTION_SERVICE");
        throw new SecurityException("Voice interaction service should not hold permission android.permission.BIND_VISUAL_QUERY_DETECTION_SERVICE");
    L27:
        Slog.w(TAG, "Visual query detection service name not found");
        throw new IllegalStateException("Visual query detection service name not found");
    }

    public void initAndVerifyDetectorLocked(Identity voiceInteractorIdentity, PersistableBundle options, SharedMemory sharedMemory, IBinder token, IHotwordRecognitionStatusCallback callback, int detectorType) {
        if (detectorType == 3) goto L5;
        IHotwordRecognitionStatusCallback r1 = callback;
        verifyDetectorForHotwordDetectionLocked(sharedMemory, r1, detectorType);
    L7:
        if (SYSPROP_VISUAL_QUERY_SERVICE_ENABLED == false) goto L14;
        if (verifyProcessSharingLocked() == true) goto L14;
        Slog.w(TAG, "Sandboxed detection service not in shared isolated process");
        throw new IllegalStateException("VisualQueryDetectionService or HotworDetectionService not in a shared isolated process. Please make sure to set android:allowSharedIsolatedProcess and android:isolatedProcess to be true and android:externalService to be false in the manifest file");
    L14:
        if (this.mHotwordDetectionConnection != null) goto L16;
        this.mHotwordDetectionConnection = new HotwordDetectionConnection(this.mServiceStub, this.mContext, this.mInfo.getServiceInfo().applicationInfo.uid, voiceInteractorIdentity, this.mHotwordDetectionComponentName, this.mVisualQueryDetectionComponentName, this.mUser, false, detectorType, new VoiceInteractionManagerServiceImpl$$ExternalSyntheticLambda3(this));
        registerAccessibilityDetectionSettingsListenerLocked(this.mHotwordDetectionConnection.mAccessibilitySettingsListener);
    L18:
        this.mHotwordDetectionConnection.createDetectorLocked(options, sharedMemory, token, r1, detectorType);
        return;
    L16:
        if (detectorType == 3) goto L18;
        this.mHotwordDetectionConnection.setDetectorType(detectorType);
        goto L18
    L5:
        r1 = callback;
        verifyDetectorForVisualQueryDetectionLocked(sharedMemory);
        goto L7
    }

    private /* synthetic */ void lambda$initAndVerifyDetectorLocked$0(IBinder token1, int detectorType1) {
        this.mService.detectorRemoteExceptionOccurred(token1, detectorType1);     // Catch: RemoteException -> L4
        return;
    L5:
        Slog.w(TAG, "Fail to notify client detector remote exception occurred.");
    }

    public void destroyDetectorLocked(IBinder token) {
        Slog.v(TAG, "destroyDetectorLocked");
        if (this.mHotwordDetectionConnection != null) goto L6;
        Slog.w(TAG, "destroy detector callback, but no hotword detection connection");
        return;
    L6:
        this.mHotwordDetectionConnection.destroyDetectorLocked(token);
    }

    private void logDetectorCreateEventIfNeeded(IHotwordRecognitionStatusCallback callback, int detectorType, boolean isCreated, int voiceInteractionServiceUid) {
        if (callback == null) goto L5;
        HotwordMetricsLogger.writeDetectorCreateEvent(detectorType, isCreated, voiceInteractionServiceUid);
        return;
    }

    public void shutdownHotwordDetectionServiceLocked() {
        if (this.mHotwordDetectionConnection != null) goto L6;
        Slog.w(TAG, "shutdown, but no hotword detection connection");
        return;
    L6:
        this.mHotwordDetectionConnection.cancelLocked();
        unregisterAccessibilityDetectionSettingsListenerLocked(this.mHotwordDetectionConnection.mAccessibilitySettingsListener);
        this.mHotwordDetectionConnection = null;
    }

    public void setVisualQueryDetectionAttentionListenerLocked(IVisualQueryDetectionAttentionListener listener) {
        if (this.mHotwordDetectionConnection != null) goto L5;
        return;
    L5:
        this.mHotwordDetectionConnection.setVisualQueryDetectionAttentionListenerLocked(listener);
    }

    public boolean startPerceivingLocked(IVisualQueryDetectionVoiceInteractionCallback callback) {
        if (this.mHotwordDetectionConnection != null) goto L7;
        return false;
    L7:
        return this.mHotwordDetectionConnection.startPerceivingLocked(callback);
    }

    public boolean stopPerceivingLocked() {
        if (this.mHotwordDetectionConnection != null) goto L7;
        Slog.w(TAG, "stopPerceivingLocked() called but connection isn't established");
        return false;
    L7:
        return this.mHotwordDetectionConnection.stopPerceivingLocked();
    }

    public void startListeningFromMicLocked(android.media.AudioFormat audioFormat, IMicrophoneHotwordDetectionVoiceInteractionCallback callback) {
        if (this.mHotwordDetectionConnection != null) goto L5;
        return;
    L5:
        this.mHotwordDetectionConnection.startListeningFromMicLocked(audioFormat, callback);
    }

    public void startListeningFromExternalSourceLocked(ParcelFileDescriptor audioStream, android.media.AudioFormat audioFormat, PersistableBundle options, IBinder token, IMicrophoneHotwordDetectionVoiceInteractionCallback callback) {
        if (this.mHotwordDetectionConnection != null) goto L5;
        return;
    L5:
        if (audioStream == null) goto L8;
        this.mHotwordDetectionConnection.startListeningFromExternalSourceLocked(audioStream, audioFormat, options, token, callback);
        return;
    L8:
        Slog.w(TAG, "External source is null for hotword detector");
        throw new IllegalStateException("External source is null for hotword detector");
    }

    public void startListeningFromWearableLocked(ParcelFileDescriptor audioStream, android.media.AudioFormat audioFormat, PersistableBundle options, VoiceInteractionManagerInternal.WearableHotwordDetectionCallback callback) {
        if (this.mHotwordDetectionConnection != null) goto L6;
        callback.onError("Unable to start listening from wearable because the hotword detection connection is null.");
        return;
    L6:
        this.mHotwordDetectionConnection.startListeningFromWearableLocked(audioStream, audioFormat, options, callback);
    }

    public void stopListeningFromMicLocked() {
        if (this.mHotwordDetectionConnection != null) goto L6;
        Slog.w(TAG, "stopListeningFromMicLocked() called but connection isn't established");
        return;
    L6:
        this.mHotwordDetectionConnection.stopListeningFromMicLocked();
    }

    public void triggerHardwareRecognitionEventForTestLocked(SoundTrigger.KeyphraseRecognitionEvent event, IHotwordRecognitionStatusCallback callback) {
        if (this.mHotwordDetectionConnection != null) goto L6;
        Slog.w(TAG, "triggerHardwareRecognitionEventForTestLocked() called but connection isn't established");
        return;
    L6:
        this.mHotwordDetectionConnection.triggerHardwareRecognitionEventForTestLocked(event, callback);
    }

    public IRecognitionStatusCallback createSoundTriggerCallbackLocked(Context context, IHotwordRecognitionStatusCallback callback, Identity voiceInteractorIdentity) {
        return new HotwordDetectionConnection.SoundTriggerCallback(context, callback, this.mHotwordDetectionConnection, voiceInteractorIdentity);
    }

    private static ServiceInfo getServiceInfoLocked(ComponentName componentName, int userHandle) {
        return AppGlobals.getPackageManager().getServiceInfo(componentName, 786560, userHandle);
    L5:
        return null;
    }

    boolean isIsolatedProcessLocked(ServiceInfo serviceInfo) {
        if ((serviceInfo.flags & 2) != 0) goto L5;
    L7:
        return false;
    L5:
        if ((serviceInfo.flags & 4) != 0) goto L7;
        return true;
    }

    boolean verifyProcessSharingLocked() {
        ServiceInfo hotwordInfo = getServiceInfoLocked(this.mHotwordDetectionComponentName, this.mUser);
        ServiceInfo visualQueryInfo = getServiceInfoLocked(this.mVisualQueryDetectionComponentName, this.mUser);
        if (hotwordInfo == null) goto L13;
        if (visualQueryInfo == null) goto L13;
        if ((hotwordInfo.flags & 16) != 0) goto L9;
    L11:
        return false;
    L9:
        if ((visualQueryInfo.flags & 16) == 0) goto L11;
        return true;
    L13:
        return true;
    }

    void forceRestartHotwordDetector() {
        if (this.mHotwordDetectionConnection != null) goto L6;
        Slog.w(TAG, "Failed to force-restart hotword detection: no hotword detection active");
        return;
    L6:
        this.mHotwordDetectionConnection.forceRestart();
    }

    void setDebugHotwordLoggingLocked(boolean logging) {
        if (this.mHotwordDetectionConnection != null) goto L6;
        Slog.w(TAG, "Failed to set temporary debug logging: no hotword detection active");
        return;
    L6:
        this.mHotwordDetectionConnection.setDebugHotwordLoggingLocked(logging);
    }

    void resetHotwordDetectionConnectionLocked() {
        if (this.mHotwordDetectionConnection != null) goto L5;
        return;
    L5:
        this.mHotwordDetectionConnection.cancelLocked();
        unregisterAccessibilityDetectionSettingsListenerLocked(this.mHotwordDetectionConnection.mAccessibilitySettingsListener);
        this.mHotwordDetectionConnection = null;
    }

    public void dumpLocked(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (this.mValid == true) goto L9;
        pw.print("  NOT VALID: ");
        if (this.mInfo != null) goto L7;
        pw.println("no info");
        return;
    L7:
        pw.println(this.mInfo.getParseError());
        return;
    L9:
        pw.print("  mUser=");
        pw.println(this.mUser);
        pw.print("  mComponent=");
        pw.println(this.mComponent.flattenToShortString());
        pw.print("  Session service=");
        pw.println(this.mInfo.getSessionService());
        pw.println("  Service info:");
        this.mInfo.getServiceInfo().dump(new PrintWriterPrinter(pw), "    ");
        pw.print("  Recognition service=");
        pw.println(this.mInfo.getRecognitionService());
        pw.print("  Hotword detection service=");
        pw.println(this.mInfo.getHotwordDetectionService());
        pw.print("  Settings activity=");
        pw.println(this.mInfo.getSettingsActivity());
        pw.print("  Supports assist=");
        pw.println(this.mInfo.getSupportsAssist());
        pw.print("  Supports launch from keyguard=");
        pw.println(this.mInfo.getSupportsLaunchFromKeyguard());
        if (this.mDisabledShowContext == 0) goto L12;
        pw.print("  mDisabledShowContext=");
        pw.println(Integer.toHexString(this.mDisabledShowContext));
    L12:
        pw.print("  mBound=");
        pw.print(this.mBound);
        pw.print(" mService=");
        pw.println(this.mService);
        if (this.mHotwordDetectionConnection == null) goto L15;
        pw.println("  Hotword detection connection:");
        this.mHotwordDetectionConnection.dump("    ", pw);
    L17:
        if (this.mActiveSession == null) goto L21;
        pw.println("  Active session:");
        this.mActiveSession.dump("    ", pw);
        return;
    L21:
        return;
    L15:
        pw.println("  No Hotword detection connection");
        goto L17
    }

    boolean getAccessibilityDetectionEnabled() {
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "visual_query_accessibility_detection_enabled", 0, this.mUser) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    void registerAccessibilityDetectionSettingsListenerLocked(IVoiceInteractionAccessibilitySettingsListener listener) {
        this.mAccessibilitySettingsListeners.add(listener);
    }

    void unregisterAccessibilityDetectionSettingsListenerLocked(IVoiceInteractionAccessibilitySettingsListener listener) {
        this.mAccessibilitySettingsListeners.remove(listener);
    }

    void startLocked() {
        Intent intent = new Intent("android.service.voice.VoiceInteractionService");
        intent.setComponent(this.mComponent);
        if (this.mBound == false) goto L5;
    L19:
        Slog.w(TAG, "startLocked return " + this.mBound + ", " + this.mShutDown);
        return;
    L5:
        if (this.mShutDown == true) goto L19;
        if (this.mIsTemporaryBound == false) goto L11;
        Slog.w(TAG, "temp bound, return");
        return;
    L11:
        Slog.w(TAG, "startLocked " + this.mComponent);
        boolean bound = this.mContext.bindServiceAsUser(intent, this.mConnection, 68161537, new UserHandle(this.mUser));
        if (bound == true) goto L14;
        Slog.w(TAG, "Failed binding to voice interaction service " + this.mComponent);
    L14:
        this.mIsTemporaryBound = bound;
        Slog.w(TAG, "startLocked bound? = " + bound);
        if (bound == false) goto L17;
        this.mHandler.postDelayed(this.mDeferredConnectionCallback, 10000);
        return;
    L17:
        retryConnectionWithBackoff();
    }

    public void launchVoiceAssistFromKeyguard() {
        if (this.mService != null) goto L11;
        Slog.w(TAG, "Not bound to voice interaction service " + this.mComponent);
        return;
    L11:
        this.mService.launchVoiceAssistFromKeyguard();     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Slog.w(TAG, "RemoteException while calling launchVoiceAssistFromKeyguard", e);
    }

    void shutdownLocked() {
        this.mShutDown = true;
        Slog.w(TAG, "shutdownLocked " + this.mComponent);
        if (this.mHandler.hasCallbacks(this.mConnectionRunnable) == false) goto L6;
        this.mHandler.removeCallbacks(this.mConnectionRunnable);
    L6:
        if (this.mActiveSession == null) goto L34;
        this.mActiveSession.cancelLocked(false);
        this.mActiveSession = null;
    L34:
    L12:
        e = move-exception;
        Slog.w(TAG, "RemoteException in shutdown", e);
    L17:
        if (this.mHotwordDetectionConnection == null) goto L20;
        this.mHotwordDetectionConnection.cancelLocked();
        unregisterAccessibilityDetectionSettingsListenerLocked(this.mHotwordDetectionConnection.mAccessibilitySettingsListener);
        this.mHotwordDetectionConnection = null;
    L20:
        if (this.mBound == false) goto L22;
    L23:
        this.mBound = false;
        this.mIsTemporaryBound = false;
        this.mContext.unbindService(this.mConnection);     // Catch: Throwable -> L26
    L29:
        if (this.mValid == false) goto L36;
        this.mContext.unregisterReceiver(this.mBroadcastReceiver);
        return;
    L36:
        return;
    L27:
        Slog.e(TAG, "unbindService error when shut down");
        goto L29
    L22:
        if (this.mIsTemporaryBound == false) goto L29;
    L9:
        if (this.mService == null) goto L17;
        this.mService.shutdown();     // Catch: RemoteException -> L12
        goto L17
    }

    void notifySoundModelsChangedLocked() {
        if (this.mService != null) goto L11;
        Slog.w(TAG, "Not bound to voice interaction service " + this.mComponent);
        return;
    L11:
        this.mService.soundModelsChanged();     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Slog.w(TAG, "RemoteException while calling soundModelsChanged", e);
    }

    @Override // com.android.server.voiceinteraction.VoiceInteractionSessionConnection.Callback
    public void sessionConnectionGone(VoiceInteractionSessionConnection connection) {
        VoiceInteractionManagerService.VoiceInteractionManagerServiceStub r0 = this.mServiceStub;
        monitor-enter(r0);
        finishLocked(connection.mToken, false);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.voiceinteraction.VoiceInteractionSessionConnection.Callback
    public void onSessionShown(VoiceInteractionSessionConnection connection) {
        this.mServiceStub.onSessionShown();
    }

    @Override // com.android.server.voiceinteraction.VoiceInteractionSessionConnection.Callback
    public void onSessionHidden(VoiceInteractionSessionConnection connection) {
        this.mServiceStub.onSessionHidden();
        this.mServiceStub.setSessionWindowVisible(connection.mToken, false);
    }

    private /* synthetic */ void lambda$new$1() {
        Slog.w(TAG, "mConnectionRunnable.run " + this.mBound);
        if (this.mBound == false) goto L5;
        return;
    L5:
        if (this.mShutDown == true) goto L10;
        this.mIsTemporaryBound = false;
        startLocked();
        return;
    }

    private void retryConnectionWithBackoff() {
        Slog.w(TAG, "retryConnectionWithBackoff " + this.mComponent + ", isBound = " + this.mBound + ", shutdown = " + this.mShutDown);
        if (this.mBound == false) goto L5;
    L13:
        Slog.w(TAG, "retryConnectionWithBackoff shut down");
        return;
    L5:
        if (this.mShutDown == true) goto L13;
        if (this.mHandler.hasCallbacks(this.mConnectionRunnable) == false) goto L11;
        Slog.w(TAG, "retryConnectionWithBackoff scheduled");
        return;
    L11:
        long timeoutMs = (long) Math.min(Math.scalb(500.0f, this.mConnectionBackoffAttempts), 600000.0f);
        this.mHandler.postDelayed(this.mConnectionRunnable, timeoutMs);
        this.mConnectionBackoffAttempts++;
        Slog.d(TAG, "Failed to connect on attempt " + this.mConnectionBackoffAttempts + " will try again in " + timeoutMs + "ms");
    }
}
