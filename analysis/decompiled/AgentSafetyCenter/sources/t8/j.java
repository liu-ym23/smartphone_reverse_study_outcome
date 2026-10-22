package t8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    public static final j f13251c;

    /* renamed from: f, reason: collision with root package name */
    public static final j f13252f;

    /* renamed from: g, reason: collision with root package name */
    public static final j f13253g;

    /* renamed from: h, reason: collision with root package name */
    public static final j f13254h;
    public static final /* synthetic */ j[] i;

    static {
        j jVar = new j("RECEIPT", 0);
        f13251c = jVar;
        j jVar2 = new j("MEDIASTORE", 1);
        f13252f = jVar2;
        j jVar3 = new j("GARBAGE", 2);
        f13253g = jVar3;
        j jVar4 = new j("HEURISTIC", 3);
        f13254h = jVar4;
        j[] jVarArr = {jVar, jVar2, jVar3, jVar4};
        i = jVarArr;
        a.a.p(jVarArr);
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) i.clone();
    }
}
