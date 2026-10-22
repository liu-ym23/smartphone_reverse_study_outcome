package com.google.common.base;

/* loaded from: classes3.dex */
public abstract class a {
    public static a c() {
        return Equivalence$Equals.f2720a;
    }

    public static a e() {
        return Equivalence$Identity.f2721a;
    }

    public abstract boolean a(Object obj, Object obj2);

    public abstract int b(Object obj);

    public final boolean d(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return a(obj, obj2);
    }
}
