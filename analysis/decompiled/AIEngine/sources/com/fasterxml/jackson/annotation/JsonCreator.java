package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface JsonCreator {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Mode {

        /* renamed from: a, reason: collision with root package name */
        public static final Mode f3429a;

        /* renamed from: b, reason: collision with root package name */
        public static final Mode f3430b;

        /* renamed from: c, reason: collision with root package name */
        public static final Mode f3431c;

        /* renamed from: d, reason: collision with root package name */
        public static final Mode f3432d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f3433e;

        static {
            Mode mode = new Mode("DEFAULT", 0);
            f3429a = mode;
            Mode mode2 = new Mode("DELEGATING", 1);
            f3430b = mode2;
            Mode mode3 = new Mode("PROPERTIES", 2);
            f3431c = mode3;
            Mode mode4 = new Mode("DISABLED", 3);
            f3432d = mode4;
            f3433e = new Mode[]{mode, mode2, mode3, mode4};
        }

        public Mode() {
            throw null;
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) f3433e.clone();
        }
    }

    Mode mode() default Mode.f3429a;
}
