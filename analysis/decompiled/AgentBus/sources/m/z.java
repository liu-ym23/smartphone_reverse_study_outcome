package m;

import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: b, reason: collision with root package name */
    public static final z f6118b = new z(new e0((ib.c) null, (m) null, (LinkedHashMap) null, 63));

    /* renamed from: c, reason: collision with root package name */
    public static final z f6119c = new z(new e0((ib.c) null, (m) null, (LinkedHashMap) null, 47));

    /* renamed from: a, reason: collision with root package name */
    public final e0 f6120a;

    public z(e0 e0Var) {
        this.f6120a = e0Var;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof z) && q7.k.a(((z) obj).f6120a, this.f6120a);
    }

    public final int hashCode() {
        return this.f6120a.hashCode();
    }

    public final String toString() {
        if (equals(f6118b)) {
            return "ExitTransition.None";
        }
        if (equals(f6119c)) {
            return "ExitTransition.KeepUntilTransitionsFinished";
        }
        StringBuilder sb2 = new StringBuilder("ExitTransition: \nFade - ");
        x.w(sb2, null, ",\nSlide - ", null, ",\nShrink - ");
        e0 e0Var = this.f6120a;
        m mVar = e0Var.f6056a;
        x.w(sb2, mVar != null ? mVar.toString() : null, ",\nScale - ", null, ",\nKeepUntilTransitionsFinished - ");
        sb2.append(e0Var.f6057b);
        return sb2.toString();
    }
}
