package fb;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final c f4052c;

    /* renamed from: f, reason: collision with root package name */
    public static final c f4053f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f4054g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ c[] f4055h;

    static {
        c cVar = new c("DISABLED", 0);
        f4052c = cVar;
        c cVar2 = new c("PENDING", 1);
        f4053f = cVar2;
        c cVar3 = new c("MOTION_KIT", 2);
        f4054g = cVar3;
        c[] cVarArr = {cVar, cVar2, cVar3};
        f4055h = cVarArr;
        a.a.p(cVarArr);
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f4055h.clone();
    }
}
