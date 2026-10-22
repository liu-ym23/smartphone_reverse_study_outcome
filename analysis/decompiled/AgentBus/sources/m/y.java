package m;

import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: b, reason: collision with root package name */
    public static final y f6116b = new y(new e0((ib.c) null, (m) null, (LinkedHashMap) null, 63));

    /* renamed from: a, reason: collision with root package name */
    public final e0 f6117a;

    public y(e0 e0Var) {
        this.f6117a = e0Var;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof y) && q7.k.a(((y) obj).f6117a, this.f6117a);
    }

    public final int hashCode() {
        return this.f6117a.hashCode();
    }

    public final String toString() {
        if (equals(f6116b)) {
            return "EnterTransition.None";
        }
        StringBuilder sb2 = new StringBuilder("EnterTransition: \nFade - ");
        x.w(sb2, null, ",\nSlide - ", null, ",\nShrink - ");
        m mVar = this.f6117a.f6056a;
        return x.n(sb2, mVar != null ? mVar.toString() : null, ",\nScale - ", null);
    }
}
