package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e;

import com.bytedance.crash.dumper.Scraps;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.g;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.StorageCondition;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.awareness.AwarenessConditionConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.al;
import d.a.p;
import d.c.b.a.f;
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

/* JADX INFO: compiled from: PersistentStorageConditionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e<StorageCondition> {
    private static final String TAG = "PersistentStorageConditionHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0352a f17233a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PersistentStorageConditionHandler.kt */
    public static final class C0352a {
        public /* synthetic */ C0352a(h r1) {
            this();
        }

        private C0352a() {
        }
    }

    /* JADX INFO: compiled from: PersistentStorageConditionHandler.kt */
    @f(b = "PersistentStorageConditionHandler.kt", c = {35}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.storage.PersistentStorageConditionHandler$isConditionMetInternal$storageData$1")
    static final class b extends l implements m<am, d.c.d<? super MemoryResponse<Float>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17234a;

        b(d.c.d<? super b> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super MemoryResponse<Float>> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super MemoryResponse<Float>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17234a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d r6 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.f17179a;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17234a = 1;
            r5 = r6.a("storage_usage_percent", r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: PersistentStorageConditionHandler.kt */
    @f(b = "PersistentStorageConditionHandler.kt", c = {70}, d = "registerTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.storage.PersistentStorageConditionHandler")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17236b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f17237c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f17238d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f17239e;
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

    /* JADX INFO: compiled from: PersistentStorageConditionHandler.kt */
    @f(b = "PersistentStorageConditionHandler.kt", c = {74}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.storage.PersistentStorageConditionHandler$registerTask$2$1")
    static final class d extends l implements d.h.a.b<d.c.d<? super MemoryResponse<Void>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17241b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ StorageCondition f17242c;

        d(String r3, StorageCondition r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17241b = r3;
            this.f17242c = r4;
            super(1, r6);
        }

        public final Object a(d.c.d<? super MemoryResponse<Void>> r3) {
            return ((d) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f17241b, this.f17242c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super MemoryResponse<Void>> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17240a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r9);
        L11:
            return r9;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r9);
            com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d r10 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.d.f17179a;
            String r2 = this.f17241b;
            AwarenessConditionConfig r3 = AwarenessConditionConfig.Companion.a(100.0d - ((double) this.f17242c.getPercent()));
            d.c.d<? super MemoryResponse<Void>> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17240a = 1;
            r9 = r10.a(r2, "storage_usage_percent", r3, r4);
            if (r9 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: PersistentStorageConditionHandler.kt */
    @f(b = "PersistentStorageConditionHandler.kt", c = {92}, d = "unregisterTask", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.storage.PersistentStorageConditionHandler")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f17243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f17244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f17245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f17246d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f17247e;

        e(a r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17246d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f17245c = r3;
            this.f17247e |= Integer.MIN_VALUE;
            return this.f17246d.b(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f17233a = new C0352a(null);
    }

    public a() {
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a a(ConditionTask r3, Condition r4) {
        return a(r3, (StorageCondition) ZeusTransformUtils.preCheckCast((Condition) ZeusTransformUtils.wrapperContextForParams(r4, Condition.class, "com.obric.aiagent.plugin"), StorageCondition.class, "com.obric.aiagent.plugin"));
    }

    public com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a a(ConditionTask r2, StorageCondition r3) {
        d.h.b.o.e(r2, "task");
        d.h.b.o.e(r3, "condition");
        if (a(r3) == false) goto L6;
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.f17016b;
    L6:
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.h;
    }

    private final boolean a(StorageCondition r7) {
        MemoryResponse r6 = (MemoryResponse) ZeusTransformUtils.preCheckCast(i.a(null, (m) ZeusTransformUtils.preCheckCast(new b(null), m.class, "com.obric.aiagent.plugin"), 1, null), MemoryResponse.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "isConditionMetInternal storageData = " + r6.getData());
        if (r6.isSuccess() == true) goto L6;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "isConditionMetInternal storageData error code = " + r6.getCode() + ", msg = " + r6.getMessage());
        return false;
    L6:
        Float r8 = (Float) ZeusTransformUtils.preCheckCast(r6.getData(), Float.class, "com.obric.aiagent.plugin");
        float r9 = r7.getPercent();
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "isConditionMetInternal currentUsagePercent = " + r8 + ", thresholdPercent = " + r9);
        if (r8 != null) goto L10;
        return false;
    L10:
        if (r8.floatValue() < (100.0f - r9)) goto L13;
        return true;
    L13:
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [T, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c] */
    /* JADX WARN: Type inference failed for: r9v5, types: [T, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x015d -> B:34:0x0162). Please report as a decompilation issue!!! */
    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public Object a(ConditionTask r20, List<StorageCondition> r21, d.c.d<? super com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c> r22) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L7;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.aiagent.plugin");
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
        z.f r8 = (z.f) ZeusTransformUtils.preCheckCast(r3.f17239e, z.f.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c r9 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r3.f17238d, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin");
        Iterator r10 = (Iterator) ZeusTransformUtils.preCheckCast(r3.f17237c, Iterator.class, "com.obric.aiagent.plugin");
        z.f r11 = (z.f) ZeusTransformUtils.preCheckCast(r3.f17236b, z.f.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r3.f17235a, String.class, "com.obric.aiagent.plugin");
        o.a(r4);
        int r18 = r1;
        Iterator r13 = r10;
    L34:
        r8.f38504a = r9.a((com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin"));
        r8 = r11;
        String r14 = r12;
        r7 = r18;
    L26:
        if (r13.hasNext() == false) goto L36;
        Object r15 = r13.next();
        int r16 = r7 + 1;
        if (r7 >= 0) goto L30;
        p.c();
    L30:
        StorageCondition r17 = (StorageCondition) ZeusTransformUtils.preCheckCast(r15, StorageCondition.class, "com.obric.aiagent.plugin");
        String r19 = g.f17272a.a(Scraps.STORAGE, r14, r7);
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c r110 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c) ZeusTransformUtils.preCheckCast(r8.f38504a, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.class, "com.obric.aiagent.plugin");
        d.h.a.b r111 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r19, r17, null), d.h.a.b.class, "com.obric.aiagent.plugin");
        r3.f17235a = r14;
        r3.f17236b = r8;
        r3.f17237c = r13;
        r3.f17238d = r110;
        r3.f17239e = r8;
        r3.f = r16;
        r3.i = 1;
        r18 = r16;
        Object r23 = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.f.a(TAG, "registerPersistentFeatureEvent " + r19 + " storage_usage_percent", 0, r111, r3, 4, null);
        if (r23 != r5) goto L33;
        return r5;
    L33:
        r12 = r14;
        r11 = r8;
        r4 = r23;
        r9 = r110;
        goto L34
    L36:
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
        boolean r24 = true;
    L21:
        if (r24 == true) goto L23;
        r8 = new z.f();
        r8.f38504a = com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.f17052a, 0, 1, null);
        r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        goto L26
    L23:
        return com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a.a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.f17052a, "register storage failed: taskId is empty", 0, 2, null);
    L20:
        r24 = false;
    L7:
        r3 = new c(this, r2);
        goto L8
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.e
    public Object b(ConditionTask r7, List<StorageCondition> r8, d.c.d<? super x> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r11, e.class, "com.obric.aiagent.plugin");
        if ((r0.f17247e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f17247e -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f17245c;
        Object r12 = d.c.a.b.a();
        int r2 = r0.f17247e;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Iterator r13 = (Iterator) ZeusTransformUtils.preCheckCast(r0.f17244b, Iterator.class, "com.obric.aiagent.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r0.f17243a, String.class, "com.obric.aiagent.plugin");
        o.a(r6);
    L26:
        if (r13.hasNext() == false) goto L31;
        String r15 = g.f17272a.a(Scraps.STORAGE, r14, ((al) ZeusTransformUtils.preCheckCast(r13, al.class, "com.obric.aiagent.plugin")).a());
        r0.f17243a = r14;
        r0.f17244b = r13;
        r0.f17247e = 1;
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
        r0 = new e(this, r11);
        goto L8
    }
}
