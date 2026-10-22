package y8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: f, reason: collision with root package name */
    public static final d f16012f;

    /* renamed from: g, reason: collision with root package name */
    public static final w f16013g;

    /* renamed from: h, reason: collision with root package name */
    public static final w f16014h;
    public static final /* synthetic */ w[] i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ qb.b f16015j;

    /* renamed from: c, reason: collision with root package name */
    public final String f16016c;

    static {
        w wVar = new w("Rules", 0, "rules");
        f16013g = wVar;
        w wVar2 = new w("Grants", 1, "grants");
        f16014h = wVar2;
        w[] wVarArr = {wVar, wVar2};
        i = wVarArr;
        f16015j = a.a.p(wVarArr);
        f16012f = new d();
    }

    public w(String str, int i3, String str2) {
        this.f16016c = str2;
    }

    public static w valueOf(String str) {
        return (w) Enum.valueOf(w.class, str);
    }

    public static w[] values() {
        return (w[]) i.clone();
    }
}
