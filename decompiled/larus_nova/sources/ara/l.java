package ara;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class l implements j.a.InterfaceC0214a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock f16063a;

    public l(CompletionBlock r100) {
        this.f16063a = r100;
    }

    @Override // ara.j.a.InterfaceC0214a
    public final void a(xa7.c r100) {
        CompletionBlock r101 = this.f16063a;
        XBaseModel r102 = XBridgeResultModelArguments.INSTANCE.createModel(bra.a.b.class);
        bra.a.b r103 = (bra.a.b) r102;
        if (r100 == null) goto L9;
        JSONObject r104 = r100.f549259m;
        if (r104 == null) goto L9;
        String r105 = r104.toString();
        if (r105 == null) goto L9;
    L10:
        r103.setResponse(r105);
        r103.setStatus(200);
        if (r100 == null) goto L13;
        String r106 = r100.f549247a;
    L14:
        r103.setLogId(r106);
        CompletionBlock.DefaultImpls.onSuccess$default(r101, (XBaseResultModel) r102, null, 2, null);
        return;
    L13:
        r106 = null;
    L9:
        r105 = "";
        goto L10
    }
}
