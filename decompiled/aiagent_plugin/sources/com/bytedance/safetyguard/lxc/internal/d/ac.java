package com.bytedance.safetyguard.lxc.internal.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: TcpProxyStream.kt */
/* JADX INFO: loaded from: classes.dex */
final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f10113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque<ab> f10114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlinx.coroutines.a.d<d.x> f10115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10116e;
    private boolean f;
    private boolean g;

    /* JADX INFO: compiled from: TcpProxyStream.kt */
    @d.c.b.a.f(b = "TcpProxyStream.kt", c = {232}, d = "consume", e = "com.bytedance.safetyguard.lxc.internal.proxy.RemoteWriteQueue")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f10118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f10119c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f10120d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ac f10121e;
        int f;

        a(ac r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10121e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f10120d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f10121e.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public ac(int r3) {
        this.f10112a = r3;
        this.f10113b = new Object();
        this.f10114c = new ArrayDeque();
        this.f10115d = kotlinx.coroutines.a.g.a(-1, null, null, 6, null);
    }

    public final boolean a(byte[] r7) {
        d.h.b.o.e(r7, "payload");
        Object r0 = this.f10113b;
        monitor-enter(r0);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.g == false) goto L7;
    L24:
        monitor-exit(r0);
        return false;
    L7:
        if (this.f == true) goto L24;
        if (r7.length <= (this.f10112a - this.f10116e)) goto L14;
        monitor-exit(r0);
        return false;
    L14:
        ab r1 = (ab) ZeusTransformUtils.preCheckCast(this.f10114c.peekLast(), ab.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (ZeusTransformUtils.instanceOf(r1, ab.a.class) == true) goto L17;
    L19:
        this.f10114c.addLast(new ab.a(r7));     // Catch: Throwable -> L26
    L20:
        this.f10116e += r7.length;     // Catch: Throwable -> L26
        d.x r8 = d.x.f38692a;     // Catch: Throwable -> L26
        monitor-exit(r0);
        return kotlinx.coroutines.a.h.a(this.f10115d.a_(d.x.f38692a));
    L17:
        if (((ab.a) ZeusTransformUtils.preCheckCast(r1, ab.a.class, "com.obric.aiagent.plugin")).a().length > (32768 - r7.length)) goto L19;
        this.f10114c.removeLast();     // Catch: Throwable -> L26
        this.f10114c.addLast(new ab.a(d.a.i.a(((ab.a) ZeusTransformUtils.preCheckCast(r1, ab.a.class, "com.obric.aiagent.plugin")).a(), r7)));     // Catch: Throwable -> L26
        goto L20
    }

    public final boolean a() {
        Object r0 = this.f10113b;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.g == true) goto L14;
        if (this.f == true) goto L14;
        this.f = true;     // Catch: Throwable -> L16
        this.f10114c.addLast(ab.b.f10111a);     // Catch: Throwable -> L16
        d.x r1 = d.x.f38692a;     // Catch: Throwable -> L16
        monitor-exit(r0);
        return kotlinx.coroutines.a.h.a(this.f10115d.a_(d.x.f38692a));
    L14:
        monitor-exit(r0);
        return false;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0096 -> B:12:0x006f). Please report as a decompilation issue!!! */
    public final Object a(d.h.a.b<? super ab, d.x> r10, d.c.d<? super d.x> r11) {
        d.h.a.b r12 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r13, a.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.f10120d;
        Object r1 = d.c.a.b.a();
        int r2 = r0.f;
        if (r2 == 0) goto L15;
        if (r2 != 1) goto L14;
        kotlinx.coroutines.a.f<d.x> r9 = (kotlinx.coroutines.a.f) ZeusTransformUtils.preCheckCast(r0.f10119c, kotlinx.coroutines.a.f.class, "com.obric.aiagent.plugin");
        d.h.a.b r15 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r0.f10118b, d.h.a.b.class, "com.obric.aiagent.plugin");
        ac r3 = (ac) ZeusTransformUtils.preCheckCast(r0.f10117a, ac.class, "com.obric.aiagent.plugin");
        d.o.a(r14);
        a r8 = r0;
        d.h.a.b r4 = r15;
        ac r16 = r3;
    L12:
        Object r5 = r1;
        a r6 = r8;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L39;
        r9.a();
    L23:
        Object r17 = r16.f10113b;
        monitor-enter(r17);
        ab r7 = (ab) ZeusTransformUtils.preCheckCast(r16.f10114c.pollFirst(), ab.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        if (r7 != null) goto L28;
        r7 = null;
    L31:
        monitor-exit(r17);
        if (r7 == null) goto L33;
        r4.invoke(r7);
        goto L23
    L33:
        d.h.a.b r18 = r4;
        r0 = r6;
        r1 = r5;
    L16:
        r0.f10117a = r16;
        r0.f10118b = r18;
        r0.f10119c = r9;
        r0.f = 1;
        Object r19 = r9.a(r0);
        if (r19 != r1) goto L19;
        return r1;
    L19:
        r8 = r0;
        r4 = r18;
        r14 = r19;
        goto L12
    L28:
        d.h.b.o.a(r7);     // Catch: Throwable -> L35
        if (ZeusTransformUtils.instanceOf(r7, ab.a.class) == false) goto L31;
        r16.f10116e -= ((ab.a) ZeusTransformUtils.preCheckCast(r7, ab.a.class, "com.obric.aiagent.plugin")).a().length;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    L39:
        return d.x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        d.o.a(r14);
        r16 = this;
        r9 = this.f10115d.g();
        r18 = r12;
    L7:
        r0 = new a(this, r13);
        goto L8
    }

    public final void b() {
        Object r0 = this.f10113b;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.g == false) goto L9;
        monitor-exit(r0);
        return;
    L9:
        this.g = true;     // Catch: Throwable -> L13
        this.f10114c.clear();     // Catch: Throwable -> L13
        this.f10116e = 0;     // Catch: Throwable -> L13
        d.x r2 = d.x.f38692a;     // Catch: Throwable -> L13
        monitor-exit(r0);
        kotlinx.coroutines.a.t.a.a((kotlinx.coroutines.a.t) ZeusTransformUtils.preCheckCast(this.f10115d, kotlinx.coroutines.a.t.class, "com.obric.aiagent.plugin"), null, 1, null);
    }
}
