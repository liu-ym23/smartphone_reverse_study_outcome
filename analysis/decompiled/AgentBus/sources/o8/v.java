package o8;

import java.util.Map;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final b0 f7852a;

    /* renamed from: b, reason: collision with root package name */
    public final b0 f7853b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f7854c = d7.a0.f2944f;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f7855d;

    public v(b0 b0Var, b0 b0Var2) {
        this.f7852a = b0Var;
        this.f7853b = b0Var2;
        s7.a.H(new a8.c(18, this));
        b0 b0Var3 = b0.IGNORE;
        this.f7855d = b0Var == b0Var3 && b0Var2 == b0Var3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f7852a == vVar.f7852a && this.f7853b == vVar.f7853b && q7.k.a(this.f7854c, vVar.f7854c);
    }

    public final int hashCode() {
        int iHashCode = this.f7852a.hashCode() * 31;
        b0 b0Var = this.f7853b;
        return this.f7854c.hashCode() + ((iHashCode + (b0Var == null ? 0 : b0Var.hashCode())) * 31);
    }

    public final String toString() {
        return "Jsr305Settings(globalLevel=" + this.f7852a + ", migrationLevel=" + this.f7853b + ", userDefinedLevelForSpecificAnnotation=" + this.f7854c + ')';
    }
}
