package com.obric.aiagent.executionengine.scheduler.impl.c;

import com.google.gson.JsonObject;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: TimeEventController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends com.obric.aiagent.executionengine.scheduler.impl.c.a {
    private static final String TAG = "TimeEventController";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18380a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aiagent.executionengine.scheduler.impl.c.c f18381b;

    /* JADX INFO: compiled from: TimeEventController.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: TimeEventController.kt */
    @f(b = "TimeEventController.kt", c = {21}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.event.TimeEventController$registerEvent$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f18383b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f18384c;

        b(d r3, long r4, d.c.d<? super b> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18383b = r3;
            this.f18384c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f18383b, this.f18384c, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18382a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            d.a(this.f18383b).a(com.obric.aiagent.executionengine.scheduler.api.b.f17955b, this.f18384c);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18382a = 1;
            if (ax.a(5000, r7) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TimeEventController.kt */
    @f(b = "TimeEventController.kt", c = {25}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.event.TimeEventController$registerEvent$2")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f18386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f18387c;

        c(d r3, long r4, d.c.d<? super c> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18386b = r3;
            this.f18387c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f18386b, this.f18387c, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18385a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            d.a(this.f18386b).a(com.obric.aiagent.executionengine.scheduler.api.b.f17956c, this.f18387c);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18385a = 1;
            if (ax.a(10000, r7) != r0) goto L11;
            return r0;
        }
    }

    static {
        f18380a = new a(null);
    }

    public d(com.obric.aiagent.executionengine.scheduler.impl.c.c r3) {
        com.obric.aiagent.executionengine.scheduler.impl.c.c r4 = (com.obric.aiagent.executionengine.scheduler.impl.c.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aiagent.executionengine.scheduler.impl.c.c.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "eventTrigger");
        this.f18381b = r4;
    }

    public static final /* synthetic */ com.obric.aiagent.executionengine.scheduler.impl.c.c a(d r0) {
        return r0.f18381b;
    }

    @Override // com.obric.aiagent.executionengine.scheduler.impl.c.a
    public void a(long r9, JsonObject r11) {
        Logger.INSTANCE.i(TAG, "registerEvent: jobId=" + r9 + ", params=" + r11);
        i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new c(this, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
