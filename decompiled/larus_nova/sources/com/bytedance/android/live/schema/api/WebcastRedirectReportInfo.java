package com.bytedance.android.live.schema.api;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class WebcastRedirectReportInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f100489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f100490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f100491c;

    public final Map<String, String> b() {
        return (Map) this.f100489a.getValue();
    }

    public final Map<String, String> c() {
        return (Map) this.f100490b.getValue();
    }

    public WebcastRedirectReportInfo() {
        this.f100489a = LazyKt.lazy(WebcastRedirectReportInfo$category$2.INSTANCE);
        this.f100490b = LazyKt.lazy(WebcastRedirectReportInfo$extras$2.INSTANCE);
        this.f100491c = LazyKt.lazy(WebcastRedirectReportInfo$metric$2.INSTANCE);
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        b().put(r100, r101);
    }
}
