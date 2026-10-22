package af7;

import com.bytedance.android.anniex.container.AnnieXContainer;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.showLoading")
public final class o extends e {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return false;
    }

    public o() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        e.b r113 = (e.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r114 = r113.getText();
        ia.c r100 = com.bytedance.android.anniex.lite.utils.c.f(r110);
        Unit r101 = null;
        if (r100 == null) goto L5;
        r100.showLoading(r114);
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) ne7.e.b(e.c.class), null, 2, null);
        return;
    L5:
        ia.c r102 = com.bytedance.android.anniex.lite.utils.c.e(r110);
        if (r102 == null) goto L8;
        r102.showLoading(r114);
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) ne7.e.b(e.c.class), null, 2, null);
        return;
    L8:
        m16.b r103 = (m16.b) r110.getService(m16.b.class);
        if (r103 == null) goto L13;
        ia.c r104 = (ia.c) r103.c(ia.c.class);
        if ((r104 instanceof AnnieXContainer) == false) goto L13;
    L14:
        if (r104 == null) goto L16;
        r104.showLoading(r114);
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) ne7.e.b(e.c.class), null, 2, null);
        return;
    L16:
        IHostStyleUIDepend r115 = com.bytedance.sdk.xbridge.cn.utils.g.h(r110);
        if (r115 == null) goto L21;
        Boolean r116 = r115.showLoading(r110);
        if (r116 == null) goto L21;
        r116.booleanValue();
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) ne7.e.b(e.c.class), null, 2, null);
        r101 = Unit.INSTANCE;
    L21:
        if (r101 != null) goto L27;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, null, null, 6, null);
        return;
    L27:
        return;
    L13:
        r104 = null;
        goto L14
    }
}
