package com.bytedance.retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface CallAdapter<T> {

    public static abstract class a {
        public a() {
        }

        public static Class b(Type r10) {
            return f6.g.j(r10);
        }

        public abstract CallAdapter a(Type r10, Annotation[] r11, f r12);
    }

    <R> T adapt(Call<R> r10);

    Type responseType();
}
