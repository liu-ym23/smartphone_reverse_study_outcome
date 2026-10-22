package com.typesafe.config.impl;

import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes4.dex */
public final class A {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractConfigValue f31720a;

    /* renamed from: b, reason: collision with root package name */
    public final D f31721b;

    public A(AbstractConfigValue abstractConfigValue, D d10) {
        this.f31720a = abstractConfigValue;
        this.f31721b = d10;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof A) {
            A a10 = (A) obj;
            if (a10.f31720a != this.f31720a) {
                return false;
            }
            D d10 = a10.f31721b;
            D d11 = this.f31721b;
            if (d10 == d11) {
                return true;
            }
            if (d10 != null && d11 != null) {
                return d10.equals(d11);
            }
        }
        return false;
    }

    public final int hashCode() {
        int iIdentityHashCode = System.identityHashCode(this.f31720a);
        D d10 = this.f31721b;
        return d10 != null ? iIdentityHashCode + ((d10.hashCode() + 41) * 41) : iIdentityHashCode;
    }

    public final String toString() {
        return "MemoKey(" + this.f31720a + "@" + System.identityHashCode(this.f31720a) + Const.STR_MART_COMMA + this.f31721b + ")";
    }
}
