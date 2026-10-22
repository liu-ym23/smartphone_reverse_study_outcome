package eb;

import java.io.IOException;
import java.net.ProtocolException;
import ob.k0;
import ob.q;

/* loaded from: classes.dex */
public final class d extends q {

    /* renamed from: g, reason: collision with root package name */
    public final long f3252g;

    /* renamed from: h, reason: collision with root package name */
    public long f3253h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3254i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3255j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3256k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ c1.o f3257l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c1.o oVar, k0 k0Var, long j2) {
        super(k0Var);
        q7.k.e(k0Var, "delegate");
        this.f3257l = oVar;
        this.f3252g = j2;
        this.f3254i = true;
        if (j2 == 0) {
            a(null);
        }
    }

    public final IOException a(IOException iOException) {
        if (this.f3255j) {
            return iOException;
        }
        this.f3255j = true;
        if (iOException == null && this.f3254i) {
            this.f3254i = false;
        }
        return this.f3257l.a(true, false, iOException);
    }

    @Override // ob.q, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f3256k) {
            return;
        }
        this.f3256k = true;
        try {
            super.close();
            a(null);
        } catch (IOException e10) {
            throw a(e10);
        }
    }

    @Override // ob.k0
    public final long read(ob.h hVar, long j2) throws IOException {
        q7.k.e(hVar, "sink");
        if (this.f3256k) {
            throw new IllegalStateException("closed");
        }
        try {
            long j4 = this.f8023f.read(hVar, j2);
            if (this.f3254i) {
                this.f3254i = false;
            }
            if (j4 == -1) {
                a(null);
                return -1L;
            }
            long j10 = this.f3253h + j4;
            long j11 = this.f3252g;
            if (j11 == -1 || j10 <= j11) {
                this.f3253h = j10;
                if (j10 == j11) {
                    a(null);
                }
                return j4;
            }
            throw new ProtocolException("expected " + j11 + " bytes but received " + j10);
        } catch (IOException e10) {
            throw a(e10);
        }
    }
}
