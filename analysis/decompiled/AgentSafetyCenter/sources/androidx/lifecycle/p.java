package androidx.lifecycle;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: c, reason: collision with root package name */
    public static final p f1418c;

    /* renamed from: f, reason: collision with root package name */
    public static final p f1419f;

    /* renamed from: g, reason: collision with root package name */
    public static final p f1420g;

    /* renamed from: h, reason: collision with root package name */
    public static final p f1421h;
    public static final p i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ p[] f1422j;

    static {
        p pVar = new p("DESTROYED", 0);
        f1418c = pVar;
        p pVar2 = new p("INITIALIZED", 1);
        f1419f = pVar2;
        p pVar3 = new p("CREATED", 2);
        f1420g = pVar3;
        p pVar4 = new p("STARTED", 3);
        f1421h = pVar4;
        p pVar5 = new p("RESUMED", 4);
        i = pVar5;
        p[] pVarArr = {pVar, pVar2, pVar3, pVar4, pVar5};
        f1422j = pVarArr;
        a.a.p(pVarArr);
    }

    public static p valueOf(String str) {
        return (p) Enum.valueOf(p.class, str);
    }

    public static p[] values() {
        return (p[]) f1422j.clone();
    }
}
