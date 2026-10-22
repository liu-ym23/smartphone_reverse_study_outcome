package com.android.server.dreams;

import android.R;
import android.app.ActivityManager;
import android.app.IAppTask;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ServiceInfo;
import android.database.ContentObserver;
import android.hardware.display.AmbientDisplayConfiguration;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.BatteryManagerInternal;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManagerInternal;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.service.dreams.DreamManagerInternal;
import android.service.dreams.IDreamManager;
import android.text.TextUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.view.Display;
import com.android.internal.content.PackageMonitor;
import com.android.internal.logging.UiEventLogger;
import com.android.internal.logging.UiEventLoggerImpl;
import com.android.internal.util.DumpUtils;
import com.android.server.LocalServices;
import com.android.server.ServiceThread;
import com.android.server.SystemService;
import com.android.server.input.InputManagerInternal;
import com.android.server.pm.UserManagerInternal;
import com.android.server.wm.ActivityInterceptorCallback;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final class DreamManagerService extends SystemService {
    private static final String AUTO_AOD_BRIGHTNESS = "21,128,255";
    private static final String AUTO_AOD_BRIGHTNE_KEY = "persist.sys.aod.brightness";
    private static final String AUTO_AOD_SMOOTH_BRIGHTNESS = "21,64,128,192,255";
    private static final boolean DEBUG = true;
    private static final String DOZE_WAKE_LOCK_TAG = "dream:doze";
    private static final int DREAM_DISABLED = 0;
    private static final int DREAM_ON_CHARGE = 2;
    private static final int DREAM_ON_DOCK = 1;
    private static final int DREAM_ON_POSTURED = 4;
    private static final String DREAM_WAKE_LOCK_TAG = "dream:dream";
    private static final String TAG = "DreamManagerService";
    private final ActivityInterceptorCallback mActivityInterceptorCallback;
    private final ComponentName mAmbientDisplayComponent;
    private final ActivityTaskManagerInternal mAtmInternal;
    private final BatteryManagerInternal mBatteryManagerInternal;
    private final BroadcastReceiver mChargingReceiver;
    private final Context mContext;
    private final DreamController mController;
    private final DreamController.Listener mControllerListener;
    private DreamRecord mCurrentDream;
    private final boolean mDismissDreamOnActivityStart;
    private final BroadcastReceiver mDockStateReceiver;
    private final AmbientDisplayConfiguration mDozeConfig;
    private final ContentObserver mDozeEnabledObserver;
    private final PowerManager.WakeLock mDozeWakeLock;
    private final CopyOnWriteArrayList<DreamManagerInternal.DreamManagerStateListener> mDreamManagerStateListeners;
    private ComponentName mDreamOverlayServiceName;
    private final DreamUiEventLogger mDreamUiEventLogger;
    private final boolean mDreamsActivatedOnChargeByDefault;
    private final boolean mDreamsActivatedOnDockByDefault;
    private final boolean mDreamsActivatedOnPosturedByDefault;
    private final boolean mDreamsDisabledByAmbientModeSuppressionConfig;
    private final boolean mDreamsEnabledByDefaultConfig;
    private boolean mDreamsEnabledSetting;
    private final boolean mDreamsOnlyEnabledForDockUser;
    private boolean mForceAmbientDisplayEnabled;
    private final Handler mHandler;
    private ServiceThread mHandlerThread;
    private boolean mIsCharging;
    private boolean mIsDocked;
    private boolean mIsPostured;
    private final boolean mKeepDreamingWhenUnpluggingDefault;
    private final Object mLock;
    private final SparseArray<PackageMonitor> mPackageMonitors;
    private final PackageManagerInternal mPmInternal;
    private final PowerManager mPowerManager;
    private final PowerManagerInternal mPowerManagerInternal;
    private SettingsObserver mSettingsObserver;
    private ComponentName mSystemDreamComponent;
    private final Runnable mSystemPropertiesChanged;
    private final UiEventLogger mUiEventLogger;
    private final UserManager mUserManager;
    private int mWhenToDream;

    private final class BinderService extends IDreamManager.Stub {
        final /* synthetic */ DreamManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$Kot4oQHonmynVtZKmfng-m1yYDI, reason: not valid java name */
        public static /* synthetic */ void m4216$r8$lambda$Kot4oQHonmynVtZKmfngm1yYDI(BinderService r0, boolean r1) {
            r0.lambda$setDreamIsObscured$1(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$oS7eqgnpGoVyGkh-XYJl1mJb8_k, reason: not valid java name */
        public static /* synthetic */ void m4217$r8$lambda$oS7eqgnpGoVyGkhXYJl1mJb8_k(BinderService r0, Intent r1, int r2, int r3) {
            r0.lambda$startDreamActivity$0(r1, r2, r3);
        }

        /* synthetic */ BinderService(DreamManagerService r1, DreamManagerServiceIA r2) {
            this(r1);
        }

        private BinderService(DreamManagerService r1) {
            this.this$0 = r1;
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(DreamManagerService.m4177$$Nest$fgetmContext(this.this$0), DreamManagerService.TAG, pw) == true) goto L5;
            return;
        L5:
            long ident = Binder.clearCallingIdentity();
            DreamManagerService.m4192$$Nest$mdumpInternal(this.this$0, pw);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(ident);
            return;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) throws RemoteException {
            new DreamShellCommand(this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }

        public ComponentName[] getDreamComponents() {
            return getDreamComponentsForUser(UserHandle.getCallingUserId());
        }

        public ComponentName[] getDreamComponentsForUser(int userId) {
            DreamManagerService.m4190$$Nest$mcheckPermission(this.this$0, "android.permission.READ_DREAM_STATE");
            int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, true, "getDreamComponents", null);
            long ident = Binder.clearCallingIdentity();
            ComponentName[] r0 = DreamManagerService.m4197$$Nest$mgetDreamComponentsForUser(this.this$0, userId2);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r0;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void setDreamComponents(ComponentName[] componentNames) {
            DreamManagerService.m4190$$Nest$mcheckPermission(this.this$0, "android.permission.WRITE_DREAM_STATE");
            int userId = UserHandle.getCallingUserId();
            long ident = Binder.clearCallingIdentity();
            setDreamComponentsForUser(userId, componentNames);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void setDreamComponentsForUser(int userId, ComponentName[] componentNames) {
            DreamManagerService.m4190$$Nest$mcheckPermission(this.this$0, "android.permission.WRITE_DREAM_STATE");
            int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, true, "setDreamComponents", null);
            long ident = Binder.clearCallingIdentity();
            DreamManagerService.m4204$$Nest$msetDreamComponentsForUser(this.this$0, userId2, componentNames);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void setSystemDreamComponent(ComponentName componentName) {
            DreamManagerService.m4190$$Nest$mcheckPermission(this.this$0, "android.permission.WRITE_DREAM_STATE");
            long ident = Binder.clearCallingIdentity();
            DreamManagerService.m4205$$Nest$msetSystemDreamComponentInternal(this.this$0, componentName);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void registerDreamOverlayService(ComponentName overlayComponent) {
            DreamManagerService.m4190$$Nest$mcheckPermission(this.this$0, "android.permission.WRITE_DREAM_STATE");
            DreamManagerService.m4186$$Nest$fputmDreamOverlayServiceName(this.this$0, overlayComponent);
        }

        public ComponentName getDefaultDreamComponentForUser(int userId) {
            DreamManagerService.m4190$$Nest$mcheckPermission(this.this$0, "android.permission.READ_DREAM_STATE");
            int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, true, "getDefaultDreamComponent", null);
            long ident = Binder.clearCallingIdentity();
            ComponentName r0 = DreamManagerService.m4195$$Nest$mgetDefaultDreamComponentForUser(this.this$0, userId2);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r0;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean isDreaming() {
            DreamManagerService.m4190$$Nest$mcheckPermission(this.this$0, "android.permission.READ_DREAM_STATE");
            long ident = Binder.clearCallingIdentity();
            boolean r2 = DreamManagerService.m4198$$Nest$misDreamingInternal(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean isDreamingOrInPreview() {
            DreamManagerService.m4190$$Nest$mcheckPermission(this.this$0, "android.permission.READ_DREAM_STATE");
            long ident = Binder.clearCallingIdentity();
            boolean r2 = DreamManagerService.m4199$$Nest$misDreamingOrInPreviewInternal(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void dream() {
            DreamManagerService.m4190$$Nest$mcheckPermission(this.this$0, "android.permission.WRITE_DREAM_STATE");
            long ident = Binder.clearCallingIdentity();
            DreamManagerService.m4203$$Nest$mrequestDreamInternal(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public boolean canStartDreaming(boolean isScreenOn) {
            DreamManagerService.m4190$$Nest$mcheckPermission(this.this$0, "android.permission.READ_DREAM_STATE");
            long ident = Binder.clearCallingIdentity();
            boolean r2 = DreamManagerService.m4189$$Nest$mcanStartDreamingInternal(this.this$0, isScreenOn);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void testDream(int userId, ComponentName dream) {
            if (dream == null) goto L15;
            DreamManagerService.m4190$$Nest$mcheckPermission(this.this$0, "android.permission.WRITE_DREAM_STATE");
            int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, true, "testDream", null);
            int currentUserId = ActivityManager.getCurrentUser();
            if (userId2 == currentUserId) goto L7;
            Slog.w(DreamManagerService.TAG, "Aborted attempt to start a test dream while a different  user is active: userId=" + userId2 + ", currentUserId=" + currentUserId);
            return;
        L7:
            long ident = Binder.clearCallingIdentity();
            DreamManagerService.m4212$$Nest$mtestDreamInternal(this.this$0, dream, userId2);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(ident);
            return;
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L15:
            throw new IllegalArgumentException("dream must not be null");
        }

        public void awaken() {
            DreamManagerService.m4190$$Nest$mcheckPermission(this.this$0, "android.permission.WRITE_DREAM_STATE");
            long ident = Binder.clearCallingIdentity();
            DreamManagerService.m4202$$Nest$mrequestAwakenInternal(this.this$0, "request awaken");     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void finishSelf(IBinder token, boolean immediate) {
            if (token == null) goto L11;
            long ident = Binder.clearCallingIdentity();
            DreamManagerService.m4193$$Nest$mfinishSelfInternal(this.this$0, token, immediate);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(ident);
            return;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L11:
            throw new IllegalArgumentException("token must not be null");
        }

        public void finishSelfOneway(IBinder token, boolean immediate) {
            if (token == null) goto L11;
            long ident = Binder.clearCallingIdentity();
            DreamManagerService.m4193$$Nest$mfinishSelfInternal(this.this$0, token, immediate);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(ident);
            return;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L11:
            throw new IllegalArgumentException("token must not be null");
        }

        public void startDozing(IBinder token, int screenState, int reason, float screenBrightnessFloat, int screeBrightnessInt, boolean useNormalBrightnessForDoze) {
            if (token == null) goto L11;
            Slog.d(DreamManagerService.TAG, "start dozing: " + token + ", pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + ", screenState=" + Display.stateToString(screenState) + ", reason=" + Display.stateReasonToString(reason) + ", screenBrightnessFloat=" + screenBrightnessFloat + ", screenBrightnessInt=" + screeBrightnessInt + ", useNormalBrightnessForDoze=" + useNormalBrightnessForDoze);
            long ident = Binder.clearCallingIdentity();
            DreamManagerService.m4208$$Nest$mstartDozingInternal(this.this$0, token, screenState, reason, screenBrightnessFloat, screeBrightnessInt, useNormalBrightnessForDoze);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(ident);
            return;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L11:
            throw new IllegalArgumentException("token must not be null");
        }

        public void startDozingOneway(IBinder token, int screenState, int reason, float screenBrightnessFloat, int screeBrightnessInt, boolean useNormalBrightnessForDoze) {
            if (token == null) goto L11;
            Slog.d(DreamManagerService.TAG, "start dozing oneWay: caller(" + Binder.getCallingPid() + "," + Binder.getCallingUid() + "), screenState=" + Display.stateToString(screenState) + ", reason=" + Display.stateReasonToString(reason) + ", screenBrightnessFloat=" + screenBrightnessFloat + ", screenBrightnessInt=" + screeBrightnessInt + ", useNormalBrightnessForDoze=" + useNormalBrightnessForDoze);
            long ident = Binder.clearCallingIdentity();
            DreamManagerService.m4208$$Nest$mstartDozingInternal(this.this$0, token, screenState, reason, screenBrightnessFloat, screeBrightnessInt, useNormalBrightnessForDoze);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(ident);
            return;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L11:
            throw new IllegalArgumentException("token must not be null");
        }

        public void stopDozing(IBinder token) {
            if (token == null) goto L11;
            Slog.d(DreamManagerService.TAG, "stop dozing: " + token + ", pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid());
            long ident = Binder.clearCallingIdentity();
            DreamManagerService.m4210$$Nest$mstopDozingInternal(this.this$0, token);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(ident);
            return;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L11:
            throw new IllegalArgumentException("token must not be null");
        }

        public void forceAmbientDisplayEnabled(boolean enabled) {
            DreamManagerService.m4190$$Nest$mcheckPermission(this.this$0, "android.permission.DEVICE_POWER");
            long ident = Binder.clearCallingIdentity();
            DreamManagerService.m4194$$Nest$mforceAmbientDisplayEnabledInternal(this.this$0, enabled);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void startDreamActivity(final Intent intent) {
            final int callingUid = Binder.getCallingUid();
            final int callingPid = Binder.getCallingPid();
            DreamManagerService.m4181$$Nest$fgetmHandler(this.this$0).post(new DreamManagerService$BinderService$$ExternalSyntheticLambda0(this, intent, callingUid, callingPid));
        }

        private /* synthetic */ void lambda$startDreamActivity$0(Intent intent, int callingUid, int callingPid) {
            Object r0 = DreamManagerService.m4182$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (DreamManagerService.m4179$$Nest$fgetmCurrentDream(this.this$0) != null) goto L11;
            Slog.e(DreamManagerService.TAG, "Attempt to start DreamActivity, but the device is not dreaming. Aborting without starting the DreamActivity.");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            Binder dreamToken = DreamManagerService.m4179$$Nest$fgetmCurrentDream(this.this$0).token;     // Catch: Throwable -> L9
            String dreamPackageName = DreamManagerService.m4179$$Nest$fgetmCurrentDream(this.this$0).name.getPackageName();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            if (canLaunchDreamActivity(dreamPackageName, intent.getPackage(), callingUid) == true) goto L17;
            Slog.e(DreamManagerService.TAG, "The dream activity can be started only when the device is dreaming and only by the active dream package.");
            return;
        L17:
            IAppTask appTask = DreamManagerService.m4175$$Nest$fgetmAtmInternal(this.this$0).startDreamActivity(intent, callingUid, callingPid);
            if (appTask != null) goto L21;
            Slog.e(DreamManagerService.TAG, "Could not start dream activity.");
            DreamManagerService.m4211$$Nest$mstopDreamInternal(this.this$0, true, "DreamActivity not started");
            return;
        L21:
            DreamManagerService.m4178$$Nest$fgetmController(this.this$0).setDreamAppTask(dreamToken, appTask);
        }

        public void setDreamIsObscured(final boolean isObscured) {
            DreamManagerService.m4190$$Nest$mcheckPermission(this.this$0, "android.permission.WRITE_DREAM_STATE");
            long ident = Binder.clearCallingIdentity();
            DreamManagerService.m4181$$Nest$fgetmHandler(this.this$0).post(new DreamManagerService$BinderService$$ExternalSyntheticLambda1(this, isObscured));     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        private /* synthetic */ void lambda$setDreamIsObscured$1(boolean isObscured) {
            DreamManagerService.m4178$$Nest$fgetmController(this.this$0).setDreamIsObscured(isObscured);
        }

        public void setDevicePostured(boolean isPostured) {
        }

        public void setScreensaverEnabled(boolean enabled) {
            DreamManagerService.m4190$$Nest$mcheckPermission(this.this$0, "android.permission.WRITE_SECURE_SETTINGS");
            UserHandle userHandle = IDreamManager.Stub.getCallingUserHandle();
            long ident = Binder.clearCallingIdentity();
            ContentResolver r3 = DreamManagerService.m4177$$Nest$fgetmContext(this.this$0).getContentResolver();     // Catch: Throwable -> L10
            if (enabled == false) goto L6;
            int r5 = 1;
        L7:
            Settings.Secure.putIntForUser(r3, "screensaver_enabled", r5, userHandle.getIdentifier());     // Catch: Throwable -> L10
            DreamManagerService.m4185$$Nest$fgetmPowerManagerInternal(this.this$0).updateSettings();     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            r5 = 0;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        boolean canLaunchDreamActivity(String dreamPackageName, String packageName, int callingUid) {
            if (dreamPackageName == null) goto L16;
            if (packageName == null) goto L16;
            if (DreamManagerService.m4183$$Nest$fgetmPmInternal(this.this$0).isSameApp(packageName, callingUid, UserHandle.getUserId(callingUid)) == true) goto L11;
            Slog.e(DreamManagerService.TAG, "Cannot launch dream activity because package=" + packageName + " does not match callingUid=" + callingUid);
            return false;
        L11:
            if (packageName.equals(dreamPackageName) == false) goto L14;
            return true;
        L14:
            Slog.e(DreamManagerService.TAG, "Dream packageName does not match active dream. Package " + packageName + " does not match " + dreamPackageName);
            return false;
        L16:
            Slog.e(DreamManagerService.TAG, "Cannot launch dream activity due to invalid state. dream component= " + dreamPackageName + ", packageName=" + packageName);
            return false;
        }
    }

    private static final class DreamHandler extends Handler {
        public DreamHandler(Looper looper) {
            super(looper, null, true);
        }
    }

    private static final class DreamRecord {
        public final boolean canDoze;
        public int dozeScreenBrightness;
        public float dozeScreenBrightnessFloat;
        public int dozeScreenState;
        public boolean isDozing;
        public final boolean isPreview;
        public boolean isWaking;
        public final ComponentName name;
        public final Binder token;
        public final int userId;

        DreamRecord(ComponentName name, int userId, boolean isPreview, boolean canDoze) {
            this.token = new Binder();
            this.isDozing = false;
            this.isWaking = false;
            this.dozeScreenState = 0;
            this.dozeScreenBrightness = -1;
            this.dozeScreenBrightnessFloat = Float.NaN;
            this.name = name;
            this.userId = userId;
            this.isPreview = isPreview;
            this.canDoze = canDoze;
        }

        public String toString() {
            return "DreamRecord{token=" + this.token + ", name=" + this.name + ", userId=" + this.userId + ", isPreview=" + this.isPreview + ", canDoze=" + this.canDoze + ", isDozing=" + this.isDozing + ", isWaking=" + this.isWaking + ", dozeScreenState=" + this.dozeScreenState + ", dozeScreenBrightness=" + this.dozeScreenBrightness + ", dozeScreenBrightnessFloat=" + this.dozeScreenBrightnessFloat + '}';
        }
    }

    private final class LocalService extends DreamManagerInternal {
        final /* synthetic */ DreamManagerService this$0;

        /* synthetic */ LocalService(DreamManagerService r1, DreamManagerServiceIA r2) {
            this(r1);
        }

        private LocalService(DreamManagerService r1) {
            this.this$0 = r1;
        }

        public void startDream(boolean doze, String reason) {
            DreamManagerService.m4209$$Nest$mstartDreamInternal(this.this$0, doze, reason);
        }

        public void stopDream(boolean immediate, String reason) {
            DreamManagerService.m4211$$Nest$mstopDreamInternal(this.this$0, immediate, reason);
        }

        public boolean isDreaming() {
            return DreamManagerService.m4198$$Nest$misDreamingInternal(this.this$0);
        }

        public boolean canStartDreaming(boolean isScreenOn) {
            return DreamManagerService.m4189$$Nest$mcanStartDreamingInternal(this.this$0, isScreenOn);
        }

        public boolean dreamConditionActive() {
            return this.this$0.dreamConditionActiveInternal();
        }

        public void requestDream() {
            DreamManagerService.m4203$$Nest$mrequestDreamInternal(this.this$0);
        }

        public void registerDreamManagerStateListener(DreamManagerInternal.DreamManagerStateListener listener) {
            DreamManagerService.m4180$$Nest$fgetmDreamManagerStateListeners(this.this$0).add(listener);
            listener.onKeepDreamingWhenUnpluggingChanged(DreamManagerService.m4207$$Nest$mshouldKeepDreamingWhenUnplugging(this.this$0));
        }

        public void unregisterDreamManagerStateListener(DreamManagerInternal.DreamManagerStateListener listener) {
            DreamManagerService.m4180$$Nest$fgetmDreamManagerStateListeners(this.this$0).remove(listener);
        }

        public void setWindowsBackgroundDrawable(int value) {
            DreamManagerService.m4206$$Nest$msetWindowsBackgroundDrawableInternal(this.this$0, value);
        }
    }

    private final class PerUserPackageMonitor extends PackageMonitor {
        final /* synthetic */ DreamManagerService this$0;

        /* synthetic */ PerUserPackageMonitor(DreamManagerService r1, DreamManagerServiceIA r2) {
            this(r1);
        }

        private PerUserPackageMonitor(DreamManagerService r1) {
            this.this$0 = r1;
        }

        public void onPackageRemoved(String packageName, int uid) {
            super.onPackageRemoved(packageName, uid);
            int userId = getChangingUserId();
            DreamManagerService.m4213$$Nest$mupdateDreamOnPackageRemoved(this.this$0, packageName, userId);
        }
    }

    private final class SettingsObserver extends ContentObserver {
        final /* synthetic */ DreamManagerService this$0;

        SettingsObserver(DreamManagerService r1, Handler handler) {
            this.this$0 = r1;
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            DreamManagerService.m4214$$Nest$mupdateWhenToDreamSettings(this.this$0);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface WhenToDream {
    }

    public static /* synthetic */ void $r8$lambda$34m2PRuKMn6VEJYH0MoOlefw52w(DreamManagerService r0, SystemService.TargetUser r1) {
        r0.lambda$onUserStarting$1(r1);
    }

    public static /* synthetic */ ComponentName[] $r8$lambda$8kQpMJHyaaBcwsaFwBy_cBa6IeA(int r0) {
        return lambda$updateDreamOnPackageRemoved$10(r0);
    }

    public static /* synthetic */ void $r8$lambda$9tk70TRtbXjOR7FkzhKsDEbrHzo(DreamManagerService r0, boolean r1) {
        r0.lambda$setDevicePosturedInternal$8(r1);
    }

    public static /* synthetic */ void $r8$lambda$A9PeWP1dPt5WVlwRjqrAipwmJbQ(boolean r0, DreamManagerInternal.DreamManagerStateListener r1) {
        lambda$reportKeepDreamingWhenUnpluggingChanged$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$BRmfdgCI09tEXiZNrTJCdwkjb3Y(DreamManagerService r0, Consumer r1) {
        r0.lambda$notifyDreamStateListeners$7(r1);
    }

    public static /* synthetic */ void $r8$lambda$IDoG7T4C1Vl6xZBc_FzIHXmU54o(DreamManagerService r0) {
        r0.lambda$cleanupDreamLocked$13();
    }

    /* JADX INFO: renamed from: $r8$lambda$QjZPI7Qt3sOCMIpqUG-NcgDvtks, reason: not valid java name */
    public static /* synthetic */ void m4172$r8$lambda$QjZPI7Qt3sOCMIpqUGNcgDvtks(DreamManagerService r0, SystemService.TargetUser r1) {
        r0.lambda$onUserStopping$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$a8qAkvqZYpCclM2efAfxVuYowmY(DreamManagerInternal.DreamManagerStateListener r0) {
        lambda$reportDreamingStarted$5(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$cQJfjZl6T2DyWFLPoYS_AMBL8Rg(String r0, ComponentName r1) {
        return lambda$updateDreamOnPackageRemoved$9(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$hDNYLRSNlFyB5EWx8p8ITg3fSxA(DreamManagerInternal.DreamManagerStateListener r0) {
        lambda$reportDreamingStopped$6(r0);
    }

    public static /* synthetic */ void $r8$lambda$mjpYB2fEx6256Aox3LGr_sIvzA0(DreamManagerService r0) {
        r0.lambda$onUserSwitching$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$r6hfoT-w7HwqjeDW2NovxGVnwn0, reason: not valid java name */
    public static /* synthetic */ void m4173$r8$lambda$r6hfoTw7HwqjeDW2NovxGVnwn0(DreamManagerService r0, boolean r1, String r2) {
        r0.lambda$stopDreamLocked$12(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$rB49yCzoy2TwA93kKKJu45km_-g, reason: not valid java name */
    public static /* synthetic */ void m4174$r8$lambda$rB49yCzoy2TwA93kKKJu45km_g(DreamManagerService r0, ComponentName r1, Binder r2, boolean r3, boolean r4, int r5, PowerManager.WakeLock r6, String r7) {
        r0.lambda$startDreamLocked$11(r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ void $r8$lambda$sMmNEbNeBRVRL3JipOyQxrAuOZ0(DreamManagerService r0, PrintWriter r1, String r2) {
        r0.lambda$dumpInternal$3(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAtmInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskManagerInternal m4175$$Nest$fgetmAtmInternal(DreamManagerService r0) {
        return r0.mAtmInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBatteryManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ BatteryManagerInternal m4176$$Nest$fgetmBatteryManagerInternal(DreamManagerService r0) {
        return r0.mBatteryManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m4177$$Nest$fgetmContext(DreamManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmController, reason: not valid java name */
    static /* bridge */ /* synthetic */ DreamController m4178$$Nest$fgetmController(DreamManagerService r0) {
        return r0.mController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentDream, reason: not valid java name */
    static /* bridge */ /* synthetic */ DreamRecord m4179$$Nest$fgetmCurrentDream(DreamManagerService r0) {
        return r0.mCurrentDream;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDreamManagerStateListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ CopyOnWriteArrayList m4180$$Nest$fgetmDreamManagerStateListeners(DreamManagerService r0) {
        return r0.mDreamManagerStateListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m4181$$Nest$fgetmHandler(DreamManagerService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m4182$$Nest$fgetmLock(DreamManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPmInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerInternal m4183$$Nest$fgetmPmInternal(DreamManagerService r0) {
        return r0.mPmInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManager m4184$$Nest$fgetmPowerManager(DreamManagerService r0) {
        return r0.mPowerManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManagerInternal m4185$$Nest$fgetmPowerManagerInternal(DreamManagerService r0) {
        return r0.mPowerManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDreamOverlayServiceName, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4186$$Nest$fputmDreamOverlayServiceName(DreamManagerService r0, ComponentName r1) {
        r0.mDreamOverlayServiceName = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsCharging, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4187$$Nest$fputmIsCharging(DreamManagerService r0, boolean r1) {
        r0.mIsCharging = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsDocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4188$$Nest$fputmIsDocked(DreamManagerService r0, boolean r1) {
        r0.mIsDocked = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcanStartDreamingInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4189$$Nest$mcanStartDreamingInternal(DreamManagerService r0, boolean r1) {
        return r0.canStartDreamingInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4190$$Nest$mcheckPermission(DreamManagerService r0, String r1) {
        r0.checkPermission(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcleanupDreamLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4191$$Nest$mcleanupDreamLocked(DreamManagerService r0) {
        r0.cleanupDreamLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4192$$Nest$mdumpInternal(DreamManagerService r0, PrintWriter r1) {
        r0.dumpInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mfinishSelfInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4193$$Nest$mfinishSelfInternal(DreamManagerService r0, IBinder r1, boolean r2) {
        r0.finishSelfInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mforceAmbientDisplayEnabledInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4194$$Nest$mforceAmbientDisplayEnabledInternal(DreamManagerService r0, boolean r1) {
        r0.forceAmbientDisplayEnabledInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetDefaultDreamComponentForUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ ComponentName m4195$$Nest$mgetDefaultDreamComponentForUser(DreamManagerService r0, int r1) {
        return r0.getDefaultDreamComponentForUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetDozeComponent, reason: not valid java name */
    static /* bridge */ /* synthetic */ ComponentName m4196$$Nest$mgetDozeComponent(DreamManagerService r0) {
        return r0.getDozeComponent();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetDreamComponentsForUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ ComponentName[] m4197$$Nest$mgetDreamComponentsForUser(DreamManagerService r0, int r1) {
        return r0.getDreamComponentsForUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misDreamingInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4198$$Nest$misDreamingInternal(DreamManagerService r0) {
        return r0.isDreamingInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$misDreamingOrInPreviewInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4199$$Nest$misDreamingOrInPreviewInternal(DreamManagerService r0) {
        return r0.isDreamingOrInPreviewInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mreportDreamingStarted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4200$$Nest$mreportDreamingStarted(DreamManagerService r0) {
        r0.reportDreamingStarted();
    }

    /* JADX INFO: renamed from: -$$Nest$mreportDreamingStopped, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4201$$Nest$mreportDreamingStopped(DreamManagerService r0) {
        r0.reportDreamingStopped();
    }

    /* JADX INFO: renamed from: -$$Nest$mrequestAwakenInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4202$$Nest$mrequestAwakenInternal(DreamManagerService r0, String r1) {
        r0.requestAwakenInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mrequestDreamInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4203$$Nest$mrequestDreamInternal(DreamManagerService r0) {
        r0.requestDreamInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$msetDreamComponentsForUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4204$$Nest$msetDreamComponentsForUser(DreamManagerService r0, int r1, ComponentName[] r2) {
        r0.setDreamComponentsForUser(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetSystemDreamComponentInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4205$$Nest$msetSystemDreamComponentInternal(DreamManagerService r0, ComponentName r1) {
        r0.setSystemDreamComponentInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetWindowsBackgroundDrawableInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4206$$Nest$msetWindowsBackgroundDrawableInternal(DreamManagerService r0, int r1) {
        r0.setWindowsBackgroundDrawableInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mshouldKeepDreamingWhenUnplugging, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4207$$Nest$mshouldKeepDreamingWhenUnplugging(DreamManagerService r0) {
        return r0.shouldKeepDreamingWhenUnplugging();
    }

    /* JADX INFO: renamed from: -$$Nest$mstartDozingInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4208$$Nest$mstartDozingInternal(DreamManagerService r0, IBinder r1, int r2, int r3, float r4, int r5, boolean r6) {
        r0.startDozingInternal(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartDreamInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4209$$Nest$mstartDreamInternal(DreamManagerService r0, boolean r1, String r2) {
        r0.startDreamInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mstopDozingInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4210$$Nest$mstopDozingInternal(DreamManagerService r0, IBinder r1) {
        r0.stopDozingInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mstopDreamInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4211$$Nest$mstopDreamInternal(DreamManagerService r0, boolean r1, String r2) {
        r0.stopDreamInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mtestDreamInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4212$$Nest$mtestDreamInternal(DreamManagerService r0, ComponentName r1, int r2) {
        r0.testDreamInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateDreamOnPackageRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4213$$Nest$mupdateDreamOnPackageRemoved(DreamManagerService r0, String r1, int r2) {
        r0.updateDreamOnPackageRemoved(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateWhenToDreamSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4214$$Nest$mupdateWhenToDreamSettings(DreamManagerService r0) {
        r0.updateWhenToDreamSettings();
    }

    /* JADX INFO: renamed from: -$$Nest$mwritePulseGestureEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4215$$Nest$mwritePulseGestureEnabled(DreamManagerService r0) {
        r0.writePulseGestureEnabled();
    }

    public DreamManagerService(Context context) {
        this(context, null);
    }

    DreamManagerService(Context context, Handler handler) {
        super(context);
        this.mLock = new Object();
        this.mDreamManagerStateListeners = new CopyOnWriteArrayList();
        this.mPackageMonitors = new SparseArray();
        this.mActivityInterceptorCallback = new AnonymousClass1(this);
        this.mChargingReceiver = new AnonymousClass2(this);
        this.mDockStateReceiver = new AnonymousClass3(this);
        this.mControllerListener = new AnonymousClass4(this);
        final Handler r1 = null;
        this.mDozeEnabledObserver = new AnonymousClass5(this, r1);
        this.mSystemPropertiesChanged = new AnonymousClass6(this);
        this.mContext = context;
        if (handler != null) goto L5;
        this.mHandlerThread = new ServiceThread(TAG, 0, false);
        this.mHandlerThread.start();
        this.mHandler = new DreamHandler(this.mHandlerThread.getLooper());
    L6:
        this.mController = new DreamController(context, this.mHandler, this.mControllerListener);
        this.mPowerManager = (PowerManager) context.getSystemService("power");
        this.mPowerManagerInternal = (PowerManagerInternal) getLocalService(PowerManagerInternal.class);
        this.mAtmInternal = (ActivityTaskManagerInternal) getLocalService(ActivityTaskManagerInternal.class);
        this.mPmInternal = (PackageManagerInternal) getLocalService(PackageManagerInternal.class);
        this.mUserManager = (UserManager) context.getSystemService(UserManager.class);
        this.mDozeWakeLock = this.mPowerManager.newWakeLock(64, DOZE_WAKE_LOCK_TAG);
        this.mDozeConfig = new AmbientDisplayConfiguration(this.mContext);
        this.mUiEventLogger = new UiEventLoggerImpl();
        this.mDreamUiEventLogger = new DreamUiEventLoggerImpl(this.mContext.getResources().getStringArray(R.array.config_notificationMsgPkgsAllowedAsConvos));
        AmbientDisplayConfiguration adc = new AmbientDisplayConfiguration(this.mContext);
        this.mAmbientDisplayComponent = ComponentName.unflattenFromString(adc.ambientDisplayComponent());
        this.mDreamsOnlyEnabledForDockUser = this.mContext.getResources().getBoolean(R.bool.config_duplicate_port_omadm_wappush);
        this.mDismissDreamOnActivityStart = this.mContext.getResources().getBoolean(R.bool.config_displayColorFadeDisabled);
        this.mDreamsEnabledByDefaultConfig = this.mContext.getResources().getBoolean(R.bool.config_dreamsSupported);
        this.mDreamsActivatedOnChargeByDefault = this.mContext.getResources().getBoolean(R.bool.config_dreamsEnabledOnBattery);
        this.mDreamsActivatedOnDockByDefault = this.mContext.getResources().getBoolean(R.bool.config_dreamsDisabledByAmbientModeSuppressionConfig);
        this.mDreamsActivatedOnPosturedByDefault = this.mContext.getResources().getBoolean(R.bool.config_dreamsEnabledByDefault);
        this.mSettingsObserver = new SettingsObserver(this, this.mHandler);
        this.mKeepDreamingWhenUnpluggingDefault = this.mContext.getResources().getBoolean(R.bool.config_letterboxIsAutomaticReachabilityInBookModeEnabled);
        this.mDreamsDisabledByAmbientModeSuppressionConfig = this.mContext.getResources().getBoolean(R.bool.config_dreamsOnlyEnabledForDockUser);
        this.mBatteryManagerInternal = (BatteryManagerInternal) getLocalService(BatteryManagerInternal.class);
        SystemProperties.set(AUTO_AOD_BRIGHTNE_KEY, AUTO_AOD_SMOOTH_BRIGHTNESS);
        return;
    L5:
        this.mHandler = handler;
        goto L6
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        DreamManagerServiceIA r1 = null;
        publishBinderService("dreams", new BinderService(this, r1));
        publishLocalService(DreamManagerInternal.class, new LocalService(this, r1));
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase == 600) goto L5;
        return;
    L5:
        if (Build.IS_DEBUGGABLE == false) goto L7;
        SystemProperties.addChangeCallback(this.mSystemPropertiesChanged);
    L7:
        this.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("doze_pulse_on_double_tap"), false, this.mDozeEnabledObserver, -1);
        writePulseGestureEnabled();
        if (this.mDismissDreamOnActivityStart == false) goto L10;
        this.mAtmInternal.registerActivityStartInterceptor(4, this.mActivityInterceptorCallback);
    L10:
        this.mContext.registerReceiver(this.mDockStateReceiver, new IntentFilter("android.intent.action.DOCK_EVENT"));
        IntentFilter chargingIntentFilter = new IntentFilter();
        chargingIntentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        chargingIntentFilter.setPriority(1000);
        this.mContext.registerReceiver(this.mChargingReceiver, chargingIntentFilter);
        this.mSettingsObserver = new SettingsObserver(this, this.mHandler);
        this.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("screensaver_activate_on_sleep"), false, this.mSettingsObserver, -1);
        this.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("screensaver_activate_on_dock"), false, this.mSettingsObserver, -1);
        this.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("screensaver_activate_on_postured"), false, this.mSettingsObserver, -1);
        this.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("screensaver_enabled"), false, this.mSettingsObserver, -1);
        this.mIsCharging = ((BatteryManager) this.mContext.getSystemService(BatteryManager.class)).isCharging();
        updateWhenToDreamSettings();
    }

    @Override // com.android.server.SystemService
    public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
        updateWhenToDreamSettings();
        this.mHandler.post(new DreamManagerService$$ExternalSyntheticLambda9(this));
    }

    private /* synthetic */ void lambda$onUserSwitching$0() {
        writePulseGestureEnabled();
        Object r0 = this.mLock;
        monitor-enter(r0);
        stopDreamLocked(false, "user switched");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onUserStarting(final SystemService.TargetUser user) {
        super.onUserStarting(user);
        this.mHandler.post(new DreamManagerService$$ExternalSyntheticLambda3(this, user));
    }

    private /* synthetic */ void lambda$onUserStarting$1(SystemService.TargetUser user) {
        int userId = user.getUserIdentifier();
        if (this.mPackageMonitors.contains(userId) == true) goto L5;
        PackageMonitor monitor = new PerUserPackageMonitor(this, null);
        monitor.register(this.mContext, UserHandle.of(userId), this.mHandler);
        this.mPackageMonitors.put(userId, monitor);
        return;
    L5:
        Slog.w(TAG, "Package monitor already registered for " + userId);
    }

    @Override // com.android.server.SystemService
    public void onUserStopping(final SystemService.TargetUser user) {
        super.onUserStopping(user);
        this.mHandler.post(new DreamManagerService$$ExternalSyntheticLambda8(this, user));
    }

    private /* synthetic */ void lambda$onUserStopping$2(SystemService.TargetUser user) {
        PackageMonitor monitor = (PackageMonitor) this.mPackageMonitors.removeReturnOld(user.getUserIdentifier());
        if (monitor == null) goto L6;
        monitor.unregister();
        return;
    }

    private void dumpInternal(PrintWriter pw) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        pw.println("DREAM MANAGER (dumpsys dreams)");     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        pw.println("mCurrentDream=" + this.mCurrentDream);     // Catch: Throwable -> L11
        pw.println("mForceAmbientDisplayEnabled=" + this.mForceAmbientDisplayEnabled);     // Catch: Throwable -> L11
        pw.println("mDreamsOnlyEnabledForDockUser=" + this.mDreamsOnlyEnabledForDockUser);     // Catch: Throwable -> L11
        pw.println("mDreamsEnabledSetting=" + this.mDreamsEnabledSetting);     // Catch: Throwable -> L11
        pw.println("mDreamsActivatedOnDockByDefault=" + this.mDreamsActivatedOnDockByDefault);     // Catch: Throwable -> L11
        pw.println("mDreamsActivatedOnChargeByDefault=" + this.mDreamsActivatedOnChargeByDefault);     // Catch: Throwable -> L11
        pw.println("mDreamsActivatedOnPosturedByDefault=" + this.mDreamsActivatedOnPosturedByDefault);     // Catch: Throwable -> L11
        pw.println("mIsDocked=" + this.mIsDocked);     // Catch: Throwable -> L11
        pw.println("mIsCharging=" + this.mIsCharging);     // Catch: Throwable -> L11
        pw.println("mWhenToDream=" + this.mWhenToDream);     // Catch: Throwable -> L11
        pw.println("mKeepDreamingWhenUnpluggingDefault=" + this.mKeepDreamingWhenUnpluggingDefault);     // Catch: Throwable -> L11
        pw.println("getDozeComponent()=" + getDozeComponent());     // Catch: Throwable -> L11
        pw.println("mDreamOverlayServiceName=" + ComponentName.flattenToShortString(this.mDreamOverlayServiceName));     // Catch: Throwable -> L11
        pw.println();     // Catch: Throwable -> L11
        DumpUtils.dumpAsync(this.mHandler, new DreamManagerService$$ExternalSyntheticLambda11(this), pw, "", 200);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L9:
        th = move-exception;
        r9 = th;
        goto L13
    }

    private /* synthetic */ void lambda$dumpInternal$3(PrintWriter pw1, String prefix) {
        this.mController.dump(pw1);
    }

    private void updateWhenToDreamSettings() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ContentResolver resolver = this.mContext.getContentResolver();     // Catch: Throwable -> L11
        boolean r2 = false;
        this.mWhenToDream = 0;     // Catch: Throwable -> L11
        if (this.mDreamsActivatedOnChargeByDefault == false) goto L7;
        int r4 = 1;
    L9:
        if (Settings.Secure.getIntForUser(resolver, "screensaver_activate_on_sleep", r4, -2) == 0) goto L14;
        this.mWhenToDream |= 2;     // Catch: Throwable -> L11
    L14:
        if (this.mDreamsActivatedOnDockByDefault == false) goto L16;
        int r5 = 1;
    L18:
        if (Settings.Secure.getIntForUser(resolver, "screensaver_activate_on_dock", r5, -2) == 0) goto L21;
        this.mWhenToDream |= 1;     // Catch: Throwable -> L11
    L21:
        if (this.mDreamsActivatedOnPosturedByDefault == false) goto L23;
        int r6 = 1;
    L25:
        if (Settings.Secure.getIntForUser(resolver, "screensaver_activate_on_postured", r6, -2) == 0) goto L28;
        this.mWhenToDream |= 4;     // Catch: Throwable -> L11
    L28:
        if (this.mDreamsEnabledByDefaultConfig == false) goto L30;
        int r7 = 1;
    L32:
        if (Settings.Secure.getIntForUser(resolver, "screensaver_enabled", r7, -2) == 0) goto L34;
        r2 = true;
    L34:
        this.mDreamsEnabledSetting = r2;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L30:
        r7 = 0;
        goto L32
    L23:
        r6 = 0;
        goto L25
    L16:
        r5 = 0;
        goto L18
    L7:
        r4 = 0;
    L11:
        th = move-exception;
        throw th;
    }

    private void reportKeepDreamingWhenUnpluggingChanged(final boolean keepDreaming) {
        notifyDreamStateListeners(new DreamManagerService$$ExternalSyntheticLambda4(keepDreaming));
    }

    private static /* synthetic */ void lambda$reportKeepDreamingWhenUnpluggingChanged$4(boolean keepDreaming, DreamManagerInternal.DreamManagerStateListener listener) {
        listener.onKeepDreamingWhenUnpluggingChanged(keepDreaming);
    }

    private static /* synthetic */ void lambda$reportDreamingStarted$5(DreamManagerInternal.DreamManagerStateListener listener) {
        listener.onDreamingStarted();
    }

    private void reportDreamingStarted() {
        notifyDreamStateListeners(new DreamManagerService$$ExternalSyntheticLambda12());
    }

    private static /* synthetic */ void lambda$reportDreamingStopped$6(DreamManagerInternal.DreamManagerStateListener listener) {
        listener.onDreamingStopped();
    }

    private void reportDreamingStopped() {
        notifyDreamStateListeners(new DreamManagerService$$ExternalSyntheticLambda5());
    }

    private void notifyDreamStateListeners(final Consumer<DreamManagerInternal.DreamManagerStateListener> notifier) {
        this.mHandler.post(new DreamManagerService$$ExternalSyntheticLambda13(this, notifier));
    }

    private /* synthetic */ void lambda$notifyDreamStateListeners$7(Consumer notifier) {
        Iterator<DreamManagerInternal.DreamManagerStateListener> r0 = this.mDreamManagerStateListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        DreamManagerInternal.DreamManagerStateListener listener = r0.next();
        notifier.accept(listener);
        goto L4
    }

    private boolean isDreamingInternal() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentDream != null) goto L7;
    L13:
        boolean r1 = false;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L7:
        if (this.mCurrentDream.isPreview == true) goto L13;
        if (this.mCurrentDream.isWaking == true) goto L13;
        r1 = true;
        goto L14
    }

    private boolean isDozingInternal() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentDream != null) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mCurrentDream.isDozing == false) goto L11;
        r1 = true;
        goto L12
    }

    private boolean isDreamingOrInPreviewInternal() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentDream != null) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mCurrentDream.isWaking == true) goto L11;
        r1 = true;
        goto L12
    }

    boolean dreamConditionActiveInternal() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = dreamConditionActiveInternalLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean dreamConditionActiveInternalLocked() {
        if ((this.mWhenToDream & 2) != 2) goto L7;
        return this.mIsCharging;
    L7:
        if ((this.mWhenToDream & 1) != 1) goto L11;
        return this.mIsDocked;
    L11:
        if ((this.mWhenToDream & 4) == 4) goto L13;
        return false;
    L13:
        return this.mIsPostured;
    }

    boolean dreamsEnabled() {
        return this.mDreamsEnabledSetting;
    }

    private boolean canStartDreamingInternal(boolean isScreenOn) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (isScreenOn == false) goto L15;
    L12:
        th = move-exception;
        throw th;
    L7:
        if (isDreamingInternal() == false) goto L15;
        if (dreamIsFrontmost() == false) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L15:
        if (this.mDreamsEnabledSetting == true) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L19:
        if (dreamsEnabledForUser(ActivityManager.getCurrentUser()) == true) goto L23;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L23:
        if (this.mUserManager.isUserUnlocked() == true) goto L27;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L27:
        if (this.mDreamsDisabledByAmbientModeSuppressionConfig == true) goto L29;
    L33:
        boolean r1 = dreamConditionActiveInternalLocked();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L29:
        if (this.mPowerManagerInternal.isAmbientDisplaySuppressed() == false) goto L33;
        Slog.i(TAG, "Can't start dreaming because ambient is suppressed.");     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    }

    private boolean dreamIsFrontmost() {
        if (this.mController.dreamIsFrontmost() == false) goto L5;
        return true;
    L5:
        return false;
    }

    protected void requestStartDreamFromShell() {
        requestDreamInternal();
    }

    private void requestDreamInternal() {
        if (isDreamingInternal() == true) goto L5;
    L9:
        long time = SystemClock.uptimeMillis();
        this.mPowerManager.userActivity(time, true);
        this.mPowerManagerInternal.nap(time, true);
        return;
    L5:
        if (dreamIsFrontmost() == true) goto L9;
        if (this.mController.bringDreamToFront() == false) goto L9;
    }

    private void requestAwakenInternal(String reason) {
        long time = SystemClock.uptimeMillis();
        this.mPowerManager.userActivity(time, false);
        stopDreamInternal(false, reason);
    }

    private void finishSelfInternal(IBinder token, boolean immediate) {
        Slog.d(TAG, "Dream finished: " + token + ", immediate=" + immediate);
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentDream != null) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mCurrentDream.token != token) goto L11;
        stopDreamLocked(immediate, "finished self");     // Catch: Throwable -> L9
        goto L11
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    private void testDreamInternal(ComponentName dream, int userId) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw th;
    L6:
        startDreamLocked(dream, true, false, userId, "test dream");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
    }

    private void startDreamInternal(boolean doze, String reason) {
        int userId = ActivityManager.getCurrentUser();
        ComponentName dream = chooseDreamForUser(doze, userId);
        if (dream == null) goto L15;
        Object r7 = this.mLock;
        monitor-enter(r7);
        startDreamLocked(dream, false, doze, userId, reason);     // Catch: Throwable -> L10
        monitor-exit(r7);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    protected void requestStopDreamFromShell() {
        stopDreamInternal(false, "stopping dream from shell");
    }

    private void stopDreamInternal(boolean immediate, String reason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        stopDreamLocked(immediate, reason);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void startDozingInternal(IBinder token, int screenState, int reason, float screenBrightnessFloat, int screenBrightnessInt, boolean useNormalBrightnessForDoze) {
        Slog.d(TAG, "Dream requested to start dozing: " + token + ", screenState=" + Display.stateToString(screenState) + ", reason=" + Display.stateReasonToString(reason) + ", screenBrightnessFloat=" + screenBrightnessFloat + ", screenBrightnessInt=" + screenBrightnessInt + ", useNormalBrightnessForDoze=" + useNormalBrightnessForDoze);
        Object r1 = this.mLock;
        monitor-enter(r1);
    L15:
        th = move-exception;
        Throwable r10 = th;
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L15
        throw r10;
    L17:
        th = move-exception;
        r10 = th;
        goto L22
    L5:
        if (this.mCurrentDream == null) goto L20;
        if (this.mCurrentDream.token != token) goto L20;
        if (this.mCurrentDream.canDoze == false) goto L20;
        this.mCurrentDream.dozeScreenState = screenState;     // Catch: Throwable -> L17
        this.mCurrentDream.dozeScreenBrightness = screenBrightnessInt;     // Catch: Throwable -> L17
        this.mCurrentDream.dozeScreenBrightnessFloat = screenBrightnessFloat;     // Catch: Throwable -> L17
        this.mPowerManagerInternal.setDozeOverrideFromDreamManager(screenState, reason, screenBrightnessFloat, screenBrightnessInt, useNormalBrightnessForDoze);     // Catch: Throwable -> L15
        if (this.mCurrentDream.isDozing == true) goto L20;
        this.mCurrentDream.isDozing = true;     // Catch: Throwable -> L15
        this.mDozeWakeLock.acquire();     // Catch: Throwable -> L15
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L15
    }

    private void stopDozingInternal(IBinder token) {
        Slog.d(TAG, "Dream requested to stop dozing: " + token);
        Object r1 = this.mLock;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentDream != null) goto L7;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.mCurrentDream.token != token) goto L13;
        if (this.mCurrentDream.isDozing == false) goto L13;
        this.mCurrentDream.isDozing = false;     // Catch: Throwable -> L11
        this.mDozeWakeLock.release();     // Catch: Throwable -> L11
        this.mPowerManagerInternal.setDozeOverrideFromDreamManager(0, 5, Float.NaN, -1, false);     // Catch: Throwable -> L11
        goto L13
    }

    private void forceAmbientDisplayEnabledInternal(boolean enabled) {
        Slog.d(TAG, "Force ambient display enabled: " + enabled);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mForceAmbientDisplayEnabled = enabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setDevicePosturedInternal(final boolean isPostured) {
        Slog.d(TAG, "Device postured: " + isPostured);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mIsPostured = isPostured;     // Catch: Throwable -> L7
        this.mHandler.post(new DreamManagerService$$ExternalSyntheticLambda10(this, isPostured));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$setDevicePosturedInternal$8(boolean isPostured) {
        this.mPowerManagerInternal.setDevicePostured(isPostured);
    }

    private ComponentName chooseDreamForUser(boolean doze, int userId) {
        if (doze == false) goto L9;
        ComponentName dozeComponent = getDozeComponent(userId);
        if (validateDream(dozeComponent, userId) == true) goto L7;
        return null;
    L7:
        return dozeComponent;
    L9:
        if (this.mSystemDreamComponent != null) goto L11;
        ComponentName[] dreams = getDreamComponentsForUser(userId);
        if (dreams != null) goto L15;
        return null;
    L15:
        if (dreams.length != 0) goto L17;
        return null;
    L17:
        return dreams[0];
    L11:
        return this.mSystemDreamComponent;
    }

    private boolean validateDream(ComponentName component, int userId) {
        if (component != null) goto L5;
        return false;
    L5:
        ServiceInfo serviceInfo = getServiceInfo(component, userId);
        if (serviceInfo != null) goto L10;
        Slog.w(TAG, "Dream " + component + " does not exist on user " + userId);
        return false;
    L10:
        if (serviceInfo.applicationInfo.targetSdkVersion >= 21) goto L12;
        return true;
    L12:
        if ("android.permission.BIND_DREAM_SERVICE".equals(serviceInfo.permission) == true) goto L17;
        Slog.w(TAG, "Dream " + component + " is not available because its manifest is missing the android.permission.BIND_DREAM_SERVICE permission on the dream service declaration.");
        return false;
    L17:
        return true;
    }

    private ComponentName[] getDreamComponentsForUser(int userId) {
        if (dreamsEnabledForUser(userId) == true) goto L6;
        return null;
    L6:
        String names = Settings.Secure.getStringForUser(this.mContext.getContentResolver(), "screensaver_components", userId);
        ComponentName[] components = componentsFromString(names);
        List<ComponentName> validComponents = new ArrayList();
        if (components == null) goto L16;
        int r3 = components.length;
        int r4 = 0;
    L10:
        if (r4 >= r3) goto L16;
        ComponentName component = components[r4];
        if (validateDream(component, userId) == false) goto L14;
        validComponents.add(component);
    L14:
        r4 = r4 + 1;
    L16:
        if (validComponents.isEmpty() == false) goto L21;
        ComponentName defaultDream = getDefaultDreamComponentForUser(userId);
        if (defaultDream == null) goto L21;
        Slog.w(TAG, "Falling back to default dream " + defaultDream);
        validComponents.add(defaultDream);
    L21:
        return (ComponentName[]) validComponents.toArray(new ComponentName[validComponents.size()]);
    }

    private void updateDreamOnPackageRemoved(final String packageName, int userId) {
        ComponentName[] componentNames = componentsFromString(Settings.Secure.getStringForUser(this.mContext.getContentResolver(), "screensaver_components", userId));
        if (componentNames == null) goto L8;
        ComponentName[] filteredComponents = (ComponentName[]) Arrays.stream(componentNames).filter(new DreamManagerService$$ExternalSyntheticLambda0(packageName)).toArray(new DreamManagerService$$ExternalSyntheticLambda1());
        if (filteredComponents.length == componentNames.length) goto L9;
        setDreamComponentsForUser(userId, filteredComponents);
        return;
    L9:
        return;
    }

    private static /* synthetic */ boolean lambda$updateDreamOnPackageRemoved$9(String packageName, ComponentName componentName) {
        return !isSamePackage(packageName, componentName);
    }

    private static /* synthetic */ ComponentName[] lambda$updateDreamOnPackageRemoved$10(int x$0) {
        return new ComponentName[x$0];
    }

    private static boolean isSamePackage(String packageName, ComponentName componentName) {
        if (packageName == null) goto L7;
        if (componentName != null) goto L6;
        return false;
    L6:
        return TextUtils.equals(componentName.getPackageName(), packageName);
    L7:
        return false;
    }

    private void setDreamComponentsForUser(int userId, ComponentName[] componentNames) {
        Settings.Secure.putStringForUser(this.mContext.getContentResolver(), "screensaver_components", componentsToString(componentNames), userId);
    }

    private void setSystemDreamComponentInternal(ComponentName componentName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (Objects.equals(this.mSystemDreamComponent, componentName) == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mSystemDreamComponent = componentName;     // Catch: Throwable -> L8
        reportKeepDreamingWhenUnpluggingChanged(shouldKeepDreamingWhenUnplugging());     // Catch: Throwable -> L8
        if (isDreamingInternal() == true) goto L13;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        if (isDozingInternal() == true) goto L19;
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L8
        if (this.mSystemDreamComponent != null) goto L17;
        String r2 = "clear";
    L18:
        r1.append(r2);     // Catch: Throwable -> L8
        r1.append(" system dream component");     // Catch: Throwable -> L8
        startDreamInternal(false, r1.toString());     // Catch: Throwable -> L8
        goto L19
    L17:
        r2 = "set";
        goto L18
    }

    private boolean shouldKeepDreamingWhenUnplugging() {
        if (this.mKeepDreamingWhenUnpluggingDefault == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mSystemDreamComponent != null) goto L7;
        return true;
    }

    private ComponentName getDefaultDreamComponentForUser(int userId) {
        String name = Settings.Secure.getStringForUser(this.mContext.getContentResolver(), "screensaver_default_component", userId);
        if (name != null) goto L6;
        return null;
    L6:
        return ComponentName.unflattenFromString(name);
    }

    private ComponentName getDozeComponent() {
        return getDozeComponent(ActivityManager.getCurrentUser());
    }

    private ComponentName getDozeComponent(int userId) {
        if (this.mForceAmbientDisplayEnabled == true) goto L10;
        if (this.mDozeConfig.enabled(userId) == true) goto L10;
        return null;
    L10:
        return ComponentName.unflattenFromString(this.mDozeConfig.ambientDisplayComponent());
    }

    private boolean dreamsEnabledForUser(int userId) {
        if (this.mDreamsOnlyEnabledForDockUser == true) goto L6;
        return true;
    L6:
        if (userId >= 0) goto L8;
        return false;
    L8:
        int mainUserId = ((UserManagerInternal) LocalServices.getService(UserManagerInternal.class)).getMainUserId();
        if (userId != mainUserId) goto L12;
        return true;
    L12:
        return false;
    }

    private ServiceInfo getServiceInfo(ComponentName name, int userId) {
        Context userContext = this.mContext.createContextAsUser(UserHandle.of(userId), 0);
        if (name == null) goto L12;
        return userContext.getPackageManager().getServiceInfo(name, 268435456);
    L7:
        return null;
    L12:
        return null;
    }

    private void startDreamLocked(final ComponentName name, final boolean isPreviewMode, final boolean canDoze, final int userId, final String reason) {
        if (this.mCurrentDream != null) goto L5;
    L16:
        Slog.i(TAG, "Entering dreamland.");
        if (this.mCurrentDream != null) goto L19;
    L21:
        this.mCurrentDream = new DreamRecord(name, userId, isPreviewMode, canDoze);
        if (this.mCurrentDream.name.equals(this.mAmbientDisplayComponent) == true) goto L24;
        this.mUiEventLogger.log(DreamUiEventLogger.DreamUiEventEnum.DREAM_START);
        this.mDreamUiEventLogger.log(DreamUiEventLogger.DreamUiEventEnum.DREAM_START, this.mCurrentDream.name.flattenToString());
    L24:
        final PowerManager.WakeLock wakeLock = this.mPowerManager.newWakeLock(1, DREAM_WAKE_LOCK_TAG);
        final Binder dreamToken = this.mCurrentDream.token;
        this.mHandler.post(wakeLock.wrap(new DreamManagerService$$ExternalSyntheticLambda7(this, name, dreamToken, isPreviewMode, canDoze, userId, wakeLock, reason)));
        return;
    L19:
        if (this.mCurrentDream.isDozing == false) goto L21;
        stopDozingInternal(this.mCurrentDream.token);
        goto L21
    L5:
        if (this.mCurrentDream.isWaking == true) goto L16;
        if (Objects.equals(this.mCurrentDream.name, name) == false) goto L16;
        if (this.mCurrentDream.isPreview != isPreviewMode) goto L16;
        if (this.mCurrentDream.canDoze != canDoze) goto L16;
        if (this.mCurrentDream.userId != userId) goto L16;
        Slog.i(TAG, "Already in target dream.");
    }

    private /* synthetic */ void lambda$startDreamLocked$11(ComponentName name, Binder dreamToken, boolean isPreviewMode, boolean canDoze, int userId, PowerManager.WakeLock wakeLock, String reason) {
        this.mAtmInternal.notifyActiveDreamChanged(name);
        this.mController.startDream(dreamToken, name, isPreviewMode, canDoze, userId, wakeLock, this.mDreamOverlayServiceName, reason);
    }

    private void stopDreamLocked(final boolean immediate, final String reason) {
        if (this.mCurrentDream != null) goto L5;
        return;
    L5:
        if (immediate == false) goto L8;
        Slog.i(TAG, "Leaving dreamland.");
        cleanupDreamLocked();
    L11:
        this.mHandler.post(new DreamManagerService$$ExternalSyntheticLambda2(this, immediate, reason));
        return;
    L8:
        if (this.mCurrentDream.isWaking == false) goto L10;
        return;
    L10:
        Slog.i(TAG, "Gently waking up from dream.");
        this.mCurrentDream.isWaking = true;
        goto L11
    }

    private /* synthetic */ void lambda$stopDreamLocked$12(boolean immediate, String reason) {
        this.mController.stopDream(immediate, reason);
    }

    private void cleanupDreamLocked() {
        this.mHandler.post(new DreamManagerService$$ExternalSyntheticLambda6(this));
        if (this.mCurrentDream != null) goto L6;
        return;
    L6:
        if (this.mCurrentDream.name.equals(this.mAmbientDisplayComponent) == true) goto L9;
        this.mUiEventLogger.log(DreamUiEventLogger.DreamUiEventEnum.DREAM_STOP);
        this.mDreamUiEventLogger.log(DreamUiEventLogger.DreamUiEventEnum.DREAM_STOP, this.mCurrentDream.name.flattenToString());
    L9:
        if (this.mCurrentDream.isDozing == false) goto L11;
        this.mDozeWakeLock.release();
    L11:
        this.mCurrentDream = null;
    }

    private /* synthetic */ void lambda$cleanupDreamLocked$13() {
        this.mAtmInternal.notifyActiveDreamChanged(null);
    }

    private void checkPermission(String permission) {
        if (this.mContext.checkCallingOrSelfPermission(permission) != 0) goto L6;
        return;
    L6:
        throw new SecurityException("Access denied to process: " + Binder.getCallingPid() + ", must have permission " + permission);
    }

    private void writePulseGestureEnabled() {
        ComponentName name = getDozeComponent();
        boolean dozeEnabled = validateDream(name, ActivityManager.getCurrentUser());
        ((InputManagerInternal) LocalServices.getService(InputManagerInternal.class)).setPulseGestureEnabled(dozeEnabled);
    }

    private static String componentsToString(ComponentName[] componentNames) {
        if (componentNames != null) goto L5;
        return null;
    L5:
        StringBuilder names = new StringBuilder();
        int r1 = componentNames.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L16;
        ComponentName componentName = componentNames[r2];
        if (componentName == null) goto L14;
        if (names.isEmpty() == true) goto L13;
        names.append(',');
    L13:
        names.append(componentName.flattenToString());
    L14:
        r2 = r2 + 1;
        goto L6
    L16:
        return names.toString();
    }

    private static ComponentName[] componentsFromString(String names) {
        if (names != null) goto L5;
        return null;
    L5:
        String[] namesArray = names.split(",");
        ComponentName[] componentNames = new ComponentName[namesArray.length];
        int i = 0;
    L7:
        if (i >= namesArray.length) goto L10;
        componentNames[i] = ComponentName.unflattenFromString(namesArray[i]);
        i = i + 1;
        goto L7
    L10:
        return componentNames;
    }

    private void setWindowsBackgroundDrawableInternal(int value) {
        if (this.mCurrentDream == null) goto L6;
        Slog.i(TAG, "setWindowsBackgroundDrawableInternal.");
        this.mController.setWindowsBackgroundDrawable(value);
        return;
    }
}
