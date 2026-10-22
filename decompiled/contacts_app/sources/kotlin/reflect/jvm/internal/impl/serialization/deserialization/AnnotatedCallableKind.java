package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: loaded from: classes4.dex */
public final enum AnnotatedCallableKind extends Enum<AnnotatedCallableKind> {
    private static final /* synthetic */ AnnotatedCallableKind[] $VALUES = null;
    public static final AnnotatedCallableKind FUNCTION = null;
    public static final AnnotatedCallableKind PROPERTY = null;
    public static final AnnotatedCallableKind PROPERTY_GETTER = null;
    public static final AnnotatedCallableKind PROPERTY_SETTER = null;

    private AnnotatedCallableKind(String r1, int r2) {
        super(r1, r2);
    }

    public static AnnotatedCallableKind valueOf(String r1) {
        return (AnnotatedCallableKind) Enum.valueOf(AnnotatedCallableKind.class, r1);
    }

    public static AnnotatedCallableKind[] values() {
        return (AnnotatedCallableKind[]) $VALUES.clone();
    }

    static {
        AnnotatedCallableKind r0 = new AnnotatedCallableKind("FUNCTION", 0);
        FUNCTION = r0;
        AnnotatedCallableKind r1 = new AnnotatedCallableKind("PROPERTY", 1);
        PROPERTY = r1;
        AnnotatedCallableKind r3 = new AnnotatedCallableKind("PROPERTY_GETTER", 2);
        PROPERTY_GETTER = r3;
        AnnotatedCallableKind r5 = new AnnotatedCallableKind("PROPERTY_SETTER", 3);
        PROPERTY_SETTER = r5;
        $VALUES = new AnnotatedCallableKind[]{r0, r1, r3, r5};
    }
}
