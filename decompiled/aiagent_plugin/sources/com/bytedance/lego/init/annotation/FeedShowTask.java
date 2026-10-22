package com.bytedance.lego.init.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface FeedShowTask {
    String desc();

    int executePriority() default 0;

    String id() default "";

    String moduleName() default "";

    boolean mustRunInMainThread();
}
