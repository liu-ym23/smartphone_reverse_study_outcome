package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: loaded from: classes4.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f21602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f21603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadContextElement[] f21604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21605d;

    public j0(CoroutineContext r10, int r11) {
        this.f21602a = r10;
        this.f21603b = new Object[r11];
        this.f21604c = new ThreadContextElement[r11];
    }

    public final void a(ThreadContextElement r10, Object r11) {
        Object[] r12 = this.f21603b;
        int r13 = this.f21605d;
        r12[r13] = r11;
        ThreadContextElement[] r14 = this.f21604c;
        this.f21605d = r13 + 1;
        kotlin.jvm.internal.q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        r14[r13] = r10;
    }

    public final void b(CoroutineContext r10) {
        int r11 = this.f21604c.length - 1;
        if (r11 < 0) goto L8;
    L4:
        int r12 = r11 - 1;
        ThreadContextElement r13 = this.f21604c[r11];
        kotlin.jvm.internal.q.d(r13);
        r13.restoreThreadContext(r10, this.f21603b[r11]);
        if (r12 < 0) goto L10;
        r11 = r12;
        goto L4
    L10:
        return;
    }
}
