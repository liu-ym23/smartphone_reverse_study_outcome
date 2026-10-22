package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

/* JADX INFO: compiled from: KotlinRetention.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum KotlinRetention extends Enum<KotlinRetention> {
    private static final /* synthetic */ KotlinRetention[] $VALUES = null;
    public static final KotlinRetention BINARY = null;
    public static final KotlinRetention RUNTIME = null;
    public static final KotlinRetention SOURCE = null;

    private static final /* synthetic */ KotlinRetention[] $values() {
        return new KotlinRetention[]{RUNTIME, BINARY, SOURCE};
    }

    public static KotlinRetention valueOf(String r1) {
        return (KotlinRetention) Enum.valueOf(KotlinRetention.class, r1);
    }

    public static KotlinRetention[] values() {
        return (KotlinRetention[]) $VALUES.clone();
    }

    private KotlinRetention(String r1, int r2) {
        super(r1, r2);
    }

    static {
        RUNTIME = new KotlinRetention("RUNTIME", 0);
        BINARY = new KotlinRetention("BINARY", 1);
        SOURCE = new KotlinRetention("SOURCE", 2);
        $VALUES = $values();
    }
}
