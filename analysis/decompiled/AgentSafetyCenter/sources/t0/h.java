package t0;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;
import p.f0;
import p.n0;
import p5.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h implements g {

    /* renamed from: c, reason: collision with root package name */
    public xb.l f13117c;

    /* renamed from: f, reason: collision with root package name */
    public f0 f13118f;

    /* renamed from: g, reason: collision with root package name */
    public f0 f13119g;

    @Override // t0.g
    public final boolean a(Object obj) {
        return ((Boolean) this.f13117c.invoke(obj)).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008e  */
    @Override // t0.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map b() {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t0.h.b():java.util.Map");
    }

    @Override // t0.g
    public final Object c(String str) {
        f0 f0Var = this.f13118f;
        List list = f0Var != null ? (List) f0Var.k(str) : null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (list.size() > 1 && f0Var != null) {
            List listSubList = list.subList(1, list.size());
            int iF = f0Var.f(str);
            if (iF < 0) {
                iF = ~iF;
            }
            Object[] objArr = f0Var.f9554c;
            Object obj = objArr[iF];
            f0Var.f9553b[iF] = str;
            objArr[iF] = listSubList;
        }
        return list.get(0);
    }

    @Override // t0.g
    public final f d(String str, xb.a aVar) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!com.stepos.statsrpk.h.v(str.charAt(i))) {
                f0 f0Var = this.f13119g;
                if (f0Var == null) {
                    long[] jArr = n0.f9597a;
                    f0Var = new f0();
                    this.f13119g = f0Var;
                }
                Object objG = f0Var.g(str);
                if (objG == null) {
                    objG = new ArrayList();
                    f0Var.m(str, objG);
                }
                ((List) objG).add(aVar);
                m mVar = new m(18);
                mVar.f9741f = f0Var;
                mVar.f9742g = str;
                mVar.f9743h = aVar;
                VarHandle.storeStoreFence();
                return mVar;
            }
        }
        g5.f.s("Registered key is empty or blank");
        return null;
    }
}
