package com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a;

import android.database.Cursor;
import androidx.room.p;
import androidx.room.s;
import androidx.room.v;
import androidx.sqlite.db.g;
import com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.bean.ShortcutTaskBean;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.obric.eventkit.task.model.ShortcutTaskAction;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ShortcutTaskDao_TaskDatabase_Impl.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f17521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.room.f<ShortcutTaskBean> f17522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.aiagent.executionengine.eventstaskmanager.common.data.c f17523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.room.e<ShortcutTaskBean> f17524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final androidx.room.e<ShortcutTaskBean> f17525e;
    private final v f;

    static /* synthetic */ com.obric.aiagent.executionengine.eventstaskmanager.common.data.c a(c r0) {
        return r0.f17523c;
    }

    public c(final p r2) {
        this.f17523c = new com.obric.aiagent.executionengine.eventstaskmanager.common.data.c();
        this.f17521a = r2;
        this.f17522b = new AnonymousClass1(this, r2);
        this.f17524d = new AnonymousClass2(this, r2);
        this.f17525e = new AnonymousClass3(this, r2);
        this.f = new AnonymousClass4(this, r2);
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a
    public void insert(ShortcutTaskBean r2) {
        this.f17521a.i();
        this.f17521a.j();
        this.f17522b.insert(r2);     // Catch: Throwable -> L6
        this.f17521a.m();     // Catch: Throwable -> L6
        this.f17521a.k();
        return;
    L6:
        th = move-exception;
        this.f17521a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a
    public int delete(ShortcutTaskBean r2) {
        this.f17521a.i();
        this.f17521a.j();
        int r3 = this.f17524d.a(r2) + 0;     // Catch: Throwable -> L6
        this.f17521a.m();     // Catch: Throwable -> L6
        this.f17521a.k();
        return r3;
    L6:
        th = move-exception;
        this.f17521a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a
    public int update(ShortcutTaskBean r2) {
        this.f17521a.i();
        this.f17521a.j();
        int r3 = this.f17525e.a(r2) + 0;     // Catch: Throwable -> L6
        this.f17521a.m();     // Catch: Throwable -> L6
        this.f17521a.k();
        return r3;
    L6:
        th = move-exception;
        this.f17521a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a
    public int a(String r3, String r4, long r5) {
        this.f17521a.i();
        g r0 = this.f.c();
        r0.a(1, r5);
        if (r4 != null) goto L5;
        r0.a(2);
    L7:
        if (r3 != null) goto L9;
        r0.a(3);
    L10:
        this.f17521a.j();
        int r6 = r0.a();     // Catch: Throwable -> L14
        this.f17521a.m();     // Catch: Throwable -> L14
        this.f17521a.k();
        this.f.a(r0);
        return r6;
    L14:
        th = move-exception;
        this.f17521a.k();
        this.f.a(r0);
        throw th;
    L9:
        r0.a(3, r3);
        goto L10
    L5:
        r0.a(2, r4);
        goto L7
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a
    public ShortcutTaskBean a(String r37) {
        s r2 = s.a("SELECT * FROM shortcut_task_bean WHERE task_id = ?", 1);
        if (r37 != null) goto L5;
        r2.a(1);
    L6:
        this.f17521a.i();
        Cursor r1 = androidx.room.b.c.query(this.f17521a, r2, false, null);
        int r6 = androidx.room.b.b.b(r1, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L58
        int r7 = androidx.room.b.b.b(r1, "actions");     // Catch: Throwable -> L58
        int r8 = androidx.room.b.b.b(r1, "name");     // Catch: Throwable -> L58
        int r9 = androidx.room.b.b.b(r1, "task_mode");     // Catch: Throwable -> L58
        int r10 = androidx.room.b.b.b(r1, "task_knowledge");     // Catch: Throwable -> L58
        int r11 = androidx.room.b.b.b(r1, "template_id");     // Catch: Throwable -> L58
        int r12 = androidx.room.b.b.b(r1, "short_instruct");     // Catch: Throwable -> L58
        int r13 = androidx.room.b.b.b(r1, "is_short_instruct_enable");     // Catch: Throwable -> L58
        int r14 = androidx.room.b.b.b(r1, "source_from");     // Catch: Throwable -> L58
        int r15 = androidx.room.b.b.b(r1, "task_status");     // Catch: Throwable -> L58
        int r3 = androidx.room.b.b.b(r1, "enable_status");     // Catch: Throwable -> L58
        int r4 = androidx.room.b.b.b(r1, "create_time");     // Catch: Throwable -> L58
        int r5 = androidx.room.b.b.b(r1, "display_order");     // Catch: Throwable -> L58
        s r16 = r2;
        int r17 = androidx.room.b.b.b(r1, "ext");     // Catch: Throwable -> L56
        int r18 = androidx.room.b.b.b(r1, "omni_model");     // Catch: Throwable -> L56
        if (r1.moveToFirst() == true) goto L12;
        ShortcutTaskBean r19 = null;
    L54:
        r1.close();
        r16.a();
        return r19;
    L12:
        if (r1.isNull(r6) == false) goto L14;
        String r110 = null;
    L16:
        if (r1.isNull(r7) == false) goto L18;
        String r20 = null;
    L19:
        List<ShortcutTaskAction> r21 = this.f17523c.e(r20);     // Catch: Throwable -> L56
        if (r1.isNull(r8) == false) goto L22;
        String r22 = null;
    L23:
        int r23 = r1.getInt(r9);     // Catch: Throwable -> L56
        if (r1.isNull(r10) == false) goto L26;
        String r24 = null;
    L27:
        TaskKnowledge r25 = this.f17523c.f(r24);     // Catch: Throwable -> L56
        if (r1.isNull(r11) == false) goto L30;
        String r26 = null;
    L32:
        if (r1.isNull(r12) == false) goto L34;
        String r27 = null;
    L36:
        if (r1.getInt(r13) == 0) goto L38;
        boolean r28 = true;
    L40:
        if (r1.isNull(r14) == false) goto L42;
        String r29 = null;
    L43:
        int r210 = r1.getInt(r15);     // Catch: Throwable -> L56
        int r211 = r1.getInt(r3);     // Catch: Throwable -> L56
        long r30 = r1.getLong(r4);     // Catch: Throwable -> L56
        long r32 = r1.getLong(r5);     // Catch: Throwable -> L56
        if (r1.isNull(r17) == false) goto L46;
        String r31 = null;
    L47:
        Map<String, String> r34 = this.f17523c.d(r31);     // Catch: Throwable -> L56
        if (r1.isNull(r18) == false) goto L50;
        String r35 = null;
    L51:
        r19 = new ShortcutTaskBean(r110, r21, r22, r23, r25, r26, r27, r28, r29, r210, r211, r30, r32, r34, r35);     // Catch: Throwable -> L56
        goto L54
    L50:
        r35 = r1.getString(r18);     // Catch: Throwable -> L56
        goto L51
    L46:
        r31 = r1.getString(r17);     // Catch: Throwable -> L56
        goto L47
    L42:
        r29 = r1.getString(r14);     // Catch: Throwable -> L56
        goto L43
    L38:
        r28 = false;
        goto L40
    L34:
        r27 = r1.getString(r12);     // Catch: Throwable -> L56
        goto L36
    L30:
        r26 = r1.getString(r11);     // Catch: Throwable -> L56
        goto L32
    L26:
        r24 = r1.getString(r10);     // Catch: Throwable -> L56
        goto L27
    L22:
        r22 = r1.getString(r8);     // Catch: Throwable -> L56
        goto L23
    L18:
        r20 = r1.getString(r7);     // Catch: Throwable -> L56
        goto L19
    L14:
        r110 = r1.getString(r6);     // Catch: Throwable -> L56
    L56:
        th = th;
    L60:
        r1.close();
        r16.a();
        throw th;
    L58:
        th = th;
        r16 = r2;
        goto L60
    L5:
        r2.a(1, r37);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a
    public List<ShortcutTaskBean> a(String r39, int r40, int r41) {
        s r2 = s.a("SELECT * FROM shortcut_task_bean WHERE `source_from` =? ORDER BY display_order DESC LIMIT ? OFFSET ?", 3);
        if (r39 != null) goto L5;
        r2.a(1);
    L6:
        r2.a(2, r41);
        r2.a(3, r40);
        this.f17521a.i();
        Cursor r1 = androidx.room.b.c.query(this.f17521a, r2, false, null);
        int r6 = androidx.room.b.b.b(r1, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L58
        int r7 = androidx.room.b.b.b(r1, "actions");     // Catch: Throwable -> L58
        int r8 = androidx.room.b.b.b(r1, "name");     // Catch: Throwable -> L58
        int r9 = androidx.room.b.b.b(r1, "task_mode");     // Catch: Throwable -> L58
        int r10 = androidx.room.b.b.b(r1, "task_knowledge");     // Catch: Throwable -> L58
        int r11 = androidx.room.b.b.b(r1, "template_id");     // Catch: Throwable -> L58
        int r12 = androidx.room.b.b.b(r1, "short_instruct");     // Catch: Throwable -> L58
        int r13 = androidx.room.b.b.b(r1, "is_short_instruct_enable");     // Catch: Throwable -> L58
        int r14 = androidx.room.b.b.b(r1, "source_from");     // Catch: Throwable -> L58
        int r15 = androidx.room.b.b.b(r1, "task_status");     // Catch: Throwable -> L58
        int r3 = androidx.room.b.b.b(r1, "enable_status");     // Catch: Throwable -> L58
        int r4 = androidx.room.b.b.b(r1, "create_time");     // Catch: Throwable -> L58
        int r5 = androidx.room.b.b.b(r1, "display_order");     // Catch: Throwable -> L58
        s r16 = r2;
        int r42 = androidx.room.b.b.b(r1, "ext");     // Catch: Throwable -> L56
        int r17 = androidx.room.b.b.b(r1, "omni_model");     // Catch: Throwable -> L56
        int r18 = r5;
        ArrayList r19 = new ArrayList(r1.getCount());     // Catch: Throwable -> L56
    L10:
        if (r1.moveToNext() == false) goto L54;
        if (r1.isNull(r6) == false) goto L15;
        String r20 = null;
    L17:
        if (r1.isNull(r7) == false) goto L19;
        String r21 = null;
    L20:
        List<ShortcutTaskAction> r22 = this.f17523c.e(r21);     // Catch: Throwable -> L56
        if (r1.isNull(r8) == false) goto L23;
        String r23 = null;
    L24:
        int r24 = r1.getInt(r9);     // Catch: Throwable -> L56
        if (r1.isNull(r10) == false) goto L27;
        String r25 = null;
    L28:
        TaskKnowledge r26 = this.f17523c.f(r25);     // Catch: Throwable -> L56
        if (r1.isNull(r11) == false) goto L31;
        String r27 = null;
    L33:
        if (r1.isNull(r12) == false) goto L35;
        String r28 = null;
    L37:
        if (r1.getInt(r13) == 0) goto L39;
        boolean r29 = true;
    L41:
        if (r1.isNull(r14) == false) goto L43;
        String r210 = null;
    L44:
        int r211 = r1.getInt(r15);     // Catch: Throwable -> L56
        int r30 = r1.getInt(r3);     // Catch: Throwable -> L56
        long r31 = r1.getLong(r4);     // Catch: Throwable -> L56
        int r32 = r18;
        long r33 = r1.getLong(r32);     // Catch: Throwable -> L56
        int r34 = r42;
        if (r1.isNull(r34) == false) goto L47;
        String r35 = null;
    L48:
        Map<String, String> r36 = this.f17523c.d(r35);     // Catch: Throwable -> L56
        int r37 = r17;
        if (r1.isNull(r37) == false) goto L51;
        String r38 = null;
    L52:
        r19.add(new ShortcutTaskBean(r20, r22, r23, r24, r26, r27, r28, r29, r210, r211, r30, r31, r33, r36, r38));     // Catch: Throwable -> L56
        r17 = r37;
        r4 = r4;
        r3 = r3;
        r18 = r32;
        r42 = r34;
        r6 = r6;
        goto L10
    L51:
        r38 = r1.getString(r37);     // Catch: Throwable -> L56
        goto L52
    L47:
        r35 = r1.getString(r34);     // Catch: Throwable -> L56
        goto L48
    L43:
        r210 = r1.getString(r14);     // Catch: Throwable -> L56
        goto L44
    L39:
        r29 = false;
        goto L41
    L35:
        r28 = r1.getString(r12);     // Catch: Throwable -> L56
        goto L37
    L31:
        r27 = r1.getString(r11);     // Catch: Throwable -> L56
        goto L33
    L27:
        r25 = r1.getString(r10);     // Catch: Throwable -> L56
        goto L28
    L23:
        r23 = r1.getString(r8);     // Catch: Throwable -> L56
        goto L24
    L19:
        r21 = r1.getString(r7);     // Catch: Throwable -> L56
        goto L20
    L15:
        r20 = r1.getString(r6);     // Catch: Throwable -> L56
        goto L17
    L54:
        r1.close();
        r16.a();
        return r19;
    L56:
        th = th;
    L60:
        r1.close();
        r16.a();
        throw th;
    L58:
        th = th;
        r16 = r2;
        goto L60
    L5:
        r2.a(1, r39);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a
    public List<ShortcutTaskBean> b(String r40) {
        s r2 = s.a("SELECT * FROM shortcut_task_bean WHERE `source_from` =? and json_extract(task_knowledge, '$.sessionId') IS NOT NULL", 1);
        if (r40 != null) goto L5;
        r2.a(1);
    L6:
        this.f17521a.i();
        Cursor r1 = androidx.room.b.c.query(this.f17521a, r2, false, null);
        int r6 = androidx.room.b.b.b(r1, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L58
        int r7 = androidx.room.b.b.b(r1, "actions");     // Catch: Throwable -> L58
        int r8 = androidx.room.b.b.b(r1, "name");     // Catch: Throwable -> L58
        int r9 = androidx.room.b.b.b(r1, "task_mode");     // Catch: Throwable -> L58
        int r10 = androidx.room.b.b.b(r1, "task_knowledge");     // Catch: Throwable -> L58
        int r11 = androidx.room.b.b.b(r1, "template_id");     // Catch: Throwable -> L58
        int r12 = androidx.room.b.b.b(r1, "short_instruct");     // Catch: Throwable -> L58
        int r13 = androidx.room.b.b.b(r1, "is_short_instruct_enable");     // Catch: Throwable -> L58
        int r14 = androidx.room.b.b.b(r1, "source_from");     // Catch: Throwable -> L58
        int r15 = androidx.room.b.b.b(r1, "task_status");     // Catch: Throwable -> L58
        int r3 = androidx.room.b.b.b(r1, "enable_status");     // Catch: Throwable -> L58
        int r4 = androidx.room.b.b.b(r1, "create_time");     // Catch: Throwable -> L58
        int r5 = androidx.room.b.b.b(r1, "display_order");     // Catch: Throwable -> L58
        s r16 = r2;
        int r17 = androidx.room.b.b.b(r1, "ext");     // Catch: Throwable -> L56
        int r18 = androidx.room.b.b.b(r1, "omni_model");     // Catch: Throwable -> L56
        int r19 = r5;
        ArrayList r20 = new ArrayList(r1.getCount());     // Catch: Throwable -> L56
    L10:
        if (r1.moveToNext() == false) goto L54;
        if (r1.isNull(r6) == false) goto L15;
        String r21 = null;
    L17:
        if (r1.isNull(r7) == false) goto L19;
        String r22 = null;
    L20:
        List<ShortcutTaskAction> r23 = this.f17523c.e(r22);     // Catch: Throwable -> L56
        if (r1.isNull(r8) == false) goto L23;
        String r24 = null;
    L24:
        int r25 = r1.getInt(r9);     // Catch: Throwable -> L56
        if (r1.isNull(r10) == false) goto L27;
        String r26 = null;
    L28:
        TaskKnowledge r27 = this.f17523c.f(r26);     // Catch: Throwable -> L56
        if (r1.isNull(r11) == false) goto L31;
        String r28 = null;
    L33:
        if (r1.isNull(r12) == false) goto L35;
        String r29 = null;
    L37:
        if (r1.getInt(r13) == 0) goto L39;
        boolean r210 = true;
    L41:
        if (r1.isNull(r14) == false) goto L43;
        String r211 = null;
    L44:
        int r30 = r1.getInt(r15);     // Catch: Throwable -> L56
        int r31 = r1.getInt(r3);     // Catch: Throwable -> L56
        long r32 = r1.getLong(r4);     // Catch: Throwable -> L56
        int r33 = r19;
        long r34 = r1.getLong(r33);     // Catch: Throwable -> L56
        int r35 = r17;
        if (r1.isNull(r35) == false) goto L47;
        String r36 = null;
    L48:
        Map<String, String> r37 = this.f17523c.d(r36);     // Catch: Throwable -> L56
        int r38 = r18;
        if (r1.isNull(r38) == false) goto L51;
        String r39 = null;
    L52:
        r20.add(new ShortcutTaskBean(r21, r23, r24, r25, r27, r28, r29, r210, r211, r30, r31, r32, r34, r37, r39));     // Catch: Throwable -> L56
        r18 = r38;
        r4 = r4;
        r3 = r3;
        r19 = r33;
        r17 = r35;
        r6 = r6;
        goto L10
    L51:
        r39 = r1.getString(r38);     // Catch: Throwable -> L56
        goto L52
    L47:
        r36 = r1.getString(r35);     // Catch: Throwable -> L56
        goto L48
    L43:
        r211 = r1.getString(r14);     // Catch: Throwable -> L56
        goto L44
    L39:
        r210 = false;
        goto L41
    L35:
        r29 = r1.getString(r12);     // Catch: Throwable -> L56
        goto L37
    L31:
        r28 = r1.getString(r11);     // Catch: Throwable -> L56
        goto L33
    L27:
        r26 = r1.getString(r10);     // Catch: Throwable -> L56
        goto L28
    L23:
        r24 = r1.getString(r8);     // Catch: Throwable -> L56
        goto L24
    L19:
        r22 = r1.getString(r7);     // Catch: Throwable -> L56
        goto L20
    L15:
        r21 = r1.getString(r6);     // Catch: Throwable -> L56
        goto L17
    L54:
        r1.close();
        r16.a();
        return r20;
    L56:
        th = th;
    L60:
        r1.close();
        r16.a();
        throw th;
    L58:
        th = th;
        r16 = r2;
        goto L60
    L5:
        r2.a(1, r40);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a
    public List<ShortcutTaskBean> c(String r40) {
        s r2 = s.a("SELECT * FROM shortcut_task_bean WHERE `source_from` =? and template_id IS NOT NULL", 1);
        if (r40 != null) goto L5;
        r2.a(1);
    L6:
        this.f17521a.i();
        Cursor r1 = androidx.room.b.c.query(this.f17521a, r2, false, null);
        int r6 = androidx.room.b.b.b(r1, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L58
        int r7 = androidx.room.b.b.b(r1, "actions");     // Catch: Throwable -> L58
        int r8 = androidx.room.b.b.b(r1, "name");     // Catch: Throwable -> L58
        int r9 = androidx.room.b.b.b(r1, "task_mode");     // Catch: Throwable -> L58
        int r10 = androidx.room.b.b.b(r1, "task_knowledge");     // Catch: Throwable -> L58
        int r11 = androidx.room.b.b.b(r1, "template_id");     // Catch: Throwable -> L58
        int r12 = androidx.room.b.b.b(r1, "short_instruct");     // Catch: Throwable -> L58
        int r13 = androidx.room.b.b.b(r1, "is_short_instruct_enable");     // Catch: Throwable -> L58
        int r14 = androidx.room.b.b.b(r1, "source_from");     // Catch: Throwable -> L58
        int r15 = androidx.room.b.b.b(r1, "task_status");     // Catch: Throwable -> L58
        int r3 = androidx.room.b.b.b(r1, "enable_status");     // Catch: Throwable -> L58
        int r4 = androidx.room.b.b.b(r1, "create_time");     // Catch: Throwable -> L58
        int r5 = androidx.room.b.b.b(r1, "display_order");     // Catch: Throwable -> L58
        s r16 = r2;
        int r17 = androidx.room.b.b.b(r1, "ext");     // Catch: Throwable -> L56
        int r18 = androidx.room.b.b.b(r1, "omni_model");     // Catch: Throwable -> L56
        int r19 = r5;
        ArrayList r20 = new ArrayList(r1.getCount());     // Catch: Throwable -> L56
    L10:
        if (r1.moveToNext() == false) goto L54;
        if (r1.isNull(r6) == false) goto L15;
        String r21 = null;
    L17:
        if (r1.isNull(r7) == false) goto L19;
        String r22 = null;
    L20:
        List<ShortcutTaskAction> r23 = this.f17523c.e(r22);     // Catch: Throwable -> L56
        if (r1.isNull(r8) == false) goto L23;
        String r24 = null;
    L24:
        int r25 = r1.getInt(r9);     // Catch: Throwable -> L56
        if (r1.isNull(r10) == false) goto L27;
        String r26 = null;
    L28:
        TaskKnowledge r27 = this.f17523c.f(r26);     // Catch: Throwable -> L56
        if (r1.isNull(r11) == false) goto L31;
        String r28 = null;
    L33:
        if (r1.isNull(r12) == false) goto L35;
        String r29 = null;
    L37:
        if (r1.getInt(r13) == 0) goto L39;
        boolean r210 = true;
    L41:
        if (r1.isNull(r14) == false) goto L43;
        String r211 = null;
    L44:
        int r30 = r1.getInt(r15);     // Catch: Throwable -> L56
        int r31 = r1.getInt(r3);     // Catch: Throwable -> L56
        long r32 = r1.getLong(r4);     // Catch: Throwable -> L56
        int r33 = r19;
        long r34 = r1.getLong(r33);     // Catch: Throwable -> L56
        int r35 = r17;
        if (r1.isNull(r35) == false) goto L47;
        String r36 = null;
    L48:
        Map<String, String> r37 = this.f17523c.d(r36);     // Catch: Throwable -> L56
        int r38 = r18;
        if (r1.isNull(r38) == false) goto L51;
        String r39 = null;
    L52:
        r20.add(new ShortcutTaskBean(r21, r23, r24, r25, r27, r28, r29, r210, r211, r30, r31, r32, r34, r37, r39));     // Catch: Throwable -> L56
        r18 = r38;
        r4 = r4;
        r3 = r3;
        r19 = r33;
        r17 = r35;
        r6 = r6;
        goto L10
    L51:
        r39 = r1.getString(r38);     // Catch: Throwable -> L56
        goto L52
    L47:
        r36 = r1.getString(r35);     // Catch: Throwable -> L56
        goto L48
    L43:
        r211 = r1.getString(r14);     // Catch: Throwable -> L56
        goto L44
    L39:
        r210 = false;
        goto L41
    L35:
        r29 = r1.getString(r12);     // Catch: Throwable -> L56
        goto L37
    L31:
        r28 = r1.getString(r11);     // Catch: Throwable -> L56
        goto L33
    L27:
        r26 = r1.getString(r10);     // Catch: Throwable -> L56
        goto L28
    L23:
        r24 = r1.getString(r8);     // Catch: Throwable -> L56
        goto L24
    L19:
        r22 = r1.getString(r7);     // Catch: Throwable -> L56
        goto L20
    L15:
        r21 = r1.getString(r6);     // Catch: Throwable -> L56
        goto L17
    L54:
        r1.close();
        r16.a();
        return r20;
    L56:
        th = th;
    L60:
        r1.close();
        r16.a();
        throw th;
    L58:
        th = th;
        r16 = r2;
        goto L60
    L5:
        r2.a(1, r40);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a
    public List<ShortcutTaskBean> d(String r40) {
        s r2 = s.a("SELECT * FROM shortcut_task_bean WHERE `source_from` =? and short_instruct IS NOT NULL", 1);
        if (r40 != null) goto L5;
        r2.a(1);
    L6:
        this.f17521a.i();
        Cursor r1 = androidx.room.b.c.query(this.f17521a, r2, false, null);
        int r6 = androidx.room.b.b.b(r1, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L58
        int r7 = androidx.room.b.b.b(r1, "actions");     // Catch: Throwable -> L58
        int r8 = androidx.room.b.b.b(r1, "name");     // Catch: Throwable -> L58
        int r9 = androidx.room.b.b.b(r1, "task_mode");     // Catch: Throwable -> L58
        int r10 = androidx.room.b.b.b(r1, "task_knowledge");     // Catch: Throwable -> L58
        int r11 = androidx.room.b.b.b(r1, "template_id");     // Catch: Throwable -> L58
        int r12 = androidx.room.b.b.b(r1, "short_instruct");     // Catch: Throwable -> L58
        int r13 = androidx.room.b.b.b(r1, "is_short_instruct_enable");     // Catch: Throwable -> L58
        int r14 = androidx.room.b.b.b(r1, "source_from");     // Catch: Throwable -> L58
        int r15 = androidx.room.b.b.b(r1, "task_status");     // Catch: Throwable -> L58
        int r3 = androidx.room.b.b.b(r1, "enable_status");     // Catch: Throwable -> L58
        int r4 = androidx.room.b.b.b(r1, "create_time");     // Catch: Throwable -> L58
        int r5 = androidx.room.b.b.b(r1, "display_order");     // Catch: Throwable -> L58
        s r16 = r2;
        int r17 = androidx.room.b.b.b(r1, "ext");     // Catch: Throwable -> L56
        int r18 = androidx.room.b.b.b(r1, "omni_model");     // Catch: Throwable -> L56
        int r19 = r5;
        ArrayList r20 = new ArrayList(r1.getCount());     // Catch: Throwable -> L56
    L10:
        if (r1.moveToNext() == false) goto L54;
        if (r1.isNull(r6) == false) goto L15;
        String r21 = null;
    L17:
        if (r1.isNull(r7) == false) goto L19;
        String r22 = null;
    L20:
        List<ShortcutTaskAction> r23 = this.f17523c.e(r22);     // Catch: Throwable -> L56
        if (r1.isNull(r8) == false) goto L23;
        String r24 = null;
    L24:
        int r25 = r1.getInt(r9);     // Catch: Throwable -> L56
        if (r1.isNull(r10) == false) goto L27;
        String r26 = null;
    L28:
        TaskKnowledge r27 = this.f17523c.f(r26);     // Catch: Throwable -> L56
        if (r1.isNull(r11) == false) goto L31;
        String r28 = null;
    L33:
        if (r1.isNull(r12) == false) goto L35;
        String r29 = null;
    L37:
        if (r1.getInt(r13) == 0) goto L39;
        boolean r210 = true;
    L41:
        if (r1.isNull(r14) == false) goto L43;
        String r211 = null;
    L44:
        int r30 = r1.getInt(r15);     // Catch: Throwable -> L56
        int r31 = r1.getInt(r3);     // Catch: Throwable -> L56
        long r32 = r1.getLong(r4);     // Catch: Throwable -> L56
        int r33 = r19;
        long r34 = r1.getLong(r33);     // Catch: Throwable -> L56
        int r35 = r17;
        if (r1.isNull(r35) == false) goto L47;
        String r36 = null;
    L48:
        Map<String, String> r37 = this.f17523c.d(r36);     // Catch: Throwable -> L56
        int r38 = r18;
        if (r1.isNull(r38) == false) goto L51;
        String r39 = null;
    L52:
        r20.add(new ShortcutTaskBean(r21, r23, r24, r25, r27, r28, r29, r210, r211, r30, r31, r32, r34, r37, r39));     // Catch: Throwable -> L56
        r18 = r38;
        r4 = r4;
        r3 = r3;
        r19 = r33;
        r17 = r35;
        r6 = r6;
        goto L10
    L51:
        r39 = r1.getString(r38);     // Catch: Throwable -> L56
        goto L52
    L47:
        r36 = r1.getString(r35);     // Catch: Throwable -> L56
        goto L48
    L43:
        r211 = r1.getString(r14);     // Catch: Throwable -> L56
        goto L44
    L39:
        r210 = false;
        goto L41
    L35:
        r29 = r1.getString(r12);     // Catch: Throwable -> L56
        goto L37
    L31:
        r28 = r1.getString(r11);     // Catch: Throwable -> L56
        goto L33
    L27:
        r26 = r1.getString(r10);     // Catch: Throwable -> L56
        goto L28
    L23:
        r24 = r1.getString(r8);     // Catch: Throwable -> L56
        goto L24
    L19:
        r22 = r1.getString(r7);     // Catch: Throwable -> L56
        goto L20
    L15:
        r21 = r1.getString(r6);     // Catch: Throwable -> L56
        goto L17
    L54:
        r1.close();
        r16.a();
        return r20;
    L56:
        th = th;
    L60:
        r1.close();
        r16.a();
        throw th;
    L58:
        th = th;
        r16 = r2;
        goto L60
    L5:
        r2.a(1, r40);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a
    public List<ShortcutTaskBean> a() {
        s r1 = s.a("SELECT * FROM shortcut_task_bean WHERE short_instruct IS NOT NULL and is_short_instruct_enable = 1", 0);
        this.f17521a.i();
        Cursor r3 = androidx.room.b.c.query(this.f17521a, r1, false, null);
        int r5 = androidx.room.b.b.b(r3, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L54
        int r6 = androidx.room.b.b.b(r3, "actions");     // Catch: Throwable -> L54
        int r7 = androidx.room.b.b.b(r3, "name");     // Catch: Throwable -> L54
        int r8 = androidx.room.b.b.b(r3, "task_mode");     // Catch: Throwable -> L54
        int r9 = androidx.room.b.b.b(r3, "task_knowledge");     // Catch: Throwable -> L54
        int r10 = androidx.room.b.b.b(r3, "template_id");     // Catch: Throwable -> L54
        int r11 = androidx.room.b.b.b(r3, "short_instruct");     // Catch: Throwable -> L54
        int r12 = androidx.room.b.b.b(r3, "is_short_instruct_enable");     // Catch: Throwable -> L54
        int r13 = androidx.room.b.b.b(r3, "source_from");     // Catch: Throwable -> L54
        int r14 = androidx.room.b.b.b(r3, "task_status");     // Catch: Throwable -> L54
        int r15 = androidx.room.b.b.b(r3, "enable_status");     // Catch: Throwable -> L54
        int r2 = androidx.room.b.b.b(r3, "create_time");     // Catch: Throwable -> L54
        int r4 = androidx.room.b.b.b(r3, "display_order");     // Catch: Throwable -> L54
        s r16 = r1;
        int r17 = androidx.room.b.b.b(r3, "ext");     // Catch: Throwable -> L52
        int r18 = androidx.room.b.b.b(r3, "omni_model");     // Catch: Throwable -> L52
        int r19 = r4;
        ArrayList r20 = new ArrayList(r3.getCount());     // Catch: Throwable -> L52
    L6:
        if (r3.moveToNext() == false) goto L50;
        if (r3.isNull(r5) == false) goto L11;
        String r21 = null;
    L13:
        if (r3.isNull(r6) == false) goto L15;
        String r22 = null;
    L16:
        List<ShortcutTaskAction> r23 = this.f17523c.e(r22);     // Catch: Throwable -> L52
        if (r3.isNull(r7) == false) goto L19;
        String r24 = null;
    L20:
        int r25 = r3.getInt(r8);     // Catch: Throwable -> L52
        if (r3.isNull(r9) == false) goto L23;
        String r26 = null;
    L24:
        TaskKnowledge r27 = this.f17523c.f(r26);     // Catch: Throwable -> L52
        if (r3.isNull(r10) == false) goto L27;
        String r28 = null;
    L29:
        if (r3.isNull(r11) == false) goto L31;
        String r29 = null;
    L33:
        if (r3.getInt(r12) == 0) goto L35;
        boolean r210 = true;
    L37:
        if (r3.isNull(r13) == false) goto L39;
        String r211 = null;
    L40:
        int r30 = r3.getInt(r14);     // Catch: Throwable -> L52
        int r31 = r3.getInt(r15);     // Catch: Throwable -> L52
        long r32 = r3.getLong(r2);     // Catch: Throwable -> L52
        int r33 = r19;
        long r34 = r3.getLong(r33);     // Catch: Throwable -> L52
        int r35 = r17;
        if (r3.isNull(r35) == false) goto L43;
        String r36 = null;
    L44:
        Map<String, String> r37 = this.f17523c.d(r36);     // Catch: Throwable -> L52
        int r38 = r18;
        if (r3.isNull(r38) == false) goto L47;
        String r39 = null;
    L48:
        r20.add(new ShortcutTaskBean(r21, r23, r24, r25, r27, r28, r29, r210, r211, r30, r31, r32, r34, r37, r39));     // Catch: Throwable -> L52
        r18 = r38;
        r2 = r2;
        r19 = r33;
        r17 = r35;
        r5 = r5;
        goto L6
    L47:
        r39 = r3.getString(r38);     // Catch: Throwable -> L52
        goto L48
    L43:
        r36 = r3.getString(r35);     // Catch: Throwable -> L52
        goto L44
    L39:
        r211 = r3.getString(r13);     // Catch: Throwable -> L52
        goto L40
    L35:
        r210 = false;
        goto L37
    L31:
        r29 = r3.getString(r11);     // Catch: Throwable -> L52
        goto L33
    L27:
        r28 = r3.getString(r10);     // Catch: Throwable -> L52
        goto L29
    L23:
        r26 = r3.getString(r9);     // Catch: Throwable -> L52
        goto L24
    L19:
        r24 = r3.getString(r7);     // Catch: Throwable -> L52
        goto L20
    L15:
        r22 = r3.getString(r6);     // Catch: Throwable -> L52
        goto L16
    L11:
        r21 = r3.getString(r5);     // Catch: Throwable -> L52
        goto L13
    L50:
        r3.close();
        r16.a();
        return r20;
    L52:
        th = th;
    L56:
        r3.close();
        r16.a();
        throw th;
    L54:
        th = th;
        r16 = r1;
        goto L56
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a
    public List<ShortcutTaskBean> a(int r40, int r41) {
        s r1 = s.a("SELECT * FROM shortcut_task_bean ORDER BY display_order DESC LIMIT ? OFFSET ?", 2);
        r1.a(1, r41);
        r1.a(2, r40);
        this.f17521a.i();
        Cursor r2 = androidx.room.b.c.query(this.f17521a, r1, false, null);
        int r6 = androidx.room.b.b.b(r2, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L54
        int r7 = androidx.room.b.b.b(r2, "actions");     // Catch: Throwable -> L54
        int r8 = androidx.room.b.b.b(r2, "name");     // Catch: Throwable -> L54
        int r9 = androidx.room.b.b.b(r2, "task_mode");     // Catch: Throwable -> L54
        int r10 = androidx.room.b.b.b(r2, "task_knowledge");     // Catch: Throwable -> L54
        int r11 = androidx.room.b.b.b(r2, "template_id");     // Catch: Throwable -> L54
        int r12 = androidx.room.b.b.b(r2, "short_instruct");     // Catch: Throwable -> L54
        int r13 = androidx.room.b.b.b(r2, "is_short_instruct_enable");     // Catch: Throwable -> L54
        int r14 = androidx.room.b.b.b(r2, "source_from");     // Catch: Throwable -> L54
        int r15 = androidx.room.b.b.b(r2, "task_status");     // Catch: Throwable -> L54
        int r3 = androidx.room.b.b.b(r2, "enable_status");     // Catch: Throwable -> L54
        int r4 = androidx.room.b.b.b(r2, "create_time");     // Catch: Throwable -> L54
        int r5 = androidx.room.b.b.b(r2, "display_order");     // Catch: Throwable -> L54
        s r16 = r1;
        int r17 = androidx.room.b.b.b(r2, "ext");     // Catch: Throwable -> L52
        int r18 = androidx.room.b.b.b(r2, "omni_model");     // Catch: Throwable -> L52
        int r19 = r5;
        ArrayList r20 = new ArrayList(r2.getCount());     // Catch: Throwable -> L52
    L6:
        if (r2.moveToNext() == false) goto L50;
        if (r2.isNull(r6) == false) goto L11;
        String r21 = null;
    L13:
        if (r2.isNull(r7) == false) goto L15;
        String r22 = null;
    L16:
        List<ShortcutTaskAction> r23 = this.f17523c.e(r22);     // Catch: Throwable -> L52
        if (r2.isNull(r8) == false) goto L19;
        String r24 = null;
    L20:
        int r25 = r2.getInt(r9);     // Catch: Throwable -> L52
        if (r2.isNull(r10) == false) goto L23;
        String r26 = null;
    L24:
        TaskKnowledge r27 = this.f17523c.f(r26);     // Catch: Throwable -> L52
        if (r2.isNull(r11) == false) goto L27;
        String r28 = null;
    L29:
        if (r2.isNull(r12) == false) goto L31;
        String r29 = null;
    L33:
        if (r2.getInt(r13) == 0) goto L35;
        boolean r210 = true;
    L37:
        if (r2.isNull(r14) == false) goto L39;
        String r211 = null;
    L40:
        int r30 = r2.getInt(r15);     // Catch: Throwable -> L52
        int r31 = r2.getInt(r3);     // Catch: Throwable -> L52
        long r32 = r2.getLong(r4);     // Catch: Throwable -> L52
        int r33 = r19;
        long r34 = r2.getLong(r33);     // Catch: Throwable -> L52
        int r35 = r17;
        if (r2.isNull(r35) == false) goto L43;
        String r36 = null;
    L44:
        Map<String, String> r37 = this.f17523c.d(r36);     // Catch: Throwable -> L52
        int r38 = r18;
        if (r2.isNull(r38) == false) goto L47;
        String r39 = null;
    L48:
        r20.add(new ShortcutTaskBean(r21, r23, r24, r25, r27, r28, r29, r210, r211, r30, r31, r32, r34, r37, r39));     // Catch: Throwable -> L52
        r18 = r38;
        r4 = r4;
        r3 = r3;
        r19 = r33;
        r17 = r35;
        r6 = r6;
        goto L6
    L47:
        r39 = r2.getString(r38);     // Catch: Throwable -> L52
        goto L48
    L43:
        r36 = r2.getString(r35);     // Catch: Throwable -> L52
        goto L44
    L39:
        r211 = r2.getString(r14);     // Catch: Throwable -> L52
        goto L40
    L35:
        r210 = false;
        goto L37
    L31:
        r29 = r2.getString(r12);     // Catch: Throwable -> L52
        goto L33
    L27:
        r28 = r2.getString(r11);     // Catch: Throwable -> L52
        goto L29
    L23:
        r26 = r2.getString(r10);     // Catch: Throwable -> L52
        goto L24
    L19:
        r24 = r2.getString(r8);     // Catch: Throwable -> L52
        goto L20
    L15:
        r22 = r2.getString(r7);     // Catch: Throwable -> L52
        goto L16
    L11:
        r21 = r2.getString(r6);     // Catch: Throwable -> L52
        goto L13
    L50:
        r2.close();
        r16.a();
        return r20;
    L52:
        th = th;
    L56:
        r2.close();
        r16.a();
        throw th;
    L54:
        th = th;
        r16 = r1;
        goto L56
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a
    public List<ShortcutTaskBean> e(String r40) {
        s r2 = s.a("SELECT * FROM shortcut_task_bean WHERE short_instruct = ?", 1);
        if (r40 != null) goto L5;
        r2.a(1);
    L6:
        this.f17521a.i();
        Cursor r1 = androidx.room.b.c.query(this.f17521a, r2, false, null);
        int r6 = androidx.room.b.b.b(r1, KnowledgeActivity.KEY_TASK_ID);     // Catch: Throwable -> L58
        int r7 = androidx.room.b.b.b(r1, "actions");     // Catch: Throwable -> L58
        int r8 = androidx.room.b.b.b(r1, "name");     // Catch: Throwable -> L58
        int r9 = androidx.room.b.b.b(r1, "task_mode");     // Catch: Throwable -> L58
        int r10 = androidx.room.b.b.b(r1, "task_knowledge");     // Catch: Throwable -> L58
        int r11 = androidx.room.b.b.b(r1, "template_id");     // Catch: Throwable -> L58
        int r12 = androidx.room.b.b.b(r1, "short_instruct");     // Catch: Throwable -> L58
        int r13 = androidx.room.b.b.b(r1, "is_short_instruct_enable");     // Catch: Throwable -> L58
        int r14 = androidx.room.b.b.b(r1, "source_from");     // Catch: Throwable -> L58
        int r15 = androidx.room.b.b.b(r1, "task_status");     // Catch: Throwable -> L58
        int r3 = androidx.room.b.b.b(r1, "enable_status");     // Catch: Throwable -> L58
        int r4 = androidx.room.b.b.b(r1, "create_time");     // Catch: Throwable -> L58
        int r5 = androidx.room.b.b.b(r1, "display_order");     // Catch: Throwable -> L58
        s r16 = r2;
        int r17 = androidx.room.b.b.b(r1, "ext");     // Catch: Throwable -> L56
        int r18 = androidx.room.b.b.b(r1, "omni_model");     // Catch: Throwable -> L56
        int r19 = r5;
        ArrayList r20 = new ArrayList(r1.getCount());     // Catch: Throwable -> L56
    L10:
        if (r1.moveToNext() == false) goto L54;
        if (r1.isNull(r6) == false) goto L15;
        String r21 = null;
    L17:
        if (r1.isNull(r7) == false) goto L19;
        String r22 = null;
    L20:
        List<ShortcutTaskAction> r23 = this.f17523c.e(r22);     // Catch: Throwable -> L56
        if (r1.isNull(r8) == false) goto L23;
        String r24 = null;
    L24:
        int r25 = r1.getInt(r9);     // Catch: Throwable -> L56
        if (r1.isNull(r10) == false) goto L27;
        String r26 = null;
    L28:
        TaskKnowledge r27 = this.f17523c.f(r26);     // Catch: Throwable -> L56
        if (r1.isNull(r11) == false) goto L31;
        String r28 = null;
    L33:
        if (r1.isNull(r12) == false) goto L35;
        String r29 = null;
    L37:
        if (r1.getInt(r13) == 0) goto L39;
        boolean r210 = true;
    L41:
        if (r1.isNull(r14) == false) goto L43;
        String r211 = null;
    L44:
        int r30 = r1.getInt(r15);     // Catch: Throwable -> L56
        int r31 = r1.getInt(r3);     // Catch: Throwable -> L56
        long r32 = r1.getLong(r4);     // Catch: Throwable -> L56
        int r33 = r19;
        long r34 = r1.getLong(r33);     // Catch: Throwable -> L56
        int r35 = r17;
        if (r1.isNull(r35) == false) goto L47;
        String r36 = null;
    L48:
        Map<String, String> r37 = this.f17523c.d(r36);     // Catch: Throwable -> L56
        int r38 = r18;
        if (r1.isNull(r38) == false) goto L51;
        String r39 = null;
    L52:
        r20.add(new ShortcutTaskBean(r21, r23, r24, r25, r27, r28, r29, r210, r211, r30, r31, r32, r34, r37, r39));     // Catch: Throwable -> L56
        r18 = r38;
        r4 = r4;
        r3 = r3;
        r19 = r33;
        r17 = r35;
        r6 = r6;
        goto L10
    L51:
        r39 = r1.getString(r38);     // Catch: Throwable -> L56
        goto L52
    L47:
        r36 = r1.getString(r35);     // Catch: Throwable -> L56
        goto L48
    L43:
        r211 = r1.getString(r14);     // Catch: Throwable -> L56
        goto L44
    L39:
        r210 = false;
        goto L41
    L35:
        r29 = r1.getString(r12);     // Catch: Throwable -> L56
        goto L37
    L31:
        r28 = r1.getString(r11);     // Catch: Throwable -> L56
        goto L33
    L27:
        r26 = r1.getString(r10);     // Catch: Throwable -> L56
        goto L28
    L23:
        r24 = r1.getString(r8);     // Catch: Throwable -> L56
        goto L24
    L19:
        r22 = r1.getString(r7);     // Catch: Throwable -> L56
        goto L20
    L15:
        r21 = r1.getString(r6);     // Catch: Throwable -> L56
        goto L17
    L54:
        r1.close();
        r16.a();
        return r20;
    L56:
        th = th;
    L60:
        r1.close();
        r16.a();
        throw th;
    L58:
        th = th;
        r16 = r2;
        goto L60
    L5:
        r2.a(1, r40);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a
    public Long b() {
        s r0 = s.a("SELECT MIN(display_order) FROM shortcut_task_bean", 0);
        this.f17521a.i();
        Long r2 = null;
        Cursor r4 = androidx.room.b.c.query(this.f17521a, r0, false, null);
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

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a
    public List<Long> a(String r7, List<String> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        StringBuilder r0 = androidx.room.b.f.a();
        r0.append("SELECT display_order FROM shortcut_task_bean WHERE task_id IN (");
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
        this.f17521a.i();
        Cursor r6 = androidx.room.b.c.query(this.f17521a, r1, false, null);
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
