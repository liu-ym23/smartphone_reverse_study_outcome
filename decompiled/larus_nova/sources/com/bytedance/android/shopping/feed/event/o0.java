package com.bytedance.android.shopping.feed.event;

import android.content.Context;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes13.dex */
public final class o0<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Integer f174835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f174836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f174837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f174838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AnchorV3Param f174839e;

    public o0(Integer r100, Context r101, AnchorV3Param r102) {
        this.f174835a = r100;
        this.f174836b = r101;
        this.f174837c = null;
        this.f174838d = 0;
        this.f174839e = r102;
    }

    @Override // java.util.concurrent.Callable
    public final com.bytedance.android.ec.core.event.a call() {
        a2 r100 = new a2();
        r100.f174610a = String.valueOf(this.f174838d);
        AnchorV3Param r101 = this.f174839e;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getVideoId();
    L6:
        r100.f174611b = r103;
        AnchorV3Param r104 = this.f174839e;
        if (r104 == null) goto L9;
        String r105 = r104.getAuthorId();
    L10:
        r100.f174612c = r105;
        AnchorV3Param r106 = this.f174839e;
        if (r106 == null) goto L15;
        ECLogExtraData r107 = r106.getLogExtraData();
        if (r107 == null) goto L15;
        r102 = r107.getEnterFrom();
    L15:
        r100.f174613d = r102;
        Integer r108 = this.f174835a;
        if (r108 != null) goto L19;
    L21:
        if (r108 != null) goto L24;
    L26:
        r100.buildLogParams();
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        r100.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
        return r100;
    L24:
        if (r108.intValue() != 0) goto L26;
        g.b(r100, this.f174836b);
        goto L26
    L19:
        if (r108.intValue() != 2) goto L21;
        g.a(r100, this.f174836b, this.f174837c);
        goto L26
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
