package com.bytedance.android.ecom.bcm.track.impl.mall;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.l;
import com.bytedance.android.ecom.bcm.track.api.p003const.AppendScene;
import com.bytedance.android.ecom.bcm.track.impl.setting.Setting;
import com.bytedance.android.ecom.bcm.track.impl.util.ChainUtils;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class d extends com.bytedance.android.ecom.bcm.track.impl.a {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // com.bytedance.android.ecom.bcm.track.impl.d
    public final void c(l r100, com.bytedance.android.ecom.bcm.track.impl.c r101, AppendScene r102) {
        if (Setting.f51149a.m().a() == 1) goto L5;
        return;
    L5:
        kc.a r103 = ChainUtils.b(ChainUtils.f51156a, r100, CollectionsKt.listOf("ecom_entrance"));
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.f502353a.isEmpty() == true) goto L36;
        Iterator<kc.a.C6534a> r104 = r103.f502353a.iterator();
    L12:
        if (r104.hasNext() == false) goto L37;
        kc.a.C6534a.C6535a r105 = r104.next().f502360g;
        if (r105 == null) goto L12;
        BcmParams r106 = r105.f502361a;
        if (r106 == null) goto L12;
        String r107 = BcmParams.optString$default(r106, "mall_from_purchase_order_id", null, 2, null);
        if (r107 != null) goto L20;
    L23:
        boolean r108 = true;
    L24:
        if (r108 == true) goto L12;
        r101.b("mall_from_purchase_order_id", r107);
        return;
    L20:
        if (r107.length() == 0) goto L23;
        r108 = false;
        goto L24
    L37:
        return;
    }
}
