package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: compiled from: UnsignedType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum UnsignedArrayType extends Enum<UnsignedArrayType> {
    private static final /* synthetic */ UnsignedArrayType[] $VALUES = null;
    public static final UnsignedArrayType UBYTEARRAY = null;
    public static final UnsignedArrayType UINTARRAY = null;
    public static final UnsignedArrayType ULONGARRAY = null;
    public static final UnsignedArrayType USHORTARRAY = null;
    private final ClassId classId;
    private final Name typeName;

    private static final /* synthetic */ UnsignedArrayType[] $values() {
        return new UnsignedArrayType[]{UBYTEARRAY, USHORTARRAY, UINTARRAY, ULONGARRAY};
    }

    public static UnsignedArrayType valueOf(String r1) {
        return (UnsignedArrayType) Enum.valueOf(UnsignedArrayType.class, r1);
    }

    public static UnsignedArrayType[] values() {
        return (UnsignedArrayType[]) $VALUES.clone();
    }

    private UnsignedArrayType(String r1, int r2, ClassId r3) {
        super(r1, r2);
        this.classId = r3;
        Name r4 = r3.getShortClassName();
        Intrinsics.checkNotNullExpressionValue(r4, "classId.shortClassName");
        this.typeName = r4;
    }

    static {
        ClassId r1 = ClassId.fromString("kotlin/UByteArray");
        Intrinsics.checkNotNullExpressionValue(r1, "fromString(\"kotlin/UByteArray\")");
        UBYTEARRAY = new UnsignedArrayType("UBYTEARRAY", 0, r1);
        ClassId r2 = ClassId.fromString("kotlin/UShortArray");
        Intrinsics.checkNotNullExpressionValue(r2, "fromString(\"kotlin/UShortArray\")");
        USHORTARRAY = new UnsignedArrayType("USHORTARRAY", 1, r2);
        ClassId r3 = ClassId.fromString("kotlin/UIntArray");
        Intrinsics.checkNotNullExpressionValue(r3, "fromString(\"kotlin/UIntArray\")");
        UINTARRAY = new UnsignedArrayType("UINTARRAY", 2, r3);
        ClassId r4 = ClassId.fromString("kotlin/ULongArray");
        Intrinsics.checkNotNullExpressionValue(r4, "fromString(\"kotlin/ULongArray\")");
        ULONGARRAY = new UnsignedArrayType("ULONGARRAY", 3, r4);
        $VALUES = $values();
    }

    public final Name getTypeName() {
        return this.typeName;
    }
}
