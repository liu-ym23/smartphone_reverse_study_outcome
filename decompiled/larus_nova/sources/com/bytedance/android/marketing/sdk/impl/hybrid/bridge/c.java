package com.bytedance.android.marketing.sdk.impl.hybrid.bridge;

import android.content.Context;
import android.view.View;
import com.bytedance.android.marketing.sdk.api.IMarketingBridgeService;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import fx2.i;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@XBridgeMethod(name = "requestECMarketingBridge", owner = "liushuai.16")
public final class c extends a {
    public c() {
    }

    @Override // v56.c
    public final void e(XBaseParamModel r100, final v56.a r101, XBridgePlatformType r110) {
        a.b r102 = (a.b) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r110, "type");
        Object r111 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        int r104 = i.f479108a;     // Catch: Throwable -> L5
        Object r105 = Result.m9449constructorimpl(null);     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r105) == false) goto L10;
        r105 = null;
    L10:
        View r106 = (View) r105;
        Context r107 = (Context) g(Context.class);
        Object r108 = r102.getParams();
        if ((r108 instanceof Map) == false) goto L14;
        r111 = r108;
    L14:
        Map<String, ? extends Object> r109 = (Map) r111;
        IMarketingBridgeService r112 = (IMarketingBridgeService) ServiceManager.get().getService(IMarketingBridgeService.class);
        if (r112 == null) goto L20;
        r112.b(r102.getAction(), r109, r106, r107, new RequestMarketingBridgeMethod$handle$1(this, r101));
        return;
    L20:
        return;
    L5:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
