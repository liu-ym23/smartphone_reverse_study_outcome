package com.bytedance.android.latch.prefetch.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class UriWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f58441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f58442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f58443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f58444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f58445e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f58446f;

    public UriWrapper(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f58441a = r100;
        this.f58442b = LazyKt.lazy(new UriWrapper$uri$2(this));
        this.f58443c = LazyKt.lazy(new UriWrapper$host$2(this));
        this.f58444d = LazyKt.lazy(new UriWrapper$queryMap$2(this));
        this.f58445e = LazyKt.lazy(new UriWrapper$path$2(this));
        this.f58446f = LazyKt.lazy(new UriWrapper$hash$2(this));
    }
}
