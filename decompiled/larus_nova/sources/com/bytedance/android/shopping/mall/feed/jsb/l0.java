package com.bytedance.android.shopping.mall.feed.jsb;

import android.content.Context;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.common.DeliveryInterceptDialog;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class l0 extends qf3.e {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return "mall.showDeliveryDialog";
    }

    public l0(qf3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        super(r100);
    }

    @Override // qf3.e, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Object r103 = r101.get("mainTip");
        Object r104 = null;
        if ((r103 instanceof String) == true) goto L5;
        r103 = null;
    L5:
        String r105 = (String) r103;
        Object r106 = r101.get("subTip");
        if ((r106 instanceof String) == true) goto L8;
        r106 = null;
    L8:
        String r107 = (String) r106;
        Object r108 = r101.get("dismissBtnText");
        if ((r108 instanceof String) == true) goto L11;
        r108 = null;
    L11:
        String r109 = (String) r108;
        Object r110 = r101.get("confirmBtnText");
        if ((r110 instanceof String) == true) goto L14;
        r110 = null;
    L14:
        String r111 = (String) r110;
        Object r112 = r101.get("chatGroupUrl");
        if ((r112 instanceof String) == false) goto L18;
        r104 = r112;
    L18:
        String r113 = (String) r104;
        int r114 = com.bytedance.android.shopping.api.mall.common.tools.w.f170468a;
        Context r115 = this.f532724c.f532722a;
        com.bytedance.android.shopping.api.mall.common.tools.l.f170445a.getClass();
        if (HybridAppInfoService.f47545p.isLocalTest() == false) goto L26;
        if (r115 == null) goto L26;
        DeliveryInterceptDialog r116 = new DeliveryInterceptDialog(r115);
        if (DialogLancet.shouldBlockDialogShow(r116) == false) goto L29;
        DialogLancet.handleBlockedDialogShow(r116);
        goto L26
    L29:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
    L25:
        DialogLancet.beforeDialogShow(r116);
        r116.show();
        DialogLancet.afterDialogShow(r116);
    L26:
        LinkedHashMap r117 = new LinkedHashMap();
        r117.put("code", 1);
        r117.put("msg", "success");
        r102.invoke(r117);
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r100, IBDXBridgeContext r101, Map<String, ? extends Object> r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "result");
        return TuplesKt.to(Boolean.TRUE, null);
    }
}
