package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import r27.a;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
@Retention(RetentionPolicy.CLASS)
public @interface RestrictTo {

    public static final enum Scope extends Enum<Scope> {
        private static final /* synthetic */ Scope[] $VALUES = null;
        public static final Scope GROUP_ID = null;
        public static final Scope LIBRARY = null;
        public static final Scope LIBRARY_GROUP = null;
        public static final Scope LIBRARY_GROUP_PREFIX = null;
        public static final Scope SUBCLASSES = null;
        public static final Scope TESTS = null;

        static {
            Scope r100 = new Scope("LIBRARY", 0);
            LIBRARY = r100;
            Scope r101 = new Scope("LIBRARY_GROUP", 1);
            LIBRARY_GROUP = r101;
            Scope r102 = new Scope("LIBRARY_GROUP_PREFIX", 2);
            LIBRARY_GROUP_PREFIX = r102;
            Scope r103 = new Scope("GROUP_ID", 3);
            GROUP_ID = r103;
            Scope r104 = new Scope("TESTS", 4);
            TESTS = r104;
            Scope r105 = new Scope("SUBCLASSES", 5);
            SUBCLASSES = r105;
            $VALUES = new Scope[]{r100, r101, r102, r103, r104, r105};
        }

        public static Scope[] values() {
            return (Scope[]) $VALUES.clone();
        }

        public static Scope valueOf(String r100) {
            return (Scope) a.a(Scope.class, r100);
        }

        private Scope(String r100, int r101) {
            super(r100, r101);
        }
    }

    Scope[] value();
}
