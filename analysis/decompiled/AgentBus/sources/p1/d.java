package p1;

import java.util.Comparator;

/* loaded from: classes.dex */
public final class d implements Comparator {

    /* renamed from: b, reason: collision with root package name */
    public static final d f8270b = new d(0);

    /* renamed from: c, reason: collision with root package name */
    public static final d f8271c = new d(1);

    /* renamed from: d, reason: collision with root package name */
    public static final d f8272d = new d(2);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8273a;

    public /* synthetic */ d(int i2) {
        this.f8273a = i2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f8273a) {
            case 0:
                t0.c cVarH = ((n) obj).h();
                t0.c cVarH2 = ((n) obj2).h();
                int iCompare = Float.compare(cVarH.f9656a, cVarH2.f9656a);
                if (iCompare != 0) {
                    return iCompare;
                }
                int iCompare2 = Float.compare(cVarH.f9657b, cVarH2.f9657b);
                if (iCompare2 != 0) {
                    return iCompare2;
                }
                int iCompare3 = Float.compare(cVarH.f9659d, cVarH2.f9659d);
                return iCompare3 != 0 ? iCompare3 : Float.compare(cVarH.f9658c, cVarH2.f9658c);
            case 1:
                t0.c cVarH3 = ((n) obj).h();
                t0.c cVarH4 = ((n) obj2).h();
                int iCompare4 = Float.compare(cVarH4.f9658c, cVarH3.f9658c);
                if (iCompare4 != 0) {
                    return iCompare4;
                }
                int iCompare5 = Float.compare(cVarH3.f9657b, cVarH4.f9657b);
                if (iCompare5 != 0) {
                    return iCompare5;
                }
                int iCompare6 = Float.compare(cVarH3.f9659d, cVarH4.f9659d);
                return iCompare6 != 0 ? iCompare6 : Float.compare(cVarH4.f9656a, cVarH3.f9656a);
            default:
                c7.j jVar = (c7.j) obj;
                c7.j jVar2 = (c7.j) obj2;
                int iCompare7 = Float.compare(((t0.c) jVar.f1973f).f9657b, ((t0.c) jVar2.f1973f).f9657b);
                return iCompare7 != 0 ? iCompare7 : Float.compare(((t0.c) jVar.f1973f).f9659d, ((t0.c) jVar2.f1973f).f9659d);
        }
    }
}
