package com.stepos.config.dag.annotation;

import com.stepos.config.dag.InitializationStrategy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface ConfigNode {
    String name();

    int priority() default 1000;

    InitializationStrategy strategy() default InitializationStrategy.EAGER;
}
