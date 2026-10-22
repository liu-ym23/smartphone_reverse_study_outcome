package com.fasterxml.jackson.databind.annotation;

import b3.f;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import q3.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface JsonSerialize {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @Deprecated
    public static final class Inclusion {

        /* renamed from: a, reason: collision with root package name */
        public static final Inclusion f3782a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Inclusion[] f3783b;

        /* JADX INFO: Fake field, exist only in values array */
        Inclusion EF0;

        static {
            Inclusion inclusion = new Inclusion("ALWAYS", 0);
            Inclusion inclusion2 = new Inclusion("NON_NULL", 1);
            Inclusion inclusion3 = new Inclusion("NON_DEFAULT", 2);
            Inclusion inclusion4 = new Inclusion("NON_EMPTY", 3);
            Inclusion inclusion5 = new Inclusion("DEFAULT_INCLUSION", 4);
            f3782a = inclusion5;
            f3783b = new Inclusion[]{inclusion, inclusion2, inclusion3, inclusion4, inclusion5};
        }

        public Inclusion() {
            throw null;
        }

        public static Inclusion valueOf(String str) {
            return (Inclusion) Enum.valueOf(Inclusion.class, str);
        }

        public static Inclusion[] values() {
            return (Inclusion[]) f3783b.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Typing {

        /* renamed from: a, reason: collision with root package name */
        public static final Typing f3784a;

        /* renamed from: b, reason: collision with root package name */
        public static final Typing f3785b;

        /* renamed from: c, reason: collision with root package name */
        public static final Typing f3786c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ Typing[] f3787d;

        static {
            Typing typing = new Typing("DYNAMIC", 0);
            f3784a = typing;
            Typing typing2 = new Typing("STATIC", 1);
            f3785b = typing2;
            Typing typing3 = new Typing("DEFAULT_TYPING", 2);
            f3786c = typing3;
            f3787d = new Typing[]{typing, typing2, typing3};
        }

        public Typing() {
            throw null;
        }

        public static Typing valueOf(String str) {
            return (Typing) Enum.valueOf(Typing.class, str);
        }

        public static Typing[] values() {
            return (Typing[]) f3787d.clone();
        }
    }

    Class<?> as() default Void.class;

    Class<?> contentAs() default Void.class;

    Class<? extends g> contentConverter() default g.a.class;

    Class<? extends f> contentUsing() default f.a.class;

    Class<? extends g> converter() default g.a.class;

    @Deprecated
    Inclusion include() default Inclusion.f3782a;

    Class<?> keyAs() default Void.class;

    Class<? extends f> keyUsing() default f.a.class;

    Class<? extends f> nullsUsing() default f.a.class;

    Typing typing() default Typing.f3786c;

    Class<? extends f> using() default f.a.class;
}
