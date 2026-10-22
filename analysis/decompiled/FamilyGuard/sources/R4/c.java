package R4;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public interface c<R, T> {

    public static abstract class a {
        protected static Type b(int i5, ParameterizedType parameterizedType) {
            return y.g(i5, parameterizedType);
        }

        protected static Class<?> c(Type type) {
            return y.h(type);
        }

        @Nullable
        public abstract c<?, ?> a(Type type, Annotation[] annotationArr, u uVar);
    }

    T a(b<R> bVar);

    Type b();
}
