package com.obric.autogui.agents.vlm.models.omni.upload;

import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.IFlowAppStateIDL;
import com.obric.aiagent.assistant.idl.IFlowOnAppStateChangedListenerIDL;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.entity.ResultCode;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.bduploader.BDAbstractUpload;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.aa;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;

/* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static final String TAG = "OmniDataFeedbackUpload";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f28643a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f28644b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final l f28645c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final d.f f28646d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final OmniDataFeedbackUploadCenter$appStateListener$1 f28647e = null;

    /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.agents.vlm.models.omni.upload.i f28648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.autogui.agents.vlm.models.omni.upload.p f28649b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.obric.autogui.agents.vlm.models.omni.upload.b f28650c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final d.h.a.a<Boolean> f28651d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final d.h.a.a<Boolean> f28652e;
        private final d.h.a.a<Boolean> f;
        private final d.h.a.a<Boolean> g;
        private final d.h.a.b<String, Boolean> h;
        private final boolean i;
        private final AtomicBoolean j;
        private final ConcurrentLinkedQueue<com.obric.autogui.agents.vlm.models.omni.a.c> k;
        private final AtomicLong l;
        private final com.obric.autogui.agents.vlm.models.omni.upload.a m;

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.omni.upload.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        private static final class C0717a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final com.obric.autogui.agents.vlm.models.omni.a.i f28653a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final com.obric.autogui.agents.vlm.models.omni.a.c f28654b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final boolean f28655c;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0717a.class) == true) goto L8;
                return false;
            L8:
                C0717a r6 = (C0717a) ZeusTransformUtils.preCheckCast(r5, C0717a.class, "com.obric.aiagent.plugin");
                if (d.h.b.o.a(this.f28653a, r6.f28653a) == true) goto L12;
                return false;
            L12:
                if (d.h.b.o.a(this.f28654b, r6.f28654b) == true) goto L15;
                return false;
            L15:
                if (this.f28655c == r6.f28655c) goto L17;
                return false;
            L17:
                return true;
            }

            public int hashCode() {
                return (((this.f28653a.hashCode() * 31) + this.f28654b.hashCode()) * 31) + Boolean.hashCode(this.f28655c);
            }

            public String toString() {
                return "UploadExecution(result=" + this.f28653a + ", request=" + this.f28654b + ", deleted=" + this.f28655c + ')';
            }

            public C0717a(com.obric.autogui.agents.vlm.models.omni.a.i r2, com.obric.autogui.agents.vlm.models.omni.a.c r3, boolean r4) {
                d.h.b.o.e(r2, "result");
                d.h.b.o.e(r3, Ext.KEY_REQUEST);
                this.f28653a = r2;
                this.f28654b = r3;
                this.f28655c = r4;
            }

            public /* synthetic */ C0717a(com.obric.autogui.agents.vlm.models.omni.a.i r1, com.obric.autogui.agents.vlm.models.omni.a.c r2, boolean r3, int r4, d.h.b.h r5) {
                if ((r4 & 4) == 0) goto L5;
                r3 = false;
            L5:
                this(r1, r2, r3);
            }

            public final com.obric.autogui.agents.vlm.models.omni.a.i a() {
                return this.f28653a;
            }

            public final com.obric.autogui.agents.vlm.models.omni.a.c b() {
                return this.f28654b;
            }

            public final boolean c() {
                return this.f28655c;
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {905}, d = "resolveIsFinish", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain")
        static final class aa extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f28656a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f28657b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f28658c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f28659d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f28660e;

            aa(a r3, d.c.d<? super aa> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28659d = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f28658c = r3;
                this.f28660e |= Integer.MIN_VALUE;
                return a.a(this.f28659d, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {202}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain$scheduleAfterAppForeground$1")
        static final class ab extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f28661a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f28662b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f28663c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f28664d;

            ab(long r3, a r5, long r6, d.c.d<? super ab> r8) {
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28662b = r3;
                this.f28663c = r5;
                this.f28664d = r6;
                super(2, r9);
            }

            public final Object a(am r3, d.c.d<? super d.x> r4) {
                return ((ab) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ab.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r9, d.c.d<?> r10) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new ab(this.f28662b, this.f28663c, this.f28664d, r7), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r10) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f28661a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r10);
            L12:
                if (a.a(this.f28663c).get() == this.f28664d) goto L19;
                if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L17;
                Loog.INSTANCE.i(e.TAG, "skip foreground upload, newer foreground schedule exists");
            L17:
                return d.x.f38692a;
            L19:
                if (((Boolean) ZeusTransformUtils.preCheckCast(a.b(this.f28663c).invoke(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L21;
                this.f28663c.a(new com.obric.autogui.agents.vlm.models.omni.a.c(com.obric.autogui.agents.vlm.models.omni.a.l.f28188a, null, null, null, null, null, 62, null));
                return d.x.f38692a;
            L21:
                if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L24;
                Loog.INSTANCE.i(e.TAG, "skip foreground upload, app is not foreground");
            L24:
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r10);
                long r4 = this.f28662b;
                d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28661a = 1;
                if (ax.a(r4, r11) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {295}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain$tryLaunchPendingLoop$1")
        static final class ac extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f28665a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f28666b;

            ac(a r3, d.c.d<? super ac> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28666b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super d.x> r4) {
                return ((ac) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ac.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new ac(this.f28666b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f28665a;
                if (r1 == 0) goto L11;
                if (r1 != 1) goto L10;
                d.o.a(r6);     // Catch: Throwable -> L7
            L15:
                a.c(this.f28666b).set(false);
                if ((!((Collection) ZeusTransformUtils.preCheckCast(a.d(this.f28666b), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L19;
                a.e(this.f28666b);
            L19:
                return d.x.f38692a;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                d.o.a(r6);
                a r7 = this.f28666b;     // Catch: Throwable -> L7
                d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
                this.f28665a = 1;     // Catch: Throwable -> L7
                if (a.a(r7, r2) != r0) goto L15;
                return r0;
            L7:
                th = move-exception;
                a.c(this.f28666b).set(false);
                if ((!((Collection) ZeusTransformUtils.preCheckCast(a.d(this.f28666b), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L23;
                a.e(this.f28666b);
            L23:
                throw th;
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {937, 945}, d = "uploadFeedbackOnlyWithServerErrorRetries", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain")
        static final class ad extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f28667a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f28668b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f28669c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f28670d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f28671e;
            Object f;
            /* synthetic */ Object g;
            final /* synthetic */ a h;
            int i;

            ad(a r3, d.c.d<? super ad> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.h = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.g = r3;
                this.i |= Integer.MIN_VALUE;
                return a.a(this.h, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {869, 871, 873}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain$uploadFeedbackOnlyWithTaskLock$2")
        static final class ae extends d.c.b.a.l implements d.h.a.b<d.c.d<? super C0717a>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f28672a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f28673b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f28674c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f28675d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f28676e;
            final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.a.c f;

            ae(a r3, String r4, com.obric.autogui.agents.vlm.models.omni.a.c r5, d.c.d<? super ae> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28675d = r3;
                this.f28676e = r4;
                this.f = r5;
                super(1, r7);
            }

            public final Object a(d.c.d<? super C0717a> r3) {
                return ((ae) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), ae.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new ae(this.f28675d, this.f28676e, this.f, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super C0717a> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r17) {
                Object r1 = d.c.a.b.a();
                int r2 = this.f28674c;
                if (r2 == 0) goto L13;
                if (r2 == 1) goto L11;
                if (r2 == 2) goto L10;
                if (r2 != 3) goto L9;
                com.obric.autogui.agents.vlm.models.omni.a.i r3 = (com.obric.autogui.agents.vlm.models.omni.a.i) ZeusTransformUtils.preCheckCast(this.f28673b, com.obric.autogui.agents.vlm.models.omni.a.i.class, "com.obric.aiagent.plugin");
                com.obric.autogui.agents.vlm.models.omni.a.c r4 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(this.f28672a, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
                d.o.a(r17);
                Object r5 = r17;
            L31:
                int r6 = ((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin")).size();
                if (r6 != 0) goto L34;
                com.obric.autogui.agents.vlm.models.omni.upload.v.f28855a.g(this.f28676e);
            L35:
                com.obric.autogui.agents.vlm.models.omni.a.i r7 = r3;
                com.obric.autogui.agents.vlm.models.omni.a.c r8 = r4;
            L38:
                return new C0717a(r7, r8, false, 4, null);
            L34:
                com.obric.autogui.agents.vlm.models.omni.upload.m.f28813a.a(this.f28676e, r4, "feedback_only", r6);
                goto L35
            L9:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L10:
                r4 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(this.f28672a, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
                d.o.a(r17);
                Object r9 = r17;
            L23:
                com.obric.autogui.agents.vlm.models.omni.a.i r10 = (com.obric.autogui.agents.vlm.models.omni.a.i) ZeusTransformUtils.preCheckCast(r9, com.obric.autogui.agents.vlm.models.omni.a.i.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r10, com.obric.autogui.agents.vlm.models.omni.a.i.e.class) == true) goto L26;
            L36:
                r8 = r4;
                r7 = r10;
                goto L38
            L26:
                if (((com.obric.autogui.agents.vlm.models.omni.a.i.e) ZeusTransformUtils.preCheckCast(r10, com.obric.autogui.agents.vlm.models.omni.a.i.e.class, "com.obric.aiagent.plugin")).a() == false) goto L36;
                com.obric.autogui.agents.vlm.models.omni.upload.i r11 = a.g(this.f28675d);
                String r12 = this.f28676e;
                d.c.d<? super List<com.obric.autogui.agents.vlm.models.omni.upload.h>> r13 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28672a = r4;
                this.f28673b = r10;
                this.f28674c = 3;
                r5 = r11.a(r12, r13);
                if (r5 != r1) goto L30;
                return r1;
            L30:
                r3 = r10;
                goto L31
            L11:
                com.obric.autogui.agents.vlm.models.omni.a.c r14 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(this.f28672a, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
                d.o.a(r17);
                Object r15 = r17;
            L12:
                com.obric.autogui.agents.vlm.models.omni.a.c r16 = r14;
                r4 = com.obric.autogui.agents.vlm.models.omni.a.c.a(r16, null, null, null, null, null, (Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.aiagent.plugin"), 31, null);
                a r18 = this.f28675d;
                String r19 = this.f28676e;
                d.c.d r20 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28672a = r4;
                this.f28674c = 2;
                r9 = a.a(r18, r19, r4, r20);
                if (r9 != r1) goto L23;
                return r1;
            L13:
                d.o.a(r17);
                if (a.a(this.f28675d, this.f28676e, this.f.a()) == true) goto L16;
                r14 = this.f;
                a r21 = this.f28675d;
                String r22 = this.f28676e;
                d.c.d r110 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28672a = r14;
                this.f28674c = 1;
                r15 = a.a(r21, r22, null, r110);
                if (r15 != r1) goto L12;
                return r1;
            L16:
                return new C0717a((com.obric.autogui.agents.vlm.models.omni.a.i) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.omni.a.i.a("inference image upload is busy"), com.obric.autogui.agents.vlm.models.omni.a.i.class, "com.obric.aiagent.plugin"), this.f, false, 4, null);
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {794, 798, 800, 810, 814, 838, 843}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain$uploadRecordWithTaskLock$2")
        static final class af extends d.c.b.a.l implements d.h.a.b<d.c.d<? super C0717a>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f28677a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f28678b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f28679c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f28680d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f28681e;
            Object f;
            int g;
            int h;
            final /* synthetic */ a i;
            final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.upload.h j;
            final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.a.c k;

            af(a r3, com.obric.autogui.agents.vlm.models.omni.upload.h r4, com.obric.autogui.agents.vlm.models.omni.a.c r5, d.c.d<? super af> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.i = r3;
                this.j = r4;
                this.k = r5;
                super(1, r7);
            }

            public final Object a(d.c.d<? super C0717a> r3) {
                return ((af) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), af.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new af(this.i, this.j, this.k, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super C0717a> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r8v23 */
            /* JADX WARN: Type inference failed for: r8v26 */
            /* JADX WARN: Type inference failed for: r8v28 */
            /* JADX WARN: Type inference failed for: r8v33 */
            /* JADX WARN: Type inference failed for: r8v34 */
            /* JADX WARN: Type inference failed for: r8v35 */
            /* JADX WARN: Type inference failed for: r8v41 */
            /* JADX WARN: Type inference failed for: r8v42 */
            /* JADX WARN: Type inference failed for: r8v43 */
            /* JADX WARN: Type inference failed for: r8v44 */
            /* JADX WARN: Type inference failed for: r8v45 */
            /* JADX WARN: Type inference failed for: r8v46 */
            /* JADX WARN: Type inference failed for: r8v8 */
            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r19) {
                Object r1 = d.c.a.b.a();
                boolean r3 = true;
                switch(this.h) {
                    case 0: goto L14;
                    case 1: goto L13;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    case 7: goto L6;
                    default: goto L5;
                };
            L6:
                int r2 = this.g;
                com.obric.autogui.agents.vlm.models.omni.a.i r4 = (com.obric.autogui.agents.vlm.models.omni.a.i) ZeusTransformUtils.preCheckCast(this.f28678b, com.obric.autogui.agents.vlm.models.omni.a.i.class, "com.obric.aiagent.plugin");
                com.obric.autogui.agents.vlm.models.omni.a.c r5 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(this.f28677a, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
                d.o.a(r19);
            L82:
                if (com.obric.autogui.agents.vlm.models.omni.upload.f.a(r5.e()) == false) goto L86;
                boolean r8 = a.g(this.i).a(this.j);
                ?? r9 = r8;
                if (r8 == false) goto L87;
                a.g(this.i).b(this.j);
                r9 = r8;
            L87:
                com.obric.autogui.agents.vlm.models.omni.a.i r6 = r4;
                com.obric.autogui.agents.vlm.models.omni.a.c r7 = r5;
                ?? r10 = r9;
            L90:
                if (r10 != 0) goto L94;
                r3 = false;
            L94:
                return new C0717a(r6, r7, r3);
            L86:
                r9 = r2;
                goto L87
            L7:
                int r11 = this.g;
                String r12 = (String) ZeusTransformUtils.preCheckCast(this.f, String.class, "com.obric.aiagent.plugin");
                com.obric.autogui.agents.vlm.models.omni.a.c r13 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(this.f28681e, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
                String r14 = (String) ZeusTransformUtils.preCheckCast(this.f28680d, String.class, "com.obric.aiagent.plugin");
                com.obric.autogui.agents.vlm.models.omni.upload.m r15 = (com.obric.autogui.agents.vlm.models.omni.upload.m) ZeusTransformUtils.preCheckCast(this.f28679c, com.obric.autogui.agents.vlm.models.omni.upload.m.class, "com.obric.aiagent.plugin");
                com.obric.autogui.agents.vlm.models.omni.a.i r16 = (com.obric.autogui.agents.vlm.models.omni.a.i) ZeusTransformUtils.preCheckCast(this.f28678b, com.obric.autogui.agents.vlm.models.omni.a.i.class, "com.obric.aiagent.plugin");
                com.obric.autogui.agents.vlm.models.omni.a.c r0 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(this.f28677a, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
                d.o.a(r19);
                String r17 = r14;
                com.obric.autogui.agents.vlm.models.omni.a.c r18 = r13;
                com.obric.autogui.agents.vlm.models.omni.a.c r20 = r0;
                Object r21 = r19;
            L73:
                r15.b(r17, r18, r12, ((List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin")).size());
                ?? r22 = r11;
            L74:
                r7 = r20;
                r6 = r16;
                r10 = r22;
                goto L90
            L8:
                int r23 = this.g;
                r12 = (String) ZeusTransformUtils.preCheckCast(this.f28679c, String.class, "com.obric.aiagent.plugin");
                r6 = (com.obric.autogui.agents.vlm.models.omni.a.i) ZeusTransformUtils.preCheckCast(this.f28678b, com.obric.autogui.agents.vlm.models.omni.a.i.class, "com.obric.aiagent.plugin");
                com.obric.autogui.agents.vlm.models.omni.a.c r24 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(this.f28677a, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
                d.o.a(r19);
                com.obric.autogui.agents.vlm.models.omni.a.c r25 = r24;
                Object r26 = r19;
            L57:
                int r27 = ((List) ZeusTransformUtils.preCheckCast(r26, List.class, "com.obric.aiagent.plugin")).size();
                if (r27 == 0) goto L60;
                com.obric.autogui.agents.vlm.models.omni.upload.m.f28813a.a(this.j.a(), r25, r12, r27);
            L65:
                r7 = r25;
                r10 = r23;
                goto L90
            L60:
                if (a.h(this.i) == false) goto L63;
                if (r23 != 0) goto L63;
                com.obric.autogui.agents.vlm.models.omni.upload.m.f28813a.b(this.j.a(), r25, r12, r27);
            L63:
                com.obric.autogui.agents.vlm.models.omni.upload.v.f28855a.g(this.j.a());
                goto L65
            L9:
                r12 = (String) ZeusTransformUtils.preCheckCast(this.f28679c, String.class, "com.obric.aiagent.plugin");
                r6 = (com.obric.autogui.agents.vlm.models.omni.a.i) ZeusTransformUtils.preCheckCast(this.f28678b, com.obric.autogui.agents.vlm.models.omni.a.i.class, "com.obric.aiagent.plugin");
                com.obric.autogui.agents.vlm.models.omni.a.c r28 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(this.f28677a, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
                d.o.a(r19);
            L49:
                r16 = r6;
                r20 = r28;
                boolean r29 = a.g(this.i).a(this.j);
            L52:
                if (((com.obric.autogui.agents.vlm.models.omni.a.i.e) ZeusTransformUtils.preCheckCast(r16, com.obric.autogui.agents.vlm.models.omni.a.i.e.class, "com.obric.aiagent.plugin")).a() == false) goto L66;
                com.obric.autogui.agents.vlm.models.omni.upload.i r30 = a.g(this.i);
                String r110 = this.j.a();
                d.c.d<? super List<com.obric.autogui.agents.vlm.models.omni.upload.h>> r111 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28677a = r20;
                this.f28678b = r16;
                this.f28679c = r12;
                this.g = r29 ? 1 : 0;
                this.h = 5;
                r26 = r30.a(r110, r111);
                if (r26 != r1) goto L56;
                return r1;
            L56:
                r23 = r29 ? 1 : 0;
                r25 = r20;
                r6 = r16;
                goto L57
            L66:
                r22 = r29;
                r22 = r29;
                if (a.h(this.i) == false) goto L74;
                if (r29 == true) goto L74;
                com.obric.autogui.agents.vlm.models.omni.upload.m r31 = com.obric.autogui.agents.vlm.models.omni.upload.m.f28813a;
                r17 = this.j.a();
                com.obric.autogui.agents.vlm.models.omni.upload.i r112 = a.g(this.i);
                String r113 = this.j.a();
                d.c.d<? super List<com.obric.autogui.agents.vlm.models.omni.upload.h>> r114 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28677a = r20;
                this.f28678b = r16;
                this.f28679c = r31;
                this.f28680d = r17;
                this.f28681e = r20;
                this.f = r12;
                this.g = r29 ? 1 : 0;
                this.h = 6;
                r21 = r112.a(r113, r114);
                if (r21 != r1) goto L72;
                return r1;
            L72:
                r11 = r29 ? 1 : 0;
                r15 = r31;
                r18 = r20;
                goto L73
            L10:
                r7 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(this.f28677a, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
                d.o.a(r19);
                Object r32 = r19;
            L35:
                r6 = (com.obric.autogui.agents.vlm.models.omni.a.i) ZeusTransformUtils.preCheckCast(r32, com.obric.autogui.agents.vlm.models.omni.a.i.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r6, com.obric.autogui.agents.vlm.models.omni.a.i.e.class) == false) goto L76;
                if (this.j.f() == null) goto L40;
            L42:
                String r33 = "grouped";
            L44:
                if (a.h(this.i) == false) goto L50;
                com.obric.autogui.agents.vlm.models.omni.upload.c r34 = com.obric.autogui.agents.vlm.models.omni.upload.c.f28637a;
                com.obric.autogui.agents.vlm.models.omni.upload.h r35 = this.j;
                d.c.d<? super d.x> r115 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28677a = r7;
                this.f28678b = r6;
                this.f28679c = r33;
                this.h = 4;
                if (r34.a(r35, r7, "success", r115) != r1) goto L48;
                return r1;
            L48:
                String r116 = r33;
                r28 = r7;
                r12 = r116;
                goto L49
            L50:
                r29 = false;
                r16 = r6;
                r20 = r7;
                r12 = r33;
                goto L52
            L40:
                if (this.j.g() != null) goto L42;
                r33 = "image_only";
                goto L44
            L76:
                if (ZeusTransformUtils.instanceOf(r6, com.obric.autogui.agents.vlm.models.omni.a.i.c.class) == false) goto L88;
                com.obric.autogui.agents.vlm.models.omni.upload.c r36 = com.obric.autogui.agents.vlm.models.omni.upload.c.f28637a;
                com.obric.autogui.agents.vlm.models.omni.upload.h r37 = this.j;
                String r38 = "server_error:" + ((com.obric.autogui.agents.vlm.models.omni.a.i.c) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.agents.vlm.models.omni.a.i.c.class, "com.obric.aiagent.plugin")).a();
                d.c.d<? super d.x> r39 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28677a = r7;
                this.f28678b = r6;
                this.g = 0;
                this.h = 7;
                if (r36.a(r37, r7, r38, r39) != r1) goto L80;
                return r1;
            L80:
                r5 = r7;
                r2 = 0;
                r4 = r6;
                goto L82
            L88:
                r10 = 0;
                goto L90
            L11:
                Integer r40 = (Integer) ZeusTransformUtils.preCheckCast(this.f28678b, Integer.class, "com.obric.aiagent.plugin");
                com.obric.autogui.agents.vlm.models.omni.a.c r41 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(this.f28677a, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
                d.o.a(r19);
                Object r42 = r19;
            L32:
                r7 = com.obric.autogui.agents.vlm.models.omni.a.c.a(r41, null, null, r40, null, null, (Boolean) ZeusTransformUtils.preCheckCast(r42, Boolean.class, "com.obric.aiagent.plugin"), 27, null);
                a r43 = this.i;
                com.obric.autogui.agents.vlm.models.omni.upload.h r44 = this.j;
                d.c.d r45 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28677a = r7;
                this.f28678b = null;
                this.h = 3;
                r32 = a.a(r43, r44, r7, r45);
                if (r32 != r1) goto L35;
                return r1;
            L13:
                d.o.a(r19);
                Object r46 = r19;
            L25:
                Integer r47 = (Integer) ZeusTransformUtils.preCheckCast(r46, Integer.class, "com.obric.aiagent.plugin");
                if (r47 == null) goto L28;
                int r48 = r47.intValue();
            L29:
                r41 = this.k;
                r40 = d.c.b.a.b.a(d.l.n.c(r48, 0));
                a r49 = this.i;
                String r50 = this.j.a();
                com.obric.autogui.agents.vlm.models.omni.upload.h r51 = this.j;
                d.c.d r117 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28677a = r41;
                this.f28678b = r40;
                this.h = 2;
                r42 = a.a(r49, r50, r51, r117);
                if (r42 != r1) goto L32;
                return r1;
            L28:
                r48 = this.k.h();
                goto L29
            L14:
                d.o.a(r19);
                if (a.a(this.i, this.j.a(), this.k.a()) == false) goto L19;
                return new C0717a((com.obric.autogui.agents.vlm.models.omni.a.i) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.omni.a.i.a("inference image upload is busy"), com.obric.autogui.agents.vlm.models.omni.a.i.class, "com.obric.aiagent.plugin"), this.k, false, 4, null);
            L19:
                if (this.j.l() == true) goto L21;
                com.obric.autogui.agents.vlm.models.omni.upload.i r52 = a.g(this.i);
                String r53 = this.j.a();
                d.c.d<? super Integer> r54 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.h = 1;
                r46 = r52.b(r53, r54);
                if (r46 != r1) goto L25;
                return r1;
            L21:
                return new C0717a((com.obric.autogui.agents.vlm.models.omni.a.i) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.omni.a.i.d("candidate changed before upload"), com.obric.autogui.agents.vlm.models.omni.a.i.class, "com.obric.aiagent.plugin"), this.k, false, 4, null);
            L5:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {764, 772}, d = "uploadWithServerErrorRetries", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain")
        static final class ag extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f28682a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f28683b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f28684c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f28685d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f28686e;
            Object f;
            /* synthetic */ Object g;
            final /* synthetic */ a h;
            int i;

            ag(a r3, d.c.d<? super ag> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.h = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.g = r3;
                this.i |= Integer.MIN_VALUE;
                return a.a(this.h, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f28687a = null;

            static {
                int[] r0 = new int[com.obric.autogui.agents.vlm.models.omni.a.l.values().length];
                r0[com.obric.autogui.agents.vlm.models.omni.a.l.f28191d.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[com.obric.autogui.agents.vlm.models.omni.a.l.f28192e.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[com.obric.autogui.agents.vlm.models.omni.a.l.f28188a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[com.obric.autogui.agents.vlm.models.omni.a.l.f28189b.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[com.obric.autogui.agents.vlm.models.omni.a.l.f28190c.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                f28687a = r0;
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {541}, d = "applyFeedbackImagePolicy", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain")
        static final class c extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f28688a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f28689b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f28690c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f28691d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f28692e;
            Object f;
            Object g;
            Object h;
            Object i;
            Object j;
            /* synthetic */ Object k;
            final /* synthetic */ a l;
            int m;

            c(a r3, d.c.d<? super c> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.l = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r8) {
                this.k = r8;
                this.m |= Integer.MIN_VALUE;
                return a.a(this.l, null, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {728}, d = "buildFeedbackOnlyUploadRequest", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain")
        static final class d extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f28693a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f28694b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f28695c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f28696d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ a f28697e;
            int f;

            d(a r3, d.c.d<? super d> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28697e = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f28696d = r3;
                this.f |= Integer.MIN_VALUE;
                return a.a(this.f28697e, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.omni.upload.e$a$e, reason: collision with other inner class name */
        /* JADX INFO: compiled from: _Collections.kt */
        public static final class C0718e implements d.a.ae<com.obric.autogui.agents.vlm.models.omni.upload.t, String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Iterable f28698a;

            public C0718e(Iterable r3) {
                this.f28698a = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
            }

            @Override // d.a.ae
            public Iterator<com.obric.autogui.agents.vlm.models.omni.upload.t> a() {
                return this.f28698a.iterator();
            }

            @Override // d.a.ae
            public String a(com.obric.autogui.agents.vlm.models.omni.upload.t r2) {
                return ((com.obric.autogui.agents.vlm.models.omni.upload.t) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.agents.vlm.models.omni.upload.t.class, "com.obric.aiagent.plugin")).b();
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {682}, d = "buildImageCountByTaskId", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain")
        static final class f extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f28699a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f28700b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f28701c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f28702d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f28703e;
            Object f;
            Object g;
            /* synthetic */ Object h;
            final /* synthetic */ a i;
            int j;

            f(a r3, d.c.d<? super f> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.i = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.h = r3;
                this.j |= Integer.MIN_VALUE;
                return a.b(this.i, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {696}, d = "buildUploadRequest", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain")
        static final class g extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f28704a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f28705b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f28706c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int f28707d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            /* synthetic */ Object f28708e;
            final /* synthetic */ a f;
            int g;

            g(a r3, d.c.d<? super g> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r8) {
                this.f28708e = r8;
                this.g |= Integer.MIN_VALUE;
                return a.a(this.f, null, null, 0, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {891}, d = "cleanupFinishedCounts", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain")
        static final class h extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f28709a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f28710b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f28711c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f28712d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f28713e;

            h(a r3, d.c.d<? super h> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28712d = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f28711c = r3;
                this.f28713e |= Integer.MIN_VALUE;
                return a.a(this.f28712d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {895}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain$cleanupFinishedCounts$2$1")
        static final class i extends d.c.b.a.l implements d.h.a.b<d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f28714a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f28715b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f28716c;

            i(String r3, a r4, d.c.d<? super i> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28715b = r3;
                this.f28716c = r4;
                super(1, r6);
            }

            public final Object a(d.c.d<? super d.x> r3) {
                return ((i) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f28715b, this.f28716c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super d.x> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f28714a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r6);
            L14:
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                if (com.obric.autogui.agents.vlm.models.omni.upload.f.a(com.obric.autogui.agents.vlm.models.omni.upload.v.f28855a.f(this.f28715b)) == false) goto L14;
                com.obric.autogui.agents.vlm.models.omni.upload.i r7 = a.g(this.f28716c);
                Collection<String> r2 = (Collection) ZeusTransformUtils.preCheckCast(d.a.p.a(this.f28715b), Collection.class, "com.obric.aiagent.plugin");
                d.c.d<? super d.x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28714a = 1;
                if (r7.a(r2, r3) != r0) goto L14;
                return r0;
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {959}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain$cleanupFinishedFeedbackTasks$2")
        static final class j extends d.c.b.a.l implements d.h.a.m<String, d.c.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f28717a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f28718b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f28719c;

            j(a r3, d.c.d<? super j> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28719c = r3;
                super(2, r5);
            }

            public final Object a(String r3, d.c.d<? super Boolean> r4) {
                return ((j) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                j r0 = new j(this.f28719c, r5);
                r0.f28718b = r3;
                return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(String r3, d.c.d<? super Boolean> r4) {
                return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f28717a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r6);
            L12:
                return d.c.b.a.b.a(!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty());
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                String r7 = (String) ZeusTransformUtils.preCheckCast(this.f28718b, String.class, "com.obric.aiagent.plugin");
                com.obric.autogui.agents.vlm.models.omni.upload.i r2 = a.g(this.f28719c);
                d.c.d<? super List<com.obric.autogui.agents.vlm.models.omni.upload.h>> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28717a = 1;
                r6 = r2.a(r7, r4);
                if (r6 != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        /* synthetic */ class k extends d.h.b.l implements d.h.a.m<String, String, Boolean> {
            k(Object r8) {
                super(2, r8, com.obric.autogui.agents.vlm.models.omni.upload.p.class, "removeTaskIdIfVersionBlocking", "removeTaskIdIfVersionBlocking$operator_release(Ljava/lang/String;Ljava/lang/String;)Z", 0);
            }

            public final Boolean a(String r3, String r4) {
                d.h.b.o.e(r3, "p0");
                d.h.b.o.e(r4, "p1");
                return Boolean.valueOf(((com.obric.autogui.agents.vlm.models.omni.upload.p) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.autogui.agents.vlm.models.omni.upload.p.class, "com.obric.aiagent.plugin")).a(r3, r4));
            }

            @Override // d.h.a.m
            public /* synthetic */ Boolean invoke(String r3, String r4) {
                return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {ResultCode.ERROR_MULTI_DETAIL, 311, 309, 316, 317, 322, 340, 347, 397, 402, 410, BDAbstractUpload.KeyIsBatchSessionKey, 445, 483, 484}, d = "drainInternal", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain")
        static final class l extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f28720a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f28721b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f28722c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f28723d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f28724e;
            Object f;
            Object g;
            Object h;
            Object i;
            Object j;
            Object k;
            Object l;
            Object m;
            int n;
            int o;
            int p;
            int q;
            int r;
            int s;
            /* synthetic */ Object t;
            final /* synthetic */ a u;
            int v;

            l(a r3, d.c.d<? super l> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.u = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.t = r3;
                this.v |= Integer.MIN_VALUE;
                return a.b(this.u, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {497}, d = "drainInternalWithTelemetry", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain")
        static final class m extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f28725a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            long f28726b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f28727c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f28728d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            int f28729e;

            m(a r3, d.c.d<? super m> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28728d = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f28727c = r3;
                this.f28729e |= Integer.MIN_VALUE;
                return a.a(this.f28728d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {284}, d = "drainLoop", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain")
        static final class n extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f28730a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f28731b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f28732c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            int f28733d;

            n(a r3, d.c.d<? super n> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28732c = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f28731b = r3;
                this.f28733d |= Integer.MIN_VALUE;
                return a.a(this.f28732c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {285}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain$drainLoop$summary$1")
        static final class o extends d.c.b.a.l implements d.h.a.b<d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.d>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f28734a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f28735b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.a.c f28736c;

            o(a r3, com.obric.autogui.agents.vlm.models.omni.a.c r4, d.c.d<? super o> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28735b = r3;
                this.f28736c = r4;
                super(1, r6);
            }

            public final Object a(d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.d> r3) {
                return ((o) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new o(this.f28735b, this.f28736c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.d> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f28734a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r6);
            L11:
                return r6;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                a r7 = this.f28735b;
                com.obric.autogui.agents.vlm.models.omni.a.c r2 = this.f28736c;
                d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28734a = 1;
                r6 = a.a(r7, r2, r3);
                if (r6 != r0) goto L11;
                return r0;
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {276}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain$drainNow$2")
        static final class p extends d.c.b.a.l implements d.h.a.b<d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.d>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f28737a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.a.c f28738b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f28739c;

            p(com.obric.autogui.agents.vlm.models.omni.a.c r3, a r4, d.c.d<? super p> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28738b = r3;
                this.f28739c = r4;
                super(1, r6);
            }

            public final Object a(d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.d> r3) {
                return ((p) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), p.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new p(this.f28738b, this.f28739c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.d> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f28737a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r6);
            L18:
                return r6;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                if (this.f28738b.a() != com.obric.autogui.agents.vlm.models.omni.a.l.f28191d) goto L11;
            L12:
                String r7 = this.f28738b.b();
                if (r7 == null) goto L15;
                a r2 = this.f28739c;
                com.obric.autogui.agents.vlm.models.omni.a.c r3 = this.f28738b;
                a.f(r2).a(r7, r3.c());
            L15:
                a r8 = this.f28739c;
                com.obric.autogui.agents.vlm.models.omni.a.c r4 = this.f28738b;
                d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28737a = 1;
                r6 = a.a(r8, r4, r5);
                if (r6 != r0) goto L18;
                return r0;
            L11:
                if (this.f28738b.a() != com.obric.autogui.agents.vlm.models.omni.a.l.f28192e) goto L15;
                goto L12
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {562}, d = "filterUploadable", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain")
        static final class q extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f28740a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f28741b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f28742c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f28743d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            /* synthetic */ Object f28744e;
            final /* synthetic */ a f;
            int g;

            q(a r3, d.c.d<? super q> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f28744e = r3;
                this.g |= Integer.MIN_VALUE;
                return a.a(this.f, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain$filterUploadable$keep$1")
        static final class r extends d.c.b.a.l implements d.h.a.b<d.c.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f28745a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.upload.h f28746b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f28747c;

            r(com.obric.autogui.agents.vlm.models.omni.upload.h r3, a r4, d.c.d<? super r> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28746b = r3;
                this.f28747c = r4;
                super(1, r6);
            }

            public final Object a(d.c.d<? super Boolean> r3) {
                return ((r) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), r.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new r(this.f28746b, this.f28747c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super Boolean> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f28745a != 0) goto L14;
                d.o.a(r4);
                if (this.f28746b.l() == false) goto L7;
                OmniDataFeedbackLog r5 = OmniDataFeedbackLog.INSTANCE;
                com.obric.autogui.agents.vlm.models.omni.upload.h r0 = this.f28746b;
                if (r5.isVerboseLogEnabled() == false) goto L11;
                Loog.INSTANCE.w(e.TAG, "drop upload candidate with missing files, files=" + r0.n() + ", missing=" + r0.m());
            L11:
                a.g(this.f28747c).a(this.f28746b);
                a.g(this.f28747c).b(this.f28746b);
                return d.c.b.a.b.a(false);
            L7:
                return d.c.b.a.b.a(true);
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {970}, d = "finishFeedbackOnlyTask", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain")
        static final class s extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f28748a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f28749b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f28750c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f28751d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f28752e;
            /* synthetic */ Object f;
            final /* synthetic */ a g;
            int h;

            s(a r3, d.c.d<? super s> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.g = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                this.f = r7;
                this.h |= Integer.MIN_VALUE;
                return a.a(this.g, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {255}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain$launch$2")
        static final class t extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f28753a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f28754b;

            t(a r3, d.c.d<? super t> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28754b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super d.x> r4) {
                return ((t) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), t.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new t(this.f28754b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r8) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f28753a;
                if (r1 == 0) goto L11;
                if (r1 != 1) goto L10;
                d.o.a(r8);     // Catch: Throwable -> L7
            L15:
                a.c(this.f28754b).set(false);
                if ((!((Collection) ZeusTransformUtils.preCheckCast(a.d(this.f28754b), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L22;
                if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L20;
                Loog.INSTANCE.i(e.TAG, "restart upload for pending request after race");
            L20:
                a.e(this.f28754b);
            L22:
                return d.x.f38692a;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                d.o.a(r8);
                a r9 = this.f28754b;     // Catch: Throwable -> L7
                d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
                this.f28753a = 1;     // Catch: Throwable -> L7
                if (a.a(r9, r2) != r0) goto L15;
                return r0;
            L7:
                th = move-exception;
                a.c(this.f28754b).set(false);
                if ((!((Collection) ZeusTransformUtils.preCheckCast(a.d(this.f28754b), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L26;
            L29:
                throw th;
            L26:
                if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L28;
                Loog.INSTANCE.i(e.TAG, "restart upload for pending request after race");
            L28:
                a.e(this.f28754b);
                goto L29
            }
        }

        /* JADX INFO: compiled from: Comparisons.kt */
        public static final class u<T> implements Comparator {
            public u() {
            }

            @Override // java.util.Comparator
            public final int compare(T r2, T r3) {
                return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin")).h()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin")).h()), Comparable.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: Comparisons.kt */
        public static final class v<T> implements Comparator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Comparator f28755a;

            public v(Comparator r3) {
                this.f28755a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.aiagent.plugin");
            }

            @Override // java.util.Comparator
            public final int compare(T r3, T r4) {
                int r2 = this.f28755a.compare(r3, r4);
                if (r2 != 0) goto L15;
                int r5 = ((com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin")).d();
                if (r5 != null) goto L9;
                r5 = Integer.MAX_VALUE;
            L9:
                Comparable r6 = (Comparable) ZeusTransformUtils.preCheckCast(r5, Comparable.class, "com.obric.aiagent.plugin");
                Integer r7 = ((com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin")).d();
                if (r7 == null) goto L12;
                Object r8 = ZeusTransformUtils.preCheckCast(r7, Comparable.class, "com.obric.aiagent.plugin");
            L14:
                return d.b.a.a(r6, (Comparable) r8);
            L12:
                r8 = ZeusTransformUtils.preCheckCast(Integer.MAX_VALUE, Comparable.class, "com.obric.aiagent.plugin");
                goto L14
            L15:
                return r2;
            }
        }

        /* JADX INFO: compiled from: Comparisons.kt */
        public static final class w<T> implements Comparator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Comparator f28756a;

            public w(Comparator r3) {
                this.f28756a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.aiagent.plugin");
            }

            @Override // java.util.Comparator
            public final int compare(T r4, T r5) {
                int r3 = this.f28756a.compare(r4, r5);
                if (r3 != 0) goto L20;
                File r6 = (File) ZeusTransformUtils.preCheckCast(d.a.p.l(((com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin")).j()), File.class, "com.obric.aiagent.plugin");
                String r7 = null;
                if (r6 == null) goto L8;
                String r8 = r6.getName();
            L9:
                String r1 = "";
                if (r8 != null) goto L12;
                r8 = "";
            L12:
                Comparable r9 = (Comparable) ZeusTransformUtils.preCheckCast(r8, Comparable.class, "com.obric.aiagent.plugin");
                File r10 = (File) ZeusTransformUtils.preCheckCast(d.a.p.l(((com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin")).j()), File.class, "com.obric.aiagent.plugin");
                if (r10 == null) goto L15;
                r7 = r10.getName();
            L15:
                if (r7 == null) goto L19;
                r1 = r7;
            L19:
                return d.b.a.a(r9, (Comparable) ZeusTransformUtils.preCheckCast(r1, Comparable.class, "com.obric.aiagent.plugin"));
            L8:
                r8 = null;
                goto L9
            L20:
                return r3;
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {626}, d = "listPendingFeedbackCandidates", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain")
        static final class x extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f28757a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f28758b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f28759c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f28760d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ a f28761e;
            int f;

            x(a r3, d.c.d<? super x> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28761e = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f28760d = r3;
                this.f |= Integer.MIN_VALUE;
                return a.a(this.f28761e, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {589, 597, 604, 606, 608, 615}, d = "resolveCandidates", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain")
        static final class y extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f28762a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f28763b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f28764c;

            y(a r3, d.c.d<? super y> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f28763b = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f28762a = r3;
                this.f28764c |= Integer.MIN_VALUE;
                return a.a(this.f28763b, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
        @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {755}, d = "resolveFeedbackInfo", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$Drain")
        static final class z extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f28765a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f28766b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f28767c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f28768d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            /* synthetic */ Object f28769e;
            final /* synthetic */ a f;
            int g;

            z(a r3, d.c.d<? super z> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f28769e = r3;
                this.g |= Integer.MIN_VALUE;
                return a.a(this.f, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        public a() {
            this(null, null, null, null, null, null, null, null, false, 511, null);
        }

        private static final boolean b() {
            return false;
        }

        private static final boolean b(String r1) {
            d.h.b.o.e(r1, "it");
            return false;
        }

        private static final boolean d() {
            return true;
        }

        private static final boolean e() {
            return false;
        }

        public static /* synthetic */ boolean lambda$AT90eDrrpSX0uXQwBrRlJo1rR1A() {
            return c();
        }

        /* JADX INFO: renamed from: lambda$QBmeVKgT0rFLwJDuz3gkaPEP-JQ, reason: not valid java name */
        public static /* synthetic */ boolean m786lambda$QBmeVKgT0rFLwJDuz3gkaPEPJQ() {
            return d();
        }

        public static /* synthetic */ boolean lambda$SwD5KKT11zVfAK9HFFh5pE1xYWQ() {
            return e();
        }

        public static /* synthetic */ boolean lambda$UMs1utYcCLLOO4jRr8hE5T9sXGo(String r0) {
            return b(r0);
        }

        /* JADX INFO: renamed from: lambda$yMt4jks-6LNLaqMyFACc-GHlWi4, reason: not valid java name */
        public static /* synthetic */ boolean m787lambda$yMt4jks6LNLaqMyFACcGHlWi4() {
            return b();
        }

        public a(com.obric.autogui.agents.vlm.models.omni.upload.i r3, com.obric.autogui.agents.vlm.models.omni.upload.p r4, com.obric.autogui.agents.vlm.models.omni.upload.b r5, d.h.a.a<Boolean> r6, d.h.a.a<Boolean> r7, d.h.a.a<Boolean> r8, d.h.a.a<Boolean> r9, d.h.a.b<? super String, Boolean> r10, boolean r11) {
            d.h.a.a<Boolean> r12 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a<Boolean> r13 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a<Boolean> r14 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a<Boolean> r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r9, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.b<String, Boolean> r16 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.b.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "store");
            d.h.b.o.e(r4, "feedbackTaskStore");
            d.h.b.o.e(r5, "uploader");
            d.h.b.o.e(r12, "internalUserChecker");
            d.h.b.o.e(r13, "omniRunningChecker");
            d.h.b.o.e(r14, "appForegroundChecker");
            d.h.b.o.e(r15, "inferenceImageBusyChecker");
            d.h.b.o.e(r16, "streamingTaskRunningChecker");
            this.f28648a = r3;
            this.f28649b = r4;
            this.f28650c = r5;
            this.f28651d = r12;
            this.f28652e = r13;
            this.f = r14;
            this.g = r15;
            this.h = r16;
            this.i = r11;
            this.j = new AtomicBoolean(false);
            this.k = new ConcurrentLinkedQueue();
            this.l = new AtomicLong(0);
            this.m = new com.obric.autogui.agents.vlm.models.omni.upload.a();
        }

        public static final /* synthetic */ Object a(a r2, com.obric.autogui.agents.vlm.models.omni.a.c r3, d.c.d r4) {
            return r2.c(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ Object a(a r9, com.obric.autogui.agents.vlm.models.omni.a.c r10, List r11, Map r12, Set r13, Set r14, d.c.d r15) {
            return r9.a(r10, (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ Object a(a r2, com.obric.autogui.agents.vlm.models.omni.a.c r3, Set r4, d.c.d r5) {
            return r2.a(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ Object a(a r9, com.obric.autogui.agents.vlm.models.omni.upload.h r10, com.obric.autogui.agents.vlm.models.omni.a.c r11, int r12, Map r13, Set r14, d.c.d r15) {
            return r9.a(r10, r11, r12, (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ Object a(a r2, com.obric.autogui.agents.vlm.models.omni.upload.h r3, com.obric.autogui.agents.vlm.models.omni.a.c r4, d.c.d r5) {
            return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ Object a(a r2, d.c.d r3) {
            return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ Object a(a r2, String r3, com.obric.autogui.agents.vlm.models.omni.a.c r4, d.c.d r5) {
            return r2.b(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ Object a(a r2, String r3, com.obric.autogui.agents.vlm.models.omni.a.c r4, Map r5, d.c.d r6) {
            return r2.a(r3, r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ Object a(a r2, String r3, com.obric.autogui.agents.vlm.models.omni.upload.h r4, d.c.d r5) {
            return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ Object a(a r8, String r9, String r10, Set r11, Set r12, d.c.d r13) {
            return r8.a(r9, r10, (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ Object a(a r2, String r3, Map r4, d.c.d r5) {
            return r2.a(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ Object a(a r2, Collection r3, d.c.d r4) {
            return r2.a((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ Object a(a r2, List r3, d.c.d r4) {
            return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ Object a(a r2, Set r3, d.c.d r4) {
            return r2.a((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ AtomicLong a(a r0) {
            return r0.l;
        }

        public static final /* synthetic */ boolean a(a r0, String r1, com.obric.autogui.agents.vlm.models.omni.a.l r2) {
            return r0.a(r1, r2);
        }

        public static final /* synthetic */ d.h.a.a b(a r0) {
            return r0.f;
        }

        public static final /* synthetic */ Object b(a r2, com.obric.autogui.agents.vlm.models.omni.a.c r3, d.c.d r4) {
            return r2.b(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ Object b(a r2, List r3, d.c.d r4) {
            return r2.b((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ AtomicBoolean c(a r0) {
            return r0.j;
        }

        public static final /* synthetic */ ConcurrentLinkedQueue d(a r0) {
            return r0.k;
        }

        public static final /* synthetic */ void e(a r0) {
            r0.a();
        }

        public static final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.upload.p f(a r0) {
            return r0.f28649b;
        }

        public static final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.upload.i g(a r0) {
            return r0.f28648a;
        }

        public static final /* synthetic */ boolean h(a r0) {
            return r0.i;
        }

        public /* synthetic */ a(com.obric.autogui.agents.vlm.models.omni.upload.i r17, com.obric.autogui.agents.vlm.models.omni.upload.p r18, com.obric.autogui.agents.vlm.models.omni.upload.b r19, d.h.a.a r20, d.h.a.a r21, d.h.a.a r22, d.h.a.a r23, d.h.a.b r24, boolean r25, int r26, d.h.b.h r27) {
            d.h.a.a r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r20, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r22, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r23, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.b r2 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r24, d.h.a.b.class, "com.obric.aiagent.plugin");
            if ((r26 & 1) == 0) goto L5;
            com.obric.autogui.agents.vlm.models.omni.upload.i r6 = new com.obric.autogui.agents.vlm.models.omni.upload.i(null, null, null, null, null, null, 63, null);
        L7:
            if ((r26 & 2) == 0) goto L9;
            com.obric.autogui.agents.vlm.models.omni.upload.p r7 = new com.obric.autogui.agents.vlm.models.omni.upload.p();
        L11:
            if ((r26 & 4) == 0) goto L13;
            com.obric.autogui.agents.vlm.models.omni.upload.b r8 = new com.obric.autogui.agents.vlm.models.omni.upload.b(null, 0, null, null, 15, null);
        L15:
            if ((r26 & 8) == 0) goto L18;
            r1 = $$Lambda$e$a$yMt4jks6LNLaqMyFACcGHlWi4.INSTANCE;
        L18:
            if ((r26 & 16) == 0) goto L21;
            r3 = $$Lambda$e$a$AT90eDrrpSX0uXQwBrRlJo1rR1A.INSTANCE;
        L21:
            if ((r26 & 32) == 0) goto L24;
            r4 = $$Lambda$e$a$QBmeVKgT0rFLwJDuz3gkaPEPJQ.INSTANCE;
        L24:
            if ((r26 & 64) == 0) goto L27;
            r5 = $$Lambda$e$a$SwD5KKT11zVfAK9HFFh5pE1xYWQ.INSTANCE;
        L27:
            if ((r26 & 128) == 0) goto L30;
            r2 = $$Lambda$e$a$UMs1utYcCLLOO4jRr8hE5T9sXGo.INSTANCE;
        L30:
            if ((r26 & 256) == 0) goto L32;
            boolean r0 = true;
        L33:
            this(r6, r7, r8, r1, r3, r4, r5, r2, r0);
            return;
        L32:
            r0 = r25;
            goto L33
        L13:
            r8 = r19;
            goto L15
        L9:
            r7 = r18;
            goto L11
        L5:
            r6 = r17;
            goto L7
        }

        private static final boolean c() {
            com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
            if (r0 != null) goto L5;
            return false;
        L5:
            if (r0.c() == true) goto L7;
            return false;
        L7:
            if (r0.K() == true) goto L9;
            return false;
        L9:
            return true;
        }

        public static /* synthetic */ void a(a r0, long r1, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L5;
            r1 = 5000;
        L5:
            r0.a(r1);
        }

        public final void a(long r10) {
            long r5 = this.l.incrementAndGet();
            AOThreadingTools.INSTANCE.launchIO((d.h.a.m) ZeusTransformUtils.preCheckCast(new ab(r10, this, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
        }

        public final void a(String r11, com.obric.autogui.agents.vlm.models.omni.a.e r12) {
            d.h.b.o.e(r11, DBDefinition.TASK_ID);
            com.obric.autogui.agents.vlm.models.omni.a.e r0 = null;
            if (r12 == null) goto L5;
            r0 = com.obric.autogui.agents.vlm.models.omni.a.e.a(r12, com.obric.autogui.agents.vlm.models.omni.a.j.f28178a, null, 2, null);
        L5:
            com.obric.autogui.agents.vlm.models.omni.a.e r5 = r0;
            this.f28649b.a(r11, r5);
            com.obric.autogui.agents.vlm.models.omni.a.l r2 = com.obric.autogui.agents.vlm.models.omni.a.l.f28191d;
            if (r5 == null) goto L9;
            com.obric.autogui.agents.vlm.models.omni.a.j r1 = r5.c();
            if (r1 == null) goto L9;
        L10:
            a(new com.obric.autogui.agents.vlm.models.omni.a.c(r2, r11, null, r5, r1, null, 36, null));
            return;
        L9:
            r1 = com.obric.autogui.agents.vlm.models.omni.a.j.f28178a;
            goto L10
        }

        public final Object a(String r13, com.obric.autogui.agents.vlm.models.omni.a.e r14, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.d> r15) {
            d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.d> r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
            if (r14 != null) goto L5;
            r14 = new com.obric.autogui.agents.vlm.models.omni.a.e(null, null, null, null, null, false, null, 127, null);
        L5:
            com.obric.autogui.agents.vlm.models.omni.a.e r7 = com.obric.autogui.agents.vlm.models.omni.a.e.a(r14, com.obric.autogui.agents.vlm.models.omni.a.j.f28179b, null, 2, null);
            com.obric.autogui.agents.vlm.models.omni.a.l r4 = com.obric.autogui.agents.vlm.models.omni.a.l.f28192e;
            if (r7 == null) goto L9;
            com.obric.autogui.agents.vlm.models.omni.a.j r0 = r7.c();
            if (r0 == null) goto L9;
        L11:
            return a(new com.obric.autogui.agents.vlm.models.omni.a.c(r4, r13, null, r7, r0, null, 36, null), r16);
        L9:
            r0 = com.obric.autogui.agents.vlm.models.omni.a.j.f28179b;
            goto L11
        }

        public final void a(com.obric.autogui.agents.vlm.models.omni.a.c r4) {
            d.h.b.o.e(r4, Ext.KEY_REQUEST);
            this.k.add(r4);
            if (this.j.compareAndSet(false, true) == false) goto L5;
            AOThreadingTools.INSTANCE.launchIO((d.h.a.m) ZeusTransformUtils.preCheckCast(new t(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
            return;
        L5:
            if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L10;
            Loog.INSTANCE.i(e.TAG, "queue pending upload, already uploading, trigger=" + r4.a() + ", taskId=" + r4.b());
            return;
        }

        public final Object a(com.obric.autogui.agents.vlm.models.omni.a.c r5, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.d> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            return this.m.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new p(r5, this, null), d.h.a.b.class, "com.obric.aiagent.plugin"), r7);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x009f -> B:25:0x00a2). Please report as a decompilation issue!!! */
        private final Object a(d.c.d<? super d.x> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r10, n.class) == false) goto L7;
            n r0 = (n) ZeusTransformUtils.preCheckCast(r10, n.class, "com.obric.aiagent.plugin");
            if ((r0.f28733d & Integer.MIN_VALUE) == 0) goto L7;
            r0.f28733d -= Integer.MIN_VALUE;
        L8:
            Object r11 = r0.f28731b;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f28733d;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            a this = (a) ZeusTransformUtils.preCheckCast(r0.f28730a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r11);
        L25:
            com.obric.autogui.agents.vlm.models.omni.a.d r12 = (com.obric.autogui.agents.vlm.models.omni.a.d) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.agents.vlm.models.omni.a.d.class, "com.obric.aiagent.plugin");
            if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == true) goto L27;
        L15:
            com.obric.autogui.agents.vlm.models.omni.a.c r13 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(this.k.poll(), com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
            if (r13 != null) goto L20;
            return d.x.f38692a;
        L20:
            if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L22;
            Loog.INSTANCE.i(e.TAG, "upload start: " + r13);
        L22:
            com.obric.autogui.agents.vlm.models.omni.upload.a r4 = this.m;
            d.h.a.b r14 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new o(this, r13, null), d.h.a.b.class, "com.obric.aiagent.plugin");
            r0.f28730a = this;
            r0.f28733d = 1;
            r11 = r4.a(r14, r0);
            if (r11 != r2) goto L25;
            return r2;
        L27:
            Loog.INSTANCE.i(e.TAG, "upload finished: " + r12);
            goto L15
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r11);
        L7:
            r0 = new n(this, r10);
            goto L8
        }

        private final void a() {
            if (this.j.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            AOThreadingTools.INSTANCE.launchIO((d.h.a.m) ZeusTransformUtils.preCheckCast(new ac(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:156:0x0efc -> B:131:0x0d85). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:189:0x115d -> B:190:0x1178). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:191:0x1191 -> B:192:0x11b6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0ac7 -> B:75:0x0ae0). Please report as a decompilation issue!!! */
        /*  JADX ERROR: Types fix failed
            jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 51381. Try increasing type updates limit count.
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:99)
            */
        private final java.lang.Object b(com.obric.autogui.agents.vlm.models.omni.a.c r48, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.d> r49) {
            /*  JADX ERROR: Simple mode code generation failed
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001a: INVOKE (r4v79 ?? I:java.lang.Object) = 
                  (r2v2 d.c.d)
                  (wrap java.lang.Class:0x0018: CONST_CLASS  A[WRAPPED] com.obric.autogui.agents.vlm.models.omni.upload.e$a$l.class)
                  ("com.obric.aiagent.plugin")
                 STATIC call: com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object A[DECLARE_VAR, MD:(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object (m)] in method: com.obric.autogui.agents.vlm.models.omni.upload.e.a.b(com.obric.autogui.agents.vlm.models.omni.a.c, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.d>):java.lang.Object, file: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
                	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
                	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
                	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
                	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
                	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
                	... 48 more
                */
            /*
                Method dump skipped, instruction units count: 5138
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.obric.autogui.agents.vlm.models.omni.upload.e.a.b(com.obric.autogui.agents.vlm.models.omni.a.c, d.c.d):java.lang.Object");
        }

        private final Object c(com.obric.autogui.agents.vlm.models.omni.a.c r8, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.d> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r10, m.class) == false) goto L7;
            m r0 = (m) ZeusTransformUtils.preCheckCast(r10, m.class, "com.obric.aiagent.plugin");
            if ((r0.f28729e & Integer.MIN_VALUE) == 0) goto L7;
            r0.f28729e -= Integer.MIN_VALUE;
        L8:
            Object r11 = r0.f28727c;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f28729e;
            if (r3 == 0) goto L18;
            if (r3 != 1) goto L17;
            long r7 = r0.f28726b;
            com.obric.autogui.agents.vlm.models.omni.a.c r1 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(r0.f28725a, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
            d.o.a(r11);     // Catch: Throwable -> L14
        L23:
            com.obric.autogui.agents.vlm.models.omni.upload.m.f28813a.a((com.obric.autogui.agents.vlm.models.omni.a.d) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.agents.vlm.models.omni.a.d.class, "com.obric.aiagent.plugin"), SystemClock.elapsedRealtime() - r7);     // Catch: Throwable -> L14
            return (com.obric.autogui.agents.vlm.models.omni.a.d) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.agents.vlm.models.omni.a.d.class, "com.obric.aiagent.plugin");
        L14:
            th = th;
        L27:
            com.obric.autogui.agents.vlm.models.omni.upload.m.f28813a.a(r1, SystemClock.elapsedRealtime() - r7, th);
            throw th;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            d.o.a(r11);
            long r5 = SystemClock.elapsedRealtime();
            r0.f28725a = r8;     // Catch: Throwable -> L25
            r0.f28726b = r5;     // Catch: Throwable -> L25
            r0.f28729e = 1;     // Catch: Throwable -> L25
            r11 = b(r8, r0);     // Catch: Throwable -> L25
            if (r11 != r2) goto L22;
            return r2;
        L22:
            r1 = r8;
            r7 = r5;
        L25:
            th = th;
            r1 = r8;
            r7 = r5;
        L7:
            r0 = new m(this, r10);
            goto L8
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x01cc -> B:41:0x01da). Please report as a decompilation issue!!! */
        private final Object a(com.obric.autogui.agents.vlm.models.omni.a.c r28, List<com.obric.autogui.agents.vlm.models.omni.upload.h> r29, Map<String, com.obric.autogui.agents.vlm.models.omni.a.e> r30, Set<String> r31, Set<String> r32, d.c.d<? super List<com.obric.autogui.agents.vlm.models.omni.upload.h>> r33) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.aiagent.plugin");
            Map<String, com.obric.autogui.agents.vlm.models.omni.a.e> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r30, Map.class, "com.obric.aiagent.plugin");
            Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r31, Set.class, "com.obric.aiagent.plugin");
            Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r32, Set.class, "com.obric.aiagent.plugin");
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r33, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r5, c.class) == false) goto L7;
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if ((r6.m & Integer.MIN_VALUE) == 0) goto L7;
            r6.m -= Integer.MIN_VALUE;
            a r7 = this;
        L8:
            Object r8 = r6.k;
            Object r9 = d.c.a.b.a();
            int r10 = r6.m;
            if (r10 == 0) goto L14;
            if (r10 != 1) goto L13;
            com.obric.autogui.agents.vlm.models.omni.upload.h r1 = (com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r6.j, com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin");
            Iterator r11 = (Iterator) ZeusTransformUtils.preCheckCast(r6.i, Iterator.class, "com.obric.aiagent.plugin");
            Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(r6.h, Collection.class, "com.obric.aiagent.plugin");
            Set r13 = (Set) ZeusTransformUtils.preCheckCast(r6.g, Set.class, "com.obric.aiagent.plugin");
            Set r14 = (Set) ZeusTransformUtils.preCheckCast(r6.f, Set.class, "com.obric.aiagent.plugin");
            Set r15 = (Set) ZeusTransformUtils.preCheckCast(r6.f28692e, Set.class, "com.obric.aiagent.plugin");
            Set r16 = (Set) ZeusTransformUtils.preCheckCast(r6.f28691d, Set.class, "com.obric.aiagent.plugin");
            Map<String, com.obric.autogui.agents.vlm.models.omni.a.e> r17 = (Map) ZeusTransformUtils.preCheckCast(r6.f28690c, Map.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.omni.a.c r18 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(r6.f28689b, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
            a r19 = (a) ZeusTransformUtils.preCheckCast(r6.f28688a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r8);
            Map<String, com.obric.autogui.agents.vlm.models.omni.a.e> r110 = r17;
        L41:
            com.obric.autogui.agents.vlm.models.omni.upload.h r111 = r1;
            com.obric.autogui.agents.vlm.models.omni.a.c r20 = r18;
            Collection r112 = r12;
            Map<String, com.obric.autogui.agents.vlm.models.omni.a.e> r21 = r110;
            Object r113 = r9;
            Set r22 = r14;
            r7 = r19;
            com.obric.autogui.agents.vlm.models.omni.a.e r114 = (com.obric.autogui.agents.vlm.models.omni.a.e) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.agents.vlm.models.omni.a.e.class, "com.obric.aiagent.plugin");
            Set r23 = r15;
            Set r24 = r13;
            Set r25 = r16;
        L43:
            boolean r115 = false;
            if (r114 != null) goto L46;
        L48:
            if (r115 == true) goto L51;
        L49:
            Object r116 = r113;
            com.obric.autogui.agents.vlm.models.omni.upload.h r117 = r111;
        L59:
            if (r117 == null) goto L16;
            r112.add(r117);
        L16:
            if (r11.hasNext() == false) goto L62;
            com.obric.autogui.agents.vlm.models.omni.upload.h r118 = (com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin");
            if (r20.f() == true) goto L20;
        L32:
            Object r27 = r116;
            r114 = r20.c();
            if (r114 != null) goto L42;
            r113 = r27;
            r111 = r118;
            goto L43
        L35:
            if (r20.f() == false) goto L37;
            r114 = (com.obric.autogui.agents.vlm.models.omni.a.e) ZeusTransformUtils.preCheckCast(r21.get(r118.a()), com.obric.autogui.agents.vlm.models.omni.a.e.class, "com.obric.aiagent.plugin");
        L42:
            r113 = r27;
            r111 = r118;
            goto L43
        L37:
            String r119 = r118.a();
            r6.f28688a = r7;
            r6.f28689b = r20;
            r6.f28690c = r21;
            r6.f28691d = r25;
            r6.f28692e = r23;
            r6.f = r22;
            r6.g = r24;
            r6.h = r112;
            r6.i = r11;
            r6.j = r118;
            r6.m = 1;
            Object r120 = r7.a(r119, r21, r6);
            if (r120 != r27) goto L40;
            return r27;
        L40:
            Collection r26 = r112;
            r18 = r20;
            r1 = r118;
            r16 = r25;
            r13 = r24;
            r15 = r23;
            r8 = r120;
            r19 = r7;
            r14 = r22;
            r9 = r27;
            r110 = r21;
            r12 = r26;
            goto L41
        L20:
            if (r23.contains(r118.a()) == true) goto L32;
            if (r25.contains(r118.a()) == true) goto L26;
            if (r7.f28649b.b(r118.a()) == false) goto L32;
        L26:
            if (r24.add(r118.a()) == false) goto L63;
            if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L63;
            Object r210 = r116;
            Loog.INSTANCE.w(e.TAG, "defer feedback task because version snapshot is unavailable, taskId=" + r118.a());
            r116 = r210;
            r117 = null;
        L63:
            r116 = r116;
            r117 = null;
            goto L59
        L62:
            return (List) ZeusTransformUtils.preCheckCast(r112, List.class, "com.obric.aiagent.plugin");
        L51:
            if (r22.add(r111.a()) == true) goto L53;
        L55:
            com.obric.autogui.agents.vlm.models.omni.upload.h r121 = com.obric.autogui.agents.vlm.models.omni.upload.h.a(r111, null, null, null, null, null, null, null, 111, null);
            if (r121.k() == false) goto L58;
            r111 = r121;
            goto L49
        L58:
            r111 = null;
            goto L49
        L53:
            if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L55;
            Loog.INSTANCE.i(e.TAG, "suppress feedback images, taskId=" + r111.a() + ", preserve local image files");
            goto L55
        L46:
            if (r114.e() == true) goto L48;
            r115 = true;
            goto L48
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r8);
            Set r34 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
            r24 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
            Iterable r35 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
            r112 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            r116 = r9;
            r22 = r34;
            r23 = r4;
            r25 = r3;
            r21 = r2;
            r11 = r35.iterator();
            r20 = r28;
        L7:
            r7 = this;
            r6 = new c(r7, r5);
            goto L8
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00bd -> B:21:0x00c1). Please report as a decompilation issue!!! */
        private final Object a(List<com.obric.autogui.agents.vlm.models.omni.upload.h> r11, d.c.d<? super List<com.obric.autogui.agents.vlm.models.omni.upload.h>> r12) {
            List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
            d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r14, q.class) == false) goto L7;
            q r0 = (q) ZeusTransformUtils.preCheckCast(r14, q.class, "com.obric.aiagent.plugin");
            if ((r0.g & Integer.MIN_VALUE) == 0) goto L7;
            r0.g -= Integer.MIN_VALUE;
        L8:
            Object r15 = r0.f28744e;
            Object r2 = d.c.a.b.a();
            int r3 = r0.g;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            com.obric.autogui.agents.vlm.models.omni.upload.h r10 = (com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r0.f28743d, com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin");
            Iterator r16 = (Iterator) ZeusTransformUtils.preCheckCast(r0.f28742c, Iterator.class, "com.obric.aiagent.plugin");
            ArrayList r4 = (ArrayList) ZeusTransformUtils.preCheckCast(r0.f28741b, ArrayList.class, "com.obric.aiagent.plugin");
            a r5 = (a) ZeusTransformUtils.preCheckCast(r0.f28740a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r15);
        L22:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r15, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L24;
            r4.add(r10);
        L24:
            a this = r5;
        L16:
            if (r16.hasNext() == false) goto L25;
            com.obric.autogui.agents.vlm.models.omni.upload.h r17 = (com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r16.next(), com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.omni.upload.v r6 = com.obric.autogui.agents.vlm.models.omni.upload.v.f28855a;
            String r7 = r17.a();
            d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new r(r17, this, null), d.h.a.b.class, "com.obric.aiagent.plugin");
            r0.f28740a = this;
            r0.f28741b = r4;
            r0.f28742c = r16;
            r0.f28743d = r17;
            r0.g = 1;
            Object r9 = r6.a(r7, r8, r0);
            if (r9 != r2) goto L20;
            return r2;
        L20:
            r5 = this;
            r10 = r17;
            r15 = r9;
            goto L22
        L25:
            return r4;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r15);
            ArrayList r18 = new ArrayList(r13.size());
            r16 = r13.iterator();
            r4 = r18;
        L7:
            r0 = new q(this, r14);
            goto L8
        }

        private final Object a(com.obric.autogui.agents.vlm.models.omni.a.c r10, Set<String> r11, d.c.d<? super List<com.obric.autogui.agents.vlm.models.omni.upload.h>> r12) {
            Set r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.aiagent.plugin");
            d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r14, y.class) == false) goto L7;
            y r0 = (y) ZeusTransformUtils.preCheckCast(r14, y.class, "com.obric.aiagent.plugin");
            if ((r0.f28764c & Integer.MIN_VALUE) == 0) goto L7;
            r0.f28764c -= Integer.MIN_VALUE;
        L8:
            Object r15 = r0.f28762a;
            Object r2 = d.c.a.b.a();
            List r4 = null;
            switch(r0.f28764c) {
                case 0: goto L18;
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                default: goto L11;
            };
        L12:
            d.o.a(r15);
        L36:
            r4 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin");
        L37:
            if (r4 == null) goto L85;
            return r4;
        L85:
            return d.a.p.b();
        L13:
            d.o.a(r15);
        L60:
            return r15;
        L14:
            d.o.a(r15);
        L56:
            return r15;
        L15:
            d.o.a(r15);
        L50:
            return r15;
        L16:
            d.o.a(r15);
        L71:
            return r15;
        L17:
            d.o.a(r15);
        L83:
            return r15;
        L18:
            d.o.a(r15);
            int r16 = b.f28687a[r10.a().ordinal()];
            boolean r3 = false;
            if (r16 != 1) goto L21;
            String r17 = r10.b();
            CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin");
            if (r18 != null) goto L75;
        L76:
            r3 = true;
        L77:
            if (r3 == true) goto L79;
            com.obric.autogui.agents.vlm.models.omni.upload.i r9 = this.f28648a;
            r0.f28764c = 1;
            r15 = r9.a(r17, r0);
            if (r15 != r2) goto L83;
            return r2;
        L79:
            return d.a.p.b();
        L75:
            if (d.o.o.d(r18) == false) goto L77;
        L21:
            if (r16 != 2) goto L23;
            String r19 = r10.b();
            CharSequence r110 = (CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin");
            if (r110 != null) goto L64;
        L65:
            r3 = true;
        L66:
            if (r3 == true) goto L86;
            com.obric.autogui.agents.vlm.models.omni.upload.i r20 = this.f28648a;
            r0.f28764c = 2;
            r15 = r20.a(r19, r0);
            if (r15 != r2) goto L71;
            return r2;
        L86:
            return d.a.p.b();
        L64:
            if (d.o.o.d(r110) == false) goto L66;
        L23:
            if (r16 == 3) goto L41;
            if (r16 == 4) goto L41;
            if (r16 != 5) goto L40;
            String r111 = r10.b();
            if (r111 == null) goto L37;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r111, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L32;
            r111 = null;
        L32:
            if (r111 == null) goto L37;
            com.obric.autogui.agents.vlm.models.omni.upload.i r21 = this.f28648a;
            r0.f28764c = 6;
            r15 = r21.a(r111, r0);
            if (r15 != r2) goto L36;
            return r2;
        L40:
            throw new d.k();
        L41:
            String r112 = r10.b();
            CharSequence r113 = (CharSequence) ZeusTransformUtils.preCheckCast(r112, CharSequence.class, "com.obric.aiagent.plugin");
            if (r113 != null) goto L44;
        L45:
            r3 = true;
        L46:
            if (r3 == true) goto L52;
            com.obric.autogui.agents.vlm.models.omni.upload.i r22 = this.f28648a;
            r0.f28764c = 3;
            r15 = r22.a(r112, r0);
            if (r15 != r2) goto L50;
            return r2;
        L52:
            if (((Boolean) ZeusTransformUtils.preCheckCast(this.f28651d.invoke(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L57;
            com.obric.autogui.agents.vlm.models.omni.upload.i r23 = this.f28648a;
            r0.f28764c = 4;
            r15 = r23.a(r0);
            if (r15 != r2) goto L56;
            return r2;
        L57:
            Set<String> r114 = d.a.ax.b(r13, (Iterable) ZeusTransformUtils.preCheckCast(com.obric.autogui.agents.vlm.models.omni.upload.v.f28855a.a(), Iterable.class, "com.obric.aiagent.plugin"));
            r0.f28764c = 5;
            r15 = a(r114, r0);
            if (r15 != r2) goto L60;
            return r2;
        L44:
            if (d.o.o.d(r113) == false) goto L46;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L7:
            r0 = new y(this, r14);
            goto L8
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00bd -> B:12:0x0065). Please report as a decompilation issue!!! */
        private final Object a(Set<String> r8, d.c.d<? super List<com.obric.autogui.agents.vlm.models.omni.upload.h>> r9) {
            Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r11, x.class) == false) goto L7;
            x r0 = (x) ZeusTransformUtils.preCheckCast(r11, x.class, "com.obric.aiagent.plugin");
            if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
            r0.f -= Integer.MIN_VALUE;
        L8:
            Object r12 = r0.f28760d;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f;
            if (r3 == 0) goto L15;
            if (r3 != 1) goto L14;
            Iterator r7 = (Iterator) ZeusTransformUtils.preCheckCast(r0.f28759c, Iterator.class, "com.obric.aiagent.plugin");
            Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(r0.f28758b, Collection.class, "com.obric.aiagent.plugin");
            a r4 = (a) ZeusTransformUtils.preCheckCast(r0.f28757a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r12);
            x r6 = r0;
            Collection r1 = r13;
            a r14 = r4;
        L12:
            Object r5 = r2;
            x r15 = r6;
            d.a.p.a(r1, (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin"));
            Collection r16 = r1;
            r0 = r15;
            r2 = r5;
        L21:
            if (r7.hasNext() == false) goto L28;
            String r17 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.omni.upload.i r18 = r14.f28648a;
            r0.f28757a = r14;
            r0.f28758b = r16;
            r0.f28759c = r7;
            r0.f = 1;
            Object r19 = r18.a(r17, r0);
            if (r19 != r2) goto L25;
            return r2;
        L25:
            r6 = r0;
            r1 = r16;
            r12 = r19;
            goto L12
        L28:
            return d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new w((Comparator) ZeusTransformUtils.preCheckCast(new v((Comparator) ZeusTransformUtils.preCheckCast(new u(), Comparator.class, "com.obric.aiagent.plugin")), Comparator.class, "com.obric.aiagent.plugin")), Comparator.class, "com.obric.aiagent.plugin"));
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            d.o.a(r12);
            if (r10.isEmpty() == true) goto L18;
            Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
            r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r21 = r20.iterator();
            r14 = this;
            r7 = r21;
            goto L21
        L18:
            return d.a.p.b();
        L7:
            r0 = new x(this, r11);
            goto L8
        }

        private final Object a(com.obric.autogui.agents.vlm.models.omni.a.c r4, List<com.obric.autogui.agents.vlm.models.omni.upload.h> r5, Set<String> r6, d.c.d<? super List<String>> r7) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            int r11 = b.f28687a[r4.a().ordinal()];
            boolean r0 = true;
            if (r11 != 1) goto L5;
            List r12 = d.a.p.b(r4.b());
        L41:
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
            Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r15 = r13.iterator();
        L43:
            if (r15.hasNext() == false) goto L47;
            String r16 = a((String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin"));
            if (r16 == null) goto L43;
            r14.add(r16);
            goto L43
        L47:
            List r3 = d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
            if (r3.isEmpty() == true) goto L50;
            Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
            Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r17, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r19 = r17.iterator();
        L53:
            if (r19.hasNext() == false) goto L55;
            r18.add(((com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r19.next(), com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin")).a());
            goto L53
        L55:
            Set r20 = d.a.p.q((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
            Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin");
            Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r23 = r21.iterator();
        L57:
            if (r23.hasNext() == false) goto L62;
            Object r24 = r23.next();
            if (r20.contains((String) ZeusTransformUtils.preCheckCast(r24, String.class, "com.obric.aiagent.plugin")) == true) goto L57;
            r22.add(r24);
            goto L57
        L62:
            return (List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.aiagent.plugin");
        L50:
            return d.a.p.b();
        L5:
            if (r11 != 2) goto L7;
            r12 = d.a.p.b(r4.b());
            goto L41
        L7:
            if (r11 != 3) goto L9;
        L29:
            String r25 = r4.b();
            if (r25 != null) goto L33;
            r12 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(d.a.ax.b(r9, (Iterable) ZeusTransformUtils.preCheckCast(com.obric.autogui.agents.vlm.models.omni.upload.v.f28855a.a(), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin"));
            goto L41
        L33:
            if (r9.contains(r25) == false) goto L35;
        L38:
            r12 = d.a.p.a(r25);
            goto L41
        L35:
            if (com.obric.autogui.agents.vlm.models.omni.upload.v.f28855a.f(r25) == com.obric.autogui.agents.vlm.models.omni.upload.x.f28883d) goto L38;
            r12 = d.a.p.b();
            goto L41
        L9:
            if (r11 == 4) goto L29;
            if (r11 != 5) goto L28;
            String r26 = r4.b();
            r12 = null;
            if (r26 != null) goto L15;
        L25:
            if (r12 != null) goto L41;
            r12 = d.a.p.b();
            goto L41
        L15:
            if (r9.contains(r26) == false) goto L17;
        L20:
            if (r0 == true) goto L23;
            r26 = null;
        L23:
            if (r26 == null) goto L25;
            r12 = d.a.p.a(r26);
            goto L25
        L17:
            if (com.obric.autogui.agents.vlm.models.omni.upload.v.f28855a.f(r26) == com.obric.autogui.agents.vlm.models.omni.upload.x.f28883d) goto L20;
            r0 = false;
            goto L20
        L28:
            throw new d.k();
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0189 -> B:30:0x018c). Please report as a decompilation issue!!! */
        private final Object b(List<com.obric.autogui.agents.vlm.models.omni.upload.h> r12, d.c.d<? super Map<String, Integer>> r13) {
            List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
            d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r15, f.class) == false) goto L7;
            f r0 = (f) ZeusTransformUtils.preCheckCast(r15, f.class, "com.obric.aiagent.plugin");
            if ((r0.j & Integer.MIN_VALUE) == 0) goto L7;
            r0.j -= Integer.MIN_VALUE;
        L8:
            Object r16 = r0.h;
            Object r2 = d.c.a.b.a();
            int r3 = r0.j;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            Object r11 = r0.g;
            Map r17 = (Map) ZeusTransformUtils.preCheckCast(r0.f, Map.class, "com.obric.aiagent.plugin");
            String r4 = (String) ZeusTransformUtils.preCheckCast(r0.f28703e, String.class, "com.obric.aiagent.plugin");
            Iterator r5 = (Iterator) ZeusTransformUtils.preCheckCast(r0.f28702d, Iterator.class, "com.obric.aiagent.plugin");
            LinkedHashMap r6 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(r0.f28701c, LinkedHashMap.class, "com.obric.aiagent.plugin");
            Map r7 = (Map) ZeusTransformUtils.preCheckCast(r0.f28700b, Map.class, "com.obric.aiagent.plugin");
            a r8 = (a) ZeusTransformUtils.preCheckCast(r0.f28699a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r16);
            Object r18 = r11;
            a this = r8;
            Object r9 = r16;
            Map r19 = r17;
        L30:
            Integer r10 = (Integer) ZeusTransformUtils.preCheckCast(r9, Integer.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L33;
            int r20 = r10.intValue();
        L34:
            r19.put(r18, d.c.b.a.b.a(r20));
        L26:
            if (r5.hasNext() == false) goto L36;
            r18 = r5.next();
            r19 = (Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.aiagent.plugin");
            r4 = (String) ZeusTransformUtils.preCheckCast(r18, String.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.omni.upload.i r21 = this.f28648a;
            r0.f28699a = this;
            r0.f28700b = r7;
            r0.f28701c = r6;
            r0.f28702d = r5;
            r0.f28703e = r4;
            r0.f = r19;
            r0.g = r18;
            r0.j = 1;
            r9 = r21.b(r4, r0);
            if (r9 != r2) goto L30;
            return r2;
        L36:
            return (Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.aiagent.plugin");
        L33:
            r20 = this.a((Integer) ZeusTransformUtils.preCheckCast(r7.get(r4), Integer.class, "com.obric.aiagent.plugin"));
            goto L34
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r16);
            Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
            Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r111 = r110.iterator();
        L16:
            if (r111.hasNext() == false) goto L20;
            com.obric.autogui.agents.vlm.models.omni.upload.t r23 = ((com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r111.next(), com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin")).e();
            if (r23 == null) goto L16;
            r22.add(r23);
            goto L16
        L20:
            Map r112 = d.a.af.a((d.a.ae) ZeusTransformUtils.preCheckCast(new C0718e((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), d.a.ae.class, "com.obric.aiagent.plugin"));
            Iterable r113 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
            Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r113, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r114 = r113.iterator();
        L22:
            if (r114.hasNext() == false) goto L24;
            r24.add(((com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r114.next(), com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin")).a());
            goto L22
        L24:
            Iterable r115 = (Iterable) ZeusTransformUtils.preCheckCast(d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r24, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");
            LinkedHashMap r25 = new LinkedHashMap(d.l.n.c(ao.a(d.a.p.a(r115, 10)), 16));
            r5 = r115.iterator();
            r7 = r112;
            r6 = r25;
        L7:
            r0 = new f(this, r15);
            goto L8
        }

        private final Object a(com.obric.autogui.agents.vlm.models.omni.upload.h r19, com.obric.autogui.agents.vlm.models.omni.a.c r20, int r21, Map<String, com.obric.autogui.agents.vlm.models.omni.a.e> r22, Set<String> r23, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.c> r24) {
            Map<String, com.obric.autogui.agents.vlm.models.omni.a.e> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin");
            Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r23, Set.class, "com.obric.aiagent.plugin");
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r4, g.class) == false) goto L7;
            g r5 = (g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.aiagent.plugin");
            if ((r5.g & Integer.MIN_VALUE) == 0) goto L7;
            r5.g -= Integer.MIN_VALUE;
        L8:
            Object r6 = r5.f28708e;
            Object r7 = d.c.a.b.a();
            int r8 = r5.g;
            boolean r9 = true;
            if (r8 == 0) goto L14;
            if (r8 != 1) goto L13;
            int r0 = r5.f28707d;
            Set r2 = (Set) ZeusTransformUtils.preCheckCast(r5.f28706c, Set.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.omni.a.c r10 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(r5.f28705b, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.omni.upload.h r11 = (com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r5.f28704a, com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin");
            d.o.a(r6);
            int r12 = r0;
            com.obric.autogui.agents.vlm.models.omni.a.c r13 = r10;
            r3 = r2;
        L23:
            com.obric.autogui.agents.vlm.models.omni.a.e r14 = (com.obric.autogui.agents.vlm.models.omni.a.e) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.agents.vlm.models.omni.a.e.class, "com.obric.aiagent.plugin");
        L24:
            com.obric.autogui.agents.vlm.models.omni.a.e r15 = r14;
        L27:
            if (r13.a() != com.obric.autogui.agents.vlm.models.omni.a.l.f28191d) goto L29;
        L34:
            com.obric.autogui.agents.vlm.models.omni.a.j r16 = r13.d();
            if (r16 != null) goto L43;
            if (r15 == null) goto L38;
            r16 = r15.c();
        L39:
            if (r16 != null) goto L43;
            if (r9 == false) goto L42;
            r16 = com.obric.autogui.agents.vlm.models.omni.a.j.f28178a;
            goto L43
        L42:
            r16 = com.obric.autogui.agents.vlm.models.omni.a.j.f28179b;
            goto L43
        L38:
            r16 = null;
        L43:
            com.obric.autogui.agents.vlm.models.omni.a.j r17 = r16;
            String r18 = r13.b();
            if (r18 != null) goto L47;
            r18 = r11.a();
        L47:
            return com.obric.autogui.agents.vlm.models.omni.a.c.a(r13, null, r18, d.c.b.a.b.a(d.l.n.c(r12, 0)), r15, r17, null, 33, null);
        L29:
            if (r13.a() == com.obric.autogui.agents.vlm.models.omni.a.l.f28192e) goto L34;
            if (r3.contains(r11.a()) == true) goto L34;
            r9 = false;
            goto L34
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r6);
            com.obric.autogui.agents.vlm.models.omni.a.e r25 = r20.c();
            if (r25 == null) goto L17;
            r13 = r20;
            r12 = r21;
            r15 = r25;
            r11 = r19;
            goto L27
        L17:
            if (r20.f() == false) goto L19;
            r14 = (com.obric.autogui.agents.vlm.models.omni.a.e) ZeusTransformUtils.preCheckCast(r1.get(r19.a()), com.obric.autogui.agents.vlm.models.omni.a.e.class, "com.obric.aiagent.plugin");
            r11 = r19;
            r13 = r20;
            r12 = r21;
            goto L24
        L19:
            String r26 = r19.a();
            r5.f28704a = r19;
            r13 = r20;
            r5.f28705b = r13;
            r5.f28706c = r3;
            r12 = r21;
            r5.f28707d = r12;
            r5.g = 1;
            r6 = a(r26, r1, r5);
            if (r6 != r7) goto L22;
            return r7;
        L22:
            r11 = r19;
        L7:
            r5 = new g(this, r4);
            goto L8
        }

        private final Object a(String r10, com.obric.autogui.agents.vlm.models.omni.a.c r11, Map<String, com.obric.autogui.agents.vlm.models.omni.a.e> r12, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.c> r13) {
            Map<String, com.obric.autogui.agents.vlm.models.omni.a.e> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
            d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r15, d.class) == false) goto L7;
            d r0 = (d) ZeusTransformUtils.preCheckCast(r15, d.class, "com.obric.aiagent.plugin");
            if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
            r0.f -= Integer.MIN_VALUE;
        L8:
            Object r16 = r0.f28696d;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            r14 = (Map) ZeusTransformUtils.preCheckCast(r0.f28695c, Map.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.omni.a.c r9 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(r0.f28694b, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
            r10 = (String) ZeusTransformUtils.preCheckCast(r0.f28693a, String.class, "com.obric.aiagent.plugin");
            d.o.a(r16);
            r11 = r9;
        L22:
            com.obric.autogui.agents.vlm.models.omni.a.e r17 = (com.obric.autogui.agents.vlm.models.omni.a.e) ZeusTransformUtils.preCheckCast(r16, com.obric.autogui.agents.vlm.models.omni.a.e.class, "com.obric.aiagent.plugin");
        L23:
            String r4 = r10;
            com.obric.autogui.agents.vlm.models.omni.a.c r1 = r11;
            com.obric.autogui.agents.vlm.models.omni.a.e r5 = r17;
            Integer r6 = d.c.b.a.b.a(0);
            com.obric.autogui.agents.vlm.models.omni.a.j r18 = r1.d();
            if (r18 != null) goto L37;
            if (r5 == null) goto L27;
            r18 = r5.c();
        L28:
            if (r18 != null) goto L37;
            if (r14.containsKey(r4) == false) goto L32;
        L35:
            r18 = com.obric.autogui.agents.vlm.models.omni.a.j.f28178a;
            goto L37
        L32:
            if (r1.a() == com.obric.autogui.agents.vlm.models.omni.a.l.f28191d) goto L35;
            r18 = com.obric.autogui.agents.vlm.models.omni.a.j.f28179b;
            goto L37
        L27:
            r18 = null;
        L37:
            return com.obric.autogui.agents.vlm.models.omni.a.c.a(r1, null, r4, r6, r5, r18, null, 33, null);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r16);
            r17 = r11.c();
            if (r17 != null) goto L23;
            if (r11.f() == false) goto L19;
            r17 = (com.obric.autogui.agents.vlm.models.omni.a.e) ZeusTransformUtils.preCheckCast(r14.get(r10), com.obric.autogui.agents.vlm.models.omni.a.e.class, "com.obric.aiagent.plugin");
            goto L23
        L19:
            r0.f28693a = r10;
            r0.f28694b = r11;
            r0.f28695c = r14;
            r0.f = 1;
            r16 = a(r10, r14, r0);
            if (r16 != r2) goto L22;
            return r2;
        L7:
            r0 = new d(this, r15);
            goto L8
        }

        private final Object a(String r6, Map<String, com.obric.autogui.agents.vlm.models.omni.a.e> r7, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.e> r8) {
            Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r10, z.class) == false) goto L7;
            z r0 = (z) ZeusTransformUtils.preCheckCast(r10, z.class, "com.obric.aiagent.plugin");
            if ((r0.g & Integer.MIN_VALUE) == 0) goto L7;
            r0.g -= Integer.MIN_VALUE;
        L8:
            Object r11 = r0.f28769e;
            Object r2 = d.c.a.b.a();
            int r3 = r0.g;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            r6 = (String) ZeusTransformUtils.preCheckCast(r0.f28768d, String.class, "com.obric.aiagent.plugin");
            r9 = (Map) ZeusTransformUtils.preCheckCast(r0.f28767c, Map.class, "com.obric.aiagent.plugin");
            Map r5 = (Map) ZeusTransformUtils.preCheckCast(r0.f28766b, Map.class, "com.obric.aiagent.plugin");
            String r1 = (String) ZeusTransformUtils.preCheckCast(r0.f28765a, String.class, "com.obric.aiagent.plugin");
            d.o.a(r11);
        L20:
            r9.put(r6, r11);
            r9 = r5;
            r6 = r1;
        L22:
            return r9.get(r6);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r11);
            if (r9.containsKey(r6) == true) goto L22;
            com.obric.autogui.agents.vlm.models.omni.upload.p r12 = this.f28649b;
            r0.f28765a = r6;
            r0.f28766b = r9;
            r0.f28767c = r9;
            r0.f28768d = r6;
            r0.g = 1;
            r11 = r12.a(r6, r0);
            if (r11 != r2) goto L19;
            return r2;
        L19:
            r1 = r6;
            r5 = r9;
        L7:
            r0 = new z(this, r10);
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0176 -> B:32:0x0177). Please report as a decompilation issue!!! */
        private final Object a(com.obric.autogui.agents.vlm.models.omni.upload.h r12, com.obric.autogui.agents.vlm.models.omni.a.c r13, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.i> r14) {
            d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r15, ag.class) == false) goto L7;
            ag r1 = (ag) ZeusTransformUtils.preCheckCast(r15, ag.class, "com.obric.aiagent.plugin");
            if ((r1.i & Integer.MIN_VALUE) == 0) goto L7;
            r1.i -= Integer.MIN_VALUE;
        L8:
            Object r16 = r1.g;
            Object r3 = d.c.a.b.a();
            int r4 = r1.i;
            if (r4 == 0) goto L16;
            if (r4 == 1) goto L15;
            if (r4 != 2) goto L14;
            d.h.b.z.f r11 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r1.f, d.h.b.z.f.class, "com.obric.aiagent.plugin");
            d.h.b.z.d r17 = (d.h.b.z.d) ZeusTransformUtils.preCheckCast(r1.f28686e, d.h.b.z.d.class, "com.obric.aiagent.plugin");
            d.h.b.z.f r18 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r1.f28685d, d.h.b.z.f.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.omni.a.c r5 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(r1.f28684c, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.omni.upload.h r7 = (com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r1.f28683b, com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin");
            a r0 = (a) ZeusTransformUtils.preCheckCast(r1.f28682a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r16);
            T r19 = r16;
        L32:
            r11.f38504a = r19;
            r11 = r18;
        L22:
            if (ZeusTransformUtils.instanceOf(r11.f38504a, com.obric.autogui.agents.vlm.models.omni.a.i.c.class) == false) goto L34;
            if (r17.f38502a >= 2) goto L34;
            r17.f38502a++;
            if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L28;
            Loog.INSTANCE.w(e.TAG, "upload server error, retry=" + r17.f38502a + "/2, files=" + r7.n() + ", code=" + ((com.obric.autogui.agents.vlm.models.omni.a.i.c) ZeusTransformUtils.preCheckCast(r11.f38504a, com.obric.autogui.agents.vlm.models.omni.a.i.c.class, "com.obric.aiagent.plugin")).a() + ", reason=" + ((com.obric.autogui.agents.vlm.models.omni.a.i.c) ZeusTransformUtils.preCheckCast(r11.f38504a, com.obric.autogui.agents.vlm.models.omni.a.i.c.class, "com.obric.aiagent.plugin")).b());
        L28:
            com.obric.autogui.agents.vlm.models.omni.upload.b r110 = r0.f28650c;
            int r111 = r17.f38502a;
            r1.f28682a = r0;
            r1.f28683b = r7;
            r1.f28684c = r5;
            r1.f28685d = r11;
            r1.f28686e = r17;
            r1.f = r11;
            r1.i = 2;
            Object r112 = r110.a(r7, r5, r111, r1);
            if (r112 != r3) goto L31;
            return r3;
        L31:
            r18 = r11;
            r19 = r112;
        L34:
            return r11.f38504a;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            d.h.b.z.f r113 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r1.f28686e, d.h.b.z.f.class, "com.obric.aiagent.plugin");
            d.h.b.z.f r114 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r1.f28685d, d.h.b.z.f.class, "com.obric.aiagent.plugin");
            r13 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(r1.f28684c, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.omni.upload.h r6 = (com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r1.f28683b, com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin");
            r0 = (a) ZeusTransformUtils.preCheckCast(r1.f28682a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r16);
            T r115 = r16;
        L20:
            r113.f38504a = r115;
            r7 = r6;
            r5 = r13;
            d.h.b.z.f r10 = r114;
            r17 = new d.h.b.z.d();
            r11 = r10;
            goto L22
        L16:
            d.o.a(r16);
            d.h.b.z.f r116 = new d.h.b.z.f();
            com.obric.autogui.agents.vlm.models.omni.upload.b r2 = this.f28650c;
            r1.f28682a = this;
            r1.f28683b = r12;
            r1.f28684c = r13;
            r1.f28685d = r116;
            r1.f28686e = r116;
            r1.i = 1;
            Object r8 = r2.a(r12, r13, 0, r1);
            if (r8 != r3) goto L19;
            return r3;
        L19:
            r6 = r12;
            r114 = r116;
            r115 = r8;
            r0 = this;
            r113 = r114;
        L7:
            r1 = new ag(this, r15);
            goto L8
        }

        private final Object b(com.obric.autogui.agents.vlm.models.omni.upload.h r6, com.obric.autogui.agents.vlm.models.omni.a.c r7, d.c.d<? super C0717a> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            return com.obric.autogui.agents.vlm.models.omni.upload.v.f28855a.a(r6.a(), (d.h.a.b) ZeusTransformUtils.preCheckCast(new af(this, r6, r7, null), d.h.a.b.class, "com.obric.aiagent.plugin"), r9);
        }

        private final Object a(String r5, com.obric.autogui.agents.vlm.models.omni.a.c r6, d.c.d<? super C0717a> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            return com.obric.autogui.agents.vlm.models.omni.upload.v.f28855a.a(r5, (d.h.a.b) ZeusTransformUtils.preCheckCast(new ae(this, r5, r6, null), d.h.a.b.class, "com.obric.aiagent.plugin"), r8);
        }

        private final Object a(Collection<String> r9, d.c.d<? super d.x> r10) {
            Collection r11 = (Collection) ZeusTransformUtils.wrapperContextForParams(r9, Collection.class, "com.obric.aiagent.plugin");
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r12, h.class) == false) goto L7;
            h r0 = (h) ZeusTransformUtils.preCheckCast(r12, h.class, "com.obric.aiagent.plugin");
            if ((r0.f28713e & Integer.MIN_VALUE) == 0) goto L7;
            r0.f28713e -= Integer.MIN_VALUE;
        L8:
            Object r13 = r0.f28711c;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f28713e;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            Iterator r8 = (Iterator) ZeusTransformUtils.preCheckCast(r0.f28710b, Iterator.class, "com.obric.aiagent.plugin");
            a r14 = (a) ZeusTransformUtils.preCheckCast(r0.f28709a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r13);
        L16:
            if (r8.hasNext() == false) goto L21;
            String r15 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.omni.upload.v r4 = com.obric.autogui.agents.vlm.models.omni.upload.v.f28855a;
            d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new i(r15, r14, null), d.h.a.b.class, "com.obric.aiagent.plugin");
            r0.f28709a = r14;
            r0.f28710b = r8;
            r0.f28713e = 1;
            if (r4.a(r15, r5, r0) != r2) goto L16;
            return r2;
        L21:
            return d.x.f38692a;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r13);
            Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
            r14 = this;
            r8 = r16;
        L7:
            r0 = new h(this, r12);
            goto L8
        }

        private final Object a(String r8, com.obric.autogui.agents.vlm.models.omni.upload.h r9, d.c.d<? super Boolean> r10) {
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r11, aa.class) == false) goto L7;
            aa r0 = (aa) ZeusTransformUtils.preCheckCast(r11, aa.class, "com.obric.aiagent.plugin");
            if ((r0.f28660e & Integer.MIN_VALUE) == 0) goto L7;
            r0.f28660e -= Integer.MIN_VALUE;
        L8:
            Object r12 = r0.f28658c;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f28660e;
            boolean r4 = true;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            r9 = (com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(r0.f28657b, com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin");
            r8 = (String) ZeusTransformUtils.preCheckCast(r0.f28656a, String.class, "com.obric.aiagent.plugin");
            d.o.a(r12);
        L17:
            List r7 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L31;
            com.obric.autogui.agents.vlm.models.omni.upload.h r1 = (com.obric.autogui.agents.vlm.models.omni.upload.h) ZeusTransformUtils.preCheckCast(d.a.p.p(r7), com.obric.autogui.agents.vlm.models.omni.upload.h.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L22;
            boolean r5 = false;
        L32:
            com.obric.autogui.agents.vlm.models.omni.upload.x r13 = com.obric.autogui.agents.vlm.models.omni.upload.v.f28855a.f(r8);
            int r14 = r7.size();
            if (r9 != null) goto L37;
            r4 = false;
        L37:
            return com.obric.autogui.agents.vlm.models.omni.upload.w.a(r13, r14, r4, r5);
        L22:
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r9.j(), Iterable.class, "com.obric.aiagent.plugin");
            Collection r15 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin");
            Iterator r16 = r6.iterator();
        L24:
            if (r16.hasNext() == false) goto L26;
            r15.add(((File) ZeusTransformUtils.preCheckCast(r16.next(), File.class, "com.obric.aiagent.plugin")).getAbsolutePath());
            goto L24
        L26:
            Set r17 = (Set) ZeusTransformUtils.preCheckCast(r15, Set.class, "com.obric.aiagent.plugin");
            Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r1.j(), Iterable.class, "com.obric.aiagent.plugin");
            Collection r19 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin");
            Iterator r20 = r18.iterator();
        L28:
            if (r20.hasNext() == false) goto L30;
            r19.add(((File) ZeusTransformUtils.preCheckCast(r20.next(), File.class, "com.obric.aiagent.plugin")).getAbsolutePath());
            goto L28
        L30:
            r5 = com.obric.autogui.agents.vlm.models.omni.upload.f.a(r17, (Set) ZeusTransformUtils.preCheckCast(r19, Set.class, "com.obric.aiagent.plugin"));
            goto L32
        L31:
            r5 = true;
            goto L32
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r12);
            com.obric.autogui.agents.vlm.models.omni.upload.i r21 = this.f28648a;
            r0.f28656a = r8;
            r0.f28657b = r9;
            r0.f28660e = 1;
            r12 = r21.a(r8, r0);
            if (r12 != r2) goto L17;
            return r2;
        L7:
            r0 = new aa(this, r11);
            goto L8
        }

        private final boolean a(String r3, com.obric.autogui.agents.vlm.models.omni.a.l r4) {
            if (r4 != com.obric.autogui.agents.vlm.models.omni.a.l.f28190c) goto L14;
            if (com.obric.autogui.agents.vlm.models.omni.upload.v.f28855a.f(r3) == com.obric.autogui.agents.vlm.models.omni.upload.x.f28881b) goto L7;
            return true;
        L7:
            if (((Boolean) ZeusTransformUtils.preCheckCast(this.h.invoke(r3), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L10;
            return true;
        L10:
            return ((Boolean) ZeusTransformUtils.preCheckCast(this.g.invoke(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        L14:
            return ((Boolean) ZeusTransformUtils.preCheckCast(this.f28652e.invoke(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0172 -> B:32:0x0173). Please report as a decompilation issue!!! */
        private final Object b(String r12, com.obric.autogui.agents.vlm.models.omni.a.c r13, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.i> r14) {
            d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r15, ad.class) == false) goto L7;
            ad r1 = (ad) ZeusTransformUtils.preCheckCast(r15, ad.class, "com.obric.aiagent.plugin");
            if ((r1.i & Integer.MIN_VALUE) == 0) goto L7;
            r1.i -= Integer.MIN_VALUE;
        L8:
            Object r16 = r1.g;
            Object r3 = d.c.a.b.a();
            int r4 = r1.i;
            if (r4 == 0) goto L16;
            if (r4 == 1) goto L15;
            if (r4 != 2) goto L14;
            d.h.b.z.f r11 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r1.f, d.h.b.z.f.class, "com.obric.aiagent.plugin");
            d.h.b.z.d r17 = (d.h.b.z.d) ZeusTransformUtils.preCheckCast(r1.f28671e, d.h.b.z.d.class, "com.obric.aiagent.plugin");
            d.h.b.z.f r18 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r1.f28670d, d.h.b.z.f.class, "com.obric.aiagent.plugin");
            com.obric.autogui.agents.vlm.models.omni.a.c r5 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(r1.f28669c, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
            String r7 = (String) ZeusTransformUtils.preCheckCast(r1.f28668b, String.class, "com.obric.aiagent.plugin");
            a r0 = (a) ZeusTransformUtils.preCheckCast(r1.f28667a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r16);
            T r19 = r16;
        L32:
            r11.f38504a = r19;
            r11 = r18;
        L22:
            if (ZeusTransformUtils.instanceOf(r11.f38504a, com.obric.autogui.agents.vlm.models.omni.a.i.c.class) == false) goto L34;
            if (r17.f38502a >= 2) goto L34;
            r17.f38502a++;
            if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L28;
            Loog.INSTANCE.w(e.TAG, "feedback-only upload server error, retry=" + r17.f38502a + "/2, taskId=" + r7 + ", code=" + ((com.obric.autogui.agents.vlm.models.omni.a.i.c) ZeusTransformUtils.preCheckCast(r11.f38504a, com.obric.autogui.agents.vlm.models.omni.a.i.c.class, "com.obric.aiagent.plugin")).a() + ", reason=" + ((com.obric.autogui.agents.vlm.models.omni.a.i.c) ZeusTransformUtils.preCheckCast(r11.f38504a, com.obric.autogui.agents.vlm.models.omni.a.i.c.class, "com.obric.aiagent.plugin")).b());
        L28:
            com.obric.autogui.agents.vlm.models.omni.upload.b r110 = r0.f28650c;
            int r111 = r17.f38502a;
            r1.f28667a = r0;
            r1.f28668b = r7;
            r1.f28669c = r5;
            r1.f28670d = r11;
            r1.f28671e = r17;
            r1.f = r11;
            r1.i = 2;
            Object r112 = r110.a(r7, r5, r111, r1);
            if (r112 != r3) goto L31;
            return r3;
        L31:
            r18 = r11;
            r19 = r112;
        L34:
            return r11.f38504a;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            d.h.b.z.f r113 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r1.f28671e, d.h.b.z.f.class, "com.obric.aiagent.plugin");
            d.h.b.z.f r114 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r1.f28670d, d.h.b.z.f.class, "com.obric.aiagent.plugin");
            r13 = (com.obric.autogui.agents.vlm.models.omni.a.c) ZeusTransformUtils.preCheckCast(r1.f28669c, com.obric.autogui.agents.vlm.models.omni.a.c.class, "com.obric.aiagent.plugin");
            String r6 = (String) ZeusTransformUtils.preCheckCast(r1.f28668b, String.class, "com.obric.aiagent.plugin");
            r0 = (a) ZeusTransformUtils.preCheckCast(r1.f28667a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r16);
            T r115 = r16;
        L20:
            r113.f38504a = r115;
            r7 = r6;
            r5 = r13;
            d.h.b.z.f r10 = r114;
            r17 = new d.h.b.z.d();
            r11 = r10;
            goto L22
        L16:
            d.o.a(r16);
            d.h.b.z.f r116 = new d.h.b.z.f();
            com.obric.autogui.agents.vlm.models.omni.upload.b r2 = this.f28650c;
            r1.f28667a = this;
            r1.f28668b = r12;
            r1.f28669c = r13;
            r1.f28670d = r116;
            r1.f28671e = r116;
            r1.i = 1;
            Object r8 = r2.a(r12, r13, 0, r1);
            if (r8 != r3) goto L19;
            return r3;
        L19:
            r6 = r12;
            r114 = r116;
            r115 = r8;
            r0 = this;
            r113 = r114;
        L7:
            r1 = new ad(this, r15);
            goto L8
        }

        private final Object a(Map<String, String> r9, Set<String> r10, Set<String> r11, d.c.d<? super d.x> r12) {
            Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
            Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.aiagent.plugin");
            Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            Object r8 = com.obric.autogui.agents.vlm.models.omni.upload.f.a(r2, r3, r4, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new k(this.f28649b), d.h.a.m.class, "com.obric.aiagent.plugin"), r7);
            if (r8 != d.c.a.b.a()) goto L6;
            return r8;
        L6:
            return d.x.f38692a;
        }

        private final Object a(String r6, String r7, Set<String> r8, Set<String> r9, d.c.d<? super d.x> r10) {
            Set r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.aiagent.plugin");
            Set r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.aiagent.plugin");
            d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r13, s.class) == false) goto L7;
            s r0 = (s) ZeusTransformUtils.preCheckCast(r13, s.class, "com.obric.aiagent.plugin");
            if ((r0.h & Integer.MIN_VALUE) == 0) goto L7;
            r0.h -= Integer.MIN_VALUE;
        L8:
            Object r14 = r0.f;
            Object r2 = d.c.a.b.a();
            int r3 = r0.h;
            boolean r4 = true;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            r12 = (Set) ZeusTransformUtils.preCheckCast(r0.f28752e, Set.class, "com.obric.aiagent.plugin");
            r11 = (Set) ZeusTransformUtils.preCheckCast(r0.f28751d, Set.class, "com.obric.aiagent.plugin");
            r7 = (String) ZeusTransformUtils.preCheckCast(r0.f28750c, String.class, "com.obric.aiagent.plugin");
            r6 = (String) ZeusTransformUtils.preCheckCast(r0.f28749b, String.class, "com.obric.aiagent.plugin");
            a this = (a) ZeusTransformUtils.preCheckCast(r0.f28748a, a.class, "com.obric.aiagent.plugin");
            d.o.a(r14);
        L18:
            if (((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L20;
            r11.add(r6);
            if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L34;
            Loog.INSTANCE.w(e.TAG, "retain feedback task because suppressed files still exist, taskId=" + r6);
        L34:
            return d.x.f38692a;
        L20:
            if (r7 != null) goto L22;
        L24:
            r4 = false;
        L25:
            if (r4 == false) goto L27;
            d.c.b.a.b.a(r12.add(r6));
            goto L34
        L27:
            r11.add(r6);
            if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L34;
            Loog.INSTANCE.i(e.TAG, "retain feedback task because version changed after upload, taskId=" + r6);
            goto L34
        L22:
            if (this.f28649b.a(r6, r7) != true) goto L24;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            d.o.a(r14);
            com.obric.autogui.agents.vlm.models.omni.upload.i r15 = this.f28648a;
            r0.f28748a = this;
            r0.f28749b = r6;
            r0.f28750c = r7;
            r0.f28751d = r11;
            r0.f28752e = r12;
            r0.h = 1;
            r14 = r15.a(r6, r0);
            if (r14 != r2) goto L18;
            return r2;
        L7:
            r0 = new s(this, r13);
            goto L8
        }

        private final String a(String r3) {
            if (r3 == null) goto L17;
            String r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (r4 != null) goto L7;
            return null;
        L7:
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
            r4 = null;
        L10:
            if (r4 == null) goto L19;
            String r5 = com.obric.autogui.agents.vlm.models.omni.upload.r.f28823b.a(r4);
            if (r5 != null) goto L14;
            return null;
        L14:
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L16;
            return null;
        L16:
            return r5;
        L19:
            return null;
        L17:
            return null;
        }

        private final int a(Integer r1) {
            if (r1 != null) goto L6;
            return 0;
        L6:
            return r1.intValue();
        }
    }

    /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
    /* synthetic */ class b extends d.h.b.l implements d.h.a.a<Boolean> {
        b(Object r8) {
            super(0, r8, l.class, "isBusy", "isBusy()Z", 0);
        }

        public final Boolean a() {
            return Boolean.valueOf(((l) ZeusTransformUtils.preCheckCast(this.receiver, l.class, "com.obric.aiagent.plugin")).a());
        }

        @Override // d.h.a.a
        public /* synthetic */ Boolean invoke() {
            return a();
        }
    }

    /* JADX INFO: compiled from: OmniDataFeedbackUploadCenter.kt */
    @d.c.b.a.f(b = "OmniDataFeedbackUploadCenter.kt", c = {169}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$uploadForDataFeedbackBlocking$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.d>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f28770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f28771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.agents.vlm.models.omni.a.e f28772c;

        c(String r3, com.obric.autogui.agents.vlm.models.omni.a.e r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28771b = r3;
            this.f28772c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.d> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f28771b, this.f28772c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.d> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f28770a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            a r8 = e.a(e.f28643a);
            String r2 = this.f28771b;
            com.obric.autogui.agents.vlm.models.omni.a.e r3 = this.f28772c;
            d.c.d<? super com.obric.autogui.agents.vlm.models.omni.a.d> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28770a = 1;
            r7 = r8.a(r2, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    public static /* synthetic */ a lambda$2jRSn7SFC0GNqjnkNudKOLodnJo() {
        return g();
    }

    public static /* synthetic */ void lambda$2ndme5UcURg8TPwrzKccRYJd0qM(IFlowAppStateIDL r0) {
        b(r0);
    }

    public static /* synthetic */ boolean lambda$7iIo13GrT3vstdl90qIsl6j7cJk(String r0) {
        return f(r0);
    }

    /* JADX INFO: renamed from: lambda$V4RJzzr2XpXwRiVlb4gEMUo5-zE, reason: not valid java name */
    public static /* synthetic */ boolean m785lambda$V4RJzzr2XpXwRiVlb4gEMUo5zE() {
        return f();
    }

    public static /* synthetic */ boolean lambda$y_1R1nzvr1ap_dbcIbfPuK0Mi1c() {
        return e();
    }

    private e() {
    }

    public static final /* synthetic */ a a(e r0) {
        return r0.c();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.obric.autogui.agents.vlm.models.omni.upload.OmniDataFeedbackUploadCenter$appStateListener$1] */
    static {
        f28643a = new e();
        f28644b = new AtomicBoolean(false);
        f28645c = new l();
        f28646d = d.g.a($$Lambda$e$2jRSn7SFC0GNqjnkNudKOLodnJo.INSTANCE);
        f28647e = new OmniDataFeedbackUploadCenter$appStateListener$1();
    }

    private final a c() {
        return (a) ZeusTransformUtils.preCheckCast(f28646d.b(), a.class, "com.obric.aiagent.plugin");
    }

    private static final a g() {
        i r1 = null;
        p r2 = null;
        com.obric.autogui.agents.vlm.models.omni.upload.b r3 = null;
        d.h.a.a r5 = null;
        return new a(r1, r2, r3, $$Lambda$e$y_1R1nzvr1ap_dbcIbfPuK0Mi1c.INSTANCE, r5, $$Lambda$e$V4RJzzr2XpXwRiVlb4gEMUo5zE.INSTANCE, (d.h.a.a) ZeusTransformUtils.preCheckCast(new b(f28645c), d.h.a.a.class, "com.obric.aiagent.plugin"), $$Lambda$e$7iIo13GrT3vstdl90qIsl6j7cJk.INSTANCE, false, 279, null);
    }

    private static final boolean e() {
        return f28643a.d();
    }

    private static final boolean f() {
        return a(f28643a, null, 1, null);
    }

    private static final boolean f(String r4) {
        d.h.b.o.e(r4, DBDefinition.TASK_ID);
        com.obric.autogui.session.a r0 = com.obric.autogui.session.c.f30777a.b();
        if (r0 == null) goto L15;
        if (w.a(r0.b(), r4) == true) goto L7;
    L11:
        boolean r5 = false;
    L12:
        if (r5 != true) goto L15;
        return true;
    L7:
        if (r0.c() == false) goto L11;
        if (r0.K() == false) goto L11;
        r5 = true;
    L15:
        return false;
    }

    private final boolean d() {
        if (com.obric.autogui.common.a.d.f28974a.C() == false) goto L5;
    L8:
        return true;
    L5:
        if (AOSystemTools.INSTANCE.isDebugVersion() == true) goto L8;
        return false;
    }

    public final void a() {
        if (f28644b.compareAndSet(false, true) == false) goto L5;
        com.obric.aiagent.assistant.idl.s.a(aa.b(IFlowAppStateIDL.class), false, false, $$Lambda$e$2ndme5UcURg8TPwrzKccRYJd0qM.INSTANCE, 3, null);
        return;
    L5:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L10;
        Loog.INSTANCE.i(TAG, "app foreground retry already registered");
        return;
    }

    private static final void b(IFlowAppStateIDL r4) {
        IFlowAppStateIDL r5 = (IFlowAppStateIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowAppStateIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "ipc");
        r5.registerAppStateListener((IFlowOnAppStateChangedListenerIDL) ZeusTransformUtils.preCheckCast(f28647e, IFlowOnAppStateChangedListenerIDL.class, "com.obric.aiagent.plugin"));
        e r0 = f28643a;
        if (r0.a(r5) == true) goto L5;
        return;
    L5:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L7;
        Loog.INSTANCE.i(TAG, "app already foreground, schedule data feedback upload");
    L7:
        a.a(r0.c(), 0, 1, null);
    }

    public final void b() {
        c().a(new com.obric.autogui.agents.vlm.models.omni.a.c(com.obric.autogui.agents.vlm.models.omni.a.l.f28189b, null, null, null, null, null, 62, null));
    }

    public final void a(String r11) {
        d.h.b.o.e(r11, DBDefinition.TASK_ID);
        c().a(new com.obric.autogui.agents.vlm.models.omni.a.c(com.obric.autogui.agents.vlm.models.omni.a.l.f28189b, r11, null, null, null, null, 60, null));
    }

    public final void b(String r3) {
        d.h.b.o.e(r3, "requestToken");
        com.obric.autogui.session.a r2 = com.obric.autogui.session.c.f30777a.b();
        String r0 = null;
        if (r2 != null) goto L5;
    L10:
        k r4 = f28645c.a(r3, r0).a();
        if (r4 == null) goto L14;
        m.f28813a.a(r4.a(), r4.b(), "inference_request_task_switch");
        return;
    L14:
        return;
    L5:
        if (r2.c() == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L10;
        r0 = r2.b();
        goto L10
    }

    public final void c(String r3) {
        d.h.b.o.e(r3, DBDefinition.TASK_ID);
        k r2 = f28645c.a(r3);
        if (r2 == null) goto L6;
        m.f28813a.a(r2.a(), r2.b(), "task_generation_started");
        return;
    }

    public final void d(String r3) {
        d.h.b.o.e(r3, DBDefinition.TASK_ID);
        k r2 = f28645c.b(r3);
        if (r2 == null) goto L6;
        m.f28813a.a(r2.a(), r2.b(), "task_generation_ended");
        return;
    }

    public final void e(String r13) {
        d.h.b.o.e(r13, "requestToken");
        Set<String> r12 = f28645c.c(r13);
        com.obric.autogui.session.a r14 = com.obric.autogui.session.c.f30777a.b();
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r15.hasNext() == false) goto L15;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin");
        if (v.f28855a.f(r4) != x.f28881b) goto L4;
        if (r14 == null) goto L4;
        if (w.a(r14.b(), r4) == false) goto L4;
        if (r14.c() == false) goto L4;
        if (r14.K() == false) goto L4;
        f28643a.c().a(new com.obric.autogui.agents.vlm.models.omni.a.c(com.obric.autogui.agents.vlm.models.omni.a.l.f28190c, r4, null, null, null, null, 60, null));
        goto L4
    }

    public final void a(String r2, com.obric.autogui.agents.vlm.models.omni.a.e r3) {
        d.h.b.o.e(r2, DBDefinition.TASK_ID);
        c().a(r2, r3);
    }

    public final com.obric.autogui.agents.vlm.models.omni.a.d b(String r2, com.obric.autogui.agents.vlm.models.omni.a.e r3) {
        d.h.b.o.e(r2, DBDefinition.TASK_ID);
        return (com.obric.autogui.agents.vlm.models.omni.a.d) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r2, r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), com.obric.autogui.agents.vlm.models.omni.a.d.class, "com.obric.aiagent.plugin");
    }

    static /* synthetic */ boolean a(e r1, IFlowAppStateIDL r2, int r3, Object r4) {
        IFlowAppStateIDL r5 = (IFlowAppStateIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowAppStateIDL.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = com.obric.aiagent.assistant.idl.s.a(aa.b(IFlowAppStateIDL.class));
    L6:
        return r1.a(r5);
    }

    private final boolean a(IFlowAppStateIDL r4) {
        IFlowAppStateIDL r5 = (IFlowAppStateIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowAppStateIDL.class, "com.obric.aiagent.plugin");
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L11
        e r3 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (r5 != null) goto L6;
    L8:
        boolean r6 = false;
    L9:
        Object r7 = d.n.f(Boolean.valueOf(r6));     // Catch: Throwable -> L11
    L14:
        if (d.n.b(r7) == false) goto L17;
        r7 = false;
    L17:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L6:
        if (r5.isAppBackground() == true) goto L8;
        r6 = true;
    L11:
        th = move-exception;
        d.n.a r8 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L14
    }
}
