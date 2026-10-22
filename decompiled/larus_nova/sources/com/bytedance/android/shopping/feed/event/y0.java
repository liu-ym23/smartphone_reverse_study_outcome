package com.bytedance.android.shopping.feed.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class y0 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174971c;

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI, r100);
        appendParam("page_name", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE, r100);
        appendParam("group_id", this.f174969a, r100);
        appendParam("amount", this.f174970b, r100);
        appendParam("expired_minute", this.f174971c, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_BENEFIT_TYPE, null, r100);
    }

    public y0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
    }
}
