package com.bytedance.android.livesdk.jsbridge.methods;

import android.os.Bundle;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.config.tj;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class i2 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f142139a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        this.f142139a.clear();
    }

    public i2() {
        this.f142139a = new CompositeDisposable();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r110) throws Exception {
        JSONObject r101 = r100;
        if (r101 != null) goto L5;
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(-1000, "ocr service proxy is unavaliable"));
        return;
    L5:
        Bundle r102 = new Bundle();
        Iterator<String> r103 = r101.keys();
        v80.d.a r104 = new v80.d.a();
        r104.f553619a = r110.getContext();
        tj.f121303a.getValue().getClass();
        HashMap r111 = null;
    L6:
        byte r105 = 1;
        if (r103.hasNext() == false) goto L95;
        String r106 = r103.next();
        Object r107 = r101.opt(r106);
        r106.getClass();
        switch(r106.hashCode()) {
            case -1405651851: goto L67;
            case -995427962: goto L64;
            case -818786127: goto L60;
            case -714207650: goto L56;
            case -419323305: goto L52;
            case 3146030: goto L48;
            case 182018955: goto L44;
            case 494495645: goto L40;
            case 562019534: goto L36;
            case 562334060: goto L32;
            case 678323412: goto L28;
            case 838006421: goto L24;
            case 924324347: goto L20;
            case 1125349443: goto L16;
            case 1969256807: goto L12;
            default: goto L10;
        };
    L10:
        r105 = -1;
    L70:
        switch(r105) {
            case 0: goto L94;
            case 1: goto L92;
            case 2: goto L90;
            case 3: goto L89;
            case 4: goto L88;
            case 5: goto L87;
            case 6: goto L86;
            case 7: goto L85;
            case 8: goto L84;
            case 9: goto L83;
            case 10: goto L82;
            case 11: goto L81;
            case 12: goto L76;
            case 13: goto L75;
            case 14: goto L74;
            default: goto L71;
        };
    L74:
        r104.f553627i = ((Boolean) r107).booleanValue();
        goto L6
    L75:
        r104.f553630l = (String) r107;
        goto L6
    L76:
        HashMap r108 = new HashMap();
        JSONObject r109 = (JSONObject) r107;
        Iterator<String> r112 = r109.keys();
    L78:
        if (r112.hasNext() == false) goto L80;
        String r113 = r112.next();
        r108.put(r113, r109.optString(r113));
        goto L78
    L80:
        r104.f553632n = r108;
        goto L6
    L81:
        String r114 = (String) r107;
        goto L6
    L82:
        r102.putString(r106, (String) r107);
        goto L6
    L83:
        r104.f553624f = (String) r107;
        goto L6
    L84:
        r104.f553623e = (String) r107;
        goto L6
    L85:
        ((Integer) r107).intValue();
        goto L6
    L86:
        ((Integer) r107).intValue();
        r102.putString(r106, String.valueOf(r107));
        goto L6
    L87:
        r104.f553631m = (String) r107;
        goto L6
    L88:
        r102.putString(r106, (String) r107);
        goto L6
    L89:
        String r115 = (String) r107;
        goto L6
    L90:
        r104.f553626h = (String) r107;
        r104.f553625g = PbRequest.SwitchType.RECHARGE.equals(r107);
        goto L6
    L92:
        if ((r107 instanceof JSONObject) == false) goto L6;
        JSONObject r116 = (JSONObject) r107;
        String r117 = r116.optString("ticket");
        String r118 = r116.optString("scene");
        String r119 = r116.optString("mode");
        r104.f553621c = r117;
        r104.f553620b = r118;
        r104.f553622d = r119;
        goto L6
    L94:
        r104.f553628j = String.valueOf(r107);
        goto L6
    L71:
        if (r111 != null) goto L73;
        r111 = new HashMap();
    L73:
        r111.put(r106, String.valueOf(r107));
        goto L6
    L12:
        if (r106.equals("skip_record_verify") == false) goto L10;
        r105 = 14;
        goto L70
    L16:
        if (r106.equals("use_new_api") == false) goto L10;
        r105 = HTTP.CR;
        goto L70
    L20:
        if (r106.equals("api_request_params") == false) goto L10;
        r105 = 12;
        goto L70
    L24:
        if (r106.equals("byte_scene") == false) goto L10;
        r105 = 11;
        goto L70
    L28:
        if (r106.equals("verified_page_source") == false) goto L10;
        r105 = 10;
        goto L70
    L32:
        if (r106.equals(BytedCertConstant.CertKey.IDENTITY_NAME) == false) goto L10;
        r105 = 9;
        goto L70
    L36:
        if (r106.equals(BytedCertConstant.CertKey.IDENTITY_CODE) == false) goto L10;
        r105 = 8;
        goto L70
    L40:
        if (r106.equals("youth_cert_scene") == false) goto L10;
        r105 = 7;
        goto L70
    L44:
        if (r106.equals(EventConstant.Key.AGE_LARGER_14) == false) goto L10;
        r105 = 6;
        goto L70
    L48:
        if (r106.equals(BytedCertConstant.CertKey.FLOW) == false) goto L10;
        r105 = 5;
        goto L70
    L52:
        if (r106.equals("conversation_id") == false) goto L10;
        r105 = 4;
        goto L70
    L56:
        if (r106.equals("children_cert_token") == false) goto L10;
        r105 = 3;
        goto L70
    L60:
        if (r106.equals("enter_from") == false) goto L10;
        r105 = 2;
        goto L70
    L64:
        if (r106.equals("params") == true) goto L70;
    L67:
        if (r106.equals("cert_type") == false) goto L10;
        r105 = 0;
        goto L70
    L95:
        if (r111 == null) goto L97;
        r104.f553633o = r111;
    L97:
        r104.f553629k = new h2(this);
        v80.d r120 = new v80.d(r104);
        x80.c.a(1).f562883a.a(r120);
    }
}
