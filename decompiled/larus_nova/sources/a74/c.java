package a74;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f1990a;

    public c(JSONObject r100) {
        this.f1990a = r100;
    }

    public final void a() {
        Object r100 = e.f1992b;     // Catch: Throwable -> L35
        monitor-enter(r100);     // Catch: Throwable -> L35
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L6:
        if (e.f1994d == true) goto L10;
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L32
    L8:
        e.f1993c.set(false);
        e.b();
        return;
    L10:
        long r101 = e.f1995e;     // Catch: Throwable -> L32
        com.bytedance.badger.v.d.f199322f0.getClass();     // Catch: Throwable -> L32
        com.bytedance.badger.v.k r102 = com.bytedance.badger.v.d.f199314b0;     // Catch: Throwable -> L32
        KProperty r103 = com.bytedance.badger.v.d.f199311a[54];     // Catch: Throwable -> L32
        if (r101 >= ((Number) r102.a()).longValue()) goto L7;
        JSONObject r104 = this.f1990a;     // Catch: Throwable -> L32
        if (r104 == null) goto L17;
        String r105 = r104.optString("1", "");     // Catch: Throwable -> L32
    L18:
        JSONObject r106 = this.f1990a;     // Catch: Throwable -> L32
        if (r106 == null) goto L22;
        String r107 = r106.optString("2", "");     // Catch: Throwable -> L32
    L24:
        if (r105.isEmpty() == true) goto L27;
        e.f1997g.addLast(r105);     // Catch: Throwable -> L32
    L27:
        if (r107.isEmpty() == true) goto L29;
        e.f1998h.addLast(r107);     // Catch: Throwable -> L32
    L29:
        e.f1995e++;     // Catch: Throwable -> L32
        com.bytedance.badger.e.f("event_behavior# ", "complete batch =" + e.f1995e);     // Catch: Throwable -> L32
        goto L7
    L22:
        r107 = "";
        goto L24
    L17:
        r105 = "";
    L35:
        th = move-exception;
        com.bytedance.badger.e.g("event_behavior# ", "onCompleted store failed: " + th.getMessage());     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        e.f1993c.set(false);
        e.b();
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
