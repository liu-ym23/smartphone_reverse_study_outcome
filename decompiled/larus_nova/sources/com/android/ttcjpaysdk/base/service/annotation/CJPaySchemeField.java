package com.android.ttcjpaysdk.base.service.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes28.dex */
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface CJPaySchemeField {
    String defValue() default "";

    String desc() default "";

    boolean isColor() default false;

    String key() default "";
}
