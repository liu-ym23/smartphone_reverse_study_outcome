package p1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final b f9683c;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ b[] f9684f;

    static {
        b bVar = new b("Lsq2", 0);
        f9683c = bVar;
        b[] bVarArr = {bVar, new b("Impulse", 1)};
        f9684f = bVarArr;
        a.a.p(bVarArr);
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f9684f.clone();
    }
}
