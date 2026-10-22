package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c[] f21541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f21543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f21544d;

    public a() {
    }

    public static final /* synthetic */ int a(a r10) {
        return r10.f21542b;
    }

    public static final /* synthetic */ c[] b(a r10) {
        return r10.f21541a;
    }

    public final c c() {
        monitor-enter(this);
        c[] r10 = this.f21541a;     // Catch: Throwable -> L6
        if (r10 != null) goto L9;
        r10 = e(2);     // Catch: Throwable -> L6
        this.f21541a = r10;     // Catch: Throwable -> L6
    L11:
        int r11 = this.f21543c;     // Catch: Throwable -> L6
    L12:
        c r12 = r10[r11];     // Catch: Throwable -> L6
        if (r12 != null) goto L15;
        r12 = d();     // Catch: Throwable -> L6
        r10[r11] = r12;     // Catch: Throwable -> L6
    L15:
        r11 = r11 + 1;     // Catch: Throwable -> L6
        if (r11 < r10.length) goto L18;
        r11 = 0;
    L18:
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");     // Catch: Throwable -> L6
        if (r12.a(this) == false) goto L12;
        this.f21543c = r11;     // Catch: Throwable -> L6
        this.f21542b++;     // Catch: Throwable -> L6
        q r13 = this.f21544d;     // Catch: Throwable -> L6
        monitor-exit(this);
        if (r13 == null) goto L24;
        r13.U(1);
    L24:
        return r12;
    L9:
        if (this.f21542b < r10.length) goto L11;
        Object[] r14 = Arrays.copyOf(r10, r10.length * 2);     // Catch: Throwable -> L6
        kotlin.jvm.internal.q.f(r14, "copyOf(this, newSize)");     // Catch: Throwable -> L6
        this.f21541a = (c[]) r14;     // Catch: Throwable -> L6
        r10 = (c[]) r14;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public abstract c d();

    public abstract c[] e(int r10);

    public final void f(c r10) {
        monitor-enter(this);
        int r11 = this.f21542b - 1;     // Catch: Throwable -> L6
        this.f21542b = r11;     // Catch: Throwable -> L6
        q r12 = this.f21544d;     // Catch: Throwable -> L6
        int r13 = 0;
        if (r11 != 0) goto L8;
        this.f21543c = 0;     // Catch: Throwable -> L6
    L8:
        kotlin.jvm.internal.q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");     // Catch: Throwable -> L6
        Continuation[] r14 = r10.b(this);     // Catch: Throwable -> L6
        monitor-exit(this);
        int r15 = r14.length;
    L11:
        if (r13 >= r15) goto L16;
        Continuation r16 = r14[r13];
        if (r16 == null) goto L15;
        Result.a r17 = Result.Companion;
        r16.resumeWith(Result.m35constructorimpl(Unit.f21064a));
    L15:
        r13 = r13 + 1;
        goto L11
    L16:
        if (r12 == null) goto L26;
        r12.U(-1);
        return;
    L26:
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final int g() {
        return this.f21542b;
    }

    public final StateFlow getSubscriptionCount() {
        monitor-enter(this);
        q r10 = this.f21544d;     // Catch: Throwable -> L7
        if (r10 != null) goto L9;
        r10 = new q(this.f21542b);     // Catch: Throwable -> L7
        this.f21544d = r10;     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public final c[] h() {
        return this.f21541a;
    }
}
