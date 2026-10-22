package yc;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import tb.AbstractC5529B;
import tb.AbstractC5531D;

/* loaded from: classes5.dex */
public interface h<F, T> {

    public static abstract class a {
        public static Type a(int i10, ParameterizedType parameterizedType) {
            return A.g(i10, parameterizedType);
        }

        public static Class<?> b(Type type) {
            return A.h(type);
        }

        public h<?, AbstractC5529B> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, w wVar) {
            return null;
        }

        public h<AbstractC5531D, ?> d(Type type, Annotation[] annotationArr, w wVar) {
            return null;
        }

        public h<?, String> e(Type type, Annotation[] annotationArr, w wVar) {
            return null;
        }
    }

    T convert(F f10) throws IOException;
}
