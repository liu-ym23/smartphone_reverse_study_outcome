package com.bytedance.android.shopping.orderlist.list.network;

import com.bytedance.android.shopping.orderlist.common.utils.OrderAppletPageScene;
import com.bytedance.android.shopping.orderlist.list.container.OrderListRequestType;
import com.bytedance.retrofit2.SsResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OrderListRequestType f180240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f180241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f180242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f180243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f180244e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f180245f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OrderAppletPageScene f180246g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f180247h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<? super SsResponse<String>, Unit> f180248i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.android.shopping.orderlist.common.monitor.error.a f180249j;

    public b() {
        throw null;
    }

    public final OrderListRequestType getType() {
        return this.f180240a;
    }

    public b(OrderListRequestType r100, int r101, boolean r102, boolean r103, boolean r104, boolean r105, OrderAppletPageScene r110, com.bytedance.android.shopping.orderlist.common.monitor.error.a r111, int r112) {
        if ((r112 & 2) == 0) goto L6;
        r101 = 1;
    L6:
        if ((r112 & 4) == 0) goto L9;
        r102 = false;
    L9:
        if ((r112 & 8) == 0) goto L12;
        r103 = true;
    L12:
        if ((r112 & 16) == 0) goto L15;
        r104 = false;
    L15:
        if ((r112 & 32) == 0) goto L18;
        r105 = false;
    L18:
        if ((r112 & 64) == 0) goto L21;
        r110 = OrderAppletPageScene.PAGE_INTERNAL;
    L21:
        if ((r112 & 512) == 0) goto L23;
        r111 = null;
    L23:
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r110, "appletPageScene");
        this.f180240a = r100;
        this.f180241b = r101;
        this.f180242c = r102;
        this.f180243d = r103;
        this.f180244e = r104;
        this.f180245f = r105;
        this.f180246g = r110;
        this.f180247h = null;
        this.f180248i = null;
        this.f180249j = r111;
    }
}
