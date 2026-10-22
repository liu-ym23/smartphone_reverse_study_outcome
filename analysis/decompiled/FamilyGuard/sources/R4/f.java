package R4;

import C4.E;
import C4.G;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public interface f<F, T> {

    public static abstract class a {
        protected static Type a(int i5, ParameterizedType parameterizedType) {
            return y.g(i5, parameterizedType);
        }

        protected static Class<?> b(Type type) {
            return y.h(type);
        }

        @Nullable
        public f<?, E> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, u uVar) {
            return null;
        }

        @Nullable
        public f<G, ?> d(Type type, Annotation[] annotationArr, u uVar) {
            return null;
        }

        @Nullable
        public f<?, String> e(Type type, Annotation[] annotationArr, u uVar) {
            return null;
        }
    }

    @Nullable
    T a(F f5);
}
