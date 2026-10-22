package kotlin.reflect.jvm.internal.impl.builtins;

import ga.b;
import ga.c;
import ga.e;
import h9.InterfaceC4149a;
import kotlin.enums.a;
import kotlin.jvm.internal.p;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class UnsignedType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ UnsignedType[] $VALUES;
    public static final UnsignedType UBYTE;
    public static final UnsignedType UINT;
    public static final UnsignedType ULONG;
    public static final UnsignedType USHORT;
    private final b arrayClassId;
    private final b classId;
    private final e typeName;

    private static final /* synthetic */ UnsignedType[] $values() {
        return new UnsignedType[]{UBYTE, USHORT, UINT, ULONG};
    }

    static {
        b.a aVar = b.f32721d;
        UBYTE = new UnsignedType("UBYTE", 0, b.a.b(aVar, "kotlin/UByte", false, 2, null));
        USHORT = new UnsignedType("USHORT", 1, b.a.b(aVar, "kotlin/UShort", false, 2, null));
        UINT = new UnsignedType("UINT", 2, b.a.b(aVar, "kotlin/UInt", false, 2, null));
        ULONG = new UnsignedType("ULONG", 3, b.a.b(aVar, "kotlin/ULong", false, 2, null));
        UnsignedType[] unsignedTypeArr$values = $values();
        $VALUES = unsignedTypeArr$values;
        $ENTRIES = a.a(unsignedTypeArr$values);
    }

    private UnsignedType(String str, int i10, b bVar) {
        this.classId = bVar;
        e eVarH = bVar.h();
        this.typeName = eVarH;
        c cVarF = bVar.f();
        e eVarJ = e.j(eVarH.b() + "Array");
        p.h(eVarJ, "identifier(...)");
        this.arrayClassId = new b(cVarF, eVarJ);
    }

    public static UnsignedType valueOf(String str) {
        return (UnsignedType) Enum.valueOf(UnsignedType.class, str);
    }

    public static UnsignedType[] values() {
        return (UnsignedType[]) $VALUES.clone();
    }

    public final b getArrayClassId() {
        return this.arrayClassId;
    }

    public final b getClassId() {
        return this.classId;
    }

    public final e getTypeName() {
        return this.typeName;
    }
}
