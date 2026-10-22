package com.typesafe.config.impl;

/* loaded from: classes4.dex */
public final class P {

    /* renamed from: a, reason: collision with root package name */
    public final D f31781a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f31782b;

    public P(D d10, boolean z10) {
        this.f31781a = d10;
        this.f31782b = z10;
    }

    public P a(D d10) {
        return d10 == this.f31781a ? this : new P(d10, this.f31782b);
    }

    public boolean b() {
        return this.f31782b;
    }

    public D c() {
        return this.f31781a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof P) {
            P p10 = (P) obj;
            if (p10.f31781a.equals(this.f31781a) && p10.f31782b == this.f31782b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f31781a.hashCode() + 41) * 41) + (this.f31782b ? 1 : 0)) * 41;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("${");
        sb2.append(this.f31782b ? "?" : "");
        sb2.append(this.f31781a.k());
        sb2.append("}");
        return sb2.toString();
    }
}
