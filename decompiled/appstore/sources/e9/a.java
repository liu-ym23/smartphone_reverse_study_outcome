package e9;

import android.content.Context;
import f9.b;
import f9.c;
import f9.f;
import f9.h;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f19328a;

    public a() {
    }

    public static a a() {
        if (f19328a != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f19328a != null) goto L11;
        f19328a = new a();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f19328a;
    }

    public void b(Context r10) {
        h.a(r10);
        b.a(r10);
        f.a();
        c.a();
    }
}
