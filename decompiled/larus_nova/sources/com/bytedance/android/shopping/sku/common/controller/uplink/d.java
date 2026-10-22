package com.bytedance.android.shopping.sku.common.controller.uplink;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f182657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Boolean> f182658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f182659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f182660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.shopping.sku.inner.repo.a f182661e;

    public final b a() {
        Iterator r100 = ((LinkedHashMap) this.f182658b).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        Map.Entry r101 = (Map.Entry) r100.next();
        if (((Boolean) r101.getValue()).booleanValue() == false) goto L4;
        return new b(true, (String) r101.getKey());
    L10:
        return new b(false, "");
    }

    public final void b() {
        Iterator r100 = ((LinkedHashMap) this.f182658b).keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        String r101 = (String) r100.next();
        this.f182658b.put(r101, Boolean.FALSE);
        goto L4
    }

    public d() {
        this.f182657a = new a(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        this.f182658b = new LinkedHashMap();
        this.f182659c = new AtomicLong(0);
    }
}
