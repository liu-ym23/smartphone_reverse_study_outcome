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
public final class d implements AuthorizeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock f16047a;

    public d(CompletionBlock r100) {
        this.f16047a = r100;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onError(AuthorizeErrorResponse r100) {
        CompletionBlock r101 = this.f16047a;
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
        CompletionBlock.DefaultImpls.onFailure$default(this.f16047a, 0, "result bundle is null", null, 4, null);
        return;
    L4:
        String r101 = r100.getString("access_token");
        String r102 = r100.getString(IOnekeyLoginService.ResponseConstants.CARRIER_FROM);
        String r103 = r100.getString("carrier_app_id");
        CompletionBlock r104 = this.f16047a;
        XBaseModel r105 = XBridgeResultModelArguments.INSTANCE.createModel(bra.f.c.class);
        bra.f.c r106 = (bra.f.c) r105;
        r106.setToken(r101);
        r106.setCarrier(r102);
        r106.setAppId(r103);
        CompletionBlock.DefaultImpls.onSuccess$default(r104, (XBaseResultModel) r105, null, 2, null);
    }
}
