package f6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final f f3923c;

    /* renamed from: f, reason: collision with root package name */
    public static final f f3924f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ f[] f3925g;

    static {
        f fVar = new f("FILL", 0);
        f3923c = fVar;
        f fVar2 = new f("FIT", 1);
        f3924f = fVar2;
        f[] fVarArr = {fVar, fVar2};
        f3925g = fVarArr;
        a.a.p(fVarArr);
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) f3925g.clone();
    }
}
