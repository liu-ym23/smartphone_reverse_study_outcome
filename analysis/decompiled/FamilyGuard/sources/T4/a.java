package T4;

import A1.e;
import C4.E;
import C4.G;
import R4.f;
import R4.u;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public final class a extends f.a {

    /* renamed from: a, reason: collision with root package name */
    private final e f5425a;

    private a(e eVar) {
        this.f5425a = eVar;
    }

    public static a f() {
        return g(new e());
    }

    public static a g(e eVar) {
        if (eVar != null) {
            return new a(eVar);
        }
        throw new NullPointerException("gson == null");
    }

    @Override // R4.f.a
    public f<?, E> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, u uVar) {
        return new b(this.f5425a, this.f5425a.k(com.google.gson.reflect.a.get(type)));
    }

    @Override // R4.f.a
    public f<G, ?> d(Type type, Annotation[] annotationArr, u uVar) {
        return new c(this.f5425a, this.f5425a.k(com.google.gson.reflect.a.get(type)));
    }
}
