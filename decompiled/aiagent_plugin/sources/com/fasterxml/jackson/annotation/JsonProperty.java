package com.fasterxml.jackson.annotation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonProperty {
    public static final int INDEX_UNKNOWN = -1;
    public static final String USE_DEFAULT_NAME = "";

    public static final enum Access extends Enum<Access> {
        private static final /* synthetic */ Access[] $VALUES = null;
        public static final Access AUTO = null;
        public static final Access READ_ONLY = null;
        public static final Access READ_WRITE = null;
        public static final Access WRITE_ONLY = null;

        private Access(String r1, int r2) {
            super(r1, r2);
        }

        public static Access valueOf(String r2) {
            return (Access) ZeusTransformUtils.preCheckCast(Enum.valueOf(Access.class, r2), Access.class, "com.obric.aiagent.plugin");
        }

        public static Access[] values() {
            return (Access[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Access[].class, "com.obric.aiagent.plugin");
        }

        static {
            Access r0 = new Access("AUTO", 0);
            AUTO = r0;
            Access r1 = new Access("READ_ONLY", 1);
            READ_ONLY = r1;
            Access r3 = new Access("WRITE_ONLY", 2);
            WRITE_ONLY = r3;
            Access r5 = new Access("READ_WRITE", 3);
            READ_WRITE = r5;
            $VALUES = new Access[]{r0, r1, r3, r5};
        }
    }

    Access access() default Access.AUTO;

    String defaultValue() default "";

    int index() default -1;

    String namespace() default "";

    boolean required() default false;

    String value() default "";
}
