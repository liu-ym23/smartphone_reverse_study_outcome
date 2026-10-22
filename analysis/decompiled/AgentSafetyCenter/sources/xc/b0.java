package xc;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b0 implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15607c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ c0 f15608f;

    public /* synthetic */ b0(int i) {
        this.f15607c = i;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, jb.d] */
    @Override // xb.a
    public final Object invoke() {
        tc.a[] aVarArrChildSerializers;
        ArrayList arrayList;
        tc.a[] aVarArrTypeParametersSerializers;
        int i = this.f15607c;
        c0 c0Var = this.f15608f;
        switch (i) {
            case 0:
                n nVar = c0Var.f15612b;
                return (nVar == null || (aVarArrChildSerializers = nVar.childSerializers()) == null) ? a0.f15605b : aVarArrChildSerializers;
            case 1:
                n nVar2 = c0Var.f15612b;
                if (nVar2 == null || (aVarArrTypeParametersSerializers = nVar2.typeParametersSerializers()) == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(aVarArrTypeParametersSerializers.length);
                    for (tc.a aVar : aVarArrTypeParametersSerializers) {
                        arrayList.add(aVar.getDescriptor());
                    }
                }
                return a0.c(arrayList);
            default:
                return Integer.valueOf(a0.d(c0Var, (vc.e[]) c0Var.f15619j.getValue()));
        }
    }
}
