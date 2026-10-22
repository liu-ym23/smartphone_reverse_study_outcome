package okhttp3.internal.c;

import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: Task.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f39838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f39839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f39840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f39841d;

    public abstract long a();

    public a(String r2, boolean r3) {
        o.e(r2, "name");
        this.f39838a = r2;
        this.f39839b = r3;
        this.f39841d = -1;
    }

    public /* synthetic */ a(String r1, boolean r2, int r3, h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        this(r1, r2);
    }

    public final String b() {
        return this.f39838a;
    }

    public final boolean c() {
        return this.f39839b;
    }

    public final c d() {
        return this.f39840c;
    }

    public final void a(long r1) {
        this.f39841d = r1;
    }

    public final long e() {
        return this.f39841d;
    }

    public final void a(c r2) {
        o.e(r2, "queue");
        c r0 = this.f39840c;
        if (r0 != r2) goto L5;
        return;
    L5:
        if (r0 != null) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L12;
        this.f39840c = r2;
        return;
    L12:
        throw new IllegalStateException("task is in multiple queues".toString());
    L7:
        r1 = false;
        goto L8
    }

    public String toString() {
        return this.f39838a;
    }
}
