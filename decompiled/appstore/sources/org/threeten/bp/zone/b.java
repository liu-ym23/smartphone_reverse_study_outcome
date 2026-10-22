package org.threeten.bp.zone;

import androidx.lifecycle.p;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f23251a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f23252b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference f23253c = null;

    public static class a extends b {
        public a() {
        }

        @Override // org.threeten.bp.zone.b
        public void b() {
        }
    }

    /* JADX INFO: renamed from: org.threeten.bp.zone.b$b, reason: collision with other inner class name */
    public static class C0337b extends b {
        public C0337b() {
        }

        @Override // org.threeten.bp.zone.b
        public void b() {
            Iterator r10 = ServiceLoader.load(c.class, c.class.getClassLoader()).iterator();
        L4:
            if (r10.hasNext() == false) goto L13;
            c.f((c) r10.next());     // Catch: ServiceConfigurationError -> L8
        L8:
            e = move-exception;
            if ((e.getCause() instanceof SecurityException) == true) goto L4;
            throw e;
        }
    }

    static {
        f23251a = new a();
        f23252b = new AtomicBoolean(false);
        f23253c = new AtomicReference();
    }

    public b() {
    }

    public static void a() {
        if (f23252b.getAndSet(true) == true) goto L7;
        AtomicReference r10 = f23253c;
        p.a(r10, null, new C0337b());
        ((b) r10.get()).b();
        return;
    L7:
        throw new IllegalStateException("Already initialized");
    }

    public static void c(b r10) {
        if (f23252b.get() == true) goto L10;
        if (p.a(f23253c, null, r10) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Initializer was already set, possibly with a default during initialization");
    L10:
        throw new IllegalStateException("Already initialized");
    }

    public abstract void b();
}
