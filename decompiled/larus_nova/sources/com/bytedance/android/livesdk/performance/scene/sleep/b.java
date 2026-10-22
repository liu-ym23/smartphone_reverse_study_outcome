package com.bytedance.android.livesdk.performance.scene.sleep;

import android.app.Activity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.performance.aapleasure.ExperienceScene;
import com.bytedance.android.livesdk.performance.aapleasure.ExperienceSceneLevel;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f154786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f154787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e<Long> f154788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e<Integer> f154789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f154790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f154791f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f154792g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f154793h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f154794i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f154795j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ho2.a f154796k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ho2.b f154797l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f154798m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f154799n;

    public final void a() {
        ALogger.d(this.f154786a, "checkAction");
        if (this.f154790e == true) goto L5;
        c();
        d();
        return;
    L5:
        if (this.f154798m == false) goto L8;
        ALogger.d(this.f154786a, "canDoAction, isAnchor(" + this.f154798m + ')');
    L32:
        boolean r100 = false;
    L33:
        if (r100 == true) goto L35;
        c();
        d();
        return;
    L35:
        if (this.f154787b == true) goto L57;
        ALogger.d(this.f154786a, "doAction, first time");
        e<Long> r101 = this.f154788c;
        Long r102 = Long.valueOf(System.currentTimeMillis());
        r101.getClass();
        f.d(r101, r102);
        this.f154787b = true;
        e<Integer> r103 = this.f154789d;
        f.d(r103, Integer.valueOf(r103.getValue().intValue() + 1));
        if (SleepModeTimePeriodManager.a().f() == false) goto L46;
        ho2.b r104 = this.f154797l;
        ExperienceSceneLevel r105 = ExperienceSceneLevel.SERIOUS;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "expLevel");
        if (r104.f486211a >= 0) goto L46;
        Activity r106 = r104.f486213c;
        if ((r106 instanceof Activity) == true) goto L43;
        r106 = null;
    L43:
        if (r106 == null) goto L46;
        r104.f486212b.b(false, r106);
        r104.f486211a = System.currentTimeMillis();
    L46:
        if (SleepModeTimePeriodManager.a().e() == false) goto L53;
        ho2.a r107 = this.f154796k;
        ExperienceSceneLevel r108 = ExperienceSceneLevel.SERIOUS;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r108, "expLevel");
        if (r107.f486210a >= 0) goto L53;
        IPerformanceManager r109 = (IPerformanceManager) k.f(IPerformanceManager.class);
        if (r109 == null) goto L52;
        r109.onExperienceSceneChange(ExperienceScene.sleep.getMask(), r108.getLevel());
    L52:
        r107.f486210a = System.currentTimeMillis();
    L53:
        a r110 = a.f154785a;
        Map<String, String> r111 = b();
        r110.getClass();
        a.a("action_execute_sleep_action", r111);
        return;
    L57:
        return;
    L8:
        if (this.f154799n == false) goto L10;
        ALogger.d(this.f154786a, "canDoAction, isVpass(" + this.f154799n + ')');
        goto L32
    L10:
        long r112 = System.currentTimeMillis() - this.f154788c.getValue().longValue();
        if (r112 <= 1440000) goto L14;
        e<Integer> r113 = this.f154789d;
        r113.getClass();
        f.d(r113, 0);
        e<Long> r114 = this.f154788c;
        r114.getClass();
        f.d(r114, -1L);
        ALogger.d(this.f154786a, "resetAction, lastActionDuration(" + r112 + ')');
    L14:
        if (this.f154789d.getValue().intValue() < this.f154791f) goto L17;
        ALogger.d(this.f154786a, "canDoAction, actionCount(" + this.f154789d.getValue() + ") > mLimitCount(" + this.f154791f + ')');
        goto L32
    L17:
        if (this.f154792g >= 0) goto L19;
    L31:
        ALogger.d(this.f154786a, "canDoAction, mLimitTriggerDuration(" + this.f154792g + ')');
        goto L32
    L19:
        if (this.f154793h < 0) goto L31;
        long r115 = System.currentTimeMillis() - this.f154793h;
        if (this.f154794i <= 0) goto L25;
        ALogger.d(this.f154786a, "not canDoAction, no screen on time: " + this.f154794i);
        this.f154794i = -1;
        goto L32
    L25:
        if (r115 > 0) goto L27;
    L30:
        ALogger.d(this.f154786a, "not canDoAction, no touch time:" + r115);
        goto L32
    L27:
        if (r115 < this.f154792g) goto L30;
        r100 = true;
        goto L33
    }

    public final Map<String, String> b() {
        LinkedHashMap r100 = new LinkedHashMap();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        if (this.f154790e == false) goto L6;
        String r102 = "1";
    L7:
        r100.put("is_in_sleep_range", r102);     // Catch: Throwable -> L9
        r100.put("last_touch_timestamp", String.valueOf(this.f154793h));     // Catch: Throwable -> L9
        r100.put("do_action_count", String.valueOf(this.f154789d.getValue().intValue()));     // Catch: Throwable -> L9
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        return r100;
    L6:
        r102 = "0";
    L9:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void c() {
        if (this.f154787b == false) goto L29;
        ALogger.d(this.f154786a, "resumeAction, isDoAction(" + this.f154787b + ") actionCount(" + this.f154789d.getValue() + ") doActionTimeStamp(" + this.f154788c.getValue() + ')');
        e<Long> r100 = this.f154788c;
        r100.getClass();
        f.d(r100, -1L);
        this.f154787b = false;
        if (SleepModeTimePeriodManager.a().f() == false) goto L18;
        ho2.b r101 = this.f154797l;
        r101.getClass();
    L15:
        e = move-exception;
        ALogger.e("LiveSleep_LiveScreenStrategy", "resumeAction, setKeepScreenOn error", e);
        goto L18
    L8:
        if (r101.f486211a <= 0) goto L18;
        Activity r102 = r101.f486213c;     // Catch: Exception -> L15
        if ((r102 instanceof Activity) == true) goto L12;
        r102 = null;
    L12:
        if (r102 == null) goto L18;
        r101.f486212b.b(true, r102);     // Catch: Exception -> L15
        r101.f486211a = -1;     // Catch: Exception -> L15
    L18:
        if (SleepModeTimePeriodManager.a().e() == false) goto L25;
        ho2.a r103 = this.f154796k;
        if (r103.f486210a <= 0) goto L25;
        IPerformanceManager r104 = (IPerformanceManager) k.f(IPerformanceManager.class);
        if (r104 == null) goto L24;
        r104.onExperienceSceneChange(ExperienceScene.sleep.getMask(), ExperienceSceneLevel.NORMAL.getLevel());
    L24:
        r103.f486210a = -1;
    L25:
        a r105 = a.f154785a;
        Map<String, String> r106 = b();
        r105.getClass();
        a.a("action_resume_sleep_action", r106);
        return;
    }

    public final void d() {
        if (this.f154798m == false) goto L7;
        ALogger.d(this.f154786a, "retrySleepModeAction, isAnchor(" + this.f154798m + ')');
        return;
    L7:
        if (this.f154799n == false) goto L11;
        ALogger.d(this.f154786a, "retrySleepModeAction, isVpass(" + this.f154799n + ')');
        return;
    L11:
        if (this.f154789d.getValue().intValue() < this.f154791f) goto L15;
        ALogger.d(this.f154786a, "retrySleepModeAction, actionCount(" + this.f154789d.getValue() + ") > mLimitCount(" + this.f154791f + ')');
        return;
    L15:
        if (this.f154790e == false) goto L32;
        long r100 = System.currentTimeMillis();
        long r101 = this.f154793h;
        long r102 = -1;
        if (r101 <= 0) goto L19;
        long r103 = r100 - r101;
    L21:
        if (r103 <= 0) goto L24;
        r102 = this.f154792g - r103;
    L24:
        if (r102 <= 0) goto L33;
        boolean r104 = SleepMode.f154768a;
        ALogger.d("LiveSleep_Mode", "trySleepModeAction, delayTime(" + r102 + ')');
        c r105 = SleepMode.f154770c;
        if (r105 != null) goto L28;
        return;
    L28:
        if (r105.hasMessages(4) == false) goto L30;
        r105.removeMessages(4);
    L30:
        r105.sendEmptyMessageDelayed(4, r102);
        return;
    L33:
        return;
    L19:
        r103 = -1;
        goto L21
    }

    public b() {
        this.f154786a = "LiveSleep_Action";
        this.f154788c = new e("live_sleep_mode_action_timestamp", -1L);
        this.f154789d = new e("live_sleep_mode_action_count", 0);
        this.f154791f = 1;
        this.f154792g = -1;
        this.f154793h = -1;
        this.f154794i = -1;
        this.f154796k = new ho2.a();
        this.f154797l = new ho2.b();
    }
}
