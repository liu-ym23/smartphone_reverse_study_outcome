package androidx.datastore.preferences.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class f0 extends g0 {
    @Override // androidx.datastore.preferences.protobuf.g0
    public final void a(long j2, Object obj) {
        ((b) ((x) s1.f949c.i(j2, obj))).f805f = false;
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public final void b(long j2, Object obj, Object obj2) {
        r1 r1Var = s1.f949c;
        x xVarMutableCopyWithCapacity = (x) r1Var.i(j2, obj);
        x xVar = (x) r1Var.i(j2, obj2);
        int size = xVarMutableCopyWithCapacity.size();
        int size2 = xVar.size();
        if (size > 0 && size2 > 0) {
            if (!((b) xVarMutableCopyWithCapacity).f805f) {
                xVarMutableCopyWithCapacity = xVarMutableCopyWithCapacity.mutableCopyWithCapacity(size2 + size);
            }
            xVarMutableCopyWithCapacity.addAll(xVar);
        }
        if (size > 0) {
            xVar = xVarMutableCopyWithCapacity;
        }
        s1.p(j2, obj, xVar);
    }

    @Override // androidx.datastore.preferences.protobuf.g0
    public final List c(long j2, Object obj) {
        x xVar = (x) s1.f949c.i(j2, obj);
        if (((b) xVar).f805f) {
            return xVar;
        }
        int size = xVar.size();
        x xVarMutableCopyWithCapacity = xVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
        s1.p(j2, obj, xVarMutableCopyWithCapacity);
        return xVarMutableCopyWithCapacity;
    }
}
