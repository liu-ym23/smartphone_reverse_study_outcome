package qa;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import k2.C1621a;

/* renamed from: qa.m, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1861m extends AbstractC1853e {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f5656a;

    public C1861m(Executor executor) {
        this.f5656a = executor;
    }

    @Override // qa.AbstractC1853e
    public final InterfaceC1854f a(Type type, Annotation[] annotationArr) {
        if (U.f(type) != InterfaceC1852d.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new C1621a(U.e(0, (ParameterizedType) type), U.j(annotationArr, O.class) ? null : this.f5656a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
