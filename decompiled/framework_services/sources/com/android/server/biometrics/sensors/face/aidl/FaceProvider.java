package com.android.server.biometrics.sensors.face.aidl;

import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.app.TaskStackListener;
import android.content.Context;
import android.content.pm.UserInfo;
import android.hardware.biometrics.IInvalidationCallback;
import android.hardware.biometrics.ITestSession;
import android.hardware.biometrics.ITestSessionCallback;
import android.hardware.biometrics.SensorPropertiesInternal;
import android.hardware.biometrics.face.IFace;
import android.hardware.biometrics.face.ISession;
import android.hardware.biometrics.face.SensorProps;
import android.hardware.biometrics.face.virtualhal.IVirtualHal;
import android.hardware.face.Face;
import android.hardware.face.FaceAuthenticateOptions;
import android.hardware.face.FaceEnrollOptions;
import android.hardware.face.FaceSensorConfigurations;
import android.hardware.face.FaceSensorPropertiesInternal;
import android.hardware.face.IFaceServiceReceiver;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserManager;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import android.view.Surface;
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
import com.android.server.biometrics.sensors.face.ServiceProvider;
import com.android.server.biometrics.sensors.face.UsageStats;
import com.android.server.biometrics.sensors.face.hidl.HidlToAidlSensorAdapter;
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
public class FaceProvider implements IBinder.DeathRecipient, ServiceProvider {
    private static final int ENROLL_TIMEOUT_SEC = 75;
    private static final String TAG = "FaceProvider";
    private final ActivityTaskManager mActivityTaskManager;
    private final AuthSessionCoordinator mAuthSessionCoordinator;
    private final AuthenticationStateListeners mAuthenticationStateListeners;
    private AuthenticationStatsCollector mAuthenticationStatsCollector;
    private final BiometricContext mBiometricContext;
    private final BiometricHandlerProvider mBiometricHandlerProvider;
    private final BiometricStateCallback mBiometricStateCallback;
    private final Context mContext;
    private IFace mDaemon;
    final SensorList<Sensor> mFaceSensors;
    private final String mHalInstanceName;
    private String mHalInstanceNameCurrent;
    private final Handler mHandler;
    private final LockoutResetDispatcher mLockoutResetDispatcher;
    private final AtomicLong mRequestCounter;
    private final BiometricTaskStackListener mTaskStackListener;
    private boolean mTestHalEnabled;
    private final UsageStats mUsageStats;
    private IVirtualHal mVhal;

    /* JADX INFO: renamed from: com.android.server.biometrics.sensors.face.aidl.FaceProvider$3, reason: invalid class name */
    class AnonymousClass3 implements ClientMonitorCallback {
        final /* synthetic */ FaceProvider this$0;
        final /* synthetic */ FaceAuthenticationClient val$client;
        final /* synthetic */ long val$requestId;
        final /* synthetic */ int val$sensorId;
        final /* synthetic */ int val$userId;

        public static /* synthetic */ void $r8$lambda$2J6kI5P_KVkNOQrgiUfEep1lllk(AnonymousClass3 r0, int r1, int r2, long r3) {
            r0.lambda$onClientStarted$0(r1, r2, r3);
        }

        /* JADX INFO: renamed from: $r8$lambda$QD1WjOw1i-Hdtlp_mmrsqgReVXQ, reason: not valid java name */
        public static /* synthetic */ void m2677$r8$lambda$QD1WjOw1iHdtlp_mmrsqgReVXQ(AnonymousClass3 r0, int r1, int r2, long r3, FaceAuthenticationClient r5) {
            r0.lambda$onClientFinished$1(r1, r2, r3, r5);
        }

        AnonymousClass3(FaceProvider this$0, int r2, int r3, long r4, FaceAuthenticationClient r6) {
            this.this$0 = this$0;
            this.val$userId = r2;
            this.val$sensorId = r3;
            this.val$requestId = r4;
            this.val$client = r6;
        }

        @Override // com.android.server.biometrics.sensors.ClientMonitorCallback
        public void onClientStarted(BaseClientMonitor clientMonitor) {
            Handler r0 = FaceProvider.m2672$$Nest$fgetmBiometricHandlerProvider(this.this$0).getBiometricCallbackHandler();
            final int r3 = this.val$userId;
            final int r4 = this.val$sensorId;
            final long r5 = this.val$requestId;
            r0.post(new FaceProvider$3$$ExternalSyntheticLambda1(this, r3, r4, r5));
        }

        private /* synthetic */ void lambda$onClientStarted$0(int userId, int sensorId, long requestId) {
            FaceProvider.m2671$$Nest$fgetmAuthSessionCoordinator(this.this$0).authStartedFor(userId, sensorId, requestId);
        }

        @Override // com.android.server.biometrics.sensors.ClientMonitorCallback
        public void onClientFinished(BaseClientMonitor clientMonitor, boolean success) {
            Handler r0 = FaceProvider.m2672$$Nest$fgetmBiometricHandlerProvider(this.this$0).getBiometricCallbackHandler();
            final int r3 = this.val$userId;
            final int r4 = this.val$sensorId;
            final long r5 = this.val$requestId;
            final FaceAuthenticationClient r7 = this.val$client;
            r0.post(new FaceProvider$3$$ExternalSyntheticLambda0(this, r3, r4, r5, r7));
        }

        private /* synthetic */ void lambda$onClientFinished$1(int userId, int sensorId, long requestId, FaceAuthenticationClient client) {
            FaceProvider.m2671$$Nest$fgetmAuthSessionCoordinator(this.this$0).authEndedFor(userId, Utils.getCurrentStrength(sensorId), sensorId, requestId, client.wasAuthSuccessful());
        }
    }

    private final class BiometricTaskStackListener extends TaskStackListener {
        final /* synthetic */ FaceProvider this$0;

        /* JADX INFO: renamed from: $r8$lambda$I3oEGrMic-koF6nmxdtLz-zwrHw, reason: not valid java name */
        public static /* synthetic */ void m2678$r8$lambda$I3oEGrMickoF6nmxdtLzzwrHw(BiometricTaskStackListener r0) {
            r0.lambda$onTaskStackChanged$0();
        }

        /* synthetic */ BiometricTaskStackListener(FaceProvider r1, FaceProviderIA r2) {
            this(r1);
        }

        private BiometricTaskStackListener(FaceProvider r1) {
            this.this$0 = r1;
        }

        public void onTaskStackChanged() {
            FaceProvider.m2674$$Nest$fgetmHandler(this.this$0).post(new FaceProvider$BiometricTaskStackListener$$ExternalSyntheticLambda0(this));
        }

        private /* synthetic */ void lambda$onTaskStackChanged$0() {
            int i = 0;
        L4:
            if (i >= this.this$0.mFaceSensors.size()) goto L20;
            BaseClientMonitor client = this.this$0.mFaceSensors.valueAt(i).getScheduler().getCurrentClient();
            if ((client instanceof AuthenticationClient) == true) goto L9;
            Slog.e(FaceProvider.m2675$$Nest$mgetTag(this.this$0), "Task stack changed for client: " + client);
        L18:
            i = i + 1;
            goto L4
        L9:
            if (Utils.isKeyguard(FaceProvider.m2673$$Nest$fgetmContext(this.this$0), client.getOwnerString()) == true) goto L18;
            if (Utils.isSystem(FaceProvider.m2673$$Nest$fgetmContext(this.this$0), client.getOwnerString()) == true) goto L18;
            if (Utils.isBackground(client.getOwnerString()) == false) goto L18;
            if (client.isAlreadyDone() == true) goto L18;
            Slog.e(FaceProvider.m2675$$Nest$mgetTag(this.this$0), "Stopping background authentication, currentClient: " + client);
            this.this$0.mFaceSensors.valueAt(i).getScheduler().cancelAuthenticationOrDetection(client.getToken(), client.getRequestId());
            goto L18
        }
    }

    public static /* synthetic */ void $r8$lambda$0szhBlathF7UIuYGzXYPVb466xQ(FaceProvider r0, int r1, IBinder r2, long r3) {
        r0.lambda$cancelAuthentication$12(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$1AAHzSOgaxnx616FUI2rby3MrDg(FaceProvider r0, int r1, int r2, byte[] r3) {
        r0.lambda$scheduleResetLockout$14(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$52IRRe2mpef2KHnvrQS-o4tsX6M, reason: not valid java name */
    public static /* synthetic */ void m2664$r8$lambda$52IRRe2mpef2KHnvrQSo4tsX6M(FaceProvider r0, int r1, IBinder r2, long r3, ClientMonitorCallbackConverter r5, FaceAuthenticateOptions r6, int r7) {
        r0.lambda$scheduleFaceDetect$9(r1, r2, r3, r5, r6, r7);
    }

    public static /* synthetic */ void $r8$lambda$7qEvNN9u60gc1PiQy2mEZQ9aMqc(FaceProvider r0, int r1, int r2) {
        r0.lambda$scheduleInvalidationRequest$3(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$AanoTywbm6iMIkTMEx7XdT__sy4(FaceProvider r0, int r1, int r2, boolean r3, ClientMonitorCallback r4) {
        r0.lambda$scheduleInternalCleanup$18(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$AqrutDsLyNsOm1YZqvDylBw4K48(FaceProvider r0, int r1, int r2, IBinder r3, IFaceServiceReceiver r4, byte[] r5, String r6, long r7, int[] r9, Surface r10, boolean r11, FaceEnrollOptions r12) {
        r0.lambda$scheduleEnroll$7(r1, r2, r3, r4, r5, r6, r7, r9, r10, r11, r12);
    }

    public static /* synthetic */ void $r8$lambda$C79dGijnPRSz2eTdYg5g6Vu77_c(FaceProvider r0, int r1) {
        r0.lambda$addHidlSensors$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$GHUlnBPzcrj-C8r0WxDwO3lDiTI, reason: not valid java name */
    public static /* synthetic */ void m2665$r8$lambda$GHUlnBPzcrjC8r0WxDwO3lDiTI(FaceProvider r0, int r1, int r2, IBinder r3, IFaceServiceReceiver r4, String r5) {
        r0.lambda$scheduleGenerateChallenge$5(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$LcjWpciCnXKfBbWpSgnFR4HBalI(FaceProvider r0) {
        r0.lambda$binderDied$19();
    }

    /* JADX INFO: renamed from: $r8$lambda$RWBG1G-ASHnfHMYYxGFdESVE22o, reason: not valid java name */
    public static /* synthetic */ void m2666$r8$lambda$RWBG1GASHnfHMYYxGFdESVE22o(FaceProvider r0, int r1, int r2, IBinder r3, IFaceServiceReceiver r4, int[] r5, String r6) {
        r0.lambda$scheduleRemoveSpecifiedIds$13(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$WPKxOG5iWT5gomG4rfVRbzLBzwc(FaceProvider r0, int r1, int r2, IBinder r3, ClientMonitorCallbackConverter r4, int r5) {
        r0.lambda$scheduleGetFeature$16(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$_LT8SLICCubVXCMS9CTEZID7ogY(FaceProvider r0, int r1, IBinder r2, long r3) {
        r0.lambda$cancelEnrollment$8(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$aZVnJEfQ5-FYIRM07ONocs1hml0, reason: not valid java name */
    public static /* synthetic */ void m2667$r8$lambda$aZVnJEfQ5FYIRM07ONocs1hml0(FaceProvider r0, int r1, int r2, IInvalidationCallback r3) {
        r0.lambda$scheduleInvalidateAuthenticatorId$4(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$gOiAHLeSkIuDqvEgox3THRD-t4w, reason: not valid java name */
    public static /* synthetic */ void m2668$r8$lambda$gOiAHLeSkIuDqvEgox3THRDt4w(FaceProvider r0, int r1, int r2) {
        r0.lambda$scheduleLoadAuthenticatorIdsForUser$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$l0_PvoSlJLSfI4fnwG6rDEOXq_g(FaceProvider r0, int r1, IBinder r2, int r3, String r4, long r5) {
        r0.lambda$scheduleRevokeChallenge$6(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$lY0Rs9DAUxOT22BY2v5zjg5xbTE(FaceProvider r0, FaceAuthenticateOptions r1, IBinder r2, long r3, ClientMonitorCallbackConverter r5, long r6, boolean r8, int r9, int r10, boolean r11) {
        r0.lambda$scheduleAuthenticate$11(r1, r2, r3, r5, r6, r8, r9, r10, r11);
    }

    /* JADX INFO: renamed from: $r8$lambda$r-7QQBLTlP8b7NP8PpLDeWHvfis, reason: not valid java name */
    public static /* synthetic */ void m2669$r8$lambda$r7QQBLTlP8b7NP8PpLDeWHvfis(FaceProvider r0, AuthenticationStatsCollector r1) {
        r0.lambda$initAuthenticationBroadcastReceiver$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$tQ3qsVX34F7QP2yB-qKP6iABZOI, reason: not valid java name */
    public static /* synthetic */ void m2670$r8$lambda$tQ3qsVX34F7QP2yBqKP6iABZOI(FaceProvider r0, int r1, IBinder r2, long r3) {
        r0.lambda$cancelFaceDetect$10(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$vF_jzmkDGW9zrXDxBDAb5AMNwco(FaceProvider r0, int r1, int r2, IBinder r3, IFaceServiceReceiver r4, int r5, boolean r6, byte[] r7) {
        r0.lambda$scheduleSetFeature$15(r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ void $r8$lambda$yDFITlEI2DMOfhfC9ve7i95cKoQ(FaceProvider r0, int r1, int r2) {
        r0.lambda$startPreparedClient$17(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAuthSessionCoordinator, reason: not valid java name */
    static /* bridge */ /* synthetic */ AuthSessionCoordinator m2671$$Nest$fgetmAuthSessionCoordinator(FaceProvider r0) {
        return r0.mAuthSessionCoordinator;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBiometricHandlerProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ BiometricHandlerProvider m2672$$Nest$fgetmBiometricHandlerProvider(FaceProvider r0) {
        return r0.mBiometricHandlerProvider;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m2673$$Nest$fgetmContext(FaceProvider r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m2674$$Nest$fgetmHandler(FaceProvider r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetTag, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2675$$Nest$mgetTag(FaceProvider r0) {
        return r0.getTag();
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceProvider
    public /* bridge */ /* synthetic */ SensorPropertiesInternal getSensorProperties(int r1) {
        return m2676getSensorProperties(r1);
    }

    public FaceProvider(Context context, BiometricStateCallback biometricStateCallback, AuthenticationStateListeners authenticationStateListeners, SensorProps[] props, String halInstanceName, LockoutResetDispatcher lockoutResetDispatcher, BiometricContext biometricContext, boolean resetLockoutRequiresChallenge) {
        this(context, biometricStateCallback, authenticationStateListeners, props, halInstanceName, lockoutResetDispatcher, biometricContext, null, BiometricHandlerProvider.getInstance(), resetLockoutRequiresChallenge, false);
    }

    FaceProvider(Context context, BiometricStateCallback biometricStateCallback, AuthenticationStateListeners authenticationStateListeners, SensorProps[] props, String halInstanceName, LockoutResetDispatcher lockoutResetDispatcher, BiometricContext biometricContext, IFace daemon, BiometricHandlerProvider biometricHandlerProvider, boolean resetLockoutRequiresChallenge, boolean testHalEnabled) {
        this.mRequestCounter = new AtomicLong(0);
        this.mContext = context;
        this.mBiometricStateCallback = biometricStateCallback;
        this.mAuthenticationStateListeners = authenticationStateListeners;
        this.mHalInstanceName = halInstanceName;
        this.mFaceSensors = new SensorList(ActivityManager.getService());
        this.mHandler = biometricHandlerProvider.getFaceHandler();
        this.mUsageStats = new UsageStats(context);
        this.mLockoutResetDispatcher = lockoutResetDispatcher;
        this.mActivityTaskManager = ActivityTaskManager.getInstance();
        this.mTaskStackListener = new BiometricTaskStackListener(this, null);
        this.mBiometricContext = biometricContext;
        this.mAuthSessionCoordinator = this.mBiometricContext.getAuthSessionCoordinator();
        this.mDaemon = daemon;
        this.mTestHalEnabled = testHalEnabled;
        this.mBiometricHandlerProvider = biometricHandlerProvider;
        initAuthenticationBroadcastReceiver();
        initFaceDanglingBroadcastReceiver();
        initSensors(resetLockoutRequiresChallenge, props);
    }

    private void initAuthenticationBroadcastReceiver() {
        new AuthenticationStatsBroadcastReceiver(this.mContext, 4, new FaceProvider$$ExternalSyntheticLambda19(this));
    }

    private /* synthetic */ void lambda$initAuthenticationBroadcastReceiver$0(AuthenticationStatsCollector collector) {
        Slog.d(getTag(), "Initializing AuthenticationStatsCollector");
        this.mAuthenticationStatsCollector = collector;
    }

    private void initFaceDanglingBroadcastReceiver() {
        new BiometricDanglingReceiver(this.mContext, 4);
    }

    private void initSensors(boolean resetLockoutRequiresChallenge, SensorProps[] props) {
        int r0 = 0;
        if (resetLockoutRequiresChallenge == false) goto L8;
        Slog.d(getTag(), "Adding HIDL configs");
        int r1 = props.length;
    L6:
        if (r0 >= r1) goto L12;
        SensorProps prop = props[r0];
        addHidlSensors(prop, resetLockoutRequiresChallenge);
        r0 = r0 + 1;
        goto L6
    L12:
        return;
    L8:
        Slog.d(getTag(), "Adding AIDL configs");
        int r2 = props.length;
    L10:
        if (r0 >= r2) goto L15;
        SensorProps prop2 = props[r0];
        addAidlSensors(prop2, resetLockoutRequiresChallenge);
        r0 = r0 + 1;
        goto L10
    }

    private void addHidlSensors(SensorProps prop, boolean resetLockoutRequiresChallenge) {
        final int sensorId = prop.commonProps.sensorId;
        Sensor sensor = new HidlToAidlSensorAdapter(this, this.mContext, this.mHandler, prop, this.mLockoutResetDispatcher, this.mBiometricContext, resetLockoutRequiresChallenge, new FaceProvider$$ExternalSyntheticLambda15(this, sensorId));
        sensor.init(this.mLockoutResetDispatcher, this);
        if (sensor.getLazySession().get() != null) goto L5;
        int userId = ProcessList.INVALID_ADJ;
    L6:
        this.mFaceSensors.addSensor(sensorId, sensor, userId, new AnonymousClass1(this, sensorId));
        Slog.d(getTag(), "Added: " + this.mFaceSensors.get(sensorId));
        return;
    L5:
        userId = sensor.getLazySession().get().getUserId();
        goto L6
    }

    private /* synthetic */ void lambda$addHidlSensors$1(int sensorId) {
        scheduleInternalCleanup(sensorId, ActivityManager.getCurrentUser(), null);
        scheduleGetFeature(sensorId, new Binder(), ActivityManager.getCurrentUser(), 1, null, this.mContext.getOpPackageName());
    }

    private void addAidlSensors(SensorProps prop, boolean resetLockoutRequiresChallenge) {
        final int sensorId = prop.commonProps.sensorId;
        Sensor sensor = new Sensor(this, this.mContext, this.mHandler, prop, this.mBiometricContext, resetLockoutRequiresChallenge);
        sensor.init(this.mLockoutResetDispatcher, this);
        if (sensor.getLazySession().get() != null) goto L5;
        int userId = ProcessList.INVALID_ADJ;
    L6:
        this.mFaceSensors.addSensor(sensorId, sensor, userId, new AnonymousClass2(this, sensorId));
        Slog.d(getTag(), "Added: " + this.mFaceSensors.get(sensorId));
        return;
    L5:
        userId = sensor.getLazySession().get().getUserId();
        goto L6
    }

    private String getTag() {
        return "FaceProvider/" + this.mHalInstanceName;
    }

    boolean hasHalInstance() {
        if (this.mTestHalEnabled == false) goto L6;
        return true;
    L6:
        if (ServiceManager.checkService(FaceSensorConfigurations.remapFqName(IFace.DESCRIPTOR + SliceClientPermissions.SliceAuthority.DELIMITER + this.mHalInstanceName)) != null) goto L10;
        return false;
    L10:
        return true;
    }

    synchronized IFace getHalInstance() {
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
        IFace r1 = this.mDaemon;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r1;
    L23:
        Slog.d(getTag(), "Daemon was null, reconnecting");     // Catch: Throwable -> L8
        this.mDaemon = FaceSensorConfigurations.getIFace(IFace.DESCRIPTOR + SliceClientPermissions.SliceAuthority.DELIMITER + this.mHalInstanceNameCurrent);     // Catch: Throwable -> L8
        if (this.mDaemon != null) goto L48;
        Slog.e(getTag(), "Unable to get daemon");     // Catch: Throwable -> L8
        monitor-exit(this);
        return null;
    L48:
        this.mDaemon.asBinder().linkToDeath(this, 0);     // Catch: Throwable -> L8 RemoteException -> L31
    L33:
        int i = 0;
    L35:
        if (i >= this.mFaceSensors.size()) goto L38;
        int sensorId = this.mFaceSensors.keyAt(i);     // Catch: Throwable -> L8
        scheduleLoadAuthenticatorIds(sensorId);     // Catch: Throwable -> L8
        scheduleInternalCleanup(sensorId, ActivityManager.getCurrentUser(), null);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L35
    L38:
        if (Build.isDebuggable() == false) goto L43;
        BiometricUtils<Face> utils = this.mFaceSensors.get(this.mFaceSensors.keyAt(0)).getFaceUtilsInstance();     // Catch: Throwable -> L8
        Iterator r2 = UserManager.get(this.mContext).getAliveUsers().iterator();     // Catch: Throwable -> L8
    L41:
        if (r2.hasNext() == false) goto L43;
        UserInfo user = (UserInfo) r2.next();     // Catch: Throwable -> L8
        List<Face> enrollments = utils.getBiometricsForUser(this.mContext, user.id);     // Catch: Throwable -> L8
        Slog.d(getTag(), "Expecting enrollments for user " + user.id + ": " + enrollments.stream().map(new FaceProvider$$ExternalSyntheticLambda17()).toList());     // Catch: Throwable -> L8
    L43:
        IFace r3 = this.mDaemon;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r3;
    L31:
        e = move-exception;
        Slog.e(getTag(), "Unable to linkToDeath", e);     // Catch: Throwable -> L8
        goto L33
    L14:
        if (this.mHalInstanceNameCurrent.contains("virtual") == false) goto L19;
        if (this.mHalInstanceNameCurrent == this.mHalInstanceName) goto L19;
        Slog.i(getTag(), "Switching face from virtual hal to " + this.mHalInstanceName);     // Catch: Throwable -> L8
        this.mHalInstanceNameCurrent = this.mHalInstanceName;     // Catch: Throwable -> L8
        this.mDaemon = null;     // Catch: Throwable -> L8
        goto L19
    }

    private void scheduleForSensor(int sensorId, BaseClientMonitor client) {
        if (this.mFaceSensors.contains(sensorId) == false) goto L7;
        this.mFaceSensors.get(sensorId).getScheduler().scheduleClientMonitor(client);
        return;
    L7:
        throw new IllegalStateException("Unable to schedule client: " + client + " for sensor: " + sensorId);
    }

    private void scheduleForSensor(int sensorId, BaseClientMonitor client, ClientMonitorCallback callback) {
        if (this.mFaceSensors.contains(sensorId) == false) goto L7;
        this.mFaceSensors.get(sensorId).getScheduler().scheduleClientMonitor(client, callback);
        return;
    L7:
        throw new IllegalStateException("Unable to schedule client: " + client + " for sensor: " + sensorId);
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
        this.mHandler.post(new FaceProvider$$ExternalSyntheticLambda20(this, sensorId, userId));
    }

    private /* synthetic */ void lambda$scheduleLoadAuthenticatorIdsForUser$2(int sensorId, int userId) {
        FaceGetAuthenticatorIdClient client = new FaceGetAuthenticatorIdClient(this.mContext, this.mFaceSensors.get(sensorId).getLazySession(), userId, this.mContext.getOpPackageName(), sensorId, createLogger(0, 0, this.mAuthenticationStatsCollector), this.mBiometricContext, this.mFaceSensors.get(sensorId).getAuthenticatorIds());
        scheduleForSensor(sensorId, client);
    }

    void scheduleInvalidationRequest(final int sensorId, final int userId) {
        this.mHandler.post(new FaceProvider$$ExternalSyntheticLambda14(this, userId, sensorId));
    }

    private /* synthetic */ void lambda$scheduleInvalidationRequest$3(int userId, int sensorId) {
        InvalidationRequesterClient<Face> client = new InvalidationRequesterClient(this.mContext, userId, sensorId, BiometricLogger.ofUnknown(this.mContext), this.mBiometricContext, this.mFaceSensors.get(sensorId).getFaceUtilsInstance());
        scheduleForSensor(sensorId, client);
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceProvider
    public boolean containsSensor(int sensorId) {
        return this.mFaceSensors.contains(sensorId);
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceProvider
    public List<FaceSensorPropertiesInternal> getSensorProperties() {
        List<FaceSensorPropertiesInternal> props = new ArrayList();
        int i = 0;
    L4:
        if (i >= this.mFaceSensors.size()) goto L7;
        props.add(this.mFaceSensors.valueAt(i).getSensorProperties());
        i = i + 1;
        goto L4
    L7:
        return props;
    }

    /* JADX INFO: renamed from: getSensorProperties, reason: collision with other method in class */
    public FaceSensorPropertiesInternal m2676getSensorProperties(int sensorId) {
        return this.mFaceSensors.get(sensorId).getSensorProperties();
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public List<Face> getEnrolledFaces(int sensorId, int userId) {
        return this.mFaceSensors.get(sensorId).getFaceUtilsInstance().getBiometricsForUser(this.mContext, userId);
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceProvider
    public boolean hasEnrollments(int sensorId, int userId) {
        return !getEnrolledFaces(sensorId, userId).isEmpty();
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public void scheduleInvalidateAuthenticatorId(final int sensorId, final int userId, final IInvalidationCallback callback) {
        this.mHandler.post(new FaceProvider$$ExternalSyntheticLambda1(this, sensorId, userId, callback));
    }

    private /* synthetic */ void lambda$scheduleInvalidateAuthenticatorId$4(int sensorId, int userId, IInvalidationCallback callback) {
        FaceInvalidationClient client = new FaceInvalidationClient(this.mContext, this.mFaceSensors.get(sensorId).getLazySession(), userId, sensorId, createLogger(0, 0, this.mAuthenticationStatsCollector), this.mBiometricContext, this.mFaceSensors.get(sensorId).getAuthenticatorIds(), callback);
        scheduleForSensor(sensorId, client);
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceProvider
    public int getLockoutModeForUser(int sensorId, int userId) {
        return this.mFaceSensors.get(sensorId).getLockoutModeForUser(userId);
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceProvider
    public long getAuthenticatorId(int sensorId, int userId) {
        return this.mFaceSensors.get(sensorId).getAuthenticatorIds().getOrDefault(Integer.valueOf(userId), 0L).longValue();
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceProvider
    public boolean isHardwareDetected(int sensorId) {
        return this.mFaceSensors.get(sensorId).isHardwareDetected(this.mHalInstanceName);
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public void scheduleGenerateChallenge(final int sensorId, final int userId, final IBinder token, final IFaceServiceReceiver receiver, final String opPackageName) {
        this.mHandler.post(new FaceProvider$$ExternalSyntheticLambda16(this, sensorId, userId, token, receiver, opPackageName));
    }

    private /* synthetic */ void lambda$scheduleGenerateChallenge$5(int sensorId, int userId, IBinder token, IFaceServiceReceiver receiver, String opPackageName) {
        this.mFaceSensors.get(sensorId).scheduleFaceUpdateActiveUserClient(userId);
        FaceGenerateChallengeClient client = new FaceGenerateChallengeClient(this.mContext, this.mFaceSensors.get(sensorId).getLazySession(), token, new ClientMonitorCallbackConverter(receiver), userId, opPackageName, sensorId, createLogger(0, 0, this.mAuthenticationStatsCollector), this.mBiometricContext);
        scheduleForSensor(sensorId, client);
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public void scheduleRevokeChallenge(final int sensorId, final int userId, final IBinder token, final String opPackageName, final long challenge) {
        this.mHandler.post(new FaceProvider$$ExternalSyntheticLambda12(this, sensorId, token, userId, opPackageName, challenge));
    }

    private /* synthetic */ void lambda$scheduleRevokeChallenge$6(int sensorId, IBinder token, int userId, String opPackageName, long challenge) {
        FaceRevokeChallengeClient client = new FaceRevokeChallengeClient(this.mContext, this.mFaceSensors.get(sensorId).getLazySession(), token, userId, opPackageName, sensorId, createLogger(0, 0, this.mAuthenticationStatsCollector), this.mBiometricContext, challenge);
        scheduleForSensor(sensorId, client);
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public long scheduleEnroll(final int sensorId, final IBinder token, final byte[] hardwareAuthToken, final int userId, final IFaceServiceReceiver receiver, final String opPackageName, final int[] disabledFeatures, final Surface previewSurface, final boolean debugConsent, final FaceEnrollOptions options) {
        final long id = this.mRequestCounter.incrementAndGet();
        this.mHandler.post(new FaceProvider$$ExternalSyntheticLambda7(this, sensorId, userId, token, receiver, hardwareAuthToken, opPackageName, id, disabledFeatures, previewSurface, debugConsent, options));
        return id;
    }

    private /* synthetic */ void lambda$scheduleEnroll$7(int sensorId, int userId, IBinder token, IFaceServiceReceiver receiver, byte[] hardwareAuthToken, String opPackageName, long id, int[] disabledFeatures, Surface previewSurface, boolean debugConsent, FaceEnrollOptions options) {
        this.mFaceSensors.get(sensorId).scheduleFaceUpdateActiveUserClient(userId);
        int maxTemplatesPerUser = this.mFaceSensors.get(sensorId).getSensorProperties().maxEnrollmentsPerUser;
        FaceEnrollClient client = new FaceEnrollClient(this.mContext, this.mFaceSensors.get(sensorId).getLazySession(), token, new ClientMonitorCallbackConverter(receiver), userId, hardwareAuthToken, opPackageName, id, this.mFaceSensors.get(sensorId).getFaceUtilsInstance(), disabledFeatures, 75, previewSurface, sensorId, createLogger(1, 0, this.mAuthenticationStatsCollector), this.mBiometricContext, maxTemplatesPerUser, debugConsent, options, this.mAuthenticationStateListeners, this.mFaceSensors.get(sensorId).getFaceUtilsInstance());
        scheduleForSensor(sensorId, client, this.mBiometricStateCallback);
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public void cancelEnrollment(final int sensorId, final IBinder token, final long requestId) {
        this.mHandler.post(new FaceProvider$$ExternalSyntheticLambda6(this, sensorId, token, requestId));
    }

    private /* synthetic */ void lambda$cancelEnrollment$8(int sensorId, IBinder token, long requestId) {
        this.mFaceSensors.get(sensorId).getScheduler().cancelEnrollment(token, requestId);
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public long scheduleFaceDetect(final IBinder token, final ClientMonitorCallbackConverter callback, final FaceAuthenticateOptions options, final int statsClient) {
        final long id = this.mRequestCounter.incrementAndGet();
        final int sensorId = options.getSensorId();
        this.mHandler.post(new FaceProvider$$ExternalSyntheticLambda18(this, sensorId, token, id, callback, options, statsClient));
        return id;
    }

    private /* synthetic */ void lambda$scheduleFaceDetect$9(int sensorId, IBinder token, long id, ClientMonitorCallbackConverter callback, FaceAuthenticateOptions options, int statsClient) {
        boolean isStrongBiometric = Utils.isStrongBiometric(sensorId);
        FaceDetectClient client = new FaceDetectClient(this.mContext, this.mFaceSensors.get(sensorId).getLazySession(), token, id, callback, options, createLogger(2, statsClient, this.mAuthenticationStatsCollector), this.mBiometricContext, this.mAuthenticationStateListeners, isStrongBiometric);
        scheduleForSensor(sensorId, client, this.mBiometricStateCallback);
    }

    private /* synthetic */ void lambda$cancelFaceDetect$10(int sensorId, IBinder token, long requestId) {
        this.mFaceSensors.get(sensorId).getScheduler().cancelAuthenticationOrDetection(token, requestId);
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public void cancelFaceDetect(final int sensorId, final IBinder token, final long requestId) {
        this.mHandler.post(new FaceProvider$$ExternalSyntheticLambda0(this, sensorId, token, requestId));
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public void scheduleAuthenticate(final IBinder token, final long operationId, final int cookie, final ClientMonitorCallbackConverter callback, final FaceAuthenticateOptions options, final long requestId, final boolean restricted, final int statsClient, final boolean allowBackgroundAuthentication) {
        this.mHandler.post(new FaceProvider$$ExternalSyntheticLambda5(this, options, token, requestId, callback, operationId, restricted, cookie, statsClient, allowBackgroundAuthentication));
    }

    private /* synthetic */ void lambda$scheduleAuthenticate$11(FaceAuthenticateOptions options, IBinder token, long requestId, ClientMonitorCallbackConverter callback, long operationId, boolean restricted, int cookie, int statsClient, boolean allowBackgroundAuthentication) {
        int userId = options.getUserId();
        int sensorId = options.getSensorId();
        boolean isStrongBiometric = Utils.isStrongBiometric(sensorId);
        this.mFaceSensors.get(sensorId).scheduleFaceUpdateActiveUserClient(userId);
        LockoutTracker lockoutTracker = this.mFaceSensors.get(sensorId).getLockoutTracker(true);
        FaceAuthenticationClient client = new FaceAuthenticationClient(this.mContext, this.mFaceSensors.get(sensorId).getLazySession(), token, requestId, callback, operationId, restricted, options, cookie, false, createLogger(2, statsClient, this.mAuthenticationStatsCollector), this.mBiometricContext, isStrongBiometric, this.mUsageStats, lockoutTracker, allowBackgroundAuthentication, Utils.getCurrentStrength(sensorId), this.mAuthenticationStateListeners);
        scheduleForSensor(sensorId, client, new AnonymousClass3(this, userId, sensorId, requestId, client));
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public long scheduleAuthenticate(IBinder token, long operationId, int cookie, ClientMonitorCallbackConverter callback, FaceAuthenticateOptions options, boolean restricted, int statsClient, boolean allowBackgroundAuthentication) {
        long id = this.mRequestCounter.incrementAndGet();
        scheduleAuthenticate(token, operationId, cookie, callback, options, id, restricted, statsClient, allowBackgroundAuthentication);
        return id;
    }

    private /* synthetic */ void lambda$cancelAuthentication$12(int sensorId, IBinder token, long requestId) {
        this.mFaceSensors.get(sensorId).getScheduler().cancelAuthenticationOrDetection(token, requestId);
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public void cancelAuthentication(final int sensorId, final IBinder token, final long requestId) {
        this.mHandler.post(new FaceProvider$$ExternalSyntheticLambda11(this, sensorId, token, requestId));
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public void scheduleRemove(int sensorId, IBinder token, int faceId, int userId, IFaceServiceReceiver receiver, String opPackageName) {
        scheduleRemoveSpecifiedIds(sensorId, token, new int[]{faceId}, userId, receiver, opPackageName);
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public void scheduleRemoveAll(int sensorId, IBinder token, int userId, IFaceServiceReceiver receiver, String opPackageName) {
        List<Face> faces = this.mFaceSensors.get(sensorId).getFaceUtilsInstance().getBiometricsForUser(this.mContext, userId);
        int[] faceIds = new int[faces.size()];
        int i = 0;
    L4:
        if (i >= faces.size()) goto L6;
        faceIds[i] = faces.get(i).getBiometricId();
        i = i + 1;
        goto L4
    L6:
        scheduleRemoveSpecifiedIds(sensorId, token, faceIds, userId, receiver, opPackageName);
    }

    private void scheduleRemoveSpecifiedIds(final int sensorId, final IBinder token, final int[] faceIds, final int userId, final IFaceServiceReceiver receiver, final String opPackageName) {
        this.mHandler.post(new FaceProvider$$ExternalSyntheticLambda3(this, sensorId, userId, token, receiver, faceIds, opPackageName));
    }

    private /* synthetic */ void lambda$scheduleRemoveSpecifiedIds$13(int sensorId, int userId, IBinder token, IFaceServiceReceiver receiver, int[] faceIds, String opPackageName) {
        this.mFaceSensors.get(sensorId).scheduleFaceUpdateActiveUserClient(userId);
        FaceRemovalClient client = new FaceRemovalClient(this.mContext, this.mFaceSensors.get(sensorId).getLazySession(), token, new ClientMonitorCallbackConverter(receiver), faceIds, userId, opPackageName, this.mFaceSensors.get(sensorId).getFaceUtilsInstance(), sensorId, createLogger(4, 0, this.mAuthenticationStatsCollector), this.mBiometricContext, this.mFaceSensors.get(sensorId).getAuthenticatorIds(), 3);
        scheduleForSensor(sensorId, client, this.mBiometricStateCallback);
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public void scheduleResetLockout(final int sensorId, final int userId, final byte[] hardwareAuthToken) {
        this.mHandler.post(new FaceProvider$$ExternalSyntheticLambda2(this, sensorId, userId, hardwareAuthToken));
    }

    private /* synthetic */ void lambda$scheduleResetLockout$14(int sensorId, int userId, byte[] hardwareAuthToken) {
        this.mFaceSensors.get(sensorId).scheduleFaceUpdateActiveUserClient(userId);
        FaceResetLockoutClient client = new FaceResetLockoutClient(this.mContext, this.mFaceSensors.get(sensorId).getLazySession(), userId, this.mContext.getOpPackageName(), sensorId, createLogger(0, 0, this.mAuthenticationStatsCollector), this.mBiometricContext, hardwareAuthToken, this.mFaceSensors.get(sensorId).getLockoutTracker(false), this.mLockoutResetDispatcher, Utils.getCurrentStrength(sensorId));
        scheduleForSensor(sensorId, client);
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public void scheduleSetFeature(final int sensorId, final IBinder token, final int userId, final int feature, final boolean enabled, final byte[] hardwareAuthToken, final IFaceServiceReceiver receiver, String opPackageName) {
        this.mHandler.post(new FaceProvider$$ExternalSyntheticLambda13(this, sensorId, userId, token, receiver, feature, enabled, hardwareAuthToken));
    }

    private /* synthetic */ void lambda$scheduleSetFeature$15(int sensorId, int userId, IBinder token, IFaceServiceReceiver receiver, int feature, boolean enabled, byte[] hardwareAuthToken) {
        this.mFaceSensors.get(sensorId).scheduleFaceUpdateActiveUserClient(userId);
        List<Face> faces = this.mFaceSensors.get(sensorId).getFaceUtilsInstance().getBiometricsForUser(this.mContext, userId);
        if (faces.isEmpty() == false) goto L6;
        Slog.w(getTag(), "Ignoring setFeature, no templates enrolled for user: " + userId);
        return;
    L6:
        FaceSetFeatureClient client = new FaceSetFeatureClient(this.mContext, this.mFaceSensors.get(sensorId).getLazySession(), token, new ClientMonitorCallbackConverter(receiver), userId, this.mContext.getOpPackageName(), sensorId, BiometricLogger.ofUnknown(this.mContext), this.mBiometricContext, feature, enabled, hardwareAuthToken);
        scheduleForSensor(sensorId, client);
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public void scheduleGetFeature(final int sensorId, final IBinder token, final int userId, final int feature, final ClientMonitorCallbackConverter callback, String opPackageName) {
        this.mHandler.post(new FaceProvider$$ExternalSyntheticLambda4(this, sensorId, userId, token, callback, feature));
    }

    private /* synthetic */ void lambda$scheduleGetFeature$16(int sensorId, int userId, IBinder token, ClientMonitorCallbackConverter callback, int feature) {
        this.mFaceSensors.get(sensorId).scheduleFaceUpdateActiveUserClient(userId);
        List<Face> faces = this.mFaceSensors.get(sensorId).getFaceUtilsInstance().getBiometricsForUser(this.mContext, userId);
        if (faces.isEmpty() == false) goto L6;
        Slog.w(getTag(), "Ignoring getFeature, no templates enrolled for user: " + userId);
        return;
    L6:
        FaceGetFeatureClient client = new FaceGetFeatureClient(this.mContext, this.mFaceSensors.get(sensorId).getLazySession(), token, callback, userId, this.mContext.getOpPackageName(), sensorId, BiometricLogger.ofUnknown(this.mContext), this.mBiometricContext, feature);
        scheduleForSensor(sensorId, client);
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public void startPreparedClient(final int sensorId, final int cookie) {
        this.mHandler.post(new FaceProvider$$ExternalSyntheticLambda9(this, sensorId, cookie));
    }

    private /* synthetic */ void lambda$startPreparedClient$17(int sensorId, int cookie) {
        this.mFaceSensors.get(sensorId).getScheduler().startPreparedClient(cookie);
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public void scheduleInternalCleanup(int sensorId, int userId, ClientMonitorCallback callback) {
        scheduleInternalCleanup(sensorId, userId, callback, false);
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public void scheduleInternalCleanup(final int sensorId, final int userId, final ClientMonitorCallback callback, final boolean favorHalEnrollments) {
        this.mHandler.post(new FaceProvider$$ExternalSyntheticLambda8(this, sensorId, userId, favorHalEnrollments, callback));
    }

    private /* synthetic */ void lambda$scheduleInternalCleanup$18(int sensorId, int userId, boolean favorHalEnrollments, ClientMonitorCallback callback) {
        this.mFaceSensors.get(sensorId).scheduleFaceUpdateActiveUserClient(userId);
        FaceInternalCleanupClient client = new FaceInternalCleanupClient(this.mContext, this.mFaceSensors.get(sensorId).getLazySession(), userId, this.mContext.getOpPackageName(), sensorId, createLogger(3, 0, this.mAuthenticationStatsCollector), this.mBiometricContext, this.mFaceSensors.get(sensorId).getFaceUtilsInstance(), this.mFaceSensors.get(sensorId).getAuthenticatorIds());
        if (favorHalEnrollments == false) goto L5;
        client.setFavorHalEnrollments();
    L5:
        scheduleForSensor(sensorId, client, new ClientMonitorCompositeCallback(new ClientMonitorCallback[]{callback, this.mBiometricStateCallback}));
    }

    private BiometricLogger createLogger(int statsAction, int statsClient, AuthenticationStatsCollector authenticationStatsCollector) {
        return new BiometricLogger(this.mContext, 4, statsAction, statsClient, authenticationStatsCollector);
    }

    @Override // com.android.server.biometrics.sensors.BiometricServiceProvider
    public void dumpProtoState(int sensorId, ProtoOutputStream proto, boolean clearSchedulerBuffer) {
        if (this.mFaceSensors.contains(sensorId) == false) goto L6;
        this.mFaceSensors.get(sensorId).dumpProtoState(sensorId, proto, clearSchedulerBuffer);
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
        int c = this.mFaceSensors.get(sensorId).getFaceUtilsInstance().getBiometricsForUser(this.mContext, userId).size();     // Catch: JSONException -> L7
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
        this.mFaceSensors.get(sensorId).getScheduler().dump(r12);
        this.mUsageStats.print(r12);
        return;
    L7:
        e = move-exception;
        Slog.e(getTag(), "dump formatting failure", e);
        goto L12
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public ITestSession createTestSession(int sensorId, ITestSessionCallback callback, String opPackageName) {
        return this.mFaceSensors.get(sensorId).createTestSession(callback);
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public void dumpHal(int sensorId, FileDescriptor fd, String[] args) {
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Slog.e(getTag(), "HAL died");
        this.mHandler.post(new FaceProvider$$ExternalSyntheticLambda10(this));
    }

    private /* synthetic */ void lambda$binderDied$19() {
        this.mDaemon = null;
        int i = 0;
    L4:
        if (i >= this.mFaceSensors.size()) goto L7;
        Sensor sensor = this.mFaceSensors.valueAt(i);
        int sensorId = this.mFaceSensors.keyAt(i);
        PerformanceTracker.getInstanceForSensorId(sensorId).incrementHALDeathCount();
        sensor.onBinderDied();
        i = i + 1;
        goto L4
    }

    void setTestHalEnabled(boolean enabled) {
        if (enabled == this.mTestHalEnabled) goto L5;
        boolean changed = true;
    L6:
        this.mTestHalEnabled = enabled;
        Slog.i(getTag(), "setTestHalEnabled(): isVhalForTestingFlags=false mTestHalEnabled=" + this.mTestHalEnabled + " changed=" + changed);
        if (changed == true) goto L9;
        return;
    L9:
        if (isVhalForTesting() == false) goto L13;
        getHalInstance();
        return;
    L13:
        return;
    L5:
        changed = false;
        goto L6
    }

    @Override // com.android.server.biometrics.sensors.face.ServiceProvider
    public void scheduleWatchdog(int sensorId) {
        Slog.d(getTag(), "Starting watchdog for face");
        BiometricScheduler<IFace, ISession> r0 = this.mFaceSensors.get(sensorId).getScheduler();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.startWatchdog();
    }

    public boolean getTestHalEnabled() {
        return this.mTestHalEnabled;
    }

    public boolean isVhalForTesting() {
        return false;
    }

    public void sendFaceReEnrollNotification() {
        this.mAuthenticationStatsCollector.sendFaceReEnrollNotification();
    }

    public void sendFingerprintReEnrollNotification() {
        this.mAuthenticationStatsCollector.sendFingerprintReEnrollNotification();
    }

    public IVirtualHal getVhal() throws RemoteException {
        if (this.mVhal != null) goto L8;
        if (isVhalForTesting() == false) goto L8;
        this.mVhal = IVirtualHal.Stub.asInterface(Binder.allowBlocking(ServiceManager.waitForService("android.hardware.biometrics.face.virtualhal.IVirtualHal/" + this.mHalInstanceNameCurrent)));
        Slog.d(getTag(), "getVhal " + this.mHalInstanceNameCurrent);
    L8:
        return this.mVhal;
    }
}
