package com.bytedance.android.shopping.mall.homepage.jsb;

import com.bytedance.android.shopping.api.mall.IECMallAddressService;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class k extends qf3.a {

    public static final class a implements com.bytedance.android.shopping.api.mall.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDLXBridgeMethod.a f178204a;

        public a(IDLXBridgeMethod.a r100) {
            this.f178204a = r100;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return "ecSetAddress";
    }

    public k(qf3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        super(r100);
    }

    @Override // qf3.a
    public final void e(IBDXBridgeContext r100, qf3.d r101, Map<String, ? extends Object> r102, IDLXBridgeMethod.a r110) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        JSONObject r103 = new JSONObject(r102);
        boolean r104 = r103.optBoolean("is_session");
        int r105 = r103.optInt("source_type");
        JSONObject r106 = r103.optJSONObject("address");
        if (r106 != null) goto L5;
        r106 = new JSONObject();
    L5:
        JSONObject r107 = r106;
        JSONObject r108 = r103.optJSONObject("extra_params");
        if (r108 != null) goto L8;
        r108 = new JSONObject();
    L8:
        r108.optBoolean("sync_write");
        r108.optBoolean("save_current_address");
        r108.optBoolean("without_network");
        com.bytedance.android.shopping.api.mall.o r109 = new com.bytedance.android.shopping.api.mall.o();
        IECMallAddressService r111 = (IECMallAddressService) ServiceManager.get().getService(IECMallAddressService.class);
        if (r111 == null) goto L12;
        r111.setAddress(r107, r105, r104, new a(r110), r109);
        return;
    }
}
