package com.obric.autogui.common.api.threading;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: AOThreadingTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AOThreadingToolsKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.obric.autogui.common.api.threading.AOThreadingToolsKt$awaitOrNull$2, reason: invalid class name */
    /* JADX INFO: compiled from: AOThreadingTools.kt */
    @f(b = "AOThreadingTools.kt", c = {255}, d = "invokeSuspend", e = "com.obric.autogui.common.api.threading.AOThreadingToolsKt$awaitOrNull$2")
    static final class AnonymousClass2<T> extends l implements m<am, d<? super T>, Object> {
        final /* synthetic */ au<T> $this_awaitOrNull;
        int label;

        AnonymousClass2(au<? extends T> r3, d<? super AnonymousClass2> r4) {
            au<T> r5 = (au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin");
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.$this_awaitOrNull = r5;
            super(2, r6);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$this_awaitOrNull, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, Object r4) {
            return invoke((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        public final Object invoke(am r3, d<? super T> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
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
            au<T> r6 = this.$this_awaitOrNull;
            d<? super T> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public static final <T> Object awaitOrNull(au<? extends T> r3, long r4, d<? super T> r6) {
        au r5 = (au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin");
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        return dg.b(r4, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r5, null), m.class, "com.obric.aiagent.plugin"), r7);
    }
}
