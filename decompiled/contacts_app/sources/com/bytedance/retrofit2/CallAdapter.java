package com.bytedance.retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface CallAdapter<R, T> {

    public static abstract class Factory {
        @Nullable
        public abstract CallAdapter<?, ?> get(Type r1, Annotation[] r2, Retrofit r3);

        public Factory() {
        }

        protected static Type getParameterUpperBound(int r0, ParameterizedType r1) {
            return Utils.getParameterUpperBound(r0, r1);
        }

        protected static Class<?> getRawType(Type r0) {
            return Utils.getRawType(r0);
        }
    }

    T adapt(Call<R> r1);

    Type responseType();
}
