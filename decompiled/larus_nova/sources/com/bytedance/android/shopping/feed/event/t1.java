package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;

/* JADX INFO: loaded from: classes13.dex */
public final class t1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f174914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f174915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f174916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f174917d;

    public static final class a {
    }

    static {
    }

    public t1() {
        super("scrolling_info");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        String r100 = this.f174914a;
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r101 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam("page_name", r100, r101);
        appendParam("product_id", this.f174915b, r101);
        Integer r102 = this.f174916c;
        if (r102 != null) goto L6;
    L8:
        if (r102 != null) goto L11;
    L13:
        if (r102 != null) goto L16;
    L18:
        String r103 = "";
    L19:
        appendParam("info_type", r103, r101);
        appendParam("group_id", this.f174917d, r101);
        return;
    L16:
        if (r102.intValue() != 1000) goto L18;
        r103 = AnchorBenefitToast.TYPE_COUPON;
        goto L19
    L11:
        if (r102.intValue() != 2) goto L13;
        r103 = "comment";
        goto L19
    L6:
        if (r102.intValue() != 1) goto L8;
        r103 = "purchase";
        goto L19
    }
}
