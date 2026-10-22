package m;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: f, reason: collision with root package name */
    public static final n f6080f;

    /* renamed from: g, reason: collision with root package name */
    public static final n f6081g;

    /* renamed from: h, reason: collision with root package name */
    public static final n f6082h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ n[] f6083i;

    static {
        n nVar = new n("PreEnter", 0);
        f6080f = nVar;
        n nVar2 = new n("Visible", 1);
        f6081g = nVar2;
        n nVar3 = new n("PostExit", 2);
        f6082h = nVar3;
        f6083i = new n[]{nVar, nVar2, nVar3};
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) f6083i.clone();
    }
}
