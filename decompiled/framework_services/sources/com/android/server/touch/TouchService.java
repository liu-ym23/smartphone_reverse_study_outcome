package com.android.server.touch;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.biometrics.BiometricStateListener;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintSensorPropertiesInternal;
import android.hardware.fingerprint.IFingerprintAuthenticatorsRegisteredCallback;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.provider.Settings;
import android.resourcemanager.IEventsCallBack;
import android.resourcemanager.IRm;
import android.resourcemanager.Rm;
import android.util.Slog;
import com.android.server.SystemService;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import vendor.bd.hardware.touchhal.ITouchHal;

/* JADX INFO: loaded from: classes3.dex */
public final class TouchService extends SystemService {
    public static final int APP_TYPE_GAME = 8192;
    public static final int APP_TYPE_MEDIA = 32;
    static final boolean DEBUG = false;
    public static final int EVENT_APPRECORD_FOCUS_APP = 10005;
    public static final int EVENT_APPRECORD_UID_TOP = 10014;
    public static final int HIGH_REPORT_RATE = 3;
    public static final int LOW_REPORT_RATE = 2;
    static final String TAG = "TouchService";
    private int mAODEnabled;
    private IEventsCallBack mAppMonitorCallBack;
    private final BroadcastReceiver mBroadcastReceiver;
    private int mClickEnableScreenOn;
    private final Context mContext;
    private boolean mDreamStarted;
    private FingerprintManager mFingerprintManager;
    private Handler mHandler;
    private final Object mLock;
    private boolean mProximityPositive;
    private ProximitySensorHelper mProximitySensorHelper;
    private float mReportedDisplayRefreshRate;
    private int mUdfpsSensorId;
    private final Supplier<ITouchHal> mVintfTouch;

    /* JADX INFO: renamed from: com.android.server.touch.TouchService$3, reason: invalid class name */
    class AnonymousClass3 extends IFingerprintAuthenticatorsRegisteredCallback.Stub {
        final /* synthetic */ TouchService this$0;

        /* JADX INFO: renamed from: com.android.server.touch.TouchService$3$1, reason: invalid class name */
        class AnonymousClass1 extends BiometricStateListener {
            final /* synthetic */ AnonymousClass3 this$1;

            public static /* synthetic */ void $r8$lambda$bwWV9SLvnz4VXP8LmshcL_jQyx8(AnonymousClass1 r0, int r1, int r2, boolean r3) {
                r0.lambda$onEnrollmentsChanged$0(r1, r2, r3);
            }

            AnonymousClass1(AnonymousClass3 this$1) {
                this.this$1 = this$1;
            }

            public void onEnrollmentsChanged(final int userId, final int sensorId, final boolean hasEnrollments) {
                if (userId != 0) goto L5;
                TouchService.m8622$$Nest$fgetmHandler(this.this$1.this$0).post(new TouchService$3$1$$ExternalSyntheticLambda0(this, userId, sensorId, hasEnrollments));
                return;
            }

            private /* synthetic */ void lambda$onEnrollmentsChanged$0(int userId, int sensorId, boolean hasEnrollments) {
                Slog.d(TouchService.TAG, "onEnrollmentsChanged userId=" + userId + ", sensorId=" + sensorId + ", hasEnrollments=" + hasEnrollments);
                TouchService.m8625$$Nest$mhandleEnrollmentStatusChanged(this.this$1.this$0, sensorId, hasEnrollments);
            }
        }

        public static /* synthetic */ void $r8$lambda$4cgPdNUGOp2gSkOm3j0rpusbLYU(AnonymousClass3 r0, List r1) {
            r0.lambda$onAllAuthenticatorsRegistered$0(r1);
        }

        AnonymousClass3(TouchService this$0) {
            this.this$0 = this$0;
        }

        public void onAllAuthenticatorsRegistered(final List<FingerprintSensorPropertiesInternal> sensors) {
            TouchService.m8622$$Nest$fgetmHandler(this.this$0).post(new TouchService$3$$ExternalSyntheticLambda0(this, sensors));
            TouchService.m8621$$Nest$fgetmFingerprintManager(this.this$0).registerBiometricStateListener(new AnonymousClass1(this));
        }

        private /* synthetic */ void lambda$onAllAuthenticatorsRegistered$0(List sensors) {
            Slog.d(TouchService.TAG, "onAllAuthenticatorsRegistered sensors=" + sensors.toString());
            TouchService.m8624$$Nest$fputmUdfpsSensorId(this.this$0, -1);
            Iterator r0 = sensors.iterator();
        L4:
            if (r0.hasNext() == false) goto L17;
            FingerprintSensorPropertiesInternal sensor = (FingerprintSensorPropertiesInternal) r0.next();
            if (sensor.sensorType == 2) goto L11;
            if (sensor.sensorType != 3) goto L4;
        L11:
            TouchService.m8624$$Nest$fputmUdfpsSensorId(this.this$0, sensor.sensorId);
            return;
        }
    }

    private static class ProximitySensorHelper {
        private static final int PROXIMITY_NEGATIVE = 0;
        private static final int PROXIMITY_POSITIVE = 1;
        private static final int PROXIMITY_UNKNOWN = -1;
        private static final float TYPICAL_PROXIMITY_THRESHOLD = 5.0f;
        private SensorCallBack mCallBack;
        private int mProximity;
        private Sensor mProximitySensor;
        private boolean mProximitySensorEnabled;
        private final SensorEventListener mProximitySensorListener;
        private float mProximityThreshold;
        private SensorManager mSensorManager;

        public interface SensorCallBack {
            void onStateChanged(long r1, boolean r3);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmProximitySensorEnabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8627$$Nest$fgetmProximitySensorEnabled(ProximitySensorHelper r0) {
            return r0.mProximitySensorEnabled;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmProximityThreshold, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m8628$$Nest$fgetmProximityThreshold(ProximitySensorHelper r0) {
            return r0.mProximityThreshold;
        }

        /* JADX INFO: renamed from: -$$Nest$mhandleProximitySensorEvent, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8629$$Nest$mhandleProximitySensorEvent(ProximitySensorHelper r0, long r1, boolean r3) {
            r0.handleProximitySensorEvent(r1, r3);
        }

        public ProximitySensorHelper(SensorManager sensorManager) {
            this.mProximitySensorEnabled = false;
            this.mProximitySensorListener = new AnonymousClass1(this);
            this.mSensorManager = sensorManager;
            this.mProximitySensor = this.mSensorManager.getDefaultSensor(8);
            if (this.mProximitySensor == null) goto L6;
            this.mProximityThreshold = Math.min(this.mProximitySensor.getMaximumRange(), TYPICAL_PROXIMITY_THRESHOLD);
            return;
        }

        public void setProximitySensorEnabled(boolean enable) {
            Slog.d(TouchService.TAG, "set PSensorEnabled:" + enable);
            if (this.mProximitySensorEnabled == enable) goto L5;
            this.mProximitySensorEnabled = enable;
            this.mProximity = -1;
        L5:
            if (enable == false) goto L7;
            this.mSensorManager.registerListener(this.mProximitySensorListener, this.mProximitySensor, 3);
            return;
        L7:
            this.mSensorManager.unregisterListener(this.mProximitySensorListener);
        }

        public void setCallBack(SensorCallBack callBack) {
            this.mCallBack = callBack;
        }

        private void triggerCallBack(long time, boolean positive) {
            if (this.mCallBack == null) goto L6;
            this.mCallBack.onStateChanged(time, positive);
            return;
        }

        private void handleProximitySensorEvent(long time, boolean positive) {
            if (positive == false) goto L7;
            if (this.mProximity == 1) goto L10;
            this.mProximity = 1;
            triggerCallBack(time, positive);
            return;
        L10:
            return;
        L7:
            if (this.mProximity == 0) goto L12;
            this.mProximity = 0;
            triggerCallBack(time, positive);
            return;
        }
    }

    private static class VintfHalCache implements Supplier<ITouchHal>, IBinder.DeathRecipient {
        private ITouchHal mInstance;

        /* synthetic */ VintfHalCache(TouchServiceIA r1) {
            this();
        }

        private VintfHalCache() {
            this.mInstance = null;
        }

        @Override // java.util.function.Supplier
        public /* bridge */ /* synthetic */ ITouchHal get() {
            return get2();
        }

        @Override // java.util.function.Supplier
        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public synchronized ITouchHal get2() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mInstance != null) goto L15;
            IBinder binder = Binder.allowBlocking(ServiceManager.waitForDeclaredService(ITouchHal.DESCRIPTOR + "/default"));     // Catch: Throwable -> L11
            if (binder == null) goto L15;
            this.mInstance = ITouchHal.Stub.asInterface(binder);     // Catch: Throwable -> L11
            binder.linkToDeath(this, 0);     // Catch: Throwable -> L11 RemoteException -> L13
        L14:
            Slog.e(TouchService.TAG, "Unable to register DeathRecipient for " + this.mInstance);     // Catch: Throwable -> L11
        L15:
            ITouchHal r0 = this.mInstance;     // Catch: Throwable -> L11
            monitor-exit(this);
            return r0;
        }

        @Override // android.os.IBinder.DeathRecipient
        public synchronized void binderDied() {
            monitor-enter(this);
            this.mInstance = null;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$6rTDBG4lvk-hi5r2r_PpsXNhrJA, reason: not valid java name */
    public static /* synthetic */ void m8618$r8$lambda$6rTDBG4lvkhi5r2r_PpsXNhrJA(TouchService r0, long r1, boolean r3) {
        r0.lambda$onBootPhase$0(r1, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAODEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8619$$Nest$fgetmAODEnabled(TouchService r0) {
        return r0.mAODEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClickEnableScreenOn, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8620$$Nest$fgetmClickEnableScreenOn(TouchService r0) {
        return r0.mClickEnableScreenOn;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFingerprintManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ FingerprintManager m8621$$Nest$fgetmFingerprintManager(TouchService r0) {
        return r0.mFingerprintManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m8622$$Nest$fgetmHandler(TouchService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProximitySensorHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ ProximitySensorHelper m8623$$Nest$fgetmProximitySensorHelper(TouchService r0) {
        return r0.mProximitySensorHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUdfpsSensorId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8624$$Nest$fputmUdfpsSensorId(TouchService r0, int r1) {
        r0.mUdfpsSensorId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleEnrollmentStatusChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8625$$Nest$mhandleEnrollmentStatusChanged(TouchService r0, int r1, boolean r2) {
        r0.handleEnrollmentStatusChanged(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monLightClickChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8626$$Nest$monLightClickChanged(TouchService r0) {
        r0.onLightClickChanged();
    }

    public TouchService(Context context) {
        super(context);
        this.mLock = new Object();
        this.mAppMonitorCallBack = null;
        this.mUdfpsSensorId = -1;
        this.mBroadcastReceiver = new AnonymousClass1(this);
        this.mDreamStarted = false;
        this.mProximityPositive = false;
        this.mContext = context;
        HandlerThread handlerThread = new HandlerThread(TAG);
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.mVintfTouch = new VintfHalCache(null);
    }

    TouchService(Context context, Supplier<ITouchHal> service, Looper looper) {
        super(context);
        this.mLock = new Object();
        Supplier<ITouchHal> r0 = null;
        this.mAppMonitorCallBack = null;
        this.mUdfpsSensorId = -1;
        this.mBroadcastReceiver = new AnonymousClass1(this);
        this.mDreamStarted = false;
        this.mProximityPositive = false;
        this.mContext = context;
        this.mHandler = new Handler(looper);
        if (service.get() == null) goto L5;
        r0 = service;
    L5:
        this.mVintfTouch = r0;
    }

    public void setTsFeatureConfig(int apptype, int framerate) {
    L6:
        ex = move-exception;
        Slog.e(TAG, "Failed issuing setTsFeatureConfig", ex);
        return;
    L4:
        if (this.mVintfTouch == null) goto L8;
        this.mVintfTouch.get().setTsFeatureConfig(apptype, framerate);     // Catch: Throwable -> L6
    L12:
        return;
    L8:
        Slog.e(TAG, "mVintfTouch is NULL");     // Catch: Throwable -> L6
        goto L12
    }

    public void setTsClickEnable(int Click_enable) {
    L6:
        ex = move-exception;
        Slog.e(TAG, "Failed issuing setTsFeatureConfig", ex);
        return;
    L4:
        if (this.mVintfTouch == null) goto L8;
        this.mVintfTouch.get().setTsClickEnableStatus(Click_enable);     // Catch: Throwable -> L6
    L12:
        return;
    L8:
        Slog.e(TAG, "mVintfTouch is NULL");     // Catch: Throwable -> L6
        goto L12
    }

    private void setTsAodMode(int enabled) {
    L6:
        ex = move-exception;
        Slog.e(TAG, "Failed issuing setTsAodMode", ex);
        return;
    L4:
        if (this.mVintfTouch == null) goto L8;
        this.mVintfTouch.get().setTsAodMode(enabled);     // Catch: Throwable -> L6
    L12:
        return;
    L8:
        Slog.e(TAG, "mVintfTouch is NULL");     // Catch: Throwable -> L6
        goto L12
    }

    private void setTsPsensorStatus(int enabled) {
    L6:
        ex = move-exception;
        Slog.e(TAG, "Failed issuing setTsPsensorStatus", ex);
        return;
    L4:
        if (this.mVintfTouch == null) goto L8;
        this.mVintfTouch.get().setTsPsensorStatus(enabled);     // Catch: Throwable -> L6
    L12:
        return;
    L8:
        Slog.e(TAG, "mVintfTouch is NULL");     // Catch: Throwable -> L6
        goto L12
    }

    public void setTsReportRateStatus(int report_rate) {
    L6:
        ex = move-exception;
        Slog.e(TAG, "Failed issuing setTsFeatureConfig", ex);
        return;
    L4:
        if (this.mVintfTouch == null) goto L8;
        this.mVintfTouch.get().setTsReportRateStatus(report_rate);     // Catch: Throwable -> L6
    L12:
        return;
    L8:
        Slog.e(TAG, "mVintfTouch is NULL");     // Catch: Throwable -> L6
        goto L12
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishLocalService(TouchService.class, this);
    }

    private void RegisterAppMonitorCallback(int event) {
        Slog.d(TAG, "RegisterAppMonitorCallback event=" + event);
        IRm rm = Rm.getInstance();
        rm.connect();
        this.mAppMonitorCallBack = new AnonymousClass2(this);
        rm.setEventCallback(event, this.mAppMonitorCallBack);
    }

    private void onLightClickChanged() {
        this.mClickEnableScreenOn = Settings.Global.getInt(getContext().getContentResolver(), "doubleclick_enable_assist_on", 0);
        this.mAODEnabled = Settings.Secure.getIntForUser(getContext().getContentResolver(), "doze_always_on", 0, -2);
        Slog.d(TAG, "Click enable status:" + this.mClickEnableScreenOn + ",AOD enabled status:" + this.mAODEnabled);
        updateSingleClickState();
    }

    private void updateSingleClickState() {
        if (this.mAODEnabled == 0) goto L5;
    L8:
        int enableSingleClick = 1;
    L9:
        setTsAodMode(enableSingleClick);
        Slog.d(TAG, "Update single click status to: " + enableSingleClick);
        return;
    L5:
        if (this.mClickEnableScreenOn != 0) goto L8;
        enableSingleClick = 0;
        goto L9
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (500 != phase) goto L8;
        RegisterAppMonitorCallback(10005);
        this.mFingerprintManager = (FingerprintManager) this.mContext.getSystemService(FingerprintManager.class);
        if (this.mFingerprintManager == null) goto L8;
        this.mFingerprintManager.addAuthenticatorsRegisteredCallback(new AnonymousClass3(this));
    L8:
        if (phase != 550) goto L11;
        ContentResolver cr = getContext().getContentResolver();
        final Handler r2 = this.mHandler;
        ContentObserver mLightClickObserver = new AnonymousClass4(this, r2);
        cr.registerContentObserver(Settings.Global.getUriFor("doubleclick_enable_assist_on"), true, mLightClickObserver);
        cr.registerContentObserver(Settings.Secure.getUriFor("doze_always_on"), false, mLightClickObserver, -1);
        this.mClickEnableScreenOn = Settings.Global.getInt(getContext().getContentResolver(), "doubleclick_enable_assist_on", 0);
        setTsClickEnable(0);
        Slog.d(TAG, "click enable start status:" + this.mClickEnableScreenOn);
        this.mAODEnabled = Settings.Secure.getIntForUser(getContext().getContentResolver(), "doze_always_on", 0, -2);
        Slog.d(TAG, "doze always on start status:" + this.mAODEnabled);
        updateSingleClickState();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.SCREEN_OFF");
        getContext().registerReceiverAsUser(this.mBroadcastReceiver, UserHandle.ALL, filter, null, this.mHandler);
        this.mProximitySensorHelper = new ProximitySensorHelper((SensorManager) getContext().getSystemService(SensorManager.class));
        this.mProximitySensorHelper.setCallBack(new TouchService$$ExternalSyntheticLambda0(this));
        return;
    }

    private /* synthetic */ void lambda$onBootPhase$0(long r1, boolean r3) {
        this.mProximityPositive = r3;
        setTsPsensorStatus(r3 ? 1 : 0);
    }

    private void handleEnrollmentStatusChanged(int sensorId, boolean hasEnrollments) {
        if (this.mUdfpsSensorId != (-1)) goto L5;
        return;
    L5:
        if (this.mUdfpsSensorId != sensorId) goto L24;
    L13:
        ex = move-exception;
        Slog.e(TAG, "Failed issuing setTsFpStatus", ex);
        return;
    L7:
        if (this.mVintfTouch == null) goto L15;
        ITouchHal r1 = this.mVintfTouch.get();     // Catch: Throwable -> L13
        if (hasEnrollments == false) goto L11;
        int r2 = 1;
    L12:
        r1.setTsFpStatus(r2);     // Catch: Throwable -> L13
    L19:
        return;
    L11:
        r2 = 0;
        goto L12
    L15:
        Slog.e(TAG, "mVintfTouch is NULL");     // Catch: Throwable -> L13
        goto L19
    }
}
