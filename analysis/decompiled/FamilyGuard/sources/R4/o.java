package R4;

import C4.G;
import R4.f;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
final class o extends f.a {

    /* renamed from: a, reason: collision with root package name */
    static final f.a f5061a = new o();

    static final class a<T> implements f<G, Optional<T>> {

        /* renamed from: a, reason: collision with root package name */
        final f<G, T> f5062a;

        a(f<G, T> fVar) {
            this.f5062a = fVar;
        }

        @Override // R4.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Optional<T> a(G g5) {
            return Optional.ofNullable(this.f5062a.a(g5));
        }
    }

    o() {
    }

    @Override // R4.f.a
    @Nullable
    public f<G, ?> d(Type type, Annotation[] annotationArr, u uVar) {
        if (f.a.b(type) != Optional.class) {
            return null;
        }
        return new a(uVar.i(f.a.a(0, (ParameterizedType) type), annotationArr));
    }
}
