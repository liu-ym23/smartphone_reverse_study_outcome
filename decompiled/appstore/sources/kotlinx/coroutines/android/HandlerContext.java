package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import bg.h;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.h1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o1;
import kotlinx.coroutines.r1;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class HandlerContext extends d implements Delay {

    @Nullable
    private volatile HandlerContext _immediate;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f21307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f21308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f21309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HandlerContext f21310f;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuation f21311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HandlerContext f21312b;

        public a(CancellableContinuation r10, HandlerContext r11) {
            this.f21311a = r10;
            this.f21312b = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f21311a.resumeUndispatched(this.f21312b, Unit.f21064a);
        }
    }

    public HandlerContext(Handler r10, String r11, boolean r12) {
        HandlerContext r13 = null;
        super(null);
        this.f21307c = r10;
        this.f21308d = r11;
        this.f21309e = r12;
        if (r12 == false) goto L5;
        r13 = this;
    L5:
        this._immediate = r13;
        HandlerContext r14 = this._immediate;
        if (r14 != null) goto L8;
        r14 = new HandlerContext(r10, r11, true);
        this._immediate = r14;
    L8:
        this.f21310f = r14;
    }

    public static /* synthetic */ void g(HandlerContext r10, Runnable r11) {
        k(r10, r11);
    }

    public static final /* synthetic */ Handler h(HandlerContext r10) {
        return r10.f21307c;
    }

    public static final void k(HandlerContext r10, Runnable r11) {
        r10.f21307c.removeCallbacks(r11);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void a(CoroutineContext r10, Runnable r11) {
        if (this.f21307c.post(r11) == true) goto L6;
        i(r10, r11);
        return;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean c(CoroutineContext r10) {
        if (this.f21309e == true) goto L5;
    L8:
        return true;
    L5:
        if (q.b(Looper.myLooper(), this.f21307c.getLooper()) == false) goto L8;
        return false;
    }

    @Override // kotlinx.coroutines.o1
    public /* bridge */ /* synthetic */ o1 e() {
        return j();
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof HandlerContext) == true) goto L5;
    L7:
        return false;
    L5:
        if (((HandlerContext) r10).f21307c != this.f21307c) goto L7;
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(this.f21307c);
    }

    public final void i(CoroutineContext r10, Runnable r11) {
        h1.c(r10, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        l0.b().a(r10, r11);
    }

    @Override // kotlinx.coroutines.Delay
    public DisposableHandle invokeOnTimeout(long r10, final Runnable r11, CoroutineContext r12) {
        if (this.f21307c.postDelayed(r11, h.h(r10, 4611686018427387903L)) == true) goto L5;
        i(r12, r11);
        return r1.f21672a;
    L5:
        return new c(this, r11);
    }

    public HandlerContext j() {
        return this.f21310f;
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long r10, CancellableContinuation r11) {
        final a r12 = new a(r11, this);
        if (this.f21307c.postDelayed(r12, h.h(r10, 4611686018427387903L)) == false) goto L5;
        r11.invokeOnCancellation(new AnonymousClass1(this, r12));
        return;
    L5:
        i(r11.getContext(), r12);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String r10 = f();
        if (r10 != null) goto L11;
        String r11 = this.f21308d;
        if (r11 != null) goto L8;
        r11 = this.f21307c.toString();
    L8:
        if (this.f21309e == true) goto L10;
        return r11;
    L10:
        return r11 + ".immediate";
    L11:
        return r10;
    }

    public /* synthetic */ HandlerContext(Handler r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public HandlerContext(Handler r10, String r11) {
        this(r10, r11, false);
    }
}
