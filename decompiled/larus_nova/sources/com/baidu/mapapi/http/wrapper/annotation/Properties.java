package com.baidu.mapapi.http.wrapper.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes39.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface Properties {
    String desc() default "";

    String name() default "";

    boolean require() default false;
}
