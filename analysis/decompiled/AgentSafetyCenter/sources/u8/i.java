package u8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: c, reason: collision with root package name */
    public static final i f14209c;

    /* renamed from: f, reason: collision with root package name */
    public static final i f14210f;

    /* renamed from: g, reason: collision with root package name */
    public static final i f14211g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ i[] f14212h;

    static {
        i iVar = new i("None", 0);
        f14209c = iVar;
        i iVar2 = new i("Eligible", 1);
        f14210f = iVar2;
        i iVar3 = new i("Revoked", 2);
        f14211g = iVar3;
        i[] iVarArr = {iVar, iVar2, iVar3};
        f14212h = iVarArr;
        a.a.p(iVarArr);
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) f14212h.clone();
    }
}
