package com.obric.autogui.agents.scripted.impl;

import android.content.ComponentName;
import android.content.Context;
import com.bytedance.vmsdk.worker.JsWorker;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.obric.aiagent.platform.depend.ICloudConfig;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.z;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dg;
import org.json.JSONObject;

/* JADX INFO: compiled from: ScriptPreCheckExecutor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r {
    private static final String TAG = "Script-ScriptPreCheckExecutor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27050a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.scripted.impl.e f27051b;

    /* JADX INFO: compiled from: ScriptPreCheckExecutor.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ScriptPreCheckExecutor.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f27052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.autogui.agents.scripted.a.g f27053b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f27052a, r6.f27052a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f27053b, r6.f27053b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f27052a.hashCode() * 31;
            com.obric.autogui.agents.scripted.a.g r1 = this.f27053b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "PreCheckExecutionResult(abilityList=" + this.f27052a + ", implementationData=" + this.f27053b + ')';
        }

        public b(List<String> r3, com.obric.autogui.agents.scripted.a.g r4) {
            List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "abilityList");
            this.f27052a = r5;
            this.f27053b = r4;
        }

        public final List<String> a() {
            return this.f27052a;
        }

        public final com.obric.autogui.agents.scripted.a.g b() {
            return this.f27053b;
        }
    }

    /* JADX INFO: compiled from: ScriptPreCheckExecutor.kt */
    @d.c.b.a.f(b = "ScriptPreCheckExecutor.kt", c = {356}, d = "executeInitPreCheck", e = "com.obric.autogui.agents.scripted.impl.ScriptPreCheckExecutor")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f27056c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ r f27057d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f27058e;

        c(r r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27057d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27056c = r3;
            this.f27058e |= Integer.MIN_VALUE;
            return r.a(this.f27057d, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ScriptPreCheckExecutor.kt */
    static final class d implements d.h.a.b<Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicReference<kotlinx.coroutines.n<Boolean>> f27059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ JsWorker f27060b;

        d(AtomicReference<kotlinx.coroutines.n<Boolean>> r1, JsWorker r2) {
            this.f27059a = r1;
            this.f27060b = r2;
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(Throwable r2) {
            this.f27059a.set(null);
            this.f27060b.setOnMessageCallback(null);
            this.f27060b.setOnErrorCallback(null);
        }
    }

    /* JADX INFO: compiled from: ScriptPreCheckExecutor.kt */
    @d.c.b.a.f(b = "ScriptPreCheckExecutor.kt", c = {356}, d = "invokeSuspend", e = "com.obric.autogui.agents.scripted.impl.ScriptPreCheckExecutor$executePreCheck$2")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super b>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f27063c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ JsWorker f27064d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f27065e;

        /* JADX INFO: compiled from: ScriptPreCheckExecutor.kt */
        static final class a implements d.h.a.b<Throwable, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AtomicReference<kotlinx.coroutines.n<b>> f27066a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ JsWorker f27067b;

            a(AtomicReference<kotlinx.coroutines.n<b>> r1, JsWorker r2) {
                this.f27066a = r1;
                this.f27067b = r2;
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(Throwable r3) {
                a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(Throwable r2) {
                this.f27066a.set(null);
                this.f27067b.setOnMessageCallback(null);
                this.f27067b.setOnErrorCallback(null);
            }
        }

        e(JsWorker r3, String r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27064d = r3;
            this.f27065e = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super b> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f27064d, this.f27065e, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super b> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r17) {
            Object r5 = d.c.a.b.a();
            int r0 = this.f27063c;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            String r1 = (String) ZeusTransformUtils.preCheckCast(this.f27062b, String.class, "com.obric.aiagent.plugin");
            JsWorker r2 = (JsWorker) ZeusTransformUtils.preCheckCast(this.f27061a, JsWorker.class, "com.obric.aiagent.plugin");
            d.o.a(r17);
            return r17;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r17);
            JsWorker r14 = this.f27064d;
            String r3 = this.f27065e;
            this.f27061a = r14;
            this.f27062b = r3;
            this.f27063c = 1;
            kotlinx.coroutines.o r15 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")), 1);
            r15.e();
            kotlinx.coroutines.n r6 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r15, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
            final AtomicReference r13 = new AtomicReference(r6);
            r14.setOnMessageCallback((com.bytedance.vmsdk.worker.a) ZeusTransformUtils.preCheckCast(new ScriptPreCheckExecutor$executePreCheck$2$1$1(r13), com.bytedance.vmsdk.worker.a.class, "com.obric.aiagent.plugin"));
            r14.setOnErrorCallback((com.bytedance.vmsdk.worker.a) ZeusTransformUtils.preCheckCast(new ScriptPreCheckExecutor$executePreCheck$2$1$2(r13), com.bytedance.vmsdk.worker.a.class, "com.obric.aiagent.plugin"));
            long r9 = System.currentTimeMillis();     // Catch: Exception -> L28
            String r4 = new Gson().toJson(r3);     // Catch: Throwable -> L20
            long r11 = System.currentTimeMillis() - r9;     // Catch: Exception -> L28
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L14;
            Loog.INSTANCE.d(r.TAG, "Gson toJson paramsJson cost: " + r11 + "ms");     // Catch: Exception -> L28
        L14:
            com.obric.autogui.agents.scripted.impl.a.a(com.obric.autogui.agents.scripted.impl.a.f26972a, r14, "preCheck(" + r4 + ')', null, 2, null);     // Catch: Exception -> L18
            AtomicReference r12 = r13;
        L36:
            r6.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r12, r14), d.h.a.b.class, "com.obric.aiagent.plugin"));
        L37:
            Object r7 = r15.h();
            if (r7 != d.c.a.b.a()) goto L40;
            d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        L40:
            if (r7 != r5) goto L51;
            return r5;
        L51:
            return r7;
        L18:
            e = e;
            r12 = r13;
        L30:
            kotlinx.coroutines.n r8 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r12.getAndSet(null), kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L37;
            com.obric.autogui.agents.scripted.c.c.a(r.TAG, "preCheck execution failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            if (r8.a() == false) goto L36;
            d.n.a r10 = d.n.f38560a;
            r8.resumeWith(d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"))));
        L20:
            th = move-exception;
            r12 = r13;
            long r16 = System.currentTimeMillis() - r9;     // Catch: Exception -> L26
            if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L25;
            Loog.INSTANCE.d(r.TAG, "Gson toJson paramsJson cost: " + r16 + "ms");     // Catch: Exception -> L26
        L25:
            throw th;     // Catch: Exception -> L26
        L26:
            e = e;
        L28:
            e = e;
            r12 = r13;
            goto L30
        }
    }

    /* JADX INFO: compiled from: ScriptPreCheckExecutor.kt */
    @d.c.b.a.f(b = "ScriptPreCheckExecutor.kt", c = {139}, d = "getAndInitWorker", e = "com.obric.autogui.agents.scripted.impl.ScriptPreCheckExecutor")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27070c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f27071d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f27072e;
        final /* synthetic */ r f;
        int g;

        f(r r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f27072e = r7;
            this.g |= Integer.MIN_VALUE;
            return r.a(this.f, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ScriptPreCheckExecutor.kt */
    @d.c.b.a.f(b = "ScriptPreCheckExecutor.kt", c = {170}, d = "initNewWorkerEnv", e = "com.obric.autogui.agents.scripted.impl.ScriptPreCheckExecutor")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f27075c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f27076d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ r f27077e;
        int f;

        g(r r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27077e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f27076d = r3;
            this.f |= Integer.MIN_VALUE;
            return r.a(this.f27077e, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ScriptPreCheckExecutor.kt */
    @d.c.b.a.f(b = "ScriptPreCheckExecutor.kt", c = {69, 89, 94}, d = "preCheckScript", e = "com.obric.autogui.agents.scripted.impl.ScriptPreCheckExecutor")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27079b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27080c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27081d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f27082e;
        Object f;
        Object g;
        long h;
        long i;
        boolean j;
        int k;
        int l;
        /* synthetic */ Object m;
        final /* synthetic */ r n;
        int o;

        h(r r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.n = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.m = r7;
            this.o |= Integer.MIN_VALUE;
            return this.n.a(null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ScriptPreCheckExecutor.kt */
    @d.c.b.a.f(b = "ScriptPreCheckExecutor.kt", c = {254}, d = "preparePreCheckParamsInternal", e = "com.obric.autogui.agents.scripted.impl.ScriptPreCheckExecutor")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f27083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f27084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f27085c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f27086d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f27087e;
        /* synthetic */ Object f;
        final /* synthetic */ r g;
        int h;

        i(r r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return r.a(this.g, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f27050a = new a(null);
    }

    public static /* synthetic */ x lambda$yq6o0NoLz9HQ2XOTyFp7tqeK2k4(z.f r0, String r1) {
        return a(r0, r1);
    }

    public r(com.obric.autogui.agents.scripted.impl.e r2) {
        d.h.b.o.e(r2, "workerPoolManager");
        this.f27051b = r2;
    }

    public static final /* synthetic */ Object a(r r2, Context r3, String r4, JsonObject r5, d.c.d r6) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(r r8, Context r9, String r10, String r11, d.h.a.b r12, d.c.d r13) {
        return r8.a((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin"), r10, r11, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(r r2, JsWorker r3, String r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(r r2, JsWorker r3, String r4, String r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public final Object a(Context r33, String r34, String r35, String r36, d.c.d<? super com.obric.autogui.agents.scripted.a.i> r37) {
        String r7 = "com.obric.aiagent.plugin";
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r33, Context.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r37, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, h.class) == false) goto L7;
        h r3 = (h) ZeusTransformUtils.preCheckCast(r2, h.class, "com.obric.aiagent.plugin");
        if ((r3.o & Integer.MIN_VALUE) == 0) goto L7;
        r3.o -= Integer.MIN_VALUE;
    L8:
        h r9 = r3;
        Object r4 = r9.m;
        Object r10 = d.c.a.b.a();
        int r5 = r9.o;
        String r14 = "ms";
        String r6 = TAG;
        if (r5 == 0) goto L31;
        if (r5 == 1) goto L25;
        if (r5 == 2) goto L20;
        if (r5 != 3) goto L19;
        long r12 = r9.i;
        int r11 = r9.l;
        int r13 = r9.k;
        boolean r0 = r9.j;
        long r15 = r9.h;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r9.f, String.class, "com.obric.aiagent.plugin");
        String r17 = (String) ZeusTransformUtils.preCheckCast(r9.f27082e, String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.scripted.impl.e.b r18 = (com.obric.autogui.agents.scripted.impl.e.b) ZeusTransformUtils.preCheckCast(r9.f27081d, com.obric.autogui.agents.scripted.impl.e.b.class, "com.obric.aiagent.plugin");
        String r19 = (String) ZeusTransformUtils.preCheckCast(r9.f27080c, String.class, "com.obric.aiagent.plugin");
        String r20 = (String) ZeusTransformUtils.preCheckCast(r9.f27079b, String.class, "com.obric.aiagent.plugin");
        r r1 = (r) ZeusTransformUtils.preCheckCast(r9.f27078a, r.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L16
        boolean r21 = r0;
        r6 = r20;
        String r24 = "com.obric.aiagent.plugin";
        int r22 = r13;
        String r110 = r19;
        r14 = "ms";
        long r111 = r12;
        String r23 = TAG;
        String r25 = r17;
        int r26 = r11;
    L119:
        int r38 = r26;
        r7 = r24;
        b r27 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, r7);     // Catch: Throwable -> L179
        long r112 = System.currentTimeMillis() - r111;     // Catch: Throwable -> L173 Exception -> L176
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L131;
        int r39 = r22;
        Loog.INSTANCE.d(r25, r16 + " cost: " + r112 + r14);     // Catch: Throwable -> L127 Exception -> L129
    L129:
        e = e;
    L178:
        r6 = r6;
        int r113 = r38;
        r18 = r18;
        long r28 = r15;
        r110 = r110;
        int r29 = r39;
    L302:
    L269:
        th = th;
        r29 = r29;
        r110 = r110;
    L271:
        if (r29 != 0) goto L274;
        if (r113 != 0) goto L274;
        r1.f27051b.a(r18, false);     // Catch: Throwable -> L275
    L275:
        th = th;
    L287:
        String r30 = r110;
    L288:
        long r31 = System.currentTimeMillis() - r28;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L291;
        Loog.INSTANCE.d(r6, r30 + " cost: " + r31 + r14);
    L291:
        throw th;
    L274:
        throw th;     // Catch: Throwable -> L275
    L255:
        if (ZeusTransformUtils.instanceOf(e, CancellationException.class) == true) goto L268;
        e.printStackTrace();     // Catch: Throwable -> L269
        com.obric.autogui.agents.scripted.c.c.a(r23, "preCheckScript failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, r7));     // Catch: Throwable -> L269
        com.obric.autogui.agents.scripted.a.i r32 = new com.obric.autogui.agents.scripted.a.i(d.a.p.b(), false, "execute_error:" + e.getMessage(), null, 8, null);     // Catch: Throwable -> L269
        if (r29 != 0) goto L263;
        if (r113 != 0) goto L263;
        r1.f27051b.a(r18, false);     // Catch: Throwable -> L261
    L261:
        th = th;
        r30 = r110;
    L263:
        long r114 = r28;
        com.obric.autogui.agents.scripted.a.i r40 = r32;
        String r115 = r110;
    L264:
        long r41 = System.currentTimeMillis() - r114;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L267;
        Loog.INSTANCE.d(r6, r115 + " cost: " + r41 + r14);
    L267:
        return r40;
    L268:
        throw e;     // Catch: Throwable -> L269
    L127:
        th = th;
    L175:
        r6 = r6;
        r113 = r38;
        r29 = r39;
    L208:
        r18 = r18;
        r28 = r15;
        goto L271
    L131:
        if (r27 == null) goto L133;
        int r42 = 1;
    L134:
        if (r42 == 0) goto L348;
        r1.f27051b.a(r18, true);     // Catch: Throwable -> L137 Exception -> L139
        int r43 = r38;
    L340:
    L165:
        e = e;
        r18 = r18;
        r113 = r43;
        r6 = r6;
    L172:
        r29 = r42;
    L212:
        r28 = r15;
    L163:
        th = th;
        r29 = r42;
        r18 = r18;
        r113 = r43;
        r28 = r15;
        r6 = r6;
        goto L271
    L144:
        if (r27 == null) goto L147;
        List<String> r116 = r27.a();     // Catch: Throwable -> L163 Exception -> L165
        if (r116 == null) goto L147;
    L148:
        boolean r44 = !r21;     // Catch: Throwable -> L163 Exception -> L165
        if (r43 == 0) goto L151;
        String r117 = "execute_timeout";
    L152:
        if (r27 == null) goto L154;
        com.obric.autogui.agents.scripted.a.g r45 = r27.b();     // Catch: Throwable -> L163 Exception -> L165
    L155:
        com.obric.autogui.agents.scripted.a.i r46 = new com.obric.autogui.agents.scripted.a.i(r116, r44, r117, r45);     // Catch: Throwable -> L163 Exception -> L165
        if (r42 != 0) goto L162;
        if (r43 != 0) goto L162;
        r1.f27051b.a(r18, false);     // Catch: Throwable -> L160
    L160:
        th = th;
        r6 = r6;
        r28 = r15;
    L162:
        r6 = r6;
        r40 = r46;
        r114 = r15;
        r115 = r110;
        goto L264
    L154:
        r45 = null;
        goto L155
    L151:
        r117 = "success";
    L147:
        r116 = d.a.p.b();     // Catch: Throwable -> L163 Exception -> L165
        goto L148
    L139:
        e = e;
        r113 = r38;
    L137:
        th = th;
        r6 = r6;
        r113 = r38;
        r29 = r42;
        goto L208
    L348:
        r1.f27051b.a(r18);     // Catch: Throwable -> L167 Exception -> L169
        r43 = 1;
        goto L340
    L169:
        e = e;
        r113 = 1;
    L167:
        th = th;
        r6 = r6;
        r29 = r42;
        r18 = r18;
        r28 = r15;
        r113 = 1;
        goto L271
    L133:
        r42 = 0;
    L176:
        e = e;
        r39 = r22;
    L173:
        th = th;
        r39 = r22;
    L179:
        th = th;
        r20 = r6;
        r113 = r38;
        int r47 = r22;
    L338:
        long r118 = System.currentTimeMillis() - r111;     // Catch: Throwable -> L205 Exception -> L209
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L199;
        r r310 = r1;
        Loog.INSTANCE.d(r25, r16 + " cost: " + r118 + r14);     // Catch: Throwable -> L201 Exception -> L203
    L200:
        throw th;     // Catch: Throwable -> L201 Exception -> L203
    L203:
        e = e;
        r1 = r310;
    L211:
        r6 = r20;
        r110 = r110;
        r29 = r47;
        r18 = r18;
    L201:
        th = th;
        r1 = r310;
    L207:
        r29 = r47;
        r6 = r20;
        goto L208
    L199:
        r310 = r1;
    L209:
        e = e;
    L205:
        th = th;
    L16:
        th = th;
        r113 = r11;
        r47 = r13;
        r110 = r19;
        r23 = TAG;
        r25 = r17;
        r7 = "com.obric.aiagent.plugin";
        r14 = "ms";
        r111 = r12;
        goto L338
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        long r48 = r9.i;
        int r49 = r9.l;
        int r50 = r9.k;
        boolean r51 = r9.j;
        long r119 = r9.h;
        String r120 = (String) ZeusTransformUtils.preCheckCast(r9.g, String.class, "com.obric.aiagent.plugin");
        String r52 = (String) ZeusTransformUtils.preCheckCast(r9.f, String.class, "com.obric.aiagent.plugin");
        JsWorker r53 = (JsWorker) ZeusTransformUtils.preCheckCast(r9.f27082e, JsWorker.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.scripted.impl.e.b r54 = (com.obric.autogui.agents.scripted.impl.e.b) ZeusTransformUtils.preCheckCast(r9.f27081d, com.obric.autogui.agents.scripted.impl.e.b.class, "com.obric.aiagent.plugin");
        String r55 = (String) ZeusTransformUtils.preCheckCast(r9.f27080c, String.class, "com.obric.aiagent.plugin");
        String r56 = (String) ZeusTransformUtils.preCheckCast(r9.f27079b, String.class, "com.obric.aiagent.plugin");
        r1 = (r) ZeusTransformUtils.preCheckCast(r9.f27078a, r.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L23
        boolean r210 = r51;
        JsWorker r211 = r53;
        r113 = r49;
        r29 = r50;
        String r57 = r56;
        r23 = TAG;
        Object r58 = r4;
        r r59 = r1;
        r110 = r55;
        String r121 = "ms";
        r28 = r119;
        String r122 = r52;
        String r123 = r120;
        com.obric.autogui.agents.scripted.impl.e.b r124 = r54;
        long r60 = r48;
    L296:
        String r61 = (String) ZeusTransformUtils.preCheckCast(r58, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L224
        long r62 = System.currentTimeMillis() - r60;     // Catch: Throwable -> L217 Exception -> L221
        if (AOSystemTools.INSTANCE.isDebugVersion() == true) goto L294;
        r24 = "com.obric.aiagent.plugin";
        r14 = r121;
    L356:
        r16 = "JS execution";
        long r63 = System.currentTimeMillis();     // Catch: Throwable -> L213 Exception -> L215
        r9.f27078a = r59;     // Catch: Throwable -> L190
        r9.f27079b = r57;     // Catch: Throwable -> L190
        r9.f27080c = r110;     // Catch: Throwable -> L190
        r9.f27081d = r124;     // Catch: Throwable -> L190
        r9.f27082e = r23;     // Catch: Throwable -> L190
        r9.f = "JS execution";     // Catch: Throwable -> L190
        r9.g = null;     // Catch: Throwable -> L190
        r9.h = r28;     // Catch: Throwable -> L190
        boolean r125 = r210;
        r9.j = r125;     // Catch: Throwable -> L190
        int r64 = r29;
        r9.k = r64;     // Catch: Throwable -> L188
        r110 = r110;
        int r65 = r113;
        r9.l = r65;     // Catch: Throwable -> L186
        r9.i = r63;     // Catch: Throwable -> L186
        r113 = r65;
        r9.o = 3;     // Catch: Throwable -> L184
        Object r66 = r59.b(r211, r61, r9);     // Catch: Throwable -> L184
        if (r66 != r10) goto L117;
        return r10;
    L117:
        r1 = r59;
        r22 = r64;
        r6 = r57;
        r25 = r23;
        r26 = r113;
        r4 = r66;
        r21 = r125;
        r18 = r124;
        r15 = r28;
        r111 = r63;
    L184:
        th = th;
    L193:
        r7 = r24;
        r20 = r57;
        r1 = r59;
        r47 = r64;
        r25 = r23;
        r18 = r124;
        r15 = r28;
        r111 = r63;
    L186:
        th = th;
        r113 = r65;
    L188:
        th = th;
        r110 = r110;
        r113 = r113;
    L190:
        th = th;
        r64 = r29;
        r113 = r113;
        r110 = r110;
        goto L193
    L215:
        e = e;
        r7 = r24;
    L223:
        r28 = r28;
        r110 = r110;
        r29 = r29;
        r6 = r57;
        r1 = r59;
    L249:
        r18 = r124;
    L213:
        th = th;
    L219:
        r6 = r57;
    L220:
        r1 = r59;
    L245:
        r18 = r124;
        goto L271
    L294:
        r24 = "com.obric.aiagent.plugin";
        r14 = r121;
        Loog.INSTANCE.d(r122, r123 + " cost: " + r62 + r14);     // Catch: Throwable -> L92 Exception -> L94
    L94:
        e = e;
    L104:
        r110 = r110;
        r1 = r59;
        r6 = r57;
        r18 = r124;
        r28 = r28;
        r113 = r113;
        r7 = r24;
    L92:
        th = th;
    L100:
        r6 = r57;
        goto L220
    L96:
        e = e;
    L103:
        r14 = r121;
    L98:
        th = th;
        r14 = r121;
    L101:
        e = e;
        r24 = "com.obric.aiagent.plugin";
        goto L103
    L221:
        e = e;
        r7 = "com.obric.aiagent.plugin";
        r14 = r121;
    L217:
        th = th;
        r14 = r121;
    L224:
        th = th;
        long r67 = r60;
        int r68 = r29;
        r110 = r110;
        r14 = r121;
        r113 = r113;
        r6 = r57;
        r1 = r59;
        int r69 = r68;
        String r126 = r123;
        long r70 = r28;
    L354:
        long r71 = System.currentTimeMillis() - r67;     // Catch: Throwable -> L242 Exception -> L246
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L236;
        r r311 = r1;
        Loog.INSTANCE.d(r122, r126 + " cost: " + r71 + r14);     // Catch: Throwable -> L238 Exception -> L240
    L237:
        throw th;     // Catch: Throwable -> L238 Exception -> L240
    L240:
        e = e;
        r1 = r311;
    L248:
        r28 = r70;
        r110 = r110;
        r29 = r69;
    L238:
        th = th;
        r1 = r311;
    L244:
        r29 = r69;
        r28 = r70;
        goto L245
    L236:
        r311 = r1;
    L246:
        e = e;
    L242:
        th = th;
    L23:
        th = th;
        r69 = r50;
        r70 = r119;
        r122 = r52;
        r110 = r55;
        r23 = TAG;
        r113 = r49;
        r14 = "ms";
        r6 = r56;
        r126 = r120;
        r124 = r54;
        r67 = r48;
        goto L354
    L25:
        r28 = r9.h;
        z.f r72 = (z.f) ZeusTransformUtils.preCheckCast(r9.f, z.f.class, "com.obric.aiagent.plugin");
        r30 = (String) ZeusTransformUtils.preCheckCast(r9.f27082e, String.class, "com.obric.aiagent.plugin");
        String r73 = (String) ZeusTransformUtils.preCheckCast(r9.f27081d, String.class, "com.obric.aiagent.plugin");
        String r127 = (String) ZeusTransformUtils.preCheckCast(r9.f27080c, String.class, "com.obric.aiagent.plugin");
        Context r128 = (Context) ZeusTransformUtils.preCheckCast(r9.f27079b, Context.class, "com.obric.aiagent.plugin");
        r1 = (r) ZeusTransformUtils.preCheckCast(r9.f27078a, r.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L28
        z.f r74 = r72;
        String r75 = r127;
        Object r76 = r4;
        Context r77 = r128;
        long r129 = r28;
        r23 = TAG;
        r6 = r73;
    L311:
        d.m r78 = (d.m) ZeusTransformUtils.preCheckCast(r76, d.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L277
        if (r78 == null) goto L323;
        r18 = (com.obric.autogui.agents.scripted.impl.e.b) ZeusTransformUtils.preCheckCast(r78.c(), com.obric.autogui.agents.scripted.impl.e.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L277
        boolean r79 = ((Boolean) ZeusTransformUtils.preCheckCast(r78.d(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L277
        JsWorker r130 = r18.a();     // Catch: Throwable -> L277
        r121 = "ms";
        r126 = "Prepare params";
        Context r131 = r77;
        r67 = System.currentTimeMillis();     // Catch: Throwable -> L250 Exception -> L252
        r9.f27078a = r1;     // Catch: Throwable -> L228
        r9.f27079b = r6;     // Catch: Throwable -> L228
        r9.f27080c = r30;     // Catch: Throwable -> L228
        r9.f27081d = r18;     // Catch: Throwable -> L228
        r9.f27082e = r130;     // Catch: Throwable -> L228
        r9.f = r23;     // Catch: Throwable -> L228
        r9.g = "Prepare params";     // Catch: Throwable -> L228
        r9.h = r129;     // Catch: Throwable -> L228
        com.obric.autogui.agents.scripted.impl.e.b r312 = r18;
        r9.j = r79;     // Catch: Throwable -> L226
        r9.k = 0;     // Catch: Throwable -> L226
        r9.l = 0;     // Catch: Throwable -> L226
        r9.i = r67;     // Catch: Throwable -> L226
        r9.o = 2;     // Catch: Throwable -> L226
        Object r80 = r1.a(r131, r75, r9);     // Catch: Throwable -> L226
        if (r80 != r10) goto L82;
        return r10;
    L82:
        r210 = r79;
        r211 = r130;
        r123 = "Prepare params";
        r29 = 0;
        r113 = 0;
        r28 = r129;
        r124 = r312;
        r122 = r23;
        r59 = r1;
        r110 = r30;
        r57 = r6;
        r60 = r67;
        r58 = r80;
    L226:
        th = th;
    L230:
        r110 = r30;
        r14 = r121;
        r70 = r129;
        r69 = 0;
        r113 = 0;
        r124 = r312;
        r122 = r23;
    L228:
        th = th;
        r312 = r18;
        goto L230
    L252:
        e = e;
        String r132 = r30;
        r7 = "com.obric.aiagent.plugin";
        r14 = r121;
        r28 = r129;
        r110 = r132;
        r29 = 0;
        r113 = 0;
    L250:
        th = th;
        r110 = r30;
        r14 = r121;
        r28 = r129;
        r29 = 0;
        r113 = 0;
        goto L271
    L323:
        r40 = new com.obric.autogui.agents.scripted.a.i(d.a.p.b(), false, "worker_init_fail:" + ((String) ZeusTransformUtils.preCheckCast(r74.f38504a, String.class, "com.obric.aiagent.plugin")), null, 8, null);     // Catch: Throwable -> L72
        r114 = r129;
        r14 = "ms";
        r115 = r30;
    L72:
        th = th;
        r28 = r129;
    L30:
        r14 = "ms";
    L277:
        th = th;
        r14 = "ms";
        r28 = r129;
    L28:
        th = th;
        r6 = r73;
        goto L30
    L31:
        d.o.a(r4);
        r115 = "Total preCheckScript";
        r114 = System.currentTimeMillis();
        CharSequence r81 = (CharSequence) ZeusTransformUtils.preCheckCast(r34, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L284
        if (r81 != null) goto L313;
    L40:
        boolean r82 = true;
    L41:
        if (r82 == false) goto L45;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "preCheckScript failed: scriptEngine is null or empty");     // Catch: Throwable -> L38
        r40 = new com.obric.autogui.agents.scripted.a.i(d.a.p.b(), false, "engine_missing", null, 8, null);     // Catch: Throwable -> L38
    L43:
        r14 = "ms";
        goto L264
    L45:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L47;
        Loog.INSTANCE.d(TAG, "scriptEngine loaded, length=" + r34.length());     // Catch: Throwable -> L38
    L47:
        CharSequence r83 = (CharSequence) ZeusTransformUtils.preCheckCast(r35, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L284
        if (r83 != null) goto L50;
    L53:
        boolean r84 = true;
    L54:
        if (r84 == false) goto L58;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "preCheckScript failed: no pre check bundle script found");     // Catch: Throwable -> L38
        r40 = new com.obric.autogui.agents.scripted.a.i(d.a.p.b(), false, "bundle_missing", null, 8, null);     // Catch: Throwable -> L38
        goto L43
    L58:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L60;
        Loog.INSTANCE.d(TAG, "pre check bundle script loaded, length=" + r35.length());     // Catch: Throwable -> L38
    L60:
        final z.f r85 = new z.f();     // Catch: Throwable -> L284
        d.h.a.b<? super String, x> r86 = new $$Lambda$r$yq6o0NoLz9HQ2XOTyFp7tqeK2k4(r85);     // Catch: Throwable -> L281
        r9.f27078a = this;     // Catch: Throwable -> L284
        r9.f27079b = r8;     // Catch: Throwable -> L284
        r9.f27080c = r36;     // Catch: Throwable -> L284
        r9.f27081d = TAG;     // Catch: Throwable -> L284
        r9.f27082e = "Total preCheckScript";     // Catch: Throwable -> L284
        r9.f = r85;     // Catch: Throwable -> L284
        r9.h = r114;     // Catch: Throwable -> L284
        r9.o = 1;     // Catch: Throwable -> L284
        r23 = TAG;
        r110 = "Total preCheckScript";
        Object r87 = a(r8, r34, r35, r86, r9);     // Catch: Throwable -> L279
        if (r87 != r10) goto L67;
        return r10;
    L67:
        r1 = this;
        r76 = r87;
        r6 = r23;
        r129 = r114;
        r30 = r110;
        r77 = r8;
        r74 = r85;
        r75 = r36;
    L279:
        th = th;
    L283:
        r6 = r23;
    L286:
        r28 = r114;
    L281:
        th = th;
        r23 = TAG;
        r110 = "Total preCheckScript";
        goto L283
    L50:
        if (r83.length() == 0) goto L53;
        r84 = false;
        goto L54
    L313:
    L38:
        th = th;
        r30 = "Total preCheckScript";
        r28 = r114;
        goto L30
    L35:
        if (r81.length() == 0) goto L40;
        r82 = false;
    L284:
        th = th;
        r110 = "Total preCheckScript";
    L7:
        r3 = new h(this, r2);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final x a(z.f r1, String r2) {
        d.h.b.o.e(r2, "it");
        r1.f38504a = r2;
        return x.f38692a;
    }

    private final Object a(Context r9, String r10, String r11, d.h.a.b<? super String, x> r12, d.c.d<? super d.m<com.obric.autogui.agents.scripted.impl.e.b, Boolean>> r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        d.h.a.b r15 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r16, f.class, "com.obric.aiagent.plugin");
        if ((r0.g & Integer.MIN_VALUE) == 0) goto L7;
        r0.g -= Integer.MIN_VALUE;
    L8:
        Object r17 = r0.f27072e;
        Object r2 = d.c.a.b.a();
        int r3 = r0.g;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        boolean r8 = r0.f27071d;
        com.obric.autogui.agents.scripted.impl.e.b r18 = (com.obric.autogui.agents.scripted.impl.e.b) ZeusTransformUtils.preCheckCast(r0.f27070c, com.obric.autogui.agents.scripted.impl.e.b.class, "com.obric.aiagent.plugin");
        r15 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r0.f27069b, d.h.a.b.class, "com.obric.aiagent.plugin");
        r r19 = (r) ZeusTransformUtils.preCheckCast(r0.f27068a, r.class, "com.obric.aiagent.plugin");
        d.o.a(r17);     // Catch: Exception -> L14
    L25:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L28;
        r15.invoke("initNewWorkerEnv returned false");     // Catch: Exception -> L14
        r19.f27051b.a(r18, false);     // Catch: Exception -> L14
        return null;
    L28:
        com.obric.autogui.agents.scripted.impl.e.b r110 = r18;
        boolean r20 = r8;
    L40:
        return new d.m(r110, d.c.b.a.b.a(r20));
    L14:
        Exception e2 = e;
    L32:
        if (ZeusTransformUtils.instanceOf(e2, CancellationException.class) == true) goto L38;
        String r111 = e2.getMessage();
        if (r111 != null) goto L36;
        r111 = "initNewWorkerEnv exception";
    L36:
        r15.invoke(r111);
        com.obric.autogui.agents.scripted.c.c.a(TAG, "Failed to initialize PreCheck JSWorker", (Throwable) ZeusTransformUtils.preCheckCast(e2, Throwable.class, "com.obric.aiagent.plugin"));
        r19.f27051b.a(r18, false);
        return null;
    L38:
        throw e2;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r17);
        d.m<com.obric.autogui.agents.scripted.impl.e.b, Boolean> r21 = this.f27051b.a(r14);
        r110 = (com.obric.autogui.agents.scripted.impl.e.b) ZeusTransformUtils.preCheckCast(r21.c(), com.obric.autogui.agents.scripted.impl.e.b.class, "com.obric.aiagent.plugin");
        r20 = ((Boolean) ZeusTransformUtils.preCheckCast(r21.d(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        JsWorker r4 = r110.a();
        if (r20 == false) goto L40;
        r0.f27068a = this;     // Catch: Exception -> L29
        r0.f27069b = r15;     // Catch: Exception -> L29
        r0.f27070c = r110;     // Catch: Exception -> L29
        r0.f27071d = r20;     // Catch: Exception -> L29
        r0.g = 1;     // Catch: Exception -> L29
        Object r112 = a(r4, r10, r11, r0);     // Catch: Exception -> L29
        if (r112 != r2) goto L23;
        return r2;
    L23:
        r19 = this;
        r8 = r20;
        r18 = r110;
        r17 = r112;
    L29:
        e = move-exception;
        r19 = this;
        e2 = e;
        r18 = r110;
    L7:
        r0 = new f(this, r16);
        goto L8
    }

    private final Object a(JsWorker r16, String r17, String r18, d.c.d<? super Boolean> r19) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, g.class) == false) goto L7;
        g r4 = (g) ZeusTransformUtils.preCheckCast(r2, g.class, "com.obric.aiagent.plugin");
        if ((r4.f & Integer.MIN_VALUE) == 0) goto L7;
        r4.f -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f27076d;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f;
        String r7 = TAG;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        long r8 = r4.f27075c;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r4.f27074b, String.class, "com.obric.aiagent.plugin");
        r7 = (String) ZeusTransformUtils.preCheckCast(r4.f27073a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L14
    L28:
        Boolean r0 = d.c.b.a.b.a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());     // Catch: Throwable -> L14
        long r9 = System.currentTimeMillis() - r8;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L32;
        Loog.INSTANCE.d(r7, r1 + " cost: " + r9 + "ms");
    L32:
        return r0;
    L14:
        th = th;
    L35:
        long r10 = System.currentTimeMillis() - r8;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L38;
        Loog.INSTANCE.d(r7, r1 + " cost: " + r10 + "ms");
    L38:
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r3);
        long r11 = System.currentTimeMillis();
        com.obric.autogui.agents.scripted.impl.a.f26972a.a(r16, r17, "auto-shortcut-engine.js");     // Catch: Throwable -> L39
        x r12 = x.f38692a;     // Catch: Throwable -> L39
        long r13 = System.currentTimeMillis() - r11;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L23;
        Loog.INSTANCE.d(TAG, "JS Engine init cost: " + r13 + "ms");
    L23:
        long r14 = System.currentTimeMillis();
        r4.f27073a = TAG;     // Catch: Throwable -> L33
        r4.f27074b = "JS initPreCheck";     // Catch: Throwable -> L33
        r4.f27075c = r14;     // Catch: Throwable -> L33
        r4.f = 1;     // Catch: Throwable -> L33
        Object r15 = a(r16, r18, r4);     // Catch: Throwable -> L33
        if (r15 != r5) goto L27;
        return r5;
    L27:
        r1 = "JS initPreCheck";
        r8 = r14;
        r3 = r15;
    L33:
        th = th;
        r1 = "JS initPreCheck";
        r8 = r14;
    L39:
        th = move-exception;
        long r20 = System.currentTimeMillis() - r11;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L43;
        Loog.INSTANCE.d(TAG, "JS Engine init cost: " + r20 + "ms");
    L43:
        throw th;
    L7:
        r4 = new g(this, r2);
        goto L8
    }

    private final Object a(JsWorker r10, String r11, d.c.d<? super Boolean> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r13, c.class, "com.obric.aiagent.plugin");
        if ((r0.f27058e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f27058e -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f27056c;
        Object r14 = d.c.a.b.a();
        int r2 = r0.f27058e;
        if (r2 == 0) goto L16;
        if (r2 != 1) goto L15;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r0.f27055b, String.class, "com.obric.aiagent.plugin");
        r10 = (JsWorker) ZeusTransformUtils.preCheckCast(r0.f27054a, JsWorker.class, "com.obric.aiagent.plugin");
        d.o.a(r9);     // Catch: Throwable -> L35
    L33:
        r10.setOnMessageCallback(null);
        r10.setOnErrorCallback(null);
        return r9;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r9);
        r0.f27054a = r10;     // Catch: Throwable -> L35
        r0.f27055b = r11;     // Catch: Throwable -> L35
        r0.f27058e = 1;     // Catch: Throwable -> L35
        kotlinx.coroutines.o r3 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin")), 1);     // Catch: Throwable -> L35
        r3.e();     // Catch: Throwable -> L35
        kotlinx.coroutines.n r16 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        final AtomicReference r4 = new AtomicReference(r16);     // Catch: Throwable -> L35
        r10.setOnMessageCallback((com.bytedance.vmsdk.worker.a) ZeusTransformUtils.preCheckCast(new ScriptPreCheckExecutor$executeInitPreCheck$2$1(r4), com.bytedance.vmsdk.worker.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L35
        r10.setOnErrorCallback((com.bytedance.vmsdk.worker.a) ZeusTransformUtils.preCheckCast(new ScriptPreCheckExecutor$executeInitPreCheck$2$2(r4), com.bytedance.vmsdk.worker.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L35
        com.obric.autogui.agents.scripted.impl.a.f26972a.a(r10, "AutoShortcutEngine.initPreCheck(" + new Gson().toJson(r11) + ')', "pre-check-bundle.js");     // Catch: Exception -> L20 Throwable -> L35
    L27:
        r16.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r4, r10), d.h.a.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L35
    L28:
        r9 = r3.h();     // Catch: Throwable -> L35
        if (r9 != d.c.a.b.a()) goto L31;
        d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L35
    L31:
        if (r9 != r14) goto L33;
        return r14;
    L20:
        e = move-exception;
        kotlinx.coroutines.n r5 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r4.getAndSet(null), kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        if (r5 == null) goto L28;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "evaluateJavaScript initPreCheck failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L35
        if (r5.a() == false) goto L27;
        d.n.a r6 = d.n.f38560a;     // Catch: Throwable -> L35
        r5.resumeWith(d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"))));     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        r10.setOnMessageCallback(null);
        r10.setOnErrorCallback(null);
        throw th;
    L7:
        r0 = new c(this, r13);
        goto L8
    }

    private final Object a(Context r5, String r6, d.c.d<? super String> r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.c.d<? super String> r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        JSONObject r0 = ICloudConfig.Companion.getSettingsConfig("obric_script_toggle_map");
        if (r0 == null) goto L7;
        String r1 = r0.toString();
        if (r1 == null) goto L7;
        JsonObject r2 = (JsonObject) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r1, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");
    L9:
        return a(r8, r6, r2, r9);
    L7:
        r2 = null;
        goto L9
    }

    private final Object a(Context r17, String r18, JsonObject r19, d.c.d<? super String> r20) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, i.class) == false) goto L7;
        i r4 = (i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin");
        if ((r4.h & Integer.MIN_VALUE) == 0) goto L7;
        r4.h -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.f;
        Object r6 = d.c.a.b.a();
        int r7 = r4.h;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        JsonObject r0 = (JsonObject) ZeusTransformUtils.preCheckCast(r4.f27087e, JsonObject.class, "com.obric.aiagent.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r4.f27086d, String.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r4.f27085c, String.class, "com.obric.aiagent.plugin");
        JsonObject r9 = (JsonObject) ZeusTransformUtils.preCheckCast(r4.f27084b, JsonObject.class, "com.obric.aiagent.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r4.f27083a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        JsonObject r12 = r0;
        String r11 = r2;
        String r15 = r10;
        String r13 = r8;
        JsonObject r14 = r9;
    L29:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(((com.obric.autogui.agents.vlm.models.impl.applist.b) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.agents.vlm.models.impl.applist.b.class, "com.obric.aiagent.plugin")).b(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r22 = r16.iterator();
    L31:
        if (r22.hasNext() == false) goto L35;
        String r23 = (String) ZeusTransformUtils.preCheckCast(d.a.i.b((String[]) ZeusTransformUtils.preCheckCast(r22.next(), String[].class, "com.obric.aiagent.plugin"), 1), String.class, "com.obric.aiagent.plugin");
        if (r23 == null) goto L31;
        r21.add(r23);
        goto L31
    L35:
        String r24 = new Gson().toJson(new com.obric.autogui.agents.scripted.a.h(r13, r11, r12, (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin"), r14, r15));
        d.h.b.o.c(r24, "toJson(...)");
        return r24;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r5);
        DisplayedAppInfo r25 = AutoActionVirtualDisplay.INSTANCE.fetchVdTopAppInfo();
        if (r25 == null) goto L19;
        ComponentName r26 = r25.getTopActivity();
        if (r26 == null) goto L19;
        String r27 = r26.getPackageName();
    L20:
        if (r25 == null) goto L24;
        ComponentName r28 = r25.getTopActivity();
        if (r28 == null) goto L24;
        String r29 = r28.getClassName();
    L25:
        JsonObject r30 = a(r1);
        com.obric.autogui.agents.vlm.models.impl.applist.b r31 = new com.obric.autogui.agents.vlm.models.impl.applist.b(r1);
        r4.f27083a = r18;
        r4.f27084b = r19;
        r4.f27085c = r27;
        r4.f27086d = r29;
        r4.f27087e = r30;
        r4.h = 1;
        Object r32 = r31.a(r4);
        if (r32 != r6) goto L28;
        return r6;
    L28:
        r12 = r30;
        r15 = r18;
        r11 = r29;
        r5 = r32;
        r13 = r27;
        r14 = r19;
    L24:
        r29 = null;
    L19:
        r27 = null;
    L7:
        r4 = new i(this, r3);
        goto L8
    }

    private final Object b(JsWorker r3, String r4, d.c.d<? super b> r5) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return dg.b(10000, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r3, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r2);
    }

    private final JsonObject a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        com.obric.autogui.util.d r6 = com.obric.autogui.util.d.f31513a.a(r5);
        Map<String, Object> r0 = r6.d();
        Map<String, Object> r1 = r6.e();
        Map<String, Object> r7 = r6.f();
        JsonObject r2 = new JsonObject();
        a(r2, r0);
        a(r2, r1);
        a(r2, r7);
        return r2;
    }

    public final void a(JsonObject r4, Map<String, ?> r5) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r3, "map");
        Iterator r6 = r3.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L20;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.aiagent.plugin");
        Object r8 = r7.getValue();
        if (ZeusTransformUtils.instanceOf(r8, String.class) == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r8, Number.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r8, Boolean.class) == true) goto L13;
        if (ZeusTransformUtils.instanceOf(r8, Character.class) == true) goto L16;
        if (r8 == null) goto L18;
        r4.addProperty(r1, r8.toString());
        goto L4
    L18:
        r4.addProperty(r1, null);
        goto L4
    L16:
        r4.addProperty(r1, (Character) ZeusTransformUtils.preCheckCast(r8, Character.class, "com.obric.aiagent.plugin"));
        goto L4
    L13:
        r4.addProperty(r1, (Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin"));
        goto L4
    L10:
        r4.addProperty(r1, (Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin"));
        goto L4
    L7:
        r4.addProperty(r1, (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin"));
        goto L4
    }
}
