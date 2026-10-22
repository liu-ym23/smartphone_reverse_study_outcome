package ie;

import java.lang.annotation.Annotation;
import java.lang.invoke.VarHandle;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class n extends d {

    /* renamed from: a, reason: collision with root package name */
    public Executor f6040a;

    @Override // ie.d
    public final e a(Type type, Annotation[] annotationArr) {
        if (w0.h(type) != c.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            g5.f.s("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
            return null;
        }
        Type typeG = w0.g(0, (ParameterizedType) type);
        Executor executor = w0.k(annotationArr, r0.class) ? null : this.f6040a;
        p5.l lVar = new p5.l();
        lVar.f9738c = typeG;
        lVar.f9739f = executor;
        VarHandle.storeStoreFence();
        return lVar;
    }
}
