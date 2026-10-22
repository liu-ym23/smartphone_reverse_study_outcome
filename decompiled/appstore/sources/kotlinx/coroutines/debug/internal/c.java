package kotlinx.coroutines.debug.internal;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.y;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f21396a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final StackTraceElement f21397b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SimpleDateFormat f21398c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentWeakMap f21399d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f21400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f21401f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Function1 f21402g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ConcurrentWeakMap f21403h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f21404i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0294c f21405j = null;

    public static final class a implements Continuation, CoroutineStackFrame {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f21406a = null;

        @Volatile
        private volatile int installations;

        static {
            f21406a = AtomicIntegerFieldUpdater.newUpdater(b.class, "installations");
        }

        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.debug.internal.c$c, reason: collision with other inner class name */
    public static final class C0294c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AtomicLongFieldUpdater f21407a = null;

        @Volatile
        private volatile long sequenceNumber;

        static {
            f21407a = AtomicLongFieldUpdater.newUpdater(C0294c.class, "sequenceNumber");
        }

        public C0294c() {
        }

        public /* synthetic */ C0294c(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        c r10 = new c();
        f21396a = r10;
        f21397b = new a.a().b();
        f21398c = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DefaultConstructorMarker r11 = null;
        f21399d = new ConcurrentWeakMap(false, 1, r11);
        f21400e = true;
        f21401f = true;
        f21402g = r10.c();
        f21403h = new ConcurrentWeakMap(true);
        f21404i = new b(r11);
        f21405j = new C0294c(r11);
    }

    public c() {
    }

    public static final /* synthetic */ ConcurrentWeakMap a() {
        return f21403h;
    }

    public static final /* synthetic */ boolean b(c r10, a r11) {
        return r10.d(r11);
    }

    public final Function1 c() {
        Object r10 = null;
        Result.a r11 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(null);     // Catch: Throwable -> L5
        q.e(r12, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");     // Catch: Throwable -> L5
        Object r13 = Result.m35constructorimpl((Function1) y.e(r12, 1));     // Catch: Throwable -> L5
    L8:
        if (Result.m41isFailureimpl(r13) == true) goto L12;
        r10 = r13;
    L12:
        return (Function1) r10;
    L5:
        th = move-exception;
        Result.a r14 = Result.Companion;
        r13 = Result.m35constructorimpl(kotlin.c.a(th));
        goto L8
    }

    public final boolean d(a r10) {
        throw null;
    }
}
