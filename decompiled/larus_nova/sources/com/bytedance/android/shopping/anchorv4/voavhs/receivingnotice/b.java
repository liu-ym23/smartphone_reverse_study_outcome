package com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice;

import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4ReceivingNoticeVH f170050a;

    public final void b() {
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(this.f170050a.f170044q, "dutyfree_logistics_info_show", null, false, null, null, null, null, 246);
    }

    public b(AnchorV4ReceivingNoticeVH r100) {
        this.f170050a = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice.a
    public final void a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "receiveType");
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(this.f170050a.f170044q, "dutyfree_logistics_info_click", MapsKt.mapOf(TuplesKt.to("logistic_type", r110)), false, null, null, null, null, 252);
    }
}
