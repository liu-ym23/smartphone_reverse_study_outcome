package a9;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: f, reason: collision with root package name */
    public static final c f246f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f247g;

    /* renamed from: h, reason: collision with root package name */
    public static final c f248h;
    public static final c i;

    /* renamed from: j, reason: collision with root package name */
    public static final c f249j;

    /* renamed from: k, reason: collision with root package name */
    public static final c f250k;

    /* renamed from: l, reason: collision with root package name */
    public static final c f251l;

    /* renamed from: m, reason: collision with root package name */
    public static final c f252m;

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ c[] f253n;

    /* renamed from: c, reason: collision with root package name */
    public final String f254c;

    static {
        c cVar = new c("INVALID_REQUEST", 0, "INVALID_REQUEST");
        f246f = cVar;
        c cVar2 = new c("PATH_NOT_ALLOWED", 1, "PATH_NOT_ALLOWED");
        f247g = cVar2;
        c cVar3 = new c("FILE_NOT_FOUND", 2, "FILE_NOT_FOUND");
        f248h = cVar3;
        c cVar4 = new c("TOO_MANY_FILES", 3, "TOO_MANY_FILES");
        i = cVar4;
        c cVar5 = new c("TRASH_FAILED", 4, "TRASH_FAILED");
        f249j = cVar5;
        c cVar6 = new c("RESTORE_NOT_FOUND", 5, "RESTORE_NOT_FOUND");
        f250k = cVar6;
        c cVar7 = new c("TARGET_EXISTS", 6, "TARGET_EXISTS");
        f251l = cVar7;
        c cVar8 = new c("RESTORE_FAILED", 7, "RESTORE_FAILED");
        f252m = cVar8;
        c[] cVarArr = {cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, cVar8};
        f253n = cVarArr;
        a.a.p(cVarArr);
    }

    public c(String str, int i3, String str2) {
        this.f254c = str2;
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f253n.clone();
    }
}
