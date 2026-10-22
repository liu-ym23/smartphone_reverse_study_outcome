package yc;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes5.dex */
public interface e<R, T> {

    public static abstract class a {
        public static Type b(int i10, ParameterizedType parameterizedType) {
            return A.g(i10, parameterizedType);
        }

        public static Class<?> c(Type type) {
            return A.h(type);
        }

        public abstract e<?, ?> a(Type type, Annotation[] annotationArr, w wVar);
    }

    Type a();

    T b(d<R> dVar);
}
