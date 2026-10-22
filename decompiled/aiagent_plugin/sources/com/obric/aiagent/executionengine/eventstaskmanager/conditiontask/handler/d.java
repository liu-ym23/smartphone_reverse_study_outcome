package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler;

import android.content.Context;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.feature.api.IFeatureServiceKt;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.ResultCallback;
import com.obric.memorydata.sdk.awareness.AwarenessConditionConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.n;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: ContextAwarenessWrapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private static final String TAG = "ContextAwarenessWrapper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f17179a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f17180b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f17181c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<d.h.a.a<x>> f17182d = null;

    /* JADX INFO: compiled from: ContextAwarenessWrapper.kt */
    static final class a implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.c.d<MemoryResponse<Void>> f17183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ double f17185c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ double f17186d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f17187e;

        a(d.c.d<? super MemoryResponse<Void>> r3, String r4, double r5, double r7, int r9) {
            this.f17183a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17184b = r4;
            this.f17185c = r5;
            this.f17186d = r7;
            this.f17187e = r9;
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            d.c.d<MemoryResponse<Void>> r0 = this.f17183a;
            n.a r1 = n.f38560a;
            r0.resumeWith(n.f(com.obric.memorydata.sdk.awareness.a.f33811a.a(this.f17184b, this.f17185c, this.f17186d, this.f17187e)));
        }
    }

    /* JADX INFO: compiled from: ContextAwarenessWrapper.kt */
    @d.c.b.a.f(b = "ContextAwarenessWrapper.kt", c = {115}, d = "getFeature", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.ContextAwarenessWrapper")
    static final class b<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f17189b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f17190c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f17191d;

        b(d r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17190c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17189b = r3;
            this.f17191d |= Integer.MIN_VALUE;
            return this.f17190c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: ContextAwarenessWrapper.kt */
    @d.c.b.a.f(b = "ContextAwarenessWrapper.kt", c = {229}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.ContextAwarenessWrapper$getFeature$response$1")
    static final class c<T> extends l implements m<am, d.c.d<? super MemoryResponse<T>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f17193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17194c;

        /* JADX INFO: compiled from: ContextAwarenessWrapper.kt */
        static final class a implements d.h.a.a<x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.n<MemoryResponse<T>> f17195a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f17196b;

            a(kotlinx.coroutines.n<? super MemoryResponse<T>> r3, String r4) {
                this.f17195a = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
                this.f17196b = r4;
            }

            @Override // d.h.a.a
            public /* synthetic */ x invoke() {
                a();
                return x.f38692a;
            }

            public final void a() {
                if (this.f17195a.a() == false) goto L6;
                d.c.d r0 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f17195a, d.c.d.class, "com.obric.aiagent.plugin");
                n.a r1 = n.f38560a;
                r0.resumeWith(n.f(com.obric.memorydata.sdk.awareness.a.f33811a.a(this.f17196b)));
                return;
            }
        }

        c(String r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17194c = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super MemoryResponse<T>> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f17194c, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, Object r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17193b;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            String r6 = (String) ZeusTransformUtils.preCheckCast(this.f17192a, String.class, "com.obric.aiagent.plugin");
            o.a(r7);
        L13:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            String r8 = this.f17194c;
            this.f17192a = r8;
            this.f17193b = 1;
            kotlinx.coroutines.o r4 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")), 1);
            r4.e();
            kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
            d.a(d.f17179a, (d.h.a.a) ZeusTransformUtils.preCheckCast(new a(r2, r8), d.h.a.a.class, "com.obric.aiagent.plugin"));
            r7 = r4.h();
            if (r7 != d.c.a.b.a()) goto L11;
            d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        L11:
            if (r7 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ContextAwarenessWrapper.kt */
    public static final class C0350d implements com.obric.memorydata.sdk.a.c {
        C0350d() {
        }

        @Override // com.obric.memorydata.sdk.a.c
        public void a(String r1, String r2) {
            d.h.b.o.e(r1, "tag");
            d.h.b.o.e(r2, "msg");
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.a(r1, r2);
        }

        @Override // com.obric.memorydata.sdk.a.c
        public void a(String r1, String r2, Throwable r3) {
            d.h.b.o.e(r1, "tag");
            d.h.b.o.e(r2, "msg");
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(r1, r2, r3);
        }

        @Override // com.obric.memorydata.sdk.a.c
        public void b(String r1, String r2) {
            d.h.b.o.e(r1, "tag");
            d.h.b.o.e(r2, "msg");
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(r1, r2);
        }

        @Override // com.obric.memorydata.sdk.a.c
        public void c(String r1, String r2) {
            d.h.b.o.e(r1, "tag");
            d.h.b.o.e(r2, "msg");
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(r1, r2);
        }
    }

    /* JADX INFO: compiled from: ContextAwarenessWrapper.kt */
    public static final class e implements ResultCallback<Boolean> {
        e() {
        }

        @Override // com.obric.memorydata.sdk.ResultCallback
        public /* synthetic */ void onResult(int r3, String r4, Boolean r5) {
            a(r3, r4, (Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin"));
        }

        public void a(int r3, String r4, Boolean r5) {
            d.h.b.o.e(r4, "errorMsg");
            if (r3 != 0) goto L5;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(d.TAG, "ContextAwareness init success");
            d.a().set(true);
            d.a(d.f17179a);
            return;
        L5:
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(d.TAG, "ContextAwareness init failed " + r3 + ' ' + r4);
            com.obric.event.task.base.report.i.f32779a.b("context_awareness_init_failed");
        }
    }

    /* JADX INFO: compiled from: ContextAwarenessWrapper.kt */
    static final class f implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.c.d<MemoryResponse<Void>> f17197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17199c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AwarenessConditionConfig f17200d;

        f(d.c.d<? super MemoryResponse<Void>> r3, String r4, String r5, AwarenessConditionConfig r6) {
            this.f17197a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17198b = r4;
            this.f17199c = r5;
            this.f17200d = r6;
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            d.c.d<MemoryResponse<Void>> r0 = this.f17197a;
            n.a r1 = n.f38560a;
            r0.resumeWith(n.f(com.obric.memorydata.sdk.awareness.a.f33811a.b(this.f17198b, this.f17199c, this.f17200d)));
        }
    }

    /* JADX INFO: compiled from: ContextAwarenessWrapper.kt */
    static final class g implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.c.d<MemoryResponse<Void>> f17201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17202b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f17203c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AwarenessConditionConfig f17204d;

        g(d.c.d<? super MemoryResponse<Void>> r3, String r4, String r5, AwarenessConditionConfig r6) {
            this.f17201a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17202b = r4;
            this.f17203c = r5;
            this.f17204d = r6;
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            d.c.d<MemoryResponse<Void>> r0 = this.f17201a;
            n.a r1 = n.f38560a;
            r0.resumeWith(n.f(com.obric.memorydata.sdk.awareness.a.f33811a.a(this.f17202b, this.f17203c, this.f17204d)));
        }
    }

    /* JADX INFO: compiled from: ContextAwarenessWrapper.kt */
    static final class h implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.c.d<MemoryResponse<Void>> f17205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17206b;

        h(d.c.d<? super MemoryResponse<Void>> r3, String r4) {
            this.f17205a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17206b = r4;
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            d.c.d<MemoryResponse<Void>> r0 = this.f17205a;
            n.a r1 = n.f38560a;
            r0.resumeWith(n.f(com.obric.memorydata.sdk.awareness.a.f33811a.b(this.f17206b)));
        }
    }

    /* JADX INFO: compiled from: ContextAwarenessWrapper.kt */
    static final class i implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.c.d<MemoryResponse<Void>> f17207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17208b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ double f17209c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ double f17210d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f17211e;
        final /* synthetic */ String f;

        i(d.c.d<? super MemoryResponse<Void>> r3, String r4, double r5, double r7, String r9, String r10) {
            this.f17207a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17208b = r4;
            this.f17209c = r5;
            this.f17210d = r7;
            this.f17211e = r9;
            this.f = r10;
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            d.c.d<MemoryResponse<Void>> r0 = this.f17207a;
            n.a r1 = n.f38560a;
            r0.resumeWith(n.f(com.obric.memorydata.sdk.awareness.a.f33811a.a(this.f17208b, this.f17209c, this.f17210d, this.f17211e, this.f)));
        }
    }

    /* JADX INFO: compiled from: ContextAwarenessWrapper.kt */
    static final class j implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.c.d<MemoryResponse<Void>> f17212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17213b;

        j(d.c.d<? super MemoryResponse<Void>> r3, String r4) {
            this.f17212a = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17213b = r4;
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            d.c.d<MemoryResponse<Void>> r0 = this.f17212a;
            n.a r1 = n.f38560a;
            r0.resumeWith(n.f(com.obric.memorydata.sdk.awareness.a.f33811a.c(this.f17213b)));
        }
    }

    private d() {
    }

    public static final /* synthetic */ AtomicBoolean a() {
        return f17180b;
    }

    public static final /* synthetic */ void a(d r0) {
        r0.b();
    }

    public static final /* synthetic */ void a(d r2, d.h.a.a r3) {
        r2.a((d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    static {
        f17179a = new d();
        f17180b = new AtomicBoolean(false);
        f17181c = new AtomicBoolean(false);
        f17182d = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    public final void a(Context r5) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "ContextAwareness start init");
        com.obric.memorydata.sdk.awareness.a.f33811a.a((com.obric.memorydata.sdk.a.c) ZeusTransformUtils.preCheckCast(new C0350d(), com.obric.memorydata.sdk.a.c.class, "com.obric.aiagent.plugin"));
        if (ObricProductSdk.INSTANCE.featureService().isFeatureEnable(IFeatureServiceKt.FEATURE_KEY_KEEP_ALIVE_HIGH_LEVEL) == false) goto L5;
        int r6 = 64;
    L6:
        com.obric.memorydata.sdk.awareness.a.f33811a.a(r4, (ResultCallback) ZeusTransformUtils.preCheckCast(new e(), ResultCallback.class, "com.obric.aiagent.plugin"), r6);
        return;
    L5:
        r6 = 32;
        goto L6
    }

    public final Object a(String r15, double r16, double r18, String r20, String r21, d.c.d<? super MemoryResponse<Void>> r22) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r2 = new d.c.i(d.c.a.b.a(r0));
        d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(r2, d.c.d.class, "com.obric.aiagent.plugin");
        f17179a.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new i(r5, r15, r16, r18, r20, r21), d.h.a.a.class, "com.obric.aiagent.plugin"));
        Object r1 = r2.a();
        if (r1 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r0);
    L5:
        return r1;
    }

    public final <T> Object a(String r7, d.c.d<? super MemoryResponse<T>> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
        if ((r0.f17191d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f17191d -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f17189b;
        Object r10 = d.c.a.b.a();
        int r2 = r0.f17191d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r7 = (String) ZeusTransformUtils.preCheckCast(r0.f17188a, String.class, "com.obric.aiagent.plugin");
        o.a(r6);
    L17:
        MemoryResponse r11 = (MemoryResponse) ZeusTransformUtils.preCheckCast(r6, MemoryResponse.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L21;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "getFeature " + r7 + " timeout after 10000ms, service not ready");
        return new MemoryResponse(404, "getFeature timeout", null, 4, null);
    L21:
        return r11;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r6);
        m r12 = (m) ZeusTransformUtils.preCheckCast(new c(r7, null), m.class, "com.obric.aiagent.plugin");
        r0.f17188a = r7;
        r0.f17191d = 1;
        r6 = dg.b(10000, r12, r0);
        if (r6 != r10) goto L17;
        return r10;
    L7:
        r0 = new b(this, r9);
        goto L8
    }

    public final Object a(String r5, String r6, AwarenessConditionConfig r7, d.c.d<? super MemoryResponse<Void>> r8) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r9 = new d.c.i(d.c.a.b.a(r4));
        d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(r9, d.c.d.class, "com.obric.aiagent.plugin");
        f17179a.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new g(r1, r5, r6, r7), d.h.a.a.class, "com.obric.aiagent.plugin"));
        Object r10 = r9.a();
        if (r10 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r4);
    L5:
        return r10;
    }

    public final Object b(String r5, String r6, AwarenessConditionConfig r7, d.c.d<? super MemoryResponse<Void>> r8) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r9 = new d.c.i(d.c.a.b.a(r4));
        d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(r9, d.c.d.class, "com.obric.aiagent.plugin");
        f17179a.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new f(r1, r5, r6, r7), d.h.a.a.class, "com.obric.aiagent.plugin"));
        Object r10 = r9.a();
        if (r10 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r4);
    L5:
        return r10;
    }

    public final Object a(String r14, double r15, double r17, int r19, d.c.d<? super MemoryResponse<Void>> r20) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r2 = new d.c.i(d.c.a.b.a(r0));
        d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(r2, d.c.d.class, "com.obric.aiagent.plugin");
        f17179a.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new a(r5, r14, r15, r17, r19), d.h.a.a.class, "com.obric.aiagent.plugin"));
        Object r1 = r2.a();
        if (r1 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r0);
    L5:
        return r1;
    }

    public final Object b(String r5, d.c.d<? super MemoryResponse<Void>> r6) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r7 = new d.c.i(d.c.a.b.a(r4));
        d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(r7, d.c.d.class, "com.obric.aiagent.plugin");
        f17179a.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new h(r1, r5), d.h.a.a.class, "com.obric.aiagent.plugin"));
        Object r8 = r7.a();
        if (r8 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r4);
    L5:
        return r8;
    }

    public final Object c(String r5, d.c.d<? super MemoryResponse<Void>> r6) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r7 = new d.c.i(d.c.a.b.a(r4));
        d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(r7, d.c.d.class, "com.obric.aiagent.plugin");
        f17179a.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new j(r1, r5), d.h.a.a.class, "com.obric.aiagent.plugin"));
        Object r8 = r7.a();
        if (r8 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r4);
    L5:
        return r8;
    }

    private final void a(d.h.a.a<x> r3) {
        d.h.a.a<x> r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (f17180b.get() == false) goto L5;
        r4.invoke();
        return;
    L5:
        b(r4);
    }

    private final void b(d.h.a.a<x> r2) {
        d.h.a.a<x> r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        List<d.h.a.a<x>> r3 = f17182d;
        monitor-enter(r3);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f17181c.get() == false) goto L7;
        r1.invoke();     // Catch: Throwable -> L10
        x r4 = x.f38692a;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r3);
        return;
    L7:
        Boolean.valueOf(r3.add(r1));     // Catch: Throwable -> L10
        goto L8
    }

    private final void b() {
        List<d.h.a.a<x>> r4 = f17182d;
        monitor-enter(r4);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L11
    L6:
        if (r0.hasNext() == false) goto L8;
        ((d.h.a.a) ZeusTransformUtils.preCheckCast(r0.next(), d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();     // Catch: Throwable -> L11
        goto L6
    L8:
        f17182d.clear();     // Catch: Throwable -> L11
        f17181c.set(true);     // Catch: Throwable -> L11
        x r1 = x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(r4);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
