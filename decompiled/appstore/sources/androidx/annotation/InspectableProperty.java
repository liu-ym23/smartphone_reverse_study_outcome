package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Deprecated
@Retention(RetentionPolicy.SOURCE)
public @interface InspectableProperty {

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface EnumEntry {
        String name();

        int value();
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FlagEntry {
        int mask() default 0;

        String name();

        int target();
    }

    public static final enum ValueType extends Enum<ValueType> {
        private static final /* synthetic */ ValueType[] $VALUES = null;
        public static final ValueType COLOR = null;
        public static final ValueType GRAVITY = null;
        public static final ValueType INFERRED = null;
        public static final ValueType INT_ENUM = null;
        public static final ValueType INT_FLAG = null;
        public static final ValueType NONE = null;
        public static final ValueType RESOURCE_ID = null;

        static {
            ValueType r10 = new ValueType("NONE", 0);
            NONE = r10;
            ValueType r11 = new ValueType("INFERRED", 1);
            INFERRED = r11;
            ValueType r12 = new ValueType("INT_ENUM", 2);
            INT_ENUM = r12;
            ValueType r13 = new ValueType("INT_FLAG", 3);
            INT_FLAG = r13;
            ValueType r14 = new ValueType("COLOR", 4);
            COLOR = r14;
            ValueType r15 = new ValueType("GRAVITY", 5);
            GRAVITY = r15;
            ValueType r16 = new ValueType("RESOURCE_ID", 6);
            RESOURCE_ID = r16;
            $VALUES = new ValueType[]{r10, r11, r12, r13, r14, r15, r16};
        }

        private ValueType(String r10, int r11) {
            super(r10, r11);
        }

        public static ValueType valueOf(String r10) {
            return (ValueType) Enum.valueOf(ValueType.class, r10);
        }

        public static ValueType[] values() {
            return (ValueType[]) $VALUES.clone();
        }
    }

    int attributeId() default 0;

    EnumEntry[] enumMapping() default {};

    FlagEntry[] flagMapping() default {};

    boolean hasAttributeId() default true;

    String name() default "";

    ValueType valueType() default ValueType.INFERRED;
}
