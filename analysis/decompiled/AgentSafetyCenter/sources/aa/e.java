package aa;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: f, reason: collision with root package name */
    public static final e f311f;

    /* renamed from: g, reason: collision with root package name */
    public static final e f312g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ e[] f313h;

    /* renamed from: c, reason: collision with root package name */
    public final int f314c;

    static {
        e eVar = new e("NONE", 0, 0);
        e eVar2 = new e("TOP_TO_BOTTOM", 1, 1);
        f311f = eVar2;
        e eVar3 = new e("BOTTOM_TO_TOP", 2, 2);
        f312g = eVar3;
        e[] eVarArr = {eVar, eVar2, eVar3, new e("LEFT_TO_RIGHT", 3, 3), new e("RIGHT_TO_LEFT", 4, 4)};
        f313h = eVarArr;
        a.a.p(eVarArr);
    }

    public e(String str, int i, int i3) {
        this.f314c = i3;
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f313h.clone();
    }
}
