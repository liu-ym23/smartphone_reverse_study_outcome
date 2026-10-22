package r6;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements n6.n {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5105a = new a();

    @Override // n6.n
    public final n6.u a(s6.h hVar) throws IOException {
        s6.f fVar;
        o oVar = hVar.f5245a;
        synchronized (oVar) {
            if (!oVar.f5170p) {
                throw new IllegalStateException("released");
            }
            if (oVar.f5167m || oVar.f5166l || oVar.f5169o || oVar.f5168n) {
                throw new IllegalStateException("Check failed.");
            }
        }
        h hVar2 = oVar.f5162g;
        kotlin.jvm.internal.p.b(hVar2);
        p pVarA = hVar2.a();
        n6.q qVar = oVar.f5157a;
        pVarA.getClass();
        int i8 = hVar.f5250g;
        a4.d dVar = pVarA.f5179h;
        u6.n nVar = pVarA.f5181j;
        if (nVar != null) {
            fVar = new u6.o(qVar, pVarA, hVar, nVar);
        } else {
            pVarA.f5176e.setSoTimeout(i8);
            c7.x xVarD = ((c7.p) dVar.f97c).f1184a.d();
            long j4 = i8;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            xVarD.g(j4, timeUnit);
            ((c7.o) dVar.d).f1181a.d().g(hVar.f5251h, timeUnit);
            fVar = new t6.f(qVar, pVarA, dVar);
        }
        g gVar = new g(oVar, hVar2, fVar);
        oVar.f5165k = gVar;
        oVar.f5172r = gVar;
        synchronized (oVar) {
            oVar.f5166l = true;
            oVar.f5167m = true;
        }
        if (oVar.f5171q) {
            throw new IOException("Canceled");
        }
        return s6.h.a(hVar, 0, gVar, null, 61).b(hVar.f5248e);
    }
}
