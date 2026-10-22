package n1;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f22352b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c2.a f22353a;

    public a() {
        this.f22353a = new c2.a(20);
    }

    public static a b() {
        if (f22352b != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f22352b != null) goto L11;
        f22352b = new a();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f22352b;
    }

    public void a(JSONObject r10) {
        this.f22353a.a(r10);
    }

    public List c() {
        return this.f22353a.b();
    }
}
