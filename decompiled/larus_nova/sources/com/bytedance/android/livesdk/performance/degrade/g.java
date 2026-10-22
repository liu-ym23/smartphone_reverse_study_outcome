package com.bytedance.android.livesdk.performance.degrade;

import com.bytedance.android.livesdk.performance.config.LivePerformanceStrategyConfig;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;

/* JADX INFO: loaded from: classes11.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f154551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LivePerformanceStrategyConfig.a f154552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f154553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f154554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f154555e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f154556f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f154557g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f154558h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f154559i;

    public static final class a {
    }

    static {
    }

    public final long a() {
        LivePerformanceStrategyConfig.a r100 = this.f154552b;
        if (r100 != null) goto L5;
        return 60000;
    L5:
        if (r100 == null) goto L7;
        long r101 = r100.mDuration;
    L9:
        if (r101 > 0) goto L11;
        return 60000;
    L11:
        return r101;
    L7:
        r101 = 60000;
        goto L9
    }

    public final void c() {
        this.f154557g = -1;
        this.f154556f = -1;
    }

    public final boolean b(int r110, float r111, double r112) {
        this.f154555e = r110;
        if (this.f154554d == false) goto L89;
        double r100 = r111;
        double r113 = 38.0f;
        LivePerformanceStrategyConfig.a r101 = this.f154552b;
        if (r101 == null) goto L12;
        double r114 = r101.mTemperature;
        if (this.f154553c == false) goto L10;
        r114 = Math.max(r114, r113);
    L10:
        r113 = r114;
    L12:
        if (r100 > r113) goto L14;
        this.f154556f = -1;
    L17:
        double r102 = 0.3f;
        LivePerformanceStrategyConfig.a r103 = this.f154552b;
        if (r103 == null) goto L25;
        double r104 = r103.mUiStallRate;
        if (this.f154553c == false) goto L23;
        r102 = Math.max(r104, r102);
        goto L25
    L23:
        r102 = r104;
    L25:
        if (r112 > r102) goto L27;
    L31:
        this.f154557g = -1;
    L33:
        if (tb1.c.f545235g == false) goto L57;
        long r105 = this.f154555e;
        if (r105 == (-1)) goto L37;
        int r106 = this.f154551a;
        if (r106 == 1) goto L47;
        if (r106 >= 2) goto L51;
    L53:
        boolean r107 = false;
    L54:
        if (r107 == false) goto L65;
        LivePerformanceStrategyManager.degradeReason = IPerformanceStrategyManager.DEGRADE_REASON_TEMPERATURE_THERMAL;
    L65:
        if (this.f154557g > 0) goto L67;
    L69:
        boolean r108 = false;
    L70:
        if (r107 == true) goto L73;
        if (r108 == false) goto L73;
        LivePerformanceStrategyManager.degradeReason = IPerformanceStrategyManager.DEGRADE_REASON_UI_STALL;
    L73:
        LivePerformanceStrategyConfig.a r109 = this.f154552b;
        if (r109 != null) goto L76;
        int r115 = 1;
        int r116 = 1;
    L80:
        if (r115 != r116) goto L84;
        if (r107 == true) goto L86;
        if (r108 == true) goto L86;
    L87:
        return false;
    L86:
        return true;
    L84:
        if (r107 == false) goto L87;
        if (r108 == false) goto L87;
    L76:
        r115 = r109.mOperator;
        r116 = 1;
        if (r115 < 0) goto L79;
        if (r115 <= 1) goto L80;
    L79:
        r115 = 1;
        goto L80
    L67:
        if ((System.currentTimeMillis() - this.f154557g) < a()) goto L69;
        r108 = true;
        goto L70
    L51:
        if (r105 != 3) goto L53;
    L52:
        r107 = true;
        goto L54
    L47:
        if (r105 != 2) goto L53;
    L37:
        if (this.f154556f > 0) goto L39;
    L41:
        r107 = false;
    L42:
        if (r107 == false) goto L65;
        LivePerformanceStrategyManager.degradeReason = IPerformanceStrategyManager.DEGRADE_REASON_TEMPERATURE_SYS;
        goto L65
    L39:
        if ((System.currentTimeMillis() - this.f154556f) < a()) goto L41;
        r107 = true;
        goto L42
    L57:
        if (this.f154556f > 0) goto L59;
    L61:
        r107 = false;
    L62:
        if (r107 == false) goto L65;
        LivePerformanceStrategyManager.degradeReason = IPerformanceStrategyManager.DEGRADE_REASON_TEMPERATURE_SYS;
        goto L65
    L59:
        if ((System.currentTimeMillis() - this.f154556f) < a()) goto L61;
        r107 = true;
        goto L62
    L27:
        if (r112 > 1.0f) goto L31;
        if (this.f154557g > 0) goto L33;
        this.f154557g = System.currentTimeMillis();
        goto L33
    L14:
        if (this.f154556f > 0) goto L17;
        this.f154556f = System.currentTimeMillis();
        goto L17
    L89:
        double r117 = r111;
        double r118 = 38.0f;
        LivePerformanceStrategyConfig.a r119 = this.f154552b;
        if (r119 == null) goto L97;
        double r120 = r119.mTemperature;
        if (this.f154553c == false) goto L95;
        r118 = Math.max(r120, r118);
        goto L97
    L95:
        r118 = r120;
    L97:
        if (r117 < r118) goto L99;
        this.f154558h = -1;
    L102:
        double r121 = 0.3f;
        LivePerformanceStrategyConfig.a r122 = this.f154552b;
        if (r122 == null) goto L110;
        double r123 = r122.mUiStallRate;
        if (this.f154553c == false) goto L108;
        r121 = Math.max(r123, r121);
        goto L110
    L108:
        r121 = r123;
    L110:
        if (r112 < r121) goto L112;
    L116:
        this.f154559i = -1;
    L118:
        if (this.f154558h > 0) goto L120;
    L122:
        boolean r124 = false;
    L123:
        if (r124 == false) goto L126;
        LivePerformanceStrategyManager.enhanceReason = IPerformanceStrategyManager.DEGRADE_REASON_TEMPERATURE_SYS;
    L126:
        if (this.f154559i > 0) goto L128;
    L130:
        boolean r125 = false;
    L131:
        if (r124 == true) goto L134;
        if (r125 == false) goto L134;
        LivePerformanceStrategyManager.enhanceReason = IPerformanceStrategyManager.DEGRADE_REASON_UI_STALL;
    L134:
        LivePerformanceStrategyConfig.a r126 = this.f154552b;
        if (r126 != null) goto L137;
        int r127 = 1;
        int r128 = 1;
    L141:
        if (r127 != r128) goto L145;
        if (r124 == true) goto L147;
        if (r125 == true) goto L147;
    L148:
        return false;
    L147:
        return true;
    L145:
        if (r124 == false) goto L148;
        if (r125 == false) goto L148;
    L137:
        r127 = r126.mOperator;
        r128 = 1;
        if (r127 < 0) goto L140;
        if (r127 <= 1) goto L141;
    L140:
        r127 = 1;
        goto L141
    L128:
        if ((System.currentTimeMillis() - this.f154559i) < a()) goto L130;
        r125 = true;
        goto L131
    L120:
        if ((System.currentTimeMillis() - this.f154558h) < a()) goto L122;
        r124 = true;
        goto L123
    L112:
        if (r112 < 0) goto L116;
        if (this.f154559i > 0) goto L118;
        this.f154559i = System.currentTimeMillis();
        goto L118
    L99:
        if (this.f154558h > 0) goto L102;
        this.f154558h = System.currentTimeMillis();
        goto L102
    }

    public g(int r100, LivePerformanceStrategyConfig.a r101, boolean r102, boolean r103) {
        this.f154555e = -1;
        this.f154556f = -1;
        this.f154557g = -1;
        this.f154558h = -1;
        this.f154559i = -1;
        this.f154551a = r100;
        this.f154552b = r101;
        this.f154553c = r102;
        this.f154554d = r103;
    }
}
