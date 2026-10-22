package K9;

import java.lang.annotation.Annotation;
import java.util.List;

/* loaded from: classes5.dex */
public final class F extends t implements Z9.B {

    /* renamed from: a, reason: collision with root package name */
    public final D f4148a;

    /* renamed from: b, reason: collision with root package name */
    public final Annotation[] f4149b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4150c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f4151d;

    public F(D type, Annotation[] reflectAnnotations, String str, boolean z10) {
        kotlin.jvm.internal.p.i(type, "type");
        kotlin.jvm.internal.p.i(reflectAnnotations, "reflectAnnotations");
        this.f4148a = type;
        this.f4149b = reflectAnnotations;
        this.f4150c = str;
        this.f4151d = z10;
    }

    @Override // Z9.d
    public boolean A() {
        return false;
    }

    @Override // Z9.B
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public D getType() {
        return this.f4148a;
    }

    @Override // Z9.B
    public boolean a() {
        return this.f4151d;
    }

    @Override // Z9.B
    public ga.e getName() {
        String str = this.f4150c;
        if (str != null) {
            return ga.e.i(str);
        }
        return null;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(F.class.getName());
        sb2.append(": ");
        sb2.append(a() ? "vararg " : "");
        sb2.append(getName());
        sb2.append(": ");
        sb2.append(getType());
        return sb2.toString();
    }

    @Override // Z9.d
    public C0926g d(ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        return k.a(this.f4149b, fqName);
    }

    @Override // Z9.d
    public List<C0926g> getAnnotations() {
        return k.b(this.f4149b);
    }
}
