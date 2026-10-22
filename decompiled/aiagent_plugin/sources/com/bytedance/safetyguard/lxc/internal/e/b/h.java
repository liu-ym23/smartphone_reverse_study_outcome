package com.bytedance.safetyguard.lxc.internal.e.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o;
import d.x;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
/* JADX INFO: loaded from: classes.dex */
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<a> f10689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CountDownLatch f10690b;

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    private static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f10691a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f10692b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f10693c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f10694d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f10695e = null;
        private static final /* synthetic */ d.d.a f = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f10691a, f10692b, f10693c, f10694d};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f10695e.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f10691a = new a("ACTIVE", 0);
            f10692b = new a("COMMITTING", 1);
            f10693c = new a("COMPLETED", 2);
            f10694d = new a("CANCELLED", 3);
            a[] r0 = a();
            f10695e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10696a = null;

        static {
            int[] r0 = new int[a.values().length];
            r0[a.f10691a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[a.f10692b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[a.f10693c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[a.f10694d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f10696a = r0;
        }
    }

    /* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
    @d.c.b.a.f(b = "DefaultSafetyGuardSidecar.kt", c = {819}, d = "commit", e = "com.bytedance.safetyguard.lxc.internal.sidecar.core.OperationCommitGate")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f10698b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ h f10699c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f10700d;

        c(h r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10699c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10698b = r3;
            this.f10700d |= Integer.MIN_VALUE;
            return this.f10699c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public h() {
        this.f10689a = new AtomicReference(a.f10691a);
        this.f10690b = new CountDownLatch(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Boolean, java.lang.Object] */
    public final Object a(d.h.a.b<? super d.c.d<? super x>, ? extends Object> r6, d.c.d<? super Boolean> r7) {
        d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
        if ((r0.f10700d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f10700d -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f10698b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f10700d;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        h r5 = (h) ZeusTransformUtils.preCheckCast(r0.f10697a, h.class, "com.obric.aiagent.plugin");
        o.a(r10);     // Catch: Throwable -> L25
        h r11 = r5;
    L23:
        r11.f10689a.set(a.f10693c);
        r11.f10690b.countDown();
        h this = d.c.b.a.b.a(true);
        return this;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        o.a(r10);
        if (this.f10689a.compareAndSet(a.f10691a, a.f10692b) == false) goto L19;
        r0.f10697a = this;     // Catch: Throwable -> L25
        r0.f10700d = 1;     // Catch: Throwable -> L25
        this = this;
        if (r8.invoke(r0) != r2) goto L23;
        return r2;
    L19:
        return d.c.b.a.b.a(false);
    L25:
        th = move-exception;
        this.f10689a.set(a.f10693c);
        this.f10690b.countDown();
        throw th;
    L7:
        r0 = new c(this, r9);
        goto L8
    }

    public final boolean a() {
    L2:
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f10689a.get(), a.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L9;
        if (this.f10689a.compareAndSet(a.f10691a, a.f10694d) == false) goto L2;
        this.f10690b.countDown();
        return true;
    L9:
        if (r1 == 2) goto L16;
        if (r1 == 3) goto L15;
        if (r1 != 4) goto L2;
    L15:
        return false;
    L16:
        c();
        return false;
    L5:
        r1 = b.f10696a[r0.ordinal()];
        goto L7
    }

    public final void b() {
        if (this.f10689a.compareAndSet(a.f10691a, a.f10693c) == false) goto L6;
        this.f10690b.countDown();
        return;
    }

    private final void c() {
        boolean r0 = false;
    L8:
        this.f10690b.await();     // Catch: InterruptedException -> L7
        if (r0 == false) goto L11;
        Thread.currentThread().interrupt();
        return;
    L11:
        return;
    L7:
        r0 = true;
        goto L8
    }
}
