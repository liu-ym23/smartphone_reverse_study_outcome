package kotlin.reflect.jvm.internal.impl.incremental.components;

/* JADX INFO: compiled from: LookupLocation.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum NoLookupLocation extends Enum<NoLookupLocation> implements LookupLocation {
    private static final /* synthetic */ NoLookupLocation[] $VALUES = null;
    public static final NoLookupLocation FOR_ALREADY_TRACKED = null;
    public static final NoLookupLocation FOR_DEFAULT_IMPORTS = null;
    public static final NoLookupLocation FOR_NON_TRACKED_SCOPE = null;
    public static final NoLookupLocation FOR_SCRIPT = null;
    public static final NoLookupLocation FROM_BACKEND = null;
    public static final NoLookupLocation FROM_BUILTINS = null;
    public static final NoLookupLocation FROM_DESERIALIZATION = null;
    public static final NoLookupLocation FROM_IDE = null;
    public static final NoLookupLocation FROM_JAVA_LOADER = null;
    public static final NoLookupLocation FROM_REFLECTION = null;
    public static final NoLookupLocation FROM_SYNTHETIC_SCOPE = null;
    public static final NoLookupLocation FROM_TEST = null;
    public static final NoLookupLocation WHEN_CHECK_DECLARATION_CONFLICTS = null;
    public static final NoLookupLocation WHEN_CHECK_OVERRIDES = null;
    public static final NoLookupLocation WHEN_FIND_BY_FQNAME = null;
    public static final NoLookupLocation WHEN_GET_ALL_DESCRIPTORS = null;
    public static final NoLookupLocation WHEN_GET_COMPANION_OBJECT = null;
    public static final NoLookupLocation WHEN_GET_DECLARATION_SCOPE = null;
    public static final NoLookupLocation WHEN_GET_LOCAL_VARIABLE = null;
    public static final NoLookupLocation WHEN_GET_SUPER_MEMBERS = null;
    public static final NoLookupLocation WHEN_RESOLVE_DECLARATION = null;
    public static final NoLookupLocation WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS = null;
    public static final NoLookupLocation WHEN_TYPING = null;

    private static final /* synthetic */ NoLookupLocation[] $values() {
        return new NoLookupLocation[]{FROM_IDE, FROM_BACKEND, FROM_TEST, FROM_BUILTINS, WHEN_CHECK_DECLARATION_CONFLICTS, WHEN_CHECK_OVERRIDES, FOR_SCRIPT, FROM_REFLECTION, WHEN_RESOLVE_DECLARATION, WHEN_GET_DECLARATION_SCOPE, WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS, FOR_ALREADY_TRACKED, WHEN_GET_ALL_DESCRIPTORS, WHEN_TYPING, WHEN_GET_SUPER_MEMBERS, FOR_NON_TRACKED_SCOPE, FROM_SYNTHETIC_SCOPE, FROM_DESERIALIZATION, FROM_JAVA_LOADER, WHEN_GET_LOCAL_VARIABLE, WHEN_FIND_BY_FQNAME, WHEN_GET_COMPANION_OBJECT, FOR_DEFAULT_IMPORTS};
    }

    public static NoLookupLocation valueOf(String r1) {
        return (NoLookupLocation) Enum.valueOf(NoLookupLocation.class, r1);
    }

    public static NoLookupLocation[] values() {
        return (NoLookupLocation[]) $VALUES.clone();
    }

    @Override // kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation
    public LocationInfo getLocation() {
        return null;
    }

    private NoLookupLocation(String r1, int r2) {
        super(r1, r2);
    }

    static {
        FROM_IDE = new NoLookupLocation("FROM_IDE", 0);
        FROM_BACKEND = new NoLookupLocation("FROM_BACKEND", 1);
        FROM_TEST = new NoLookupLocation("FROM_TEST", 2);
        FROM_BUILTINS = new NoLookupLocation("FROM_BUILTINS", 3);
        WHEN_CHECK_DECLARATION_CONFLICTS = new NoLookupLocation("WHEN_CHECK_DECLARATION_CONFLICTS", 4);
        WHEN_CHECK_OVERRIDES = new NoLookupLocation("WHEN_CHECK_OVERRIDES", 5);
        FOR_SCRIPT = new NoLookupLocation("FOR_SCRIPT", 6);
        FROM_REFLECTION = new NoLookupLocation("FROM_REFLECTION", 7);
        WHEN_RESOLVE_DECLARATION = new NoLookupLocation("WHEN_RESOLVE_DECLARATION", 8);
        WHEN_GET_DECLARATION_SCOPE = new NoLookupLocation("WHEN_GET_DECLARATION_SCOPE", 9);
        WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS = new NoLookupLocation("WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS", 10);
        FOR_ALREADY_TRACKED = new NoLookupLocation("FOR_ALREADY_TRACKED", 11);
        WHEN_GET_ALL_DESCRIPTORS = new NoLookupLocation("WHEN_GET_ALL_DESCRIPTORS", 12);
        WHEN_TYPING = new NoLookupLocation("WHEN_TYPING", 13);
        WHEN_GET_SUPER_MEMBERS = new NoLookupLocation("WHEN_GET_SUPER_MEMBERS", 14);
        FOR_NON_TRACKED_SCOPE = new NoLookupLocation("FOR_NON_TRACKED_SCOPE", 15);
        FROM_SYNTHETIC_SCOPE = new NoLookupLocation("FROM_SYNTHETIC_SCOPE", 16);
        FROM_DESERIALIZATION = new NoLookupLocation("FROM_DESERIALIZATION", 17);
        FROM_JAVA_LOADER = new NoLookupLocation("FROM_JAVA_LOADER", 18);
        WHEN_GET_LOCAL_VARIABLE = new NoLookupLocation("WHEN_GET_LOCAL_VARIABLE", 19);
        WHEN_FIND_BY_FQNAME = new NoLookupLocation("WHEN_FIND_BY_FQNAME", 20);
        WHEN_GET_COMPANION_OBJECT = new NoLookupLocation("WHEN_GET_COMPANION_OBJECT", 21);
        FOR_DEFAULT_IMPORTS = new NoLookupLocation("FOR_DEFAULT_IMPORTS", 22);
        $VALUES = $values();
    }
}
