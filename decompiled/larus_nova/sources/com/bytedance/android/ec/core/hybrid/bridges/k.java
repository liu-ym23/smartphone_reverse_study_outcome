package com.bytedance.android.ec.core.hybrid.bridges;

import bolts.Task;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(name = "ec.triggerPreProcessor")
public final class k extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f44172d = 0;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public k() {
    }

    public static void a(Integer r100, CompletionBlock r101) {
        if (r100 != null) goto L5;
    L7:
        XBaseModel r102 = ne7.e.b(d.c.class);
        d.c r103 = (d.c) r102;
        if (r100 != null) goto L10;
    L18:
        Unit r104 = Unit.INSTANCE;
        CompletionBlock.DefaultImpls.onSuccess$default(r101, (XBaseResultModel) r102, null, 2, null);
        return;
    L10:
        if (r100.intValue() <= 0) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == true) goto L16;
        r100 = null;
    L16:
        if (r100 == null) goto L18;
        r103.setSubCode(Integer.valueOf(r100.intValue()));
        goto L18
    L12:
        r105 = false;
        goto L13
    L5:
        if (r100.intValue() != (-100)) goto L7;
        CompletionBlock.DefaultImpls.onFailure$default(r101, 0, "url is empty", null, 4, null);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, final CompletionBlock r102) {
        d.b r103 = (d.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Number r104 = r103.getOptimization();
        Object r105 = null;
        if ((r104 instanceof Integer) == true) goto L5;
        r104 = null;
    L5:
        Integer r106 = (Integer) r104;
        int r107 = 0;
        if (r106 == null) goto L8;
        int r108 = r106.intValue();
    L9:
        Map<String, Object> r109 = r103.getData();
        Object r110 = r109.get("template_url");
        if ((r110 instanceof String) == true) goto L12;
        r110 = null;
    L12:
        String r111 = (String) r110;
        Object r112 = r109.get("na_prefetch_cert");
        if ((r112 instanceof String) == true) goto L15;
        r112 = null;
    L15:
        String r113 = (String) r112;
        Object r114 = r109.get("thread_strategy");
        if ((r114 instanceof Integer) == false) goto L19;
        r105 = r114;
    L19:
        Integer r115 = (Integer) r105;
        if (r115 == null) goto L22;
        r107 = r115.intValue();
    L22:
        bh.b r116 = new bh.b(r108);
        r116.f18989a = r111;
        r116.f18990b = r113;
        if (r107 != 0) goto L25;
        a(r116.b(), r102);
        return;
    L25:
        if (r107 == 1) goto L27;
        a(r116.b(), r102);
        return;
    L27:
        Function1<Integer, Unit> r117 = new ECTriggerPreProcessorXMethod$handle$1(this, r102);
        Intrinsics.checkNotNullParameter(r117, "callback");
        Task.callInBackground(new bh.a(r116, r117));
        return;
    L8:
        r108 = 0;
        goto L9
    }
}
