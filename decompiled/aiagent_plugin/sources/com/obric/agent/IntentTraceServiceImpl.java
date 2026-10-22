package com.obric.agent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.agent.trace.IIntentTraceService;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.capabilitykit.common.Ext;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: IntentTraceServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntentTraceServiceImpl implements IIntentTraceService {

    /* JADX INFO: compiled from: IntentTraceServiceImpl.kt */
    @d.c.b.a.f(b = "IntentTraceServiceImpl.kt", c = {ApWakeEvent.ACCELERATING_START}, d = "invokeSuspend", e = "com.obric.agent.IntentTraceServiceImpl$getEngineCost$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Long>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IntentTraceServiceImpl f14200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14201c;

        a(IntentTraceServiceImpl r3, String r4, d.c.d<? super a> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14200b = r3;
            this.f14201c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Long> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f14200b, this.f14201c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Long> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14199a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            IntentTraceServiceImpl r7 = this.f14200b;
            String r2 = this.f14201c;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14199a = 1;
            r6 = IntentTraceServiceImpl.access$getEngineCostInternal(r7, r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: IntentTraceServiceImpl.kt */
    @d.c.b.a.f(b = "IntentTraceServiceImpl.kt", c = {144}, d = "invokeSuspend", e = "com.obric.agent.IntentTraceServiceImpl$getEngineCostInternal$2")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Long>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14203b;

        b(String r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14203b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super Long> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f14203b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Long> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14202a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            com.obric.agent.trace.q r8 = com.obric.agent.trace.q.f15713a;
            String r2 = this.f14203b;
            com.obric.agent.trace.o r3 = com.obric.agent.trace.o.r;
            d.c.d<? super Long> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14202a = 1;
            r7 = r8.a(r2, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: IntentTraceServiceImpl.kt */
    @d.c.b.a.f(b = "IntentTraceServiceImpl.kt", c = {108, 110}, d = "getQueryOrReWriteContent", e = "com.obric.agent.IntentTraceServiceImpl")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f14205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IntentTraceServiceImpl f14206c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f14207d;

        c(IntentTraceServiceImpl r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14206c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14205b = r3;
            this.f14207d |= Integer.MIN_VALUE;
            return this.f14206c.getQueryOrReWriteContent(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: IntentTraceServiceImpl.kt */
    @d.c.b.a.f(b = "IntentTraceServiceImpl.kt", c = {116, 118, IdlErrors.E_RejectInferDeviceOverheat, IdlErrors.E_RejectInferDeviceOverheat, 121}, d = "getQueryOrReWriteContentForSummary", e = "com.obric.agent.IntentTraceServiceImpl")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f14209b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IntentTraceServiceImpl f14210c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f14211d;

        d(IntentTraceServiceImpl r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14210c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14209b = r3;
            this.f14211d |= Integer.MIN_VALUE;
            return this.f14210c.getQueryOrReWriteContentForSummary(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public IntentTraceServiceImpl() {
    }

    public static final /* synthetic */ Object access$getEngineCostInternal(IntentTraceServiceImpl r2, String r3, d.c.d r4) {
        return r2.getEngineCostInternal(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public void recordASRDuration(String r1, long r2, String r4) {
        d.h.b.o.e(r1, DbHelper.COL_ID);
        com.obric.agent.trace.q.f15713a.a(r1, r2, r4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ILogDepend.Companion r3 = ILogDepend.Companion;
        StringBuilder r5 = new StringBuilder().append("recordASRDuration failed! ");
        e.printStackTrace();
        r3.e("IntentTracer", r5.append(d.x.f38692a).toString());
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public void recordAudioInfo(String r1, String r2, String r3) {
        com.obric.agent.trace.q.f15713a.a(r1, r2, r3);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        ILogDepend.Companion r4 = ILogDepend.Companion;
        StringBuilder r5 = new StringBuilder().append("recordAudioInfo failed! ");
        e.printStackTrace();
        r4.e("IntentTracer", r5.append(d.x.f38692a).toString());
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public void onQueryInput(String r8, String r9) {
        d.h.b.o.e(r8, DbHelper.COL_ID);
        d.h.b.o.e(r9, DownloadConstants.QUERY_KEY);
        com.obric.agent.trace.q.f15713a.a(r8, r9);     // Catch: Exception -> L5
        com.obric.agent.trace.q.a(com.obric.agent.trace.q.f15713a, r8, DownloadConstants.QUERY_KEY, r9, 0, 8, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ILogDepend.Companion r10 = ILogDepend.Companion;
        StringBuilder r11 = new StringBuilder().append("onQueryInput failed! ");
        e.printStackTrace();
        r10.e("IntentTracer", r11.append(d.x.f38692a).toString());
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public void onIntentDispatched(String r3) {
        d.h.b.o.e(r3, DbHelper.COL_ID);
        com.obric.agent.trace.q.f15713a.c(r3);
        com.obric.agent.trace.q.f15713a.a(r3, com.obric.agent.trace.o.r, false);
        com.obric.agent.trace.q.f15713a.a(r3, true);
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public void enterAppActionStage(String r9, long r10, String r12, boolean r13) {
        d.h.b.o.e(r9, DbHelper.COL_ID);
        d.h.b.o.e(r12, "intentName");
        com.obric.agent.trace.q.a(com.obric.agent.trace.q.f15713a, r9, com.obric.agent.trace.o.t, false, 4, null);
        com.obric.agent.trace.q.f15713a.a(r9, com.obric.agent.trace.o.t, r10, r13);
        com.obric.agent.trace.q.a(com.obric.agent.trace.q.f15713a, r9, Ext.KEY_INTENT_NAME, r12, 0, 8, null);
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public void onResultReceived(String r1, com.obric.agent.trace.f r2) {
        d.h.b.o.e(r1, DbHelper.COL_ID);
        d.h.b.o.e(r2, "result");
        com.obric.agent.trace.q.f15713a.setResult(r1, r2);
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public void onSummarize(String r7) {
        d.h.b.o.e(r7, DbHelper.COL_ID);
        com.obric.agent.trace.q.a(com.obric.agent.trace.q.f15713a, r7, com.obric.agent.trace.o.u, false, 4, null);
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public void onShowingResult(String r7) {
        d.h.b.o.e(r7, DbHelper.COL_ID);
        com.obric.agent.trace.q.a(com.obric.agent.trace.q.f15713a, r7, com.obric.agent.trace.o.y, false, 4, null);
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public void onIntentEnded(String r7) {
        d.h.b.o.e(r7, DbHelper.COL_ID);
        com.obric.agent.trace.q.a(com.obric.agent.trace.q.f15713a, r7, com.obric.agent.trace.o.A, false, 4, null);
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public void onResponseToServer(String r7) {
        d.h.b.o.e(r7, DbHelper.COL_ID);
        com.obric.agent.trace.q.a(com.obric.agent.trace.q.f15713a, r7, com.obric.agent.trace.o.x, false, 4, null);
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public void addStateParams(String r1, String r2, Object r3, int r4) {
        d.h.b.o.e(r1, DbHelper.COL_ID);
        d.h.b.o.e(r2, "key");
        com.obric.agent.trace.q.f15713a.a(r1, r2, r3, r4);
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public void onMessageTimeout(String r1) {
        d.h.b.o.e(r1, "localMessageId");
        com.obric.agent.trace.q.f15713a.b(r1);
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public void onMessageInterrupt(String r3) {
        d.h.b.o.e(r3, "localMessageId");
        com.obric.agent.trace.q.a(com.obric.agent.trace.q.f15713a, r3, null, 2, null);
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public View getDebugView(Context r3, d.h.a.a<d.x> r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "context");
        com.obric.agent.c.a r6 = com.obric.agent.c.a.a(LayoutInflater.from(r2), null, false);
        d.h.b.o.c(r6, "inflate(...)");
        new com.obric.agent.trace.a.d(r6, r5).a();
        ConstraintLayout r7 = r6.b();
        d.h.b.o.c(r7, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public Object getQuery(String r2, d.c.d<? super String> r3) {
        d.c.d<? super String> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.agent.trace.q.f15713a.a(r2, r1);
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public Object getQueryOrReWriteContent(String r6, d.c.d<? super String> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r8, c.class, "com.obric.aiagent.plugin");
        if ((r0.f14207d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f14207d -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.f14205b;
        Object r9 = d.c.a.b.a();
        int r2 = r0.f14207d;
        boolean r4 = true;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        d.o.a(r5);
    L30:
        return (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r6 = (String) ZeusTransformUtils.preCheckCast(r0.f14204a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
    L19:
        String r10 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L22;
    L25:
        if (r4 == false) goto L31;
        com.obric.agent.trace.q r11 = com.obric.agent.trace.q.f15713a;
        r0.f14204a = null;
        r0.f14207d = 2;
        r5 = r11.a(r6, r0);
        if (r5 != r9) goto L30;
        return r9;
    L31:
        return r10;
    L22:
        if (r3.length() == 0) goto L25;
        r4 = false;
        goto L25
    L16:
        d.o.a(r5);
        com.obric.agent.trace.q r12 = com.obric.agent.trace.q.f15713a;
        r0.f14204a = r6;
        r0.f14207d = 1;
        r5 = r12.f(r6, r0);
        if (r5 != r9) goto L19;
        return r9;
    L7:
        r0 = new c(this, r8);
        goto L8
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public Object getQueryOrReWriteContentForSummary(String r10, d.c.d<? super String> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r12, d.class, "com.obric.aiagent.plugin");
        if ((r0.f14211d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f14211d -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f14209b;
        Object r13 = d.c.a.b.a();
        int r2 = r0.f14211d;
        if (r2 == 0) goto L22;
        if (r2 == 1) goto L21;
        if (r2 == 2) goto L20;
        if (r2 == 3) goto L19;
        if (r2 == 4) goto L18;
        if (r2 != 5) goto L17;
        d.o.a(r9);
    L51:
        return (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r9);
    L54:
        return (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
    L19:
        r10 = (String) ZeusTransformUtils.preCheckCast(r0.f14208a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r9);
    L41:
        String r14 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L53;
        com.obric.agent.trace.q r15 = com.obric.agent.trace.q.f15713a;
        r0.f14208a = null;
        r0.f14211d = 4;
        r9 = r15.a(r10, r0);
        if (r9 != r13) goto L54;
        return r13;
    L53:
        return r14;
    L20:
        r10 = (String) ZeusTransformUtils.preCheckCast(r0.f14208a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r9);
    L37:
        if (d.h.b.o.a(r9, d.c.b.a.b.a(true)) == false) goto L47;
        com.obric.agent.trace.q r16 = com.obric.agent.trace.q.f15713a;
        r0.f14208a = r10;
        r0.f14211d = 3;
        r9 = r16.b(r10, r0);
        if (r9 != r13) goto L41;
        return r13;
    L47:
        com.obric.agent.trace.q r17 = com.obric.agent.trace.q.f15713a;
        r0.f14208a = null;
        r0.f14211d = 5;
        r9 = r17.a(r10, r0);
        if (r9 != r13) goto L51;
        return r13;
    L21:
        r10 = (String) ZeusTransformUtils.preCheckCast(r0.f14208a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r9);
    L25:
        String r18 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L28;
    L31:
        boolean r4 = true;
    L32:
        if (r4 == false) goto L52;
        com.obric.agent.trace.q r19 = com.obric.agent.trace.q.f15713a;
        r0.f14208a = r10;
        r0.f14211d = 2;
        r9 = r19.d(r10, r0);
        if (r9 != r13) goto L37;
        return r13;
    L52:
        return r18;
    L28:
        if (r3.length() == 0) goto L31;
        r4 = false;
        goto L32
    L22:
        d.o.a(r9);
        com.obric.agent.trace.q r20 = com.obric.agent.trace.q.f15713a;
        r0.f14208a = r10;
        r0.f14211d = 1;
        r9 = r20.f(r10, r0);
        if (r9 != r13) goto L25;
        return r13;
    L7:
        r0 = new d(this, r12);
        goto L8
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public Long getEngineCost(String r4) {
        d.h.b.o.e(r4, DbHelper.COL_ID);
        return (Long) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this, r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), Long.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        ILogDepend.Companion r5 = ILogDepend.Companion;
        StringBuilder r0 = new StringBuilder().append("getEngineCost failed! ");
        e.printStackTrace();
        r5.e("IntentTracer", r0.append(d.x.f38692a).toString());
        return null;
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public boolean isAppIntentActive() {
        return com.obric.agent.trace.q.f15713a.d();
    }

    private final Object getEngineCostInternal(String r3, d.c.d<? super Long> r4) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return dg.b(40, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r2);
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public void onAuthBegin(String r1, int r2) {
        d.h.b.o.e(r1, DbHelper.COL_ID);
        com.obric.agent.trace.q.f15713a.a(r1, r2);
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public void onAuthEnd(String r1) {
        d.h.b.o.e(r1, DbHelper.COL_ID);
        com.obric.agent.trace.q.f15713a.a(r1);
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public void setAppStateEndTime(String r2) {
        d.h.b.o.e(r2, DbHelper.COL_ID);
        com.obric.agent.trace.q.f15713a.a(r2, com.obric.agent.trace.o.t);
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public void reportPermissionGranted(String r1, String r2, boolean r3, String r4) {
        d.h.b.o.e(r1, "permission");
        d.h.b.o.e(r2, DBHelper.BATTERY_COL_SCENE);
        com.obric.agent.trace.g.f15449a.a(r1, r2, r3, r4);
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public Object getRunningAction(String r2, d.c.d<? super String> r3) {
        d.c.d<? super String> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.agent.trace.q.f15713a.c(r2, r1);
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public void addInterruptedState(String r2, String r3, Map<String, ? extends Object> r4) {
        Map<String, ? extends Object> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, DbHelper.COL_ID);
        d.h.b.o.e(r3, "interruptReason");
        com.obric.agent.trace.q.f15713a.a(r2, r3, r1);
    }

    @Override // com.obric.agent.trace.IIntentTraceService
    public void onProcessDead(String r2, Map<String, String> r3) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "reason");
        com.obric.agent.trace.q.f15713a.a(r2, r1);
    }
}
