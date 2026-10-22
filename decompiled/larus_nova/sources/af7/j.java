package af7;

import android.view.View;
import com.bytedance.ies.bullet.preloadv2.PreloadV2;
import com.bytedance.ies.bullet.ui.common.BulletCardView;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.reloadView")
public final class j extends c {
    public j() {
        ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, id7.b> r100 = id7.e.f489350a;
        id7.e.a(j.class, new id7.b(c.b.class, c.InterfaceC0062c.class));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter((c.b) r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        View r113 = r110.getEngineView();
        if (r113 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "can not get engine view", null, 4, null);
        return;
    L5:
        ia.c r114 = com.bytedance.android.anniex.lite.utils.c.f(r110);
        if (r114 == null) goto L9;
        r114.reload(null);
        XBaseModel r115 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC0062c.class));
        c.InterfaceC0062c r116 = (c.InterfaceC0062c) r115;
        r116.setCode(1);
        r116.setMsg("success");
        r112.onSuccess((XBaseResultModel) r115, "success");
        return;
    L9:
        if ((r113 instanceof BulletCardView) == true) goto L15;
        if (r113 == null) goto L15;
        Object r117 = r113.getParent();
        if ((r117 instanceof View) == true) goto L13;
        r113 = null;
        goto L9
    L13:
        r113 = (View) r117;
    L15:
        if (r113 != null) goto L17;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "can not get bullet view", null, 4, null);
        return;
    L17:
        boolean r118 = PreloadV2.f247628a;
        PreloadV2.e(true, "x.reloadView");
        int r119 = z16.a.f569669e;
        z16.a r120 = z16.a.b.f569674a;
        r120.f569672c.clear();
        z16.b r100 = r120.f569671b;
        if (r100 == null) goto L20;
        r100.evictAll();
    L20:
        z16.c r101 = r120.f569670a;
        if (r101 == null) goto L23;
        r101.evictAll();
    L23:
        r120.f569673d.clear();
        ((BulletCardView) r113).yc();
        r112.onSuccess((XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC0062c.class)), "success");
    }
}
