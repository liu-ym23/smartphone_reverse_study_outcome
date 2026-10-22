package af7;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.DialogBuilder;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.showModal")
public final class s extends f {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return false;
    }

    public s() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        f.b r100 = (f.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Map<String, Map<Class<?>, Object>> r101 = x26.a.f562251a;
        w26.g r102 = (w26.g) x26.a.a(w26.g.class);
        boolean r103 = true;
        if (r102 == null) goto L7;
        w26.e r104 = (w26.e) r102.n0(w26.e.class);
        if (r104 == null) goto L7;
        boolean r105 = r104.L0();
    L8:
        Boolean r106 = null;
        if (r105 == false) goto L20;
        m16.b r107 = (m16.b) r110.getService(m16.b.class);
        if (r107 == null) goto L13;
        Context r108 = (Context) r107.c(Context.class);
    L15:
        if ((r108 instanceof Activity) == false) goto L17;
        Activity r109 = (Activity) r108;
    L18:
        if (r109 != null) goto L21;
        r109 = r110.getOwnerActivity();
    L21:
        Activity r113 = r109;
        if (r113 != null) goto L24;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
        return;
    L24:
        boolean r114 = r100.getTapMaskToDismiss();
        String r115 = r100.getConfirmText();
        if (r115 != null) goto L27;
    L32:
        boolean r116 = false;
    L33:
        if (r116 == false) goto L35;
        String r117 = r100.getConfirmText();
    L36:
        String r118 = r117;
        String r119 = r100.getContent();
        String r120 = r100.getTitle();
        r r121 = new r(r112);
        if (r100.getShowCancel() == false) goto L51;
        String r122 = r100.getCancelText();
        if (r122 != null) goto L41;
    L46:
        r103 = false;
    L47:
        if (r103 == false) goto L49;
        String r123 = r100.getCancelText();
    L50:
        String r124 = r123;
        p r125 = new p(r112);
    L52:
        if (r114 == false) goto L54;
        q r126 = new q(r112);
    L55:
        DialogBuilder r127 = new DialogBuilder(r113, r120, r119, r118, r121, r124, r125, r126, r114);
        IHostStyleUIDepend r128 = com.bytedance.sdk.xbridge.cn.utils.g.h(r110);
        if (r128 == null) goto L59;
        r106 = r128.showDialog(r127);
    L59:
        if (Intrinsics.areEqual(r106, Boolean.TRUE) == true) goto L63;
        Intrinsics.checkNotNullParameter(r127, "dialogBuilder");
        Intrinsics.checkNotNullParameter(r127, "dialogBuilder");
        return;
    L63:
        return;
    L54:
        r126 = null;
        goto L55
    L49:
        r123 = "cancel";
        goto L50
    L41:
        if (r122.length() <= 0) goto L43;
        boolean r129 = true;
    L44:
        if (r129 != true) goto L46;
    L43:
        r129 = false;
        goto L44
    L51:
        r124 = null;
        r125 = null;
        goto L52
    L35:
        r117 = "confirm";
        goto L36
    L27:
        if (r115.length() <= 0) goto L29;
        boolean r130 = true;
    L30:
        if (r130 != true) goto L32;
        r116 = true;
        goto L33
    L29:
        r130 = false;
        goto L30
    L17:
        r109 = null;
        goto L18
    L13:
        r108 = null;
        goto L15
    L20:
        r109 = r110.getOwnerActivity();
    L7:
        r105 = true;
        goto L8
    }
}
