package kotlinx.coroutines.channels;

import com.bytedance.keva.KevaImpl;
import com.google.common.primitives.Longs;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.c0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BufferedChannelKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f21336a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f21337b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f21338c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b0 f21339d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b0 f21340e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b0 f21341f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b0 f21342g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b0 f21343h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b0 f21344i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b0 f21345j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b0 f21346k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b0 f21347l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b0 f21348m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b0 f21349n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final b0 f21350o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b0 f21351p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final b0 f21352q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final b0 f21353r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final b0 f21354s = null;

    static {
        f21336a = new g(-1, null, null, 0);
        f21337b = c0.g("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);
        f21338c = c0.g("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD, 0, 0, 12, null);
        f21339d = new b0("BUFFERED");
        f21340e = new b0("SHOULD_BUFFER");
        f21341f = new b0("S_RESUMING_BY_RCV");
        f21342g = new b0("RESUMING_BY_EB");
        f21343h = new b0("POISONED");
        f21344i = new b0("DONE_RCV");
        f21345j = new b0("INTERRUPTED_SEND");
        f21346k = new b0("INTERRUPTED_RCV");
        f21347l = new b0("CHANNEL_CLOSED");
        f21348m = new b0("SUSPEND");
        f21349n = new b0("SUSPEND_NO_WAITER");
        f21350o = new b0("FAILED");
        f21351p = new b0("NO_RECEIVE_RESULT");
        f21352q = new b0("CLOSE_HANDLER_CLOSED");
        f21353r = new b0("CLOSE_HANDLER_INVOKED");
        f21354s = new b0("NO_CLOSE_CAUSE");
    }

    public static final long A(int r10) {
        if (r10 != 0) goto L4;
        return 0;
    L4:
        if (r10 != Integer.MAX_VALUE) goto L9;
        return Long.MAX_VALUE;
    L9:
        return r10;
    }

    public static final boolean B(CancellableContinuation r10, Object r11, Function1 r12) {
        Object r13 = r10.tryResume(r11, null, r12);
        if (r13 == null) goto L5;
        r10.completeResume(r13);
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ boolean C(CancellableContinuation r10, Object r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = null;
    L6:
        return B(r10, r11, r12);
    }

    public static final /* synthetic */ long a(long r10, boolean r11) {
        return v(r10, r11);
    }

    public static final /* synthetic */ long b(long r10, int r11) {
        return w(r10, r11);
    }

    public static final /* synthetic */ g c(long r10, g r11) {
        return x(r10, r11);
    }

    public static final /* synthetic */ b0 d() {
        return f21352q;
    }

    public static final /* synthetic */ b0 e() {
        return f21353r;
    }

    public static final /* synthetic */ b0 f() {
        return f21344i;
    }

    public static final /* synthetic */ int g() {
        return f21338c;
    }

    public static final /* synthetic */ b0 h() {
        return f21350o;
    }

    public static final /* synthetic */ b0 i() {
        return f21346k;
    }

    public static final /* synthetic */ b0 j() {
        return f21345j;
    }

    public static final /* synthetic */ b0 k() {
        return f21340e;
    }

    public static final /* synthetic */ b0 l() {
        return f21354s;
    }

    public static final /* synthetic */ b0 m() {
        return f21351p;
    }

    public static final /* synthetic */ g n() {
        return f21336a;
    }

    public static final /* synthetic */ b0 o() {
        return f21343h;
    }

    public static final /* synthetic */ b0 p() {
        return f21342g;
    }

    public static final /* synthetic */ b0 q() {
        return f21341f;
    }

    public static final /* synthetic */ b0 r() {
        return f21348m;
    }

    public static final /* synthetic */ b0 s() {
        return f21349n;
    }

    public static final /* synthetic */ long t(int r10) {
        return A(r10);
    }

    public static final /* synthetic */ boolean u(CancellableContinuation r10, Object r11, Function1 r12) {
        return B(r10, r11, r12);
    }

    public static final long v(long r10, boolean r11) {
        if (r11 == false) goto L4;
        long r12 = Longs.MAX_POWER_OF_TWO;
    L6:
        return r12 + r10;
    L4:
        r12 = 0;
        goto L6
    }

    public static final long w(long r10, int r11) {
        return (((long) r11) << 60) + r10;
    }

    public static final g x(long r10, g r11) {
        return new g(r10, r11, r11.u(), 0);
    }

    public static final KFunction y() {
        return BufferedChannelKt$createSegmentFunction$1.INSTANCE;
    }

    public static final b0 z() {
        return f21347l;
    }
}
