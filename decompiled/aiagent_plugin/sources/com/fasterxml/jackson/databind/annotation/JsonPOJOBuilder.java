package com.fasterxml.jackson.databind.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonPOJOBuilder {
    public static final String DEFAULT_BUILD_METHOD = "build";
    public static final String DEFAULT_WITH_PREFIX = "with";

    public static class Value {
        public final String buildMethodName;
        public final String withPrefix;

        public Value(JsonPOJOBuilder r3) {
            JsonPOJOBuilder r4 = (JsonPOJOBuilder) ZeusTransformUtils.wrapperContextForParams(r3, JsonPOJOBuilder.class, "com.obric.aiagent.plugin");
            this(r4.buildMethodName(), r4.withPrefix());
        }

        public Value(String r1, String r2) {
            this.buildMethodName = r1;
            this.withPrefix = r2;
        }
    }

    String buildMethodName() default "build";

    String withPrefix() default "with";
}
