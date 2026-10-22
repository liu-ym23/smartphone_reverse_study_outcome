package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler;

import com.obric.memorydata.sdk.MemoryResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o;
import d.x;
import kotlinx.coroutines.ax;

/* JADX INFO: compiled from: PersistentAwarenessRegisterHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: compiled from: PersistentAwarenessRegisterHelper.kt */
    @d.c.b.a.f(b = "PersistentAwarenessRegisterHelper.kt", c = {22, 30}, d = "registerPersistentAwarenessWithRetry", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.PersistentAwarenessRegisterHelperKt")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17249b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f17250c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f17251d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f17252e;
        long f;
        int g;
        int h;
        boolean i;
        /* synthetic */ Object j;
        int k;

        a(d.c.d<? super a> r3) {
            super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.j = r7;
            this.k |= Integer.MIN_VALUE;
            return f.a(null, null, 0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: PersistentAwarenessRegisterHelper.kt */
    @d.c.b.a.f(b = "PersistentAwarenessRegisterHelper.kt", c = {53}, d = "unregisterPersistentAwarenessSubscription", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.PersistentAwarenessRegisterHelperKt")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f17255c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f17256d;

        b(d.c.d<? super b> r3) {
            super((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f17255c = r2;
            this.f17256d |= Integer.MIN_VALUE;
            return f.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x017a -> B:17:0x00db). Please report as a decompilation issue!!! */
    public static final Object a(String r20, String r21, long r22, d.h.a.b<? super d.c.d<? super MemoryResponse<Void>>, ? extends Object> r24, d.c.d<? super c> r25) {
        d.h.a.b r0 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r24, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r25, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, a.class) == false) goto L7;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin");
        if ((r3.k & Integer.MIN_VALUE) == 0) goto L7;
        r3.k -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.j;
        Object r5 = d.c.a.b.a();
        int r6 = r3.k;
        String r8 = null;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        boolean r1 = r3.i;
        int r7 = r3.h;
        int r10 = r3.g;
        long r11 = r3.f;
        MemoryResponse r13 = (MemoryResponse) ZeusTransformUtils.preCheckCast(r3.f17252e, MemoryResponse.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r3.f17251d, String.class, "com.obric.aiagent.plugin");
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r3.f17250c, d.h.a.b.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r3.f17249b, String.class, "com.obric.aiagent.plugin");
        String r15 = (String) ZeusTransformUtils.preCheckCast(r3.f17248a, String.class, "com.obric.aiagent.plugin");
        o.a(r4);
        String r16 = r12;
        int r17 = r10;
        String r18 = r14;
        boolean r19 = r1;
        int r110 = r7;
        d.h.a.b r23 = r9;
        String r26 = r15;
        a r27 = r3;
        Object r28 = r5;
        long r29 = r11;
    L17:
        int r111 = r17 - 1;
        if (r17 <= 0) goto L33;
        int r112 = r110 + 1;
        r27.f17248a = r26;
        r27.f17249b = r16;
        r27.f17250c = r23;
        r27.f17251d = null;
        r27.f17252e = null;
        r27.f = r29;
        r27.g = r111;
        r27.h = r112;
        r27.k = 1;
        Object r30 = r23.invoke(r27);
        if (r30 != r28) goto L22;
        return r28;
    L22:
        String r113 = r16;
        r4 = r30;
        String r114 = r26;
        Object r115 = r28;
        d.h.a.b r31 = r23;
        int r32 = r112;
        long r116 = r29;
        r3 = r27;
        long r33 = r116;
        r5 = r115;
    L23:
        r13 = (MemoryResponse) ZeusTransformUtils.preCheckCast(r4, MemoryResponse.class, "com.obric.aiagent.plugin");
        String r34 = r113 + " code=" + r13.getCode() + " msg=" + r13.getMessage();
        boolean r35 = r13.isSuccess();
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(r114, r34);
        if (r13.getCode() != 404) goto L26;
    L29:
        r3.f17248a = r114;
        r3.f17249b = r113;
        r3.f17250c = r31;
        r3.f17251d = r34;
        r3.f17252e = r13;
        r3.f = r33;
        r3.g = r111;
        r3.h = r32;
        r3.i = r35;
        r3.k = 2;
        if (ax.a(r33, r3) != r5) goto L32;
        return r5;
    L32:
        r19 = r35;
        r16 = r113;
        r18 = r34;
        r26 = r114;
        r110 = r32;
        r23 = r31;
        r28 = r5;
        r27 = r3;
        r29 = r33;
        r17 = r111;
        goto L17
    L26:
        if (r13.getCode() == 406) goto L29;
        r19 = r35;
        r16 = r113;
        r18 = r34;
        r26 = r114;
        r110 = r32;
    L33:
        if (r19 == true) goto L35;
        com.obric.event.task.base.report.e.f32759a.a(r26, r18);
    L35:
        if (r13 != null) goto L37;
    L39:
        boolean r36 = false;
    L40:
        if (r36 == true) goto L51;
        c.a r37 = c.f17052a;
        StringBuilder r38 = new StringBuilder().append(r16).append(" failed: code=");
        if (r13 == null) goto L45;
        Integer r39 = d.c.b.a.b.a(r13.getCode());
    L46:
        StringBuilder r40 = r38.append(r39).append(", msg=");
        if (r13 == null) goto L50;
        r8 = r13.getMessage();
    L50:
        return r37.a(r40.append(r8).toString(), r110 - 1);
    L45:
        r39 = null;
        goto L46
    L51:
        return c.f17052a.a(r110 - 1);
    L37:
        if (r13.getCode() != 0) goto L39;
        r36 = true;
        goto L40
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r41 = r3.h;
        int r42 = r3.g;
        r33 = r3.f;
        r31 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r3.f17250c, d.h.a.b.class, "com.obric.aiagent.plugin");
        r113 = (String) ZeusTransformUtils.preCheckCast(r3.f17249b, String.class, "com.obric.aiagent.plugin");
        r114 = (String) ZeusTransformUtils.preCheckCast(r3.f17248a, String.class, "com.obric.aiagent.plugin");
        o.a(r4);
        r111 = r42;
        r32 = r41;
        goto L23
    L16:
        o.a(r4);
        r17 = 3;
        r27 = r3;
        r28 = r5;
        r18 = "";
        r13 = null;
        r110 = 0;
        r19 = false;
        r16 = r21;
        r29 = r22;
        r23 = r0;
        r26 = r20;
    L7:
        r3 = new a(r2);
        goto L8
    }

    public static /* synthetic */ Object a(String r7, String r8, long r9, d.h.a.b r11, d.c.d r12, int r13, Object r14) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r13 & 4) == 0) goto L6;
        r9 = 5000;
    L6:
        return a(r7, r8, r9, r5, r6);
    }

    public static final Object a(String r5, String r6, d.c.d<? super x> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.aiagent.plugin");
        if ((r0.f17256d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f17256d -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f17255c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f17256d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (String) ZeusTransformUtils.preCheckCast(r0.f17254b, String.class, "com.obric.aiagent.plugin");
        r5 = (String) ZeusTransformUtils.preCheckCast(r0.f17253a, String.class, "com.obric.aiagent.plugin");
        o.a(r9);
    L17:
        MemoryResponse r10 = (MemoryResponse) ZeusTransformUtils.preCheckCast(r9, MemoryResponse.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(r5, "unregisterPersistentSubscription subscriptionId=" + r6 + " code=" + r10.getCode() + " msg=" + r10.getMessage());
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r9);
        d r11 = d.f17179a;
        r0.f17253a = r5;
        r0.f17254b = r6;
        r0.f17256d = 1;
        r9 = r11.c(r6, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new b(r8);
        goto L8
    }
}
