package kotlin.reflect.jvm.internal.impl.builtins;

import C9.k;
import C9.l;
import C9.o;
import Y8.h;
import Z8.Y;
import ga.c;
import ga.e;
import h9.InterfaceC4149a;
import java.util.Set;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class PrimitiveType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ PrimitiveType[] $VALUES;
    public static final PrimitiveType BOOLEAN = new PrimitiveType("BOOLEAN", 0, "Boolean");
    public static final PrimitiveType BYTE;
    public static final PrimitiveType CHAR;
    public static final a Companion;
    public static final PrimitiveType DOUBLE;
    public static final PrimitiveType FLOAT;
    public static final PrimitiveType INT;
    public static final PrimitiveType LONG;
    public static final Set<PrimitiveType> NUMBER_TYPES;
    public static final PrimitiveType SHORT;
    private final h arrayTypeFqName$delegate;
    private final e arrayTypeName;
    private final h typeFqName$delegate;
    private final e typeName;

    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public a() {
        }
    }

    private static final /* synthetic */ PrimitiveType[] $values() {
        return new PrimitiveType[]{BOOLEAN, CHAR, BYTE, SHORT, INT, FLOAT, LONG, DOUBLE};
    }

    static {
        PrimitiveType primitiveType = new PrimitiveType("CHAR", 1, "Char");
        CHAR = primitiveType;
        PrimitiveType primitiveType2 = new PrimitiveType("BYTE", 2, "Byte");
        BYTE = primitiveType2;
        PrimitiveType primitiveType3 = new PrimitiveType("SHORT", 3, "Short");
        SHORT = primitiveType3;
        PrimitiveType primitiveType4 = new PrimitiveType("INT", 4, "Int");
        INT = primitiveType4;
        PrimitiveType primitiveType5 = new PrimitiveType("FLOAT", 5, "Float");
        FLOAT = primitiveType5;
        PrimitiveType primitiveType6 = new PrimitiveType("LONG", 6, "Long");
        LONG = primitiveType6;
        PrimitiveType primitiveType7 = new PrimitiveType("DOUBLE", 7, "Double");
        DOUBLE = primitiveType7;
        PrimitiveType[] primitiveTypeArr$values = $values();
        $VALUES = primitiveTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(primitiveTypeArr$values);
        Companion = new a(null);
        NUMBER_TYPES = Y.j(primitiveType, primitiveType2, primitiveType3, primitiveType4, primitiveType5, primitiveType6, primitiveType7);
    }

    private PrimitiveType(String str, int i10, String str2) {
        e eVarJ = e.j(str2);
        p.h(eVarJ, "identifier(...)");
        this.typeName = eVarJ;
        e eVarJ2 = e.j(str2 + "Array");
        p.h(eVarJ2, "identifier(...)");
        this.arrayTypeName = eVarJ2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.typeFqName$delegate = C4848b.a(lazyThreadSafetyMode, new k(this));
        this.arrayTypeFqName$delegate = C4848b.a(lazyThreadSafetyMode, new l(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c arrayTypeFqName_delegate$lambda$0(PrimitiveType primitiveType) {
        return o.f1810B.b(primitiveType.arrayTypeName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c typeFqName_delegate$lambda$0(PrimitiveType primitiveType) {
        return o.f1810B.b(primitiveType.typeName);
    }

    public static PrimitiveType valueOf(String str) {
        return (PrimitiveType) Enum.valueOf(PrimitiveType.class, str);
    }

    public static PrimitiveType[] values() {
        return (PrimitiveType[]) $VALUES.clone();
    }

    public final c getArrayTypeFqName() {
        return (c) this.arrayTypeFqName$delegate.getValue();
    }

    public final e getArrayTypeName() {
        return this.arrayTypeName;
    }

    public final c getTypeFqName() {
        return (c) this.typeFqName$delegate.getValue();
    }

    public final e getTypeName() {
        return this.typeName;
    }
}
