package rc;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final b f10537c;

    /* renamed from: f, reason: collision with root package name */
    public static final b f10538f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f10539g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f10540h;
    public static final b i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ b[] f10541j;

    static {
        b bVar = new b("CPU_ACQUIRED", 0);
        f10537c = bVar;
        b bVar2 = new b("BLOCKING", 1);
        f10538f = bVar2;
        b bVar3 = new b("PARKING", 2);
        f10539g = bVar3;
        b bVar4 = new b("DORMANT", 3);
        f10540h = bVar4;
        b bVar5 = new b("TERMINATED", 4);
        i = bVar5;
        b[] bVarArr = {bVar, bVar2, bVar3, bVar4, bVar5};
        f10541j = bVarArr;
        a.a.p(bVarArr);
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f10541j.clone();
    }
}
