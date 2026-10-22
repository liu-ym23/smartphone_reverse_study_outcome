package u1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: c, reason: collision with root package name */
    public static final t f13917c;

    /* renamed from: f, reason: collision with root package name */
    public static final t f13918f;

    /* renamed from: g, reason: collision with root package name */
    public static final t f13919g;

    /* renamed from: h, reason: collision with root package name */
    public static final t f13920h;
    public static final /* synthetic */ t[] i;

    static {
        t tVar = new t("LookaheadMeasurement", 0);
        f13917c = tVar;
        t tVar2 = new t("LookaheadPlacement", 1);
        f13918f = tVar2;
        t tVar3 = new t("Measurement", 2);
        f13919g = tVar3;
        t tVar4 = new t("Placement", 3);
        f13920h = tVar4;
        t[] tVarArr = {tVar, tVar2, tVar3, tVar4};
        i = tVarArr;
        a.a.p(tVarArr);
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) i.clone();
    }
}
