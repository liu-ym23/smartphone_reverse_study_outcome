package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.exifinterface.media.ExifInterface;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes4.dex */
final class JvmTypeFactoryImpl implements JvmTypeFactory<JvmType> {
    public static final JvmTypeFactoryImpl INSTANCE = null;

    /* JADX INFO: compiled from: methodSignatureMapping.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[PrimitiveType.values().length];
            r0[PrimitiveType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[PrimitiveType.CHAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[PrimitiveType.BYTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[PrimitiveType.SHORT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[PrimitiveType.INT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[PrimitiveType.FLOAT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[PrimitiveType.LONG.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[PrimitiveType.DOUBLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        INSTANCE = new JvmTypeFactoryImpl();
    }

    private JvmTypeFactoryImpl() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType boxType(JvmType r1) {
        return boxType2(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType createFromString(String r1) {
        return createFromString2(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType createObjectType(String r1) {
        return createObjectType2(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType createPrimitiveType(PrimitiveType r1) {
        return createPrimitiveType2(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType getJavaLangClassType() {
        return getJavaLangClassType2();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ String toString(JvmType r1) {
        return toString2(r1);
    }

    /* JADX INFO: renamed from: boxType, reason: avoid collision after fix types in other method */
    public JvmType boxType2(JvmType r3) {
        Intrinsics.checkNotNullParameter(r3, "possiblyPrimitiveType");
        if ((r3 instanceof JvmType.Primitive) == false) goto L8;
        JvmType.Primitive r0 = (JvmType.Primitive) r3;
        if (r0.getJvmPrimitiveType() == null) goto L9;
        String r4 = JvmClassName.byFqNameWithoutInnerClasses(r0.getJvmPrimitiveType().getWrapperFqName()).getInternalName();
        Intrinsics.checkNotNullExpressionValue(r4, "byFqNameWithoutInnerClas…apperFqName).internalName");
        return createObjectType2(r4);
    L9:
        return r3;
    L8:
        return r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    /* JADX INFO: renamed from: createFromString, reason: avoid collision after fix types in other method */
    public JvmType createFromString2(String r11) {
        Intrinsics.checkNotNullParameter(r11, "representation");
        String r0 = r11;
        r0.length();
        char r2 = r11.charAt(0);
        JvmPrimitiveType[] r3 = JvmPrimitiveType.values();
        int r4 = r3.length;
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L12;
        JvmPrimitiveType r8 = r3[r5];
        if (r8.getDesc().charAt(0) != r2) goto L8;
        boolean r9 = true;
    L9:
        if (r9 == true) goto L13;
        r5 = r5 + 1;
    L13:
        if (r8 == null) goto L17;
        return new JvmType.Primitive(r8);
    L17:
        if (r2 != 'V') goto L20;
        return new JvmType.Primitive(null);
    L20:
        if (r2 != '[') goto L23;
        String r12 = r11.substring(1);
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).substring(startIndex)");
        return new JvmType.Array(createFromString2(r12));
    L23:
        if (r2 != 'L') goto L25;
        StringsKt.endsWith$default(r0, ';', false, 2, null);
    L25:
        String r13 = r11.substring(1, r11.length() - 1);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String…ing(startIndex, endIndex)");
        return new JvmType.Object(r13);
    L8:
        r9 = false;
        goto L9
    L12:
        r8 = null;
        goto L13
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    /* JADX INFO: renamed from: createPrimitiveType, reason: avoid collision after fix types in other method */
    public JvmType createPrimitiveType2(PrimitiveType r1) {
        Intrinsics.checkNotNullParameter(r1, "primitiveType");
        switch(WhenMappings.$EnumSwitchMapping$0[r1.ordinal()]) {
            case 1: goto L14;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L15:
        return JvmType.Companion.getDOUBLE$descriptors_jvm();
    L16:
        return JvmType.Companion.getLONG$descriptors_jvm();
    L17:
        return JvmType.Companion.getFLOAT$descriptors_jvm();
    L18:
        return JvmType.Companion.getINT$descriptors_jvm();
    L19:
        return JvmType.Companion.getSHORT$descriptors_jvm();
    L20:
        return JvmType.Companion.getBYTE$descriptors_jvm();
    L21:
        return JvmType.Companion.getCHAR$descriptors_jvm();
    L14:
        return JvmType.Companion.getBOOLEAN$descriptors_jvm();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    /* JADX INFO: renamed from: createObjectType, reason: avoid collision after fix types in other method */
    public JvmType createObjectType2(String r1) {
        Intrinsics.checkNotNullParameter(r1, "internalName");
        return new JvmType.Object(r1);
    }

    /* JADX INFO: renamed from: toString, reason: avoid collision after fix types in other method */
    public String toString2(JvmType r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        if ((r3 instanceof JvmType.Array) == false) goto L6;
        return "[" + toString2(((JvmType.Array) r3).getElementType());
    L6:
        if ((r3 instanceof JvmType.Primitive) == false) goto L13;
        JvmPrimitiveType r2 = ((JvmType.Primitive) r3).getJvmPrimitiveType();
        if (r2 == null) goto L11;
        String r4 = r2.getDesc();
        if (r4 == null) goto L11;
        return r4;
    L11:
        return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
    L13:
        if ((r3 instanceof JvmType.Object) == false) goto L17;
        return "L" + ((JvmType.Object) r3).getInternalName() + ';';
    L17:
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    /* JADX INFO: renamed from: getJavaLangClassType, reason: avoid collision after fix types in other method */
    public JvmType getJavaLangClassType2() {
        return createObjectType2("java/lang/Class");
    }
}
