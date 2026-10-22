package qa;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import u1.C2031a;

/* renamed from: qa.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1857i extends AbstractC1853e {
    @Override // qa.AbstractC1853e
    public final InterfaceC1854f a(Type type, Annotation[] annotationArr) {
        if (U.f(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type typeE = U.e(0, (ParameterizedType) type);
        if (U.f(typeE) != L.class) {
            return new h2.d(typeE);
        }
        if (typeE instanceof ParameterizedType) {
            return new C2031a(U.e(0, (ParameterizedType) typeE));
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}
