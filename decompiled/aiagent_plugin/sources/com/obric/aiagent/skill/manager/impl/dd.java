package com.obric.aiagent.skill.manager.impl;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SkillMetadataDao_Impl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class dd implements dc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final androidx.room.p f19724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.room.f<de> f19725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final androidx.room.v f19726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.room.v f19727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final androidx.room.v f19728e;
    private final androidx.room.v f;
    private final androidx.room.v g;
    private final androidx.room.v h;

    public dd(final androidx.room.p r2) {
        this.f19724a = r2;
        this.f19725b = new AnonymousClass1(this, r2);
        this.f19726c = new AnonymousClass2(this, r2);
        this.f19727d = new AnonymousClass3(this, r2);
        this.f19728e = new AnonymousClass4(this, r2);
        this.f = new AnonymousClass5(this, r2);
        this.g = new AnonymousClass6(this, r2);
        this.h = new AnonymousClass7(this, r2);
    }

    @Override // com.obric.aiagent.skill.manager.impl.dc
    public void insert(de r2) {
        this.f19724a.i();
        this.f19724a.j();
        this.f19725b.insert(r2);     // Catch: Throwable -> L6
        this.f19724a.m();     // Catch: Throwable -> L6
        this.f19724a.k();
        return;
    L6:
        th = move-exception;
        this.f19724a.k();
        throw th;
    }

    @Override // com.obric.aiagent.skill.manager.impl.dc
    public int a(String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, int r31, boolean r32, boolean r33, Long r34, Long r35, Long r36) {
        this.f19724a.i();
        androidx.sqlite.db.g r15 = this.f19726c.c();
        if (r18 != null) goto L5;
        r15.a(1);
    L7:
        if (r19 != null) goto L9;
        r15.a(2);
    L11:
        if (r20 != null) goto L13;
        r15.a(3);
    L15:
        if (r21 != null) goto L17;
        r15.a(4);
    L19:
        if (r22 != null) goto L21;
        r15.a(5);
    L23:
        if (r23 != null) goto L25;
        r15.a(6);
    L27:
        if (r24 != null) goto L29;
        r15.a(7);
    L31:
        if (r25 != null) goto L33;
        r15.a(8);
    L35:
        if (r26 != null) goto L37;
        r15.a(9);
    L39:
        if (r27 != null) goto L41;
        r15.a(10);
    L43:
        if (r28 != null) goto L45;
        r15.a(11);
    L47:
        if (r29 != null) goto L49;
        r15.a(12);
    L51:
        if (r30 != null) goto L53;
        r15.a(13);
    L54:
        r15.a(14, r31);
        r15.a(15, r32 ? 1 : 0);
        r15.a(16, r33 ? 1 : 0);
        if (r34 != null) goto L57;
        r15.a(17);
    L59:
        if (r35 != null) goto L61;
        r15.a(18);
    L63:
        if (r36 != null) goto L65;
        r15.a(19);
    L67:
        if (r17 != null) goto L69;
        r15.a(20);
    L70:
        this.f19724a.j();
        int r0 = r15.a();     // Catch: Throwable -> L74
        this.f19724a.m();     // Catch: Throwable -> L74
        this.f19724a.k();
        this.f19726c.a(r15);
        return r0;
    L74:
        th = move-exception;
        this.f19724a.k();
        this.f19726c.a(r15);
        throw th;
    L69:
        r15.a(20, r17);
        goto L70
    L65:
        r15.a(19, r36.longValue());
        goto L67
    L61:
        r15.a(18, r35.longValue());
        goto L63
    L57:
        r15.a(17, r34.longValue());
        goto L59
    L53:
        r15.a(13, r30);
        goto L54
    L49:
        r15.a(12, r29);
        goto L51
    L45:
        r15.a(11, r28);
        goto L47
    L41:
        r15.a(10, r27);
        goto L43
    L37:
        r15.a(9, r26);
        goto L39
    L33:
        r15.a(8, r25);
        goto L35
    L29:
        r15.a(7, r24);
        goto L31
    L25:
        r15.a(6, r23);
        goto L27
    L21:
        r15.a(5, r22);
        goto L23
    L17:
        r15.a(4, r21);
        goto L19
    L13:
        r15.a(3, r20);
        goto L15
    L9:
        r15.a(2, r19);
        goto L11
    L5:
        r15.a(1, r18);
        goto L7
    }

    @Override // com.obric.aiagent.skill.manager.impl.dc
    public int a(String r3, long r4) {
        this.f19724a.i();
        androidx.sqlite.db.g r0 = this.f19727d.c();
        r0.a(1, r4);
        if (r3 != null) goto L5;
        r0.a(2);
    L6:
        this.f19724a.j();
        int r5 = r0.a();     // Catch: Throwable -> L10
        this.f19724a.m();     // Catch: Throwable -> L10
        this.f19724a.k();
        this.f19727d.a(r0);
        return r5;
    L10:
        th = move-exception;
        this.f19724a.k();
        this.f19727d.a(r0);
        throw th;
    L5:
        r0.a(2, r3);
        goto L6
    }

    @Override // com.obric.aiagent.skill.manager.impl.dc
    public int delete(String r3) {
        this.f19724a.i();
        androidx.sqlite.db.g r0 = this.f19728e.c();
        if (r3 != null) goto L5;
        r0.a(1);
    L6:
        this.f19724a.j();
        int r4 = r0.a();     // Catch: Throwable -> L10
        this.f19724a.m();     // Catch: Throwable -> L10
        this.f19724a.k();
        this.f19728e.a(r0);
        return r4;
    L10:
        th = move-exception;
        this.f19724a.k();
        this.f19728e.a(r0);
        throw th;
    L5:
        r0.a(1, r3);
        goto L6
    }

    @Override // com.obric.aiagent.skill.manager.impl.dc
    public int a(String r4, int r5, String r6, long r7) {
        this.f19724a.i();
        androidx.sqlite.db.g r0 = this.f.c();
        r0.a(1, r5);
        if (r6 != null) goto L5;
        r0.a(2);
    L6:
        r0.a(3, r7);
        r0.a(4, r7);
        if (r4 != null) goto L9;
        r0.a(5);
    L10:
        this.f19724a.j();
        int r8 = r0.a();     // Catch: Throwable -> L14
        this.f19724a.m();     // Catch: Throwable -> L14
        this.f19724a.k();
        this.f.a(r0);
        return r8;
    L14:
        th = move-exception;
        this.f19724a.k();
        this.f.a(r0);
        throw th;
    L9:
        r0.a(5, r4);
        goto L10
    L5:
        r0.a(2, r6);
        goto L6
    }

    @Override // com.obric.aiagent.skill.manager.impl.dc
    public int a(String r3, int r4, long r5, String r7, String r8, String r9, String r10, String r11, long r12, long r14) {
        this.f19724a.i();
        androidx.sqlite.db.g r0 = this.g.c();
        if (r7 != null) goto L5;
        r0.a(1);
    L7:
        if (r8 != null) goto L9;
        r0.a(2);
    L11:
        if (r9 != null) goto L13;
        r0.a(3);
    L15:
        if (r10 != null) goto L17;
        r0.a(4);
    L19:
        if (r11 != null) goto L21;
        r0.a(5);
    L22:
        r0.a(6, r12);
        r0.a(7, r14);
        if (r3 != null) goto L25;
        r0.a(8);
    L26:
        r0.a(9, r4);
        r0.a(10, r5);
        this.f19724a.j();
        int r6 = r0.a();     // Catch: Throwable -> L30
        this.f19724a.m();     // Catch: Throwable -> L30
        this.f19724a.k();
        this.g.a(r0);
        return r6;
    L30:
        th = move-exception;
        this.f19724a.k();
        this.g.a(r0);
        throw th;
    L25:
        r0.a(8, r3);
        goto L26
    L21:
        r0.a(5, r11);
        goto L22
    L17:
        r0.a(4, r10);
        goto L19
    L13:
        r0.a(3, r9);
        goto L15
    L9:
        r0.a(2, r8);
        goto L11
    L5:
        r0.a(1, r7);
        goto L7
    }

    @Override // com.obric.aiagent.skill.manager.impl.dc
    public int b(String r3) {
        this.f19724a.i();
        androidx.sqlite.db.g r0 = this.h.c();
        if (r3 != null) goto L5;
        r0.a(1);
    L6:
        this.f19724a.j();
        int r4 = r0.a();     // Catch: Throwable -> L10
        this.f19724a.m();     // Catch: Throwable -> L10
        this.f19724a.k();
        this.h.a(r0);
        return r4;
    L10:
        th = move-exception;
        this.f19724a.k();
        this.h.a(r0);
        throw th;
    L5:
        r0.a(1, r3);
        goto L6
    }

    @Override // com.obric.aiagent.skill.manager.impl.dc
    public List<de> a() {
        androidx.room.s r1 = androidx.room.s.a("SELECT * FROM skill_metadata", 0);
        this.f19724a.i();
        Cursor r4 = androidx.room.b.c.query(this.f19724a, r1, false, null);
        int r0 = androidx.room.b.b.b(r4, "slug");     // Catch: Throwable -> L152
        int r5 = androidx.room.b.b.b(r4, "display_name");     // Catch: Throwable -> L152
        int r6 = androidx.room.b.b.b(r4, "short_description");     // Catch: Throwable -> L152
        int r7 = androidx.room.b.b.b(r4, "store_description");     // Catch: Throwable -> L152
        int r8 = androidx.room.b.b.b(r4, "cover_url");     // Catch: Throwable -> L152
        int r9 = androidx.room.b.b.b(r4, "source_type");     // Catch: Throwable -> L152
        int r10 = androidx.room.b.b.b(r4, "source_channel");     // Catch: Throwable -> L152
        int r11 = androidx.room.b.b.b(r4, "source_import_kind");     // Catch: Throwable -> L152
        int r12 = androidx.room.b.b.b(r4, "source_id");     // Catch: Throwable -> L152
        int r13 = androidx.room.b.b.b(r4, "source_name");     // Catch: Throwable -> L152
        int r14 = androidx.room.b.b.b(r4, "source_icon_url");     // Catch: Throwable -> L152
        int r15 = androidx.room.b.b.b(r4, "source_attribution_name");     // Catch: Throwable -> L152
        int r2 = androidx.room.b.b.b(r4, "app_function_package_name");     // Catch: Throwable -> L152
        int r3 = androidx.room.b.b.b(r4, "app_function_content_fingerprint");     // Catch: Throwable -> L152
        androidx.room.s r16 = r1;
        int r17 = androidx.room.b.b.b(r4, "version");     // Catch: Throwable -> L150
        int r18 = androidx.room.b.b.b(r4, "enabled");     // Catch: Throwable -> L150
        int r19 = androidx.room.b.b.b(r4, "removable");     // Catch: Throwable -> L150
        int r20 = androidx.room.b.b.b(r4, "created_at");     // Catch: Throwable -> L150
        int r21 = androidx.room.b.b.b(r4, "last_used_at");     // Catch: Throwable -> L150
        int r22 = androidx.room.b.b.b(r4, "last_updated_at");     // Catch: Throwable -> L150
        int r23 = androidx.room.b.b.b(r4, "scan_generation");     // Catch: Throwable -> L150
        int r24 = androidx.room.b.b.b(r4, "scan_version");     // Catch: Throwable -> L150
        int r25 = androidx.room.b.b.b(r4, "scan_raw_task_json");     // Catch: Throwable -> L150
        int r26 = androidx.room.b.b.b(r4, "scan_raw_signed_manifest_json");     // Catch: Throwable -> L150
        int r27 = androidx.room.b.b.b(r4, "scan_submitted_package_sha256");     // Catch: Throwable -> L150
        int r28 = androidx.room.b.b.b(r4, "scan_fetched_manifest_sha256");     // Catch: Throwable -> L150
        int r29 = androidx.room.b.b.b(r4, "scan_trigger_type");     // Catch: Throwable -> L150
        int r30 = androidx.room.b.b.b(r4, "scan_created_at_ms");     // Catch: Throwable -> L150
        int r31 = androidx.room.b.b.b(r4, "scan_updated_at_ms");     // Catch: Throwable -> L150
        int r32 = r3;
        ArrayList r33 = new ArrayList(r4.getCount());     // Catch: Throwable -> L150
    L6:
        if (r4.moveToNext() == false) goto L148;
        if (r4.isNull(r0) == false) goto L11;
        String r34 = null;
    L13:
        if (r4.isNull(r5) == false) goto L15;
        String r35 = null;
    L17:
        if (r4.isNull(r6) == false) goto L19;
        String r36 = null;
    L21:
        if (r4.isNull(r7) == false) goto L23;
        String r37 = null;
    L25:
        if (r4.isNull(r8) == false) goto L27;
        String r38 = null;
    L29:
        if (r4.isNull(r9) == false) goto L31;
        String r39 = null;
    L33:
        if (r4.isNull(r10) == false) goto L35;
        String r40 = null;
    L37:
        if (r4.isNull(r11) == false) goto L39;
        String r41 = null;
    L41:
        if (r4.isNull(r12) == false) goto L43;
        String r42 = null;
    L45:
        if (r4.isNull(r13) == false) goto L47;
        String r43 = null;
    L49:
        if (r4.isNull(r14) == false) goto L51;
        String r44 = null;
    L53:
        if (r4.isNull(r15) == false) goto L55;
        String r45 = null;
    L57:
        if (r4.isNull(r2) == false) goto L59;
        String r46 = null;
    L61:
        if (r4.isNull(r32) == false) goto L64;
        String r47 = null;
    L63:
        int r66 = r17;
        int r110 = r0;
        int r48 = r4.getInt(r66);     // Catch: Throwable -> L150
        r18 = r18;
        if (r4.getInt(r18) == 0) goto L68;
        boolean r49 = true;
    L70:
        if (r4.getInt(r19) == 0) goto L72;
        boolean r50 = true;
    L74:
        if (r4.isNull(r20) == false) goto L76;
        Long r51 = null;
    L78:
        if (r4.isNull(r21) == false) goto L80;
        Long r52 = null;
    L82:
        if (r4.isNull(r22) == false) goto L84;
        Long r53 = null;
    L86:
        if (r4.isNull(r23) == false) goto L105;
        int r210 = r2;
        int r54 = r24;
        if (r4.isNull(r54) == false) goto L106;
        int r211 = r32;
        int r55 = r25;
        if (r4.isNull(r55) == false) goto L107;
        int r212 = r5;
        int r56 = r26;
        if (r4.isNull(r56) == false) goto L108;
        int r213 = r6;
        int r57 = r27;
        if (r4.isNull(r57) == false) goto L109;
        int r214 = r7;
        int r58 = r28;
        if (r4.isNull(r58) == false) goto L110;
        int r215 = r8;
        int r59 = r29;
        if (r4.isNull(r59) == false) goto L111;
        int r216 = r9;
        int r60 = r30;
        if (r4.isNull(r60) == false) goto L112;
        int r310 = r10;
        int r111 = r31;
        if (r4.isNull(r111) == false) goto L113;
        hk r510 = null;
    L146:
        r33.add(new de(r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r510));     // Catch: Throwable -> L150
        r0 = r110;
        r17 = r66;
        r32 = r211;
        r24 = r54;
        r2 = r210;
        r23 = r23;
        r31 = r111;
        r10 = r310;
        r30 = r60;
        r9 = r216;
        r29 = r59;
        r8 = r215;
        r28 = r58;
        r7 = r214;
        r27 = r57;
        r6 = r213;
        r26 = r56;
        r5 = r212;
        r25 = r55;
    L113:
        long r511 = r4.getLong(r23);     // Catch: Throwable -> L150
        if (r4.isNull(r54) == false) goto L116;
        Integer r512 = null;
    L118:
        if (r4.isNull(r55) == false) goto L120;
        String r513 = null;
    L122:
        if (r4.isNull(r56) == false) goto L124;
        String r514 = null;
    L126:
        if (r4.isNull(r57) == false) goto L128;
        String r61 = null;
    L130:
        if (r4.isNull(r58) == false) goto L132;
        String r62 = null;
    L134:
        if (r4.isNull(r59) == false) goto L136;
        String r63 = null;
    L138:
        if (r4.isNull(r60) == false) goto L140;
        Long r64 = null;
    L142:
        if (r4.isNull(r111) == false) goto L144;
        Long r65 = null;
    L145:
        r510 = new hk(r511, r512, r513, r514, r61, r62, r63, r64, r65);     // Catch: Throwable -> L150
        goto L146
    L144:
        r65 = Long.valueOf(r4.getLong(r111));     // Catch: Throwable -> L150
        goto L145
    L140:
        r64 = Long.valueOf(r4.getLong(r60));     // Catch: Throwable -> L150
        goto L142
    L136:
        r63 = r4.getString(r59);     // Catch: Throwable -> L150
        goto L138
    L132:
        r62 = r4.getString(r58);     // Catch: Throwable -> L150
        goto L134
    L128:
        r61 = r4.getString(r57);     // Catch: Throwable -> L150
        goto L130
    L124:
        r514 = r4.getString(r56);     // Catch: Throwable -> L150
        goto L126
    L120:
        r513 = r4.getString(r55);     // Catch: Throwable -> L150
        goto L122
    L116:
        r512 = Integer.valueOf(r4.getInt(r54));     // Catch: Throwable -> L150
    L112:
        r310 = r10;
        r111 = r31;
    L111:
        r216 = r9;
        r60 = r30;
    L110:
        r215 = r8;
        r59 = r29;
    L109:
        r214 = r7;
        r58 = r28;
    L108:
        r213 = r6;
        r57 = r27;
    L107:
        r212 = r5;
        r56 = r26;
    L106:
        r211 = r32;
        r55 = r25;
        goto L107
    L105:
        r210 = r2;
        r54 = r24;
        goto L106
    L84:
        r53 = Long.valueOf(r4.getLong(r22));     // Catch: Throwable -> L150
        goto L86
    L80:
        r52 = Long.valueOf(r4.getLong(r21));     // Catch: Throwable -> L150
        goto L82
    L76:
        r51 = Long.valueOf(r4.getLong(r20));     // Catch: Throwable -> L150
        goto L78
    L72:
        r50 = false;
        goto L74
    L68:
        r49 = false;
        goto L70
    L64:
        r47 = r4.getString(r32);     // Catch: Throwable -> L150
        goto L63
    L59:
        r46 = r4.getString(r2);     // Catch: Throwable -> L150
        goto L61
    L55:
        r45 = r4.getString(r15);     // Catch: Throwable -> L150
        goto L57
    L51:
        r44 = r4.getString(r14);     // Catch: Throwable -> L150
        goto L53
    L47:
        r43 = r4.getString(r13);     // Catch: Throwable -> L150
        goto L49
    L43:
        r42 = r4.getString(r12);     // Catch: Throwable -> L150
        goto L45
    L39:
        r41 = r4.getString(r11);     // Catch: Throwable -> L150
        goto L41
    L35:
        r40 = r4.getString(r10);     // Catch: Throwable -> L150
        goto L37
    L31:
        r39 = r4.getString(r9);     // Catch: Throwable -> L150
        goto L33
    L27:
        r38 = r4.getString(r8);     // Catch: Throwable -> L150
        goto L29
    L23:
        r37 = r4.getString(r7);     // Catch: Throwable -> L150
        goto L25
    L19:
        r36 = r4.getString(r6);     // Catch: Throwable -> L150
        goto L21
    L15:
        r35 = r4.getString(r5);     // Catch: Throwable -> L150
        goto L17
    L11:
        r34 = r4.getString(r0);     // Catch: Throwable -> L150
        goto L13
    L148:
        r4.close();
        r16.a();
        return r33;
    L150:
        th = th;
    L154:
        r4.close();
        r16.a();
        throw th;
    L152:
        th = th;
        r16 = r1;
        goto L154
    }

    @Override // com.obric.aiagent.skill.manager.impl.dc
    public de a(String r54) {
        androidx.room.s r2 = androidx.room.s.a("SELECT * FROM skill_metadata WHERE slug = ? LIMIT 1", 1);
        if (r54 != null) goto L5;
        r2.a(1);
    L6:
        this.f19724a.i();
        Cursor r5 = androidx.room.b.c.query(this.f19724a, r2, false, null);
        int r0 = androidx.room.b.b.b(r5, "slug");     // Catch: Throwable -> L154
        int r6 = androidx.room.b.b.b(r5, "display_name");     // Catch: Throwable -> L154
        int r7 = androidx.room.b.b.b(r5, "short_description");     // Catch: Throwable -> L154
        int r8 = androidx.room.b.b.b(r5, "store_description");     // Catch: Throwable -> L154
        int r9 = androidx.room.b.b.b(r5, "cover_url");     // Catch: Throwable -> L154
        int r10 = androidx.room.b.b.b(r5, "source_type");     // Catch: Throwable -> L154
        int r11 = androidx.room.b.b.b(r5, "source_channel");     // Catch: Throwable -> L154
        int r12 = androidx.room.b.b.b(r5, "source_import_kind");     // Catch: Throwable -> L154
        int r13 = androidx.room.b.b.b(r5, "source_id");     // Catch: Throwable -> L154
        int r14 = androidx.room.b.b.b(r5, "source_name");     // Catch: Throwable -> L154
        int r15 = androidx.room.b.b.b(r5, "source_icon_url");     // Catch: Throwable -> L154
        int r1 = androidx.room.b.b.b(r5, "source_attribution_name");     // Catch: Throwable -> L154
        int r3 = androidx.room.b.b.b(r5, "app_function_package_name");     // Catch: Throwable -> L154
        int r4 = androidx.room.b.b.b(r5, "app_function_content_fingerprint");     // Catch: Throwable -> L154
        androidx.room.s r16 = r2;
        int r17 = androidx.room.b.b.b(r5, "version");     // Catch: Throwable -> L152
        int r18 = androidx.room.b.b.b(r5, "enabled");     // Catch: Throwable -> L152
        int r19 = androidx.room.b.b.b(r5, "removable");     // Catch: Throwable -> L152
        int r20 = androidx.room.b.b.b(r5, "created_at");     // Catch: Throwable -> L152
        int r21 = androidx.room.b.b.b(r5, "last_used_at");     // Catch: Throwable -> L152
        int r22 = androidx.room.b.b.b(r5, "last_updated_at");     // Catch: Throwable -> L152
        int r23 = androidx.room.b.b.b(r5, "scan_generation");     // Catch: Throwable -> L152
        int r24 = androidx.room.b.b.b(r5, "scan_version");     // Catch: Throwable -> L152
        int r25 = androidx.room.b.b.b(r5, "scan_raw_task_json");     // Catch: Throwable -> L152
        int r26 = androidx.room.b.b.b(r5, "scan_raw_signed_manifest_json");     // Catch: Throwable -> L152
        int r27 = androidx.room.b.b.b(r5, "scan_submitted_package_sha256");     // Catch: Throwable -> L152
        int r28 = androidx.room.b.b.b(r5, "scan_fetched_manifest_sha256");     // Catch: Throwable -> L152
        int r29 = androidx.room.b.b.b(r5, "scan_trigger_type");     // Catch: Throwable -> L152
        int r30 = androidx.room.b.b.b(r5, "scan_created_at_ms");     // Catch: Throwable -> L152
        int r31 = androidx.room.b.b.b(r5, "scan_updated_at_ms");     // Catch: Throwable -> L152
        if (r5.moveToFirst() == true) goto L12;
        de r32 = null;
    L150:
        r5.close();
        r16.a();
        return r32;
    L12:
        if (r5.isNull(r0) == false) goto L14;
        String r33 = null;
    L16:
        if (r5.isNull(r6) == false) goto L18;
        String r34 = null;
    L20:
        if (r5.isNull(r7) == false) goto L22;
        String r35 = null;
    L24:
        if (r5.isNull(r8) == false) goto L26;
        String r36 = null;
    L28:
        if (r5.isNull(r9) == false) goto L30;
        String r37 = null;
    L32:
        if (r5.isNull(r10) == false) goto L34;
        String r38 = null;
    L36:
        if (r5.isNull(r11) == false) goto L38;
        String r39 = null;
    L40:
        if (r5.isNull(r12) == false) goto L42;
        String r310 = null;
    L44:
        if (r5.isNull(r13) == false) goto L46;
        String r40 = null;
    L48:
        if (r5.isNull(r14) == false) goto L50;
        String r41 = null;
    L52:
        if (r5.isNull(r15) == false) goto L54;
        String r42 = null;
    L56:
        if (r5.isNull(r1) == false) goto L58;
        String r43 = null;
    L60:
        if (r5.isNull(r3) == false) goto L62;
        String r44 = null;
    L64:
        if (r5.isNull(r4) == false) goto L66;
        String r45 = null;
    L67:
        int r46 = r5.getInt(r17);     // Catch: Throwable -> L152
        if (r5.getInt(r18) == 0) goto L70;
        boolean r47 = true;
    L72:
        if (r5.getInt(r19) == 0) goto L74;
        boolean r48 = true;
    L76:
        if (r5.isNull(r20) == false) goto L78;
        Long r49 = null;
    L80:
        if (r5.isNull(r21) == false) goto L82;
        Long r50 = null;
    L84:
        if (r5.isNull(r22) == false) goto L86;
        Long r51 = null;
    L88:
        if (r5.isNull(r23) == false) goto L107;
        int r52 = r24;
        if (r5.isNull(r52) == false) goto L108;
        int r53 = r25;
        if (r5.isNull(r53) == false) goto L109;
        int r55 = r26;
        if (r5.isNull(r55) == false) goto L110;
        int r56 = r27;
        if (r5.isNull(r56) == false) goto L111;
        int r57 = r28;
        if (r5.isNull(r57) == false) goto L112;
        int r58 = r29;
        if (r5.isNull(r58) == false) goto L113;
        int r59 = r30;
        if (r5.isNull(r59) == true) goto L104;
    L114:
        long r110 = r5.getLong(r23);     // Catch: Throwable -> L152
        if (r5.isNull(r52) == false) goto L117;
        Integer r210 = null;
    L119:
        if (r5.isNull(r53) == false) goto L121;
        String r211 = null;
    L123:
        if (r5.isNull(r55) == false) goto L125;
        String r212 = null;
    L127:
        if (r5.isNull(r56) == false) goto L129;
        String r213 = null;
    L131:
        if (r5.isNull(r57) == false) goto L133;
        String r214 = null;
    L135:
        if (r5.isNull(r58) == false) goto L137;
        String r215 = null;
    L139:
        if (r5.isNull(r59) == false) goto L141;
        Long r216 = null;
    L143:
        if (r5.isNull(r31) == false) goto L145;
        Long r217 = null;
    L146:
        hk r510 = new hk(r110, r210, r211, r212, r213, r214, r215, r216, r217);     // Catch: Throwable -> L152
    L147:
        r32 = new de(r33, r34, r35, r36, r37, r38, r39, r310, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r510);     // Catch: Throwable -> L152
        goto L150
    L145:
        r217 = Long.valueOf(r5.getLong(r31));     // Catch: Throwable -> L152
        goto L146
    L141:
        r216 = Long.valueOf(r5.getLong(r59));     // Catch: Throwable -> L152
        goto L143
    L137:
        r215 = r5.getString(r58);     // Catch: Throwable -> L152
        goto L139
    L133:
        r214 = r5.getString(r57);     // Catch: Throwable -> L152
        goto L135
    L129:
        r213 = r5.getString(r56);     // Catch: Throwable -> L152
        goto L131
    L125:
        r212 = r5.getString(r55);     // Catch: Throwable -> L152
        goto L127
    L121:
        r211 = r5.getString(r53);     // Catch: Throwable -> L152
        goto L123
    L117:
        r210 = Integer.valueOf(r5.getInt(r52));     // Catch: Throwable -> L152
        goto L119
    L104:
        if (r5.isNull(r31) == false) goto L114;
        r510 = null;
    L113:
        r59 = r30;
    L112:
        r58 = r29;
    L111:
        r57 = r28;
    L110:
        r56 = r27;
    L109:
        r55 = r26;
    L108:
        r53 = r25;
        goto L109
    L107:
        r52 = r24;
        goto L108
    L86:
        r51 = Long.valueOf(r5.getLong(r22));     // Catch: Throwable -> L152
        goto L88
    L82:
        r50 = Long.valueOf(r5.getLong(r21));     // Catch: Throwable -> L152
        goto L84
    L78:
        r49 = Long.valueOf(r5.getLong(r20));     // Catch: Throwable -> L152
        goto L80
    L74:
        r48 = false;
        goto L76
    L70:
        r47 = false;
        goto L72
    L66:
        r45 = r5.getString(r4);     // Catch: Throwable -> L152
        goto L67
    L62:
        r44 = r5.getString(r3);     // Catch: Throwable -> L152
        goto L64
    L58:
        r43 = r5.getString(r1);     // Catch: Throwable -> L152
        goto L60
    L54:
        r42 = r5.getString(r15);     // Catch: Throwable -> L152
        goto L56
    L50:
        r41 = r5.getString(r14);     // Catch: Throwable -> L152
        goto L52
    L46:
        r40 = r5.getString(r13);     // Catch: Throwable -> L152
        goto L48
    L42:
        r310 = r5.getString(r12);     // Catch: Throwable -> L152
        goto L44
    L38:
        r39 = r5.getString(r11);     // Catch: Throwable -> L152
        goto L40
    L34:
        r38 = r5.getString(r10);     // Catch: Throwable -> L152
        goto L36
    L30:
        r37 = r5.getString(r9);     // Catch: Throwable -> L152
        goto L32
    L26:
        r36 = r5.getString(r8);     // Catch: Throwable -> L152
        goto L28
    L22:
        r35 = r5.getString(r7);     // Catch: Throwable -> L152
        goto L24
    L18:
        r34 = r5.getString(r6);     // Catch: Throwable -> L152
        goto L20
    L14:
        r33 = r5.getString(r0);     // Catch: Throwable -> L152
    L152:
        th = th;
    L156:
        r5.close();
        r16.a();
        throw th;
    L154:
        th = th;
        r16 = r2;
        goto L156
    L5:
        r2.a(1, r54);
        goto L6
    }

    @Override // com.obric.aiagent.skill.manager.impl.dc
    public List<String> b() {
        androidx.room.s r0 = androidx.room.s.a("SELECT cover_url FROM skill_metadata", 0);
        this.f19724a.i();
        Cursor r5 = androidx.room.b.c.query(this.f19724a, r0, false, null);
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

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }
}
