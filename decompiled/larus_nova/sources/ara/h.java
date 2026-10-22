package ara;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class h extends va7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f16048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock f16049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f16050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ bra.i.b f16051d;

    @Override // sa7.h
    public final void onSuccess(ua7.b r100) {
        xa7.d r101 = (xa7.d) r100;
        CompletionBlock.DefaultImpls.onSuccess$default(this.f16049b, (XBaseResultModel) XBridgeResultModelArguments.INSTANCE.createModel(bra.i.c.class), null, 2, null);
        int r102 = a.f16045a;
        String r103 = this.f16048a.f20183a;
        long r104 = System.currentTimeMillis() - this.f16050c;
        JSONObject r105 = new JSONObject();
        r105.put("scene", this.f16051d.getScene());
        a.b(r103, r105.toString(), null, r104, null, 116);
    }

    @Override // sa7.h
    public final void onError(ua7.b r110, int r111) {
        xa7.d r112 = (xa7.d) r110;
        CompletionBlock r100 = this.f16049b;
        if (r112 == null) goto L7;
        String r101 = r112.f549255i;
        if (r101 == null) goto L7;
    L8:
        CompletionBlock.DefaultImpls.onFailure$default(r100, 0, r101, null, 4, null);
        int r102 = a.f16045a;
        String r103 = this.f16048a.f20183a;
        long r104 = System.currentTimeMillis() - this.f16050c;
        if (r112 == null) goto L13;
        String r113 = r112.f549255i;
        if (r113 == null) goto L13;
        String r105 = r113;
    L14:
        JSONObject r114 = new JSONObject();
        r114.put("scene", this.f16051d.getScene());
        a.a(r103, r114.toString(), r105, r104, null, null, 112);
        return;
    L13:
        r105 = "";
    L7:
        r101 = "";
        goto L8
    }

    public h(i r100, CompletionBlock r101, long r102, bra.i.b r103) {
        this.f16048a = r100;
        this.f16049b = r101;
        this.f16050c = r102;
        this.f16051d = r103;
    }
}
