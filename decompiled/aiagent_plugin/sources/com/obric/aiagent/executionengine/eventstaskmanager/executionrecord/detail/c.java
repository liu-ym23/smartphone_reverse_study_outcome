package com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail;

import android.database.Cursor;
import androidx.room.f;
import androidx.room.p;
import androidx.room.s;
import androidx.room.v;
import androidx.sqlite.db.g;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import os.teatracker.IBdInstall;

/* JADX INFO: compiled from: ExecutionDetailRecordDao_TaskDatabase_Impl.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f17319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f<ExecutionDetailRecordBean> f17320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.aiagent.executionengine.eventstaskmanager.common.data.c f17321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.room.e<ExecutionDetailRecordBean> f17322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final v f17323e;

    static /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.common.data.c a(c r0) {
        return r0.f17321c;
    }

    public c(final p r2) {
        this.f17321c = new com.obric.aiagent.executionengine.eventstaskmanager.common.data.c();
        this.f17319a = r2;
        this.f17320b = new AnonymousClass1(this, r2);
        this.f17322d = new AnonymousClass2(this, r2);
        this.f17323e = new AnonymousClass3(this, r2);
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a
    public List<Long> insert(List<ExecutionDetailRecordBean> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.f17319a.i();
        this.f17319a.j();
        List<Long> r5 = this.f17320b.a(r4);     // Catch: Throwable -> L6
        this.f17319a.m();     // Catch: Throwable -> L6
        this.f17319a.k();
        return r5;
    L6:
        th = move-exception;
        this.f17319a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a
    public int update(ExecutionDetailRecordBean r2) {
        this.f17319a.i();
        this.f17319a.j();
        int r3 = this.f17322d.a(r2) + 0;     // Catch: Throwable -> L6
        this.f17319a.m();     // Catch: Throwable -> L6
        this.f17319a.k();
        return r3;
    L6:
        th = move-exception;
        this.f17319a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a
    public int b(List<ExecutionDetailRecordBean> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.f17319a.i();
        this.f17319a.j();
        int r5 = this.f17322d.a(r4) + 0;     // Catch: Throwable -> L6
        this.f17319a.m();     // Catch: Throwable -> L6
        this.f17319a.k();
        return r5;
    L6:
        th = move-exception;
        this.f17319a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a
    public int a(String r3) {
        this.f17319a.i();
        g r0 = this.f17323e.c();
        if (r3 != null) goto L5;
        r0.a(1);
    L6:
        this.f17319a.j();
        int r4 = r0.a();     // Catch: Throwable -> L10
        this.f17319a.m();     // Catch: Throwable -> L10
        this.f17319a.k();
        this.f17323e.a(r0);
        return r4;
    L10:
        th = move-exception;
        this.f17319a.k();
        this.f17323e.a(r0);
        throw th;
    L5:
        r0.a(1, r3);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a
    public List<ExecutionDetailRecordBean> a(int r26, int r27) {
        s r3 = s.a("SELECT * FROM task_execution_record_detail_bean ORDER BY exec_time ASC LIMIT ? OFFSET ?", 2);
        r3.a(1, r27);
        r3.a(2, r26);
        this.f17319a.i();
        this.f17319a.j();
        Cursor r2 = androidx.room.b.c.query(this.f17319a, r3, false, null);     // Catch: Throwable -> L35
        int r0 = androidx.room.b.b.b(r2, "session_id");     // Catch: Throwable -> L32
        int r5 = androidx.room.b.b.b(r2, "exec_time");     // Catch: Throwable -> L32
        int r6 = androidx.room.b.b.b(r2, "package_name");     // Catch: Throwable -> L32
        int r7 = androidx.room.b.b.b(r2, IBdInstall.PARAM_APP_NAME);     // Catch: Throwable -> L32
        int r8 = androidx.room.b.b.b(r2, "detail_text");     // Catch: Throwable -> L32
        int r9 = androidx.room.b.b.b(r2, "detail_type");     // Catch: Throwable -> L32
        int r10 = androidx.room.b.b.b(r2, "ext");     // Catch: Throwable -> L32
        int r11 = androidx.room.b.b.b(r2, DbHelper.COL_ID);     // Catch: Throwable -> L32
        ArrayList r12 = new ArrayList(r2.getCount());     // Catch: Throwable -> L32
    L6:
        if (r2.moveToNext() == false) goto L28;
        if (r2.isNull(r0) == false) goto L10;
        String r15 = null;
    L11:
        long r16 = r2.getLong(r5);     // Catch: Throwable -> L32
        if (r2.isNull(r6) == false) goto L14;
        String r18 = null;
    L16:
        if (r2.isNull(r7) == false) goto L18;
        String r19 = null;
    L20:
        if (r2.isNull(r8) == false) goto L22;
        String r20 = null;
    L23:
        int r21 = r2.getInt(r9);     // Catch: Throwable -> L32
        if (r2.isNull(r10) == false) goto L26;
        String r13 = null;
    L27:
        r12.add(new ExecutionDetailRecordBean(r15, r16, r18, r19, r20, r21, this.f17321c.d(r13), r2.getLong(r11)));     // Catch: Throwable -> L32
        goto L6
    L26:
        r13 = r2.getString(r10);     // Catch: Throwable -> L32
        goto L27
    L22:
        r20 = r2.getString(r8);     // Catch: Throwable -> L32
        goto L23
    L18:
        r19 = r2.getString(r7);     // Catch: Throwable -> L32
        goto L20
    L14:
        r18 = r2.getString(r6);     // Catch: Throwable -> L32
        goto L16
    L10:
        r15 = r2.getString(r0);     // Catch: Throwable -> L32
        goto L11
    L28:
        this.f17319a.m();     // Catch: Throwable -> L32
        r2.close();     // Catch: Throwable -> L35
        r3.a();     // Catch: Throwable -> L35
        this.f17319a.k();
        return r12;
    L32:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L35
        r3.a();     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        this.f17319a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a
    public List<ExecutionDetailRecordBean> a(String r26, int r27, int r28) {
        s r2 = s.a("SELECT * FROM task_execution_record_detail_bean WHERE session_id = ? ORDER BY exec_time ASC LIMIT ? OFFSET ?", 3);
        if (r26 != null) goto L5;
        r2.a(1);
    L6:
        r2.a(2, r28);
        r2.a(3, r27);
        this.f17319a.i();
        this.f17319a.j();
        Cursor r3 = androidx.room.b.c.query(this.f17319a, r2, false, null);     // Catch: Throwable -> L39
        int r0 = androidx.room.b.b.b(r3, "session_id");     // Catch: Throwable -> L36
        int r5 = androidx.room.b.b.b(r3, "exec_time");     // Catch: Throwable -> L36
        int r6 = androidx.room.b.b.b(r3, "package_name");     // Catch: Throwable -> L36
        int r7 = androidx.room.b.b.b(r3, IBdInstall.PARAM_APP_NAME);     // Catch: Throwable -> L36
        int r8 = androidx.room.b.b.b(r3, "detail_text");     // Catch: Throwable -> L36
        int r9 = androidx.room.b.b.b(r3, "detail_type");     // Catch: Throwable -> L36
        int r10 = androidx.room.b.b.b(r3, "ext");     // Catch: Throwable -> L36
        int r11 = androidx.room.b.b.b(r3, DbHelper.COL_ID);     // Catch: Throwable -> L36
        ArrayList r12 = new ArrayList(r3.getCount());     // Catch: Throwable -> L36
    L10:
        if (r3.moveToNext() == false) goto L32;
        if (r3.isNull(r0) == false) goto L14;
        String r15 = null;
    L15:
        long r16 = r3.getLong(r5);     // Catch: Throwable -> L36
        if (r3.isNull(r6) == false) goto L18;
        String r18 = null;
    L20:
        if (r3.isNull(r7) == false) goto L22;
        String r19 = null;
    L24:
        if (r3.isNull(r8) == false) goto L26;
        String r20 = null;
    L27:
        int r21 = r3.getInt(r9);     // Catch: Throwable -> L36
        if (r3.isNull(r10) == false) goto L30;
        String r13 = null;
    L31:
        r12.add(new ExecutionDetailRecordBean(r15, r16, r18, r19, r20, r21, this.f17321c.d(r13), r3.getLong(r11)));     // Catch: Throwable -> L36
        goto L10
    L30:
        r13 = r3.getString(r10);     // Catch: Throwable -> L36
        goto L31
    L26:
        r20 = r3.getString(r8);     // Catch: Throwable -> L36
        goto L27
    L22:
        r19 = r3.getString(r7);     // Catch: Throwable -> L36
        goto L24
    L18:
        r18 = r3.getString(r6);     // Catch: Throwable -> L36
        goto L20
    L14:
        r15 = r3.getString(r0);     // Catch: Throwable -> L36
        goto L15
    L32:
        this.f17319a.m();     // Catch: Throwable -> L36
        r3.close();     // Catch: Throwable -> L39
        r2.a();     // Catch: Throwable -> L39
        this.f17319a.k();
        return r12;
    L36:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L39
        r2.a();     // Catch: Throwable -> L39
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        this.f17319a.k();
        throw th;
    L5:
        r2.a(1, r26);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a
    public List<ExecutionDetailRecordBean> a(List<Long> r26) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.aiagent.plugin");
        StringBuilder r3 = androidx.room.b.f.a();
        r3.append("SELECT * FROM task_execution_record_detail_bean WHERE id IN (");
        int r4 = r0.size();
        androidx.room.b.f.a(r3, r4);
        r3.append(") ORDER BY exec_time ASC");
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
        this.f17319a.i();
        this.f17319a.j();
        Cursor r8 = androidx.room.b.c.query(this.f17319a, r5, false, null);     // Catch: Throwable -> L43
        int r2 = androidx.room.b.b.b(r8, "session_id");     // Catch: Throwable -> L40
        int r9 = androidx.room.b.b.b(r8, "exec_time");     // Catch: Throwable -> L40
        int r10 = androidx.room.b.b.b(r8, "package_name");     // Catch: Throwable -> L40
        int r11 = androidx.room.b.b.b(r8, IBdInstall.PARAM_APP_NAME);     // Catch: Throwable -> L40
        int r12 = androidx.room.b.b.b(r8, "detail_text");     // Catch: Throwable -> L40
        int r13 = androidx.room.b.b.b(r8, "detail_type");     // Catch: Throwable -> L40
        int r14 = androidx.room.b.b.b(r8, "ext");     // Catch: Throwable -> L40
        int r15 = androidx.room.b.b.b(r8, DbHelper.COL_ID);     // Catch: Throwable -> L40
        ArrayList r16 = new ArrayList(r8.getCount());     // Catch: Throwable -> L40
    L14:
        if (r8.moveToNext() == false) goto L36;
        if (r8.isNull(r2) == false) goto L18;
        String r17 = null;
    L19:
        long r18 = r8.getLong(r9);     // Catch: Throwable -> L40
        if (r8.isNull(r10) == false) goto L22;
        String r19 = null;
    L24:
        if (r8.isNull(r11) == false) goto L26;
        String r110 = null;
    L28:
        if (r8.isNull(r12) == false) goto L30;
        String r20 = null;
    L31:
        int r21 = r8.getInt(r13);     // Catch: Throwable -> L40
        if (r8.isNull(r14) == false) goto L34;
        String r111 = null;
    L35:
        r16.add(new ExecutionDetailRecordBean(r17, r18, r19, r110, r20, r21, this.f17321c.d(r111), r8.getLong(r15)));     // Catch: Throwable -> L40
        goto L14
    L34:
        r111 = r8.getString(r14);     // Catch: Throwable -> L40
        goto L35
    L30:
        r20 = r8.getString(r12);     // Catch: Throwable -> L40
        goto L31
    L26:
        r110 = r8.getString(r11);     // Catch: Throwable -> L40
        goto L28
    L22:
        r19 = r8.getString(r10);     // Catch: Throwable -> L40
        goto L24
    L18:
        r17 = r8.getString(r2);     // Catch: Throwable -> L40
        goto L19
    L36:
        this.f17319a.m();     // Catch: Throwable -> L40
        r8.close();     // Catch: Throwable -> L43
        r5.a();     // Catch: Throwable -> L43
        this.f17319a.k();
        return r16;
    L40:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L43
        r5.a();     // Catch: Throwable -> L43
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        this.f17319a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a
    public int c(List<Long> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        this.f17319a.i();
        StringBuilder r0 = androidx.room.b.f.a();
        r0.append("DELETE FROM task_execution_record_detail_bean WHERE id IN (");
        androidx.room.b.f.a(r0, r7.size());
        r0.append(")");
        String r1 = r0.toString();
        g r2 = this.f17319a.a(r1);
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
        this.f17319a.j();
        int r9 = r2.a();     // Catch: Throwable -> L14
        this.f17319a.m();     // Catch: Throwable -> L14
        this.f17319a.k();
        return r9;
    L14:
        th = move-exception;
        this.f17319a.k();
        throw th;
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }
}
