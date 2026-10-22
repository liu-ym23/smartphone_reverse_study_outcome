package e6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: g, reason: collision with root package name */
    public static final b f3508g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f3509h;
    public static final /* synthetic */ b[] i;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3510c;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3511f;

    static {
        b bVar = new b("ENABLED", 0, true, true);
        f3508g = bVar;
        b bVar2 = new b("READ_ONLY", 1, true, false);
        b bVar3 = new b("WRITE_ONLY", 2, false, true);
        b bVar4 = new b("DISABLED", 3, false, false);
        f3509h = bVar4;
        b[] bVarArr = {bVar, bVar2, bVar3, bVar4};
        i = bVarArr;
        a.a.p(bVarArr);
    }

    public b(String str, int i3, boolean z10, boolean z11) {
        this.f3510c = z10;
        this.f3511f = z11;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) i.clone();
    }
}
