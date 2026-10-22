package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a;

import android.database.Cursor;
import androidx.room.p;
import androidx.room.s;
import androidx.room.v;
import androidx.sqlite.db.g;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.bean.ConditionTaskBean;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ConditionTaskDao_TaskDatabase_Impl.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f16902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.room.f<ConditionTaskBean> f16903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.aiagent.executionengine.eventstaskmanager.common.data.c f16904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.room.e<ConditionTaskBean> f16905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final androidx.room.e<ConditionTaskBean> f16906e;
    private final v f;

    static /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.common.data.c a(c r0) {
        return r0.f16904c;
    }

    public c(final p r2) {
        this.f16904c = new com.obric.aiagent.executionengine.eventstaskmanager.common.data.c();
        this.f16902a = r2;
        this.f16903b = new AnonymousClass1(this, r2);
        this.f16905d = new AnonymousClass2(this, r2);
        this.f16906e = new AnonymousClass3(this, r2);
        this.f = new AnonymousClass4(this, r2);
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a
    public void insert(ConditionTaskBean r2) {
        this.f16902a.i();
        this.f16902a.j();
        this.f16903b.insert(r2);     // Catch: Throwable -> L6
        this.f16902a.m();     // Catch: Throwable -> L6
        this.f16902a.k();
        return;
    L6:
        th = move-exception;
        this.f16902a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a
    public int delete(ConditionTaskBean r2) {
        this.f16902a.i();
        this.f16902a.j();
        int r3 = this.f16905d.a(r2) + 0;     // Catch: Throwable -> L6
        this.f16902a.m();     // Catch: Throwable -> L6
        this.f16902a.k();
        return r3;
    L6:
        th = move-exception;
        this.f16902a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a
    public int update(ConditionTaskBean r2) {
        this.f16902a.i();
        this.f16902a.j();
        int r3 = this.f16906e.a(r2) + 0;     // Catch: Throwable -> L6
        this.f16902a.m();     // Catch: Throwable -> L6
        this.f16902a.k();
        return r3;
    L6:
        th = move-exception;
        this.f16902a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a
    public int a(String r3, String r4, long r5) {
        this.f16902a.i();
        g r0 = this.f.c();
        r0.a(1, r5);
        if (r4 != null) goto L5;
        r0.a(2);
    L7:
        if (r3 != null) goto L9;
        r0.a(3);
    L10:
        this.f16902a.j();
        int r6 = r0.a();     // Catch: Throwable -> L14
        this.f16902a.m();     // Catch: Throwable -> L14
        this.f16902a.k();
        this.f.a(r0);
        return r6;
    L14:
        th = move-exception;
        this.f16902a.k();
        this.f.a(r0);
        throw th;
    L9:
        r0.a(3, r3);
        goto L10
    L5:
        r0.a(2, r4);
        goto L7
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a
    public ConditionTaskBean a(String r39) {
        s r2 = s.a("SELECT * FROM condition_task_bean WHERE task_id = ?", 1);
        if (r39 != null) goto L5;
        r2.a(1);
    L6:
        this.f16902a.i();
        Cursor r1 = androidx.room.b.c.query(this.f16902a, r2, false, null);
        int r3 = androidx.room.b.b.b(r1, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L66
        int r5 = androidx.room.b.b.b(r1, "actions");     // Catch: Throwable -> L66
        int r6 = androidx.room.b.b.b(r1, "name");     // Catch: Throwable -> L66
        int r7 = androidx.room.b.b.b(r1, "conditions");     // Catch: Throwable -> L66
        int r8 = androidx.room.b.b.b(r1, "periodicPolicy");     // Catch: Throwable -> L66
        int r9 = androidx.room.b.b.b(r1, "trigger_control_policy");     // Catch: Throwable -> L66
        int r10 = androidx.room.b.b.b(r1, "source_from");     // Catch: Throwable -> L66
        int r11 = androidx.room.b.b.b(r1, "task_status");     // Catch: Throwable -> L66
        int r12 = androidx.room.b.b.b(r1, "enable_status");     // Catch: Throwable -> L66
        int r13 = androidx.room.b.b.b(r1, "create_time");     // Catch: Throwable -> L66
        int r14 = androidx.room.b.b.b(r1, "display_order");     // Catch: Throwable -> L66
        int r15 = androidx.room.b.b.b(r1, "ext");     // Catch: Throwable -> L66
        int r4 = androidx.room.b.b.b(r1, "task_mode");     // Catch: Throwable -> L66
        s r16 = r2;
        int r17 = androidx.room.b.b.b(r1, "task_knowledge");     // Catch: Throwable -> L64
        int r18 = androidx.room.b.b.b(r1, "template_id");     // Catch: Throwable -> L64
        int r19 = androidx.room.b.b.b(r1, "omni_model");     // Catch: Throwable -> L64
        if (r1.moveToFirst() == true) goto L12;
        ConditionTaskBean r20 = null;
    L62:
        r1.close();
        r16.a();
        return r20;
    L12:
        if (r1.isNull(r3) == false) goto L14;
        String r21 = null;
    L16:
        if (r1.isNull(r5) == false) goto L18;
        String r22 = null;
    L19:
        List<ConditionTaskAction> r23 = this.f16904c.c(r22);     // Catch: Throwable -> L64
        if (r1.isNull(r6) == false) goto L22;
        String r24 = null;
    L24:
        if (r1.isNull(r7) == false) goto L26;
        String r25 = null;
    L27:
        ConditionGroup r26 = this.f16904c.a(r25);     // Catch: Throwable -> L64
        if (r1.isNull(r8) == false) goto L30;
        String r27 = null;
    L31:
        PeriodicPolicy r28 = this.f16904c.b(r27);     // Catch: Throwable -> L64
        if (r1.isNull(r9) == false) goto L34;
        String r29 = null;
    L35:
        TriggerControlPolicy r210 = this.f16904c.g(r29);     // Catch: Throwable -> L64
        if (r1.isNull(r10) == false) goto L38;
        String r211 = null;
    L39:
        int r212 = r1.getInt(r11);     // Catch: Throwable -> L64
        int r213 = r1.getInt(r12);     // Catch: Throwable -> L64
        long r214 = r1.getLong(r13);     // Catch: Throwable -> L64
        long r31 = r1.getLong(r14);     // Catch: Throwable -> L64
        if (r1.isNull(r15) == false) goto L42;
        String r30 = null;
    L43:
        Map<String, String> r33 = this.f16904c.d(r30);     // Catch: Throwable -> L64
        if (r1.isNull(r4) == false) goto L46;
        Integer r34 = null;
    L48:
        if (r1.isNull(r17) == false) goto L50;
        String r32 = null;
    L51:
        TaskKnowledge r35 = this.f16904c.f(r32);     // Catch: Throwable -> L64
        if (r1.isNull(r18) == false) goto L54;
        String r36 = null;
    L56:
        if (r1.isNull(r19) == false) goto L58;
        String r37 = null;
    L59:
        r20 = new ConditionTaskBean(r21, r23, r24, r26, r28, r210, r211, r212, r213, r214, r31, r33, r34, r35, r36, r37);     // Catch: Throwable -> L64
        goto L62
    L58:
        r37 = r1.getString(r19);     // Catch: Throwable -> L64
        goto L59
    L54:
        r36 = r1.getString(r18);     // Catch: Throwable -> L64
        goto L56
    L50:
        r32 = r1.getString(r17);     // Catch: Throwable -> L64
        goto L51
    L46:
        r34 = Integer.valueOf(r1.getInt(r4));     // Catch: Throwable -> L64
        goto L48
    L42:
        r30 = r1.getString(r15);     // Catch: Throwable -> L64
        goto L43
    L38:
        r211 = r1.getString(r10);     // Catch: Throwable -> L64
        goto L39
    L34:
        r29 = r1.getString(r9);     // Catch: Throwable -> L64
        goto L35
    L30:
        r27 = r1.getString(r8);     // Catch: Throwable -> L64
        goto L31
    L26:
        r25 = r1.getString(r7);     // Catch: Throwable -> L64
        goto L27
    L22:
        r24 = r1.getString(r6);     // Catch: Throwable -> L64
        goto L24
    L18:
        r22 = r1.getString(r5);     // Catch: Throwable -> L64
        goto L19
    L14:
        r21 = r1.getString(r3);     // Catch: Throwable -> L64
    L64:
        th = th;
    L68:
        r1.close();
        r16.a();
        throw th;
    L66:
        th = th;
        r16 = r2;
        goto L68
    L5:
        r2.a(1, r39);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a
    public List<ConditionTaskBean> a() {
        c r0 = this;
        s r1 = s.a("SELECT * FROM condition_task_bean WHERE enable_status = 0", 0);
        r0.f16902a.i();
        Cursor r2 = androidx.room.b.c.query(r0.f16902a, r1, false, null);
        int r3 = androidx.room.b.b.b(r2, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L62
        int r5 = androidx.room.b.b.b(r2, "actions");     // Catch: Throwable -> L62
        int r6 = androidx.room.b.b.b(r2, "name");     // Catch: Throwable -> L62
        int r7 = androidx.room.b.b.b(r2, "conditions");     // Catch: Throwable -> L62
        int r8 = androidx.room.b.b.b(r2, "periodicPolicy");     // Catch: Throwable -> L62
        int r9 = androidx.room.b.b.b(r2, "trigger_control_policy");     // Catch: Throwable -> L62
        int r10 = androidx.room.b.b.b(r2, "source_from");     // Catch: Throwable -> L62
        int r11 = androidx.room.b.b.b(r2, "task_status");     // Catch: Throwable -> L62
        int r12 = androidx.room.b.b.b(r2, "enable_status");     // Catch: Throwable -> L62
        int r13 = androidx.room.b.b.b(r2, "create_time");     // Catch: Throwable -> L62
        int r14 = androidx.room.b.b.b(r2, "display_order");     // Catch: Throwable -> L62
        int r15 = androidx.room.b.b.b(r2, "ext");     // Catch: Throwable -> L62
        int r4 = androidx.room.b.b.b(r2, "task_mode");     // Catch: Throwable -> L62
        s r16 = r1;
        int r17 = androidx.room.b.b.b(r2, "task_knowledge");     // Catch: Throwable -> L60
        int r18 = androidx.room.b.b.b(r2, "template_id");     // Catch: Throwable -> L60
        int r19 = androidx.room.b.b.b(r2, "omni_model");     // Catch: Throwable -> L60
        int r20 = r4;
        ArrayList r21 = new ArrayList(r2.getCount());     // Catch: Throwable -> L60
    L6:
        if (r2.moveToNext() == false) goto L58;
        if (r2.isNull(r3) == false) goto L11;
        String r22 = null;
    L13:
        if (r2.isNull(r5) == false) goto L15;
        String r23 = null;
    L16:
        List<ConditionTaskAction> r24 = r0.f16904c.c(r23);     // Catch: Throwable -> L60
        if (r2.isNull(r6) == false) goto L19;
        String r25 = null;
    L21:
        if (r2.isNull(r7) == false) goto L23;
        String r26 = null;
    L24:
        ConditionGroup r27 = r0.f16904c.a(r26);     // Catch: Throwable -> L60
        if (r2.isNull(r8) == false) goto L27;
        String r28 = null;
    L28:
        PeriodicPolicy r29 = r0.f16904c.b(r28);     // Catch: Throwable -> L60
        if (r2.isNull(r9) == false) goto L31;
        String r30 = null;
    L32:
        TriggerControlPolicy r210 = r0.f16904c.g(r30);     // Catch: Throwable -> L60
        if (r2.isNull(r10) == false) goto L35;
        String r211 = null;
    L36:
        int r212 = r2.getInt(r11);     // Catch: Throwable -> L60
        int r31 = r2.getInt(r12);     // Catch: Throwable -> L60
        long r32 = r2.getLong(r13);     // Catch: Throwable -> L60
        long r33 = r2.getLong(r14);     // Catch: Throwable -> L60
        if (r2.isNull(r15) == false) goto L39;
        String r34 = null;
    L40:
        Map<String, String> r35 = r0.f16904c.d(r34);     // Catch: Throwable -> L60
        r20 = r20;
        if (r2.isNull(r20) == false) goto L43;
        Integer r36 = null;
    L45:
        if (r2.isNull(r17) == false) goto L47;
        String r37 = null;
    L48:
        TaskKnowledge r38 = r0.f16904c.f(r37);     // Catch: Throwable -> L60
        int r39 = r18;
        if (r2.isNull(r39) == false) goto L51;
        String r310 = null;
    L53:
        if (r2.isNull(r19) == false) goto L55;
        String r311 = null;
    L56:
        r21.add(new ConditionTaskBean(r22, r24, r25, r27, r29, r210, r211, r212, r31, r32, r33, r35, r36, r38, r310, r311));     // Catch: Throwable -> L60
        r0 = this;
        r18 = r39;
        r19 = r19;
        r3 = r3;
        goto L6
    L55:
        r311 = r2.getString(r19);     // Catch: Throwable -> L60
        goto L56
    L51:
        r310 = r2.getString(r39);     // Catch: Throwable -> L60
        goto L53
    L47:
        r37 = r2.getString(r17);     // Catch: Throwable -> L60
        goto L48
    L43:
        r36 = Integer.valueOf(r2.getInt(r20));     // Catch: Throwable -> L60
        goto L45
    L39:
        r34 = r2.getString(r15);     // Catch: Throwable -> L60
        goto L40
    L35:
        r211 = r2.getString(r10);     // Catch: Throwable -> L60
        goto L36
    L31:
        r30 = r2.getString(r9);     // Catch: Throwable -> L60
        goto L32
    L27:
        r28 = r2.getString(r8);     // Catch: Throwable -> L60
        goto L28
    L23:
        r26 = r2.getString(r7);     // Catch: Throwable -> L60
        goto L24
    L19:
        r25 = r2.getString(r6);     // Catch: Throwable -> L60
        goto L21
    L15:
        r23 = r2.getString(r5);     // Catch: Throwable -> L60
        goto L16
    L11:
        r22 = r2.getString(r3);     // Catch: Throwable -> L60
        goto L13
    L58:
        r2.close();
        r16.a();
        return r21;
    L60:
        th = th;
    L64:
        r2.close();
        r16.a();
        throw th;
    L62:
        th = th;
        r16 = r1;
        goto L64
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a
    public List<ConditionTaskBean> b(String r42) {
        c r0 = this;
        s r2 = s.a("SELECT * FROM condition_task_bean WHERE `source_from` =?", 1);
        if (r42 != null) goto L5;
        r2.a(1);
    L6:
        r0.f16902a.i();
        Cursor r1 = androidx.room.b.c.query(r0.f16902a, r2, false, null);
        int r3 = androidx.room.b.b.b(r1, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L66
        int r5 = androidx.room.b.b.b(r1, "actions");     // Catch: Throwable -> L66
        int r6 = androidx.room.b.b.b(r1, "name");     // Catch: Throwable -> L66
        int r7 = androidx.room.b.b.b(r1, "conditions");     // Catch: Throwable -> L66
        int r8 = androidx.room.b.b.b(r1, "periodicPolicy");     // Catch: Throwable -> L66
        int r9 = androidx.room.b.b.b(r1, "trigger_control_policy");     // Catch: Throwable -> L66
        int r10 = androidx.room.b.b.b(r1, "source_from");     // Catch: Throwable -> L66
        int r11 = androidx.room.b.b.b(r1, "task_status");     // Catch: Throwable -> L66
        int r12 = androidx.room.b.b.b(r1, "enable_status");     // Catch: Throwable -> L66
        int r13 = androidx.room.b.b.b(r1, "create_time");     // Catch: Throwable -> L66
        int r14 = androidx.room.b.b.b(r1, "display_order");     // Catch: Throwable -> L66
        int r15 = androidx.room.b.b.b(r1, "ext");     // Catch: Throwable -> L66
        int r4 = androidx.room.b.b.b(r1, "task_mode");     // Catch: Throwable -> L66
        s r16 = r2;
        int r17 = androidx.room.b.b.b(r1, "task_knowledge");     // Catch: Throwable -> L64
        int r18 = androidx.room.b.b.b(r1, "template_id");     // Catch: Throwable -> L64
        int r19 = androidx.room.b.b.b(r1, "omni_model");     // Catch: Throwable -> L64
        int r20 = r4;
        ArrayList r21 = new ArrayList(r1.getCount());     // Catch: Throwable -> L64
    L10:
        if (r1.moveToNext() == false) goto L62;
        if (r1.isNull(r3) == false) goto L15;
        String r22 = null;
    L17:
        if (r1.isNull(r5) == false) goto L19;
        String r23 = null;
    L20:
        List<ConditionTaskAction> r24 = r0.f16904c.c(r23);     // Catch: Throwable -> L64
        if (r1.isNull(r6) == false) goto L23;
        String r25 = null;
    L25:
        if (r1.isNull(r7) == false) goto L27;
        String r26 = null;
    L28:
        ConditionGroup r27 = r0.f16904c.a(r26);     // Catch: Throwable -> L64
        if (r1.isNull(r8) == false) goto L31;
        String r28 = null;
    L32:
        PeriodicPolicy r29 = r0.f16904c.b(r28);     // Catch: Throwable -> L64
        if (r1.isNull(r9) == false) goto L35;
        String r30 = null;
    L36:
        TriggerControlPolicy r210 = r0.f16904c.g(r30);     // Catch: Throwable -> L64
        if (r1.isNull(r10) == false) goto L39;
        String r211 = null;
    L40:
        int r212 = r1.getInt(r11);     // Catch: Throwable -> L64
        int r31 = r1.getInt(r12);     // Catch: Throwable -> L64
        long r32 = r1.getLong(r13);     // Catch: Throwable -> L64
        long r33 = r1.getLong(r14);     // Catch: Throwable -> L64
        if (r1.isNull(r15) == false) goto L43;
        String r34 = null;
    L44:
        Map<String, String> r35 = r0.f16904c.d(r34);     // Catch: Throwable -> L64
        r20 = r20;
        if (r1.isNull(r20) == false) goto L47;
        Integer r36 = null;
    L49:
        if (r1.isNull(r17) == false) goto L51;
        String r37 = null;
    L52:
        TaskKnowledge r38 = r0.f16904c.f(r37);     // Catch: Throwable -> L64
        int r39 = r18;
        if (r1.isNull(r39) == false) goto L55;
        String r310 = null;
    L57:
        if (r1.isNull(r19) == false) goto L59;
        String r311 = null;
    L60:
        r21.add(new ConditionTaskBean(r22, r24, r25, r27, r29, r210, r211, r212, r31, r32, r33, r35, r36, r38, r310, r311));     // Catch: Throwable -> L64
        r0 = this;
        r18 = r39;
        r19 = r19;
        r3 = r3;
        goto L10
    L59:
        r311 = r1.getString(r19);     // Catch: Throwable -> L64
        goto L60
    L55:
        r310 = r1.getString(r39);     // Catch: Throwable -> L64
        goto L57
    L51:
        r37 = r1.getString(r17);     // Catch: Throwable -> L64
        goto L52
    L47:
        r36 = Integer.valueOf(r1.getInt(r20));     // Catch: Throwable -> L64
        goto L49
    L43:
        r34 = r1.getString(r15);     // Catch: Throwable -> L64
        goto L44
    L39:
        r211 = r1.getString(r10);     // Catch: Throwable -> L64
        goto L40
    L35:
        r30 = r1.getString(r9);     // Catch: Throwable -> L64
        goto L36
    L31:
        r28 = r1.getString(r8);     // Catch: Throwable -> L64
        goto L32
    L27:
        r26 = r1.getString(r7);     // Catch: Throwable -> L64
        goto L28
    L23:
        r25 = r1.getString(r6);     // Catch: Throwable -> L64
        goto L25
    L19:
        r23 = r1.getString(r5);     // Catch: Throwable -> L64
        goto L20
    L15:
        r22 = r1.getString(r3);     // Catch: Throwable -> L64
        goto L17
    L62:
        r1.close();
        r16.a();
        return r21;
    L64:
        th = th;
    L68:
        r1.close();
        r16.a();
        throw th;
    L66:
        th = th;
        r16 = r2;
        goto L68
    L5:
        r2.a(1, r42);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a
    public List<ConditionTaskBean> a(String r41, int r42, int r43) {
        c r0 = this;
        s r2 = s.a("SELECT * FROM condition_task_bean WHERE `source_from` =? ORDER BY display_order DESC LIMIT ? OFFSET ?", 3);
        if (r41 != null) goto L5;
        r2.a(1);
    L6:
        r2.a(2, r43);
        r2.a(3, r42);
        r0.f16902a.i();
        Cursor r1 = androidx.room.b.c.query(r0.f16902a, r2, false, null);
        int r3 = androidx.room.b.b.b(r1, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L66
        int r5 = androidx.room.b.b.b(r1, "actions");     // Catch: Throwable -> L66
        int r6 = androidx.room.b.b.b(r1, "name");     // Catch: Throwable -> L66
        int r7 = androidx.room.b.b.b(r1, "conditions");     // Catch: Throwable -> L66
        int r8 = androidx.room.b.b.b(r1, "periodicPolicy");     // Catch: Throwable -> L66
        int r9 = androidx.room.b.b.b(r1, "trigger_control_policy");     // Catch: Throwable -> L66
        int r10 = androidx.room.b.b.b(r1, "source_from");     // Catch: Throwable -> L66
        int r11 = androidx.room.b.b.b(r1, "task_status");     // Catch: Throwable -> L66
        int r12 = androidx.room.b.b.b(r1, "enable_status");     // Catch: Throwable -> L66
        int r13 = androidx.room.b.b.b(r1, "create_time");     // Catch: Throwable -> L66
        int r14 = androidx.room.b.b.b(r1, "display_order");     // Catch: Throwable -> L66
        int r15 = androidx.room.b.b.b(r1, "ext");     // Catch: Throwable -> L66
        int r4 = androidx.room.b.b.b(r1, "task_mode");     // Catch: Throwable -> L66
        s r16 = r2;
        int r44 = androidx.room.b.b.b(r1, "task_knowledge");     // Catch: Throwable -> L64
        int r45 = androidx.room.b.b.b(r1, "template_id");     // Catch: Throwable -> L64
        int r17 = androidx.room.b.b.b(r1, "omni_model");     // Catch: Throwable -> L64
        int r18 = r4;
        ArrayList r19 = new ArrayList(r1.getCount());     // Catch: Throwable -> L64
    L10:
        if (r1.moveToNext() == false) goto L62;
        if (r1.isNull(r3) == false) goto L15;
        String r20 = null;
    L17:
        if (r1.isNull(r5) == false) goto L19;
        String r21 = null;
    L20:
        List<ConditionTaskAction> r22 = r0.f16904c.c(r21);     // Catch: Throwable -> L64
        if (r1.isNull(r6) == false) goto L23;
        String r23 = null;
    L25:
        if (r1.isNull(r7) == false) goto L27;
        String r24 = null;
    L28:
        ConditionGroup r25 = r0.f16904c.a(r24);     // Catch: Throwable -> L64
        if (r1.isNull(r8) == false) goto L31;
        String r26 = null;
    L32:
        PeriodicPolicy r27 = r0.f16904c.b(r26);     // Catch: Throwable -> L64
        if (r1.isNull(r9) == false) goto L35;
        String r28 = null;
    L36:
        TriggerControlPolicy r29 = r0.f16904c.g(r28);     // Catch: Throwable -> L64
        if (r1.isNull(r10) == false) goto L39;
        String r210 = null;
    L40:
        int r211 = r1.getInt(r11);     // Catch: Throwable -> L64
        int r212 = r1.getInt(r12);     // Catch: Throwable -> L64
        long r213 = r1.getLong(r13);     // Catch: Throwable -> L64
        long r31 = r1.getLong(r14);     // Catch: Throwable -> L64
        if (r1.isNull(r15) == false) goto L43;
        String r30 = null;
    L44:
        Map<String, String> r33 = r0.f16904c.d(r30);     // Catch: Throwable -> L64
        int r32 = r18;
        if (r1.isNull(r32) == false) goto L47;
        Integer r34 = null;
    L49:
        if (r1.isNull(r44) == false) goto L51;
        String r35 = null;
    L52:
        TaskKnowledge r36 = r0.f16904c.f(r35);     // Catch: Throwable -> L64
        int r37 = r45;
        if (r1.isNull(r37) == false) goto L55;
        String r38 = null;
    L57:
        if (r1.isNull(r17) == false) goto L59;
        String r39 = null;
    L60:
        r19.add(new ConditionTaskBean(r20, r22, r23, r25, r27, r29, r210, r211, r212, r213, r31, r33, r34, r36, r38, r39));     // Catch: Throwable -> L64
        r0 = this;
        r45 = r37;
        r17 = r17;
        r3 = r3;
        r18 = r32;
        r44 = r44;
        goto L10
    L59:
        r39 = r1.getString(r17);     // Catch: Throwable -> L64
        goto L60
    L55:
        r38 = r1.getString(r37);     // Catch: Throwable -> L64
        goto L57
    L51:
        r35 = r1.getString(r44);     // Catch: Throwable -> L64
        goto L52
    L47:
        r34 = Integer.valueOf(r1.getInt(r32));     // Catch: Throwable -> L64
        goto L49
    L43:
        r30 = r1.getString(r15);     // Catch: Throwable -> L64
        goto L44
    L39:
        r210 = r1.getString(r10);     // Catch: Throwable -> L64
        goto L40
    L35:
        r28 = r1.getString(r9);     // Catch: Throwable -> L64
        goto L36
    L31:
        r26 = r1.getString(r8);     // Catch: Throwable -> L64
        goto L32
    L27:
        r24 = r1.getString(r7);     // Catch: Throwable -> L64
        goto L28
    L23:
        r23 = r1.getString(r6);     // Catch: Throwable -> L64
        goto L25
    L19:
        r21 = r1.getString(r5);     // Catch: Throwable -> L64
        goto L20
    L15:
        r20 = r1.getString(r3);     // Catch: Throwable -> L64
        goto L17
    L62:
        r1.close();
        r16.a();
        return r19;
    L64:
        th = th;
    L68:
        r1.close();
        r16.a();
        throw th;
    L66:
        th = th;
        r16 = r2;
        goto L68
    L5:
        r2.a(1, r41);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a
    public List<ConditionTaskBean> c(String r42) {
        c r0 = this;
        s r2 = s.a("SELECT * FROM condition_task_bean WHERE `source_from` =? and json_extract(task_knowledge, '$.sessionId') IS NOT NULL", 1);
        if (r42 != null) goto L5;
        r2.a(1);
    L6:
        r0.f16902a.i();
        Cursor r1 = androidx.room.b.c.query(r0.f16902a, r2, false, null);
        int r3 = androidx.room.b.b.b(r1, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L66
        int r5 = androidx.room.b.b.b(r1, "actions");     // Catch: Throwable -> L66
        int r6 = androidx.room.b.b.b(r1, "name");     // Catch: Throwable -> L66
        int r7 = androidx.room.b.b.b(r1, "conditions");     // Catch: Throwable -> L66
        int r8 = androidx.room.b.b.b(r1, "periodicPolicy");     // Catch: Throwable -> L66
        int r9 = androidx.room.b.b.b(r1, "trigger_control_policy");     // Catch: Throwable -> L66
        int r10 = androidx.room.b.b.b(r1, "source_from");     // Catch: Throwable -> L66
        int r11 = androidx.room.b.b.b(r1, "task_status");     // Catch: Throwable -> L66
        int r12 = androidx.room.b.b.b(r1, "enable_status");     // Catch: Throwable -> L66
        int r13 = androidx.room.b.b.b(r1, "create_time");     // Catch: Throwable -> L66
        int r14 = androidx.room.b.b.b(r1, "display_order");     // Catch: Throwable -> L66
        int r15 = androidx.room.b.b.b(r1, "ext");     // Catch: Throwable -> L66
        int r4 = androidx.room.b.b.b(r1, "task_mode");     // Catch: Throwable -> L66
        s r16 = r2;
        int r17 = androidx.room.b.b.b(r1, "task_knowledge");     // Catch: Throwable -> L64
        int r18 = androidx.room.b.b.b(r1, "template_id");     // Catch: Throwable -> L64
        int r19 = androidx.room.b.b.b(r1, "omni_model");     // Catch: Throwable -> L64
        int r20 = r4;
        ArrayList r21 = new ArrayList(r1.getCount());     // Catch: Throwable -> L64
    L10:
        if (r1.moveToNext() == false) goto L62;
        if (r1.isNull(r3) == false) goto L15;
        String r22 = null;
    L17:
        if (r1.isNull(r5) == false) goto L19;
        String r23 = null;
    L20:
        List<ConditionTaskAction> r24 = r0.f16904c.c(r23);     // Catch: Throwable -> L64
        if (r1.isNull(r6) == false) goto L23;
        String r25 = null;
    L25:
        if (r1.isNull(r7) == false) goto L27;
        String r26 = null;
    L28:
        ConditionGroup r27 = r0.f16904c.a(r26);     // Catch: Throwable -> L64
        if (r1.isNull(r8) == false) goto L31;
        String r28 = null;
    L32:
        PeriodicPolicy r29 = r0.f16904c.b(r28);     // Catch: Throwable -> L64
        if (r1.isNull(r9) == false) goto L35;
        String r30 = null;
    L36:
        TriggerControlPolicy r210 = r0.f16904c.g(r30);     // Catch: Throwable -> L64
        if (r1.isNull(r10) == false) goto L39;
        String r211 = null;
    L40:
        int r212 = r1.getInt(r11);     // Catch: Throwable -> L64
        int r31 = r1.getInt(r12);     // Catch: Throwable -> L64
        long r32 = r1.getLong(r13);     // Catch: Throwable -> L64
        long r33 = r1.getLong(r14);     // Catch: Throwable -> L64
        if (r1.isNull(r15) == false) goto L43;
        String r34 = null;
    L44:
        Map<String, String> r35 = r0.f16904c.d(r34);     // Catch: Throwable -> L64
        r20 = r20;
        if (r1.isNull(r20) == false) goto L47;
        Integer r36 = null;
    L49:
        if (r1.isNull(r17) == false) goto L51;
        String r37 = null;
    L52:
        TaskKnowledge r38 = r0.f16904c.f(r37);     // Catch: Throwable -> L64
        int r39 = r18;
        if (r1.isNull(r39) == false) goto L55;
        String r310 = null;
    L57:
        if (r1.isNull(r19) == false) goto L59;
        String r311 = null;
    L60:
        r21.add(new ConditionTaskBean(r22, r24, r25, r27, r29, r210, r211, r212, r31, r32, r33, r35, r36, r38, r310, r311));     // Catch: Throwable -> L64
        r0 = this;
        r18 = r39;
        r19 = r19;
        r3 = r3;
        goto L10
    L59:
        r311 = r1.getString(r19);     // Catch: Throwable -> L64
        goto L60
    L55:
        r310 = r1.getString(r39);     // Catch: Throwable -> L64
        goto L57
    L51:
        r37 = r1.getString(r17);     // Catch: Throwable -> L64
        goto L52
    L47:
        r36 = Integer.valueOf(r1.getInt(r20));     // Catch: Throwable -> L64
        goto L49
    L43:
        r34 = r1.getString(r15);     // Catch: Throwable -> L64
        goto L44
    L39:
        r211 = r1.getString(r10);     // Catch: Throwable -> L64
        goto L40
    L35:
        r30 = r1.getString(r9);     // Catch: Throwable -> L64
        goto L36
    L31:
        r28 = r1.getString(r8);     // Catch: Throwable -> L64
        goto L32
    L27:
        r26 = r1.getString(r7);     // Catch: Throwable -> L64
        goto L28
    L23:
        r25 = r1.getString(r6);     // Catch: Throwable -> L64
        goto L25
    L19:
        r23 = r1.getString(r5);     // Catch: Throwable -> L64
        goto L20
    L15:
        r22 = r1.getString(r3);     // Catch: Throwable -> L64
        goto L17
    L62:
        r1.close();
        r16.a();
        return r21;
    L64:
        th = th;
    L68:
        r1.close();
        r16.a();
        throw th;
    L66:
        th = th;
        r16 = r2;
        goto L68
    L5:
        r2.a(1, r42);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a
    public List<ConditionTaskBean> d(String r42) {
        c r0 = this;
        s r2 = s.a("SELECT * FROM condition_task_bean WHERE `source_from` =? and template_id IS NOT NULL", 1);
        if (r42 != null) goto L5;
        r2.a(1);
    L6:
        r0.f16902a.i();
        Cursor r1 = androidx.room.b.c.query(r0.f16902a, r2, false, null);
        int r3 = androidx.room.b.b.b(r1, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L66
        int r5 = androidx.room.b.b.b(r1, "actions");     // Catch: Throwable -> L66
        int r6 = androidx.room.b.b.b(r1, "name");     // Catch: Throwable -> L66
        int r7 = androidx.room.b.b.b(r1, "conditions");     // Catch: Throwable -> L66
        int r8 = androidx.room.b.b.b(r1, "periodicPolicy");     // Catch: Throwable -> L66
        int r9 = androidx.room.b.b.b(r1, "trigger_control_policy");     // Catch: Throwable -> L66
        int r10 = androidx.room.b.b.b(r1, "source_from");     // Catch: Throwable -> L66
        int r11 = androidx.room.b.b.b(r1, "task_status");     // Catch: Throwable -> L66
        int r12 = androidx.room.b.b.b(r1, "enable_status");     // Catch: Throwable -> L66
        int r13 = androidx.room.b.b.b(r1, "create_time");     // Catch: Throwable -> L66
        int r14 = androidx.room.b.b.b(r1, "display_order");     // Catch: Throwable -> L66
        int r15 = androidx.room.b.b.b(r1, "ext");     // Catch: Throwable -> L66
        int r4 = androidx.room.b.b.b(r1, "task_mode");     // Catch: Throwable -> L66
        s r16 = r2;
        int r17 = androidx.room.b.b.b(r1, "task_knowledge");     // Catch: Throwable -> L64
        int r18 = androidx.room.b.b.b(r1, "template_id");     // Catch: Throwable -> L64
        int r19 = androidx.room.b.b.b(r1, "omni_model");     // Catch: Throwable -> L64
        int r20 = r4;
        ArrayList r21 = new ArrayList(r1.getCount());     // Catch: Throwable -> L64
    L10:
        if (r1.moveToNext() == false) goto L62;
        if (r1.isNull(r3) == false) goto L15;
        String r22 = null;
    L17:
        if (r1.isNull(r5) == false) goto L19;
        String r23 = null;
    L20:
        List<ConditionTaskAction> r24 = r0.f16904c.c(r23);     // Catch: Throwable -> L64
        if (r1.isNull(r6) == false) goto L23;
        String r25 = null;
    L25:
        if (r1.isNull(r7) == false) goto L27;
        String r26 = null;
    L28:
        ConditionGroup r27 = r0.f16904c.a(r26);     // Catch: Throwable -> L64
        if (r1.isNull(r8) == false) goto L31;
        String r28 = null;
    L32:
        PeriodicPolicy r29 = r0.f16904c.b(r28);     // Catch: Throwable -> L64
        if (r1.isNull(r9) == false) goto L35;
        String r30 = null;
    L36:
        TriggerControlPolicy r210 = r0.f16904c.g(r30);     // Catch: Throwable -> L64
        if (r1.isNull(r10) == false) goto L39;
        String r211 = null;
    L40:
        int r212 = r1.getInt(r11);     // Catch: Throwable -> L64
        int r31 = r1.getInt(r12);     // Catch: Throwable -> L64
        long r32 = r1.getLong(r13);     // Catch: Throwable -> L64
        long r33 = r1.getLong(r14);     // Catch: Throwable -> L64
        if (r1.isNull(r15) == false) goto L43;
        String r34 = null;
    L44:
        Map<String, String> r35 = r0.f16904c.d(r34);     // Catch: Throwable -> L64
        r20 = r20;
        if (r1.isNull(r20) == false) goto L47;
        Integer r36 = null;
    L49:
        if (r1.isNull(r17) == false) goto L51;
        String r37 = null;
    L52:
        TaskKnowledge r38 = r0.f16904c.f(r37);     // Catch: Throwable -> L64
        int r39 = r18;
        if (r1.isNull(r39) == false) goto L55;
        String r310 = null;
    L57:
        if (r1.isNull(r19) == false) goto L59;
        String r311 = null;
    L60:
        r21.add(new ConditionTaskBean(r22, r24, r25, r27, r29, r210, r211, r212, r31, r32, r33, r35, r36, r38, r310, r311));     // Catch: Throwable -> L64
        r0 = this;
        r18 = r39;
        r19 = r19;
        r3 = r3;
        goto L10
    L59:
        r311 = r1.getString(r19);     // Catch: Throwable -> L64
        goto L60
    L55:
        r310 = r1.getString(r39);     // Catch: Throwable -> L64
        goto L57
    L51:
        r37 = r1.getString(r17);     // Catch: Throwable -> L64
        goto L52
    L47:
        r36 = Integer.valueOf(r1.getInt(r20));     // Catch: Throwable -> L64
        goto L49
    L43:
        r34 = r1.getString(r15);     // Catch: Throwable -> L64
        goto L44
    L39:
        r211 = r1.getString(r10);     // Catch: Throwable -> L64
        goto L40
    L35:
        r30 = r1.getString(r9);     // Catch: Throwable -> L64
        goto L36
    L31:
        r28 = r1.getString(r8);     // Catch: Throwable -> L64
        goto L32
    L27:
        r26 = r1.getString(r7);     // Catch: Throwable -> L64
        goto L28
    L23:
        r25 = r1.getString(r6);     // Catch: Throwable -> L64
        goto L25
    L19:
        r23 = r1.getString(r5);     // Catch: Throwable -> L64
        goto L20
    L15:
        r22 = r1.getString(r3);     // Catch: Throwable -> L64
        goto L17
    L62:
        r1.close();
        r16.a();
        return r21;
    L64:
        th = th;
    L68:
        r1.close();
        r16.a();
        throw th;
    L66:
        th = th;
        r16 = r2;
        goto L68
    L5:
        r2.a(1, r42);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a
    public List<ConditionTaskBean> a(int r42, int r43) {
        c r0 = this;
        s r1 = s.a("SELECT * FROM condition_task_bean ORDER BY display_order DESC LIMIT ? OFFSET ?", 2);
        r1.a(1, r43);
        r1.a(2, r42);
        r0.f16902a.i();
        Cursor r2 = androidx.room.b.c.query(r0.f16902a, r1, false, null);
        int r3 = androidx.room.b.b.b(r2, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L62
        int r5 = androidx.room.b.b.b(r2, "actions");     // Catch: Throwable -> L62
        int r6 = androidx.room.b.b.b(r2, "name");     // Catch: Throwable -> L62
        int r7 = androidx.room.b.b.b(r2, "conditions");     // Catch: Throwable -> L62
        int r8 = androidx.room.b.b.b(r2, "periodicPolicy");     // Catch: Throwable -> L62
        int r9 = androidx.room.b.b.b(r2, "trigger_control_policy");     // Catch: Throwable -> L62
        int r10 = androidx.room.b.b.b(r2, "source_from");     // Catch: Throwable -> L62
        int r11 = androidx.room.b.b.b(r2, "task_status");     // Catch: Throwable -> L62
        int r12 = androidx.room.b.b.b(r2, "enable_status");     // Catch: Throwable -> L62
        int r13 = androidx.room.b.b.b(r2, "create_time");     // Catch: Throwable -> L62
        int r14 = androidx.room.b.b.b(r2, "display_order");     // Catch: Throwable -> L62
        int r15 = androidx.room.b.b.b(r2, "ext");     // Catch: Throwable -> L62
        int r4 = androidx.room.b.b.b(r2, "task_mode");     // Catch: Throwable -> L62
        s r16 = r1;
        int r44 = androidx.room.b.b.b(r2, "task_knowledge");     // Catch: Throwable -> L60
        int r17 = androidx.room.b.b.b(r2, "template_id");     // Catch: Throwable -> L60
        int r18 = androidx.room.b.b.b(r2, "omni_model");     // Catch: Throwable -> L60
        int r19 = r4;
        ArrayList r20 = new ArrayList(r2.getCount());     // Catch: Throwable -> L60
    L6:
        if (r2.moveToNext() == false) goto L58;
        if (r2.isNull(r3) == false) goto L11;
        String r21 = null;
    L13:
        if (r2.isNull(r5) == false) goto L15;
        String r22 = null;
    L16:
        List<ConditionTaskAction> r23 = r0.f16904c.c(r22);     // Catch: Throwable -> L60
        if (r2.isNull(r6) == false) goto L19;
        String r24 = null;
    L21:
        if (r2.isNull(r7) == false) goto L23;
        String r25 = null;
    L24:
        ConditionGroup r26 = r0.f16904c.a(r25);     // Catch: Throwable -> L60
        if (r2.isNull(r8) == false) goto L27;
        String r27 = null;
    L28:
        PeriodicPolicy r28 = r0.f16904c.b(r27);     // Catch: Throwable -> L60
        if (r2.isNull(r9) == false) goto L31;
        String r29 = null;
    L32:
        TriggerControlPolicy r210 = r0.f16904c.g(r29);     // Catch: Throwable -> L60
        if (r2.isNull(r10) == false) goto L35;
        String r211 = null;
    L36:
        int r212 = r2.getInt(r11);     // Catch: Throwable -> L60
        int r213 = r2.getInt(r12);     // Catch: Throwable -> L60
        long r30 = r2.getLong(r13);     // Catch: Throwable -> L60
        long r32 = r2.getLong(r14);     // Catch: Throwable -> L60
        if (r2.isNull(r15) == false) goto L39;
        String r31 = null;
    L40:
        Map<String, String> r34 = r0.f16904c.d(r31);     // Catch: Throwable -> L60
        int r33 = r19;
        if (r2.isNull(r33) == false) goto L43;
        Integer r35 = null;
    L45:
        if (r2.isNull(r44) == false) goto L47;
        String r36 = null;
    L48:
        TaskKnowledge r37 = r0.f16904c.f(r36);     // Catch: Throwable -> L60
        int r38 = r17;
        if (r2.isNull(r38) == false) goto L51;
        String r39 = null;
    L53:
        if (r2.isNull(r18) == false) goto L55;
        String r310 = null;
    L56:
        r20.add(new ConditionTaskBean(r21, r23, r24, r26, r28, r210, r211, r212, r213, r30, r32, r34, r35, r37, r39, r310));     // Catch: Throwable -> L60
        r0 = this;
        r17 = r38;
        r18 = r18;
        r3 = r3;
        r19 = r33;
        r44 = r44;
        goto L6
    L55:
        r310 = r2.getString(r18);     // Catch: Throwable -> L60
        goto L56
    L51:
        r39 = r2.getString(r38);     // Catch: Throwable -> L60
        goto L53
    L47:
        r36 = r2.getString(r44);     // Catch: Throwable -> L60
        goto L48
    L43:
        r35 = Integer.valueOf(r2.getInt(r33));     // Catch: Throwable -> L60
        goto L45
    L39:
        r31 = r2.getString(r15);     // Catch: Throwable -> L60
        goto L40
    L35:
        r211 = r2.getString(r10);     // Catch: Throwable -> L60
        goto L36
    L31:
        r29 = r2.getString(r9);     // Catch: Throwable -> L60
        goto L32
    L27:
        r27 = r2.getString(r8);     // Catch: Throwable -> L60
        goto L28
    L23:
        r25 = r2.getString(r7);     // Catch: Throwable -> L60
        goto L24
    L19:
        r24 = r2.getString(r6);     // Catch: Throwable -> L60
        goto L21
    L15:
        r22 = r2.getString(r5);     // Catch: Throwable -> L60
        goto L16
    L11:
        r21 = r2.getString(r3);     // Catch: Throwable -> L60
        goto L13
    L58:
        r2.close();
        r16.a();
        return r20;
    L60:
        th = th;
    L64:
        r2.close();
        r16.a();
        throw th;
    L62:
        th = th;
        r16 = r1;
        goto L64
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a
    public Long b() {
        s r0 = s.a("SELECT MIN(display_order) FROM condition_task_bean", 0);
        this.f16902a.i();
        Long r2 = null;
        Cursor r4 = androidx.room.b.c.query(this.f16902a, r0, false, null);
    L12:
        th = move-exception;
        r4.close();
        r0.a();
        throw th;
    L4:
        if (r4.moveToFirst() == true) goto L6;
    L10:
        r4.close();
        r0.a();
        return r2;
    L6:
        if (r4.isNull(0) == true) goto L10;
        r2 = Long.valueOf(r4.getLong(0));     // Catch: Throwable -> L12
        goto L10
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a
    public List<Long> a(String r7, List<String> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        StringBuilder r0 = androidx.room.b.f.a();
        r0.append("SELECT display_order FROM condition_task_bean WHERE task_id IN (");
        int r2 = r9.size();
        androidx.room.b.f.a(r0, r2);
        r0.append(") AND source_from = ");
        r0.append("?");
        r0.append(" ORDER BY display_order DESC");
        int r3 = 1;
        int r4 = r2 + 1;
        s r1 = s.a(r0.toString(), r4);
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L8;
        r1.a(r3);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        r1.a(r3, r5);
        goto L9
    L10:
        if (r7 != null) goto L12;
        r1.a(r4);
    L13:
        this.f16902a.i();
        Cursor r6 = androidx.room.b.c.query(this.f16902a, r1, false, null);
        ArrayList r11 = new ArrayList(r6.getCount());     // Catch: Throwable -> L25
    L15:
        if (r6.moveToNext() == false) goto L23;
        if (r6.isNull(0) == false) goto L20;
        Long r12 = null;
    L21:
        r11.add(r12);     // Catch: Throwable -> L25
        goto L15
    L20:
        r12 = Long.valueOf(r6.getLong(0));     // Catch: Throwable -> L25
        goto L21
    L23:
        r6.close();
        r1.a();
        return r11;
    L25:
        th = move-exception;
        r6.close();
        r1.a();
        throw th;
    L12:
        r1.a(r4, r7);
        goto L13
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }
}
