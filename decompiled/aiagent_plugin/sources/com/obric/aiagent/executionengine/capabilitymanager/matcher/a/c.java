package com.obric.aiagent.executionengine.capabilitymanager.matcher.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: AppIntentCapabilitySource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements com.obric.aiagent.executionengine.capabilitymanager.matcher.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f16481a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f16482b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.obric.aiagent.executionengine.capabilitymanager.api.a.a f16483c = null;

    /* JADX INFO: compiled from: AppIntentCapabilitySource.kt */
    @f(b = "AppIntentCapabilitySource.kt", c = {45}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.capabilitymanager.matcher.source.AppIntentCapabilitySource$refresh$1")
    static final class a extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16484a;

        a(d.c.d<? super a> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16484a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            com.obric.aiagent.executionengine.capabilitymanager.publish.a r6 = com.obric.aiagent.executionengine.capabilitymanager.publish.a.f16520a;
            d.c.d<? super x> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16484a = 1;
            if (r6.a(r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AppIntentCapabilitySource.kt */
    @f(b = "AppIntentCapabilitySource.kt", c = {32}, d = "snapshot", e = "com.obric.aiagent.executionengine.capabilitymanager.matcher.source.AppIntentCapabilitySource")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f16485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f16486b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16487c;

        b(c r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16486b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16485a = r3;
            this.f16487c |= Integer.MIN_VALUE;
            return this.f16486b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private c() {
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.matcher.b
    public void a() {
        com.obric.aiagent.executionengine.capabilitymanager.matcher.b.a.a(this);
    }

    static {
        f16481a = new c();
        f16482b = an.a((g) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.capabilitymanager.a.f16395a.b(), g.class, "com.obric.aiagent.plugin"));
        f16483c = com.obric.aiagent.executionengine.capabilitymanager.api.a.a.f16401c;
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.matcher.b
    public com.obric.aiagent.executionengine.capabilitymanager.api.a.a getType() {
        return f16483c;
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.matcher.b
    public Object a(d.c.d<? super List<com.obric.aiagent.executionengine.capabilitymanager.api.a.b>> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r11, b.class, "com.obric.aiagent.plugin");
        if ((r0.f16487c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16487c -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f16485a;
        Object r12 = d.c.a.b.a();
        int r2 = r0.f16487c;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        o.a(r9);
    L17:
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r13, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r13.iterator();
    L19:
        if (r15.hasNext() == false) goto L22;
        com.obric.aiagent.executionengine.capabilitymanager.data.bean.a r1 = (com.obric.aiagent.executionengine.capabilitymanager.data.bean.a) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.aiagent.executionengine.capabilitymanager.data.bean.a.class, "com.obric.aiagent.plugin");
        r14.add(new com.obric.aiagent.executionengine.capabilitymanager.api.a.b(com.obric.aiagent.executionengine.capabilitymanager.api.a.a.f16401c, r1.a(), r1.b(), r1.c(), r1.h()));
        goto L19
    L22:
        return (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r9);
        com.obric.aiagent.executionengine.capabilitymanager.publish.a r16 = com.obric.aiagent.executionengine.capabilitymanager.publish.a.f16520a;
        r0.f16487c = 1;
        r9 = r16.b(r0);
        if (r9 != r12) goto L17;
        return r12;
    L7:
        r0 = new b(this, r11);
        goto L8
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.matcher.b
    public void b() {
        i.a(f16482b, null, null, (m) ZeusTransformUtils.preCheckCast(new a(null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final Object b(d.c.d<? super x> r2) {
        d.c.d<? super x> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        Object r3 = com.obric.aiagent.executionengine.capabilitymanager.publish.a.f16520a.a(r1);
        if (r3 != d.c.a.b.a()) goto L6;
        return r3;
    L6:
        return x.f38692a;
    }
}
