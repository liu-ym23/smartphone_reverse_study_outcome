package com.obric.aiagent.executionengine.eventstaskmanager.executionrecord;

import android.database.Cursor;
import androidx.core.provider.FontsContractCompat;
import androidx.room.f;
import androidx.room.p;
import androidx.room.s;
import androidx.room.v;
import androidx.sqlite.db.g;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ExecutionRecordDao_TaskDatabase_Impl.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f17284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f<ExecutionRecordBean> f17285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.aiagent.executionengine.eventstaskmanager.common.data.c f17286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.room.e<ExecutionRecordBean> f17287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final v f17288e;

    static /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.common.data.c a(c r0) {
        return r0.f17286c;
    }

    public c(final p r2) {
        this.f17286c = new com.obric.aiagent.executionengine.eventstaskmanager.common.data.c();
        this.f17284a = r2;
        this.f17285b = new AnonymousClass1(this, r2);
        this.f17287d = new AnonymousClass2(this, r2);
        this.f17288e = new AnonymousClass3(this, r2);
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a
    public List<Long> insert(List<ExecutionRecordBean> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.f17284a.i();
        this.f17284a.j();
        List<Long> r5 = this.f17285b.a(r4);     // Catch: Throwable -> L6
        this.f17284a.m();     // Catch: Throwable -> L6
        this.f17284a.k();
        return r5;
    L6:
        th = move-exception;
        this.f17284a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a
    public int update(ExecutionRecordBean r2) {
        this.f17284a.i();
        this.f17284a.j();
        int r3 = this.f17287d.a(r2) + 0;     // Catch: Throwable -> L6
        this.f17284a.m();     // Catch: Throwable -> L6
        this.f17284a.k();
        return r3;
    L6:
        th = move-exception;
        this.f17284a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a
    public int b(List<ExecutionRecordBean> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.f17284a.i();
        this.f17284a.j();
        int r5 = this.f17287d.a(r4) + 0;     // Catch: Throwable -> L6
        this.f17284a.m();     // Catch: Throwable -> L6
        this.f17284a.k();
        return r5;
    L6:
        th = move-exception;
        this.f17284a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a
    public int a(String r3) {
        this.f17284a.i();
        g r0 = this.f17288e.c();
        if (r3 != null) goto L5;
        r0.a(1);
    L6:
        this.f17284a.j();
        int r4 = r0.a();     // Catch: Throwable -> L10
        this.f17284a.m();     // Catch: Throwable -> L10
        this.f17284a.k();
        this.f17288e.a(r0);
        return r4;
    L10:
        th = move-exception;
        this.f17284a.k();
        this.f17288e.a(r0);
        throw th;
    L5:
        r0.a(1, r3);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a
    public List<ExecutionRecordBean> a(int r37, int r38) {
        s r3 = s.a("SELECT * FROM task_execution_record_bean ORDER BY create_time DESC LIMIT ? OFFSET ?", 2);
        r3.a(1, r38);
        r3.a(2, r37);
        this.f17284a.i();
        this.f17284a.j();
        Cursor r2 = androidx.room.b.c.query(this.f17284a, r3, false, null);     // Catch: Throwable -> L44
        int r0 = androidx.room.b.b.b(r2, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L40
        int r5 = androidx.room.b.b.b(r2, KnowledgeActivity.KEY_TASK_TYPE);     // Catch: Throwable -> L40
        int r6 = androidx.room.b.b.b(r2, "task_mode");     // Catch: Throwable -> L40
        int r7 = androidx.room.b.b.b(r2, DownloadConstants.QUERY_KEY);     // Catch: Throwable -> L40
        int r8 = androidx.room.b.b.b(r2, "trigger_time");     // Catch: Throwable -> L40
        int r9 = androidx.room.b.b.b(r2, "duration");     // Catch: Throwable -> L40
        int r10 = androidx.room.b.b.b(r2, FontsContractCompat.Columns.RESULT_CODE);     // Catch: Throwable -> L40
        int r11 = androidx.room.b.b.b(r2, "result_message");     // Catch: Throwable -> L40
        int r12 = androidx.room.b.b.b(r2, "complex_task_model");     // Catch: Throwable -> L40
        int r13 = androidx.room.b.b.b(r2, "ext");     // Catch: Throwable -> L40
        int r14 = androidx.room.b.b.b(r2, "source_from");     // Catch: Throwable -> L40
        int r15 = androidx.room.b.b.b(r2, "create_time");     // Catch: Throwable -> L40
        s r16 = r3;
        int r39 = androidx.room.b.b.b(r2, DbHelper.COL_ID);     // Catch: Throwable -> L40
        ArrayList r4 = new ArrayList(r2.getCount());     // Catch: Throwable -> L38
    L8:
        if (r2.moveToNext() == false) goto L34;
        if (r2.isNull(r0) == false) goto L12;
        String r18 = null;
    L13:
        int r19 = r2.getInt(r5);     // Catch: Throwable -> L38
        int r20 = r2.getInt(r6);     // Catch: Throwable -> L38
        if (r2.isNull(r7) == false) goto L16;
        String r21 = null;
    L17:
        long r22 = r2.getLong(r8);     // Catch: Throwable -> L38
        long r24 = r2.getLong(r9);     // Catch: Throwable -> L38
        int r26 = r2.getInt(r10);     // Catch: Throwable -> L38
        if (r2.isNull(r11) == false) goto L20;
        String r27 = null;
    L22:
        if (r2.isNull(r12) == false) goto L24;
        String r28 = null;
    L26:
        if (r2.isNull(r13) == false) goto L28;
        String r17 = null;
    L29:
        Map<String, String> r29 = this.f17286c.d(r17);     // Catch: Throwable -> L38
        if (r2.isNull(r14) == false) goto L32;
        String r30 = null;
    L33:
        int r1 = r39;
        r4.add(new ExecutionRecordBean(r18, r19, r20, r21, r22, r24, r26, r27, r28, r29, r30, r2.getLong(r15), r2.getLong(r1)));     // Catch: Throwable -> L38
        r39 = r1;
        r0 = r0;
        goto L8
    L32:
        r30 = r2.getString(r14);     // Catch: Throwable -> L38
        goto L33
    L28:
        r17 = r2.getString(r13);     // Catch: Throwable -> L38
        goto L29
    L24:
        r28 = r2.getString(r12);     // Catch: Throwable -> L38
        goto L26
    L20:
        r27 = r2.getString(r11);     // Catch: Throwable -> L38
        goto L22
    L16:
        r21 = r2.getString(r7);     // Catch: Throwable -> L38
        goto L17
    L12:
        r18 = r2.getString(r0);     // Catch: Throwable -> L38
        goto L13
    L34:
        this.f17284a.m();     // Catch: Throwable -> L38
        r2.close();     // Catch: Throwable -> L44
        r16.a();     // Catch: Throwable -> L44
        this.f17284a.k();
        return r4;
    L38:
        th = th;
    L42:
        r2.close();     // Catch: Throwable -> L44
        r16.a();     // Catch: Throwable -> L44
        throw th;     // Catch: Throwable -> L44
    L40:
        th = th;
        r16 = r3;
    L44:
        th = move-exception;
        this.f17284a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a
    public List<ExecutionRecordBean> a(String r36, int r37, int r38) {
        s r2 = s.a("SELECT * FROM task_execution_record_bean WHERE task_id = ? ORDER BY create_time DESC LIMIT ? OFFSET ?", 3);
        if (r36 != null) goto L5;
        r2.a(1);
    L6:
        r2.a(2, r38);
        r2.a(3, r37);
        this.f17284a.i();
        this.f17284a.j();
        Cursor r3 = androidx.room.b.c.query(this.f17284a, r2, false, null);     // Catch: Throwable -> L48
        int r0 = androidx.room.b.b.b(r3, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L44
        int r5 = androidx.room.b.b.b(r3, KnowledgeActivity.KEY_TASK_TYPE);     // Catch: Throwable -> L44
        int r6 = androidx.room.b.b.b(r3, "task_mode");     // Catch: Throwable -> L44
        int r7 = androidx.room.b.b.b(r3, DownloadConstants.QUERY_KEY);     // Catch: Throwable -> L44
        int r8 = androidx.room.b.b.b(r3, "trigger_time");     // Catch: Throwable -> L44
        int r9 = androidx.room.b.b.b(r3, "duration");     // Catch: Throwable -> L44
        int r10 = androidx.room.b.b.b(r3, FontsContractCompat.Columns.RESULT_CODE);     // Catch: Throwable -> L44
        int r11 = androidx.room.b.b.b(r3, "result_message");     // Catch: Throwable -> L44
        int r12 = androidx.room.b.b.b(r3, "complex_task_model");     // Catch: Throwable -> L44
        int r13 = androidx.room.b.b.b(r3, "ext");     // Catch: Throwable -> L44
        int r14 = androidx.room.b.b.b(r3, "source_from");     // Catch: Throwable -> L44
        int r15 = androidx.room.b.b.b(r3, "create_time");     // Catch: Throwable -> L44
        s r16 = r2;
        int r39 = androidx.room.b.b.b(r3, DbHelper.COL_ID);     // Catch: Throwable -> L44
        ArrayList r4 = new ArrayList(r3.getCount());     // Catch: Throwable -> L42
    L12:
        if (r3.moveToNext() == false) goto L38;
        if (r3.isNull(r0) == false) goto L16;
        String r18 = null;
    L17:
        int r19 = r3.getInt(r5);     // Catch: Throwable -> L42
        int r20 = r3.getInt(r6);     // Catch: Throwable -> L42
        if (r3.isNull(r7) == false) goto L20;
        String r21 = null;
    L21:
        long r22 = r3.getLong(r8);     // Catch: Throwable -> L42
        long r24 = r3.getLong(r9);     // Catch: Throwable -> L42
        int r26 = r3.getInt(r10);     // Catch: Throwable -> L42
        if (r3.isNull(r11) == false) goto L24;
        String r27 = null;
    L26:
        if (r3.isNull(r12) == false) goto L28;
        String r28 = null;
    L30:
        if (r3.isNull(r13) == false) goto L32;
        String r17 = null;
    L33:
        Map<String, String> r29 = this.f17286c.d(r17);     // Catch: Throwable -> L42
        if (r3.isNull(r14) == false) goto L36;
        String r30 = null;
    L37:
        int r1 = r39;
        r4.add(new ExecutionRecordBean(r18, r19, r20, r21, r22, r24, r26, r27, r28, r29, r30, r3.getLong(r15), r3.getLong(r1)));     // Catch: Throwable -> L42
        r39 = r1;
        r0 = r0;
        goto L12
    L36:
        r30 = r3.getString(r14);     // Catch: Throwable -> L42
        goto L37
    L32:
        r17 = r3.getString(r13);     // Catch: Throwable -> L42
        goto L33
    L28:
        r28 = r3.getString(r12);     // Catch: Throwable -> L42
        goto L30
    L24:
        r27 = r3.getString(r11);     // Catch: Throwable -> L42
        goto L26
    L20:
        r21 = r3.getString(r7);     // Catch: Throwable -> L42
        goto L21
    L16:
        r18 = r3.getString(r0);     // Catch: Throwable -> L42
        goto L17
    L38:
        this.f17284a.m();     // Catch: Throwable -> L42
        r3.close();     // Catch: Throwable -> L48
        r16.a();     // Catch: Throwable -> L48
        this.f17284a.k();
        return r4;
    L42:
        th = th;
    L46:
        r3.close();     // Catch: Throwable -> L48
        r16.a();     // Catch: Throwable -> L48
        throw th;     // Catch: Throwable -> L48
    L44:
        th = th;
        r16 = r2;
    L48:
        th = move-exception;
        this.f17284a.k();
        throw th;
    L5:
        r2.a(1, r36);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a
    public List<ExecutionRecordBean> a(List<Long> r38) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r38, List.class, "com.obric.aiagent.plugin");
        StringBuilder r3 = androidx.room.b.f.a();
        r3.append("SELECT * FROM task_execution_record_bean WHERE id IN (");
        int r4 = r0.size();
        androidx.room.b.f.a(r3, r4);
        r3.append(")");
        s r5 = s.a(r3.toString(), r4 + 0);
        Iterator r1 = r0.iterator();
        int r6 = 1;
    L4:
        if (r1.hasNext() == false) goto L10;
        Long r7 = (Long) ZeusTransformUtils.preCheckCast(r1.next(), Long.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L8;
        r5.a(r6);
    L9:
        r6 = r6 + 1;
        goto L4
    L8:
        r5.a(r6, r7.longValue());
        goto L9
    L10:
        this.f17284a.i();
        this.f17284a.j();
        Cursor r8 = androidx.room.b.c.query(this.f17284a, r5, false, null);     // Catch: Throwable -> L52
        int r2 = androidx.room.b.b.b(r8, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L48
        int r9 = androidx.room.b.b.b(r8, KnowledgeActivity.KEY_TASK_TYPE);     // Catch: Throwable -> L48
        int r10 = androidx.room.b.b.b(r8, "task_mode");     // Catch: Throwable -> L48
        int r11 = androidx.room.b.b.b(r8, DownloadConstants.QUERY_KEY);     // Catch: Throwable -> L48
        int r12 = androidx.room.b.b.b(r8, "trigger_time");     // Catch: Throwable -> L48
        int r13 = androidx.room.b.b.b(r8, "duration");     // Catch: Throwable -> L48
        int r14 = androidx.room.b.b.b(r8, FontsContractCompat.Columns.RESULT_CODE);     // Catch: Throwable -> L48
        int r15 = androidx.room.b.b.b(r8, "result_message");     // Catch: Throwable -> L48
        int r16 = androidx.room.b.b.b(r8, "complex_task_model");     // Catch: Throwable -> L48
        int r17 = androidx.room.b.b.b(r8, "ext");     // Catch: Throwable -> L48
        int r18 = androidx.room.b.b.b(r8, "source_from");     // Catch: Throwable -> L48
        int r19 = androidx.room.b.b.b(r8, "create_time");     // Catch: Throwable -> L48
        s r110 = r5;
        int r111 = androidx.room.b.b.b(r8, DbHelper.COL_ID);     // Catch: Throwable -> L48
        ArrayList r20 = new ArrayList(r8.getCount());     // Catch: Throwable -> L46
    L16:
        if (r8.moveToNext() == false) goto L42;
        if (r8.isNull(r2) == false) goto L20;
        String r112 = null;
    L21:
        int r21 = r8.getInt(r9);     // Catch: Throwable -> L46
        int r22 = r8.getInt(r10);     // Catch: Throwable -> L46
        if (r8.isNull(r11) == false) goto L24;
        String r23 = null;
    L25:
        long r24 = r8.getLong(r12);     // Catch: Throwable -> L46
        long r25 = r8.getLong(r13);     // Catch: Throwable -> L46
        int r27 = r8.getInt(r14);     // Catch: Throwable -> L46
        if (r8.isNull(r15) == false) goto L28;
        String r28 = null;
    L30:
        if (r8.isNull(r16) == false) goto L32;
        String r29 = null;
    L34:
        if (r8.isNull(r17) == false) goto L36;
        String r26 = null;
    L37:
        Map<String, String> r30 = this.f17286c.d(r26);     // Catch: Throwable -> L46
        if (r8.isNull(r18) == false) goto L40;
        String r31 = null;
    L41:
        int r32 = r111;
        r20.add(new ExecutionRecordBean(r112, r21, r22, r23, r24, r25, r27, r28, r29, r30, r31, r8.getLong(r19), r8.getLong(r32)));     // Catch: Throwable -> L46
        r111 = r32;
        r2 = r2;
        goto L16
    L40:
        r31 = r8.getString(r18);     // Catch: Throwable -> L46
        goto L41
    L36:
        r26 = r8.getString(r17);     // Catch: Throwable -> L46
        goto L37
    L32:
        r29 = r8.getString(r16);     // Catch: Throwable -> L46
        goto L34
    L28:
        r28 = r8.getString(r15);     // Catch: Throwable -> L46
        goto L30
    L24:
        r23 = r8.getString(r11);     // Catch: Throwable -> L46
        goto L25
    L20:
        r112 = r8.getString(r2);     // Catch: Throwable -> L46
        goto L21
    L42:
        this.f17284a.m();     // Catch: Throwable -> L46
        r8.close();     // Catch: Throwable -> L52
        r110.a();     // Catch: Throwable -> L52
        this.f17284a.k();
        return r20;
    L46:
        th = th;
    L50:
        r8.close();     // Catch: Throwable -> L52
        r110.a();     // Catch: Throwable -> L52
        throw th;     // Catch: Throwable -> L52
    L48:
        th = th;
        r110 = r5;
    L52:
        th = move-exception;
        this.f17284a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a
    public int c(List<Long> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        this.f17284a.i();
        StringBuilder r0 = androidx.room.b.f.a();
        r0.append("DELETE FROM task_execution_record_bean WHERE id IN (");
        androidx.room.b.f.a(r0, r7.size());
        r0.append(")");
        String r1 = r0.toString();
        g r2 = this.f17284a.a(r1);
        Iterator r8 = r7.iterator();
        int r3 = 1;
    L4:
        if (r8.hasNext() == false) goto L10;
        Long r4 = (Long) ZeusTransformUtils.preCheckCast(r8.next(), Long.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L8;
        r2.a(r3);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        r2.a(r3, r4.longValue());
        goto L9
    L10:
        this.f17284a.j();
        int r9 = r2.a();     // Catch: Throwable -> L14
        this.f17284a.m();     // Catch: Throwable -> L14
        this.f17284a.k();
        return r9;
    L14:
        th = move-exception;
        this.f17284a.k();
        throw th;
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }
}
