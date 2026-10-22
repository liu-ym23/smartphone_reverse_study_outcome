package com.bytedance.android.ec.core.hybrid.utils;

import android.net.Uri;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f44324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static JSONObject f44325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Uri f44326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, l> f44327d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Object> f44328e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, l> f44329f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<String, Object> f44330g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<String, l> f44331h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map<String, Object> f44332i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Map<String, q> f44333j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map<String, ECBaseBridgeMethod.a> f44334k = null;

    static {
        f44324a = new JSONObject();
        f44325b = new JSONObject();
        f44326c = Uri.EMPTY;
        f44327d = new LinkedHashMap();
        f44328e = new LinkedHashMap();
        f44329f = new LinkedHashMap();
        f44330g = new LinkedHashMap();
        f44331h = new LinkedHashMap();
        f44332i = new LinkedHashMap();
        f44333j = new LinkedHashMap();
        f44334k = new LinkedHashMap();
    }

    public static void a() {
        ((LinkedHashMap) f44328e).clear();
        ((LinkedHashMap) f44327d).clear();
        ((LinkedHashMap) f44330g).clear();
        ((LinkedHashMap) f44329f).clear();
        ((LinkedHashMap) f44332i).clear();
        ((LinkedHashMap) f44331h).clear();
    }

    public static Object c(l r100) {
        String r101 = r100.f44316b;
        boolean r102 = true;
        int r103 = 0;
        switch(r101.hashCode()) {
            case -1613114217: goto L24;
            case -907987551: goto L19;
            case 94844771: goto L16;
            case 794212742: goto L6;
            default: goto L33;
        };
    L33:
        String r104 = r100.f44318d;
    L34:
        String r105 = r100.getType();
        int r106 = r105.hashCode();
        if (r106 == (-1034364087)) goto L43;
        if (r106 != 64711720) goto L47;
        if (r105.equals("boolean") == false) goto L47;
        return Boolean.valueOf(Intrinsics.areEqual(r104, "true"));
    L47:
        if (Intrinsics.areEqual(r104, "null") == true) goto L49;
        return r104;
    L49:
        return JSONObject.NULL;
    L43:
        if (r105.equals("number") == false) goto L47;
        r103 = CastIntegerProtector.parseInt(r104);     // Catch: Throwable -> L50
    L54:
        return Integer.valueOf(r103);
    L6:
        if (r101.equals(com.bytedance.android.ec.core.event.a.KEY_CJ_INFO) == false) goto L33;
        r104 = f44324a.optString(r100.f44317c);
        if (r104 != null) goto L10;
    L13:
        if (r102 == false) goto L34;
        r104 = r100.f44318d;
        goto L34
    L10:
        if (r104.length() == 0) goto L13;
        r102 = false;
        goto L13
    L16:
        if (r101.equals("const") == false) goto L33;
        r104 = r100.f44318d;
        goto L34
    L19:
        if (r101.equals("schema") == false) goto L33;
        r104 = UriProtector.getQueryParameter(f44326c, r100.f44317c);
        if (r104 != null) goto L34;
        r104 = r100.f44318d;
        goto L34
    L24:
        if (r101.equals(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO) == false) goto L33;
        r104 = f44325b.optString(r100.f44317c);
        if (r104 != null) goto L28;
    L31:
        if (r102 == false) goto L34;
        r104 = r100.f44318d;
        goto L34
    L28:
        if (r104.length() == 0) goto L31;
        r102 = false;
        goto L31
    }

    public static void b(int r100, ECBaseBridgeMethod.a r101) {
        JSONObject r102 = new JSONObject();
        r102.put("code", 0);
        r102.put("status", r100);
        Unit r103 = Unit.INSTANCE;
        r101.a(r102);
    }

    public static void d(String r110, JSONObject r111) {
        JSONObject r112 = r111.optJSONObject(r110);
        if (r112 == null) goto L25;
        Iterator<String> r100 = r112.keys();
    L6:
        if (r100.hasNext() == false) goto L45;
        String r101 = r100.next();
        JSONObject r102 = r112.optJSONObject(r101);
        if (r102 == null) goto L6;
        int r103 = r110.hashCode();
        if (r103 != (-42570899)) goto L12;
        if (r110.equals("ec_order_product_request") == false) goto L6;
        f44331h.put(r101, new l(r102.optString("type", ""), r102.optString("from", ""), r102.optString("key", ""), r102.optString("default", "")));
        goto L6
    L12:
        if (r103 != 911923416) goto L14;
        if (r110.equals("ec_order_shop_request") == false) goto L6;
        f44329f.put(r101, new l(r102.optString("type", ""), r102.optString("from", ""), r102.optString("key", ""), r102.optString("default", "")));
        goto L6
    L14:
        if (r103 != 1124837331) goto L6;
        if (r110.equals("ec_order_outside") == false) goto L6;
        f44327d.put(r101, new l(r102.optString("type", ""), r102.optString("from", ""), r102.optString("key", ""), r102.optString("default", "")));
        goto L6
    L45:
        return;
    }

    public static void e(q r100, String r101) {
        ECBaseBridgeMethod.a r102 = f44334k.remove(r101);
        if (r102 != null) goto L5;
        f44333j.put(r101, r100);
        return;
    L5:
        int r103 = r100.f44336b;
        if (r103 != 1) goto L8;
        f(r100, r102);
        return;
    L8:
        b(r103, r102);
    }

    public static void f(q r100, ECBaseBridgeMethod.a r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L4
        r102.put("code", 1);     // Catch: Exception -> L4
        r102.put("data", new JSONObject(r100.f44335a));     // Catch: Exception -> L4
        r102.put("status", r100.f44336b);     // Catch: Exception -> L4
        Unit r103 = Unit.INSTANCE;     // Catch: Exception -> L4
        r101.a(r102);     // Catch: Exception -> L4
        return;
    L4:
        b(3, r101);
    }
}
