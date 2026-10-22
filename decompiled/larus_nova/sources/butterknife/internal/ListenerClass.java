package butterknife.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes28.dex */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ListenerClass {

    public static final enum NONE extends Enum<NONE> {
        private static final /* synthetic */ NONE[] $VALUES = null;

        static {
            $VALUES = new NONE[0];
        }

        public static NONE[] values() {
            return (NONE[]) $VALUES.clone();
        }

        public static NONE valueOf(String r100) {
            return (NONE) r27.a.a(NONE.class, r100);
        }

        private NONE(String r100, int r101) {
            super(r100, r101);
        }
    }

    Class<? extends Enum<?>> callbacks() default NONE.class;

    ListenerMethod[] method() default {};

    String remover() default "";

    String setter();

    String targetType();

    String type();
}
