package t8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: c, reason: collision with root package name */
    public static final k f13255c;

    /* renamed from: f, reason: collision with root package name */
    public static final k f13256f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ k[] f13257g;

    static {
        k kVar = new k("FOUND", 0);
        f13255c = kVar;
        k kVar2 = new k("NOT_FOUND", 1);
        f13256f = kVar2;
        k[] kVarArr = {kVar, kVar2, new k("AMBIGUOUS", 2)};
        f13257g = kVarArr;
        a.a.p(kVarArr);
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f13257g.clone();
    }
}
