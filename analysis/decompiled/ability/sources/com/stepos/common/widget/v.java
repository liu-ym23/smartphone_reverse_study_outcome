package com.stepos.common.widget;

/* loaded from: classes3.dex */
public final class v {
    public static final v c = new v(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f3814a;
    public final int b;

    public v(int i, int i6) {
        this.f3814a = i;
        this.b = i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v.class != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        return this.f3814a == vVar.f3814a && this.b == vVar.b;
    }

    public final int hashCode() {
        return ((this.f3814a * 961) + this.b) * 31;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Insets{left=");
        sb.append(this.f3814a);
        sb.append(", top=0, right=");
        return androidx.appfunctions.metadata.a.o(sb, ", bottom=0}", this.b);
    }
}
