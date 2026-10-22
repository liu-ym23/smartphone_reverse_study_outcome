package bqc;

import com.volcengine.zeus.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile b f20111b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f20112a;

    public static b c() {
        if (f20111b != null) goto L13;
        monitor-enter(b.class);
        f20111b = new b();     // Catch: Throwable -> L9
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f20111b;
    }

    public b() {
        this.f20112a = new ArrayList();
    }

    public final void a(i.b r100) {
        List<a> r101 = this.f20112a;
        monitor-enter(r101);
        ((ArrayList) this.f20112a).add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        List<a> r104 = this.f20112a;
        monitor-enter(r104);
        Iterator r105 = ((ArrayList) this.f20112a).iterator();     // Catch: Throwable -> L14
    L6:
        if (r105.hasNext() == false) goto L12;
        ((a) r105.next()).a(r100, r101, r102, r103);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        goto L6
    L12:
        monitor-exit(r104);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
