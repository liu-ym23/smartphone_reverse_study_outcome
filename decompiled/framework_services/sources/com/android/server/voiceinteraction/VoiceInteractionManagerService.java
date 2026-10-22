package com.android.server.voiceinteraction;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.ActivityOptions;
import android.app.AppGlobals;
import android.app.admin.DevicePolicyManagerInternal;
import android.app.role.OnRoleHoldersChangedListener;
import android.app.role.RoleManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.ShortcutServiceInternal;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.hardware.soundtrigger.IRecognitionStatusCallback;
import android.hardware.soundtrigger.KeyphraseMetadata;
import android.hardware.soundtrigger.SoundTrigger;
import android.media.AudioFormat;
import android.media.permission.Identity;
import android.media.permission.PermissionUtil;
import android.media.permission.SafeCloseable;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.os.RemoteCallback;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SharedMemory;
import android.os.ShellCallback;
import android.os.UserHandle;
import android.provider.Settings;
import android.service.voice.IMicrophoneHotwordDetectionVoiceInteractionCallback;
import android.service.voice.IVisualQueryDetectionVoiceInteractionCallback;
import android.service.voice.IVoiceInteractionSession;
import android.service.voice.VoiceInteractionManagerInternal;
import android.service.voice.VoiceInteractionServiceInfo;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.Slog;
import android.window.ScreenCapture;
import com.android.internal.app.IHotwordRecognitionStatusCallback;
import com.android.internal.app.IVisualQueryDetectionAttentionListener;
import com.android.internal.app.IVisualQueryRecognitionStatusListener;
import com.android.internal.app.IVoiceActionCheckCallback;
import com.android.internal.app.IVoiceInteractionAccessibilitySettingsListener;
import com.android.internal.app.IVoiceInteractionManagerService;
import com.android.internal.app.IVoiceInteractionSessionListener;
import com.android.internal.app.IVoiceInteractionSessionShowCallback;
import com.android.internal.app.IVoiceInteractionSoundTriggerSession;
import com.android.internal.app.IVoiceInteractor;
import com.android.internal.content.PackageMonitor;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.DumpUtils;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.SoundTriggerInternal;
import com.android.server.SystemService;
import com.android.server.UiThread;
import com.android.server.pm.UserManagerInternal;
import com.android.server.pm.permission.LegacyPermissionManagerInternal;
import com.android.server.policy.AppOpsPolicy;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.utils.Slogf;
import com.android.server.utils.TimingsTraceAndSlog;
import com.android.server.wm.ActivityAssistInfo;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.WindowManagerInternal;
import com.obric.utils.ObricImplFactory;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class VoiceInteractionManagerService extends SystemService {
    private static final String CS_INTENT_FILTER = "com.android.contextualsearch.LAUNCH";
    private static final String CS_KEY_FLAG_IS_MANAGED_PROFILE_VISIBLE = "com.android.contextualsearch.is_managed_profile_visible";
    private static final String CS_KEY_FLAG_SCREENSHOT = "com.android.contextualsearch.screenshot";
    private static final String CS_KEY_FLAG_SECURE_FOUND = "com.android.contextualsearch.flag_secure_found";
    private static final String CS_KEY_FLAG_VISIBLE_PACKAGE_NAMES = "com.android.contextualsearch.visible_package_names";
    static final boolean DEBUG = false;
    static final String TAG = "VoiceInteractionManager";
    final ActivityManagerInternal mAmInternal;
    final ActivityTaskManagerInternal mAtmInternal;
    final Context mContext;
    private IEnrolledModelDb mDbHelper;
    final DevicePolicyManagerInternal mDpmInternal;
    private final IVoiceInteractionSessionListener mLatencyLoggingListener;
    final ArrayMap<Integer, VoiceInteractionManagerServiceStub.SoundTriggerSession> mLoadedKeyphraseIds;
    private IObricVoiceInteractionManagerService mObricExt;
    private final IEnrolledModelDb mRealDbHelper;
    final ContentResolver mResolver;
    private final VoiceInteractionManagerServiceStub mServiceStub;
    ShortcutServiceInternal mShortcutServiceInternal;
    SoundTriggerInternal mSoundTriggerInternal;
    final UserManagerInternal mUserManagerInternal;
    private IVoiceInteractionManagerServiceExt mVIMSExt;
    private IVisualQueryRecognitionStatusListener mVisualQueryRecognitionStatusListener;
    private final RemoteCallbackList<IVoiceInteractionSessionListener> mVoiceInteractionSessionListeners;
    final WindowManagerInternal mWmInternal;

    class LocalService extends VoiceInteractionManagerInternal {
        final /* synthetic */ VoiceInteractionManagerService this$0;

        LocalService(VoiceInteractionManagerService this$0) {
            this.this$0 = this$0;
        }

        public void startLocalVoiceInteraction(IBinder callingActivity, String attributionTag, Bundle options) {
            VoiceInteractionManagerService.m9412$$Nest$fgetmServiceStub(this.this$0).startLocalVoiceInteraction(callingActivity, attributionTag, options);
        }

        public boolean supportsLocalVoiceInteraction() {
            return VoiceInteractionManagerService.m9412$$Nest$fgetmServiceStub(this.this$0).supportsLocalVoiceInteraction();
        }

        public void stopLocalVoiceInteraction(IBinder callingActivity) {
            VoiceInteractionManagerService.m9412$$Nest$fgetmServiceStub(this.this$0).stopLocalVoiceInteraction(callingActivity);
        }

        public boolean hasActiveSession(String packageName) {
            VoiceInteractionManagerServiceImpl impl = VoiceInteractionManagerService.m9412$$Nest$fgetmServiceStub(this.this$0).mImpl;
            if (impl != null) goto L5;
            return false;
        L5:
            VoiceInteractionSessionConnection session = impl.mActiveSession;
            if (session != null) goto L9;
            return false;
        L9:
            return TextUtils.equals(packageName, session.mSessionComponentName.getPackageName());
        }

        public String getVoiceInteractorPackageName(IBinder callingVoiceInteractor) {
            VoiceInteractionManagerServiceImpl impl = VoiceInteractionManagerService.m9412$$Nest$fgetmServiceStub(this.this$0).mImpl;
            if (impl != null) goto L5;
            return null;
        L5:
            VoiceInteractionSessionConnection session = impl.mActiveSession;
            if (session != null) goto L8;
            return null;
        L8:
            IVoiceInteractor voiceInteractor = session.mInteractor;
            if (voiceInteractor != null) goto L11;
        L15:
            return null;
        L11:
            if (voiceInteractor.asBinder() != callingVoiceInteractor) goto L15;
            return session.mSessionComponentName.getPackageName();
        }

        public VoiceInteractionManagerInternal.HotwordDetectionServiceIdentity getHotwordDetectionServiceIdentity() {
            VoiceInteractionManagerServiceImpl impl = VoiceInteractionManagerService.m9412$$Nest$fgetmServiceStub(this.this$0).mImpl;
            if (impl != null) goto L5;
            return null;
        L5:
            HotwordDetectionConnection hotwordDetectionConnection = impl.mHotwordDetectionConnection;
            if (hotwordDetectionConnection != null) goto L9;
            return null;
        L9:
            return hotwordDetectionConnection.mIdentity;
        }

        public void onPreCreatedUserConversion(int userId) {
            Slogf.d(VoiceInteractionManagerService.TAG, "onPreCreatedUserConversion(%d): calling onRoleHoldersChanged() again", new Object[]{Integer.valueOf(userId)});
            VoiceInteractionManagerServiceStub.m9424$$Nest$fgetmRoleObserver(VoiceInteractionManagerService.m9412$$Nest$fgetmServiceStub(this.this$0)).onRoleHoldersChanged("android.app.role.ASSISTANT", UserHandle.of(userId));
        }

        public void startListeningFromWearable(ParcelFileDescriptor audioStreamFromWearable, AudioFormat audioFormatFromWearable, PersistableBundle options, ComponentName targetVisComponentName, int userId, VoiceInteractionManagerInternal.WearableHotwordDetectionCallback callback) {
            Slog.d(VoiceInteractionManagerService.TAG, "#startListeningFromWearable");
            VoiceInteractionManagerServiceImpl impl = VoiceInteractionManagerService.m9412$$Nest$fgetmServiceStub(this.this$0).mImpl;
            if (impl != null) goto L6;
            callback.onError("Unable to start listening from wearable because the service impl is null.");
            return;
        L6:
            if (targetVisComponentName == null) goto L12;
            if (targetVisComponentName.equals(impl.mComponent) == true) goto L12;
            callback.onError(TextUtils.formatSimple("Unable to start listening from wearable because the target VoiceInteractionService %s is different from the current VoiceInteractionService %s", new Object[]{targetVisComponentName, impl.mComponent}));
            return;
        L12:
            if (userId == impl.mUser) goto L15;
            callback.onError(TextUtils.formatSimple("Unable to start listening from wearable because the target userId %s is different from the current VoiceInteractionManagerServiceImpl's userId %s", new Object[]{Integer.valueOf(userId), Integer.valueOf(impl.mUser)}));
            return;
        L15:
            VoiceInteractionManagerServiceStub r1 = VoiceInteractionManagerService.m9412$$Nest$fgetmServiceStub(this.this$0);
            monitor-enter(r1);
            impl.startListeningFromWearableLocked(audioStreamFromWearable, audioFormatFromWearable, options, callback);     // Catch: Throwable -> L20
            monitor-exit(r1);     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            throw th;
        }
    }

    class VoiceInteractionManagerServiceStub extends IVoiceInteractionManagerService.Stub {
        private static final int SHOW_SESSION_START_ID = 0;
        private final boolean IS_HDS_REQUIRED;
        private int mCurUser;
        private boolean mCurUserSupported;
        private final boolean mEnableService;
        volatile VoiceInteractionManagerServiceImpl mImpl;
        PackageMonitor mPackageMonitor;
        private final RoleObserver mRoleObserver;
        private boolean mSafeMode;
        private int mShowSessionId;
        private boolean mTemporarilyDisabled;
        final /* synthetic */ VoiceInteractionManagerService this$0;

        class RoleObserver implements OnRoleHoldersChangedListener {
            private PackageManager mPm;
            private RoleManager mRm;
            final /* synthetic */ VoiceInteractionManagerServiceStub this$1;

            RoleObserver(VoiceInteractionManagerServiceStub this$1, Executor executor) {
                this.this$1 = this$1;
                this.mPm = this.this$1.this$0.mContext.getPackageManager();
                this.mRm = (RoleManager) this.this$1.this$0.mContext.getSystemService(RoleManager.class);
                this.mRm.addOnRoleHoldersChangedListenerAsUser(executor, this, UserHandle.ALL);
                if (this.mRm.isRoleAvailable("android.app.role.ASSISTANT") == false) goto L6;
                UserHandle currentUser = UserHandle.of(((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).getCurrentUserId());
                onRoleHoldersChanged("android.app.role.ASSISTANT", currentUser);
                return;
            }

            public void onRoleHoldersChanged(String roleName, UserHandle user) {
                if (roleName.equals("android.app.role.ASSISTANT") == true) goto L5;
                return;
            L5:
                List<String> roleHolders = this.mRm.getRoleHoldersAsUser(roleName, user);
                if (roleHolders.isEmpty() == false) goto L13;
                UserInfo userInfo = this.this$1.this$0.mUserManagerInternal.getUserInfo(user.getIdentifier());
                if (userInfo == null) goto L13;
                if (userInfo.preCreated == false) goto L13;
                Slogf.d(VoiceInteractionManagerService.TAG, "onRoleHoldersChanged(): ignoring pre-created user %s for now, this method will be called again when it's converted to a real user", new Object[]{userInfo.toFullString()});
                return;
            L13:
                int userId = user.getIdentifier();
                if (roleHolders.isEmpty() == false) goto L16;
                Settings.Secure.putStringForUser(this.this$1.this$0.getContext().getContentResolver(), "assistant", "", userId);
                Settings.Secure.putStringForUser(this.this$1.this$0.getContext().getContentResolver(), "voice_interaction_service", "", userId);
                return;
            L16:
                String pkg = roleHolders.get(0);
                Iterator r7 = VoiceInteractionManagerServiceStub.m9428$$Nest$mqueryInteractorServices(this.this$1, userId, pkg).iterator();
            L18:
                if (r7.hasNext() == false) goto L27;
                ResolveInfo resolveInfo = (ResolveInfo) r7.next();
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                VoiceInteractionServiceInfo voiceInteractionServiceInfo = new VoiceInteractionServiceInfo(this.mPm, serviceInfo);
                if (voiceInteractionServiceInfo.getSupportsAssist() == false) goto L18;
                String serviceComponentName = serviceInfo.getComponentName().flattenToShortString();
                if (voiceInteractionServiceInfo.getRecognitionService() != null) goto L25;
                Slog.e(VoiceInteractionManagerService.TAG, "The RecognitionService must be set to avoid boot loop on earlier platform version. Also make sure that this is a valid RecognitionService when running on Android 11 or earlier.");
                serviceComponentName = "";
            L25:
                Settings.Secure.putStringForUser(this.this$1.this$0.getContext().getContentResolver(), "assistant", serviceComponentName, userId);
                Settings.Secure.putStringForUser(this.this$1.this$0.getContext().getContentResolver(), "voice_interaction_service", serviceComponentName, userId);
                return;
            L27:
                List<ResolveInfo> activities = this.mPm.queryIntentActivitiesAsUser(new Intent("android.intent.action.ASSIST").setPackage(pkg), 851968, userId);
                Iterator<ResolveInfo> r8 = activities.iterator();
                if (r8.hasNext() == false) goto L35;
                ResolveInfo resolveInfo2 = r8.next();
                ActivityInfo activityInfo = resolveInfo2.activityInfo;
                Settings.Secure.putStringForUser(this.this$1.this$0.getContext().getContentResolver(), "assistant", activityInfo.getComponentName().flattenToShortString(), userId);
                Settings.Secure.putStringForUser(this.this$1.this$0.getContext().getContentResolver(), "voice_interaction_service", "", userId);
                return;
            }
        }

        class SettingsObserver extends ContentObserver {
            final /* synthetic */ VoiceInteractionManagerServiceStub this$1;

            SettingsObserver(VoiceInteractionManagerServiceStub this$1, Handler handler) {
                this.this$1 = this$1;
                super(handler);
                ContentResolver resolver = this$1.this$0.mContext.getContentResolver();
                resolver.registerContentObserver(Settings.Secure.getUriFor("voice_interaction_service"), false, this, -1);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                VoiceInteractionManagerServiceStub r0 = this.this$1;
                monitor-enter(r0);
                this.this$1.switchImplementationIfNeededLocked(false);     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }
        }

        private class SoundTriggerSession extends IVoiceInteractionSoundTriggerSession.Stub {
            final SoundTriggerInternal.Session mSession;
            private IHotwordRecognitionStatusCallback mSessionExternalCallback;
            private IRecognitionStatusCallback mSessionInternalCallback;
            private final Identity mVoiceInteractorIdentity;
            final /* synthetic */ VoiceInteractionManagerServiceStub this$1;

            /* JADX INFO: renamed from: -$$Nest$munloadKeyphraseModel, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m9432$$Nest$munloadKeyphraseModel(SoundTriggerSession r0, int r1) {
                return r0.unloadKeyphraseModel(r1);
            }

            SoundTriggerSession(VoiceInteractionManagerServiceStub r1, SoundTriggerInternal.Session session, Identity voiceInteractorIdentity) {
                this.this$1 = r1;
                this.mSession = session;
                this.mVoiceInteractorIdentity = voiceInteractorIdentity;
            }

            public SoundTrigger.ModuleProperties getDspModuleProperties() {
                VoiceInteractionManagerServiceStub r0 = this.this$1;
                monitor-enter(r0);
                VoiceInteractionManagerServiceStub.m9427$$Nest$menforceIsCurrentVoiceInteractionService(this.this$1);     // Catch: Throwable -> L9
                long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
                SoundTrigger.ModuleProperties r3 = this.mSession.getModuleProperties();     // Catch: Throwable -> L11
                Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
                monitor-exit(r0);     // Catch: Throwable -> L9
                return r3;
            L11:
                th = move-exception;
                Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
                throw th;     // Catch: Throwable -> L9
            L9:
                th = move-exception;
                throw th;
            }

            public int startRecognition(int keyphraseId, String bcp47Locale, IHotwordRecognitionStatusCallback callback, SoundTrigger.RecognitionConfig recognitionConfig, boolean runInBatterySaverMode) {
                VoiceInteractionManagerServiceStub r1 = this.this$1;
                monitor-enter(r1);
                VoiceInteractionManagerServiceStub.m9427$$Nest$menforceIsCurrentVoiceInteractionService(this.this$1);     // Catch: Throwable -> L57
                if (callback == null) goto L61;
                if (recognitionConfig == null) goto L61;
                if (bcp47Locale == null) goto L61;
                if (runInBatterySaverMode == true) goto L71;
            L13:
                monitor-exit(r1);     // Catch: Throwable -> L57
                int callingUserId = UserHandle.getCallingUserId();
                long caller = Binder.clearCallingIdentity();
                SoundTrigger.KeyphraseSoundModel soundModel = VoiceInteractionManagerService.m9410$$Nest$fgetmDbHelper(this.this$1.this$0).getKeyphraseSoundModel(keyphraseId, callingUserId, bcp47Locale);     // Catch: Throwable -> L42
                if (soundModel == null) goto L52;
                if (soundModel.getUuid() == null) goto L52;
                if (soundModel.getKeyphrases() == null) goto L52;
                VoiceInteractionManagerServiceStub r4 = this.this$1;     // Catch: Throwable -> L42
                monitor-enter(r4);     // Catch: Throwable -> L42
                this.this$1.this$0.mLoadedKeyphraseIds.put(Integer.valueOf(keyphraseId), this);     // Catch: Throwable -> L44
                if (this.mSessionExternalCallback != null) goto L75;
            L33:
                this.mSessionInternalCallback = VoiceInteractionManagerServiceStub.m9425$$Nest$mcreateSoundTriggerCallbackLocked(this.this$1, callback, this.mVoiceInteractorIdentity);     // Catch: Throwable -> L44
                this.mSessionExternalCallback = callback;     // Catch: Throwable -> L44
            L34:
                monitor-exit(r4);     // Catch: Throwable -> L44
                int keyphraseId2 = this.mSession.startRecognition(keyphraseId, soundModel, this.mSessionInternalCallback, recognitionConfig, runInBatterySaverMode);     // Catch: Throwable -> L40
                Binder.restoreCallingIdentity(caller);
                return keyphraseId2;
            L75:
            L31:
                th = th;
            L73:
                monitor-exit(r4);     // Catch: Throwable -> L48
                throw th;     // Catch: Throwable -> L40
            L48:
                th = th;
                goto L73
            L27:
                if (this.mSessionInternalCallback == null) goto L33;
                if (callback.asBinder() == this.mSessionExternalCallback.asBinder()) goto L34;
            L44:
                th = th;
            L52:
                Slog.w(VoiceInteractionManagerService.TAG, "No matching sound model found in startRecognition");     // Catch: Throwable -> L40
                Binder.restoreCallingIdentity(caller);
                return Integer.MIN_VALUE;
            L40:
                th = move-exception;
                Throwable r11 = th;
            L55:
                Binder.restoreCallingIdentity(caller);
                throw r11;
            L42:
                th = move-exception;
                r11 = th;
                goto L55
            L71:
                VoiceInteractionManagerServiceStub.m9426$$Nest$menforceCallingPermission(this.this$1, "android.permission.SOUND_TRIGGER_RUN_IN_BATTERY_SAVER");     // Catch: Throwable -> L11
            L11:
                th = th;
            L63:
                monitor-exit(r1);     // Catch: Throwable -> L62
                throw th;
            L61:
                throw new IllegalArgumentException("Illegal argument(s) in startRecognition");     // Catch: Throwable -> L62
            L62:
                th = th;
            L57:
                th = th;
                goto L63
            }

            public int stopRecognition(int keyphraseId, IHotwordRecognitionStatusCallback callback) {
                VoiceInteractionManagerServiceStub r0 = this.this$1;
                monitor-enter(r0);
                VoiceInteractionManagerServiceStub.m9427$$Nest$menforceIsCurrentVoiceInteractionService(this.this$1);     // Catch: Throwable -> L12
                if (this.mSessionExternalCallback != null) goto L7;
            L14:
                IRecognitionStatusCallback soundTriggerCallback = VoiceInteractionManagerServiceStub.m9425$$Nest$mcreateSoundTriggerCallbackLocked(this.this$1, callback, this.mVoiceInteractorIdentity);     // Catch: Throwable -> L12
                Slog.w(VoiceInteractionManagerService.TAG, "stopRecognition() called with a different callback thanstartRecognition()");     // Catch: Throwable -> L12
            L15:
                this.mSessionExternalCallback = null;     // Catch: Throwable -> L12
                this.mSessionInternalCallback = null;     // Catch: Throwable -> L12
                monitor-exit(r0);     // Catch: Throwable -> L12
                long caller = Binder.clearCallingIdentity();
                int r1 = this.mSession.stopRecognition(keyphraseId, soundTriggerCallback);     // Catch: Throwable -> L21
                Binder.restoreCallingIdentity(caller);
                return r1;
            L21:
                th = move-exception;
                Binder.restoreCallingIdentity(caller);
                throw th;
            L7:
                if (this.mSessionInternalCallback == null) goto L14;
                if (callback.asBinder() != this.mSessionExternalCallback.asBinder()) goto L14;
                soundTriggerCallback = this.mSessionInternalCallback;     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                throw th;
            }

            public int setParameter(int keyphraseId, int modelParam, int value) {
                VoiceInteractionManagerServiceStub r0 = this.this$1;
                monitor-enter(r0);
                VoiceInteractionManagerServiceStub.m9427$$Nest$menforceIsCurrentVoiceInteractionService(this.this$1);     // Catch: Throwable -> L13
                monitor-exit(r0);     // Catch: Throwable -> L13
                long caller = Binder.clearCallingIdentity();
                int r2 = this.mSession.setParameter(keyphraseId, modelParam, value);     // Catch: Throwable -> L10
                Binder.restoreCallingIdentity(caller);
                return r2;
            L10:
                th = move-exception;
                Binder.restoreCallingIdentity(caller);
                throw th;
            L13:
                th = move-exception;
                throw th;
            }

            public int getParameter(int keyphraseId, int modelParam) {
                VoiceInteractionManagerServiceStub r0 = this.this$1;
                monitor-enter(r0);
                VoiceInteractionManagerServiceStub.m9427$$Nest$menforceIsCurrentVoiceInteractionService(this.this$1);     // Catch: Throwable -> L13
                monitor-exit(r0);     // Catch: Throwable -> L13
                long caller = Binder.clearCallingIdentity();
                int r2 = this.mSession.getParameter(keyphraseId, modelParam);     // Catch: Throwable -> L10
                Binder.restoreCallingIdentity(caller);
                return r2;
            L10:
                th = move-exception;
                Binder.restoreCallingIdentity(caller);
                throw th;
            L13:
                th = move-exception;
                throw th;
            }

            public SoundTrigger.ModelParamRange queryParameter(int keyphraseId, int modelParam) {
                VoiceInteractionManagerServiceStub r0 = this.this$1;
                monitor-enter(r0);
                VoiceInteractionManagerServiceStub.m9427$$Nest$menforceIsCurrentVoiceInteractionService(this.this$1);     // Catch: Throwable -> L13
                monitor-exit(r0);     // Catch: Throwable -> L13
                long caller = Binder.clearCallingIdentity();
                SoundTrigger.ModelParamRange r2 = this.mSession.queryParameter(keyphraseId, modelParam);     // Catch: Throwable -> L10
                Binder.restoreCallingIdentity(caller);
                return r2;
            L10:
                th = move-exception;
                Binder.restoreCallingIdentity(caller);
                throw th;
            L13:
                th = move-exception;
                throw th;
            }

            public void detach() {
                this.mSession.detach();
            }

            private int unloadKeyphraseModel(int keyphraseId) {
                long caller = Binder.clearCallingIdentity();
                int r2 = this.mSession.unloadKeyphraseModel(keyphraseId);     // Catch: Throwable -> L6
                Binder.restoreCallingIdentity(caller);
                return r2;
            L6:
                th = move-exception;
                Binder.restoreCallingIdentity(caller);
                throw th;
            }
        }

        public static /* synthetic */ void $r8$lambda$2WTCWNnGSILXgbpLlmmnNRqrm6s(VoiceInteractionManagerServiceStub r0, TestModelEnrollmentDatabase r1) {
            r0.lambda$setModelDatabaseForTestEnabled$6(r1);
        }

        public static /* synthetic */ void $r8$lambda$GfRqqSVzelo_PyKdpAYYSfxjXpQ(VoiceInteractionManagerServiceStub r0, PersistableBundle r1, SharedMemory r2, IBinder r3) {
            r0.lambda$updateState$3(r1, r2, r3);
        }

        /* JADX INFO: renamed from: $r8$lambda$Jw_CP7-yo1wVcgGwkdowhEr7q8Q, reason: not valid java name */
        public static /* synthetic */ void m9419$r8$lambda$Jw_CP7yo1wVcgGwkdowhEr7q8Q(VoiceInteractionManagerServiceStub r0, Identity r1, PersistableBundle r2, SharedMemory r3, IBinder r4, IHotwordRecognitionStatusCallback r5, int r6) {
            r0.lambda$initAndVerifyDetector$4(r1, r2, r3, r4, r5, r6);
        }

        public static /* synthetic */ void $r8$lambda$XoLzhNmPoTCUWdDDv6z9DlJ6LDg(boolean r0, IVoiceInteractionSessionListener r1) {
            lambda$setSessionWindowVisible$7(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$Zyo9fdPDMlokL6qbAHBULoBwrz8(VoiceInteractionManagerServiceStub r0, int r1) {
            r0.lambda$switchUser$1(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$_IDl3GJfOJFdPFBYAq26hf1-3Js, reason: not valid java name */
        public static /* synthetic */ void m9420$r8$lambda$_IDl3GJfOJFdPFBYAq26hf13Js(VoiceInteractionManagerServiceStub r0, IBinder r1) {
            r0.lambda$destroyDetector$5(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$bKtCa3woMDysaznnJUO0Ht-F78U, reason: not valid java name */
        public static /* synthetic */ void m9421$r8$lambda$bKtCa3woMDysaznnJUO0HtF78U(VoiceInteractionManagerServiceStub r0, IBinder r1) {
            r0.lambda$notifyActivityDestroyed$0(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$neI-3po18jGAyl3AE1N3pXNPLbI, reason: not valid java name */
        public static /* synthetic */ void m9422$r8$lambda$neI3po18jGAyl3AE1N3pXNPLbI(VoiceInteractionManagerServiceStub r0, IBinder r1, int r2) {
            r0.lambda$notifyActivityEventChanged$2(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCurUser, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9423$$Nest$fgetmCurUser(VoiceInteractionManagerServiceStub r0) {
            return r0.mCurUser;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRoleObserver, reason: not valid java name */
        static /* bridge */ /* synthetic */ RoleObserver m9424$$Nest$fgetmRoleObserver(VoiceInteractionManagerServiceStub r0) {
            return r0.mRoleObserver;
        }

        /* JADX INFO: renamed from: -$$Nest$mcreateSoundTriggerCallbackLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ IRecognitionStatusCallback m9425$$Nest$mcreateSoundTriggerCallbackLocked(VoiceInteractionManagerServiceStub r0, IHotwordRecognitionStatusCallback r1, Identity r2) {
            return r0.createSoundTriggerCallbackLocked(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$menforceCallingPermission, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9426$$Nest$menforceCallingPermission(VoiceInteractionManagerServiceStub r0, String r1) {
            r0.enforceCallingPermission(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$menforceIsCurrentVoiceInteractionService, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9427$$Nest$menforceIsCurrentVoiceInteractionService(VoiceInteractionManagerServiceStub r0) {
            r0.enforceIsCurrentVoiceInteractionService();
        }

        /* JADX INFO: renamed from: -$$Nest$mqueryInteractorServices, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m9428$$Nest$mqueryInteractorServices(VoiceInteractionManagerServiceStub r0, int r1, String r2) {
            return r0.queryInteractorServices(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mresetServicesIfNoRecognitionService, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9429$$Nest$mresetServicesIfNoRecognitionService(VoiceInteractionManagerServiceStub r0, ComponentName r1, int r2) {
            r0.resetServicesIfNoRecognitionService(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$msetImplLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9430$$Nest$msetImplLocked(VoiceInteractionManagerServiceStub r0, VoiceInteractionManagerServiceImpl r1) {
            r0.setImplLocked(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$munloadAllKeyphraseModels, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9431$$Nest$munloadAllKeyphraseModels(VoiceInteractionManagerServiceStub r0) {
            r0.unloadAllKeyphraseModels();
        }

        VoiceInteractionManagerServiceStub(VoiceInteractionManagerService this$0) {
            this.this$0 = this$0;
            this.IS_HDS_REQUIRED = AppOpsPolicy.isHotwordDetectionServiceRequired(this.this$0.mContext.getPackageManager());
            this.mShowSessionId = 0;
            final boolean r1 = true;
            this.mPackageMonitor = new AnonymousClass2(this, r1);
            this.mEnableService = shouldEnableService(this$0.mContext);
            this.mRoleObserver = new RoleObserver(this, this$0.mContext.getMainExecutor());
        }

        void handleUserStop(String packageName, int userHandle) {
            monitor-enter(this);
            ComponentName curInteractor = getCurInteractor(userHandle);     // Catch: Throwable -> L8
            if (curInteractor != null) goto L6;
        L10:
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L6:
            if (packageName.equals(curInteractor.getPackageName()) == false) goto L10;
            Slog.d(VoiceInteractionManagerService.TAG, "switchImplementation for user stop.");     // Catch: Throwable -> L8
            switchImplementationIfNeededLocked(true);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        int getNextShowSessionId() {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (this.mShowSessionId != 2147483646) goto L8;
            this.mShowSessionId = 0;     // Catch: Throwable -> L6
        L8:
            this.mShowSessionId++;     // Catch: Throwable -> L6
            int r0 = this.mShowSessionId;     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return r0;
        }

        int getShowSessionId() {
            monitor-enter(this);
            int r0 = this.mShowSessionId;     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public IVoiceInteractionSoundTriggerSession createSoundTriggerSessionAsOriginator(Identity originatorIdentity, IBinder client, SoundTrigger.ModuleProperties moduleProperties) {
            originatorIdentity.getClass();
            monitor-enter(this);
            enforceIsCurrentVoiceInteractionService();     // Catch: Throwable -> L9
            if (this.mImpl != null) goto L7;
        L11:
            boolean r1 = false;
        L12:
            boolean forHotwordDetectionService = r1;
            monitor-exit(this);     // Catch: Throwable -> L9
            SafeCloseable ignored = PermissionUtil.establishIdentityDirect(originatorIdentity);
        L22:
            th = move-exception;
            if (ignored != null) goto L35;
        L28:
            throw th;
        L35:
            ignored.close();     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            th.addSuppressed(th);
            goto L28
        L16:
            if (this.IS_HDS_REQUIRED == true) goto L18;
            forHotwordDetectionService = true;
        L18:
            SoundTriggerSession r2 = new SoundTriggerSession(this, this.this$0.mSoundTriggerInternal.attach(client, moduleProperties, forHotwordDetectionService), originatorIdentity);     // Catch: Throwable -> L22
            if (ignored == null) goto L21;
            ignored.close();
        L21:
            return r2;
        L7:
            if (this.mImpl.mHotwordDetectionConnection == null) goto L11;
            r1 = true;
        L9:
            th = move-exception;
            throw th;
        }

        public List<SoundTrigger.ModuleProperties> listModuleProperties(Identity originatorIdentity) {
            monitor-enter(this);
            enforceIsCurrentVoiceInteractionService();     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return this.this$0.mSoundTriggerInternal.listModuleProperties(originatorIdentity);
        L7:
            th = move-exception;
            throw th;
        }

        void startLocalVoiceInteraction(final IBinder token, String attributionTag, Bundle options) {
            if (this.mImpl != null) goto L5;
            return;
        L5:
            final int callingUid = Binder.getCallingUid();
            long caller = Binder.clearCallingIdentity();
            HotwordMetricsLogger.cancelHotwordTriggerToUiLatencySession(this.this$0.mContext);     // Catch: Throwable -> L13
            this.mImpl.showSessionLocked(options, 16, attributionTag, new AnonymousClass1(this, callingUid, token), token);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(caller);
            return;
        L11:
            th = move-exception;
            Throwable r11 = th;
        L15:
            Binder.restoreCallingIdentity(caller);
            throw r11;
        L13:
            th = move-exception;
            r11 = th;
            goto L15
        }

        public void stopLocalVoiceInteraction(IBinder callingActivity) {
            if (this.mImpl != null) goto L5;
            return;
        L5:
            long caller = Binder.clearCallingIdentity();
            this.mImpl.finishLocked(callingActivity, true);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(caller);
            return;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);
            throw th;
        }

        public boolean supportsLocalVoiceInteraction() {
            if (this.mImpl != null) goto L7;
            return false;
        L7:
            return this.mImpl.supportsLocalVoiceInteraction();
        }

        void notifyActivityDestroyed(final IBinder activityToken) {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl == null) goto L12;
            if (activityToken == null) goto L12;
            Binder.withCleanCallingIdentity(new VoiceInteractionManagerService$VoiceInteractionManagerServiceStub$$ExternalSyntheticLambda2(this, activityToken));     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L12:
            monitor-exit(this);     // Catch: Throwable -> L10
        }

        private /* synthetic */ void lambda$notifyActivityDestroyed$0(IBinder activityToken) throws Exception {
            this.mImpl.notifyActivityDestroyedLocked(activityToken);
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            return super.onTransact(code, data, reply, flags);
        L4:
            e = move-exception;
            if ((e instanceof SecurityException) == true) goto L8;
            Slog.wtf(VoiceInteractionManagerService.TAG, "VoiceInteractionManagerService Crash", e);
        L8:
            throw e;
        }

        public void initForUser(int userHandle) {
            TimingsTraceAndSlog t = null;
            initForUserNoTracing(userHandle);
            if (0 == 0) goto L6;
            t.traceEnd();
            return;
        }

        private void initForUserNoTracing(int userHandle) {
            String curInteractorStr = Settings.Secure.getStringForUser(this.this$0.mContext.getContentResolver(), "voice_interaction_service", userHandle);
            ComponentName curRecognizer = getCurRecognizer(userHandle);
            VoiceInteractionServiceInfo curInteractorInfo = null;
            if (curInteractorStr != null) goto L10;
            if (curRecognizer == null) goto L10;
            if (this.mEnableService == false) goto L10;
            curInteractorInfo = findAvailInteractor(userHandle, curRecognizer.getPackageName());
            if (curInteractorInfo == null) goto L10;
            curRecognizer = null;
        L10:
            String forceInteractorPackage = getForceVoiceInteractionServicePackage(this.this$0.mContext.getResources());
            if (forceInteractorPackage == null) goto L16;
            curInteractorInfo = findAvailInteractor(userHandle, forceInteractorPackage);
            if (curInteractorInfo == null) goto L16;
            curRecognizer = null;
        L16:
            if (this.mEnableService == true) goto L21;
            if (curInteractorStr == null) goto L21;
            if (TextUtils.isEmpty(curInteractorStr) == true) goto L21;
            setCurInteractor(null, userHandle);
            curInteractorStr = "";
        L21:
            if (curRecognizer == null) goto L45;
            IPackageManager pm = AppGlobals.getPackageManager();
            ServiceInfo interactorInfo = null;
            ServiceInfo recognizerInfo = null;
            if (TextUtils.isEmpty(curInteractorStr) == true) goto L25;
            ComponentName curInteractor = ComponentName.unflattenFromString(curInteractorStr);
        L56:
            recognizerInfo = pm.getServiceInfo(curRecognizer, 786560, userHandle);     // Catch: RemoteException -> L32
            if (recognizerInfo == null) goto L37;
            RecognitionServiceInfo rsi = RecognitionServiceInfo.parseInfo(this.this$0.mContext.getPackageManager(), recognizerInfo);     // Catch: RemoteException -> L32
            if (TextUtils.isEmpty(rsi.getParseError()) == true) goto L35;
            Log.w(VoiceInteractionManagerService.TAG, "Parse error in getAvailableServices: " + rsi.getParseError());     // Catch: RemoteException -> L32
        L35:
            if (rsi.isSelectableAsDefault() == true) goto L37;
            recognizerInfo = null;
        L37:
            if (curInteractor == null) goto L41;
            interactorInfo = pm.getServiceInfo(curInteractor, 786432, userHandle);     // Catch: RemoteException -> L32
        L41:
            if (recognizerInfo == null) goto L45;
            if (curInteractor == null) goto L44;
            if (interactorInfo == null) goto L45;
            return;
        L44:
            return;
        L25:
            curInteractor = null;
        L45:
            if (curInteractorInfo == null) goto L47;
        L51:
            if (curInteractorInfo == null) goto L53;
            setCurInteractor(new ComponentName(curInteractorInfo.getServiceInfo().packageName, curInteractorInfo.getServiceInfo().name), userHandle);
        L54:
            initRecognizer(userHandle);
            return;
        L53:
            setCurInteractor(null, userHandle);
            goto L54
        L47:
            if (this.mEnableService == false) goto L51;
            if ("".equals(curInteractorStr) == true) goto L51;
            curInteractorInfo = findAvailInteractor(userHandle, null);
            goto L51
        }

        public void initRecognizer(int userHandle) {
            ComponentName curRecognizer = findAvailRecognizer(null, userHandle);
            if (curRecognizer == null) goto L6;
            setCurRecognizer(curRecognizer, userHandle);
            return;
        }

        private boolean shouldEnableService(Context context) {
            if (getForceVoiceInteractionServicePackage(context.getResources()) == null) goto L7;
            return true;
        L7:
            return context.getPackageManager().hasSystemFeature("android.software.voice_recognizers");
        }

        private String getForceVoiceInteractionServicePackage(Resources res) {
            String interactorPackage = res.getString(R.string.config_pluginsProviderJarPath);
            if (TextUtils.isEmpty(interactorPackage) == false) goto L6;
            return null;
        L6:
            return interactorPackage;
        }

        public void systemRunning(boolean safeMode) {
            this.mSafeMode = safeMode;
            this.mPackageMonitor.register(this.this$0.mContext, BackgroundThread.getHandler().getLooper(), UserHandle.ALL, true);
            new SettingsObserver(this, UiThread.getHandler());
            monitor-enter(this);
            setCurrentUserLocked(ActivityManager.getCurrentUser());     // Catch: Throwable -> L7
            switchImplementationIfNeededLocked(false);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void setCurrentUserLocked(int userHandle) {
            this.mCurUser = userHandle;
            UserInfo userInfo = this.this$0.mUserManagerInternal.getUserInfo(this.mCurUser);
            this.mCurUserSupported = VoiceInteractionManagerService.m9418$$Nest$misUserSupported(this.this$0, userInfo);
        }

        public void switchUser(final int userHandle) {
            FgThread.getHandler().post(new VoiceInteractionManagerService$VoiceInteractionManagerServiceStub$$ExternalSyntheticLambda0(this, userHandle));
        }

        private /* synthetic */ void lambda$switchUser$1(int userHandle) {
            monitor-enter(this);
            setCurrentUserLocked(userHandle);     // Catch: Throwable -> L6
            switchImplementationIfNeededLocked(false);     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        void switchImplementationIfNeeded(boolean force) {
            monitor-enter(this);
            switchImplementationIfNeededLocked(force);     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        void switchImplementationIfNeededLocked(boolean force) {
            if (this.mCurUserSupported == false) goto L5;
            TimingsTraceAndSlog t = null;
            switchImplementationIfNeededNoTracingLocked(force);
            if (0 == 0) goto L13;
            t.traceEnd();
            return;
        L13:
            return;
        L5:
            if (this.mImpl == null) goto L12;
            this.mImpl.shutdownLocked();
            setImplLocked(null);
            return;
        }

        void switchImplementationIfNeededNoTracingLocked(boolean force) {
            if (this.mSafeMode == true) goto L38;
            String curService = Settings.Secure.getStringForUser(this.this$0.mResolver, "voice_interaction_service", this.mCurUser);
            ServiceInfo serviceInfo = null;
            if (curService != null) goto L7;
        L12:
            ComponentName serviceComponent = null;
        L13:
            if (serviceComponent == null) goto L16;
            if (serviceInfo == null) goto L16;
            boolean hasComponent = true;
        L18:
            if (this.this$0.mUserManagerInternal.isUserUnlockingOrUnlocked(this.mCurUser) == false) goto L22;
            if (hasComponent == false) goto L21;
            this.this$0.mShortcutServiceInternal.setShortcutHostPackage(VoiceInteractionManagerService.TAG, serviceComponent.getPackageName(), this.mCurUser);
            this.this$0.mAtmInternal.setAllowAppSwitches(VoiceInteractionManagerService.TAG, serviceInfo.applicationInfo.uid, this.mCurUser);
            goto L22
        L21:
            this.this$0.mShortcutServiceInternal.setShortcutHostPackage(VoiceInteractionManagerService.TAG, null, this.mCurUser);
            this.this$0.mAtmInternal.setAllowAppSwitches(VoiceInteractionManagerService.TAG, -1, this.mCurUser);
        L22:
            if (force == false) goto L24;
        L31:
            unloadAllKeyphraseModels();
            if (this.mImpl == null) goto L34;
            this.mImpl.shutdownLocked();
        L34:
            if (hasComponent == false) goto L36;
            setImplLocked(new VoiceInteractionManagerServiceImpl(this.this$0.mContext, UiThread.getHandler(), this, this.mCurUser, serviceComponent));
            this.mImpl.startLocked();
            return;
        L36:
            setImplLocked(null);
            return;
        L24:
            if (this.mImpl == null) goto L31;
            if (this.mImpl.mUser != this.mCurUser) goto L31;
            if (this.mImpl.mComponent.equals(serviceComponent) == false) goto L31;
            return;
        L16:
            hasComponent = false;
            goto L18
        L7:
            if (curService.isEmpty() == true) goto L12;
            ComponentName serviceComponent2 = ComponentName.unflattenFromString(curService);     // Catch: Throwable -> L10
            serviceInfo = AppGlobals.getPackageManager().getServiceInfo(serviceComponent2, 0, this.mCurUser);     // Catch: Throwable -> L10
            serviceComponent = serviceComponent2;
        L10:
            e = move-exception;
            Slog.wtf(VoiceInteractionManagerService.TAG, "Bad voice interaction service name " + curService, e);
            serviceInfo = null;
            serviceComponent = null;
            goto L13
        }

        private List<ResolveInfo> queryInteractorServices(int user, String packageName) {
            return this.this$0.mContext.getPackageManager().queryIntentServicesAsUser(new Intent("android.service.voice.VoiceInteractionService").setPackage(packageName), 786560, user);
        }

        VoiceInteractionServiceInfo findAvailInteractor(int user, String packageName) {
            List<ResolveInfo> available = queryInteractorServices(user, packageName);
            int numAvailable = available.size();
            if (numAvailable != 0) goto L6;
            Slog.w(VoiceInteractionManagerService.TAG, "no available voice interaction services found for user " + user);
            return null;
        L6:
            String curInteractorStr = Settings.Secure.getStringForUser(this.this$0.mContext.getContentResolver(), "voice_interaction_service", user);
            VoiceInteractionServiceInfo foundInfo = null;
            int i = 0;
        L7:
            if (i >= numAvailable) goto L22;
            ServiceInfo cur = available.get(i).serviceInfo;
            if ((cur.applicationInfo.flags & 1) == 0) goto L20;
            VoiceInteractionServiceInfo info = new VoiceInteractionServiceInfo(this.this$0.mContext.getPackageManager(), cur);
            if (info.getParseError() == null) goto L14;
            Slog.w(VoiceInteractionManagerService.TAG, "Bad interaction service " + cur.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + cur.name + ": " + info.getParseError());
            goto L20
        L14:
            if (foundInfo != null) goto L16;
            foundInfo = info;
            goto L20
        L16:
            String curCompentName = new ComponentName(cur.packageName, cur.name).flattenToShortString();
            if (curCompentName.equals(curInteractorStr) == false) goto L19;
            foundInfo = info;
            Slog.w(VoiceInteractionManagerService.TAG, "More than one voice interaction service, but equals, use " + new ComponentName(cur.packageName, cur.name));
            goto L20
        L19:
            Slog.w(VoiceInteractionManagerService.TAG, "More than one voice interaction service, picking first " + new ComponentName(foundInfo.getServiceInfo().packageName, foundInfo.getServiceInfo().name) + " over " + new ComponentName(cur.packageName, cur.name) + " and str:" + curInteractorStr);
        L20:
            i = i + 1;
            goto L7
        L22:
            return foundInfo;
        }

        ComponentName getCurInteractor(int userHandle) {
            String curInteractor = Settings.Secure.getStringForUser(this.this$0.mContext.getContentResolver(), "voice_interaction_service", userHandle);
            if (TextUtils.isEmpty(curInteractor) == false) goto L7;
            return null;
        L7:
            return ComponentName.unflattenFromString(curInteractor);
        }

        void setCurInteractor(ComponentName comp, int userHandle) {
            ContentResolver r0 = this.this$0.mContext.getContentResolver();
            if (comp == null) goto L5;
            String r1 = comp.flattenToShortString();
        L6:
            Settings.Secure.putStringForUser(r0, "voice_interaction_service", r1, userHandle);
            return;
        L5:
            r1 = "";
            goto L6
        }

        ComponentName findAvailRecognizer(String prefPackage, int userHandle) {
            if (prefPackage != null) goto L4;
            prefPackage = getDefaultRecognizer();
        L4:
            List<RecognitionServiceInfo> available = RecognitionServiceInfo.getAvailableServices(this.this$0.mContext, userHandle);
            if (available.size() != 0) goto L8;
            Slog.w(VoiceInteractionManagerService.TAG, "no available voice recognition services found for user " + userHandle);
            return null;
        L8:
            List<RecognitionServiceInfo> nonSelectableAsDefault = removeNonSelectableAsDefault(available);
            if (available.size() != 0) goto L11;
            Slog.w(VoiceInteractionManagerService.TAG, "No selectableAsDefault recognition services found for user " + userHandle + ". Falling back to non selectableAsDefault ones.");
            available = nonSelectableAsDefault;
        L11:
            int numAvailable = available.size();
            if (prefPackage == null) goto L20;
            int i = 0;
        L14:
            if (i >= numAvailable) goto L20;
            ServiceInfo serviceInfo = available.get(i).getServiceInfo();
            if (prefPackage.equals(serviceInfo.packageName) == true) goto L18;
            i = i + 1;
            goto L14
        L18:
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        L20:
            int i2 = 0;
        L21:
            if (i2 >= numAvailable) goto L27;
            ServiceInfo serviceInfo2 = available.get(i2).getServiceInfo();
            if ((serviceInfo2.applicationInfo.flags & 1) != 0) goto L26;
            i2 = i2 + 1;
            goto L21
        L26:
            return new ComponentName(serviceInfo2.packageName, serviceInfo2.name);
        L27:
            Slog.w(VoiceInteractionManagerService.TAG, "no auto selectable voice recognition services found for user " + userHandle);
            return null;
        }

        private List<RecognitionServiceInfo> removeNonSelectableAsDefault(List<RecognitionServiceInfo> services) {
            List<RecognitionServiceInfo> nonSelectableAsDefault = new ArrayList();
            int i = services.size() - 1;
        L3:
            if (i < 0) goto L9;
            if (services.get(i).isSelectableAsDefault() == true) goto L7;
            nonSelectableAsDefault.add(services.remove(i));
        L7:
            i = i - 1;
            goto L3
        L9:
            return nonSelectableAsDefault;
        }

        public String getDefaultRecognizer() {
            String recognizer = this.this$0.mContext.getString(R.string.config_systemSpeechRecognizer);
            if (TextUtils.isEmpty(recognizer) == false) goto L6;
            return null;
        L6:
            return recognizer;
        }

        ComponentName getCurRecognizer(int userHandle) {
            String curRecognizer = Settings.Secure.getStringForUser(this.this$0.mContext.getContentResolver(), "voice_recognition_service", userHandle);
            if (TextUtils.isEmpty(curRecognizer) == false) goto L7;
            return null;
        L7:
            return ComponentName.unflattenFromString(curRecognizer);
        }

        void setCurRecognizer(ComponentName comp, int userHandle) {
            ContentResolver r0 = this.this$0.mContext.getContentResolver();
            if (comp == null) goto L5;
            String r1 = comp.flattenToShortString();
        L6:
            Settings.Secure.putStringForUser(r0, "voice_recognition_service", r1, userHandle);
            return;
        L5:
            r1 = "";
            goto L6
        }

        ComponentName getCurAssistant(int userHandle) {
            String curAssistant = Settings.Secure.getStringForUser(this.this$0.mContext.getContentResolver(), "assistant", userHandle);
            if (TextUtils.isEmpty(curAssistant) == false) goto L7;
            return null;
        L7:
            return ComponentName.unflattenFromString(curAssistant);
        }

        void resetCurAssistant(int userHandle) {
            Settings.Secure.putStringForUser(this.this$0.mContext.getContentResolver(), "assistant", null, userHandle);
        }

        void forceRestartHotwordDetector() {
            this.mImpl.forceRestartHotwordDetector();
        }

        void setDebugHotwordLogging(boolean logging) {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl != null) goto L10;
            Slog.w(VoiceInteractionManagerService.TAG, "setTemporaryLogging without running voice interaction service");     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            this.mImpl.setDebugHotwordLoggingLocked(logging);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
        }

        public void showSession(Bundle args, int flags, String attributionTag) {
            monitor-enter(this);
        L25:
            th = th;
        L27:
            monitor-exit(this);     // Catch: Throwable -> L17
            throw th;
        L4:
            if (VoiceInteractionManagerService.m9413$$Nest$fgetmVIMSExt(this.this$0).showSession_skipPermissionCheck() == false) goto L31;
        L9:
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L25
            this.mImpl.showSessionLocked(args, flags, attributionTag, null, null);     // Catch: Throwable -> L19
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L17
            monitor-exit(this);     // Catch: Throwable -> L17
            return;
        L19:
            th = move-exception;
            Throwable r10 = th;
        L23:
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L17
            throw r10;     // Catch: Throwable -> L17
        L21:
            th = move-exception;
            r10 = th;
            goto L23
        L31:
            enforceIsCurrentVoiceInteractionService();     // Catch: Throwable -> L7
        L7:
            th = th;
        L17:
            th = th;
            goto L27
        }

        public boolean deliverNewSession(IBinder token, IVoiceInteractionSession session, IVoiceInteractor interactor) {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl == null) goto L16;
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
            boolean r2 = this.mImpl.deliverNewSessionLocked(token, session, interactor);     // Catch: Throwable -> L12
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            return r2;
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L10
            throw th;     // Catch: Throwable -> L10
        L16:
            throw new SecurityException("deliverNewSession without running voice interaction service");     // Catch: Throwable -> L10
        }

        public boolean showSessionFromSession(IBinder token, Bundle sessionArgs, int flags, String attributionTag) {
            monitor-enter(this);
            String csKey = this.this$0.mContext.getResources().getString(R.string.config_doubleTouchGestureEnableFile);     // Catch: Throwable -> L62
            String csEnabledKey = this.this$0.mContext.getResources().getString(R.string.config_doublePressOnPowerTargetActivity);     // Catch: Throwable -> L62
            if (sessionArgs == null) goto L41;
        L19:
            th = th;
        L64:
            monitor-exit(this);     // Catch: Throwable -> L54
            throw th;
        L7:
            if (sessionArgs.containsKey(csKey) == false) goto L41;
            if (sessionArgs.getBoolean(csEnabledKey, true) == false) goto L27;
            long getSearchIntentCaller = Binder.clearCallingIdentity();     // Catch: Throwable -> L19
            Intent launchIntent = getContextualSearchIntent(sessionArgs);     // Catch: Throwable -> L24
            Binder.restoreCallingIdentity(getSearchIntentCaller);     // Catch: Throwable -> L19
            if (launchIntent == null) goto L27;
            Slog.d(VoiceInteractionManagerService.TAG, "Handed over to contextual search helper.");     // Catch: Throwable -> L19
            int userId = Binder.getCallingUserHandle().getIdentifier();     // Catch: Throwable -> L19
            long startSearchCaller = Binder.clearCallingIdentity();     // Catch: Throwable -> L19
            boolean r0 = startContextualSearch(launchIntent, userId);     // Catch: Throwable -> L21
            Binder.restoreCallingIdentity(startSearchCaller);     // Catch: Throwable -> L19
            monitor-exit(this);     // Catch: Throwable -> L19
            return r0;
        L21:
            th = move-exception;
            Binder.restoreCallingIdentity(startSearchCaller);     // Catch: Throwable -> L19
            throw th;     // Catch: Throwable -> L19
        L24:
            th = move-exception;
            Binder.restoreCallingIdentity(getSearchIntentCaller);     // Catch: Throwable -> L19
            throw th;     // Catch: Throwable -> L19
        L27:
            String visEnabledKey = this.this$0.mContext.getResources().getString(R.string.config_dozeComponent);     // Catch: Throwable -> L19
            if (sessionArgs.getBoolean(visEnabledKey, true) == false) goto L38;
            String csPkgName = this.this$0.mContext.getResources().getString(R.string.config_dozeDoubleTapSensorType);     // Catch: Throwable -> L19
            ComponentName currInteractor = getCurInteractor(Binder.getCallingUserHandle().getIdentifier());     // Catch: Throwable -> L19
            if (currInteractor != null) goto L32;
        L35:
            Slog.w(VoiceInteractionManagerService.TAG, "Contextual Search not supported yet. Returning failure.");     // Catch: Throwable -> L19
            monitor-exit(this);     // Catch: Throwable -> L19
            return false;
        L32:
            if (csPkgName.equals(currInteractor.getPackageName()) == false) goto L35;
            Slog.d(VoiceInteractionManagerService.TAG, "Contextual search not supported yet. Proceeding with VIS.");     // Catch: Throwable -> L19
            goto L41
        L38:
            monitor-exit(this);     // Catch: Throwable -> L19
            return false;
        L41:
            if (this.mImpl != null) goto L45;
            Slog.w(VoiceInteractionManagerService.TAG, "showSessionFromSession without running voice interaction service");     // Catch: Throwable -> L19
            monitor-exit(this);     // Catch: Throwable -> L19
            return false;
        L45:
            if (token != null) goto L47;
            HotwordMetricsLogger.cancelHotwordTriggerToUiLatencySession(this.this$0.mContext);     // Catch: Throwable -> L19
        L47:
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L62
            boolean r13 = this.mImpl.showSessionLocked(sessionArgs, flags, attributionTag, null, null);     // Catch: Throwable -> L56
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L54
            monitor-exit(this);     // Catch: Throwable -> L54
            return r13;
        L56:
            th = move-exception;
            Throwable r14 = th;
        L60:
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L54
            throw r14;     // Catch: Throwable -> L54
        L58:
            th = move-exception;
            r14 = th;
        L62:
            th = th;
        L54:
            th = th;
            goto L64
        }

        public boolean hideSessionFromSession(IBinder token) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl != null) goto L11;
            Slog.w(VoiceInteractionManagerService.TAG, "hideSessionFromSession without running voice interaction service");     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return false;
        L11:
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
            boolean r2 = this.mImpl.hideSessionLocked();     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return r2;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        }

        public int startVoiceActivity(IBinder token, Intent intent, String resolvedType, String attributionTag) {
            monitor-enter(this);
        L34:
            th = th;
        L36:
            monitor-exit(this);     // Catch: Throwable -> L26
            throw th;
        L4:
            if (this.mImpl == null) goto L42;
            int callingPid = Binder.getCallingPid();     // Catch: Throwable -> L34
            int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L34
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L34
            ActivityInfo activityInfo = intent.resolveActivityInfo(this.this$0.mContext.getPackageManager(), 131072);     // Catch: Throwable -> L30
            if (activityInfo != null) goto L38;
            Slog.w(VoiceInteractionManagerService.TAG, "Cannot find ActivityInfo in startVoiceActivity.");     // Catch: Throwable -> L30
        L20:
            int r11 = this.mImpl.startVoiceActivityLocked(attributionTag, callingPid, callingUid, token, intent, resolvedType);     // Catch: Throwable -> L28
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L26
            monitor-exit(this);     // Catch: Throwable -> L26
            return r11;
        L28:
            th = th;
        L32:
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L26
            throw th;     // Catch: Throwable -> L26
        L38:
            int activityUid = activityInfo.applicationInfo.uid;     // Catch: Throwable -> L17
            this.mImpl.grantImplicitAccessLocked(activityUid, intent);     // Catch: Throwable -> L17
        L17:
            th = th;
        L30:
            th = th;
            goto L32
        L42:
            Slog.w(VoiceInteractionManagerService.TAG, "startVoiceActivity without running voice interaction service");     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return -96;
        L9:
            th = th;
        L26:
            th = th;
            goto L36
        }

        public int startAssistantActivity(IBinder token, Intent intent, String resolvedType, String attributionTag, Bundle bundle) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl != null) goto L11;
            Slog.w(VoiceInteractionManagerService.TAG, "startAssistantActivity without running voice interaction service");     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return -96;
        L11:
            int callingPid = Binder.getCallingPid();     // Catch: Throwable -> L9
            int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L9
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
            int r0 = this.mImpl.startAssistantActivityLocked(attributionTag, callingPid, callingUid, token, intent, resolvedType, bundle);     // Catch: Throwable -> L17
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return r0;
        L17:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        }

        public void requestDirectActions(IBinder token, int taskId, IBinder assistToken, RemoteCallback cancellationCallback, RemoteCallback resultCallback) {
            monitor-enter(this);
        L26:
            th = th;
        L28:
            monitor-exit(this);     // Catch: Throwable -> L18
            throw th;
        L4:
            if (this.mImpl == null) goto L34;
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L26
            this.mImpl.requestDirectActionsLocked(token, taskId, assistToken, cancellationCallback, resultCallback);     // Catch: Throwable -> L20
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L18
            monitor-exit(this);     // Catch: Throwable -> L18
            return;
        L20:
            th = move-exception;
            Throwable r10 = th;
        L24:
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L18
            throw r10;     // Catch: Throwable -> L18
        L22:
            th = move-exception;
            r10 = th;
            goto L24
        L34:
            Slog.w(VoiceInteractionManagerService.TAG, "requestDirectActions without running voice interaction service");     // Catch: Throwable -> L8
            resultCallback.sendResult(null);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L8:
            th = th;
        L18:
            th = th;
            goto L28
        }

        public void performDirectAction(IBinder token, String actionId, Bundle arguments, int taskId, IBinder assistToken, RemoteCallback cancellationCallback, RemoteCallback resultCallback) {
            monitor-enter(this);
        L10:
            th = th;
        L23:
            monitor-exit(this);     // Catch: Throwable -> L10
            throw th;
        L4:
            if (this.mImpl == null) goto L28;
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
            this.mImpl.performDirectActionLocked(token, actionId, arguments, taskId, assistToken, cancellationCallback, resultCallback);     // Catch: Throwable -> L20
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L20:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L10
            throw th;     // Catch: Throwable -> L10
        L28:
            Slog.w(VoiceInteractionManagerService.TAG, "performDirectAction without running voice interaction service");     // Catch: Throwable -> L12
            resultCallback.sendResult(null);     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L12:
            th = th;
            goto L23
        }

        public void setKeepAwake(IBinder token, boolean keepAwake) {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl != null) goto L10;
            Slog.w(VoiceInteractionManagerService.TAG, "setKeepAwake without running voice interaction service");     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L8
            this.mImpl.setKeepAwakeLocked(token, keepAwake);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        }

        public void closeSystemDialogs(IBinder token) {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl != null) goto L10;
            Slog.w(VoiceInteractionManagerService.TAG, "closeSystemDialogs without running voice interaction service");     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L8
            this.mImpl.closeSystemDialogsLocked(token);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        }

        public void finish(IBinder token) {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl != null) goto L10;
            Slog.w(VoiceInteractionManagerService.TAG, "finish without running voice interaction service");     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L8
            this.mImpl.finishLocked(token, false);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        }

        public void setDisabledShowContext(int flags) {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl != null) goto L10;
            Slog.w(VoiceInteractionManagerService.TAG, "setDisabledShowContext without running voice interaction service");     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L8
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L8
            this.mImpl.setDisabledShowContextLocked(callingUid, flags);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        }

        public int getDisabledShowContext() {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl != null) goto L11;
            Slog.w(VoiceInteractionManagerService.TAG, "getDisabledShowContext without running voice interaction service");     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return 0;
        L11:
            int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L9
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
            int r3 = this.mImpl.getDisabledShowContextLocked(callingUid);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return r3;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        }

        public int getUserDisabledShowContext() {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl != null) goto L11;
            Slog.w(VoiceInteractionManagerService.TAG, "getUserDisabledShowContext without running voice interaction service");     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return 0;
        L11:
            int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L9
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
            int r3 = this.mImpl.getUserDisabledShowContextLocked(callingUid);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return r3;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        }

        public void setDisabled(boolean disabled) {
            super.setDisabled_enforcePermission();
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mTemporarilyDisabled != disabled) goto L10;
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            this.mTemporarilyDisabled = disabled;     // Catch: Throwable -> L8
            if (this.mTemporarilyDisabled == false) goto L17;
            Slog.i(VoiceInteractionManagerService.TAG, "setDisabled(): temporarily disabling and hiding current session");     // Catch: Throwable -> L8
            hideCurrentSession();     // Catch: Throwable -> L8 RemoteException -> L15
        L18:
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L15:
            e = move-exception;
            Log.w(VoiceInteractionManagerService.TAG, "Failed to call hideCurrentSession", e);     // Catch: Throwable -> L8
            goto L18
        L17:
            Slog.i(VoiceInteractionManagerService.TAG, "setDisabled(): re-enabling");     // Catch: Throwable -> L8
            goto L18
        }

        public void startListeningVisibleActivityChanged(IBinder token) {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl != null) goto L10;
            Slog.w(VoiceInteractionManagerService.TAG, "startListeningVisibleActivityChanged without running voice interaction service");     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L8
            this.mImpl.startListeningVisibleActivityChangedLocked(token);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        }

        public void stopListeningVisibleActivityChanged(IBinder token) {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl != null) goto L10;
            Slog.w(VoiceInteractionManagerService.TAG, "stopListeningVisibleActivityChanged without running voice interaction service");     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L8
            this.mImpl.stopListeningVisibleActivityChangedLocked(token);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        }

        public void notifyActivityEventChanged(final IBinder activityToken, final int type) {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl == null) goto L12;
            if (activityToken == null) goto L12;
            Binder.withCleanCallingIdentity(new VoiceInteractionManagerService$VoiceInteractionManagerServiceStub$$ExternalSyntheticLambda7(this, activityToken, type));     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L12:
            monitor-exit(this);     // Catch: Throwable -> L10
        }

        private /* synthetic */ void lambda$notifyActivityEventChanged$2(IBinder activityToken, int type) throws Exception {
            this.mImpl.notifyActivityEventChangedLocked(activityToken, type);
        }

        public void updateState(final PersistableBundle options, final SharedMemory sharedMemory, final IBinder token) {
            super.updateState_enforcePermission();
            monitor-enter(this);
            enforceIsCurrentVoiceInteractionService();     // Catch: Throwable -> L7
            Binder.withCleanCallingIdentity(new VoiceInteractionManagerService$VoiceInteractionManagerServiceStub$$ExternalSyntheticLambda3(this, options, sharedMemory, token));     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$updateState$3(PersistableBundle options, SharedMemory sharedMemory, IBinder token) throws Exception {
            this.mImpl.updateStateLocked(options, sharedMemory, token);
        }

        public void initAndVerifyDetector(final Identity voiceInteractorIdentity, final PersistableBundle options, final SharedMemory sharedMemory, final IBinder token, final IHotwordRecognitionStatusCallback callback, final int detectorType) {
            super.initAndVerifyDetector_enforcePermission();
            monitor-enter(this);
            enforceIsCurrentVoiceInteractionService();     // Catch: Throwable -> L11
            voiceInteractorIdentity.uid = Binder.getCallingUid();     // Catch: Throwable -> L11
            voiceInteractorIdentity.pid = Binder.getCallingPid();     // Catch: Throwable -> L11
            Binder.withCleanCallingIdentity(new VoiceInteractionManagerService$VoiceInteractionManagerServiceStub$$ExternalSyntheticLambda6(this, voiceInteractorIdentity, options, sharedMemory, token, callback, detectorType));     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            Throwable r10 = th;
        L13:
            monitor-exit(this);     // Catch: Throwable -> L9
            throw r10;
        L11:
            th = move-exception;
            r10 = th;
            goto L13
        }

        private /* synthetic */ void lambda$initAndVerifyDetector$4(Identity voiceInteractorIdentity, PersistableBundle options, SharedMemory sharedMemory, IBinder token, IHotwordRecognitionStatusCallback callback, int detectorType) throws Exception {
            this.mImpl.initAndVerifyDetectorLocked(voiceInteractorIdentity, options, sharedMemory, token, callback, detectorType);
        }

        public void destroyDetector(final IBinder token) {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl != null) goto L10;
            Slog.w(VoiceInteractionManagerService.TAG, "destroyDetector without running voice interaction service");     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            Binder.withCleanCallingIdentity(new VoiceInteractionManagerService$VoiceInteractionManagerServiceStub$$ExternalSyntheticLambda4(this, token));     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
        }

        private /* synthetic */ void lambda$destroyDetector$5(IBinder token) throws Exception {
            this.mImpl.destroyDetectorLocked(token);
        }

        public void shutdownHotwordDetectionService() {
            monitor-enter(this);
            enforceIsCurrentVoiceInteractionService();     // Catch: Throwable -> L8
            if (this.mImpl != null) goto L10;
            Slog.w(VoiceInteractionManagerService.TAG, "shutdownHotwordDetectionService without running voice interaction service");     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L8
            this.mImpl.shutdownHotwordDetectionServiceLocked();     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        public void subscribeVisualQueryRecognitionStatus(IVisualQueryRecognitionStatusListener listener) {
            super.subscribeVisualQueryRecognitionStatus_enforcePermission();
            monitor-enter(this);
            VoiceInteractionManagerService.m9417$$Nest$fputmVisualQueryRecognitionStatusListener(this.this$0, listener);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void enableVisualQueryDetection(IVisualQueryDetectionAttentionListener listener) {
            super.enableVisualQueryDetection_enforcePermission();
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mImpl != null) goto L11;
            Slog.w(VoiceInteractionManagerService.TAG, "enableVisualQueryDetection without running voice interaction service");     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return;
        L11:
            this.mImpl.setVisualQueryDetectionAttentionListenerLocked(listener);     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
        }

        public void disableVisualQueryDetection() {
            super.disableVisualQueryDetection_enforcePermission();
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mImpl != null) goto L11;
            Slog.w(VoiceInteractionManagerService.TAG, "disableVisualQueryDetection without running voice interaction service");     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return;
        L11:
            this.mImpl.setVisualQueryDetectionAttentionListenerLocked(null);     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
        }

        public void startPerceiving(IVisualQueryDetectionVoiceInteractionCallback callback) throws RemoteException {
            enforceCallingPermission("android.permission.RECORD_AUDIO");
            enforceCallingPermission("android.permission.CAMERA");
            monitor-enter(this);
            enforceIsCurrentVoiceInteractionService();     // Catch: Throwable -> L9
            if (this.mImpl != null) goto L11;
            Slog.w(VoiceInteractionManagerService.TAG, "startPerceiving without running voice interaction service");     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return;
        L11:
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
            boolean success = this.mImpl.startPerceivingLocked(callback);     // Catch: Throwable -> L18
            if (success == true) goto L15;
        L20:
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return;
        L15:
            if (VoiceInteractionManagerService.m9414$$Nest$fgetmVisualQueryRecognitionStatusListener(this.this$0) == null) goto L20;
            VoiceInteractionManagerService.m9414$$Nest$fgetmVisualQueryRecognitionStatusListener(this.this$0).onStartPerceiving();     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        public void stopPerceiving() throws RemoteException {
            monitor-enter(this);
            enforceIsCurrentVoiceInteractionService();     // Catch: Throwable -> L8
            if (this.mImpl != null) goto L10;
            Slog.w(VoiceInteractionManagerService.TAG, "stopPerceiving without running voice interaction service");     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L8
            boolean success = this.mImpl.stopPerceivingLocked();     // Catch: Throwable -> L17
            if (success == true) goto L14;
        L19:
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L14:
            if (VoiceInteractionManagerService.m9414$$Nest$fgetmVisualQueryRecognitionStatusListener(this.this$0) == null) goto L19;
            VoiceInteractionManagerService.m9414$$Nest$fgetmVisualQueryRecognitionStatusListener(this.this$0).onStopPerceiving();     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        public void startListeningFromMic(AudioFormat audioFormat, IMicrophoneHotwordDetectionVoiceInteractionCallback callback) throws RemoteException {
            enforceCallingPermission("android.permission.RECORD_AUDIO");
            enforceCallingPermission("android.permission.CAPTURE_AUDIO_HOTWORD");
            monitor-enter(this);
            enforceIsCurrentVoiceInteractionService();     // Catch: Throwable -> L9
            if (this.mImpl != null) goto L11;
            Slog.w(VoiceInteractionManagerService.TAG, "startListeningFromMic without running voice interaction service");     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return;
        L11:
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
            this.mImpl.startListeningFromMicLocked(audioFormat, callback);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        public void startListeningFromExternalSource(ParcelFileDescriptor audioStream, AudioFormat audioFormat, PersistableBundle options, IBinder token, IMicrophoneHotwordDetectionVoiceInteractionCallback callback) throws RemoteException {
            monitor-enter(this);
            enforceIsCurrentVoiceInteractionService();     // Catch: Throwable -> L26
            if (this.mImpl == null) goto L32;
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L26
            this.mImpl.startListeningFromExternalSourceLocked(audioStream, audioFormat, options, token, callback);     // Catch: Throwable -> L20
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L18
            monitor-exit(this);     // Catch: Throwable -> L18
            return;
        L20:
            th = move-exception;
            Throwable r10 = th;
        L24:
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L18
            throw r10;     // Catch: Throwable -> L18
        L22:
            th = move-exception;
            r10 = th;
            goto L24
        L32:
            Slog.w(VoiceInteractionManagerService.TAG, "startListeningFromExternalSource without running voice interaction service");     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L8:
            th = th;
        L28:
            monitor-exit(this);     // Catch: Throwable -> L18
            throw th;
        L18:
            th = th;
        L26:
            th = th;
            goto L28
        }

        public void stopListeningFromMic() throws RemoteException {
            monitor-enter(this);
            enforceIsCurrentVoiceInteractionService();     // Catch: Throwable -> L8
            if (this.mImpl != null) goto L10;
            Slog.w(VoiceInteractionManagerService.TAG, "stopListeningFromMic without running voice interaction service");     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L8
            this.mImpl.stopListeningFromMicLocked();     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        public void triggerHardwareRecognitionEventForTest(SoundTrigger.KeyphraseRecognitionEvent event, IHotwordRecognitionStatusCallback callback) throws RemoteException {
            enforceCallingPermission("android.permission.RECORD_AUDIO");
            enforceCallingPermission("android.permission.CAPTURE_AUDIO_HOTWORD");
            monitor-enter(this);
            enforceIsCurrentVoiceInteractionService();     // Catch: Throwable -> L9
            if (this.mImpl != null) goto L11;
            Slog.w(VoiceInteractionManagerService.TAG, "triggerHardwareRecognitionEventForTest without running voice interaction service");     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return;
        L11:
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
            this.mImpl.triggerHardwareRecognitionEventForTestLocked(event, callback);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        public SoundTrigger.KeyphraseSoundModel getKeyphraseSoundModel(int keyphraseId, String bcp47Locale) {
            enforceCallerAllowedToEnrollVoiceModel();
            if (bcp47Locale == null) goto L12;
            int callingUserId = UserHandle.getCallingUserId();
            long caller = Binder.clearCallingIdentity();
            SoundTrigger.KeyphraseSoundModel r3 = VoiceInteractionManagerService.m9410$$Nest$fgetmDbHelper(this.this$0).getKeyphraseSoundModel(keyphraseId, callingUserId, bcp47Locale);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(caller);
            return r3;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);
            throw th;
        L12:
            throw new IllegalArgumentException("Illegal argument(s) in getKeyphraseSoundModel");
        }

        public int updateKeyphraseSoundModel(SoundTrigger.KeyphraseSoundModel model) {
            enforceCallerAllowedToEnrollVoiceModel();
            if (model == null) goto L27;
            long caller = Binder.clearCallingIdentity();
        L20:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);
            throw th;
        L6:
            if (VoiceInteractionManagerService.m9410$$Nest$fgetmDbHelper(this.this$0).updateKeyphraseSoundModel(model) == false) goto L22;
            monitor-enter(this);     // Catch: Throwable -> L20
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L9:
            if (this.mImpl != null) goto L11;
        L15:
            monitor-exit(this);     // Catch: Throwable -> L13
            Binder.restoreCallingIdentity(caller);
            return 0;
        L11:
            if (this.mImpl.mService == null) goto L15;
            this.mImpl.notifySoundModelsChangedLocked();     // Catch: Throwable -> L13
            goto L15
        L22:
            Binder.restoreCallingIdentity(caller);
            return Integer.MIN_VALUE;
        L27:
            throw new IllegalArgumentException("Model must not be null");
        }

        public int deleteKeyphraseSoundModel(int keyphraseId, String bcp47Locale) {
            enforceCallerAllowedToEnrollVoiceModel();
            if (bcp47Locale == null) goto L49;
            int callingUserId = UserHandle.getCallingUserId();
            long caller = Binder.clearCallingIdentity();
            SoundTriggerSession session = this.this$0.mLoadedKeyphraseIds.get(Integer.valueOf(keyphraseId));     // Catch: Throwable -> L10
            if (session == null) goto L12;
            int unloadStatus = SoundTriggerSession.m9432$$Nest$munloadKeyphraseModel(session, keyphraseId);     // Catch: Throwable -> L10
            if (unloadStatus == 0) goto L12;
            Slog.w(VoiceInteractionManagerService.TAG, "Unable to unload keyphrase sound model:" + unloadStatus);     // Catch: Throwable -> L10
        L12:
            boolean deleted = VoiceInteractionManagerService.m9410$$Nest$fgetmDbHelper(this.this$0).deleteKeyphraseSoundModel(keyphraseId, callingUserId, bcp47Locale);     // Catch: Throwable -> L10
            if (deleted == false) goto L15;
            int r1 = 0;
        L16:
            if (deleted == false) goto L30;
            monitor-enter(this);
        L23:
            th = move-exception;
            throw th;
        L19:
            if (this.mImpl != null) goto L21;
        L25:
            this.this$0.mLoadedKeyphraseIds.remove(Integer.valueOf(keyphraseId));     // Catch: Throwable -> L23
            monitor-exit(this);     // Catch: Throwable -> L23
            goto L30
        L21:
            if (this.mImpl.mService == null) goto L25;
            this.mImpl.notifySoundModelsChangedLocked();     // Catch: Throwable -> L23
        L30:
            Binder.restoreCallingIdentity(caller);
            return r1;
        L15:
            r1 = Integer.MIN_VALUE;
        L10:
            th = move-exception;
            if (0 == 0) goto L46;
            monitor-enter(this);
        L39:
            th = move-exception;
            throw th;
        L35:
            if (this.mImpl != null) goto L37;
        L41:
            this.this$0.mLoadedKeyphraseIds.remove(Integer.valueOf(keyphraseId));     // Catch: Throwable -> L39
            goto L46
        L37:
            if (this.mImpl.mService == null) goto L41;
            this.mImpl.notifySoundModelsChangedLocked();     // Catch: Throwable -> L39
        L46:
            Binder.restoreCallingIdentity(caller);
            throw th;
        L49:
            throw new IllegalArgumentException("Illegal argument(s) in deleteKeyphraseSoundModel");
        }

        public void setModelDatabaseForTestEnabled(boolean enabled, IBinder token) {
            super.setModelDatabaseForTestEnabled_enforcePermission();
            enforceCallerAllowedToEnrollVoiceModel();
            monitor-enter(this);
            if (enabled == false) goto L14;
            final TestModelEnrollmentDatabase db = new TestModelEnrollmentDatabase();     // Catch: Throwable -> L8
            token.linkToDeath(new VoiceInteractionManagerService$VoiceInteractionManagerServiceStub$$ExternalSyntheticLambda5(this, db), 0);     // Catch: Throwable -> L8 RemoteException -> L10
            VoiceInteractionManagerService.m9416$$Nest$fputmDbHelper(this.this$0, db);     // Catch: Throwable -> L8
            this.mImpl.notifySoundModelsChangedLocked();     // Catch: Throwable -> L8
        L16:
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L12:
            return;
        L14:
            if (VoiceInteractionManagerService.m9410$$Nest$fgetmDbHelper(this.this$0) == VoiceInteractionManagerService.m9411$$Nest$fgetmRealDbHelper(this.this$0)) goto L16;
            VoiceInteractionManagerService.m9416$$Nest$fputmDbHelper(this.this$0, VoiceInteractionManagerService.m9411$$Nest$fgetmRealDbHelper(this.this$0));     // Catch: Throwable -> L8
            this.mImpl.notifySoundModelsChangedLocked();     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$setModelDatabaseForTestEnabled$6(TestModelEnrollmentDatabase db) {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (VoiceInteractionManagerService.m9410$$Nest$fgetmDbHelper(this.this$0) != db) goto L8;
            VoiceInteractionManagerService.m9416$$Nest$fputmDbHelper(this.this$0, VoiceInteractionManagerService.m9411$$Nest$fgetmRealDbHelper(this.this$0));     // Catch: Throwable -> L6
            this.mImpl.notifySoundModelsChangedLocked();     // Catch: Throwable -> L6
        L8:
            monitor-exit(this);     // Catch: Throwable -> L6
        }

        public boolean isEnrolledForKeyphrase(int keyphraseId, String bcp47Locale) {
            monitor-enter(this);
            enforceIsCurrentVoiceInteractionService();     // Catch: Throwable -> L18
            monitor-exit(this);     // Catch: Throwable -> L18
            if (bcp47Locale == null) goto L17;
            int callingUserId = UserHandle.getCallingUserId();
            long caller = Binder.clearCallingIdentity();
            SoundTrigger.KeyphraseSoundModel model = VoiceInteractionManagerService.m9410$$Nest$fgetmDbHelper(this.this$0).getKeyphraseSoundModel(keyphraseId, callingUserId, bcp47Locale);     // Catch: Throwable -> L13
            if (model == null) goto L10;
            boolean r4 = true;
        L11:
            Binder.restoreCallingIdentity(caller);
            return r4;
        L10:
            r4 = false;
        L13:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);
            throw th;
        L17:
            throw new IllegalArgumentException("Illegal argument(s) in isEnrolledForKeyphrase");
        L18:
            th = move-exception;
            throw th;
        }

        public KeyphraseMetadata getEnrolledKeyphraseMetadata(String keyphrase, String bcp47Locale) {
            monitor-enter(this);
            enforceIsCurrentVoiceInteractionService();     // Catch: Throwable -> L28
            monitor-exit(this);     // Catch: Throwable -> L28
            if (bcp47Locale == null) goto L27;
            int callingUserId = UserHandle.getCallingUserId();
            long caller = Binder.clearCallingIdentity();
            SoundTrigger.KeyphraseSoundModel model = VoiceInteractionManagerService.m9410$$Nest$fgetmDbHelper(this.this$0).getKeyphraseSoundModel(keyphrase, callingUserId, bcp47Locale);     // Catch: Throwable -> L19
            if (model != null) goto L12;
            Binder.restoreCallingIdentity(caller);
            return null;
        L12:
            SoundTrigger.Keyphrase[] r5 = model.getKeyphrases();     // Catch: Throwable -> L19
            int r6 = r5.length;     // Catch: Throwable -> L19
            int r7 = 0;
        L13:
            if (r7 >= r6) goto L22;
            SoundTrigger.Keyphrase phrase = r5[r7];     // Catch: Throwable -> L19
            if (keyphrase.equals(phrase.getText()) == true) goto L16;
            r7 = r7 + 1;
            goto L13
        L16:
            ArraySet<Locale> locales = new ArraySet();     // Catch: Throwable -> L19
            locales.add(phrase.getLocale());     // Catch: Throwable -> L19
            KeyphraseMetadata r8 = new KeyphraseMetadata(phrase.getId(), phrase.getText(), locales, phrase.getRecognitionModes());     // Catch: Throwable -> L19
            Binder.restoreCallingIdentity(caller);
            return r8;
        L22:
            Binder.restoreCallingIdentity(caller);
            return null;
        L19:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);
            throw th;
        L27:
            throw new IllegalArgumentException("Illegal argument(s) in isEnrolledForKeyphrase");
        L28:
            th = move-exception;
            throw th;
        }

        private synchronized void unloadAllKeyphraseModels() {
            monitor-enter(this);
            int i = 0;
        L17:
        L9:
            th = move-exception;
            throw th;
        L5:
            if (i >= this.this$0.mLoadedKeyphraseIds.size()) goto L12;
            int id = this.this$0.mLoadedKeyphraseIds.keyAt(i).intValue();     // Catch: Throwable -> L9
            SoundTriggerSession session = this.this$0.mLoadedKeyphraseIds.valueAt(i);     // Catch: Throwable -> L9
            int status = SoundTriggerSession.m9432$$Nest$munloadKeyphraseModel(session, id);     // Catch: Throwable -> L9
            if (status == 0) goto L11;
            Slog.w(VoiceInteractionManagerService.TAG, "Failed to unload keyphrase " + id + ":" + status);     // Catch: Throwable -> L9
        L11:
            i = i + 1;     // Catch: Throwable -> L9
            goto L17
        L12:
            this.this$0.mLoadedKeyphraseIds.clear();     // Catch: Throwable -> L9
            monitor-exit(this);
        }

        public ComponentName getActiveServiceComponentName() {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl == null) goto L8;
            ComponentName r0 = this.mImpl.mComponent;     // Catch: Throwable -> L6
        L9:
            monitor-exit(this);     // Catch: Throwable -> L6
            return r0;
        L8:
            r0 = null;
            goto L9
        }

        public boolean showSessionForActiveService(Bundle args, int sourceFlags, String attributionTag, IVoiceInteractionSessionShowCallback showCallback, IBinder activityToken) {
            super.showSessionForActiveService_enforcePermission();
            monitor-enter(this);
        L25:
            th = th;
        L35:
            monitor-exit(this);     // Catch: Throwable -> L25
            throw th;
        L33:
            th = th;
            goto L35
        L37:
            if (this.mImpl != null) goto L13;
            Slog.w(VoiceInteractionManagerService.TAG, "showSessionForActiveService without running voice interactionservice");     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            return false;
        L13:
            if (this.mTemporarilyDisabled == false) goto L17;
            Slog.i(VoiceInteractionManagerService.TAG, "showSessionForActiveService(): ignored while temporarily disabled");     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
            return false;
        L17:
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L33
            HotwordMetricsLogger.cancelHotwordTriggerToUiLatencySession(this.this$0.mContext);     // Catch: Throwable -> L29
            this.this$0.getObricExt().fillActiveServiceDisplayId(args);     // Catch: Throwable -> L29
            int finalFlags = this.this$0.getObricExt().adjustSessionSourceFlags(args, sourceFlags);     // Catch: Throwable -> L29
            boolean r10 = this.mImpl.showSessionLocked(args, finalFlags, attributionTag, showCallback, activityToken);     // Catch: Throwable -> L27
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L25
            monitor-exit(this);     // Catch: Throwable -> L25
            return r10;
        L27:
            th = move-exception;
            Throwable r11 = th;
        L31:
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L25
            throw r11;     // Catch: Throwable -> L25
        L29:
            th = move-exception;
            r11 = th;
        L10:
            th = th;
            goto L35
        }

        public void hideCurrentSession() throws RemoteException {
            super.hideCurrentSession_enforcePermission();
            if (this.mImpl != null) goto L5;
            return;
        L5:
            long caller = Binder.clearCallingIdentity();
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);
            throw th;
        L7:
            if (this.mImpl.mActiveSession != null) goto L9;
        L16:
            Binder.restoreCallingIdentity(caller);
            return;
        L9:
            if (this.mImpl.mActiveSession.mSession == null) goto L16;
            this.mImpl.mActiveSession.mSession.closeSystemDialogs();     // Catch: Throwable -> L12 RemoteException -> L14
        L14:
            e = move-exception;
            Log.w(VoiceInteractionManagerService.TAG, "Failed to call closeSystemDialogs", e);     // Catch: Throwable -> L12
            goto L16
        }

        public void launchVoiceAssistFromKeyguard() {
            super.launchVoiceAssistFromKeyguard_enforcePermission();
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mImpl != null) goto L11;
            Slog.w(VoiceInteractionManagerService.TAG, "launchVoiceAssistFromKeyguard without running voice interactionservice");     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return;
        L11:
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
            this.mImpl.launchVoiceAssistFromKeyguard();     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        }

        public boolean isSessionRunning() {
            super.isSessionRunning_enforcePermission();
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mImpl != null) goto L7;
        L11:
            boolean r0 = false;
        L12:
            monitor-exit(this);     // Catch: Throwable -> L9
            return r0;
        L7:
            if (this.mImpl.mActiveSession == null) goto L11;
            r0 = true;
            goto L12
        }

        public boolean activeServiceSupportsAssist() {
            super.activeServiceSupportsAssist_enforcePermission();
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.mImpl != null) goto L7;
        L13:
            boolean r0 = false;
        L14:
            monitor-exit(this);     // Catch: Throwable -> L11
            return r0;
        L7:
            if (this.mImpl.mInfo == null) goto L13;
            if (this.mImpl.mInfo.getSupportsAssist() == false) goto L13;
            r0 = true;
            goto L14
        }

        public boolean activeServiceSupportsLaunchFromKeyguard() throws RemoteException {
            super.activeServiceSupportsLaunchFromKeyguard_enforcePermission();
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.mImpl != null) goto L7;
        L13:
            boolean r0 = false;
        L14:
            monitor-exit(this);     // Catch: Throwable -> L11
            return r0;
        L7:
            if (this.mImpl.mInfo == null) goto L13;
            if (this.mImpl.mInfo.getSupportsLaunchFromKeyguard() == false) goto L13;
            r0 = true;
            goto L14
        }

        public void onLockscreenShown() {
            super.onLockscreenShown_enforcePermission();
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mImpl != null) goto L10;
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L8
        L17:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        L12:
            if (this.mImpl.mActiveSession != null) goto L14;
        L21:
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L14:
            if (this.mImpl.mActiveSession.mSession == null) goto L21;
            this.mImpl.mActiveSession.mSession.onLockscreenShown();     // Catch: Throwable -> L17 RemoteException -> L19
        L19:
            e = move-exception;
            Log.w(VoiceInteractionManagerService.TAG, "Failed to call onLockscreenShown", e);     // Catch: Throwable -> L17
            goto L21
        }

        public void registerVoiceInteractionSessionListener(IVoiceInteractionSessionListener listener) {
            super.registerVoiceInteractionSessionListener_enforcePermission();
            monitor-enter(this);
            VoiceInteractionManagerService.m9415$$Nest$fgetmVoiceInteractionSessionListeners(this.this$0).register(listener);     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void getActiveServiceSupportedActions(List<String> voiceActions, IVoiceActionCheckCallback callback) {
            super.getActiveServiceSupportedActions_enforcePermission();
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mImpl == null) goto L26;
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
            this.mImpl.getActiveServiceSupportedActions(voiceActions, callback);     // Catch: Throwable -> L19
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return;
        L19:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        L26:
            callback.onComplete(null);     // Catch: Throwable -> L9 RemoteException -> L11
        L12:
            monitor-exit(this);     // Catch: Throwable -> L9
        }

        public void onSessionShown() {
            monitor-enter(this);
            int size = VoiceInteractionManagerService.m9415$$Nest$fgetmVoiceInteractionSessionListeners(this.this$0).beginBroadcast();     // Catch: Throwable -> L8
            int i = 0;
        L4:
            if (i >= size) goto L13;
            IVoiceInteractionSessionListener listener = VoiceInteractionManagerService.m9415$$Nest$fgetmVoiceInteractionSessionListeners(this.this$0).getBroadcastItem(i);     // Catch: Throwable -> L8
            listener.onVoiceSessionShown();     // Catch: Throwable -> L8 RemoteException -> L10
        L12:
            i = i + 1;     // Catch: Throwable -> L8
        L10:
            e = move-exception;
            Slog.e(VoiceInteractionManagerService.TAG, "Error delivering voice interaction open event.", e);     // Catch: Throwable -> L8
            goto L12
        L13:
            VoiceInteractionManagerService.m9415$$Nest$fgetmVoiceInteractionSessionListeners(this.this$0).finishBroadcast();     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void onSessionHidden() {
            monitor-enter(this);
            int size = VoiceInteractionManagerService.m9415$$Nest$fgetmVoiceInteractionSessionListeners(this.this$0).beginBroadcast();     // Catch: Throwable -> L8
            int i = 0;
        L4:
            if (i >= size) goto L13;
            IVoiceInteractionSessionListener listener = VoiceInteractionManagerService.m9415$$Nest$fgetmVoiceInteractionSessionListeners(this.this$0).getBroadcastItem(i);     // Catch: Throwable -> L8
            listener.onVoiceSessionHidden();     // Catch: Throwable -> L8 RemoteException -> L10
        L12:
            i = i + 1;     // Catch: Throwable -> L8
        L10:
            e = move-exception;
            Slog.e(VoiceInteractionManagerService.TAG, "Error delivering voice interaction closed event.", e);     // Catch: Throwable -> L8
            goto L12
        L13:
            VoiceInteractionManagerService.m9415$$Nest$fgetmVoiceInteractionSessionListeners(this.this$0).finishBroadcast();     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void setSessionWindowVisible(IBinder token, final boolean visible) {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl != null) goto L11;
            Slog.w(VoiceInteractionManagerService.TAG, "setSessionWindowVisible called without running voice interaction service");     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L11:
            if (this.mImpl.mActiveSession == null) goto L23;
            if (token != this.mImpl.mActiveSession.mToken) goto L23;
            long caller = Binder.clearCallingIdentity();     // Catch: Throwable -> L8
            VoiceInteractionManagerService.m9415$$Nest$fgetmVoiceInteractionSessionListeners(this.this$0).broadcast(new VoiceInteractionManagerService$VoiceInteractionManagerServiceStub$$ExternalSyntheticLambda1(visible));     // Catch: Throwable -> L20
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L20:
            th = move-exception;
            Binder.restoreCallingIdentity(caller);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        L23:
            Slog.w(VoiceInteractionManagerService.TAG, "setSessionWindowVisible does not match active session");     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
        }

        private static /* synthetic */ void lambda$setSessionWindowVisible$7(boolean visible, IVoiceInteractionSessionListener listener) {
            listener.onVoiceSessionWindowVisibilityChanged(visible);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.e(VoiceInteractionManagerService.TAG, "Error delivering window visibility event to listener.", e);
        }

        public boolean getAccessibilityDetectionEnabled() {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl != null) goto L11;
            Slog.w(VoiceInteractionManagerService.TAG, "registerAccessibilityDetectionSettingsListener called without running voice interaction service");     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return false;
        L11:
            boolean r0 = this.mImpl.getAccessibilityDetectionEnabled();     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            return r0;
        }

        public void registerAccessibilityDetectionSettingsListener(IVoiceInteractionAccessibilitySettingsListener listener) {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl != null) goto L10;
            Slog.w(VoiceInteractionManagerService.TAG, "registerAccessibilityDetectionSettingsListener called without running voice interaction service");     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            this.mImpl.registerAccessibilityDetectionSettingsListenerLocked(listener);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
        }

        public void unregisterAccessibilityDetectionSettingsListener(IVoiceInteractionAccessibilitySettingsListener listener) {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mImpl != null) goto L10;
            Slog.w(VoiceInteractionManagerService.TAG, "unregisterAccessibilityDetectionSettingsListener called without running voice interaction service");     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L10:
            this.mImpl.unregisterAccessibilityDetectionSettingsListenerLocked(listener);     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
        }

        public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.mContext, VoiceInteractionManagerService.TAG, pw) == true) goto L5;
            return;
        L5:
            monitor-enter(this);
            pw.println("VOICE INTERACTION MANAGER (dumpsys voiceinteraction)");     // Catch: Throwable -> L9
            pw.println("  mEnableService: " + this.mEnableService);     // Catch: Throwable -> L9
            pw.println("  mTemporarilyDisabled: " + this.mTemporarilyDisabled);     // Catch: Throwable -> L9
            pw.println("  mCurUser: " + this.mCurUser);     // Catch: Throwable -> L9
            pw.println("  mCurUserSupported: " + this.mCurUserSupported);     // Catch: Throwable -> L9
            pw.println("  mIsHdsRequired: " + this.IS_HDS_REQUIRED);     // Catch: Throwable -> L9
            VoiceInteractionManagerService.access$000(this.this$0, pw, "  ");     // Catch: Throwable -> L9
            VoiceInteractionManagerService.m9410$$Nest$fgetmDbHelper(this.this$0).dump(pw);     // Catch: Throwable -> L9
            if (this.mImpl != null) goto L11;
            pw.println("  (No active implementation)");     // Catch: Throwable -> L9
        L12:
            monitor-exit(this);     // Catch: Throwable -> L9
            return;
        L11:
            this.mImpl.dumpLocked(fd, pw, args);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new VoiceInteractionManagerServiceShellCommand(VoiceInteractionManagerService.m9412$$Nest$fgetmServiceStub(this.this$0)).exec(this, in, out, err, args, callback, resultReceiver);
        }

        public void setUiHints(Bundle hints) {
            monitor-enter(this);
            enforceIsCurrentVoiceInteractionService();     // Catch: Throwable -> L8
            int size = VoiceInteractionManagerService.m9415$$Nest$fgetmVoiceInteractionSessionListeners(this.this$0).beginBroadcast();     // Catch: Throwable -> L8
            int i = 0;
        L4:
            if (i >= size) goto L13;
            IVoiceInteractionSessionListener listener = VoiceInteractionManagerService.m9415$$Nest$fgetmVoiceInteractionSessionListeners(this.this$0).getBroadcastItem(i);     // Catch: Throwable -> L8
            listener.onSetUiHints(hints);     // Catch: Throwable -> L8 RemoteException -> L10
        L12:
            i = i + 1;     // Catch: Throwable -> L8
        L10:
            e = move-exception;
            Slog.e(VoiceInteractionManagerService.TAG, "Error delivering UI hints.", e);     // Catch: Throwable -> L8
            goto L12
        L13:
            VoiceInteractionManagerService.m9415$$Nest$fgetmVoiceInteractionSessionListeners(this.this$0).finishBroadcast();     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private boolean isCallerHoldingPermission(String permission) {
            if (this.this$0.mContext.checkCallingOrSelfPermission(permission) != 0) goto L5;
            return true;
        L5:
            return false;
        }

        private void enforceCallingPermission(String permission) {
            if (isCallerHoldingPermission(permission) == false) goto L6;
            return;
        L6:
            throw new SecurityException("Caller does not hold the permission " + permission);
        }

        private void enforceIsCurrentVoiceInteractionService() {
            if (isCallerCurrentVoiceInteractionService() == false) goto L6;
            return;
        L6:
            throw new SecurityException("Caller is not the current voice interaction service");
        }

        private void enforceIsCallerPreinstalledAssistant() {
            if (isCallerPreinstalledAssistant() == false) goto L6;
            return;
        L6:
            throw new SecurityException("Caller is not the pre-installed assistant.");
        }

        private void enforceCallerAllowedToEnrollVoiceModel() {
            if (isCallerHoldingPermission("android.permission.KEYPHRASE_ENROLLMENT_APPLICATION") == false) goto L5;
            return;
        L5:
            enforceCallingPermission("android.permission.MANAGE_VOICE_KEYPHRASES");
            enforceIsCurrentVoiceInteractionService();
        }

        private boolean isCallerCurrentVoiceInteractionService() {
            if (this.mImpl != null) goto L5;
        L7:
            return false;
        L5:
            if (this.mImpl.mInfo.getServiceInfo().applicationInfo.uid != Binder.getCallingUid()) goto L7;
            return true;
        }

        private boolean isCallerPreinstalledAssistant() {
            if (this.mImpl != null) goto L5;
        L11:
            return false;
        L5:
            if (this.mImpl.getApplicationInfo().uid != Binder.getCallingUid()) goto L11;
            if (this.mImpl.getApplicationInfo().isSystemApp() == false) goto L9;
        L10:
            return true;
        L9:
            if (this.mImpl.getApplicationInfo().isUpdatedSystemApp() == false) goto L11;
            goto L10
        }

        private void setImplLocked(VoiceInteractionManagerServiceImpl impl) {
            this.mImpl = impl;
            this.this$0.mAtmInternal.notifyActiveVoiceInteractionServiceChanged(getActiveServiceComponentName());
        }

        private IRecognitionStatusCallback createSoundTriggerCallbackLocked(IHotwordRecognitionStatusCallback callback, Identity voiceInteractorIdentity) {
            if (this.mImpl != null) goto L7;
            return null;
        L7:
            return this.mImpl.createSoundTriggerCallbackLocked(this.this$0.mContext, callback, voiceInteractorIdentity);
        }

        private void resetServicesIfNoRecognitionService(ComponentName serviceComponent, int userHandle) {
            Iterator<ResolveInfo> r0 = queryInteractorServices(userHandle, serviceComponent.getPackageName()).iterator();
        L4:
            if (r0.hasNext() == false) goto L12;
            ResolveInfo resolveInfo = r0.next();
            VoiceInteractionServiceInfo serviceInfo = new VoiceInteractionServiceInfo(this.this$0.mContext.getPackageManager(), resolveInfo.serviceInfo);
            if (serviceInfo.getSupportsAssist() == false) goto L4;
            if (serviceInfo.getRecognitionService() != null) goto L4;
            Slog.e(VoiceInteractionManagerService.TAG, "The RecognitionService must be set to avoid boot loop on earlier platform version. Also make sure that this is a valid RecognitionService when running on Android 11 or earlier.");
            setCurInteractor(null, userHandle);
            resetCurAssistant(userHandle);
            goto L4
        }

        private Intent getContextualSearchIntent(Bundle args) {
            String csPkgName = this.this$0.mContext.getResources().getString(R.string.config_dozeDoubleTapSensorType);
            Bitmap bm = null;
            if (csPkgName.isEmpty() == false) goto L5;
            return null;
        L5:
            Intent launchIntent = new Intent(VoiceInteractionManagerService.CS_INTENT_FILTER);
            launchIntent.setPackage(csPkgName);
            ResolveInfo resolveInfo = this.this$0.mContext.getPackageManager().resolveActivity(launchIntent, 2097152);
            if (resolveInfo != null) goto L8;
            return null;
        L8:
            launchIntent.setComponent(resolveInfo.getComponentInfo().getComponentName());
            launchIntent.addFlags(268795904);
            launchIntent.putExtras(args);
            boolean isAssistDataAllowed = this.this$0.mAtmInternal.isAssistDataAllowed();
            List<ActivityAssistInfo> records = this.this$0.mAtmInternal.getTopVisibleActivities();
            ArrayList<String> visiblePackageNames = new ArrayList();
            boolean isManagedProfileVisible = false;
            Iterator<ActivityAssistInfo> r8 = records.iterator();
        L10:
            if (r8.hasNext() == false) goto L20;
            ActivityAssistInfo record = r8.next();
            if (isAssistDataAllowed == false) goto L15;
            visiblePackageNames.add(record.getComponentName().getPackageName());
        L15:
            if (this.this$0.mDpmInternal == null) goto L10;
            if (this.this$0.mDpmInternal.isUserOrganizationManaged(record.getUserId()) == false) goto L10;
            isManagedProfileVisible = true;
            goto L10
        L20:
            ScreenCapture.ScreenshotHardwareBuffer shb = this.this$0.mWmInternal.takeAssistScreenshot();
            if (shb == null) goto L23;
            bm = shb.asBitmap();
        L23:
            if (bm == null) goto L27;
            launchIntent.putExtra(VoiceInteractionManagerService.CS_KEY_FLAG_SECURE_FOUND, shb.containsSecureLayers());
            if (isAssistDataAllowed == false) goto L27;
            launchIntent.putExtra(VoiceInteractionManagerService.CS_KEY_FLAG_SCREENSHOT, bm.asShared());
        L27:
            launchIntent.putExtra(VoiceInteractionManagerService.CS_KEY_FLAG_IS_MANAGED_PROFILE_VISIBLE, isManagedProfileVisible);
            if (isAssistDataAllowed == false) goto L30;
            launchIntent.putExtra(VoiceInteractionManagerService.CS_KEY_FLAG_VISIBLE_PACKAGE_NAMES, visiblePackageNames);
        L30:
            return launchIntent;
        }

        private boolean startContextualSearch(Intent launchIntent, int userId) {
            ActivityOptions opts = ActivityOptions.makeCustomTaskAnimation(this.this$0.mContext, 0, 0, null, null, null);
            opts.setDisableStartingWindow(true);
            int resultCode = this.this$0.mAtmInternal.startActivityWithScreenshot(launchIntent, this.this$0.mContext.getPackageName(), Binder.getCallingUid(), Binder.getCallingPid(), null, opts.toBundle(), userId);
            if (resultCode == 0) goto L7;
            return false;
        L7:
            return true;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDbHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ IEnrolledModelDb m9410$$Nest$fgetmDbHelper(VoiceInteractionManagerService r0) {
        return r0.mDbHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRealDbHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ IEnrolledModelDb m9411$$Nest$fgetmRealDbHelper(VoiceInteractionManagerService r0) {
        return r0.mRealDbHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServiceStub, reason: not valid java name */
    static /* bridge */ /* synthetic */ VoiceInteractionManagerServiceStub m9412$$Nest$fgetmServiceStub(VoiceInteractionManagerService r0) {
        return r0.mServiceStub;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVIMSExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IVoiceInteractionManagerServiceExt m9413$$Nest$fgetmVIMSExt(VoiceInteractionManagerService r0) {
        return r0.mVIMSExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVisualQueryRecognitionStatusListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ IVisualQueryRecognitionStatusListener m9414$$Nest$fgetmVisualQueryRecognitionStatusListener(VoiceInteractionManagerService r0) {
        return r0.mVisualQueryRecognitionStatusListener;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVoiceInteractionSessionListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallbackList m9415$$Nest$fgetmVoiceInteractionSessionListeners(VoiceInteractionManagerService r0) {
        return r0.mVoiceInteractionSessionListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDbHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9416$$Nest$fputmDbHelper(VoiceInteractionManagerService r0, IEnrolledModelDb r1) {
        r0.mDbHelper = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmVisualQueryRecognitionStatusListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9417$$Nest$fputmVisualQueryRecognitionStatusListener(VoiceInteractionManagerService r0, IVisualQueryRecognitionStatusListener r1) {
        r0.mVisualQueryRecognitionStatusListener = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$misUserSupported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9418$$Nest$misUserSupported(VoiceInteractionManagerService r0, UserInfo r1) {
        return r0.isUserSupported(r1);
    }

    static /* synthetic */ void access$000(VoiceInteractionManagerService x0, PrintWriter x1, String x2) {
        x0.dumpSupportedUsers(x1, x2);
    }

    public VoiceInteractionManagerService(Context context) {
        super(context);
        this.mLoadedKeyphraseIds = new ArrayMap();
        this.mVoiceInteractionSessionListeners = new RemoteCallbackList();
        this.mObricExt = (IObricVoiceInteractionManagerService) ObricImplFactory.getImpl(IObricVoiceInteractionManagerService.class, new Object[]{this});
        this.mLatencyLoggingListener = new AnonymousClass3(this);
        this.mContext = context;
        this.mResolver = context.getContentResolver();
        UserManagerInternal r0 = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        r0.getClass();
        this.mUserManagerInternal = r0;
        DatabaseHelper r1 = new DatabaseHelper(context);
        this.mRealDbHelper = r1;
        this.mDbHelper = r1;
        this.mServiceStub = new VoiceInteractionManagerServiceStub(this);
        ActivityManagerInternal r2 = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        r2.getClass();
        this.mAmInternal = r2;
        ActivityTaskManagerInternal r3 = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        r3.getClass();
        this.mAtmInternal = r3;
        WindowManagerInternal r4 = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        r4.getClass();
        this.mWmInternal = r4;
        this.mDpmInternal = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        LegacyPermissionManagerInternal permissionManagerInternal = (LegacyPermissionManagerInternal) LocalServices.getService(LegacyPermissionManagerInternal.class);
        permissionManagerInternal.setVoiceInteractionPackagesProvider(new AnonymousClass1(this));
        this.mVIMSExt = IVoiceInteractionManagerServiceExt.get(this);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("voiceinteraction", this.mServiceStub);
        publishLocalService(VoiceInteractionManagerInternal.class, new LocalService(this));
        this.mAmInternal.setVoiceInteractionManagerProvider(new AnonymousClass2(this));
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (500 != phase) goto L6;
        ShortcutServiceInternal r0 = (ShortcutServiceInternal) LocalServices.getService(ShortcutServiceInternal.class);
        r0.getClass();
        this.mShortcutServiceInternal = r0;
        this.mSoundTriggerInternal = (SoundTriggerInternal) LocalServices.getService(SoundTriggerInternal.class);
        return;
    L6:
        if (phase != 600) goto L9;
        this.mServiceStub.systemRunning(isSafeMode());
        return;
    L9:
        if (phase != 1000) goto L14;
        this.mServiceStub.registerVoiceInteractionSessionListener(this.mLatencyLoggingListener);
        return;
    }

    @Override // com.android.server.SystemService
    public boolean isUserSupported(SystemService.TargetUser user) {
        return user.isFull();
    }

    private boolean isUserSupported(UserInfo user) {
        return user.isFull();
    }

    @Override // com.android.server.SystemService
    public void onUserStarting(SystemService.TargetUser user) {
        this.mServiceStub.initForUser(user.getUserIdentifier());
    }

    @Override // com.android.server.SystemService
    public void onUserUnlocking(SystemService.TargetUser user) {
        this.mServiceStub.initForUser(user.getUserIdentifier());
        this.mServiceStub.switchImplementationIfNeeded(false);
    }

    @Override // com.android.server.SystemService
    public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
        this.mServiceStub.switchUser(to.getUserIdentifier());
    }

    public IObricVoiceInteractionManagerService getObricExt() {
        return this.mObricExt;
    }
}
