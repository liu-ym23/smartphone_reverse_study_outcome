package s;

import java.lang.invoke.VarHandle;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final n6.a f10957a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f10958b;

    /* renamed from: c, reason: collision with root package name */
    public final i f10959c;

    /* renamed from: d, reason: collision with root package name */
    public final k0.k1 f10960d;

    /* renamed from: e, reason: collision with root package name */
    public final k0.k1 f10961e;

    /* renamed from: f, reason: collision with root package name */
    public final l0 f10962f;

    /* renamed from: g, reason: collision with root package name */
    public final n f10963g;

    /* renamed from: h, reason: collision with root package name */
    public final n f10964h;
    public final n i;

    /* renamed from: j, reason: collision with root package name */
    public final n f10965j;

    public c(Object obj, n6.a aVar, Float f5, int i) {
        f5 = (i & 4) != 0 ? null : f5;
        this.f10957a = aVar;
        this.f10958b = f5;
        i iVar = new i(aVar, obj, null, 60);
        this.f10959c = iVar;
        this.f10960d = k0.z.v(Boolean.FALSE);
        this.f10961e = k0.z.v(obj);
        l0 l0Var = new l0();
        l0Var.f11048a = new AtomicReference(null);
        l0Var.f11049b = new sc.c();
        VarHandle.storeStoreFence();
        this.f10962f = l0Var;
        new o0(1500.0f, f5);
        n nVar = iVar.f11022g;
        boolean z10 = nVar instanceof j;
        n nVar2 = z10 ? d.f10980e : nVar instanceof k ? d.f10981f : nVar instanceof l ? d.f10982g : d.f10983h;
        this.f10963g = nVar2;
        n nVar3 = z10 ? d.f10976a : nVar instanceof k ? d.f10977b : nVar instanceof l ? d.f10978c : d.f10979d;
        this.f10964h = nVar3;
        this.i = nVar2;
        this.f10965j = nVar3;
    }

    /* JADX WARN: Type inference failed for: r8v2, types: [xb.l, yb.l] */
    /* JADX WARN: Type inference failed for: r9v2, types: [xb.l, yb.l] */
    public static final Object a(c cVar, Object obj) {
        n6.a aVar = cVar.f10957a;
        n nVar = cVar.f10965j;
        n nVar2 = cVar.i;
        if (!yb.k.a(nVar2, cVar.f10963g) || !yb.k.a(nVar, cVar.f10964h)) {
            n nVar3 = (n) ((yb.l) aVar.f8776c).invoke(obj);
            int iB = nVar3.b();
            boolean z10 = false;
            for (int i = 0; i < iB; i++) {
                if (nVar3.a(i) < nVar2.a(i) || nVar3.a(i) > nVar.a(i)) {
                    nVar3.e(p5.f.p(nVar3.a(i), nVar2.a(i), nVar.a(i)), i);
                    z10 = true;
                }
            }
            if (z10) {
                return ((yb.l) aVar.f8777f).invoke(nVar3);
            }
        }
        return obj;
    }

    public static final void b(c cVar) {
        i iVar = cVar.f10959c;
        iVar.f11022g.d();
        iVar.f11023h = Long.MIN_VALUE;
        cVar.f10960d.setValue(Boolean.FALSE);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [xb.l, yb.l] */
    /* JADX WARN: Type inference failed for: r0v5, types: [xb.l, yb.l] */
    public static Object c(c cVar, Object obj, h hVar, xb.l lVar, pb.i iVar, int i) {
        Object objInvoke = ((yb.l) cVar.f10957a.f8777f).invoke(cVar.f10959c.f11022g);
        xb.l lVar2 = (i & 8) != 0 ? null : lVar;
        Object objD = cVar.d();
        n6.a aVar = cVar.f10957a;
        return l0.a(cVar.f10962f, new a(cVar, objInvoke, new w0(hVar, aVar, objD, obj, (n) ((yb.l) aVar.f8776c).invoke(objInvoke)), cVar.f10959c.f11023h, lVar2, null), iVar);
    }

    public final Object d() {
        return this.f10959c.f11021f.getValue();
    }

    public final Object e(Object obj, pb.i iVar) {
        Object objA = l0.a(this.f10962f, new b(this, obj, null), iVar);
        return objA == ob.a.f9351c ? objA : jb.v.f6774a;
    }
}
