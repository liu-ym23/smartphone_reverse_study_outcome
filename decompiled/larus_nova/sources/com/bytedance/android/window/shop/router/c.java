package com.bytedance.android.window.shop.router;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f189655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f189656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f189657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f189658d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam("location", this.f189655a);
        appendParam("business", this.f189656b);
        appendParam("in_schema", this.f189657c);
        appendParam("out_schema", this.f189658d);
    }

    public c(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "location");
        Intrinsics.checkNotNullParameter(r101, "business");
        super("schema_report");
        this.f189655a = r100;
        this.f189656b = r101;
        this.f189657c = r102;
        this.f189658d = r103;
    }
}
