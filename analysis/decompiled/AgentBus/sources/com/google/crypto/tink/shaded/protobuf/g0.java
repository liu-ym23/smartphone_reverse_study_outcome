package com.google.crypto.tink.shaded.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public final class g0 extends h0 {
    @Override // com.google.crypto.tink.shaded.protobuf.h0
    public final void a(long j2, Object obj) {
        ((b) ((y) m1.f2246c.i(j2, obj))).f2176f = false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h0
    public final void b(long j2, Object obj, Object obj2) {
        l1 l1Var = m1.f2246c;
        y yVarMutableCopyWithCapacity = (y) l1Var.i(j2, obj);
        y yVar = (y) l1Var.i(j2, obj2);
        int size = yVarMutableCopyWithCapacity.size();
        int size2 = yVar.size();
        if (size > 0 && size2 > 0) {
            if (!((b) yVarMutableCopyWithCapacity).f2176f) {
                yVarMutableCopyWithCapacity = yVarMutableCopyWithCapacity.mutableCopyWithCapacity(size2 + size);
            }
            yVarMutableCopyWithCapacity.addAll(yVar);
        }
        if (size > 0) {
            yVar = yVarMutableCopyWithCapacity;
        }
        m1.p(j2, obj, yVar);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.h0
    public final List c(long j2, Object obj) {
        y yVar = (y) m1.f2246c.i(j2, obj);
        if (((b) yVar).f2176f) {
            return yVar;
        }
        int size = yVar.size();
        y yVarMutableCopyWithCapacity = yVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
        m1.p(j2, obj, yVarMutableCopyWithCapacity);
        return yVarMutableCopyWithCapacity;
    }
}
