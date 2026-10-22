package com.obric.aiagent.skill.manager.impl;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SkillServerTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class fc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19862a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("skill_id")
    private final String f19863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("skill_name")
    private final String f19864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("skill_desc")
    private final String f19865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("skill_content")
    private final String f19866e;

    @SerializedName("install_type")
    private final String f;

    @SerializedName("create_time")
    private final String g;

    @SerializedName("update_time")
    private final String h;

    @SerializedName("is_enable")
    private final String i;

    @SerializedName("is_audit_pass")
    private final String j;

    @SerializedName("is_delete")
    private final String k;

    @SerializedName("file_downloaded")
    private final String l;

    @SerializedName("fail_reason")
    private final String m;

    @SerializedName("operate_type")
    private final String n;

    /* JADX INFO: compiled from: SkillServerTracking.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final fc a(com.obric.aiagent.skill.manager.api.e r21, ew r22, Boolean r23) {
            d.h.b.o.e(r21, "skill");
            d.h.b.o.e(r22, "operation");
            String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r21.a(), CharSequence.class, "com.obric.aiagent.plugin")).toString();
            boolean r3 = true;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L27;
            com.obric.aiagent.skill.manager.api.aq r1 = r21.g();
            if (r1 == null) goto L25;
            String r7 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r21.b(), CharSequence.class, "com.obric.aiagent.plugin")).toString();
            String r8 = r21.c();
            String r9 = r21.k();
            String r10 = com.obric.aiagent.skill.manager.api.as.a(r1).a();
            Long r2 = r21.n();
            if (r2 == null) goto L9;
            String r11 = r2.toString();
        L10:
            Long r4 = r21.p();
            if (r4 == null) goto L13;
            String r12 = r4.toString();
        L14:
            String r13 = ez.a(r21.l());
            String r14 = ez.a(en.b(r21.i()));
            if (r22 == ew.f19849c) goto L18;
            r3 = false;
        L18:
            String r15 = ez.a(r3);
            if (r23 == null) goto L21;
            String r16 = ez.a(r23.booleanValue());
        L23:
            return new fc(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, null, r22.a());
        L21:
            r16 = null;
            goto L23
        L13:
            r12 = null;
            goto L14
        L9:
            r11 = null;
            goto L10
        L25:
            throw new IllegalArgumentException("Skill source must not be null".toString());
        L27:
            throw new IllegalArgumentException("skill_id must not be blank".toString());
        }

        public final fc a(cl r21, ci r22, Boolean r23) {
            d.h.b.o.e(r21, "context");
            d.h.b.o.e(r22, "failureReason");
            String r0 = r21.c();
            String r3 = null;
            if (r0 == null) goto L5;
            String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        L6:
            CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L9;
        L12:
            boolean r2 = true;
        L14:
            if ((!r2) == false) goto L38;
            String r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r21.b(), CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L36;
            if (r21.a() != com.obric.aiagent.skill.manager.api.q.f19297c) goto L20;
        L29:
            ew r5 = ew.f19848b;
        L30:
            String r10 = r21.a().a();
            String r13 = ez.a(false);
            String r14 = ez.a(false);
            String r15 = ez.a(false);
            if (r23 == null) goto L34;
            r3 = ez.a(r23.booleanValue());
        L34:
            return new fc(r6, r4, null, null, r10, null, null, r13, r14, r15, r3, r22.a(), r5.a());
        L20:
            if (r21.a() != com.obric.aiagent.skill.manager.api.q.f) goto L28;
            gs r7 = r21.e();
            if (r7 == null) goto L24;
            cp r8 = r7.a();
        L26:
            if (r8 != cp.f19690b) goto L28;
        L24:
            r8 = null;
        L28:
            r5 = ew.f19847a;
            goto L30
        L36:
            throw new IllegalArgumentException("skill_name must not be blank".toString());
        L38:
            throw new IllegalArgumentException("skill_id must not be blank".toString());
        L9:
            if (d.o.o.d(r1) == true) goto L12;
            r2 = false;
            goto L14
        L5:
            r6 = null;
            goto L6
        }
    }

    static {
        f19862a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, fc.class) == true) goto L8;
        return false;
    L8:
        fc r6 = (fc) ZeusTransformUtils.preCheckCast(r5, fc.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19863b, r6.f19863b) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19864c, r6.f19864c) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19865d, r6.f19865d) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19866e, r6.f19866e) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.h, r6.h) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.i, r6.i) == true) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.j, r6.j) == true) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.k, r6.k) == true) goto L39;
        return false;
    L39:
        if (d.h.b.o.a(this.l, r6.l) == true) goto L42;
        return false;
    L42:
        if (d.h.b.o.a(this.m, r6.m) == true) goto L45;
        return false;
    L45:
        if (d.h.b.o.a(this.n, r6.n) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        int r0 = this.f19863b.hashCode() * 31;
        String r1 = this.f19864c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f19865d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.f19866e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((r7 + r9) * 31) + this.f.hashCode()) * 31;
        String r11 = this.g;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.h;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (((((((r13 + r15) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31;
        String r17 = this.l;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.m;
        if (r20 == null) goto L31;
        r2 = r20.hashCode();
    L31:
        return ((r19 + r2) * 31) + this.n.hashCode();
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("SkillServerTrackingSnapshot(skillId=").append(this.f19863b).append(", skillName=").append(this.f19864c).append(", skillDescription=").append(this.f19865d).append(", skillContent=").append(this.f19866e).append(", installType=").append(this.f).append(", createTime=").append(this.g).append(", updateTime=").append(this.h).append(", isEnable=").append(this.i).append(", isAuditPass=").append(this.j).append(", isDelete=").append(this.k).append(", fileDownloaded=").append(this.l).append(", failReason=");
        r0.append(this.m).append(", operateType=").append(this.n).append(')');
        return r0.toString();
    }

    public fc(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14) {
        d.h.b.o.e(r2, "skillId");
        d.h.b.o.e(r6, "installType");
        d.h.b.o.e(r9, "isEnable");
        d.h.b.o.e(r10, "isAuditPass");
        d.h.b.o.e(r11, "isDelete");
        d.h.b.o.e(r14, "operateType");
        this.f19863b = r2;
        this.f19864c = r3;
        this.f19865d = r4;
        this.f19866e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
    }

    public final String a() {
        return this.f19863b;
    }

    public final String b() {
        return this.i;
    }

    public final String c() {
        return this.j;
    }

    public final String d() {
        return this.k;
    }

    public final String e() {
        return this.l;
    }

    public final String f() {
        return this.m;
    }

    public final ew g() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(ew.b(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Object r1 = r0.next();
        if (d.h.b.o.a(((ew) ZeusTransformUtils.preCheckCast(r1, ew.class, "com.obric.aiagent.plugin")).a(), this.n) == false) goto L4;
        return (ew) ZeusTransformUtils.preCheckCast(r1, ew.class, "com.obric.aiagent.plugin");
    L10:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
