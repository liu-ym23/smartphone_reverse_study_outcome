package com.obric.event.task.base.report;

import com.bytedance.crash.dumper.Scraps;
import com.bytedance.keva.Keva;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.assistant.idl.IFlowNetworkIDL;
import com.obric.aiagent.assistant.idl.IFlowNetworkResultCallbackIDL;
import com.obric.aiagent.assistant.idl.bean.ObricConditionalTaskCreateRequest;
import com.obric.aiagent.assistant.idl.bean.ObricConditionalTaskSweepRequest;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.eventkit.task.api.IEventTaskApi;
import com.obric.eventkit.task.model.BatteryCondition;
import com.obric.eventkit.task.model.BluetoothCondition;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.LocationCondition;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.ShortcutTaskAction;
import com.obric.eventkit.task.model.SmsCondition;
import com.obric.eventkit.task.model.StorageCondition;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.obric.eventkit.task.model.TimeCondition;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import com.obric.eventkit.task.model.WifiCondition;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.aa;
import d.x;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: TaskDataReportManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class o {
    private static final String TAG = "TaskDataReportManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f32870a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long[] f32871b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final am f32872c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f32873d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final d.f f32874e = null;
    private static final DateTimeFormatter f = null;

    /* JADX INFO: compiled from: TaskDataReportManager.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f32875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f32876b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f32875a == r6.f32875a) goto L12;
            return false;
        L12:
            if (this.f32876b == r6.f32876b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f32875a) * 31) + Boolean.hashCode(this.f32876b);
        }

        public String toString() {
            return "SweepTaskTypeResult(hasTaskToReport=" + this.f32875a + ", success=" + this.f32876b + ')';
        }

        public a(boolean r1, boolean r2) {
            this.f32875a = r1;
            this.f32876b = r2;
        }

        public final boolean a() {
            return this.f32875a;
        }

        public final boolean b() {
            return this.f32876b;
        }
    }

    /* JADX INFO: compiled from: TaskDataReportManager.kt */
    @d.c.b.a.f(b = "TaskDataReportManager.kt", c = {251, 255}, d = "sweepConditionalTaskWithRetry", e = "com.obric.event.task.base.report.TaskDataReportManager")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f32877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f32878b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f32879c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f32880d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f32881e;

        b(o r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32880d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f32879c = r3;
            this.f32881e |= Integer.MIN_VALUE;
            return o.a(this.f32880d, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskDataReportManager.kt */
    @d.c.b.a.f(b = "TaskDataReportManager.kt", c = {273, 294, 303}, d = "sweepTaskTypeWithRetry", e = "com.obric.event.task.base.report.TaskDataReportManager")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f32882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f32883b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f32884c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f32885d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f32886e;
        int f;
        int g;
        int h;
        boolean i;
        /* synthetic */ Object j;
        final /* synthetic */ o k;
        int l;

        c(o r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.k = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.j = r3;
            this.l |= Integer.MIN_VALUE;
            return o.a(this.k, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskDataReportManager.kt */
    @d.c.b.a.f(b = "TaskDataReportManager.kt", c = {114}, d = "invokeSuspend", e = "com.obric.event.task.base.report.TaskDataReportManager$trySweepConditionalTaskIfNeeded$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f32887a;

        d(d.c.d<? super d> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f32887a;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            d.o.a(r6);     // Catch: Throwable -> L7
        L15:
            o.b().set(false);
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r6);
            o r7 = o.f32870a;     // Catch: Throwable -> L7
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            this.f32887a = 1;     // Catch: Throwable -> L7
            if (o.a(r7, r2) != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            o.b().set(false);
            throw th;
        }
    }

    public static /* synthetic */ Keva lambda$DtLM5zGftUGikTDF1q8dSw1KiWE() {
        return f();
    }

    private o() {
    }

    public static final /* synthetic */ Object a(o r2, int r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(o r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ AtomicBoolean b() {
        return f32873d;
    }

    static {
        f32870a = new o();
        f32871b = new long[]{1000, 2000, 4000};
        f32872c = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
        f32873d = new AtomicBoolean(false);
        f32874e = d.g.a($$Lambda$o$DtLM5zGftUGikTDF1q8dSw1KiWE.INSTANCE);
        DateTimeFormatter r0 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        d.h.b.o.c(r0, "ofPattern(...)");
        f = r0;
    }

    private final Keva c() {
        return (Keva) ZeusTransformUtils.preCheckCast(f32874e.b(), Keva.class, "com.obric.aiagent.plugin");
    }

    private static final Keva f() {
        return Keva.getRepo("obric_task_data_report");
    }

    public final void a() {
        if (d() == false) goto L7;
        com.obric.event.task.base.b.b.f32684a.b(TAG, "trySweepConditionalTaskIfNeeded skipped, already reported");
        return;
    L7:
        if (f32873d.compareAndSet(false, true) == true) goto L10;
        com.obric.event.task.base.b.b.f32684a.b(TAG, "trySweepConditionalTaskIfNeeded skipped, reporting in progress");
        return;
    L10:
        kotlinx.coroutines.i.a(f32872c, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public static /* synthetic */ void a(o r7, ConditionTask r8, String r9, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 8) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r13 & 16) == 0) goto L9;
        String r6 = null;
    L10:
        r7.a(r8, r9, r10, r5, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }

    public final void a(ConditionTask r19, final String r20, String r21, String r22, String r23) {
        d.h.b.o.e(r19, "conditionTask");
        d.h.b.o.e(r20, "operateType");
        d.h.b.o.e(r21, "createType");
        final String r1 = r19.getId();
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L8;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L13;
        com.obric.event.task.base.b.b.f32684a.d(TAG, "reportConditionTaskCreateOrUpdate taskId empty");
        return;
    L13:
        ConditionTaskAction r6 = (ConditionTaskAction) ZeusTransformUtils.preCheckCast(d.a.p.l(r19.getActions()), ConditionTaskAction.class, "com.obric.aiagent.plugin");
        String r8 = null;
        if (r6 == null) goto L16;
        IntentParams r7 = r6.getParams();
    L18:
        if (ZeusTransformUtils.instanceOf(r7, SystemAutoActionParams.class) == false) goto L20;
        SystemAutoActionParams r9 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r7, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
    L21:
        if (r9 == null) goto L23;
        r8 = r9.getInstruction();
    L23:
        if (r8 != null) goto L25;
        r8 = "";
    L25:
        String r10 = com.obric.event.task.base.report.c.b(r19);
        String r11 = a(r19);
        Long r12 = r19.getCreateTime();
        if (r12 == null) goto L28;
        long r13 = r12.longValue();
    L29:
        String r14 = a(r13);
        String r15 = a(System.currentTimeMillis());
        String r16 = b(r19).toString();
        d.h.b.o.c(r16, "toString(...)");
        IFlowNetworkIDL r0 = com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class));
        if (r0 == null) goto L43;
        TaskKnowledge r17 = r19.getTaskKnowledge();
        if (r17 == null) goto L37;
        String r18 = r17.getContent();
        if (r18 == null) goto L37;
        String r110 = r18;
    L38:
        String r2 = r19.getOmniModel();
        if (r2 != null) goto L41;
        String r111 = "";
    L42:
        r0.createConditionalTask(r1, r11, r21, r8, r10, "", r14, r15, r110, r16, r20, r22, r23, r111, ao.b(), (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.preCheckCast(new TaskDataReportManager$reportConditionTaskCreateOrUpdate$1(r20, r1), IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin"));
        return;
    L41:
        r111 = r2;
    L37:
        r110 = "";
        goto L38
    L43:
        com.obric.event.task.base.b.b.f32684a.d(TAG, "reportConditionTaskCreateOrUpdate ipc empty, type=" + r20 + ", taskId=" + r1);
        return;
    L28:
        r13 = System.currentTimeMillis();
        goto L29
    L20:
        r9 = null;
        goto L21
    L16:
        r7 = null;
        goto L18
    L8:
        r5 = false;
        goto L10
    }

    public static /* synthetic */ void a(o r7, ShortcutTask r8, String r9, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 8) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r13 & 16) == 0) goto L9;
        String r6 = null;
    L10:
        r7.a(r8, r9, r10, r5, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }

    public final void a(ShortcutTask r19, final String r20, String r21, String r22, String r23) {
        d.h.b.o.e(r19, "shortTask");
        d.h.b.o.e(r20, "operateType");
        d.h.b.o.e(r21, "createType");
        final String r1 = r19.getId();
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L8;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L13;
        com.obric.event.task.base.b.b.f32684a.d(TAG, "reportShortcutTaskCreateOrUpdate taskId empty, type=" + r20);
        return;
    L13:
        String r6 = r19.getShortInstruct();
        String r9 = null;
        if (r19.isShortInstructEnable() == true) goto L17;
        r6 = null;
    L17:
        ShortcutTaskAction r8 = (ShortcutTaskAction) ZeusTransformUtils.preCheckCast(d.a.p.l(r19.getActions()), ShortcutTaskAction.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L20;
        IntentParams r10 = r8.getParams();
    L22:
        if (ZeusTransformUtils.instanceOf(r10, SystemAutoActionParams.class) == false) goto L24;
        SystemAutoActionParams r11 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r10, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
    L25:
        if (r11 == null) goto L27;
        String r12 = r11.getInstruction();
    L28:
        if (r12 != null) goto L30;
        r12 = "";
    L30:
        Long r13 = r19.getCreateTime();
        if (r13 == null) goto L33;
        long r14 = r13.longValue();
    L34:
        String r15 = a(r14);
        String r16 = a(System.currentTimeMillis());
        String r17 = b(r6);
        IFlowNetworkIDL r0 = com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class));
        if (r0 == null) goto L49;
        if (r6 != null) goto L38;
        String r7 = "";
    L39:
        TaskKnowledge r18 = r19.getTaskKnowledge();
        if (r18 == null) goto L42;
        r9 = r18.getContent();
    L42:
        if (r9 != null) goto L44;
        r9 = "";
    L44:
        String r2 = r19.getOmniModel();
        if (r2 != null) goto L47;
        String r110 = "";
    L48:
        r0.createConditionalTask(r1, r17, r21, r12, "", r7, r15, r16, r9, "", r20, r22, r23, r110, ao.b(), (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.preCheckCast(new TaskDataReportManager$reportShortcutTaskCreateOrUpdate$1(r20, r1), IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin"));
        return;
    L47:
        r110 = r2;
        goto L48
    L38:
        r7 = r6;
        goto L39
    L49:
        com.obric.event.task.base.b.b.f32684a.d(TAG, "reportShortcutTaskCreateOrUpdate ipc empty, type=" + r20 + ", taskId=" + r1);
        return;
    L33:
        r14 = System.currentTimeMillis();
        goto L34
    L27:
        r12 = null;
        goto L28
    L24:
        r11 = null;
        goto L25
    L20:
        r10 = null;
        goto L22
    L8:
        r5 = false;
        goto L10
    }

    public final void a(final String r5) {
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L7;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L12;
        com.obric.event.task.base.b.b.f32684a.d(TAG, "reportTaskDelete taskId empty");
        return;
    L12:
        IFlowNetworkIDL r6 = com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class));
        if (r6 == null) goto L15;
        r6.deleteConditionalTask(r5, ao.b(), (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.preCheckCast(new TaskDataReportManager$reportTaskDelete$1(r5), IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin"));
        return;
    L15:
        com.obric.event.task.base.b.b.f32684a.d(TAG, "reportTaskDelete ipc empty, taskId=" + r5);
        return;
    L7:
        r4 = false;
        goto L9
    }

    public final String b(String r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        return "shortcut";
    L11:
        return "shortcut_short";
    L5:
        if (r1.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    private final Object a(d.c.d<? super x> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, b.class) == false) goto L7;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r10, b.class, "com.obric.aiagent.plugin");
        if ((r1.f32881e & Integer.MIN_VALUE) == 0) goto L7;
        r1.f32881e -= Integer.MIN_VALUE;
    L8:
        Object r11 = r1.f32879c;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f32881e;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        a r8 = (a) ZeusTransformUtils.preCheckCast(r1.f32878b, a.class, "com.obric.aiagent.plugin");
        o r0 = (o) ZeusTransformUtils.preCheckCast(r1.f32877a, o.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L27:
        a r12 = (a) ZeusTransformUtils.preCheckCast(r11, a.class, "com.obric.aiagent.plugin");
        if (r12.b() == true) goto L32;
        return x.f38692a;
    L32:
        if (r8.a() == false) goto L34;
    L37:
        r0.e();
        return x.f38692a;
    L34:
        if (r12.a() == true) goto L37;
        com.obric.event.task.base.b.b.f32684a.b(TAG, "sweepConditionalTaskWithRetry no stock task need report");
        r0.e();
        return x.f38692a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        o this = (o) ZeusTransformUtils.preCheckCast(r1.f32877a, o.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L19:
        a r13 = (a) ZeusTransformUtils.preCheckCast(r11, a.class, "com.obric.aiagent.plugin");
        if (r13.b() == false) goto L22;
        r1.f32877a = this;
        r1.f32878b = r13;
        r1.f32881e = 2;
        Object r2 = this.a(3, r1);
        if (r2 != r3) goto L26;
        return r3;
    L26:
        r0 = this;
        r8 = r13;
        r11 = r2;
        goto L27
    L22:
        return x.f38692a;
    L16:
        d.o.a(r11);
        r1.f32877a = this;
        r1.f32881e = 1;
        r11 = a(2, r1);
        if (r11 != r3) goto L19;
        return r3;
    L7:
        r1 = new b(this, r10);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0178 -> B:20:0x00f9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x01b5 -> B:43:0x01b7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0268 -> B:59:0x026b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0276 -> B:61:0x0278). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x028b -> B:66:0x0294). Please report as a decompilation issue!!! */
    private final Object a(int r20, d.c.d<? super a> r21) {
        String r2 = "com.obric.aiagent.plugin";
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, c.class) == false) goto L7;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin");
        if ((r3.l & Integer.MIN_VALUE) == 0) goto L7;
        r3.l -= Integer.MIN_VALUE;
        o r4 = this;
    L8:
        Object r5 = r3.j;
        Object r6 = d.c.a.b.a();
        int r7 = r3.l;
        if (r7 == 0) goto L19;
        if (r7 == 1) goto L18;
        if (r7 == 2) goto L16;
        if (r7 != 3) goto L15;
        int r8 = r3.h;
        int r9 = r3.g;
        boolean r15 = r3.i;
        int r14 = r3.f;
        int r10 = r3.f32886e;
        int r11 = r3.f32885d;
        ObricConditionalTaskSweepRequest r12 = (ObricConditionalTaskSweepRequest) ZeusTransformUtils.preCheckCast(r3.f32884c, ObricConditionalTaskSweepRequest.class, "com.obric.aiagent.plugin");
        IEventTaskApi r13 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(r3.f32883b, IEventTaskApi.class, "com.obric.aiagent.plugin");
        o r0 = (o) ZeusTransformUtils.preCheckCast(r3.f32882a, o.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        String r16 = "com.obric.aiagent.plugin";
        Object r17 = r6;
        int r18 = r14;
        int r19 = r8;
        int r110 = r9;
    L61:
        char r22 = 3;
    L59:
        int r23 = r19;
        o r24 = r0;
        int r25 = r11;
        int r111 = r10;
        IEventTaskApi r26 = r13;
        int r27 = r18;
        ObricConditionalTaskSweepRequest r112 = r12;
        int r28 = r111;
        if (r110 == r23) goto L64;
        r110 = r110 + 1;
        Object r29 = r17;
        r2 = r16;
    L43:
        r3.f32882a = r24;
        r3.f32883b = r26;
        r3.f32884c = r112;
        r3.f32885d = r25;
        r3.f32886e = r28;
        r3.f = r27;
        r3.g = r110;
        r3.h = r23;
        r3.l = 2;
        Object r113 = r24.a(r112, r3);
        if (r113 != r29) goto L46;
        return r29;
    L46:
        r11 = r25;
        r0 = r24;
        r19 = r23;
        r5 = r113;
        ObricConditionalTaskSweepRequest r114 = r112;
        r18 = r27;
        r13 = r26;
        r10 = r28;
    L17:
        r12 = r114;
        r15 = ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, r2)).booleanValue();
        com.obric.event.task.base.b.b r30 = com.obric.event.task.base.b.b.f32684a;
        r16 = r2;
        Object r115 = r29;
        StringBuilder r31 = new StringBuilder().append("sweepTaskTypeWithRetry result success=").append(r15).append(", type=").append(r0.a(r11)).append(", attempt=").append(r110).append(", offset=").append(r10).append(", size=");
        List<ObricConditionalTaskCreateRequest> r32 = r12.getTaskList();
        if (r32 == null) goto L50;
        int r33 = r32.size();
    L51:
        r30.b(TAG, r31.append(r33).toString());
        if (r15 == false) goto L54;
        r6 = r115;
        int r34 = r10;
        r26 = r13;
        r4 = r0;
        r25 = r11;
    L66:
        if (r15 == true) goto L73;
        com.obric.event.task.base.b.b r35 = com.obric.event.task.base.b.b.f32684a;
        StringBuilder r36 = new StringBuilder().append("sweepTaskTypeWithRetry failed, type=").append(r4.a(r25)).append(", offset=").append(r34).append(", size=");
        List<ObricConditionalTaskCreateRequest> r37 = r12.getTaskList();
        if (r37 == null) goto L70;
        int r38 = r37.size();
    L71:
        r35.d(TAG, r36.append(r38).toString());
        return new a(true, false);
    L70:
        r38 = 0;
        goto L71
    L73:
        int r39 = r18;
        r2 = r16;
    L20:
        if (r26 == null) goto L26;
        r3.f32882a = r4;
        r3.f32883b = r26;
        r3.f32884c = null;
        r3.f32885d = r25;
        r3.f32886e = r34;
        r3.f = r39;
        r3.l = 1;
        Object r40 = r26.getEventTasksByType(r25, r34, 20, r3);
        if (r40 != r6) goto L24;
        return r6;
    L24:
        int r41 = r25;
        o r42 = r4;
        int r43 = r39;
        r5 = r40;
    L25:
        List<? extends EventTask> r44 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, r2);
        Object r116 = r6;
        r24 = r42;
        r25 = r41;
        int r45 = r34;
        r29 = r116;
    L27:
        if (r44 != null) goto L30;
        r44 = d.a.p.b();
    L30:
        if (r44.isEmpty() == false) goto L37;
        com.obric.event.task.base.b.b.f32684a.b(TAG, "sweepTaskTypeWithRetry no more task, type=" + r24.a(r25) + ", offset=" + r45);
        if (r43 == 0) goto L34;
        boolean r117 = true;
    L36:
        return new a(r117, true);
    L34:
        r117 = false;
        goto L36
    L37:
        r28 = r45 + r44.size();
        r112 = r24.a(r44);
        if (r112 != null) goto L40;
        com.obric.event.task.base.b.b.f32684a.b(TAG, "sweepTaskTypeWithRetry skip empty batch, type=" + r24.a(r25) + ", offset=" + r28 + ", rawSize=" + r44.size());
        r39 = r43;
        r4 = r24;
        r6 = r29;
        r34 = r28;
        goto L20
    L40:
        r23 = f32871b.length;
        if (r23 < 0) goto L65;
        r27 = 1;
        r110 = 0;
        goto L43
    L65:
        r16 = r2;
        r4 = r24;
        r6 = r29;
        r34 = r28;
        r12 = r112;
        r18 = 1;
        r15 = false;
        goto L66
    L26:
        r45 = r34;
        r29 = r6;
        r24 = r4;
        r43 = r39;
        r44 = null;
        goto L27
    L54:
        long[] r46 = f32871b;
        if (r110 >= r46.length) goto L60;
        long r47 = r46[r110];
        r3.f32882a = r0;
        r3.f32883b = r13;
        r3.f32884c = r12;
        r3.f32885d = r11;
        r3.f32886e = r10;
        r3.f = r18;
        r3.i = r15;
        r3.g = r110;
        r3.h = r19;
        r22 = 3;
        r3.l = 3;
        r17 = r115;
        if (ax.a(r47, r3) != r17) goto L59;
        return r17;
    L60:
        r17 = r115;
        goto L61
    L50:
        r33 = 0;
        goto L51
    L64:
        r34 = r28;
        r12 = r112;
        r18 = r27;
        r4 = r24;
        r6 = r17;
        goto L66
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        int r48 = r3.h;
        int r49 = r3.g;
        int r50 = r3.f;
        r10 = r3.f32886e;
        r11 = r3.f32885d;
        ObricConditionalTaskSweepRequest r118 = (ObricConditionalTaskSweepRequest) ZeusTransformUtils.preCheckCast(r3.f32884c, ObricConditionalTaskSweepRequest.class, "com.obric.aiagent.plugin");
        IEventTaskApi r119 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(r3.f32883b, IEventTaskApi.class, "com.obric.aiagent.plugin");
        r0 = (o) ZeusTransformUtils.preCheckCast(r3.f32882a, o.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        r19 = r48;
        r13 = r119;
        r110 = r49;
        r29 = r6;
        r114 = r118;
        r18 = r50;
        goto L17
    L18:
        r43 = r3.f;
        r34 = r3.f32886e;
        r41 = r3.f32885d;
        r26 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(r3.f32883b, IEventTaskApi.class, "com.obric.aiagent.plugin");
        r42 = (o) ZeusTransformUtils.preCheckCast(r3.f32882a, o.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        goto L25
    L19:
        d.o.a(r5);
        r26 = (IEventTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEventTaskApi.class), IEventTaskApi.class, "com.obric.aiagent.plugin");
        r39 = 0;
        r34 = 0;
        r25 = r20;
    L7:
        r4 = this;
        r3 = new c(r4, r1);
        goto L8
    }

    private final ObricConditionalTaskSweepRequest a(List<? extends EventTask> r5) {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r4.iterator();
    L3:
        ObricConditionalTaskCreateRequest r2 = null;
        if (r7.hasNext() == false) goto L10;
        EventTask r1 = (EventTask) ZeusTransformUtils.preCheckCast(r7.next(), EventTask.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L8;
        r2 = f32870a.a(r1);
    L8:
        if (r2 == null) goto L3;
        r6.add(r2);
        goto L3
    L10:
        List r8 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
        if (r8.isEmpty() == false) goto L14;
        return null;
    L14:
        return new ObricConditionalTaskSweepRequest(r8, ao.b());
    }

    private final String a(int r1) {
        if (r1 != 2) goto L5;
        return "condition";
    L5:
        if (r1 != 3) goto L10;
        return "shortcut";
    L10:
        return String.valueOf(r1);
    }

    private final ObricConditionalTaskCreateRequest a(EventTask r6) {
        CharSequence r1 = "gui";
        if (ZeusTransformUtils.instanceOf(r6, ConditionTask.class) == false) goto L16;
        ConditionTask r0 = (ConditionTask) ZeusTransformUtils.preCheckCast(r6, ConditionTask.class, "com.obric.aiagent.plugin");
        String r7 = com.obric.event.task.base.report.c.a((ConditionTask) ZeusTransformUtils.preCheckCast(r6, ConditionTask.class, "com.obric.aiagent.plugin"));
        if (r7 != null) goto L7;
        r7 = "";
    L7:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        if (r8.length() != 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L20;
        r1 = r8;
    L20:
        return a(r0, "sweep", (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin"));
    L10:
        r4 = false;
        goto L11
    L16:
        if (ZeusTransformUtils.instanceOf(r6, ShortcutTask.class) == true) goto L21;
        return null;
    L21:
        return a((ShortcutTask) ZeusTransformUtils.preCheckCast(r6, ShortcutTask.class, "com.obric.aiagent.plugin"), "sweep", "gui");
    }

    private final ObricConditionalTaskCreateRequest a(ConditionTask r20, String r21, String r22) {
        String r1 = r20.getId();
        if (r1 != null) goto L5;
        String r4 = "";
    L7:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L9;
        boolean r2 = true;
    L10:
        String r5 = null;
        if (r2 == false) goto L13;
        return null;
    L13:
        ConditionTaskAction r3 = (ConditionTaskAction) ZeusTransformUtils.preCheckCast(d.a.p.l(r20.getActions()), ConditionTaskAction.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L16;
        IntentParams r6 = r3.getParams();
    L18:
        if (ZeusTransformUtils.instanceOf(r6, SystemAutoActionParams.class) == false) goto L20;
        SystemAutoActionParams r7 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r6, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
    L21:
        if (r7 == null) goto L23;
        String r8 = r7.getInstruction();
    L24:
        if (r8 != null) goto L26;
        String r9 = "";
    L27:
        String r10 = a(r20);
        String r11 = com.obric.event.task.base.report.c.b(r20);
        if (r11 != null) goto L30;
        String r12 = "";
    L31:
        Long r13 = r20.getCreateTime();
        if (r13 == null) goto L34;
        long r14 = r13.longValue();
    L35:
        String r15 = a(r14);
        String r16 = a(System.currentTimeMillis());
        TaskKnowledge r17 = r20.getTaskKnowledge();
        if (r17 == null) goto L38;
        r5 = r17.getContent();
    L38:
        if (r5 != null) goto L40;
        String r18 = "";
    L41:
        String r19 = b(r20).toString();
        String r0 = r20.getTemplateId();
        if (r0 != null) goto L44;
        String r110 = "";
    L45:
        String r23 = r20.getOmniModel();
        if (r23 != null) goto L48;
        String r111 = "";
    L50:
        return new ObricConditionalTaskCreateRequest(r4, r10, r22, r9, r12, "", r15, r16, r18, r19, r21, ao.b(), r110, null, r111);
    L48:
        r111 = r23;
        goto L50
    L44:
        r110 = r0;
        goto L45
    L40:
        r18 = r5;
        goto L41
    L34:
        r14 = System.currentTimeMillis();
        goto L35
    L30:
        r12 = r11;
        goto L31
    L26:
        r9 = r8;
        goto L27
    L23:
        r8 = null;
        goto L24
    L20:
        r7 = null;
        goto L21
    L16:
        r6 = null;
        goto L18
    L9:
        r2 = false;
        goto L10
    L5:
        r4 = r1;
        goto L7
    }

    private final ObricConditionalTaskCreateRequest a(ShortcutTask r20, String r21, String r22) {
        String r1 = r20.getId();
        if (r1 != null) goto L5;
        String r4 = "";
    L7:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L9;
        boolean r2 = true;
    L10:
        String r5 = null;
        if (r2 == false) goto L13;
        return null;
    L13:
        String r3 = r20.getShortInstruct();
        if (r20.isShortInstructEnable() == true) goto L17;
        r3 = null;
    L17:
        ShortcutTaskAction r6 = (ShortcutTaskAction) ZeusTransformUtils.preCheckCast(d.a.p.l(r20.getActions()), ShortcutTaskAction.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L20;
        IntentParams r7 = r6.getParams();
    L22:
        if (ZeusTransformUtils.instanceOf(r7, SystemAutoActionParams.class) == false) goto L24;
        SystemAutoActionParams r8 = (SystemAutoActionParams) ZeusTransformUtils.preCheckCast(r7, SystemAutoActionParams.class, "com.obric.aiagent.plugin");
    L25:
        if (r8 == null) goto L27;
        String r9 = r8.getInstruction();
    L28:
        if (r9 != null) goto L30;
        String r10 = "";
    L31:
        String r11 = b(r3);
        if (r3 != null) goto L34;
        String r12 = "";
    L35:
        Long r13 = r20.getCreateTime();
        if (r13 == null) goto L38;
        long r14 = r13.longValue();
    L39:
        String r15 = a(r14);
        String r16 = a(System.currentTimeMillis());
        TaskKnowledge r0 = r20.getTaskKnowledge();
        if (r0 == null) goto L42;
        r5 = r0.getContent();
    L42:
        if (r5 != null) goto L44;
        String r17 = "";
    L45:
        String r18 = r20.getTemplateId();
        String r19 = r20.getOmniModel();
        if (r19 != null) goto L48;
        String r110 = "";
    L50:
        return new ObricConditionalTaskCreateRequest(r4, r11, r22, r10, "", r12, r15, r16, r17, "", r21, ao.b(), r18, null, r110);
    L48:
        r110 = r19;
        goto L50
    L44:
        r17 = r5;
        goto L45
    L38:
        r14 = System.currentTimeMillis();
        goto L39
    L34:
        r12 = r3;
        goto L35
    L30:
        r10 = r9;
        goto L31
    L27:
        r9 = null;
        goto L28
    L24:
        r8 = null;
        goto L25
    L20:
        r7 = null;
        goto L22
    L9:
        r2 = false;
        goto L10
    L5:
        r4 = r1;
        goto L7
    }

    private final Object a(ObricConditionalTaskSweepRequest r5, d.c.d<? super Boolean> r6) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        IFlowNetworkIDL r7 = com.obric.aiagent.assistant.idl.am.a(aa.b(IFlowNetworkIDL.class));
        if (r7 != null) goto L6;
        com.obric.event.task.base.b.b.f32684a.d(TAG, "reportSweepRequest ipc empty");
        return d.c.b.a.b.a(false);
    L6:
        kotlinx.coroutines.o r1 = new kotlinx.coroutines.o(d.c.a.b.a(r4), 1);
        r1.e();
        final kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        r7.sweepConditionalTask(r5, (IFlowNetworkResultCallbackIDL) ZeusTransformUtils.preCheckCast(new TaskDataReportManager$reportSweepRequest$2$1(r2), IFlowNetworkResultCallbackIDL.class, "com.obric.aiagent.plugin"));
        Object r8 = r1.h();
        if (r8 != d.c.a.b.a()) goto L9;
        d.c.b.a.h.c(r4);
    L9:
        return r8;
    }

    private final boolean d() {
        return c().getBoolean("key_has_swept_stock_task", false);
    }

    private final void e() {
        c().storeBoolean("key_has_swept_stock_task", true);
    }

    private final JSONObject b(ConditionTask r5) {
        List<Condition> r4 = a((Condition) ZeusTransformUtils.preCheckCast(r5.getConditions(), Condition.class, "com.obric.aiagent.plugin"));
        JSONObject r0 = new JSONObject();
        o r1 = f32870a;
        JSONObject r2 = r1.b(r4);
        if (r2 == null) goto L5;
        r0.put("time_condition", r2);
    L5:
        JSONObject r3 = r1.c(r4);
        if (r3 == null) goto L8;
        r0.put("location_condition", r3);
    L8:
        JSONObject r6 = r1.d(r4);
        if (r6 == null) goto L11;
        r0.put("device_condition", r6);
    L11:
        r0.put("repeat", r1.a(r5.getPeriodicPolicy()));
        String r7 = r5.getPeriodicPolicy().getStartDate();
        String r8 = "";
        if (r7 != null) goto L14;
        r7 = "";
    L14:
        r0.put("start_time", r7);
        String r9 = r5.getPeriodicPolicy().getExpireDate();
        if (r9 == null) goto L18;
        r8 = r9;
    L18:
        r0.put("end_time", r8);
        r0.put("frequency_switch", r1.a(r5.getTriggerControlPolicy()) ? 1 : 0);
        Integer r10 = r5.getEnableStatus();
        if (r10 != null) goto L22;
    L24:
        int r11 = 0;
    L25:
        r0.put("open_switch", r11);
        return r0;
    L22:
        if (r10.intValue() != 0) goto L24;
        r11 = 1;
        goto L25
    }

    private final JSONObject b(List<? extends Condition> r5) {
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r6 = r4.next();
        if (ZeusTransformUtils.instanceOf((Condition) ZeusTransformUtils.preCheckCast(r6, Condition.class, "com.obric.aiagent.plugin"), TimeCondition.class) == false) goto L4;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, TimeCondition.class) == false) goto L12;
        TimeCondition r7 = (TimeCondition) ZeusTransformUtils.preCheckCast(r6, TimeCondition.class, "com.obric.aiagent.plugin");
    L13:
        if (r7 != null) goto L15;
        return null;
    L15:
        JSONObject r8 = new JSONObject();
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r7.getEnd(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L18;
    L21:
        boolean r1 = true;
    L22:
        if (r1 == true) goto L24;
        JSONObject r2 = new JSONObject();
        r2.put("start", r7.getStart());
        r2.put("end", r7.getEnd());
        x r3 = x.f38692a;
        r8.put("frame", r2);
    L26:
        if (r7.getInterval() <= 0) goto L28;
        r8.put("interval", String.valueOf(r7.getInterval()));
    L28:
        return r8;
    L24:
        r8.put("point", r7.getStart());
        goto L26
    L18:
        if (r0.length() == 0) goto L21;
        r1 = false;
        goto L22
    L12:
        r7 = null;
        goto L13
    L8:
        r6 = null;
        goto L10
    }

    private final JSONObject c(List<? extends Condition> r5) {
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r6 = r4.next();
        if (ZeusTransformUtils.instanceOf((Condition) ZeusTransformUtils.preCheckCast(r6, Condition.class, "com.obric.aiagent.plugin"), LocationCondition.class) == false) goto L4;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, LocationCondition.class) == false) goto L12;
        LocationCondition r7 = (LocationCondition) ZeusTransformUtils.preCheckCast(r6, LocationCondition.class, "com.obric.aiagent.plugin");
    L13:
        if (r7 != null) goto L15;
        return null;
    L15:
        JSONObject r8 = new JSONObject();
        if (d.h.b.o.a(r7.getType(), "inside") == false) goto L18;
        String r0 = "enter";
    L19:
        r8.put("enter_type", r0);
        String r1 = r7.getAddrName();
        if (r1 != null) goto L22;
        r1 = "";
    L22:
        r8.put("name", r1);
        r8.put("location_type", f32870a.a(r7));
        r8.put("longitude", String.valueOf(r7.getLongitude()));
        r8.put("latitude", String.valueOf(r7.getLatitude()));
        r8.put("radius", String.valueOf(r7.getRadius()));
        return r8;
    L18:
        r0 = "leave";
        goto L19
    L12:
        r7 = null;
        goto L13
    L8:
        r6 = null;
        goto L10
    }

    private final JSONObject d(List<? extends Condition> r7) {
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L20;
        Object r8 = r6.next();
        Condition r2 = (Condition) ZeusTransformUtils.preCheckCast(r8, Condition.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, SmsCondition.class) == false) goto L8;
    L17:
        boolean r3 = true;
    L18:
        if (r3 == false) goto L4;
    L21:
        Condition r9 = (Condition) ZeusTransformUtils.preCheckCast(r8, Condition.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L24;
        return null;
    L24:
        String r4 = "";
        if (ZeusTransformUtils.instanceOf(r9, SmsCondition.class) == false) goto L32;
        JSONObject r1 = new JSONObject();
        r1.put("condition_type", "sms");
        JSONObject r5 = new JSONObject();
        String r10 = ((SmsCondition) ZeusTransformUtils.preCheckCast(r9, SmsCondition.class, "com.obric.aiagent.plugin")).getCategoryType();
        if (r10 == null) goto L30;
        r4 = r10;
    L30:
        r5.put("type", r4);
        x r11 = x.f38692a;
        r1.put("sms", r5);
        return r1;
    L32:
        if (ZeusTransformUtils.instanceOf(r9, WifiCondition.class) == false) goto L39;
        JSONObject r12 = new JSONObject();
        r12.put("condition_type", "wifi");
        JSONObject r13 = new JSONObject();
        String r14 = ((WifiCondition) ZeusTransformUtils.preCheckCast(r9, WifiCondition.class, "com.obric.aiagent.plugin")).getSsid();
        if (r14 == null) goto L37;
        r4 = r14;
    L37:
        r13.put("wifi_name", r4);
        x r15 = x.f38692a;
        r12.put("wifi", r13);
        return r12;
    L39:
        if (ZeusTransformUtils.instanceOf(r9, BluetoothCondition.class) == false) goto L46;
        JSONObject r16 = new JSONObject();
        r16.put("condition_type", "bluetooth");
        JSONObject r17 = new JSONObject();
        String r18 = ((BluetoothCondition) ZeusTransformUtils.preCheckCast(r9, BluetoothCondition.class, "com.obric.aiagent.plugin")).getName();
        if (r18 == null) goto L44;
        r4 = r18;
    L44:
        r17.put(SensitiveType.DEVICE_NAME, r4);
        x r19 = x.f38692a;
        r16.put("bluetooth", r17);
        return r16;
    L46:
        if (ZeusTransformUtils.instanceOf(r9, BatteryCondition.class) == false) goto L49;
        JSONObject r20 = new JSONObject();
        r20.put("condition_type", Scraps.BATTERY);
        JSONObject r21 = new JSONObject();
        r21.put("percent", String.valueOf(((BatteryCondition) ZeusTransformUtils.preCheckCast(r9, BatteryCondition.class, "com.obric.aiagent.plugin")).getPercent()));
        r21.put("isCharging", ((BatteryCondition) ZeusTransformUtils.preCheckCast(r9, BatteryCondition.class, "com.obric.aiagent.plugin")).isCharging());
        x r22 = x.f38692a;
        r20.put(Scraps.BATTERY, r21);
        return r20;
    L49:
        if (ZeusTransformUtils.instanceOf(r9, StorageCondition.class) == false) goto L61;
        JSONObject r23 = new JSONObject();
        r23.put("condition_type", Scraps.STORAGE);
        JSONObject r24 = new JSONObject();
        r24.put("percent", String.valueOf(((StorageCondition) ZeusTransformUtils.preCheckCast(r9, StorageCondition.class, "com.obric.aiagent.plugin")).getPercent()));
        x r25 = x.f38692a;
        r23.put(Scraps.STORAGE, r24);
        return r23;
    L61:
        return null;
    L8:
        if (ZeusTransformUtils.instanceOf(r2, WifiCondition.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r2, BluetoothCondition.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r2, BatteryCondition.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r2, StorageCondition.class) == true) goto L17;
        r3 = false;
        goto L18
    L20:
        r8 = null;
        goto L21
    }

    private final JSONObject a(PeriodicPolicy r6) {
        JSONArray r5 = new JSONArray();
        String r0 = String.valueOf(r6.getYearly());
        boolean r2 = true;
        int r3 = 0;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        String r4 = "daily";
        if (r6.isSingleTask() == false) goto L15;
        r4 = "once";
    L45:
        JSONObject r7 = new JSONObject();
        r7.put("type", r4);
        r7.put("value", r5);
        return r7;
    L15:
        if (r6.getDaily() == true) goto L45;
        int[] r8 = r6.getWeekly();
        if (r8 != null) goto L20;
    L26:
        r2 = false;
    L27:
        if (r2 == false) goto L35;
        int[] r9 = r6.getWeekly();
        if (r9 == null) goto L33;
        int r10 = r9.length;
    L31:
        if (r3 >= r10) goto L33;
        r5.put(String.valueOf(r9[r3]));
        r3 = r3 + 1;
    L33:
        r4 = "weekly";
        goto L45
    L35:
        if (r6.getMonthly() <= 0) goto L37;
        r5.put(String.valueOf(r6.getMonthly()));
        r4 = "monthly";
        goto L45
    L37:
        if (r0 == null) goto L40;
        r5.put(r0);
        r4 = "yearly";
        goto L45
    L40:
        if (r6.getEveryWorkDay() == false) goto L43;
        r4 = "workday";
        goto L45
    L43:
        if (r6.getEveryOffDay() == false) goto L45;
        r4 = "holiday";
        goto L45
    L20:
        if (r8.length != 0) goto L22;
        boolean r11 = true;
    L24:
        if ((!r11) != true) goto L26;
    L22:
        r11 = false;
        goto L24
    L5:
        if (d.h.b.o.a(r0, "null") == true) goto L7;
        r1 = true;
        goto L8
    }

    private final List<Condition> a(Condition r4) {
        Condition r3 = (Condition) ZeusTransformUtils.wrapperContextForParams(r4, Condition.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, ConditionGroup.class) == false) goto L12;
        List r5 = (List) ZeusTransformUtils.preCheckCast(((ConditionGroup) ZeusTransformUtils.preCheckCast(r3, ConditionGroup.class, "com.obric.aiagent.plugin")).getConditions(), List.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L7;
        r5 = d.a.p.b();
    L7:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r6.iterator();
    L9:
        if (r8.hasNext() == false) goto L17;
        Condition r1 = (Condition) ZeusTransformUtils.preCheckCast(r8.next(), Condition.class, "com.obric.aiagent.plugin");
        d.a.p.a(r7, (Iterable) ZeusTransformUtils.preCheckCast(f32870a.a(r1), Iterable.class, "com.obric.aiagent.plugin"));
        goto L9
    L17:
        return (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
    L12:
        if (r3 != null) goto L15;
        return d.a.p.b();
    L15:
        return d.a.p.a(r3);
    }

    public final String a(ConditionTask r7) {
        d.h.b.o.e(r7, "conditionTask");
        List<Condition> r6 = a((Condition) ZeusTransformUtils.preCheckCast(r7.getConditions(), Condition.class, "com.obric.aiagent.plugin"));
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
        boolean r2 = true;
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L5;
    L7:
        Iterator r9 = r8.iterator();
    L9:
        if (r9.hasNext() == false) goto L6;
        if (ZeusTransformUtils.instanceOf((Condition) ZeusTransformUtils.preCheckCast(r9.next(), Condition.class, "com.obric.aiagent.plugin"), TimeCondition.class) == false) goto L9;
        boolean r10 = true;
    L13:
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L16;
    L18:
        Iterator r1 = r0.iterator();
    L20:
        if (r1.hasNext() == false) goto L17;
        if (ZeusTransformUtils.instanceOf((Condition) ZeusTransformUtils.preCheckCast(r1.next(), Condition.class, "com.obric.aiagent.plugin"), LocationCondition.class) == false) goto L20;
        boolean r3 = true;
    L24:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, Collection.class) == true) goto L27;
    L29:
        Iterator r12 = r11.iterator();
    L31:
        if (r12.hasNext() == false) goto L28;
        Condition r4 = (Condition) ZeusTransformUtils.preCheckCast(r12.next(), Condition.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SmsCondition.class) == false) goto L35;
    L44:
        boolean r5 = true;
    L45:
        if (r5 == false) goto L31;
    L46:
        if (r10 == false) goto L50;
        if (r3 == false) goto L50;
        if (r2 == false) goto L50;
        return "automatic_time_position_event";
    L50:
        if (r10 == false) goto L53;
        if (r3 == false) goto L53;
        return "automatic_time_position";
    L53:
        if (r10 == false) goto L56;
        if (r2 == false) goto L56;
        return "automatic_time_event";
    L56:
        if (r3 == false) goto L59;
        if (r2 == false) goto L59;
        return "automatic_position_event";
    L59:
        if (r10 == false) goto L61;
        return "automatic_time";
    L61:
        if (r3 == false) goto L63;
        return "automatic_position";
    L63:
        if (r2 == false) goto L65;
        return "automatic_event";
    L65:
        return "";
    L35:
        if (ZeusTransformUtils.instanceOf(r4, WifiCondition.class) == true) goto L44;
        if (ZeusTransformUtils.instanceOf(r4, BluetoothCondition.class) == true) goto L44;
        if (ZeusTransformUtils.instanceOf(r4, BatteryCondition.class) == true) goto L44;
        if (ZeusTransformUtils.instanceOf(r4, StorageCondition.class) == true) goto L44;
        r5 = false;
    L28:
        r2 = false;
        goto L46
    L27:
        if (((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L29;
    L17:
        r3 = false;
        goto L24
    L16:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L18;
    L6:
        r10 = false;
        goto L13
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    private final String a(LocationCondition r4) {
        if (d.h.b.o.a(r4.getMode(), "place_alias") == false) goto L11;
        String r3 = r4.getAddrType();
        if (d.h.b.o.a(r3, "home") == false) goto L8;
        return "home";
    L8:
        if (d.h.b.o.a(r3, "company") == true) goto L10;
        return MonitorConstants.CUSTOM;
    L10:
        return "company";
    L11:
        d.h.b.o.a(r4.getMode(), "geo_radius");
        return MonitorConstants.CUSTOM;
    }

    private final boolean a(TriggerControlPolicy r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return d.h.b.o.a(r1.getEnable(), true);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.time.LocalDateTime] */
    private final String a(long r1) {
        String r0 = Instant.ofEpochMilli(r1).atZone(ZoneId.systemDefault()).toLocalDateTime().format(f);
        d.h.b.o.c(r0, "format(...)");
        return r0;
    }
}
