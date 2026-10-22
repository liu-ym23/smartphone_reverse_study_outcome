package com.bytedance.android.livesdk.livecommerce.iron.helper;

import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class h implements cf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.f f148655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ cf.a f148656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ il2.a f148657c;

    @Override // cf.a
    public final boolean c() {
        return true;
    }

    @Override // cf.a
    public final jf.e a() {
        com.bytedance.android.ec.common.api.jump.model.f r100 = this.f148655a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f42862d;
    }

    @Override // cf.a
    public final void onFailed() {
        il2.a r100 = this.f148657c;
        if (r100 == null) goto L8;
        il2.a r101 = il2.a.C6280a.a(r100, "add_cart_directly_failed", null, false, null, null, null, 56);
        if (r101 == null) goto L9;
        ((LiveActionTracker) r101).e(false);
        return;
    L9:
        return;
    }

    public h(com.bytedance.android.ec.common.api.jump.model.f r100, cf.a r101, il2.a r102) {
        this.f148655a = r100;
        this.f148656b = r101;
        this.f148657c = r102;
    }

    @Override // cf.a
    public final void b(int r110, String r111, String r112, String r113, Integer r114, String r115, String r116, Integer r117, String r210) {
        Intrinsics.checkNotNullParameter(r210, "addType");
        cf.a r100 = this.f148656b;
        if (r100 == null) goto L5;
        cf.a.C0439a.a(r100, r110, r111, r112, r113, r114, r115, r116, r117);
    L5:
        il2.a r101 = this.f148657c;
        if (r101 == null) goto L11;
        il2.a r102 = il2.a.C6280a.a(r101, "add_cart_directly_success", MapsKt.mapOf(TuplesKt.to("product_id", r111)), false, null, null, null, 60);
        if (r102 == null) goto L12;
        ((LiveActionTracker) r102).e(false);
        return;
    L12:
        return;
    }
}
