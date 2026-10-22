package o1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: c, reason: collision with root package name */
    public static final k f9059c;

    /* renamed from: f, reason: collision with root package name */
    public static final k f9060f;

    /* renamed from: g, reason: collision with root package name */
    public static final k f9061g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ k[] f9062h;

    static {
        k kVar = new k("Initial", 0);
        f9059c = kVar;
        k kVar2 = new k("Main", 1);
        f9060f = kVar2;
        k kVar3 = new k("Final", 2);
        f9061g = kVar3;
        k[] kVarArr = {kVar, kVar2, kVar3};
        f9062h = kVarArr;
        a.a.p(kVarArr);
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f9062h.clone();
    }
}
