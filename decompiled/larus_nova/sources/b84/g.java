package b84;

import android.text.TextUtils;
import com.bytedance.bdinstall.c1;
import com.bytedance.bdinstall.o0;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o0 f18024e;

    public g(o0 r100) {
        super(false, true);
        this.f18024e = r100;
    }

    @Override // b84.d
    public final boolean a(JSONObject r100) throws JSONException {
        r100.put("channel", this.f18024e.f199734g);
        r100.put("not_request_sender", 1);
        r100.put("aid", this.f18024e.f199728a);
        String r101 = this.f18024e.f199736i;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.put("release_build", r101);
        o0 r102 = this.f18024e;
        Map r103 = null;
        if (TextUtils.isEmpty(r102.f199738k) == true) goto L8;
        String r104 = r102.f199738k;
    L9:
        c1.i(r100, com.alipay.sdk.m.l.b.f25480b, r104);
        com.bytedance.bdinstall.x r105 = this.f18024e.f199737j;
        if (r105 == null) goto L12;
        String r106 = r105.getAbVersion();
    L13:
        c1.i(r100, TTVideoEngineInterface.PLAY_API_KEY_ABVERSION, r106);
        o0 r107 = this.f18024e;
        if (TextUtils.isEmpty(r107.f199739l) == true) goto L16;
        String r108 = r107.f199739l;
    L18:
        if (TextUtils.isEmpty(r108) == false) goto L20;
        r108 = this.f18024e.c().getString(EffectConfiguration.KEY_APP_LANGUAGE, null);
    L20:
        c1.i(r100, EffectConfiguration.KEY_APP_LANGUAGE, r108);
        o0 r109 = this.f18024e;
        if (TextUtils.isEmpty(r109.f199740m) == true) goto L23;
        String r110 = r109.f199740m;
    L25:
        if (TextUtils.isEmpty(r110) == false) goto L27;
        r110 = this.f18024e.c().getString("app_region", null);
    L27:
        c1.i(r100, "app_region", r110);
        o0 r111 = this.f18024e;
        JSONObject r112 = r111.f199741n;
        if (r112 != null) goto L36;
        String r113 = i84.a.a(r111.f199730c, r111).getString("app_track", null);
        if (r113 != null) goto L75;
    L35:
        r112 = null;
        goto L36
    L75:
        r112 = new JSONObject(r113);     // Catch: JSONException -> L34
    L36:
        if (r112 != null) goto L71;
    L41:
        JSONObject r114 = r100.optJSONObject("custom");
        if (r114 != null) goto L45;
        r114 = new JSONObject();
    L45:
        if (TextUtils.isEmpty(this.f18024e.f199732e) == true) goto L73;
        r114.put("real_package_name", this.f18024e.getContext().getPackageName());
    L73:
        com.bytedance.bdinstall.z r115 = this.f18024e.f199753z;     // Catch: Throwable -> L67
        if (r115 == null) goto L59;
        JSONObject r116 = ((nw3.g) r115).b();     // Catch: Throwable -> L67
        if (r116 != null) goto L52;
        r103 = Collections.emptyMap();     // Catch: Throwable -> L67
        goto L59
    L52:
        HashMap r117 = new HashMap();     // Catch: Throwable -> L67
        Iterator<String> r118 = r116.keys();     // Catch: Throwable -> L67
    L54:
        if (r118.hasNext() == false) goto L58;
        String r119 = r118.next();     // Catch: Throwable -> L67
        if (r119 == null) goto L54;
        r117.put(r119, r116.opt(r119));     // Catch: Throwable -> L67
        goto L54
    L58:
        r103 = r117;
    L59:
        if (r103 != null) goto L61;
    L69:
        r100.put("custom", r114);
        return true;
    L61:
        if (r103.size() <= 0) goto L69;
        Iterator r120 = r103.keySet().iterator();     // Catch: Throwable -> L67
    L63:
        if (r120.hasNext() == false) goto L69;
        String r121 = (String) r120.next();     // Catch: Throwable -> L67
        r114.put(r121, r103.get(r121));     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        th.printStackTrace();
        goto L69
    L71:
        r100.put("app_track", r112);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        com.bytedance.bdinstall.t.e(th);
        goto L41
    L23:
        r110 = i84.a.a(r109.f199730c, r109).getString("app_region", null);
        goto L25
    L16:
        r108 = i84.a.a(r107.f199730c, r107).getString(EffectConfiguration.KEY_APP_LANGUAGE, null);
        goto L18
    L12:
        r106 = null;
        goto L13
    L8:
        r104 = i84.a.a(r102.f199730c, r102).getString(com.alipay.sdk.m.l.b.f25480b, null);
        goto L9
    }

    @Override // b84.d
    public final void b(JSONObject r100) {
        r100.remove("channel");
        r100.remove("not_request_sender");
        r100.remove("aid");
        r100.remove("release_build");
        r100.remove(com.alipay.sdk.m.l.b.f25480b);
        r100.remove(TTVideoEngineInterface.PLAY_API_KEY_ABVERSION);
        r100.remove(EffectConfiguration.KEY_APP_LANGUAGE);
        r100.remove("app_region");
        r100.remove("app_track");
        r100.remove("custom");
    }
}
