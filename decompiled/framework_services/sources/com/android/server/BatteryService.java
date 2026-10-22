package com.android.server;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.BroadcastOptions;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.database.ContentObserver;
import android.hardware.health.HealthInfo;
import android.metrics.LogMaker;
import android.os.BatteryManagerInternal;
import android.os.BatteryProperty;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.DropBoxManager;
import android.os.FileUtils;
import android.os.Handler;
import android.os.IBatteryPropertiesRegistrar;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.ShellCommand;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UEventObserver;
import android.os.UserHandle;
import android.provider.Settings;
import android.sysprop.PowerProperties;
import android.util.EventLog;
import android.util.Slog;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import com.android.internal.app.IBatteryStats;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.os.SomeArgs;
import com.android.internal.util.DumpUtils;
import com.android.server.am.BatteryStatsService;
import com.android.server.health.HealthServiceWrapper;
import com.android.server.health.Utils;
import com.android.server.lights.LightsManager;
import com.android.server.lights.LogicalLight;
import com.android.server.pm.PackageManagerService;
import com.android.server.storage.DeviceStorageMonitorService;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class BatteryService extends SystemService {
    private static final int ABSOLUTE_DECI_CELSIUS_DIFF_FOR_TEMP_UPDATE = 10;
    private static final float BASE_POINT_DIFF_FOR_VOLTAGE_UPDATE = 0.01f;
    public static final Bundle BATTERY_CHANGED_OPTIONS = null;
    private static final long BATTERY_LEVEL_CHANGE_THROTTLE_MS = 60000;
    private static final Bundle BATTERY_OPTIONS = null;
    private static final int BATTERY_PLUGGED_NONE = 0;
    private static final int BATTERY_SCALE = 100;
    private static final boolean DEBUG = false;
    private static final String[] DUMPSYS_ARGS = null;
    private static final String DUMPSYS_DATA_PATH = "/data/system/";
    private static final long HEALTH_HAL_WAIT_MS = 1000;
    private static final int MAX_BATTERY_LEVELS_QUEUE_SIZE = 100;
    private static final int MSG_BROADCAST_BATTERY_CHANGED = 1;
    private static final int MSG_BROADCAST_BATTERY_LOW_OKAY = 3;
    private static final int MSG_BROADCAST_POWER_CONNECTION_CHANGED = 2;
    static final int OPTION_FORCE_UPDATE = 1;
    private static final Bundle POWER_OPTIONS = null;
    private static final String TAG = null;
    private static final int TIME_DIFF_FOR_MAX_CHARGING_CURRENT_UPDATE_MS = 5000;
    private static final int TIME_DIFF_FOR_VOLTAGE_UPDATE_MS = 20000;
    private static String sSystemUiPackage;
    private long lastReportTime;
    protected ActivityManagerInternal mActivityManagerInternal;
    private boolean mBatteryInputSuspended;
    private boolean mBatteryLevelCritical;
    private boolean mBatteryLevelLow;
    private ArrayDeque<Bundle> mBatteryLevelsEventQueue;
    private int mBatteryNearlyFullLevel;
    private BatteryPropertiesRegistrar mBatteryPropertiesRegistrar;
    private final IBatteryStats mBatteryStats;
    BinderService mBinderService;
    private int mChargeStartLevel;
    private long mChargeStartTime;
    private final CopyOnWriteArraySet<BatteryManagerInternal.ChargingPolicyChangeListener> mChargingPolicyChangeListeners;
    private final ConditionVariable mConditionVariable;
    protected final Context mContext;
    private int mCriticalBatteryLevel;
    private int mDischargeStartLevel;
    private long mDischargeStartTime;
    protected final Handler mHandler;
    protected HealthInfo mHealthInfo;
    private HealthServiceWrapper mHealthServiceWrapper;
    private int mInvalidCharger;
    private boolean mIsFirstBatteryChangedUpdate;
    private long mLastBatteryLevelChangedSentMs;
    private int mLastBroadcastBatteryCapacityLevel;
    private int mLastBroadcastBatteryCycleCount;
    private int mLastBroadcastBatteryHealth;
    protected int mLastBroadcastBatteryLevel;
    private boolean mLastBroadcastBatteryLevelCritical;
    private boolean mLastBroadcastBatteryPresent;
    private int mLastBroadcastBatteryStatus;
    private int mLastBroadcastBatteryTemperature;
    private int mLastBroadcastBatteryVoltage;
    private int mLastBroadcastChargeCounter;
    private int mLastBroadcastChargingState;
    private int mLastBroadcastInvalidCharger;
    private int mLastBroadcastMaxChargingCurrent;
    public long mLastBroadcastMaxChargingCurrentUpdateTime;
    private int mLastBroadcastMaxChargingVoltage;
    private int mLastBroadcastPlugType;
    public long mLastBroadcastVoltageUpdateTime;
    private int mLastChargingPolicy;
    private final HealthInfo mLastHealthInfo;
    private int mLastLowBatteryWarningLevel;
    private Led mLed;
    private final Handler.Callback mLocalCallback;
    final Object mLock;
    private int mLowBatteryCloseWarningLevel;
    private int mLowBatteryWarningLevel;
    private MetricsLogger mMetricsLogger;
    private int mPlugType;
    private boolean mSentLowBatteryBroadcast;
    private int mSequence;
    private int mShutdownBatteryTemperature;
    private boolean mShutdownIfNoPower;
    private final BatteryServiceSmtEx mSmtEx;
    private boolean mUpdatesStopped;

    /* JADX INFO: renamed from: com.android.server.BatteryService$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ BatteryService this$0;
        final /* synthetic */ Intent val$statusIntent;

        AnonymousClass4(BatteryService this$0, Intent r2) {
            this.this$0 = this$0;
            this.val$statusIntent = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.mContext.sendBroadcastAsUser(this.val$statusIntent, UserHandle.ALL, null, BatteryService.m106$$Nest$sfgetPOWER_OPTIONS());
        }
    }

    /* JADX INFO: renamed from: com.android.server.BatteryService$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ BatteryService this$0;
        final /* synthetic */ Intent val$statusIntent;

        AnonymousClass5(BatteryService this$0, Intent r2) {
            this.this$0 = this$0;
            this.val$statusIntent = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.mContext.sendBroadcastAsUser(this.val$statusIntent, UserHandle.ALL, null, BatteryService.m106$$Nest$sfgetPOWER_OPTIONS());
        }
    }

    /* JADX INFO: renamed from: com.android.server.BatteryService$6, reason: invalid class name */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ BatteryService this$0;
        final /* synthetic */ Intent val$statusIntent;

        AnonymousClass6(BatteryService this$0, Intent r2) {
            this.this$0 = this$0;
            this.val$statusIntent = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.mContext.sendBroadcastAsUser(this.val$statusIntent, UserHandle.ALL, null, BatteryService.m105$$Nest$sfgetBATTERY_OPTIONS());
        }
    }

    /* JADX INFO: renamed from: com.android.server.BatteryService$7, reason: invalid class name */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ BatteryService this$0;
        final /* synthetic */ Intent val$statusIntent;

        AnonymousClass7(BatteryService this$0, Intent r2) {
            this.this$0 = this$0;
            this.val$statusIntent = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.mContext.sendBroadcastAsUser(this.val$statusIntent, UserHandle.ALL, null, BatteryService.m105$$Nest$sfgetBATTERY_OPTIONS());
        }
    }

    private final class BatteryPropertiesRegistrar extends IBatteryPropertiesRegistrar.Stub {
        final /* synthetic */ BatteryService this$0;

        /* synthetic */ BatteryPropertiesRegistrar(BatteryService r1, BatteryServiceIA r2) {
            this(r1);
        }

        private BatteryPropertiesRegistrar(BatteryService r1) {
            this.this$0 = r1;
        }

        public int getProperty(int id, BatteryProperty prop) throws RemoteException {
            switch(id) {
                case 7: goto L5;
                case 8: goto L5;
                case 9: goto L5;
                case 10: goto L5;
                case 11: goto L5;
                case 12: goto L5;
                default: goto L7;
            };
        L5:
            this.this$0.mContext.enforceCallingPermission("android.permission.BATTERY_STATS", null);
        L7:
            return BatteryService.m89$$Nest$fgetmHealthServiceWrapper(this.this$0).getProperty(id, prop);
        }

        public void scheduleUpdate() throws RemoteException {
            BatteryService.m89$$Nest$fgetmHealthServiceWrapper(this.this$0).scheduleUpdate();
        }
    }

    private final class BinderService extends Binder {
        final /* synthetic */ BatteryService this$0;

        /* synthetic */ BinderService(BatteryService r1, BatteryServiceIA r2) {
            this(r1);
        }

        private BinderService(BatteryService r1) {
            this.this$0 = r1;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int pid = Binder.getCallingPid();     // Catch: RuntimeException -> L14
            int uid = Binder.getCallingUid();     // Catch: RuntimeException -> L14
        L10:
            e = move-exception;
            throw e;
        L5:
            if (SysOptBridge.getFactory().getBatteryServiceOptEx().onTransactOptEx(code, data, reply, pid, uid) == true) goto L12;
            if (super.onTransact(code, data, reply, flags) == true) goto L12;
            return false;
        L12:
            return true;
        L14:
            e = move-exception;
            throw e;
        }

        @Override // android.os.Binder
        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.mContext, BatteryService.m107$$Nest$sfgetTAG(), pw) == true) goto L6;
            return;
        L6:
            if (args.length > 0) goto L8;
        L10:
            this.this$0.dumpInternal(fd, pw, args);
            return;
        L8:
            if ("--proto".equals(args[0]) == false) goto L10;
            BatteryService.m96$$Nest$mdumpProto(this.this$0, fd);
        }

        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new Shell(this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }
    }

    private final class Led {
        static final int LOW_BATTERY_BEHAVIOR_DEFAULT = 0;
        static final int LOW_BATTERY_BEHAVIOR_FLASHING = 2;
        static final int LOW_BATTERY_BEHAVIOR_SOLID = 1;
        private final int mBatteryFullARGB;
        private final int mBatteryLedOff;
        private final int mBatteryLedOn;
        private final LogicalLight mBatteryLight;
        private final int mBatteryLowARGB;
        private final int mBatteryLowBehavior;
        private final int mBatteryMediumARGB;
        final /* synthetic */ BatteryService this$0;

        public Led(BatteryService r3, Context context, LightsManager lights) {
            this.this$0 = r3;
            this.mBatteryLight = lights.getLight(3);
            this.mBatteryLowARGB = context.getResources().getInteger(R.integer.config_pdp_reject_retry_delay_ms);
            this.mBatteryMediumARGB = context.getResources().getInteger(R.integer.config_pictureInPictureMaxNumberOfActions);
            this.mBatteryFullARGB = context.getResources().getInteger(R.integer.config_pauseRotationWhenUnfolding_displaySwitchTimeout);
            this.mBatteryLedOn = context.getResources().getInteger(R.integer.config_pauseRotationWhenUnfolding_maxHingeAngle);
            this.mBatteryLedOff = context.getResources().getInteger(R.integer.config_pauseRotationWhenUnfolding_hingeEventTimeout);
            BatteryService.m94$$Nest$fputmBatteryNearlyFullLevel(r3, context.getResources().getInteger(R.integer.config_pinnerAssistantPinBytes));
            this.mBatteryLowBehavior = context.getResources().getInteger(R.integer.config_phonenumber_compare_min_match);
        }

        public void updateLightsLocked() {
            if (this.mBatteryLight != null) goto L5;
            return;
        L5:
            int level = this.this$0.mHealthInfo.batteryLevel;
            int status = this.this$0.mHealthInfo.batteryStatus;
            if (level >= BatteryService.m92$$Nest$fgetmLowBatteryWarningLevel(this.this$0)) goto L15;
            switch(this.mBatteryLowBehavior) {
                case 1: goto L13;
                case 2: goto L12;
                default: goto L9;
            };
        L9:
            if (status != 2) goto L11;
            this.mBatteryLight.setColor(this.mBatteryLowARGB);
            return;
        L11:
            this.mBatteryLight.setFlashing(this.mBatteryLowARGB, 1, this.mBatteryLedOn, this.mBatteryLedOff);
            return;
        L12:
            this.mBatteryLight.setFlashing(this.mBatteryLowARGB, 1, this.mBatteryLedOn, this.mBatteryLedOff);
            return;
        L13:
            this.mBatteryLight.setColor(this.mBatteryLowARGB);
            return;
        L15:
            if (status == 2) goto L19;
            if (status == 5) goto L19;
            this.mBatteryLight.turnOff();
            return;
        L19:
            if (status != 5) goto L21;
        L24:
            this.mBatteryLight.setColor(this.mBatteryFullARGB);
            return;
        L21:
            if (level >= BatteryService.m87$$Nest$fgetmBatteryNearlyFullLevel(this.this$0)) goto L24;
            this.mBatteryLight.setColor(this.mBatteryMediumARGB);
        }
    }

    private final class LocalService extends BatteryManagerInternal {
        final /* synthetic */ BatteryService this$0;

        /* synthetic */ LocalService(BatteryService r1, BatteryServiceIA r2) {
            this(r1);
        }

        private LocalService(BatteryService r1) {
            this.this$0 = r1;
        }

        public boolean isPowered(int plugTypeSet) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            boolean r1 = BatteryService.m97$$Nest$misPoweredLocked(this.this$0, plugTypeSet);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public int getPlugType() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            int r1 = BatteryService.m93$$Nest$fgetmPlugType(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public int getBatteryLevel() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            int r1 = this.this$0.mHealthInfo.batteryLevel;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public int getBatteryChargeCounter() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            int r1 = this.this$0.mHealthInfo.batteryChargeCounterUah;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public int getBatteryFullCharge() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            int r1 = this.this$0.mHealthInfo.batteryFullChargeUah;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public int getBatteryHealth() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            int r1 = this.this$0.mHealthInfo.batteryHealth;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean getBatteryLevelLow() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            boolean r1 = BatteryService.m86$$Nest$fgetmBatteryLevelLow(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void registerChargingPolicyChangeListener(BatteryManagerInternal.ChargingPolicyChangeListener listener) {
            BatteryService.m88$$Nest$fgetmChargingPolicyChangeListeners(this.this$0).add(listener);
        }

        public int getChargingPolicy() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            int r1 = BatteryService.m91$$Nest$fgetmLastChargingPolicy(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public int getInvalidCharger() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            int r1 = BatteryService.m90$$Nest$fgetmInvalidCharger(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void setChargerAcOnline(boolean online, boolean forceUpdate) {
            BatteryService.m101$$Nest$msetChargerAcOnline(this.this$0, online, forceUpdate);
        }

        public void setBatteryLevel(int level, boolean forceUpdate) {
            BatteryService.m99$$Nest$msetBatteryLevel(this.this$0, level, forceUpdate);
        }

        public void unplugBattery(boolean forceUpdate) {
            BatteryService.m103$$Nest$munplugBattery(this.this$0, forceUpdate, null);
        }

        public void resetBattery(boolean forceUpdate) {
            BatteryService.m98$$Nest$mresetBattery(this.this$0, forceUpdate, null);
        }

        public void suspendBatteryInput() {
            BatteryService.m102$$Nest$msuspendBatteryInput(this.this$0);
        }
    }

    class Shell extends ShellCommand {
        final /* synthetic */ BatteryService this$0;

        Shell(BatteryService this$0) {
            this.this$0 = this$0;
        }

        public int onCommand(String cmd) {
            return this.this$0.onShellCommand(this, cmd);
        }

        public void onHelp() {
            PrintWriter pw = getOutPrintWriter();
            BatteryService.dumpHelp(pw);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$AiQShtRSNhmz_ZTL74NPp-e3gi0, reason: not valid java name */
    public static /* synthetic */ boolean m82$r8$lambda$AiQShtRSNhmz_ZTL74NPpe3gi0(Message r0) {
        return lambda$new$0(r0);
    }

    public static /* synthetic */ void $r8$lambda$BGhQ0dN9QktqFNdHUq5Fcu0CN1A(BatteryService r0, boolean r1) {
        r0.lambda$setBatteryLevel$5(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$BRkwuw5AmQmc0BnIM-83mKctdPY, reason: not valid java name */
    public static /* synthetic */ void m83$r8$lambda$BRkwuw5AmQmc0BnIM83mKctdPY(BatteryService r0, boolean r1, PrintWriter r2) {
        r0.lambda$resetBattery$7(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$LviqpWDIutTTwiaEiuaGMjhoNls(BatteryService r0, Intent r1) {
        r0.lambda$shutdownIfNoPowerLocked$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$QITgs02JU2zUgONUrF7rVY3JmZw(BatteryService r0) {
        r0.sendEnqueuedBatteryLevelChangedEvents();
    }

    /* JADX INFO: renamed from: $r8$lambda$Vwg9quKnvOG6KNXA-o38qgmIfAc, reason: not valid java name */
    public static /* synthetic */ void m84$r8$lambda$Vwg9quKnvOG6KNXAo38qgmIfAc(BatteryService r0, boolean r1, PrintWriter r2) {
        r0.lambda$unplugBattery$6(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$YM_7CKDUYQ7TsvkKgKjHdUFeQhI(BatteryService r0, boolean r1) {
        r0.lambda$setChargerAcOnline$4(r1);
    }

    public static /* synthetic */ void $r8$lambda$egoSIcfIT8XByY8cTM2sBM4zxEA(BatteryService r0, Intent r1) {
        r0.lambda$shutdownIfOverTempLocked$2(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$kI548aEkD-5ubzJcKyoIH4vQF6M, reason: not valid java name */
    public static /* synthetic */ void m85$r8$lambda$kI548aEkD5ubzJcKyoIH4vQF6M(BatteryService r0) {
        r0.notifyChargingPolicyChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBatteryLevelLow, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m86$$Nest$fgetmBatteryLevelLow(BatteryService r0) {
        return r0.mBatteryLevelLow;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBatteryNearlyFullLevel, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m87$$Nest$fgetmBatteryNearlyFullLevel(BatteryService r0) {
        return r0.mBatteryNearlyFullLevel;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmChargingPolicyChangeListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ CopyOnWriteArraySet m88$$Nest$fgetmChargingPolicyChangeListeners(BatteryService r0) {
        return r0.mChargingPolicyChangeListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHealthServiceWrapper, reason: not valid java name */
    static /* bridge */ /* synthetic */ HealthServiceWrapper m89$$Nest$fgetmHealthServiceWrapper(BatteryService r0) {
        return r0.mHealthServiceWrapper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInvalidCharger, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m90$$Nest$fgetmInvalidCharger(BatteryService r0) {
        return r0.mInvalidCharger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastChargingPolicy, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m91$$Nest$fgetmLastChargingPolicy(BatteryService r0) {
        return r0.mLastChargingPolicy;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLowBatteryWarningLevel, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m92$$Nest$fgetmLowBatteryWarningLevel(BatteryService r0) {
        return r0.mLowBatteryWarningLevel;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPlugType, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m93$$Nest$fgetmPlugType(BatteryService r0) {
        return r0.mPlugType;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmBatteryNearlyFullLevel, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m94$$Nest$fputmBatteryNearlyFullLevel(BatteryService r0, int r1) {
        r0.mBatteryNearlyFullLevel = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmInvalidCharger, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m95$$Nest$fputmInvalidCharger(BatteryService r0, int r1) {
        r0.mInvalidCharger = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpProto, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m96$$Nest$mdumpProto(BatteryService r0, FileDescriptor r1) {
        r0.dumpProto(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misPoweredLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m97$$Nest$misPoweredLocked(BatteryService r0, int r1) {
        return r0.isPoweredLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mresetBattery, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m98$$Nest$mresetBattery(BatteryService r0, boolean r1, PrintWriter r2) {
        r0.resetBattery(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetBatteryLevel, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m99$$Nest$msetBatteryLevel(BatteryService r0, int r1, boolean r2) {
        r0.setBatteryLevel(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetChargeDockApproach, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m100$$Nest$msetChargeDockApproach(BatteryService r0) {
        r0.setChargeDockApproach();
    }

    /* JADX INFO: renamed from: -$$Nest$msetChargerAcOnline, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m101$$Nest$msetChargerAcOnline(BatteryService r0, boolean r1, boolean r2) {
        r0.setChargerAcOnline(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msuspendBatteryInput, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m102$$Nest$msuspendBatteryInput(BatteryService r0) {
        r0.suspendBatteryInput();
    }

    /* JADX INFO: renamed from: -$$Nest$munplugBattery, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m103$$Nest$munplugBattery(BatteryService r0, boolean r1, PrintWriter r2) {
        r0.unplugBattery(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateBatteryWarningLevelLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m104$$Nest$mupdateBatteryWarningLevelLocked(BatteryService r0) {
        r0.updateBatteryWarningLevelLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetBATTERY_OPTIONS, reason: not valid java name */
    static /* bridge */ /* synthetic */ Bundle m105$$Nest$sfgetBATTERY_OPTIONS() {
        return BATTERY_OPTIONS;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetPOWER_OPTIONS, reason: not valid java name */
    static /* bridge */ /* synthetic */ Bundle m106$$Nest$sfgetPOWER_OPTIONS() {
        return POWER_OPTIONS;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m107$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = BatteryService.class.getSimpleName();
        DUMPSYS_ARGS = new String[]{"--checkin", "--unplugged"};
        BATTERY_CHANGED_OPTIONS = BroadcastOptions.makeBasic().setDeliveryGroupPolicy(1).setDeferralPolicy(2).toBundle();
        POWER_OPTIONS = BroadcastOptions.makeBasic().setDeliveryGroupPolicy(1).setDeliveryGroupMatchingKey(PackageManagerService.PLATFORM_PACKAGE_NAME, "android.intent.action.ACTION_POWER_CONNECTED").setDeferralPolicy(2).toBundle();
        BATTERY_OPTIONS = BroadcastOptions.makeBasic().setDeliveryGroupPolicy(1).setDeliveryGroupMatchingKey(PackageManagerService.PLATFORM_PACKAGE_NAME, "android.intent.action.BATTERY_OKAY").setDeferralPolicy(2).toBundle();
    }

    private static /* synthetic */ boolean lambda$new$0(Message msg) {
        switch(msg.what) {
            case 1: goto L20;
            case 2: goto L13;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        SomeArgs args = (SomeArgs) msg.obj;
        Context context = (Context) args.arg1;     // Catch: Throwable -> L10
        Intent intent = (Intent) args.arg2;     // Catch: Throwable -> L10
        args.recycle();
        sendBroadcastToAllUsers(context, intent, BATTERY_OPTIONS);
        return true;
    L10:
        th = move-exception;
        args.recycle();
        throw th;
    L13:
        SomeArgs args2 = (SomeArgs) msg.obj;
        Context context2 = (Context) args2.arg1;     // Catch: Throwable -> L17
        Intent intent2 = (Intent) args2.arg2;     // Catch: Throwable -> L17
        args2.recycle();
        sendBroadcastToAllUsers(context2, intent2, POWER_OPTIONS);
        return true;
    L17:
        th = move-exception;
        args2.recycle();
        throw th;
    L20:
        SomeArgs args3 = (SomeArgs) msg.obj;
        Context context3 = (Context) args3.arg1;     // Catch: Throwable -> L24
        Intent intent3 = (Intent) args3.arg2;     // Catch: Throwable -> L24
        boolean forceUpdate = ((Boolean) args3.arg3).booleanValue();     // Catch: Throwable -> L24
        args3.recycle();
        broadcastBatteryChangedIntent(context3, intent3, BATTERY_CHANGED_OPTIONS, forceUpdate);
        return true;
    L24:
        th = move-exception;
        args3.recycle();
        throw th;
    }

    public BatteryService(Context context) {
        Looper r0 = Looper.myLooper();
        r0.getClass();
        this(context, r0);
    }

    public BatteryService(Context context, Looper looper) {
        super(context);
        this.mConditionVariable = new ConditionVariable();
        this.mLock = new Object();
        this.mLastHealthInfo = new HealthInfo();
        this.mLastBroadcastPlugType = -1;
        this.mSequence = 1;
        this.mIsFirstBatteryChangedUpdate = true;
        this.mSentLowBatteryBroadcast = false;
        this.mChargingPolicyChangeListeners = new CopyOnWriteArraySet();
        this.mLocalCallback = new BatteryService$$ExternalSyntheticLambda4();
        this.lastReportTime = -1;
        looper.getClass();
        this.mContext = context;
        this.mHandler = new Handler(looper, this.mLocalCallback, true);
        this.mLed = new Led(this, context, (LightsManager) getLocalService(LightsManager.class));
        this.mBatteryStats = BatteryStatsService.getService();
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        this.mCriticalBatteryLevel = this.mContext.getResources().getInteger(R.integer.config_defaultAlarmVibrationIntensity);
        this.mLowBatteryWarningLevel = this.mContext.getResources().getInteger(R.integer.config_maximumScreenDimDuration);
        this.mLowBatteryCloseWarningLevel = this.mLowBatteryWarningLevel + this.mContext.getResources().getInteger(R.integer.config_maximumCallLogEntriesPerSim);
        this.mShutdownBatteryTemperature = this.mContext.getResources().getInteger(R.integer.config_timeout_to_receive_delivered_ack_millis);
        this.mShutdownIfNoPower = this.mContext.getResources().getBoolean(R.bool.config_smma_notification_supported_over_ims);
        sSystemUiPackage = this.mContext.getResources().getString(R.string.config_systemUi);
        this.mBatteryLevelsEventQueue = new ArrayDeque();
        this.mMetricsLogger = new MetricsLogger();
        if (new File("/sys/devices/virtual/switch/invalid_charger/state").exists() == false) goto L5;
        UEventObserver invalidChargerObserver = new AnonymousClass1(this);
        invalidChargerObserver.startObserving("DEVPATH=/devices/virtual/switch/invalid_charger");
    L5:
        UEventObserver wirelessChargerObserver = new AnonymousClass2(this);
        wirelessChargerObserver.startObserving("wipower=detect");
        this.mBatteryInputSuspended = ((Boolean) PowerProperties.battery_input_suspended().orElse(false)).booleanValue();
        this.mSmtEx = new BatteryServiceSmtEx(this);
        SysOptBridge.getFactory().getBatteryServiceOptEx().init(this.mContext, this);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        registerHealthCallback();
        BatteryServiceIA r1 = null;
        this.mBinderService = new BinderService(this, r1);
        publishBinderService("battery", this.mBinderService);
        this.mBatteryPropertiesRegistrar = new BatteryPropertiesRegistrar(this, r1);
        publishBinderService("batteryproperties", this.mBatteryPropertiesRegistrar);
        publishLocalService(BatteryManagerInternal.class, new LocalService(this, r1));
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 550) goto L12;
        Object r0 = this.mLock;
        monitor-enter(r0);
        final Handler r2 = this.mHandler;     // Catch: Throwable -> L9
        ContentObserver obs = new AnonymousClass3(this, r2);     // Catch: Throwable -> L9
        ContentResolver resolver = this.mContext.getContentResolver();     // Catch: Throwable -> L9
        resolver.registerContentObserver(Settings.Global.getUriFor("low_power_trigger_level"), false, obs, -1);     // Catch: Throwable -> L9
        updateBatteryWarningLevelLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        this.mSmtEx.registerReverseObserver();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void registerHealthCallback() {
        traceBegin("HealthInitWrapper");
        this.mHealthServiceWrapper = HealthServiceWrapper.create(new BatteryService$$ExternalSyntheticLambda9(this));     // Catch: Throwable -> L9 NoSuchElementException -> L11 RemoteException -> L13
        traceEnd();
        traceBegin("HealthInitWaitUpdate");
        long beforeWait = SystemClock.uptimeMillis();
        if (this.mHealthInfo != null) goto L7;
        Slog.i(TAG, "health: Waited " + (SystemClock.uptimeMillis() - beforeWait) + "ms for callbacks. Waiting another 1000 ms...");
        this.mConditionVariable.block(1000);
    L7:
        Slog.i(TAG, "health: Waited " + (SystemClock.uptimeMillis() - beforeWait) + "ms and received the update.");
        traceEnd();
        return;
    L9:
        th = move-exception;
        traceEnd();
        throw th;
    L13:
        ex = move-exception;
        Slog.e(TAG, "health: cannot register callback. (RemoteException)");     // Catch: Throwable -> L9
        throw ex.rethrowFromSystemServer();     // Catch: Throwable -> L9
    L11:
        ex = move-exception;
        Slog.e(TAG, "health: cannot register callback. (no supported health HAL service)");     // Catch: Throwable -> L9
        throw ex;     // Catch: Throwable -> L9
    }

    private void updateBatteryWarningLevelLocked() {
        ContentResolver resolver = this.mContext.getContentResolver();
        int defWarnLevel = this.mContext.getResources().getInteger(R.integer.config_maximumScreenDimDuration);
        this.mLastLowBatteryWarningLevel = this.mLowBatteryWarningLevel;
        this.mLowBatteryWarningLevel = Settings.Global.getInt(resolver, "low_power_trigger_level", defWarnLevel);
        if (this.mLowBatteryWarningLevel != 0) goto L6;
        this.mLowBatteryWarningLevel = defWarnLevel;
    L6:
        if (this.mLowBatteryWarningLevel >= this.mCriticalBatteryLevel) goto L8;
        this.mLowBatteryWarningLevel = this.mCriticalBatteryLevel;
    L8:
        this.mLowBatteryCloseWarningLevel = this.mLowBatteryWarningLevel + this.mContext.getResources().getInteger(R.integer.config_maximumCallLogEntriesPerSim);
        Slog.i(TAG, "updateBatteryWarningLevel. lowWarningLevel:" + this.mLowBatteryWarningLevel + ", criticalBatteryLevel:" + this.mCriticalBatteryLevel + ", closeBatteryWarningLevel:" + this.mLowBatteryCloseWarningLevel);
        processValuesLocked(true);
    }

    private boolean isPoweredLocked(int plugTypeSet) {
        if (this.mHealthInfo.batteryStatus != 1) goto L6;
        return true;
    L6:
        if ((plugTypeSet & 1) == 0) goto L11;
        if (this.mHealthInfo.chargerAcOnline == false) goto L11;
        return true;
    L11:
        if ((plugTypeSet & 2) == 0) goto L16;
        if (this.mHealthInfo.chargerUsbOnline == false) goto L16;
        return true;
    L16:
        if ((plugTypeSet & 4) == 0) goto L21;
        if (this.mHealthInfo.chargerWirelessOnline == false) goto L21;
        return true;
    L21:
        if ((plugTypeSet & 8) != 0) goto L23;
        return false;
    L23:
        if (this.mHealthInfo.chargerDockOnline == false) goto L27;
        return true;
    L27:
        return false;
    }

    private boolean shouldSendBatteryLowLocked() {
        if (this.mPlugType == 0) goto L5;
        boolean plugged = true;
    L7:
        if (this.mLastBroadcastPlugType == 0) goto L9;
        boolean oldPlugged = true;
    L10:
        if (plugged == false) goto L12;
        return false;
    L12:
        if (this.mHealthInfo.batteryStatus != 1) goto L14;
        return false;
    L14:
        if (this.mHealthInfo.batteryLevel > this.mLowBatteryWarningLevel) goto L24;
        if (oldPlugged == true) goto L21;
        if (this.mLastBroadcastBatteryLevel > this.mLowBatteryWarningLevel) goto L21;
        if (this.mHealthInfo.batteryLevel > this.mLastLowBatteryWarningLevel) goto L21;
        return false;
    L21:
        return true;
    L24:
        return false;
    L9:
        oldPlugged = false;
        goto L10
    L5:
        plugged = false;
        goto L7
    }

    private boolean shouldShutdownLocked() {
        if (this.mHealthInfo.batteryCapacityLevel == (-1)) goto L10;
        if (this.mHealthInfo.batteryCapacityLevel != 1) goto L8;
        return true;
    L8:
        return false;
    L10:
        if (this.mShutdownIfNoPower == true) goto L13;
        return false;
    L13:
        if (this.mHealthInfo.batteryLevel <= 0) goto L16;
        return false;
    L16:
        if (this.mHealthInfo.batteryPresent == true) goto L19;
        return false;
    L19:
        if (this.mHealthInfo.batteryStatus == 2) goto L22;
        return true;
    L22:
        return false;
    }

    private void shutdownIfNoPowerLocked() {
        if (shouldShutdownLocked() == false) goto L6;
        final Intent intent = new Intent("com.android.internal.intent.action.REQUEST_SHUTDOWN");
        intent.putExtra("android.intent.extra.KEY_CONFIRM", false);
        intent.putExtra("android.intent.extra.REASON", "battery");
        intent.setFlags(268435456);
        this.mHandler.post(new BatteryService$$ExternalSyntheticLambda1(this, intent));
        return;
    }

    private /* synthetic */ void lambda$shutdownIfNoPowerLocked$1(Intent intent) {
        startShutdownActivity(intent);
    }

    private void shutdownIfOverTempLocked() {
        if (this.mHealthInfo.batteryTemperatureTenthsCelsius <= this.mShutdownBatteryTemperature) goto L6;
        final Intent intent = new Intent("com.android.internal.intent.action.REQUEST_SHUTDOWN");
        intent.putExtra("android.intent.extra.KEY_CONFIRM", false);
        intent.putExtra("android.intent.extra.REASON", "thermal,battery");
        intent.setFlags(268435456);
        this.mHandler.post(new BatteryService$$ExternalSyntheticLambda2(this, intent));
        return;
    }

    private /* synthetic */ void lambda$shutdownIfOverTempLocked$2(Intent intent) {
        startShutdownActivity(intent);
    }

    private void startShutdownActivity(Intent intent) {
        if (this.mActivityManagerInternal.isSystemReady() == true) goto L5;
        return;
    L5:
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        if (pmi != null) goto L8;
        return;
    L8:
        List<ResolveInfo> resolveInfos = pmi.queryIntentActivities(intent, null, 0, Process.myUid(), this.mActivityManagerInternal.getCurrentUserId());
        if (resolveInfos == null) goto L23;
        int i = 0;
    L12:
        if (i >= resolveInfos.size()) goto L23;
        ResolveInfo ri = resolveInfos.get(i);
        if (ri.activityInfo == null) goto L22;
        if (ri.activityInfo.applicationInfo == null) goto L22;
        if (this.mContext.checkPermission("android.permission.SHUTDOWN", 0, ri.activityInfo.applicationInfo.uid) == 0) goto L21;
        Slog.w(TAG, "Shutdown activity " + ri.activityInfo.getComponentName() + " does not have permission android.permission.SHUTDOWN");
        goto L22
    L21:
        intent.setComponent(ri.activityInfo.getComponentName());
    L22:
        i = i + 1;
    L23:
        this.mContext.startActivityAsUser(intent, UserHandle.CURRENT);
    }

    public void update(HealthInfo info) {
        traceBegin("HealthInfoUpdate");
        Trace.traceCounter(131072, "BatteryChargeCounter", info.batteryChargeCounterUah);
        Trace.traceCounter(131072, "BatteryCurrent", info.batteryCurrentMicroamps);
        Trace.traceCounter(131072, "PlugType", plugType(info));
        Trace.traceCounter(131072, "BatteryStatus", info.batteryStatus);
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mUpdatesStopped == true) goto L9;
        this.mHealthInfo = info;     // Catch: Throwable -> L7
        processValuesLocked(false);     // Catch: Throwable -> L7
        this.mConditionVariable.open();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        traceEnd();
        return;
    L9:
        Utils.copyV1Battery(this.mLastHealthInfo, info);     // Catch: Throwable -> L7
        goto L10
    }

    private static int plugType(HealthInfo healthInfo) {
        if (healthInfo.chargerAcOnline == false) goto L7;
        return 1;
    L7:
        if (healthInfo.chargerUsbOnline == false) goto L11;
        return 2;
    L11:
        if (healthInfo.chargerWirelessOnline == false) goto L15;
        return 4;
    L15:
        if (healthInfo.chargerDockOnline == false) goto L18;
        return 8;
    L18:
        return 0;
    }

    private void processValuesLocked(boolean r21) {
        boolean r2 = false;
        long r3 = 0;
        if (this.mHealthInfo.batteryStatus != 1) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.mBatteryLevelCritical = r0;
        this.mPlugType = plugType(this.mHealthInfo);
        boolean r18 = false;
        this.mBatteryStats.setBatteryState(this.mHealthInfo.batteryStatus, this.mHealthInfo.batteryHealth, this.mPlugType, this.mHealthInfo.batteryLevel, this.mHealthInfo.batteryTemperatureTenthsCelsius, this.mHealthInfo.batteryVoltageMillivolts, this.mHealthInfo.batteryChargeCounterUah, this.mHealthInfo.batteryFullChargeUah, this.mHealthInfo.batteryChargeTimeToFullNowSeconds);     // Catch: RemoteException -> L13
    L17:
        shutdownIfNoPowerLocked();
        shutdownIfOverTempLocked();
        if (r21 == false) goto L20;
    L21:
        this.mLastChargingPolicy = this.mHealthInfo.chargingPolicy;
        this.mHandler.post(new BatteryService$$ExternalSyntheticLambda6(this));
    L22:
        boolean r1 = r18;
        if (r21 == true) goto L52;
        if (this.mHealthInfo.batteryStatus != this.mLastBroadcastBatteryStatus) goto L52;
        if (this.mHealthInfo.batteryHealth != this.mLastBroadcastBatteryHealth) goto L52;
        if (this.mHealthInfo.batteryPresent != this.mLastBroadcastBatteryPresent) goto L52;
        if (this.mHealthInfo.batteryLevel != this.mLastBroadcastBatteryLevel) goto L52;
        if (this.mPlugType != this.mLastBroadcastPlugType) goto L52;
        if (this.mHealthInfo.batteryVoltageMillivolts != this.mLastBroadcastBatteryVoltage) goto L52;
        if (this.mHealthInfo.batteryTemperatureTenthsCelsius != this.mLastBroadcastBatteryTemperature) goto L52;
        if (this.mHealthInfo.maxChargingCurrentMicroamps != this.mLastBroadcastMaxChargingCurrent) goto L52;
        if (this.mHealthInfo.maxChargingVoltageMicrovolts != this.mLastBroadcastMaxChargingVoltage) goto L52;
        if (r1 == true) goto L52;
        if (this.mInvalidCharger != this.mLastBroadcastInvalidCharger) goto L52;
        if (this.mHealthInfo.batteryCycleCount != this.mLastBroadcastBatteryCycleCount) goto L52;
        if (this.mHealthInfo.chargingState != this.mLastBroadcastChargingState) goto L52;
        if (this.mHealthInfo.batteryCapacityLevel != this.mLastBroadcastBatteryCapacityLevel) goto L52;
        return;
    L52:
        if (this.mPlugType == this.mLastBroadcastPlugType) goto L70;
        if (this.mLastBroadcastPlugType != 0) goto L62;
        this.mChargeStartLevel = this.mHealthInfo.batteryLevel;
        this.mChargeStartTime = SystemClock.elapsedRealtime();
        LogMaker r5 = new LogMaker(1417);
        r5.setType(4);
        r5.addTaggedData(1421, Integer.valueOf(this.mPlugType));
        r5.addTaggedData(1418, Integer.valueOf(this.mHealthInfo.batteryLevel));
        this.mMetricsLogger.write(r5);
        if (this.mDischargeStartTime == 0) goto L70;
        if (this.mDischargeStartLevel == this.mHealthInfo.batteryLevel) goto L70;
        r3 = SystemClock.elapsedRealtime() - this.mDischargeStartTime;
        r2 = true;
        EventLog.writeEvent(EventLogTags.BATTERY_DISCHARGE, new Object[]{Long.valueOf(r3), Integer.valueOf(this.mDischargeStartLevel), Integer.valueOf(this.mHealthInfo.batteryLevel)});
        this.mDischargeStartTime = 0;
        goto L70
    L62:
        if (this.mPlugType != 0) goto L70;
        this.mDischargeStartTime = SystemClock.elapsedRealtime();
        this.mDischargeStartLevel = this.mHealthInfo.batteryLevel;
        long r11 = SystemClock.elapsedRealtime() - this.mChargeStartTime;
        if (this.mChargeStartTime != 0) goto L66;
    L68:
        this.mChargeStartTime = 0;
        goto L70
    L66:
        if (r11 == 0) goto L68;
        LogMaker r6 = new LogMaker(1417);
        r6.setType(5);
        r6.addTaggedData(1421, Integer.valueOf(this.mLastBroadcastPlugType));
        r6.addTaggedData(1420, Long.valueOf(r11));
        r6.addTaggedData(1418, Integer.valueOf(this.mChargeStartLevel));
        r6.addTaggedData(1419, Integer.valueOf(this.mHealthInfo.batteryLevel));
        this.mMetricsLogger.write(r6);
    L70:
        if (this.mHealthInfo.batteryStatus == this.mLastBroadcastBatteryStatus) goto L72;
    L77:
        EventLog.writeEvent(EventLogTags.BATTERY_STATUS, new Object[]{Integer.valueOf(this.mHealthInfo.batteryStatus), Integer.valueOf(this.mHealthInfo.batteryHealth), Integer.valueOf(this.mHealthInfo.batteryPresent ? 1 : 0), Integer.valueOf(this.mPlugType), this.mHealthInfo.batteryTechnology});
        SystemProperties.set("debug.tracing.battery_status", Integer.toString(this.mHealthInfo.batteryStatus));
        SystemProperties.set("debug.tracing.plug_type", Integer.toString(this.mPlugType));
    L79:
        if (this.mHealthInfo.batteryLevel == this.mLastBroadcastBatteryLevel) goto L81;
    L82:
        EventLog.writeEvent(EventLogTags.BATTERY_LEVEL, new Object[]{Integer.valueOf(this.mHealthInfo.batteryLevel), Integer.valueOf(this.mHealthInfo.batteryVoltageMillivolts), Integer.valueOf(this.mHealthInfo.batteryTemperatureTenthsCelsius)});
    L84:
        if (this.mBatteryLevelCritical == false) goto L91;
        if (this.mLastBroadcastBatteryLevelCritical == true) goto L91;
        if (this.mPlugType != 0) goto L91;
        r2 = true;
        r3 = SystemClock.elapsedRealtime() - this.mDischargeStartTime;
    L91:
        if (this.mBatteryLevelLow == true) goto L98;
        if (this.mHealthInfo.batteryStatus != 1) goto L95;
    L104:
        this.mSequence++;
        if (this.mPlugType == 0) goto L111;
        if (this.mLastBroadcastPlugType != 0) goto L111;
        Intent r7 = new Intent("android.intent.action.ACTION_POWER_CONNECTED");
        r7.setFlags(67108864);
        r7.putExtra(DeviceStorageMonitorService.EXTRA_SEQUENCE, this.mSequence);
        this.mHandler.removeMessages(2);
        SomeArgs r12 = SomeArgs.obtain();
        r12.arg1 = this.mContext;
        r12.arg2 = r7;
        this.mHandler.obtainMessage(2, r12).sendToTarget();
    L116:
        if (shouldSendBatteryLowLocked() == false) goto L120;
        this.mSentLowBatteryBroadcast = true;
        Intent r8 = new Intent("android.intent.action.BATTERY_LOW");
        r8.setFlags(67108864);
        r8.putExtra(DeviceStorageMonitorService.EXTRA_SEQUENCE, this.mSequence);
        this.mHandler.removeMessages(3);
        SomeArgs r9 = SomeArgs.obtain();
        r9.arg1 = this.mContext;
        r9.arg2 = r8;
        this.mHandler.obtainMessage(3, r9).sendToTarget();
    L124:
        boolean r10 = rateLimitBatteryChangedBroadcast(r21);
        if (r10 == true) goto L128;
        sendBatteryChangedIntentLocked(r21);
    L128:
        if (this.mLastBroadcastBatteryLevel == this.mHealthInfo.batteryLevel) goto L130;
    L131:
        sendBatteryLevelChangedIntentLocked();
    L132:
        this.mSmtEx.sendBatteryDrainIntent();
        this.mLed.updateLightsLocked();
        if (r2 == true) goto L135;
    L137:
        if (r10 == true) goto L145;
        this.mLastBroadcastBatteryStatus = this.mHealthInfo.batteryStatus;
        this.mLastBroadcastBatteryHealth = this.mHealthInfo.batteryHealth;
        this.mLastBroadcastBatteryPresent = this.mHealthInfo.batteryPresent;
        this.mLastBroadcastBatteryLevel = this.mHealthInfo.batteryLevel;
        this.mLastBroadcastPlugType = this.mPlugType;
        this.mLastBroadcastBatteryVoltage = this.mHealthInfo.batteryVoltageMillivolts;
        this.mLastBroadcastBatteryTemperature = this.mHealthInfo.batteryTemperatureTenthsCelsius;
        this.mLastBroadcastMaxChargingCurrent = this.mHealthInfo.maxChargingCurrentMicroamps;
        this.mLastBroadcastMaxChargingVoltage = this.mHealthInfo.maxChargingVoltageMicrovolts;
        this.mLastBroadcastChargeCounter = this.mHealthInfo.batteryChargeCounterUah;
        this.mLastBroadcastBatteryLevelCritical = this.mBatteryLevelCritical;
        this.mLastBroadcastInvalidCharger = this.mInvalidCharger;
        this.mLastBroadcastBatteryCycleCount = this.mHealthInfo.batteryCycleCount;
        this.mLastBroadcastChargingState = this.mHealthInfo.chargingState;
        this.mLastBroadcastBatteryCapacityLevel = this.mHealthInfo.batteryCapacityLevel;
        return;
    L145:
        return;
    L135:
        if (r3 == 0) goto L137;
        logOutlierLocked(r3);
        goto L137
    L130:
        if (this.mLastBroadcastPlugType == this.mPlugType) goto L132;
    L120:
        if (this.mSentLowBatteryBroadcast == false) goto L124;
        if (this.mHealthInfo.batteryLevel < this.mLowBatteryCloseWarningLevel) goto L124;
        this.mSentLowBatteryBroadcast = false;
        Intent r13 = new Intent("android.intent.action.BATTERY_OKAY");
        r13.setFlags(67108864);
        r13.putExtra(DeviceStorageMonitorService.EXTRA_SEQUENCE, this.mSequence);
        this.mHandler.removeMessages(3);
        SomeArgs r14 = SomeArgs.obtain();
        r14.arg1 = this.mContext;
        r14.arg2 = r13;
        this.mHandler.obtainMessage(3, r14).sendToTarget();
    L111:
        if (this.mPlugType != 0) goto L116;
        if (this.mLastBroadcastPlugType == 0) goto L116;
        Intent r15 = new Intent("android.intent.action.ACTION_POWER_DISCONNECTED");
        r15.setFlags(67108864);
        r15.putExtra(DeviceStorageMonitorService.EXTRA_SEQUENCE, this.mSequence);
        this.mHandler.removeMessages(2);
        SomeArgs r16 = SomeArgs.obtain();
        r16.arg1 = this.mContext;
        r16.arg2 = r15;
        this.mHandler.obtainMessage(2, r16).sendToTarget();
        goto L116
    L95:
        if (this.mHealthInfo.batteryLevel > this.mLowBatteryWarningLevel) goto L104;
        this.mBatteryLevelLow = true;
        Slog.i(TAG, "Processing new values. set batteryLevelLow true. batteryLevel:" + this.mHealthInfo.batteryLevel + ", lowBatteryWarningLevel:" + this.mLowBatteryWarningLevel);
        goto L104
    L98:
        if (this.mHealthInfo.batteryLevel < this.mLowBatteryCloseWarningLevel) goto L100;
        this.mBatteryLevelLow = r18;
        Slog.i(TAG, "Processing new values. set batteryLevelLow false. batteryLevel:" + this.mHealthInfo.batteryLevel + ", lowBatteryCloseWarningLevel:" + this.mLowBatteryCloseWarningLevel);
        goto L104
    L100:
        if (r21 == false) goto L104;
        if (this.mHealthInfo.batteryLevel <= this.mLowBatteryWarningLevel) goto L104;
        this.mBatteryLevelLow = false;
        Slog.i(TAG, "Processing new values. set batteryLevelLow false. batteryLevel:" + this.mHealthInfo.batteryLevel + ", lowBatteryWarningLevel:" + this.mLowBatteryWarningLevel);
        goto L104
    L81:
        if (this.mHealthInfo.batteryVoltageMillivolts >= 3200) goto L84;
    L72:
        if (this.mHealthInfo.batteryHealth != this.mLastBroadcastBatteryHealth) goto L77;
        if (this.mHealthInfo.batteryPresent != this.mLastBroadcastBatteryPresent) goto L77;
        if (this.mPlugType == this.mLastBroadcastPlugType) goto L79;
    L20:
        if (this.mHealthInfo.chargingPolicy == this.mLastChargingPolicy) goto L22;
    L16:
        r18 = false;
        goto L17
    L5:
        if (this.mHealthInfo.batteryLevel > this.mCriticalBatteryLevel) goto L7;
        r0 = true;
        goto L8
    }

    private void sendBatteryChangedIntentLocked(boolean forceUpdate) {
        Intent intent = new Intent("android.intent.action.BATTERY_CHANGED");
        intent.addFlags(1610612736);
        int icon = getIconLocked(this.mHealthInfo.batteryLevel);
        intent.putExtra(DeviceStorageMonitorService.EXTRA_SEQUENCE, this.mSequence);
        intent.putExtra("status", this.mHealthInfo.batteryStatus);
        intent.putExtra("health", this.mHealthInfo.batteryHealth);
        intent.putExtra("present", this.mHealthInfo.batteryPresent);
        intent.putExtra("level", this.mHealthInfo.batteryLevel);
        intent.putExtra("battery_low", this.mSentLowBatteryBroadcast);
        intent.putExtra("scale", 100);
        intent.putExtra("icon-small", icon);
        intent.putExtra("plugged", this.mPlugType);
        intent.putExtra("voltage", this.mHealthInfo.batteryVoltageMillivolts);
        intent.putExtra("temperature", this.mHealthInfo.batteryTemperatureTenthsCelsius);
        intent.putExtra("technology", this.mHealthInfo.batteryTechnology);
        intent.putExtra("invalid_charger", this.mInvalidCharger);
        intent.putExtra("max_charging_current", this.mHealthInfo.maxChargingCurrentMicroamps);
        intent.putExtra("max_charging_voltage", this.mHealthInfo.maxChargingVoltageMicrovolts);
        intent.putExtra("charge_counter", this.mHealthInfo.batteryChargeCounterUah);
        intent.putExtra("android.os.extra.CYCLE_COUNT", this.mHealthInfo.batteryCycleCount);
        intent.putExtra("android.os.extra.CHARGING_STATUS", this.mHealthInfo.chargingState);
        intent.putExtra("android.os.extra.CAPACITY_LEVEL", this.mHealthInfo.batteryCapacityLevel);
        this.mHandler.removeMessages(1);
        SomeArgs args = SomeArgs.obtain();
        args.arg1 = this.mContext;
        args.arg2 = intent;
        args.arg3 = Boolean.valueOf(forceUpdate);
        this.mHandler.obtainMessage(1, args).sendToTarget();
    }

    private /* synthetic */ void lambda$sendBatteryChangedIntentLocked$3(Intent intent, boolean forceUpdate) {
        broadcastBatteryChangedIntent(this.mContext, intent, BATTERY_CHANGED_OPTIONS, forceUpdate);
    }

    private static void broadcastBatteryChangedIntent(Context context, Intent intent, Bundle options, boolean forceUpdate) {
        traceBatteryChangedBroadcastEvent(intent, forceUpdate);
        Intent fgIntent = new Intent(intent);
        fgIntent.addFlags(268435456);
        fgIntent.setPackage(sSystemUiPackage);
        context.sendBroadcastAsUser(fgIntent, UserHandle.ALL, null, options);
        ActivityManager.broadcastStickyIntent(intent, new String[]{sSystemUiPackage}, -1, options, -1);
    }

    private static void traceBatteryChangedBroadcastEvent(Intent intent, boolean forceUpdate) {
        if (Trace.isTagEnabled(524288) == true) goto L5;
        return;
    L5:
        Trace.instant(524288, "broadcastBatteryChanged; force=" + forceUpdate + ",seq=" + intent.getIntExtra(DeviceStorageMonitorService.EXTRA_SEQUENCE, -1) + ",s=" + intent.getIntExtra("status", -1) + ",h=" + intent.getIntExtra("health", -1) + ",p=" + intent.getBooleanExtra("present", false) + ",l=" + intent.getIntExtra("level", -1) + ",bl=" + intent.getBooleanExtra("battery_low", false) + ",sc=" + intent.getIntExtra("scale", -1) + ",pt=" + intent.getIntExtra("plugged", -1) + ",v=" + intent.getIntExtra("voltage", -1) + ",t=" + intent.getIntExtra("temperature", -1) + ",tech=" + intent.getStringExtra("technology") + ",invc=" + intent.getIntExtra("invalid_charger", -1) + ",mcc=" + intent.getIntExtra("max_charging_current", -1) + ",mcv=" + intent.getIntExtra("max_charging_voltage", -1) + ",chc=" + intent.getIntExtra("charge_counter", -1) + ",cc=" + intent.getIntExtra("android.os.extra.CYCLE_COUNT", -1) + ",chs=" + intent.getIntExtra("android.os.extra.CHARGING_STATUS", -1));
    }

    private void sendBatteryLevelChangedIntentLocked() {
        Bundle event = new Bundle();
        long now = SystemClock.elapsedRealtime();
        event.putInt(DeviceStorageMonitorService.EXTRA_SEQUENCE, this.mSequence);
        event.putInt("status", this.mHealthInfo.batteryStatus);
        event.putInt("health", this.mHealthInfo.batteryHealth);
        event.putBoolean("present", this.mHealthInfo.batteryPresent);
        event.putInt("level", this.mHealthInfo.batteryLevel);
        event.putBoolean("battery_low", this.mSentLowBatteryBroadcast);
        event.putInt("scale", 100);
        event.putInt("plugged", this.mPlugType);
        event.putInt("voltage", this.mHealthInfo.batteryVoltageMillivolts);
        event.putInt("temperature", this.mHealthInfo.batteryTemperatureTenthsCelsius);
        event.putInt("charge_counter", this.mHealthInfo.batteryChargeCounterUah);
        event.putLong("android.os.extra.EVENT_TIMESTAMP", now);
        event.putInt("android.os.extra.CYCLE_COUNT", this.mHealthInfo.batteryCycleCount);
        event.putInt("android.os.extra.CHARGING_STATUS", this.mHealthInfo.chargingState);
        event.putInt("android.os.extra.CAPACITY_LEVEL", this.mHealthInfo.batteryCapacityLevel);
        boolean queueWasEmpty = this.mBatteryLevelsEventQueue.isEmpty();
        this.mBatteryLevelsEventQueue.add(event);
        if (this.mBatteryLevelsEventQueue.size() <= 100) goto L5;
        this.mBatteryLevelsEventQueue.removeFirst();
    L5:
        if (queueWasEmpty == true) goto L7;
        return;
    L7:
        if ((now - this.mLastBatteryLevelChangedSentMs) <= 60000) goto L9;
        long delay = 0;
    L10:
        this.mHandler.postDelayed(new BatteryService$$ExternalSyntheticLambda0(this), delay);
        return;
    L9:
        delay = (this.mLastBatteryLevelChangedSentMs + 60000) - now;
        goto L10
    }

    private void sendEnqueuedBatteryLevelChangedEvents() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList<Bundle> events = new ArrayList(this.mBatteryLevelsEventQueue);     // Catch: Throwable -> L8
        this.mBatteryLevelsEventQueue.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        Intent intent = new Intent("android.intent.action.BATTERY_LEVEL_CHANGED");
        intent.addFlags(16777216);
        intent.putParcelableArrayListExtra("android.os.extra.EVENTS", events);
        this.mContext.sendBroadcastAsUser(intent, UserHandle.ALL, "android.permission.BATTERY_STATS");
        this.mLastBatteryLevelChangedSentMs = SystemClock.elapsedRealtime();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void notifyChargingPolicyChanged() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int newPolicy = this.mLastChargingPolicy;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        Iterator<BatteryManagerInternal.ChargingPolicyChangeListener> r1 = this.mChargingPolicyChangeListeners.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        BatteryManagerInternal.ChargingPolicyChangeListener listener = r1.next();
        listener.onChargingPolicyChanged(newPolicy);
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.String] */
    private void logBatteryStatsLocked() {
        String r0 = "failed to delete temporary dumpsys file: ";
        String r1 = "failed to close dumpsys output stream";
        IBinder r2 = ServiceManager.getService("batterystats");
        if (r2 != null) goto L5;
        return;
    L5:
        DropBoxManager r3 = (DropBoxManager) this.mContext.getSystemService("dropbox");
        if (r3 != null) goto L8;
        return;
    L8:
        if (r3.isTagEnabled("BATTERY_DISCHARGE_INFO") == false) goto L74;
        File r5 = null;
        FileOutputStream r6 = null;
        r5 = new File("/data/system/batterystats.dump");     // Catch: Throwable -> L20 IOException -> L22 RemoteException -> L24
        r6 = new FileOutputStream(r5);     // Catch: Throwable -> L20 IOException -> L22 RemoteException -> L24
        r2.dump(r6.getFD(), DUMPSYS_ARGS);     // Catch: Throwable -> L20 IOException -> L22 RemoteException -> L24
        FileUtils.sync(r6);     // Catch: Throwable -> L20 IOException -> L22 RemoteException -> L24
        r3.addFile("BATTERY_DISCHARGE_INFO", r5, 2);     // Catch: Throwable -> L20 IOException -> L22 RemoteException -> L24
        r6.close();     // Catch: IOException -> L14
    L16:
        r1 = r5.delete();
        if (r1 != 0) goto L68;
        String r4 = TAG;
        StringBuilder r7 = new StringBuilder();
        r1 = r4;
    L19:
        r7.append("failed to delete temporary dumpsys file: ");
        r7.append(r5.getAbsolutePath());
        r0 = r7.toString();
        Slog.e(r1, r0);
    L68:
        return;
    L15:
        Slog.e(TAG, "failed to close dumpsys output stream");
        goto L16
    L20:
        th = move-exception;
        if (r6 != null) goto L64;
    L54:
        if (r5 != null) goto L56;
        throw th;
    L56:
        if (r5.delete() == true) goto L73;
        Slog.e(TAG, r0 + r5.getAbsolutePath());
        throw th;
    L73:
        throw th;
    L64:
        r6.close();     // Catch: IOException -> L52
    L53:
        Slog.e(TAG, r1);
    L24:
        e = move-exception;
        Slog.e(TAG, "failed to dump battery service", e);     // Catch: Throwable -> L20
        if (r6 != null) goto L60;
    L44:
        if (r5 == null) goto L68;
        r1 = r5.delete();
        if (r1 != 0) goto L68;
        String r8 = TAG;
        r7 = new StringBuilder();
        r1 = r8;
        goto L19
    L60:
        r6.close();     // Catch: IOException -> L42
    L43:
        Slog.e(TAG, "failed to close dumpsys output stream");
    L22:
        e = move-exception;
        Slog.e(TAG, "failed to write dumpsys file", e);     // Catch: Throwable -> L20
        if (r6 != null) goto L66;
    L33:
        if (r5 == null) goto L68;
        r1 = r5.delete();
        if (r1 != 0) goto L68;
        String r9 = TAG;
        r7 = new StringBuilder();
        r1 = r9;
        goto L19
    L66:
        r6.close();     // Catch: IOException -> L31
    L32:
        Slog.e(TAG, "failed to close dumpsys output stream");
        goto L33
    }

    private void logOutlierLocked(long duration) {
        ContentResolver cr = this.mContext.getContentResolver();
        String dischargeThresholdString = Settings.Global.getString(cr, "battery_discharge_threshold");
        String durationThresholdString = Settings.Global.getString(cr, "battery_discharge_duration_threshold");
        if (dischargeThresholdString == null) goto L18;
        if (durationThresholdString == null) goto L19;
        long durationThreshold = Long.parseLong(durationThresholdString);     // Catch: NumberFormatException -> L11
        int dischargeThreshold = Integer.parseInt(dischargeThresholdString);     // Catch: NumberFormatException -> L11
        if (duration <= durationThreshold) goto L8;
        return;
    L8:
        if ((this.mDischargeStartLevel - this.mHealthInfo.batteryLevel) < dischargeThreshold) goto L21;
        logBatteryStatsLocked();     // Catch: NumberFormatException -> L11
        return;
    L21:
        return;
    L14:
        Slog.e(TAG, "Invalid DischargeThresholds GService string: " + durationThresholdString + " or " + dischargeThresholdString);
        return;
    L19:
        return;
    }

    private int getIconLocked(int level) {
        if (this.mHealthInfo.batteryStatus != 2) goto L6;
        return 17305190;
    L6:
        if (this.mHealthInfo.batteryStatus != 3) goto L9;
        return 17305176;
    L9:
        if (this.mHealthInfo.batteryStatus == 4) goto L16;
        if (this.mHealthInfo.batteryStatus == 5) goto L16;
        return 17305204;
    L16:
        if (isPoweredLocked(15) == true) goto L18;
    L20:
        return 17305176;
    L18:
        if (this.mHealthInfo.batteryLevel < 100) goto L20;
        return 17305190;
    }

    private boolean rateLimitBatteryChangedBroadcast(boolean forceUpdate) {
        if (this.mIsFirstBatteryChangedUpdate == false) goto L7;
        this.mLastBroadcastVoltageUpdateTime = SystemClock.elapsedRealtime();
        this.mLastBroadcastMaxChargingCurrentUpdateTime = SystemClock.elapsedRealtime();
        this.mIsFirstBatteryChangedUpdate = false;
        return false;
    L7:
        if (this.mLastBroadcastBatteryVoltage == this.mHealthInfo.batteryVoltageMillivolts) goto L9;
        boolean voltageUpdated = true;
    L11:
        if (this.mLastBroadcastBatteryTemperature == this.mHealthInfo.batteryTemperatureTenthsCelsius) goto L13;
        boolean temperatureUpdated = true;
    L15:
        if (this.mLastBroadcastMaxChargingCurrent == this.mHealthInfo.maxChargingCurrentMicroamps) goto L17;
        boolean maxChargingCurrentUpdated = true;
    L18:
        if (forceUpdate == false) goto L20;
    L41:
        boolean otherStatesUpdated = true;
    L42:
        if (otherStatesUpdated == false) goto L48;
        if (voltageUpdated == false) goto L45;
        this.mLastBroadcastVoltageUpdateTime = SystemClock.elapsedRealtime();
    L45:
        if (maxChargingCurrentUpdated == false) goto L47;
        this.mLastBroadcastMaxChargingCurrentUpdateTime = SystemClock.elapsedRealtime();
    L47:
        return false;
    L48:
        float basePointDiff = (this.mLastBroadcastBatteryVoltage - this.mHealthInfo.batteryVoltageMillivolts) / this.mLastBroadcastBatteryVoltage;
        if (voltageUpdated == true) goto L51;
    L59:
        if (temperatureUpdated == true) goto L61;
    L67:
        if (maxChargingCurrentUpdated == true) goto L69;
    L74:
        return true;
    L69:
        if ((SystemClock.elapsedRealtime() - this.mLastBroadcastMaxChargingCurrentUpdateTime) < 5000) goto L74;
        this.mLastBroadcastMaxChargingCurrentUpdateTime = SystemClock.elapsedRealtime();
        if (voltageUpdated == false) goto L73;
        this.mLastBroadcastVoltageUpdateTime = SystemClock.elapsedRealtime();
    L73:
        return false;
    L61:
        if (Math.abs(this.mLastBroadcastBatteryTemperature - this.mHealthInfo.batteryTemperatureTenthsCelsius) < 10) goto L67;
        if (voltageUpdated == false) goto L64;
        this.mLastBroadcastVoltageUpdateTime = SystemClock.elapsedRealtime();
    L64:
        if (maxChargingCurrentUpdated == false) goto L66;
        this.mLastBroadcastMaxChargingCurrentUpdateTime = SystemClock.elapsedRealtime();
    L66:
        return false;
    L51:
        if (Math.abs(basePointDiff) < 0.01f) goto L59;
        if ((SystemClock.elapsedRealtime() - this.mLastBroadcastVoltageUpdateTime) < 20000) goto L59;
        this.mLastBroadcastVoltageUpdateTime = SystemClock.elapsedRealtime();
        if (maxChargingCurrentUpdated == false) goto L57;
        this.mLastBroadcastMaxChargingCurrentUpdateTime = SystemClock.elapsedRealtime();
    L57:
        return false;
    L20:
        if (this.mHealthInfo.batteryStatus != this.mLastBroadcastBatteryStatus) goto L41;
        if (this.mHealthInfo.batteryHealth != this.mLastBroadcastBatteryHealth) goto L41;
        if (this.mHealthInfo.batteryPresent != this.mLastBroadcastBatteryPresent) goto L41;
        if (this.mHealthInfo.batteryLevel != this.mLastBroadcastBatteryLevel) goto L41;
        if (this.mPlugType != this.mLastBroadcastPlugType) goto L41;
        if (this.mHealthInfo.maxChargingVoltageMicrovolts != this.mLastBroadcastMaxChargingVoltage) goto L41;
        if (this.mInvalidCharger != this.mLastBroadcastInvalidCharger) goto L41;
        if (this.mHealthInfo.batteryCycleCount != this.mLastBroadcastBatteryCycleCount) goto L41;
        if (this.mHealthInfo.chargingState != this.mLastBroadcastChargingState) goto L41;
        if (this.mHealthInfo.batteryCapacityLevel != this.mLastBroadcastBatteryCapacityLevel) goto L41;
        otherStatesUpdated = false;
        goto L42
    L17:
        maxChargingCurrentUpdated = false;
        goto L18
    L13:
        temperatureUpdated = false;
        goto L15
    L9:
        voltageUpdated = false;
        goto L11
    }

    static void dumpHelp(PrintWriter pw) {
        pw.println("Battery service (battery) commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        String getSetOptions = "ac|usb|wireless|dock|status|level|temp|present|counter|invalid|current_now|current_average";
        pw.println("  get [-f] [" + getSetOptions + "]");
        pw.println("    Gets the value of a battery state.");
        pw.println("    -f: force to get the latest property value.");
        pw.println("  set [-f] [" + getSetOptions + "] <value>");
        pw.println("    Force a battery property value, freezing battery state.");
        pw.println("    -f: force a battery change broadcast be sent, prints new sequence.");
        pw.println("  unplug [-f]");
        pw.println("    Force battery unplugged, freezing battery state.");
        pw.println("    -f: force a battery change broadcast be sent, prints new sequence.");
        pw.println("  reset [-f]");
        pw.println("    Unfreeze battery state, returning to current hardware values.");
        pw.println("    -f: force a battery change broadcast be sent, prints new sequence.");
        if (Build.IS_DEBUGGABLE == false) goto L6;
        pw.println("  suspend_input");
        pw.println("    Suspend charging even if plugged in. ");
        return;
    }

    int parseOptions(Shell shell) {
        int opts = 0;
    L3:
        String opt = shell.getNextOption();
        if (opt == null) goto L8;
        if ("-f".equals(opt) == false) goto L3;
        opts = opts | 1;
        goto L3
    L8:
        return opts;
    }

    int onShellCommand(Shell shell, String cmd) {
        if (cmd == null) goto L5;
        PrintWriter pw = shell.getOutPrintWriter();
        boolean r9 = true;
        switch(cmd.hashCode()) {
            case -840325209: goto L22;
            case -541966841: goto L19;
            case 102230: goto L16;
            case 113762: goto L13;
            case 108404047: goto L10;
            default: goto L24;
        };
    L24:
        byte r0 = -1;
    L26:
        switch(r0) {
            case 0: goto L200;
            case 1: goto L137;
            case 2: goto L35;
            case 3: goto L30;
            case 4: goto L29;
            default: goto L28;
        };
    L29:
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        suspendBatteryInput();
    L205:
        return 0;
    L30:
        int opts = parseOptions(shell);
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        if ((opts & 1) != 0) goto L34;
        r9 = false;
    L34:
        resetBattery(r9, pw);
        goto L205
    L35:
        int opts2 = parseOptions(shell);
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        String key = shell.getNextArg();
        if (key != null) goto L39;
        pw.println("No property specified");
        return -1;
    L39:
        String value = shell.getNextArg();
        if (value != null) goto L208;
        pw.println("No value specified");
        return -1;
    L208:
        if (this.mUpdatesStopped == true) goto L49;
        Utils.copyV1Battery(this.mLastHealthInfo, this.mHealthInfo);     // Catch: NumberFormatException -> L46
    L49:
        switch(key.hashCode()) {
            case -1000044642: goto L85;
            case -892481550: goto L82;
            case -379340457: goto L79;
            case -318277445: goto L76;
            case 3106: goto L73;
            case 116100: goto L70;
            case 3088947: goto L67;
            case 3556308: goto L64;
            case 102865796: goto L61;
            case 601568016: goto L58;
            case 957830652: goto L55;
            case 1959784951: goto L52;
            default: goto L87;
        };     // Catch: NumberFormatException -> L46
    L87:
        byte r4 = -1;
    L88:
        switch(r4) {
            case 0: goto L117;
            case 1: goto L112;
            case 2: goto L107;
            case 3: goto L102;
            case 4: goto L97;
            case 5: goto L96;
            case 6: goto L95;
            case 7: goto L94;
            case 8: goto L93;
            case 9: goto L91;
            case 10: goto L92;
            case 11: goto L90;
            default: goto L89;
        };     // Catch: NumberFormatException -> L46
    L89:
        pw.println("Unknown set option: " + key);     // Catch: NumberFormatException -> L46
        boolean update = false;
    L123:
        if (update == false) goto L205;
        long ident = Binder.clearCallingIdentity();     // Catch: NumberFormatException -> L46
        this.mUpdatesStopped = true;     // Catch: Throwable -> L131
        if ((opts2 & 1) != 0) goto L129;
        r9 = false;
    L129:
        processValuesLocked(r9, pw);     // Catch: Throwable -> L131
        Binder.restoreCallingIdentity(ident);     // Catch: NumberFormatException -> L46
        goto L205
    L131:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: NumberFormatException -> L46
        throw th;     // Catch: NumberFormatException -> L46
    L90:
        this.mInvalidCharger = Integer.parseInt(value);     // Catch: NumberFormatException -> L46
    L122:
        update = true;
        goto L123
    L91:
        this.mHealthInfo.batteryCurrentAverageMicroamps = Integer.parseInt(value);     // Catch: NumberFormatException -> L46
    L92:
        this.mHealthInfo.batteryTemperatureTenthsCelsius = Integer.parseInt(value);     // Catch: NumberFormatException -> L46
        goto L122
    L93:
        this.mHealthInfo.batteryCurrentMicroamps = Integer.parseInt(value);     // Catch: NumberFormatException -> L46
        goto L122
    L94:
        this.mHealthInfo.batteryChargeCounterUah = Integer.parseInt(value);     // Catch: NumberFormatException -> L46
        goto L122
    L95:
        this.mHealthInfo.batteryLevel = Integer.parseInt(value);     // Catch: NumberFormatException -> L46
        goto L122
    L96:
        this.mHealthInfo.batteryStatus = Integer.parseInt(value);     // Catch: NumberFormatException -> L46
        goto L122
    L97:
        HealthInfo r5 = this.mHealthInfo;     // Catch: NumberFormatException -> L46
        if (Integer.parseInt(value) == 0) goto L100;
        boolean r6 = true;
    L101:
        r5.chargerDockOnline = r6;     // Catch: NumberFormatException -> L46
        goto L122
    L100:
        r6 = false;
        goto L101
    L102:
        HealthInfo r7 = this.mHealthInfo;     // Catch: NumberFormatException -> L46
        if (Integer.parseInt(value) == 0) goto L105;
        boolean r8 = true;
    L106:
        r7.chargerWirelessOnline = r8;     // Catch: NumberFormatException -> L46
        goto L122
    L105:
        r8 = false;
        goto L106
    L107:
        HealthInfo r10 = this.mHealthInfo;     // Catch: NumberFormatException -> L46
        if (Integer.parseInt(value) == 0) goto L110;
        boolean r11 = true;
    L111:
        r10.chargerUsbOnline = r11;     // Catch: NumberFormatException -> L46
        goto L122
    L110:
        r11 = false;
        goto L111
    L112:
        HealthInfo r12 = this.mHealthInfo;     // Catch: NumberFormatException -> L46
        if (Integer.parseInt(value) == 0) goto L115;
        boolean r13 = true;
    L116:
        r12.chargerAcOnline = r13;     // Catch: NumberFormatException -> L46
        goto L122
    L115:
        r13 = false;
        goto L116
    L117:
        HealthInfo r14 = this.mHealthInfo;     // Catch: NumberFormatException -> L46
        if (Integer.parseInt(value) == 0) goto L120;
        boolean r15 = true;
    L121:
        r14.batteryPresent = r15;     // Catch: NumberFormatException -> L46
        goto L122
    L120:
        r15 = false;
        goto L121
    L52:
        if (key.equals("invalid") == false) goto L87;
        r4 = 11;
        goto L88
    L55:
        if (key.equals("counter") == false) goto L87;
        r4 = 7;
        goto L88
    L58:
        if (key.equals("current_now") == false) goto L87;
        r4 = 8;
        goto L88
    L61:
        if (key.equals("level") == false) goto L87;
        r4 = 6;
        goto L88
    L64:
        if (key.equals("temp") == false) goto L87;
        r4 = 10;
        goto L88
    L67:
        if (key.equals("dock") == false) goto L87;
        r4 = 4;
        goto L88
    L70:
        if (key.equals("usb") == false) goto L87;
        r4 = 2;
        goto L88
    L73:
        if (key.equals("ac") == false) goto L87;
        r4 = 1;
        goto L88
    L76:
        if (key.equals("present") == false) goto L87;
        r4 = 0;
        goto L88
    L79:
        if (key.equals("current_average") == false) goto L87;
        r4 = 9;
        goto L88
    L82:
        if (key.equals("status") == false) goto L87;
        r4 = 5;
        goto L88
    L85:
        if (key.equals("wireless") == false) goto L87;
        r4 = 3;
    L135:
        pw.println("Bad value: " + value);
        return -1;
    L137:
        int opts3 = parseOptions(shell);
        String key2 = shell.getNextArg();
        if (key2 != null) goto L142;
        pw.println("No property specified");
        return -1;
    L142:
        if ((opts3 & 1) == 0) goto L146;
        this.mConditionVariable.close();
        updateHealthInfo();
        this.mConditionVariable.block(1000);
    L146:
        switch(key2.hashCode()) {
            case -1000044642: goto L182;
            case -892481550: goto L179;
            case -379340457: goto L176;
            case -318277445: goto L173;
            case 3106: goto L170;
            case 116100: goto L167;
            case 3088947: goto L164;
            case 3556308: goto L161;
            case 102865796: goto L158;
            case 601568016: goto L155;
            case 957830652: goto L152;
            case 1959784951: goto L149;
            default: goto L184;
        };
    L184:
        byte r16 = -1;
    L185:
        switch(r16) {
            case 0: goto L198;
            case 1: goto L197;
            case 2: goto L196;
            case 3: goto L195;
            case 4: goto L194;
            case 5: goto L193;
            case 6: goto L192;
            case 7: goto L191;
            case 8: goto L190;
            case 9: goto L189;
            case 10: goto L188;
            case 11: goto L187;
            default: goto L186;
        };
    L186:
        pw.println("Unknown get option: " + key2);
        goto L205
    L187:
        pw.println(this.mInvalidCharger);
        goto L205
    L188:
        pw.println(this.mHealthInfo.batteryTemperatureTenthsCelsius);
        goto L205
    L189:
        pw.println(this.mHealthInfo.batteryCurrentAverageMicroamps);
        goto L205
    L190:
        pw.println(this.mHealthInfo.batteryCurrentMicroamps);
        goto L205
    L191:
        pw.println(this.mHealthInfo.batteryChargeCounterUah);
        goto L205
    L192:
        pw.println(this.mHealthInfo.batteryLevel);
        goto L205
    L193:
        pw.println(this.mHealthInfo.batteryStatus);
        goto L205
    L194:
        pw.println(this.mHealthInfo.chargerDockOnline);
        goto L205
    L195:
        pw.println(this.mHealthInfo.chargerWirelessOnline);
        goto L205
    L196:
        pw.println(this.mHealthInfo.chargerUsbOnline);
        goto L205
    L197:
        pw.println(this.mHealthInfo.chargerAcOnline);
        goto L205
    L198:
        pw.println(this.mHealthInfo.batteryPresent);
        goto L205
    L149:
        if (key2.equals("invalid") == false) goto L209;
        r16 = 11;
        goto L185
    L209:
        r16 = -1;
        goto L185
    L152:
        if (key2.equals("counter") == false) goto L210;
        r16 = 7;
        goto L185
    L210:
        r16 = -1;
        goto L185
    L155:
        if (key2.equals("current_now") == false) goto L211;
        r16 = 8;
        goto L185
    L211:
        r16 = -1;
        goto L185
    L158:
        if (key2.equals("level") == false) goto L212;
        r16 = 6;
        goto L185
    L212:
        r16 = -1;
        goto L185
    L161:
        if (key2.equals("temp") == false) goto L213;
        r16 = 10;
        goto L185
    L213:
        r16 = -1;
        goto L185
    L164:
        if (key2.equals("dock") == false) goto L214;
        r16 = 4;
        goto L185
    L214:
        r16 = -1;
        goto L185
    L167:
        if (key2.equals("usb") == false) goto L215;
        r16 = 2;
        goto L185
    L215:
        r16 = -1;
        goto L185
    L170:
        if (key2.equals("ac") == false) goto L216;
        r16 = 1;
        goto L185
    L216:
        r16 = -1;
        goto L185
    L173:
        if (key2.equals("present") == false) goto L217;
        r16 = 0;
        goto L185
    L217:
        r16 = -1;
        goto L185
    L176:
        if (key2.equals("current_average") == false) goto L218;
        r16 = 9;
        goto L185
    L218:
        r16 = -1;
        goto L185
    L179:
        if (key2.equals("status") == false) goto L219;
        r16 = 5;
        goto L185
    L219:
        r16 = -1;
        goto L185
    L182:
        if (key2.equals("wireless") == false) goto L220;
        r16 = 3;
        goto L185
    L220:
        r16 = -1;
        goto L185
    L200:
        int opts4 = parseOptions(shell);
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        if ((opts4 & 1) == 0) goto L203;
        boolean r17 = true;
    L204:
        unplugBattery(r17, pw);
        goto L205
    L203:
        r17 = false;
        goto L204
    L28:
        return shell.handleDefaultCommands(cmd);
    L10:
        if (cmd.equals("reset") == false) goto L24;
        r0 = 3;
        goto L26
    L13:
        if (cmd.equals("set") == false) goto L24;
        r0 = 2;
        goto L26
    L16:
        if (cmd.equals("get") == false) goto L24;
        r0 = 1;
        goto L26
    L19:
        if (cmd.equals("suspend_input") == false) goto L24;
        r0 = 4;
        goto L26
    L22:
        if (cmd.equals("unplug") == false) goto L24;
        r0 = 0;
        goto L26
    L5:
        return shell.handleDefaultCommands(cmd);
    }

    private void updateHealthInfo() {
        this.mHealthServiceWrapper.scheduleUpdate();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Unable to update health service data.", e);
    }

    private void setChargerAcOnline(boolean online, final boolean forceUpdate) {
        if (this.mUpdatesStopped == true) goto L5;
        Utils.copyV1Battery(this.mLastHealthInfo, this.mHealthInfo);
    L5:
        this.mHealthInfo.chargerAcOnline = online;
        this.mUpdatesStopped = true;
        Binder.withCleanCallingIdentity(new BatteryService$$ExternalSyntheticLambda3(this, forceUpdate));
    }

    private /* synthetic */ void lambda$setChargerAcOnline$4(boolean forceUpdate) throws Exception {
        processValuesLocked(forceUpdate);
    }

    private void setBatteryLevel(int level, final boolean forceUpdate) {
        if (this.mUpdatesStopped == true) goto L5;
        Utils.copyV1Battery(this.mLastHealthInfo, this.mHealthInfo);
    L5:
        this.mHealthInfo.batteryLevel = level;
        this.mUpdatesStopped = true;
        Binder.withCleanCallingIdentity(new BatteryService$$ExternalSyntheticLambda7(this, forceUpdate));
    }

    private /* synthetic */ void lambda$setBatteryLevel$5(boolean forceUpdate) throws Exception {
        processValuesLocked(forceUpdate);
    }

    private void unplugBattery(final boolean forceUpdate, final PrintWriter pw) {
        if (this.mUpdatesStopped == true) goto L5;
        Utils.copyV1Battery(this.mLastHealthInfo, this.mHealthInfo);
    L5:
        this.mHealthInfo.chargerAcOnline = false;
        this.mHealthInfo.chargerUsbOnline = false;
        this.mHealthInfo.chargerWirelessOnline = false;
        this.mHealthInfo.chargerDockOnline = false;
        this.mUpdatesStopped = true;
        Binder.withCleanCallingIdentity(new BatteryService$$ExternalSyntheticLambda5(this, forceUpdate, pw));
    }

    private /* synthetic */ void lambda$unplugBattery$6(boolean forceUpdate, PrintWriter pw) throws Exception {
        processValuesLocked(forceUpdate, pw);
    }

    private void resetBattery(final boolean forceUpdate, final PrintWriter pw) {
        if (this.mUpdatesStopped == false) goto L6;
        this.mUpdatesStopped = false;
        Utils.copyV1Battery(this.mHealthInfo, this.mLastHealthInfo);
        Binder.withCleanCallingIdentity(new BatteryService$$ExternalSyntheticLambda8(this, forceUpdate, pw));
    L6:
        if (this.mBatteryInputSuspended == false) goto L9;
        PowerProperties.battery_input_suspended(false);
        this.mBatteryInputSuspended = false;
        return;
    }

    private /* synthetic */ void lambda$resetBattery$7(boolean forceUpdate, PrintWriter pw) throws Exception {
        processValuesLocked(forceUpdate, pw);
    }

    private void suspendBatteryInput() {
        if (Build.IS_DEBUGGABLE == false) goto L7;
        PowerProperties.battery_input_suspended(true);
        this.mBatteryInputSuspended = true;
        return;
    L7:
        throw new SecurityException("battery suspend_input is only supported on debuggable builds");
    }

    private void processValuesLocked(boolean forceUpdate, PrintWriter pw) {
        processValuesLocked(forceUpdate);
        if (pw == null) goto L7;
        if (forceUpdate == false) goto L8;
        pw.println(this.mSequence);
        return;
    L8:
        return;
    }

    protected void dumpInternal(FileDescriptor fd, PrintWriter pw, String[] args) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        if (args == null) goto L18;
    L15:
        th = move-exception;
        Throwable r11 = th;
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L13
        throw r11;
    L6:
        if (args.length == 0) goto L18;
        if ("-a".equals(args[0]) == true) goto L18;
        Shell shell = new Shell(this);     // Catch: Throwable -> L15
        shell.exec(this.mBinderService, null, fd, null, args, null, new ResultReceiver(null));     // Catch: Throwable -> L13
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L18:
        pw.println("Current Battery Service state:");     // Catch: Throwable -> L13
        if (this.mUpdatesStopped == false) goto L21;
        pw.println("  (UPDATES STOPPED -- use 'reset' to restart)");     // Catch: Throwable -> L13
    L21:
        pw.println("  AC powered: " + this.mHealthInfo.chargerAcOnline);     // Catch: Throwable -> L13
        pw.println("  USB powered: " + this.mHealthInfo.chargerUsbOnline);     // Catch: Throwable -> L13
        pw.println("  Wireless powered: " + this.mHealthInfo.chargerWirelessOnline);     // Catch: Throwable -> L13
        pw.println("  Dock powered: " + this.mHealthInfo.chargerDockOnline);     // Catch: Throwable -> L13
        pw.println("  Max charging current: " + this.mHealthInfo.maxChargingCurrentMicroamps);     // Catch: Throwable -> L13
        pw.println(" Time when the latest updated value of the Max charging current was sent via battery changed broadcast: " + TimeUtils.formatDuration(this.mLastBroadcastMaxChargingCurrentUpdateTime));     // Catch: Throwable -> L13
        pw.println("  Max charging voltage: " + this.mHealthInfo.maxChargingVoltageMicrovolts);     // Catch: Throwable -> L13
        pw.println("  Charge counter: " + this.mHealthInfo.batteryChargeCounterUah);     // Catch: Throwable -> L13
        pw.println("  status: " + this.mHealthInfo.batteryStatus);     // Catch: Throwable -> L13
        pw.println("  health: " + this.mHealthInfo.batteryHealth);     // Catch: Throwable -> L13
        pw.println("  present: " + this.mHealthInfo.batteryPresent);     // Catch: Throwable -> L13
        pw.println("  level: " + this.mHealthInfo.batteryLevel);     // Catch: Throwable -> L13
        pw.println("  scale: 100");     // Catch: Throwable -> L13
        pw.println("  voltage: " + this.mHealthInfo.batteryVoltageMillivolts);     // Catch: Throwable -> L13
        pw.println(" Time when the latest updated value of the voltage was sent via battery changed broadcast: " + TimeUtils.formatDuration(this.mLastBroadcastVoltageUpdateTime));     // Catch: Throwable -> L13
        pw.println(" The last voltage value sent via the battery changed broadcast: " + this.mLastBroadcastBatteryVoltage);     // Catch: Throwable -> L13
        pw.println("  temperature: " + this.mHealthInfo.batteryTemperatureTenthsCelsius);     // Catch: Throwable -> L13
        pw.println("  technology: " + this.mHealthInfo.batteryTechnology);     // Catch: Throwable -> L13
        pw.println("  Charging state: " + this.mHealthInfo.chargingState);     // Catch: Throwable -> L13
        pw.println("  Charging policy: " + this.mHealthInfo.chargingPolicy);     // Catch: Throwable -> L13
        pw.println("  Capacity level: " + this.mHealthInfo.batteryCapacityLevel);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r11 = th;
        goto L24
    }

    private void dumpProto(FileDescriptor fd) {
        ProtoOutputStream proto = new ProtoOutputStream(fd);
        Object r1 = this.mLock;
        monitor-enter(r1);
        proto.write(1133871366145L, this.mUpdatesStopped);     // Catch: Throwable -> L20
        int batteryPluggedValue = 0;
        if (this.mHealthInfo.chargerAcOnline == false) goto L8;
        batteryPluggedValue = 1;
    L16:
        proto.write(1159641169922L, batteryPluggedValue);     // Catch: Throwable -> L20
        proto.write(1120986464259L, this.mHealthInfo.maxChargingCurrentMicroamps);     // Catch: Throwable -> L20
        proto.write(1120986464260L, this.mHealthInfo.maxChargingVoltageMicrovolts);     // Catch: Throwable -> L20
        proto.write(1120986464261L, this.mHealthInfo.batteryChargeCounterUah);     // Catch: Throwable -> L20
        proto.write(1159641169926L, this.mHealthInfo.batteryStatus);     // Catch: Throwable -> L20
        proto.write(1159641169927L, this.mHealthInfo.batteryHealth);     // Catch: Throwable -> L20
        proto.write(1133871366152L, this.mHealthInfo.batteryPresent);     // Catch: Throwable -> L20
        proto.write(1120986464265L, this.mHealthInfo.batteryLevel);     // Catch: Throwable -> L20
        proto.write(1120986464266L, 100);     // Catch: Throwable -> L20
        proto.write(1120986464267L, this.mHealthInfo.batteryVoltageMillivolts);     // Catch: Throwable -> L20
        proto.write(1120986464268L, this.mHealthInfo.batteryTemperatureTenthsCelsius);     // Catch: Throwable -> L20
        proto.write(1138166333453L, this.mHealthInfo.batteryTechnology);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        proto.flush();
        return;
    L8:
        if (this.mHealthInfo.chargerUsbOnline == false) goto L11;
        batteryPluggedValue = 2;
        goto L16
    L11:
        if (this.mHealthInfo.chargerWirelessOnline == false) goto L14;
        batteryPluggedValue = 4;
        goto L16
    L14:
        if (this.mHealthInfo.chargerDockOnline == false) goto L16;
        batteryPluggedValue = 8;
    L20:
        th = move-exception;
        throw th;
    }

    private static void traceBegin(String name) {
        Trace.traceBegin(524288, name);
    }

    private static void traceEnd() {
        Trace.traceEnd(524288);
    }

    public Handler getHandlerForTest() {
        return this.mHandler;
    }

    private static void sendBroadcastToAllUsers(Context context, Intent intent, Bundle options) {
        context.sendBroadcastAsUser(intent, UserHandle.ALL, null, options);
    }

    public BatteryServiceSmtEx getSmtEx() {
        return this.mSmtEx;
    }

    private void setChargeDockApproach() {
        if ((SystemClock.elapsedRealtime() - this.lastReportTime) <= 500) goto L6;
        this.lastReportTime = SystemClock.elapsedRealtime();
        final Intent intent = new Intent("com.bytedanceos.chargedock_approach");
        this.mHandler.post(new AnonymousClass8(this, intent));
        return;
    }
}
