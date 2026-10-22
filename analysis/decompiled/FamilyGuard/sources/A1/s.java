package A1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f68a;

    /* renamed from: b, reason: collision with root package name */
    public static final s f69b;

    /* renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ s[] f70c;

    enum a extends s {
        a(String str, int i5) {
            super(str, i5, null);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        f68a = aVar;
        s sVar = new s("STRING", 1) { // from class: A1.s.b
            {
                a aVar2 = null;
            }
        };
        f69b = sVar;
        f70c = new s[]{aVar, sVar};
    }

    private s(String str, int i5) {
    }

    public static s valueOf(String str) {
        return (s) Enum.valueOf(s.class, str);
    }

    public static s[] values() {
        return (s[]) f70c.clone();
    }

    /* synthetic */ s(String str, int i5, a aVar) {
        this(str, i5);
    }
}
