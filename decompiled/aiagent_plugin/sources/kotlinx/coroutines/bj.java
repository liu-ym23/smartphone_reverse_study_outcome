package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class bj extends ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f39152a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f39153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.a.h<ba<?>> f39154e;

    private final long c(boolean r1) {
        if (r1 == false) goto L4;
        return 4294967296L;
    L4:
        return 1;
    }

    public void b() {
    }

    public boolean g() {
        return false;
    }

    public bj() {
    }

    public long c() {
        if (f() == true) goto L6;
        return Long.MAX_VALUE;
    L6:
        return 0;
    }

    public boolean d() {
        return i();
    }

    public long e() {
        d.a.h<ba<?>> r2 = this.f39154e;
        if (r2 != null) goto L6;
        return Long.MAX_VALUE;
    L6:
        if (r2.isEmpty() == true) goto L10;
        return 0;
    L10:
        return Long.MAX_VALUE;
    }

    public final boolean f() {
        d.a.h<ba<?>> r3 = this.f39154e;
        if (r3 != null) goto L5;
        return false;
    L5:
        ba r4 = (ba) ZeusTransformUtils.preCheckCast(r3.c(), ba.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L8;
        return false;
    L8:
        r4.run();
        return true;
    }

    public final void a(ba<?> r2) {
        d.a.h<ba<?>> r0 = this.f39154e;
        if (r0 != null) goto L5;
        r0 = new d.a.h();
        this.f39154e = r0;
    L5:
        r0.b(r2);
    }

    public final boolean h() {
        if (this.f39152a >= c(true)) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean i() {
        d.a.h<ba<?>> r0 = this.f39154e;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.isEmpty();
    }

    public static /* synthetic */ void a(bj r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.a(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void a(boolean r5) {
        this.f39152a += c(r5);
        if (r5 == true) goto L6;
        this.f39153d = true;
        return;
    }

    public static /* synthetic */ void b(bj r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.b(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    public final void b(boolean r5) {
        long r0 = this.f39152a - c(r5);
        this.f39152a = r0;
        if (r0 <= 0) goto L6;
        return;
    L6:
        if (aq.a() == false) goto L16;
        if (this.f39152a != 0) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == true) goto L16;
        throw new AssertionError();
    L10:
        r6 = false;
    L16:
        if (this.f39153d == false) goto L19;
        b();
        return;
    }

    @Override // kotlinx.coroutines.ai
    public final ai a(int r2) {
        kotlinx.coroutines.internal.u.a(r2);
        return (ai) ZeusTransformUtils.preCheckCast(this, ai.class, "com.obric.aiagent.plugin");
    }
}
