package com.obric.aiagent.executionengine.eventstaskmanager.migration;

import android.content.Context;
import android.os.Looper;
import androidx.room.p;
import com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDatabase;
import com.obric.aiagent.executionengine.eventstaskmanager.common.data.e;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.bean.ConditionTaskBean;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.bean.ConditionTaskRecordBean;
import com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.ExecutionRecordBean;
import com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.ExecutionDetailRecordBean;
import com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.bean.ShortcutTaskBean;
import com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.bean.ShortcutTaskRecordBean;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.h.b.z;
import d.o;
import d.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlinx.coroutines.am;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: ConditionTaskMigrationOperation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.obric.aiagent.executionengine.eventstaskmanager.migration.b<TaskDatabase> {
    private static final String TAG = "ConditionTaskMigrationOp";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0359a f17451a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.migration.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConditionTaskMigrationOperation.kt */
    private static final class C0359a {
        public /* synthetic */ C0359a(h r1) {
            this();
        }

        private C0359a() {
        }
    }

    /* JADX INFO: compiled from: ConditionTaskMigrationOperation.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f17452a;

        public b(Long r5) {
            if (r5 == null) goto L5;
            long r0 = r5.longValue();
        L6:
            this.f17452a = r0 - 1;
            return;
        L5:
            r0 = System.currentTimeMillis();
            goto L6
        }

        public final long a() {
            long r0 = this.f17452a;
            this.f17452a = (-1) + r0;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskMigrationOperation.kt */
    @f(b = "ConditionTaskMigrationOperation.kt", c = {29}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.migration.ConditionTaskMigrationOperation$getOriginalDatabase$1")
    static final class c extends l implements m<am, d.c.d<? super TaskDatabase>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17453a;

        c(d.c.d<? super c> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super TaskDatabase> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super TaskDatabase> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17453a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r6 = e.f16691a;
            d.c.d<? super TaskDatabase> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17453a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ConditionTaskMigrationOperation.kt */
    @f(b = "ConditionTaskMigrationOperation.kt", c = {57}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.migration.ConditionTaskMigrationOperation$mergeData$targetDb$1")
    static final class d extends l implements m<am, d.c.d<? super TaskDatabase>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17454a;

        d(d.c.d<? super d> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super TaskDatabase> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super TaskDatabase> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17454a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            e r6 = e.f16691a;
            d.c.d<? super TaskDatabase> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17454a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    static {
        f17451a = new C0359a(null);
    }

    /* JADX INFO: renamed from: lambda$3WZ2-YhPB1Sn7cjG1kpd3dCpZ_w, reason: not valid java name */
    public static /* synthetic */ List m172lambda$3WZ2YhPB1Sn7cjG1kpd3dCpZ_w(com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r0, int r1, int r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ List lambda$4M9AjgKE6QWiEERLd6tfjEk1YO8(com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r0, int r1, int r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$8KnxmnjlkcRFkexiYbkOTffsdoM(com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r0, List r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$IgN0FGHLCDn_6rFfKkArjExO-Ek, reason: not valid java name */
    public static /* synthetic */ List m173lambda$IgN0FGHLCDn_6rFfKkArjExOEk(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r0, int r1, int r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$WCqX90CtatHJ11v7JxboJbmKET0(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r0, List r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$_N1iJm-iE-l4CuMwKt4NXfuEN0I, reason: not valid java name */
    public static /* synthetic */ x m174lambda$_N1iJmiEl4CuMwKt4NXfuEN0I(a r0, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r1, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r2, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r3, b r4, Set r5, List r6) {
        return a(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ x lambda$eBJQ8PNDMXNpV8P52_LUuQkyP3s(com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r0, List r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ x lambda$gfRtMR2I2UG_Mwvv9OiYMbzVwfA(com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r0, List r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ List lambda$i62R11s0D8NZMS1YXpLoW_wERbs(com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r0, int r1, int r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ List lambda$jmLXxtHb0vjJjjDESFUwA1WadgY(com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r0, int r1, int r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$qmdJy4qisIWC_4ooeK-F9lxIs6M, reason: not valid java name */
    public static /* synthetic */ void m175lambda$qmdJy4qisIWC_4ooeKF9lxIs6M(a r0, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r1, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r2, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r3, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r4, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r5, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r6, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r7, z.d r8, z.d r9, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r10, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r11, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r12, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r13, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r14) {
        a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ x lambda$wcHbX46zuvYy9vdjOZT180jNPGk(a r0, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r1, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r2, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r3, b r4, Set r5, List r6) {
        return a(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ List lambda$yaJWfS3tJvsvcBkeucYpT_1Ei4M(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r0, int r1, int r2) {
        return a(r0, r1, r2);
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.migration.b
    public String b() {
        return "condition_task_backup.db";
    }

    public a() {
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.migration.b
    public /* synthetic */ void a(Context r3, p r4) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (TaskDatabase) ZeusTransformUtils.preCheckCast(r4, TaskDatabase.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.migration.b
    public /* synthetic */ p b(Context r3, File r4) {
        return (p) ZeusTransformUtils.preCheckCast(a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4), p.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.migration.b
    public /* synthetic */ p c() {
        return (p) ZeusTransformUtils.preCheckCast(a(), p.class, "com.obric.aiagent.plugin");
    }

    public TaskDatabase a() {
        return (TaskDatabase) ZeusTransformUtils.preCheckCast(i.a(null, (m) ZeusTransformUtils.preCheckCast(new c(null), m.class, "com.obric.aiagent.plugin"), 1, null), TaskDatabase.class, "com.obric.aiagent.plugin");
    }

    public TaskDatabase a(Context r2, File r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        d.h.b.o.e(r3, "importedDbFile");
        return TaskDatabase.f16687e.a(r1, r3, "restored_condition_task.db");
    }

    private final <T> void a(m<? super Integer, ? super Integer, ? extends List<? extends T>> r5, d.h.a.b<? super List<? extends T>, x> r6) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        int r8 = 0;
    L3:
        List r1 = (List) ZeusTransformUtils.preCheckCast(r4.invoke(Integer.valueOf(r8), 300), List.class, "com.obric.aiagent.plugin");
        if (r1.isEmpty() == true) goto L7;
        r7.invoke(r1);
        r8 = r8 + r1.size();
        if (r1.size() >= 300) goto L3;
        return;
    }

    public void a(Context r22, TaskDatabase r23) {
        d.h.b.o.e((Context) ZeusTransformUtils.wrapperContextForParams(r22, Context.class, "com.obric.aiagent.plugin"), "context");
        d.h.b.o.e(r23, "restoredDb");
        if (d.h.b.o.a(Looper.getMainLooper(), Looper.myLooper()) == false) goto L5;
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.a(TAG, "mergeData is running on main thread; it may cause ANR. Call it from a background thread.", null);
    L5:
        TaskDatabase r1 = (TaskDatabase) ZeusTransformUtils.preCheckCast(i.a(null, (m) ZeusTransformUtils.preCheckCast(new d(null), m.class, "com.obric.aiagent.plugin"), 1, null), TaskDatabase.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L20;
        final com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r6 = r23.q();
        final com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r10 = r23.o();
        final com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r15 = r23.r();
        final com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r16 = r23.p();
        final com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r17 = r23.s();
        final com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r18 = r23.t();
        final com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r7 = r1.q();
        final com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r11 = r1.o();
        final com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r8 = r1.r();
        final com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r12 = r1.p();
        final com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r9 = r1.s();
        final com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r19 = r1.t();
        final z.d r14 = new z.d();
        final z.d r13 = new z.d();
        r1.a(new $$Lambda$a$qmdJy4qisIWC_4ooeKF9lxIs6M(this, r6, r7, r8, r9, r10, r11, r12, r14, r13, r15, r16, r17, r18, r19));     // Catch: Throwable -> L13
        com.obric.aiagent.executionengine.eventstaskmanager.migration.c.f17455a.a((p) ZeusTransformUtils.preCheckCast(r23, p.class, "com.obric.aiagent.plugin"), "condition_task_bean");
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b(TAG, "Merge from restored DB to current TaskDatabase completed, removedShortcut=" + r14.f38502a + ", removedCondition=" + r13.f38502a);
        return;
    L13:
        th = th;
        String r2 = TAG;
    L17:
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b(r2, "Merge from restored DB to current TaskDatabase failed", th);
        throw th;
    L15:
        th = th;
        r2 = TAG;
        goto L17
    L20:
        throw new IllegalStateException("Target TaskDatabase is null (maybe not logged in)");
    }

    private static final void a(a r16, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r17, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r18, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r19, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r20, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r21, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r22, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r23, z.d r24, z.d r25, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r26, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r27, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r28, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r29, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r30) {
        com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r1 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.wrapperContextForParams(r17, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r3 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.wrapperContextForParams(r18, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
        final com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r4 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d) ZeusTransformUtils.wrapperContextForParams(r19, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d.class, "com.obric.aiagent.plugin");
        final com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r5 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.wrapperContextForParams(r20, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.wrapperContextForParams(r21, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r7 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.wrapperContextForParams(r22, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
        final com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r8 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d) ZeusTransformUtils.wrapperContextForParams(r23, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d.class, "com.obric.aiagent.plugin");
        final com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r9 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d) ZeusTransformUtils.wrapperContextForParams(r26, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d.class, "com.obric.aiagent.plugin");
        final com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r10 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d) ZeusTransformUtils.wrapperContextForParams(r27, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d.class, "com.obric.aiagent.plugin");
        final com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r11 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.wrapperContextForParams(r28, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
        final com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r12 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a) ZeusTransformUtils.wrapperContextForParams(r29, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a.class, "com.obric.aiagent.plugin");
        final com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r13 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a) ZeusTransformUtils.wrapperContextForParams(r30, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a.class, "com.obric.aiagent.plugin");
        HashSet r14 = new HashSet();
        HashSet r15 = new HashSet();
        r16.a(r1, r3, r4, r5, new b(r3.b()), (Set) ZeusTransformUtils.preCheckCast(r14, Set.class, "com.obric.aiagent.plugin"));
        r16.a(r6, r7, r8, r5, new b(r7.b()), (Set) ZeusTransformUtils.preCheckCast(r15, Set.class, "com.obric.aiagent.plugin"));
        r16.a(new $$Lambda$a$4M9AjgKE6QWiEERLd6tfjEk1YO8(r9), new $$Lambda$a$eBJQ8PNDMXNpV8P52_LUuQkyP3s(r4));
        r16.a(new $$Lambda$a$yaJWfS3tJvsvcBkeucYpT_1Ei4M(r10), new $$Lambda$a$WCqX90CtatHJ11v7JxboJbmKET0(r8));
        r16.a(new $$Lambda$a$jmLXxtHb0vjJjjDESFUwA1WadgY(r11), new $$Lambda$a$8KnxmnjlkcRFkexiYbkOTffsdoM(r5));
        r16.a(new $$Lambda$a$3WZ2YhPB1Sn7cjG1kpd3dCpZ_w(r12), new $$Lambda$a$gfRtMR2I2UG_Mwvv9OiYMbzVwfA(r13));
        com.obric.aiagent.executionengine.eventstaskmanager.b.a.f16675a.b(TAG, "Merged task beans in transaction, removedShortcut=" + r14.size() + ", removedCondition=" + r15.size());
        r24.f38502a = r14.size();
        r25.f38502a = r15.size();
    }

    private static final List a(com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r2, int r3, int r4) {
        return ((com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d.class, "com.obric.aiagent.plugin")).a(r3, r4);
    }

    private static final x a(com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r17, List r18) {
        com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r0 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d) ZeusTransformUtils.wrapperContextForParams(r17, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "records");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r3, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r4.add(ShortcutTaskRecordBean.copy$default((ShortcutTaskRecordBean) ZeusTransformUtils.preCheckCast(r5.next(), ShortcutTaskRecordBean.class, "com.obric.aiagent.plugin"), null, 0, null, 0, 0, 0, 31, null));
        goto L4
    L6:
        r0.a((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    private static final List a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r2, int r3, int r4) {
        return ((com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d.class, "com.obric.aiagent.plugin")).a(r3, r4);
    }

    private static final x a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r17, List r18) {
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r0 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d) ZeusTransformUtils.wrapperContextForParams(r17, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "records");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r3, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r4.add(ConditionTaskRecordBean.copy$default((ConditionTaskRecordBean) ZeusTransformUtils.preCheckCast(r5.next(), ConditionTaskRecordBean.class, "com.obric.aiagent.plugin"), null, 0, null, 0, 0, 0, 31, null));
        goto L4
    L6:
        r0.a((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    private static final List a(com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r2, int r3, int r4) {
        return ((com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin")).a(r3, r4);
    }

    private static final x a(com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r25, List r26) {
        com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r0 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.wrapperContextForParams(r25, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "records");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r3, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r4.add(ExecutionRecordBean.copy$default((ExecutionRecordBean) ZeusTransformUtils.preCheckCast(r5.next(), ExecutionRecordBean.class, "com.obric.aiagent.plugin"), null, 0, 0, null, 0, 0, 0, null, null, null, null, 0, 0, 4095, null));
        goto L4
    L6:
        r0.insert((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    private static final List a(com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r2, int r3, int r4) {
        return ((com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a.class, "com.obric.aiagent.plugin")).a(r3, r4);
    }

    private static final x a(com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r18, List r19) {
        com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r0 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a) ZeusTransformUtils.wrapperContextForParams(r18, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "records");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r3, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r4.add(ExecutionDetailRecordBean.copy$default((ExecutionDetailRecordBean) ZeusTransformUtils.preCheckCast(r5.next(), ExecutionDetailRecordBean.class, "com.obric.aiagent.plugin"), null, 0, null, null, null, 0, null, 0, 127, null));
        goto L4
    L6:
        r0.insert((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    private final void a(com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r10, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r11, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r12, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r13, final b r14, Set<String> r15) {
        final com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r16 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
        final com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r4 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
        final com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r5 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d.class, "com.obric.aiagent.plugin");
        final com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.wrapperContextForParams(r13, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
        final Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r15, Set.class, "com.obric.aiagent.plugin");
        a(new $$Lambda$a$i62R11s0D8NZMS1YXpLoW_wERbs(r16), new $$Lambda$a$_N1iJmiEl4CuMwKt4NXfuEN0I(this, r4, r5, r6, r14, r8));
    }

    private static final List a(com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r2, int r3, int r4) {
        return ((com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin")).a(r3, r4);
    }

    private static final x a(a r14, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r15, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r16, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r17, b r18, Set r19, List r20) {
        com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r0 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.wrapperContextForParams(r15, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r10 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d) ZeusTransformUtils.wrapperContextForParams(r16, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r11 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.wrapperContextForParams(r17, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
        Set<String> r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r19, Set.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "tasks");
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        r14.a((ShortcutTaskBean) ZeusTransformUtils.preCheckCast(r13.next(), ShortcutTaskBean.class, "com.obric.aiagent.plugin"), r0, r10, r11, r18.a(), r12);
        goto L4
    L7:
        return x.f38692a;
    }

    private final void a(ShortcutTaskBean r26, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r27, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r28, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r29, long r30, Set<String> r32) {
        com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r1 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.wrapperContextForParams(r27, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r3 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d) ZeusTransformUtils.wrapperContextForParams(r28, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r4 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.wrapperContextForParams(r29, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r32, Set.class, "com.obric.aiagent.plugin");
        String r6 = r26.getShortInstruct();
        if (r6 == null) goto L5;
        String r7 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString();
    L6:
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == false) goto L28;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r1.e(r7), Iterable.class, "com.obric.aiagent.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r9, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r9.iterator();
    L15:
        if (r11.hasNext() == false) goto L17;
        r10.add(((ShortcutTaskBean) ZeusTransformUtils.preCheckCast(r11.next(), ShortcutTaskBean.class, "com.obric.aiagent.plugin")).getTaskId());
        goto L15
    L17:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r14 = r12.iterator();
    L19:
        if (r14.hasNext() == false) goto L23;
        Object r15 = r14.next();
        if (r5.add((String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.aiagent.plugin")) == false) goto L19;
        r13.add(r15);
        goto L19
    L23:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L25:
        if (r16.hasNext() == false) goto L28;
        a(r3, r1, r4, (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.aiagent.plugin"));
    L28:
        if (r1.a(r26.getTaskId()) != null) goto L30;
    L32:
        r1.insert(ShortcutTaskBean.copy$default(r26, null, null, null, 0, null, null, null, false, null, 0, 0, 0, r30, null, null, 28671, null));
        return;
    L30:
        if (r5.add(r26.getTaskId()) == false) goto L32;
        a(r3, r1, r4, r26.getTaskId());
        goto L32
    L11:
        r8 = false;
        goto L12
    L5:
        r7 = null;
        goto L6
    }

    private final void a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r10, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r11, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r12, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r13, final b r14, Set<String> r15) {
        final com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r16 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
        final com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r4 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
        final com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r5 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d.class, "com.obric.aiagent.plugin");
        final com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.wrapperContextForParams(r13, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
        final Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r15, Set.class, "com.obric.aiagent.plugin");
        a(new $$Lambda$a$IgN0FGHLCDn_6rFfKkArjExOEk(r16), new $$Lambda$a$wcHbX46zuvYy9vdjOZT180jNPGk(this, r4, r5, r6, r14, r8));
    }

    private static final List a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r2, int r3, int r4) {
        return ((com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin")).a(r3, r4);
    }

    private static final x a(a r14, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r15, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r16, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r17, b r18, Set r19, List r20) {
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r0 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.wrapperContextForParams(r15, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r10 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d) ZeusTransformUtils.wrapperContextForParams(r16, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r11 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.wrapperContextForParams(r17, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
        Set<String> r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r19, Set.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "tasks");
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        r14.a((ConditionTaskBean) ZeusTransformUtils.preCheckCast(r13.next(), ConditionTaskBean.class, "com.obric.aiagent.plugin"), r0, r10, r11, r18.a(), r12);
        goto L4
    L7:
        return x.f38692a;
    }

    private final void a(ConditionTaskBean r26, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r27, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r28, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r29, long r30, Set<String> r32) {
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r0 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.wrapperContextForParams(r27, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r2 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d) ZeusTransformUtils.wrapperContextForParams(r28, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r3 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.wrapperContextForParams(r29, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r32, Set.class, "com.obric.aiagent.plugin");
        if (r0.a(r26.getTaskId()) != null) goto L5;
    L7:
        r0.insert(ConditionTaskBean.copy$default(r26, null, null, null, null, null, null, null, 0, 1, 0, r30, null, null, null, null, null, 64255, null));
        return;
    L5:
        if (r1.add(r26.getTaskId()) == false) goto L7;
        a(r2, r0, r3, r26.getTaskId());
        goto L7
    }

    private final void a(com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r2, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r3, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r4, String r5) {
        com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r1 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r7 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
        ShortcutTaskBean r8 = r6.a(r5);
        if (r8 == null) goto L5;
        r6.delete(r8);
    L5:
        r1.b(r5);
        r7.a(r5);
    }

    private final void a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r2, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r3, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r4, String r5) {
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r1 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r6 = (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r7 = (com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, "com.obric.aiagent.plugin");
        ConditionTaskBean r8 = r6.a(r5);
        if (r8 == null) goto L5;
        r6.delete(r8);
    L5:
        r1.c(r5);
        r7.a(r5);
    }
}
