package com.bytedance.applog.log;

import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Boolean f192479a;

    /* JADX INFO: loaded from: classes14.dex */
    public static class a implements g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f192480a;

        @Override // com.bytedance.applog.log.g.b
        public final Object fetch() {
            JSONObject r100 = ((jx3.a) this.f192480a).o();
            JSONObject r101 = new JSONObject();
            nx3.f.b(r100, r101);
            r101.put("$$APP_ID", ((jx3.a) this.f192480a).f500769m);     // Catch: JSONException -> L5
            r101.put("$$EVENT_TYPE", m.a((jx3.a) this.f192480a));     // Catch: JSONException -> L5
            r101.put("$$PRIORITY", ((jx3.a) this.f192480a).f500771o);     // Catch: JSONException -> L5
            r101.put("$$EVENT_LOCAL_ID", ((jx3.a) this.f192480a).f500773q);     // Catch: JSONException -> L5
        L4:
            return r101;
        }

        public a(Object r100) {
            this.f192480a = r100;
        }
    }

    static {
        f192479a = Boolean.FALSE;
    }

    public static boolean b() {
        return !f192479a.booleanValue();
    }

    public static String a(jx3.a r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if ((r100 instanceof jx3.f) == false) goto L10;
        return "FORWARD_EVENT";
    L10:
        if ((r100 instanceof jx3.e) == false) goto L17;
        if ("applog_trace".equals(((jx3.e) r100).B) == false) goto L15;
        return "TRACE";
    L15:
        return "EVENT_V3";
    L17:
        if ((r100 instanceof jx3.j) == false) goto L20;
        return "EVENT_V3";
    L20:
        if ((r100 instanceof jx3.c) == false) goto L24;
        return ((jx3.c) r100).f500795y.toUpperCase(Locale.ROOT);
    L24:
        if ((r100 instanceof jx3.g) == false) goto L28;
        return "LAUNCH";
    L28:
        if ((r100 instanceof jx3.k) == false) goto L32;
        return "TERMINATE";
    L32:
        if ((r100 instanceof jx3.d) == false) goto L35;
        return "LOG_DATA";
    L35:
        return "";
    }

    public static void e(String r100) {
        if (b() == false) goto L5;
        return;
    L5:
        if (nx3.k.g("init_end") == true) goto L10;
        g.f192461z.b(new Object[0]).e(f("init_end"), r100);
        return;
    }

    public static String f(String r100) {
        return "applog_".concat(r100);
    }

    public static void c(String r100, g.b r101) {
        if (b() == false) goto L5;
        return;
    L5:
        if (nx3.k.g(r100) == true) goto L10;
        g.f192461z.b(new Object[0]).a(f(r100), r101);
        return;
    }

    public static void d(String r100, Object r101) {
        if (b() == false) goto L5;
        return;
    L5:
        if (nx3.k.g(r100) == false) goto L8;
        return;
    L8:
        if ((r101 instanceof jx3.a) == false) goto L10;
        g.f192461z.b(new Object[0]).a(f(r100), new a(r101));
        return;
    L10:
        g.f192461z.b(new Object[0]).e(f(r100), r101);
    }
}
