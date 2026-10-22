package kotlin.reflect.jvm.internal.impl.load.java.structure;

/* JADX INFO: compiled from: javaElements.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum LightClassOriginKind extends Enum<LightClassOriginKind> {
    private static final /* synthetic */ LightClassOriginKind[] $VALUES = null;
    public static final LightClassOriginKind BINARY = null;
    public static final LightClassOriginKind SOURCE = null;

    private static final /* synthetic */ LightClassOriginKind[] $values() {
        return new LightClassOriginKind[]{SOURCE, BINARY};
    }

    public static LightClassOriginKind valueOf(String r1) {
        return (LightClassOriginKind) Enum.valueOf(LightClassOriginKind.class, r1);
    }

    public static LightClassOriginKind[] values() {
        return (LightClassOriginKind[]) $VALUES.clone();
    }

    private LightClassOriginKind(String r1, int r2) {
        super(r1, r2);
    }

    static {
        SOURCE = new LightClassOriginKind("SOURCE", 0);
        BINARY = new LightClassOriginKind("BINARY", 1);
        $VALUES = $values();
    }
}
