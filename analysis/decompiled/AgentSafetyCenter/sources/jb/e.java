package jb;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final e f6756c;

    /* renamed from: f, reason: collision with root package name */
    public static final e f6757f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ e[] f6758g;

    static {
        e eVar = new e("SYNCHRONIZED", 0);
        e eVar2 = new e("PUBLICATION", 1);
        f6756c = eVar2;
        e eVar3 = new e("NONE", 2);
        f6757f = eVar3;
        e[] eVarArr = {eVar, eVar2, eVar3};
        f6758g = eVarArr;
        a.a.p(eVarArr);
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f6758g.clone();
    }
}
