package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: compiled from: UnsignedType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum UnsignedType extends Enum<UnsignedType> {
    private static final /* synthetic */ UnsignedType[] $VALUES = null;
    public static final UnsignedType UBYTE = null;
    public static final UnsignedType UINT = null;
    public static final UnsignedType ULONG = null;
    public static final UnsignedType USHORT = null;
    private final ClassId arrayClassId;
    private final ClassId classId;
    private final Name typeName;

    private static final /* synthetic */ UnsignedType[] $values() {
        return new UnsignedType[]{UBYTE, USHORT, UINT, ULONG};
    }

    public static UnsignedType valueOf(String r1) {
        return (UnsignedType) Enum.valueOf(UnsignedType.class, r1);
    }

    public static UnsignedType[] values() {
        return (UnsignedType[]) $VALUES.clone();
    }

    private UnsignedType(String r2, int r3, ClassId r4) {
        super(r2, r3);
        this.classId = r4;
        Name r5 = r4.getShortClassName();
        Intrinsics.checkNotNullExpressionValue(r5, "classId.shortClassName");
        this.typeName = r5;
        this.arrayClassId = new ClassId(r4.getPackageFqName(), Name.identifier(r5.asString() + "Array"));
    }

    public final ClassId getClassId() {
        return this.classId;
    }

    static {
        ClassId r1 = ClassId.fromString("kotlin/UByte");
        Intrinsics.checkNotNullExpressionValue(r1, "fromString(\"kotlin/UByte\")");
        UBYTE = new UnsignedType("UBYTE", 0, r1);
        ClassId r2 = ClassId.fromString("kotlin/UShort");
        Intrinsics.checkNotNullExpressionValue(r2, "fromString(\"kotlin/UShort\")");
        USHORT = new UnsignedType("USHORT", 1, r2);
        ClassId r3 = ClassId.fromString("kotlin/UInt");
        Intrinsics.checkNotNullExpressionValue(r3, "fromString(\"kotlin/UInt\")");
        UINT = new UnsignedType("UINT", 2, r3);
        ClassId r4 = ClassId.fromString("kotlin/ULong");
        Intrinsics.checkNotNullExpressionValue(r4, "fromString(\"kotlin/ULong\")");
        ULONG = new UnsignedType("ULONG", 3, r4);
        $VALUES = $values();
    }

    public final Name getTypeName() {
        return this.typeName;
    }

    public final ClassId getArrayClassId() {
        return this.arrayClassId;
    }
}
