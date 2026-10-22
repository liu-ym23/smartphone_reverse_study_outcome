package com.obric.autogui.platforms.tools.computercontrol;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.w;

/* JADX INFO: compiled from: ComputerControlViewHierarchyDumpAsync.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "ComputerControlViewHierarchyDumpAsync.kt", c = {83}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.computercontrol.ComputerControlViewHierarchyDumpAsync$AssistDataRequestSession$request$requestResult$1")
final class ComputerControlViewHierarchyDumpAsync$AssistDataRequestSession$request$requestResult$1 extends l implements m<am, d<? super Object>, Object> {
    int label;
    final /* synthetic */ ComputerControlViewHierarchyDumpAsync.AssistDataRequestSession this$0;

    ComputerControlViewHierarchyDumpAsync$AssistDataRequestSession$request$requestResult$1(ComputerControlViewHierarchyDumpAsync.AssistDataRequestSession r3, d<? super ComputerControlViewHierarchyDumpAsync$AssistDataRequestSession$request$requestResult$1> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // d.c.b.a.a
    public final d<x> create(Object r2, d<?> r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return (d) ZeusTransformUtils.preCheckCast(new ComputerControlViewHierarchyDumpAsync$AssistDataRequestSession$request$requestResult$1(this.this$0, r4), d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(am r3, d<? super Object> r4) {
        return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(am r3, d<Object> r4) {
        return ((ComputerControlViewHierarchyDumpAsync$AssistDataRequestSession$request$requestResult$1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), ComputerControlViewHierarchyDumpAsync$AssistDataRequestSession$request$requestResult$1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r5) {
        Object r0 = b.a();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        o.a(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        o.a(r5);
        w r6 = ComputerControlViewHierarchyDumpAsync.AssistDataRequestSession.access$getResult$p(this.this$0);
        d r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
        this.label = 1;
        r5 = r6.a(r2);
        if (r5 != r0) goto L11;
        return r0;
    }
}
