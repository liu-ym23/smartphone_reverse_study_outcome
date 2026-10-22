package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;
import k3.c;
import l3.C1658b;

/* loaded from: classes3.dex */
class Suppliers$SupplierOfInstance<T> implements c, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final C1658b f2722a;

    public Suppliers$SupplierOfInstance(C1658b c1658b) {
        this.f2722a = c1658b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Suppliers$SupplierOfInstance)) {
            return false;
        }
        Object obj2 = ((Suppliers$SupplierOfInstance) obj).f2722a;
        C1658b c1658b = this.f2722a;
        return c1658b == obj2 || c1658b.equals(obj2);
    }

    @Override // k3.c
    public final Object get() {
        return this.f2722a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2722a});
    }

    public final String toString() {
        return "Suppliers.ofInstance(" + this.f2722a + ")";
    }
}
