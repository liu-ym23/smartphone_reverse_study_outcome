package com.obric.aiagent.executionengine.scheduler.impl.job;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.widget.Toast;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.executionengine.capabilitymanager.api.publish.IIntentInfoManagerApi;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.FeedbackResult;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.ICapabilityActionHandler;
import com.obric.capabilitykit.common.ICapabilityFeedbackReceiver;
import com.obric.capabilitykit.common.IGetRunningTaskCallback;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IQueryAppIntentsCallback;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.AppIntentImplInfo;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.z;
import d.m;
import d.n;
import d.o;
import d.s;
import d.x;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.br;

/* JADX INFO: compiled from: JobManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private static final String TAG = "JobManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f18489a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f18490b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final am f18491c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<String, com.obric.aiagent.executionengine.scheduler.impl.job.c> f18492d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ConcurrentLinkedQueue<com.obric.aiagent.executionengine.scheduler.impl.job.c> f18493e = null;
    private static final Set<Long> f = null;
    private static final ConcurrentHashMap<Long, CopyOnWriteArrayList<com.obric.aiagent.executionengine.scheduler.impl.job.c>> g = null;
    private static final Random h = null;
    private static final CopyOnWriteArrayList<m<String, ICapabilityFeedbackReceiver>> i = null;

    /* JADX INFO: compiled from: JobManager.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18494a = null;

        static {
            int[] r0 = new int[com.obric.aiagent.executionengine.scheduler.impl.job.c.d.values().length];
            r0[com.obric.aiagent.executionengine.scheduler.impl.job.c.d.f18471a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[com.obric.aiagent.executionengine.scheduler.impl.job.c.d.f18472b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[com.obric.aiagent.executionengine.scheduler.impl.job.c.d.f18473c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[com.obric.aiagent.executionengine.scheduler.impl.job.c.d.f18474d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f18494a = r0;
        }
    }

    /* JADX INFO: compiled from: JobManager.kt */
    @d.c.b.a.f(b = "JobManager.kt", c = {297}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.job.JobManager$dispatchActionResultFromClient$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IMAppAction f18496b;

        b(IMAppAction r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18496b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f18496b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18495a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L14:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            ISecureLogDepend.Companion.i(d.TAG, "receiveActionResultFromClient " + this.f18496b);
            com.obric.aiagent.executionengine.scheduler.impl.job.c r7 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(d.e().get(String.valueOf(this.f18496b.getJobId())), com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L14;
            IMAppAction r2 = this.f18496b;
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18495a = 1;
            if (r7.a(r2, r3) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: JobManager.kt */
    @d.c.b.a.f(b = "JobManager.kt", c = {307}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.job.JobManager$dispatchIntentResultFromClient$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IntentResult<?> f18498b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IMAppAction f18499c;

        c(IntentResult<?> r3, IMAppAction r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18498b = r3;
            this.f18499c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f18498b, this.f18499c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18497a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L14:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            ISecureLogDepend.Companion.i(d.TAG, "receiveIntentResultFromClient " + this.f18498b);
            com.obric.aiagent.executionengine.scheduler.impl.job.c r8 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(d.e().get(String.valueOf(this.f18499c.getJobId())), com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
            if (r8 == null) goto L14;
            IntentResult<?> r2 = this.f18498b;
            IMAppAction r4 = this.f18499c;
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18497a = 1;
            if (r8.a(r2, r4, r3) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.scheduler.impl.job.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JobManager.kt */
    @d.c.b.a.f(b = "JobManager.kt", c = {68}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.job.JobManager$dispatchServerActions$1")
    static final class C0384d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IMAppAction f18501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f18502c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f18503d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f18504e;

        C0384d(IMAppAction r3, boolean r4, String r5, boolean r6, d.c.d<? super C0384d> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18501b = r3;
            this.f18502c = r4;
            this.f18503d = r5;
            this.f18504e = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0384d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0384d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0384d(this.f18501b, this.f18502c, this.f18503d, this.f18504e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r33) {
            Object r0 = d.c.a.b.a();
            int r2 = this.f18500a;
            boolean r6 = true;
            if (r2 == 0) goto L11;
            if (r2 != 1) goto L10;
            o.a(r33);     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L7
            Object r3 = r33;
        L15:
            List r1 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L7
            if (r1 == null) goto L40;
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
            Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r10 = r8.iterator();
        L20:
            if (r10.hasNext() == false) goto L22;
            p.a(r9, (Iterable) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin")).j().values(), Iterable.class, "com.obric.aiagent.plugin"));
            goto L20
        L22:
            Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r11, Collection.class) == true) goto L25;
        L27:
            Iterator r12 = r11.iterator();
        L29:
            if (r12.hasNext() == false) goto L26;
            com.obric.aiagent.executionengine.scheduler.impl.a.e r13 = (com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin");
            if (r13.c() == false) goto L33;
        L35:
            boolean r14 = false;
        L36:
            if (r14 == false) goto L29;
            boolean r15 = true;
        L38:
            if (r15 != true) goto L40;
        L41:
            if (r6 == false) goto L52;
            ILogDepend.Companion.e(d.TAG, "return because of non-intent actions. ");
            String r4 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_execution_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_execution_failed"));
            d.h.b.o.c(r4, "getString(...)");
            IMAppAction r5 = IMAppAction.copy$default(this.f18501b, 0, null, null, 0, null, null, null, null, 0, 0, 0, null, 4095, null);
            IMAppAction r7 = this.f18501b;
            Long r16 = r7.getMessageId();
            if (r16 == null) goto L45;
            long r17 = r16.longValue();
        L46:
            r5.setReplyId(r17);
            r5.setMessageId(r7.getMessageId());
            r5.setQuestionId(r7.getQuestionId());
            r5.setContent(com.obric.aiagent.executionengine.utils.e.a().toJson(new FeedbackResult(-2001, r4, null, 1, null, false, 52, null)));
            d r24 = d.f18489a;
            IMAppAction r18 = this.f18501b;
            boolean r19 = this.f18502c;
            Long r20 = r18.getMessageId();
            if (r20 == null) goto L49;
            long r21 = r20.longValue();
        L50:
            r24.a(r18, r5, r19, -1, new JobResult(r21, true, r4, p.b()), this.f18503d);
            return x.f38692a;
        L49:
            r21 = -1;
            goto L50
        L45:
            r17 = -1;
            goto L46
        L52:
            if (r1 == null) goto L70;
            Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
            String r23 = this.f18503d;
            boolean r25 = this.f18504e;
            IMAppAction r26 = this.f18501b;
            Iterator r27 = r22.iterator();
        L55:
            if (r27.hasNext() == false) goto L70;
            com.obric.aiagent.executionengine.scheduler.impl.job.c r28 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(r27.next(), com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
            r28.a(r23);
            r28.l();
            if (r25 == true) goto L59;
            ISecureLogDepend.Companion.i(d.TAG, "job = " + r28.i().b());
            d.a(d.f18489a, r28);
            long r29 = r28.e();
            ((Map) ZeusTransformUtils.preCheckCast(d.e(), Map.class, "com.obric.aiagent.plugin")).put(String.valueOf(r29), r28);
            if (r26.getQuestionId() == null) goto L69;
            ConcurrentMap r30 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(d.f(), ConcurrentMap.class, "com.obric.aiagent.plugin");
            Long r110 = r26.getQuestionId();
            d.h.b.o.a(r110);
            Object r111 = r30.get(r110);
            if (r111 != null) goto L68;
            r111 = new CopyOnWriteArrayList();
            Object r31 = r30.putIfAbsent(r110, r111);
            if (r31 == null) goto L68;
            r111 = r31;
        L68:
            ((CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(r111, CopyOnWriteArrayList.class, "com.obric.aiagent.plugin")).add(r28);
        L69:
            ILogDepend.Companion.i(d.TAG, "dispatchServerActions: jobId=" + r29 + " action.questionId " + r26.getQuestionId());
            goto L55
        L59:
            return x.f38692a;
        L70:
            d.a(d.f18489a);
            return x.f38692a;
        L33:
            if (d.h.b.o.a(r13.e(), "end_listening") == true) goto L35;
            r14 = true;
        L26:
            r15 = false;
            goto L38
        L25:
            if (((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L27;
        L40:
            r6 = false;
            goto L41
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            o.a(r33);
            com.obric.aiagent.executionengine.scheduler.impl.job.e r32 = com.obric.aiagent.executionengine.scheduler.impl.job.e.f18533a;     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L7
            IMAppAction r34 = this.f18501b;     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L7
            boolean r35 = this.f18502c;     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L7
            d.c.d<? super List<com.obric.aiagent.executionengine.scheduler.impl.job.c>> r112 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L7
            this.f18500a = 1;     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L7
            r3 = r32.a(r34, r35, r112);     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L7
            if (r3 != r0) goto L15;
            return r0;
        L7:
            e = move-exception;
            ISecureLogDepend.Companion.e(d.TAG, "error occurred whilst parsing ECA job. e:", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            if (ZeusTransformUtils.instanceOf(e, com.obric.aiagent.executionengine.scheduler.impl.job.e.b.class) == false) goto L75;
            int r36 = -2005;
        L76:
            IMAppAction r113 = IMAppAction.copy$default(this.f18501b, 0, null, null, 0, null, null, null, null, 0, 0, 0, null, 4095, null);
            IMAppAction r37 = this.f18501b;
            Long r38 = r37.getMessageId();
            if (r38 == null) goto L79;
            long r39 = r38.longValue();
        L80:
            r113.setReplyId(r39);
            r113.setMessageId(r37.getMessageId());
            r113.setQuestionId(r37.getQuestionId());
            r113.setContent(com.obric.aiagent.executionengine.utils.e.a().toJson(new FeedbackResult(r36, e.a(), null, 1, null, false, 52, null)));
            d r210 = d.f18489a;
            IMAppAction r40 = this.f18501b;
            boolean r41 = this.f18502c;
            Long r42 = r40.getMessageId();
            if (r42 == null) goto L83;
            long r114 = r42.longValue();
        L84:
            long r43 = r114;
            r210.a(r40, r113, r41, -1, new JobResult(r43, true, e.a(), p.a(new IntentExecutionRecord("", "", "", new IntentResult(r36, null, null, e.a(), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null), false))), this.f18503d);
            return x.f38692a;
        L83:
            r114 = -1;
            goto L84
        L79:
            r39 = -1;
            goto L80
        L75:
            r36 = -2001;
            goto L76
        }
    }

    /* JADX INFO: compiled from: JobManager.kt */
    @d.c.b.a.f(b = "JobManager.kt", c = {600, 603}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.job.JobManager$findActionByQuestionId$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18505a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18506b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18507c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f18508d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f18509e;
        int f;
        final /* synthetic */ CopyOnWriteArrayList<com.obric.aiagent.executionengine.scheduler.impl.job.c> g;
        final /* synthetic */ IGetRunningTaskCallback h;
        final /* synthetic */ long i;

        e(CopyOnWriteArrayList<com.obric.aiagent.executionengine.scheduler.impl.job.c> r3, IGetRunningTaskCallback r4, long r5, d.c.d<? super e> r7) {
            IGetRunningTaskCallback r6 = (IGetRunningTaskCallback) ZeusTransformUtils.wrapperContextForParams(r4, IGetRunningTaskCallback.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            this.h = r6;
            this.i = r5;
            super(2, r8);
        }

        public static /* synthetic */ int lambda$WnXElqqYhkUz8oRIU2mBBW2LAo8(long r0, com.obric.aiagent.executionengine.scheduler.impl.job.c r2, ICapabilityActionHandler r3) {
            return a(r0, r2, r3);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.g, this.h, this.i, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference failed for: r7v2, types: [T, java.util.List] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0139 -> B:31:0x013c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0145 -> B:33:0x0146). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r20) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            final long r7 = this.f18509e;
            String r3 = (String) ZeusTransformUtils.preCheckCast(this.f18508d, String.class, "com.obric.aiagent.plugin");
            final com.obric.aiagent.executionengine.scheduler.impl.job.c r9 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(this.f18507c, com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
            Iterator r10 = (Iterator) ZeusTransformUtils.preCheckCast(this.f18506b, Iterator.class, "com.obric.aiagent.plugin");
            z.f r11 = (z.f) ZeusTransformUtils.preCheckCast(this.f18505a, z.f.class, "com.obric.aiagent.plugin");
            o.a(r20);
            z.f r12 = r11;
            Iterator r13 = r10;
            Object r14 = r20;
        L31:
            Integer r15 = (Integer) ZeusTransformUtils.preCheckCast(r14, Integer.class, "com.obric.aiagent.plugin");
        L33:
            ILogDepend.Companion.i(d.TAG, "actionResult: " + r15 + " pkg:" + r3);
            if (r15 != null) goto L37;
        L38:
            if (r15 != null) goto L41;
        L43:
            long r8 = r7;
            Iterator r16 = r13;
            z.f r4 = r12;
        L12:
            if (r16.hasNext() == false) goto L44;
            com.obric.aiagent.executionengine.scheduler.impl.job.c r17 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(r16.next(), com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
            String r18 = r17.f();
            CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin");
            if (r19 != null) goto L16;
        L19:
            boolean r110 = true;
        L20:
            if (r110 == false) goto L22;
            ILogDepend.Companion.e(d.TAG, "Job targetPackage is null, cannot notify implementer. job=" + r17);
            goto L12
        L22:
            com.obric.aiagent.executionengine.scheduler.impl.a r111 = com.obric.aiagent.executionengine.scheduler.impl.a.f17967a;
            this.f18505a = r4;
            this.f18506b = r16;
            this.f18507c = r17;
            this.f18508d = r18;
            this.f18509e = r8;
            this.f = 1;
            Object r112 = com.obric.aiagent.executionengine.scheduler.impl.a.a(r111, r18, null, this, 2, null);
            if (r112 != r1) goto L25;
            return r1;
        L25:
            r12 = r4;
            r13 = r16;
            r7 = r8;
            r9 = r17;
            r3 = r18;
        L26:
            com.obric.aiagent.executionengine.scheduler.impl.a.b r113 = (com.obric.aiagent.executionengine.scheduler.impl.a.b) ZeusTransformUtils.preCheckCast(r112, com.obric.aiagent.executionengine.scheduler.impl.a.b.class, "com.obric.aiagent.plugin");
            if (r113 == null) goto L32;
            d.h.a.b r114 = new $$Lambda$d$e$WnXElqqYhkUz8oRIU2mBBW2LAo8(r7, r9);
            this.f18505a = r12;
            this.f18506b = r13;
            this.f18507c = r9;
            this.f18508d = r3;
            this.f18509e = r7;
            this.f = 2;
            r14 = r113.a(r114, this);
            if (r14 != r1) goto L31;
            return r1;
        L32:
            r15 = null;
            goto L33
        L16:
            if (r19.length() == 0) goto L19;
            r110 = false;
            goto L20
        L44:
            ILogDepend.Companion.i(d.TAG, "findActionByQuestionId " + r4.f38504a);
            this.h.onResult(com.obric.aiagent.executionengine.utils.e.a().toJson(r4.f38504a));
            return x.f38692a;
        L41:
            if (r15.intValue() != 1) goto L43;
        L42:
            ILogDepend.Companion.i(d.TAG, "runningActions add " + r9.b());
            ((List) ZeusTransformUtils.preCheckCast(r12.f38504a, List.class, "com.obric.aiagent.plugin")).add(r9.b());
            goto L43
        L37:
            if (r15.intValue() == 0) goto L42;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r7 = this.f18509e;
            r3 = (String) ZeusTransformUtils.preCheckCast(this.f18508d, String.class, "com.obric.aiagent.plugin");
            r9 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(this.f18507c, com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
            Iterator r115 = (Iterator) ZeusTransformUtils.preCheckCast(this.f18506b, Iterator.class, "com.obric.aiagent.plugin");
            z.f r116 = (z.f) ZeusTransformUtils.preCheckCast(this.f18505a, z.f.class, "com.obric.aiagent.plugin");
            o.a(r20);
            r12 = r116;
            r13 = r115;
            r112 = r20;
            goto L26
        L10:
            o.a(r20);
            r4 = new z.f();
            r4.f38504a = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.aiagent.plugin");
            r8 = this.i;
            r16 = r21.iterator();
            goto L12
        }

        private static final int a(long r2, com.obric.aiagent.executionengine.scheduler.impl.job.c r4, ICapabilityActionHandler r5) {
            return ((ICapabilityActionHandler) ZeusTransformUtils.wrapperContextForParams(r5, ICapabilityActionHandler.class, "com.obric.aiagent.plugin")).isTaskRunning(String.valueOf(r2), String.valueOf(r4.e()));
        }
    }

    /* JADX INFO: compiled from: JobManager.kt */
    @d.c.b.a.f(b = "JobManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.job.JobManager$finishIMAction$2$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f18511b;

        f(String r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18511b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f18511b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f18510a != 0) goto L7;
            o.a(r3);
            Toast.makeText((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(this.f18511b, CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin"), 1).show();
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: JobManager.kt */
    @d.c.b.a.f(b = "JobManager.kt", c = {209}, d = "mockJobWithConstraints", e = "com.obric.aiagent.executionengine.scheduler.impl.job.JobManager")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18513b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f18514c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f18515d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f18516e;

        g(d r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18515d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18514c = r3;
            this.f18516e |= Integer.MIN_VALUE;
            return this.f18515d.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: JobManager.kt */
    @d.c.b.a.f(b = "JobManager.kt", c = {174}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.job.JobManager$queryAppIntents$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f18518b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IQueryAppIntentsCallback f18519c;

        h(String r3, IQueryAppIntentsCallback r4, d.c.d<? super h> r5) {
            IQueryAppIntentsCallback r6 = (IQueryAppIntentsCallback) ZeusTransformUtils.wrapperContextForParams(r4, IQueryAppIntentsCallback.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18518b = r3;
            this.f18519c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f18518b, this.f18519c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18517a;
            List<AppIntentImplInfo> r2 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L13:
            com.obric.aiagent.executionengine.capabilitymanager.api.publish.a r8 = (com.obric.aiagent.executionengine.capabilitymanager.api.publish.a) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.executionengine.capabilitymanager.api.publish.a.class, "com.obric.aiagent.plugin");
        L15:
            IQueryAppIntentsCallback r6 = this.f18519c;
            if (r8 == null) goto L18;
            r2 = r8.b();
        L18:
            r6.onResult(r2);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            IIntentInfoManagerApi r9 = (IIntentInfoManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentInfoManagerApi.class), IIntentInfoManagerApi.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L14;
            String r3 = this.f18518b;
            d.c.d<? super com.obric.aiagent.executionengine.capabilitymanager.api.publish.a> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18517a = 1;
            r7 = r9.queryIntentInfo(r3, r5);
            if (r7 != r0) goto L13;
            return r0;
        L14:
            r8 = null;
            goto L15
        }
    }

    /* JADX INFO: compiled from: JobManager.kt */
    @d.c.b.a.f(b = "JobManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.job.JobManager$satisfiedConstraintsByJobId$1")
    static final class i extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f18521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f18522c;

        i(long r3, int r5, d.c.d<? super i> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18521b = r3;
            this.f18522c = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f18521b, this.f18522c, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f18520a != 0) goto L10;
            o.a(r5);
            String r6 = String.valueOf(this.f18521b);
            if (d.e().containsKey(r6) == false) goto L7;
            com.obric.aiagent.executionengine.scheduler.impl.job.c r7 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(d.e().get(r6), com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
            ILogDepend.Companion.i(d.TAG, "satisfiedConstraintsByJobId jobId=" + this.f18521b + ", job=" + r7 + ", constraints=" + this.f18522c);
            d.h.b.o.a(r7);
            r7.a(this.f18522c);
            d.a(d.f18489a, r7);
        L7:
            d.a(d.f18489a);
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: JobManager.kt */
    @d.c.b.a.f(b = "JobManager.kt", c = {247}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.job.JobManager$scheduleJob$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18523a;

        j(d.c.d<? super j> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18523a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L15:
            IMAppAction r4 = (IMAppAction) ZeusTransformUtils.preCheckCast(r5, IMAppAction.class, "com.obric.aiagent.plugin");
        L17:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            if ((!((Collection) ZeusTransformUtils.preCheckCast(d.h(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L17;
            com.obric.aiagent.executionengine.scheduler.impl.job.c r6 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(d.h().poll(), com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L17;
            d.c.d<? super IMAppAction> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18523a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: compiled from: JobManager.kt */
    @d.c.b.a.f(b = "JobManager.kt", c = {671, 674}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.job.JobManager$stopRunningAction$1")
    static final class k extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f18525b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.executionengine.scheduler.impl.job.c f18526c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f18527d;

        k(com.obric.aiagent.executionengine.scheduler.impl.job.c r3, String r4, d.c.d<? super k> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18526c = r3;
            this.f18527d = r4;
            super(2, r6);
        }

        public static /* synthetic */ boolean lambda$xkmx5OItz_FhbptVcKV02zZlzYg(com.obric.aiagent.executionengine.scheduler.impl.job.c r0, String r1, ICapabilityActionHandler r2) {
            return a(r0, r1, r2);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new k(this.f18526c, this.f18527d, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18525b;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            com.obric.aiagent.executionengine.scheduler.impl.a.b r2 = (com.obric.aiagent.executionengine.scheduler.impl.a.b) ZeusTransformUtils.preCheckCast(this.f18524a, com.obric.aiagent.executionengine.scheduler.impl.a.b.class, "com.obric.aiagent.plugin");
            o.a(r14);
        L29:
            Boolean r15 = (Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.aiagent.plugin");
        L31:
            ILogDepend.Companion.i(d.TAG, "Notified implementer for running job: " + this.f18526c + ", result=" + r15 + " binder=" + r2);
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r14);
        L23:
            com.obric.aiagent.executionengine.scheduler.impl.a.b r16 = (com.obric.aiagent.executionengine.scheduler.impl.a.b) ZeusTransformUtils.preCheckCast(r14, com.obric.aiagent.executionengine.scheduler.impl.a.b.class, "com.obric.aiagent.plugin");
            if (r16 == null) goto L30;
            final com.obric.aiagent.executionengine.scheduler.impl.job.c r3 = this.f18526c;
            final String r4 = this.f18527d;
            d.h.a.b r6 = new $$Lambda$d$k$xkmx5OItz_FhbptVcKV02zZlzYg(r3, r4);
            d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18524a = r16;
            this.f18525b = 2;
            Object r7 = r16.a(r6, r5);
            if (r7 != r0) goto L28;
            return r0;
        L28:
            r2 = r16;
            r14 = r7;
            goto L29
        L30:
            r2 = r16;
            r15 = null;
            goto L31
        L10:
            o.a(r14);
            String r8 = this.f18526c.f();
            CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
            if (r17 != null) goto L13;
        L16:
            boolean r18 = true;
        L17:
            if (r18 == false) goto L20;
            ILogDepend.Companion.e(d.TAG, "Job targetPackage is null, cannot notify implementer. job=" + this.f18526c);
            return x.f38692a;
        L20:
            com.obric.aiagent.executionengine.scheduler.impl.a r9 = com.obric.aiagent.executionengine.scheduler.impl.a.f17967a;
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18525b = 1;
            r14 = com.obric.aiagent.executionengine.scheduler.impl.a.a(r9, r8, null, r10, 2, null);
            if (r14 != r0) goto L23;
            return r0;
        L13:
            if (r17.length() == 0) goto L16;
            r18 = false;
            goto L17
        }

        private static final boolean a(com.obric.aiagent.executionengine.scheduler.impl.job.c r2, String r3, ICapabilityActionHandler r4) {
            return ((ICapabilityActionHandler) ZeusTransformUtils.wrapperContextForParams(r4, ICapabilityActionHandler.class, "com.obric.aiagent.plugin")).stopAction(String.valueOf(r2.d()), r3);
        }
    }

    /* JADX INFO: compiled from: JobManager.kt */
    @d.c.b.a.f(b = "JobManager.kt", c = {509, 512}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.job.JobManager$stopRunningJobs$1")
    static final class l extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f18529b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.executionengine.scheduler.impl.job.c f18530c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f18531d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f18532e;

        l(com.obric.aiagent.executionengine.scheduler.impl.job.c r3, String r4, String r5, d.c.d<? super l> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18530c = r3;
            this.f18531d = r4;
            this.f18532e = r5;
            super(2, r7);
        }

        public static /* synthetic */ boolean lambda$HY7T9oGG2p63EkXqtsP6i624k20(String r0, String r1, ICapabilityActionHandler r2) {
            return a(r0, r1, r2);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new l(this.f18530c, this.f18531d, this.f18532e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18529b;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            com.obric.aiagent.executionengine.scheduler.impl.a.b r2 = (com.obric.aiagent.executionengine.scheduler.impl.a.b) ZeusTransformUtils.preCheckCast(this.f18528a, com.obric.aiagent.executionengine.scheduler.impl.a.b.class, "com.obric.aiagent.plugin");
            o.a(r14);
        L29:
            Boolean r15 = (Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.aiagent.plugin");
        L31:
            ILogDepend.Companion.i(d.TAG, "Notified implementer for running job: " + this.f18530c + ", result=" + r15 + " binder=" + r2);
            return x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            o.a(r14);
        L23:
            com.obric.aiagent.executionengine.scheduler.impl.a.b r16 = (com.obric.aiagent.executionengine.scheduler.impl.a.b) ZeusTransformUtils.preCheckCast(r14, com.obric.aiagent.executionengine.scheduler.impl.a.b.class, "com.obric.aiagent.plugin");
            if (r16 == null) goto L30;
            final String r3 = this.f18531d;
            final String r4 = this.f18532e;
            d.h.a.b r6 = new $$Lambda$d$l$HY7T9oGG2p63EkXqtsP6i624k20(r3, r4);
            d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18528a = r16;
            this.f18529b = 2;
            Object r7 = r16.a(r6, r5);
            if (r7 != r0) goto L28;
            return r0;
        L28:
            r2 = r16;
            r14 = r7;
            goto L29
        L30:
            r2 = r16;
            r15 = null;
            goto L31
        L10:
            o.a(r14);
            String r8 = this.f18530c.f();
            CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
            if (r17 != null) goto L13;
        L16:
            boolean r18 = true;
        L17:
            if (r18 == false) goto L20;
            ILogDepend.Companion.e(d.TAG, "Job targetPackage is null, cannot notify implementer. job=" + this.f18530c);
            return x.f38692a;
        L20:
            com.obric.aiagent.executionengine.scheduler.impl.a r9 = com.obric.aiagent.executionengine.scheduler.impl.a.f17967a;
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18529b = 1;
            r14 = com.obric.aiagent.executionengine.scheduler.impl.a.a(r9, r8, null, r10, 2, null);
            if (r14 != r0) goto L23;
            return r0;
        L13:
            if (r17.length() == 0) goto L16;
            r18 = false;
            goto L17
        }

        private static final boolean a(String r2, String r3, ICapabilityActionHandler r4) {
            return ((ICapabilityActionHandler) ZeusTransformUtils.wrapperContextForParams(r4, ICapabilityActionHandler.class, "com.obric.aiagent.plugin")).stopAction(r2, r3);
        }
    }

    /* JADX INFO: renamed from: lambda$A2e73kufmxPEv-INkCT5Ae3RSnQ, reason: not valid java name */
    public static /* synthetic */ Thread m188lambda$A2e73kufmxPEvINkCT5Ae3RSnQ(Runnable r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$L8zg1VG96fMTXIwUdgH62TeNh-w, reason: not valid java name */
    public static /* synthetic */ boolean m189lambda$L8zg1VG96fMTXIwUdgH62TeNhw(com.obric.aiagent.executionengine.scheduler.impl.job.c r0, com.obric.aiagent.executionengine.scheduler.impl.job.c r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$LFii-i3GL_6na79w-xx5esMIFFQ, reason: not valid java name */
    public static /* synthetic */ Thread m190lambda$LFiii3GL_6na79wxx5esMIFFQ(Runnable r0) {
        return b(r0);
    }

    public static /* synthetic */ boolean lambda$QzMt9zMl4Okmo5C0AXf_2cKsPAA(m r0) {
        return a(r0);
    }

    public static /* synthetic */ boolean lambda$hmnEy0IqeJAls2EUlgPrNrp7Uyk(d.h.a.b r0, Object r1) {
        return a(r0, r1);
    }

    public final PendingIntent a(long r1, Intent r3, FloatingIntentParams r4) {
        d.h.b.o.e(r3, MemorySourceLinkType.INTENT);
        d.h.b.o.e(r4, "params");
        return null;
    }

    private d() {
    }

    public static final /* synthetic */ void a(d r0) {
        r0.i();
    }

    public static final /* synthetic */ void a(d r0, com.obric.aiagent.executionengine.scheduler.impl.job.c r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ ConcurrentHashMap e() {
        return f18492d;
    }

    public static final /* synthetic */ ConcurrentHashMap f() {
        return g;
    }

    public static final /* synthetic */ CopyOnWriteArrayList g() {
        return i;
    }

    public static final /* synthetic */ ConcurrentLinkedQueue h() {
        return f18493e;
    }

    static {
        f18489a = new d();
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$d$A2e73kufmxPEvINkCT5Ae3RSnQ.INSTANCE);
        d.h.b.o.c(r0, "newSingleThreadExecutor(...)");
        f18490b = an.a((d.c.g) ZeusTransformUtils.preCheckCast(br.a(r0), d.c.g.class, "com.obric.aiagent.plugin"));
        ExecutorService r1 = Executors.newFixedThreadPool(1, $$Lambda$d$LFiii3GL_6na79wxx5esMIFFQ.INSTANCE);
        d.h.b.o.c(r1, "newFixedThreadPool(...)");
        f18491c = an.a((d.c.g) ZeusTransformUtils.preCheckCast(br.a(r1), d.c.g.class, "com.obric.aiagent.plugin"));
        f18492d = new ConcurrentHashMap();
        f18493e = new ConcurrentLinkedQueue();
        ConcurrentHashMap.KeySetView r2 = ConcurrentHashMap.newKeySet();
        d.h.b.o.c(r2, "newKeySet(...)");
        f = (Set) ZeusTransformUtils.preCheckCast(r2, Set.class, "com.obric.aiagent.plugin");
        g = new ConcurrentHashMap();
        h = new Random();
        i = new CopyOnWriteArrayList();
    }

    public final am a() {
        return f18490b;
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "job-dispatcher");
    }

    private static final Thread b(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "job-executor");
    }

    public static /* synthetic */ void a(d r0, IMAppAction r1, boolean r2, boolean r3, String r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = true;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r3 = false;
    L8:
        r0.a(r1, r2, r3, r4);
    }

    public final void a(IMAppAction r8, boolean r9, boolean r10, String r11) {
        d.h.b.o.e(r8, "action");
        kotlinx.coroutines.i.a(f18490b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0384d(r8, r9, r11, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(String r8, IQueryAppIntentsCallback r9) {
        IQueryAppIntentsCallback r7 = (IQueryAppIntentsCallback) ZeusTransformUtils.wrapperContextForParams(r9, IQueryAppIntentsCallback.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L8;
        if (r7 == null) goto L8;
        kotlinx.coroutines.i.a(f18490b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(r8, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L8:
        if (r7 == null) goto L11;
        r7.onResult(null);
        return;
    }

    public final void a(ICapabilityFeedbackReceiver r8, String r9) {
        ICapabilityFeedbackReceiver r7 = (ICapabilityFeedbackReceiver) ZeusTransformUtils.wrapperContextForParams(r8, ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "receiver");
        com.obric.aiagent.executionengine.scheduler.impl.d.b.a r10 = com.obric.aiagent.executionengine.scheduler.impl.d.b.f18388a;
        n.a r1 = n.f38560a;     // Catch: Throwable -> L8
        Object r2 = Proxy.newProxyInstance(ICapabilityFeedbackReceiver.class.getClassLoader(), new Class[]{ICapabilityFeedbackReceiver.class}, (InvocationHandler) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.executionengine.scheduler.impl.d.b((IInterface) ZeusTransformUtils.preCheckCast(r7, IInterface.class, "com.obric.aiagent.plugin"), TAG, ICapabilityFeedbackReceiver.class), InvocationHandler.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        if (r2 == null) goto L7;
        IInterface r3 = (IInterface) ZeusTransformUtils.preCheckCast((ICapabilityFeedbackReceiver) ZeusTransformUtils.preCheckCast(r2, ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin"), IInterface.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
    L13:
        ICapabilityFeedbackReceiver r11 = (ICapabilityFeedbackReceiver) ZeusTransformUtils.preCheckCast(r3, ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin");
        d r4 = f18489a;
        monitor-enter(r4);
        CopyOnWriteArrayList<m<String, ICapabilityFeedbackReceiver>> r5 = i;     // Catch: Throwable -> L19
        p.a((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), $$Lambda$d$QzMt9zMl4Okmo5C0AXf_2cKsPAA.INSTANCE);     // Catch: Throwable -> L19
        r5.add(new m(r9, r11));     // Catch: Throwable -> L19
        ILogDepend.Companion.i(TAG, "resultReceiver new size:" + r5.size());     // Catch: Throwable -> L19
        x r6 = x.f38692a;     // Catch: Throwable -> L19
        monitor-exit(r4);
        r7.asBinder().linkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(new JobManager$attachResultReceiver$2(r11, r9), IBinder.DeathRecipient.class, "com.obric.aiagent.plugin"), 0);
        return;
    L19:
        th = move-exception;
        throw th;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.capabilitykit.common.ICapabilityFeedbackReceiver");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        n.a r12 = n.f38560a;
        if (n.c(n.f(o.a(th))) == null) goto L12;
        ILogDepend.Companion.e(TAG, "DeadDetectableBinderProxy createProxyInstance for " + ((IInterface) ZeusTransformUtils.preCheckCast(r7, IInterface.class, "com.obric.aiagent.plugin")).getClass() + " fail");
    L12:
        r3 = (IInterface) ZeusTransformUtils.preCheckCast(r7, IInterface.class, "com.obric.aiagent.plugin");
        goto L13
    }

    private static final boolean a(m r2) {
        return !((ICapabilityFeedbackReceiver) ZeusTransformUtils.preCheckCast(r2.b(), ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin")).asBinder().isBinderAlive();
    }

    public final Object a(JsonArray r33, List<Integer> r34, d.c.d<? super Long> r35) {
        d r0 = this;
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r35, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, g.class) == false) goto L7;
        g r4 = (g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin");
        if ((r4.f18516e & Integer.MIN_VALUE) == 0) goto L7;
        r4.f18516e -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.f18514c;
        Object r6 = d.c.a.b.a();
        int r7 = r4.f18516e;
        if (r7 == 0) goto L16;
        if (r7 != 1) goto L15;
        r1 = (List) ZeusTransformUtils.preCheckCast(r4.f18513b, List.class, "com.obric.aiagent.plugin");
        r0 = (d) ZeusTransformUtils.preCheckCast(r4.f18512a, d.class, "com.obric.aiagent.plugin");
        o.a(r5);     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L33
    L20:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L33
        if (r8 == null) goto L23;
        com.obric.aiagent.executionengine.scheduler.impl.job.c r9 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(p.l(r8), com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
    L24:
        if (r9 == null) goto L32;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L27:
        if (r10.hasNext() == false) goto L29;
        r9.b(((Number) ZeusTransformUtils.preCheckCast(r10.next(), Number.class, "com.obric.aiagent.plugin")).intValue());
        goto L27
    L29:
        long r11 = r9.e();
        r0.a(r9);
        ((Map) ZeusTransformUtils.preCheckCast(f18492d, Map.class, "com.obric.aiagent.plugin")).put(String.valueOf(r11), r9);
        ILogDepend.Companion.d(TAG, "mockJobWithConstraints: jobId=" + r11 + ", constraints=" + r1);
        return d.c.b.a.b.a(r11);
    L32:
        return d.c.b.a.b.a(-1);
    L23:
        r9 = null;
        goto L24
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        o.a(r5);
        JsonObject r12 = new JsonObject();
        r12.add("actions", (JsonElement) ZeusTransformUtils.preCheckCast(r33, JsonElement.class, "com.obric.aiagent.plugin"));
        JsonArray r13 = new JsonArray();
        r13.add((JsonElement) ZeusTransformUtils.preCheckCast(r12, JsonElement.class, "com.obric.aiagent.plugin"));
        JsonObject r14 = new JsonObject();
        r14.add("jobs", (JsonElement) ZeusTransformUtils.preCheckCast(r13, JsonElement.class, "com.obric.aiagent.plugin"));
        Random r15 = h;
        String r16 = String.valueOf(Math.abs(r15.nextLong()));
        String r17 = String.valueOf(Math.abs(r15.nextLong()));
        com.obric.aiagent.executionengine.scheduler.impl.job.e r18 = com.obric.aiagent.executionengine.scheduler.impl.job.e.f18533a;     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L33
        IMAppAction r19 = new IMAppAction(0, null, null, 0, null, null, null, null, 0, 0, 0, null, 4095, null);     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L33
        r19.setMessageId(d.c.b.a.b.a(Long.parseLong(r17)));     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L33
        r19.setReplyId(0);     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L33
        r19.setQuestionId(d.c.b.a.b.a(Long.parseLong(r16)));     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L33
        r19.setVersion(2);     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L33
        r19.setContent(r14.toString());     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L33
        r4.f18512a = r0;     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L33
        r4.f18513b = r1;     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L33
        r4.f18516e = 1;     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L33
        r5 = r18.a(r19, false, r4);     // Catch: com.obric.aiagent.executionengine.scheduler.impl.job.e.a -> L33
        if (r5 != r6) goto L20;
        return r6;
    L33:
        e = move-exception;
        ISecureLogDepend.Companion.e(TAG, "mockJobWithConstraints parse failed. e:", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return d.c.b.a.b.a(-1);
    L7:
        r4 = new g(r0, r3);
        goto L8
    }

    private final void i() {
        kotlinx.coroutines.i.a(f18490b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(IMAppAction r18, IMAppAction r19, boolean r20, long r21, JobResult r23, String r24) {
        d.h.b.o.e(r18, Ext.KEY_REQUEST);
        d.h.b.o.e(r19, "result");
        ILogDepend.Companion r7 = ILogDepend.Companion;
        StringBuilder r8 = new StringBuilder().append("JobManager finishIMAction jobid ").append(r21).append(", callback Size:");
        CopyOnWriteArrayList<m<String, ICapabilityFeedbackReceiver>> r9 = i;
        r7.i(TAG, r8.append(r9.size()).toString());
        com.obric.aiagent.executionengine.scheduler.impl.job.i.f18560a.a(r18, r19, r23);
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L17;
        m r11 = (m) ZeusTransformUtils.preCheckCast(r10.next(), m.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.c(), String.class, "com.obric.aiagent.plugin");
        ICapabilityFeedbackReceiver r13 = (ICapabilityFeedbackReceiver) ZeusTransformUtils.preCheckCast(r11.d(), ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r12, r24) == false) goto L15;
        if (r13.asBinder().isBinderAlive() == false) goto L15;
        if (f18489a.d(r21) == true) goto L15;
        if (r23 != null) goto L13;
        r13.onActionResultRecv(com.obric.aiagent.executionengine.utils.e.a().toJson(r18), com.obric.aiagent.executionengine.utils.e.a().toJson(r19), r20);
        goto L4
    L13:
        ILogDepend.Companion.i(TAG, "JobManager finishIMAction onJobResultRecv " + r24);
        r13.onJobResultRecv(com.obric.aiagent.executionengine.utils.e.a().toJson(r18), com.obric.aiagent.executionengine.utils.e.a().toJson(r19), r20, r23);
    L15:
        ILogDepend.Companion.i(TAG, "JobManager finishIMAction isInterruptedJob=" + f18489a.d(r21) + ' ' + r24);
        goto L4
    L17:
        if (i.isEmpty() == false) goto L24;
        ILogDepend.Companion.e(TAG, "no resultReceiver to handle the result message.");
        if (IAppContext.Companion.isDebug() == false) goto L24;
        if (r23 == null) goto L24;
        String r0 = r23.getMessage();
        if (r0 == null) goto L24;
        kotlinx.coroutines.i.a(an.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r0, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    L24:
        a(r21, r23);
        ISecureLogDepend.Companion.i(TAG, "JobManager finishIMAction end jobResult " + r23);
        i();
    }

    public final void a(IMAppAction r7) {
        d.h.b.o.e(r7, "action");
        kotlinx.coroutines.i.a(f18490b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(IntentResult<?> r7, IMAppAction r8) {
        d.h.b.o.e(r8, "oldResult");
        kotlinx.coroutines.i.a(f18490b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r7, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(long r7, String r9, boolean r10, IntentResult<?> r11) {
        d.h.b.o.e(r9, "jobId");
        d.h.b.o.e(r11, "result");
        a(r7, r11, r10, ao.a(s.a(Ext.KEY_JOB_ID, r9)));
    }

    public final void a(long r9, IntentResult<?> r11, boolean r12, Map<?, ?> r13) {
        Map<?, ?> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "result");
        List r0 = null;
        if (r14 == null) goto L5;
        Object r2 = r14.get(Ext.KEY_JOB_ID);
    L7:
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L9;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L10:
        com.obric.aiagent.executionengine.scheduler.impl.job.c r4 = a(r9, r3);
        if (r4 == null) goto L25;
        com.obric.aiagent.executionengine.scheduler.impl.a.f17967a.a(r3, r11);
        if (r11.isFinal() == false) goto L18;
        com.obric.aiagent.executionengine.scheduler.impl.job.i.f18560a.a((Collection) ZeusTransformUtils.preCheckCast(p.a(r4), Collection.class, "com.obric.aiagent.plugin"), r11, r14);
        if (r3 == null) goto L18;
        f18489a.b(r9, r3);
    L18:
        if (f18489a.d(r4.e()) == false) goto L21;
        ILogDepend.Companion.i(TAG, "updateIntentResult isInterruptedJob " + r9 + ", jobId " + r3 + " no need return");
        return;
    L21:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(i, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L23:
        if (r8.hasNext() == false) goto L44;
        ((ICapabilityFeedbackReceiver) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r8.next(), m.class, "com.obric.aiagent.plugin")).d(), ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin")).onUpdateIntentResultWithRequest(com.obric.aiagent.executionengine.utils.e.a().toJson(r4.b()), r11, r12, r14);
        goto L23
    L44:
        return;
    L25:
        d r10 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.scheduler.impl.a.f17967a.a(r3, r11);
        CopyOnWriteArrayList r5 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(g.get(Long.valueOf(r9)), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L28;
        r0 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin"));
    L28:
        if (r0 != null) goto L30;
        r0 = p.b();
    L30:
        com.obric.aiagent.executionengine.scheduler.impl.job.c r6 = r10.e(r9);
        if (r6 == null) goto L33;
        long r7 = r6.e();
    L34:
        boolean r15 = r10.d(r7);
        if (r11.isFinal() == false) goto L37;
        com.obric.aiagent.executionengine.scheduler.impl.job.i.f18560a.a((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin"), r11, r14);
        r10.f(r9);
    L37:
        if (r15 == false) goto L40;
        ILogDepend.Companion.i(TAG, "updateIntentResult isInterruptedJob " + r9 + ", no need return");
        return;
    L40:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(i, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L42:
        if (r16.hasNext() == false) goto L47;
        ((ICapabilityFeedbackReceiver) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r16.next(), m.class, "com.obric.aiagent.plugin")).d(), ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin")).onUpdateIntentResult(r9, r11, r12, r14);
        goto L42
    L47:
        return;
    L33:
        r7 = -1;
        goto L34
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public final void a(long r4) {
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(i, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((ICapabilityFeedbackReceiver) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r3.next(), m.class, "com.obric.aiagent.plugin")).d(), ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin")).onHideIntentResultCard(r4);
        goto L4
    }

    public final void b(long r4) {
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(i, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((ICapabilityFeedbackReceiver) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r3.next(), m.class, "com.obric.aiagent.plugin")).b(), ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin")).onFinishFloatingActivity(r4);
        goto L4
    }

    public final boolean c(long r5) {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(i, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L18;
        if (((ICapabilityFeedbackReceiver) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r6.next(), m.class, "com.obric.aiagent.plugin")).b(), ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin")).isCardViewVisible(r5) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        return false;
    }

    public final Boolean b() {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(i, Iterable.class, "com.obric.aiagent.plugin");
        boolean r2 = false;
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L14;
        if (((ICapabilityFeedbackReceiver) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.preCheckCast(r5.next(), m.class, "com.obric.aiagent.plugin")).b(), ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin")).isKeyguardReallyLocked() == false) goto L9;
        r2 = true;
    L14:
        return Boolean.valueOf(r2);
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    public final kotlinx.coroutines.a.d<IMAppAction> a(Long r2, long r3) {
        com.obric.aiagent.executionengine.scheduler.impl.job.c r1 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(f18492d.get(String.valueOf(r2)), com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.a(r3);
    }

    public final void b(Long r2, long r3) {
        com.obric.aiagent.executionengine.scheduler.impl.job.c r1 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(f18492d.get(String.valueOf(r2)), com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        r1.c(r3);
        return;
    }

    public final kotlinx.coroutines.a.d<com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> c(Long r2, long r3) {
        com.obric.aiagent.executionengine.scheduler.impl.job.c r1 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(f18492d.get(String.valueOf(r2)), com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.b(r3);
    }

    public final void d(Long r2, long r3) {
        com.obric.aiagent.executionengine.scheduler.impl.job.c r1 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(f18492d.get(String.valueOf(r2)), com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        r1.d(r3);
        return;
    }

    public final void a(long r7, int r9) {
        kotlinx.coroutines.i.a(f18490b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(r7, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void a(com.obric.aiagent.executionengine.scheduler.impl.job.c r1) {
        if (r1.h() == false) goto L6;
        f18493e.add(r1);
        return;
    }

    public final am c() {
        return f18490b;
    }

    public final am d() {
        return f18491c;
    }

    public final void a(String r12, String r13) {
        d.h.b.o.e(r12, "messageId");
        d.h.b.o.e(r13, "reason");
        ILogDepend.Companion r11 = ILogDepend.Companion;
        StringBuilder r0 = new StringBuilder().append("stopRunningJobs: actionCallbackJobMap=");
        ConcurrentHashMap<String, com.obric.aiagent.executionengine.scheduler.impl.job.c> r1 = f18492d;
        r11.i(TAG, r0.append(r1).toString());
        Iterator<Map.Entry<String, com.obric.aiagent.executionengine.scheduler.impl.job.c>> r14 = r1.entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L25;
        Map.Entry<String, com.obric.aiagent.executionengine.scheduler.impl.job.c> r2 = r14.next();
        d.h.b.o.c(r2, "next(...)");
        Object r3 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.aiagent.plugin")).getValue();
        d.h.b.o.c(r3, "<get-value>(...)");
        com.obric.aiagent.executionengine.scheduler.impl.job.c r4 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.scheduler.impl.job.c.d r5 = r4.g();
        if (r4.d() != Long.parseLong(r12)) goto L8;
        boolean r6 = true;
    L9:
        ILogDepend.Companion.i(TAG, "stopRunningJobs: jobId=" + r4.e() + ", state=" + r5 + ", isSameMessageId=" + r6 + " jobMsgid " + r4.d() + " messageId " + r12);
        if (r6 == false) goto L4;
        Set<Long> r7 = f;
        r7.add(Long.valueOf(r4.e()));
        ILogDepend.Companion.i(TAG, "Added interrupted interruptedJobs: " + r7);
        int r8 = a.f18494a[r5.ordinal()];
        if (r8 == 1) goto L24;
        if (r8 == 2) goto L24;
        if (r8 != 3) goto L19;
    L23:
        kotlinx.coroutines.i.a(f18490b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new l(r4, r12, r13, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        goto L4
    L19:
        if (r8 == 4) goto L23;
        throw new d.k();
    L24:
        ILogDepend.Companion.i(TAG, "Removing job: " + r4 + ", state=" + r5 + ", reason: " + r13);
        r14.remove();
        g.remove(Long.valueOf(r4.d()));
        goto L4
    L8:
        r6 = false;
        goto L9
    }

    private final boolean d(long r1) {
        return f.contains(Long.valueOf(r1));
    }

    private final void a(long r8, JobResult r10) {
        com.obric.aiagent.executionengine.scheduler.impl.job.c r0 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(f18492d.get(String.valueOf(r8)), com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        ISecureLogDepend.Companion r1 = ISecureLogDepend.Companion;
        StringBuilder r3 = new StringBuilder().append("try removeJob jobResult.execRecords ");
        if (r10 == null) goto L8;
        List<IntentExecutionRecord> r4 = r10.getExecRecords();
    L9:
        r1.i(TAG, r3.append(r4).toString());
        if (r10 == null) goto L24;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10.getExecRecords(), Iterable.class, "com.obric.aiagent.plugin");
        boolean r5 = true;
        if (ZeusTransformUtils.instanceOf(r11, Collection.class) == true) goto L14;
    L16:
        Iterator r12 = r11.iterator();
    L18:
        if (r12.hasNext() == false) goto L15;
        if ((!((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r12.next(), IntentExecutionRecord.class, "com.obric.aiagent.plugin")).getResult().isFinal()) == false) goto L18;
    L21:
        if (r5 == false) goto L24;
        ILogDepend.Companion.i(TAG, "Job " + r8 + " still has unfinished execRecords, not removed.");
        return;
    L15:
        r5 = false;
        goto L21
    L14:
        if (((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L16;
    L24:
        f18492d.remove(String.valueOf(r8));
        f.remove(Long.valueOf(r8));
        a(r0.d(), r0);
        ILogDepend.Companion.i(TAG, "Removed jobId=" + r8 + " questionId " + Long.valueOf(r0.d()));
        return;
    L8:
        r4 = null;
        goto L9
    }

    private final com.obric.aiagent.executionengine.scheduler.impl.job.c e(long r1) {
        CopyOnWriteArrayList r0 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(g.get(Long.valueOf(r1)), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        return null;
    L7:
        return (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(p.l((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin")), com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
    }

    private final com.obric.aiagent.executionengine.scheduler.impl.job.c a(long r6, String r8) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        Object r1 = null;
        if (r7 == false) goto L12;
        return null;
    L12:
        ILogDepend.Companion r9 = ILogDepend.Companion;
        StringBuilder r2 = new StringBuilder().append("findJob job questionId=").append(r6).append(" jobId: ").append(r8).append(' ');
        ConcurrentHashMap<Long, CopyOnWriteArrayList<com.obric.aiagent.executionengine.scheduler.impl.job.c>> r3 = g;
        r9.i(TAG, r2.append(r3.get(Long.valueOf(r6))).toString());
        CopyOnWriteArrayList r10 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(r3.get(Long.valueOf(r6)), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L25;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L16:
        if (r11.hasNext() == false) goto L21;
        Object r12 = r11.next();
        if (d.h.b.o.a(String.valueOf(((com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin")).e()), r8) == false) goto L16;
        r1 = r12;
    L21:
        return (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
    L25:
        return null;
    L5:
        if (r5.length() == 0) goto L8;
        r7 = false;
        goto L9
    }

    private final void b(long r6, String r8) {
        CopyOnWriteArrayList r0 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(g.get(Long.valueOf(r6)), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L19;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();
        if (d.h.b.o.a(String.valueOf(((com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin")).e()), r8) == false) goto L6;
    L11:
        com.obric.aiagent.executionengine.scheduler.impl.job.c r3 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L20;
        f18492d.remove(String.valueOf(r3.e()));
        f.remove(Long.valueOf(r3.e()));
        a(r6, r3);
        ILogDepend.Companion.i(TAG, "Finished job questionId=" + r6 + ", jobId=" + r3.e() + " jobId: " + r8);
        return;
    L20:
        return;
    L10:
        r2 = null;
        goto L11
    }

    private final void a(long r4, final com.obric.aiagent.executionengine.scheduler.impl.job.c r6) {
        ConcurrentHashMap<Long, CopyOnWriteArrayList<com.obric.aiagent.executionengine.scheduler.impl.job.c>> r3 = g;
        CopyOnWriteArrayList r0 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(r3.get(Long.valueOf(r4)), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        final d.h.a.b r1 = new $$Lambda$d$L8zg1VG96fMTXIwUdgH62TeNhw(r6);
        r0.removeIf(new $$Lambda$d$hmnEy0IqeJAls2EUlgPrNrp7Uyk(r1));
    L5:
        CopyOnWriteArrayList r7 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(r3.get(Long.valueOf(r4)), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin");
        boolean r2 = true;
        if (r7 != null) goto L8;
    L10:
        r2 = false;
    L11:
        if (r2 == false) goto L14;
        r3.remove(Long.valueOf(r4));
        return;
    L14:
        return;
    L8:
        if (r7.isEmpty() != true) goto L10;
        goto L10
    }

    private static final boolean a(com.obric.aiagent.executionengine.scheduler.impl.job.c r0, com.obric.aiagent.executionengine.scheduler.impl.job.c r1) {
        return d.h.b.o.a(r0, r1);
    }

    private static final boolean a(d.h.a.b r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private final void f(long r4) {
        CopyOnWriteArrayList r3 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(g.remove(Long.valueOf(r4)), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L9;
        com.obric.aiagent.executionengine.scheduler.impl.job.c r5 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(p.l((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin")), com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L10;
        f18492d.remove(String.valueOf(r5.e()));
        f.remove(Long.valueOf(r5.e()));
        ILogDepend.Companion.i(TAG, "Finished job questionId=" + r4 + ", jobId=" + r5.e());
        return;
    L10:
        return;
    }

    public final void a(long r12, IGetRunningTaskCallback r14) {
        IGetRunningTaskCallback r3 = (IGetRunningTaskCallback) ZeusTransformUtils.wrapperContextForParams(r14, IGetRunningTaskCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "callback");
        ConcurrentHashMap<Long, CopyOnWriteArrayList<com.obric.aiagent.executionengine.scheduler.impl.job.c>> r11 = g;
        CopyOnWriteArrayList r2 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(r11.get(Long.valueOf(r12)), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion r15 = ILogDepend.Companion;
        StringBuilder r1 = new StringBuilder().append("findActionByQuestionId ");
        if (r2 == null) goto L5;
        Integer r5 = Integer.valueOf(r2.size());
    L6:
        r15.i(TAG, r1.append(r5).append(" questionId: ").append(r12).append(" map:").append(r11).toString());
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L9;
    L12:
        boolean r16 = true;
    L13:
        if (r16 == false) goto L16;
        r3.onResult(null);
        return;
    L16:
        kotlinx.coroutines.i.a(f18490b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r2, r3, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L9:
        if (r13.isEmpty() == true) goto L12;
        r16 = false;
        goto L13
    L5:
        r5 = null;
        goto L6
    }

    public final void a(String r12, String r13, String r14, String r15) {
        d.h.b.o.e(r15, "reason");
        ILogDepend.Companion r11 = ILogDepend.Companion;
        StringBuilder r0 = new StringBuilder().append("stopRunningAction: actionCallbackJobMap=");
        ConcurrentHashMap<String, com.obric.aiagent.executionengine.scheduler.impl.job.c> r1 = f18492d;
        r11.i(TAG, r0.append(r1).toString());
        Iterator<Map.Entry<String, com.obric.aiagent.executionengine.scheduler.impl.job.c>> r16 = r1.entrySet().iterator();
    L4:
        if (r16.hasNext() == false) goto L35;
        Map.Entry<String, com.obric.aiagent.executionengine.scheduler.impl.job.c> r2 = r16.next();
        d.h.b.o.c(r2, "next(...)");
        Object r3 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.aiagent.plugin")).getValue();
        d.h.b.o.c(r3, "<get-value>(...)");
        com.obric.aiagent.executionengine.scheduler.impl.job.c r4 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.scheduler.impl.job.c.d r5 = r4.g();
        boolean r6 = false;
        if (r12 != null) goto L8;
    L10:
        ILogDepend.Companion.i(TAG, "stopRunningAction: jobId=" + r4.e() + ", state=" + r5 + ", isSameMessageId=" + r6 + " jobMsgid " + r4.d() + " messageId " + r12);
        if (r6 == true) goto L14;
        if (r12 != null) goto L4;
    L14:
        if (r13 == null) goto L18;
        if (d.h.b.o.a(r13, String.valueOf(r4.b().getActionId())) == false) goto L4;
    L18:
        if (r14 == null) goto L22;
        if (d.h.b.o.a(r14, r4.b().getAction().getAction()) == true) goto L22;
        ILogDepend.Companion.i(TAG, "stopRunningAction: intentName:" + r14 + " != " + r4.b().getAction().getAction());
    L22:
        Set<Long> r7 = f;
        r7.add(Long.valueOf(r4.e()));
        ILogDepend.Companion.i(TAG, "Added interrupted interruptedJobs: " + r7);
        int r8 = a.f18494a[r5.ordinal()];
        if (r8 == 1) goto L34;
        if (r8 == 2) goto L34;
        if (r8 != 3) goto L29;
    L33:
        kotlinx.coroutines.i.a(f18490b, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new k(r4, r15, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        goto L4
    L29:
        if (r8 == 4) goto L33;
        throw new d.k();
    L34:
        ILogDepend.Companion.i(TAG, "Removing job: " + r4 + ", state=" + r5 + ", reason: " + r15);
        r16.remove();
        g.remove(Long.valueOf(r4.d()));
        goto L4
    L8:
        if (r4.d() != Long.parseLong(r12)) goto L10;
        r6 = true;
        goto L10
    }
}
