package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface JsonProperty {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Access {

        /* renamed from: a, reason: collision with root package name */
        public static final Access f3476a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Access[] f3477b;

        static {
            Access access = new Access("AUTO", 0);
            f3476a = access;
            f3477b = new Access[]{access, new Access("READ_ONLY", 1), new Access("WRITE_ONLY", 2), new Access("READ_WRITE", 3)};
        }

        public Access() {
            throw null;
        }

        public static Access valueOf(String str) {
            return (Access) Enum.valueOf(Access.class, str);
        }

        public static Access[] values() {
            return (Access[]) f3477b.clone();
        }
    }

    Access access() default Access.f3476a;

    String defaultValue() default "";

    int index() default -1;

    String namespace() default "";

    boolean required() default false;

    String value() default "";
}
