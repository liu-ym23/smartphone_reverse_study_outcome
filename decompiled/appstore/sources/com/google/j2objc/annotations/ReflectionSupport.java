package com.google.j2objc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE, ElementType.PACKAGE})
@Retention(RetentionPolicy.CLASS)
public @interface ReflectionSupport {

    public static final enum Level extends Enum<Level> {
        private static final /* synthetic */ Level[] $VALUES = null;
        public static final Level FULL = null;
        public static final Level NATIVE_ONLY = null;

        static {
            Level r10 = new Level("NATIVE_ONLY", 0);
            NATIVE_ONLY = r10;
            Level r11 = new Level("FULL", 1);
            FULL = r11;
            $VALUES = new Level[]{r10, r11};
        }

        private Level(String r10, int r11) {
            super(r10, r11);
        }

        public static Level valueOf(String r10) {
            return (Level) Enum.valueOf(Level.class, r10);
        }

        public static Level[] values() {
            return (Level[]) $VALUES.clone();
        }
    }

    Level value();
}
