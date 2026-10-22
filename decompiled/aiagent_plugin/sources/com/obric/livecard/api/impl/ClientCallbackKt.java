package com.obric.livecard.api.impl;

import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.a;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: ClientCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ClientCallbackKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.obric.livecard.api.impl.ClientCallbackKt$runOnMainThreadBlock$1, reason: invalid class name */
    /* JADX INFO: compiled from: ClientCallback.kt */
    @f(b = "ClientCallback.kt", c = {}, d = "invokeSuspend", e = "com.obric.livecard.api.impl.ClientCallbackKt$runOnMainThreadBlock$1")
    static final class AnonymousClass1<T> extends l implements m<am, d<? super T>, Object> {
        final /* synthetic */ a<T> $block;
        int label;

        AnonymousClass1(a<? extends T> r3, d<? super AnonymousClass1> r4) {
            a<T> r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.$block = r5;
            super(2, r6);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$block, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, Object r4) {
            return invoke((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        public final Object invoke(am r3, d<? super T> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            b.a();
            if (this.label != 0) goto L7;
            o.a(r2);
            return this.$block.invoke();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final <T> T runOnMainThreadBlock(a<? extends T> r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "block");
        if (d.h.b.o.a(Thread.currentThread(), Looper.getMainLooper().getThread()) == false) goto L6;
        return (T) r5.invoke();
    L6:
        return (T) i.a((g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5, null), m.class, "com.obric.aiagent.plugin"));
    }
}
