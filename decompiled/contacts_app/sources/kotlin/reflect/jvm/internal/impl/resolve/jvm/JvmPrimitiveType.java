package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import androidx.exifinterface.media.ExifInterface;
import com.android.vcard.VCardConstants;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes4.dex */
public final enum JvmPrimitiveType extends Enum<JvmPrimitiveType> {
    private static final /* synthetic */ JvmPrimitiveType[] $VALUES = null;
    public static final JvmPrimitiveType BOOLEAN = null;
    public static final JvmPrimitiveType BYTE = null;
    public static final JvmPrimitiveType CHAR = null;
    public static final JvmPrimitiveType DOUBLE = null;
    public static final JvmPrimitiveType FLOAT = null;
    public static final JvmPrimitiveType INT = null;
    public static final JvmPrimitiveType LONG = null;
    public static final JvmPrimitiveType SHORT = null;
    private static final Map<String, JvmPrimitiveType> TYPE_BY_DESC = null;
    private static final Map<String, JvmPrimitiveType> TYPE_BY_NAME = null;
    private static final Map<PrimitiveType, JvmPrimitiveType> TYPE_BY_PRIMITIVE_TYPE = null;
    private static final Set<FqName> WRAPPERS_CLASS_NAMES = null;
    private final String desc;
    private final String name;
    private final PrimitiveType primitiveType;
    private final FqName wrapperFqName;

    private static /* synthetic */ void $$$reportNull$$$0(int r7) {
        if (r7 == 2) goto L7;
        if (r7 == 4) goto L7;
        switch(r7) {
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L7;
            case 13: goto L7;
            default: goto L6;
        };
    L6:
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r7 == 2) goto L12;
        if (r7 == 4) goto L44;
        switch(r7) {
            case 10: goto L45;
            case 11: goto L45;
            case 12: goto L45;
            case 13: goto L45;
            default: goto L11;
        };
    L11:
        int r3 = 3;
    L13:
        Object[] r4 = new Object[r3];
        switch(r7) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L21;
            case 8: goto L18;
            case 9: goto L16;
            case 10: goto L20;
            case 11: goto L20;
            case 12: goto L20;
            case 13: goto L20;
            default: goto L15;
        };
    L15:
        r4[0] = "className";
    L23:
        if (r7 == 2) goto L31;
        if (r7 == 4) goto L31;
        switch(r7) {
            case 10: goto L30;
            case 11: goto L29;
            case 12: goto L28;
            case 13: goto L27;
            default: goto L26;
        };
    L26:
        r4[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
    L32:
        switch(r7) {
            case 1: goto L36;
            case 2: goto L37;
            case 3: goto L36;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L34;
            case 7: goto L34;
            case 8: goto L34;
            case 9: goto L34;
            case 10: goto L37;
            case 11: goto L37;
            case 12: goto L37;
            case 13: goto L37;
            default: goto L33;
        };
    L33:
        r4[2] = "isWrapperClassName";
        goto L37
    L34:
        r4[2] = "<init>";
        goto L37
    L35:
        r4[2] = "getByDesc";
        goto L37
    L36:
        r4[2] = "get";
    L37:
        String r5 = String.format(r2, r4);
        if (r7 == 2) goto L43;
        if (r7 == 4) goto L43;
        switch(r7) {
            case 10: goto L43;
            case 11: goto L43;
            case 12: goto L43;
            case 13: goto L43;
            default: goto L46;
        };
    L46:
        throw new IllegalArgumentException(r5);
    L43:
        throw new IllegalStateException(r5);
    L27:
        r4[1] = "getWrapperFqName";
        goto L32
    L28:
        r4[1] = "getDesc";
        goto L32
    L29:
        r4[1] = "getJavaKeywordName";
        goto L32
    L30:
        r4[1] = "getPrimitiveType";
    L31:
        r4[1] = "get";
        goto L32
    L16:
        r4[0] = "wrapperClassName";
        goto L23
    L17:
        r4[0] = "primitiveType";
        goto L23
    L18:
        r4[0] = "desc";
        goto L23
    L19:
        r4[0] = "type";
        goto L23
    L20:
        r4[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
        goto L23
    L21:
        r4[0] = "name";
        goto L23
    L45:
        r3 = 2;
        goto L13
    L44:
        r3 = 2;
        goto L13
    L12:
        r3 = 2;
    L7:
        r2 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    public static JvmPrimitiveType valueOf(String r1) {
        return (JvmPrimitiveType) Enum.valueOf(JvmPrimitiveType.class, r1);
    }

    public static JvmPrimitiveType[] values() {
        return (JvmPrimitiveType[]) $VALUES.clone();
    }

    static {
        JvmPrimitiveType r7 = new JvmPrimitiveType("BOOLEAN", 0, PrimitiveType.BOOLEAN, "boolean", "Z", "java.lang.Boolean");
        BOOLEAN = r7;
        JvmPrimitiveType r0 = new JvmPrimitiveType("CHAR", 1, PrimitiveType.CHAR, "char", "C", "java.lang.Character");
        CHAR = r0;
        JvmPrimitiveType r1 = new JvmPrimitiveType("BYTE", 2, PrimitiveType.BYTE, "byte", VCardConstants.PARAM_ENCODING_B, "java.lang.Byte");
        BYTE = r1;
        JvmPrimitiveType r2 = new JvmPrimitiveType("SHORT", 3, PrimitiveType.SHORT, "short", ExifInterface.LATITUDE_SOUTH, "java.lang.Short");
        SHORT = r2;
        JvmPrimitiveType r3 = new JvmPrimitiveType("INT", 4, PrimitiveType.INT, "int", "I", "java.lang.Integer");
        INT = r3;
        JvmPrimitiveType r4 = new JvmPrimitiveType("FLOAT", 5, PrimitiveType.FLOAT, "float", "F", "java.lang.Float");
        FLOAT = r4;
        JvmPrimitiveType r5 = new JvmPrimitiveType("LONG", 6, PrimitiveType.LONG, WsChannelMultiProcessSharedProvider.LONG_TYPE, "J", "java.lang.Long");
        LONG = r5;
        JvmPrimitiveType r6 = new JvmPrimitiveType("DOUBLE", 7, PrimitiveType.DOUBLE, "double", "D", "java.lang.Double");
        DOUBLE = r6;
        int r9 = 0;
        $VALUES = new JvmPrimitiveType[]{r7, r0, r1, r2, r3, r4, r5, r6};
        WRAPPERS_CLASS_NAMES = new HashSet();
        TYPE_BY_NAME = new HashMap();
        TYPE_BY_PRIMITIVE_TYPE = new EnumMap(PrimitiveType.class);
        TYPE_BY_DESC = new HashMap();
        JvmPrimitiveType[] r8 = values();
        int r10 = r8.length;
    L3:
        if (r9 >= r10) goto L5;
        JvmPrimitiveType r11 = r8[r9];
        WRAPPERS_CLASS_NAMES.add(r11.getWrapperFqName());
        TYPE_BY_NAME.put(r11.getJavaKeywordName(), r11);
        TYPE_BY_PRIMITIVE_TYPE.put(r11.getPrimitiveType(), r11);
        TYPE_BY_DESC.put(r11.getDesc(), r11);
        r9 = r9 + 1;
        goto L3
    }

    public static JvmPrimitiveType get(String r3) {
        if (r3 != null) goto L4;
        $$$reportNull$$$0(1);
    L4:
        JvmPrimitiveType r0 = TYPE_BY_NAME.get(r3);
        if (r0 == null) goto L10;
        if (r0 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        return r0;
    L10:
        throw new AssertionError("Non-primitive type name passed: " + r3);
    }

    public static JvmPrimitiveType get(PrimitiveType r1) {
        if (r1 != null) goto L4;
        $$$reportNull$$$0(3);
    L4:
        JvmPrimitiveType r2 = TYPE_BY_PRIMITIVE_TYPE.get(r1);
        if (r2 != null) goto L7;
        $$$reportNull$$$0(4);
    L7:
        return r2;
    }

    private JvmPrimitiveType(String r2, int r3, PrimitiveType r4, String r5, String r6, String r7) {
        if (r4 != null) goto L4;
        $$$reportNull$$$0(6);
    L4:
        if (r5 != null) goto L6;
        $$$reportNull$$$0(7);
    L6:
        if (r6 != null) goto L8;
        $$$reportNull$$$0(8);
    L8:
        if (r7 != null) goto L10;
        $$$reportNull$$$0(9);
    L10:
        super(r2, r3);
        this.primitiveType = r4;
        this.name = r5;
        this.desc = r6;
        this.wrapperFqName = new FqName(r7);
    }

    public PrimitiveType getPrimitiveType() {
        PrimitiveType r1 = this.primitiveType;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(10);
    L5:
        return r1;
    }

    public String getJavaKeywordName() {
        String r1 = this.name;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(11);
    L5:
        return r1;
    }

    public String getDesc() {
        String r1 = this.desc;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(12);
    L5:
        return r1;
    }

    public FqName getWrapperFqName() {
        FqName r1 = this.wrapperFqName;
        if (r1 != null) goto L5;
        $$$reportNull$$$0(13);
    L5:
        return r1;
    }
}
