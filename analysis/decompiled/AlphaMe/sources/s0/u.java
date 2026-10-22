package s0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final u f14214a;

    /* renamed from: b, reason: collision with root package name */
    public static final u f14215b;

    /* renamed from: c, reason: collision with root package name */
    public static final u f14216c;

    /* renamed from: d, reason: collision with root package name */
    public static final u f14217d;

    /* renamed from: e, reason: collision with root package name */
    public static final u f14218e;

    /* renamed from: f, reason: collision with root package name */
    public static final u f14219f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ u[] f14220g;

    static {
        u uVar = new u("NOT_REQUIRED", 0);
        f14214a = uVar;
        u uVar2 = new u("CONNECTED", 1);
        f14215b = uVar2;
        u uVar3 = new u("UNMETERED", 2);
        f14216c = uVar3;
        u uVar4 = new u("NOT_ROAMING", 3);
        f14217d = uVar4;
        u uVar5 = new u("METERED", 4);
        f14218e = uVar5;
        u uVar6 = new u("TEMPORARILY_UNMETERED", 5);
        f14219f = uVar6;
        f14220g = new u[]{uVar, uVar2, uVar3, uVar4, uVar5, uVar6};
    }

    public static u valueOf(String str) {
        return (u) Enum.valueOf(u.class, str);
    }

    public static u[] values() {
        return (u[]) f14220g.clone();
    }
}
