package v5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final f f14784c;

    /* renamed from: f, reason: collision with root package name */
    public static final f f14785f;

    /* renamed from: g, reason: collision with root package name */
    public static final f f14786g;

    /* renamed from: h, reason: collision with root package name */
    public static final f f14787h;
    public static final /* synthetic */ f[] i;

    static {
        f fVar = new f("MEMORY_CACHE", 0);
        f14784c = fVar;
        f fVar2 = new f("MEMORY", 1);
        f14785f = fVar2;
        f fVar3 = new f("DISK", 2);
        f14786g = fVar3;
        f fVar4 = new f("NETWORK", 3);
        f14787h = fVar4;
        f[] fVarArr = {fVar, fVar2, fVar3, fVar4};
        i = fVarArr;
        a.a.p(fVarArr);
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) i.clone();
    }
}
