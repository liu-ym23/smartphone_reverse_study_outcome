package t8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f13206c;

    /* renamed from: f, reason: collision with root package name */
    public static final a f13207f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f13208g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f13209h;
    public static final /* synthetic */ a[] i;

    static {
        a aVar = new a("MEDIASTORE_TRASH", 0);
        f13206c = aVar;
        a aVar2 = new a("BATCH_TRASH", 1);
        f13207f = aVar2;
        a aVar3 = new a("GARBAGE_FALLBACK", 2);
        f13208g = aVar3;
        a aVar4 = new a("UNKNOWN", 3);
        f13209h = aVar4;
        a[] aVarArr = {aVar, aVar2, aVar3, aVar4};
        i = aVarArr;
        a.a.p(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) i.clone();
    }
}
