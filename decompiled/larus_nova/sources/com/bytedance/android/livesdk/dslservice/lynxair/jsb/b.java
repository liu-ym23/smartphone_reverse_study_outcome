package com.bytedance.android.livesdk.dslservice.lynxair.jsb;

import android.view.View;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.live.core.setting.n0;
import com.bytedance.android.livesdk.dslservice.lynxair.h;
import com.bytedance.android.livesdk.dslservice.util.m;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ne7.e;
import yt1.i;

/* JADX INFO: loaded from: classes8.dex */
@XBridgeMethod(name = "liveDSLAction")
public final class b extends a {
    public b() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        a.b r113 = (a.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        final String r100 = r113.getType();
        m r101 = m.f123003h;
        r101.d(new LynxAirHandleDslAction$handle$1(r100));
        c r102 = (c) r110.getService(c.class);
        if (Intrinsics.areEqual(n0.f65363a.getValue(), Boolean.TRUE) == false) goto L15;
        View r103 = r110.getEngineView();
        if ((r103 instanceof AnnieXLynxView) == true) goto L7;
        r103 = null;
    L7:
        AnnieXLynxView r104 = (AnnieXLynxView) r103;
        final Map r105 = MapsKt.toMap(r113.getFields());
        IAction r106 = new LynxAirHandleDslAction$createAction$1(r105, r100);
        if (r104 == null) goto L15;
        if (r102 == null) goto L15;
        i r107 = r102.f122885a;
        if (r107 == null) goto L15;
        Intrinsics.checkNotNullParameter(r104, "$this$toDSLCardHolder");
        if (r107.a(r106, r104, new h(r104)) != true) goto L15;
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) e.c(Reflection.getOrCreateKotlinClass(a.c.class)), null, 2, null);
        return;
    L15:
        if (r102 == null) goto L17;
        List<yt1.h> r108 = r102.f122886b;
    L18:
        if (r108 != null) goto L20;
        r101.d(LynxAirHandleDslAction$handle$2.INSTANCE);
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, null, null, 6, null);
        return;
    L20:
        Iterator<T> r109 = r108.iterator();
    L22:
        if (r109.hasNext() == false) goto L29;
        Object r114 = r109.next();
        yt1.h r115 = (yt1.h) r114;
        String r116 = r115.a();
        if (r116 != null) goto L27;
        r116 = r115.getName().getText();
    L27:
        if (Intrinsics.areEqual(r116, r100) == false) goto L22;
    L30:
        yt1.h r117 = (yt1.h) r114;
        if (r117 != null) goto L34;
        m.f123003h.d(new LynxAirHandleDslAction$handle$3(r100));
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, null, null, 6, null);
        return;
    L34:
        if (r110.getPlatformType() != PlatformType.LYNX) goto L43;
        MapsKt.toMap(r113.getFields());
        Map r118 = MapsKt.toMap(r113.getFields());
        View r119 = r110.getEngineView();
        if ((r119 instanceof AnnieXLynxView) == true) goto L38;
        r119 = null;
    L38:
        AnnieXLynxView r120 = (AnnieXLynxView) r119;
        if (r120 == null) goto L41;
        Intrinsics.checkNotNullParameter(r120, "$this$toDSLCardHolder");
        h r121 = new h(r120);
    L42:
        r117.b(r118, r121);
        goto L43
    L41:
        r121 = null;
    L43:
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) e.c(Reflection.getOrCreateKotlinClass(a.c.class)), null, 2, null);
        return;
    L29:
        r114 = null;
        goto L30
    L17:
        r108 = null;
        goto L18
    }
}
