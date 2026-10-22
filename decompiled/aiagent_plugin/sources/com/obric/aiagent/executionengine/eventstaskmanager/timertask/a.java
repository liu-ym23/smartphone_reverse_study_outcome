package com.obric.aiagent.executionengine.eventstaskmanager.timertask;

import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.assistant.idl.r;
import com.obric.aiagent.executionengine.eventstaskmanager.common.data.e;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.bean.ConditionTaskBean;
import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.bean.TimerTaskBean;
import com.obric.autoaction.app.launcherpage.api.IAutoTaskApi;
import com.obric.capabilitykit.common.intent.BaseSystemAutoActionIntent;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.SystemAutoActionParams;
import com.obric.capabilitykit.entity.EntityContentProvider;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.ConditionTaskResult;
import com.obric.eventkit.task.model.EventTaskExecutionRecord;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TimeCondition;
import com.obric.eventkit.task.model.TimerTask;
import com.obric.eventkit.task.model.TimerTaskResult;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.d;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.g;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.o;
import d.l.j;
import d.n;
import d.o.k;
import d.x;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: TimerTaskAutoMigrateHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "TimerTaskAutoMigrateHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17861a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f17862b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile ca f17863c;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.timertask.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TimerTaskAutoMigrateHelper.kt */
    private static final class C0365a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PeriodicPolicy f17864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f17865b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0365a.class) == true) goto L8;
            return false;
        L8:
            C0365a r6 = (C0365a) ZeusTransformUtils.preCheckCast(r5, C0365a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f17864a, r6.f17864a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f17865b, r6.f17865b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            PeriodicPolicy r0 = this.f17864a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f17865b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "TimerTaskMigrateResult(periodicPolicy=" + this.f17864a + ", time=" + this.f17865b + ')';
        }

        public C0365a(PeriodicPolicy r1, String r2) {
            this.f17864a = r1;
            this.f17865b = r2;
        }

        public final PeriodicPolicy a() {
            return this.f17864a;
        }

        public final String b() {
            return this.f17865b;
        }
    }

    /* JADX INFO: compiled from: TimerTaskAutoMigrateHelper.kt */
    @f(b = "TimerTaskAutoMigrateHelper.kt", c = {68}, d = "retryUserId", e = "com.obric.aiagent.executionengine.eventstaskmanager.timertask.TimerTaskAutoMigrateHelper")
    static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f17867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f17868c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f17869d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f17870e;
        final /* synthetic */ a f;
        int g;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17870e = r3;
            this.g |= Integer.MIN_VALUE;
            return a.a(this.f, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TimerTaskAutoMigrateHelper.kt */
    @f(b = "TimerTaskAutoMigrateHelper.kt", c = {55}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.timertask.TimerTaskAutoMigrateHelper$start$1$1")
    static final class c extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IFlowAppIntentIDL f17872b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f17873c;

        c(IFlowAppIntentIDL r3, d.c.d<? super c> r4) {
            IFlowAppIntentIDL r5 = (IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17872b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f17872b, r5);
            r0.f17873c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17871a;
            boolean r3 = false;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L27:
            String r9 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
        L28:
            CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L31;
        L32:
            r3 = true;
        L33:
            if (r3 == false) goto L36;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(a.TAG, "migrateTimerTasks skip, required id still empty");
            return x.f38692a;
        L36:
            a.a(a.f17861a, r9);
            return x.f38692a;
        L31:
            if (r7.length() != 0) goto L33;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            am r10 = (am) ZeusTransformUtils.preCheckCast(this.f17873c, am.class, "com.obric.aiagent.plugin");
            IFlowAppIntentIDL r11 = this.f17872b;
            n.a r2 = n.f38560a;     // Catch: Throwable -> L11
            Object r12 = n.f(r11.getUserId());     // Catch: Throwable -> L11
        L14:
            if (n.b(r12) == false) goto L16;
            r12 = null;
        L16:
            r9 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.aiagent.plugin");
            CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L19;
        L22:
            boolean r5 = true;
        L23:
            if (r5 == false) goto L28;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(a.TAG, "migrateTimerTasks required id empty, start retry");
            a r13 = a.f17861a;
            IFlowAppIntentIDL r6 = this.f17872b;
            d.c.d r14 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17871a = 1;
            r8 = a.a(r13, r6, r14);
            if (r8 != r0) goto L27;
            return r0;
        L19:
            if (r4.length() == 0) goto L22;
            r5 = false;
        L11:
            th = move-exception;
            n.a r15 = n.f38560a;
            r12 = n.f(d.o.a(th));
            goto L14
        }
    }

    public static /* synthetic */ void lambda$fmLvWQ0Zs4k1n3pWmM4uxWPwbF4(IFlowAppIntentIDL r0) {
        a(r0);
    }

    private a() {
    }

    public static final /* synthetic */ Object a(a r2, IFlowAppIntentIDL r3, d.c.d r4) {
        return r2.a((IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(a r0, String r1) {
        r0.a(r1);
    }

    static {
        f17861a = new a();
        f17862b = an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"));
    }

    public final void a() {
        r.a(aa.b(IFlowAppIntentIDL.class), false, false, $$Lambda$a$fmLvWQ0Zs4k1n3pWmM4uxWPwbF4.INSTANCE, 3, null);
    }

    private static final void a(IFlowAppIntentIDL r10) {
        IFlowAppIntentIDL r11 = (IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r10, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
        o.e(r11, "ipc");
        ca r0 = f17863c;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        f17863c = i.a(f17862b, null, null, (m) ZeusTransformUtils.preCheckCast(new c(r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x007c -> B:52:0x007d). Please report as a decompilation issue!!! */
    private final Object a(IFlowAppIntentIDL r12, d.c.d<? super String> r13) {
        IFlowAppIntentIDL r14 = (IFlowAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r12, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r15, b.class, "com.obric.aiagent.plugin");
        if ((r0.g & Integer.MIN_VALUE) == 0) goto L7;
        r0.g -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f17870e;
        Object r16 = d.c.a.b.a();
        int r2 = r0.g;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        int r17 = r0.f17869d;
        int r3 = r0.f17868c;
        int r6 = r0.f17867b;
        IFlowAppIntentIDL r7 = (IFlowAppIntentIDL) ZeusTransformUtils.preCheckCast(r0.f17866a, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
        IFlowAppIntentIDL r18 = r7;
    L52:
        n.a r8 = n.f38560a;     // Catch: Throwable -> L22
        Object r9 = n.f(r18.getUserId());     // Catch: Throwable -> L22
    L25:
        if (n.b(r9) == false) goto L27;
        r9 = null;
    L27:
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
        CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (r19 != null) goto L30;
    L33:
        boolean r20 = true;
    L34:
        if (r20 == false) goto L39;
        IFlowAppIntentIDL r21 = r.a(aa.b(IFlowAppIntentIDL.class));
        if (r21 == null) goto L38;
        r10 = r21.getUserId();
        goto L39
    L38:
        r10 = null;
    L39:
        CharSequence r22 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (r22 != null) goto L42;
    L45:
        boolean r23 = true;
    L47:
        if (r23 == true) goto L50;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "migrateTimerTasks retryUserId success after " + (r17 + 1) + " retries");
        return r10;
    L50:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.c(TAG, "migrateTimerTasks required id still empty, attempt=" + (r17 + 1) + "/3");
        r17 = r3 + 1;
    L15:
        if (r17 >= r6) goto L51;
        r0.f17866a = r18;
        r0.f17867b = r6;
        r0.f17868c = r17;
        r0.f17869d = r17;
        r0.g = 1;
        if (ax.a(EntityContentProvider.g, r0) != r16) goto L19;
        return r16;
    L19:
        r3 = r17;
        goto L52
    L51:
        return null;
    L42:
        if (r22.length() == 0) goto L45;
        r23 = false;
        goto L47
    L30:
        if (r19.length() == 0) goto L33;
        r20 = false;
    L22:
        th = move-exception;
        n.a r24 = n.f38560a;
        r9 = n.f(d.o.a(th));
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        r6 = 3;
        r18 = r14;
        r17 = 0;
    L7:
        r0 = new b(this, r15);
        goto L8
    }

    private final void a(String r11) {
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a r10 = e.f16691a.b(r11);
        if (r10 == null) goto L5;
        List<TimerTaskBean> r12 = r10.a();
    L6:
        if (r12 != null) goto L9;
        r12 = p.b();
    L9:
        if (r12.isEmpty() == false) goto L12;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "migrateTimerTasks no timer task");
        return;
    L12:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "migrateTimerTasks start, size=" + r12.size());
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r14 = r13.iterator();
    L14:
        if (r14.hasNext() == false) goto L19;
        Object r3 = r14.next();
        String r4 = ((TimerTaskBean) ZeusTransformUtils.preCheckCast(r3, TimerTaskBean.class, "com.obric.aiagent.plugin")).getSourceFrom();
        Object r5 = r0.get(r4);
        if (r5 != null) goto L18;
        r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r0.put(r4, r5);
    L18:
        ((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin")).add(r3);
        goto L14
    L19:
        Iterator r15 = r0.entrySet().iterator();
    L21:
        if (r15.hasNext() == false) goto L45;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin");
        List<TimerTaskBean> r2 = (List) ZeusTransformUtils.preCheckCast(r1.getValue(), List.class, "com.obric.aiagent.plugin");
        a r7 = f17861a;
        Set<Integer> r8 = r7.a(r2, r6);
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r9.iterator();
    L24:
        if (r17.hasNext() == false) goto L28;
        Object r18 = r17.next();
        if (r8.contains(Integer.valueOf(((TimerTaskBean) ZeusTransformUtils.preCheckCast(r18, TimerTaskBean.class, "com.obric.aiagent.plugin")).getTaskId())) == false) goto L24;
        r16.add(r18);
        goto L24
    L28:
        r7.a((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin"));
        Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L30:
        if (r19.hasNext() == false) goto L21;
        TimerTaskBean r20 = (TimerTaskBean) ZeusTransformUtils.preCheckCast(r19.next(), TimerTaskBean.class, "com.obric.aiagent.plugin");
        if (r8.contains(Integer.valueOf(r20.getTaskId())) == false) goto L33;
        a r21 = f17861a;
        n.a r22 = n.f38560a;     // Catch: Throwable -> L37
        r21.a(r20, r11);     // Catch: Throwable -> L37
        Object r23 = n.f(x.f38692a);     // Catch: Throwable -> L37
    L39:
        Throwable r24 = n.c(r23);
        if (r24 == null) goto L30;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "migrateTimerTask failed, taskId=" + r20.getTaskId(), r24);
        a r25 = f17861a;
        String r26 = r24.getMessage();
        if (r26 != null) goto L44;
        r26 = "migrate failed";
    L44:
        r25.a(false, r26);
    L37:
        th = move-exception;
        n.a r27 = n.f38560a;
        r23 = n.f(d.o.a(th));
        goto L39
    L33:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "migrateTimerTask skip, remove old failed, taskId=" + r20.getTaskId());
        f17861a.a(false, "remove old failed");
        goto L30
    L45:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "migrateTimerTasks finish");
        return;
    L5:
        r12 = null;
        goto L6
    }

    private final Set<Integer> a(List<TimerTaskBean> r5, String r6) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.b r7 = com.obric.aiagent.executionengine.eventstaskmanager.timertask.b.f17879a;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r1.add(Integer.valueOf(((TimerTaskBean) ZeusTransformUtils.preCheckCast(r9.next(), TimerTaskBean.class, "com.obric.aiagent.plugin")).getTaskId()));
        goto L4
    L6:
        TimerTaskResult r10 = r7.a((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), r6);
        if (r10.getCode() == 0) goto L10;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "removeTimerTasks failed, code=" + r10.getCode());
        return d.a.ax.b();
    L10:
        List<TimerTask> r11 = r10.getData();
        if (r11 != null) goto L13;
        r11 = p.b();
    L13:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r12.iterator();
    L15:
        if (r14.hasNext() == false) goto L23;
        TimerTask r15 = (TimerTask) ZeusTransformUtils.preCheckCast(r14.next(), TimerTask.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L19;
        Integer r16 = r15.getId();
    L20:
        if (r16 == null) goto L15;
        r13.add(r16);
        goto L15
    L19:
        r16 = null;
        goto L20
    L23:
        return p.q((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
    }

    private final void a(List<TimerTaskBean> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r7, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        r0.add(((TimerTaskBean) ZeusTransformUtils.preCheckCast(r8.next(), TimerTaskBean.class, "com.obric.aiagent.plugin")).toTimerTask());
        goto L7
    L9:
        List<TimerTask> r9 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        n.a r1 = n.f38560a;     // Catch: Throwable -> L16
        a r4 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        IAutoTaskApi r10 = (IAutoTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoTaskApi.class), IAutoTaskApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r10 == null) goto L13;
        r10.onTimerTasksRemoved(r9, true);     // Catch: Throwable -> L16
        x r11 = x.f38692a;     // Catch: Throwable -> L16
    L14:
        Object r12 = n.f(r11);     // Catch: Throwable -> L16
    L18:
        Throwable r13 = n.c(r12);
        if (r13 == null) goto L25;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "notifyTimerTasksRemoved failed", r13);
        return;
    L25:
        return;
    L13:
        r11 = null;
    L16:
        th = move-exception;
        n.a r14 = n.f38560a;
        r12 = n.f(d.o.a(th));
        goto L18
    }

    private final void a(TimerTaskBean r26, String r27) {
        String r2 = r26.getAction();
        if (r2 == null) goto L34;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L34;
        String r3 = String.valueOf(r26.getTaskId());
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "migrateTimerTask start, taskId=" + r3);
        C0365a r7 = b(r26.getCronTime());
        if (d(r27) == false) goto L12;
        int r8 = 1;
    L13:
        ConditionTaskResult r4 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.f16741a, r26.getSourceFrom(), p.a(c(r2)), null, a(r26, r7), b(r26, r7), new TriggerControlPolicy(false, null, 2, null), null, Integer.valueOf(r8), 1, null, null, null, 3584, null);
        List<ConditionTask> r5 = r4.getData();
        if (r5 == null) goto L18;
        ConditionTask r6 = (ConditionTask) ZeusTransformUtils.preCheckCast(p.l(r5), ConditionTask.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L18;
        String r9 = r6.getId();
    L20:
        if (r4.getCode() != 0) goto L32;
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L24;
    L27:
        boolean r11 = true;
    L28:
        if (r11 == true) goto L32;
        a(r26, r3, r9);
        a(this, true, null, 2, null);
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "migrateTimerTask finish, oldTaskId=" + r3 + ", newTaskId=" + r9);
        return;
    L24:
        if (r10.length() == 0) goto L27;
        r11 = false;
    L32:
        throw new IllegalStateException("create new failed".toString());
    L18:
        r9 = null;
        goto L20
    L12:
        r8 = a(r26.getEnableStatus());
    L34:
        throw new IllegalStateException("query is empty".toString());
    }

    private final C0365a b(String r8) {
        List<String> r0 = new k("\\s+").c((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).toString(), CharSequence.class, "com.obric.aiagent.plugin"), 0);
        if (r0.size() == 6) goto L9;
        if (r0.size() == 7) goto L9;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.a(TAG, "Unsupported cron format: " + r8, null);
        return null;
    L9:
        return new C0365a(a((String) ZeusTransformUtils.preCheckCast(r0.get(3), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.get(5), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.get(4), String.class, "com.obric.aiagent.plugin")), b((String) ZeusTransformUtils.preCheckCast(r0.get(0), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.get(1), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.get(2), String.class, "com.obric.aiagent.plugin")));
    }

    private final ConditionTaskAction c(String r14) {
        return new ConditionTaskAction(new BaseSystemAutoActionIntent().getName(), (IntentParams) ZeusTransformUtils.preCheckCast(new SystemAutoActionParams(r14, null, null, null, null, null, null, null, 254, null), IntentParams.class, "com.obric.aiagent.plugin"));
    }

    private final ConditionGroup a(TimerTaskBean r9, C0365a r10) {
        if (r10 == null) goto L5;
        String r11 = r10.b();
        if (r11 == null) goto L5;
    L7:
        return new ConditionGroup("or", p.d(new Condition[]{new TimeCondition(r11, null, 0, 6, null)}));
    L5:
        r11 = b();
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.a(TAG, "Parse time from cron failed, fallback to currentTime, taskId=" + r9.getTaskId(), null);
        goto L7
    }

    private final PeriodicPolicy b(TimerTaskBean r13, C0365a r14) {
        if (r14 == null) goto L5;
        PeriodicPolicy r12 = r14.a();
        if (r12 == null) goto L5;
        return r12;
    L5:
        PeriodicPolicy r15 = new PeriodicPolicy(false, null, 0, null, false, false, null, true, null, 383, null);
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.a(TAG, "Parse periodicPolicy from cron failed, fallback to single task, taskId=" + r13.getTaskId(), null);
        return r15;
    }

    private final PeriodicPolicy a(String r22, String r23, String r24) {
        if (o.a(r22, "*") == true) goto L5;
    L10:
        boolean r6 = false;
        if (o.a(r23, "*") == true) goto L50;
        if (o.a(r22, "*") == false) goto L50;
        if (o.a(r24, "*") == false) goto L50;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{","}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L18:
        if (r2.hasNext() == false) goto L28;
        Integer r3 = d.o.o.d((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin"));
        if (r3 == null) goto L25;
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r4 != 0) goto L24;
        r4 = 7;
    L24:
        Integer r5 = Integer.valueOf(r4);
    L26:
        if (r5 == null) goto L18;
        r1.add(r5);
        goto L18
    L25:
        r5 = null;
        goto L26
    L28:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r7.iterator();
    L30:
        if (r9.hasNext() == false) goto L39;
        Object r10 = r9.next();
        int r11 = ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (1 <= r11) goto L34;
    L36:
        boolean r12 = false;
    L37:
        if (r12 == false) goto L30;
        r8.add(r10);
        goto L30
    L34:
        if (r11 >= 8) goto L36;
        r12 = true;
        goto L37
    L39:
        int[] r13 = p.e((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
        if (r13.length != 0) goto L43;
        r6 = true;
    L43:
        if ((!r6) == false) goto L45;
        int[] r14 = r13;
    L46:
        if (r14 != null) goto L48;
        return null;
    L48:
        return new PeriodicPolicy(false, r14, 0, null, false, false, null, false, null, 509, null);
    L45:
        r14 = null;
    L50:
        if (o.a(r22, "*") == false) goto L52;
    L68:
        return null;
    L52:
        if (o.a(r24, "*") == false) goto L68;
        if (o.a(r23, "?") == false) goto L68;
        Integer r15 = d.o.o.d(r22);
        if (r15 == null) goto L68;
        int r16 = ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (1 <= r16) goto L60;
    L62:
        if (r6 == true) goto L65;
        r15 = null;
    L65:
        if (r15 == null) goto L68;
        return new PeriodicPolicy(false, null, r15.intValue(), null, false, false, null, false, null, 507, null);
    L60:
        if (r16 >= 31) goto L62;
        r6 = true;
        goto L62
    L5:
        if (o.a(r23, "?") == false) goto L10;
        if (o.a(r24, "*") == false) goto L10;
        return new PeriodicPolicy(true, null, 0, null, false, false, null, false, null, 510, null);
    }

    private final String b(String r4, String r5, String r6) {
        if (o.a(r4, "*") == false) goto L5;
        return null;
    L5:
        if (o.a(r5, "*") == false) goto L7;
        return null;
    L7:
        if (o.a(r6, "*") == true) goto L29;
        Integer r3 = d.o.o.d(r5);
        Integer r7 = d.o.o.d(r6);
        j r8 = new j(0, 59);
        if (r3 != null) goto L12;
    L14:
        boolean r9 = false;
    L15:
        if (r9 == false) goto L27;
        j r10 = new j(0, 23);
        if (r7 != null) goto L19;
    L21:
        boolean r11 = false;
    L22:
        if (r11 == false) goto L28;
        String r0 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{r7, r3}, 2));
        o.c(r0, "format(...)");
        return r0;
    L28:
        return null;
    L19:
        if (r10.a(r7.intValue()) == false) goto L21;
        r11 = true;
        goto L22
    L27:
        return null;
    L12:
        if (r8.a(r3.intValue()) == false) goto L14;
        r9 = true;
        goto L15
    L29:
        return null;
    }

    private final int a(int r3) {
        Integer r2 = Integer.valueOf(r3);
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r4 == 0) goto L9;
        if (r4 == 1) goto L9;
        if (r4 == 2) goto L9;
        boolean r5 = false;
    L10:
        if (r5 == true) goto L13;
        r2 = null;
    L13:
        if (r2 != null) goto L15;
        return 1;
    L15:
        return r2.intValue();
    L9:
        r5 = true;
        goto L10
    }

    private final boolean d(String r7) {
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a r6 = e.f16691a.b(r7);
        if (r6 == null) goto L22;
        List<TimerTaskBean> r8 = r6.a();
        if (r8 == null) goto L22;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L9;
    L11:
        Iterator r10 = r9.iterator();
        int r2 = 0;
    L13:
        if (r10.hasNext() == false) goto L23;
        if (((TimerTaskBean) ZeusTransformUtils.preCheckCast(r10.next(), TimerTaskBean.class, "com.obric.aiagent.plugin")).getEnableStatus() != 0) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L13;
        r2 = r2 + 1;
        if (r2 >= 0) goto L13;
        p.d();
        goto L13
    L17:
        r4 = false;
    L23:
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r11 = e.f16691a.a(r7);
        if (r11 == null) goto L28;
        List<ConditionTaskBean> r12 = r11.a();
        if (r12 == null) goto L28;
        int r13 = r12.size();
    L30:
        if ((r2 + r13) < 5) goto L33;
        return true;
    L33:
        return false;
    L28:
        r13 = 0;
        goto L30
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L11;
    L22:
        r2 = 0;
        goto L23
    }

    private final void a(TimerTaskBean r23, String r24, String r25) {
        List<EventTaskExecutionRecord> r1 = com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.d.f17292a.a(r23.getSourceFrom(), r24, 0, Integer.MAX_VALUE);
        if (r1 == null) goto L9;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r3.add(EventTaskExecutionRecord.copy$default((EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(r4.next(), EventTaskExecutionRecord.class, "com.obric.aiagent.plugin"), 0, 0, 0, r25, null, 0, 0, 0, null, null, null, 2039, null));
        goto L6
    L8:
        List<EventTaskExecutionRecord> r5 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
    L10:
        if (r5 != null) goto L13;
        r5 = p.b();
    L13:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L17;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "Migrated execution records, taskId=" + r24 + ", count=" + com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.d.f17292a.b(r23.getSourceFrom(), r5));
        return;
    L17:
        return;
    L9:
        r5 = null;
        goto L10
    }

    private final String b() {
        String r1 = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        o.c(r1, "format(...)");
        return r1;
    }

    static /* synthetic */ void a(a r0, boolean r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.a(r1, r2);
    }

    private final void a(boolean r3, String r4) {
        IAutoTaskApi r2 = (IAutoTaskApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoTaskApi.class), IAutoTaskApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.reportTimerTaskUpgradeMob(r3, r4);
        return;
    }
}
