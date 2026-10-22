package com.obric.livecard.api.impl;

import android.os.DeadObjectException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.o;
import d.x;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.f.a;

/* JADX INFO: compiled from: Collect.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IslandImpl$1$invokeSuspend$$inlined$collect$1 implements i<IslandTask> {
    final /* synthetic */ IslandImpl this$0;

    /* JADX INFO: renamed from: com.obric.livecard.api.impl.IslandImpl$1$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Collect.kt */
    @f(b = "IslandImpl.kt", c = {139, 143}, d = "emit", e = "com.obric.livecard.api.impl.IslandImpl$1$invokeSuspend$$inlined$collect$1")
    public static final class AnonymousClass1 extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ IslandImpl$1$invokeSuspend$$inlined$collect$1 this$0;

        public AnonymousClass1(IslandImpl$1$invokeSuspend$$inlined$collect$1 r3, d.c.d r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.emit(null, this);
        }
    }

    public IslandImpl$1$invokeSuspend$$inlined$collect$1(IslandImpl r1) {
        this.this$0 = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.obric.livecard.api.impl.IslandImpl$1$invokeSuspend$$inlined$collect$1] */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlinx.coroutines.f.a] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [kotlinx.coroutines.f.a] */
    /* JADX WARN: Type inference failed for: r7v8 */
    @Override // kotlinx.coroutines.b.i
    public Object emit(IslandTask r8, d.c.d r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r10, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = b.a();
        int r3 = r0.label;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L21;
        if (r3 != 2) goto L20;
        a r7 = (a) ZeusTransformUtils.preCheckCast(r0.L$0, a.class, "com.obric.aiagent.plugin");
        o.a(r11);     // Catch: Throwable -> L15 DeadObjectException -> L17
        IslandImpl$1$invokeSuspend$$inlined$collect$1 this = r7;
    L34:
    L29:
        x r12 = x.f38692a;     // Catch: Throwable -> L15
        this.b(null);
        return x.f38692a;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        a r13 = (a) ZeusTransformUtils.preCheckCast(r0.L$1, a.class, "com.obric.aiagent.plugin");
        IslandTask r14 = (IslandTask) ZeusTransformUtils.preCheckCast(r0.L$0, IslandTask.class, "com.obric.aiagent.plugin");
        o.a(r11);
        a r15 = r13;
    L25:
        d.h.a.b<d.c.d<? super x>, Object> r16 = r14.getBlock();     // Catch: Throwable -> L15 DeadObjectException -> L17
        r0.L$0 = r15;     // Catch: Throwable -> L15 DeadObjectException -> L17
        r0.L$1 = null;     // Catch: Throwable -> L15 DeadObjectException -> L17
        r0.label = 2;     // Catch: Throwable -> L15 DeadObjectException -> L17
        this = r15;
        if (r16.invoke(r0) != r2) goto L34;
        return r2;
    L22:
        o.a(r11);
        d.c.d r17 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        r14 = (IslandTask) ZeusTransformUtils.preCheckCast(r8, IslandTask.class, "com.obric.aiagent.plugin");
        a r18 = IslandImpl.access$getSessionLock$p(this.this$0);
        r0.L$0 = r14;
        r0.L$1 = r18;
        r0.label = 1;
        Object r19 = r18.a(null, r0);
        r15 = r18;
        if (r19 != r2) goto L25;
        return r2;
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        this.b(null);
        throw th;
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }
}
