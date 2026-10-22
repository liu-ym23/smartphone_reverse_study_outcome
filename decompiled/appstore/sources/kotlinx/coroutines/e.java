package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.Volatile;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f21410b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Deferred[] f21411a;

    @Volatile
    private volatile int notCompletedCount;

    public final class a extends k1 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f21412h = null;

        @Volatile
        @Nullable
        private volatile Object _disposer;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final CancellableContinuation f21413e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public DisposableHandle f21414f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ e f21415g;

        static {
            f21412h = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_disposer");
        }

        public a(e r10, CancellableContinuation r11) {
            this.f21415g = r10;
            this.f21413e = r11;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object r10) {
            o((Throwable) r10);
            return Unit.f21064a;
        }

        @Override // kotlinx.coroutines.y
        public void o(Throwable r10) {
            if (r10 == null) goto L9;
            Object r11 = this.f21413e.tryResumeWithException(r10);
            if (r11 == null) goto L16;
            this.f21413e.completeResume(r11);
            b r12 = r();
            if (r12 == null) goto L17;
            r12.b();
            return;
        L17:
            return;
        L16:
            return;
        L9:
            if (e.b().decrementAndGet(this.f21415g) != 0) goto L19;
            CancellableContinuation r13 = this.f21413e;
            Deferred[] r14 = e.a(this.f21415g);
            ArrayList r15 = new ArrayList(r14.length);
            int r16 = r14.length;
            int r17 = 0;
        L11:
            if (r17 >= r16) goto L13;
            r15.add(r14[r17].getCompleted());
            r17 = r17 + 1;
            goto L11
        L13:
            r13.resumeWith(Result.m35constructorimpl(r15));
            return;
        }

        public final b r() {
            return (b) f21412h.get(this);
        }

        public final DisposableHandle s() {
            DisposableHandle r10 = this.f21414f;
            if (r10 == null) goto L5;
            return r10;
        L5:
            kotlin.jvm.internal.q.y("handle");
            return null;
        }

        public final void t(b r10) {
            f21412h.set(this, r10);
        }

        public final void u(DisposableHandle r10) {
            this.f21414f = r10;
        }
    }

    public final class b extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a[] f21416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f21417b;

        public b(e r10, a[] r11) {
            this.f21417b = r10;
            this.f21416a = r11;
        }

        @Override // kotlinx.coroutines.m
        public void a(Throwable r10) {
            b();
        }

        public final void b() {
            a[] r10 = this.f21416a;
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            r10[r12].s().dispose();
            r12 = r12 + 1;
            goto L3
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object r10) {
            a((Throwable) r10);
            return Unit.f21064a;
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f21416a + ']';
        }
    }

    static {
        f21410b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount");
    }

    public e(Deferred[] r10) {
        this.f21411a = r10;
        this.notCompletedCount = r10.length;
    }

    public static final /* synthetic */ Deferred[] a(e r10) {
        return r10.f21411a;
    }

    public static final /* synthetic */ AtomicIntegerFieldUpdater b() {
        return f21410b;
    }

    public final Object c(Continuation r10) {
        n r11 = new n(IntrinsicsKt__IntrinsicsJvmKt.c(r10), 1);
        r11.initCancellability();
        int r12 = a(this).length;
        a[] r13 = new a[r12];
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r15 >= r12) goto L5;
        Deferred r16 = a(this)[r15];
        r16.start();
        a r17 = new a(this, r11);
        r17.u(r16.invokeOnCompletion(r17));
        Unit r18 = Unit.f21064a;
        r13[r15] = r17;
        r15 = r15 + 1;
        goto L3
    L5:
        b r19 = new b(this, r13);
    L6:
        if (r14 >= r12) goto L9;
        r13[r14].t(r19);
        r14 = r14 + 1;
        goto L6
    L9:
        if (r11.isCompleted() == false) goto L11;
        r19.b();
    L12:
        Object r20 = r11.q();
        if (r20 != kotlin.coroutines.intrinsics.a.d()) goto L15;
        tf.d.c(r10);
    L15:
        return r20;
    L11:
        r11.invokeOnCancellation(r19);
        goto L12
    }
}
