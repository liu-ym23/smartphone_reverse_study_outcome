package c2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f2180c;

    /* renamed from: f, reason: collision with root package name */
    public static final a f2181f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ a[] f2182g;

    static {
        a aVar = new a("On", 0);
        f2180c = aVar;
        a aVar2 = new a("Off", 1);
        f2181f = aVar2;
        a[] aVarArr = {aVar, aVar2, new a("Indeterminate", 2)};
        f2182g = aVarArr;
        a.a.p(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f2182g.clone();
    }
}
