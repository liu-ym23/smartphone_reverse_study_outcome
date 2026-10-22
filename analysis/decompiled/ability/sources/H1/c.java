package H1;

import H.h;
import L.d;
import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c {
    public static volatile c f;

    /* renamed from: a, reason: collision with root package name */
    public Context f729a;
    public volatile boolean b;
    public volatile cc.dd.hh.gg.a c;
    public volatile SharedPreferences d;
    public boolean e;

    public static cc.dd.hh.gg.a a(File file, JSONObject jSONObject) {
        a aVar = new a();
        aVar.b = file;
        aVar.h = jSONObject.optLong("currentTime");
        aVar.i = jSONObject.optLong("sidTime");
        jSONObject.optLong("heapDumpFileSize");
        String strOptString = jSONObject.optString("referenceName");
        S0.b.L(strOptString, "referenceName");
        aVar.d = strOptString;
        aVar.f727a = jSONObject.optBoolean("isDebug");
        aVar.f = jSONObject.optLong("gcDurationMs");
        aVar.e = jSONObject.optLong("watchDurationMs");
        aVar.g = jSONObject.optLong("dumpDurationMs");
        aVar.c = jSONObject.optString("shrinkFilePath");
        S0.b.L(aVar.b, "heapDumpFile");
        return new cc.dd.hh.gg.a(aVar);
    }

    public static void c(cc.dd.hh.gg.a aVar, JSONObject jSONObject) throws JSONException {
        jSONObject.put("heapDumpFilePath", aVar.f2145a.getPath());
        jSONObject.put("shrinkFilePath", aVar.g);
        jSONObject.put("heapDumpFileSize", aVar.f2145a.length());
        jSONObject.put("referenceName", aVar.e);
        jSONObject.put("isDebug", aVar.b);
        jSONObject.put("gcDurationMs", aVar.h);
        jSONObject.put("watchDurationMs", aVar.f);
        jSONObject.put("dumpDurationMs", aVar.i);
        jSONObject.put("currentTime", aVar.c);
        jSONObject.put("sidTime", aVar.d);
    }

    public static c d() {
        if (f == null) {
            synchronized (c.class) {
                try {
                    if (f == null) {
                        D1.a aVarB = D1.a.b();
                        S0.b.L(aVarB.f371a, "You must call init() first before using !!!");
                        Context context = aVarB.f371a;
                        c cVar = new c();
                        cVar.d = null;
                        cVar.f729a = context.getApplicationContext();
                        f = cVar;
                    }
                } finally {
                }
            }
        }
        return f;
    }

    public final void b() {
        E1.a.b.execute(new b(this, 1));
    }

    public final SharedPreferences e() {
        if (this.d == null) {
            synchronized (this) {
                try {
                    if (this.d == null) {
                        this.d = d.a(this.f729a, "MemoryWidgetSp" + h.c());
                    }
                } finally {
                }
            }
        }
        return this.d;
    }

    public final void f() {
        if (this.b) {
            return;
        }
        if (!d().e().getBoolean("hasShrink", false)) {
            E1.a.b.execute(new b(this, 0));
        } else {
            U7.a.j("HeapSaver shrink hasShrinked", new Object[0]);
            C1.a.a();
        }
    }
}
