package com.amap.api.col.jmsl;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.v1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1615v1 {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, c> f16981a = new ConcurrentHashMap<>(8);

    /* renamed from: b, reason: collision with root package name */
    public static volatile List<String> f16982b = Collections.synchronizedList(new ArrayList(8));

    /* renamed from: c, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, b> f16983c = new ConcurrentHashMap<>(8);

    /* renamed from: d, reason: collision with root package name */
    public static Random f16984d = new Random();

    /* renamed from: e, reason: collision with root package name */
    public static ConcurrentHashMap<String, String> f16985e = new ConcurrentHashMap<>(8);

    /* renamed from: f, reason: collision with root package name */
    public static List<C1558h> f16986f = Collections.synchronizedList(new ArrayList(16));

    /* renamed from: com.amap.api.col.jmsl.v1$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f16987a;

        /* renamed from: b, reason: collision with root package name */
        public int f16988b;

        /* renamed from: c, reason: collision with root package name */
        public double f16989c;

        public a() {
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    /* renamed from: com.amap.api.col.jmsl.v1$b */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public C1577l2 f16990a;

        /* renamed from: b, reason: collision with root package name */
        public long f16991b;

        public b() {
        }

        public /* synthetic */ b(byte b10) {
            this();
        }
    }

    public static C1577l2 a(String str, String str2) {
        Uri uri;
        if (f16983c == null) {
            return null;
        }
        if (f16983c.containsKey("app")) {
            b bVar = f16983c.get("app");
            if (SystemClock.elapsedRealtime() <= bVar.f16991b) {
                C1577l2 c1577l2 = bVar.f16990a;
                j(true, str2, str, 1);
                return c1577l2;
            }
            f16983c.remove("app");
        } else if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null) {
            String path = uri.getPath();
            if (f16983c.containsKey(path)) {
                b bVar2 = f16983c.get(path);
                if (SystemClock.elapsedRealtime() <= bVar2.f16991b) {
                    C1577l2 c1577l22 = bVar2.f16990a;
                    j(true, str2, str, 2);
                    return c1577l22;
                }
                f16983c.remove(path);
            }
        }
        return null;
    }

    public static void b() {
        try {
            Context context = C1602s0.f16866c;
            if (context == null) {
                return;
            }
            C1594q.g(o(), context);
        } catch (Throwable unused) {
        }
    }

    public static void c(c cVar, JSONObject jSONObject) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("block");
            if (jSONArrayOptJSONArray == null) {
                return;
            }
            HashMap map = new HashMap(8);
            byte b10 = 0;
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("api");
                    if (!TextUtils.isEmpty(strOptString)) {
                        if (!strOptString.startsWith("/")) {
                            strOptString = "/".concat(strOptString);
                        }
                        if (strOptString.endsWith("/")) {
                            strOptString = strOptString.substring(0, strOptString.length() - 1);
                        }
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("periods");
                        ArrayList arrayList = new ArrayList();
                        for (int i11 = 0; i11 < jSONArrayOptJSONArray2.length(); i11++) {
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i11);
                            if (jSONObjectOptJSONObject2 != null) {
                                a aVar = new a(b10);
                                aVar.f16987a = jSONObjectOptJSONObject2.optString("begin");
                                aVar.f16988b = jSONObjectOptJSONObject2.optInt("duration");
                                aVar.f16989c = jSONObjectOptJSONObject2.optDouble("percent");
                                arrayList.add(aVar);
                            }
                        }
                        map.put(strOptString, arrayList);
                    }
                }
            }
            cVar.f16992a = map;
        } catch (Throwable th) {
            C1611u1.b(th, "hlUtil", "pbr");
        }
    }

    public static synchronized void d(C1569j2 c1569j2, JSONObject jSONObject) {
        if (c1569j2 == null) {
            return;
        }
        try {
            String strG = c1569j2.g();
            if (TextUtils.isEmpty(strG)) {
                return;
            }
            if (jSONObject == null) {
                e(strG);
            }
            if (!C1602s0.u(jSONObject.optString("able", null), false)) {
                e(strG);
                return;
            }
            C1575l0.d(C1602s0.f16866c, "Yb3Blbl9odHRwX2NvbnRyb2w", strG, jSONObject.toString());
            g(strG, jSONObject);
        } catch (Throwable th) {
            C1611u1.b(th, "hlUtil", "par");
        }
    }

    public static synchronized void e(String str) {
        try {
            if (f16981a.containsKey(str)) {
                f16981a.remove(str);
            }
            SharedPreferences.Editor editorB = C1575l0.b(C1602s0.f16866c, "Yb3Blbl9odHRwX2NvbnRyb2w");
            if (editorB != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        editorB.remove(str);
                    }
                } catch (Throwable th) {
                    C1611u1.b(th, "sp", "rk");
                }
            }
            C1575l0.e(editorB);
        } catch (Throwable th2) {
            C1611u1.b(th2, "hlUtil", "rc");
        }
    }

    public static void f(String str, String str2, String str3) {
        try {
            Context context = C1602s0.f16866c;
            if (context != null && !TextUtils.isEmpty(str)) {
                if (f16985e == null) {
                    f16985e = new ConcurrentHashMap<>(8);
                }
                synchronized (f16985e) {
                    try {
                        if (f16985e.containsKey(str2)) {
                            return;
                        }
                        f16985e.put(str2, str3);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("timestamp", System.currentTimeMillis());
                        jSONObject.put("type", K0.f16153i);
                        jSONObject.put("name", str);
                        jSONObject.put("version", K0.a(str));
                        jSONObject.put("hostname", str2 + Const.STR_MART_WELL + str3);
                        String string = jSONObject.toString();
                        if (TextUtils.isEmpty(string)) {
                            return;
                        }
                        C1558h c1558h = new C1558h(context, "core", "2.0", "O005");
                        c1558h.a(string);
                        C1594q.d(c1558h, context);
                    } finally {
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(String str, JSONObject jSONObject) {
        JSONArray jSONArrayNames;
        try {
            c cVar = new c(0 == true ? 1 : 0);
            c(cVar, jSONObject);
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("domainMap");
                if (jSONObjectOptJSONObject != null && (jSONArrayNames = jSONObjectOptJSONObject.names()) != null) {
                    HashMap map = new HashMap(8);
                    int length = jSONArrayNames.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        String strOptString = jSONArrayNames.optString(i10);
                        map.put(strOptString, jSONObjectOptJSONObject.optString(strOptString));
                    }
                    cVar.f16993b = map;
                }
            } catch (Throwable th) {
                C1611u1.b(th, "hlUtil", "pdr");
            }
            if (cVar.f16993b == null && cVar.f16992a == null) {
                e(str);
                return;
            }
            try {
                if (f16981a == null) {
                    f16981a = new ConcurrentHashMap<>(8);
                }
                f16981a.put(str, cVar);
            } catch (Throwable th2) {
                C1611u1.b(th2, "hlUtil", "ucr");
            }
        } catch (Throwable unused) {
        }
    }

    public static void h(URL url, C1577l2 c1577l2) {
        List<String> list;
        try {
            if (f16983c == null) {
                f16983c = new ConcurrentHashMap<>(8);
            }
            Map<String, List<String>> map = c1577l2.f16720b;
            if (map != null && map.containsKey("nb") && (list = c1577l2.f16720b.get("nb")) != null && list.size() > 0) {
                byte b10 = 0;
                String[] strArrSplit = list.get(0).split(Const.STR_MART_WELL);
                if (strArrSplit.length < 2) {
                    return;
                }
                int i10 = Integer.parseInt(strArrSplit[0]);
                long j10 = Integer.parseInt(strArrSplit[1]);
                b bVar = new b(b10);
                bVar.f16990a = c1577l2;
                if (j10 <= 0) {
                    j10 = 30;
                }
                bVar.f16991b = SystemClock.elapsedRealtime() + (j10 * 1000);
                if (i10 == 1) {
                    f16983c.put("app", bVar);
                } else {
                    if (i10 != 2 || url == null) {
                        return;
                    }
                    f16983c.put(url.getPath(), bVar);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void i(boolean z10, String str) {
        try {
            Context context = C1602s0.f16866c;
            if (context != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                if (z10) {
                    jSONObject.put("type", K0.f16150f);
                } else {
                    jSONObject.put("type", K0.f16149e);
                }
                jSONObject.put("name", str);
                jSONObject.put("version", K0.a(str));
                String string = jSONObject.toString();
                C1558h c1558h = new C1558h(context, "core", "2.0", "O005");
                c1558h.a(string);
                C1594q.d(c1558h, context);
            }
        } catch (Throwable unused) {
        }
    }

    public static void j(boolean z10, String str, String str2, int i10) {
        try {
            Context context = C1602s0.f16866c;
            if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", System.currentTimeMillis());
                String strA = K0.a(str);
                if (z10) {
                    jSONObject.put("type", K0.f16152h);
                } else {
                    jSONObject.put("type", K0.f16151g);
                }
                jSONObject.put("name", str);
                jSONObject.put("version", strA);
                jSONObject.put("uri", Uri.parse(str2).getPath());
                jSONObject.put("blockLevel", i10);
                String string = jSONObject.toString();
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                C1558h c1558h = new C1558h(context, "core", "2.0", "O005");
                c1558h.a(string);
                if (f16986f == null) {
                    f16986f = Collections.synchronizedList(new ArrayList(16));
                }
                synchronized (f16986f) {
                    f16986f.add(c1558h);
                    if (f16986f.size() >= 15) {
                        try {
                            Context context2 = C1602s0.f16866c;
                            if (context2 != null) {
                                C1594q.g(o(), context2);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static boolean k(String str, c cVar, String str2) {
        Map<String, List<a>> map;
        try {
            map = cVar.f16992a;
        } catch (Throwable th) {
            C1611u1.b(th, "hlUtil", "inb");
        }
        if (map != null && map.size() > 0) {
            if (map.containsKey("*")) {
                Iterator<Map.Entry<String, List<a>>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    if (l(it.next().getValue())) {
                        j(false, str2, str, 1);
                        return true;
                    }
                }
            } else {
                String path = Uri.parse(str).getPath();
                if (map.containsKey(path) && l(map.get(path))) {
                    j(false, str2, str, 2);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean l(List<a> list) {
        Calendar calendar;
        if (list != null && list.size() > 0) {
            for (a aVar : list) {
                if (aVar != null && aVar.f16989c != 1.0d) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(aVar.f16987a) && aVar.f16988b > 0) {
                        String str = aVar.f16987a;
                        String[] strArr = C1604s2.f16918a;
                        try {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);
                            calendar = Calendar.getInstance();
                            Calendar calendar2 = Calendar.getInstance();
                            calendar2.setTime(simpleDateFormat.parse(str));
                            calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), calendar2.get(11), calendar2.get(12), calendar2.get(13));
                        } catch (ParseException e10) {
                            C1611u1.b(e10, "ut", "ctt");
                            calendar = null;
                        }
                        long timeInMillis = jCurrentTimeMillis - calendar.getTimeInMillis();
                        if (timeInMillis > 0 && timeInMillis < aVar.f16988b * 1000) {
                            if (aVar.f16989c != 0.0d) {
                                if (f16984d == null) {
                                    f16984d = new Random();
                                }
                                f16984d.setSeed(UUID.randomUUID().hashCode() + jCurrentTimeMillis);
                                if (f16984d.nextDouble() > aVar.f16989c) {
                                }
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static String m(String str, c cVar, String str2) {
        try {
            Map<String, String> map = cVar.f16993b;
            if (map != null && map.size() > 0) {
                Uri uri = Uri.parse(str);
                String authority = uri.getAuthority();
                if (map.containsKey(authority)) {
                    String str3 = map.get(authority);
                    str = uri.buildUpon().authority(str3).toString();
                    f(str2, authority, str3);
                    return str;
                }
            }
            return str;
        } catch (Throwable th) {
            C1611u1.b(th, "hlUtil", "pdr");
            return str;
        }
    }

    public static synchronized String n(String str, String str2) throws g5 {
        try {
            try {
                try {
                    System.currentTimeMillis();
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                        Context context = C1602s0.f16866c;
                        try {
                            if (f16982b == null) {
                                f16982b = Collections.synchronizedList(new ArrayList(8));
                            }
                            if (context != null && !f16982b.contains(str2)) {
                                f16982b.add(str2);
                                String strC = C1575l0.c(context, "Yb3Blbl9odHRwX2NvbnRyb2w", str2);
                                if (!TextUtils.isEmpty(strC)) {
                                    g(str2, new JSONObject(strC));
                                }
                            }
                        } catch (Throwable th) {
                            C1611u1.b(th, "hlUtil", "llhl");
                        }
                        if (f16981a != null && f16981a.size() > 0) {
                            if (!f16981a.containsKey(str2)) {
                                return str;
                            }
                            c cVar = f16981a.get(str2);
                            if (cVar == null) {
                                return str;
                            }
                            if (k(str, cVar, str2)) {
                                throw new g5("服务QPS超限");
                            }
                            return m(str, cVar, str2);
                        }
                        return str;
                    }
                    return str;
                } catch (Throwable th2) {
                    C1611u1.b(th2, "hlUtil", "pcr");
                    return str;
                }
            } catch (g5 e10) {
                throw e10;
            }
        } finally {
        }
    }

    public static List<C1558h> o() {
        ArrayList arrayList = null;
        try {
            synchronized (f16986f) {
                try {
                    List<C1558h> list = f16986f;
                    if (list != null && list.size() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        try {
                            arrayList2.addAll(f16986f);
                            f16986f.clear();
                            arrayList = arrayList2;
                        } catch (Throwable th) {
                            th = th;
                            arrayList = arrayList2;
                            throw th;
                        }
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable unused) {
            return arrayList;
        }
    }

    /* renamed from: com.amap.api.col.jmsl.v1$c */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public Map<String, List<a>> f16992a;

        /* renamed from: b, reason: collision with root package name */
        public Map<String, String> f16993b;

        public c() {
            this.f16992a = new HashMap(8);
            this.f16993b = new HashMap(8);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass()) {
                c cVar = (c) obj;
                if (this.f16992a.equals(cVar.f16992a) && this.f16993b.equals(cVar.f16993b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Map<String, List<a>> map = this.f16992a;
            int iHashCode = map != null ? map.hashCode() : 0;
            Map<String, String> map2 = this.f16993b;
            return iHashCode + (map2 != null ? map2.hashCode() : 0);
        }

        public /* synthetic */ c(byte b10) {
            this();
        }
    }
}
