package com.google.protobuf;

import java.util.AbstractList;

/* loaded from: classes.dex */
public final class n2 extends AbstractList {

    /* renamed from: f, reason: collision with root package name */
    public final Internal$IntList f2458f;

    /* renamed from: g, reason: collision with root package name */
    public final m2 f2459g;

    public n2(Internal$IntList internal$IntList, m2 m2Var) {
        this.f2458f = internal$IntList;
        this.f2459g = m2Var;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        int i10 = this.f2458f.getInt(i2);
        ((i) this.f2459g).getClass();
        w0 w0VarA = w0.a(i10);
        return w0VarA == null ? w0.TARGET_TYPE_UNKNOWN : w0VarA;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2458f.size();
    }
}
