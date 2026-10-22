package kotlinx.coroutines.a;

import com.bytedance.keva.KevaImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import kotlinx.coroutines.internal.al;
import kotlinx.coroutines.internal.am;

/* JADX INFO: compiled from: BufferedChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38799a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final al f38800b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final i<Object> f38801c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f38802d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final al f38803e = null;
    private static final al f = null;
    private static final al g = null;
    private static final al h = null;
    private static final al i = null;
    private static final al j = null;
    private static final al k = null;
    private static final al l = null;
    private static final al m = null;
    private static final al n = null;
    private static final al o = null;
    private static final al p = null;
    private static final al q = null;
    private static final al r = null;
    private static final al s = null;

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: compiled from: BufferedChannel.kt */
    /* synthetic */ class a<E> extends d.h.b.l implements d.h.a.m<Long, i<E>, i<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f38804a = null;

        static {
            f38804a = new a();
        }

        a() {
            super(2, c.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        public final i<E> a(long r1, i<E> r3) {
            return c.a(r1, r3);
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(Long r5, Object r6) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).longValue(), (i) ZeusTransformUtils.preCheckCast(r6, i.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final /* synthetic */ long a(int r2) {
        return b(r2);
    }

    public static final /* synthetic */ long a(long r0, int r2) {
        return b(r0, r2);
    }

    public static final /* synthetic */ long a(long r0, boolean r2) {
        return b(r0, r2);
    }

    public static final /* synthetic */ i a(long r0, i r2) {
        return b(r0, r2);
    }

    public static final /* synthetic */ boolean a(kotlinx.coroutines.n r2, Object r3, d.h.a.b r4) {
        return b((kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin"), r3, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private static final long b(int r2) {
        if (r2 != 0) goto L4;
        return 0;
    L4:
        if (r2 != Integer.MAX_VALUE) goto L9;
        return Long.MAX_VALUE;
    L9:
        return r2;
    }

    private static final long b(long r2, int r4) {
        return (((long) r4) << 60) + r2;
    }

    private static final long b(long r2, boolean r4) {
        if (r4 == false) goto L4;
        long r0 = 4611686018427387904L;
    L6:
        return r0 + r2;
    L4:
        r0 = 0;
        goto L6
    }

    public static final /* synthetic */ i c() {
        return f38801c;
    }

    public static final /* synthetic */ al d() {
        return s;
    }

    public static final /* synthetic */ al e() {
        return j;
    }

    public static final /* synthetic */ al f() {
        return i;
    }

    public static final /* synthetic */ al g() {
        return k;
    }

    public static final /* synthetic */ al h() {
        return f38803e;
    }

    public static final /* synthetic */ al i() {
        return h;
    }

    public static final /* synthetic */ al j() {
        return o;
    }

    public static final /* synthetic */ al k() {
        return m;
    }

    public static final /* synthetic */ al l() {
        return n;
    }

    public static final /* synthetic */ al m() {
        return g;
    }

    public static final /* synthetic */ al n() {
        return f;
    }

    public static final /* synthetic */ int o() {
        return f38802d;
    }

    public static final /* synthetic */ al p() {
        return p;
    }

    public static final /* synthetic */ al q() {
        return q;
    }

    public static final /* synthetic */ al r() {
        return r;
    }

    public static final <E> d.m.e<i<E>> a() {
        return (d.m.e) ZeusTransformUtils.preCheckCast(a.f38804a, d.m.e.class, "com.obric.aiagent.plugin");
    }

    private static final <E> i<E> b(long r7, i<E> r9) {
        return new i(r7, r9, r9.a(), 0);
    }

    static {
        f38801c = new i(-1, null, null, 0);
        f38799a = am.a("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);
        f38802d = am.a("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD, 0, 0, 12, null);
        f38800b = new al("BUFFERED");
        f38803e = new al("SHOULD_BUFFER");
        f = new al("S_RESUMING_BY_RCV");
        g = new al("RESUMING_BY_EB");
        h = new al("POISONED");
        i = new al("DONE_RCV");
        j = new al("INTERRUPTED_SEND");
        k = new al("INTERRUPTED_RCV");
        l = new al("CHANNEL_CLOSED");
        m = new al("SUSPEND");
        n = new al("SUSPEND_NO_WAITER");
        o = new al("FAILED");
        p = new al("NO_RECEIVE_RESULT");
        q = new al("CLOSE_HANDLER_CLOSED");
        r = new al("CLOSE_HANDLER_INVOKED");
        s = new al("NO_CLOSE_CAUSE");
    }

    static /* synthetic */ boolean a(kotlinx.coroutines.n r1, Object r2, d.h.a.b r3, int r4, Object r5) {
        kotlinx.coroutines.n r6 = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r1, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r7 = null;
    L6:
        return b(r6, r2, r7);
    }

    private static final <T> boolean b(kotlinx.coroutines.n<? super T> r2, T r3, d.h.a.b<? super Throwable, x> r4) {
        kotlinx.coroutines.n r5 = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        Object r6 = r5.a(r3, null, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin"));
        if (r6 == null) goto L5;
        r5.a(r6);
        return true;
    L5:
        return false;
    }

    public static final al b() {
        return l;
    }
}
