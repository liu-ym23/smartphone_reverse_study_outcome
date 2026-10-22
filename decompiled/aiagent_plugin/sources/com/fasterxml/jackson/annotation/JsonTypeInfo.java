package com.fasterxml.jackson.annotation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonTypeInfo {

    public static final enum As extends Enum<As> {
        private static final /* synthetic */ As[] $VALUES = null;
        public static final As EXISTING_PROPERTY = null;
        public static final As EXTERNAL_PROPERTY = null;
        public static final As PROPERTY = null;
        public static final As WRAPPER_ARRAY = null;
        public static final As WRAPPER_OBJECT = null;

        private As(String r1, int r2) {
            super(r1, r2);
        }

        public static As valueOf(String r2) {
            return (As) ZeusTransformUtils.preCheckCast(Enum.valueOf(As.class, r2), As.class, "com.obric.aiagent.plugin");
        }

        public static As[] values() {
            return (As[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), As[].class, "com.obric.aiagent.plugin");
        }

        static {
            As r0 = new As("PROPERTY", 0);
            PROPERTY = r0;
            As r1 = new As("WRAPPER_OBJECT", 1);
            WRAPPER_OBJECT = r1;
            As r3 = new As("WRAPPER_ARRAY", 2);
            WRAPPER_ARRAY = r3;
            As r5 = new As("EXTERNAL_PROPERTY", 3);
            EXTERNAL_PROPERTY = r5;
            As r7 = new As("EXISTING_PROPERTY", 4);
            EXISTING_PROPERTY = r7;
            $VALUES = new As[]{r0, r1, r3, r5, r7};
        }
    }

    public static final enum Id extends Enum<Id> {
        private static final /* synthetic */ Id[] $VALUES = null;
        public static final Id CLASS = null;
        public static final Id CUSTOM = null;
        public static final Id DEDUCTION = null;
        public static final Id MINIMAL_CLASS = null;
        public static final Id NAME = null;
        public static final Id NONE = null;
        private final String _defaultPropertyName;

        public static Id valueOf(String r2) {
            return (Id) ZeusTransformUtils.preCheckCast(Enum.valueOf(Id.class, r2), Id.class, "com.obric.aiagent.plugin");
        }

        public static Id[] values() {
            return (Id[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Id[].class, "com.obric.aiagent.plugin");
        }

        static {
            Id r0 = new Id("NONE", 0, null);
            NONE = r0;
            Id r1 = new Id("CLASS", 1, "@class");
            CLASS = r1;
            Id r4 = new Id("MINIMAL_CLASS", 2, "@c");
            MINIMAL_CLASS = r4;
            Id r6 = new Id("NAME", 3, "@type");
            NAME = r6;
            Id r8 = new Id("DEDUCTION", 4, null);
            DEDUCTION = r8;
            Id r10 = new Id("CUSTOM", 5, null);
            CUSTOM = r10;
            $VALUES = new Id[]{r0, r1, r4, r6, r8, r10};
        }

        private Id(String r1, int r2, String r3) {
            super(r1, r2);
            this._defaultPropertyName = r3;
        }

        public String getDefaultPropertyName() {
            return this._defaultPropertyName;
        }
    }

    @Deprecated
    public static abstract class None {
        public None() {
        }
    }

    Class<?> defaultImpl() default JsonTypeInfo.class;

    As include() default As.PROPERTY;

    String property() default "";

    Id use();

    boolean visible() default false;
}
