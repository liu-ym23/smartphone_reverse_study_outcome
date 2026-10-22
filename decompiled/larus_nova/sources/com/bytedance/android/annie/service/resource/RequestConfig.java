package com.bytedance.android.annie.service.resource;

import android.webkit.WebResourceRequest;
import com.bytedance.android.annie.api.resource.AnnieResType;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class RequestConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnnieResType f40016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f40017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f40018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f40019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f40020e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f40021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f40022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f40023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f40024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f40025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WebResourceRequest f40026k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f40027l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RequestConfig) == true) goto L9;
        return false;
    L9:
        if (this.f40016a == ((RequestConfig) r100).f40016a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f40016a.hashCode();
    }

    public final String toString() {
        return "RequestConfig(resType=" + this.f40016a + ')';
    }

    public final Map<String, Object> a() {
        return (Map) this.f40025j.getValue();
    }

    public RequestConfig(AnnieResType r100) {
        Intrinsics.checkNotNullParameter(r100, "resType");
        this.f40016a = r100;
        if (com.bytedance.android.annie.ng.g.f39675g == true) goto L5;
    L8:
        boolean r101 = true;
    L9:
        this.f40024i = r101;
        this.f40025j = LazyKt.lazy(RequestConfig$customParams$2.INSTANCE);
        return;
    L5:
        if (com.bytedance.android.annie.ng.g.b().f39657a.f522322a == false) goto L8;
        r101 = false;
        goto L9
    }
}
