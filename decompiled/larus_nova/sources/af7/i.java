package af7;

import com.bytedance.android.anniex.container.AnnieXContainer;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.hideLoading")
public final class i extends b {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return false;
    }

    public i() {
        ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, id7.b> r100 = id7.e.f489350a;
        id7.e.a(i.class, new id7.b(b.InterfaceC0061b.class, b.c.class));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r110, CompletionBlock r111) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((b.InterfaceC0061b) r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        ia.c r112 = com.bytedance.android.anniex.lite.utils.c.f(r100);
        Unit r101 = null;
        if (r112 == null) goto L5;
        r112.hideLoading();
        CompletionBlock.DefaultImpls.onSuccess$default(r111, (XBaseResultModel) ne7.e.b(b.c.class), null, 2, null);
        return;
    L5:
        ia.c r113 = com.bytedance.android.anniex.lite.utils.c.e(r100);
        if (r113 == null) goto L8;
        r113.hideLoading();
        CompletionBlock.DefaultImpls.onSuccess$default(r111, (XBaseResultModel) ne7.e.b(b.c.class), null, 2, null);
        return;
    L8:
        m16.b r114 = (m16.b) r100.getService(m16.b.class);
        if (r114 == null) goto L13;
        ia.c r115 = (ia.c) r114.c(ia.c.class);
        if ((r115 instanceof AnnieXContainer) == false) goto L13;
    L14:
        if (r115 == null) goto L16;
        r115.hideLoading();
        CompletionBlock.DefaultImpls.onSuccess$default(r111, (XBaseResultModel) ne7.e.b(b.c.class), null, 2, null);
        return;
    L16:
        IHostStyleUIDepend r116 = com.bytedance.sdk.xbridge.cn.utils.g.h(r100);
        if (r116 == null) goto L21;
        Boolean r102 = r116.hideLoading(r100);
        if (r102 == null) goto L21;
        r102.booleanValue();
        CompletionBlock.DefaultImpls.onSuccess$default(r111, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class)), null, 2, null);
        r101 = Unit.INSTANCE;
    L21:
        if (r101 != null) goto L27;
        CompletionBlock.DefaultImpls.onFailure$default(r111, 0, null, null, 6, null);
        return;
    L27:
        return;
    L13:
        r115 = null;
        goto L14
    }
}
