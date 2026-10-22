package com.bytedance.retrofit2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: CallAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public interface f<R, T> {

    /* JADX INFO: compiled from: CallAdapter.java */
    public static abstract class a {
        public abstract f<?, ?> a(Type r1, Annotation[] r2, ab r3);

        public a() {
        }

        public static Class<?> a(Type r2) {
            return an.a((Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.aiagent.plugin"));
        }
    }

    T a(e<R> r1);

    Type a();
}
