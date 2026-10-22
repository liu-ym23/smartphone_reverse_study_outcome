package mc;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f8550c;

    /* renamed from: f, reason: collision with root package name */
    public static final a f8551f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f8552g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ a[] f8553h;

    static {
        a aVar = new a("SUSPEND", 0);
        f8550c = aVar;
        a aVar2 = new a("DROP_OLDEST", 1);
        f8551f = aVar2;
        a aVar3 = new a("DROP_LATEST", 2);
        f8552g = aVar3;
        a[] aVarArr = {aVar, aVar2, aVar3};
        f8553h = aVarArr;
        a.a.p(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f8553h.clone();
    }
}
