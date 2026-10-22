package af7;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.showKeyBoardForWeb")
public final class n extends defpackage.g {
    public n() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r110, CompletionBlock r111) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((g.b) r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        View r101 = r100.getEngineView();
        if (r101 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r111, 0, "engineView is null", null, 4, null);
        return;
    L5:
        Object r112 = r101.getContext().getSystemService("input_method");
        if ((r112 instanceof InputMethodManager) == false) goto L8;
        InputMethodManager r113 = (InputMethodManager) r112;
    L9:
        boolean r102 = r101.requestFocusFromTouch();
        boolean r103 = false;
        if (r113 != null) goto L12;
    L14:
        if (r102 == false) goto L18;
        if (r103 == false) goto L18;
        CompletionBlock.DefaultImpls.onSuccess$default(r111, (XBaseResultModel) ne7.e.b(g.c.class), null, 2, null);
        return;
    L18:
        CompletionBlock.DefaultImpls.onFailure$default(r111, 0, "show keyBoard fail", null, 4, null);
        return;
    L12:
        if (r113.showSoftInput(r101, 0) != true) goto L14;
        r103 = true;
        goto L14
    L8:
        r113 = null;
        goto L9
    }
}
