package com.bytedance.android.shopping.feed.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class l1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174801b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY, null, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_BRAND_VERIFIED, this.f174800a, r100);
        appendParam("page_type", this.f174801b, r100);
    }

    public l1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super(r100);
    }
}
