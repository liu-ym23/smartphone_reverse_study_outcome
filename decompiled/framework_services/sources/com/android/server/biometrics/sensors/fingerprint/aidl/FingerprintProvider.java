package com.android.server.biometrics.sensors.fingerprint.aidl;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.app.TaskStackListener;
import android.content.Context;
import android.content.pm.UserInfo;
import android.content.res.TypedArray;
import android.hardware.biometrics.IInvalidationCallback;
import android.hardware.biometrics.ITestSession;
import android.hardware.biometrics.ITestSessionCallback;
import android.hardware.biometrics.SensorLocationInternal;
import android.hardware.biometrics.SensorPropertiesInternal;
import android.hardware.biometrics.fingerprint.IFingerprint;
import android.hardware.biometrics.fingerprint.ISession;
import android.hardware.biometrics.fingerprint.PointerContext;
import android.hardware.biometrics.fingerprint.SensorProps;
import android.hardware.biometrics.fingerprint.virtualhal.IVirtualHal;
import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintAuthenticateOptions;
import android.hardware.fingerprint.FingerprintEnrollOptions;
import android.hardware.fingerprint.FingerprintSensorConfigurations;
import android.hardware.fingerprint.FingerprintSensorPropertiesInternal;
import android.hardware.fingerprint.IFingerprintServiceReceiver;
import android.hardware.fingerprint.IUdfpsOverlayController;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserManager;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.server.am.AssistDataRequester;
import com.android.server.am.HostingRecord;
import com.android.server.am.ProcessList;
import com.android.server.biometrics.AuthenticationStatsBroadcastReceiver;
import com.android.server.biometrics.AuthenticationStatsCollector;
import com.android.server.biometrics.BiometricDanglingReceiver;
import com.android.server.biometrics.BiometricHandlerProvider;
import com.android.server.biometrics.Utils;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.sensors.AuthSessionCoordinator;
import com.android.server.biometrics.sensors.AuthenticationClient;
import com.android.server.biometrics.sensors.AuthenticationStateListeners;
import com.android.server.biometrics.sensors.BaseClientMonitor;
import com.android.server.biometrics.sensors.BiometricScheduler;
import com.android.server.biometrics.sensors.BiometricStateCallback;
import com.android.server.biometrics.sensors.BiometricUtils;
import com.android.server.biometrics.sensors.ClientMonitorCallback;
import com.android.server.biometrics.sensors.ClientMonitorCallbackConverter;
import com.android.server.biometrics.sensors.ClientMonitorCompositeCallback;
import com.android.server.biometrics.sensors.InvalidationRequesterClient;
import com.android.server.biometrics.sensors.LockoutResetDispatcher;
import com.android.server.biometrics.sensors.LockoutTracker;
import com.android.server.biometrics.sensors.PerformanceTracker;
import com.android.server.biometrics.sensors.SensorList;
import com.android.server.biometrics.sensors.fingerprint.GestureAvailabilityDispatcher;
import com.android.server.biometrics.sensors.fingerprint.PowerPressHandler;
import com.android.server.biometrics.sensors.fingerprint.ServiceProvider;
import com.android.server.biometrics.sensors.fingerprint.Udfps;
import com.android.server.biometrics.sensors.fingerprint.hidl.HidlToAidlSensorAdapter;
import com.android.server.slice.SliceClientPermissions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintProvider implements IBinder.DeathRecipient, ServiceProvider, IZteFingerprintProvider.IZteFingerprintProviderExport {
    private static final String TAG = "FingerprintProvider";
    private final ActivityTaskManager mActivityTaskManager;
    private final AuthSessionCoordinator mAuthSessionCoordinator;
    private final AuthenticationStateListeners mAuthenticationStateListeners;
    private AuthenticationStatsCollector mAuthenticationStatsCollector;
    private final BiometricContext mBiometricContext;
    private final BiometricHandlerProvider mBiometricHandlerProvider;
    private final BiometricStateCallback mBiometricStateCallback;
    private final Context mContext;
    private IFingerprint mDaemon;
    final SensorList<Sensor> mFingerprintSensors;
    private final String mHalInstanceName;
    private String mHalInstanceNameCurrent;
    private final Handler mHandler;
    private final LockoutResetDispatcher mLockoutResetDispatcher;
    private final AtomicLong mRequestCounter;
    private final BiometricTaskStackListener mTaskStackListener;
    private boolean mTestHalEnabled;
    private IUdfpsOverlayController mUdfpsOverlayController;
    private IVirtualHal mVhal;
    private final IZteFingerprintProvider mZteFingerprintProvider;

    /* JADX INFO: renamed from: com.android.server.biometrics.sensors.fingerprint.aidl.FingerprintProvider$3, reason: invalid class name */
    class AnonymousClass3 implements ClientMonitorCallback {
        final /* synthetic */ FingerprintProvider this$0;
        final /* synthetic */ ClientMonitorCallbackConverter val$callback;
        final /* synthetic */ long val$requestId;
        final /* synthetic */ int val$sensorId;
        final /* synthetic */ int val$userId;

        public static /* synthetic */ void $r8$lambda$FOSDjhyLxG3xMf6j7e1awdBMCeM(AnonymousClass3 r0, int r1, int r2, long r3, boolean r5) {
            r0.lambda$onClientFinished$1(r1, r2, r3, r5);
        }

        public static /* synthetic */ void $r8$lambda$_SD_bziflpOr4WdvYEZXxz1mCSI(AnonymousClass3 r0, int r1, int r2, long r3) {
            r0.lambda$onClientStarted$0(r1, r2, r3);
        }

        AnonymousClass3(FingerprintProvider this$0, int r2, int r3, long r4, ClientMonitorCallbackConverter r6) {
            this.this$0 = this$0;
            this.val$sensorId = r2;
            this.val$userId = r3;
            this.val$requestId = r4;
            this.val$callback = r6;
        }

        @Override // com.android.server.biometrics.sensors.ClientMonitorCallback
        public void onClientStarted(BaseClientMonitor clientMonitor) {
            this.this$0.mFingerprintSensors.get(this.val$sensorId).registerPostAuthAcquiredFallback(this.val$userId, this.val$requestId, this.val$callback);
            FingerprintProvider.m2720$$Nest$fgetmBiometricStateCallback(this.this$0).onClientStarted(clientMonitor);
            Handler r0 = FingerprintProvider.m2719$$Nest$fgetmBiometricHandlerProvider(this.this$0).getBiometricCallbackHandler();
            final int r3 = this.val$userId;
            final int r4 = this.val$sensorId;
            final long r5 = this.val$requestId;
            r0.post(new FingerprintProvider$3$$ExternalSyntheticLambda0(this, r3, r4, r5));
        }

        private /* synthetic */ void lambda$onClientStarted$0(int userId, int sensorId, long requestId) {
            FingerprintProvider.m2718$$Nest$fgetmAuthSessionCoordinator(this.this$0).authStartedFor(userId, sensorId, requestId);
        }

        @Override // com.android.server.biometrics.sensors.ClientMonitorCallback
        public void onBiometricAction(int action) {
            FingerprintProvider.m2720$$Nest$fgetmBiometricStateCallback(this.this$0).onBiometricAction(action);
        }

        @Override // com.android.server.biometrics.sensors.ClientMonitorCallback
        public void onClientFinished(BaseClientMonitor clientMonitor, final boolean success) {
            FingerprintProvider.m2720$$Nest$fgetmBiometricStateCallback(this.this$0).onClientFinished(clientMonitor, success);
            Handler r0 = FingerprintProvider.m2719$$Nest$fgetmBiometricHandlerProvider(this.this$0).getBiometricCallbackHandler();
            final int r3 = this.val$userId;
            final int r4 = this.val$sensorId;
            final long r5 = this.val$requestId;
            r0.post(new FingerprintProvider$3$$ExternalSyntheticLambda1(this, r3, r4, r5, success));
        }

        private /* synthetic */ void lambda$onClientFinished$1(int userId, int sensorId, long requestId, boolean success) {
            FingerprintProvider.m2718$$Nest$fgetmAuthSessionCoordinator(this.this$0).authEndedFor(userId, Utils.getCurrentStrength(sensorId), sensorId, requestId, success);
        }
    }

    private final class BiometricTaskStackListener extends TaskStackListener {
        final /* synthetic */ FingerprintProvider this$0;

        public static /* synthetic */ void $r8$lambda$9JZAvIXgFiiondPOiImji9qFFW8(BiometricTaskStackListener r0) {
            r0.lambda$onTaskStackChanged$0();
        }

        /* synthetic */ BiometricTaskStackListener(FingerprintProvider r1, FingerprintProviderIA r2) {
            this(r1);
        }

        private BiometricTaskStackListener(FingerprintProvider r1) {
            this.this$0 = r1;
        }

        public void onTaskStackChanged() {
            FingerprintProvider.m2722$$Nest$fgetmHandler(this.this$0).post(new FingerprintProvider$BiometricTaskStackListener$$ExternalSyntheticLambda0(this));
        }

        private /* synthetic */ void lambda$onTaskStackChanged$0() {
            int i = 0;
        L4:
            if (i >= this.this$0.mFingerprintSensors.size()) goto L20;
            BaseClientMonitor client = this.this$0.mFingerprintSensors.valueAt(i).getScheduler().getCurrentClient();
            if ((client instanceof AuthenticationClient) == true) goto L9;
            Slog.e(FingerprintProvider.m2723$$Nest$mgetTag(this.this$0), "Task stack changed for client: " + client);
        L18:
            i = i + 1;
            goto L4
        L9:
            if (Utils.isKeyguard(FingerprintProvider.m2721$$Nest$fgetmContext(this.this$0), client.getOwnerString()) == true) goto L18;
            if (Utils.isSystem(FingerprintProvider.m2721$$Nest$fgetmContext(this.this$0), client.getOwnerString()) == true) goto L18;
            if (Utils.isBackground(client.getOwnerString()) == false) goto L18;
            if (client.isAlreadyDone() == true) goto L18;
            Slog.e(FingerprintProvider.m2723$$Nest$mgetTag(this.this$0), "Stopping background authentication, currentClient: " + client);
            this.this$0.mFingerprintSensors.valueAt(i).getScheduler().cancelAuthenticationOrDetection(client.getToken(), client.getRequestId());
            goto L18
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$1tLBgDV09I_KsRs-oXSB7l5Q4iQ, reason: not valid java name */
    public static /* synthetic */ void m2711$r8$lambda$1tLBgDV09I_KsRsoXSB7l5Q4iQ(FingerprintProvider r0, int r1, BaseClientMonitor r2) {
        r0.lambda$onUdfpsUiEvent$18(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$72PbP_UmkDrirLRjOT0MeKG-kMM, reason: not valid java name */
    public static /* synthetic */ void m2712$r8$lambda$72PbP_UmkDrirLRjOT0MeKGkMM(FingerprintProvider r0, AuthenticationStatsCollector r1) {
        r0.lambda$initAuthenticationBroadcastReceiver$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$A4F9kkhbIJeHbRpZf26yVMsvuJw(FingerprintProvider r0) {
        r0.lambda$binderDied$20();
    }

    public static /* synthetic */ void $r8$lambda$FxHmr12DHMsBpMP1GuGipE55KJI(FingerprintProvider r0, int r1) {
        r0.lambda$addHidlSensors$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$G5F60btAbe55dRZa7ZrvbzyOl4Y(FingerprintProvider r0, int r1, IBinder r2, long r3) {
        r0.lambda$cancelAuthentication$12(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$GKDHtLTZo8kTP9SiLECkPyoybRs(FingerprintProvider r0, PointerContext r1, BaseClientMonitor r2) {
        r0.lambda$onPointerDown$16(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$J0YCPp7ym08QfGylR8UXQdjy8-o, reason: not valid java name */
    public static /* synthetic */ void m2713$r8$lambda$J0YCPp7ym08QfGylR8UXQdjy8o(FingerprintProvider r0, int r1, int r2) {
        r0.lambda$scheduleLoadAuthenticatorIdsForUser$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$NApmjDRXTrVEqXPaLbI9rEnPAAI(FingerprintProvider r0, int r1, IBinder r2, int r3, String r4, long r5) {
        r0.lambda$scheduleRevokeChallenge$6(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$OIviNmy2AAfFbf5v7xaGozQ0KA8(FingerprintProvider r0, int r1, IBinder r2, long r3, IFingerprintServiceReceiver r5, int r6, byte[] r7, String r8, int r9, FingerprintEnrollOptions r10) {
        r0.lambda$scheduleEnroll$7(r1, r2, r3, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ void $r8$lambda$WfHh6xGS2tV06mzd4MnWTXmaG5A(FingerprintProvider r0, int r1, int r2) {
        r0.lambda$scheduleInvalidationRequest$3(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$XtXe03HdldLDrN_KmbOTdMeoY_8(FingerprintProvider r0, FingerprintAuthenticateOptions r1, IBinder r2, long r3, ClientMonitorCallbackConverter r5, long r6, boolean r8, int r9, int r10, boolean r11) {
        r0.lambda$scheduleAuthenticate$10(r1, r2, r3, r5, r6, r8, r9, r10, r11);
    }

    /* JADX INFO: renamed from: $r8$lambda$cbwyniobjPUXy-K_OADOJcIHvPs, reason: not valid java name */
    public static /* synthetic */ void m2714$r8$lambda$cbwyniobjPUXyK_OADOJcIHvPs(FingerprintProvider r0, int r1, IBinder r2, IFingerprintServiceReceiver r3, int r4, String r5) {
        r0.lambda$scheduleGenerateChallenge$5(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$f3mMoxnzb2TmOrNK5KSnXG4fl9M(FingerprintProvider r0, int r1, int r2, IInvalidationCallback r3) {
        r0.lambda$scheduleInvalidateAuthenticatorId$15(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$hJBb1vqDM1iWbOLWZ2ao0gZ67yM(FingerprintProvider r0, int r1, int r2) {
        r0.lambda$startPreparedClient$11(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$iriqxn-VH4fNimtEsxwjAzP0gq0, reason: not valid java name */
    public static /* synthetic */ void m2715$r8$lambda$iriqxnVH4fNimtEsxwjAzP0gq0(FingerprintProvider r0, PointerContext r1, BaseClientMonitor r2) {
        r0.lambda$onPointerUp$17(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$jpURe8PSNCK0EeBM_D-a3O0t4Sk, reason: not valid java name */
    public static /* synthetic */ void m2716$r8$lambda$jpURe8PSNCK0EeBM_Da3O0t4Sk(FingerprintProvider r0, int r1, IBinder r2, IFingerprintServiceReceiver r3, int[] r4, int r5, String r6) {
        r0.lambda$scheduleRemoveSpecifiedIds$13(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$m0WtlN6aO_fj1Hky3uWk7TYU_Ok(FingerprintProvider r0, FingerprintAuthenticateOptions r1, IBinder r2, long r3, ClientMonitorCallbackConverter r5, int r6) {
        r0.lambda$scheduleFingerDetect$9(r1, r2, r3, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$rSyzPVc2q9vb7oJ02YE_BLtcAOo(FingerprintProvider r0, int r1, int r2, byte[] r3) {
        r0.lambda$scheduleResetLockout$4(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$uhgxnAStb128-rtLqAjkcwFDElQ, reason: not valid java name */
    public static /* synthetic */ void m2717$r8$lambda$uhgxnAStb128rtLqAjkcwFDElQ(FingerprintProvider r0, int r1, IBinder r2, long r3) {
        r0.lambda$cancelEnrollment$8(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$wfezxlZ5_nE95dJiCOpxNNNkLcI(FingerprintProvider r0, int r1, int r2, boolean r3, ClientMonitorCallback r4) {
        r0.lambda$scheduleInternalCleanup$14(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAuthSessionCoordinator, reason: not valid java name */
    static /* bridge */ /* synthetic */ AuthSessionCoordinator m2718$$Nest$fgetmAuthSessionCoordinator(FingerprintProvider r0) {
        return r0.mAuthSessionCoordinator;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBiometricHandlerProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ BiometricHandlerProvider m2719$$Nest$fgetmBiometricHandlerProvider(FingerprintProvider r0) {
        return r0.mBiometricHandlerProvider;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBiometricStateCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ BiometricStateCallback m2720$$Nest$fgetmBiometricStateCallback(FingerprintProvider r0) {
        return r0.mBiometricStateCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m2721$$Nest$fgetmContext(FingerprintProvider r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m2722$$Nest$fgetmHandler(FingerprintProvider r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetTag, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2723$$Nest$mgetTag(FingerprintProvider r0) {
        return r0.getTag();
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceProvider
    public /* bridge */ /* synthetic */ SensorPropertiesInternal getSensorProperties(int r1) {
        return m2724getSensorProperties(r1);
    }

    public FingerprintProvider(Context context, BiometricStateCallback biometricStateCallback, AuthenticationStateListeners authenticationStateListeners, SensorProps[] props, String halInstanceName, LockoutResetDispatcher lockoutResetDispatcher, GestureAvailabilityDispatcher gestureAvailabilityDispatcher, BiometricContext biometricContext, boolean resetLockoutRequiresHardwareAuthToken) {
        this(context, biometricStateCallback, authenticationStateListeners, props, halInstanceName, lockoutResetDispatcher, gestureAvailabilityDispatcher, biometricContext, null, BiometricHandlerProvider.getInstance(), resetLockoutRequiresHardwareAuthToken, false);
    }

    FingerprintProvider(Context context, BiometricStateCallback biometricStateCallback, AuthenticationStateListeners authenticationStateListeners, SensorProps[] props, String halInstanceName, LockoutResetDispatcher lockoutResetDispatcher, GestureAvailabilityDispatcher gestureAvailabilityDispatcher, BiometricContext biometricContext, IFingerprint daemon, BiometricHandlerProvider biometricHandlerProvider, boolean resetLockoutRequiresHardwareAuthToken, boolean testHalEnabled) {
        this.mRequestCounter = new AtomicLong(0);
        this.mContext = context;
        this.mBiometricStateCallback = biometricStateCallback;
        this.mAuthenticationStateListeners = authenticationStateListeners;
        this.mHalInstanceName = halInstanceName;
        this.mFingerprintSensors = new SensorList(ActivityManager.getService());
        this.mHandler = biometricHandlerProvider.getFingerprintHandler();
        this.mLockoutResetDispatcher = lockoutResetDispatcher;
        this.mActivityTaskManager = ActivityTaskManager.getInstance();
        this.mTaskStackListener = new BiometricTaskStackListener(this, null);
        this.mBiometricContext = biometricContext;
        this.mAuthSessionCoordinator = this.mBiometricContext.getAuthSessionCoordinator();
        this.mDaemon = daemon;
        this.mTestHalEnabled = testHalEnabled;
        this.mBiometricHandlerProvider = biometricHandlerProvider;
        initAuthenticationBroadcastReceiver();
        initFingerprintDanglingBroadcastReceiver();
        initSensors(resetLockoutRequiresHardwareAuthToken, props, gestureAvailabilityDispatcher);
        this.mZteFingerprintProvider = new ZteFingerprintProviderImpl(context, this, getTag());
    }

    private void initAuthenticationBroadcastReceiver() {
        new AuthenticationStatsBroadcastReceiver(this.mContext, 1, new FingerprintProvider$$ExternalSyntheticLambda3(this));
    }

    private /* synthetic */ void lambda$initAuthenticationBroadcastReceiver$0(AuthenticationStatsCollector collector) {
        Slog.d(getTag(), "Initializing AuthenticationStatsCollector");
        this.mAuthenticationStatsCollector = collector;
    }

    private void initFingerprintDanglingBroadcastReceiver() {
        new BiometricDanglingReceiver(this.mContext, 1);
    }

    private void initSensors(boolean resetLockoutRequiresHardwareAuthToken, SensorProps[] props, GestureAvailabilityDispatcher gestureAvailabilityDispatcher) {
        int r0 = 0;
        if (resetLockoutRequiresHardwareAuthToken == true) goto L8;
        Slog.d(getTag(), "Adding HIDL configs");
        int r1 = props.length;
    L6:
        if (r0 >= r1) goto L12;
        SensorProps sensorConfig = props[r0];
        addHidlSensors(sensorConfig, gestureAvailabilityDispatcher, resetLockoutRequiresHardwareAuthToken);
        r0 = r0 + 1;
        goto L6
    L12:
        return;
    L8:
        Slog.d(getTag(), "Adding AIDL configs");
        List<SensorLocationInternal> workaroundLocations = getWorkaroundSensorProps(this.mContext);
        int r2 = props.length;
    L10:
        if (r0 >= r2) goto L15;
        SensorProps prop = props[r0];
        addAidlSensors(prop, gestureAvailabilityDispatcher, workaroundLocations, resetLockoutRequiresHardwareAuthToken);
        r0 = r0 + 1;
        goto L10
    }

    private void addHidlSensors(SensorProps prop, GestureAvailabilityDispatcher gestureAvailabilityDispatcher, boolean resetLockoutRequiresHardwareAuthToken) {
        final int sensorId = prop.commonProps.sensorId;
        Sensor sensor = new HidlToAidlSensorAdapter(this, this.mContext, this.mHandler, prop, this.mLockoutResetDispatcher, this.mBiometricContext, resetLockoutRequiresHardwareAuthToken, new FingerprintProvider$$ExternalSyntheticLambda7(this, sensorId));
        sensor.init(gestureAvailabilityDispatcher, this.mLockoutResetDispatcher);
        if (sensor.getLazySession().get() != null) goto L5;
        int sessionUserId = ProcessList.INVALID_ADJ;
    L6:
        this.mFingerprintSensors.addSensor(sensorId, sensor, sessionUserId, new AnonymousClass1(this, sensorId));
        Slog.d(getTag(), "Added: " + this.mFingerprintSensors.get(sensorId).toString());
        return;
    L5:
        sessionUserId = sensor.getLazySession().get().getUserId();
        goto L6
    }

    private /* synthetic */ void lambda$addHidlSensors$1(int sensorId) {
        scheduleInternalCleanup(sensorId, ActivityManager.getCurrentUser(), null);
    }

    private void addAidlSensors(SensorProps prop, GestureAvailabilityDispatcher gestureAvailabilityDispatcher, List<SensorLocationInternal> workaroundLocations, boolean resetLockoutRequiresHardwareAuthToken) {
        final int sensorId = prop.commonProps.sensorId;
        Sensor sensor = new Sensor(this, this.mContext, this.mHandler, prop, this.mBiometricContext, workaroundLocations, resetLockoutRequiresHardwareAuthToken);
        sensor.init(gestureAvailabilityDispatcher, this.mLockoutResetDispatcher);
        if (sensor.getLazySession().get() != null) goto L5;
        int sessionUserId = ProcessList.INVALID_ADJ;
    L6:
        this.mFingerprintSensors.addSensor(sensorId, sensor, sessionUserId, new AnonymousClass2(this, sensorId));
        Slog.d(getTag(), "Added: " + this.mFingerprintSensors.get(sensorId).toString());
        return;
    L5:
        sessionUserId = sensor.getLazySession().get().getUserId();
        goto L6
    }

    private String getTag() {
        return "FingerprintProvider/" + this.mHalInstanceName;
    }

    boolean hasHalInstance() {
        if (this.mTestHalEnabled == false) goto L6;
        return true;
    L6:
        if (ServiceManager.checkService(FingerprintSensorConfigurations.remapFqName(IFingerprint.DESCRIPTOR + SliceClientPermissions.SliceAuthority.DELIMITER + this.mHalInstanceName)) != null) goto L10;
        return false;
    L10:
        return true;
    }

    synchronized IFingerprint getHalInstance() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mTestHalEnabled == false) goto L11;
        TestHal r0 = new TestHal();     // Catch: Throwable -> L8
        monitor-exit(this);
        return r0;
    L11:
        if (this.mHalInstanceNameCurrent != null) goto L14;
        this.mHalInstanceNameCurrent = this.mHalInstanceName;     // Catch: Throwable -> L8
    L19:
        if (this.mDaemon == null) goto L23;
        IFingerprint r1 = this.mDaemon;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r1;
    L23:
        Slog.d(getTag(), "Daemon was null, reconnecting");     // Catch: Throwable -> L8
        this.mDaemon = FingerprintSensorConfigurations.getIFingerprint(IFingerprint.DESCRIPTOR + SliceClientPermissions.SliceAuthority.DELIMITER + this.mHalInstanceNameCurrent);     // Catch: Throwable -> L8
        if (this.mDaemon != null) goto L48;
        Slog.e(getTag(), "Unable to get daemon");     // Catch: Throwable -> L8
        monitor-exit(this);
        return null;
    L48:
        this.mDaemon.asBinder().linkToDeath(this, 0);     // Catch: Throwable -> L8 RemoteException -> L31
    L33:
        int i = 0;
    L35:
        if (i >= this.mFingerprintSensors.size()) goto L38;
        int sensorId = this.mFingerprintSensors.keyAt(i);     // Catch: Throwable -> L8
        scheduleLoadAuthenticatorIds(sensorId);     // Catch: Throwable -> L8
        scheduleInternalCleanup(sensorId, ActivityManager.getCurrentUser(), null);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L35
    L38:
        if (Build.isDebuggable() == false) goto L43;
        BiometricUtils<Fingerprint> utils = this.mFingerprintSensors.get(this.mFingerprintSensors.keyAt(0)).getFingerprintUtilsInstance();     // Catch: Throwable -> L8
        Iterator r2 = UserManager.get(this.mContext).getAliveUsers().iterator();     // Catch: Throwable -> L8
    L41:
        if (r2.hasNext() == false) goto L43;
        UserInfo user = (UserInfo) r2.next();     // Catch: Throwable -> L8
        List<Fingerprint> enrollments = utils.getBiometricsForUser(this.mContext, user.id);     // Catch: Throwable -> L8
        Slog.d(getTag(), "Expecting enrollments for user " + user.id + ": " + enrollments.stream().map(new FingerprintProvider$$ExternalSyntheticLambda14()).toList());     // Catch: Throwable -> L8
    L43:
        IFingerprint r3 = this.mDaemon;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r3;
    L31:
        e = move-exception;
        Slog.e(getTag(), "Unable to linkToDeath", e);     // Catch: Throwable -> L8
        goto L33
    L14:
        if (this.mHalInstanceNameCurrent.contains("virtual") == false) goto L19;
        if (this.mHalInstanceNameCurrent == this.mHalInstanceName) goto L19;
        Slog.i(getTag(), "Switching fingerprint from virtual hal to " + this.mHalInstanceName);     // Catch: Throwable -> L8
        this.mHalInstanceNameCurrent = this.mHalInstanceName;     // Catch: Throwable -> L8
        this.mDaemon = null;     // Catch: Throwable -> L8
        goto L19
    }

    private void scheduleForSensor(int sensorId, BaseClientMonitor client) {
        if (this.mFingerprintSensors.contains(sensorId) == false) goto L7;
        this.mFingerprintSensors.get(sensorId).getScheduler().scheduleClientMonitor(client);
        return;
    L7:
        throw new IllegalStateException("Unable to schedule client: " + client + " for sensor: " + sensorId);
    }

    private void scheduleForSensor(int sensorId, BaseClientMonitor client, ClientMonitorCallback callback) {
        if (this.mFingerprintSensors.contains(sensorId) == false) goto L7;
        this.mFingerprintSensors.get(sensorId).getScheduler().scheduleClientMonitor(client, callback);
        return;
    L7:
        throw new IllegalStateException("Unable to schedule client: " + client + " for sensor: " + sensorId);
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceProvider
    public boolean containsSensor(int sensorId) {
        return this.mFingerprintSensors.contains(sensorId);
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceProvider
    public List<FingerprintSensorPropertiesInternal> getSensorProperties() {
        List<FingerprintSensorPropertiesInternal> props = new ArrayList();
        int i = 0;
    L4:
        if (i >= this.mFingerprintSensors.size()) goto L7;
        props.add(this.mFingerprintSensors.valueAt(i).getSensorProperties());
        i = i + 1;
        goto L4
    L7:
        return props;
    }

    /* JADX INFO: renamed from: getSensorProperties, reason: collision with other method in class */
    public FingerprintSensorPropertiesInternal m2724getSensorProperties(int sensorId) {
        if (this.mFingerprintSensors.size() != 0) goto L6;
        return null;
    L6:
        if (sensorId == (-1)) goto L8;
        Sensor sensor = this.mFingerprintSensors.get(sensorId);
        if (sensor != null) goto L12;
        return null;
    L12:
        return sensor.getSensorProperties();
    L8:
        return this.mFingerprintSensors.valueAt(0).getSensorProperties();
    }

    private void scheduleLoadAuthenticatorIds(int sensorId) {
        Iterator r0 = UserManager.get(this.mContext).getAliveUsers().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        UserInfo user = (UserInfo) r0.next();
        scheduleLoadAuthenticatorIdsForUser(sensorId, user.id);
        goto L4
    }

    protected void scheduleLoadAuthenticatorIdsForUser(final int sensorId, final int userId) {
        this.mHandler.post(new FingerprintProvider$$ExternalSyntheticLambda17(this, sensorId, userId));
    }

    private /* synthetic */ void lambda$scheduleLoadAuthenticatorIdsForUser$2(int sensorId, int userId) {
        FingerprintGetAuthenticatorIdClient client = new FingerprintGetAuthenticatorIdClient(this.mContext, this.mFingerprintSensors.get(sensorId).getLazySession(), userId, this.mContext.getOpPackageName(), sensorId, createLogger(0, 0, this.mAuthenticationStatsCollector), this.mBiometricContext, this.mFingerprintSensors.get(sensorId).getAuthenticatorIds());
        scheduleForSensor(sensorId, client);
    }

    void scheduleInvalidationRequest(final int sensorId, final int userId) {
        this.mHandler.post(new FingerprintProvider$$ExternalSyntheticLambda15(this, userId, sensorId));
    }

    private /* synthetic */ void lambda$scheduleInvalidationRequest$3(int userId, int sensorId) {
        InvalidationRequesterClient<Fingerprint> client = new InvalidationRequesterClient(this.mContext, userId, sensorId, BiometricLogger.ofUnknown(this.mContext), this.mBiometricContext, this.mFingerprintSensors.get(sensorId).getFingerprintUtilsInstance());
        scheduleForSensor(sensorId, client);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void scheduleResetLockout(final int sensorId, final int userId, final byte[] hardwareAuthToken) {
        this.mHandler.post(new FingerprintProvider$$ExternalSyntheticLambda8(this, sensorId, userId, hardwareAuthToken));
    }

    private /* synthetic */ void lambda$scheduleResetLockout$4(int sensorId, int userId, byte[] hardwareAuthToken) {
        FingerprintResetLockoutClient client = new FingerprintResetLockoutClient(this.mContext, this.mFingerprintSensors.get(sensorId).getLazySession(), userId, this.mContext.getOpPackageName(), sensorId, createLogger(0, 0, this.mAuthenticationStatsCollector), this.mBiometricContext, hardwareAuthToken, this.mFingerprintSensors.get(sensorId).getLockoutTracker(false), this.mLockoutResetDispatcher, Utils.getCurrentStrength(sensorId));
        scheduleForSensor(sensorId, client);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void scheduleGenerateChallenge(final int sensorId, final int userId, final IBinder token, final IFingerprintServiceReceiver receiver, final String opPackageName) {
        this.mHandler.post(new FingerprintProvider$$ExternalSyntheticLambda1(this, sensorId, token, receiver, userId, opPackageName));
    }

    private /* synthetic */ void lambda$scheduleGenerateChallenge$5(int sensorId, IBinder token, IFingerprintServiceReceiver receiver, int userId, String opPackageName) {
        FingerprintGenerateChallengeClient client = new FingerprintGenerateChallengeClient(this.mContext, this.mFingerprintSensors.get(sensorId).getLazySession(), token, new ClientMonitorCallbackConverter(receiver), userId, opPackageName, sensorId, createLogger(0, 0, this.mAuthenticationStatsCollector), this.mBiometricContext);
        scheduleForSensor(sensorId, client);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void scheduleRevokeChallenge(final int sensorId, final int userId, final IBinder token, final String opPackageName, final long challenge) {
        this.mHandler.post(new FingerprintProvider$$ExternalSyntheticLambda2(this, sensorId, token, userId, opPackageName, challenge));
    }

    private /* synthetic */ void lambda$scheduleRevokeChallenge$6(int sensorId, IBinder token, int userId, String opPackageName, long challenge) {
        FingerprintRevokeChallengeClient client = new FingerprintRevokeChallengeClient(this.mContext, this.mFingerprintSensors.get(sensorId).getLazySession(), token, userId, opPackageName, sensorId, createLogger(0, 0, this.mAuthenticationStatsCollector), this.mBiometricContext, challenge);
        scheduleForSensor(sensorId, client);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public long scheduleEnroll(final int sensorId, final IBinder token, final byte[] hardwareAuthToken, final int userId, final IFingerprintServiceReceiver receiver, final String opPackageName, final int enrollReason, final FingerprintEnrollOptions options) {
        final long id = this.mRequestCounter.incrementAndGet();
        this.mHandler.post(new FingerprintProvider$$ExternalSyntheticLambda10(this, sensorId, token, id, receiver, userId, hardwareAuthToken, opPackageName, enrollReason, options));
        return id;
    }

    private /* synthetic */ void lambda$scheduleEnroll$7(int sensorId, IBinder token, long id, IFingerprintServiceReceiver receiver, int userId, byte[] hardwareAuthToken, String opPackageName, int enrollReason, FingerprintEnrollOptions options) {
        int maxTemplatesPerUser = this.mFingerprintSensors.get(sensorId).getSensorProperties().maxEnrollmentsPerUser;
        FingerprintEnrollClient client = new FingerprintEnrollClient(this.mContext, this.mFingerprintSensors.get(sensorId).getLazySession(), token, id, new ClientMonitorCallbackConverter(receiver), userId, hardwareAuthToken, opPackageName, this.mFingerprintSensors.get(sensorId).getFingerprintUtilsInstance(), sensorId, createLogger(1, 0, this.mAuthenticationStatsCollector), this.mBiometricContext, this.mFingerprintSensors.get(sensorId).getSensorProperties(), this.mUdfpsOverlayController, this.mAuthenticationStateListeners, maxTemplatesPerUser, enrollReason, options);
        Slog.d(getTag(), "scheduleEnroll route: sensorId=" + sensorId + ", userId=" + userId + ", requestId=" + id + ", owner=" + opPackageName + ", scheduler=" + this.mFingerprintSensors.get(sensorId).getScheduler());
        scheduleForSensor(sensorId, client, this.mBiometricStateCallback);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void cancelEnrollment(final int sensorId, final IBinder token, final long requestId) {
        this.mHandler.post(new FingerprintProvider$$ExternalSyntheticLambda20(this, sensorId, token, requestId));
    }

    private /* synthetic */ void lambda$cancelEnrollment$8(int sensorId, IBinder token, long requestId) {
        this.mFingerprintSensors.get(sensorId).getScheduler().cancelEnrollment(token, requestId);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public long scheduleFingerDetect(final IBinder token, final ClientMonitorCallbackConverter callback, final FingerprintAuthenticateOptions options, final int statsClient) {
        final long id = this.mRequestCounter.incrementAndGet();
        this.mHandler.post(new FingerprintProvider$$ExternalSyntheticLambda13(this, options, token, id, callback, statsClient));
        return id;
    }

    private /* synthetic */ void lambda$scheduleFingerDetect$9(FingerprintAuthenticateOptions options, IBinder token, long id, ClientMonitorCallbackConverter callback, int statsClient) {
        int sensorId = options.getSensorId();
        boolean isStrongBiometric = Utils.isStrongBiometric(sensorId);
        FingerprintDetectClient client = new FingerprintDetectClient(this.mContext, this.mFingerprintSensors.get(sensorId).getLazySession(), token, id, callback, options, createLogger(2, statsClient, this.mAuthenticationStatsCollector), this.mBiometricContext, this.mAuthenticationStateListeners, this.mUdfpsOverlayController, isStrongBiometric);
        scheduleForSensor(sensorId, client, this.mBiometricStateCallback);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void scheduleAuthenticate(final IBinder token, final long operationId, final int cookie, final ClientMonitorCallbackConverter callback, final FingerprintAuthenticateOptions options, final long requestId, final boolean restricted, final int statsClient, final boolean allowBackgroundAuthentication) {
        this.mHandler.post(new FingerprintProvider$$ExternalSyntheticLambda4(this, options, token, requestId, callback, operationId, restricted, cookie, statsClient, allowBackgroundAuthentication));
    }

    private /* synthetic */ void lambda$scheduleAuthenticate$10(FingerprintAuthenticateOptions options, IBinder token, long requestId, ClientMonitorCallbackConverter callback, long operationId, boolean restricted, int cookie, int statsClient, boolean allowBackgroundAuthentication) {
        int userId = options.getUserId();
        int sensorId = options.getSensorId();
        boolean isStrongBiometric = Utils.isStrongBiometric(sensorId);
        LockoutTracker lockoutTracker = this.mFingerprintSensors.get(sensorId).getLockoutTracker(true);
        FingerprintAuthenticationClient client = new FingerprintAuthenticationClient(this.mContext, this.mFingerprintSensors.get(sensorId).getLazySession(), token, requestId, callback, operationId, restricted, options, cookie, false, createLogger(2, statsClient, this.mAuthenticationStatsCollector), this.mBiometricContext, isStrongBiometric, this.mTaskStackListener, this.mUdfpsOverlayController, this.mAuthenticationStateListeners, allowBackgroundAuthentication, this.mFingerprintSensors.get(sensorId).getSensorProperties(), Utils.getCurrentStrength(sensorId), lockoutTracker);
        scheduleForSensor(sensorId, client, new AnonymousClass3(this, sensorId, userId, requestId, callback));
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public long scheduleAuthenticate(IBinder token, long operationId, int cookie, ClientMonitorCallbackConverter callback, FingerprintAuthenticateOptions options, boolean restricted, int statsClient, boolean allowBackgroundAuthentication) {
        long id = this.mRequestCounter.incrementAndGet();
        scheduleAuthenticate(token, operationId, cookie, callback, options, id, restricted, statsClient, allowBackgroundAuthentication);
        return id;
    }

    private /* synthetic */ void lambda$startPreparedClient$11(int sensorId, int cookie) {
        this.mFingerprintSensors.get(sensorId).getScheduler().startPreparedClient(cookie);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void startPreparedClient(final int sensorId, final int cookie) {
        this.mHandler.post(new FingerprintProvider$$ExternalSyntheticLambda9(this, sensorId, cookie));
    }

    private /* synthetic */ void lambda$cancelAuthentication$12(int sensorId, IBinder token, long requestId) {
        this.mFingerprintSensors.get(sensorId).getScheduler().cancelAuthenticationOrDetection(token, requestId);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void cancelAuthentication(final int sensorId, final IBinder token, final long requestId) {
        this.mHandler.post(new FingerprintProvider$$ExternalSyntheticLambda16(this, sensorId, token, requestId));
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void scheduleRemove(int sensorId, IBinder token, IFingerprintServiceReceiver receiver, int fingerId, int userId, String opPackageName) {
        scheduleRemoveSpecifiedIds(sensorId, token, new int[]{fingerId}, userId, receiver, opPackageName);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void scheduleRemoveAll(int sensorId, IBinder token, IFingerprintServiceReceiver receiver, int userId, String opPackageName) {
        List<Fingerprint> fingers = this.mFingerprintSensors.get(sensorId).getFingerprintUtilsInstance().getBiometricsForUser(this.mContext, userId);
        int[] fingerIds = new int[fingers.size()];
        int i = 0;
    L4:
        if (i >= fingers.size()) goto L6;
        fingerIds[i] = fingers.get(i).getBiometricId();
        i = i + 1;
        goto L4
    L6:
        scheduleRemoveSpecifiedIds(sensorId, token, fingerIds, userId, receiver, opPackageName);
    }

    private void scheduleRemoveSpecifiedIds(final int sensorId, final IBinder token, final int[] fingerprintIds, final int userId, final IFingerprintServiceReceiver receiver, final String opPackageName) {
        this.mHandler.post(new FingerprintProvider$$ExternalSyntheticLambda5(this, sensorId, token, receiver, fingerprintIds, userId, opPackageName));
    }

    private /* synthetic */ void lambda$scheduleRemoveSpecifiedIds$13(int sensorId, IBinder token, IFingerprintServiceReceiver receiver, int[] fingerprintIds, int userId, String opPackageName) {
        FingerprintRemovalClient client = new FingerprintRemovalClient(this.mContext, this.mFingerprintSensors.get(sensorId).getLazySession(), token, new ClientMonitorCallbackConverter(receiver), fingerprintIds, userId, opPackageName, this.mFingerprintSensors.get(sensorId).getFingerprintUtilsInstance(), sensorId, createLogger(4, 0, this.mAuthenticationStatsCollector), this.mBiometricContext, this.mFingerprintSensors.get(sensorId).getAuthenticatorIds(), 3);
        scheduleForSensor(sensorId, client, this.mBiometricStateCallback);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void scheduleInternalCleanup(int sensorId, int userId, ClientMonitorCallback callback) {
        scheduleInternalCleanup(sensorId, userId, callback, false);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void scheduleInternalCleanup(final int sensorId, final int userId, final ClientMonitorCallback callback, final boolean favorHalEnrollments) {
        this.mHandler.post(new FingerprintProvider$$ExternalSyntheticLambda11(this, sensorId, userId, favorHalEnrollments, callback));
    }

    private /* synthetic */ void lambda$scheduleInternalCleanup$14(int sensorId, int userId, boolean favorHalEnrollments, ClientMonitorCallback callback) {
        FingerprintInternalCleanupClient client = new FingerprintInternalCleanupClient(this.mContext, this.mFingerprintSensors.get(sensorId).getLazySession(), userId, this.mContext.getOpPackageName(), sensorId, createLogger(3, 0, this.mAuthenticationStatsCollector), this.mBiometricContext, this.mFingerprintSensors.get(sensorId).getFingerprintUtilsInstance(), this.mFingerprintSensors.get(sensorId).getAuthenticatorIds());
        if (favorHalEnrollments == false) goto L5;
        client.setFavorHalEnrollments();
    L5:
        scheduleForSensor(sensorId, client, new ClientMonitorCompositeCallback(new ClientMonitorCallback[]{callback, this.mBiometricStateCallback}));
    }

    private BiometricLogger createLogger(int statsAction, int statsClient, AuthenticationStatsCollector authenticationStatsCollector) {
        return new BiometricLogger(this.mContext, 1, statsAction, statsClient, authenticationStatsCollector);
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceProvider
    public boolean isHardwareDetected(int sensorId) {
        return this.mFingerprintSensors.get(sensorId).isHardwareDetected(this.mHalInstanceName);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void rename(int sensorId, int fingerId, int userId, String name) {
        this.mFingerprintSensors.get(sensorId).getFingerprintUtilsInstance().renameBiometricForUser(this.mContext, userId, fingerId, name);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public List<Fingerprint> getEnrolledFingerprints(int sensorId, int userId) {
        return this.mFingerprintSensors.get(sensorId).getFingerprintUtilsInstance().getBiometricsForUser(this.mContext, userId);
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceProvider
    public boolean hasEnrollments(int sensorId, int userId) {
        return !getEnrolledFingerprints(sensorId, userId).isEmpty();
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void scheduleInvalidateAuthenticatorId(final int sensorId, final int userId, final IInvalidationCallback callback) {
        this.mHandler.post(new FingerprintProvider$$ExternalSyntheticLambda0(this, sensorId, userId, callback));
    }

    private /* synthetic */ void lambda$scheduleInvalidateAuthenticatorId$15(int sensorId, int userId, IInvalidationCallback callback) {
        FingerprintInvalidationClient client = new FingerprintInvalidationClient(this.mContext, this.mFingerprintSensors.get(sensorId).getLazySession(), userId, sensorId, createLogger(0, 0, this.mAuthenticationStatsCollector), this.mBiometricContext, this.mFingerprintSensors.get(sensorId).getAuthenticatorIds(), callback);
        scheduleForSensor(sensorId, client);
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceProvider
    public int getLockoutModeForUser(int sensorId, int userId) {
        return this.mFingerprintSensors.get(sensorId).getLockoutModeForUser(userId);
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceProvider
    public long getAuthenticatorId(int sensorId, int userId) {
        return this.mFingerprintSensors.get(sensorId).getAuthenticatorIds().getOrDefault(Integer.valueOf(userId), 0L).longValue();
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void onPointerDown(long requestId, int sensorId, final PointerContext pc) {
        this.mFingerprintSensors.get(sensorId).getScheduler().getCurrentClientIfMatches(requestId, new FingerprintProvider$$ExternalSyntheticLambda19(this, pc));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$onPointerDown$16(PointerContext pc, BaseClientMonitor r5) {
        if ((r5 instanceof Udfps) == true) goto L6;
        Slog.e(getTag(), "onPointerDown received during client: " + r5);
        return;
    L6:
        ((Udfps) r5).onPointerDown(pc);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void onPointerUp(long requestId, int sensorId, final PointerContext pc) {
        this.mFingerprintSensors.get(sensorId).getScheduler().getCurrentClientIfMatches(requestId, new FingerprintProvider$$ExternalSyntheticLambda6(this, pc));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$onPointerUp$17(PointerContext pc, BaseClientMonitor r5) {
        if ((r5 instanceof Udfps) == true) goto L6;
        Slog.e(getTag(), "onPointerUp received during client: " + r5);
        return;
    L6:
        ((Udfps) r5).onPointerUp(pc);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void onUdfpsUiEvent(final int event, long requestId, int sensorId) {
        this.mFingerprintSensors.get(sensorId).getScheduler().getCurrentClientIfMatches(requestId, new FingerprintProvider$$ExternalSyntheticLambda12(this, event));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$onUdfpsUiEvent$18(int event, BaseClientMonitor r5) {
        if ((r5 instanceof Udfps) == true) goto L6;
        Slog.e(getTag(), "onUdfpsUiEvent received during client: " + r5);
        return;
    L6:
        ((Udfps) r5).onUdfpsUiEvent(event);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void setUdfpsOverlayController(IUdfpsOverlayController controller) {
        this.mUdfpsOverlayController = controller;
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void setIgnoreDisplayTouches(long requestId, int sensorId, boolean ignoreTouches) {
        this.mFingerprintSensors.get(sensorId).getLazySession().get().getSession().setIgnoreDisplayTouches(ignoreTouches);     // Catch: Exception -> L4
        Slog.d(getTag(), "setIgnoreDisplayTouches set to " + ignoreTouches);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(getTag(), "setIgnore failed", e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$setIgnoreDisplayTouches$19(boolean ignoreTouches, BaseClientMonitor r5) {
        if ((r5 instanceof Udfps) == true) goto L6;
        Slog.e(getTag(), "setIgnoreDisplayTouches received during client: " + r5);
        return;
    L6:
        ((Udfps) r5).setIgnoreDisplayTouches(ignoreTouches);
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void onPowerPressed() {
        int i = 0;
    L4:
        if (i >= this.mFingerprintSensors.size()) goto L14;
        Sensor sensor = this.mFingerprintSensors.valueAt(i);
        IBinder.DeathRecipient r2 = sensor.getScheduler().getCurrentClient();
        if (r2 == null) goto L7;
        if ((r2 instanceof PowerPressHandler) == false) goto L12;
        ((PowerPressHandler) r2).onPowerPressed();
    L12:
        i = i + 1;
        goto L4
    L7:
        return;
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceProvider
    public void dumpProtoState(int sensorId, ProtoOutputStream proto, boolean clearSchedulerBuffer) {
        if (this.mFingerprintSensors.contains(sensorId) == false) goto L6;
        this.mFingerprintSensors.get(sensorId).dumpProtoState(sensorId, proto, clearSchedulerBuffer);
        return;
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceProvider
    public void dumpProtoMetrics(int sensorId, FileDescriptor fd) {
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceProvider
    public void dumpInternal(int sensorId, PrintWriter r12) {
        PerformanceTracker performanceTracker = PerformanceTracker.getInstanceForSensorId(sensorId);
        JSONObject r1 = new JSONObject();
        r1.put(HostingRecord.HOSTING_TYPE_SERVICE, getTag());     // Catch: JSONException -> L7
        JSONArray sets = new JSONArray();     // Catch: JSONException -> L7
        Iterator r3 = UserManager.get(this.mContext).getUsers().iterator();     // Catch: JSONException -> L7
    L5:
        if (r3.hasNext() == false) goto L9;
        UserInfo user = (UserInfo) r3.next();     // Catch: JSONException -> L7
        int userId = user.getUserHandle().getIdentifier();     // Catch: JSONException -> L7
        int c = this.mFingerprintSensors.get(sensorId).getFingerprintUtilsInstance().getBiometricsForUser(this.mContext, userId).size();     // Catch: JSONException -> L7
        JSONObject set = new JSONObject();     // Catch: JSONException -> L7
        set.put("id", userId);     // Catch: JSONException -> L7
        set.put(AssistDataRequester.KEY_RECEIVER_EXTRA_COUNT, c);     // Catch: JSONException -> L7
        set.put("accept", performanceTracker.getAcceptForUser(userId));     // Catch: JSONException -> L7
        set.put("reject", performanceTracker.getRejectForUser(userId));     // Catch: JSONException -> L7
        set.put("acquire", performanceTracker.getAcquireForUser(userId));     // Catch: JSONException -> L7
        set.put("lockout", performanceTracker.getTimedLockoutForUser(userId));     // Catch: JSONException -> L7
        set.put("permanentLockout", performanceTracker.getPermanentLockoutForUser(userId));     // Catch: JSONException -> L7
        set.put("acceptCrypto", performanceTracker.getAcceptCryptoForUser(userId));     // Catch: JSONException -> L7
        set.put("rejectCrypto", performanceTracker.getRejectCryptoForUser(userId));     // Catch: JSONException -> L7
        set.put("acquireCrypto", performanceTracker.getAcquireCryptoForUser(userId));     // Catch: JSONException -> L7
        sets.put(set);     // Catch: JSONException -> L7
        goto L5
    L9:
        r1.put("prints", sets);     // Catch: JSONException -> L7
    L12:
        r12.println(r1);
        r12.println("HAL deaths since last reboot: " + performanceTracker.getHALDeathCount());
        r12.println("---AuthSessionCoordinator logs begin---");
        r12.println(this.mBiometricContext.getAuthSessionCoordinator());
        r12.println("---AuthSessionCoordinator logs end  ---");
        r12.println("Cached authenticatorIds: " + this.mFingerprintSensors.get(sensorId).getAuthenticatorIds());
        this.mFingerprintSensors.get(sensorId).getScheduler().dump(r12);
        return;
    L7:
        e = move-exception;
        Slog.e(getTag(), "dump formatting failure", e);
        goto L12
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public ITestSession createTestSession(int sensorId, ITestSessionCallback callback, String opPackageName) {
        return this.mFingerprintSensors.get(sensorId).createTestSession(callback, this.mBiometricStateCallback);
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Slog.e(getTag(), "HAL died");
        this.mHandler.post(new FingerprintProvider$$ExternalSyntheticLambda18(this));
    }

    private /* synthetic */ void lambda$binderDied$20() {
        this.mDaemon = null;
        binderDiedForZteCmd();
        int i = 0;
    L4:
        if (i >= this.mFingerprintSensors.size()) goto L11;
        Sensor sensor = this.mFingerprintSensors.valueAt(i);
        int sensorId = this.mFingerprintSensors.keyAt(i);
        PerformanceTracker performanceTracker = PerformanceTracker.getInstanceForSensorId(sensorId);
        if (performanceTracker == null) goto L8;
        performanceTracker.incrementHALDeathCount();
    L9:
        sensor.onBinderDied();
        i = i + 1;
        goto L4
    L8:
        Slog.w(getTag(), "Performance tracker is null. Not counting HAL death.");
        goto L9
    }

    void setTestHalEnabled(boolean enabled) {
        if (enabled == this.mTestHalEnabled) goto L5;
        boolean changed = true;
    L6:
        this.mTestHalEnabled = enabled;
        Slog.i(getTag(), "setTestHalEnabled(): useVhalForTestingFlags=false mTestHalEnabled=" + this.mTestHalEnabled + " changed=" + changed);
        if (changed == true) goto L9;
        return;
    L9:
        if (useVhalForTesting() == false) goto L13;
        getHalInstance();
        return;
    L13:
        return;
    L5:
        changed = false;
        goto L6
    }

    public boolean getTestHalEnabled() {
        return this.mTestHalEnabled;
    }

    private List<SensorLocationInternal> getWorkaroundSensorProps(Context context) {
        List<SensorLocationInternal> sensorLocations = new ArrayList();
        TypedArray sfpsProps = context.getResources().obtainTypedArray(R.array.config_udfps_enroll_stage_thresholds);
        int i = 0;
    L4:
        if (i >= sfpsProps.length()) goto L11;
        int id = sfpsProps.getResourceId(i, -1);
        if (id <= 0) goto L10;
        SensorLocationInternal location = parseSensorLocation(context.getResources().obtainTypedArray(id));
        if (location == null) goto L10;
        sensorLocations.add(location);
    L10:
        i = i + 1;
        goto L4
    L11:
        sfpsProps.recycle();
        return sensorLocations;
    }

    private SensorLocationInternal parseSensorLocation(TypedArray array) {
        if (array != null) goto L10;
        return null;
    L10:
        return new SensorLocationInternal(array.getString(0), array.getInt(1, 0), array.getInt(2, 0), array.getInt(3, 0));
    L7:
        e = move-exception;
        Slog.w(getTag(), "malformed sensor location", e);
        return null;
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void scheduleWatchdog(int sensorId) {
        Slog.d(getTag(), "Starting watchdog for fingerprint");
        BiometricScheduler<IFingerprint, ISession> r0 = this.mFingerprintSensors.get(sensorId).getScheduler();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.startWatchdog();
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.ServiceProvider
    public void simulateVhalFingerDown(int userId, int sensorId) {
        Slog.d(getTag(), "Simulate virtual HAL finger down event");
        AidlSession session = this.mFingerprintSensors.get(sensorId).getSessionForUser(userId);
        if (session != null) goto L6;
        Slog.e(getTag(), "no existing hal session found - aborting");
        return;
    L6:
        PointerContext pc = new PointerContext();
        session.getSession().onPointerDownWithContext(pc);     // Catch: RemoteException -> L9
        session.getSession().onUiReady();     // Catch: RemoteException -> L9
        session.getSession().onPointerUpWithContext(pc);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        Slog.e(getTag(), "failed hal operation ", e);
    }

    public void sendFingerprintReEnrollNotification() {
        this.mAuthenticationStatsCollector.sendFingerprintReEnrollNotification();
    }

    public IVirtualHal getVhal() throws RemoteException {
        if (this.mVhal != null) goto L8;
        if (useVhalForTesting() == false) goto L8;
        this.mVhal = IVirtualHal.Stub.asInterface(Binder.allowBlocking(ServiceManager.waitForService("android.hardware.biometrics.fingerprint.virtualhal.IVirtualHal/" + this.mHalInstanceNameCurrent)));
        Slog.d(getTag(), "getVhal " + this.mHalInstanceNameCurrent);
    L8:
        return this.mVhal;
    }

    public boolean useVhalForTesting() {
        return false;
    }

    @Override // com.android.server.biometrics.sensors.fingerprint.aidl.IZteFingerprintProvider.IZteFingerprintProviderExport
    public IZteFingerprintProvider getZteInjectInstance() {
        return this.mZteFingerprintProvider;
    }
}
