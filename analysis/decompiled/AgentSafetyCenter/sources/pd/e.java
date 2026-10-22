package pd;

import java.io.IOException;
import od.i0;
import od.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends q {

    /* renamed from: f, reason: collision with root package name */
    public final long f10006f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f10007g;

    /* renamed from: h, reason: collision with root package name */
    public long f10008h;

    public e(i0 i0Var, long j10, boolean z10) {
        this.f9480c = i0Var;
        this.f10006f = j10;
        this.f10007g = z10;
    }

    @Override // od.q, od.i0
    public final long l(od.i iVar, long j10) throws IOException {
        iVar.getClass();
        long j11 = this.f10008h;
        long j12 = this.f10006f;
        if (j11 > j12) {
            j10 = 0;
        } else if (this.f10007g) {
            long j13 = j12 - j11;
            if (j13 == 0) {
                return -1L;
            }
            j10 = Math.min(j10, j13);
        }
        long jL = this.f9480c.l(iVar, j10);
        if (jL != -1) {
            this.f10008h += jL;
        }
        long j14 = this.f10008h;
        if ((j14 >= j12 || jL != -1) && j14 <= j12) {
            return jL;
        }
        if (jL > 0 && j14 > j12) {
            long j15 = iVar.f9454f - (j14 - j12);
            od.i iVar2 = new od.i();
            iVar2.a0(iVar);
            iVar.f(iVar2, j15);
            iVar2.d();
        }
        throw new IOException("expected " + j12 + " bytes but got " + this.f10008h);
    }
}
