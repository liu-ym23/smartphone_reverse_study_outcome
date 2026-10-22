package l8;

import java.lang.annotation.Annotation;
import java.util.Collection;

/* loaded from: classes.dex */
public final class d0 extends s implements v8.b {

    /* renamed from: a, reason: collision with root package name */
    public final b0 f5861a;

    /* renamed from: b, reason: collision with root package name */
    public final Annotation[] f5862b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5863c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f5864d;

    public d0(b0 b0Var, Annotation[] annotationArr, String str, boolean z4) {
        q7.k.e(annotationArr, "reflectAnnotations");
        this.f5861a = b0Var;
        this.f5862b = annotationArr;
        this.f5863c = str;
        this.f5864d = z4;
    }

    @Override // v8.b
    public final e a(e9.c cVar) {
        q7.k.e(cVar, "fqName");
        return a.a.M(this.f5862b, cVar);
    }

    @Override // v8.b
    public final Collection getAnnotations() {
        return a.a.P(this.f5862b);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(d0.class.getName());
        sb2.append(": ");
        sb2.append(this.f5864d ? "vararg " : "");
        String str = this.f5863c;
        sb2.append(str != null ? e9.f.d(str) : null);
        sb2.append(": ");
        sb2.append(this.f5861a);
        return sb2.toString();
    }
}
