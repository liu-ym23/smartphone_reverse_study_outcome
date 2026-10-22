package ara;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class t extends ua7.a<ua7.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f16064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock f16065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f16066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ bra.m.b f16067d;

    @Override // ua7.a
    public final void onResponse(ua7.b r110) {
        ua7.f r111 = (ua7.f) r110;
        bra.m.c r100 = (bra.m.c) XBridgeResultModelArguments.INSTANCE.createModel(bra.m.c.class);
        if (r111 == null) goto L5;
        String r101 = r111.f549267s;
    L6:
        r100.setType(r101);
        if (r111 != null) goto L9;
    L13:
        CompletionBlock r102 = this.f16065b;
        if (r111 == null) goto L18;
        String r103 = r111.f549255i;
        if (r103 == null) goto L18;
    L19:
        r102.onFailure(0, r103, r100);
        int r104 = a.f16045a;
        String r105 = this.f16064a.f20194a;
        long r106 = System.currentTimeMillis() - this.f16066c;
        if (r111 == null) goto L24;
        String r112 = r111.f549255i;
        if (r112 == null) goto L24;
        String r107 = r112;
    L25:
        JSONObject r113 = new JSONObject();
        r113.put("scene", this.f16067d.getScene());
        a.a(r105, r113.toString(), r107, r106, this.f16067d.getScene(), null, 96);
        return;
    L24:
        r107 = "";
    L18:
        r103 = "";
        goto L19
    L9:
        if (r111.f549249c != true) goto L13;
        if (r111.f549253g != 0) goto L13;
        CompletionBlock.DefaultImpls.onSuccess$default(this.f16065b, r100, null, 2, null);
        int r108 = a.f16045a;
        String r109 = this.f16064a.f20194a;
        long r114 = System.currentTimeMillis() - this.f16066c;
        JSONObject r115 = new JSONObject();
        r115.put("scene", this.f16067d.getScene());
        String r116 = r115.toString();
        JSONObject r117 = new JSONObject();
        r117.put("type", r111.f549267s);
        a.b(r109, r116, r117.toString(), r114, this.f16067d.getScene(), 96);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public t(s r100, CompletionBlock r101, long r102, bra.m.b r103) {
        this.f16064a = r100;
        this.f16065b = r101;
        this.f16066c = r102;
        this.f16067d = r103;
    }
}
