package cf7;

import android.view.View;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "pia.internal.trigger")
public final class h extends a {
    public h() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        a.b r102 = (a.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        View r103 = r100.getEngineView();
        if (r103 == null) goto L15;
        k47.a r104 = (k47.a) c47.b.b(k47.a.class);
        String r105 = r102.getName();
        Map<String, Object> r106 = r102.getData();
        if (r106 != null) goto L7;
    L10:
        boolean r107 = true;
    L11:
        if (r107 == false) goto L13;
        Object r108 = new JsonObject();
    L14:
        r104.call(r103, r105, r108, new f(r110), new g(r110));
        Unit r109 = Unit.INSTANCE;
    L16:
        if (r109 != null) goto L19;
        CompletionBlock.DefaultImpls.onFailure$default(r110, 0, "lack of engineView", null, 4, null);
        return;
    L19:
        return;
    L13:
        r108 = GsonProtectorUtils.toJsonTree(new Gson(), r102.getData());
        goto L14
    L7:
        if (r106.isEmpty() == true) goto L10;
        r107 = false;
        goto L11
    L15:
        r109 = null;
        goto L16
    }
}
