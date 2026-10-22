package q6;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f23545b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f23546a;

    public a() {
        this.f23546a = new ConcurrentHashMap();
    }

    public static synchronized a c() {
        monitor-enter(a.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f23545b != null) goto L9;
        f23545b = new a();     // Catch: Throwable -> L7
    L9:
        a r10 = f23545b;     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return r10;
    }

    public void a(String r10, String r11, int r12, int r13, int r14, List r15, String r16) {
        b r17 = (b) this.f23546a.get(r10);
        if (r17 == null) goto L6;
        r17.e(new c(r12, r13, r14, r15, r16));
        r17.d();
        this.f23546a.remove(r10);
        return;
    }

    public c b(String r10, int r11) {
        b r12 = new b(r10, r11);
        this.f23546a.put(r12.f(), r12);
        r12.b();
        r12.a();
        this.f23546a.remove(r12.f());
        return r12.c();
    }
}
