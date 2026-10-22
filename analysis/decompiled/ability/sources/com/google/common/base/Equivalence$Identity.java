package com.google.common.base;

import java.io.Serializable;

/* loaded from: classes3.dex */
final class Equivalence$Identity extends a implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final Equivalence$Identity f2721a = new Equivalence$Identity();

    private Object readResolve() {
        return f2721a;
    }

    @Override // com.google.common.base.a
    public final boolean a(Object obj, Object obj2) {
        return false;
    }

    @Override // com.google.common.base.a
    public final int b(Object obj) {
        return System.identityHashCode(obj);
    }
}
