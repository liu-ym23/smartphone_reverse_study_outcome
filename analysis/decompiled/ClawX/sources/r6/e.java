package r6;

import java.io.IOException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e implements c7.t {

    /* renamed from: a, reason: collision with root package name */
    public final c7.t f5129a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5130b;

    /* renamed from: c, reason: collision with root package name */
    public long f5131c;
    public boolean d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5132e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ g f5133f;

    public e(g gVar, c7.t delegate) {
        kotlin.jvm.internal.p.e(delegate, "delegate");
        this.f5133f = gVar;
        this.f5129a = delegate;
        this.d = true;
    }

    public final void a() {
        this.f5129a.close();
    }

    public final IOException b(IOException iOException) {
        if (this.f5130b) {
            return iOException;
        }
        this.f5130b = true;
        return g.a(this.f5133f, true, iOException, 4);
    }

    @Override // c7.t, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        if (this.f5132e) {
            return;
        }
        this.f5132e = true;
        try {
            a();
            b(null);
        } catch (IOException e9) {
            IOException iOExceptionB = b(e9);
            kotlin.jvm.internal.p.b(iOExceptionB);
            throw iOExceptionB;
        }
    }

    @Override // c7.t
    public final c7.x d() {
        return this.f5129a.d();
    }

    public final void e() {
        this.f5129a.flush();
    }

    @Override // c7.t, java.io.Flushable
    public final void flush() throws IOException {
        try {
            e();
        } catch (IOException e9) {
            IOException iOExceptionB = b(e9);
            kotlin.jvm.internal.p.b(iOExceptionB);
            throw iOExceptionB;
        }
    }

    public final String toString() {
        return e.class.getSimpleName() + '(' + this.f5129a + ')';
    }

    @Override // c7.t
    public final void x(long j4, c7.f fVar) throws IOException {
        if (this.f5132e) {
            throw new IllegalStateException("closed");
        }
        try {
            if (this.d) {
                this.d = false;
            }
            this.f5129a.x(j4, fVar);
            this.f5131c += j4;
        } catch (IOException e9) {
            IOException iOExceptionB = b(e9);
            kotlin.jvm.internal.p.b(iOExceptionB);
            throw iOExceptionB;
        }
    }
}
