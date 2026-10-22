package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: TypeUsage.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum TypeUsage extends Enum<TypeUsage> {
    private static final /* synthetic */ TypeUsage[] $VALUES = null;
    public static final TypeUsage COMMON = null;
    public static final TypeUsage SUPERTYPE = null;

    private static final /* synthetic */ TypeUsage[] $values() {
        return new TypeUsage[]{SUPERTYPE, COMMON};
    }

    public static TypeUsage valueOf(String r1) {
        return (TypeUsage) Enum.valueOf(TypeUsage.class, r1);
    }

    public static TypeUsage[] values() {
        return (TypeUsage[]) $VALUES.clone();
    }

    private TypeUsage(String r1, int r2) {
        super(r1, r2);
    }

    static {
        SUPERTYPE = new TypeUsage("SUPERTYPE", 0);
        COMMON = new TypeUsage("COMMON", 1);
        $VALUES = $values();
    }
}
