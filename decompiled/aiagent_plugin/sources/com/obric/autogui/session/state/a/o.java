package com.obric.autogui.session.state.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: VirtualDisplayRecordSetStartupGate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.b<d.c.d<? super f>, Object> f31352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.b<d.c.d<? super f>, Object> f31353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.m<Integer, d.c.d<? super Boolean>, Object> f31354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.a<Boolean> f31355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.a<x> f31356e;

    /* JADX INFO: compiled from: VirtualDisplayRecordSetStartupGate.kt */
    @d.c.b.a.f(b = "VirtualDisplayRecordSetStartupGate.kt", c = {59, 59, 93}, d = "initialize", e = "com.obric.autogui.session.state.impl.VirtualDisplayRecordSetStartupGate")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f31359c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f31360d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ o f31361e;
        int f;

        a(o r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31361e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31360d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f31361e.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public o(d.h.a.b<? super d.c.d<? super f>, ? extends Object> r3, d.h.a.b<? super d.c.d<? super f>, ? extends Object> r4, d.h.a.m<? super Integer, ? super d.c.d<? super Boolean>, ? extends Object> r5, d.h.a.a<Boolean> r6, d.h.a.a<x> r7) {
        d.h.a.b<d.c.d<? super f>, Object> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<d.c.d<? super f>, Object> r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.m<Integer, d.c.d<? super Boolean>, Object> r10 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.h.a.a<Boolean> r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r12 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "createDisplaySynchronously");
        d.h.b.o.e(r10, "beginRecordSet");
        d.h.b.o.e(r11, "isTerminationActive");
        d.h.b.o.e(r12, "endRecordSet");
        this.f31352a = r8;
        this.f31353b = r9;
        this.f31354c = r10;
        this.f31355d = r11;
        this.f31356e = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Class, java.lang.Class<com.obric.autogui.session.state.a.o>] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.autogui.session.state.a.o] */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.obric.autogui.session.state.a.o] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.autogui.session.state.a.o] */
    /* JADX WARN: Type inference failed for: r0v23, types: [com.obric.autogui.session.state.a.o] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25, types: [com.obric.autogui.session.state.a.o] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.obric.autogui.session.state.a.o, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.obric.autogui.session.state.a.o, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v16, types: [com.obric.autogui.session.state.a.o] */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20, types: [com.obric.autogui.session.state.a.o, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v50 */
    /* JADX WARN: Type inference failed for: r10v58 */
    /* JADX WARN: Type inference failed for: r10v59 */
    /* JADX WARN: Type inference failed for: r10v60 */
    /* JADX WARN: Type inference failed for: r10v61 */
    /* JADX WARN: Type inference failed for: r10v62 */
    /* JADX WARN: Type inference failed for: r10v63 */
    /* JADX WARN: Type inference failed for: r10v64 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v11, types: [com.obric.autogui.session.state.a.n] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v46 */
    /* JADX WARN: Type inference failed for: r11v49, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v53 */
    /* JADX WARN: Type inference failed for: r11v54 */
    /* JADX WARN: Type inference failed for: r11v55 */
    /* JADX WARN: Type inference failed for: r11v56 */
    /* JADX WARN: Type inference failed for: r11v57 */
    /* JADX WARN: Type inference failed for: r11v58 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    public final Object a(d.c.d<? super p> r11) {
        ?? r0 = o.class;
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, a.class) == false) goto L7;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r12, a.class, "com.obric.aiagent.plugin");
        if ((r1.f & Integer.MIN_VALUE) == 0) goto L7;
        r1.f -= Integer.MIN_VALUE;
    L8:
        Object r13 = r1.f31360d;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f;
        String r8 = "";
        if (r4 != 0) goto L122;
        d.o.a(r13);
        if (this.f31352a == null) goto L39;
        ?? r14 = n.f31347a;
    L120:
        d.h.a.b<d.c.d<? super f>, Object> r2 = this.f31352a;     // Catch: Error -> L32 CancellationException -> L34 Exception -> L107
        ?? r10 = this;
        ?? r15 = r14;
        if (r2 == null) goto L47;
        r1.f31357a = this;     // Catch: Error -> L32 CancellationException -> L34 Exception -> L107
        r1.f31358b = r14;     // Catch: Error -> L32 CancellationException -> L34 Exception -> L107
        r1.f = 1;     // Catch: Error -> L32 CancellationException -> L34 Exception -> L107
        Object r5 = r2.invoke(r1);     // Catch: Error -> L32 CancellationException -> L34 Exception -> L107
        ?? r16 = this;
        ?? r17 = r14;
        if (r5 != r3) goto L45;
        return r3;
    L45:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");     // Catch: Error -> L32 CancellationException -> L34 Exception -> L107
        ?? r18 = r16;
        r10 = r16;
        r15 = r17;
        if (r6 == null) goto L47;
    L51:
        f r9 = r6;
        r0 = r18;
        if (r9.a().g() == false) goto L54;
        Integer r19 = r9.b();
        if (r19 == null) goto L106;
        int r110 = r19.intValue();
        if (((Boolean) ZeusTransformUtils.preCheckCast(r0.f31355d.invoke(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L60;
        d.h.a.m<Integer, d.c.d<? super Boolean>, Object> r7 = r0.f31354c;     // Catch: Error -> L18 CancellationException -> L20 Exception -> L93
        Integer r20 = d.c.b.a.b.a(r110);     // Catch: Error -> L18 CancellationException -> L20 Exception -> L93
        r1.f31357a = r0;     // Catch: Error -> L18 CancellationException -> L20 Exception -> L93
        r1.f31358b = r9;     // Catch: Error -> L18 CancellationException -> L20 Exception -> L93
        r1.f31359c = r110;     // Catch: Error -> L18 CancellationException -> L20 Exception -> L93
        r1.f = 3;     // Catch: Error -> L18 CancellationException -> L20 Exception -> L93
        Object r21 = r7.invoke(r20, r1);     // Catch: Error -> L18 CancellationException -> L20 Exception -> L93
        if (r21 != r3) goto L64;
        return r3;
    L64:
        f r22 = r9;
        int r111 = r110;
        r13 = r21;
        r0 = r0;
    L65:
    L16:
        Exception e2 = e;
    L95:
        r0.f31356e.invoke();
        com.obric.autogui.common.e.a r112 = com.obric.autogui.common.e.f29014b;
        StringBuilder r23 = new StringBuilder().append("virtual display record set begin failed: ");
        String r113 = e2.getMessage();
        if (r113 == null) goto L100;
        r8 = r113;
    L100:
        return r0.a(r112.b(r23.append(r8).toString()), r22.c(), q.f31368b);
    L67:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L75;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r0.f31355d.invoke(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L73;
        return r0.a(r22.c(), "during record set begin");
    L73:
        return r0.a(com.obric.autogui.common.e.f29014b.b("virtual display record set init failed"), r22.c(), q.f31368b);
    L75:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r0.f31355d.invoke(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L124;
        r0.f31356e.invoke();
        return r0.a(r22.c(), "during record set begin");
    L124:
        r22.d().invoke();     // Catch: Exception -> L80 Error -> L87 CancellationException -> L90
        return new p.b(r111, r22.c());
    L87:
        e = move-exception;
        r0.f31356e.invoke();
        throw e;
    L90:
        e = move-exception;
        r0.f31356e.invoke();
        throw e;
    L80:
        e = move-exception;
        r0.f31356e.invoke();
        com.obric.autogui.common.e.a r114 = com.obric.autogui.common.e.f29014b;
        StringBuilder r24 = new StringBuilder().append("virtual display activation failed: ");
        String r115 = e.getMessage();
        if (r115 == null) goto L86;
        r8 = r115;
    L86:
        return r0.a(r114.b(r24.append(r8).toString()), r22.c(), q.f31369c);
    L93:
        e = move-exception;
        r22 = r9;
        e2 = e;
        goto L95
    L60:
        return r0.a(r9.c(), "before record set begin");
    L106:
        return new p.a(com.obric.autogui.common.e.f29014b.b("active space is not the prepared virtual display"), r9.c(), q.f31367a);
    L54:
        return new p.a(r9.a(), r9.c(), q.f31367a);
    L47:
        d.h.a.b<d.c.d<? super f>, Object> r25 = r10.f31353b;     // Catch: Error -> L32 CancellationException -> L34 Exception -> L107
        r1.f31357a = r10;     // Catch: Error -> L32 CancellationException -> L34 Exception -> L107
        r1.f31358b = r15;     // Catch: Error -> L32 CancellationException -> L34 Exception -> L107
        r1.f = 2;     // Catch: Error -> L32 CancellationException -> L34 Exception -> L107
        Object r26 = r25.invoke(r1);     // Catch: Error -> L32 CancellationException -> L34 Exception -> L107
        o this = r10;
        r14 = r15;
        if (r26 != r3) goto L50;
        return r3;
    L50:
        r6 = (f) ZeusTransformUtils.preCheckCast(r26, f.class, "com.obric.aiagent.plugin");     // Catch: Error -> L32 CancellationException -> L34 Exception -> L107
        r18 = this;
    L107:
        Exception e3 = e;
    L108:
        com.obric.autogui.common.e.a r27 = com.obric.autogui.common.e.f29014b;
        StringBuilder r28 = new StringBuilder().append("virtual display preparation failed: ");
        String r29 = e3.getMessage();
        if (r29 == null) goto L113;
        r8 = r29;
    L113:
        return this.a(r27.b(r28.append(r8).toString()), r14, q.f31367a);
    L39:
        r14 = n.f31348b;
        goto L120
    L122:
        if (r4 == 1) goto L27;
        if (r4 == 2) goto L24;
        if (r4 != 3) goto L23;
        r111 = r1.f31359c;
        r22 = (f) ZeusTransformUtils.preCheckCast(r1.f31358b, f.class, "com.obric.aiagent.plugin");
        r0 = (o) ZeusTransformUtils.preCheckCast(r1.f31357a, r0, "com.obric.aiagent.plugin");
        d.o.a(r13);     // Catch: Exception -> L16 Error -> L18 CancellationException -> L20
        r0 = r0;
        goto L65
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L24:
        n r116 = (n) ZeusTransformUtils.preCheckCast(r1.f31358b, n.class, "com.obric.aiagent.plugin");
        o r30 = (o) ZeusTransformUtils.preCheckCast(r1.f31357a, r0, "com.obric.aiagent.plugin");
        d.o.a(r13);     // Catch: Exception -> L30 Error -> L32 CancellationException -> L34
        r14 = r116;
        this = r30;
        r26 = r13;
        goto L50
    L27:
        n r117 = (n) ZeusTransformUtils.preCheckCast(r1.f31358b, n.class, "com.obric.aiagent.plugin");
        o r31 = (o) ZeusTransformUtils.preCheckCast(r1.f31357a, r0, "com.obric.aiagent.plugin");
        d.o.a(r13);     // Catch: Exception -> L30 Error -> L32 CancellationException -> L34
        r17 = r117;
        r16 = r31;
        r5 = r13;
    L30:
        e = move-exception;
        r14 = this;
        this = r0;
        e3 = e;
    L18:
        e = move-exception;
        r0.f31356e.invoke();
        throw e;
    L20:
        e = move-exception;
        r0.f31356e.invoke();
        throw e;
    L32:
        e = move-exception;
        throw e;
    L34:
        e = move-exception;
        throw e;
    L7:
        r1 = new a(this, r12);
        goto L8
    }

    private final p.a a(com.obric.autogui.common.e r1, n r2, q r3) {
        return new p.a(r1, r2, r3);
    }

    private final p.a a(n r4, String r5) {
        return new p.a(com.obric.autogui.common.e.f29014b.b("session termination requested " + r5), r4, q.f31370d);
    }
}
