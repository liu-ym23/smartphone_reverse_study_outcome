package com.obric.autogui.util.c;

import com.obric.autogui.common.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: StateMachine.kt */
/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f31504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f31505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.autogui.util.c.b f31506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.obric.autogui.util.c.b f31507d;

    /* JADX INFO: compiled from: StateMachine.kt */
    @f(b = "StateMachine.kt", c = {45, 48}, d = "changeStateTo$suspendImpl", e = "com.obric.autogui.util.statemachine.StateMachine")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31509b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f31510c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f31511d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f31512e;

        a(c r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31511d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31510c = r3;
            this.f31512e |= Integer.MIN_VALUE;
            return c.a(this.f31511d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StateMachine.kt */
    public static final class b {
        b() {
        }
    }

    public Object a(com.obric.autogui.util.c.b r3, d.c.d<? super e> r4) {
        return a(this, (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public c(com.obric.autogui.util.c.b r3) {
        com.obric.autogui.util.c.b r4 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "initState");
        this.f31504a = new b();
        this.f31506c = r4;
        this.f31507d = r4;
    }

    private final void a(boolean r2) {
        if (this.f31505b == r2) goto L6;
        this.f31505b = r2;
        return;
    }

    private final void a(com.obric.autogui.util.c.b r3) {
        com.obric.autogui.util.c.b r4 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f31506c, r4) == true) goto L6;
        this.f31506c = r4;
        return;
    }

    public com.obric.autogui.util.c.b a() {
        return this.f31506c;
    }

    static /* synthetic */ Object a(c r6, com.obric.autogui.util.c.b r7, d.c.d<? super e> r8) {
        com.obric.autogui.util.c.b r9 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, a.class) == false) goto L7;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.aiagent.plugin");
        if ((r1.f31512e & Integer.MIN_VALUE) == 0) goto L7;
        r1.f31512e -= Integer.MIN_VALUE;
    L8:
        Object r11 = r1.f31510c;
        Object r2 = d.c.a.b.a();
        int r3 = r1.f31512e;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        e r12 = (e) ZeusTransformUtils.preCheckCast(r1.f31509b, e.class, "com.obric.aiagent.plugin");
        c r13 = (c) ZeusTransformUtils.preCheckCast(r1.f31508a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L33:
        e r14 = r12;
        r6 = r13;
    L34:
        r6.b(r14.g());
        return r14;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = (com.obric.autogui.util.c.b) ZeusTransformUtils.preCheckCast(r1.f31509b, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        r6 = (c) ZeusTransformUtils.preCheckCast(r1.f31508a, c.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L27:
        r14 = (e) ZeusTransformUtils.preCheckCast(r11, e.class, "com.obric.aiagent.plugin");
        if (r14.g() == false) goto L34;
        r6.f31506c.a(r9);
        com.obric.autogui.util.c.b r0 = r6.f31506c;
        r1.f31508a = r6;
        r1.f31509b = r14;
        r1.f31512e = 2;
        if (r9.a(r0, r1) != r2) goto L32;
        return r2;
    L32:
        r13 = r6;
        r12 = r14;
        goto L33
    L16:
        d.o.a(r11);
        if (r6.f31505b == true) goto L19;
        b r15 = r6.f31504a;
        monitor-enter(r15);
        r6.a(true);     // Catch: Throwable -> L36
        r6.f31507d = r9;     // Catch: Throwable -> L36
        x r4 = x.f38692a;     // Catch: Throwable -> L36
        monitor-exit(r15);
        com.obric.autogui.util.c.b r16 = r6.f31506c;
        r1.f31508a = r6;
        r1.f31509b = r9;
        r1.f31512e = 1;
        r11 = r16.b(r9, r1);
        if (r11 != r2) goto L27;
        return r2;
    L36:
        th = move-exception;
        throw th;
    L19:
        return e.f29014b.b("busy");
    L7:
        r1 = new a(r6, r10);
        goto L8
    }

    private final void b(boolean r3) {
        b r0 = this.f31504a;
        monitor-enter(r0);
        a(false);     // Catch: Throwable -> L14
        if (r3 == false) goto L11;
        com.obric.autogui.util.c.b r4 = this.f31506c;     // Catch: Throwable -> L14
        a(this.f31507d);     // Catch: Throwable -> L14
        if (o.a(r4, this.f31506c) == false) goto L10;
        this.f31506c.c();     // Catch: Throwable -> L14
        goto L11
    L10:
        this.f31506c.b(r4);     // Catch: Throwable -> L14
    L11:
        x r2 = x.f38692a;     // Catch: Throwable -> L14
        monitor-exit(r0);
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
