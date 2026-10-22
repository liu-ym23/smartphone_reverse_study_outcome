package io.ktor.utils.io;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n0 implements p {

    /* renamed from: b, reason: collision with root package name */
    public final p f3219b;

    /* renamed from: c, reason: collision with root package name */
    public final j6.a f3220c;
    public long d;

    /* renamed from: e, reason: collision with root package name */
    public long f3221e;

    public n0(p delegate) {
        kotlin.jvm.internal.p.e(delegate, "delegate");
        this.f3219b = delegate;
        this.f3220c = new j6.a();
    }

    @Override // io.ktor.utils.io.p
    public final Throwable a() {
        return this.f3219b.a();
    }

    @Override // io.ktor.utils.io.p
    public final void c(Throwable th) {
        this.f3219b.c(th);
    }

    @Override // io.ktor.utils.io.p
    public final Object d(int i8, h5.c cVar) {
        return b().f3512c < ((long) i8) ? this.f3219b.d(i8, cVar) : Boolean.TRUE;
    }

    @Override // io.ktor.utils.io.p
    public final boolean e() {
        return this.f3220c.q() && this.f3219b.e();
    }

    @Override // io.ktor.utils.io.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final j6.a b() {
        g();
        j6.a aVarB = this.f3219b.b();
        j6.a aVar = this.f3220c;
        this.d += aVar.j(aVarB);
        return aVar;
    }

    public final void g() {
        long j4 = this.f3221e;
        long j8 = this.d;
        long j9 = this.f3220c.f3512c;
        this.f3221e = (j8 - j9) + j4;
        this.d = j9;
    }
}
