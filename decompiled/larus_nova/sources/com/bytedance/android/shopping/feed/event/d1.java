package com.bytedance.android.shopping.feed.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174655d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174652a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("page_name", r100, r101);
        appendParam("product_id", this.f174653b, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, this.f174654c, r101);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, this.f174655d, r101);
    }

    public d1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super(r100);
    }
}
