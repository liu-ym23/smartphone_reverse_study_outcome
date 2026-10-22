package androidx.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface RestrictTo {

    public static final enum Scope extends Enum<Scope> {
        private static final /* synthetic */ Scope[] $VALUES = null;

        @Deprecated
        public static final Scope GROUP_ID = null;
        public static final Scope LIBRARY = null;
        public static final Scope LIBRARY_GROUP = null;
        public static final Scope LIBRARY_GROUP_PREFIX = null;
        public static final Scope SUBCLASSES = null;
        public static final Scope TESTS = null;

        static {
            Scope r10 = new Scope("LIBRARY", 0);
            LIBRARY = r10;
            Scope r11 = new Scope("LIBRARY_GROUP", 1);
            LIBRARY_GROUP = r11;
            Scope r12 = new Scope("LIBRARY_GROUP_PREFIX", 2);
            LIBRARY_GROUP_PREFIX = r12;
            Scope r13 = new Scope("GROUP_ID", 3);
            GROUP_ID = r13;
            Scope r14 = new Scope("TESTS", 4);
            TESTS = r14;
            Scope r15 = new Scope("SUBCLASSES", 5);
            SUBCLASSES = r15;
            $VALUES = new Scope[]{r10, r11, r12, r13, r14, r15};
        }

        private Scope(String r10, int r11) {
            super(r10, r11);
        }

        public static Scope valueOf(String r10) {
            return (Scope) Enum.valueOf(Scope.class, r10);
        }

        public static Scope[] values() {
            return (Scope[]) $VALUES.clone();
        }
    }

    Scope[] value();
}
