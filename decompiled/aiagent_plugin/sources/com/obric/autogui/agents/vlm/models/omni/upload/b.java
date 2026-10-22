package com.obric.autogui.agents.vlm.models.omni.upload;

import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.IFlowNetworkIDL;
import com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.entity.app.EntityType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.h.b.aa;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: IpcOmniDataFeedbackUploader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "IpcOmniUploadDataUploader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28576a = null;
    private static final Set<String> f = null;
    private static final Set<String> g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.a<IFlowNetworkIDL> f28577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f28578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.a<Long> f28579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.b<m.a, d.x> f28580e;

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.omni.upload.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: IpcOmniDataFeedbackUploader.kt */
    /* synthetic */ class AnonymousClass1 extends d.h.b.l implements d.h.a.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f28581a = null;

        static {
            f28581a = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(0, SystemClock.class, "elapsedRealtime", "elapsedRealtime()J", 0);
        }

        public final Long a() {
            return Long.valueOf(SystemClock.elapsedRealtime());
        }

        @Override // d.h.a.a
        public /* synthetic */ Long invoke() {
            return a();
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.omni.upload.b$2, reason: invalid class name */
    /* JADX INFO: compiled from: IpcOmniDataFeedbackUploader.kt */
    /* synthetic */ class AnonymousClass2 extends d.h.b.l implements d.h.a.b<m.a, d.x> {
        AnonymousClass2(Object r8) {
            super(1, r8, m.class, "report", "report(Lcom/obric/autogui/agents/vlm/models/omni/upload/OmniScreenshotUploadTelemetry$Event;)V", 0);
        }

        public final void a(m.a r3) {
            d.h.b.o.e(r3, "p0");
            ((m) ZeusTransformUtils.preCheckCast(this.receiver, m.class, "com.obric.aiagent.plugin")).a(r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(m.a r3) {
            a((m.a) ZeusTransformUtils.preCheckCast(r3, m.a.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: IpcOmniDataFeedbackUploader.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.omni.upload.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IpcOmniDataFeedbackUploader.kt */
    private static final class C0714b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.agents.vlm.models.omni.a.i f28582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f28583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f28584c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Integer f28585d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f28586e;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0714b.class) == true) goto L8;
            return false;
        L8:
            C0714b r6 = (C0714b) ZeusTransformUtils.preCheckCast(r5, C0714b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f28582a, r6.f28582a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f28583b, r6.f28583b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f28584c, r6.f28584c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f28585d, r6.f28585d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f28586e, r6.f28586e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f28582a.hashCode() * 31) + this.f28583b.hashCode()) * 31;
            String r1 = this.f28584c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Integer r5 = this.f28585d;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.f28586e;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "HostUploadOutcome(result=" + this.f28582a + ", reasonCode=" + this.f28583b + ", failureStage=" + this.f28584c + ", serverCode=" + this.f28585d + ", exceptionType=" + this.f28586e + ')';
        }

        public C0714b(com.obric.autogui.agents.vlm.models.omni.a.i r2, String r3, String r4, Integer r5, String r6) {
            d.h.b.o.e(r2, "result");
            d.h.b.o.e(r3, "reasonCode");
            this.f28582a = r2;
            this.f28583b = r3;
            this.f28584c = r4;
            this.f28585d = r5;
            this.f28586e = r6;
        }

        public /* synthetic */ C0714b(com.obric.autogui.agents.vlm.models.omni.a.i r8, String r9, String r10, Integer r11, String r12, int r13, d.h.b.h r14) {
            if ((r13 & 4) == 0) goto L5;
            String r4 = null;
        L7:
            if ((r13 & 8) == 0) goto L9;
            Integer r5 = null;
        L11:
            if ((r13 & 16) == 0) goto L13;
            String r6 = null;
        L14:
            this(r8, r9, r4, r5, r6);
            return;
        L13:
            r6 = r12;
            goto L14
        L9:
            r5 = r11;
            goto L11
        L5:
            r4 = r10;
            goto L7
        }

        public final com.obric.autogui.agents.vlm.models.omni.a.i a() {
            return this.f28582a;
        }

        public final String b() {
            return this.f28583b;
        }

        public final String c() {
            return this.f28584c;
        }

        public final Integer d() {
            return this.f28585d;
        }

        public final String e() {
            return this.f28586e;
        }
    }

    /* JADX INFO: compiled from: IpcOmniDataFeedbackUploader.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.autogui.agents.vlm.models.omni.a.c f28588b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f28589c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f28590d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f28591e;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
            return false;
        L8:
            c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f28587a, r10.f28587a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f28588b, r10.f28588b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f28589c, r10.f28589c) == true) goto L18;
            return false;
        L18:
            if (this.f28590d == r10.f28590d) goto L21;
            return false;
        L21:
            if (this.f28591e == r10.f28591e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f28587a.hashCode() * 31) + this.f28588b.hashCode()) * 31) + this.f28589c.hashCode()) * 31) + Long.hashCode(this.f28590d)) * 31) + Integer.hashCode(this.f28591e);
        }

        public String toString() {
            return "UploadAttemptContext(taskId=" + this.f28587a + ", request=" + this.f28588b + ", payloadMode=" + this.f28589c + ", payloadSizeBytes=" + this.f28590d + ", retryIndex=" + this.f28591e + ')';
        }

        public c(String r2, com.obric.autogui.agents.vlm.models.omni.a.c r3, String r4, long r5, int r7) {
            d.h.b.o.e(r2, DBDefinition.TASK_ID);
            d.h.b.o.e(r3, Ext.KEY_REQUEST);
            d.h.b.o.e(r4, "payloadMode");
            this.f28587a = r2;
            this.f28588b = r3;
            this.f28589c = r4;
            this.f28590d = r5;
            this.f28591e = r7;
        }

        public final String a() {
            return this.f28587a;
        }

        public final com.obric.autogui.agents.vlm.models.omni.a.c b() {
            return this.f28588b;
        }

        public final String c() {
            return this.f28589c;
        }

        public final long d() {
            return this.f28590d;
        }

        public final int e() {
            return this.f28591e;
        }
    }

    /* JADX INFO: compiled from: IpcOmniDataFeedbackUploader.kt */
    @d.c.b.a.f(b = "IpcOmniDataFeedbackUploader.kt", c = {EntityType.AUDITORY_RECORDING}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.IpcOmniDataFeedbackUploader$uploadGroupedViaHost$2")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super C0714b>, Object> {
        final /* synthetic */ String A;
        final /* synthetic */ String B;
        final /* synthetic */ b C;
        final /* synthetic */ c D;
        final /* synthetic */ long E;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28594c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f28595d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f28596e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        Object k;
        Object l;
        Object m;
        int n;
        long o;
        int p;
        final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.a.c q;
        final /* synthetic */ IFlowNetworkIDL r;
        final /* synthetic */ String s;
        final /* synthetic */ String t;
        final /* synthetic */ int u;
        final /* synthetic */ String v;
        final /* synthetic */ String w;
        final /* synthetic */ String x;
        final /* synthetic */ String y;
        final /* synthetic */ String z;

        /* JADX INFO: compiled from: IpcOmniDataFeedbackUploader.kt */
        static final class a implements d.h.a.b<Throwable, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f28597a;

            a(AtomicBoolean r1) {
                this.f28597a = r1;
            }

            public final void a(Throwable r2) {
                this.f28597a.compareAndSet(false, true);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(Throwable r3) {
                a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }
        }

        d(com.obric.autogui.agents.vlm.models.omni.a.c r6, IFlowNetworkIDL r7, String r8, String r9, int r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, b r18, c r19, long r20, d.c.d<? super d> r22) {
            IFlowNetworkIDL r1 = (IFlowNetworkIDL) ZeusTransformUtils.wrapperContextForParams(r7, IFlowNetworkIDL.class, "com.obric.aiagent.plugin");
            d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
            this.q = r6;
            this.r = r1;
            this.s = r8;
            this.t = r9;
            this.u = r10;
            this.v = r11;
            this.w = r12;
            this.x = r13;
            this.y = r14;
            this.z = r15;
            this.A = r16;
            this.B = r17;
            this.C = r18;
            this.D = r19;
            this.E = r20;
            super(2, r2);
        }

        public final Object a(am r3, d.c.d<? super C0714b> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r22, d.c.d<?> r23) {
            d.c.d r20 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, r20), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super C0714b> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, kotlinx.coroutines.o] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v9 */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r38) {
            Object r2 = d.c.a.b.a();
            int r0 = this.p;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            c r1 = (c) ZeusTransformUtils.preCheckCast(this.m, c.class, "com.obric.aiagent.plugin");
            b r3 = (b) ZeusTransformUtils.preCheckCast(this.l, b.class, "com.obric.aiagent.plugin");
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.k, String.class, "com.obric.aiagent.plugin");
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.j, String.class, "com.obric.aiagent.plugin");
            String r6 = (String) ZeusTransformUtils.preCheckCast(this.i, String.class, "com.obric.aiagent.plugin");
            String r7 = (String) ZeusTransformUtils.preCheckCast(this.h, String.class, "com.obric.aiagent.plugin");
            String r8 = (String) ZeusTransformUtils.preCheckCast(this.g, String.class, "com.obric.aiagent.plugin");
            String r9 = (String) ZeusTransformUtils.preCheckCast(this.f, String.class, "com.obric.aiagent.plugin");
            String r10 = (String) ZeusTransformUtils.preCheckCast(this.f28596e, String.class, "com.obric.aiagent.plugin");
            String r11 = (String) ZeusTransformUtils.preCheckCast(this.f28595d, String.class, "com.obric.aiagent.plugin");
            String r12 = (String) ZeusTransformUtils.preCheckCast(this.f28594c, String.class, "com.obric.aiagent.plugin");
            IFlowNetworkIDL r13 = (IFlowNetworkIDL) ZeusTransformUtils.preCheckCast(this.f28593b, IFlowNetworkIDL.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.omni.a.c r14 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(this.f28592a, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
            d.o.a(r38);
            return r38;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r38);
            final com.obric.autogui.agents.vlm.models.omni.a.c r15 = this.q;
            IFlowNetworkIDL r16 = this.r;
            String r17 = this.s;
            String r18 = this.t;
            int r19 = this.u;
            String r110 = this.v;
            String r111 = this.w;
            String r20 = this.x;
            String r21 = this.y;
            String r22 = this.z;
            String r23 = this.A;
            String r24 = this.B;
            final b r25 = this.C;
            final c r26 = this.D;
            final long r27 = this.E;
            this.f28592a = r15;
            this.f28593b = r16;
            this.f28594c = r17;
            this.f28595d = r18;
            this.f28596e = r110;
            this.f = r111;
            this.g = r20;
            this.h = r21;
            this.i = r22;
            this.j = r23;
            this.k = r24;
            this.l = r25;
            this.m = r26;
            this.n = r19;
            this.o = r27;
            this.p = 1;
            b r28 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")), 1);
            r28.e();
            kotlinx.coroutines.n r29 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r28, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
            AtomicBoolean r30 = new AtomicBoolean(false);
            r29.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r30), d.h.a.b.class, "com.obric.aiagent.plugin"));
            final AtomicBoolean r210 = r30;
            final String r211 = r24;
            final kotlinx.coroutines.n r39 = r29;
            IFlowNetworkResultCallbackIDL.Stub r31 = new IpcOmniDataFeedbackUploader$uploadGroupedViaHost$2$1$callback$1(r25, r39, r210, r15, r26, r27, r211);     // Catch: Throwable -> L60
            Boolean r32 = r15.e();     // Catch: Throwable -> L60
            if (r32 != null) goto L36;
            String r33 = r15.g().a();     // Catch: Throwable -> L60
            com.obric.autogui.agents.vlm.models.omni.a.e r34 = r15.c();     // Catch: Throwable -> L60
            if (r34 == null) goto L16;
            String r35 = r34.a();     // Catch: Throwable -> L60
        L17:
            com.obric.aiagent.assistant.idl.bean.c r36 = com.obric.aiagent.assistant.idl.bean.c.f16269a;     // Catch: Throwable -> L60
            com.obric.autogui.agents.vlm.models.omni.a.e r37 = r15.c();     // Catch: Throwable -> L60
            if (r37 == null) goto L20;
            List<String> r40 = r37.b();     // Catch: Throwable -> L60
        L21:
            com.obric.autogui.agents.vlm.models.omni.a.e r41 = r15.c();     // Catch: Throwable -> L60
            if (r41 == null) goto L24;
            Integer r42 = r41.f();     // Catch: Throwable -> L60
        L25:
            List<String> r310 = r36.a(r40, r42);     // Catch: Throwable -> L60
            com.obric.autogui.agents.vlm.models.omni.a.e r43 = r15.c();     // Catch: Throwable -> L60
            if (r43 == null) goto L28;
            String r311 = r43.getType();     // Catch: Throwable -> L60
        L29:
            com.obric.autogui.agents.vlm.models.omni.a.e r44 = r15.c();     // Catch: Throwable -> L60
            if (r44 == null) goto L32;
            String r45 = r44.d();     // Catch: Throwable -> L60
        L33:
            kotlinx.coroutines.o r312 = r28;
            r16.uploadOmniDataFeedbackByHttp(r17, r18, r19, r110, r111, r20, r21, r22, r23, r33, r35, r310, r311, r45, (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.preCheckCast(r31, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L58
        L65:
            Object r46 = r312.h();
            if (r46 != d.c.a.b.a()) goto L69;
            d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        L69:
            if (r46 != r2) goto L77;
            return r2;
        L77:
            return r46;
        L32:
            r45 = null;
            goto L33
        L28:
            r311 = null;
            goto L29
        L24:
            r42 = null;
            goto L25
        L20:
            r40 = null;
            goto L21
        L16:
            r35 = null;
            goto L17
        L36:
            r312 = r28;
            String r212 = r15.g().a();     // Catch: Throwable -> L58
            com.obric.autogui.agents.vlm.models.omni.a.e r47 = r15.c();     // Catch: Throwable -> L58
            if (r47 == null) goto L39;
            String r313 = r47.a();     // Catch: Throwable -> L58
        L40:
            com.obric.aiagent.assistant.idl.bean.c r48 = com.obric.aiagent.assistant.idl.bean.c.f16269a;     // Catch: Throwable -> L58
            com.obric.autogui.agents.vlm.models.omni.a.e r49 = r15.c();     // Catch: Throwable -> L58
            if (r49 == null) goto L43;
            List<String> r50 = r49.b();     // Catch: Throwable -> L58
        L44:
            com.obric.autogui.agents.vlm.models.omni.a.e r51 = r15.c();     // Catch: Throwable -> L58
            if (r51 == null) goto L47;
            Integer r52 = r51.f();     // Catch: Throwable -> L58
        L48:
            List<String> r314 = r48.a(r50, r52);     // Catch: Throwable -> L58
            com.obric.autogui.agents.vlm.models.omni.a.e r53 = r15.c();     // Catch: Throwable -> L58
            if (r53 == null) goto L51;
            String r315 = r53.getType();     // Catch: Throwable -> L58
        L52:
            com.obric.autogui.agents.vlm.models.omni.a.e r54 = r15.c();     // Catch: Throwable -> L58
            if (r54 == null) goto L55;
            String r55 = r54.d();     // Catch: Throwable -> L58
        L56:
            r16.uploadOmniDataFeedbackByHttpV2(r17, r18, r19, r110, r111, r20, r21, r22, r23, r212, r313, r314, r315, r55, r32.booleanValue(), (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.preCheckCast(r31, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L58
            goto L65
        L55:
            r55 = null;
            goto L56
        L51:
            r315 = null;
            goto L52
        L47:
            r52 = null;
            goto L48
        L43:
            r50 = null;
            goto L44
        L39:
            r313 = null;
        L58:
            th = th;
        L64:
            OmniDataFeedbackLog.INSTANCE.e(b.TAG, "upload grouped feedback failed, target=" + r211, th);
            b r112 = r28;
            AtomicBoolean r113 = r210;
            b.a(r112, (d.c.d) ZeusTransformUtils.preCheckCast(r39, d.c.d.class, "com.obric.aiagent.plugin"), r113, new C0714b((com.obric.autogui.agents.vlm.models.omni.a.i) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.omni.a.i.b("grouped feedback ipc dispatch failed"), com.obric.autogui.agents.vlm.models.omni.a.i.class, "com.obric.aiagent.plugin"), "ipc_dispatch_exception", "ipc_dispatch", null, b.a(r28, th), 8, null), r26, r27);
            r312 = r28;
        L60:
            th = th;
            r28 = r25;
        L62:
            th = th;
            r210 = r30;
            r39 = r29;
            r28 = r25;
            r211 = r24;
            goto L64
        }
    }

    /* JADX INFO: compiled from: IpcOmniDataFeedbackUploader.kt */
    @d.c.b.a.f(b = "IpcOmniDataFeedbackUploader.kt", c = {EntityType.AUDITORY_RECORDING}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.IpcOmniDataFeedbackUploader$uploadImageOnlyViaHost$2")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super C0714b>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28600c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f28601d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f28602e;
        Object f;
        Object g;
        Object h;
        Object i;
        int j;
        long k;
        int l;
        final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.a.c m;
        final /* synthetic */ IFlowNetworkIDL n;
        final /* synthetic */ String o;
        final /* synthetic */ String p;
        final /* synthetic */ int q;
        final /* synthetic */ String r;
        final /* synthetic */ String s;
        final /* synthetic */ String t;
        final /* synthetic */ b u;
        final /* synthetic */ c v;
        final /* synthetic */ long w;

        /* JADX INFO: compiled from: IpcOmniDataFeedbackUploader.kt */
        static final class a implements d.h.a.b<Throwable, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f28603a;

            a(AtomicBoolean r1) {
                this.f28603a = r1;
            }

            public final void a(Throwable r2) {
                this.f28603a.compareAndSet(false, true);
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(Throwable r3) {
                a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }
        }

        e(com.obric.autogui.agents.vlm.models.omni.a.c r3, IFlowNetworkIDL r4, String r5, String r6, int r7, String r8, String r9, String r10, b r11, c r12, long r13, d.c.d<? super e> r15) {
            IFlowNetworkIDL r14 = (IFlowNetworkIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowNetworkIDL.class, "com.obric.aiagent.plugin");
            d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
            this.m = r3;
            this.n = r14;
            this.o = r5;
            this.p = r6;
            this.q = r7;
            this.r = r8;
            this.s = r9;
            this.t = r10;
            this.u = r11;
            this.v = r12;
            this.w = r13;
            super(2, r16);
        }

        public final Object a(am r3, d.c.d<? super C0714b> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r18, d.c.d<?> r19) {
            d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, r16), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super C0714b> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r29) {
            Object r2 = d.c.a.b.a();
            int r0 = this.l;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            c r1 = (c) ZeusTransformUtils.preCheckCast(this.i, c.class, "com.obric.aiagent.plugin");
            b r3 = (b) ZeusTransformUtils.preCheckCast(this.h, b.class, "com.obric.aiagent.plugin");
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.g, String.class, "com.obric.aiagent.plugin");
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.f, String.class, "com.obric.aiagent.plugin");
            String r6 = (String) ZeusTransformUtils.preCheckCast(this.f28602e, String.class, "com.obric.aiagent.plugin");
            String r7 = (String) ZeusTransformUtils.preCheckCast(this.f28601d, String.class, "com.obric.aiagent.plugin");
            String r8 = (String) ZeusTransformUtils.preCheckCast(this.f28600c, String.class, "com.obric.aiagent.plugin");
            IFlowNetworkIDL r9 = (IFlowNetworkIDL) ZeusTransformUtils.preCheckCast(this.f28599b, IFlowNetworkIDL.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.omni.a.c r10 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(this.f28598a, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
            d.o.a(r29);
            return r29;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r29);
            final com.obric.autogui.agents.vlm.models.omni.a.c r11 = this.m;
            IFlowNetworkIDL r14 = this.n;
            String r15 = this.o;
            String r13 = this.p;
            int r12 = this.q;
            String r16 = this.r;
            String r17 = this.s;
            String r18 = this.t;
            final b r19 = this.u;
            c r20 = this.v;
            long r21 = this.w;
            this.f28598a = r11;
            this.f28599b = r14;
            this.f28600c = r15;
            this.f28601d = r13;
            this.f28602e = r16;
            this.f = r17;
            this.g = r18;
            this.h = r19;
            this.i = r20;
            this.j = r12;
            this.k = r21;
            this.l = 1;
            kotlinx.coroutines.o r22 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")), 1);
            r22.e();
            final kotlinx.coroutines.n r23 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r22, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
            AtomicBoolean r24 = new AtomicBoolean(false);
            r23.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r24), d.h.a.b.class, "com.obric.aiagent.plugin"));
            final long r25 = r21;
            final AtomicBoolean r110 = r24;
            final c r26 = r20;
            kotlinx.coroutines.o r210 = r22;
            final String r111 = r18;
            IFlowNetworkResultCallbackIDL.Stub r27 = new IpcOmniDataFeedbackUploader$uploadImageOnlyViaHost$2$1$callback$1(r19, r23, r110, r11, r26, r25, r111);     // Catch: Throwable -> L56
            Boolean r28 = r11.e();     // Catch: Throwable -> L56
            if (r28 != null) goto L34;
            String r112 = r11.g().a();     // Catch: Throwable -> L56
            com.obric.autogui.agents.vlm.models.omni.a.e r30 = r11.c();     // Catch: Throwable -> L56
            if (r30 == null) goto L16;
            String r113 = r30.a();     // Catch: Throwable -> L56
        L17:
            com.obric.aiagent.assistant.idl.bean.c r31 = com.obric.aiagent.assistant.idl.bean.c.f16269a;     // Catch: Throwable -> L56
            com.obric.autogui.agents.vlm.models.omni.a.e r32 = r11.c();     // Catch: Throwable -> L56
            if (r32 == null) goto L20;
            List<String> r33 = r32.b();     // Catch: Throwable -> L56
        L21:
            com.obric.autogui.agents.vlm.models.omni.a.e r34 = r11.c();     // Catch: Throwable -> L56
            if (r34 == null) goto L24;
            Integer r35 = r34.f();     // Catch: Throwable -> L56
        L25:
            List<String> r114 = r31.a(r33, r35);     // Catch: Throwable -> L56
            com.obric.autogui.agents.vlm.models.omni.a.e r36 = r11.c();     // Catch: Throwable -> L56
            if (r36 == null) goto L28;
            String r211 = r36.getType();     // Catch: Throwable -> L56
        L29:
            com.obric.autogui.agents.vlm.models.omni.a.e r37 = r11.c();     // Catch: Throwable -> L56
            if (r37 == null) goto L32;
            String r38 = r37.d();     // Catch: Throwable -> L56
        L33:
            r14.uploadOmniScreenshotByHttp(r15, r13, r12, r16, r17, r112, r113, r114, r211, r38, (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.preCheckCast(r27, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L56
        L61:
            Object r39 = r210.h();
            if (r39 != d.c.a.b.a()) goto L65;
            d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        L65:
            if (r39 != r2) goto L71;
            return r2;
        L71:
            return r39;
        L32:
            r38 = null;
            goto L33
        L28:
            r211 = null;
            goto L29
        L24:
            r35 = null;
            goto L25
        L20:
            r33 = null;
            goto L21
        L16:
            r113 = null;
            goto L17
        L34:
            String r115 = r11.g().a();     // Catch: Throwable -> L56
            com.obric.autogui.agents.vlm.models.omni.a.e r40 = r11.c();     // Catch: Throwable -> L56
            if (r40 == null) goto L37;
            String r116 = r40.a();     // Catch: Throwable -> L56
        L38:
            com.obric.aiagent.assistant.idl.bean.c r41 = com.obric.aiagent.assistant.idl.bean.c.f16269a;     // Catch: Throwable -> L56
            com.obric.autogui.agents.vlm.models.omni.a.e r42 = r11.c();     // Catch: Throwable -> L56
            if (r42 == null) goto L41;
            List<String> r43 = r42.b();     // Catch: Throwable -> L56
        L42:
            com.obric.autogui.agents.vlm.models.omni.a.e r44 = r11.c();     // Catch: Throwable -> L56
            if (r44 == null) goto L45;
            Integer r45 = r44.f();     // Catch: Throwable -> L56
        L46:
            List<String> r117 = r41.a(r43, r45);     // Catch: Throwable -> L56
            com.obric.autogui.agents.vlm.models.omni.a.e r46 = r11.c();     // Catch: Throwable -> L56
            if (r46 == null) goto L49;
            String r212 = r46.getType();     // Catch: Throwable -> L56
        L50:
            com.obric.autogui.agents.vlm.models.omni.a.e r47 = r11.c();     // Catch: Throwable -> L56
            if (r47 == null) goto L53;
            String r48 = r47.d();     // Catch: Throwable -> L56
        L54:
            r14.uploadOmniScreenshotByHttpV2(r15, r13, r12, r16, r17, r115, r116, r117, r212, r48, r28.booleanValue(), (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.preCheckCast(r27, IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L56
            goto L61
        L53:
            r48 = null;
            goto L54
        L49:
            r212 = null;
            goto L50
        L45:
            r45 = null;
            goto L46
        L41:
            r43 = null;
            goto L42
        L37:
            r116 = null;
        L56:
            th = th;
        L60:
            OmniDataFeedbackLog.INSTANCE.e(b.TAG, "upload image-only fallback failed, target=" + r111, th);
            b.a(r19, (d.c.d) ZeusTransformUtils.preCheckCast(r23, d.c.d.class, "com.obric.aiagent.plugin"), r110, new C0714b((com.obric.autogui.agents.vlm.models.omni.a.i) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.omni.a.i.b("image-only ipc dispatch failed"), com.obric.autogui.agents.vlm.models.omni.a.i.class, "com.obric.aiagent.plugin"), "ipc_dispatch_exception", "ipc_dispatch", null, b.a(r19, th), 8, null), r26, r25);
        L58:
            th = th;
            r26 = r20;
            r111 = r18;
            r25 = r21;
            r110 = r24;
            r210 = r22;
            goto L60
        }
    }

    /* JADX INFO: compiled from: IpcOmniDataFeedbackUploader.kt */
    @d.c.b.a.f(b = "IpcOmniDataFeedbackUploader.kt", c = {138, 151}, d = "uploadViaHost", e = "com.obric.autogui.agents.vlm.models.omni.upload.IpcOmniDataFeedbackUploader")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f28606c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f28607d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f28608e;
        int f;

        f(b r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28608e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r20) {
            this.f28607d = r20;
            this.f |= Integer.MIN_VALUE;
            return b.a(this.f28608e, null, null, 0, null, null, null, null, null, null, null, null, null, 0, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public b() {
        this(null, 0, null, null, 15, null);
    }

    /* JADX INFO: renamed from: lambda$JZySc94cUVlFBUMNTzlhQ-Ahq9o, reason: not valid java name */
    public static /* synthetic */ IFlowNetworkIDL m784lambda$JZySc94cUVlFBUMNTzlhQAhq9o() {
        return a();
    }

    public b(d.h.a.a<? extends IFlowNetworkIDL> r3, long r4, d.h.a.a<Long> r6, d.h.a.b<? super m.a, d.x> r7) {
        d.h.a.a<IFlowNetworkIDL> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<Long> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b<m.a, d.x> r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "ipcProvider");
        d.h.b.o.e(r8, "elapsedRealtime");
        d.h.b.o.e(r9, "telemetryReporter");
        this.f28577b = r5;
        this.f28578c = r4;
        this.f28579d = r8;
        this.f28580e = r9;
    }

    public static final /* synthetic */ C0714b a(b r2, Map r3) {
        return r2.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(b r17, String r18, String r19, int r20, String r21, String r22, String r23, String r24, String r25, String r26, com.obric.autogui.agents.vlm.models.omni.a.c r27, String r28, String r29, long r30, int r32, d.c.d r33) {
        return r17.a(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r32, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r33, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a(b r0, Throwable r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ void a(b r7, d.c.d r8, AtomicBoolean r9, C0714b r10, c r11, long r12) {
        r7.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin"), r9, r10, r11, r12);
    }

    public /* synthetic */ b(d.h.a.a r8, long r9, d.h.a.a r11, d.h.a.b r12, int r13, d.h.b.h r14) {
        d.h.a.a r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.b r16 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r13 & 1) == 0) goto L5;
        r10 = $$Lambda$b$JZySc94cUVlFBUMNTzlhQAhq9o.INSTANCE;
    L5:
        d.h.a.a r2 = r10;
        if ((r13 & 2) == 0) goto L8;
        r9 = 60000;
    L8:
        long r3 = r9;
        if ((r13 & 4) == 0) goto L11;
        r15 = (d.h.a.a) ZeusTransformUtils.preCheckCast(AnonymousClass1.f28581a, d.h.a.a.class, "com.obric.aiagent.plugin");
    L11:
        d.h.a.a r5 = r15;
        if ((r13 & 8) == 0) goto L14;
        r16 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass2(m.f28813a), d.h.a.b.class, "com.obric.aiagent.plugin");
    L14:
        this(r2, r3, r5, r16);
    }

    private static final IFlowNetworkIDL a() {
        return com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class));
    }

    public final Object a(h r19, com.obric.autogui.agents.vlm.models.omni.a.c r20, int r21, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.i> r22) {
        d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.i> r17 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L5;
        Loog.INSTANCE.i(TAG, "upload grouped feedback start, trigger=" + r20.a() + ", source=" + r20.g().a() + ", task=" + r19.a() + ", tool=" + r19.b() + ", imageCount=" + r20.h() + ", files=" + r19.n() + ", size=" + r19.i());
    L5:
        String r2 = r19.a();
        String r3 = r19.b();
        int r4 = r20.h();
        t r0 = r19.e();
        String r1 = null;
        if (r0 == null) goto L10;
        File r5 = r0.a();
        if (r5 == null) goto L10;
        String r6 = r5.getAbsolutePath();
    L12:
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        t r7 = r19.e();
        if (r7 == null) goto L17;
        String r8 = r.f28823b.c(r7.a());
    L18:
        if (r8 != null) goto L20;
        r8 = "";
    L20:
        com.obric.autogui.agents.vlm.models.omni.upload.b.e r9 = r19.f();
        if (r9 == null) goto L25;
        File r10 = r9.a();
        if (r10 == null) goto L25;
        String r11 = r10.getAbsolutePath();
    L26:
        if (r11 != null) goto L28;
        r11 = "";
    L28:
        com.obric.autogui.agents.vlm.models.omni.upload.b.e r12 = r19.f();
        if (r12 == null) goto L31;
        String r13 = com.obric.autogui.agents.vlm.models.omni.upload.b.b.f28610b.c(r12.a());
    L32:
        if (r13 != null) goto L34;
        r13 = "";
    L34:
        com.obric.autogui.agents.vlm.models.omni.upload.a.g r14 = r19.g();
        if (r14 == null) goto L39;
        File r15 = r14.a();
        if (r15 == null) goto L39;
        String r16 = r15.getAbsolutePath();
    L40:
        if (r16 != null) goto L42;
        r16 = "";
    L42:
        com.obric.autogui.agents.vlm.models.omni.upload.a.g r18 = r19.g();
        if (r18 == null) goto L45;
        r1 = com.obric.autogui.agents.vlm.models.omni.upload.a.d.f28544b.c(r18.a());
    L45:
        if (r1 != null) goto L47;
        String r110 = "";
    L48:
        String r111 = r19.n();
        if (r19.f() == null) goto L51;
    L53:
        String r23 = "grouped";
    L55:
        return a(r2, r3, r4, r6, r8, r11, r13, r16, r110, r20, r111, r23, r19.i(), r21, r17);
    L51:
        if (r19.g() != null) goto L53;
        r23 = "image_only";
        goto L55
    L47:
        r110 = r1;
    L39:
        r16 = null;
        goto L40
    L31:
        r13 = null;
    L25:
        r11 = null;
        goto L26
    L17:
        r8 = null;
    L10:
        r6 = null;
        goto L12
    }

    public final Object a(String r18, com.obric.autogui.agents.vlm.models.omni.a.c r19, int r20, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.i> r21) {
        d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.i> r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L6;
        Loog.INSTANCE.i(TAG, "upload feedback-only start, trigger=" + r19.a() + ", source=" + r19.g().a() + ", task=" + r18);
    L6:
        return a(r18, "", 0, "", "", "", "", "", "", r19, "feedback-only:" + r18, "feedback_only", 0, r20, r16);
    }

    private final Object a(String r26, String r27, int r28, String r29, String r30, String r31, String r32, String r33, String r34, com.obric.autogui.agents.vlm.models.omni.a.c r35, String r36, String r37, long r38, int r40, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.i> r41) {
        b r15 = this;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r41, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, f.class) == false) goto L7;
        f r2 = (f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.aiagent.plugin");
        if ((r2.f & Integer.MIN_VALUE) == 0) goto L7;
        r2.f -= Integer.MIN_VALUE;
    L8:
        f r13 = r2;
        Object r3 = r13.f28607d;
        Object r11 = d.c.a.b.a();
        int r4 = r13.f;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        long r5 = r13.f28606c;
        c r6 = (c) ZeusTransformUtils.preCheckCast(r13.f28605b, c.class, "com.obric.aiagent.plugin");
        b r0 = (b) ZeusTransformUtils.preCheckCast(r13.f28604a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
    L32:
        String r7 = "com.obric.aiagent.plugin";
        r15 = r0;
        C0714b r8 = (C0714b) ZeusTransformUtils.preCheckCast(r3, C0714b.class, r7);
    L33:
        if (r8 != null) goto L36;
        r8 = new C0714b((com.obric.autogui.agents.vlm.models.omni.a.i) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.omni.a.i.b("host upload timeout"), com.obric.autogui.agents.vlm.models.omni.a.i.class, r7), "ipc_timeout", "ipc_callback", null, null, 24, null);
    L36:
        return r15.a(r6, r5, r8);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r5 = r13.f28606c;
        r6 = (c) ZeusTransformUtils.preCheckCast(r13.f28605b, c.class, "com.obric.aiagent.plugin");
        b r9 = (b) ZeusTransformUtils.preCheckCast(r13.f28604a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
        r15 = r9;
    L27:
        r8 = (C0714b) ZeusTransformUtils.preCheckCast(r3, C0714b.class, "com.obric.aiagent.plugin");
        r7 = "com.obric.aiagent.plugin";
        goto L33
    L16:
        d.o.a(r3);
        c r12 = new c(r26, r35, r37, r38, r40);
        long r10 = ((Number) ZeusTransformUtils.preCheckCast(r15.f28579d.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue();
        IFlowNetworkIDL r14 = (IFlowNetworkIDL) ZeusTransformUtils.preCheckCast(r15.f28577b.invoke(), IFlowNetworkIDL.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (r14 != null) goto L22;
        return r15.a(r12, r10, new C0714b((com.obric.autogui.agents.vlm.models.omni.a.i) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.omni.a.i.b("flow network ipc is null"), com.obric.autogui.agents.vlm.models.omni.a.i.class, "com.obric.aiagent.plugin"), "ipc_null", "ipc_lookup", null, null, 24, null));
    L22:
        if (r15.a(r29, r31, r33) == false) goto L28;
        r13.f28604a = r15;
        r13.f28605b = r12;
        r13.f28606c = r10;
        r13.f = 1;
        r3 = a(r14, r26, r27, r28, r29, r30, r35, r36, r12, r10, r13);
        if (r3 != r11) goto L26;
        return r11;
    L26:
        r5 = r10;
        r6 = r12;
        goto L27
    L28:
        r13.f28604a = r15;
        r13.f28605b = r12;
        r13.f28606c = r10;
        r13.f = 2;
        r3 = a(r14, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r12, r10, r13);
        if (r3 != r11) goto L31;
        return r11;
    L31:
        r0 = this;
        r5 = r10;
        r6 = r12;
    L37:
        th = move-exception;
        return a(r12, r10, new C0714b((com.obric.autogui.agents.vlm.models.omni.a.i) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.omni.a.i.b("flow network ipc lookup failed"), com.obric.autogui.agents.vlm.models.omni.a.i.class, "com.obric.aiagent.plugin"), "ipc_provider_exception", "ipc_lookup", null, a(th), 8, null));
    L7:
        r2 = new f(r15, r1);
        goto L8
    }

    private final Object a(IFlowNetworkIDL r23, String r24, String r25, int r26, String r27, String r28, String r29, String r30, String r31, String r32, com.obric.autogui.agents.vlm.models.omni.a.c r33, String r34, c r35, long r36, d.c.d<? super C0714b> r38) {
        IFlowNetworkIDL r0 = (IFlowNetworkIDL) ZeusTransformUtils.wrapperContextForParams(r23, IFlowNetworkIDL.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r38, d.c.d.class, "com.obric.aiagent.plugin");
        return dg.b(this.f28578c, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r33, r0, r24, r25, r26, r27, r28, r29, r30, r31, r32, r34, this, r35, r36, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r2);
    }

    private final Object a(IFlowNetworkIDL r20, String r21, String r22, int r23, String r24, String r25, com.obric.autogui.agents.vlm.models.omni.a.c r26, String r27, c r28, long r29, d.c.d<? super C0714b> r31) {
        IFlowNetworkIDL r4 = (IFlowNetworkIDL) ZeusTransformUtils.wrapperContextForParams(r20, IFlowNetworkIDL.class, "com.obric.aiagent.plugin");
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r31, d.c.d.class, "com.obric.aiagent.plugin");
        return dg.b(this.f28578c, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r26, r4, r21, r22, r23, r24, r25, r27, this, r28, r29, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r0);
    }

    private final boolean a(String r1, String r2, String r3) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L5;
    L7:
        return false;
    L5:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L7;
        return true;
    }

    private final C0714b a(Map<Object, Object> r11) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        String r12 = null;
        if (r10 == null) goto L9;
        Object r1 = r10.get(MonitorConstants.CODE);
        if (r1 == null) goto L9;
        String r2 = r1.toString();
        if (r2 == null) goto L9;
        Integer r6 = d.o.o.d(r2);
    L10:
        if (r10 == null) goto L15;
        Object r3 = r10.get("msg");
        if (r3 == null) goto L15;
        String r4 = r3.toString();
        if (r4 == null) goto L15;
    L16:
        if (r10 == null) goto L24;
        Object r5 = r10.get("reason_code");
        if (r5 == null) goto L24;
        String r7 = r5.toString();
        if (r7 == null) goto L24;
        if (f.contains(r7) == false) goto L24;
    L25:
        if (r10 == null) goto L35;
        Object r13 = r10.get("failure_stage");
        if (r13 == null) goto L35;
        String r14 = r13.toString();
        if (r14 == null) goto L35;
        if (g.contains(r14) == false) goto L33;
        r12 = r14;
    L33:
        if (r12 == null) goto L35;
        String r8 = r12;
    L37:
        if (r6 == null) goto L43;
        if (r6.intValue() != 10000) goto L43;
        return new C0714b((com.obric.autogui.agents.vlm.models.omni.a.i) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.omni.a.i.c(r6.intValue(), r4), com.obric.autogui.agents.vlm.models.omni.a.i.class, "com.obric.aiagent.plugin"), "server_internal_error", r8, r6, null, 16, null);
    L43:
        if (r6 != null) goto L46;
    L48:
        com.obric.autogui.agents.vlm.models.omni.a.i r9 = (com.obric.autogui.agents.vlm.models.omni.a.i) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.omni.a.i.b("host upload failed: " + r4), com.obric.autogui.agents.vlm.models.omni.a.i.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L51;
        String r15 = "host_retryable_failure";
    L53:
        return new C0714b(r9, r15, r8, r6, null, 16, null);
    L51:
        r15 = r7;
        goto L53
    L46:
        if (r6.intValue() != 10001) goto L48;
        return new C0714b((com.obric.autogui.agents.vlm.models.omni.a.i) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.omni.a.i.c(r6.intValue(), r4), com.obric.autogui.agents.vlm.models.omni.a.i.class, "com.obric.aiagent.plugin"), "server_invalid_param", r8, r6, null, 16, null);
    L35:
        r8 = "ipc_callback";
    L24:
        r7 = null;
    L15:
        r4 = String.valueOf(r10);
    L9:
        r6 = null;
        goto L10
    }

    private final com.obric.autogui.agents.vlm.models.omni.a.i a(c r11, long r12, C0714b r14) {
        if (ZeusTransformUtils.instanceOf(r14.a(), com.obric.autogui.agents.vlm.models.omni.a.i.e.class) == false) goto L5;
        String r0 = "success";
    L6:
        a(a(r11, r0, r14.b(), ((Number) ZeusTransformUtils.preCheckCast(this.f28579d.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() - r12, r14.d(), r14.c(), r14.e()));
        return r14.a();
    L5:
        r0 = "failure";
        goto L6
    }

    private final void a(d.c.d<? super C0714b> r3, AtomicBoolean r4, C0714b r5, c r6, long r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        if (r4.compareAndSet(false, true) == true) goto L6;
        a(r6, r7);
        return;
    L6:
        d.n.a r2 = d.n.f38560a;
        r8.resumeWith(d.n.f(r5));
    }

    private final void a(c r12, long r13) {
        a(a(this, r12, "ignored", "late_or_duplicate_callback", ((Number) ZeusTransformUtils.preCheckCast(this.f28579d.invoke(), Number.class, "com.obric.aiagent.plugin")).longValue() - r13, null, "ipc_callback", null, 40, null));
    }

    private final void a(m.a r4) {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L4
        ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).f28580e.invoke(r4);     // Catch: Throwable -> L4
        Object r3 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L4
    L6:
        Throwable r5 = d.n.c(r3);
        if (r5 == null) goto L12;
        OmniDataFeedbackLog.INSTANCE.e(TAG, "telemetry callback failed, stage=" + r4.a() + ", reason=" + r4.c(), r5);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        r3 = d.n.f(d.o.a(th));
        goto L6
    }

    static /* synthetic */ m.a a(b r11, c r12, String r13, String r14, long r15, Integer r17, String r18, String r19, int r20, Object r21) {
        if ((r20 & 8) == 0) goto L5;
        Integer r8 = null;
    L7:
        if ((r20 & 16) == 0) goto L9;
        String r9 = null;
    L11:
        if ((r20 & 32) == 0) goto L13;
        String r10 = null;
    L15:
        return r11.a(r12, r13, r14, r15, r8, r9, r10);
    L13:
        r10 = r19;
        goto L15
    L9:
        r9 = r18;
        goto L11
    L5:
        r8 = r17;
        goto L7
    }

    private final m.a a(c r29, String r30, String r31, long r32, Integer r34, String r35, String r36) {
        String r4 = r29.a();
        String r0 = r29.b().a().name().toLowerCase(Locale.ROOT);
        d.h.b.o.c(r0, "toLowerCase(...)");
        return new m.a("upload_attempt", r30, r31, r4, r0, m.f28813a.a(r29.b()), r29.c(), r29.b().g().a(), r29.b().e(), Integer.valueOf(r29.b().h()), Long.valueOf(r29.d()), Long.valueOf(d.l.n.a(r32, 0)), Integer.valueOf(r29.e()), r34, r35, r36, null, null, null, null, null, null, null, null, 16711680, null);
    }

    private final String a(Throwable r1) {
        return m.f28813a.a(r1);
    }

    static {
        f28576a = new a(null);
        f = ax.a(new String[]{"host_service_null", "host_invalid_argument", "host_file_unavailable", "host_encrypt_failed", "host_transport_error", "host_biz_error"});
        g = ax.a(new String[]{"host_service", "host_validate", "host_prepare", "host_http", "host_biz"});
    }
}
