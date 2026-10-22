package com.obric.autogui.agents.scripted.impl;

import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: PerformanceUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: compiled from: PerformanceUtil.kt */
    @d.c.b.a.f(b = "PerformanceUtil.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.scripted.impl.PerformanceUtilKt$launchWithPerfLog$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f26990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f26991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f26992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<x> f26993d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Callback f26994e;

        a(String r3, String r4, d.h.a.a<x> r5, Callback r6, d.c.d<? super a> r7) {
            d.h.a.a<x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
            Callback r9 = (Callback) ZeusTransformUtils.wrapperContextForParams(r6, Callback.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f26991b = r3;
            this.f26992c = r4;
            this.f26993d = r8;
            this.f26994e = r9;
            super(2, r10);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f26991b, this.f26992c, this.f26993d, this.f26994e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            d.c.a.b.a();
            if (this.f26990a != 0) goto L22;
            d.o.a(r11);
            String r12 = this.f26991b;
            String r2 = this.f26992c + ": total";
            d.h.a.a<x> r3 = this.f26993d;
            String r4 = this.f26991b;
            String r5 = this.f26992c;
            Callback r10 = this.f26994e;
            long r6 = System.currentTimeMillis();
            r3.invoke();     // Catch: Throwable -> L7 Exception -> L9
        L11:
            x r13 = x.f38692a;     // Catch: Throwable -> L7
            long r7 = System.currentTimeMillis() - r6;
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L16;
            Loog.INSTANCE.d(r12, r2 + " cost: " + r7 + "ms");
        L16:
            return x.f38692a;
        L7:
            th = move-exception;
            long r8 = System.currentTimeMillis() - r6;
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L20;
            Loog.INSTANCE.d(r12, r2 + " cost: " + r8 + "ms");
        L20:
            throw th;
        L9:
            e = move-exception;
            com.obric.autogui.agents.scripted.c.c.a(r4, r5 + " error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
            r10.invoke(new Object[]{"{}"});     // Catch: Throwable -> L7
            goto L11
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final void a(am r9, String r10, String r11, Callback r12, d.h.a.a<x> r13) {
        am r2 = (am) ZeusTransformUtils.wrapperContextForParams(r9, am.class, "com.obric.aiagent.plugin");
        Callback r7 = (Callback) ZeusTransformUtils.wrapperContextForParams(r12, Callback.class, "com.obric.aiagent.plugin");
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "scope");
        d.h.b.o.e(r10, "tag");
        d.h.b.o.e(r11, "methodName");
        d.h.b.o.e(r7, "callback");
        d.h.b.o.e(r6, "block");
        kotlinx.coroutines.i.a(r2, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r10, r11, r6, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
