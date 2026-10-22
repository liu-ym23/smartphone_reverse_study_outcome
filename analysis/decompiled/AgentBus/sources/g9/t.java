package g9;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: f, reason: collision with root package name */
    public static final s f4002f;

    /* renamed from: g, reason: collision with root package name */
    public static final r f4003g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ t[] f4004h;

    static {
        s sVar = new s();
        f4002f = sVar;
        r rVar = new r();
        f4003g = rVar;
        f4004h = new t[]{sVar, rVar};
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) f4004h.clone();
    }

    public abstract String a(String str);
}
