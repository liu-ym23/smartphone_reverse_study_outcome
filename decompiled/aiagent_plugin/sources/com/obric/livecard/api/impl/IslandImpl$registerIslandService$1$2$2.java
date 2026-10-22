package com.obric.livecard.api.impl;

import com.obric.livecard.api.IslandCardCallback;
import com.obric.livecard.api.entity.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.o;
import d.x;
import java.util.Iterator;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.f.a;

/* JADX INFO: compiled from: IslandImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(b = "IslandImpl.kt", c = {391}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.IslandImpl$registerIslandService$1$2$2")
final class IslandImpl$registerIslandService$1$2$2 extends l implements m<am, d<? super x>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ IslandImpl this$0;

    IslandImpl$registerIslandService$1$2$2(IslandImpl r3, d<? super IslandImpl$registerIslandService$1$2$2> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // d.c.b.a.a
    public final d<x> create(Object r2, d<?> r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return (d) ZeusTransformUtils.preCheckCast(new IslandImpl$registerIslandService$1$2$2(this.this$0, r4), d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
        return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(am r3, d<? super x> r4) {
        return ((IslandImpl$registerIslandService$1$2$2) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), IslandImpl$registerIslandService$1$2$2.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r8) {
        Object r0 = b.a();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        IslandImpl r2 = (IslandImpl) ZeusTransformUtils.preCheckCast(this.L$1, IslandImpl.class, "com.obric.aiagent.plugin");
        a r7 = (a) ZeusTransformUtils.preCheckCast(this.L$0, a.class, "com.obric.aiagent.plugin");
        o.a(r8);
    L24:
        Iterator r9 = ((Map) ZeusTransformUtils.preCheckCast(r2.getMSessionMap(), Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();     // Catch: Throwable -> L21
    L14:
        if (r9.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        IslandCardCallback r5 = ((IslandSession) ZeusTransformUtils.preCheckCast(r3.getKey(), IslandSession.class, "com.obric.aiagent.plugin")).getCallback();     // Catch: Throwable -> L21
        if (r5 == null) goto L14;
        r5.onSessionDestroy((IslandSession) ZeusTransformUtils.preCheckCast(r3.getKey(), IslandSession.class, "com.obric.aiagent.plugin"), d.c.b.a.b.a(1));     // Catch: Throwable -> L21
        goto L14
    L18:
        r2.getMSessionMap().clear();     // Catch: Throwable -> L21
        x r10 = x.f38692a;     // Catch: Throwable -> L21
        r7.b(null);
        return x.f38692a;
    L21:
        th = move-exception;
        r7.b(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        o.a(r8);
        a r11 = IslandImpl.access$getSessionLock$p(this.this$0);
        IslandImpl r4 = this.this$0;
        d<? super x> r6 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
        this.L$0 = r11;
        this.L$1 = r4;
        this.label = 1;
        if (r11.a(null, r6) != r0) goto L11;
        return r0;
    L11:
        r7 = r11;
        r2 = r4;
        goto L24
    }
}
