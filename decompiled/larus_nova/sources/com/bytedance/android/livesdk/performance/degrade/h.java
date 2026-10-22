package com.bytedance.android.livesdk.performance.degrade;

import com.bytedance.android.livesdk.performance.config.LivePerformanceStrategyConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LivePerformanceStrategyConfig.b f154560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f154561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f154562c;

    public static final class a {
    }

    static {
    }

    public final int b() {
        if (this.f154562c == false) goto L11;
        LivePerformanceStrategyConfig.b r100 = this.f154560a;
        Intrinsics.checkNotNull(r100);
        if (r100.mPowerLevel == 0) goto L7;
        LivePerformanceStrategyConfig.b r101 = this.f154560a;
        Intrinsics.checkNotNull(r101);
        int r102 = r101.mPowerLevel;
    L9:
        if (this.f154561b == false) goto L20;
        LivePerformanceStrategyConfig.b r103 = this.f154560a;
        Intrinsics.checkNotNull(r103);
        double r104 = Math.min(r103.mPowerLevel, 30);
    L19:
        return (int) r104;
    L20:
        return r102;
    L7:
        r102 = 30;
        goto L9
    L11:
        LivePerformanceStrategyConfig.b r105 = this.f154560a;
        Intrinsics.checkNotNull(r105);
        if (r105.mPowerLevel == 0) goto L14;
        LivePerformanceStrategyConfig.b r106 = this.f154560a;
        Intrinsics.checkNotNull(r106);
        int r107 = r106.mPowerLevel;
    L16:
        if (this.f154561b == false) goto L21;
        LivePerformanceStrategyConfig.b r108 = this.f154560a;
        Intrinsics.checkNotNull(r108);
        r104 = Math.max(r108.mPowerLevel, 90);
        goto L19
    L21:
        return r107;
    L14:
        r107 = 90;
        goto L16
    }

    public final boolean a(int r100, boolean r101) {
        if (this.f154562c == false) goto L22;
        LivePerformanceStrategyConfig.b r102 = this.f154560a;
        if (r102 == null) goto L10;
        int r103 = r102.mOperator;
        if (r103 < 0) goto L10;
        if (r103 > 1) goto L10;
    L11:
        if (r103 != 1) goto L18;
        if (r100 <= b()) goto L42;
        LivePerformanceStrategyConfig.b r104 = this.f154560a;
        Intrinsics.checkNotNull(r104);
        if (r101 == r104.mPowerInCharge) goto L44;
    L40:
        return false;
    L44:
        return true;
    L42:
        return true;
    L18:
        if (r100 > b()) goto L40;
        LivePerformanceStrategyConfig.b r105 = this.f154560a;
        Intrinsics.checkNotNull(r105);
        if (r101 != r105.mPowerInCharge) goto L40;
        return true;
    L10:
        r103 = 1;
        goto L11
    L22:
        LivePerformanceStrategyConfig.b r106 = this.f154560a;
        if (r106 == null) goto L28;
        int r107 = r106.mOperator;
        if (r107 < 0) goto L28;
        if (r107 > 1) goto L28;
    L29:
        if (r107 != 1) goto L36;
        if (r100 >= b()) goto L43;
        LivePerformanceStrategyConfig.b r108 = this.f154560a;
        Intrinsics.checkNotNull(r108);
        if (r101 != r108.mPowerInCharge) goto L40;
        return true;
    L43:
        return true;
    L36:
        if (r100 < b()) goto L40;
        LivePerformanceStrategyConfig.b r109 = this.f154560a;
        Intrinsics.checkNotNull(r109);
        if (r101 != r109.mPowerInCharge) goto L40;
        return true;
    L28:
        r107 = 1;
        goto L29
    }

    public h(LivePerformanceStrategyConfig.b r100, boolean r101, boolean r102) {
        this.f154560a = r100;
        this.f154561b = r101;
        this.f154562c = r102;
    }
}
