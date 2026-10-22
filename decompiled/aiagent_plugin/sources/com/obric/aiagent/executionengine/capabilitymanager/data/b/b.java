package com.obric.aiagent.executionengine.capabilitymanager.data.b;

import android.database.Cursor;
import androidx.room.e;
import androidx.room.f;
import androidx.room.p;
import androidx.room.s;
import androidx.room.v;
import androidx.sqlite.db.g;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: IntentDao_Impl.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f16431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> f16432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> f16433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> f16434d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final v f16435e;
    private final v f;

    public b(final p r2) {
        this.f16431a = r2;
        this.f16432b = new AnonymousClass1(this, r2);
        this.f16433c = new AnonymousClass2(this, r2);
        this.f16434d = new AnonymousClass3(this, r2);
        this.f16435e = new AnonymousClass4(this, r2);
        this.f = new AnonymousClass5(this, r2);
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.data.b.a
    public long a(com.obric.aiagent.executionengine.capabilitymanager.data.bean.a r3) {
        this.f16431a.i();
        this.f16431a.j();
        long r0 = this.f16432b.a(r3);     // Catch: Throwable -> L6
        this.f16431a.m();     // Catch: Throwable -> L6
        this.f16431a.k();
        return r0;
    L6:
        th = move-exception;
        this.f16431a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.data.b.a
    public List<Long> b(List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.f16431a.i();
        this.f16431a.j();
        List<Long> r5 = this.f16432b.a(r4);     // Catch: Throwable -> L6
        this.f16431a.m();     // Catch: Throwable -> L6
        this.f16431a.k();
        return r5;
    L6:
        th = move-exception;
        this.f16431a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.data.b.a
    public int c(List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.f16431a.i();
        this.f16431a.j();
        int r5 = this.f16433c.a(r4) + 0;     // Catch: Throwable -> L6
        this.f16431a.m();     // Catch: Throwable -> L6
        this.f16431a.k();
        return r5;
    L6:
        th = move-exception;
        this.f16431a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.data.b.a
    public int e(List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.f16431a.i();
        this.f16431a.j();
        int r5 = this.f16434d.a(r4) + 0;     // Catch: Throwable -> L6
        this.f16431a.m();     // Catch: Throwable -> L6
        this.f16431a.k();
        return r5;
    L6:
        th = move-exception;
        this.f16431a.k();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.data.b.a
    public int c(String r3) {
        this.f16431a.i();
        g r0 = this.f16435e.c();
        if (r3 != null) goto L5;
        r0.a(1);
    L6:
        this.f16431a.j();
        int r4 = r0.a();     // Catch: Throwable -> L10
        this.f16431a.m();     // Catch: Throwable -> L10
        this.f16431a.k();
        this.f16435e.a(r0);
        return r4;
    L10:
        th = move-exception;
        this.f16431a.k();
        this.f16435e.a(r0);
        throw th;
    L5:
        r0.a(1, r3);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.data.b.a
    public int a(String r4, boolean r5) {
        this.f16431a.i();
        g r0 = this.f.c();
        if (r4 != null) goto L5;
        r0.a(1);
    L6:
        r0.a(2, r5 ? 1 : 0);
        this.f16431a.j();
        int r6 = r0.a();     // Catch: Throwable -> L10
        this.f16431a.m();     // Catch: Throwable -> L10
        this.f16431a.k();
        this.f.a(r0);
        return r6;
    L10:
        th = move-exception;
        this.f16431a.k();
        this.f.a(r0);
        throw th;
    L5:
        r0.a(1, r4);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.data.b.a
    public List<String> a() {
        s r0 = s.a("SELECT DISTINCT pkg_name FROM intent_bean WHERE state = 1", 0);
        this.f16431a.i();
        Cursor r5 = androidx.room.b.c.query(this.f16431a, r0, false, null);
        ArrayList r3 = new ArrayList(r5.getCount());     // Catch: Throwable -> L14
    L4:
        if (r5.moveToNext() == false) goto L12;
        if (r5.isNull(0) == false) goto L9;
        String r4 = null;
    L10:
        r3.add(r4);     // Catch: Throwable -> L14
        goto L4
    L9:
        r4 = r5.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r5.close();
        r0.a();
        return r3;
    L14:
        th = move-exception;
        r5.close();
        r0.a();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.data.b.a
    public com.obric.aiagent.executionengine.capabilitymanager.data.bean.a a(String r23) {
        s r2 = s.a("SELECT * FROM intent_bean WHERE `key` =?", 1);
        if (r23 != null) goto L5;
        r2.a(1);
    L6:
        this.f16431a.i();
        com.obric.aiagent.executionengine.capabilitymanager.data.bean.a r4 = null;
        String r5 = null;
        Cursor r6 = androidx.room.b.c.query(this.f16431a, r2, false, null);
        int r0 = androidx.room.b.b.b(r6, "name");     // Catch: Throwable -> L40
        int r7 = androidx.room.b.b.b(r6, "pkg_name");     // Catch: Throwable -> L40
        int r8 = androidx.room.b.b.b(r6, "impl_class");     // Catch: Throwable -> L40
        int r9 = androidx.room.b.b.b(r6, "is_static_register");     // Catch: Throwable -> L40
        int r10 = androidx.room.b.b.b(r6, "key");     // Catch: Throwable -> L40
        int r11 = androidx.room.b.b.b(r6, "registered");     // Catch: Throwable -> L40
        int r12 = androidx.room.b.b.b(r6, "state");     // Catch: Throwable -> L40
        int r13 = androidx.room.b.b.b(r6, WsConstants.KEY_SERVICE);     // Catch: Throwable -> L40
        if (r6.moveToFirst() == true) goto L10;
    L38:
        r6.close();
        r2.a();
        return r4;
    L10:
        if (r6.isNull(r0) == false) goto L12;
        String r14 = null;
    L14:
        if (r6.isNull(r7) == false) goto L16;
        String r15 = null;
    L18:
        if (r6.isNull(r8) == false) goto L20;
        String r16 = null;
    L22:
        if (r6.getInt(r9) == 0) goto L24;
        boolean r17 = true;
    L26:
        if (r6.isNull(r10) == false) goto L28;
        String r18 = null;
    L30:
        if (r6.getInt(r11) == 0) goto L32;
        boolean r19 = true;
    L33:
        int r20 = r6.getInt(r12);     // Catch: Throwable -> L40
        if (r6.isNull(r13) == true) goto L37;
        r5 = r6.getString(r13);     // Catch: Throwable -> L40
    L37:
        r4 = new com.obric.aiagent.executionengine.capabilitymanager.data.bean.a(r14, r15, r16, r17, r18, r19, r20, r5);     // Catch: Throwable -> L40
        goto L38
    L32:
        r19 = false;
        goto L33
    L28:
        r18 = r6.getString(r10);     // Catch: Throwable -> L40
        goto L30
    L24:
        r17 = false;
        goto L26
    L20:
        r16 = r6.getString(r8);     // Catch: Throwable -> L40
        goto L22
    L16:
        r15 = r6.getString(r7);     // Catch: Throwable -> L40
        goto L18
    L12:
        r14 = r6.getString(r0);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        r6.close();
        r2.a();
        throw th;
    L5:
        r2.a(1, r23);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.data.b.a
    public List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> b(String r25) {
        s r2 = s.a("SELECT * FROM intent_bean WHERE `name` =? AND state = 1", 1);
        if (r25 != null) goto L5;
        r2.a(1);
    L6:
        this.f16431a.i();
        Cursor r5 = androidx.room.b.c.query(this.f16431a, r2, false, null);
        int r0 = androidx.room.b.b.b(r5, "name");     // Catch: Throwable -> L42
        int r6 = androidx.room.b.b.b(r5, "pkg_name");     // Catch: Throwable -> L42
        int r7 = androidx.room.b.b.b(r5, "impl_class");     // Catch: Throwable -> L42
        int r8 = androidx.room.b.b.b(r5, "is_static_register");     // Catch: Throwable -> L42
        int r9 = androidx.room.b.b.b(r5, "key");     // Catch: Throwable -> L42
        int r10 = androidx.room.b.b.b(r5, "registered");     // Catch: Throwable -> L42
        int r11 = androidx.room.b.b.b(r5, "state");     // Catch: Throwable -> L42
        int r12 = androidx.room.b.b.b(r5, WsConstants.KEY_SERVICE);     // Catch: Throwable -> L42
        ArrayList r13 = new ArrayList(r5.getCount());     // Catch: Throwable -> L42
    L8:
        if (r5.moveToNext() == false) goto L40;
        if (r5.isNull(r0) == false) goto L13;
        String r16 = null;
    L15:
        if (r5.isNull(r6) == false) goto L17;
        String r17 = null;
    L19:
        if (r5.isNull(r7) == false) goto L21;
        String r18 = null;
    L23:
        if (r5.getInt(r8) == 0) goto L25;
        boolean r19 = true;
    L27:
        if (r5.isNull(r9) == false) goto L29;
        String r20 = null;
    L31:
        if (r5.getInt(r10) == 0) goto L33;
        boolean r21 = true;
    L34:
        int r22 = r5.getInt(r11);     // Catch: Throwable -> L42
        if (r5.isNull(r12) == false) goto L37;
        String r23 = null;
    L38:
        r13.add(new com.obric.aiagent.executionengine.capabilitymanager.data.bean.a(r16, r17, r18, r19, r20, r21, r22, r23));     // Catch: Throwable -> L42
        goto L8
    L37:
        r23 = r5.getString(r12);     // Catch: Throwable -> L42
        goto L38
    L33:
        r21 = false;
        goto L34
    L29:
        r20 = r5.getString(r9);     // Catch: Throwable -> L42
        goto L31
    L25:
        r19 = false;
        goto L27
    L21:
        r18 = r5.getString(r7);     // Catch: Throwable -> L42
        goto L23
    L17:
        r17 = r5.getString(r6);     // Catch: Throwable -> L42
        goto L19
    L13:
        r16 = r5.getString(r0);     // Catch: Throwable -> L42
        goto L15
    L40:
        r5.close();
        r2.a();
        return r13;
    L42:
        th = move-exception;
        r5.close();
        r2.a();
        throw th;
    L5:
        r2.a(1, r25);
        goto L6
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.data.b.a
    public List<com.obric.aiagent.executionengine.capabilitymanager.data.bean.a> a(List<String> r25) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin");
        StringBuilder r3 = androidx.room.b.f.a();
        r3.append("SELECT * FROM intent_bean WHERE `pkg_name` in (");
        int r4 = r1.size();
        androidx.room.b.f.a(r3, r4);
        r3.append(") AND state = 1");
        s r5 = s.a(r3.toString(), r4 + 0);
        Iterator r2 = r1.iterator();
        int r6 = 1;
    L4:
        if (r2.hasNext() == false) goto L10;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L8;
        r5.a(r6);
    L9:
        r6 = r6 + 1;
        goto L4
    L8:
        r5.a(r6, r7);
        goto L9
    L10:
        this.f16431a.i();
        Cursor r8 = androidx.room.b.c.query(this.f16431a, r5, false, null);
        int r0 = androidx.room.b.b.b(r8, "name");     // Catch: Throwable -> L46
        int r9 = androidx.room.b.b.b(r8, "pkg_name");     // Catch: Throwable -> L46
        int r10 = androidx.room.b.b.b(r8, "impl_class");     // Catch: Throwable -> L46
        int r11 = androidx.room.b.b.b(r8, "is_static_register");     // Catch: Throwable -> L46
        int r12 = androidx.room.b.b.b(r8, "key");     // Catch: Throwable -> L46
        int r13 = androidx.room.b.b.b(r8, "registered");     // Catch: Throwable -> L46
        int r14 = androidx.room.b.b.b(r8, "state");     // Catch: Throwable -> L46
        int r15 = androidx.room.b.b.b(r8, WsConstants.KEY_SERVICE);     // Catch: Throwable -> L46
        ArrayList r16 = new ArrayList(r8.getCount());     // Catch: Throwable -> L46
    L12:
        if (r8.moveToNext() == false) goto L44;
        if (r8.isNull(r0) == false) goto L17;
        String r17 = null;
    L19:
        if (r8.isNull(r9) == false) goto L21;
        String r18 = null;
    L23:
        if (r8.isNull(r10) == false) goto L25;
        String r19 = null;
    L27:
        if (r8.getInt(r11) == 0) goto L29;
        boolean r110 = true;
    L31:
        if (r8.isNull(r12) == false) goto L33;
        String r20 = null;
    L35:
        if (r8.getInt(r13) == 0) goto L37;
        boolean r21 = true;
    L38:
        int r22 = r8.getInt(r14);     // Catch: Throwable -> L46
        if (r8.isNull(r15) == false) goto L41;
        String r23 = null;
    L42:
        r16.add(new com.obric.aiagent.executionengine.capabilitymanager.data.bean.a(r17, r18, r19, r110, r20, r21, r22, r23));     // Catch: Throwable -> L46
        goto L12
    L41:
        r23 = r8.getString(r15);     // Catch: Throwable -> L46
        goto L42
    L37:
        r21 = false;
        goto L38
    L33:
        r20 = r8.getString(r12);     // Catch: Throwable -> L46
        goto L35
    L29:
        r110 = false;
        goto L31
    L25:
        r19 = r8.getString(r10);     // Catch: Throwable -> L46
        goto L27
    L21:
        r18 = r8.getString(r9);     // Catch: Throwable -> L46
        goto L23
    L17:
        r17 = r8.getString(r0);     // Catch: Throwable -> L46
        goto L19
    L44:
        r8.close();
        r5.a();
        return r16;
    L46:
        th = move-exception;
        r8.close();
        r5.a();
        throw th;
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.data.b.a
    public int d(List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        this.f16431a.i();
        StringBuilder r0 = androidx.room.b.f.a();
        r0.append("UPDATE intent_bean SET state = 0  WHERE `key` in (");
        androidx.room.b.f.a(r0, r7.size());
        r0.append(")");
        String r1 = r0.toString();
        g r2 = this.f16431a.a(r1);
        Iterator r8 = r7.iterator();
        int r3 = 1;
    L4:
        if (r8.hasNext() == false) goto L10;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L8;
        r2.a(r3);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        r2.a(r3, r4);
        goto L9
    L10:
        this.f16431a.j();
        int r9 = r2.a();     // Catch: Throwable -> L14
        this.f16431a.m();     // Catch: Throwable -> L14
        this.f16431a.k();
        return r9;
    L14:
        th = move-exception;
        this.f16431a.k();
        throw th;
    }

    public static List<Class<?>> b() {
        return Collections.emptyList();
    }
}
