package v1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r1 {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ r1[] f14530c;

    static {
        r1[] r1VarArr = {new r1("Shown", 0), new r1("Hidden", 1)};
        f14530c = r1VarArr;
        a.a.p(r1VarArr);
    }

    public static r1 valueOf(String str) {
        return (r1) Enum.valueOf(r1.class, str);
    }

    public static r1[] values() {
        return (r1[]) f14530c.clone();
    }
}
