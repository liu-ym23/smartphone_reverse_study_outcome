package com.bytedance.android.shopping.feed.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class p1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f174852c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r100 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_LABEL_CONTENT_TYPE, "product_card", r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_LABEL_ID, this.f174850a, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, this.f174851b, r100);
        appendParam(com.bytedance.android.ec.core.event.a.KEY_LABEL_INFO, this.f174852c, r100);
    }

    public p1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
    }
}
