package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: ClassKind.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum ClassKind extends Enum<ClassKind> {
    private static final /* synthetic */ ClassKind[] $VALUES = null;
    public static final ClassKind ANNOTATION_CLASS = null;
    public static final ClassKind CLASS = null;
    public static final ClassKind ENUM_CLASS = null;
    public static final ClassKind ENUM_ENTRY = null;
    public static final ClassKind INTERFACE = null;
    public static final ClassKind OBJECT = null;
    private final String codeRepresentation;

    private static final /* synthetic */ ClassKind[] $values() {
        return new ClassKind[]{CLASS, INTERFACE, ENUM_CLASS, ENUM_ENTRY, ANNOTATION_CLASS, OBJECT};
    }

    public static ClassKind valueOf(String r1) {
        return (ClassKind) Enum.valueOf(ClassKind.class, r1);
    }

    public static ClassKind[] values() {
        return (ClassKind[]) $VALUES.clone();
    }

    private ClassKind(String r1, int r2, String r3) {
        super(r1, r2);
        this.codeRepresentation = r3;
    }

    static {
        CLASS = new ClassKind("CLASS", 0, "class");
        INTERFACE = new ClassKind("INTERFACE", 1, "interface");
        ENUM_CLASS = new ClassKind("ENUM_CLASS", 2, "enum class");
        ENUM_ENTRY = new ClassKind("ENUM_ENTRY", 3, null);
        ANNOTATION_CLASS = new ClassKind("ANNOTATION_CLASS", 4, "annotation class");
        OBJECT = new ClassKind("OBJECT", 5, "object");
        $VALUES = $values();
    }

    public final boolean isSingleton() {
        if (this != OBJECT) goto L5;
    L8:
        return true;
    L5:
        if (this == ENUM_ENTRY) goto L8;
        return false;
    }
}
