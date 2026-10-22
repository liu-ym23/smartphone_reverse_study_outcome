package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class q implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4DetailSkuPropertiesFragment f168250a;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailhead.w
    public final void a() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailhead.w
    public final void c() {
    }

    public q(AnchorV4DetailSkuPropertiesFragment r100) {
        this.f168250a = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.detailhead.w
    public final void b(String r110, String r111, String r112) {
        t r100 = this.f168250a.f168189k.getViewModel();
        if (r100 == null) goto L6;
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r100, "info_explanation_entrance_click", MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, r111), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r110), TuplesKt.to("character_type", r112)}), false, null, null, null, null, 252);
        return;
    }
}
