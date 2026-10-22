package org.jetbrains.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes4.dex */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE, ElementType.TYPE, ElementType.PACKAGE})
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface Nls {

    public static final enum Capitalization extends Enum<Capitalization> {
        private static final /* synthetic */ Capitalization[] $VALUES = null;
        public static final Capitalization NotSpecified = null;
        public static final Capitalization Sentence = null;
        public static final Capitalization Title = null;

        static {
            Capitalization r10 = new Capitalization("NotSpecified", 0);
            NotSpecified = r10;
            Capitalization r11 = new Capitalization("Title", 1);
            Title = r11;
            Capitalization r12 = new Capitalization("Sentence", 2);
            Sentence = r12;
            $VALUES = new Capitalization[]{r10, r11, r12};
        }

        private Capitalization(String r10, int r11) {
            super(r10, r11);
        }

        public static Capitalization valueOf(String r10) {
            return (Capitalization) Enum.valueOf(Capitalization.class, r10);
        }

        public static Capitalization[] values() {
            return (Capitalization[]) $VALUES.clone();
        }
    }

    Capitalization capitalization() default Capitalization.NotSpecified;
}
