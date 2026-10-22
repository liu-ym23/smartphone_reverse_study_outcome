package pb;

import java.io.IOException;
import ob.k0;
import ob.q;
import q7.k;

/* loaded from: classes.dex */
public final class e extends q {

    /* renamed from: g, reason: collision with root package name */
    public final long f8585g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f8586h;

    /* renamed from: i, reason: collision with root package name */
    public long f8587i;

    public e(k0 k0Var, long j2, boolean z4) {
        super(k0Var);
        this.f8585g = j2;
        this.f8586h = z4;
    }

    @Override // ob.k0
    public final long read(ob.h hVar, long j2) throws IOException {
        k.e(hVar, "sink");
        long j4 = this.f8587i;
        long j10 = this.f8585g;
        if (j4 > j10) {
            j2 = 0;
        } else if (this.f8586h) {
            long j11 = j10 - j4;
            if (j11 == 0) {
                return -1L;
            }
            j2 = Math.min(j2, j11);
        }
        long j12 = this.f8023f.read(hVar, j2);
        if (j12 != -1) {
            this.f8587i += j12;
        }
        long j13 = this.f8587i;
        if ((j13 >= j10 || j12 != -1) && j13 <= j10) {
            return j12;
        }
        if (j12 > 0 && j13 > j10) {
            long j14 = hVar.f7993g - (j13 - j10);
            ob.h hVar2 = new ob.h();
            hVar2.K(hVar);
            hVar.write(hVar2, j14);
            hVar2.a();
        }
        throw new IOException("expected " + j10 + " bytes but got " + this.f8587i);
    }
}
