package fd;

import ad.e0;
import ad.q;
import ad.r;
import ad.z;
import ed.j;
import java.util.ArrayList;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final j f4062a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f4063b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4064c;

    /* renamed from: d, reason: collision with root package name */
    public final ed.e f4065d;

    /* renamed from: e, reason: collision with root package name */
    public final z f4066e;

    /* renamed from: f, reason: collision with root package name */
    public final int f4067f;

    /* renamed from: g, reason: collision with root package name */
    public final int f4068g;

    /* renamed from: h, reason: collision with root package name */
    public final int f4069h;
    public int i;

    public f(j jVar, ArrayList arrayList, int i, ed.e eVar, z zVar, int i3, int i10, int i11) {
        zVar.getClass();
        this.f4062a = jVar;
        this.f4063b = arrayList;
        this.f4064c = i;
        this.f4065d = eVar;
        this.f4066e = zVar;
        this.f4067f = i3;
        this.f4068g = i10;
        this.f4069h = i11;
    }

    public static f a(f fVar, int i, ed.e eVar, z zVar, int i3) {
        if ((i3 & 1) != 0) {
            i = fVar.f4064c;
        }
        int i10 = i;
        if ((i3 & 2) != 0) {
            eVar = fVar.f4065d;
        }
        ed.e eVar2 = eVar;
        if ((i3 & 4) != 0) {
            zVar = fVar.f4066e;
        }
        z zVar2 = zVar;
        int i11 = fVar.f4067f;
        int i12 = fVar.f4068g;
        int i13 = fVar.f4069h;
        zVar2.getClass();
        return new f(fVar.f4062a, fVar.f4063b, i10, eVar2, zVar2, i11, i12, i13);
    }

    public final e0 b(z zVar) {
        zVar.getClass();
        ArrayList arrayList = this.f4063b;
        int size = arrayList.size();
        int i = this.f4064c;
        if (i >= size) {
            od.f.e("Check failed.");
            return null;
        }
        this.i++;
        ed.e eVar = this.f4065d;
        if (eVar != null) {
            ed.f fVar = (ed.f) eVar.f3785c;
            q qVar = (q) zVar.f637b;
            fVar.getClass();
            qVar.getClass();
            q qVar2 = fVar.f3789b.f428h;
            if (qVar.f563e != qVar2.f563e || !k.a(qVar.f562d, qVar2.f562d)) {
                od.f.r("network interceptor ", arrayList.get(i - 1), " must retain the same host and port");
                return null;
            }
            if (this.i != 1) {
                od.f.r("network interceptor ", arrayList.get(i - 1), " must call proceed() exactly once");
                return null;
            }
        }
        int i3 = i + 1;
        f fVarA = a(this, i3, null, zVar, 58);
        r rVar = (r) arrayList.get(i);
        e0 e0VarA = rVar.a(fVarA);
        if (e0VarA == null) {
            throw new NullPointerException("interceptor " + rVar + " returned null");
        }
        if (eVar != null && i3 < arrayList.size() && fVarA.i != 1) {
            od.f.r("network interceptor ", rVar, " must call proceed() exactly once");
            return null;
        }
        if (e0VarA.f473k != null) {
            return e0VarA;
        }
        od.f.r("interceptor ", rVar, " returned a response with no body");
        return null;
    }
}
