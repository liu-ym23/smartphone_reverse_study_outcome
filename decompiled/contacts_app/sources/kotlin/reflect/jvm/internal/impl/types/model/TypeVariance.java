package kotlin.reflect.jvm.internal.impl.types.model;

/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum TypeVariance extends Enum<TypeVariance> {
    private static final /* synthetic */ TypeVariance[] $VALUES = null;
    public static final TypeVariance IN = null;
    public static final TypeVariance INV = null;
    public static final TypeVariance OUT = null;
    private final String presentation;

    private static final /* synthetic */ TypeVariance[] $values() {
        return new TypeVariance[]{IN, OUT, INV};
    }

    public static TypeVariance valueOf(String r1) {
        return (TypeVariance) Enum.valueOf(TypeVariance.class, r1);
    }

    public static TypeVariance[] values() {
        return (TypeVariance[]) $VALUES.clone();
    }

    private TypeVariance(String r1, int r2, String r3) {
        super(r1, r2);
        this.presentation = r3;
    }

    static {
        IN = new TypeVariance("IN", 0, "in");
        OUT = new TypeVariance("OUT", 1, "out");
        INV = new TypeVariance("INV", 2, "");
        $VALUES = $values();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.presentation;
    }
}
