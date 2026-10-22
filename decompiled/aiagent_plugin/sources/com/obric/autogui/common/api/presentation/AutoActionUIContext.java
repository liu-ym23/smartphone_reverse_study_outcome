package com.obric.autogui.common.api.presentation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.o;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.bs;

/* JADX INFO: compiled from: IAutoActionGlobalUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionUIContext {
    public static final AutoActionUIContext INSTANCE = null;
    private static final x<GlobalUIContext> state = null;

    /* JADX INFO: renamed from: com.obric.autogui.common.api.presentation.AutoActionUIContext$1, reason: invalid class name */
    /* JADX INFO: compiled from: IAutoActionGlobalUIState.kt */
    @f(b = "IAutoActionGlobalUIState.kt", c = {17}, d = "invokeSuspend", e = "com.obric.autogui.common.api.presentation.AutoActionUIContext$1")
    static final class AnonymousClass1 extends l implements m<am, d<? super d.x>, Object> {
        int label;

        AnonymousClass1(d<? super AnonymousClass1> r3) {
            super(2, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final d<d.x> create(Object r1, d<?> r2) {
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass1((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super d.x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super d.x> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            x<GlobalUIContext> r7 = AutoActionUIContext.INSTANCE.getState();
            i<? super GlobalUIContext> r2 = (i) ZeusTransformUtils.preCheckCast(C07271.INSTANCE, i.class, "com.obric.aiagent.plugin");
            d<?> r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    private AutoActionUIContext() {
    }

    static {
        INSTANCE = new AutoActionUIContext();
        state = kotlinx.coroutines.b.am.a(new GlobalUIContext(null, null, null, null, 15, null));
        kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final x<GlobalUIContext> getState() {
        return state;
    }
}
