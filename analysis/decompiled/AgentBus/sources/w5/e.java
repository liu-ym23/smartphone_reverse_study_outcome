package w5;

import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final c0 f10690a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10691b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10692c;

    /* renamed from: d, reason: collision with root package name */
    public final List f10693d;

    public e(c0 c0Var, float f10, String str, List list) {
        q7.k.e(c0Var, "rootCause");
        q7.k.e(str, "summary");
        this.f10690a = c0Var;
        this.f10691b = f10;
        this.f10692c = str;
        this.f10693d = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f10690a == eVar.f10690a && Float.compare(this.f10691b, eVar.f10691b) == 0 && q7.k.a(this.f10692c, eVar.f10692c) && q7.k.a(this.f10693d, eVar.f10693d);
    }

    public final int hashCode() {
        return this.f10693d.hashCode() + m.x.g(this.f10692c, m.x.d(this.f10691b, this.f10690a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        return "DiagnosticConclusion(rootCause=" + this.f10690a + ", confidence=" + this.f10691b + ", summary=" + this.f10692c + ", suggestions=" + this.f10693d + ")";
    }
}
