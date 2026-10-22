package kotlinx.coroutines.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlinx.coroutines.b.a.d;
import kotlinx.coroutines.b.ak;

/* JADX INFO: compiled from: AbstractSharedFlow.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b<S extends d<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private S[] f38877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f38878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f38879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private z f38880d;

    public abstract S[] b(int r1);

    public abstract S g();

    public b() {
    }

    public static final /* synthetic */ int a(b r0) {
        return r0.f38878b;
    }

    public static final /* synthetic */ d[] b(b r0) {
        return r0.f38877a;
    }

    public final S[] h() {
        return this.f38877a;
    }

    public final int i() {
        return this.f38878b;
    }

    public final ak<Integer> a() {
        monitor-enter(this);
        z r0 = this.f38880d;     // Catch: Throwable -> L9
        if (r0 != null) goto L6;
        r0 = new z(this.f38878b);     // Catch: Throwable -> L9
        this.f38880d = r0;     // Catch: Throwable -> L9
    L6:
        monitor-exit(this);
        return (ak) ZeusTransformUtils.preCheckCast(r0, ak.class, "com.obric.aiagent.plugin");
    L9:
        th = move-exception;
        throw th;
    }

    public final S j() {
        monitor-enter(this);
        S[] r0 = this.f38877a;     // Catch: Throwable -> L23
        if (r0 != null) goto L7;
        r0 = (S[]) b(2);
        this.f38877a = r0;     // Catch: Throwable -> L23
    L9:
        int r1 = this.f38879c;     // Catch: Throwable -> L23
    L10:
        S r2 = r0[r1];     // Catch: Throwable -> L23
        if (r2 != null) goto L13;
        r2 = (S) g();
        r0[r1] = r2;     // Catch: Throwable -> L23
    L13:
        r1 = r1 + 1;     // Catch: Throwable -> L23
        if (r1 < r0.length) goto L16;
        r1 = 0;
    L16:
        d.h.b.o.a(r2, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");     // Catch: Throwable -> L23
        if (r2.a(this) == false) goto L10;
        this.f38879c = r1;     // Catch: Throwable -> L23
        this.f38878b++;     // Catch: Throwable -> L23
        z r3 = this.f38880d;     // Catch: Throwable -> L23
        monitor-exit(this);
        if (r3 == null) goto L22;
        r3.c(1);
    L22:
        return r2;
    L7:
        if (this.f38878b < r0.length) goto L9;
        Object[] r4 = Arrays.copyOf(r0, r0.length * 2);     // Catch: Throwable -> L23
        d.h.b.o.c(r4, "copyOf(...)");     // Catch: Throwable -> L23
        this.f38877a = (S[]) ((d[]) ZeusTransformUtils.preCheckCast(r4, d[].class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L23
        r0 = (S[]) ((d[]) ZeusTransformUtils.preCheckCast(r4, d[].class, "com.obric.aiagent.plugin"));
    L23:
        th = move-exception;
        throw th;
    }

    public final void a(S r6) {
        monitor-enter(this);
        int r0 = this.f38878b - 1;     // Catch: Throwable -> L17
        this.f38878b = r0;     // Catch: Throwable -> L17
        z r2 = this.f38880d;     // Catch: Throwable -> L17
        int r3 = 0;
        if (r0 != 0) goto L6;
        this.f38879c = 0;     // Catch: Throwable -> L17
    L6:
        d.h.b.o.a(r6, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");     // Catch: Throwable -> L17
        d.c.d<d.x>[] r7 = r6.b(this);     // Catch: Throwable -> L17
        monitor-exit(this);
        int r5 = r7.length;
    L9:
        if (r3 >= r5) goto L14;
        d.c.d<d.x> r1 = r7[r3];
        if (r1 == null) goto L13;
        d.n.a r4 = d.n.f38560a;
        r1.resumeWith(d.n.f(d.x.f38692a));
    L13:
        r3 = r3 + 1;
        goto L9
    L14:
        if (r2 == null) goto L25;
        r2.c(-1);
        return;
    L25:
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
