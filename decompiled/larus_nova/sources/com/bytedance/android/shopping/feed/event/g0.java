package com.bytedance.android.shopping.feed.event;

import android.content.Context;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes13.dex */
public final class g0<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Integer f174718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f174719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f174720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f174721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f174722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f174723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f174724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f174725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f174726i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f174727j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f174728k;

    public g0(Integer r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        this.f174718a = r100;
        this.f174719b = null;
        this.f174720c = null;
        this.f174721d = r101;
        this.f174722e = r102;
        this.f174723f = r103;
        this.f174724g = r104;
        this.f174725h = r105;
        this.f174726i = r106;
        this.f174727j = r107;
        this.f174728k = "0";
    }

    @Override // java.util.concurrent.Callable
    public final com.bytedance.android.ec.core.event.a call() {
        x0 r100 = new x0();
        String r101 = this.f174721d;
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.f174959a = r101;
        String r103 = this.f174722e;
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r100.f174960b = r103;
        String r104 = this.f174723f;
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        r100.f174961c = r104;
        String r105 = this.f174724g;
        if (r105 != null) goto L14;
        r105 = "";
    L14:
        r100.f174962d = r105;
        String r106 = this.f174725h;
        if (r106 != null) goto L17;
        r106 = "";
    L17:
        r100.f174963e = r106;
        String r107 = this.f174726i;
        if (r107 != null) goto L20;
        r107 = "";
    L20:
        r100.f174964f = r107;
        String r108 = this.f174727j;
        if (r108 != null) goto L23;
        r108 = "";
    L23:
        r100.f174965g = r108;
        String r109 = this.f174728k;
        if (r109 == null) goto L27;
        r102 = r109;
    L27:
        r100.f174966h = r102;
        Integer r110 = this.f174718a;
        if (r110 != null) goto L31;
    L33:
        if (r110 != null) goto L36;
    L38:
        r100.buildLogParams();
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        r100.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);
        return r100;
    L36:
        if (r110.intValue() != 0) goto L38;
        g.b(r100, this.f174719b);
        goto L38
    L31:
        if (r110.intValue() != 2) goto L33;
        g.a(r100, this.f174719b, this.f174720c);
        goto L38
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
