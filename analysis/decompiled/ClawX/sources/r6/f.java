package r6;

import java.io.IOException;
import java.net.ProtocolException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f implements c7.v {

    /* renamed from: a, reason: collision with root package name */
    public final c7.v f5134a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5135b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5136c;
    public long d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5137e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5138f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5139g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ g f5140h;

    public f(g gVar, c7.v delegate, long j4, boolean z) {
        kotlin.jvm.internal.p.e(delegate, "delegate");
        this.f5140h = gVar;
        this.f5134a = delegate;
        this.f5135b = j4;
        this.f5136c = z;
        this.f5137e = true;
        if (j4 == 0) {
            b(null);
        }
    }

    public final void a() throws IOException {
        this.f5134a.close();
    }

    public final IOException b(IOException iOException) {
        if (this.f5138f) {
            return iOException;
        }
        this.f5138f = true;
        if (iOException == null && this.f5137e) {
            this.f5137e = false;
        }
        return g.a(this.f5140h, this.f5136c, iOException, 8);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f5139g) {
            return;
        }
        this.f5139g = true;
        try {
            a();
            b(null);
        } catch (IOException e9) {
            IOException iOExceptionB = b(e9);
            kotlin.jvm.internal.p.b(iOExceptionB);
            throw iOExceptionB;
        }
    }

    @Override // c7.v, c7.t
    public final c7.x d() {
        return this.f5134a.d();
    }

    @Override // c7.v
    public final long h(long j4, c7.f fVar) throws IOException {
        g gVar = this.f5140h;
        if (this.f5139g) {
            throw new IllegalStateException("closed");
        }
        try {
            long jH = this.f5134a.h(8192L, fVar);
            if (this.f5137e) {
                this.f5137e = false;
            }
            if (jH == -1) {
                b(null);
                return -1L;
            }
            long j8 = this.d + jH;
            long j9 = this.f5135b;
            if (j9 == -1 || j8 <= j9) {
                this.d = j8;
                if (gVar.f5143c.c()) {
                    b(null);
                }
                return jH;
            }
            throw new ProtocolException("expected " + j9 + " bytes but received " + j8);
        } catch (IOException e9) {
            IOException iOExceptionB = b(e9);
            kotlin.jvm.internal.p.b(iOExceptionB);
            throw iOExceptionB;
        }
    }

    public final String toString() {
        return f.class.getSimpleName() + '(' + this.f5134a + ')';
    }
}
