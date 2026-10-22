package ed;

import ad.e0;
import ad.r;
import ad.w;
import java.io.IOException;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements r {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3769a = new a();

    @Override // ad.r
    public final e0 a(fd.f fVar) throws IOException {
        j jVar = fVar.f4062a;
        synchronized (jVar) {
            try {
                if (!jVar.f3811p) {
                    throw new IllegalStateException("released");
                }
                if (jVar.f3810o) {
                    throw new IllegalStateException("Check failed.");
                }
                if (jVar.f3809n) {
                    throw new IllegalStateException("Check failed.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        f fVar2 = jVar.f3806k;
        fVar2.getClass();
        w wVar = jVar.f3801c;
        wVar.getClass();
        try {
            fd.d dVarI = fVar2.a(fVar.f4067f, fVar.f4068g, fVar.f4069h, wVar.f607j, !yb.k.a((String) fVar.f4066e.f638c, "GET")).i(wVar, fVar);
            e eVar = new e();
            eVar.f3784b = jVar;
            eVar.f3785c = fVar2;
            eVar.f3786d = dVarI;
            eVar.f3787e = dVarI.d();
            VarHandle.storeStoreFence();
            jVar.f3808m = eVar;
            jVar.f3813r = eVar;
            synchronized (jVar) {
                jVar.f3809n = true;
                jVar.f3810o = true;
            }
            if (!jVar.f3812q) {
                return fd.f.a(fVar, 0, eVar, null, 61).b(fVar.f4066e);
            }
            od.f.l("Canceled");
            return null;
        } catch (n e10) {
            fVar2.b(e10.f3836f);
            throw e10;
        } catch (IOException e11) {
            fVar2.b(e11);
            n nVar = new n(e11);
            nVar.f3835c = e11;
            nVar.f3836f = e11;
            throw nVar;
        }
    }
}
