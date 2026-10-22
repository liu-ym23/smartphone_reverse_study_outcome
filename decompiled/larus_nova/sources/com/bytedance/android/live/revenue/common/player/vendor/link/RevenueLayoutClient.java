package com.bytedance.android.live.revenue.common.player.vendor.link;

import android.graphics.RectF;
import com.bytedance.android.live.link.player.DeviceType;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import rc0.n;

/* JADX INFO: loaded from: classes47.dex */
public final class RevenueLayoutClient implements rx0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f90944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f90945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f90946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f90947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f90948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DeviceType f90949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f90950g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f90951h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f90952i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f90953j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RevSeiFrame f90954k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public zx0.b f90955l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f90956m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public zx0.a f90957n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f90958o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f90959p;

    @Override // rx0.a
    public final sx0.a a() {
        zx0.b r100 = this.f90955l;
        if (r100 == null) goto L7;
        sx0.a r101 = r100.f573869b;
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new sx0.a.C7666a(1.0f, 0, 0.0f);
    }

    @Override // rx0.a
    public final RectF b() {
        zx0.b r100 = this.f90955l;
        if (r100 == null) goto L7;
        RectF r101 = r100.f573868a;
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public final void c() {
        a r100 = this.f90948e;
        boolean r101 = n.a(this.f90949f);
        DeviceType r102 = this.f90949f;
        Intrinsics.checkNotNullParameter(r102, "$this$isFoldFull");
        if (r102 != DeviceType.FOLD_FULL) goto L5;
        boolean r103 = true;
    L6:
        c r110 = new c(r101, r103, this.f90950g, this.f90944a, this.f90945b, this.f90946c, this.f90947d, this.f90956m, this.f90954k, this.f90951h, this.f90952i, this.f90953j);
        b r104 = this.f90959p;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r110, "layoutContext");
        Iterator r105 = ((ArrayList) r104.f90962a).iterator();
    L7:
        zx0.b r106 = null;
        if (r105.hasNext() == false) goto L12;
        Object r107 = r105.next();
        if (((zx0.a) r107).c(r110) == false) goto L7;
    L13:
        this.f90957n = (zx0.a) r107;
        if (Intrinsics.areEqual(r100, a.b.f90961a) == false) goto L19;
        zx0.a r108 = this.f90957n;
        if (r108 == null) goto L26;
        r106 = r108.a(r110);
    L26:
        this.f90955l = r106;
        return;
    L19:
        if ((r100 instanceof a.C1397a) == false) goto L29;
        RectF r109 = ((a.C1397a) r100).f90960a;
        zx0.a r111 = this.f90957n;
        if (r111 == null) goto L26;
        RectF r112 = r111.b(r110);
        if (r112 == null) goto L26;
        sx0.a.e r113 = new sx0.a.e(r109);
        float r114 = r112.centerX();
        float r115 = r112.centerY();
        float r116 = r112.width() * this.f90958o;
        float r117 = r112.height() * this.f90958o;
        float r118 = r116 / 2.0f;
        float r119 = r117 / 2.0f;
        r106 = new zx0.b(new RectF(RangesKt.coerceAtLeast(r114 - r118, 0.0f), RangesKt.coerceAtLeast(r115 - r119, 0.0f), RangesKt.coerceAtMost(r114 + r118, 1.0f), RangesKt.coerceAtMost(r115 + r119, 1.0f)), r113, null);
        goto L26
    L29:
        throw new NoWhenBranchMatchedException();
    L12:
        r107 = null;
        goto L13
    L5:
        r103 = false;
        goto L6
    }

    public RevenueLayoutClient() {
        this.f90948e = a.b.f90961a;
        this.f90949f = DeviceType.NORMAL_MOBILE;
        this.f90950g = true;
        RevSeiFrame.G.getClass();
        this.f90954k = (RevSeiFrame) RevSeiFrame.D.getValue();
        this.f90958o = 1.0f;
        this.f90959p = new b(RevenueLayoutClient$strategyManager$1.INSTANCE);
    }

    @Override // rx0.a
    public final int getContainerWidth() {
        return this.f90944a;
    }

    @Override // rx0.a
    public final int l() {
        return this.f90945b;
    }
}
