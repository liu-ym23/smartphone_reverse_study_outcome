package com.bytedance.android.shopping.deepfeed.slice;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements wc3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f173408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public wc3.c f173409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f173410c;

    public static final class a {
    }

    static {
    }

    public final void b() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.putAll(this.f173408a);
        LinkedHashMap r101 = new LinkedHashMap();
        r101.putAll(this.f173410c);
        r100.put("state", r101);
        wc3.c r102 = this.f173409b;
        if (r102 == null) goto L6;
        r102.updateData(r100);
        return;
    }

    @Override // wc3.a
    public final void a(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        e(r100);
        b();
    }

    public final void c(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Iterator<T> r101 = r100.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L17;
        String r102 = (String) r101.next();
        Object r103 = r100.get(r102);
        if (r103 == null) goto L4;
        if ((!Intrinsics.areEqual(r102, "state")) == true) goto L10;
        if ((r103 instanceof Map) == true) goto L14;
        r103 = null;
    L14:
        Map<? extends String, ? extends Object> r104 = (Map) r103;
        if (r104 == null) goto L4;
        this.f173410c.putAll(r104);
        goto L4
    L10:
        this.f173408a.put(r102, r100.get(r102));
        goto L4
    }

    public final void d(com.bytedance.android.shopping.deepfeed.slice.a r100) {
        Intrinsics.checkNotNullParameter(r100, "slcData");
        this.f173409b = r100;
    }

    public final void e(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f173410c.putAll(r100);
    }

    public c(Map<String, Object> r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "drawData");
        Intrinsics.checkNotNullParameter(r101, "firstBindState");
        LinkedHashMap r102 = new LinkedHashMap();
        this.f173408a = r102;
        LinkedHashMap r103 = new LinkedHashMap();
        this.f173410c = r103;
        r102.putAll(r100);
        Object r104 = r100.get("state");
        if ((r104 instanceof Map) == true) goto L5;
        r104 = null;
    L5:
        Map r105 = (Map) r104;
        if (r105 == null) goto L8;
        r103.putAll(r105);
    L8:
        r103.putAll(r101);
    }
}
