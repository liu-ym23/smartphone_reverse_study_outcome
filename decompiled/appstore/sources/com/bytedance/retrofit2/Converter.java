package com.bytedance.retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface Converter<F, T> {

    public static abstract class a {
        public a() {
        }

        public Converter a(Type r10, Annotation[] r11, f r12) {
            return null;
        }

        public Converter b(Type r10, Annotation[] r11, f r12) {
            return null;
        }

        public abstract Converter c(Type r10, Annotation[] r11, Annotation[] r12, f r13);

        public abstract Converter d(Type r10, Annotation[] r11, f r12);

        public Converter e(Type r10, Annotation[] r11, f r12) {
            return null;
        }
    }

    T convert(F r10) throws IOException;
}
