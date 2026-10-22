package bsb;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f20360b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<InterfaceC0357a> f20361a;

    /* JADX INFO: renamed from: bsb.a$a, reason: collision with other inner class name */
    public interface InterfaceC0357a {
        void onExit();
    }

    public static a a() {
        if (f20360b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f20360b != null) goto L9;
        f20360b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f20360b;
    }

    public a() {
        this.f20361a = new ArrayList();
    }
}
