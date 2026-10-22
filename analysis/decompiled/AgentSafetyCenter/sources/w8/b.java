package w8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final b f15372c;

    /* renamed from: f, reason: collision with root package name */
    public static final b f15373f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f15374g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f15375h;
    public static final b i;

    /* renamed from: j, reason: collision with root package name */
    public static final b f15376j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ b[] f15377k;

    static {
        b bVar = new b("TitleBody", 0);
        f15372c = bVar;
        b bVar2 = new b("TitleOnly", 1);
        f15373f = bVar2;
        b bVar3 = new b("BodyOnly", 2);
        f15374g = bVar3;
        b bVar4 = new b("ImageOnlySingle", 3);
        f15375h = bVar4;
        b bVar5 = new b("ImageOnlyMulti", 4);
        i = bVar5;
        b bVar6 = new b("AttachmentOnly", 5);
        f15376j = bVar6;
        b[] bVarArr = {bVar, bVar2, bVar3, bVar4, bVar5, bVar6};
        f15377k = bVarArr;
        a.a.p(bVarArr);
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f15377k.clone();
    }
}
