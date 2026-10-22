package cf7;

import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "pia.rendering.execute")
public final class e extends b {
    public e() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        b.InterfaceC0442b r113 = (b.InterfaceC0442b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r100 = r113.getUrl();
        if (r100 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, null, null, 6, null);
        return;
    L5:
        m16.b r114 = (m16.b) r110.getService(m16.b.class);
        if (r114 == null) goto L12;
        BulletContext r115 = (BulletContext) r114.c(BulletContext.class);
        if (r115 == null) goto L12;
        String r116 = r115.f246438f;
        if (r116 == null) goto L12;
    L13:
        Map<String, com.bytedance.ies.bullet.web.pia.c.a> r101 = com.bytedance.ies.bullet.web.pia.c.f248301a;
        Map<String, Object> r117 = r113.getContext();
        c r102 = new c(r112);
        d r103 = new d(r112);
        Intrinsics.checkNotNullParameter(r116, "bid");
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r102, JSEventListener.ACTION_RESOLVE);
        Intrinsics.checkNotNullParameter(r103, "reject");
        k47.d r104 = (k47.d) c47.b.b(k47.d.class);
        if (r104 != null) goto L16;
        r103.accept(new PiaMethod.Error("IPiaRenderingService isn't implemented"));
        return;
    L16:
        String r105 = com.bytedance.ies.bullet.web.pia.c.c(r116);
        if (r117 != null) goto L19;
        Map<String, Object> r106 = new HashMap();
    L20:
        r104.b(r100, r105, r106, r102, r103);
        return;
    L19:
        r106 = r117;
    L12:
        r116 = "default_bid";
        goto L13
    }
}
