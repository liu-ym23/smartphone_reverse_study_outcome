package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: compiled from: PrimitiveType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum PrimitiveType extends Enum<PrimitiveType> {
    private static final /* synthetic */ PrimitiveType[] $VALUES = null;
    public static final PrimitiveType BOOLEAN = null;
    public static final PrimitiveType BYTE = null;
    public static final PrimitiveType CHAR = null;
    public static final Companion Companion = null;
    public static final PrimitiveType DOUBLE = null;
    public static final PrimitiveType FLOAT = null;
    public static final PrimitiveType INT = null;
    public static final PrimitiveType LONG = null;
    public static final Set<PrimitiveType> NUMBER_TYPES = null;
    public static final PrimitiveType SHORT = null;
    private final Lazy arrayTypeFqName$delegate;
    private final Name arrayTypeName;
    private final Lazy typeFqName$delegate;
    private final Name typeName;

    /* JADX INFO: compiled from: PrimitiveType.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ PrimitiveType[] $values() {
        return new PrimitiveType[]{BOOLEAN, CHAR, BYTE, SHORT, INT, FLOAT, LONG, DOUBLE};
    }

    public static PrimitiveType valueOf(String r1) {
        return (PrimitiveType) Enum.valueOf(PrimitiveType.class, r1);
    }

    public static PrimitiveType[] values() {
        return (PrimitiveType[]) $VALUES.clone();
    }

    private PrimitiveType(String r1, int r2, String r3) {
        super(r1, r2);
        Name r4 = Name.identifier(r3);
        Intrinsics.checkNotNullExpressionValue(r4, "identifier(typeName)");
        this.typeName = r4;
        Name r5 = Name.identifier(r3 + "Array");
        Intrinsics.checkNotNullExpressionValue(r5, "identifier(\"${typeName}Array\")");
        this.arrayTypeName = r5;
        this.typeFqName$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new PrimitiveType$typeFqName$2(this));
        this.arrayTypeFqName$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new PrimitiveType$arrayTypeFqName$2(this));
    }

    static {
        BOOLEAN = new PrimitiveType("BOOLEAN", 0, "Boolean");
        PrimitiveType r0 = new PrimitiveType("CHAR", 1, "Char");
        CHAR = r0;
        PrimitiveType r1 = new PrimitiveType("BYTE", 2, "Byte");
        BYTE = r1;
        PrimitiveType r2 = new PrimitiveType("SHORT", 3, "Short");
        SHORT = r2;
        PrimitiveType r5 = new PrimitiveType("INT", 4, "Int");
        INT = r5;
        PrimitiveType r7 = new PrimitiveType("FLOAT", 5, "Float");
        FLOAT = r7;
        PrimitiveType r9 = new PrimitiveType("LONG", 6, "Long");
        LONG = r9;
        PrimitiveType r11 = new PrimitiveType("DOUBLE", 7, "Double");
        DOUBLE = r11;
        $VALUES = $values();
        Companion = new Companion(null);
        NUMBER_TYPES = SetsKt.setOf(new PrimitiveType[]{r0, r1, r2, r5, r7, r9, r11});
    }

    public final Name getTypeName() {
        return this.typeName;
    }

    public final Name getArrayTypeName() {
        return this.arrayTypeName;
    }

    public final FqName getTypeFqName() {
        return (FqName) this.typeFqName$delegate.getValue();
    }

    public final FqName getArrayTypeFqName() {
        return (FqName) this.arrayTypeFqName$delegate.getValue();
    }
}
