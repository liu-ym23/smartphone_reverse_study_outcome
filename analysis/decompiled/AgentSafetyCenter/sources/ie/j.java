package ie;

import java.lang.annotation.Annotation;
import java.lang.invoke.VarHandle;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class j extends d {

    /* renamed from: a, reason: collision with root package name */
    public static final j f6002a = new j();

    @Override // ie.d
    public final e a(Type type, Annotation[] annotationArr) {
        if (w0.h(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            od.f.e("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
            return null;
        }
        int i = 0;
        Type typeG = w0.g(0, (ParameterizedType) type);
        if (w0.h(typeG) != o0.class) {
            h hVar = new h(i);
            hVar.f5997f = typeG;
            VarHandle.storeStoreFence();
            return hVar;
        }
        if (!(typeG instanceof ParameterizedType)) {
            od.f.e("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            return null;
        }
        Type typeG2 = w0.g(0, (ParameterizedType) typeG);
        h hVar2 = new h(1);
        hVar2.f5997f = typeG2;
        VarHandle.storeStoreFence();
        return hVar2;
    }
}
