package u8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: c, reason: collision with root package name */
    public static final p f14243c;

    /* renamed from: f, reason: collision with root package name */
    public static final p f14244f;

    /* renamed from: g, reason: collision with root package name */
    public static final p f14245g;

    /* renamed from: h, reason: collision with root package name */
    public static final p f14246h;
    public static final /* synthetic */ p[] i;

    static {
        p pVar = new p("File", 0);
        f14243c = pVar;
        p pVar2 = new p("Contact", 1);
        f14244f = pVar2;
        p pVar3 = new p("Note", 2);
        f14245g = pVar3;
        p pVar4 = new p("None", 3);
        f14246h = pVar4;
        p[] pVarArr = {pVar, pVar2, pVar3, pVar4};
        i = pVarArr;
        a.a.p(pVarArr);
    }

    public static p valueOf(String str) {
        return (p) Enum.valueOf(p.class, str);
    }

    public static p[] values() {
        return (p[]) i.clone();
    }
}
