package com.fasterxml.jackson.annotation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonCreator {

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode DEFAULT = null;
        public static final Mode DELEGATING = null;
        public static final Mode DISABLED = null;
        public static final Mode PROPERTIES = null;

        private Mode(String r1, int r2) {
            super(r1, r2);
        }

        public static Mode valueOf(String r2) {
            return (Mode) ZeusTransformUtils.preCheckCast(Enum.valueOf(Mode.class, r2), Mode.class, "com.obric.aiagent.plugin");
        }

        public static Mode[] values() {
            return (Mode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Mode[].class, "com.obric.aiagent.plugin");
        }

        static {
            Mode r0 = new Mode("DEFAULT", 0);
            DEFAULT = r0;
            Mode r1 = new Mode("DELEGATING", 1);
            DELEGATING = r1;
            Mode r3 = new Mode("PROPERTIES", 2);
            PROPERTIES = r3;
            Mode r5 = new Mode("DISABLED", 3);
            DISABLED = r5;
            $VALUES = new Mode[]{r0, r1, r3, r5};
        }
    }

    Mode mode() default Mode.DEFAULT;
}
