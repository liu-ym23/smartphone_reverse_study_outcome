package com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b;

import android.database.Cursor;
import androidx.room.p;
import androidx.room.s;
import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.bean.TimerTaskBean;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: TimerTaskDao_TimerTaskDatabase_Impl.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f17927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.room.f<TimerTaskBean> f17928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final androidx.room.e<TimerTaskBean> f17929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.room.e<TimerTaskBean> f17930d;

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a
    public long insert(TimerTaskBean r3) {
        this.f17927a.i();
        this.f17927a.j();
        long r0 = this.f17928b.a(r3);     // Catch: Throwable -> L6
        this.f17927a.m();     // Catch: Throwable -> L6
        this.f17927a.k();
        return r0;
    L6:
        th = move-exception;
        this.f17927a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a
    public int delete(TimerTaskBean r2) {
        this.f17927a.i();
        this.f17927a.j();
        int r3 = this.f17929c.a(r2) + 0;     // Catch: Throwable -> L6
        this.f17927a.m();     // Catch: Throwable -> L6
        this.f17927a.k();
        return r3;
    L6:
        th = move-exception;
        this.f17927a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a
    public int a(TimerTaskBean r2) {
        this.f17927a.i();
        this.f17927a.j();
        int r3 = this.f17930d.a(r2) + 0;     // Catch: Throwable -> L6
        this.f17927a.m();     // Catch: Throwable -> L6
        this.f17927a.k();
        return r3;
    L6:
        th = move-exception;
        this.f17927a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a
    public TimerTaskBean a(int r30) {
        s r1 = s.a("SELECT * FROM timer_task_bean WHERE task_id = ?", 1);
        r1.a(1, r30);
        this.f17927a.i();
        TimerTaskBean r4 = null;
        String r5 = null;
        Cursor r6 = androidx.room.b.c.query(this.f17927a, r1, false, null);
        int r0 = androidx.room.b.b.b(r6, "cronTime");     // Catch: Throwable -> L44
        int r7 = androidx.room.b.b.b(r6, "is_repeat");     // Catch: Throwable -> L44
        int r8 = androidx.room.b.b.b(r6, "name");     // Catch: Throwable -> L44
        int r9 = androidx.room.b.b.b(r6, "action");     // Catch: Throwable -> L44
        int r10 = androidx.room.b.b.b(r6, MemorySourceLinkType.INTENT);     // Catch: Throwable -> L44
        int r11 = androidx.room.b.b.b(r6, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L44
        int r12 = androidx.room.b.b.b(r6, "source_from");     // Catch: Throwable -> L44
        int r13 = androidx.room.b.b.b(r6, "task_status");     // Catch: Throwable -> L44
        int r14 = androidx.room.b.b.b(r6, "enable_status");     // Catch: Throwable -> L44
        int r15 = androidx.room.b.b.b(r6, "next_schedule_time");     // Catch: Throwable -> L44
        int r16 = androidx.room.b.b.b(r6, "create_time");     // Catch: Throwable -> L44
        int r2 = androidx.room.b.b.b(r6, "ext");     // Catch: Throwable -> L44
        if (r6.moveToFirst() == true) goto L6;
    L42:
        r6.close();
        r1.a();
        return r4;
    L6:
        if (r6.isNull(r0) == false) goto L8;
        String r17 = null;
    L10:
        if (r6.getInt(r7) == 0) goto L12;
        boolean r18 = true;
    L14:
        if (r6.isNull(r8) == false) goto L16;
        String r19 = null;
    L18:
        if (r6.isNull(r9) == false) goto L20;
        String r20 = null;
    L22:
        if (r6.isNull(r10) == false) goto L24;
        String r21 = null;
    L25:
        int r22 = r6.getInt(r11);     // Catch: Throwable -> L44
        if (r6.isNull(r12) == false) goto L28;
        String r23 = null;
    L29:
        int r24 = r6.getInt(r13);     // Catch: Throwable -> L44
        int r25 = r6.getInt(r14);     // Catch: Throwable -> L44
        if (r6.isNull(r15) == false) goto L32;
        Long r26 = null;
    L34:
        if (r6.isNull(r16) == false) goto L36;
        Long r27 = null;
    L38:
        if (r6.isNull(r2) == true) goto L41;
        r5 = r6.getString(r2);     // Catch: Throwable -> L44
    L41:
        r4 = new TimerTaskBean(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r5);     // Catch: Throwable -> L44
        goto L42
    L36:
        r27 = Long.valueOf(r6.getLong(r16));     // Catch: Throwable -> L44
        goto L38
    L32:
        r26 = Long.valueOf(r6.getLong(r15));     // Catch: Throwable -> L44
        goto L34
    L28:
        r23 = r6.getString(r12);     // Catch: Throwable -> L44
        goto L29
    L24:
        r21 = r6.getString(r10);     // Catch: Throwable -> L44
        goto L25
    L20:
        r20 = r6.getString(r9);     // Catch: Throwable -> L44
        goto L22
    L16:
        r19 = r6.getString(r8);     // Catch: Throwable -> L44
        goto L18
    L12:
        r18 = false;
        goto L14
    L8:
        r17 = r6.getString(r0);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        r6.close();
        r1.a();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a
    public List<TimerTaskBean> a(String r30) {
        s r2 = s.a("SELECT * FROM timer_task_bean WHERE `source_from` =?", 1);
        if (r30 != null) goto L5;
        r2.a(1);
    L6:
        this.f17927a.i();
        Cursor r5 = androidx.room.b.c.query(this.f17927a, r2, false, null);
        int r0 = androidx.room.b.b.b(r5, "cronTime");     // Catch: Throwable -> L50
        int r6 = androidx.room.b.b.b(r5, "is_repeat");     // Catch: Throwable -> L50
        int r7 = androidx.room.b.b.b(r5, "name");     // Catch: Throwable -> L50
        int r8 = androidx.room.b.b.b(r5, "action");     // Catch: Throwable -> L50
        int r9 = androidx.room.b.b.b(r5, MemorySourceLinkType.INTENT);     // Catch: Throwable -> L50
        int r10 = androidx.room.b.b.b(r5, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L50
        int r11 = androidx.room.b.b.b(r5, "source_from");     // Catch: Throwable -> L50
        int r12 = androidx.room.b.b.b(r5, "task_status");     // Catch: Throwable -> L50
        int r13 = androidx.room.b.b.b(r5, "enable_status");     // Catch: Throwable -> L50
        int r14 = androidx.room.b.b.b(r5, "next_schedule_time");     // Catch: Throwable -> L50
        int r15 = androidx.room.b.b.b(r5, "create_time");     // Catch: Throwable -> L50
        int r1 = androidx.room.b.b.b(r5, "ext");     // Catch: Throwable -> L50
        ArrayList r3 = new ArrayList(r5.getCount());     // Catch: Throwable -> L50
    L8:
        if (r5.moveToNext() == false) goto L48;
        if (r5.isNull(r0) == false) goto L13;
        String r17 = null;
    L15:
        if (r5.getInt(r6) == 0) goto L17;
        boolean r18 = true;
    L19:
        if (r5.isNull(r7) == false) goto L21;
        String r19 = null;
    L23:
        if (r5.isNull(r8) == false) goto L25;
        String r20 = null;
    L27:
        if (r5.isNull(r9) == false) goto L29;
        String r21 = null;
    L30:
        int r22 = r5.getInt(r10);     // Catch: Throwable -> L50
        if (r5.isNull(r11) == false) goto L33;
        String r23 = null;
    L34:
        int r24 = r5.getInt(r12);     // Catch: Throwable -> L50
        int r25 = r5.getInt(r13);     // Catch: Throwable -> L50
        if (r5.isNull(r14) == false) goto L37;
        Long r26 = null;
    L39:
        if (r5.isNull(r15) == false) goto L41;
        Long r27 = null;
    L43:
        if (r5.isNull(r1) == false) goto L45;
        String r28 = null;
    L46:
        r3.add(new TimerTaskBean(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28));     // Catch: Throwable -> L50
        goto L8
    L45:
        r28 = r5.getString(r1);     // Catch: Throwable -> L50
        goto L46
    L41:
        r27 = Long.valueOf(r5.getLong(r15));     // Catch: Throwable -> L50
        goto L43
    L37:
        r26 = Long.valueOf(r5.getLong(r14));     // Catch: Throwable -> L50
        goto L39
    L33:
        r23 = r5.getString(r11);     // Catch: Throwable -> L50
        goto L34
    L29:
        r21 = r5.getString(r9);     // Catch: Throwable -> L50
        goto L30
    L25:
        r20 = r5.getString(r8);     // Catch: Throwable -> L50
        goto L27
    L21:
        r19 = r5.getString(r7);     // Catch: Throwable -> L50
        goto L23
    L17:
        r18 = false;
        goto L19
    L13:
        r17 = r5.getString(r0);     // Catch: Throwable -> L50
        goto L15
    L48:
        r5.close();
        r2.a();
        return r3;
    L50:
        th = move-exception;
        r5.close();
        r2.a();
        throw th;
    L5:
        r2.a(1, r30);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a
    public List<TimerTaskBean> a(String r30, int r31, int r32) {
        s r2 = s.a("SELECT * FROM timer_task_bean WHERE `source_from` =? LIMIT ? OFFSET ?", 3);
        if (r30 != null) goto L5;
        r2.a(1);
    L6:
        r2.a(2, r32);
        r2.a(3, r31);
        this.f17927a.i();
        Cursor r5 = androidx.room.b.c.query(this.f17927a, r2, false, null);
        int r0 = androidx.room.b.b.b(r5, "cronTime");     // Catch: Throwable -> L50
        int r6 = androidx.room.b.b.b(r5, "is_repeat");     // Catch: Throwable -> L50
        int r7 = androidx.room.b.b.b(r5, "name");     // Catch: Throwable -> L50
        int r8 = androidx.room.b.b.b(r5, "action");     // Catch: Throwable -> L50
        int r9 = androidx.room.b.b.b(r5, MemorySourceLinkType.INTENT);     // Catch: Throwable -> L50
        int r10 = androidx.room.b.b.b(r5, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L50
        int r11 = androidx.room.b.b.b(r5, "source_from");     // Catch: Throwable -> L50
        int r12 = androidx.room.b.b.b(r5, "task_status");     // Catch: Throwable -> L50
        int r13 = androidx.room.b.b.b(r5, "enable_status");     // Catch: Throwable -> L50
        int r14 = androidx.room.b.b.b(r5, "next_schedule_time");     // Catch: Throwable -> L50
        int r15 = androidx.room.b.b.b(r5, "create_time");     // Catch: Throwable -> L50
        int r1 = androidx.room.b.b.b(r5, "ext");     // Catch: Throwable -> L50
        ArrayList r3 = new ArrayList(r5.getCount());     // Catch: Throwable -> L50
    L8:
        if (r5.moveToNext() == false) goto L48;
        if (r5.isNull(r0) == false) goto L13;
        String r17 = null;
    L15:
        if (r5.getInt(r6) == 0) goto L17;
        boolean r18 = true;
    L19:
        if (r5.isNull(r7) == false) goto L21;
        String r19 = null;
    L23:
        if (r5.isNull(r8) == false) goto L25;
        String r20 = null;
    L27:
        if (r5.isNull(r9) == false) goto L29;
        String r21 = null;
    L30:
        int r22 = r5.getInt(r10);     // Catch: Throwable -> L50
        if (r5.isNull(r11) == false) goto L33;
        String r23 = null;
    L34:
        int r24 = r5.getInt(r12);     // Catch: Throwable -> L50
        int r25 = r5.getInt(r13);     // Catch: Throwable -> L50
        if (r5.isNull(r14) == false) goto L37;
        Long r26 = null;
    L39:
        if (r5.isNull(r15) == false) goto L41;
        Long r27 = null;
    L43:
        if (r5.isNull(r1) == false) goto L45;
        String r28 = null;
    L46:
        r3.add(new TimerTaskBean(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28));     // Catch: Throwable -> L50
        goto L8
    L45:
        r28 = r5.getString(r1);     // Catch: Throwable -> L50
        goto L46
    L41:
        r27 = Long.valueOf(r5.getLong(r15));     // Catch: Throwable -> L50
        goto L43
    L37:
        r26 = Long.valueOf(r5.getLong(r14));     // Catch: Throwable -> L50
        goto L39
    L33:
        r23 = r5.getString(r11);     // Catch: Throwable -> L50
        goto L34
    L29:
        r21 = r5.getString(r9);     // Catch: Throwable -> L50
        goto L30
    L25:
        r20 = r5.getString(r8);     // Catch: Throwable -> L50
        goto L27
    L21:
        r19 = r5.getString(r7);     // Catch: Throwable -> L50
        goto L23
    L17:
        r18 = false;
        goto L19
    L13:
        r17 = r5.getString(r0);     // Catch: Throwable -> L50
        goto L15
    L48:
        r5.close();
        r2.a();
        return r3;
    L50:
        th = move-exception;
        r5.close();
        r2.a();
        throw th;
    L5:
        r2.a(1, r30);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a
    public List<TimerTaskBean> a() {
        s r1 = s.a("SELECT * FROM timer_task_bean", 0);
        this.f17927a.i();
        Cursor r4 = androidx.room.b.c.query(this.f17927a, r1, false, null);
        int r0 = androidx.room.b.b.b(r4, "cronTime");     // Catch: Throwable -> L46
        int r5 = androidx.room.b.b.b(r4, "is_repeat");     // Catch: Throwable -> L46
        int r6 = androidx.room.b.b.b(r4, "name");     // Catch: Throwable -> L46
        int r7 = androidx.room.b.b.b(r4, "action");     // Catch: Throwable -> L46
        int r8 = androidx.room.b.b.b(r4, MemorySourceLinkType.INTENT);     // Catch: Throwable -> L46
        int r9 = androidx.room.b.b.b(r4, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L46
        int r10 = androidx.room.b.b.b(r4, "source_from");     // Catch: Throwable -> L46
        int r11 = androidx.room.b.b.b(r4, "task_status");     // Catch: Throwable -> L46
        int r12 = androidx.room.b.b.b(r4, "enable_status");     // Catch: Throwable -> L46
        int r13 = androidx.room.b.b.b(r4, "next_schedule_time");     // Catch: Throwable -> L46
        int r14 = androidx.room.b.b.b(r4, "create_time");     // Catch: Throwable -> L46
        int r15 = androidx.room.b.b.b(r4, "ext");     // Catch: Throwable -> L46
        ArrayList r2 = new ArrayList(r4.getCount());     // Catch: Throwable -> L46
    L4:
        if (r4.moveToNext() == false) goto L44;
        if (r4.isNull(r0) == false) goto L9;
        String r17 = null;
    L11:
        if (r4.getInt(r5) == 0) goto L13;
        boolean r18 = true;
    L15:
        if (r4.isNull(r6) == false) goto L17;
        String r19 = null;
    L19:
        if (r4.isNull(r7) == false) goto L21;
        String r20 = null;
    L23:
        if (r4.isNull(r8) == false) goto L25;
        String r21 = null;
    L26:
        int r22 = r4.getInt(r9);     // Catch: Throwable -> L46
        if (r4.isNull(r10) == false) goto L29;
        String r23 = null;
    L30:
        int r24 = r4.getInt(r11);     // Catch: Throwable -> L46
        int r25 = r4.getInt(r12);     // Catch: Throwable -> L46
        if (r4.isNull(r13) == false) goto L33;
        Long r26 = null;
    L35:
        if (r4.isNull(r14) == false) goto L37;
        Long r27 = null;
    L39:
        if (r4.isNull(r15) == false) goto L41;
        String r28 = null;
    L42:
        r2.add(new TimerTaskBean(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28));     // Catch: Throwable -> L46
        goto L4
    L41:
        r28 = r4.getString(r15);     // Catch: Throwable -> L46
        goto L42
    L37:
        r27 = Long.valueOf(r4.getLong(r14));     // Catch: Throwable -> L46
        goto L39
    L33:
        r26 = Long.valueOf(r4.getLong(r13));     // Catch: Throwable -> L46
        goto L35
    L29:
        r23 = r4.getString(r10);     // Catch: Throwable -> L46
        goto L30
    L25:
        r21 = r4.getString(r8);     // Catch: Throwable -> L46
        goto L26
    L21:
        r20 = r4.getString(r7);     // Catch: Throwable -> L46
        goto L23
    L17:
        r19 = r4.getString(r6);     // Catch: Throwable -> L46
        goto L19
    L13:
        r18 = false;
        goto L15
    L9:
        r17 = r4.getString(r0);     // Catch: Throwable -> L46
        goto L11
    L44:
        r4.close();
        r1.a();
        return r2;
    L46:
        th = move-exception;
        r4.close();
        r1.a();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a
    public List<TimerTaskBean> a(androidx.sqlite.db.f r4) {
        androidx.sqlite.db.f r5 = (androidx.sqlite.db.f) ZeusTransformUtils.wrapperContextForParams(r4, androidx.sqlite.db.f.class, "com.obric.aiagent.plugin");
        this.f17927a.i();
        Cursor r6 = androidx.room.b.c.query(this.f17927a, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(a(r6));     // Catch: Throwable -> L10
        goto L5
    L8:
        r6.close();
        return r0;
    L10:
        th = move-exception;
        r6.close();
        throw th;
    }

    public static List<Class<?>> b() {
        return Collections.emptyList();
    }

    private TimerTaskBean a(Cursor r29) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r29, Cursor.class, "com.obric.aiagent.plugin");
        int r1 = r0.getColumnIndex("cronTime");
        int r2 = r0.getColumnIndex("is_repeat");
        int r3 = r0.getColumnIndex("name");
        int r4 = r0.getColumnIndex("action");
        int r5 = r0.getColumnIndex(MemorySourceLinkType.INTENT);
        int r6 = r0.getColumnIndex(KnowledgeActivity.KEY_TASK_ID);
        int r7 = r0.getColumnIndex("source_from");
        int r8 = r0.getColumnIndex("task_status");
        int r9 = r0.getColumnIndex("enable_status");
        int r10 = r0.getColumnIndex("next_schedule_time");
        int r11 = r0.getColumnIndex("create_time");
        int r12 = r0.getColumnIndex("ext");
        String r14 = null;
        if (r1 != (-1)) goto L6;
    L4:
        String r16 = null;
    L9:
        int r13 = 0;
        if (r2 != (-1)) goto L13;
        boolean r17 = false;
    L17:
        if (r3 != (-1)) goto L20;
    L18:
        String r18 = null;
    L23:
        if (r4 != (-1)) goto L26;
    L24:
        String r19 = null;
    L29:
        if (r5 != (-1)) goto L32;
    L30:
        String r20 = null;
    L35:
        if (r6 != (-1)) goto L37;
        int r21 = 0;
    L38:
        if (r7 != (-1)) goto L41;
    L39:
        String r22 = null;
    L44:
        if (r8 != (-1)) goto L46;
        int r23 = 0;
    L47:
        if (r9 == (-1)) goto L50;
        r13 = r0.getInt(r9);
    L50:
        int r24 = r13;
        if (r10 != (-1)) goto L54;
    L52:
        Long r25 = null;
    L57:
        if (r11 != (-1)) goto L60;
    L58:
        Long r26 = null;
    L63:
        if (r12 != (-1)) goto L66;
    L70:
        return new TimerTaskBean(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r14);
    L66:
        if (r0.isNull(r12) == true) goto L70;
        r14 = r0.getString(r12);
        goto L70
    L60:
        if (r0.isNull(r11) == true) goto L58;
        r26 = Long.valueOf(r0.getLong(r11));
        goto L63
    L54:
        if (r0.isNull(r10) == true) goto L52;
        r25 = Long.valueOf(r0.getLong(r10));
        goto L57
    L46:
        r23 = r0.getInt(r8);
        goto L47
    L41:
        if (r0.isNull(r7) == true) goto L39;
        r22 = r0.getString(r7);
        goto L44
    L37:
        r21 = r0.getInt(r6);
        goto L38
    L32:
        if (r0.isNull(r5) == true) goto L30;
        r20 = r0.getString(r5);
        goto L35
    L26:
        if (r0.isNull(r4) == true) goto L24;
        r19 = r0.getString(r4);
        goto L29
    L20:
        if (r0.isNull(r3) == true) goto L18;
        r18 = r0.getString(r3);
        goto L23
    L13:
        if (r0.getInt(r2) == 0) goto L15;
        boolean r15 = true;
    L16:
        r17 = r15;
        goto L17
    L15:
        r15 = false;
        goto L16
    L6:
        if (r0.isNull(r1) == true) goto L4;
        r16 = r0.getString(r1);
        goto L9
    }
}
