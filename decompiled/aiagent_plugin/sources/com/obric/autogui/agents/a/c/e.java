package com.obric.autogui.agents.a.c;

import com.obric.autogui.agents.a.m.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.de;

/* JADX INFO: compiled from: ActionEffectEvaluator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: compiled from: ActionEffectEvaluator.kt */
    @d.c.b.a.f(b = "ActionEffectEvaluator.kt", c = {677}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.evaluation.ActionEffectEvaluatorKt$awaitActionEffectDetectorResults$2")
    static final class a extends l implements m<am, d.c.d<? super List<? extends com.obric.autogui.agents.a.f.b>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<d.h.a.b<d.c.d<? super com.obric.autogui.agents.a.f.b>, Object>> f26336b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f26337c;

        /* JADX INFO: renamed from: com.obric.autogui.agents.a.c.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ActionEffectEvaluator.kt */
        @d.c.b.a.f(b = "ActionEffectEvaluator.kt", c = {677}, d = "invokeSuspend", e = "com.obric.autogui.agents.actioneffect.evaluation.ActionEffectEvaluatorKt$awaitActionEffectDetectorResults$2$1$1")
        static final class C0662a extends l implements m<am, d.c.d<? super com.obric.autogui.agents.a.f.b>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f26338a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d.h.a.b<d.c.d<? super com.obric.autogui.agents.a.f.b>, Object> f26339b;

            C0662a(d.h.a.b<? super d.c.d<? super com.obric.autogui.agents.a.f.b>, ? extends Object> r3, d.c.d<? super C0662a> r4) {
                d.h.a.b<d.c.d<? super com.obric.autogui.agents.a.f.b>, Object> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f26339b = r5;
                super(2, r6);
            }

            public final Object a(am r3, d.c.d<? super com.obric.autogui.agents.a.f.b> r4) {
                return ((C0662a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0662a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new C0662a(this.f26339b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.agents.a.f.b> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f26338a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                o.a(r4);
            L11:
                return r4;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                o.a(r4);
                d.h.a.b<d.c.d<? super com.obric.autogui.agents.a.f.b>, Object> r5 = this.f26339b;
                this.f26338a = 1;
                r4 = r5.invoke(this);
                if (r4 != r0) goto L11;
                return r0;
            }
        }

        a(List<? extends d.h.a.b<? super d.c.d<? super com.obric.autogui.agents.a.f.b>, ? extends Object>> r3, d.c.d<? super a> r4) {
            List<d.h.a.b<d.c.d<? super com.obric.autogui.agents.a.f.b>, Object>> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26336b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super List<com.obric.autogui.agents.a.f.b>> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f26336b, r5);
            r0.f26337c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends com.obric.autogui.agents.a.f.b>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f26335a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r12);
        L15:
            return r12;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r12);
            am r13 = (am) ZeusTransformUtils.preCheckCast(this.f26337c, am.class, "com.obric.aiagent.plugin");
            Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(this.f26336b, Iterable.class, "com.obric.aiagent.plugin");
            Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r3 = r2.iterator();
        L10:
            if (r3.hasNext() == false) goto L12;
            r10.add(kotlinx.coroutines.i.b(r13, null, null, (m) ZeusTransformUtils.preCheckCast(new C0662a((d.h.a.b) ZeusTransformUtils.preCheckCast(r3.next(), d.h.a.b.class, "com.obric.aiagent.plugin"), null), m.class, "com.obric.aiagent.plugin"), 3, null));
            goto L10
        L12:
            Collection r14 = (Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin");
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26335a = 1;
            r12 = kotlinx.coroutines.f.a(r14, r4);
            if (r12 != r0) goto L15;
            return r0;
        }
    }

    public static final /* synthetic */ s a(CancellationException r0) {
        return b(r0);
    }

    private static final s b(CancellationException r1) {
        if (ZeusTransformUtils.instanceOf(r1, de.class) == false) goto L6;
        return s.f26711b;
    L6:
        return s.f26712c;
    }

    public static final Object a(List<? extends d.h.a.b<? super d.c.d<? super com.obric.autogui.agents.a.f.b>, ? extends Object>> r3, d.c.d<? super List<com.obric.autogui.agents.a.f.b>> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return an.a((m) ZeusTransformUtils.preCheckCast(new a(r5, null), m.class, "com.obric.aiagent.plugin"), r6);
    }
}
