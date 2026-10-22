package com.baidu.mapapi.http.wrapper.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface BodyData {
    public static final String TYPE_FORM_DATA = "form-data";
    public static final String TYPE_JSON = "json";
    public static final String TYPE_URL_ENCODED = "urlencoded";

    String value() default "json";
}
