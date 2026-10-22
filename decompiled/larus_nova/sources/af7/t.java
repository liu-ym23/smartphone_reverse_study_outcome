package af7;

import android.app.Activity;
import android.widget.Toast;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ToastBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.showToast")
public final class t extends g {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return false;
    }

    public t() {
    }

    public static void a(IBDXBridgeContext r100, g.b r110, CompletionBlock r111) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Activity r101 = r100.getOwnerActivity();
        if (r101 != null) goto L7;
        r111.onFailure(0, "context not provided in host", (XBaseResultModel) ne7.e.b(g.c.class));
        return;
    L7:
        if (r110.getType() != null) goto L13;
        if (r110.getIcon() != null) goto L13;
        CompletionBlock.DefaultImpls.onFailure$default(r111, -3, "either type or icon should have value", null, 4, null);
        return;
    L13:
        if (r110.getMessage().length() != 0) goto L15;
        boolean r102 = true;
    L16:
        if (r102 == false) goto L19;
        CompletionBlock.DefaultImpls.onFailure$default(r111, -3, "message can not be empty", null, 4, null);
        return;
    L19:
        Number r103 = r110.getDuration();
        if (r103 == null) goto L22;
        int r104 = r103.intValue();
    L23:
        ToastBuilder r105 = new ToastBuilder(r101, r110.getMessage(), r110.getType(), Integer.valueOf(r104), r110.getIcon(), r110.getCustomIcon());
        r105.setExt(r110.getExt());
        IHostStyleUIDepend r106 = com.bytedance.sdk.xbridge.cn.utils.g.h(r100);
        if (r106 == null) goto L26;
        Boolean r107 = r106.showToast(r105);
    L28:
        if (Intrinsics.areEqual(r107, Boolean.TRUE) == true) goto L30;
        Intrinsics.checkNotNullParameter(r105, "toastBuilder");
        Toast.makeText(r105.getContext(), r105.getMessage(), 0).show();
    L30:
        CompletionBlock.DefaultImpls.onSuccess$default(r111, (XBaseResultModel) ne7.e.b(g.c.class), null, 2, null);
        return;
    L26:
        r107 = null;
        goto L28
    L22:
        r104 = 3000;
        goto L23
    L15:
        r102 = false;
        goto L16
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final /* bridge */ /* synthetic */ void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        a(r100, (g.b) r101, r102);
    }
}
