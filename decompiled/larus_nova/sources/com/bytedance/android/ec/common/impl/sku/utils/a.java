package com.bytedance.android.ec.common.impl.sku.utils;

import android.net.Uri;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.mt.protector.impl.UriProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f43350a = 0;

    public a() {
    }

    static {
    }

    public static String a(String r100, ECAdLogExtra r101, ECAdInfo r102, boolean r110) {
        if (r100 != null) goto L4;
        return "";
    L4:
        String r103 = null;
        if (r101 != null) goto L7;
    L23:
        String r104 = r100;
    L24:
        if (r102 == null) goto L52;
        String r105 = UriProtector.getQueryParameter(UriProtector.parse(r100), com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        boolean r106 = true;
        if (r105 != null) goto L54;
    L35:
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L37
    L53:
    L39:
        if (r107.optString("creative_id").length() != 0) goto L41;
        boolean r108 = true;
    L42:
        if (r108 == false) goto L45;
        r107.put("creative_id", r102.getCid());
    L45:
        if (r107.optString("log_extra").length() == 0) goto L48;
        r106 = false;
    L48:
        if (r106 == false) goto L50;
        r107.put("log_extra", r102.getLogExtra());
    L50:
        int r109 = jg.e.f498944a;
        return jg.e.b(r104, com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r107.toString());
    L41:
        r108 = false;
    L37:
        r107 = new JSONObject();
        goto L39
    L54:
        if (r105.length() <= 0) goto L30;
        boolean r111 = true;
    L31:
        if (r111 == false) goto L33;
        r103 = r105;
    L33:
        if (r103 == null) goto L35;
        r107 = new JSONObject(r103);     // Catch: Exception -> L37
        goto L53
    L30:
        r111 = false;
        goto L31
    L52:
        return r104;
    L7:
        if (a2.b(r101.getCreativeId()) == false) goto L23;
        String r112 = r101.getAdExtraData();
        if (r110 == true) goto L18;
        String r113 = r101.getCreativeId().toString();
        String r114 = r101.getLogExtra();
        JSONObject r115 = new JSONObject();
        if (r113 == null) goto L13;
        r115.put("cid", r113);
    L13:
        if (r114 == null) goto L15;
        r115.put("log_extra", r114);
    L15:
        if (r112 == null) goto L17;
        r115.put("ad_extra_data", r112);
    L17:
        String r116 = r115.toString();
        Uri.Builder r117 = UriProtector.parse(r100).buildUpon();
        r117.appendQueryParameter("has_adinfojson", "1");
        r117.appendQueryParameter("adinfojson", r116);
        r104 = r117.toString();
        goto L24
    L18:
        String r118 = r101.getCreativeId().toString();
        String r119 = r101.getLogExtra();
        JSONObject r120 = jg.g.f(UriProtector.getQueryParameter(UriProtector.parse(r100), com.bytedance.android.ec.core.event.a.KEY_RIFLE_MEGA_OBJECT));
        if (r120 == null) goto L21;
        r120.put("cid", r118);
        r120.put("log_extra", r119);
        r120.put("ad_extra_data", r112);
    L22:
        int r121 = jg.e.f498944a;
        r104 = jg.e.b(r100, com.bytedance.android.ec.core.event.a.KEY_RIFLE_MEGA_OBJECT, String.valueOf(r120));
        goto L24
    L21:
        r120 = null;
        goto L22
    }
}
