package com.bytedance.android.brick.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes43.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface BrickRootSubComponent {

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    public @interface Builder {
    }

    Class<?>[] modules() default {};
}
