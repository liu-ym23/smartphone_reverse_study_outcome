package com.android.server.localtonemapping;

import android.content.Context;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.resourcemanager.IEventsCallBack;
import android.resourcemanager.IRm;
import android.resourcemanager.Rm;
import android.util.Slog;
import com.android.server.SysOptBridge;
import com.android.server.SystemService;
import java.util.function.Supplier;
import vendor.bd.hardware.display.colormanager.IDisplayHal;

/* JADX INFO: loaded from: classes2.dex */
public final class LocalToneMappingService extends SystemService {
    public static final int APP_TYPE_GAME = 8192;
    public static final int APP_TYPE_MEDIA = 32;
    static final boolean DEBUG = false;
    public static final int EVENT_APPRECORD_FOCUS_APP = 10005;
    public static final int EVENT_APPRECORD_UID_TOP = 10014;
    public static final int HIGH_REPORT_RATE = 3;
    public static final int LOW_REPORT_RATE = 2;
    static final String TAG = "LocalToneMappingService";
    private IEventsCallBack mAppMonitorCallBack;
    private int mClickEnableScreenOn;
    private final Context mContext;
    private Handler mHandler;
    private FocusAppMode mLastFocusAppMode;
    private final Object mLock;
    private float mReportedDisplayRefreshRate;
    private final Supplier<IDisplayHal> mVintfDisplay;

    static final enum FocusAppMode extends Enum<FocusAppMode> {
        private static final /* synthetic */ FocusAppMode[] $VALUES = null;
        public static final FocusAppMode GAME_MODE = null;
        public static final FocusAppMode NORMAL_MODE = null;
        private final int code;

        private static /* synthetic */ FocusAppMode[] $values() {
            return new FocusAppMode[]{NORMAL_MODE, GAME_MODE};
        }

        public static FocusAppMode valueOf(String name) {
            return (FocusAppMode) Enum.valueOf(FocusAppMode.class, name);
        }

        public static FocusAppMode[] values() {
            return (FocusAppMode[]) $VALUES.clone();
        }

        static {
            NORMAL_MODE = new FocusAppMode("NORMAL_MODE", 0, 0);
            GAME_MODE = new FocusAppMode("GAME_MODE", 1, 1);
            $VALUES = $values();
        }

        private FocusAppMode(String r1, int r2, int code) {
            super(r1, r2);
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }
    }

    private static class VintfHalCache implements Supplier<IDisplayHal>, IBinder.DeathRecipient {
        private IDisplayHal mInstance;

        /* synthetic */ VintfHalCache(LocalToneMappingServiceIA r1) {
            this();
        }

        private VintfHalCache() {
            this.mInstance = null;
        }

        @Override // java.util.function.Supplier
        public /* bridge */ /* synthetic */ IDisplayHal get() {
            return get2();
        }

        @Override // java.util.function.Supplier
        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public synchronized IDisplayHal get2() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mInstance != null) goto L15;
            IBinder binder = Binder.allowBlocking(ServiceManager.waitForDeclaredService(IDisplayHal.DESCRIPTOR + "/default"));     // Catch: Throwable -> L11
            if (binder == null) goto L15;
            this.mInstance = IDisplayHal.Stub.asInterface(binder);     // Catch: Throwable -> L11
            binder.linkToDeath(this, 0);     // Catch: Throwable -> L11 RemoteException -> L13
        L14:
            Slog.e(LocalToneMappingService.TAG, "Unable to register DeathRecipient for " + this.mInstance);     // Catch: Throwable -> L11
        L15:
            IDisplayHal r0 = this.mInstance;     // Catch: Throwable -> L11
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

    /* JADX INFO: renamed from: -$$Nest$fgetmLastFocusAppMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ FocusAppMode m5110$$Nest$fgetmLastFocusAppMode(LocalToneMappingService r0) {
        return r0.mLastFocusAppMode;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastFocusAppMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5111$$Nest$fputmLastFocusAppMode(LocalToneMappingService r0, FocusAppMode r1) {
        r0.mLastFocusAppMode = r1;
    }

    public LocalToneMappingService(Context context) {
        this(context, new VintfHalCache(null), Looper.myLooper());
    }

    LocalToneMappingService(Context context, Supplier<IDisplayHal> service, Looper looper) {
        super(context);
        this.mLock = new Object();
        Supplier<IDisplayHal> r0 = null;
        this.mAppMonitorCallBack = null;
        this.mLastFocusAppMode = null;
        this.mContext = context;
        this.mHandler = new Handler(looper);
        if (service.get() == null) goto L5;
        r0 = service;
    L5:
        this.mVintfDisplay = r0;
    }

    public void setFocusAppMode(FocusAppMode focusAppMode) {
    L6:
        ex = move-exception;
        Slog.e(TAG, "Failed issuing setTsFeatureConfig", ex);
        return;
    L4:
        if (this.mVintfDisplay == null) goto L8;
        this.mVintfDisplay.get().SetFocusAppMode(focusAppMode.getCode());     // Catch: Throwable -> L6
    L12:
        return;
    L8:
        Slog.e(TAG, "mVintfDisplay is NULL");     // Catch: Throwable -> L6
        goto L12
    }

    public static boolean isGameApp(String pkgName) {
        if (pkgName != null) goto L5;
        return false;
    L5:
        if (pkgName.isEmpty() == true) goto L11;
        boolean isGame = SysOptBridge.getFactory().getAppRecordManagerService().isGameApp(pkgName);
        return isGame;
    L11:
        return false;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishLocalService(LocalToneMappingService.class, this);
    }

    private void RegisterGameModeMonitorCallback(int event) {
        Slog.d(TAG, "RegisterGameModeMonitorCallback event=" + event);
        Slog.i(TAG, "RegisterGameModeMonitorCallback Connecting to Rm...");
        IRm rm = Rm.getInstance();
        rm.connect();
        this.mAppMonitorCallBack = new AnonymousClass1(this);
        rm.setEventCallback(event, this.mAppMonitorCallBack);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (500 != phase) goto L6;
        RegisterGameModeMonitorCallback(10005);
        return;
    }
}
