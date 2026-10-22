package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

/* JADX INFO: compiled from: DeprecationInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum DeprecationLevelValue extends Enum<DeprecationLevelValue> {
    private static final /* synthetic */ DeprecationLevelValue[] $VALUES = null;
    public static final DeprecationLevelValue ERROR = null;
    public static final DeprecationLevelValue HIDDEN = null;
    public static final DeprecationLevelValue WARNING = null;

    private static final /* synthetic */ DeprecationLevelValue[] $values() {
        return new DeprecationLevelValue[]{WARNING, ERROR, HIDDEN};
    }

    public static DeprecationLevelValue valueOf(String r1) {
        return (DeprecationLevelValue) Enum.valueOf(DeprecationLevelValue.class, r1);
    }

    public static DeprecationLevelValue[] values() {
        return (DeprecationLevelValue[]) $VALUES.clone();
    }

    private DeprecationLevelValue(String r1, int r2) {
        super(r1, r2);
    }

    static {
        WARNING = new DeprecationLevelValue("WARNING", 0);
        ERROR = new DeprecationLevelValue("ERROR", 1);
        HIDDEN = new DeprecationLevelValue("HIDDEN", 2);
        $VALUES = $values();
    }
}
