package com.android.ttcjpaysdk.base.service.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes28.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface CJPayService {
    String value() default "";
}
