package com.bytedance.android.shopping.anchorv4.voavhs.car;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.hybrid.utils.r;
import com.bytedance.android.ec.core.utils.d1;
import com.bytedance.android.ec.core.utils.g0;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnchorV4CarAddressMeta f168077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f168078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f168079c;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r100, Object r101) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r100) {
        return null;
    }

    public final Context getContext() {
        return this.f168078b;
    }

    public a(AnchorV4CarAddressMeta r100, Context r101, e r102) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        this.f168077a = r100;
        this.f168078b = r101;
        this.f168079c = r102;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r110, Action r111, Object r112) {
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "action");
        String r113 = r111.getId();
        if (r113 != null) goto L6;
        return;
    L6:
        if (r113.hashCode() == 1733388578) goto L9;
        return;
    L9:
        if (r113.equals("car_address_title") == false) goto L42;
        AnchorV4CarAddressMeta r114 = this.f168077a;
        if (r114 == null) goto L43;
        AnchorV4CarAddressBusinessMeta r115 = r114.getBusinessMeta();
        if (r115 == null) goto L44;
        String r116 = r115.getLinkUrl();
        if (r116 == null) goto L45;
        int r117 = p0.f45664a;
        int r118 = g0.f45598a;
        if (g0.a(this.f168078b) == false) goto L19;
        String r119 = "1";
    L20:
        String r120 = p0.d(r116, "gpsOn", r119);
        ProductSelectPoiInfo r121 = d1.f45575a;
        Context r122 = null;
        if (r121 == null) goto L23;
        String r123 = r121.getPoiId();
    L24:
        if (r123 != null) goto L31;
        AnchorV4CarAddressMeta r124 = this.f168077a;
        if (r124 == null) goto L30;
        AnchorV4CarAddressBusinessMeta r125 = r124.getBusinessMeta();
        if (r125 == null) goto L30;
        r123 = r125.getSelectedShopId();
    L30:
        r123 = null;
    L31:
        if (r123 != null) goto L33;
        r123 = "";
    L33:
        String r126 = p0.d(r120, "selectedShopId", r123);
        Context r127 = this.f168078b;
        if ((r127 instanceof Activity) == false) goto L37;
        r122 = r127;
    L37:
        Activity r128 = (Activity) r122;
        if (r128 == null) goto L40;
        r.a(r126, r128);
    L40:
        f.a.a(this.f168079c, "click_offline_store_entrance", null, false, null, null, null, null, 254);
        return;
    L23:
        r123 = null;
        goto L24
    L19:
        r119 = "0";
        goto L20
    L45:
        return;
    L44:
        return;
    L43:
        return;
    }
}
