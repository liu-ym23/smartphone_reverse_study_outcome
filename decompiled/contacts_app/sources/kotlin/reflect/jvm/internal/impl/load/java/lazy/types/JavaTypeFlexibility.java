package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

/* JADX INFO: compiled from: JavaTypeFlexibility.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum JavaTypeFlexibility extends Enum<JavaTypeFlexibility> {
    private static final /* synthetic */ JavaTypeFlexibility[] $VALUES = null;
    public static final JavaTypeFlexibility FLEXIBLE_LOWER_BOUND = null;
    public static final JavaTypeFlexibility FLEXIBLE_UPPER_BOUND = null;
    public static final JavaTypeFlexibility INFLEXIBLE = null;

    private static final /* synthetic */ JavaTypeFlexibility[] $values() {
        return new JavaTypeFlexibility[]{INFLEXIBLE, FLEXIBLE_UPPER_BOUND, FLEXIBLE_LOWER_BOUND};
    }

    public static JavaTypeFlexibility valueOf(String r1) {
        return (JavaTypeFlexibility) Enum.valueOf(JavaTypeFlexibility.class, r1);
    }

    public static JavaTypeFlexibility[] values() {
        return (JavaTypeFlexibility[]) $VALUES.clone();
    }

    private JavaTypeFlexibility(String r1, int r2) {
        super(r1, r2);
    }

    static {
        INFLEXIBLE = new JavaTypeFlexibility("INFLEXIBLE", 0);
        FLEXIBLE_UPPER_BOUND = new JavaTypeFlexibility("FLEXIBLE_UPPER_BOUND", 1);
        FLEXIBLE_LOWER_BOUND = new JavaTypeFlexibility("FLEXIBLE_LOWER_BOUND", 2);
        $VALUES = $values();
    }
}
