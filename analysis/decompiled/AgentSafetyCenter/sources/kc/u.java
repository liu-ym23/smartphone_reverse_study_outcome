package kc;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: c, reason: collision with root package name */
    public static final u f7481c;

    /* renamed from: f, reason: collision with root package name */
    public static final u f7482f;

    /* renamed from: g, reason: collision with root package name */
    public static final u f7483g;

    /* renamed from: h, reason: collision with root package name */
    public static final u f7484h;
    public static final /* synthetic */ u[] i;

    static {
        u uVar = new u("DEFAULT", 0);
        f7481c = uVar;
        u uVar2 = new u("LAZY", 1);
        f7482f = uVar2;
        u uVar3 = new u("ATOMIC", 2);
        f7483g = uVar3;
        u uVar4 = new u("UNDISPATCHED", 3);
        f7484h = uVar4;
        u[] uVarArr = {uVar, uVar2, uVar3, uVar4};
        i = uVarArr;
        a.a.p(uVarArr);
    }

    public static u valueOf(String str) {
        return (u) Enum.valueOf(u.class, str);
    }

    public static u[] values() {
        return (u[]) i.clone();
    }
}
