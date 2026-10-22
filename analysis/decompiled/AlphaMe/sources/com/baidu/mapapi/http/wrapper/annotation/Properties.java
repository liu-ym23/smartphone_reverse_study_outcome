package com.baidu.mapapi.http.wrapper.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface Properties {
    String desc() default "";

    String name() default "";

    boolean require() default false;
}
