package s0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class C {

    /* renamed from: a, reason: collision with root package name */
    public static final C f14150a;

    /* renamed from: b, reason: collision with root package name */
    public static final C f14151b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ C[] f14152c;

    static {
        C c4 = new C("RUN_AS_NON_EXPEDITED_WORK_REQUEST", 0);
        f14150a = c4;
        C c5 = new C("DROP_WORK_REQUEST", 1);
        f14151b = c5;
        f14152c = new C[]{c4, c5};
    }

    public static C valueOf(String str) {
        return (C) Enum.valueOf(C.class, str);
    }

    public static C[] values() {
        return (C[]) f14152c.clone();
    }
}
