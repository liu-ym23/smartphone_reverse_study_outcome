package f6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    public static final d f3919c;

    /* renamed from: f, reason: collision with root package name */
    public static final d f3920f;

    /* renamed from: g, reason: collision with root package name */
    public static final d f3921g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ d[] f3922h;

    static {
        d dVar = new d("EXACT", 0);
        f3919c = dVar;
        d dVar2 = new d("INEXACT", 1);
        f3920f = dVar2;
        d dVar3 = new d("AUTOMATIC", 2);
        f3921g = dVar3;
        d[] dVarArr = {dVar, dVar2, dVar3};
        f3922h = dVarArr;
        a.a.p(dVarArr);
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f3922h.clone();
    }
}
