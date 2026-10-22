package n8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class c implements a {

    /* renamed from: f, reason: collision with root package name */
    public static final c f6877f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f6878g;

    /* renamed from: h, reason: collision with root package name */
    public static final c f6879h;

    /* renamed from: i, reason: collision with root package name */
    public static final c f6880i;

    /* renamed from: j, reason: collision with root package name */
    public static final c f6881j;

    /* renamed from: k, reason: collision with root package name */
    public static final c f6882k;

    /* renamed from: l, reason: collision with root package name */
    public static final c f6883l;

    /* renamed from: m, reason: collision with root package name */
    public static final c f6884m;

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ c[] f6885n;

    /* JADX INFO: Fake field, exist only in values array */
    c EF1;

    static {
        c cVar = new c("FROM_IDE", 0);
        c cVar2 = new c("FROM_BACKEND", 1);
        c cVar3 = new c("FROM_TEST", 2);
        c cVar4 = new c("FROM_BUILTINS", 3);
        f6877f = cVar4;
        c cVar5 = new c("WHEN_CHECK_DECLARATION_CONFLICTS", 4);
        c cVar6 = new c("WHEN_CHECK_OVERRIDES", 5);
        c cVar7 = new c("FOR_SCRIPT", 6);
        c cVar8 = new c("FROM_REFLECTION", 7);
        f6878g = cVar8;
        c cVar9 = new c("WHEN_RESOLVE_DECLARATION", 8);
        c cVar10 = new c("WHEN_GET_DECLARATION_SCOPE", 9);
        c cVar11 = new c("WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS", 10);
        c cVar12 = new c("FOR_ALREADY_TRACKED", 11);
        f6879h = cVar12;
        c cVar13 = new c("WHEN_GET_ALL_DESCRIPTORS", 12);
        f6880i = cVar13;
        c cVar14 = new c("WHEN_TYPING", 13);
        c cVar15 = new c("WHEN_GET_SUPER_MEMBERS", 14);
        f6881j = cVar15;
        c cVar16 = new c("FOR_NON_TRACKED_SCOPE", 15);
        f6882k = cVar16;
        c cVar17 = new c("FROM_SYNTHETIC_SCOPE", 16);
        c cVar18 = new c("FROM_DESERIALIZATION", 17);
        f6883l = cVar18;
        c cVar19 = new c("FROM_JAVA_LOADER", 18);
        f6884m = cVar19;
        f6885n = new c[]{cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, cVar8, cVar9, cVar10, cVar11, cVar12, cVar13, cVar14, cVar15, cVar16, cVar17, cVar18, cVar19, new c("WHEN_GET_LOCAL_VARIABLE", 19), new c("WHEN_FIND_BY_FQNAME", 20), new c("WHEN_GET_COMPANION_OBJECT", 21), new c("FOR_DEFAULT_IMPORTS", 22)};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f6885n.clone();
    }
}
