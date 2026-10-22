package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECOrderBatchAddAndTriggerPreloadTasksMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECOrderBatchAddAndTriggerPreloadTasksMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f44124e;

    public ECOrderBatchAddAndTriggerPreloadTasksMethod() {
        this.f44124e = "ec.order.batchAddAndTriggerPreloadTasks";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f44124e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        int r102 = ECSdk.f48106a;
        IEShoppingService r103 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r103 == null) goto L7;
        sc3.h r104 = r103.getOrderListService();
        if (r104 == null) goto L7;
        r104.a(r100);
    L7:
        JSONObject r105 = new JSONObject();
        r105.put("code", 1);
        Unit r106 = Unit.INSTANCE;
        r101.a(r105);
    }
}
