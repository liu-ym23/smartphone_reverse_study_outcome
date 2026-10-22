package com.obric.aiagent.skill.manager.impl;

import com.obric.aiagent.assistant.idl.bean.SkillSecurityDecisionAction;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillScanDecisionStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class eg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f19813a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f19816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f19817e;
    private final String f;
    private final String g;
    private final String h;
    private final Integer i;
    private final long j;

    /* JADX INFO: compiled from: SkillScanDecisionStore.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f19813a = new a(null);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, eg.class) == true) goto L8;
        return false;
    L8:
        eg r8 = (eg) ZeusTransformUtils.preCheckCast(r7, eg.class, "com.obric.aiagent.plugin");
        if (this.f19814b == r8.f19814b) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19815c, r8.f19815c) == true) goto L15;
        return false;
    L15:
        if (this.f19816d == r8.f19816d) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19817e, r8.f19817e) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f, r8.f) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.g, r8.g) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.h, r8.h) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.i, r8.i) == true) goto L33;
        return false;
    L33:
        if (this.j == r8.j) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((((Integer.hashCode(this.f19814b) * 31) + this.f19815c.hashCode()) * 31) + Integer.hashCode(this.f19816d)) * 31) + this.f19817e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        Integer r1 = this.i;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Long.hashCode(this.j);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "SkillScanDecisionSnapshot(schemaVersion=" + this.f19814b + ", slug=" + this.f19815c + ", version=" + this.f19816d + ", taskId=" + this.f19817e + ", scanId=" + this.f + ", scanStatus=" + this.g + ", decisionAction=" + this.h + ", riskScore=" + this.i + ", fetchedAtMs=" + this.j + ')';
    }

    public eg(int r2, String r3, int r4, String r5, String r6, String r7, String r8, Integer r9, long r10) {
        d.h.b.o.e(r3, "slug");
        d.h.b.o.e(r5, DBDefinition.TASK_ID);
        d.h.b.o.e(r6, "scanId");
        d.h.b.o.e(r7, "scanStatus");
        d.h.b.o.e(r8, "decisionAction");
        this.f19814b = r2;
        this.f19815c = r3;
        this.f19816d = r4;
        this.f19817e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }

    public /* synthetic */ eg(int r14, String r15, int r16, String r17, String r18, String r19, String r20, Integer r21, long r22, int r24, d.h.b.h r25) {
        if ((r24 & 1) == 0) goto L5;
        int r3 = 1;
    L7:
        if ((r24 & 16) == 0) goto L9;
        String r7 = "";
    L11:
        if ((r24 & 32) == 0) goto L13;
        String r8 = "";
    L15:
        if ((r24 & 128) == 0) goto L17;
        Integer r10 = null;
    L18:
        this(r3, r15, r16, r17, r7, r8, r20, r10, r22);
        return;
    L17:
        r10 = r21;
        goto L18
    L13:
        r8 = r19;
        goto L15
    L9:
        r7 = r18;
        goto L11
    L5:
        r3 = r14;
        goto L7
    }

    public final String a() {
        return this.f19815c;
    }

    public final int b() {
        return this.f19816d;
    }

    public final String c() {
        return this.f19817e;
    }

    public final String d() {
        return this.g;
    }

    public final String e() {
        return this.h;
    }

    public final Integer f() {
        return this.i;
    }

    public final com.obric.aiagent.skill.manager.api.ak g() {
        SkillSecurityDecisionAction r3 = SkillSecurityDecisionAction.Companion.a(this.h);
        if (r3 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, SkillSecurityDecisionAction.Unknown.class) == false) goto L9;
        return null;
    L9:
        return new com.obric.aiagent.skill.manager.api.ak(r3, this.i, null, 4, null);
    }
}
