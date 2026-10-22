package ara;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements AuthorizeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock f16046a;

    public b(CompletionBlock r100) {
        this.f16046a = r100;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onError(AuthorizeErrorResponse r100) {
        CompletionBlock r101 = this.f16046a;
        if (r100 == null) goto L7;
        String r102 = r100.platformErrorMsg;
        if (r102 == null) goto L7;
    L8:
        CompletionBlock.DefaultImpls.onFailure$default(r101, 0, r102, null, 4, null);
        return;
    L7:
        r102 = "";
        goto L8
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onSuccess(Bundle r100) {
        if (r100 != null) goto L4;
        CompletionBlock.DefaultImpls.onFailure$default(this.f16046a, 0, "result bundle is null", null, 4, null);
        return;
    L4:
        String r101 = r100.getString(IOnekeyLoginService.ResponseConstants.SECURITY_PHONE);
        String r102 = r100.getString(IOnekeyLoginService.ResponseConstants.CARRIER_FROM);
        CompletionBlock r103 = this.f16046a;
        XBaseModel r104 = XBridgeResultModelArguments.INSTANCE.createModel(bra.e.c.class);
        bra.e.c r105 = (bra.e.c) r104;
        r105.setPhone(r101);
        r105.setCarrier(r102);
        CompletionBlock.DefaultImpls.onSuccess$default(r103, (XBaseResultModel) r104, null, 2, null);
    }
}
