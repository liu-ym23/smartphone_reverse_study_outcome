package io.ktor.utils.io;

import java.io.IOException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class p0 implements p {

    /* renamed from: b, reason: collision with root package name */
    public final j6.a f3227b;
    private volatile j0 closed;

    public p0(j6.a aVar) {
        this.f3227b = aVar;
    }

    @Override // io.ktor.utils.io.p
    public final Throwable a() {
        j0 j0Var = this.closed;
        if (j0Var != null) {
            return j0Var.a(i0.f3206a);
        }
        return null;
    }

    @Override // io.ktor.utils.io.p
    public final j6.a b() throws Throwable {
        Throwable thA = a();
        if (thA == null) {
            return this.f3227b;
        }
        throw thA;
    }

    @Override // io.ktor.utils.io.p
    public final void c(Throwable th) {
        if (this.closed != null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "Channel was cancelled";
        }
        this.closed = new j0(new IOException(message, th));
    }

    @Override // io.ktor.utils.io.p
    public final Object d(int i8, h5.c cVar) throws Throwable {
        Throwable thA = a();
        if (thA == null) {
            return Boolean.valueOf(this.f3227b.k(i8));
        }
        throw thA;
    }

    @Override // io.ktor.utils.io.p
    public final boolean e() {
        return this.f3227b.q();
    }
}
