package com.bytedance.android.shopping.mall.homepage.jsb;

import com.bytedance.android.shopping.api.mall.IECMallShareService;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class l extends qf3.a {

    public static final class a implements com.bytedance.android.shopping.api.mall.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IDLXBridgeMethod.a f178205a;

        public a(IDLXBridgeMethod.a r100) {
            this.f178205a = r100;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return "share";
    }

    public l(qf3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        super(r100);
    }

    @Override // qf3.a
    public final void e(IBDXBridgeContext r100, qf3.d r101, Map<String, ? extends Object> r102, IDLXBridgeMethod.a r103) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "callback");
        ServiceManager r104 = ServiceManager.get();
        if (r104 == null) goto L8;
        IECMallShareService r105 = (IECMallShareService) r104.getService(IECMallShareService.class);
        if (r105 == null) goto L9;
        r105.directJsbShare(r101.f532722a, com.bytedance.android.ec.hybrid.list.util.k.b(r102), new a(r103));
        return;
    L9:
        return;
    }
}
