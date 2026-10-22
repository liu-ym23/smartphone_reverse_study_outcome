package com.obric.autogui.common.api.assistant;

import android.content.Context;
import android.os.CancellationSignal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.i;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: AssistantPrivacyApprovalHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "AssistantPrivacyApprovalHelper.kt", c = {148}, d = "invokeSuspend", e = "com.obric.autogui.common.api.assistant.AssistantPrivacyApprovalHelper$checkApprovalAsync$result$1")
final class AssistantPrivacyApprovalHelper$checkApprovalAsync$result$1 extends l implements m<am, d<? super AssistantPrivacyApprovalStatus>, Object> {
    final /* synthetic */ CancellationSignal $cancellationSignal;
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ AssistantPrivacyApprovalHelper this$0;

    /* JADX INFO: renamed from: com.obric.autogui.common.api.assistant.AssistantPrivacyApprovalHelper$checkApprovalAsync$result$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: AssistantPrivacyApprovalHelper.kt */
    @f(b = "AssistantPrivacyApprovalHelper.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.common.api.assistant.AssistantPrivacyApprovalHelper$checkApprovalAsync$result$1$1")
    static final class AnonymousClass1 extends l implements m<am, d<? super x>, Object> {
        final /* synthetic */ CancellationSignal $cancellationSignal;
        final /* synthetic */ Context $context;
        final /* synthetic */ w<AssistantPrivacyApprovalStatus> $deferred;
        int label;
        final /* synthetic */ AssistantPrivacyApprovalHelper this$0;

        AnonymousClass1(AssistantPrivacyApprovalHelper r3, Context r4, CancellationSignal r5, w<AssistantPrivacyApprovalStatus> r6, d<? super AnonymousClass1> r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            w<AssistantPrivacyApprovalStatus> r9 = (w) ZeusTransformUtils.wrapperContextForParams(r6, w.class, "com.obric.aiagent.plugin");
            d r10 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$context = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
            this.$cancellationSignal = r5;
            this.$deferred = r9;
            super(2, r10);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r8, d<?> r9) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$context, this.$cancellationSignal, this.$deferred, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            b.a();
            if (this.label != 0) goto L7;
            o.a(r3);
            AssistantPrivacyApprovalStatus r4 = AssistantPrivacyApprovalHelper.access$checkApprovalSync(this.this$0, this.$context, this.$cancellationSignal);
            this.$deferred.a(r4);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    AssistantPrivacyApprovalHelper$checkApprovalAsync$result$1(AssistantPrivacyApprovalHelper r3, Context r4, CancellationSignal r5, d<? super AssistantPrivacyApprovalHelper$checkApprovalAsync$result$1> r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        this.$context = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
        this.$cancellationSignal = r5;
        super(2, r8);
    }

    @Override // d.c.b.a.a
    public final d<x> create(Object r4, d<?> r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return (d) ZeusTransformUtils.preCheckCast(new AssistantPrivacyApprovalHelper$checkApprovalAsync$result$1(this.this$0, this.$context, this.$cancellationSignal, r6), d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(am r3, d<? super AssistantPrivacyApprovalStatus> r4) {
        return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(am r3, d<? super AssistantPrivacyApprovalStatus> r4) {
        return ((AssistantPrivacyApprovalHelper$checkApprovalAsync$result$1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AssistantPrivacyApprovalHelper$checkApprovalAsync$result$1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r14) {
        Object r0 = b.a();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        o.a(r14);
    L11:
        return r14;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        o.a(r14);
        w r15 = y.a(null, 1, null);
        i.a(AssistantPrivacyApprovalHelper.access$getMScope$p(this.this$0), null, null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$context, this.$cancellationSignal, r15, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        d r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
        this.label = 1;
        r14 = r15.a(r2);
        if (r14 != r0) goto L11;
        return r0;
    }
}
