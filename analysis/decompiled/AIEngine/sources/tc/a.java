package tc;

import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a<Element, Collection, Builder> implements pc.a<Collection> {
    @Override // pc.a
    public Collection b(sc.d dVar) {
        return (Collection) i(dVar);
    }

    public abstract Builder e();

    public abstract int f(Builder builder);

    public abstract Iterator<Element> g(Collection collection);

    public abstract int h(Collection collection);

    public final Object i(sc.d dVar) {
        Builder builderE = e();
        int iF = f(builderE);
        sc.b bVarB = dVar.b(d());
        while (true) {
            int iF2 = bVarB.f(d());
            if (iF2 == -1) {
                bVarB.a(d());
                return l(builderE);
            }
            j(bVarB, iF2 + iF, builderE);
        }
    }

    public abstract void j(sc.b bVar, int i10, Object obj);

    public abstract Builder k(Collection collection);

    public abstract Collection l(Builder builder);
}
