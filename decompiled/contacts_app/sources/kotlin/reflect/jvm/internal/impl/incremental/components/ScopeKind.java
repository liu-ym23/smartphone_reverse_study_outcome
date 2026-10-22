package kotlin.reflect.jvm.internal.impl.incremental.components;

/* JADX INFO: compiled from: LookupTracker.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum ScopeKind extends Enum<ScopeKind> {
    private static final /* synthetic */ ScopeKind[] $VALUES = null;
    public static final ScopeKind CLASSIFIER = null;
    public static final ScopeKind PACKAGE = null;

    private static final /* synthetic */ ScopeKind[] $values() {
        return new ScopeKind[]{PACKAGE, CLASSIFIER};
    }

    public static ScopeKind valueOf(String r1) {
        return (ScopeKind) Enum.valueOf(ScopeKind.class, r1);
    }

    public static ScopeKind[] values() {
        return (ScopeKind[]) $VALUES.clone();
    }

    private ScopeKind(String r1, int r2) {
        super(r1, r2);
    }

    static {
        PACKAGE = new ScopeKind("PACKAGE", 0);
        CLASSIFIER = new ScopeKind("CLASSIFIER", 1);
        $VALUES = $values();
    }
}
