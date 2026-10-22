package af7;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowInsetsController;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.getStatusStyleMode")
public final class h extends a {
    public h() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((a.b) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Activity r103 = r100.getOwnerActivity();
        if (r103 == null) goto L5;
        Window r104 = r103.getWindow();
    L6:
        if (r104 != null) goto L9;
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, "window is null", null, 4, null);
        return;
    L9:
        if (Build.VERSION.SDK_INT < 30) goto L22;
        WindowInsetsController r105 = r104.getInsetsController();
        if (r105 != null) goto L13;
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, "wic is null", null, 4, null);
        return;
    L13:
        if ((r105.getSystemBarsAppearance() & 8) == 0) goto L15;
        boolean r106 = true;
    L16:
        XBaseModel r107 = ne7.e.c(Reflection.getOrCreateKotlinClass(a.c.class));
        a.c r108 = (a.c) r107;
        if (r106 == false) goto L19;
        String r109 = "dark";
    L20:
        r108.setStatusFontMode(r109);
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) r107, null, 2, null);
        return;
    L19:
        r109 = "light";
        goto L20
    L15:
        r106 = false;
        goto L16
    L22:
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, "Build.VERSION.SDK_INT < Build.VERSION_CODES.R", null, 4, null);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
