package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d;

import android.os.Bundle;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.g;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.SmsCondition;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.awareness.AwarenessConditionConfig;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.al;
import d.a.ax;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.h.b.z;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: PersistentSmsConditionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e<SmsCondition> {
    private static final String TAG = "PersistentSmsConditionHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0351a f17214a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, ConditionTask> f17215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<Long, List<b>> f17216c;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PersistentSmsConditionHandler.kt */
    public static final class C0351a {
        public /* synthetic */ C0351a(h r1) {
            this();
        }

        private C0351a() {
        }
    }

    /* JADX INFO: compiled from: PersistentSmsConditionHandler.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f17217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f17218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set<String> f17219c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f17217a, r6.f17217a) == true) goto L12;
            return false;
        L12:
            if (this.f17218b == r6.f17218b) goto L15;
            return false;
        L15:
            if (o.a(this.f17219c, r6.f17219c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f17217a.hashCode() * 31) + Integer.hashCode(this.f17218b)) * 31) + this.f17219c.hashCode();
        }

        public String toString() {
            return "SmsMatchRecord(taskId=" + this.f17217a + ", conditionIndex=" + this.f17218b + ", categoryTypes=" + this.f17219c + ')';
        }

        public b(String r3, int r4, Set<String> r5) {
            Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
            o.e(r3, DBDefinition.TASK_ID);
            o.e(r6, "categoryTypes");
            this.f17217a = r3;
            this.f17218b = r4;
            this.f17219c = r6;
        }

        public final String a() {
            return this.f17217a;
        }

        public final int b() {
            return this.f17218b;
        }

        public final Set<String> c() {
            return this.f17219c;
        }
    }

    /* JADX INFO: compiled from: PersistentSmsConditionHandler.kt */
    @f(b = "PersistentSmsConditionHandler.kt", c = {94}, d = "registerTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.sms.PersistentSmsConditionHandler")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17221b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f17222c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f17223d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f17224e;
        int f;
        /* synthetic */ Object g;
        final /* synthetic */ a h;
        int i;

        c(a r3, d.c.d<? super c> r4) {
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

    /* JADX INFO: compiled from: PersistentSmsConditionHandler.kt */
    @f(b = "PersistentSmsConditionHandler.kt", c = {98}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.sms.PersistentSmsConditionHandler$registerTask$2$1")
    static final class d extends l implements d.h.a.b<d.c.d<? super MemoryResponse<Void>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SmsCondition f17227c;

        d(String r3, SmsCondition r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17226b = r3;
            this.f17227c = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super MemoryResponse<Void>> r3) {
            return ((d) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f17226b, this.f17227c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super MemoryResponse<Void>> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17225a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L14:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d r8 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.f17179a;
            String r2 = this.f17226b;
            AwarenessConditionConfig.a r3 = AwarenessConditionConfig.Companion;
            String r4 = this.f17227c.getCategoryType();
            if (r4 != null) goto L11;
            r4 = "";
        L11:
            AwarenessConditionConfig r5 = r3.b("category_list", r4);
            d.c.d<? super MemoryResponse<Void>> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17225a = 1;
            r7 = r8.b(r2, EventNames.RECEIVE_SMS, r5, r6);
            if (r7 != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: PersistentSmsConditionHandler.kt */
    @f(b = "PersistentSmsConditionHandler.kt", c = {120}, d = "unregisterTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.sms.PersistentSmsConditionHandler")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f17230c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f17231d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f17232e;

        e(a r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17231d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17230c = r3;
            this.f17232e |= Integer.MIN_VALUE;
            return this.f17231d.b(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f17214a = new C0351a(null);
    }

    public static /* synthetic */ boolean lambda$ECrGMCzAbxNYVeQ_6rqa12hx1PQ(long r0, Long r2) {
        return a(r0, r2);
    }

    public static /* synthetic */ List lambda$KTS5PaBL3XslRXlanwfVbO4Ks44(b r0, Long r1, List r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$wxKHvFl5sXmI7F1-CHM7RhNj3kk, reason: not valid java name */
    public static /* synthetic */ List m169lambda$wxKHvFl5sXmI7F1CHM7RhNj3kk(m r0, Object r1, Object r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$xdgXhRAc_aXOPsKMIGYfWCXCXG8(d.h.a.b r0, Object r1) {
        return a(r0, r1);
    }

    public a() {
        this.f17215b = new ConcurrentHashMap();
        this.f17216c = new ConcurrentHashMap();
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a a(ConditionTask r3, Condition r4) {
        return a(r3, (SmsCondition) ZeusTransformUtils.preCheckCast((Condition) ZeusTransformUtils.wrapperContextForParams(r4, Condition.class, "com.obric.aiagent.plugin"), SmsCondition.class, "com.obric.aiagent.plugin"));
    }

    public com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a a(ConditionTask r2, SmsCondition r3) {
        o.e(r2, "task");
        o.e(r3, "condition");
        if (b(r2, r3) == false) goto L6;
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.f17016b;
    L6:
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.i;
    }

    private final boolean b(ConditionTask r13, SmsCondition r14) {
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "isConditionMetInternal categoryList = " + r14.getCategoryType() + ", content = " + r14.getContent());
        String r0 = r13.getId();
        if (r0 != null) goto L5;
    L39:
        return false;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L39;
        int r15 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.d.c(r13.getConditions(), aa.b(SmsCondition.class)).indexOf(r14);
        if (r15 >= 0) goto L13;
        return false;
    L13:
        long r5 = System.currentTimeMillis();
        long r7 = r5 - 60000;
        a(r7);
        Set<Long> r2 = this.f17216c.keySet();
        o.c(r2, "<get-keys>(...)");
        Iterator r3 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L15:
        if (r3.hasNext() == false) goto L39;
        long r9 = ((Number) ZeusTransformUtils.preCheckCast(r3.next(), Number.class, "com.obric.aiagent.plugin")).longValue();
        if (r7 <= r9) goto L19;
    L21:
        boolean r11 = false;
    L22:
        if (r11 == false) goto L15;
        List r10 = (List) ZeusTransformUtils.preCheckCast(this.f17216c.get(Long.valueOf(r9)), List.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L26;
        r10 = p.b();
    L26:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, Collection.class) == true) goto L29;
    L31:
        Iterator r16 = r12.iterator();
    L33:
        if (r16.hasNext() == false) goto L30;
        if (a((b) ZeusTransformUtils.preCheckCast(r16.next(), b.class, "com.obric.aiagent.plugin"), r0, r15, r14) == false) goto L33;
        boolean r17 = true;
    L37:
        if (r17 == false) goto L15;
        return true;
    L30:
        r17 = false;
        goto L37
    L29:
        if (((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L31;
    L19:
        if (r9 > r5) goto L21;
        r11 = true;
        goto L22
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [T, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c] */
    /* JADX WARN: Type inference failed for: r6v11, types: [T, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x016d -> B:34:0x0170). Please report as a decompilation issue!!! */
    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public Object a(ConditionTask r20, List<SmsCondition> r21, d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c> r22) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, c.class) == false) goto L7;
        c r4 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin");
        if ((r4.i & Integer.MIN_VALUE) == 0) goto L7;
        r4.i -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.g;
        Object r6 = d.c.a.b.a();
        int r7 = r4.i;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        int r0 = r4.f;
        z.f r2 = (z.f) ZeusTransformUtils.preCheckCast(r4.f17224e, z.f.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c r8 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r4.f17223d, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin");
        Iterator r9 = (Iterator) ZeusTransformUtils.preCheckCast(r4.f17222c, Iterator.class, "com.obric.aiagent.plugin");
        z.f r10 = (z.f) ZeusTransformUtils.preCheckCast(r4.f17221b, z.f.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r4.f17220a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
    L34:
        r2.f38504a = r8.a((com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin"));
        r2 = r10;
        String r12 = r11;
    L26:
        if (r9.hasNext() == false) goto L36;
        Object r13 = r9.next();
        int r15 = r0 + 1;
        if (r0 >= 0) goto L30;
        p.c();
    L30:
        SmsCondition r14 = (SmsCondition) ZeusTransformUtils.preCheckCast(r13, SmsCondition.class, "com.obric.aiagent.plugin");
        String r16 = g.f17272a.a("sms", r12, r0);
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c r17 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r2.f38504a, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin");
        String r18 = "registerPersistentContextEvent " + r16 + " receive_sms";
        d.h.a.b r19 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r16, r14, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        r4.f17220a = r12;
        r4.f17221b = r2;
        r4.f17222c = r9;
        r4.f17223d = r17;
        r4.f17224e = r2;
        r4.f = r15;
        r4.i = 1;
        r8 = r17;
        r0 = r15;
        Object r110 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.f.a(TAG, r18, 0, r19, r4, 4, null);
        if (r110 != r6) goto L33;
        return r6;
    L33:
        r11 = r12;
        r5 = r110;
        r10 = r2;
        goto L34
    L36:
        return r2.f38504a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r5);
        r12 = r20.getId();
        if (r12 != null) goto L17;
        r12 = "";
    L17:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "registerTask taskId = " + r12);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L20;
        boolean r23 = true;
    L21:
        if (r23 == true) goto L23;
        ((Map) ZeusTransformUtils.preCheckCast(this.f17215b, Map.class, "com.obric.aiagent.plugin")).put(r12, r20);
        z.f r24 = new z.f();
        r24.f38504a = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.f17052a, 0, 1, null);
        Iterator r25 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        r2 = r24;
        r0 = 0;
        r9 = r25;
        goto L26
    L23:
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.f17052a, "register sms failed: taskId is empty", 0, 2, null);
    L20:
        r23 = false;
    L7:
        r4 = new c(this, r3);
        goto L8
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public Object b(ConditionTask r8, List<SmsCondition> r9, d.c.d<? super x> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r12, e.class, "com.obric.aiagent.plugin");
        if ((r0.f17232e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f17232e -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.f17230c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f17232e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Iterator r7 = (Iterator) ZeusTransformUtils.preCheckCast(r0.f17229b, Iterator.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r0.f17228a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
    L26:
        if (r7.hasNext() == false) goto L31;
        String r15 = g.f17272a.a("sms", r14, ((al) ZeusTransformUtils.preCheckCast(r7, al.class, "com.obric.aiagent.plugin")).a());
        r0.f17228a = r14;
        r0.f17229b = r7;
        r0.f17232e = 1;
        if (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.f.a(TAG, r15, r0) != r2) goto L26;
        return r2;
    L31:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r13);
        r14 = r8.getId();
        if (r14 != null) goto L17;
        r14 = "";
    L17:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "unregisterTask taskId = " + r14);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L20;
        boolean r16 = true;
    L21:
        if (r16 == true) goto L23;
        this.f17215b.remove(r14);
        r7 = ((Iterable) ZeusTransformUtils.preCheckCast(p.a((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        goto L26
    L23:
        return x.f38692a;
    L20:
        r16 = false;
    L7:
        r0 = new e(this, r12);
        goto L8
    }

    public final void a(String r6, int r7, Bundle r8) {
        o.e(r6, DBDefinition.TASK_ID);
        if (r8 == null) goto L6;
        ArrayList<String> r0 = r8.getStringArrayList("category_list");
        if (r0 == null) goto L6;
    L7:
        String r1 = null;
        if (r8 == null) goto L10;
        String r9 = r8.getString("content");
    L11:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "recordPersistentSmsEvent taskId=" + r6 + " conditionIndex=" + r7 + " categoryList=" + r0 + " content=" + r9);
        ConditionTask r10 = (ConditionTask) ZeusTransformUtils.preCheckCast(this.f17215b.get(r6), ConditionTask.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L18;
        ConditionGroup r11 = r10.getConditions();
        if (r11 == null) goto L18;
        List r12 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.d.c(r11, aa.b(SmsCondition.class));
        if (r12 == null) goto L18;
        SmsCondition r13 = (SmsCondition) ZeusTransformUtils.preCheckCast(p.d(r12, r7), SmsCondition.class, "com.obric.aiagent.plugin");
    L19:
        if (r13 == null) goto L32;
        String r14 = r13.getCategoryType();
        if (r14 == null) goto L32;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L25;
        boolean r2 = true;
    L26:
        if (r2 == false) goto L28;
        r1 = r14;
    L28:
        if (r1 == null) goto L32;
        Set r15 = ax.a(r1);
        if (r15 == null) goto L32;
    L33:
        final b r3 = new b(r6, r7, r15);
        long r16 = System.currentTimeMillis();
        a(r16 - 60000);
        ConcurrentHashMap<Long, List<b>> r5 = this.f17216c;
        Long r17 = Long.valueOf(r16);
        final m r18 = new $$Lambda$a$KTS5PaBL3XslRXlanwfVbO4Ks44(r3);
        r5.compute(r17, new $$Lambda$a$wxKHvFl5sXmI7F1CHM7RhNj3kk(r18));
        return;
    L25:
        r2 = false;
    L32:
        r15 = p.q((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"));
    L18:
        r13 = null;
        goto L19
    L10:
        r9 = null;
    L6:
        r0 = new ArrayList();
        goto L7
    }

    private static final List a(m r2, Object r3, Object r4) {
        return (List) ZeusTransformUtils.preCheckCast(((m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.aiagent.plugin")).invoke(r3, r4), List.class, "com.obric.aiagent.plugin");
    }

    private static final List a(b r2, Long r3, List r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "<unused var>");
        if (r5 != null) goto L6;
        r5 = p.b();
    L6:
        return p.a((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin"), r2);
    }

    private final boolean a(b r2, String r3, int r4, SmsCondition r5) {
        if (o.a(r2.a(), r3) == false) goto L15;
        if (r2.b() != r4) goto L15;
        String r1 = r5.getCategoryType();
        if (r1 != null) goto L9;
    L11:
        boolean r6 = false;
    L12:
        if (r6 == false) goto L15;
        return true;
    L9:
        if (r2.c().contains(r1) != true) goto L11;
        r6 = true;
    L15:
        return false;
    }

    private final void a(final long r2) {
        Set<Long> r1 = this.f17216c.keySet();
        final d.h.a.b r0 = new $$Lambda$a$ECrGMCzAbxNYVeQ_6rqa12hx1PQ(r2);
        r1.removeIf(new $$Lambda$a$xdgXhRAc_aXOPsKMIGYfWCXCXG8(r0));
    }

    private static final boolean a(long r2, Long r4) {
        o.e(r4, "it");
        if (r4.longValue() >= r2) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean a(d.h.a.b r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }
}
