package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes4.dex */
public interface Converter<F, T> {

    public static abstract class a {
        public a() {
        }

        public abstract Converter a(Type r10, Annotation[] r11, Annotation[] r12, Retrofit r13);

        public abstract Converter b(Type r10, Annotation[] r11, Retrofit r12);

        public Converter c(Type r10, Annotation[] r11, Retrofit r12) {
            return null;
        }
    }

    T convert(F r10) throws IOException;
}
