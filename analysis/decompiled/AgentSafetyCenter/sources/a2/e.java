package a2;

import java.util.Comparator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements Comparator {

    /* renamed from: f, reason: collision with root package name */
    public static final e f39f = new e(0);

    /* renamed from: g, reason: collision with root package name */
    public static final e f40g = new e(1);

    /* renamed from: h, reason: collision with root package name */
    public static final e f41h = new e(2);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f42c;

    public /* synthetic */ e(int i) {
        this.f42c = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f42c) {
            case 0:
                c1.c cVarH = ((p) obj).h();
                c1.c cVarH2 = ((p) obj2).h();
                int iCompare = Float.compare(cVarH.f2167a, cVarH2.f2167a);
                if (iCompare != 0) {
                    return iCompare;
                }
                int iCompare2 = Float.compare(cVarH.f2168b, cVarH2.f2168b);
                if (iCompare2 != 0) {
                    return iCompare2;
                }
                int iCompare3 = Float.compare(cVarH.f2170d, cVarH2.f2170d);
                return iCompare3 != 0 ? iCompare3 : Float.compare(cVarH.f2169c, cVarH2.f2169c);
            case 1:
                c1.c cVarH3 = ((p) obj).h();
                c1.c cVarH4 = ((p) obj2).h();
                int iCompare4 = Float.compare(cVarH4.f2169c, cVarH3.f2169c);
                if (iCompare4 != 0) {
                    return iCompare4;
                }
                int iCompare5 = Float.compare(cVarH3.f2168b, cVarH4.f2168b);
                if (iCompare5 != 0) {
                    return iCompare5;
                }
                int iCompare6 = Float.compare(cVarH3.f2170d, cVarH4.f2170d);
                return iCompare6 != 0 ? iCompare6 : Float.compare(cVarH4.f2167a, cVarH3.f2167a);
            default:
                jb.g gVar = (jb.g) obj;
                jb.g gVar2 = (jb.g) obj2;
                int iCompare7 = Float.compare(((c1.c) gVar.f6759c).f2168b, ((c1.c) gVar2.f6759c).f2168b);
                return iCompare7 != 0 ? iCompare7 : Float.compare(((c1.c) gVar.f6759c).f2170d, ((c1.c) gVar2.f6759c).f2170d);
        }
    }
}
