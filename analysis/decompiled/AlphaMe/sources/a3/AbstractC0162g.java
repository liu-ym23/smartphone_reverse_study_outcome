package a3;

import Z2.InterfaceC0126g;
import f1.AbstractC0557a;
import kotlin.jvm.functions.Function1;

/* renamed from: a3.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0162g {

    /* renamed from: a, reason: collision with root package name */
    public static final C0169n f2290a = new C0169n(-1, null, null, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final int f2291b = AbstractC0557a.e0("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12);

    /* renamed from: c, reason: collision with root package name */
    public static final int f2292c = AbstractC0557a.e0("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12);

    /* renamed from: d, reason: collision with root package name */
    public static final X.r f2293d = new X.r("BUFFERED", 4);

    /* renamed from: e, reason: collision with root package name */
    public static final X.r f2294e = new X.r("SHOULD_BUFFER", 4);

    /* renamed from: f, reason: collision with root package name */
    public static final X.r f2295f = new X.r("S_RESUMING_BY_RCV", 4);

    /* renamed from: g, reason: collision with root package name */
    public static final X.r f2296g = new X.r("RESUMING_BY_EB", 4);

    /* renamed from: h, reason: collision with root package name */
    public static final X.r f2297h = new X.r("POISONED", 4);

    /* renamed from: i, reason: collision with root package name */
    public static final X.r f2298i = new X.r("DONE_RCV", 4);

    /* renamed from: j, reason: collision with root package name */
    public static final X.r f2299j = new X.r("INTERRUPTED_SEND", 4);

    /* renamed from: k, reason: collision with root package name */
    public static final X.r f2300k = new X.r("INTERRUPTED_RCV", 4);

    /* renamed from: l, reason: collision with root package name */
    public static final X.r f2301l = new X.r("CHANNEL_CLOSED", 4);

    /* renamed from: m, reason: collision with root package name */
    public static final X.r f2302m = new X.r("SUSPEND", 4);

    /* renamed from: n, reason: collision with root package name */
    public static final X.r f2303n = new X.r("SUSPEND_NO_WAITER", 4);

    /* renamed from: o, reason: collision with root package name */
    public static final X.r f2304o = new X.r("FAILED", 4);

    /* renamed from: p, reason: collision with root package name */
    public static final X.r f2305p = new X.r("NO_RECEIVE_RESULT", 4);

    /* renamed from: q, reason: collision with root package name */
    public static final X.r f2306q = new X.r("CLOSE_HANDLER_CLOSED", 4);

    /* renamed from: r, reason: collision with root package name */
    public static final X.r f2307r = new X.r("CLOSE_HANDLER_INVOKED", 4);

    /* renamed from: s, reason: collision with root package name */
    public static final X.r f2308s = new X.r("NO_CLOSE_CAUSE", 4);

    public static final boolean a(InterfaceC0126g interfaceC0126g, Object obj, Function1 function1) {
        X.r rVarH = interfaceC0126g.h(obj, function1);
        if (rVarH == null) {
            return false;
        }
        interfaceC0126g.q(rVarH);
        return true;
    }
}
