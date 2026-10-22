package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.opt.session.ECPerfSessionManager;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(name = "ec.readPerfSession")
public final class i extends c {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public i() {
    }

    public static void b(bm.a r100, CompletionBlock r101) {
        XBaseModel r102 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC0800c.class));
        c.InterfaceC0800c r103 = (c.InterfaceC0800c) r102;
        r103.setCommon(r100.f19537a);
        LinkedHashMap<String, bm.b> r104 = r100.f19539c;
        if (r104 == null) goto L8;
        ArrayList r105 = new ArrayList(r104.size());
        Iterator<Map.Entry<String, bm.b>> r106 = r104.entrySet().iterator();
    L6:
        if (r106.hasNext() == false) goto L9;
        r105.add(r106.next().getValue().b());
    L9:
        r103.setStages(r105);
        Unit r107 = Unit.INSTANCE;
        CompletionBlock.DefaultImpls.onSuccess$default(r101, (XBaseResultModel) r102, null, 2, null);
        return;
    L8:
        r105 = null;
        goto L9
    }

    public final void a(String r100, CompletionBlock<c.InterfaceC0800c> r101) {
        r101.onFailure(0, r100, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC0800c.class)));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        c.b r103 = (c.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getSessionId();
        String r105 = r103.getStage();
        if (StringsKt.isBlank(r104) == false) goto L26;
        a("invalid session id", r102);
        return;
    L26:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L20
        if (r105 != null) goto L8;
    L11:
        boolean r107 = true;
    L12:
        if (r107 == false) goto L14;
        bm.a r108 = ECPerfSessionManager.f48098d.b(r104);     // Catch: Throwable -> L20
    L15:
        if (r108 != null) goto L17;
        a("no session info", r102);     // Catch: Throwable -> L20
    L18:
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L29;
        a("read session fail: " + r110.getMessage(), r102);
        return;
    L29:
        return;
    L17:
        b(r108, r102);     // Catch: Throwable -> L20
        goto L18
    L14:
        r108 = ECPerfSessionManager.f48098d.c(r104, r105);     // Catch: Throwable -> L20
        goto L15
    L8:
        if (StringsKt.isBlank(r105) == true) goto L11;
        r107 = false;
    L20:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    }
}
