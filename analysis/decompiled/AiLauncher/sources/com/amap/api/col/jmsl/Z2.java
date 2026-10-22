package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class Z2 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f16502a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f16503b = false;

    /* renamed from: c, reason: collision with root package name */
    public static HashMap<String, Boolean> f16504c = new HashMap<>();

    public static <T> String a(Map<String, T> map) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Const.STR_MART_JSON_BEGIN);
            for (Map.Entry<String, T> entry : map.entrySet()) {
                sb2.append("\"" + entry.getKey() + "\":");
                sb2.append(entry.getValue());
                sb2.append(Const.STR_MART_COMMA);
            }
            sb2.deleteCharAt(sb2.length() - 1);
            sb2.append("}");
            return sb2.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void b(Context context) {
        if (f16502a) {
            return;
        }
        try {
            HashMap map = new HashMap();
            map.put("amap_3dmap_bzmapreview", 1);
            e(context, "O031", a(map));
            f16502a = true;
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context, long j10) {
        try {
            HashMap map = new HashMap();
            map.put("amap_3dmap_rendertime", Long.valueOf(j10));
            map.put("amap_3dmap_render_background", 0L);
            e(context, "O027", a(map));
        } catch (Throwable unused) {
        }
    }

    public static synchronized void d(Context context, String str) {
        if (f16504c != null && !TextUtils.isEmpty(str)) {
            if (f16504c.containsKey(str) && f16504c.get(str).booleanValue()) {
                return;
            }
            HashMap map = new HashMap();
            map.put("amap_3dmap_coordinate", str);
            e(context, "O030", a(map));
            if (!f16504c.containsKey(str)) {
                f16504c.put(str, Boolean.TRUE);
            }
        }
    }

    public static void e(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            C1558h c1558h = new C1558h(context, "3dmap-lite", "1.2.0", str);
            c1558h.a(str2);
            C1594q.d(c1558h, context);
        } catch (Throwable unused) {
        }
    }

    public static void f(Context context) {
        if (f16503b) {
            return;
        }
        try {
            HashMap map = new HashMap();
            map.put("amap_3dmap_wxmapreview", 1);
            e(context, "O032", a(map));
            f16503b = true;
        } catch (Throwable unused) {
        }
    }

    public static void g(Context context, long j10) {
        try {
            HashMap map = new HashMap();
            map.put("amap_3dmap_launchtime", Long.valueOf(j10));
            e(context, "O028", a(map));
        } catch (Throwable unused) {
        }
    }
}
