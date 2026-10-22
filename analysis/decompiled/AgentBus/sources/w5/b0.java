package w5;

import java.util.List;

/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f10677a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10678b;

    /* renamed from: c, reason: collision with root package name */
    public final List f10679c;

    public b0(int i2, String str, List list) {
        this.f10677a = i2;
        this.f10678b = str;
        this.f10679c = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.f10677a == b0Var.f10677a && this.f10678b.equals(b0Var.f10678b) && this.f10679c.equals(b0Var.f10679c);
    }

    public final int hashCode() {
        return this.f10679c.hashCode() + m.x.g(this.f10678b, Integer.hashCode(this.f10677a) * 31, 31);
    }

    public final String toString() {
        return "PhaseInfo(phase=" + this.f10677a + ", title=" + this.f10678b + ", checkIds=" + this.f10679c + ")";
    }
}
