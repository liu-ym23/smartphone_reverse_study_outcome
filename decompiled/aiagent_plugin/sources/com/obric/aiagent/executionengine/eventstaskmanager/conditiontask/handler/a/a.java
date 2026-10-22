package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a;

import com.bytedance.crash.dumper.Scraps;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.g;
import com.obric.eventkit.task.model.BatteryCondition;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.awareness.AwarenessConditionConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.al;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.h.b.z;
import d.o;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: PersistentBatteryConditionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e<BatteryCondition> {
    private static final String TAG = "PersistentBatteryConditionHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0347a f17020a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PersistentBatteryConditionHandler.kt */
    public static final class C0347a {
        public /* synthetic */ C0347a(h r1) {
            this();
        }

        private C0347a() {
        }
    }

    /* JADX INFO: compiled from: PersistentBatteryConditionHandler.kt */
    @d.c.b.a.f(b = "PersistentBatteryConditionHandler.kt", c = {34}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.battery.PersistentBatteryConditionHandler$isConditionMetInternal$batteryData$1")
    static final class b extends l implements m<am, d.c.d<? super Double>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17021a;

        b(d.c.d<? super b> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super Double> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Double> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17021a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L12:
            return ((MemoryResponse) ZeusTransformUtils.preCheckCast(r5, MemoryResponse.class, "com.obric.aiagent.plugin")).getData();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d r6 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.f17179a;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17021a = 1;
            r5 = r6.a("device_battery", r2);
            if (r5 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: PersistentBatteryConditionHandler.kt */
    @d.c.b.a.f(b = "PersistentBatteryConditionHandler.kt", c = {37}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.battery.PersistentBatteryConditionHandler$isConditionMetInternal$isCharging$1")
    static final class c extends l implements m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17022a;

        c(d.c.d<? super c> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17022a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L12:
            return ((MemoryResponse) ZeusTransformUtils.preCheckCast(r5, MemoryResponse.class, "com.obric.aiagent.plugin")).getData();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d r6 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.f17179a;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17022a = 1;
            r5 = r6.a("device_is_charge", r2);
            if (r5 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: PersistentBatteryConditionHandler.kt */
    @d.c.b.a.f(b = "PersistentBatteryConditionHandler.kt", c = {79}, d = "registerTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.battery.PersistentBatteryConditionHandler")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f17025c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f17026d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f17027e;
        int f;
        /* synthetic */ Object g;
        final /* synthetic */ a h;
        int i;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.g = r3;
            this.i |= Integer.MIN_VALUE;
            return this.h.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: PersistentBatteryConditionHandler.kt */
    @d.c.b.a.f(b = "PersistentBatteryConditionHandler.kt", c = {83}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.battery.PersistentBatteryConditionHandler$registerTask$2$1")
    static final class e extends l implements d.h.a.b<d.c.d<? super MemoryResponse<Void>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AwarenessConditionConfig f17030c;

        e(String r3, AwarenessConditionConfig r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17029b = r3;
            this.f17030c = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super MemoryResponse<Void>> r3) {
            return ((e) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f17029b, this.f17030c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super MemoryResponse<Void>> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17028a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d r8 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.f17179a;
            String r2 = this.f17029b;
            AwarenessConditionConfig r3 = this.f17030c;
            d.c.d<? super MemoryResponse<Void>> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17028a = 1;
            r7 = r8.a(r2, "device_battery", r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: PersistentBatteryConditionHandler.kt */
    @d.c.b.a.f(b = "PersistentBatteryConditionHandler.kt", c = {101}, d = "unregisterTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.battery.PersistentBatteryConditionHandler")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17032b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f17033c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f17034d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f17035e;

        f(a r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17034d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17033c = r3;
            this.f17035e |= Integer.MIN_VALUE;
            return this.f17034d.b(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f17020a = new C0347a(null);
    }

    public a() {
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a a(ConditionTask r3, Condition r4) {
        return a(r3, (BatteryCondition) ZeusTransformUtils.preCheckCast((Condition) ZeusTransformUtils.wrapperContextForParams(r4, Condition.class, "com.obric.aiagent.plugin"), BatteryCondition.class, "com.obric.aiagent.plugin"));
    }

    public com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a a(ConditionTask r2, BatteryCondition r3) {
        d.h.b.o.e(r2, "task");
        d.h.b.o.e(r3, "condition");
        if (a(r3) == false) goto L6;
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.f17016b;
    L6:
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.g;
    }

    private final boolean a(BatteryCondition r6) {
        Double r5 = (Double) ZeusTransformUtils.preCheckCast(i.a(null, (m) ZeusTransformUtils.preCheckCast(new b(null), m.class, "com.obric.aiagent.plugin"), 1, null), Double.class, "com.obric.aiagent.plugin");
        Boolean r0 = (Boolean) ZeusTransformUtils.preCheckCast(i.a(null, (m) ZeusTransformUtils.preCheckCast(new c(null), m.class, "com.obric.aiagent.plugin"), 1, null), Boolean.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "isConditionMetInternal batteryData = " + r5 + " isCharging = " + r0);
        if (r5 == null) goto L18;
        if (r0 == null) goto L18;
        if (d.h.b.o.a(r0, Boolean.valueOf(r6.isCharging())) == false) goto L17;
        if (r6.isCharging() == false) goto L14;
        if (r5.doubleValue() < r6.getPercent()) goto L17;
        return true;
    L14:
        if (r5.doubleValue() > r6.getPercent()) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [T, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c] */
    /* JADX WARN: Type inference failed for: r9v5, types: [T, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0178 -> B:38:0x017d). Please report as a decompilation issue!!! */
    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public Object a(ConditionTask r20, List<BatteryCondition> r21, d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c> r22) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L7;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.aiagent.plugin");
        if ((r3.i & Integer.MIN_VALUE) == 0) goto L7;
        r3.i -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.g;
        Object r5 = d.c.a.b.a();
        int r6 = r3.i;
        int r7 = 0;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        int r1 = r3.f;
        z.f r8 = (z.f) ZeusTransformUtils.preCheckCast(r3.f17027e, z.f.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c r9 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r3.f17026d, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin");
        Iterator r10 = (Iterator) ZeusTransformUtils.preCheckCast(r3.f17025c, Iterator.class, "com.obric.aiagent.plugin");
        z.f r11 = (z.f) ZeusTransformUtils.preCheckCast(r3.f17024b, z.f.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r3.f17023a, String.class, "com.obric.aiagent.plugin");
        o.a(r4);
        int r18 = r1;
        Iterator r13 = r10;
    L38:
        r8.f38504a = r9.a((com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin"));
        r8 = r11;
        String r14 = r12;
        r7 = r18;
    L26:
        if (r13.hasNext() == false) goto L40;
        Object r15 = r13.next();
        int r16 = r7 + 1;
        if (r7 >= 0) goto L30;
        p.c();
    L30:
        BatteryCondition r17 = (BatteryCondition) ZeusTransformUtils.preCheckCast(r15, BatteryCondition.class, "com.obric.aiagent.plugin");
        String r19 = g.f17272a.a(Scraps.BATTERY, r14, r7);
        if (r17.isCharging() == false) goto L33;
        AwarenessConditionConfig r23 = AwarenessConditionConfig.Companion.a(r17.getPercent());
    L34:
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c r110 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r8.f38504a, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin");
        d.h.a.b r111 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new e(r19, r23, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        r3.f17023a = r14;
        r3.f17024b = r8;
        r3.f17025c = r13;
        r3.f17026d = r110;
        r3.f17027e = r8;
        r3.f = r16;
        r3.i = 1;
        r18 = r16;
        Object r24 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.f.a(TAG, "registerPersistentFeatureEvent " + r19 + " device_battery", 0, r111, r3, 4, null);
        if (r24 != r5) goto L37;
        return r5;
    L37:
        r12 = r14;
        r11 = r8;
        r4 = r24;
        r9 = r110;
        goto L38
    L33:
        r23 = AwarenessConditionConfig.Companion.b(r17.getPercent());
        goto L34
    L40:
        return r8.f38504a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r4);
        r14 = r20.getId();
        if (r14 != null) goto L17;
        r14 = "";
    L17:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "registerTask taskId = " + r14);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L20;
        boolean r25 = true;
    L21:
        if (r25 == true) goto L23;
        r8 = new z.f();
        r8.f38504a = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.f17052a, 0, 1, null);
        r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        goto L26
    L23:
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.f17052a, "register battery failed: taskId is empty", 0, 2, null);
    L20:
        r25 = false;
    L7:
        r3 = new d(this, r2);
        goto L8
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public Object b(ConditionTask r7, List<BatteryCondition> r8, d.c.d<? super x> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r11, f.class, "com.obric.aiagent.plugin");
        if ((r0.f17035e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f17035e -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f17033c;
        Object r12 = d.c.a.b.a();
        int r2 = r0.f17035e;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Iterator r13 = (Iterator) ZeusTransformUtils.preCheckCast(r0.f17032b, Iterator.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r0.f17031a, String.class, "com.obric.aiagent.plugin");
        o.a(r6);
    L26:
        if (r13.hasNext() == false) goto L31;
        String r15 = g.f17272a.a(Scraps.BATTERY, r14, ((al) ZeusTransformUtils.preCheckCast(r13, al.class, "com.obric.aiagent.plugin")).a());
        r0.f17031a = r14;
        r0.f17032b = r13;
        r0.f17035e = 1;
        if (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.f.a(TAG, r15, r0) != r12) goto L26;
        return r12;
    L31:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r6);
        String r16 = r7.getId();
        if (r16 != null) goto L17;
        r16 = "";
    L17:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "unregisterTask taskId = " + r16);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L20;
        boolean r17 = true;
    L21:
        if (r17 == true) goto L23;
        r13 = ((Iterable) ZeusTransformUtils.preCheckCast(p.a((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        r14 = r16;
        goto L26
    L23:
        return x.f38692a;
    L20:
        r17 = false;
    L7:
        r0 = new f(this, r11);
        goto L8
    }
}
