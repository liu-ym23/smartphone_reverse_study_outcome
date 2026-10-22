package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.videosend.tools.VideoTools;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "ocrUploadPhoto")
public final class k2 extends com.bytedance.ies.web.jsbridge2.f<a, JSONObject> {

    public static final class a {

        @SerializedName(VideoTools.ERROR_TYPE_COMPRESS)
        public int compress;

        @SerializedName("params")
        public g2 params;

        @SerializedName("type")
        public String type;

        public a() {
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public k2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r100, CallContext r101) throws Exception {
        a r102 = r100;
        x80.b r103 = x80.c.a(0);
        v80.e.a r104 = new v80.e.a();
        r104.f553637a = r101.getContext();
        g2 r105 = r102.params;
        String r106 = null;
        if (r105 == null) goto L5;
        String r107 = r105.scene;
    L6:
        r104.f553638b = r107;
        if (r105 == null) goto L9;
        String r108 = r105.mode;
    L10:
        r104.f553642f = r108;
        if (r105 == null) goto L13;
        r106 = r105.ticket;
    L13:
        r104.f553641e = r106;
        r104.f553640d = r102.compress;
        r104.f553639c = r102.type;
        r104.f553643g = new j2(this);
        r103.f562883a.a(new v80.e(r104));
        return;
    L9:
        r108 = BytedCertConstant.CertKey.IDENTITY_CODE;
        goto L10
    L5:
        r107 = null;
        goto L6
    }
}
