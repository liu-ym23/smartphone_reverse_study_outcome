package com.obric.aiagent.skill.manager.impl;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopApiClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class gp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(KnowledgeActivity.KEY_TASK_ID)
    private final String f20016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("status")
    private final String f20017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("manifest_id")
    private final String f20018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("error_code")
    private final String f20019d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("error_message")
    private final String f20020e;

    @SerializedName("created_at")
    private final Long f;

    @SerializedName("updated_at")
    private final Long g;

    @SerializedName("signed_manifest")
    private final JsonElement h;
    private final transient String i;

    public gp() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ gp a(gp r10, String r11, String r12, String r13, String r14, String r15, Long r16, Long r17, JsonElement r18, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.f20016a;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.f20017b;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.f20018c;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.f20019d;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = r10.f20020e;
    L23:
        if ((r20 & 32) == 0) goto L25;
        Long r7 = r10.f;
    L27:
        if ((r20 & 64) == 0) goto L29;
        Long r8 = r10.g;
    L31:
        if ((r20 & 128) == 0) goto L33;
        JsonElement r9 = r10.h;
    L35:
        if ((r20 & 256) == 0) goto L37;
        String r1 = r10.i;
    L39:
        return r10.a(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final gp a(String r12, String r13, String r14, String r15, String r16, Long r17, Long r18, JsonElement r19, String r20) {
        d.h.b.o.e(r12, DBDefinition.TASK_ID);
        d.h.b.o.e(r13, "status");
        d.h.b.o.e(r20, "rawJson");
        return new gp(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, gp.class) == true) goto L8;
        return false;
    L8:
        gp r6 = (gp) ZeusTransformUtils.preCheckCast(r5, gp.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20016a, r6.f20016a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f20017b, r6.f20017b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f20018c, r6.f20018c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f20019d, r6.f20019d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f20020e, r6.f20020e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (d.h.b.o.a(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f20016a.hashCode() * 31) + this.f20017b.hashCode()) * 31;
        String r1 = this.f20018c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f20019d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.f20020e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Long r11 = this.f;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Long r14 = this.g;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        JsonElement r17 = this.h;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return ((r16 + r2) * 31) + this.i.hashCode();
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
        return "SkillSigningTaskData(taskId=" + this.f20016a + ", status=" + this.f20017b + ", manifestId=" + this.f20018c + ", errorCode=" + this.f20019d + ", errorMessage=" + this.f20020e + ", createdAt=" + this.f + ", updatedAt=" + this.g + ", signedManifest=" + this.h + ", rawJson=" + this.i + ')';
    }

    public gp(String r2, String r3, String r4, String r5, String r6, Long r7, Long r8, JsonElement r9, String r10) {
        d.h.b.o.e(r2, DBDefinition.TASK_ID);
        d.h.b.o.e(r3, "status");
        d.h.b.o.e(r10, "rawJson");
        this.f20016a = r2;
        this.f20017b = r3;
        this.f20018c = r4;
        this.f20019d = r5;
        this.f20020e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public /* synthetic */ gp(String r3, String r4, String r5, String r6, String r7, Long r8, Long r9, JsonElement r10, String r11, int r12, d.h.b.h r13) {
        if ((r12 & 1) == 0) goto L6;
        r3 = "";
    L6:
        if ((r12 & 2) == 0) goto L9;
        r4 = "";
    L9:
        if ((r12 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r12 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r12 & 16) == 0) goto L18;
        r7 = null;
    L18:
        if ((r12 & 32) == 0) goto L21;
        r8 = null;
    L21:
        if ((r12 & 64) == 0) goto L24;
        r9 = null;
    L24:
        if ((r12 & 128) == 0) goto L27;
        r10 = null;
    L27:
        if ((r12 & 256) == 0) goto L29;
        r11 = "";
    L29:
        this(r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public final String a() {
        return this.f20016a;
    }

    public final String b() {
        return this.f20017b;
    }

    public final String c() {
        return this.f20018c;
    }

    public final String d() {
        return this.f20019d;
    }

    public final String e() {
        return this.f20020e;
    }

    public final JsonElement f() {
        return this.h;
    }

    public final String g() {
        return this.i;
    }
}
