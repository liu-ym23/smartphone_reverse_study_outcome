package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX INFO: compiled from: TypeComponentPosition.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum TypeComponentPosition extends Enum<TypeComponentPosition> {
    private static final /* synthetic */ TypeComponentPosition[] $VALUES = null;
    public static final TypeComponentPosition FLEXIBLE_LOWER = null;
    public static final TypeComponentPosition FLEXIBLE_UPPER = null;
    public static final TypeComponentPosition INFLEXIBLE = null;

    private static final /* synthetic */ TypeComponentPosition[] $values() {
        return new TypeComponentPosition[]{FLEXIBLE_LOWER, FLEXIBLE_UPPER, INFLEXIBLE};
    }

    public static TypeComponentPosition valueOf(String r1) {
        return (TypeComponentPosition) Enum.valueOf(TypeComponentPosition.class, r1);
    }

    public static TypeComponentPosition[] values() {
        return (TypeComponentPosition[]) $VALUES.clone();
    }

    private TypeComponentPosition(String r1, int r2) {
        super(r1, r2);
    }

    static {
        FLEXIBLE_LOWER = new TypeComponentPosition("FLEXIBLE_LOWER", 0);
        FLEXIBLE_UPPER = new TypeComponentPosition("FLEXIBLE_UPPER", 1);
        INFLEXIBLE = new TypeComponentPosition("INFLEXIBLE", 2);
        $VALUES = $values();
    }
}
