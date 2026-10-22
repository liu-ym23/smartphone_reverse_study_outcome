package Ca;

import java.util.concurrent.atomic.AtomicBoolean;
import m9.C1724q;
import m9.q0;

/* renamed from: Ca.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0205d {

    /* renamed from: a, reason: collision with root package name */
    public final stepai.aios.guiagent.runtime.b f347a;
    public final C0206e b;
    public final C1724q c;
    public final long d;
    public final AtomicBoolean e;
    public final AtomicBoolean f;
    public final AtomicBoolean g;
    public volatile q0 h;

    public C0205d(stepai.aios.guiagent.runtime.b bVar, C0206e c0206e, C1724q c1724q) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        AtomicBoolean atomicBoolean3 = new AtomicBoolean(false);
        this.f347a = bVar;
        this.b = c0206e;
        this.c = c1724q;
        this.d = jCurrentTimeMillis;
        this.e = atomicBoolean;
        this.f = atomicBoolean2;
        this.g = atomicBoolean3;
        this.h = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0205d)) {
            return false;
        }
        C0205d c0205d = (C0205d) obj;
        return kotlin.jvm.internal.k.b(this.f347a, c0205d.f347a) && kotlin.jvm.internal.k.b(this.b, c0205d.b) && kotlin.jvm.internal.k.b(this.c, c0205d.c) && this.d == c0205d.d && kotlin.jvm.internal.k.b(this.e, c0205d.e) && kotlin.jvm.internal.k.b(this.f, c0205d.f) && kotlin.jvm.internal.k.b(this.g, c0205d.g) && kotlin.jvm.internal.k.b(this.h, c0205d.h);
    }

    public final int hashCode() {
        return ((this.g.hashCode() + ((this.f.hashCode() + ((this.e.hashCode() + androidx.appfunctions.metadata.a.c((this.c.hashCode() + ((this.b.hashCode() + (this.f347a.hashCode() * 31)) * 31)) * 31, 31, this.d)) * 31)) * 31)) * 31) + (this.h == null ? 0 : this.h.hashCode());
    }

    public final String toString() {
        return "TaskEntry(handle=" + this.f347a + ", listener=" + this.b + ", result=" + this.c + ", createdAt=" + this.d + ", started=" + this.e + ", finalized=" + this.f + ", semaphoreAcquired=" + this.g + ", buildTimeoutJob=" + this.h + ")";
    }
}
