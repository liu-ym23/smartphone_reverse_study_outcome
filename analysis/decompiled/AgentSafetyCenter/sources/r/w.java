package r;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: c, reason: collision with root package name */
    public static final w f10348c;

    /* renamed from: f, reason: collision with root package name */
    public static final w f10349f;

    /* renamed from: g, reason: collision with root package name */
    public static final w f10350g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ w[] f10351h;

    static {
        w wVar = new w("PreEnter", 0);
        f10348c = wVar;
        w wVar2 = new w("Visible", 1);
        f10349f = wVar2;
        w wVar3 = new w("PostExit", 2);
        f10350g = wVar3;
        f10351h = new w[]{wVar, wVar2, wVar3};
    }

    public static w valueOf(String str) {
        return (w) Enum.valueOf(w.class, str);
    }

    public static w[] values() {
        return (w[]) f10351h.clone();
    }
}
