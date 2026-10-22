package i9;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name */
    public static final f8.b f5833f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f5834g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f5835h;
    public static final b i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ b[] f5836j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ qb.b f5837k;

    /* renamed from: c, reason: collision with root package name */
    public final String f5838c;

    static {
        b bVar = new b("TASK_EXECUTION", 0, "TASK_EXECUTION");
        f5834g = bVar;
        b bVar2 = new b("THIRTY_DAYS", 1, "THIRTY_DAYS");
        f5835h = bVar2;
        b bVar3 = new b("ONLY_ONCE", 2, "ONLY_ONCE");
        i = bVar3;
        b[] bVarArr = {bVar, bVar2, bVar3};
        f5836j = bVarArr;
        f5837k = a.a.p(bVarArr);
        f5833f = new f8.b(9);
    }

    public b(String str, int i3, String str2) {
        this.f5838c = str2;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f5836j.clone();
    }
}
