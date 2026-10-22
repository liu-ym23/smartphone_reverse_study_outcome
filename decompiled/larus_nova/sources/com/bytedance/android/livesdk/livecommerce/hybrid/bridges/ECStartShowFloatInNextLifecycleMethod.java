package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import android.app.Activity;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.j;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.plugin.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECStartShowFloatInNextLifecycleMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStartShowFloatInNextLifecycleMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f147838e;

    public ECStartShowFloatInNextLifecycleMethod() {
        this.f147838e = "ecStartShowFloatInNextLifecycle";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f147838e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        String r102 = r100.optString("request_page");
        int r103 = ECSdk.f48106a;
        IAdapterService r104 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r104 == null) goto L7;
        j r105 = r104.getLiveWindowService();
        if (r105 == null) goto L7;
        Activity r106 = e.getActivity(getContext());
        com.bytedance.android.ec.adapter.api.a r107 = new com.bytedance.android.ec.adapter.api.a();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r107.f42669a = r102;
        Unit r108 = Unit.INSTANCE;
        r105.e(r106, r107);
    L7:
        r101.onSuccess(null);
    }
}
