package g9;

import d7.g0;
import f8.e0;
import f8.q0;
import i8.c0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: b, reason: collision with root package name */
    public static final b f3927b = new b(0);

    /* renamed from: c, reason: collision with root package name */
    public static final b f3928c = new b(1);

    /* renamed from: d, reason: collision with root package name */
    public static final b f3929d = new b(2);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3930a;

    public /* synthetic */ b(int i2) {
        this.f3930a = i2;
    }

    public static String b(f8.g gVar) {
        String strE0;
        e9.f name = gVar.getName();
        q7.k.d(name, "descriptor.name");
        String strD0 = a.a.d0(name);
        if (!(gVar instanceof q0)) {
            f8.j jVarP = gVar.p();
            q7.k.d(jVarP, "descriptor.containingDeclaration");
            if (jVarP instanceof f8.e) {
                strE0 = b((f8.g) jVarP);
            } else if (jVarP instanceof e0) {
                e9.e eVarI = ((c0) ((e0) jVarP)).f4758j.i();
                q7.k.d(eVarI, "descriptor.fqName.toUnsafe()");
                strE0 = a.a.e0(eVarI.e());
            } else {
                strE0 = null;
            }
            if (strE0 != null && !strE0.equals("")) {
                return strE0 + '.' + strD0;
            }
        }
        return strD0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [f8.g, f8.j] */
    /* JADX WARN: Type inference failed for: r1v5, types: [f8.j] */
    /* JADX WARN: Type inference failed for: r1v6, types: [f8.j] */
    @Override // g9.c
    public final String a(f8.g gVar, g gVar2) {
        switch (this.f3930a) {
            case 0:
                if (gVar instanceof q0) {
                    e9.f name = ((q0) gVar).getName();
                    q7.k.d(name, "classifier.name");
                    return gVar2.P(name, false);
                }
                e9.e eVarG = h9.f.g(gVar);
                q7.k.d(eVarG, "getFqName(classifier)");
                return gVar2.p(a.a.e0(eVarG.e()));
            case 1:
                if (gVar instanceof q0) {
                    e9.f name2 = ((q0) gVar).getName();
                    q7.k.d(name2, "classifier.name");
                    return gVar2.P(name2, false);
                }
                ArrayList arrayList = new ArrayList();
                do {
                    arrayList.add(gVar.getName());
                    gVar = gVar.p();
                } while (gVar instanceof f8.e);
                return a.a.e0(new g0(arrayList));
            default:
                return b(gVar);
        }
    }
}
