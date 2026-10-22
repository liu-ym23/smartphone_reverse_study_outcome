package n8;

import java.lang.annotation.Annotation;
import java.util.Collection;
import x8.InterfaceC2119b;

/* loaded from: classes4.dex */
public final class w extends l implements InterfaceC2119b {

    /* renamed from: a, reason: collision with root package name */
    public final u f5367a;
    public final Annotation[] b;
    public final String c;
    public final boolean d;

    public w(u uVar, Annotation[] reflectAnnotations, String str, boolean z10) {
        kotlin.jvm.internal.k.f(reflectAnnotations, "reflectAnnotations");
        this.f5367a = uVar;
        this.b = reflectAnnotations;
        this.c = str;
        this.d = z10;
    }

    @Override // x8.InterfaceC2119b
    public final d a(G8.c fqName) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        return H4.o.B(this.b, fqName);
    }

    @Override // x8.InterfaceC2119b
    public final Collection getAnnotations() {
        return H4.o.D(this.b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.constraintlayout.core.dsl.a.z(sb, w.class, ": ");
        sb.append(this.d ? "vararg " : "");
        String str = this.c;
        sb.append(str != null ? G8.f.d(str) : null);
        sb.append(": ");
        sb.append(this.f5367a);
        return sb.toString();
    }
}
