package J2;

import b4.C0567b;
import b4.InterfaceC0566a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f3212a = new c("WARNING", 0);

    /* renamed from: b, reason: collision with root package name */
    public static final c f3213b = new c("DEGRADED", 1);

    /* renamed from: c, reason: collision with root package name */
    public static final c f3214c = new c("FATAL", 2);

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ c[] f3215d;

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ InterfaceC0566a f3216e;

    static {
        c[] cVarArrB = b();
        f3215d = cVarArrB;
        f3216e = C0567b.a(cVarArrB);
    }

    private c(String str, int i5) {
    }

    private static final /* synthetic */ c[] b() {
        return new c[]{f3212a, f3213b, f3214c};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f3215d.clone();
    }
}
