package qa;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

/* renamed from: qa.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1850b extends AbstractC1858j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5653a;

    public /* synthetic */ C1850b(int i) {
        this.f5653a = i;
    }

    @Override // qa.AbstractC1858j
    public InterfaceC1859k a(Type type) {
        switch (this.f5653a) {
            case 0:
                if (F9.K.class.isAssignableFrom(U.f(type))) {
                    return C1849a.d;
                }
                return null;
            default:
                return super.a(type);
        }
    }

    @Override // qa.AbstractC1858j
    public final InterfaceC1859k b(Type type, Annotation[] annotationArr, N n) {
        switch (this.f5653a) {
            case 0:
                if (type == F9.P.class) {
                    return U.j(annotationArr, sa.w.class) ? C1849a.e : C1849a.c;
                }
                if (type == Void.class) {
                    return C1849a.g;
                }
                if (U.b && type == C7.r.class) {
                    return C1849a.f;
                }
                return null;
            default:
                if (U.f(type) != Optional.class) {
                    return null;
                }
                return new Q.a(n.d(U.e(0, (ParameterizedType) type), annotationArr), 9);
        }
    }
}
