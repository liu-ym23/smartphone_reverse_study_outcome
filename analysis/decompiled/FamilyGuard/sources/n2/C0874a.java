package n2;

import C4.E;
import C4.G;
import R4.f;
import R4.u;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* renamed from: n2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0874a extends f.a {

    /* renamed from: a, reason: collision with root package name */
    private final String f18914a;

    private C0874a(String str) {
        this.f18914a = str;
    }

    public static C0874a f(String str) {
        return new C0874a(str);
    }

    @Override // R4.f.a
    public R4.f<?, E> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, u uVar) {
        return new C0875b();
    }

    @Override // R4.f.a
    public R4.f<G, ?> d(Type type, Annotation[] annotationArr, u uVar) {
        return new C0876c(this.f18914a, type);
    }
}
