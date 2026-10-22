package com.bytedance.android.latch.prefetch.internal;

import java.util.Map;
import java.util.SortedMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class PrefetchRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f58427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SortedMap<String, String> f58429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SortedMap<String, Object> f58430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f58431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f58432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f58433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f58434h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f58435i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f58436j;

    public final int hashCode() {
        return ((Number) this.f58436j.getValue()).intValue();
    }

    public final String toString() {
        return (String) this.f58434h.getValue();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof PrefetchRequest) == true) goto L5;
        return false;
    L5:
        PrefetchRequest r101 = (PrefetchRequest) r100;
        if (Intrinsics.areEqual(this.f58427a, r101.f58427a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f58428b, r101.f58428b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f58429c, r101.f58429c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f58430d, r101.f58430d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f58431e, r101.f58431e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f58432f, r101.f58432f) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public PrefetchRequest(String r100, String r101, SortedMap<String, String> r102, SortedMap<String, Object> r103, JSONObject r104, Map<String, String> r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r106, "callbackId");
        this.f58427a = r100;
        this.f58428b = r101;
        this.f58429c = r102;
        this.f58430d = r103;
        this.f58431e = r104;
        this.f58432f = r105;
        this.f58433g = r106;
        this.f58434h = LazyKt.lazy(new PrefetchRequest$str$2(this));
        this.f58435i = LazyKt.lazy(new PrefetchRequest$jsonObject$2(this));
        this.f58436j = LazyKt.lazy(new AnonymousClass2(this));
    }
}
