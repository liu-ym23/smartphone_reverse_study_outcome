package com.bytedance.android.ec.core.hybrid.prefetch;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class NativeRequestCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f44225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f44226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f44227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f44228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t f44229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f44230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final JSONObject f44231g;

    public final Map<String, String> b(Map<String, String> r100, ParamsType r101) {
        Intrinsics.checkNotNullParameter(r101, "paramType");
        LinkedHashMap r102 = new LinkedHashMap();
        if (r100 == null) goto L33;
        Iterator<Map.Entry<String, String>> r103 = r100.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L33;
        Map.Entry<String, String> r104 = r103.next();
        int r105 = s.f44258a[r101.ordinal()];
        if (r105 != 1) goto L10;
        com.bytedance.android.ec.core.opt.ab.l r106 = (com.bytedance.android.ec.core.opt.ab.l) this.f44225a.getValue();
        if (r106 == null) goto L32;
        com.bytedance.android.ec.core.opt.ab.b r107 = r106.a();
        if (r107 == null) goto L32;
        List<String> r108 = r107.a();
        if (r108 == null) goto L32;
        if (r108.contains(r104.getKey()) == true) goto L6;
    L32:
        r102.put(r104.getKey(), r104.getValue());
        goto L6
    L10:
        if (r105 != 2) goto L12;
    L14:
        com.bytedance.android.ec.core.opt.ab.l r109 = (com.bytedance.android.ec.core.opt.ab.l) this.f44225a.getValue();
        if (r109 == null) goto L32;
        com.bytedance.android.ec.core.opt.ab.b r110 = r109.a();
        if (r110 == null) goto L32;
        List<String> r111 = r110.b();
        if (r111 == null) goto L32;
        if (r111.contains(r104.getKey()) != true) goto L32;
    L12:
        if (r105 == 3) goto L14;
    L33:
        return r102;
    }

    public NativeRequestCache(t r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "nativeRequestConfig");
        Intrinsics.checkNotNullParameter(r101, "requestId");
        this.f44229e = r100;
        this.f44230f = r101;
        this.f44231g = r102;
        this.f44225a = LazyKt.lazy(NativeRequestCache$reuseConfig$2.INSTANCE);
        this.f44226b = System.currentTimeMillis() + ((long) 20000);
        this.f44227c = new AtomicBoolean(false);
        this.f44228d = "NativeRequestCache";
    }

    public final boolean a(Map<String, String> r100, Map<String, String> r101, ParamsType r102) {
        Intrinsics.checkNotNullParameter(r102, "paramType");
        Map<String, String> r103 = b(r100, r102);
        Map<String, String> r104 = b(r101, r102);
        if ((!Intrinsics.areEqual(Integer.valueOf(r103.size()), Integer.valueOf(r104.size()))) == false) goto L5;
        return false;
    L5:
        Iterator r105 = ((LinkedHashMap) r103).entrySet().iterator();
    L7:
        if (r105.hasNext() == false) goto L11;
        Map.Entry r106 = (Map.Entry) r105.next();
        if ((!Intrinsics.areEqual((String) r106.getValue(), (String) ((LinkedHashMap) r104).get(r106.getKey()))) == false) goto L7;
        return false;
    L11:
        return true;
    }
}
