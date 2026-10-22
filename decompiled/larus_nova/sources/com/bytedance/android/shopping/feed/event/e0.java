package com.bytedance.android.shopping.feed.event;

import android.content.Context;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes13.dex */
public final class e0<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Integer f174687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f174688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f174689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f174690d;

    public e0(Integer r100, Context r101, String r102) {
        this.f174687a = r100;
        this.f174688b = r101;
        this.f174689c = null;
        this.f174690d = r102;
    }

    @Override // java.util.concurrent.Callable
    public final com.bytedance.android.ec.core.event.a call() {
        i1 r100 = new i1("click_mall_entrance");
        r100.f174755a = "product_flow_float";
        r100.f174756b = this.f174690d;
        Integer r101 = this.f174687a;
        if (r101 != null) goto L6;
    L8:
        if (r101 != null) goto L11;
    L13:
        r100.buildLogParams();
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        r100.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
        return r100;
    L11:
        if (r101.intValue() != 0) goto L13;
        g.b(r100, this.f174688b);
        goto L13
    L6:
        if (r101.intValue() != 2) goto L8;
        g.a(r100, this.f174688b, this.f174689c);
        goto L13
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
