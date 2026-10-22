package c0;

import b0.s2;
import i1.a1;
import java.util.List;

/* loaded from: classes.dex */
public final class g extends b9.d {

    /* renamed from: d, reason: collision with root package name */
    public static final g f1737d = new g(0, 2, 1);

    @Override // b9.d
    public final void c(androidx.datastore.preferences.protobuf.k kVar, b0.c cVar, s2 s2Var, a1 a1Var, h0 h0Var) {
        int i2 = ((j0.e) kVar.c(0)).f5076a;
        List list = (List) kVar.c(1);
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = list.get(i10);
            int i11 = i2 + i10;
            cVar.a(i11, obj);
            cVar.e(i11, obj);
        }
    }
}
