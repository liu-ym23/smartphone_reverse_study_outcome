package com.bytedance.android.shopping.feed.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f175001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f175002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f175003c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        appendParam("product_id", this.f175001a);
        appendParam("search_words_group", this.f175002b);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, "guess_you_like_product");
        appendParam("search_words_content", this.f175003c);
    }

    public z0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super(r100);
    }
}
