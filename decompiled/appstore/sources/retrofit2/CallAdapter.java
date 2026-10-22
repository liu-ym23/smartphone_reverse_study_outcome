package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes4.dex */
public interface CallAdapter<R, T> {

    public static abstract class a {
        public a() {
        }

        public static Type b(int r10, ParameterizedType r11) {
            return i.i(r10, r11);
        }

        public static Class c(Type r10) {
            return i.j(r10);
        }

        public abstract CallAdapter a(Type r10, Annotation[] r11, Retrofit r12);
    }

    T adapt(Call<R> r10);

    Type responseType();
}
