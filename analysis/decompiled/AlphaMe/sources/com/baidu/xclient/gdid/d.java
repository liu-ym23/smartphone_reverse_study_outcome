package com.baidu.xclient.gdid;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.mshield.b.a.g;
import com.baidu.xclient.gdid.d.b;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static volatile d f9501a = null;

    /* renamed from: b, reason: collision with root package name */
    public static Context f9502b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f9503c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f9504d = "";

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap<String, String> f9505e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    public b f9506f;

    /* renamed from: h, reason: collision with root package name */
    public String f9508h;

    /* renamed from: g, reason: collision with root package name */
    public AtomicBoolean f9507g = new AtomicBoolean(false);

    /* renamed from: i, reason: collision with root package name */
    public ConcurrentHashMap<String, String> f9509i = new ConcurrentHashMap<>();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.g();
                d.this.a(true, true);
            } catch (Throwable th) {
                com.baidu.xclient.gdid.j.d.a(th);
            }
        }
    }

    public class b implements Runnable {
        public b(d dVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                h.a().a(d.f9502b);
            } catch (Throwable th) {
                com.baidu.xclient.gdid.j.d.a(th);
            }
        }
    }

    public static d a() {
        if (f9501a == null) {
            synchronized (d.class) {
                try {
                    if (f9501a == null) {
                        f9501a = new d();
                    }
                } finally {
                }
            }
        }
        return f9501a;
    }

    public String b(String str) {
        return com.baidu.xclient.gdid.jni.c.a(f9502b).d(str);
    }

    public String c(String str) {
        try {
            HashMap<String, String> map = f9505e;
            if (map.size() <= 0) {
                return "";
            }
            synchronized (map) {
                try {
                    if (!map.containsKey(str)) {
                        return "";
                    }
                    return map.get(str);
                } finally {
                }
            }
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
            return "";
        }
    }

    public synchronized String[] d() {
        String[] strArr = {"", ""};
        String str = this.f9508h;
        if (TextUtils.isEmpty(str)) {
            return strArr;
        }
        String str2 = this.f9509i.get(str);
        strArr[0] = str;
        strArr[1] = str2;
        return strArr;
    }

    public String e() {
        return "";
    }

    public final void f() {
        JSONObject jSONObjectC;
        try {
            if (com.baidu.xclient.gdid.j.d.a(f9502b) && com.baidu.mshield.b.e.a.d(f9502b) && (jSONObjectC = c()) != null) {
                if (new com.baidu.xclient.gdid.g.a(f9502b, null).a(com.baidu.xclient.gdid.j.d.a(f9502b, jSONObjectC, "1072101").toString())) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    e.e().g(jCurrentTimeMillis);
                    e.e().c(jCurrentTimeMillis);
                } else {
                    h.a().a(f9502b);
                }
            }
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }

    public final void g() {
        try {
            this.f9506f = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(b.f9514a);
            try {
                f9502b.registerReceiver(this.f9506f, intentFilter, 4);
            } catch (Throwable th) {
                com.baidu.xclient.gdid.j.d.a(th);
            }
        } catch (Throwable th2) {
            com.baidu.xclient.gdid.j.d.a(th2);
        }
    }

    public final void h() {
        try {
            f9502b.unregisterReceiver(this.f9506f);
            this.f9506f = null;
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }

    public final void i() {
        JSONObject jSONObject;
        String strP = e.e().p();
        String strU = e.e().u();
        e.e().t();
        if (TextUtils.isEmpty(strU)) {
            jSONObject = new JSONObject();
        } else {
            try {
                jSONObject = new JSONObject(strU);
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            }
        }
        if (TextUtils.isEmpty(strP)) {
            return;
        }
        this.f9509i.put(strP, jSONObject.toString());
        this.f9508h = strP;
    }

    public Object a(int i4, Object obj, Object obj2, Object obj3) {
        return com.baidu.xclient.gdid.jni.c.a(f9502b).a(i4, obj, obj2, obj3);
    }

    public void b() {
        try {
            h();
            this.f9507g.set(false);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }

    public JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            StringBuilder sb = new StringBuilder();
            a(jSONObject, sb);
            a(jSONObject);
            b(jSONObject, sb);
            b(jSONObject);
            jSONObject.put("15057", sb);
            jSONObject.put("15006", TextUtils.isEmpty(com.baidu.xclient.gdid.jni.c.a(f9502b).a()) ? 1 : 0);
            return jSONObject;
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
            return null;
        }
    }

    public String a(Context context) {
        try {
            String strC = c("p");
            if (!TextUtils.isEmpty(strC)) {
                return strC;
            }
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
        return context.getPackageName();
    }

    public final void b(JSONObject jSONObject) {
        try {
            jSONObject.put("12006", com.baidu.mshield.b.e.a.c(f9502b, "screen_brightness"));
        } catch (Throwable unused) {
            try {
                jSONObject.put("12006", -1);
            } catch (Throwable th) {
                try {
                    com.baidu.xclient.gdid.j.d.a(th);
                } catch (Throwable th2) {
                    com.baidu.xclient.gdid.j.d.a(th2);
                }
            }
        }
    }

    public String a(String str) {
        return com.baidu.xclient.gdid.jni.c.a(f9502b).a(str);
    }

    public final void b(JSONObject jSONObject, StringBuilder sb) {
        StringBuilder sb2;
        String str;
        try {
            a(jSONObject, "02018", com.baidu.xclient.gdid.j.c.a("02018", c("arid"), sb));
            jSONObject.put("02015", c("arv"));
            jSONObject.put("02016", c("arl"));
            jSONObject.put("02002", com.baidu.xclient.gdid.jni.c.a(f9502b).f());
            jSONObject.put("02003", c("mod"));
            jSONObject.put("02004", com.baidu.xclient.gdid.jni.c.a(f9502b).k());
            jSONObject.put("02005", com.baidu.xclient.gdid.jni.c.a(f9502b).j());
            jSONObject.put("02006", com.baidu.xclient.gdid.jni.c.a(f9502b).i());
            jSONObject.put("02007", com.baidu.xclient.gdid.jni.c.a(f9502b).h());
            jSONObject.put("02008", com.baidu.xclient.gdid.jni.c.a(f9502b).g());
            jSONObject.put("15023", com.baidu.xclient.gdid.i.a.a());
            jSONObject.put("15021", com.baidu.xclient.gdid.i.a.c());
            jSONObject.put("15020", com.baidu.xclient.gdid.i.a.b());
            jSONObject.put("15022", com.baidu.xclient.gdid.i.a.d());
            String strB = g.b(f9502b);
            String strC = g.c(f9502b);
            jSONObject.put("15029", strB);
            jSONObject.put("15030", strC);
            a(jSONObject, "15048", com.baidu.xclient.gdid.jni.b.a(f9502b).a());
            a(jSONObject, "p", com.baidu.mshield.b.a.e.c() ? "1" : "0");
            a(jSONObject, "s", com.baidu.xclient.gdid.jni.c.a(f9502b).a());
            a(jSONObject, "11005", String.valueOf(com.baidu.mshield.b.a.e.b()));
            String strA = com.baidu.mshield.b.a.e.a();
            if (!TextUtils.isEmpty(strA)) {
                if (strA.contains("64")) {
                    sb2 = new StringBuilder();
                    str = "64 ";
                } else {
                    sb2 = new StringBuilder();
                    str = "32 ";
                }
                sb2.append(str);
                sb2.append(strA);
                strA = sb2.toString();
            }
            a(jSONObject, "11003", strA);
            a(jSONObject, "02010", com.baidu.xclient.gdid.i.a.a(f9502b));
            a(jSONObject, "02012", com.baidu.xclient.gdid.i.a.b(f9502b));
            a(jSONObject, "02059", com.baidu.xclient.gdid.jni.c.a(f9502b).e());
            try {
                com.baidu.xclient.gdid.j.e eVar = new com.baidu.xclient.gdid.j.e();
                eVar.a(10, 10);
                String strGlGetString = eVar.f9543f.glGetString(7937);
                a(jSONObject, "20081", eVar.f9543f.glGetString(7936));
                a(jSONObject, "20082", strGlGetString);
                eVar.b();
            } catch (Throwable th) {
                com.baidu.xclient.gdid.j.d.a(th);
            }
            a(jSONObject, "12001", com.baidu.xclient.gdid.i.a.c(f9502b));
            a(jSONObject, "12007", String.valueOf(com.baidu.xclient.gdid.i.a.d(f9502b)));
            a(jSONObject, "06011", String.valueOf(com.baidu.xclient.gdid.i.a.e(f9502b)));
            a(jSONObject, "06012", String.valueOf(com.baidu.xclient.gdid.i.a.f(f9502b) ? 1 : 0));
        } catch (Throwable th2) {
            com.baidu.xclient.gdid.j.d.a(th2);
        }
    }

    public void a(Context context, String str, String str2) {
        try {
            if (this.f9507g.get()) {
                return;
            }
            f9502b = context;
            f9503c = str;
            f9504d = str2;
            i();
            this.f9507g.set(true);
            new Thread(new a()).start();
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }

    public final void b(boolean z4) {
        if (z4) {
            com.baidu.xclient.gdid.j.b.b().postDelayed(new b(this), 65000L);
        } else {
            h.a().a(f9502b);
        }
    }

    public void a(Context context, String str, String str2, HashMap<String, String> map) {
        f9502b = context;
        f9503c = str;
        f9504d = str2;
        if (map != null) {
            HashMap<String, String> map2 = f9505e;
            synchronized (map2) {
                map2.putAll(map);
            }
        }
    }

    public void a(HashMap<String, String> map) {
        if (map != null) {
            try {
                if (map.size() == 0) {
                    return;
                }
                synchronized (f9505e) {
                    try {
                        for (String str : map.keySet()) {
                            f9505e.put(str, map.get(str));
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                com.baidu.xclient.gdid.j.d.a(th);
            }
        }
    }

    public final void a(JSONObject jSONObject) {
        try {
            a(jSONObject, "15027", com.baidu.xclient.gdid.b.a.a(f9502b));
            a(jSONObject, "15003", com.baidu.mshield.b.b.a.a(f9502b));
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }

    public final void a(JSONObject jSONObject, String str, String str2) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            jSONObject.put(str, str2);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }

    public final void a(JSONObject jSONObject, StringBuilder sb) {
        try {
            a(jSONObject, "15200", "C");
            a(jSONObject, "01001", com.baidu.xclient.gdid.j.a.a(f9502b));
            a(jSONObject, "15017", (String) com.baidu.xclient.gdid.j.d.c(f9502b).first);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }

    public void a(boolean z4) {
        if (e.e().v()) {
            return;
        }
        if (e.e().w()) {
            b(z4);
            return;
        }
        long jH = e.e().h();
        if (System.currentTimeMillis() - jH < e.e().i()) {
            b(z4);
        } else {
            f();
        }
    }

    public void a(boolean z4, boolean z5) {
        try {
            c.a().a(f9502b);
            a(z4);
            if (z5) {
                long jL = e.e().l();
                long jM = e.e().m();
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j4 = jCurrentTimeMillis - jL;
                if (j4 >= jM) {
                    e.e().e(jCurrentTimeMillis);
                } else {
                    jM -= j4;
                }
                com.baidu.xclient.gdid.d.a.a(f9502b, jM);
            }
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }
}
