package androidx.datastore.preferences.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class K extends L {
    @Override // androidx.datastore.preferences.protobuf.L
    public final void a(long j4, Object obj) {
        ((AbstractC0249c) ((C) z0.f3558d.i(j4, obj))).f3464a = false;
    }

    @Override // androidx.datastore.preferences.protobuf.L
    public final void b(long j4, Object obj, Object obj2) {
        y0 y0Var = z0.f3558d;
        C cB = (C) y0Var.i(j4, obj);
        C c4 = (C) y0Var.i(j4, obj2);
        int size = cB.size();
        int size2 = c4.size();
        if (size > 0 && size2 > 0) {
            if (!((AbstractC0249c) cB).f3464a) {
                cB = cB.b(size2 + size);
            }
            cB.addAll(c4);
        }
        if (size > 0) {
            c4 = cB;
        }
        z0.r(j4, obj, c4);
    }

    @Override // androidx.datastore.preferences.protobuf.L
    public final List c(long j4, Object obj) {
        C c4 = (C) z0.f3558d.i(j4, obj);
        if (((AbstractC0249c) c4).f3464a) {
            return c4;
        }
        int size = c4.size();
        C cB = c4.b(size == 0 ? 10 : size * 2);
        z0.r(j4, obj, cB);
        return cB;
    }
}
