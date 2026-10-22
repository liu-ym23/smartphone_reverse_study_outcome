package com.stepos.common.widget;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: e, reason: collision with root package name */
    public static final p f11932e = new p(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f11933a;

    /* renamed from: c, reason: collision with root package name */
    public final int f11935c;

    /* renamed from: b, reason: collision with root package name */
    public final int f11934b = 0;

    /* renamed from: d, reason: collision with root package name */
    public final int f11936d = 0;

    public p(int i4, int i5) {
        this.f11933a = i4;
        this.f11935c = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        return this.f11936d == pVar.f11936d && this.f11933a == pVar.f11933a && this.f11935c == pVar.f11935c && this.f11934b == pVar.f11934b;
    }

    public final int hashCode() {
        return (((((this.f11933a * 31) + this.f11934b) * 31) + this.f11935c) * 31) + this.f11936d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Insets{left=");
        sb.append(this.f11933a);
        sb.append(", top=");
        sb.append(this.f11934b);
        sb.append(", right=");
        sb.append(this.f11935c);
        sb.append(", bottom=");
        return B0.g.o(sb, this.f11936d, '}');
    }
}
