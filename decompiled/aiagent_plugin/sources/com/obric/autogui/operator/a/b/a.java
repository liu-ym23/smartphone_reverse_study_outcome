package com.obric.autogui.operator.a.b;

import android.content.ComponentName;
import android.content.Context;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.executionengine.scheduler.api.IJobManagerApi;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.agents.vlm.models.omni.t;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.obric.autogui.operator.k;
import com.obric.capability.schedulekit.JobResultWrapper;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.n;
import d.s;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: OpBrowserUse.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.autogui.operator.b {
    private static final String TAG = "OpBrowserUse";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f29306a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final am f29307d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long[] f29308e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f29309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.autogui.operator.e f29310c;

    /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OpBrowserUse.kt */
    private static final class C0746a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0747a f29311a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f29312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f29313c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f29314d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final JsonObject f29315e;

        /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OpBrowserUse.kt */
        public static final class C0747a {
            public /* synthetic */ C0747a(d.h.b.h r1) {
                this();
            }

            private C0747a() {
            }

            public final C0746a a(JobResult r18, long r19) {
                if (r18 == null) goto L81;
                List<IntentExecutionRecord> r0 = r18.getExecRecords();
                if (r0 == null) goto L81;
                IntentExecutionRecord r1 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(p.l(r0), IntentExecutionRecord.class, "com.obric.aiagent.plugin");
                if (r1 == null) goto L81;
                IntentResult<?> r2 = r1.getResult();
                if (r2 == null) goto L81;
                String r10 = r2.getDetails();
                boolean r13 = true;
                if (r2.getRet() != 0) goto L13;
                boolean r4 = true;
            L14:
                String r15 = "execution_failed";
                if (r10 == null) goto L19;
                JsonObject r3 = C0746a.f29311a.a(r10);
                if (r3 == null) goto L19;
            L18:
                JsonObject r5 = r3;
                JsonElement r6 = r5.get("success");
                if (r6 != null) goto L31;
            L43:
                Boolean r7 = null;
            L45:
                if (r2.getRet() == 0) goto L47;
            L49:
                r13 = false;
            L50:
                r5.addProperty("success", Boolean.valueOf(r13));
                if (r5.has("elapsed_ms") == true) goto L53;
                r5.addProperty("elapsed_ms", (Number) ZeusTransformUtils.preCheckCast(Long.valueOf(r19), Number.class, "com.obric.aiagent.plugin"));
            L53:
                if (r13 == false) goto L55;
            L57:
                JsonElement r8 = r5.get(WsConstants.KEY_CONNECTION_ERROR);
                if (r8 != null) goto L60;
            L76:
                if (r13 == false) goto L79;
                r15 = null;
            L79:
                return new C0746a(r13, r2.getRet(), r15, r5);
            L60:
                if (r8.isJsonObject() == true) goto L63;
                r8 = null;
            L63:
                if (r8 == null) goto L76;
                JsonObject r9 = r8.getAsJsonObject();
                if (r9 == null) goto L76;
                JsonElement r11 = r9.get(MonitorConstants.CODE);
                if (r11 == null) goto L76;
                if (r11.isJsonPrimitive() == true) goto L72;
                r11 = null;
            L72:
                if (r11 == null) goto L76;
                String r12 = r11.getAsString();
                if (r12 == null) goto L76;
                r15 = r12;
                goto L79
            L55:
                if (r5.has("execution_state") == true) goto L57;
                r5.addProperty("execution_state", SensitiveType.UNKNOWN);
                goto L57
            L47:
                if (o.a(r7, false) == true) goto L49;
            L31:
                if (r6.isJsonPrimitive() == true) goto L34;
                r6 = null;
            L34:
                if (r6 == null) goto L43;
                n.a r14 = n.f38560a;     // Catch: Throwable -> L37
                Object r16 = n.f(Boolean.valueOf(r6.getAsBoolean()));     // Catch: Throwable -> L37
            L40:
                if (n.b(r16) == false) goto L42;
                r16 = null;
            L42:
                r7 = (Boolean) ZeusTransformUtils.preCheckCast(r16, Boolean.class, "com.obric.aiagent.plugin");
            L37:
                th = move-exception;
                n.a r17 = n.f38560a;
                r16 = n.f(d.o.a(th));
            L19:
                if (r4 == false) goto L21;
                String r20 = null;
            L22:
                if (r4 == false) goto L24;
                String r21 = null;
            L27:
                r3 = a(this, r4, r19, r20, r21, null, r10, 16, null);
                goto L18
            L24:
                if (r10 != null) goto L26;
                r21 = "Browser_Use returned empty details";
                goto L27
            L26:
                r21 = r10;
                goto L27
            L21:
                r20 = "execution_failed";
                goto L22
            L13:
                r4 = false;
            L81:
                return a(-1, "empty_result", "Browser_Use returned no execution record", r19, SensitiveType.UNKNOWN);
            }

            public final C0746a a(int r13, String r14, String r15, long r16, String r18) {
                o.e(r14, MonitorConstants.CODE);
                o.e(r15, "message");
                return new C0746a(false, r13, r14, a(this, false, r16, r14, r15, r18, null, 32, null));
            }

            private final JsonObject a(String r3) {
                n.a r1 = n.f38560a;     // Catch: Throwable -> L5
                C0747a r2 = (C0747a) ZeusTransformUtils.preCheckCast(this, C0747a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
                Object r4 = n.f((JsonObject) ZeusTransformUtils.preCheckCast(com.obric.autogui.util.b.f31495a.a().fromJson(r3, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
            L8:
                if (n.b(r4) == false) goto L11;
                r4 = null;
            L11:
                return (JsonObject) ZeusTransformUtils.preCheckCast(r4, JsonObject.class, "com.obric.aiagent.plugin");
            L5:
                th = move-exception;
                n.a r5 = n.f38560a;
                r4 = n.f(d.o.a(th));
                goto L8
            }

            static /* synthetic */ JsonObject a(C0747a r10, boolean r11, long r12, String r14, String r15, String r16, String r17, int r18, Object r19) {
                if ((r18 & 16) == 0) goto L5;
                String r8 = null;
            L7:
                if ((r18 & 32) == 0) goto L9;
                String r9 = null;
            L11:
                return r10.a(r11, r12, r14, r15, r8, r9);
            L9:
                r9 = r17;
                goto L11
            L5:
                r8 = r16;
                goto L7
            }

            private final JsonObject a(boolean r2, long r3, String r5, String r6, String r7, String r8) {
                JsonObject r1 = new JsonObject();
                r1.addProperty("success", Boolean.valueOf(r2));
                if (r7 == null) goto L5;
                r1.addProperty("execution_state", r7);
            L5:
                JsonObject r4 = new JsonObject();
                if (r8 == null) goto L8;
                r4.addProperty("raw_details", r8);
            L8:
                x r9 = x.f38692a;
                r1.add("data", (JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.aiagent.plugin"));
                r1.addProperty("elapsed_ms", (Number) ZeusTransformUtils.preCheckCast(Long.valueOf(r3), Number.class, "com.obric.aiagent.plugin"));
                if (r5 != null) goto L11;
                if (r6 != null) goto L11;
            L17:
                return r1;
            L11:
                JsonObject r10 = new JsonObject();
                if (r5 == null) goto L14;
                r10.addProperty(MonitorConstants.CODE, r5);
            L14:
                if (r6 == null) goto L16;
                r10.addProperty("message", r6);
            L16:
                x r11 = x.f38692a;
                r1.add(WsConstants.KEY_CONNECTION_ERROR, (JsonElement) ZeusTransformUtils.preCheckCast(r10, JsonElement.class, "com.obric.aiagent.plugin"));
                goto L17
            }
        }

        static {
            f29311a = new C0747a(null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0746a.class) == true) goto L8;
            return false;
        L8:
            C0746a r6 = (C0746a) ZeusTransformUtils.preCheckCast(r5, C0746a.class, "com.obric.aiagent.plugin");
            if (this.f29312b == r6.f29312b) goto L12;
            return false;
        L12:
            if (this.f29313c == r6.f29313c) goto L15;
            return false;
        L15:
            if (o.a(this.f29314d, r6.f29314d) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f29315e, r6.f29315e) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((Boolean.hashCode(this.f29312b) * 31) + Integer.hashCode(this.f29313c)) * 31;
            String r1 = this.f29314d;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.f29315e.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "BrowserUseExecutionResult(success=" + this.f29312b + ", ret=" + this.f29313c + ", errorCode=" + this.f29314d + ", payload=" + this.f29315e + ')';
        }

        public C0746a(boolean r2, int r3, String r4, JsonObject r5) {
            o.e(r5, "payload");
            this.f29312b = r2;
            this.f29313c = r3;
            this.f29314d = r4;
            this.f29315e = r5;
        }

        public final boolean a() {
            return this.f29312b;
        }

        public final int b() {
            return this.f29313c;
        }

        public final String c() {
            return this.f29314d;
        }

        public final JsonObject d() {
            return this.f29315e;
        }

        public final String e() {
            String r1 = this.f29315e.toString();
            o.c(r1, "toString(...)");
            return r1;
        }
    }

    /* JADX INFO: compiled from: OpBrowserUse.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f29316a = null;

        /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OpBrowserUse.kt */
        @d.c.b.a.f(b = "OpBrowserUse.kt", c = {378}, d = "ensureBrowserReadyInVirtualDisplay", e = "com.obric.autogui.operator.impl.op.OpBrowserUse$BrowserUseLocalExecutor")
        static final class C0748a extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f29317a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            long f29318b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f29319c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ b f29320d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f29321e;

            C0748a(b r3, d.c.d<? super C0748a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f29320d = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f29319c = r3;
                this.f29321e |= Integer.MIN_VALUE;
                return b.a(this.f29320d, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.a$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OpBrowserUse.kt */
        @d.c.b.a.f(b = "OpBrowserUse.kt", c = {251, 274}, d = "execute", e = "com.obric.autogui.operator.impl.op.OpBrowserUse$BrowserUseLocalExecutor")
        static final class C0749b extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f29322a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f29323b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f29324c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            long f29325d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            long f29326e;
            long f;
            /* synthetic */ Object g;
            final /* synthetic */ b h;
            int i;

            C0749b(b r3, d.c.d<? super C0749b> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.h = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                this.g = r4;
                this.i |= Integer.MIN_VALUE;
                return this.h.a(null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OpBrowserUse.kt */
        @d.c.b.a.f(b = "OpBrowserUse.kt", c = {453}, d = "invokeSuspend", e = "com.obric.autogui.operator.impl.op.OpBrowserUse$BrowserUseLocalExecutor$requestCancelChild$1")
        static final class c extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f29327a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f29328b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            long f29329c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            long f29330d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f29331e;
            int f;
            int g;
            final /* synthetic */ long h;
            final /* synthetic */ String i;
            private /* synthetic */ Object j;

            c(long r3, String r5, d.c.d<? super c> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.h = r3;
                this.i = r5;
                super(2, r7);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r5, d.c.d<?> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                c r0 = new c(this.h, this.i, r7);
                r0.j = r5;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0069 -> B:15:0x0082). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x007f -> B:15:0x0082). Please report as a decompilation issue!!! */
            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r20) {
                c r0 = this;
                Object r1 = d.c.a.b.a();
                int r2 = r0.g;
                int r3 = 1;
                String r4 = "com.obric.aiagent.plugin";
                if (r2 == 0) goto L8;
                if (r2 != 1) goto L7;
                long r5 = r0.f29330d;
                int r6 = r0.f;
                int r7 = r0.f29331e;
                long r8 = r0.f29329c;
                String r10 = (String) ZeusTransformUtils.preCheckCast(r0.f29328b, String.class, "com.obric.aiagent.plugin");
                long[] r11 = (long[]) ZeusTransformUtils.preCheckCast(r0.f29327a, long[].class, "com.obric.aiagent.plugin");
                am r12 = (am) ZeusTransformUtils.preCheckCast(r0.j, am.class, "com.obric.aiagent.plugin");
                d.o.a(r20);
            L15:
                am r13 = r12;
                long[] r14 = r11;
                String r15 = r10;
                long r9 = r8;
                int r16 = r7;
                long r17 = r5;
                int r18 = r6;
                Object r19 = r1;
                c r21 = r0;
                n.a r22 = n.f38560a;     // Catch: Throwable -> L21
                IJobManagerApi r23 = (IJobManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IJobManagerApi.class), IJobManagerApi.class, r4);     // Catch: Throwable -> L21
                x r110 = null;
                if (r23 == null) goto L19;
                r23.stopRunningAction(String.valueOf(r9), null, "Browser_Use", r15);     // Catch: Throwable -> L21
                r110 = x.f38692a;     // Catch: Throwable -> L21
            L19:
                Object r24 = n.f(r110);     // Catch: Throwable -> L21
            L23:
                Throwable r25 = n.c(r24);
                if (r25 == null) goto L27;
                Loog.INSTANCE.w(a.TAG, "cancel failed childQuestionId=" + r9 + " delayMs=" + r17 + " reason=" + r15 + " error=" + r25);
            L27:
                Loog.INSTANCE.i(a.TAG, "cancel requested childQuestionId=" + r9 + " delayMs=" + r17 + " reason=" + r15);
                r7 = r16 + 1;
                r0 = r21;
                r3 = 1;
                r6 = r18;
                r8 = r9;
                r10 = r15;
                r11 = r14;
                r12 = r13;
                r4 = r4;
                r1 = r19;
            L9:
                if (r7 >= r6) goto L29;
                r5 = r11[r7];
                if (r5 <= 0) goto L15;
                r0.j = r12;
                r0.f29327a = r11;
                r0.f29328b = r10;
                r0.f29329c = r8;
                r0.f29331e = r7;
                r0.f = r6;
                r0.f29330d = r5;
                r0.g = r3;
                if (ax.a(r5, r0) != r1) goto L15;
                return r1;
            L29:
                return x.f38692a;
            L21:
                th = move-exception;
                n.a r26 = n.f38560a;
                r24 = n.f(d.o.a(th));
                goto L23
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r20);
                am r27 = (am) ZeusTransformUtils.preCheckCast(r0.j, am.class, "com.obric.aiagent.plugin");
                long[] r28 = a.c();
                long r29 = r0.h;
                String r30 = r0.i;
                r12 = r27;
                r11 = r28;
                r6 = r28.length;
                r10 = r30;
                r7 = 0;
                r8 = r29;
                goto L9
            }
        }

        /* JADX INFO: compiled from: OpBrowserUse.kt */
        @d.c.b.a.f(b = "OpBrowserUse.kt", c = {398}, d = "waitUntilBrowserTopInVirtualDisplay", e = "com.obric.autogui.operator.impl.op.OpBrowserUse$BrowserUseLocalExecutor")
        static final class d extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f29332a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f29333b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f29334c;

            d(b r3, d.c.d<? super d> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f29333b = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f29332a = r3;
                this.f29334c |= Integer.MIN_VALUE;
                return b.a(this.f29333b, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OpBrowserUse.kt */
        @d.c.b.a.f(b = "OpBrowserUse.kt", c = {400}, d = "invokeSuspend", e = "com.obric.autogui.operator.impl.op.OpBrowserUse$BrowserUseLocalExecutor$waitUntilBrowserTopInVirtualDisplay$2")
        static final class e extends l implements m<am, d.c.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f29335a;

            e(d.c.d<? super e> r3) {
                super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(am r3, d.c.d<? super Boolean> r4) {
                return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
                return (d.c.d) ZeusTransformUtils.preCheckCast(new e((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f29335a;
                if (r1 == 0) goto L8;
                if (r1 == 1) goto L8;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
            L10:
                if (b.a(b.f29316a) == true) goto L15;
                d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f29335a = 1;
                if (ax.a(100, r7) != r0) goto L10;
                return r0;
            L15:
                return d.c.b.a.b.a(true);
            }
        }

        static {
            f29316a = new b();
        }

        public static /* synthetic */ String lambda$0BrERATCfJNx739_EGnOKWGu_p0(long r0, String r2) {
            return c(r0, r2);
        }

        /* JADX INFO: renamed from: lambda$GFQu8MV5oQTXMal-XXzFD2yOmAU, reason: not valid java name */
        public static /* synthetic */ String m825lambda$GFQu8MV5oQTXMalXXzFD2yOmAU(long r0, JsonObject r2) {
            return a(r0, r2);
        }

        public static /* synthetic */ String lambda$OFuqYH2YQA5AU1XyJU3m27wjULM(long r0, long r2, C0746a r4) {
            return b(r0, r2, r4);
        }

        public static /* synthetic */ String lambda$V3_5icdWsbYg2FPVRLMNL_DPiJI(long r0, long r2, C0746a r4) {
            return a(r0, r2, r4);
        }

        private b() {
        }

        public static final /* synthetic */ Object a(b r2, long r3, d.c.d r5) {
            return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ Object a(b r2, d.c.d r3) {
            return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ boolean a(b r0) {
            return r0.a();
        }

        public final Object a(JsonObject r27, long r28, d.c.d<? super C0746a> r30) {
            d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r30, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r3, C0749b.class) == false) goto L7;
            C0749b r5 = (C0749b) ZeusTransformUtils.preCheckCast(r3, C0749b.class, "com.obric.aiagent.plugin");
            if ((r5.i & Integer.MIN_VALUE) == 0) goto L7;
            r5.i -= Integer.MIN_VALUE;
        L8:
            Object r4 = r5.g;
            Object r15 = d.c.a.b.a();
            int r6 = r5.i;
            if (r6 == 0) goto L23;
            if (r6 == 1) goto L21;
            if (r6 != 2) goto L20;
            long r7 = r5.f;
            long r8 = r5.f29326e;
            long r0 = r5.f29325d;
            b r2 = (b) ZeusTransformUtils.preCheckCast(r5.f29322a, b.class, "com.obric.aiagent.plugin");
            d.o.a(r4);     // Catch: Exception -> L15 CancellationException -> L17
            b r9 = r2;
            long r12 = r7;
            long r21 = r8;
            JobResult r23 = null;
            Object r1 = r4;
            long r10 = r0;
            String r11 = a.TAG;
        L127:
            JobResultWrapper r13 = (JobResultWrapper) ZeusTransformUtils.preCheckCast(r1, JobResultWrapper.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L97 CancellationException -> L99
            if (r13 == null) goto L91;
            JobResult r14 = r13.getJobResult();     // Catch: Exception -> L97 CancellationException -> L99
        L92:
            final long r16 = AOSystemTools.INSTANCE.bootTimeMillis() - r21;     // Catch: Exception -> L97 CancellationException -> L99
            if (r14 != null) goto L95;
            r9.b(r12, "browser_use_timeout");     // Catch: Exception -> L97 CancellationException -> L99
            Loog.INSTANCE.w(r11, "timeout childQuestionId=" + r12 + " elapsedMs=" + r16);     // Catch: Exception -> L97 CancellationException -> L99
            return C0746a.f29311a.a(-1, "timeout", "Browser_Use did not return within " + r10 + "ms", r16, SensitiveType.UNKNOWN);
        L95:
            final C0746a r17 = C0746a.f29311a.a(r14, r16);     // Catch: Exception -> L97 CancellationException -> L99
            Loog r18 = Loog.INSTANCE;     // Catch: Exception -> L97 CancellationException -> L99
            final long r19 = r12;
            d.h.a.a<String> r20 = new $$Lambda$a$b$V3_5icdWsbYg2FPVRLMNL_DPiJI(r19, r16, r17);     // Catch: Exception -> L97 CancellationException -> L99
            final long r22 = r12;
            r18.ip(r11, r20, new $$Lambda$a$b$OFuqYH2YQA5AU1XyJU3m27wjULM(r22, r16, r17));     // Catch: Exception -> L97 CancellationException -> L99
            return r17;
        L91:
            r14 = r23;
        L99:
            e = e;
            r2 = r9;
            r7 = r12;
        L121:
            r2.b(r7, "browser_use_parent_cancelled");
            Loog.INSTANCE.i(r11, "cancelled childQuestionId=" + r7 + " reason=" + e.getMessage());
            throw e;
        L97:
            e = e;
            r2 = r9;
            r7 = r12;
        L112:
            r8 = r21;
        L113:
            long r110 = AOSystemTools.INSTANCE.bootTimeMillis() - r8;
            r2.b(r7, "browser_use_dispatch_failed");
            Loog.INSTANCE.e(r11, "execute failed childQuestionId=" + r7, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            C0746a.C0747a r111 = C0746a.f29311a;
            String r24 = e.getMessage();
            if (r24 != null) goto L117;
            r24 = "Browser_Use execution failed";
        L117:
            return r111.a(-1, "execution_failed", r24, r110, SensitiveType.UNKNOWN);
        L17:
            e = e;
        L18:
            r11 = a.TAG;
        L15:
            e = e;
        L16:
            r11 = a.TAG;
            goto L113
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L21:
            long r25 = r5.f29326e;
            long r26 = r5.f29325d;
            final String r29 = (String) ZeusTransformUtils.preCheckCast(r5.f29324c, String.class, "com.obric.aiagent.plugin");
            final JsonObject r112 = (JsonObject) ZeusTransformUtils.preCheckCast(r5.f29323b, JsonObject.class, "com.obric.aiagent.plugin");
            r2 = (b) ZeusTransformUtils.preCheckCast(r5.f29322a, b.class, "com.obric.aiagent.plugin");
            d.o.a(r4);
            long r210 = r25;
        L22:
            long r31 = r26;
            long r32 = r210;
            C0746a r33 = (C0746a) ZeusTransformUtils.preCheckCast(r4, C0746a.class, "com.obric.aiagent.plugin");
            if (r33 == null) goto L52;
            return r33;
        L52:
            final long r34 = r2.b();
            Loog.INSTANCE.ip(a.TAG, new $$Lambda$a$b$GFQu8MV5oQTXMalXXzFD2yOmAU(r34, r112), new $$Lambda$a$b$0BrERATCfJNx739_EGnOKWGu_p0(r34, r29));
            com.obric.autogui.session.a r35 = com.obric.autogui.session.c.f30777a.b();     // Catch: Exception -> L109 CancellationException -> L118
            if (r35 != null) goto L130;
        L63:
            String r36 = null;
        L64:
            com.obric.capability.schedulekit.a r37 = com.obric.capability.schedulekit.a.f31846a;     // Catch: Exception -> L109 CancellationException -> L118
            String r113 = r112.toString();     // Catch: Exception -> L109 CancellationException -> L118
        L66:
            if (r36 == null) goto L78;
            String r114 = a.TAG;
        L76:
            e = e;
            r7 = r34;
            r11 = r114;
        L74:
            e = e;
            r7 = r34;
            r8 = r32;
            r11 = r114;
            goto L113
        L69:
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r36, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L72;
            r36 = null;
        L72:
            if (r36 == null) goto L79;
            Map<String, String> r38 = ao.a(s.a("inner_log_id", r36));     // Catch: Exception -> L74 CancellationException -> L76
        L80:
            if (r38 != null) goto L123;
            r38 = ao.b();     // Catch: Exception -> L74 CancellationException -> L76
        L123:
            r5.f29322a = r2;     // Catch: Exception -> L105 CancellationException -> L107
            r5.f29323b = null;     // Catch: Exception -> L105 CancellationException -> L107
            r5.f29324c = null;     // Catch: Exception -> L105 CancellationException -> L107
            r5.f29325d = r31;     // Catch: Exception -> L105 CancellationException -> L107
            r5.f29326e = r32;     // Catch: Exception -> L105 CancellationException -> L107
            r5.f = r34;     // Catch: Exception -> L105 CancellationException -> L107
            r5.i = 2;     // Catch: Exception -> L105 CancellationException -> L107
            long r115 = r34;
            r21 = r32;
            r23 = null;
            r11 = r114;
            Object r39 = r37.a("Browser_Use", r113, r31, r115, "com.obric.browser", false, r38, r5);     // Catch: Exception -> L101 CancellationException -> L103
            if (r39 != r15) goto L87;
            return r15;
        L87:
            r9 = r2;
            r1 = r39;
            r12 = r115;
            r10 = r31;
            goto L127
        L103:
            e = e;
        L120:
            r7 = r115;
        L101:
            e = e;
        L111:
            r7 = r115;
            goto L112
        L107:
            e = e;
            r115 = r34;
            r11 = r114;
        L105:
            e = e;
            r115 = r34;
            r21 = r32;
            r11 = r114;
        L79:
            r38 = null;
            goto L80
        L78:
            r114 = a.TAG;
            goto L79
        L130:
            r r40 = t.f28523a.a(r35.b());     // Catch: Exception -> L59 CancellationException -> L61
            if (r40 == null) goto L63;
            r36 = r40.b();     // Catch: Exception -> L59 CancellationException -> L61
        L61:
            e = e;
            r7 = r34;
        L59:
            e = e;
            r7 = r34;
            r8 = r32;
        L118:
            e = e;
            r115 = r34;
            r11 = a.TAG;
        L109:
            e = e;
            r115 = r34;
            r21 = r32;
            r11 = a.TAG;
            goto L111
        L23:
            d.o.a(r4);
            long r41 = AOSystemTools.INSTANCE.bootTimeMillis();
            JsonElement r42 = r27.get("action");
            boolean r43 = false;
            if (r42 != null) goto L26;
        L36:
            r29 = null;
        L37:
            CharSequence r116 = (CharSequence) ZeusTransformUtils.preCheckCast(r29, CharSequence.class, "com.obric.aiagent.plugin");
            if (r116 != null) goto L40;
        L41:
            r43 = true;
        L42:
            if (r43 == true) goto L44;
            r5.f29322a = this;
            r5.f29323b = r27;
            r5.f29324c = r29;
            r26 = r28;
            r5.f29325d = r26;
            r5.f29326e = r41;
            r5.i = 1;
            Object r117 = a(r41, r5);
            if (r117 != r15) goto L48;
            return r15;
        L48:
            r210 = r41;
            r2 = this;
            r4 = r117;
            r112 = r27;
            goto L22
        L44:
            return a("invalid_params", "Browser_Use requires a non-empty action", r41);
        L40:
            if (d.o.o.d(r116) == false) goto L42;
        L26:
            if (r42.isJsonPrimitive() == true) goto L28;
        L30:
            boolean r118 = false;
        L31:
            if (r118 == true) goto L34;
            r42 = null;
        L34:
            if (r42 == null) goto L36;
            r29 = r42.getAsString();
            goto L37
        L28:
            if (r42.getAsJsonPrimitive().isString() == false) goto L30;
            r118 = true;
        L7:
            r5 = new C0749b(this, r3);
            goto L8
        }

        private static final String a(long r2, JsonObject r4) {
            return "dispatch childQuestionId=" + r2 + " logicalParams=" + com.obric.autogui.util.b.f31495a.a().toJson((JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.aiagent.plugin"));
        }

        private static final String c(long r2, String r4) {
            return "dispatch childQuestionId=" + r2 + " action=" + r4;
        }

        private static final String a(long r2, long r4, C0746a r6) {
            return "result childQuestionId=" + r2 + " elapsedMs=" + r4 + " payload=" + r6.d();
        }

        private static final String b(long r2, long r4, C0746a r6) {
            return "result childQuestionId=" + r2 + " elapsedMs=" + r4 + " success=" + r6.a() + " ret=" + r6.b() + " errorCode=" + r6.c();
        }

        private final Object a(long r20, d.c.d<? super C0746a> r22) {
            b r1 = this;
            long r2 = r20;
            d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r0, C0748a.class) == false) goto L7;
            C0748a r5 = (C0748a) ZeusTransformUtils.preCheckCast(r0, C0748a.class, "com.obric.aiagent.plugin");
            if ((r5.f29321e & Integer.MIN_VALUE) == 0) goto L7;
            r5.f29321e -= Integer.MIN_VALUE;
        L8:
            Object r3 = r5.f29319c;
            Object r6 = d.c.a.b.a();
            int r7 = r5.f29321e;
            String r8 = "Failed to prepare Browser in virtual display";
            if (r7 == 0) goto L18;
            if (r7 != 1) goto L17;
            long r4 = r5.f29318b;
            b r9 = (b) ZeusTransformUtils.preCheckCast(r5.f29317a, b.class, "com.obric.aiagent.plugin");
            d.o.a(r3);     // Catch: Exception -> L14 CancellationException -> L73
            r1 = r9;
            r2 = r4;
        L61:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L63;
            Loog.INSTANCE.i(a.TAG, "browser became ready in virtual display");     // Catch: Exception -> L66 CancellationException -> L73
            return null;
        L63:
            return r1.a(r2, "Browser did not become ready in virtual display within 3000ms");
        L14:
            e = e;
            r1 = r9;
            r2 = r4;
        L67:
            String r10 = e.getMessage();
            if (r10 == null) goto L72;
            r8 = r10;
        L72:
            return r1.a(r2, r8);
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            d.o.a(r3);
        L66:
            e = e;
            goto L67
        L20:
            if (a() == false) goto L23;
            Loog.INSTANCE.i(a.TAG, "browser is already ready in virtual display");     // Catch: Exception -> L66 CancellationException -> L73
            return null;
        L23:
            char r12 = 0;
            Collection<DisplayedAppInfo> r11 = AutoActionVirtualDisplay.INSTANCE.fetchMdTopAppInfo(20, false);     // Catch: Exception -> L66 CancellationException -> L73
            if (r11 == null) goto L46;
            Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L66 CancellationException -> L73
        L28:
            if (r13.hasNext() == false) goto L44;
            Object r14 = r13.next();     // Catch: Exception -> L66 CancellationException -> L73
            DisplayedAppInfo r15 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(r14, DisplayedAppInfo.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L66 CancellationException -> L73
            ComponentName[] r16 = new ComponentName[3];     // Catch: Exception -> L66 CancellationException -> L73
            r16[r12] = r15.getTopActivity();     // Catch: Exception -> L66 CancellationException -> L73
            r16[1] = r15.getBaseActivity();     // Catch: Exception -> L66 CancellationException -> L73
            r16[2] = r15.getRealActivity();     // Catch: Exception -> L66 CancellationException -> L73
            Iterator r17 = d.n.m.a(r16).a();     // Catch: Exception -> L66 CancellationException -> L73
        L31:
            if (r17.hasNext() == false) goto L40;
            ComponentName r18 = (ComponentName) ZeusTransformUtils.preCheckCast(r17.next(), ComponentName.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L66 CancellationException -> L73
            if (r18 == null) goto L35;
            String r19 = r18.getPackageName();     // Catch: Exception -> L66 CancellationException -> L73
        L37:
            if (o.a(r19, "com.obric.browser") == false) goto L31;
            boolean r110 = true;
        L41:
            if (r110 == true) goto L45;
            r12 = 0;
        L45:
            DisplayedAppInfo r21 = (DisplayedAppInfo) ZeusTransformUtils.preCheckCast(r14, DisplayedAppInfo.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L66 CancellationException -> L73
        L47:
            if (r21 == null) goto L49;
            Loog.INSTANCE.i(a.TAG, "bring browser task to virtual display taskId=" + r21.getTaskId());     // Catch: Exception -> L66 CancellationException -> L73
            com.obric.autogui.common.e r23 = AutoActionVirtualDisplay.INSTANCE.bringMdAppToVd(r21.getTaskId());     // Catch: Exception -> L66 CancellationException -> L73
        L51:
            if (r23.g() == true) goto L57;
            CharSequence r24 = (CharSequence) ZeusTransformUtils.preCheckCast(r23.h(), CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L66 CancellationException -> L73
            if (d.o.o.d(r24) == false) goto L56;
            r24 = "Failed to prepare Browser in virtual display";
        L56:
            return r1.a(r2, (String) ZeusTransformUtils.preCheckCast(r24, String.class, "com.obric.aiagent.plugin"));
        L57:
            r5.f29317a = r1;     // Catch: Exception -> L66 CancellationException -> L73
            r5.f29318b = r2;     // Catch: Exception -> L66 CancellationException -> L73
            r5.f29321e = 1;     // Catch: Exception -> L66 CancellationException -> L73
            r3 = r1.a(r5);     // Catch: Exception -> L66 CancellationException -> L73
            if (r3 != r6) goto L61;
            return r6;
        L49:
            Loog.INSTANCE.i(a.TAG, "open browser in virtual display");     // Catch: Exception -> L66 CancellationException -> L73
            r23 = AutoActionVirtualDisplay.INSTANCE.openAppInVd("com.obric.browser");     // Catch: Exception -> L66 CancellationException -> L73
            goto L51
        L35:
            r19 = null;
            goto L37
        L40:
            r110 = false;
            goto L41
        L44:
            r14 = null;
            goto L45
        L46:
            r21 = null;
        L73:
            e = move-exception;
            throw e;
        L7:
            r5 = new C0748a(r1, r0);
            goto L8
        }

        private final Object a(d.c.d<? super Boolean> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r8, d.class) == false) goto L7;
            d r0 = (d) ZeusTransformUtils.preCheckCast(r8, d.class, "com.obric.aiagent.plugin");
            if ((r0.f29334c & Integer.MIN_VALUE) == 0) goto L7;
            r0.f29334c -= Integer.MIN_VALUE;
        L8:
            Object r6 = r0.f29332a;
            Object r9 = d.c.a.b.a();
            int r2 = r0.f29334c;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            d.o.a(r6);
        L18:
            return d.c.b.a.b.a(o.a(r6, d.c.b.a.b.a(true)));
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r6);
            m r10 = (m) ZeusTransformUtils.preCheckCast(new e(null), m.class, "com.obric.aiagent.plugin");
            r0.f29334c = 1;
            r6 = dg.b(WsConstants.EXIT_DELAY_TIME, r10, r0);
            if (r6 != r9) goto L18;
            return r9;
        L7:
            r0 = new d(this, r8);
            goto L8
        }

        private final boolean a() {
            ComponentName r2 = (ComponentName) ZeusTransformUtils.preCheckCast(AutoActionVirtualDisplay.INSTANCE.getVdTopComponent().a(), ComponentName.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L5;
            String r3 = r2.getPackageName();
        L7:
            return o.a(r3, "com.obric.browser");
        L5:
            r3 = null;
            goto L7
        }

        private final C0746a a(long r8, String r10) {
            return C0746a.f29311a.a(-1, "browser_virtual_display_not_ready", r10, AOSystemTools.INSTANCE.bootTimeMillis() - r8, "not_started");
        }

        private final C0746a a(String r8, String r9, long r10) {
            return C0746a.f29311a.a(-1, r8, r9, AOSystemTools.INSTANCE.bootTimeMillis() - r10, "not_started");
        }

        private final long b() {
            Long r4 = Long.valueOf(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
            if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).longValue() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L9;
            r4 = null;
        L9:
            if (r4 != null) goto L13;
            return 1;
        L13:
            return r4.longValue();
        L5:
            r0 = false;
            goto L6
        }

        private final void b(long r7, String r9) {
            i.a(a.b(), null, null, (m) ZeusTransformUtils.preCheckCast(new c(r7, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        }
    }

    /* JADX INFO: compiled from: OpBrowserUse.kt */
    private static final class c implements com.obric.autogui.operator.c, k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0750a f29336b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final C0746a f29337c;

        /* JADX INFO: renamed from: com.obric.autogui.operator.a.b.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OpBrowserUse.kt */
        public static final class C0750a {
            public /* synthetic */ C0750a(d.h.b.h r1) {
                this();
            }

            private C0750a() {
            }

            public final c a() {
                return new c(C0746a.f29311a.a(-1, "invalid_params", "Browser_Use operation input is missing", 0, "not_started"));
            }
        }

        static {
            f29336b = new C0750a(null);
        }

        public c(C0746a r2) {
            o.e(r2, "result");
            this.f29337c = r2;
        }

        @Override // com.obric.autogui.operator.c
        public com.obric.autogui.operator.c.EnumC0779c c() {
            return com.obric.autogui.operator.c.b.b(this);
        }

        @Override // com.obric.autogui.operator.c
        public boolean a() {
            return !this.f29337c.a();
        }

        @Override // com.obric.autogui.operator.c
        public int b() {
            boolean r1 = false;
            if (this.f29337c.a() == true) goto L16;
            Integer r3 = Integer.valueOf(this.f29337c.b());
            if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue() == 0) goto L8;
            r1 = true;
        L8:
            if (r1 == true) goto L11;
            r3 = null;
        L11:
            if (r3 != null) goto L15;
            return -1;
        L15:
            return r3.intValue();
        L16:
            return 0;
        }

        @Override // com.obric.autogui.operator.c
        public String d() {
            return this.f29337c.c();
        }

        @Override // com.obric.autogui.operator.c
        public String e() {
            String r1 = this.f29337c.d().toString();
            o.c(r1, "toString(...)");
            return r1;
        }

        @Override // com.obric.autogui.operator.k
        public String a(Context r3) {
            o.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "context");
            return this.f29337c.e();
        }
    }

    /* JADX INFO: compiled from: OpBrowserUse.kt */
    public static final class d {
        public /* synthetic */ d(d.h.b.h r1) {
            this();
        }

        private d() {
        }
    }

    /* JADX INFO: compiled from: OpBrowserUse.kt */
    public static final class e implements com.obric.autogui.operator.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JsonObject f29338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f29339b;

        public static /* synthetic */ e a(e r0, JsonObject r1, long r2, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.f29338a;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.f29339b;
        L9:
            return r0.a(r1, r2);
        }

        public final e a(JsonObject r1, long r2) {
            o.e(r1, "params");
            return new e(r1, r2);
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, e.class) == true) goto L8;
            return false;
        L8:
            e r8 = (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29338a, r8.f29338a) == true) goto L12;
            return false;
        L12:
            if (this.f29339b == r8.f29339b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f29338a.hashCode() * 31) + Long.hashCode(this.f29339b);
        }

        public String toString() {
            return "Input(params=" + this.f29338a + ", timeoutMillis=" + this.f29339b + ')';
        }

        public e(JsonObject r2, long r3) {
            o.e(r2, "params");
            this.f29338a = r2;
            this.f29339b = r3;
        }

        public /* synthetic */ e(JsonObject r1, long r2, int r4, d.h.b.h r5) {
            if ((r4 & 2) == 0) goto L5;
            r2 = 45000;
        L5:
            this(r1, r2);
        }

        public final JsonObject a() {
            return this.f29338a;
        }

        public final long b() {
            return this.f29339b;
        }
    }

    /* JADX INFO: compiled from: OpBrowserUse.kt */
    @d.c.b.a.f(b = "OpBrowserUse.kt", c = {68}, d = "perform", e = "com.obric.autogui.operator.impl.op.OpBrowserUse")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f29340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f29341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f29342c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f29343d;

        f(a r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f29342c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f29341b = r3;
            this.f29343d |= Integer.MIN_VALUE;
            return this.f29342c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final /* synthetic */ am b() {
        return f29307d;
    }

    public static final /* synthetic */ long[] c() {
        return f29308e;
    }

    private a(e r1) {
        this.f29309b = r1;
    }

    public a() {
        this(null);
    }

    @Override // com.obric.autogui.operator.b
    public com.obric.autogui.operator.b a(com.obric.autogui.operator.b.a r9) {
        com.obric.autogui.operator.b.a r8 = (com.obric.autogui.operator.b.a) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.autogui.operator.b.a.class, "com.obric.aiagent.plugin");
        o.e(r8, "input");
        a r1 = null;
        if (ZeusTransformUtils.instanceOf(r8, e.class) == false) goto L5;
        e r2 = (e) ZeusTransformUtils.preCheckCast(r8, e.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 == null) goto L9;
        JsonObject r3 = r2.a().deepCopy();
        o.c(r3, "deepCopy(...)");
        r1 = new a(e.a(r2, r3, 0, 2, null));
    L9:
        return (com.obric.autogui.operator.b) ZeusTransformUtils.preCheckCast(r1, com.obric.autogui.operator.b.class, "com.obric.aiagent.plugin");
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.obric.autogui.operator.b
    public void a(com.obric.autogui.operator.e r2) {
        o.e(r2, "step");
        this.f29310c = r2;
    }

    @Override // com.obric.autogui.operator.b
    public void b(com.obric.autogui.operator.e r2) {
        o.e(r2, "step");
        if (this.f29310c != r2) goto L6;
        this.f29310c = null;
        return;
    }

    @Override // com.obric.autogui.operator.b
    public Object a(Context r8, d.c.d<? super com.obric.autogui.operator.c> r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, f.class) == false) goto L7;
        f r12 = (f) ZeusTransformUtils.preCheckCast(r11, f.class, "com.obric.aiagent.plugin");
        if ((r12.f29343d & Integer.MIN_VALUE) == 0) goto L7;
        r12.f29343d -= Integer.MIN_VALUE;
    L8:
        Object r13 = r12.f29341b;
        Object r0 = d.c.a.b.a();
        int r2 = r12.f29343d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        a this = (a) ZeusTransformUtils.preCheckCast(r12.f29340a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
    L21:
        C0746a r14 = (C0746a) ZeusTransformUtils.preCheckCast(r13, C0746a.class, "com.obric.aiagent.plugin");
        com.obric.autogui.operator.e r7 = this.f29310c;
        if (ZeusTransformUtils.instanceOf(r7, com.obric.autogui.agents.vlm.models.impl.g.class) == false) goto L24;
        com.obric.autogui.agents.vlm.models.impl.g r15 = (com.obric.autogui.agents.vlm.models.impl.g) ZeusTransformUtils.preCheckCast(r7, com.obric.autogui.agents.vlm.models.impl.g.class, "com.obric.aiagent.plugin");
    L25:
        if (r15 == null) goto L28;
        r15.i(r14.e());
    L28:
        return new c(r14);
    L24:
        r15 = null;
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r13);
        e r16 = this.f29309b;
        if (r16 == null) goto L17;
        b r3 = b.f29316a;
        JsonObject r4 = r16.a();
        long r5 = r16.b();
        r12.f29340a = this;
        r12.f29343d = 1;
        r13 = r3.a(r4, r5, r12);
        if (r13 != r0) goto L21;
        return r0;
    L17:
        return c.f29336b.a();
    L7:
        r12 = new f(this, r11);
        goto L8
    }

    static {
        f29306a = new d(null);
        f29307d = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.a(), d.c.g.class, "com.obric.aiagent.plugin")));
        f29308e = new long[]{0, 100, 500};
    }
}
