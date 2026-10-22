package td;

import java.io.IOException;
import sd.e0;
import sd.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends n {

    /* renamed from: a, reason: collision with root package name */
    public final long f13082a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f13083b;

    /* renamed from: c, reason: collision with root package name */
    public long f13084c;

    public e(e0 e0Var, long j10, boolean z) {
        super(e0Var);
        this.f13082a = j10;
        this.f13083b = z;
    }

    @Override // sd.n, sd.e0
    public final long read(sd.e sink, long j10) throws IOException {
        kotlin.jvm.internal.g.f(sink, "sink");
        long j11 = this.f13084c;
        long j12 = this.f13082a;
        if (j11 > j12) {
            j10 = 0;
        } else if (this.f13083b) {
            long j13 = j12 - j11;
            if (j13 == 0) {
                return -1L;
            }
            j10 = Math.min(j10, j13);
        }
        long j14 = super.read(sink, j10);
        if (j14 != -1) {
            this.f13084c += j14;
        }
        long j15 = this.f13084c;
        if ((j15 >= j12 || j14 != -1) && j15 <= j12) {
            return j14;
        }
        if (j14 > 0 && j15 > j12) {
            long j16 = sink.f11926b - (j15 - j12);
            sd.e eVar = new sd.e();
            eVar.u(sink);
            sink.j0(eVar, j16);
            eVar.o();
        }
        StringBuilder sbQ = ai.onnxruntime.a.q(j12, "expected ", " bytes but got ");
        sbQ.append(this.f13084c);
        throw new IOException(sbQ.toString());
    }
}
