package mc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final m f8573a = new m(-1, null, null, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final int f8574b = pc.a.j(32, 12, "kotlinx.coroutines.bufferedChannel.segmentSize");

    /* renamed from: c, reason: collision with root package name */
    public static final int f8575c = pc.a.j(10000, 12, "kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations");

    /* renamed from: d, reason: collision with root package name */
    public static final pc.t f8576d = new pc.t("BUFFERED");

    /* renamed from: e, reason: collision with root package name */
    public static final pc.t f8577e = new pc.t("SHOULD_BUFFER");

    /* renamed from: f, reason: collision with root package name */
    public static final pc.t f8578f = new pc.t("S_RESUMING_BY_RCV");

    /* renamed from: g, reason: collision with root package name */
    public static final pc.t f8579g = new pc.t("RESUMING_BY_EB");

    /* renamed from: h, reason: collision with root package name */
    public static final pc.t f8580h = new pc.t("POISONED");
    public static final pc.t i = new pc.t("DONE_RCV");

    /* renamed from: j, reason: collision with root package name */
    public static final pc.t f8581j = new pc.t("INTERRUPTED_SEND");

    /* renamed from: k, reason: collision with root package name */
    public static final pc.t f8582k = new pc.t("INTERRUPTED_RCV");

    /* renamed from: l, reason: collision with root package name */
    public static final pc.t f8583l = new pc.t("CHANNEL_CLOSED");

    /* renamed from: m, reason: collision with root package name */
    public static final pc.t f8584m = new pc.t("SUSPEND");

    /* renamed from: n, reason: collision with root package name */
    public static final pc.t f8585n = new pc.t("SUSPEND_NO_WAITER");

    /* renamed from: o, reason: collision with root package name */
    public static final pc.t f8586o = new pc.t("FAILED");

    /* renamed from: p, reason: collision with root package name */
    public static final pc.t f8587p = new pc.t("NO_RECEIVE_RESULT");

    /* renamed from: q, reason: collision with root package name */
    public static final pc.t f8588q = new pc.t("CLOSE_HANDLER_CLOSED");

    /* renamed from: r, reason: collision with root package name */
    public static final pc.t f8589r = new pc.t("CLOSE_HANDLER_INVOKED");

    /* renamed from: s, reason: collision with root package name */
    public static final pc.t f8590s = new pc.t("NO_CLOSE_CAUSE");

    public static final boolean a(kc.f fVar, Object obj, xb.q qVar) {
        pc.t tVarK = fVar.k(obj, qVar);
        if (tVarK == null) {
            return false;
        }
        fVar.m(tVarK);
        return true;
    }
}
