package com.bytedance.android.shopping.anchorv3.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.mt.protector.impl.UriProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f165302a = 0;

    public b() {
    }

    static {
    }

    public static String a(String r100, ECAdLogExtra r101, boolean r102) {
        if (r100 != null) goto L4;
        return "";
    L4:
        String r103 = null;
        if (r101 != null) goto L7;
    L23:
        String r104 = r100;
    L24:
        boolean r105 = ECServiceManager.f42805a;
        ECAdInfo r106 = ((s83.g) ECServiceManager.c(s83.g.class)).A(null);
        if (r106 == null) goto L44;
        String r107 = UriProtector.getQueryParameter(UriProtector.parse(r100), com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r107 != null) goto L46;
    L33:
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L35
    L45:
    L37:
        if (TextUtils.isEmpty(r108.optString("creative_id")) == false) goto L40;
        r108.put("creative_id", r106.getCid());
        com.bytedance.android.ec.core.anchorv3.a.b(r107);
    L40:
        if (TextUtils.isEmpty(r108.optString("log_extra")) == false) goto L42;
        r108.put("log_extra", r106.getLogExtra());
        com.bytedance.android.ec.core.anchorv3.a.b(r107);
    L42:
        int r109 = p0.f45664a;
        return p0.d(r104, com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r108.toString());
    L35:
        r108 = new JSONObject();
        goto L37
    L46:
        if ((!TextUtils.isEmpty(r107)) == false) goto L31;
        r103 = r107;
    L31:
        if (r103 == null) goto L33;
        r108 = new JSONObject(r103);     // Catch: Exception -> L35
        goto L45
    L44:
        return r104;
    L7:
        if (a2.b(r101.getCreativeId()) == false) goto L23;
        String r110 = r101.getAdExtraData();
        if (r102 == true) goto L18;
        String r111 = r101.getCreativeId().toString();
        String r112 = r101.getLogExtra();
        JSONObject r113 = new JSONObject();
        if (r111 == null) goto L13;
        r113.put("cid", r111);
    L13:
        if (r112 == null) goto L15;
        r113.put("log_extra", r112);
    L15:
        if (r110 == null) goto L17;
        r113.put("ad_extra_data", r110);
    L17:
        String r114 = r113.toString();
        Uri.Builder r115 = UriProtector.parse(r100).buildUpon();
        r115.appendQueryParameter("has_adinfojson", "1");
        r115.appendQueryParameter("adinfojson", r114);
        r104 = r115.toString();
        goto L24
    L18:
        String r116 = r101.getCreativeId().toString();
        String r117 = r101.getLogExtra();
        JSONObject r118 = com.bytedance.android.shopping.extensions.k.w(UriProtector.getQueryParameter(UriProtector.parse(r100), com.bytedance.android.ec.core.event.a.KEY_RIFLE_MEGA_OBJECT));
        if (r118 == null) goto L21;
        r118.put("cid", r116);
        r118.put("log_extra", r117);
        r118.put("ad_extra_data", r110);
    L22:
        int r119 = p0.f45664a;
        r104 = p0.d(r100, com.bytedance.android.ec.core.event.a.KEY_RIFLE_MEGA_OBJECT, String.valueOf(r118));
        goto L24
    L21:
        r118 = null;
        goto L22
    }

    public static ECAdLogExtra b(String r100, String r101, String r110, String r111) {
        ECAdLogExtra r102 = new ECAdLogExtra(null, null, null, null, 15, null);
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.setCreativeId(r100);
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r102.setLogExtra(r101);
        if (r110 != null) goto L11;
        r110 = "";
    L11:
        r102.setAdExtraData(r110);
        if (r111 != null) goto L14;
        r111 = "";
    L14:
        r102.setGroupId(r111);
        return r102;
    }
}
