package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f126863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f126864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EXGaugeLevel f126865c;

    public static final class a {
    }

    static {
    }

    public h() {
        this.f126865c = EXGaugeLevel.INNATE;
    }

    public final void a(int r100, boolean r101) {
        long r102 = System.currentTimeMillis();
        long r103 = this.f126863a;
        if (r103 != 0) goto L5;
        float r104 = 1.0f;
    L7:
        if (RangesKt.coerceAtLeast((int) ((r100 - this.f126864b) / r104), 1) >= 4) goto L9;
        EXGaugeLevel r105 = EXGaugeLevel.INNATE;
    L12:
        this.f126865c = r105;
        this.f126863a = r102;
        this.f126864b = r100;
        return;
    L9:
        if (r101 == false) goto L11;
        r105 = EXGaugeLevel.OVERHEATED;
        goto L12
    L11:
        r105 = EXGaugeLevel.HEATED;
        goto L12
    L5:
        r104 = (r102 - r103) / 1000.0f;
        goto L7
    }
}
