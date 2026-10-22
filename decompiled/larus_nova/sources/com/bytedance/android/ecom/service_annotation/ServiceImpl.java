package com.bytedance.android.ecom.service_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes44.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface ServiceImpl {
    String constructor() default "";

    Class<?>[] services();

    boolean singleTon() default false;
}
