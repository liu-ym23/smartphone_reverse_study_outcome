package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f3551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f3552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f3553c;

    public k0() {
        this.f3551a = new HashMap();
        this.f3552b = new LinkedHashSet();
        this.f3553c = false;
    }

    public static void b(Object r10) {
        if ((r10 instanceof Closeable) == true) goto L10;
        return;
    L10:
        ((Closeable) r10).close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    final void a() {
        this.f3553c = true;
        Map r10 = this.f3551a;
        if (r10 == null) goto L15;
        monitor-enter(r10);
        Iterator r11 = this.f3551a.values().iterator();     // Catch: Throwable -> L9
    L7:
        if (r11.hasNext() == false) goto L11;
        b(r11.next());     // Catch: Throwable -> L9
        goto L7
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L15:
        Set r12 = this.f3552b;
        if (r12 == null) goto L28;
        monitor-enter(r12);
        Iterator r13 = this.f3552b.iterator();     // Catch: Throwable -> L22
    L20:
        if (r13.hasNext() == false) goto L24;
        b((Closeable) r13.next());     // Catch: Throwable -> L22
        goto L20
    L24:
        monitor-exit(r12);     // Catch: Throwable -> L22
        this.f3552b.clear();
    L22:
        th = move-exception;
        throw th;
    L28:
        d();
    }

    public Object c(String r10) {
        Map r11 = this.f3551a;
        if (r11 != null) goto L6;
        return null;
    L6:
        monitor-enter(r11);
        Object r12 = this.f3551a.get(r10);     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return r12;
    L10:
        th = move-exception;
        throw th;
    }

    public void d() {
    }

    public Object e(String r10, Object r11) {
        Map r12 = this.f3551a;
        monitor-enter(r12);
        Object r13 = this.f3551a.get(r10);     // Catch: Throwable -> L7
        if (r13 != null) goto L9;
        this.f3551a.put(r10, r11);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r12);     // Catch: Throwable -> L7
        if (r13 == null) goto L14;
        r11 = r13;
    L14:
        if (this.f3553c == false) goto L16;
        b(r11);
    L16:
        return r11;
    L7:
        th = move-exception;
        throw th;
    }
}
