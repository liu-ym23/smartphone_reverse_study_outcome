package hb;

import b0.r1;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import v9.i0;
import v9.m0;
import v9.v0;

/* loaded from: classes.dex */
public final class k implements p7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4297f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f4298g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f4299h;

    public /* synthetic */ k(int i2, Object obj, Object obj2) {
        this.f4297f = i2;
        this.f4299h = obj;
        this.f4298g = obj2;
    }

    @Override // p7.a
    public final Object c() throws IOException {
        switch (this.f4297f) {
            case 0:
                p pVar = (p) this.f4299h;
                t tVar = (t) this.f4298g;
                try {
                } catch (IOException e10) {
                    pVar.a(2, 2, e10);
                } catch (Throwable th) {
                    pVar.a(3, 3, null);
                    bb.b.d(tVar);
                    throw th;
                }
                if (!tVar.a(true, this)) {
                    throw new IOException("Required SETTINGS preface not received");
                }
                while (tVar.a(false, this)) {
                }
                pVar.a(1, 9, null);
                bb.b.d(tVar);
                return c7.r.f1986a;
            case 1:
                i0.f10557g.getClass();
                i0 i0Var = i0.f10558h;
                m0 m0VarH = ((i8.h) this.f4299h).h();
                List list = Collections.EMPTY_LIST;
                r1 r1Var = new r1(1, this);
                u9.b bVar = u9.k.f10207e;
                q7.k.d(bVar, "NO_LOCKS");
                return v9.d.s(list, new o9.j(bVar, r1Var), i0Var, m0VarH, false);
            default:
                ea.f fVar = new ea.f();
                Iterator it = ((i8.u) this.f4299h).r().iterator();
                while (it.hasNext()) {
                    fVar.add(((f8.t) it.next()).d((v0) this.f4298g));
                }
                return fVar;
        }
    }
}
