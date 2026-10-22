package androidx.annotation;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import r27.a;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.METHOD})
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
            ValueType r100 = new ValueType(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            ValueType r101 = new ValueType("INFERRED", 1);
            INFERRED = r101;
            ValueType r102 = new ValueType("INT_ENUM", 2);
            INT_ENUM = r102;
            ValueType r103 = new ValueType("INT_FLAG", 3);
            INT_FLAG = r103;
            ValueType r104 = new ValueType("COLOR", 4);
            COLOR = r104;
            ValueType r105 = new ValueType("GRAVITY", 5);
            GRAVITY = r105;
            ValueType r110 = new ValueType("RESOURCE_ID", 6);
            RESOURCE_ID = r110;
            $VALUES = new ValueType[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static ValueType[] values() {
            return (ValueType[]) $VALUES.clone();
        }

        public static ValueType valueOf(String r100) {
            return (ValueType) a.a(ValueType.class, r100);
        }

        private ValueType(String r100, int r101) {
            super(r100, r101);
        }
    }

    int attributeId() default 0;

    EnumEntry[] enumMapping() default {};

    FlagEntry[] flagMapping() default {};

    boolean hasAttributeId() default true;

    String name() default "";

    ValueType valueType() default ValueType.INFERRED;
}
