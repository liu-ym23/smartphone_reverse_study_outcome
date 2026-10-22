package com.bytedance.retrofit2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: Converter.java */
/* JADX INFO: loaded from: classes.dex */
public interface i<F, T> {

    /* JADX INFO: compiled from: Converter.java */
    public static abstract class a {
        public i<com.bytedance.retrofit2.e.i, ?> a(Type r1, Annotation[] r2, ab r3) {
            Type r0 = (Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.aiagent.plugin");
            return null;
        }

        public i<?, com.bytedance.retrofit2.e.j> a(Type r1, Annotation[] r2, Annotation[] r3, ab r4) {
            Type r0 = (Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.aiagent.plugin");
            return null;
        }

        public i<?, Object> b(Type r1, Annotation[] r2, ab r3) {
            Type r0 = (Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.aiagent.plugin");
            return null;
        }

        public i<?, String> c(Type r1, Annotation[] r2, ab r3) {
            Type r0 = (Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.aiagent.plugin");
            return null;
        }

        public i<?, com.bytedance.retrofit2.b.b> d(Type r1, Annotation[] r2, ab r3) {
            Type r0 = (Type) ZeusTransformUtils.wrapperContextForParams(r1, Type.class, "com.obric.aiagent.plugin");
            return null;
        }

        public a() {
        }
    }

    default T a(F r1, z r2) {
        return null;
    }

    default boolean a() {
        return false;
    }

    T b(F r1);
}
