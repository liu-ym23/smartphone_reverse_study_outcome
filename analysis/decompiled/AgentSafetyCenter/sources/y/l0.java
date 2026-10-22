package y;

import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import k0.k1;
import k0.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l0 implements t0.g, t0.c {

    /* renamed from: c, reason: collision with root package name */
    public final t0.h f15785c;

    /* renamed from: f, reason: collision with root package name */
    public final k1 f15786f = k0.z.v(null);

    /* renamed from: g, reason: collision with root package name */
    public final LinkedHashSet f15787g = new LinkedHashSet();

    public l0(t0.g gVar, Map map) {
        this.f15785c = t0.i.a(map, new j0(gVar, 0));
    }

    @Override // t0.g
    public final boolean a(Object obj) {
        return this.f15785c.a(obj);
    }

    @Override // t0.g
    public final Map b() {
        t0.c cVar = (t0.c) this.f15786f.getValue();
        if (cVar != null) {
            Iterator it = this.f15787g.iterator();
            while (it.hasNext()) {
                cVar.f(it.next());
            }
        }
        return this.f15785c.b();
    }

    @Override // t0.g
    public final Object c(String str) {
        return this.f15785c.c(str);
    }

    @Override // t0.g
    public final t0.f d(String str, xb.a aVar) {
        return this.f15785c.d(str, aVar);
    }

    @Override // t0.c
    public final void e(Object obj, s0.c cVar, k0.s sVar, int i) {
        int i3;
        sVar.Z(-697180401);
        if ((i & 6) == 0) {
            i3 = (sVar.h(obj) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= sVar.h(cVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= sVar.h(this) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if ((i3 & 147) == 146 && sVar.B()) {
            sVar.S();
        } else {
            t0.c cVar2 = (t0.c) this.f15786f.getValue();
            if (cVar2 == null) {
                g5.f.s("null wrappedHolder");
                return;
            }
            cVar2.e(obj, cVar, sVar, i3 & 126);
            boolean zH = sVar.h(this) | sVar.h(obj);
            Object objM = sVar.M();
            if (zH || objM == k0.m.f6974a) {
                objM = new v1.i0(9, this, obj);
                sVar.i0(objM);
            }
            k0.z.d(obj, (xb.l) objM, sVar);
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new b0.u(this, obj, cVar, i, 3);
        }
    }

    @Override // t0.c
    public final void f(Object obj) {
        t0.c cVar = (t0.c) this.f15786f.getValue();
        if (cVar != null) {
            cVar.f(obj);
        } else {
            g5.f.s("null wrappedHolder");
        }
    }
}
