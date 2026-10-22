package b84;

import android.content.Context;
import com.bytedance.bdinstall.c1;
import com.bytedance.bdinstall.o0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, d> f18026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f18027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f18028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f18030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o0 f18031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.bdinstall.u f18032g;

    public final synchronized boolean a() {
        monitor-enter(this);
    L40:
        th = move-exception;
        throw th;
    L5:
        if (this.f18029d == false) goto L10;
        com.bytedance.bdinstall.t.a("DRCommonHeaderload: mAllReady is true  header : " + this.f18028c);     // Catch: Throwable -> L40
        monitor-exit(this);
        return true;
    L10:
        if (this.f18027b == true) goto L12;
        this.f18027b = true;     // Catch: Throwable -> L40
        this.f18026a.put(e.class, new e());     // Catch: Throwable -> L40
        this.f18026a.put(o.class, new o(this.f18030e));     // Catch: Throwable -> L40
        this.f18026a.put(s.class, new s(this.f18030e));     // Catch: Throwable -> L40
        this.f18026a.put(v.class, new v());     // Catch: Throwable -> L40
        this.f18026a.put(r.class, new r(this.f18030e, this.f18031f));     // Catch: Throwable -> L40
        this.f18026a.put(y.class, new y(this.f18031f));     // Catch: Throwable -> L40
        this.f18026a.put(n.class, new n(this.f18031f, this.f18032g));     // Catch: Throwable -> L40
        this.f18026a.put(p.class, new p());     // Catch: Throwable -> L40
    L12:
        JSONObject r100 = this.f18028c;     // Catch: Throwable -> L40
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L40
        c1.e(r101, r100);     // Catch: Throwable -> L40
        Iterator r102 = ((LinkedHashMap) this.f18026a).values().iterator();     // Catch: Throwable -> L40
        boolean r103 = true;
    L14:
        if (r102.hasNext() == false) goto L37;
        d r104 = (d) r102.next();     // Catch: Throwable -> L40
        boolean r105 = false;
        if (r104.f18019a == true) goto L18;
    L45:
        r104.b(r101);     // Catch: JSONException -> L29 SecurityException -> L43 Throwable -> L40
        r104.f18019a = r104.a(r101);     // Catch: JSONException -> L29 SecurityException -> L43 Throwable -> L40
    L29:
        e = move-exception;
        com.bytedance.bdinstall.t.e(e);     // Catch: Throwable -> L40
    L32:
        if (r104.f18019a == false) goto L34;
    L35:
        r105 = true;
    L36:
        r103 = r103 & r105;     // Catch: Throwable -> L40
        this.f18028c = r101;     // Catch: Throwable -> L40
        com.bytedance.bdinstall.t.a("DRCommonHeaderload: allReady : " + r103 + " mHeader : " + this.f18028c);     // Catch: Throwable -> L40
        this.f18029d = r103;     // Catch: Throwable -> L40
        goto L14
    L34:
        if (r104.f18020b == false) goto L36;
    L18:
        if (r104.f18021c == true) goto L45;
        if (c1.g(this.f18031f.getContext()) == false) goto L22;
    L24:
        boolean r106 = false;
    L25:
        int r107 = com.bytedance.bdinstall.t.f199790a;     // Catch: Throwable -> L40
        if (r106 == false) goto L32;
    L22:
        if (r104.f18022d == false) goto L24;
        r106 = true;
        goto L25
    L37:
        boolean r108 = this.f18029d;     // Catch: Throwable -> L40
        monitor-exit(this);
        return r108;
    }

    public i(Context r100, o0 r101, com.bytedance.bdinstall.u r102) {
        this.f18026a = new LinkedHashMap(32);
        this.f18027b = false;
        this.f18028c = new JSONObject();
        this.f18030e = r100;
        this.f18032g = r102;
        this.f18031f = r101;
    }
}
