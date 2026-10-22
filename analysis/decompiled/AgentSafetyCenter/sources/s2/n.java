package s2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: c, reason: collision with root package name */
    public static final n f11365c;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ n[] f11366f;

    static {
        n nVar = new n("Inherit", 0);
        f11365c = nVar;
        n[] nVarArr = {nVar, new n("SecureOn", 1), new n("SecureOff", 2)};
        f11366f = nVarArr;
        a.a.p(nVarArr);
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) f11366f.clone();
    }
}
