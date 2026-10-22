package eb;

import java.io.IOException;
import java.net.ProtocolException;
import ob.i0;

/* loaded from: classes.dex */
public final class c extends ob.p {

    /* renamed from: f, reason: collision with root package name */
    public final long f3247f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3248g;

    /* renamed from: h, reason: collision with root package name */
    public long f3249h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3250i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ c1.o f3251j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c1.o oVar, i0 i0Var, long j2) {
        super(i0Var);
        q7.k.e(i0Var, "delegate");
        this.f3251j = oVar;
        this.f3247f = j2;
    }

    public final IOException a(IOException iOException) {
        if (this.f3248g) {
            return iOException;
        }
        this.f3248g = true;
        return this.f3251j.a(false, true, iOException);
    }

    @Override // ob.p, ob.i0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f3250i) {
            return;
        }
        this.f3250i = true;
        long j2 = this.f3247f;
        if (j2 != -1 && this.f3249h != j2) {
            throw new ProtocolException("unexpected end of stream");
        }
        try {
            super.close();
            a(null);
        } catch (IOException e10) {
            throw a(e10);
        }
    }

    @Override // ob.p, ob.i0, java.io.Flushable
    public final void flush() throws IOException {
        try {
            super.flush();
        } catch (IOException e10) {
            throw a(e10);
        }
    }

    @Override // ob.p, ob.i0
    public final void write(ob.h hVar, long j2) throws IOException {
        q7.k.e(hVar, "source");
        if (this.f3250i) {
            throw new IllegalStateException("closed");
        }
        long j4 = this.f3247f;
        if (j4 == -1 || this.f3249h + j2 <= j4) {
            try {
                super.write(hVar, j2);
                this.f3249h += j2;
                return;
            } catch (IOException e10) {
                throw a(e10);
            }
        }
        throw new ProtocolException("expected " + j4 + " bytes but received " + (this.f3249h + j2));
    }
}
