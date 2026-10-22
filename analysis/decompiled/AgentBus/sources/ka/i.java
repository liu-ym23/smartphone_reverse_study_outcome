package ka;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final o f5688a = new o(-1, null, null, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final int f5689b = na.b.l("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 12);

    /* renamed from: c, reason: collision with root package name */
    public static final int f5690c = na.b.l("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 12);

    /* renamed from: d, reason: collision with root package name */
    public static final f8.x f5691d = new f8.x("BUFFERED", 3);

    /* renamed from: e, reason: collision with root package name */
    public static final f8.x f5692e = new f8.x("SHOULD_BUFFER", 3);

    /* renamed from: f, reason: collision with root package name */
    public static final f8.x f5693f = new f8.x("S_RESUMING_BY_RCV", 3);

    /* renamed from: g, reason: collision with root package name */
    public static final f8.x f5694g = new f8.x("RESUMING_BY_EB", 3);

    /* renamed from: h, reason: collision with root package name */
    public static final f8.x f5695h = new f8.x("POISONED", 3);

    /* renamed from: i, reason: collision with root package name */
    public static final f8.x f5696i = new f8.x("DONE_RCV", 3);

    /* renamed from: j, reason: collision with root package name */
    public static final f8.x f5697j = new f8.x("INTERRUPTED_SEND", 3);

    /* renamed from: k, reason: collision with root package name */
    public static final f8.x f5698k = new f8.x("INTERRUPTED_RCV", 3);

    /* renamed from: l, reason: collision with root package name */
    public static final f8.x f5699l = new f8.x("CHANNEL_CLOSED", 3);

    /* renamed from: m, reason: collision with root package name */
    public static final f8.x f5700m = new f8.x("SUSPEND", 3);

    /* renamed from: n, reason: collision with root package name */
    public static final f8.x f5701n = new f8.x("SUSPEND_NO_WAITER", 3);

    /* renamed from: o, reason: collision with root package name */
    public static final f8.x f5702o = new f8.x("FAILED", 3);

    /* renamed from: p, reason: collision with root package name */
    public static final f8.x f5703p = new f8.x("NO_RECEIVE_RESULT", 3);

    /* renamed from: q, reason: collision with root package name */
    public static final f8.x f5704q = new f8.x("CLOSE_HANDLER_CLOSED", 3);

    /* renamed from: r, reason: collision with root package name */
    public static final f8.x f5705r = new f8.x("CLOSE_HANDLER_INVOKED", 3);

    /* renamed from: s, reason: collision with root package name */
    public static final f8.x f5706s = new f8.x("NO_CLOSE_CAUSE", 3);

    public static final boolean a(ia.k kVar, Object obj, p7.o oVar) {
        f8.x xVarH = kVar.h(obj, oVar);
        if (xVarH == null) {
            return false;
        }
        kVar.x(xVarH);
        return true;
    }
}
