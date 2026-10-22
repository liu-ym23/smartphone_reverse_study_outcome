package g9;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: f, reason: collision with root package name */
    public static final q f3999f;

    /* renamed from: g, reason: collision with root package name */
    public static final q f4000g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ q[] f4001h;

    /* JADX INFO: Fake field, exist only in values array */
    q EF0;

    static {
        q qVar = new q("PRETTY", 0);
        q qVar2 = new q("DEBUG", 1);
        f3999f = qVar2;
        q qVar3 = new q("NONE", 2);
        f4000g = qVar3;
        f4001h = new q[]{qVar, qVar2, qVar3};
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f4001h.clone();
    }
}
