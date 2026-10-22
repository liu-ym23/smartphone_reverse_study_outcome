package com.fasterxml.jackson.databind.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.databind.l.j;
import com.fasterxml.jackson.databind.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@JacksonAnnotation
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonSerialize {

    @Deprecated
    public static final enum Inclusion extends Enum<Inclusion> {
        private static final /* synthetic */ Inclusion[] $VALUES = null;
        public static final Inclusion ALWAYS = null;
        public static final Inclusion DEFAULT_INCLUSION = null;
        public static final Inclusion NON_DEFAULT = null;
        public static final Inclusion NON_EMPTY = null;
        public static final Inclusion NON_NULL = null;

        public static Inclusion valueOf(String r2) {
            return (Inclusion) ZeusTransformUtils.preCheckCast(Enum.valueOf(Inclusion.class, r2), Inclusion.class, "com.obric.aiagent.plugin");
        }

        public static Inclusion[] values() {
            return (Inclusion[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Inclusion[].class, "com.obric.aiagent.plugin");
        }

        private Inclusion(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Inclusion r0 = new Inclusion("ALWAYS", 0);
            ALWAYS = r0;
            Inclusion r1 = new Inclusion("NON_NULL", 1);
            NON_NULL = r1;
            Inclusion r3 = new Inclusion("NON_DEFAULT", 2);
            NON_DEFAULT = r3;
            Inclusion r5 = new Inclusion("NON_EMPTY", 3);
            NON_EMPTY = r5;
            Inclusion r7 = new Inclusion("DEFAULT_INCLUSION", 4);
            DEFAULT_INCLUSION = r7;
            $VALUES = new Inclusion[]{r0, r1, r3, r5, r7};
        }
    }

    public static final enum Typing extends Enum<Typing> {
        private static final /* synthetic */ Typing[] $VALUES = null;
        public static final Typing DEFAULT_TYPING = null;
        public static final Typing DYNAMIC = null;
        public static final Typing STATIC = null;

        private Typing(String r1, int r2) {
            super(r1, r2);
        }

        public static Typing valueOf(String r2) {
            return (Typing) ZeusTransformUtils.preCheckCast(Enum.valueOf(Typing.class, r2), Typing.class, "com.obric.aiagent.plugin");
        }

        public static Typing[] values() {
            return (Typing[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Typing[].class, "com.obric.aiagent.plugin");
        }

        static {
            Typing r0 = new Typing("DYNAMIC", 0);
            DYNAMIC = r0;
            Typing r1 = new Typing("STATIC", 1);
            STATIC = r1;
            Typing r3 = new Typing("DEFAULT_TYPING", 2);
            DEFAULT_TYPING = r3;
            $VALUES = new Typing[]{r0, r1, r3};
        }
    }

    Class<?> as() default Void.class;

    Class<?> contentAs() default Void.class;

    Class<? extends j> contentConverter() default j.a.class;

    Class<? extends p> contentUsing() default p.a.class;

    Class<? extends j> converter() default j.a.class;

    @Deprecated
    Inclusion include() default Inclusion.DEFAULT_INCLUSION;

    Class<?> keyAs() default Void.class;

    Class<? extends p> keyUsing() default p.a.class;

    Class<? extends p> nullsUsing() default p.a.class;

    Typing typing() default Typing.DEFAULT_TYPING;

    Class<? extends p> using() default p.a.class;
}
