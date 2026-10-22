package androidx.lifecycle;

import java.io.Closeable;
import kotlin.coroutines.CoroutineContext;

/* renamed from: androidx.lifecycle.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0311h implements Closeable, Z2.F {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f3944a;

    public C0311h(CoroutineContext coroutineContext) {
        this.f3944a = coroutineContext;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Z2.o0 o0Var = (Z2.o0) this.f3944a.get(Z2.n0.f2230a);
        if (o0Var != null) {
            o0Var.b(null);
        }
    }

    @Override // Z2.F
    public final CoroutineContext e() {
        return this.f3944a;
    }
}
