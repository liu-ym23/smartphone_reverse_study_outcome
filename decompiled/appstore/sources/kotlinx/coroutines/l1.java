package kotlinx.coroutines;

/* JADX INFO: loaded from: classes4.dex */
public abstract class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f21638a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f21639b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f21640c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f21641d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f21642e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final p0 f21643f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final p0 f21644g = null;

    static {
        f21638a = new kotlinx.coroutines.internal.b0("COMPLETING_ALREADY");
        f21639b = new kotlinx.coroutines.internal.b0("COMPLETING_WAITING_CHILDREN");
        f21640c = new kotlinx.coroutines.internal.b0("COMPLETING_RETRY");
        f21641d = new kotlinx.coroutines.internal.b0("TOO_LATE_TO_CANCEL");
        f21642e = new kotlinx.coroutines.internal.b0("SEALED");
        f21643f = new p0(false);
        f21644g = new p0(true);
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.b0 a() {
        return f21638a;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.b0 b() {
        return f21640c;
    }

    public static final /* synthetic */ p0 c() {
        return f21644g;
    }

    public static final /* synthetic */ p0 d() {
        return f21643f;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.b0 e() {
        return f21642e;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.b0 f() {
        return f21641d;
    }

    public static final Object g(Object r10) {
        if ((r10 instanceof Incomplete) == true) goto L5;
        return r10;
    L5:
        return new a1((Incomplete) r10);
    }

    public static final Object h(Object r10) {
        if ((r10 instanceof a1) == false) goto L5;
        a1 r11 = (a1) r10;
    L6:
        if (r11 == null) goto L12;
        Incomplete r12 = r11.f21302a;
        if (r12 != null) goto L11;
        return r10;
    L11:
        return r12;
    L12:
        return r10;
    L5:
        r11 = null;
        goto L6
    }
}
