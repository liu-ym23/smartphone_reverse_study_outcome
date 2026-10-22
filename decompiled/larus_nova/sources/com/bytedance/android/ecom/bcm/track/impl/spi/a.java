package com.bytedance.android.ecom.bcm.track.impl.spi;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.inner.g;
import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import java.util.Map;
import kc.d;
import kc.e;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements d {
    public a() {
    }

    @Override // kc.d
    public final void a(final String r100, String r101, e r110) {
        Map<String, BcmParams> r102 = r110.f502371d;
        if (r102 == null) goto L13;
        BcmParams r103 = r102.get("ecom_entrance");
        if (r103 == null) goto L7;
        Object r104 = r103.opt(com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE);
    L8:
        if (r104 != null) goto L10;
        return;
    L10:
        if (StringsKt.endsWith$default(r101, ".c0.d0", false, 2, null) == false) goto L15;
        g.a.a(BtmMonitor.f42161c, 6003, "页面参数: " + r110.f502370c + "\n点位参数：" + r102, null, new BcmExtraCheckerProviderImpl$getExtraChecker$1$check$1(r100), 28);
        return;
    L15:
        return;
    L7:
        r104 = null;
        goto L8
    }
}
