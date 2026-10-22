package com.bytedance.ai.bridge.method.payment;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.payment.payment.AbsDyPayMethodIDL;
import com.bytedance.ai.bridge.service.OnPayOrderResultCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements OnPayOrderResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h<ResultModel> f35782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DyPayMethod f35783b;

    @Override // com.bytedance.ai.bridge.service.OnPayOrderResultCallback
    public final void onSuccess() {
        com.bytedance.ai.utils.g.f37637a.i("AISDK_JSB_DyPayMethod", "call success");
        f3.h<ResultModel> r100 = this.f35782a;
        Intrinsics.checkNotNullParameter(AbsDyPayMethodIDL.c.class, "<this>");
        f3.h.a.b(r100, (ResultModel) k3.c.a(AbsDyPayMethodIDL.c.class));
    }

    public c(f3.h<ResultModel> r100, DyPayMethod r101) {
        this.f35782a = r100;
        this.f35783b = r101;
    }

    @Override // com.bytedance.ai.bridge.service.OnPayOrderResultCallback
    public final void onFailed(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "errorNo");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        DyPayMethod r102 = this.f35783b;
        f3.h<ResultModel> r103 = this.f35782a;
        int r104 = DyPayMethod.f35761b;
        f3.a r105 = f3.a.f475265f;
        r102.getClass();
        DyPayMethod.b(r103, r100, r101, r105);
    }
}
