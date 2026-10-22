package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.opt.session.ECPerfSessionManager;
import com.bytedance.android.ec.opt.session.model.StageType;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(name = "ec.writePerfSession")
public final class j extends e {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public j() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        e.b r103 = (e.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L17
        String r105 = r103.getSessionId();     // Catch: Throwable -> L17
        String r106 = r103.getStage();     // Catch: Throwable -> L17
        if (StringsKt.isBlank(r105) == false) goto L6;
    L15:
        r102.onFailure(0, "invalid id or stage", (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(e.c.class)));     // Catch: Throwable -> L17
        return;
    L6:
        if (StringsKt.isBlank(r106) == true) goto L15;
        String r107 = r103.getTimestamp();     // Catch: Throwable -> L17
        if (r107 != null) goto L11;
        r107 = "0";
    L11:
        String r108 = r103.getStageType();     // Catch: Throwable -> L17
        Map<String, ? extends Object> r109 = r103.getStageData();     // Catch: Throwable -> L17
        bm.b r110 = new bm.b(r106, r107);     // Catch: Throwable -> L17
        StageType.Companion.getClass();     // Catch: Throwable -> L17
        StageType r111 = StageType.a.a(r108);     // Catch: Throwable -> L17
        if (r111 != null) goto L14;
        r111 = StageType.NORMAL;     // Catch: Throwable -> L17
    L14:
        Intrinsics.checkNotNullParameter(r111, "<set-?>");     // Catch: Throwable -> L17
        r110.f19540a = r111;     // Catch: Throwable -> L17
        r110.update(r109);     // Catch: Throwable -> L17
        ECPerfSessionManager.f48098d.d(r105, r106, r110);     // Catch: Throwable -> L17
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(e.c.class)), null, 2, null);     // Catch: Throwable -> L17
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L24;
        r102.onFailure(0, "write session fail: " + r113.getMessage(), (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(e.c.class)));
        return;
    L24:
        return;
    L17:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }
}
