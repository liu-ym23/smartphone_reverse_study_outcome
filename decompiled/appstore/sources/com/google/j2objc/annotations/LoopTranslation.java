package com.google.j2objc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
public @interface LoopTranslation {

    public static final enum LoopStyle extends Enum<LoopStyle> {
        private static final /* synthetic */ LoopStyle[] $VALUES = null;
        public static final LoopStyle FAST_ENUMERATION = null;
        public static final LoopStyle JAVA_ITERATOR = null;

        static {
            LoopStyle r10 = new LoopStyle("JAVA_ITERATOR", 0);
            JAVA_ITERATOR = r10;
            LoopStyle r11 = new LoopStyle("FAST_ENUMERATION", 1);
            FAST_ENUMERATION = r11;
            $VALUES = new LoopStyle[]{r10, r11};
        }

        private LoopStyle(String r10, int r11) {
            super(r10, r11);
        }

        public static LoopStyle valueOf(String r10) {
            return (LoopStyle) Enum.valueOf(LoopStyle.class, r10);
        }

        public static LoopStyle[] values() {
            return (LoopStyle[]) $VALUES.clone();
        }
    }

    LoopStyle value();
}
