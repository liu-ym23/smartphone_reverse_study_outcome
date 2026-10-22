package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a;

import android.database.Cursor;
import androidx.room.p;
import androidx.room.s;
import androidx.room.v;
import androidx.sqlite.db.g;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.bean.ConditionTaskRecordBean;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ConditionTaskRecordDao_EventTaskDatabase_Impl.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f16911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.room.f<ConditionTaskRecordBean> f16912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v f16913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final v f16914d;

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d
    public long insert(ConditionTaskRecordBean r3) {
        this.f16911a.i();
        this.f16911a.j();
        long r0 = this.f16912b.a(r3);     // Catch: Throwable -> L6
        this.f16911a.m();     // Catch: Throwable -> L6
        this.f16911a.k();
        return r0;
    L6:
        th = move-exception;
        this.f16911a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d
    public List<Long> a(List<ConditionTaskRecordBean> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.f16911a.i();
        this.f16911a.j();
        List<Long> r5 = this.f16912b.a(r4);     // Catch: Throwable -> L6
        this.f16911a.m();     // Catch: Throwable -> L6
        this.f16911a.k();
        return r5;
    L6:
        th = move-exception;
        this.f16911a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d
    public int b(String r3) {
        this.f16911a.i();
        g r0 = this.f16913c.c();
        if (r3 != null) goto L5;
        r0.a(1);
    L6:
        this.f16911a.j();
        int r4 = r0.a();     // Catch: Throwable -> L10
        this.f16911a.m();     // Catch: Throwable -> L10
        this.f16911a.k();
        this.f16913c.a(r0);
        return r4;
    L10:
        th = move-exception;
        this.f16911a.k();
        this.f16913c.a(r0);
        throw th;
    L5:
        r0.a(1, r3);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d
    public int c(String r3) {
        this.f16911a.i();
        g r0 = this.f16914d.c();
        if (r3 != null) goto L5;
        r0.a(1);
    L6:
        this.f16911a.j();
        int r4 = r0.a();     // Catch: Throwable -> L10
        this.f16911a.m();     // Catch: Throwable -> L10
        this.f16911a.k();
        this.f16914d.a(r0);
        return r4;
    L10:
        th = move-exception;
        this.f16911a.k();
        this.f16914d.a(r0);
        throw th;
    L5:
        r0.a(1, r3);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d
    public List<ConditionTaskRecordBean> a(int r22, int r23) {
        s r1 = s.a("SELECT * FROM condition_task_record_bean ORDER BY id ASC LIMIT ? OFFSET ?", 2);
        r1.a(1, r23);
        r1.a(2, r22);
        this.f16911a.i();
        Cursor r2 = androidx.room.b.c.query(this.f16911a, r1, false, null);
        int r0 = androidx.room.b.b.b(r2, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L18
        int r4 = androidx.room.b.b.b(r2, "trigger_time");     // Catch: Throwable -> L18
        int r5 = androidx.room.b.b.b(r2, "source_from");     // Catch: Throwable -> L18
        int r6 = androidx.room.b.b.b(r2, "result");     // Catch: Throwable -> L18
        int r7 = androidx.room.b.b.b(r2, "create_time");     // Catch: Throwable -> L18
        int r8 = androidx.room.b.b.b(r2, DbHelper.COL_ID);     // Catch: Throwable -> L18
        ArrayList r9 = new ArrayList(r2.getCount());     // Catch: Throwable -> L18
    L4:
        if (r2.moveToNext() == false) goto L16;
        if (r2.isNull(r0) == false) goto L9;
        String r12 = null;
    L10:
        long r13 = r2.getLong(r4);     // Catch: Throwable -> L18
        if (r2.isNull(r5) == false) goto L13;
        String r15 = null;
    L14:
        r9.add(new ConditionTaskRecordBean(r12, r13, r15, r2.getInt(r6), r2.getLong(r7), r2.getLong(r8)));     // Catch: Throwable -> L18
        goto L4
    L13:
        r15 = r2.getString(r5);     // Catch: Throwable -> L18
        goto L14
    L9:
        r12 = r2.getString(r0);     // Catch: Throwable -> L18
        goto L10
    L16:
        r2.close();
        r1.a();
        return r9;
    L18:
        th = move-exception;
        r2.close();
        r1.a();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d
    public List<ConditionTaskRecordBean> a(long r22, long r24, String r26) {
        s r2 = s.a("SELECT * FROM condition_task_record_bean WHERE trigger_time BETWEEN ? AND ? AND source_from = ?", 3);
        r2.a(1, r22);
        r2.a(2, r24);
        if (r26 != null) goto L5;
        r2.a(3);
    L6:
        this.f16911a.i();
        Cursor r1 = androidx.room.b.c.query(this.f16911a, r2, false, null);
        int r0 = androidx.room.b.b.b(r1, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L22
        int r4 = androidx.room.b.b.b(r1, "trigger_time");     // Catch: Throwable -> L22
        int r5 = androidx.room.b.b.b(r1, "source_from");     // Catch: Throwable -> L22
        int r6 = androidx.room.b.b.b(r1, "result");     // Catch: Throwable -> L22
        int r7 = androidx.room.b.b.b(r1, "create_time");     // Catch: Throwable -> L22
        int r8 = androidx.room.b.b.b(r1, DbHelper.COL_ID);     // Catch: Throwable -> L22
        ArrayList r9 = new ArrayList(r1.getCount());     // Catch: Throwable -> L22
    L8:
        if (r1.moveToNext() == false) goto L20;
        if (r1.isNull(r0) == false) goto L13;
        String r12 = null;
    L14:
        long r13 = r1.getLong(r4);     // Catch: Throwable -> L22
        if (r1.isNull(r5) == false) goto L17;
        String r15 = null;
    L18:
        r9.add(new ConditionTaskRecordBean(r12, r13, r15, r1.getInt(r6), r1.getLong(r7), r1.getLong(r8)));     // Catch: Throwable -> L22
        goto L8
    L17:
        r15 = r1.getString(r5);     // Catch: Throwable -> L22
        goto L18
    L13:
        r12 = r1.getString(r0);     // Catch: Throwable -> L22
        goto L14
    L20:
        r1.close();
        r2.a();
        return r9;
    L22:
        th = move-exception;
        r1.close();
        r2.a();
        throw th;
    L5:
        r2.a(3, r26);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d
    public Long a(String r4) {
        s r0 = s.a("SELECT MAX(trigger_time) FROM condition_task_record_bean WHERE task_id = ?", 1);
        if (r4 != null) goto L5;
        r0.a(1);
    L6:
        this.f16911a.i();
        Long r1 = null;
        Cursor r3 = androidx.room.b.c.query(this.f16911a, r0, false, null);
    L16:
        th = move-exception;
        r3.close();
        r0.a();
        throw th;
    L8:
        if (r3.moveToFirst() == true) goto L10;
    L14:
        r3.close();
        r0.a();
        return r1;
    L10:
        if (r3.isNull(0) == true) goto L14;
        r1 = Long.valueOf(r3.getLong(0));     // Catch: Throwable -> L16
        goto L14
    L5:
        r0.a(1, r4);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d
    public List<ConditionTaskRecordBean> a(String r23, long r24, long r26, String r28) {
        s r3 = s.a("SELECT * FROM condition_task_record_bean WHERE trigger_time BETWEEN ? AND ? AND source_from = ? AND task_id = ?", 4);
        r3.a(1, r24);
        r3.a(2, r26);
        if (r28 != null) goto L5;
        r3.a(3);
    L6:
        if (r23 != null) goto L8;
        r3.a(4);
    L9:
        this.f16911a.i();
        this.f16911a.j();
        Cursor r2 = androidx.room.b.c.query(this.f16911a, r3, false, null);     // Catch: Throwable -> L30
        int r0 = androidx.room.b.b.b(r2, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L27
        int r5 = androidx.room.b.b.b(r2, "trigger_time");     // Catch: Throwable -> L27
        int r6 = androidx.room.b.b.b(r2, "source_from");     // Catch: Throwable -> L27
        int r7 = androidx.room.b.b.b(r2, "result");     // Catch: Throwable -> L27
        int r8 = androidx.room.b.b.b(r2, "create_time");     // Catch: Throwable -> L27
        int r9 = androidx.room.b.b.b(r2, DbHelper.COL_ID);     // Catch: Throwable -> L27
        ArrayList r10 = new ArrayList(r2.getCount());     // Catch: Throwable -> L27
    L13:
        if (r2.moveToNext() == false) goto L23;
        if (r2.isNull(r0) == false) goto L17;
        String r13 = null;
    L18:
        long r14 = r2.getLong(r5);     // Catch: Throwable -> L27
        if (r2.isNull(r6) == false) goto L21;
        String r16 = null;
    L22:
        r10.add(new ConditionTaskRecordBean(r13, r14, r16, r2.getInt(r7), r2.getLong(r8), r2.getLong(r9)));     // Catch: Throwable -> L27
        goto L13
    L21:
        r16 = r2.getString(r6);     // Catch: Throwable -> L27
        goto L22
    L17:
        r13 = r2.getString(r0);     // Catch: Throwable -> L27
        goto L18
    L23:
        this.f16911a.m();     // Catch: Throwable -> L27
        r2.close();     // Catch: Throwable -> L30
        r3.a();     // Catch: Throwable -> L30
        this.f16911a.k();
        return r10;
    L27:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L30
        r3.a();     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        this.f16911a.k();
        throw th;
    L8:
        r3.a(4, r23);
        goto L9
    L5:
        r3.a(3, r28);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d
    public int a(List<Long> r5, String r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.f16911a.i();
        StringBuilder r0 = androidx.room.b.f.a();
        r0.append("DELETE FROM condition_task_record_bean WHERE source_from = ");
        r0.append("?");
        r0.append(" AND id IN (");
        androidx.room.b.f.a(r0, r7.size());
        r0.append(")");
        String r1 = r0.toString();
        g r2 = this.f16911a.a(r1);
        if (r6 != null) goto L5;
        r2.a(1);
    L6:
        int r8 = 2;
        Iterator r9 = r7.iterator();
    L8:
        if (r9.hasNext() == false) goto L14;
        Long r3 = (Long) ZeusTransformUtils.preCheckCast(r9.next(), Long.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L12;
        r2.a(r8);
    L13:
        r8 = r8 + 1;
        goto L8
    L12:
        r2.a(r8, r3.longValue());
        goto L13
    L14:
        this.f16911a.j();
        int r10 = r2.a();     // Catch: Throwable -> L18
        this.f16911a.m();     // Catch: Throwable -> L18
        this.f16911a.k();
        return r10;
    L18:
        th = move-exception;
        this.f16911a.k();
        throw th;
    L5:
        r2.a(1, r6);
        goto L6
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }
}
