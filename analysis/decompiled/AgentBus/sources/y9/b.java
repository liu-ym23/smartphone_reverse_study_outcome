package y9;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name */
    public static final b f11723f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ b[] f11724g;

    static {
        b bVar = new b("FOR_SUBTYPING", 0);
        f11723f = bVar;
        f11724g = new b[]{bVar, new b("FOR_INCORPORATION", 1), new b("FROM_EXPRESSION", 2)};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f11724g.clone();
    }
}
