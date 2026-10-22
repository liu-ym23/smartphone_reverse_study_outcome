package u4;

import V3.v;
import i4.InterfaceC0772l;
import i4.p;
import p4.InterfaceC0931d;
import s4.InterfaceC1080k;
import x4.C1294F;
import x4.C1297I;

/* renamed from: u4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1165c {

    /* renamed from: a, reason: collision with root package name */
    private static final C1169g<Object> f22940a = new C1169g<>(-1, null, null, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final int f22941b = C1297I.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);

    /* renamed from: c, reason: collision with root package name */
    private static final int f22942c = C1297I.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);

    /* renamed from: d, reason: collision with root package name */
    public static final C1294F f22943d = new C1294F("BUFFERED");

    /* renamed from: e, reason: collision with root package name */
    private static final C1294F f22944e = new C1294F("SHOULD_BUFFER");

    /* renamed from: f, reason: collision with root package name */
    private static final C1294F f22945f = new C1294F("S_RESUMING_BY_RCV");

    /* renamed from: g, reason: collision with root package name */
    private static final C1294F f22946g = new C1294F("RESUMING_BY_EB");

    /* renamed from: h, reason: collision with root package name */
    private static final C1294F f22947h = new C1294F("POISONED");

    /* renamed from: i, reason: collision with root package name */
    private static final C1294F f22948i = new C1294F("DONE_RCV");

    /* renamed from: j, reason: collision with root package name */
    private static final C1294F f22949j = new C1294F("INTERRUPTED_SEND");

    /* renamed from: k, reason: collision with root package name */
    private static final C1294F f22950k = new C1294F("INTERRUPTED_RCV");

    /* renamed from: l, reason: collision with root package name */
    private static final C1294F f22951l = new C1294F("CHANNEL_CLOSED");

    /* renamed from: m, reason: collision with root package name */
    private static final C1294F f22952m = new C1294F("SUSPEND");

    /* renamed from: n, reason: collision with root package name */
    private static final C1294F f22953n = new C1294F("SUSPEND_NO_WAITER");

    /* renamed from: o, reason: collision with root package name */
    private static final C1294F f22954o = new C1294F("FAILED");

    /* renamed from: p, reason: collision with root package name */
    private static final C1294F f22955p = new C1294F("NO_RECEIVE_RESULT");

    /* renamed from: q, reason: collision with root package name */
    private static final C1294F f22956q = new C1294F("CLOSE_HANDLER_CLOSED");

    /* renamed from: r, reason: collision with root package name */
    private static final C1294F f22957r = new C1294F("CLOSE_HANDLER_INVOKED");

    /* renamed from: s, reason: collision with root package name */
    private static final C1294F f22958s = new C1294F("NO_CLOSE_CAUSE");

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* renamed from: u4.c$a */
    /* synthetic */ class a<E> extends j4.j implements p<Long, C1169g<E>, C1169g<E>> {

        /* renamed from: j, reason: collision with root package name */
        public static final a f22959j = new a();

        a() {
            super(2, C1165c.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        @Override // i4.p
        public /* bridge */ /* synthetic */ Object invoke(Long l5, Object obj) {
            return j(l5.longValue(), (C1169g) obj);
        }

        public final C1169g<E> j(long j5, C1169g<E> c1169g) {
            return C1165c.w(j5, c1169g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean A(InterfaceC1080k<? super T> interfaceC1080k, T t5, InterfaceC0772l<? super Throwable, v> interfaceC0772l) {
        Object objE = interfaceC1080k.e(t5, null, interfaceC0772l);
        if (objE == null) {
            return false;
        }
        interfaceC1080k.h(objE);
        return true;
    }

    static /* synthetic */ boolean B(InterfaceC1080k interfaceC1080k, Object obj, InterfaceC0772l interfaceC0772l, int i5, Object obj2) {
        if ((i5 & 2) != 0) {
            interfaceC0772l = null;
        }
        return A(interfaceC1080k, obj, interfaceC0772l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long u(long j5, boolean z5) {
        return (z5 ? 4611686018427387904L : 0L) + j5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long v(long j5, int i5) {
        return (i5 << 60) + j5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> C1169g<E> w(long j5, C1169g<E> c1169g) {
        return new C1169g<>(j5, c1169g, c1169g.y(), 0);
    }

    public static final <E> InterfaceC0931d<C1169g<E>> x() {
        return a.f22959j;
    }

    public static final C1294F y() {
        return f22951l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long z(int i5) {
        if (i5 == 0) {
            return 0L;
        }
        if (i5 != Integer.MAX_VALUE) {
            return i5;
        }
        return Long.MAX_VALUE;
    }
}
