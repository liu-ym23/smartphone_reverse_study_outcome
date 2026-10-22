package com.android.server.voiceinteraction;

import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.app.AppOpsManager;
import android.app.IActivityManager;
import android.app.IActivityTaskManager;
import android.app.UriGrantsManager;
import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManagerInternal;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.provider.Settings;
import android.service.voice.IVoiceInteractionSession;
import android.service.voice.IVoiceInteractionSessionService;
import android.service.voice.VisibleActivityInfo;
import android.util.ArrayMap;
import android.util.Slog;
import android.view.IWindowManager;
import com.android.internal.app.AssistUtils;
import com.android.internal.app.IVoiceInteractionSessionShowCallback;
import com.android.internal.app.IVoiceInteractor;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.am.AssistDataRequester;
import com.android.server.job.controllers.JobStatus;
import com.android.server.power.LowPowerStandbyControllerInternal;
import com.android.server.uri.UriGrantsManagerInternal;
import com.android.server.wm.ActivityAssistInfo;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.obric.utils.ObricImplFactory;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
final class VoiceInteractionSessionConnection implements ServiceConnection, AssistDataRequester.AssistDataRequesterCallbacks {
    static final int BOOST_TIMEOUT_MS = 300;
    static final boolean DEBUG = false;
    private static final int LOW_POWER_STANDBY_ALLOWLIST_TIMEOUT_MS = 120000;
    static final int MAX_POWER_BOOST_TIMEOUT = 10000;
    static final int POWER_BOOST_TIMEOUT_MS = 0;
    static final String TAG = "VoiceInteractionServiceManager";
    final IActivityTaskManager mActivityTaskManager;
    final IActivityManager mAm;
    final AppOpsManager mAppOps;
    AssistDataRequester mAssistDataRequester;
    final Intent mBindIntent;
    boolean mBound;
    final Callback mCallback;
    final int mCallingUid;
    boolean mCanceled;
    final Context mContext;
    private final Handler mFgHandler;
    final ServiceConnection mFullConnection;
    boolean mFullyBound;
    final Handler mHandler;
    final IWindowManager mIWindowManager;
    IVoiceInteractor mInteractor;
    private boolean mListeningVisibleActivity;
    final Object mLock;
    private boolean mLowPowerStandbyAllowlisted;
    private final LowPowerStandbyControllerInternal mLowPowerStandbyControllerInternal;
    private IObricVoiceInteractionSessionConnection mObricExt;
    private List<ActivityAssistInfo> mPendingHandleAssistWithoutData;
    ArrayList<IVoiceInteractionSessionShowCallback> mPendingShowCallbacks;
    final IBinder mPermissionOwner;
    private final PowerManagerInternal mPowerManagerInternal;
    private final Runnable mRemoveFromLowPowerStandbyAllowlistRunnable;
    private final ScheduledExecutorService mScheduledExecutorService;
    IVoiceInteractionSessionService mService;
    IVoiceInteractionSession mSession;
    final ComponentName mSessionComponentName;
    private PowerBoostSetter mSetPowerBoostRunnable;
    Bundle mShowArgs;
    private Runnable mShowAssistDisclosureRunnable;
    IVoiceInteractionSessionShowCallback mShowCallback;
    int mShowFlags;
    boolean mShown;
    final IBinder mToken;
    final UriGrantsManagerInternal mUgmInternal;
    final int mUser;
    private final ArrayMap<IBinder, VisibleActivityInfo> mVisibleActivityInfoForToken;

    public interface Callback {
        void onSessionHidden(VoiceInteractionSessionConnection r1);

        void onSessionShown(VoiceInteractionSessionConnection r1);

        void sessionConnectionGone(VoiceInteractionSessionConnection r1);
    }

    class PowerBoostSetter implements Runnable {
        private boolean mCanceled;
        private final Instant mExpiryTime;
        final /* synthetic */ VoiceInteractionSessionConnection this$0;

        PowerBoostSetter(VoiceInteractionSessionConnection this$0, Instant expiryTime) {
            this.this$0 = this$0;
            this.mExpiryTime = expiryTime;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mCanceled == false) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L11:
            if (SysOptBridge.getFactory().getDynamicRefreshRateService().shouldInterceptPowerBoost("voice_interaction_session") == false) goto L16;
            Slog.i(VoiceInteractionSessionConnection.TAG, "voice_interaction_session is config, not set power boost.");     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L16:
            if (Instant.now().isBefore(this.mExpiryTime) == false) goto L20;
            VoiceInteractionSessionConnection.m9444$$Nest$fgetmPowerManagerInternal(this.this$0).setPowerBoost(0, 300);     // Catch: Throwable -> L8
            if (VoiceInteractionSessionConnection.m9445$$Nest$fgetmSetPowerBoostRunnable(this.this$0) == null) goto L21;
            VoiceInteractionSessionConnection.m9443$$Nest$fgetmFgHandler(this.this$0).postDelayed(VoiceInteractionSessionConnection.m9445$$Nest$fgetmSetPowerBoostRunnable(this.this$0), VoiceInteractionSessionConnection.POWER_BOOST_TIMEOUT_MS);     // Catch: Throwable -> L8
        L21:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L20:
            Slog.w(VoiceInteractionSessionConnection.TAG, "Reset power boost INTERACTION because reaching max timeout.");     // Catch: Throwable -> L8
            VoiceInteractionSessionConnection.m9444$$Nest$fgetmPowerManagerInternal(this.this$0).setPowerBoost(0, -1);     // Catch: Throwable -> L8
            goto L21
        }

        void cancel() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            this.mCanceled = true;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$61JaFtv-HNurIyihIAeqTohfP7Y, reason: not valid java name */
    public static /* synthetic */ void m9441$r8$lambda$61JaFtvHNurIyihIAeqTohfP7Y(VoiceInteractionSessionConnection r0, IBinder r1, int r2) {
        r0.lambda$notifyActivityEventChangedLocked$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$McGZ4mLhpllekyTs61ZkmSRUpd8(VoiceInteractionSessionConnection r0, IBinder r1) {
        r0.lambda$notifyActivityDestroyedLocked$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$xX6Smey6hkW8W-W7pQTd_eop6Co, reason: not valid java name */
    public static /* synthetic */ void m9442$r8$lambda$xX6Smey6hkW8WW7pQTd_eop6Co(VoiceInteractionSessionConnection r0) {
        r0.removeFromLowPowerStandbyAllowlist();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFgHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m9443$$Nest$fgetmFgHandler(VoiceInteractionSessionConnection r0) {
        return r0.mFgHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManagerInternal m9444$$Nest$fgetmPowerManagerInternal(VoiceInteractionSessionConnection r0) {
        return r0.mPowerManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSetPowerBoostRunnable, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerBoostSetter m9445$$Nest$fgetmSetPowerBoostRunnable(VoiceInteractionSessionConnection r0) {
        return r0.mSetPowerBoostRunnable;
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyPendingShowCallbacksFailedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9446$$Nest$mnotifyPendingShowCallbacksFailedLocked(VoiceInteractionSessionConnection r0) {
        r0.notifyPendingShowCallbacksFailedLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyPendingShowCallbacksShownLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9447$$Nest$mnotifyPendingShowCallbacksShownLocked(VoiceInteractionSessionConnection r0) {
        r0.notifyPendingShowCallbacksShownLocked();
    }

    static {
        POWER_BOOST_TIMEOUT_MS = Integer.parseInt(System.getProperty("vendor.powerhal.interaction.max", "200"));
    }

    public VoiceInteractionSessionConnection(Object lock, ComponentName component, int user, Context context, Callback callback, int callingUid, Handler handler) {
        this.mToken = new Binder();
        this.mPendingShowCallbacks = new ArrayList();
        this.mPendingHandleAssistWithoutData = new ArrayList();
        this.mScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        this.mVisibleActivityInfoForToken = new ArrayMap();
        this.mRemoveFromLowPowerStandbyAllowlistRunnable = new VoiceInteractionSessionConnection$$ExternalSyntheticLambda1(this);
        this.mObricExt = (IObricVoiceInteractionSessionConnection) ObricImplFactory.getImpl(IObricVoiceInteractionSessionConnection.class, new Object[]{this});
        this.mShowCallback = new AnonymousClass1(this);
        this.mFullConnection = new AnonymousClass2(this);
        this.mShowAssistDisclosureRunnable = new AnonymousClass3(this);
        this.mLock = lock;
        this.mSessionComponentName = component;
        this.mUser = user;
        this.mContext = context;
        this.mCallback = callback;
        this.mCallingUid = callingUid;
        this.mHandler = handler;
        this.mActivityTaskManager = ActivityTaskManager.getService();
        this.mAm = ActivityManager.getService();
        this.mUgmInternal = (UriGrantsManagerInternal) LocalServices.getService(UriGrantsManagerInternal.class);
        this.mIWindowManager = IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
        this.mPowerManagerInternal = (PowerManagerInternal) LocalServices.getService(PowerManagerInternal.class);
        this.mLowPowerStandbyControllerInternal = (LowPowerStandbyControllerInternal) LocalServices.getService(LowPowerStandbyControllerInternal.class);
        this.mAppOps = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        this.mFgHandler = FgThread.getHandler();
        this.mAssistDataRequester = new AssistDataRequester(this.mContext, this.mIWindowManager, (AppOpsManager) this.mContext.getSystemService("appops"), this, this.mLock, 49, 50);
        IBinder permOwner = this.mUgmInternal.newUriPermissionOwner("voicesession:" + component.flattenToShortString());
        this.mPermissionOwner = permOwner;
        this.mBindIntent = new Intent("android.service.voice.VoiceInteractionService");
        this.mBindIntent.setComponent(this.mSessionComponentName);
        this.mBound = this.mContext.bindServiceAsUser(this.mBindIntent, this, 1048625, new UserHandle(this.mUser));
        if (this.mBound == true) goto L10;
        Slog.w(TAG, "Failed binding to voice interaction session service " + this.mSessionComponentName);
        return;
    L10:
        this.mIWindowManager.addWindowToken(this.mToken, 2031, 0, null);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.w(TAG, "Failed adding window token", e);
    }

    public int getUserDisabledShowContextLocked() {
        int flags = 0;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "assist_structure_enabled", 1, this.mUser) != 0) goto L6;
        flags = 0 | 1;
    L6:
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "assist_screenshot_enabled", 1, this.mUser) == 0) goto L8;
        return flags;
    L8:
        return flags | 2;
    }

    public boolean showLocked(Bundle args, int flags, String attributionTag, int disabledContext, IVoiceInteractionSessionShowCallback showCallback, List<ActivityAssistInfo> topActivities) {
        if (this.mBound == true) goto L5;
        StringBuilder r0 = new StringBuilder();
        r0.append("[AI KEY] showLocked -> !mBound, show FAILED (not delivered). invocation_type=");
        if (args == null) goto L98;
        int r7 = args.getInt("invocation_type", -999);
    L99:
        r0.append(r7);
        r0.append(" flags=");
        r0.append(flags);
        Slog.d(TAG, r0.toString());
        if (showCallback == null) goto L116;
        showCallback.onFailed();     // Catch: RemoteException -> L103
        return false;
    L104:
        return false;
    L116:
        return false;
    L98:
        r7 = -888;
        goto L99
    L5:
        if (this.mFullyBound == true) goto L7;
        this.mFullyBound = this.mContext.bindServiceAsUser(this.mBindIntent, this.mFullConnection, 404226049, new UserHandle(this.mUser));
    L7:
        this.mShown = true;
        this.mShowArgs = args;
        this.mShowFlags = flags;
        int disabledContext2 = disabledContext | getUserDisabledShowContextLocked();
        if ((flags & 1) == 0) goto L10;
        boolean r1 = true;
    L11:
        boolean fetchData = r1;
        if ((flags & 2) == 0) goto L14;
        boolean fetchScreenshot = true;
    L15:
        if (fetchData == true) goto L19;
        if (fetchScreenshot == true) goto L19;
        boolean assistDataRequestNeeded = false;
    L20:
        if (assistDataRequestNeeded == false) goto L22;
    L25:
        boolean r14 = true;
    L26:
        boolean assistDataRequestNeeded2 = r14;
        if (assistDataRequestNeeded2 == false) goto L66;
        int topActivitiesCount = topActivities.size();
        ArrayList<IBinder> topActivitiesToken = new ArrayList(topActivitiesCount);
        int i = 0;
    L29:
        if (i >= topActivitiesCount) goto L35;
        if (getObricExt().assistantExclude(topActivities, i) == true) goto L34;
        topActivitiesToken.add(topActivities.get(i).getActivityToken());
    L34:
        i = i + 1;
        goto L29
    L35:
        int i2 = disabledContext2 & 1;
        if (i2 != 0) goto L38;
        boolean fetchDataAllowed = true;
    L39:
        boolean isAssistDataAllowed = false;
        isAssistDataAllowed = this.mActivityTaskManager.isAssistDataAllowed();     // Catch: RemoteException -> L42
    L43:
        if (fetchDataAllowed == false) goto L49;
        if (isAssistDataAllowed == false) goto L49;
        ArrayList<ComponentName> topComponents = new ArrayList(topActivitiesCount);
        int i3 = 0;
    L46:
        if (i3 >= topActivitiesCount) goto L48;
        topComponents.add(topActivities.get(i3).getComponentName());
        i3 = i3 + 1;
        goto L46
    L48:
        this.mShowArgs.putParcelableArrayList("android.service.voice.FOREGROUND_ACTIVITIES", topComponents);
    L49:
        AssistDataRequester r15 = this.mAssistDataRequester;
        if ((disabledContext2 & 2) != 0) goto L52;
        boolean r19 = true;
    L53:
        r15.requestAssistData(topActivitiesToken, fetchData, fetchScreenshot, fetchDataAllowed, r19, this.mCallingUid, this.mSessionComponentName.getPackageName(), attributionTag);
        if (this.mAssistDataRequester.getPendingDataCount() <= 0) goto L56;
    L59:
        boolean needDisclosure = true;
    L61:
        if (needDisclosure == false) goto L66;
        if (AssistUtils.shouldDisclose(this.mContext, this.mSessionComponentName) == false) goto L66;
        this.mHandler.post(this.mShowAssistDisclosureRunnable);
        goto L66
    L56:
        if (this.mAssistDataRequester.getPendingScreenshotCount() > 0) goto L59;
        needDisclosure = false;
        goto L61
    L52:
        r19 = false;
        goto L53
    L38:
        fetchDataAllowed = false;
    L66:
        if (this.mSession == null) goto L78;
        StringBuilder r2 = new StringBuilder();
        r2.append("[AI KEY] showLocked -> deliver to client mSession.show() invocation_type=");
        if (this.mShowArgs == null) goto L70;
        int r8 = this.mShowArgs.getInt("invocation_type", -999);
    L71:
        r2.append(r8);
        r2.append(" flags=");
        r2.append(this.mShowFlags);
        Slog.d(TAG, r2.toString());
        this.mSession.show(this.mShowArgs, this.mShowFlags, showCallback);     // Catch: RemoteException -> L74
        this.mShowArgs = null;     // Catch: RemoteException -> L74
        this.mShowFlags = 0;     // Catch: RemoteException -> L74
    L75:
        if (assistDataRequestNeeded2 == false) goto L77;
        this.mAssistDataRequester.processPendingAssistData();
    L88:
        if (this.mSetPowerBoostRunnable == null) goto L90;
        this.mSetPowerBoostRunnable.cancel();
    L90:
        this.mSetPowerBoostRunnable = new PowerBoostSetter(this, Instant.now().plusMillis(JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY));
        this.mFgHandler.post(this.mSetPowerBoostRunnable);
        if (this.mLowPowerStandbyControllerInternal == null) goto L93;
        this.mLowPowerStandbyControllerInternal.addToAllowlist(this.mCallingUid, 1);
        this.mLowPowerStandbyAllowlisted = true;
        this.mFgHandler.removeCallbacks(this.mRemoveFromLowPowerStandbyAllowlistRunnable);
        this.mFgHandler.postDelayed(this.mRemoveFromLowPowerStandbyAllowlistRunnable, 120000);
    L93:
        this.mCallback.onSessionShown(this);
        return true;
    L77:
        doHandleAssistWithoutData(topActivities);
        goto L88
    L70:
        r8 = -888;
        goto L71
    L78:
        StringBuilder r3 = new StringBuilder();
        r3.append("[AI KEY] showLocked -> mSession==null, NOT delivered, stored pending. invocation_type=");
        if (args == null) goto L81;
        int r9 = args.getInt("invocation_type", -999);
    L82:
        r3.append(r9);
        r3.append(" flags=");
        r3.append(flags);
        Slog.d(TAG, r3.toString());
        if (showCallback == null) goto L85;
        this.mPendingShowCallbacks.add(showCallback);
    L85:
        if (assistDataRequestNeeded2 == true) goto L88;
        this.mPendingHandleAssistWithoutData = topActivities;
        goto L88
    L81:
        r9 = -888;
        goto L82
    L22:
        if (getObricExt().forceAllowAssistDataRequest() == true) goto L25;
        r14 = false;
    L19:
        assistDataRequestNeeded = true;
        goto L20
    L14:
        fetchScreenshot = false;
        goto L15
    L10:
        r1 = false;
        goto L11
    }

    private void doHandleAssistWithoutData(List<ActivityAssistInfo> topActivities) {
        int activityCount = topActivities.size();
        int i = 0;
    L3:
        if (i >= activityCount) goto L10;
        ActivityAssistInfo topActivity = topActivities.get(i);
        IBinder assistToken = topActivity.getAssistToken();
        int taskId = topActivity.getTaskId();
        int activityIndex = i;
        this.mSession.handleAssist(taskId, assistToken, null, null, null, activityIndex, activityCount);     // Catch: RemoteException -> L7
    L8:
        i = i + 1;
        goto L3
    }

    @Override // com.android.server.am.AssistDataRequester.AssistDataRequesterCallbacks
    public boolean canHandleReceivedAssistDataLocked() {
        if (this.mSession == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.am.AssistDataRequester.AssistDataRequesterCallbacks
    public void onAssistDataReceivedLocked(Bundle data, int activityIndex, int activityCount) {
        if (this.mSession != null) goto L5;
        return;
    L5:
        if (data == null) goto L30;
        int taskId = data.getInt(ActivityTaskManagerInternal.ASSIST_TASK_ID);
        IBinder activityId = data.getBinder(ActivityTaskManagerInternal.ASSIST_ACTIVITY_ID);
        Bundle assistData = data.getBundle("data");
        AssistStructure structure = (AssistStructure) data.getParcelable(ActivityTaskManagerInternal.ASSIST_KEY_STRUCTURE, AssistStructure.class);
        AssistContent content = (AssistContent) data.getParcelable(ActivityTaskManagerInternal.ASSIST_KEY_CONTENT, AssistContent.class);
        if (assistData == null) goto L13;
        int uid = assistData.getInt("android.intent.extra.ASSIST_UID", -1);
        int uid2 = uid;
    L14:
        if (uid2 < 0) goto L32;
        if (content == null) goto L32;
        Intent intent = content.getIntent();
        if (intent == null) goto L23;
        ClipData clipData = intent.getClipData();
        if (clipData == null) goto L23;
        if (Intent.isAccessUriMode(intent.getFlags()) == false) goto L23;
        grantClipDataPermissions(clipData, intent.getFlags(), uid2, this.mCallingUid, this.mSessionComponentName.getPackageName());
    L23:
        ClipData clipData2 = content.getClipData();
        if (clipData2 == null) goto L32;
        grantClipDataPermissions(clipData2, 1, uid2, this.mCallingUid, this.mSessionComponentName.getPackageName());
    L32:
        this.mSession.handleAssist(taskId, activityId, assistData, structure, content, activityIndex, activityCount);     // Catch: RemoteException -> L28
        return;
    L29:
        return;
    L13:
        uid2 = -1;
        goto L14
    L30:
        this.mSession.handleAssist(-1, null, null, null, null, 0, 0);     // Catch: RemoteException -> L8
        return;
    }

    @Override // com.android.server.am.AssistDataRequester.AssistDataRequesterCallbacks
    public void onAssistScreenshotReceivedLocked(Bitmap screenshot) {
        if (this.mSession != null) goto L9;
        return;
    L9:
        this.mSession.handleScreenshot(screenshot);     // Catch: RemoteException -> L7
        return;
    }

    void grantUriPermission(Uri uri, int mode, int srcUid, int destUid, String destPkg) {
        if (ActivityTaskManagerInternal.ASSIST_KEY_CONTENT.equals(uri.getScheme()) == true) goto L5;
        return;
    L5:
        long ident = Binder.clearCallingIdentity();
        this.mUgmInternal.checkGrantUriPermission(srcUid, null, ContentProvider.getUriWithoutUserId(uri), mode, ContentProvider.getUserIdFromUri(uri, UserHandle.getUserId(srcUid)));     // Catch: Throwable -> L15 SecurityException -> L17 RemoteException -> L19
        int sourceUserId = ContentProvider.getUserIdFromUri(uri, this.mUser);     // Catch: Throwable -> L15 SecurityException -> L17 RemoteException -> L19
        Uri uri2 = ContentProvider.getUriWithoutUserId(uri);     // Catch: Throwable -> L15 SecurityException -> L17 RemoteException -> L19
        UriGrantsManager.getService().grantUriPermissionFromOwner(this.mPermissionOwner, srcUid, destPkg, uri2, 1, sourceUserId, this.mUser);     // Catch: Throwable -> L9 SecurityException -> L11 RemoteException -> L13
    L8:
        Binder.restoreCallingIdentity(ident);
        return;
    L11:
        e = move-exception;
        SecurityException e = e;
    L22:
        Slog.w(TAG, "Can't propagate permission", e);     // Catch: Throwable -> L9
    L14:
        uri = uri2;
        goto L26
    L9:
        th = move-exception;
        Throwable r12 = th;
    L24:
        Binder.restoreCallingIdentity(ident);
        throw r12;
    L17:
        e = move-exception;
        e = e;
    L15:
        th = move-exception;
        r12 = th;
    L26:
        Binder.restoreCallingIdentity(ident);
    }

    void grantClipDataItemPermission(ClipData.Item item, int mode, int srcUid, int destUid, String destPkg) {
        if (item.getUri() == null) goto L5;
        int mode2 = mode;
        int srcUid2 = srcUid;
        int destUid2 = destUid;
        String destPkg2 = destPkg;
        grantUriPermission(item.getUri(), mode2, srcUid2, destUid2, destPkg2);
    L6:
        Intent intent = item.getIntent();
        if (intent != null) goto L9;
        return;
    L9:
        if (intent.getData() == null) goto L13;
        String destPkg3 = destPkg2;
        int srcUid3 = srcUid2;
        int destUid3 = destUid2;
        grantUriPermission(intent.getData(), mode2, srcUid3, destUid3, destPkg3);
        return;
    L13:
        return;
    L5:
        mode2 = mode;
        srcUid2 = srcUid;
        destUid2 = destUid;
        destPkg2 = destPkg;
        goto L6
    }

    void grantClipDataPermissions(ClipData data, int mode, int srcUid, int destUid, String destPkg) {
        int N = data.getItemCount();
        int i = 0;
    L3:
        if (i >= N) goto L6;
        grantClipDataItemPermission(data.getItemAt(i), mode, srcUid, destUid, destPkg);
        i = i + 1;
        goto L3
    }

    public boolean hideLocked() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[AI KEY] hideLocked enter mBound=");
        r0.append(this.mBound);
        r0.append(" mShown=");
        r0.append(this.mShown);
        r0.append(" mSessionNull=");
        if (this.mSession != null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(" pendingShowArgs_type=");
        if (this.mShowArgs == null) goto L9;
        int r2 = this.mShowArgs.getInt("invocation_type", -999);
    L10:
        r0.append(r2);
        Slog.d(TAG, r0.toString());
        if (this.mBound == true) goto L13;
        return false;
    L13:
        if (this.mShown == false) goto L32;
        this.mShown = false;
        this.mShowArgs = null;
        this.mShowFlags = 0;
        this.mAssistDataRequester.cancel();
        this.mPendingShowCallbacks.clear();
        if (this.mSession != null) goto L36;
    L19:
        this.mUgmInternal.revokeUriPermissionFromOwner(this.mPermissionOwner, null, 3, this.mUser);
        if (this.mSession == null) goto L25;
        ActivityTaskManager.getService().finishVoiceTask(this.mSession);     // Catch: RemoteException -> L23
    L25:
        if (this.mSetPowerBoostRunnable == null) goto L27;
        this.mSetPowerBoostRunnable.cancel();
        this.mSetPowerBoostRunnable = null;
    L27:
        this.mPowerManagerInternal.setPowerBoost(0, -1);
        if (this.mLowPowerStandbyControllerInternal == null) goto L30;
        removeFromLowPowerStandbyAllowlist();
    L30:
        this.mCallback.onSessionHidden(this);
        goto L32
    L36:
        this.mSession.hide();     // Catch: RemoteException -> L18
    L32:
        if (this.mFullyBound == false) goto L34;
        this.mContext.unbindService(this.mFullConnection);
        this.mFullyBound = false;
    L34:
        return true;
    L9:
        r2 = -888;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public void cancelLocked(boolean finishTask) {
        Slog.d(TAG, "[AI KEY] cancelLocked enter finishTask=" + finishTask + " mBound=" + this.mBound + " mShown=" + this.mShown);
        this.mListeningVisibleActivity = false;
        this.mVisibleActivityInfoForToken.clear();
        hideLocked();
        this.mCanceled = true;
        if (this.mBound == false) goto L23;
        if (this.mSession != null) goto L30;
    L10:
        if (finishTask == true) goto L12;
    L16:
        this.mContext.unbindService(this);
        this.mIWindowManager.removeWindowToken(this.mToken, 0);     // Catch: RemoteException -> L19
    L21:
        this.mBound = false;
        this.mService = null;
        this.mSession = null;
        this.mInteractor = null;
    L19:
        e = move-exception;
        Slog.w(TAG, "Failed removing window token", e);
        goto L21
    L12:
        if (this.mSession == null) goto L16;
        ActivityTaskManager.getService().finishVoiceTask(this.mSession);     // Catch: RemoteException -> L15
        goto L16
    L30:
        this.mSession.destroy();     // Catch: RemoteException -> L8
    L9:
        Slog.w(TAG, "Voice interation session already dead");
    L23:
        if (this.mFullyBound == false) goto L32;
        this.mContext.unbindService(this.mFullConnection);
        this.mFullyBound = false;
        return;
    }

    public boolean deliverNewSessionLocked(IVoiceInteractionSession session, IVoiceInteractor interactor) {
        this.mSession = session;
        this.mInteractor = interactor;
        StringBuilder r0 = new StringBuilder();
        r0.append("[AI KEY] deliverNewSessionLocked mShown=");
        r0.append(this.mShown);
        r0.append(" replayShowArgs_type=");
        if (this.mShowArgs == null) goto L5;
        int r1 = this.mShowArgs.getInt("invocation_type", -999);
    L6:
        r0.append(r1);
        r0.append(" (this is the show that will actually be replayed to client onShow)");
        Slog.d(TAG, r0.toString());
        if (this.mShown == false) goto L18;
        session.show(this.mShowArgs, this.mShowFlags, this.mShowCallback);     // Catch: RemoteException -> L10
        this.mShowArgs = null;     // Catch: RemoteException -> L10
        this.mShowFlags = 0;     // Catch: RemoteException -> L10
    L11:
        this.mAssistDataRequester.processPendingAssistData();
        if (this.mPendingHandleAssistWithoutData.isEmpty() == true) goto L19;
        doHandleAssistWithoutData(this.mPendingHandleAssistWithoutData);
        this.mPendingHandleAssistWithoutData.clear();
        return true;
    L19:
        return true;
    L18:
        return true;
    L5:
        r1 = -888;
        goto L6
    }

    private void notifyPendingShowCallbacksShownLocked() {
        int i = 0;
    L4:
        if (i >= this.mPendingShowCallbacks.size()) goto L9;
        this.mPendingShowCallbacks.get(i).onShown();     // Catch: RemoteException -> L7
    L8:
        i = i + 1;
        goto L4
    L9:
        this.mPendingShowCallbacks.clear();
    }

    private void notifyPendingShowCallbacksFailedLocked() {
        int i = 0;
    L4:
        if (i >= this.mPendingShowCallbacks.size()) goto L9;
        this.mPendingShowCallbacks.get(i).onFailed();     // Catch: RemoteException -> L7
    L8:
        i = i + 1;
        goto L4
    L9:
        this.mPendingShowCallbacks.clear();
    }

    void startListeningVisibleActivityChangedLocked() {
        if (this.mShown == true) goto L5;
        return;
    L5:
        if (this.mCanceled == false) goto L7;
        return;
    L7:
        if (this.mSession == null) goto L20;
        this.mListeningVisibleActivity = true;
        this.mVisibleActivityInfoForToken.clear();
        ArrayMap<IBinder, VisibleActivityInfo> newVisibleActivityInfos = getTopVisibleActivityInfosLocked();
        if (newVisibleActivityInfos != null) goto L12;
        return;
    L12:
        if (newVisibleActivityInfos.isEmpty() == true) goto L18;
        notifyVisibleActivitiesChangedLocked(newVisibleActivityInfos, 1);
        this.mVisibleActivityInfoForToken.putAll(newVisibleActivityInfos);
        return;
    L18:
        return;
    }

    void stopListeningVisibleActivityChangedLocked() {
        this.mListeningVisibleActivity = false;
        this.mVisibleActivityInfoForToken.clear();
    }

    void notifyActivityEventChangedLocked(final IBinder activityToken, final int type) {
        if (this.mListeningVisibleActivity == true) goto L5;
        return;
    L5:
        this.mScheduledExecutorService.execute(new VoiceInteractionSessionConnection$$ExternalSyntheticLambda0(this, activityToken, type));
    }

    private /* synthetic */ void lambda$notifyActivityEventChangedLocked$0(IBinder activityToken, int type) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        handleVisibleActivitiesLocked(activityToken, type);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private ArrayMap<IBinder, VisibleActivityInfo> getTopVisibleActivityInfosLocked() {
        List<ActivityAssistInfo> allVisibleActivities = ((ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class)).getTopVisibleActivities();
        if (allVisibleActivities.isEmpty() == false) goto L6;
        Slog.w(TAG, "no visible activity");
        return null;
    L6:
        int count = allVisibleActivities.size();
        ArrayMap<IBinder, VisibleActivityInfo> visibleActivityInfoArrayMap = new ArrayMap(count);
        int i = 0;
    L7:
        if (i >= count) goto L10;
        ActivityAssistInfo info = allVisibleActivities.get(i);
        visibleActivityInfoArrayMap.put(info.getActivityToken(), new VisibleActivityInfo(info.getTaskId(), info.getAssistToken()));
        i = i + 1;
        goto L7
    L10:
        return visibleActivityInfoArrayMap;
    }

    private void handleVisibleActivitiesLocked(IBinder activityToken, int type) {
        if (this.mListeningVisibleActivity == true) goto L6;
        return;
    L6:
        if (this.mShown == true) goto L8;
        return;
    L8:
        if (this.mCanceled == false) goto L10;
        return;
    L10:
        if (this.mSession == null) goto L54;
        boolean notifyOnVisible = false;
        int r2 = 2;
        if (type == 1) goto L32;
        if (type == 2) goto L32;
        if (type != 3) goto L25;
        if (getVisibleActivityInfoFromTopVisibleActivity(activityToken) == null) goto L21;
        return;
    L21:
        VisibleActivityInfo notifyVisibleActivityInfo = this.mVisibleActivityInfoForToken.get(activityToken);
        if (notifyVisibleActivityInfo != null) goto L50;
        return;
    L50:
        IVoiceInteractionSession r4 = this.mSession;     // Catch: RemoteException -> L44
        if (notifyOnVisible == false) goto L42;
        r2 = 1;
    L42:
        r4.notifyVisibleActivityInfoChanged(notifyVisibleActivityInfo, r2);     // Catch: RemoteException -> L44
    L45:
        if (notifyOnVisible == false) goto L47;
        this.mVisibleActivityInfoForToken.put(activityToken, notifyVisibleActivityInfo);
        return;
    L47:
        this.mVisibleActivityInfoForToken.remove(activityToken);
        return;
    L25:
        if (type != 4) goto L29;
        notifyVisibleActivityInfo = this.mVisibleActivityInfoForToken.get(activityToken);
        if (notifyVisibleActivityInfo != null) goto L50;
        return;
    L29:
        Slog.w(TAG, "notifyActivityEventChangedLocked unexpected type=" + type);
        return;
    L32:
        if (this.mVisibleActivityInfoForToken.containsKey(activityToken) == false) goto L34;
        return;
    L34:
        notifyVisibleActivityInfo = getVisibleActivityInfoFromTopVisibleActivity(activityToken);
        if (notifyVisibleActivityInfo != null) goto L37;
        return;
    L37:
        notifyOnVisible = true;
        goto L50
    }

    private void notifyVisibleActivitiesChangedLocked(ArrayMap<IBinder, VisibleActivityInfo> visibleActivityInfos, int type) {
        if (visibleActivityInfos != null) goto L4;
        return;
    L4:
        if (visibleActivityInfos.isEmpty() == false) goto L7;
        return;
    L7:
        if (this.mSession != null) goto L9;
        return;
    L9:
        int i = 0;
    L19:
        if (i >= visibleActivityInfos.size()) goto L22;
        this.mSession.notifyVisibleActivityInfoChanged(visibleActivityInfos.valueAt(i), type);     // Catch: RemoteException -> L14
        i = i + 1;
        goto L19
    L22:
        return;
    }

    private VisibleActivityInfo getVisibleActivityInfoFromTopVisibleActivity(IBinder activityToken) {
        ArrayMap<IBinder, VisibleActivityInfo> visibleActivityInfos = getTopVisibleActivityInfosLocked();
        if (visibleActivityInfos != null) goto L7;
        return null;
    L7:
        return visibleActivityInfos.get(activityToken);
    }

    void notifyActivityDestroyedLocked(final IBinder activityToken) {
        if (this.mListeningVisibleActivity == true) goto L5;
        return;
    L5:
        this.mScheduledExecutorService.execute(new VoiceInteractionSessionConnection$$ExternalSyntheticLambda2(this, activityToken));
    }

    private /* synthetic */ void lambda$notifyActivityDestroyedLocked$1(IBinder activityToken) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mListeningVisibleActivity == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mShown == false) goto L24;
        if (this.mCanceled == true) goto L24;
        if (this.mSession == null) goto L24;
        VisibleActivityInfo visibleActivityInfo = this.mVisibleActivityInfoForToken.remove(activityToken);     // Catch: Throwable -> L8
        if (visibleActivityInfo != null) goto L28;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L28:
        this.mSession.notifyVisibleActivityInfoChanged(visibleActivityInfo, 2);     // Catch: Throwable -> L8 RemoteException -> L21
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void removeFromLowPowerStandbyAllowlist() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mLowPowerStandbyAllowlisted == false) goto L9;
        this.mFgHandler.removeCallbacks(this.mRemoveFromLowPowerStandbyAllowlistRunnable);     // Catch: Throwable -> L7
        this.mLowPowerStandbyControllerInternal.removeFromAllowlist(this.mCallingUid, 1);     // Catch: Throwable -> L7
        this.mLowPowerStandbyAllowlisted = false;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mService = IVoiceInteractionSessionService.Stub.asInterface(service);     // Catch: Throwable -> L8
        if (this.mCanceled == false) goto L18;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L18:
        this.mService.newSession(this.mToken, this.mShowArgs, this.mShowFlags);     // Catch: Throwable -> L8 RemoteException -> L10
    L10:
        e = move-exception;
        Slog.w(TAG, "Failed adding window token", e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        this.mCallback.sessionConnectionGone(this);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mService = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void dump(String prefix, PrintWriter pw) {
        pw.print(prefix);
        pw.print("mToken=");
        pw.println(this.mToken);
        pw.print(prefix);
        pw.print("mShown=");
        pw.println(this.mShown);
        pw.print(prefix);
        pw.print("mShowArgs=");
        pw.println(this.mShowArgs);
        pw.print(prefix);
        pw.print("mShowFlags=0x");
        pw.println(Integer.toHexString(this.mShowFlags));
        pw.print(prefix);
        pw.print("mBound=");
        pw.println(this.mBound);
        if (this.mBound == false) goto L5;
        pw.print(prefix);
        pw.print("mService=");
        pw.println(this.mService);
        pw.print(prefix);
        pw.print("mSession=");
        pw.println(this.mSession);
        pw.print(prefix);
        pw.print("mInteractor=");
        pw.println(this.mInteractor);
    L5:
        this.mAssistDataRequester.dump(prefix, pw);
    }

    public IObricVoiceInteractionSessionConnection getObricExt() {
        return this.mObricExt;
    }
}
