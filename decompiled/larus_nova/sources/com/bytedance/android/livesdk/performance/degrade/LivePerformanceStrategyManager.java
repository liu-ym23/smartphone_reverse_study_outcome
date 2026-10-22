package com.bytedance.android.livesdk.performance.degrade;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.log.ALoggerConfigHelper;
import com.bytedance.android.live.core.setting.g4;
import com.bytedance.android.live.core.setting.h4;
import com.bytedance.android.live.core.setting.i4;
import com.bytedance.android.live.core.setting.j4;
import com.bytedance.android.live.core.setting.k4;
import com.bytedance.android.live.core.setting.l4;
import com.bytedance.android.live.core.setting.u5;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeManager;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livehostapi.platform.IHostPerformanceHelper;
import com.bytedance.android.livesdk.config.an;
import com.bytedance.android.livesdk.config.c60;
import com.bytedance.android.livesdk.config.di0;
import com.bytedance.android.livesdk.config.gg0;
import com.bytedance.android.livesdk.config.i80;
import com.bytedance.android.livesdk.config.oy;
import com.bytedance.android.livesdk.config.ua;
import com.bytedance.android.livesdk.config.y51;
import com.bytedance.android.livesdk.config.yf0;
import com.bytedance.android.livesdk.performance.LivePerformancePythiaConfig;
import com.bytedance.android.livesdk.performance.aapleasure.AAPleasureNotifyScene;
import com.bytedance.android.livesdk.performance.aapleasure.AAPleasureRegister;
import com.bytedance.android.livesdk.performance.aapleasure.ExperienceScene;
import com.bytedance.android.livesdk.performance.aapleasure.ExperienceSceneLevel;
import com.bytedance.android.livesdk.performance.aapleasure.Level;
import com.bytedance.android.livesdk.performance.aapleasure.o;
import com.bytedance.android.livesdk.performance.config.LivePerformanceStrategyConfig;
import com.bytedance.android.livesdk.performance.event.EventType;
import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdk.performance.s0;
import com.bytedance.android.livesdk.performance.scene.sleep.SleepMode;
import com.bytedance.android.livesdk.performance.u;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.performance.BasePerformanceStrategyTask;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyMonitor;
import com.bytedance.android.livesdkapi.service.IPerfBalanceService;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.bytedance.unitm.api.IThermalStatusManager;
import com.bytedance.unitm.core.UniteThermal;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes11.dex */
public class LivePerformanceStrategyManager implements IPerformanceStrategyManager {
    private static final long DEFAULT_HIGH_SHELL_TEMP_DURATION = 10000;
    private static final long DEFAULT_LOW_BATTERY_DURATION = 15000;
    private static final int DEFAULT_LOW_BATTERY_LEVEL = 30;
    private static final long DEFAULT_PUSH_STREAM_UPDATE_TIME_DURATION = 5000;
    private static final long DEFAULT_RECOVER_DURATION = 60000;
    private static final int DEFAULT_STALL_OVER_COUNT = 2;
    private static final String KEY_SCENE = "scene";
    private static final float MAX_UI_STALL_RATE = 1.0f;
    public static final String PYTHIA_SCENE_LIVE = "live";
    private static final String TAG = "IPerformanceStrategyManager";
    public static String degradeReason = "NONE";
    public static String enhanceReason = "NONE";
    private static boolean hasStallIssue = false;
    private static int hasStallIssueCount = 0;
    public static long mDegradeDuration = -1;
    public static long mEnhanceDuration = -1;
    private long LAST_OUTTER_PERFORMANCE_DURATION;
    private Map<String, String> basePerformanceInfo;
    private com.bytedance.android.livesdk.performance.degrade.c batteryLevelStrategy;
    private int currentPerformanceLevel;
    private boolean enableBatteryStrategy;
    private boolean enableMonitorMerge;
    private boolean enableOutterPerformanceStrategy;
    private boolean enablePythia;
    private boolean enableShellTemperatureStrategy;
    private volatile boolean hasInitConfig;
    private boolean hasJudgeOnce;
    private boolean hasOuterPoorPerformance;
    private boolean hasPythiaTriggerDegrade;
    private boolean hasPythiaTriggerRecover;
    private boolean hasReportMonitorMerge;
    private boolean hasTriggerDegradeEleven;
    private boolean hasTriggerDegradeOne;
    private boolean hasTriggerDegradeTwo;
    private boolean hasTriggerOrigin;
    private boolean hasTryPythia;
    private boolean isAnchor;
    private boolean lev11Res;
    private boolean lev1Res;
    private boolean lev2Res;
    private boolean lev3Res;
    private boolean lev4Res;
    private boolean lev6Res;
    private Disposable localTestDisposable;
    private c mAnchorDegradeStrategy;
    private long mDegradeStartTime;
    private long mEnhanceStartTime;
    private IHostPerformanceHelper mHostPerformanceHelper;
    private long mLastPushStreamUpdateTime;
    private LivePerformancePythiaConfig mLivePerformancePythiaConfig;
    private LivePerformanceStrategyConfig mLivePerformanceStrategyConfig;
    private long mLowBatteryStartTime;
    private Map<Integer, BasePerformanceStrategyTask> mPerforamnceStrategyTaskMap;
    private g mPerformanceDegradeFour;
    private g mPerformanceDegradeOne;
    private g mPerformanceDegradeThree;
    private g mPerformanceDegradeTwo;
    private g mPerformanceEnhanceSeven;
    private g mPerformanceEnhanceSix;
    private h mPowerDegradeEleven;
    private h mPowerDegradeTwelve;
    private h mPowerEnhanceSixteen;
    private long mPythiaCurrentDegradeTime;
    private long mPythiaCurrentRecoverTime;
    private int mPythiaTempLevel;
    private int mPythiaTempLevelBefore;
    private long mRecoverStartTime;
    private Map<String, String> monitorInfoAction;
    private Map<String, String> monitorInfoNotify;
    private long outerPoorPerformanceStartTime;
    private final IPerformanceStrategyMonitor performanceMonitor;
    private AAPleasureManager pleasureManager;
    private u setting;
    private k shellTemperatureLevelStrategy;

    public class a implements IPerformanceStrategyMonitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LivePerformanceStrategyManager f154520a;

        public a(LivePerformanceStrategyManager r100) {
            this.f154520a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.performance.IPerformanceStrategyMonitor
        public final void updatePerformanceExecuteMonitor(Map<String, String> r100, int r110) {
            if (r110 != 0) goto L5;
            boolean r101 = true;
        L7:
            if (LivePerformanceStrategyManager.access$100(this.f154520a) == false) goto L9;
            LivePerformanceStrategyManager r102 = this.f154520a;
            LivePerformanceStrategyManager.access$300(r102, LivePerformanceStrategyManager.access$200(r102), r100, r110, r101, false);
            return;
        L9:
            HashMap r103 = new HashMap();
            LivePerformanceStrategyManager.access$400(this.f154520a, r103, r110, "action");
            if (r100 == null) goto L12;
            r103.putAll(r100);
        L12:
            if (r101 == true) goto L14;
            r103.put("degrade_reason", LivePerformanceStrategyManager.degradeReason);
        L14:
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_performance_strategy_monitor", r103, new Object[0]);
            return;
        L5:
            r101 = false;
            goto L7
        }

        @Override // com.bytedance.android.livesdkapi.performance.IPerformanceStrategyMonitor
        public final void updatePerformanceNotifyMonitor(Map<String, String> r100, int r110) {
            if (r110 != 0) goto L5;
            boolean r101 = true;
        L7:
            if (LivePerformanceStrategyManager.access$100(this.f154520a) == false) goto L9;
            LivePerformanceStrategyManager r102 = this.f154520a;
            LivePerformanceStrategyManager.access$300(r102, LivePerformanceStrategyManager.access$500(r102), r100, r110, r101, true);
            return;
        L9:
            HashMap r103 = new HashMap();
            LivePerformanceStrategyManager.access$400(this.f154520a, r103, r110, "notify");
            if (r100 == null) goto L12;
            r103.putAll(r100);
        L12:
            if (r101 == true) goto L14;
            r103.put("degrade_reason", LivePerformanceStrategyManager.degradeReason);
        L15:
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_performance_strategy_monitor", r103, new Object[0]);
            return;
        L14:
            r103.put("degrade_duration", String.valueOf(LivePerformanceStrategyManager.mDegradeDuration));
            goto L15
        L5:
            r101 = false;
            goto L7
        }
    }

    public class b implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f154521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BroadcastReceiver f154522b;

        @Override // io.reactivex.functions.Action
        public final void run() throws Exception {
            Context r100 = this.f154521a;
            BroadcastReceiver r101 = this.f154522b;
            ReceiverRegisterLancet.loge(r101, false);
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
            r100.unregisterReceiver(r101);
            return;
        L14:
        L8:
            e = move-exception;
            if (r101 == null) goto L11;
            Npth.addTag("unregisterReceiver", r101.toString());
        L11:
            e.printStackTrace();
            return;
        L5:
            if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
            r100.unregisterReceiver(r101);     // Catch: Exception -> L8
            return;
        }

        public b(Context r100, d r101) {
            this.f154521a = r100;
            this.f154522b = r101;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f154523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f154524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f154525c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f154526d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public double f154527e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f154528f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f154529g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final u.a f154530h;

        public c(u.a r100) {
            this.f154523a = 0;
            this.f154524b = -1;
            this.f154525c = 0;
            this.f154526d = -1;
            this.f154527e = -1.0d;
            this.f154528f = false;
            this.f154529g = false;
            this.f154530h = null;
            this.f154530h = r100;
        }

        public final boolean a(double r110) {
            ALogger.d(LivePerformanceStrategyManager.TAG, "当前性能数据： previewFps = " + r110);
            if (this.f154527e >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
            this.f154527e = r110;
            this.f154528f = false;
            return false;
        L6:
            u.a r100 = this.f154530h;
            long r101 = 60000;
            float r102 = 1.0f;
            if (r100 == null) goto L10;
            r101 = Math.max(r100.previewFpsDuration, 60000);
            r102 = Math.max(this.f154530h.previewFpsDeviation, 1.0f);
        L10:
            if (this.f154526d <= 0) goto L16;
            if ((System.currentTimeMillis() - this.f154526d) <= r101) goto L16;
            this.f154526d = -1;
            this.f154527e = r110;
            this.f154528f = false;
            return this.f154529g;
        L16:
            if (Math.abs(r110 - this.f154527e) <= r102) goto L23;
            if (this.f154526d <= 0) goto L21;
            this.f154523a = 2;
            this.f154528f = true;
            return true;
        L21:
            this.f154526d = System.currentTimeMillis();
        L23:
            return this.f154529g;
        }

        public final boolean b(float r100, double r101) {
            ALogger.d(LivePerformanceStrategyManager.TAG, "当前性能数据： temperature = " + r100 + " ; seriousStallRate = " + r101);
            if (r101 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        L14:
            this.f154525c = 0;
            this.f154529g = false;
            if (this.f154528f == false) goto L17;
            return true;
        L17:
            u.a r102 = this.f154530h;
            long r103 = 60000;
            float r104 = 38.0f;
            if (r102 == null) goto L21;
            r104 = Math.max(r102.temperatureAnchor, 38.0f);
            r103 = Math.max(this.f154530h.temperatureDuration, 60000);
        L21:
            if (r100 > r104) goto L23;
        L26:
            this.f154524b = -1;
            return false;
        L23:
            if ((System.currentTimeMillis() - this.f154524b) < r103) goto L26;
            this.f154523a = 1;
            return true;
        L5:
            if (r101 >= 1.0d) goto L14;
            this.f154525c++;
            u.a r105 = this.f154530h;
            if (r105 == null) goto L9;
            int r106 = Math.max(r105.uiStallSeriousCount, 2);
        L11:
            if (this.f154525c < r106) goto L14;
            this.f154523a = 2;
            this.f154525c = 0;
            this.f154529g = true;
            return true;
        L9:
            r106 = 2;
            goto L11
        }
    }

    public class d extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LivePerformanceStrategyManager f154531a;

        public d(LivePerformanceStrategyManager r100) {
            this.f154531a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            if (r101 != null) goto L4;
            return;
        L4:
            if (r101.hasExtra("level") == false) goto L11;
            int r102 = r101.getIntExtra("level", 0);
            if (r102 <= 0) goto L8;
            ALogger.e(LivePerformanceStrategyManager.TAG, "强制触发降级 Level：" + r102);
            LivePerformanceStrategyManager.access$700(this.f154531a, r102);
            return;
        L8:
            ALogger.e(LivePerformanceStrategyManager.TAG, "强制触发还原");
            LivePerformanceStrategyManager.access$800(this.f154531a);
            return;
        }
    }

    public static /* synthetic */ Integer b(LivePerformanceStrategyManager r100, Integer r101) {
        return r100.lambda$onPerformanceDataReady$1(r101);
    }

    public static /* synthetic */ Integer c(LivePerformanceStrategyManager r100, Integer r101) {
        return r100.lambda$onPerformanceDataReady$0(r101);
    }

    private void reset() {
        this.hasTriggerOrigin = true;
        this.hasTriggerDegradeOne = false;
        this.hasTriggerDegradeTwo = false;
        this.hasTriggerDegradeEleven = false;
        this.currentPerformanceLevel = 0;
        c r100 = this.mAnchorDegradeStrategy;
        if (r100 == null) goto L5;
        r100.f154523a = 0;
        r100.f154524b = -1;
        r100.f154525c = 0;
        r100.f154526d = -1;
        r100.f154527e = -1.0d;
    L5:
        g r101 = this.mPerformanceDegradeOne;
        if (r101 == null) goto L8;
        r101.c();
    L8:
        g r102 = this.mPerformanceDegradeTwo;
        if (r102 == null) goto L12;
        r102.c();
        return;
    }

    public void onEnterPlay() {
        boolean r100 = false;
        hasStallIssueCount = 0;
        if (SleepMode.f154768a == false) goto L14;
        com.bytedance.android.livesdk.performance.scene.sleep.b r101 = SleepMode.f154771d;
        IStrategyService r102 = (IStrategyService) jc1.k.f(IStrategyService.class);
        if (r102 == null) goto L12;
        LiveData r103 = IStrategyService.a.a(r102, "avoid_live_sleep_core_scene", Boolean.FALSE, false, 12);
        if (r103 == null) goto L12;
        Boolean r104 = (Boolean) r103.getValue();
        if (r104 == null) goto L12;
        r100 = r104.booleanValue();
    L12:
        r101.f154799n = r100;
        return;
    }

    private boolean checkBalanceSwitch() {
        if (g4.f65306a.getValue().booleanValue() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.isAnchor == true) goto L7;
    L8:
        return true;
    L7:
        if (c60.f119925a.getValue().getBalanceAnchorSupport() == false) goto L9;
        goto L8
    }

    private boolean checkBalanceSwitchV2() {
        return k4.f65340a.getValue().booleanValue();
    }

    private void checkDegrade() {
        int r100 = this.mPythiaTempLevel;
        if (r100 == this.mPythiaTempLevelBefore) goto L9;
        this.mPythiaTempLevelBefore = r100;
        if (r100 == 0) goto L7;
        this.mPythiaCurrentDegradeTime = System.currentTimeMillis();
        this.mPythiaCurrentRecoverTime = 0;
        return;
    L7:
        this.mPythiaCurrentDegradeTime = 0;
        this.mPythiaCurrentRecoverTime = System.currentTimeMillis();
        return;
    L9:
        if (r100 == 0) goto L18;
        if (this.mPythiaCurrentDegradeTime > 0) goto L13;
        return;
    L13:
        if ((System.currentTimeMillis() - this.mPythiaCurrentDegradeTime) >= this.mLivePerformancePythiaConfig.mJudgeDuration) goto L15;
        return;
    L15:
        if (this.hasPythiaTriggerDegrade == true) goto L29;
        triggerDegrade(this.mPythiaTempLevel);
        this.hasPythiaTriggerDegrade = true;
        this.hasPythiaTriggerRecover = false;
        this.mPythiaCurrentRecoverTime = 0;
        return;
    L29:
        return;
    L18:
        if (this.mPythiaCurrentDegradeTime > 0) goto L20;
        return;
    L20:
        if ((System.currentTimeMillis() - this.mPythiaCurrentRecoverTime) >= this.mLivePerformancePythiaConfig.mRecoverDuration) goto L22;
        return;
    L22:
        if (this.hasPythiaTriggerRecover == true) goto L33;
        triggerOrigin();
        this.hasPythiaTriggerDegrade = false;
        this.hasPythiaTriggerRecover = true;
        this.mPythiaCurrentDegradeTime = 0;
        return;
    }

    private boolean checkPythiaSettings() {
        if (this.hasTryPythia == true) goto L6;
        LivePerformancePythiaConfig r100 = yf0.f121682a.getValue();
        this.mLivePerformancePythiaConfig = r100;
        this.enablePythia = r100.mEnable;
        this.hasTryPythia = true;
    L6:
        return this.enablePythia;
    }

    private boolean enable() {
        if (this.mLivePerformanceStrategyConfig.getEnable() == true) goto L5;
    L7:
        return false;
    L5:
        if (hasStallIssue == true) goto L7;
        return true;
    }

    private void getCommonSettings() {
        this.enableMonitorMerge = i80.f120430a.getValue().booleanValue();
        this.basePerformanceInfo.put("device_score", String.valueOf(z0.b(this.isAnchor)));
        this.basePerformanceInfo.put(IPerformanceStrategyManager.KEY_INT_DEVICE_LEVEL, String.valueOf(z0.a()));
    }

    private int judgeEnterRoomHasTriggerDegrade() {
        if (this.enableOutterPerformanceStrategy == true) goto L11;
    L10:
        return 0;
    L11:
        int r100 = ((Integer) ((IFeatureService) jc1.k.f(IFeatureService.class)).getFeatureManager().getFeature("live_resource_experience_mode_level", 0)).intValue();     // Catch: Exception -> L8
        if (r100 >= 0) goto L10;
        this.hasOuterPoorPerformance = true;     // Catch: Exception -> L8
        this.outerPoorPerformanceStartTime = System.currentTimeMillis();     // Catch: Exception -> L8
        return r100;
    L8:
        e = move-exception;
        ALogger.i(TAG, "onEnterRoom:" + e.getMessage());
        goto L10
    }

    private boolean judgeRecover() {
        if (this.mRecoverStartTime > 0) goto L5;
    L7:
        return false;
    L5:
        if ((System.currentTimeMillis() - this.mRecoverStartTime) < recoverDuration()) goto L7;
        return true;
    }

    private long recoverDuration() {
        boolean r100 = this.isAnchor;
        if (r100 == true) goto L7;
        LivePerformanceStrategyConfig r101 = this.mLivePerformanceStrategyConfig;
        if (r101 == null) goto L7;
        long r102 = r101.mRecoverDuration;
    L15:
        if (r102 > 0) goto L17;
        return 60000;
    L17:
        return r102;
    L7:
        if (r100 == false) goto L13;
        u r103 = this.setting;
        if (r103 == null) goto L13;
        u.a r104 = r103.anchorDegradeSetting;
        if (r104 == null) goto L13;
        r102 = r104.anchorRecoverDuration;
    L13:
        r102 = 60000;
        goto L15
    }

    private void resetPerformanceStrategy() {
        this.mPerformanceDegradeFour.c();
        this.mPerformanceDegradeThree.c();
        this.mPerformanceDegradeTwo.c();
        this.mPerformanceDegradeOne.c();
        this.mPerformanceEnhanceSix.c();
    }

    private void triggerMonitor() {
        if (this.hasReportMonitorMerge == true) goto L16;
        Map<String, String> r100 = this.monitorInfoNotify;
        if (r100 != null) goto L7;
    L9:
        Map<String, String> r101 = this.monitorInfoAction;
        if (r101 != null) goto L12;
    L14:
        this.hasReportMonitorMerge = true;
        return;
    L12:
        if (r101.size() <= 0) goto L14;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_performance_strategy_monitor", this.monitorInfoAction, new Object[0]);
        this.monitorInfoAction = new HashMap();
        goto L14
    L7:
        if (r100.size() <= 0) goto L9;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_performance_strategy_monitor", this.monitorInfoNotify, new Object[0]);
        this.monitorInfoNotify = new HashMap();
        goto L9
    }

    private void triggerOrigin() {
        ALogger.d(TAG, "恢复常态功能");
        reset();
        this.hasJudgeOnce = true;
        long r100 = System.currentTimeMillis();
        long r101 = this.mDegradeStartTime;
        if (r100 > r101) goto L5;
    L7:
        IHostPerformanceHelper r102 = this.mHostPerformanceHelper;
        if (r102 == null) goto L13;
        if (tb1.c.f545229a == false) goto L13;
        r102.onLiveDegrade(0);
    L13:
        if (this.pleasureManager == null) goto L18;
        if (checkBalanceSwitch() == false) goto L18;
        this.pleasureManager.i(0);
    L18:
        if (tb1.c.f545235g == false) goto L42;
        if (s0.f154760a == false) goto L42;
        s0.f154760a = false;     // Catch: NullPointerException -> L40
        if (s0.f154763d.booleanValue() == false) goto L25;
        s0.f154762c.setDisableVoiceBalanceOpt(false);     // Catch: NullPointerException -> L40
    L25:
        if (s0.f154764e == false) goto L30;
        if (s0.f154767h == false) goto L30;
        ALoggerConfigHelper.f64881a = false;     // Catch: NullPointerException -> L40
    L30:
        if (s0.f154765f == false) goto L35;
        if (s0.f154767h == false) goto L35;
        int r103 = com.bytedance.android.livesdk.behavior.b.f104288a;     // Catch: NullPointerException -> L40
    L35:
        if (s0.f154766g == false) goto L42;
        if (s0.f154767h == false) goto L42;
        y51.f121657a = false;     // Catch: NullPointerException -> L40
    L42:
        if (this.hasReportMonitorMerge == true) goto L55;
        Map<String, String> r104 = this.monitorInfoNotify;
        if (r104 != null) goto L46;
    L48:
        Map<String, String> r105 = this.monitorInfoAction;
        if (r105 != null) goto L51;
    L53:
        this.hasReportMonitorMerge = true;
        goto L55
    L51:
        if (r105.size() <= 0) goto L53;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_performance_strategy_monitor", this.monitorInfoAction, new Object[0]);
        this.monitorInfoAction = new HashMap();
        goto L53
    L46:
        if (r104.size() <= 0) goto L48;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_performance_strategy_monitor", this.monitorInfoNotify, new Object[0]);
        this.monitorInfoNotify = new HashMap();
    L55:
        if (l4.f65350a.getValue().booleanValue() == false) goto L57;
        return;
    L57:
        Iterator<Integer> r106 = this.mPerforamnceStrategyTaskMap.keySet().iterator();
    L59:
        if (r106.hasNext() == false) goto L67;
        Integer r107 = r106.next();
        BasePerformanceStrategyTask r108 = this.mPerforamnceStrategyTaskMap.get(r107);     // Catch: Exception -> L65
        if (r108 == null) goto L59;
        r108.onTriggerOrigin(this.basePerformanceInfo, this.performanceMonitor);     // Catch: Exception -> L65
    L65:
        e = move-exception;
        ALogger.e(TAG, "恢复功能时发生异常：type = " + r107 + "; message = " + e.getMessage());
        e.printStackTrace();
        goto L59
    L67:
        return;
    L5:
        if (r101 <= 0) goto L7;
        mDegradeDuration = (r100 - r101) / 1000;
        this.mDegradeStartTime = -1;
        goto L7
    }

    public boolean hasTriggerPerformanceDegrade() {
        int r100 = this.currentPerformanceLevel;
        if (r100 >= 1) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 5) goto L7;
        return true;
    }

    public boolean hasTriggerPerformanceEnhance() {
        int r100 = this.currentPerformanceLevel;
        if (r100 >= 6) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 10) goto L7;
        return true;
    }

    public boolean hasTriggerPowerDegrade() {
        int r100 = this.currentPerformanceLevel;
        if (r100 >= 11) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 15) goto L7;
        return true;
    }

    public boolean hasTriggerPowerEnhance() {
        int r100 = this.currentPerformanceLevel;
        if (r100 >= 16) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 20) goto L7;
        return true;
    }

    public void init() {
        jc1.k.l(IPerformanceStrategyManager.class, this);
        registerLocalTestBr();
        AAPleasureManager r100 = new AAPleasureManager();
        this.pleasureManager = r100;
        jc1.k.l(IPerfBalanceService.class, r100);
        TopSpeedModeManager r101 = TopSpeedModeManager.f99061l;
        TopSpeedModeManager.f99061l.c();
    }

    public boolean judgeLowBattery() {
        if (this.mLowBatteryStartTime > 0) goto L5;
    L7:
        return false;
    L5:
        if ((System.currentTimeMillis() - this.mLowBatteryStartTime) < 15000) goto L7;
        return true;
    }

    public void onEnterRoom() {
        if (this.pleasureManager != null) goto L5;
        return;
    L5:
        if (checkBalanceSwitch() == false) goto L23;
        int r100 = judgeEnterRoomHasTriggerDegrade();
        AAPleasureManager r101 = this.pleasureManager;
        if (((Boolean) r101.f154492l.getValue()).booleanValue() == false) goto L10;
        r101.f154500t = false;
    L10:
        if (r101.f154496p == true) goto L12;
        r101.f154483c.getClass();
        r101.f154496p = true;
    L12:
        boolean r102 = com.bytedance.android.livesdk.performance.aapleasure.d.f154428b;
        com.bytedance.android.livesdk.performance.aapleasure.d.f154427a = System.currentTimeMillis();
        if (gg0.f120286a.getValue().booleanValue() == false) goto L15;
        AAPleasureRegister.c();
    L15:
        if (r100 < 0) goto L17;
        return;
    L17:
        if (r100 != (-1)) goto L19;
        Level r103 = Level.Serious;
    L20:
        Function2<? super Integer, ? super String, Unit> r104 = com.bytedance.android.livesdk.performance.aapleasure.c.f154426a;
        com.bytedance.android.livesdk.performance.aapleasure.c.a(r103, AAPleasureNotifyScene.ENTER);
        return;
    L19:
        r103 = Level.Critical;
        goto L20
    }

    public void onLeaveRoom() {
        if (this.pleasureManager == null) goto L13;
        if (checkBalanceSwitch() == false) goto L13;
        this.pleasureManager.getClass();
        com.bytedance.android.livesdk.performance.aapleasure.d.f154427a = 0;
        com.bytedance.android.livesdk.performance.aapleasure.a.f154415b = null;
        if (gg0.f120286a.getValue().booleanValue() == false) goto L9;
        AAPleasureRegister.f154408a.clear();
    L9:
        IInteractService r100 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r100 == null) goto L13;
        r100.resetMultiLinkPerfAbilityManager();
    L13:
        if (checkPythiaSettings() == false) goto L16;
        ALogger.i(TAG, "onLeaveRoom");
        this.mPythiaTempLevel = 0;
        this.mPythiaTempLevelBefore = 0;
        this.mPythiaCurrentRecoverTime = -1;
        this.mPythiaCurrentDegradeTime = -1;
        this.hasPythiaTriggerDegrade = false;
        this.hasPythiaTriggerRecover = false;
        return;
    }

    public void release() {
        if (this.hasReportMonitorMerge == true) goto L14;
        Map<String, String> r100 = this.monitorInfoNotify;
        if (r100 != null) goto L7;
    L9:
        Map<String, String> r101 = this.monitorInfoAction;
        if (r101 == null) goto L14;
        if (r101.size() <= 0) goto L14;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_performance_strategy_monitor", this.monitorInfoAction, new Object[0]);
        goto L14
    L7:
        if (r100.size() <= 0) goto L9;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_performance_strategy_monitor", this.monitorInfoNotify, new Object[0]);
    L14:
        this.monitorInfoNotify = new HashMap();
        this.monitorInfoAction = new HashMap();
        this.basePerformanceInfo = new HashMap();
        this.hasReportMonitorMerge = true;
        mDegradeDuration = -1;
        reset();
        unregisterAll();
        this.hasInitConfig = false;
        this.hasJudgeOnce = false;
        this.mHostPerformanceHelper = null;
        if (this.pleasureManager != null) goto L17;
        return;
    L17:
        if (checkBalanceSwitch() == false) goto L23;
        AAPleasureManager r102 = this.pleasureManager;
        r102.getClass();
        if (m87.b.f512469a == null) goto L24;
        m87.c r103 = m87.b.f512469a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "observer");
        r103.f512473d.remove(r102);
        return;
    L24:
        return;
    }

    public void unregisterAll() {
        this.mPerforamnceStrategyTaskMap.clear();
    }

    public LivePerformanceStrategyManager() {
        this.mLivePerformancePythiaConfig = null;
        this.mLivePerformanceStrategyConfig = null;
        this.setting = null;
        this.hasTriggerOrigin = true;
        this.hasTriggerDegradeOne = false;
        this.hasTriggerDegradeTwo = false;
        this.hasTriggerDegradeEleven = false;
        this.enableBatteryStrategy = h4.f65315a.getValue().booleanValue();
        this.enableShellTemperatureStrategy = j4.f65332a.getValue().booleanValue();
        this.enableOutterPerformanceStrategy = i4.f65324a.getValue().booleanValue();
        this.currentPerformanceLevel = 0;
        this.enableMonitorMerge = false;
        this.hasReportMonitorMerge = false;
        this.monitorInfoAction = new HashMap();
        this.monitorInfoNotify = new HashMap();
        this.basePerformanceInfo = new HashMap();
        this.mRecoverStartTime = -1;
        this.mLowBatteryStartTime = -1;
        this.mDegradeStartTime = -1;
        this.mEnhanceStartTime = -1;
        this.hasInitConfig = false;
        this.lev11Res = false;
        this.lev4Res = false;
        this.lev3Res = false;
        this.lev2Res = false;
        this.lev1Res = false;
        this.lev6Res = false;
        this.isAnchor = false;
        this.mLastPushStreamUpdateTime = -1;
        this.hasJudgeOnce = false;
        this.localTestDisposable = null;
        this.mHostPerformanceHelper = null;
        this.mPerforamnceStrategyTaskMap = new ConcurrentHashMap();
        this.pleasureManager = null;
        this.performanceMonitor = new a(this);
        this.hasTryPythia = false;
        this.enablePythia = false;
        this.mPythiaTempLevel = 0;
        this.mPythiaTempLevelBefore = 0;
        this.mPythiaCurrentRecoverTime = -1;
        this.mPythiaCurrentDegradeTime = -1;
        this.hasPythiaTriggerDegrade = false;
        this.hasPythiaTriggerRecover = false;
        this.hasOuterPoorPerformance = false;
        this.outerPoorPerformanceStartTime = 0;
        this.LAST_OUTTER_PERFORMANCE_DURATION = 60000;
        init();
    }

    private boolean enableLocalTest() {
        if (v.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (LiveDegradeConfigHelper.a().enableLocalDebug == false) goto L7;
        return true;
    }

    private boolean enableLocalTestPerformance() {
        if (v.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (LiveDegradeConfigHelper.a().enableLocalPerformanceDebug == false) goto L7;
        return true;
    }

    private void registerLocalTestBr() {
        if (enableLocalTest() == false) goto L10;
        Context r100 = df6.g.getContext();
        if (r100 != null) goto L7;
        return;
    L7:
        if (this.localTestDisposable != null) goto L12;
        ALogger.d(TAG, "注册本地性能测试广播");
        d r101 = new d(this);
        INVOKEVIRTUAL_com_bytedance_android_livesdk_performance_degrade_LivePerformanceStrategyManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, r101, new IntentFilter("android.intent.action.LIVE_EXP_DEGRADE_TEST"));
        this.localTestDisposable = Disposables.fromAction(new b(r100, r101));
        return;
    L12:
        return;
    }

    private void unregisterLocalTestBr() {
        if (enableLocalTest() == false) goto L9;
        Disposable r100 = this.localTestDisposable;
        if (r100 == null) goto L7;
        ALogger.d(TAG, "移除本地性能测试广播");
        r100.dispose();
    L7:
        this.localTestDisposable = null;
        return;
    }

    @Override // com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager
    public boolean enableRevOpt() {
        return LiveDegradeConfigHelper.a().enableRevenueOpt;
    }

    @Override // com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager
    public int getCurrentPerformanceLevel() {
        return this.currentPerformanceLevel;
    }

    public AAPleasureManager getPleasureManager() {
        return this.pleasureManager;
    }

    public static /* synthetic */ boolean access$100(LivePerformanceStrategyManager r100) {
        return r100.enableMonitorMerge;
    }

    public static /* synthetic */ Map access$200(LivePerformanceStrategyManager r100) {
        return r100.monitorInfoAction;
    }

    public static /* synthetic */ Map access$500(LivePerformanceStrategyManager r100) {
        return r100.monitorInfoNotify;
    }

    public static /* synthetic */ void access$800(LivePerformanceStrategyManager r100) {
        r100.triggerOrigin();
    }

    private void initConfig(boolean r100) {
        if (r100 == true) goto L56;
        LivePerformanceStrategyConfig r101 = this.mLivePerformanceStrategyConfig;
        if (r101 == null) goto L50;
        boolean r102 = r101.mLintEnable;
        Iterator<LivePerformanceStrategyConfig.a> r103 = r101.mPerformanceDegradeList.iterator();
    L8:
        if (r103.hasNext() == false) goto L22;
        LivePerformanceStrategyConfig.a r104 = r103.next();
        int r105 = r104.mPerformanceLevel;
        if (r105 != 1) goto L12;
        this.mPerformanceDegradeOne = new g(1, r104, r102, true);
        goto L8
    L12:
        if (r105 != 2) goto L14;
        this.mPerformanceDegradeTwo = new g(2, r104, r102, true);
        goto L8
    L14:
        if (r105 != 3) goto L16;
        this.mPerformanceDegradeThree = new g(3, r104, r102, true);
        goto L8
    L16:
        if (r105 != 4) goto L8;
        this.mPerformanceDegradeFour = new g(4, r104, r102, true);
        goto L8
    L22:
        Iterator<LivePerformanceStrategyConfig.a> r106 = this.mLivePerformanceStrategyConfig.mPerformanceEnhanceList.iterator();
    L24:
        if (r106.hasNext() == false) goto L32;
        LivePerformanceStrategyConfig.a r107 = r106.next();
        int r108 = r107.mPerformanceLevel;
        if (r108 != 6) goto L28;
        this.mPerformanceEnhanceSix = new g(6, r107, r102, false);
        goto L24
    L28:
        if (r108 != 7) goto L24;
        this.mPerformanceEnhanceSeven = new g(7, r107, r102, false);
        goto L24
    L32:
        Iterator<LivePerformanceStrategyConfig.b> r109 = this.mLivePerformanceStrategyConfig.mPowerDegradeList.iterator();
    L34:
        if (r109.hasNext() == false) goto L42;
        LivePerformanceStrategyConfig.b r110 = r109.next();
        int r111 = r110.mPerformanceLevel;
        if (r111 != 11) goto L38;
        this.mPowerDegradeEleven = new h(r110, r102, true);
        goto L34
    L38:
        if (r111 != 12) goto L34;
        this.mPowerDegradeTwelve = new h(r110, r102, true);
        goto L34
    L42:
        Iterator<LivePerformanceStrategyConfig.b> r112 = this.mLivePerformanceStrategyConfig.mPowerEnhanceList.iterator();
    L44:
        if (r112.hasNext() == false) goto L50;
        LivePerformanceStrategyConfig.b r113 = r112.next();
        if (r113.mPerformanceLevel != 16) goto L44;
        this.mPowerEnhanceSixteen = new h(r113, r102, false);
    L50:
        if (this.enableShellTemperatureStrategy == false) goto L53;
        this.shellTemperatureLevelStrategy = new k();
    L53:
        if (this.enableBatteryStrategy == false) goto L55;
        this.batteryLevelStrategy = new com.bytedance.android.livesdk.performance.degrade.c();
    L55:
        getCommonSettings();
        this.hasInitConfig = true;
    L56:
        if (r100 == false) goto L103;
        this.setting = an.f119805a.getValue();
        if (this.mAnchorDegradeStrategy == null) goto L60;
    L66:
        this.hasInitConfig = true;
        return;
    L60:
        if (ua.f121355a.getValue().booleanValue() == true) goto L66;
        this.mAnchorDegradeStrategy = new c(this.setting.anchorDegradeSetting);
        getCommonSettings();
        c r114 = this.mAnchorDegradeStrategy;
        if (r114 == null) goto L66;
        u.a r115 = r114.f154530h;
        if (r115 == null) goto L66;
        this.basePerformanceInfo.put(IPerformanceStrategyManager.KEY_LONG_ANCHOR_TEMPERATURE_LAST_DURATION, String.valueOf(r115.temperatureDuration));
        goto L66
    }

    private void judgeAnchorDegrade(boolean r100) {
        if (r100 == false) goto L17;
        int r101 = this.mAnchorDegradeStrategy.f154523a;
        this.currentPerformanceLevel = r101;
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L10;
    L15:
        this.mRecoverStartTime = -1;
        this.hasTriggerOrigin = false;
        return;
    L10:
        if (this.hasTriggerDegradeTwo == true) goto L15;
        triggerDegrade(2);
        this.hasTriggerDegradeTwo = true;
        this.hasTriggerDegradeOne = false;
        goto L15
    L13:
        if (this.hasTriggerDegradeOne == true) goto L15;
        triggerDegrade(1);
        this.hasTriggerDegradeTwo = false;
        this.hasTriggerDegradeOne = true;
        goto L15
    L17:
        if (this.hasTriggerOrigin == false) goto L20;
        return;
    L20:
        if (this.mRecoverStartTime >= 0) goto L23;
        this.mRecoverStartTime = System.currentTimeMillis();
        return;
    L23:
        if ((System.currentTimeMillis() - this.mRecoverStartTime) > recoverDuration()) goto L25;
        return;
    L25:
        if (this.hasTriggerOrigin == true) goto L31;
        triggerOrigin();
        this.hasTriggerOrigin = true;
        return;
    }

    private void judgeEnhanceStrategy(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 6;
    L6:
        if (r101 != this.currentPerformanceLevel) goto L8;
        this.mRecoverStartTime = -1;
        return;
    L8:
        if (r101 == 0) goto L11;
        this.mRecoverStartTime = -1;
        triggerEnhance(r101);
        resetPerformanceStrategy();
        return;
    L11:
        if (this.mRecoverStartTime >= 0) goto L14;
        this.mRecoverStartTime = System.currentTimeMillis();
    L14:
        if (judgeRecover() == false) goto L19;
        triggerOrigin();
        return;
    L19:
        return;
    L4:
        r101 = 0;
        goto L6
    }

    private void judgeLowPowerStrategy(boolean r100) {
        if (r100 == true) goto L5;
        this.mLowBatteryStartTime = -1;
        if (this.mRecoverStartTime >= 0) goto L17;
        this.mRecoverStartTime = System.currentTimeMillis();
    L17:
        if (this.hasTriggerOrigin == false) goto L19;
        return;
    L19:
        if (judgeRecover() == false) goto L26;
        triggerOrigin();
        return;
    L26:
        return;
    L5:
        if (this.hasTriggerDegradeEleven == false) goto L8;
        this.mRecoverStartTime = -1;
        return;
    L8:
        if (this.mLowBatteryStartTime >= 0) goto L11;
        this.mLowBatteryStartTime = System.currentTimeMillis();
    L11:
        if (judgeLowBattery() == false) goto L23;
        degradeReason = "low_battery";
        triggerDegrade(11);
        this.hasTriggerDegradeEleven = true;
        this.mRecoverStartTime = -1;
        return;
    }

    private /* synthetic */ Integer lambda$onPerformanceDataReady$0(Integer r100) {
        if (this.pleasureManager == null) goto L8;
        if (checkBalanceSwitch() == false) goto L8;
        this.pleasureManager.i(r100.intValue());
    L8:
        return 0;
    }

    private /* synthetic */ Integer lambda$onPerformanceDataReady$1(Integer r100) {
        if (this.pleasureManager == null) goto L8;
        if (checkBalanceSwitch() == false) goto L8;
        this.pleasureManager.i(r100.intValue());
    L8:
        return 0;
    }

    private void triggerDegrade(int r100) {
        ALogger.d(TAG, "触发性能降级：level = " + r100);
        this.hasTriggerOrigin = false;
        this.hasJudgeOnce = true;
        this.currentPerformanceLevel = r100;
        if (this.mDegradeStartTime >= 0) goto L5;
        this.mDegradeStartTime = System.currentTimeMillis();
        mDegradeDuration = -1;
    L5:
        IHostPerformanceHelper r101 = this.mHostPerformanceHelper;
        if (r101 == null) goto L11;
        if (tb1.c.f545229a == false) goto L11;
        r101.onLiveDegrade(this.currentPerformanceLevel);
    L11:
        if (this.pleasureManager == null) goto L16;
        if (checkBalanceSwitch() == false) goto L16;
        this.pleasureManager.i(r100);
    L46:
        triggerMonitor();
        if (l4.f65350a.getValue().booleanValue() == false) goto L49;
        return;
    L49:
        Iterator<Integer> r102 = this.mPerforamnceStrategyTaskMap.keySet().iterator();
    L51:
        if (r102.hasNext() == false) goto L70;
        Integer r103 = r102.next();
        BasePerformanceStrategyTask r104 = this.mPerforamnceStrategyTaskMap.get(r103);     // Catch: Exception -> L68
        if (r104 == null) goto L51;
        if (r100 == 1) goto L66;
        if (r100 == 2) goto L66;
        if (r100 == 3) goto L66;
        if (r100 == 4) goto L66;
        if (r100 == 5) goto L66;
        switch(r100) {
            case 11: goto L66;
            case 12: goto L66;
            case 13: goto L66;
            case 14: goto L66;
            case 15: goto L66;
            default: goto L51;
        };     // Catch: Exception -> L68
    L66:
        r104.onTriggerDegrade(r100, this.basePerformanceInfo, this.performanceMonitor);     // Catch: Exception -> L68
    L68:
        e = move-exception;
        ALogger.e(TAG, "触发降级时发生异常：type = " + r103 + "; message = " + e.getMessage());
        e.printStackTrace();
        goto L51
    L70:
        return;
    L16:
        if (tb1.c.f545235g == false) goto L46;
        if (s0.f154760a == true) goto L46;
        if (s0.f154761b != 0) goto L22;
        s0.f154761b = oy.f120940a.getValue().intValue();
    L22:
        int r105 = s0.f154761b;
        if (r105 > 0) goto L25;
    L27:
        boolean r106 = com.bytedance.android.livesdk.performance.event.c.f154591a;
        com.bytedance.android.livesdk.performance.event.c.c(EventType.m.f154589e, null);
        if (s0.f154762c != null) goto L31;
        s0.f154762c = di0.f120035a.getValue();
    L31:
        if (s0.f154763d != null) goto L34;
        s0.f154763d = u5.f65425a.getValue();
    L34:
        if (s0.f154763d.booleanValue() == false) goto L37;
        s0.f154762c.setDisableVoiceBalanceOpt(true);
    L37:
        if (s0.f154764e == false) goto L40;
        ALoggerConfigHelper.f64881a = true;
    L40:
        if (s0.f154765f == false) goto L43;
        int r107 = com.bytedance.android.livesdk.behavior.b.f104288a;
    L43:
        if (s0.f154766g == false) goto L45;
        y51.f121657a = true;
    L45:
        s0.f154760a = true;
        goto L46
    L25:
        if (r105 > 2000) goto L27;
        cu2.b.f465422c.getClass();
        cu2.b.a.a(r105);
        goto L27
    }

    private void triggerEnhance(int r100) {
        ALogger.d(TAG, "触发性能增强：level = " + r100);
        this.hasTriggerOrigin = false;
        this.hasJudgeOnce = true;
        this.currentPerformanceLevel = r100;
        if (this.mEnhanceStartTime >= 0) goto L5;
        this.mEnhanceStartTime = System.currentTimeMillis();
        mEnhanceDuration = -1;
    L5:
        triggerMonitor();
        if (this.pleasureManager != null) goto L8;
        return;
    L8:
        if (checkBalanceSwitch() == false) goto L12;
        this.pleasureManager.i(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager
    public boolean canLoad(int r100) {
        int r101 = f.f154550a;
        int r102 = f.f154550a;
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager
    public boolean canShowAnimation(int r100) {
        int r101 = f.f154550a;
        int r102 = f.f154550a;
        return true;
    }

    public boolean checkAnchorEnable(o0 r100) {
        if (this.setting != null) goto L6;
        this.setting = an.f119805a.getValue();
    L6:
        if (r100.f154693a == true) goto L8;
    L12:
        return false;
    L8:
        if (this.setting.enableAnchor == false) goto L12;
        if (hasStallIssue == true) goto L12;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.bytedance.android.livesdk.performance.degrade.d] */
    /* JADX WARN: Type inference failed for: r13v4, types: [com.bytedance.android.livesdk.performance.degrade.e] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void onPerformanceDataReady(o0 r110) {
    L147:
        e = move-exception;
        ALogger.e(TAG, "判断是否需要降级时发生异常，message = " + e.getMessage());
        e.printStackTrace();
        return;
    L4:
        if (this.hasOuterPoorPerformance == true) goto L6;
    L9:
        if (r110 != null) goto L11;
        return;
    L11:
        if (this.mLivePerformanceStrategyConfig != null) goto L13;
        return;
    L13:
        if (checkPythiaSettings() == false) goto L16;
        return;
    L16:
        if (this.hasInitConfig == true) goto L19;
        boolean r100 = r110.f154693a;     // Catch: Exception -> L147
        this.isAnchor = r100;     // Catch: Exception -> L147
        initConfig(r100);     // Catch: Exception -> L147
    L19:
        if (this.hasInitConfig == false) goto L24;
        if (enable() == true) goto L24;
        return;
    L24:
        if (this.pleasureManager == null) goto L29;
        if (checkBalanceSwitch() == false) goto L29;
        this.pleasureManager.g(r110);     // Catch: Exception -> L147
    L29:
        if (enableLocalTest() == false) goto L32;
        return;
    L32:
        if (enableLocalTestPerformance() == false) goto L40;
        int r101 = LiveDegradeConfigHelper.a().enableLocalPerformanceLevel;     // Catch: Exception -> L147
        if (r101 != 0) goto L36;
        triggerOrigin();     // Catch: Exception -> L147
        return;
    L36:
        if (r101 <= 0) goto L164;
        triggerDegrade(r101);     // Catch: Exception -> L147
        return;
    L164:
        return;
    L40:
        boolean r102 = true;
        if (this.isAnchor == true) goto L136;
        AAPleasureManager r103 = this.pleasureManager;     // Catch: Exception -> L147
        if (r103 == null) goto L48;
        if (r103.d().booleanValue() == false) goto L48;
        r103.f154495o.clear();     // Catch: Exception -> L147
        r103.f154501u = true;     // Catch: Exception -> L147
    L48:
        if (this.enableShellTemperatureStrategy == false) goto L50;
        this.shellTemperatureLevelStrategy.a(r110.O, new com.bytedance.android.livesdk.performance.degrade.d(this));     // Catch: Exception -> L147
    L50:
        int r104 = r110.f154697b0;     // Catch: Exception -> L147
        int r111 = r110.f154712g0;     // Catch: Exception -> L147
        if (r111 != 2) goto L53;
    L58:
        boolean r112 = true;
    L59:
        this.basePerformanceInfo.put("battery_level", String.valueOf(r104));     // Catch: Exception -> L147
        this.basePerformanceInfo.put(IPerformanceStrategyManager.KEY_BOOLEAN_BATTERY_CHARGE, String.valueOf(r112));     // Catch: Exception -> L147
        if (this.enableBatteryStrategy == false) goto L62;
        this.batteryLevelStrategy.a(r104, r112, new e(this));     // Catch: Exception -> L147
    L62:
        IThermalStatusManager r113 = UniteThermal.getInstance(jc1.a.b()).getThermalStatusManager();     // Catch: Exception -> L147
        if (r113 == null) goto L65;
        int r114 = r113.getCurrentThermalStatus();     // Catch: Exception -> L147
    L66:
        double r115 = r110.f154743t0;     // Catch: Exception -> L147
        this.basePerformanceInfo.put(IPerformanceStrategyManager.KEY_DOUBLE_UI_STALL_RATE, String.valueOf(r115));     // Catch: Exception -> L147
        if (r115 <= 1.0d) goto L74;
        int r105 = hasStallIssueCount + 1;     // Catch: Exception -> L147
        hasStallIssueCount = r105;     // Catch: Exception -> L147
        if (r105 <= 2) goto L74;
        hasStallIssue = true;     // Catch: Exception -> L147
        triggerOrigin();     // Catch: Exception -> L147
        AAPleasureManager r106 = this.pleasureManager;     // Catch: Exception -> L147
        if (r106 == null) goto L165;
        r106.b();     // Catch: Exception -> L147
        return;
    L165:
        return;
    L74:
        float r107 = r110.f154735p0;     // Catch: Exception -> L147
        float r108 = r110.N;     // Catch: Exception -> L147
        this.basePerformanceInfo.put("fps", String.valueOf(r107));     // Catch: Exception -> L147
        this.basePerformanceInfo.put(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, String.valueOf(r108));     // Catch: Exception -> L147
        if (this.enableBatteryStrategy == true) goto L86;
        if (hasTriggerPowerDegrade() == false) goto L86;
        if (this.enableBatteryStrategy == false) goto L81;
    L83:
        r102 = false;
    L84:
        this.lev11Res = r102;     // Catch: Exception -> L147
        judgeLowPowerStrategy(r102);     // Catch: Exception -> L147
    L133:
        AAPleasureManager r109 = this.pleasureManager;     // Catch: Exception -> L147
        if (r109 == null) goto L169;
        r109.b();     // Catch: Exception -> L147
        return;
    L169:
        return;
    L81:
        if (this.mPowerDegradeEleven.a(r104, r112) == false) goto L83;
    L86:
        if (hasTriggerPerformanceDegrade() == false) goto L90;
        this.lev4Res = this.mPerformanceDegradeFour.b(r114, r108, r115);     // Catch: NullPointerException -> L153 Exception -> L147
        this.lev3Res = this.mPerformanceDegradeThree.b(r114, r108, r115);     // Catch: NullPointerException -> L153 Exception -> L147
        this.lev2Res = this.mPerformanceDegradeTwo.b(r114, r108, r115);     // Catch: NullPointerException -> L153 Exception -> L147
        this.lev1Res = this.mPerformanceDegradeOne.b(r114, r108, r115);     // Catch: NullPointerException -> L153 Exception -> L147
    L88:
        judgeDegradeStrategy(this.lev4Res, this.lev3Res, this.lev2Res, this.lev1Res);     // Catch: Exception -> L147
        goto L133
    L90:
        if (checkBalanceSwitchV2() == false) goto L96;
        if (hasTriggerPerformanceEnhance() == false) goto L96;
        this.lev6Res = this.mPerformanceEnhanceSix.b(r114, r108, r115);     // Catch: NullPointerException -> L150 Exception -> L147
    L94:
        judgeEnhanceStrategy(this.lev6Res);     // Catch: Exception -> L147
    L96:
        if (this.enableBatteryStrategy == false) goto L98;
    L100:
        boolean r116 = false;
    L101:
        this.lev11Res = r116;     // Catch: Exception -> L147
        if (r116 == false) goto L161;
        judgeLowPowerStrategy(true);     // Catch: Exception -> L147
        goto L133
    L161:
        this.lev4Res = this.mPerformanceDegradeFour.b(r114, r108, r115);     // Catch: NullPointerException -> L151 Exception -> L147
        this.lev3Res = this.mPerformanceDegradeThree.b(r114, r108, r115);     // Catch: NullPointerException -> L151 Exception -> L147
        this.lev2Res = this.mPerformanceDegradeTwo.b(r114, r108, r115);     // Catch: NullPointerException -> L151 Exception -> L147
        this.lev1Res = this.mPerformanceDegradeOne.b(r114, r108, r115);     // Catch: NullPointerException -> L151 Exception -> L147
    L106:
        boolean r117 = this.lev4Res;     // Catch: Exception -> L147
        if (r117 == false) goto L109;
    L132:
        judgeDegradeStrategy(r117, this.lev3Res, this.lev2Res, this.lev1Res);     // Catch: Exception -> L147
        goto L133
    L109:
        if (this.lev3Res == true) goto L132;
        if (this.lev1Res == true) goto L132;
        if (this.lev2Res == true) goto L132;
        if (checkBalanceSwitchV2() == true) goto L118;
    L120:
        r102 = false;
    L121:
        this.lev6Res = r102;     // Catch: NullPointerException -> L152 Exception -> L147
        goto L122
    L118:
        if (this.mPerformanceEnhanceSix.b(r114, r108, r115) == false) goto L120;
    L122:
        boolean r118 = this.lev6Res;     // Catch: Exception -> L147
        if (r118 == false) goto L126;
        judgeEnhanceStrategy(r118);     // Catch: Exception -> L147
        goto L133
    L126:
        if (this.hasTriggerOrigin == false) goto L131;
        AAPleasureManager r119 = this.pleasureManager;     // Catch: Exception -> L147
        if (r119 == null) goto L166;
        r119.b();     // Catch: Exception -> L147
        return;
    L166:
        return;
    L131:
        triggerOrigin();     // Catch: Exception -> L147
        goto L133
    L98:
        if (this.mPowerDegradeEleven.a(r104, r112) == false) goto L100;
        r116 = true;
        goto L101
    L65:
        r114 = -1;
        goto L66
    L53:
        if (r111 == 4) goto L58;
        if (r111 == 5) goto L58;
        r112 = false;
        goto L59
    L136:
        double r120 = r110.f154743t0;     // Catch: Exception -> L147
        this.basePerformanceInfo.put(IPerformanceStrategyManager.KEY_DOUBLE_UI_STALL_RATE, String.valueOf(r120));     // Catch: Exception -> L147
        if (r120 <= 1.0d) goto L142;
        int r121 = hasStallIssueCount + 1;     // Catch: Exception -> L147
        hasStallIssueCount = r121;     // Catch: Exception -> L147
        if (r121 <= 2) goto L142;
        hasStallIssue = true;     // Catch: Exception -> L147
        triggerOrigin();     // Catch: Exception -> L147
        return;
    L142:
        float r122 = r110.C0;     // Catch: Exception -> L147
        float r123 = r110.N;     // Catch: Exception -> L147
        this.basePerformanceInfo.put(IPerformanceStrategyManager.KEY_DOUBLE_UI_STALL_RATE_SERIOUS, String.valueOf(r122));     // Catch: Exception -> L147
        this.basePerformanceInfo.put(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, String.valueOf(r123));     // Catch: Exception -> L147
        c r124 = this.mAnchorDegradeStrategy;     // Catch: Exception -> L147
        if (r124 == null) goto L171;
        judgeAnchorDegrade(r124.b(r123, r122));     // Catch: Exception -> L147
        return;
    L171:
        return;
    L6:
        if ((System.currentTimeMillis() - this.outerPoorPerformanceStartTime) >= this.LAST_OUTTER_PERFORMANCE_DURATION) goto L9;
        ALogger.i(TAG, "onPerformanceDataReady skip error");     // Catch: Exception -> L147
    }

    public void onPushStreamInfoReady(o0 r100) {
        if (r100 == null) goto L23;
    L18:
        e = move-exception;
        ALogger.e(TAG, "判断主播侧是否需要降级时发生异常，message = " + e.getMessage());
        e.printStackTrace();
        return;
    L4:
        if (checkAnchorEnable(r100) == true) goto L6;
        return;
    L6:
        if (checkPythiaSettings() == true) goto L25;
        long r101 = System.currentTimeMillis();     // Catch: Exception -> L18
        if ((r101 - this.mLastPushStreamUpdateTime) >= 5000) goto L11;
        return;
    L11:
        this.mLastPushStreamUpdateTime = r101;     // Catch: Exception -> L18
        if (this.hasInitConfig == true) goto L14;
        boolean r102 = r100.f154693a;     // Catch: Exception -> L18
        this.isAnchor = r102;     // Catch: Exception -> L18
        initConfig(r102);     // Catch: Exception -> L18
    L14:
        double r103 = r100.Q;     // Catch: Exception -> L18
        this.basePerformanceInfo.put(IPerformanceStrategyManager.KEY_DOUBLE_PREVIEW_FPS, String.valueOf(r103));     // Catch: Exception -> L18
        c r104 = this.mAnchorDegradeStrategy;     // Catch: Exception -> L18
        if (r104 == null) goto L26;
        judgeAnchorDegrade(r104.a(r103));     // Catch: Exception -> L18
        return;
    L26:
        return;
    L25:
        return;
    }

    public void setHostPerformanceHelper(IHostPerformanceHelper r100) {
        this.mHostPerformanceHelper = r100;
    }

    public void setIsAnchor(boolean r100) {
        AAPleasureManager r101 = this.pleasureManager;
        if (r101 == null) goto L15;
        if (((Boolean) r101.f154492l.getValue()).booleanValue() == false) goto L15;
        ALogger.d("AAPleasureManager", "isAnchor " + r100);
        if (r100 == false) goto L11;
        r101.f154500t = true;
        Function1<? super Boolean, Unit> r102 = com.bytedance.android.livesdk.performance.aapleasure.b.f154425a;
        if (r102 == null) goto L15;
        Unit r103 = r102.invoke(Boolean.TRUE);
        goto L15
    L11:
        r101.f154500t = false;
        Function1<? super Boolean, Unit> r104 = com.bytedance.android.livesdk.performance.aapleasure.b.f154425a;
        if (r104 == null) goto L15;
        Unit r105 = r104.invoke(Boolean.FALSE);
    L15:
        if (SleepMode.f154768a == false) goto L19;
        SleepMode.f154771d.f154798m = r100;
        return;
    }

    public void setLivePerformanceStrategyConfig(LivePerformanceStrategyConfig r100) {
        this.mLivePerformanceStrategyConfig = r100;
    }

    @Override // com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager
    public void unregisterPerformanceStrategyTask(int r100) {
        this.mPerforamnceStrategyTaskMap.remove(Integer.valueOf(r100));
    }

    public static /* synthetic */ void access$700(LivePerformanceStrategyManager r100, int r101) {
        r100.triggerDegrade(r101);
    }

    public void onExperienceSceneChange(String r100, int r101) {
        if (this.pleasureManager != null) goto L5;
        return;
    L5:
        if (checkBalanceSwitch() == false) goto L28;
        AAPleasureManager r102 = this.pleasureManager;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (r102.f154501u == true) goto L10;
        r102.f154495o.clear();
    L10:
        if (Intrinsics.areEqual(r100, ExperienceScene.sleep.getMask()) == false) goto L24;
        o r103 = r102.f154487g;
        r103.getClass();
        if (r101 != ExperienceSceneLevel.NORMAL.getLevel()) goto L15;
        String r104 = r103.f154462a;
        Level r105 = Level.Normal;
        Pair<String, Integer> r106 = new Pair(r104, Integer.valueOf(r105.getLevel()));
        r103.f154463b.setActiveLevel(r105);
    L21:
        if (r106 == null) goto L24;
        r102.f154495o.add(r106);
        goto L24
    L15:
        if (r101 != ExperienceSceneLevel.SERIOUS.getLevel()) goto L18;
        String r107 = r103.f154462a;
        Level r108 = Level.Serious;
        r106 = new Pair(r107, Integer.valueOf(r108.getLevel()));
        r103.f154463b.setActiveLevel(r108);
        goto L21
    L18:
        if (r101 != ExperienceSceneLevel.CRITICAL.getLevel()) goto L20;
        String r109 = r103.f154462a;
        Level r110 = Level.Critical;
        r106 = new Pair(r109, Integer.valueOf(r110.getLevel()));
        r103.f154463b.setActiveLevel(r110);
        goto L21
    L20:
        r106 = null;
    L24:
        if (r102.f154501u == true) goto L29;
        r102.c(r102.f154495o);
        return;
    L29:
        return;
    }

    public void onPythiaDataReady(float r100, float r101) {
        ALogger.i(TAG, "current score = " + r100 + " ; stable score = " + r101 + "");
        if (checkPythiaSettings() == false) goto L23;
        LivePerformancePythiaConfig r102 = this.mLivePerformancePythiaConfig;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.mEnable == true) goto L9;
        return;
    L9:
        if (r100 > r102.mScoreLevelFour) goto L12;
        this.mPythiaTempLevel = 4;
    L21:
        getCommonSettings();
        checkDegrade();
        return;
    L12:
        if (r100 > r102.mScoreLevelThree) goto L15;
        this.mPythiaTempLevel = 3;
        goto L21
    L15:
        if (r100 > r102.mScoreLevelTwo) goto L18;
        this.mPythiaTempLevel = 2;
        goto L21
    L18:
        if (r100 > r102.mScoreLevelOne) goto L20;
        this.mPythiaTempLevel = 1;
        goto L21
    L20:
        this.mPythiaTempLevel = 0;
        goto L21
    }

    @Override // com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager
    public void registerPerformanceStrategyTask(int r100, BasePerformanceStrategyTask r101) {
        this.mPerforamnceStrategyTaskMap.put(Integer.valueOf(r100), r101);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_android_livesdk_performance_degrade_LivePerformanceStrategyManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }

    private void buildCommonMonitorInfo(Map<String, String> r100, int r101, String r102) {
        if (r100 == null) goto L10;
        String r103 = "recover";
        switch(r101) {
            case 0: goto L8;
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L7;
            case 12: goto L7;
            case 13: goto L7;
            case 14: goto L7;
            case 15: goto L7;
            case 16: goto L6;
            case 17: goto L6;
            case 18: goto L6;
            case 19: goto L6;
            case 20: goto L6;
            default: goto L8;
        };
    L6:
        r103 = "enhance";
        goto L8
    L7:
        r103 = "degrade";
    L8:
        r100.put("performance_level", String.valueOf(r101));
        r100.put("performance_action", r102);
        r100.put("performance_scene", r103);
        return;
    }

    public static /* synthetic */ void access$400(LivePerformanceStrategyManager r100, Map r101, int r102, String r103) {
        r100.buildCommonMonitorInfo(r101, r102, r103);
    }

    private void judgeDegradeStrategy(boolean r100, boolean r101, boolean r102, boolean r103) {
        if (r100 == false) goto L4;
        int r104 = 4;
    L12:
        if (r104 != this.currentPerformanceLevel) goto L14;
        this.mRecoverStartTime = -1;
        return;
    L14:
        if (r104 == 0) goto L17;
        this.mRecoverStartTime = -1;
        triggerDegrade(r104);
        resetPerformanceStrategy();
        return;
    L17:
        if (this.mRecoverStartTime >= 0) goto L20;
        this.mRecoverStartTime = System.currentTimeMillis();
    L20:
        if (judgeRecover() == false) goto L25;
        triggerOrigin();
        return;
    L25:
        return;
    L4:
        if (r101 == false) goto L6;
        r104 = 3;
        goto L12
    L6:
        if (r102 == false) goto L8;
        r104 = 2;
        goto L12
    L8:
        if (r103 == false) goto L10;
        r104 = 1;
        goto L12
    L10:
        r104 = 0;
        goto L12
    }

    private void mergedMonitorInfo(Map<String, String> r100, Map<String, String> r101, int r102, boolean r103, boolean r104) {
        if (r104 == false) goto L5;
        String r105 = "notify";
    L32:
    L24:
        e = move-exception;
        ALogger.e(TAG, e.getMessage());
    L26:
        if (r103 == true) goto L28;
        r100.put("degrade_reason", degradeReason);
    L30:
        this.hasReportMonitorMerge = false;
        return;
    L28:
        if (r104 == false) goto L30;
        r100.put("degrade_duration", String.valueOf(mDegradeDuration));
        goto L30
    L7:
        if (r100.size() != 0) goto L11;
        buildCommonMonitorInfo(r100, r102, r105);     // Catch: Exception -> L24
        if (r101 == null) goto L26;
        r100.putAll(r101);     // Catch: Exception -> L24
        goto L26
    L11:
        if (r101 == null) goto L26;
        if (r101.size() <= 0) goto L26;
        if (r101.containsKey("scene") == true) goto L17;
    L22:
        r100.putAll(r101);     // Catch: Exception -> L24
        goto L26
    L17:
        if (TextUtils.isEmpty(r101.get("scene")) == true) goto L22;
        String r106 = r101.get("scene");     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r100.get("scene")) == true) goto L21;
        r100.put("scene", r100.get("scene") + "&" + r106);     // Catch: Exception -> L24
    L21:
        r101.remove("scene");     // Catch: Exception -> L24
        goto L22
    L5:
        r105 = "action";
        goto L32
    }

    public static /* synthetic */ void access$300(LivePerformanceStrategyManager r100, Map r101, Map r102, int r103, boolean r104, boolean r105) {
        r100.mergedMonitorInfo(r101, r102, r103, r104, r105);
    }
}
