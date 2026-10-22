package androidx.room;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: c, reason: collision with root package name */
    public static final c0 f1513c;

    /* renamed from: f, reason: collision with root package name */
    public static final c0 f1514f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ c0[] f1515g;

    static {
        c0 c0Var = new c0("DEFERRED", 0);
        f1513c = c0Var;
        c0 c0Var2 = new c0("IMMEDIATE", 1);
        f1514f = c0Var2;
        c0[] c0VarArr = {c0Var, c0Var2, new c0("EXCLUSIVE", 2)};
        f1515g = c0VarArr;
        a.a.p(c0VarArr);
    }

    public static c0 valueOf(String str) {
        return (c0) Enum.valueOf(c0.class, str);
    }

    public static c0[] values() {
        return (c0[]) f1515g.clone();
    }
}
