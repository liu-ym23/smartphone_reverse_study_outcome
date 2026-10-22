package v5;

import java.io.Closeable;
import od.c0;
import od.i0;
import od.z;
import t.i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o extends p {

    /* renamed from: c, reason: collision with root package name */
    public z f14799c;

    /* renamed from: f, reason: collision with root package name */
    public od.o f14800f;

    /* renamed from: g, reason: collision with root package name */
    public String f14801g;

    /* renamed from: h, reason: collision with root package name */
    public Closeable f14802h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public c0 f14803j;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            this.i = true;
            c0 c0Var = this.f14803j;
            if (c0Var != null) {
                i6.d.a(c0Var);
            }
            Closeable closeable = this.f14802h;
            if (closeable != null) {
                i6.d.a(closeable);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // v5.p
    public final synchronized z d() {
        if (this.i) {
            throw new IllegalStateException("closed");
        }
        return this.f14799c;
    }

    @Override // v5.p
    public final i1 e() {
        return null;
    }

    @Override // v5.p
    public final synchronized od.k g() {
        if (this.i) {
            throw new IllegalStateException("closed");
        }
        c0 c0Var = this.f14803j;
        if (c0Var != null) {
            return c0Var;
        }
        i0 i0VarL = this.f14800f.l(this.f14799c);
        i0VarL.getClass();
        c0 c0Var2 = new c0(i0VarL);
        this.f14803j = c0Var2;
        return c0Var2;
    }
}
