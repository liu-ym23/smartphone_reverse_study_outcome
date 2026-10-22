package com.google.common.base;

import java.io.Serializable;

/* loaded from: classes3.dex */
final class Equivalence$Equals extends a implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final Equivalence$Equals f2720a = new Equivalence$Equals();

    private Object readResolve() {
        return f2720a;
    }

    @Override // com.google.common.base.a
    public final boolean a(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    @Override // com.google.common.base.a
    public final int b(Object obj) {
        return obj.hashCode();
    }
}
