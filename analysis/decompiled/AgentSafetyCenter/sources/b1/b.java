package b1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final b f1806c;

    /* renamed from: f, reason: collision with root package name */
    public static final b f1807f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f1808g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ b[] f1809h;

    static {
        b bVar = new b("None", 0);
        f1806c = bVar;
        b bVar2 = new b("Cancelled", 1);
        f1807f = bVar2;
        b bVar3 = new b("Redirected", 2);
        f1808g = bVar3;
        b[] bVarArr = {bVar, bVar2, bVar3, new b("RedirectCancelled", 3)};
        f1809h = bVarArr;
        a.a.p(bVarArr);
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f1809h.clone();
    }
}
