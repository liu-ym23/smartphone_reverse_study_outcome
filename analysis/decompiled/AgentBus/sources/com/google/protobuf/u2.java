package com.google.protobuf;

/* loaded from: classes.dex */
public final class u2 {
    public static o2 a(long j2, Object obj) {
        o2 o2Var = (o2) i4.f2400c.i(j2, obj);
        if (o2Var.isModifiable()) {
            return o2Var;
        }
        int size = o2Var.size();
        o2 o2VarMutableCopyWithCapacity = o2Var.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
        i4.p(j2, obj, o2VarMutableCopyWithCapacity);
        return o2VarMutableCopyWithCapacity;
    }
}
