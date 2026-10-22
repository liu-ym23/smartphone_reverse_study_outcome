package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface JsonTypeInfo {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class As {

        /* renamed from: a, reason: collision with root package name */
        public static final As f3481a;

        /* renamed from: b, reason: collision with root package name */
        public static final As f3482b;

        /* renamed from: c, reason: collision with root package name */
        public static final As f3483c;

        /* renamed from: d, reason: collision with root package name */
        public static final As f3484d;

        /* renamed from: e, reason: collision with root package name */
        public static final As f3485e;
        public static final /* synthetic */ As[] h;

        static {
            As as = new As("PROPERTY", 0);
            f3481a = as;
            As as2 = new As("WRAPPER_OBJECT", 1);
            f3482b = as2;
            As as3 = new As("WRAPPER_ARRAY", 2);
            f3483c = as3;
            As as4 = new As("EXTERNAL_PROPERTY", 3);
            f3484d = as4;
            As as5 = new As("EXISTING_PROPERTY", 4);
            f3485e = as5;
            h = new As[]{as, as2, as3, as4, as5};
        }

        public As() {
            throw null;
        }

        public static As valueOf(String str) {
            return (As) Enum.valueOf(As.class, str);
        }

        public static As[] values() {
            return (As[]) h.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public enum Id {
        NONE(null),
        CLASS("@class"),
        MINIMAL_CLASS("@c"),
        /* JADX INFO: Fake field, exist only in values array */
        NAME("@type"),
        DEDUCTION(null),
        /* JADX INFO: Fake field, exist only in values array */
        CUSTOM(null);


        /* renamed from: a, reason: collision with root package name */
        public final String f3490a;

        Id(String str) {
            this.f3490a = str;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @Deprecated
    public static abstract class a {
    }

    Class<?> defaultImpl() default JsonTypeInfo.class;

    As include() default As.f3481a;

    String property() default "";

    Id use();

    boolean visible() default false;
}
