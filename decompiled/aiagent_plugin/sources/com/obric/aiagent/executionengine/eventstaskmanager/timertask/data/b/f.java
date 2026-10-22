package com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b;

import android.database.Cursor;
import androidx.room.p;
import androidx.room.s;
import androidx.room.v;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.bean.TimerTaskRecordBean;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TimerTaskRecordDao_TimerTaskDatabase_Impl.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f17941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.room.f<TimerTaskRecordBean> f17942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final androidx.room.e<TimerTaskRecordBean> f17943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final v f17944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final v f17945e;

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.d
    public long insert(TimerTaskRecordBean r3) {
        this.f17941a.i();
        this.f17941a.j();
        long r0 = this.f17942b.a(r3);     // Catch: Throwable -> L6
        this.f17941a.m();     // Catch: Throwable -> L6
        this.f17941a.k();
        return r0;
    L6:
        th = move-exception;
        this.f17941a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.d
    public void delete(TimerTaskRecordBean r2) {
        this.f17941a.i();
        this.f17941a.j();
        this.f17943c.a(r2);     // Catch: Throwable -> L6
        this.f17941a.m();     // Catch: Throwable -> L6
        this.f17941a.k();
        return;
    L6:
        th = move-exception;
        this.f17941a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.d
    public int a(String r3) {
        this.f17941a.i();
        androidx.sqlite.db.g r0 = this.f17944d.c();
        if (r3 != null) goto L5;
        r0.a(1);
    L6:
        this.f17941a.j();
        int r4 = r0.a();     // Catch: Throwable -> L10
        this.f17941a.m();     // Catch: Throwable -> L10
        this.f17941a.k();
        this.f17944d.a(r0);
        return r4;
    L10:
        th = move-exception;
        this.f17941a.k();
        this.f17944d.a(r0);
        throw th;
    L5:
        r0.a(1, r3);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.d
    public int a(int r4) {
        this.f17941a.i();
        androidx.sqlite.db.g r0 = this.f17945e.c();
        r0.a(1, r4);
        this.f17941a.j();
        int r5 = r0.a();     // Catch: Throwable -> L6
        this.f17941a.m();     // Catch: Throwable -> L6
        this.f17941a.k();
        this.f17945e.a(r0);
        return r5;
    L6:
        th = move-exception;
        this.f17941a.k();
        this.f17945e.a(r0);
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.d
    public List<TimerTaskRecordBean> a(long r22, long r24, String r26) {
        s r2 = s.a("SELECT * FROM timer_task_record_bean WHERE trigger_time BETWEEN ? AND ? AND target_package = ?", 3);
        r2.a(1, r22);
        r2.a(2, r24);
        if (r26 != null) goto L5;
        r2.a(3);
    L6:
        this.f17941a.i();
        Cursor r1 = androidx.room.b.c.query(this.f17941a, r2, false, null);
        int r0 = androidx.room.b.b.b(r1, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L26
        int r4 = androidx.room.b.b.b(r1, "trigger_time");     // Catch: Throwable -> L26
        int r5 = androidx.room.b.b.b(r1, "real_action_time");     // Catch: Throwable -> L26
        int r6 = androidx.room.b.b.b(r1, "source_from");     // Catch: Throwable -> L26
        int r7 = androidx.room.b.b.b(r1, "target_package");     // Catch: Throwable -> L26
        int r8 = androidx.room.b.b.b(r1, DbHelper.COL_ID);     // Catch: Throwable -> L26
        int r9 = androidx.room.b.b.b(r1, "task_status");     // Catch: Throwable -> L26
        ArrayList r10 = new ArrayList(r1.getCount());     // Catch: Throwable -> L26
    L8:
        if (r1.moveToNext() == false) goto L24;
        int r13 = r1.getInt(r0);     // Catch: Throwable -> L26
        long r14 = r1.getLong(r4);     // Catch: Throwable -> L26
        if (r1.isNull(r5) == false) goto L13;
        Long r16 = null;
    L15:
        if (r1.isNull(r6) == false) goto L17;
        String r17 = null;
    L19:
        if (r1.isNull(r7) == false) goto L21;
        String r18 = null;
    L22:
        r10.add(new TimerTaskRecordBean(r13, r14, r16, r17, r18, r1.getInt(r8), r1.getInt(r9)));     // Catch: Throwable -> L26
        goto L8
    L21:
        r18 = r1.getString(r7);     // Catch: Throwable -> L26
        goto L22
    L17:
        r17 = r1.getString(r6);     // Catch: Throwable -> L26
        goto L19
    L13:
        r16 = Long.valueOf(r1.getLong(r5));     // Catch: Throwable -> L26
        goto L15
    L24:
        r1.close();
        r2.a();
        return r10;
    L26:
        th = move-exception;
        r1.close();
        r2.a();
        throw th;
    L5:
        r2.a(3, r26);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.d
    public List<TimerTaskRecordBean> a(int r23, long r24, long r26, String r28) {
        s r2 = s.a("SELECT * FROM timer_task_record_bean WHERE trigger_time BETWEEN ? AND ? AND target_package = ? AND task_id = ?", 4);
        r2.a(1, r24);
        r2.a(2, r26);
        if (r28 != null) goto L5;
        r2.a(3);
    L6:
        r2.a(4, r23);
        this.f17941a.i();
        this.f17941a.j();
        Cursor r3 = androidx.room.b.c.query(this.f17941a, r2, false, null);     // Catch: Throwable -> L31
        int r0 = androidx.room.b.b.b(r3, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L28
        int r5 = androidx.room.b.b.b(r3, "trigger_time");     // Catch: Throwable -> L28
        int r6 = androidx.room.b.b.b(r3, "real_action_time");     // Catch: Throwable -> L28
        int r7 = androidx.room.b.b.b(r3, "source_from");     // Catch: Throwable -> L28
        int r8 = androidx.room.b.b.b(r3, "target_package");     // Catch: Throwable -> L28
        int r9 = androidx.room.b.b.b(r3, DbHelper.COL_ID);     // Catch: Throwable -> L28
        int r10 = androidx.room.b.b.b(r3, "task_status");     // Catch: Throwable -> L28
        ArrayList r11 = new ArrayList(r3.getCount());     // Catch: Throwable -> L28
    L10:
        if (r3.moveToNext() == false) goto L24;
        int r14 = r3.getInt(r0);     // Catch: Throwable -> L28
        long r15 = r3.getLong(r5);     // Catch: Throwable -> L28
        if (r3.isNull(r6) == false) goto L14;
        Long r17 = null;
    L16:
        if (r3.isNull(r7) == false) goto L18;
        String r18 = null;
    L20:
        if (r3.isNull(r8) == false) goto L22;
        String r19 = null;
    L23:
        r11.add(new TimerTaskRecordBean(r14, r15, r17, r18, r19, r3.getInt(r9), r3.getInt(r10)));     // Catch: Throwable -> L28
        goto L10
    L22:
        r19 = r3.getString(r8);     // Catch: Throwable -> L28
        goto L23
    L18:
        r18 = r3.getString(r7);     // Catch: Throwable -> L28
        goto L20
    L14:
        r17 = Long.valueOf(r3.getLong(r6));     // Catch: Throwable -> L28
        goto L16
    L24:
        this.f17941a.m();     // Catch: Throwable -> L28
        r3.close();     // Catch: Throwable -> L31
        r2.a();     // Catch: Throwable -> L31
        this.f17941a.k();
        return r11;
    L28:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L31
        r2.a();     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        this.f17941a.k();
        throw th;
    L5:
        r2.a(3, r28);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.d
    public int a(List<Integer> r5, String r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.f17941a.i();
        StringBuilder r0 = androidx.room.b.f.a();
        r0.append("DELETE FROM timer_task_record_bean WHERE target_package = ");
        r0.append("?");
        r0.append(" AND id IN (");
        androidx.room.b.f.a(r0, r7.size());
        r0.append(")");
        androidx.sqlite.db.g r1 = this.f17941a.a(r0.toString());
        if (r6 != null) goto L5;
        r1.a(1);
    L6:
        int r8 = 2;
        Iterator r9 = r7.iterator();
    L8:
        if (r9.hasNext() == false) goto L14;
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(r9.next(), Integer.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L12;
        r1.a(r8);
    L13:
        r8 = r8 + 1;
        goto L8
    L12:
        r1.a(r8, r2.intValue());
        goto L13
    L14:
        this.f17941a.j();
        int r10 = r1.a();     // Catch: Throwable -> L18
        this.f17941a.m();     // Catch: Throwable -> L18
        this.f17941a.k();
        return r10;
    L18:
        th = move-exception;
        this.f17941a.k();
        throw th;
    L5:
        r1.a(1, r6);
        goto L6
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }
}
