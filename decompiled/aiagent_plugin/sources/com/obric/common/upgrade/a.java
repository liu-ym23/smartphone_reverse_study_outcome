package com.obric.common.upgrade;

import androidx.core.internal.view.SupportMenu;
import com.google.gson.annotations.SerializedName;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import os.teatracker.IBdInstall;

/* JADX INFO: compiled from: AppUpgradeResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("file_url")
    private final String f32587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("file_md5")
    private final String f32588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("file_size")
    private final long f32589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("file_kind")
    private final int f32590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("pkg_name")
    private final String f32591e;

    @SerializedName("version_code")
    private final long f;

    @SerializedName("version_name")
    private final String g;

    @SerializedName("apk_identity")
    private final String h;

    @SerializedName("app_id")
    private final String i;

    @SerializedName(IBdInstall.PARAM_APP_NAME)
    private final String j;

    @SerializedName("app_tag")
    private final b k;

    @SerializedName("patch_info")
    private final h l;

    @SerializedName(KnowledgeActivity.KEY_TASK_ID)
    private final long m;

    @SerializedName("update_model")
    private final int n;

    @SerializedName("update_info")
    private final String o;

    @SerializedName("is_depended")
    private final boolean p;

    public a() {
        this(null, null, 0, 0, null, 0, null, null, null, null, null, null, 0, 0, null, false, SupportMenu.USER_MASK, null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
        return false;
    L8:
        a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f32587a, r10.f32587a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f32588b, r10.f32588b) == true) goto L15;
        return false;
    L15:
        if (this.f32589c == r10.f32589c) goto L18;
        return false;
    L18:
        if (this.f32590d == r10.f32590d) goto L21;
        return false;
    L21:
        if (o.a(this.f32591e, r10.f32591e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (o.a(this.h, r10.h) == true) goto L33;
        return false;
    L33:
        if (o.a(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (o.a(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (o.a(this.k, r10.k) == true) goto L42;
        return false;
    L42:
        if (o.a(this.l, r10.l) == true) goto L45;
        return false;
    L45:
        if (this.m == r10.m) goto L48;
        return false;
    L48:
        if (this.n == r10.n) goto L51;
        return false;
    L51:
        if (o.a(this.o, r10.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r10.p) goto L56;
        return false;
    L56:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v31, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int r0 = ((((((((((((((((((this.f32587a.hashCode() * 31) + this.f32588b.hashCode()) * 31) + Long.hashCode(this.f32589c)) * 31) + Integer.hashCode(this.f32590d)) * 31) + this.f32591e.hashCode()) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31;
        b r1 = this.k;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        h r5 = this.l;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (((((((r4 + r2) * 31) + Long.hashCode(this.m)) * 31) + Integer.hashCode(this.n)) * 31) + this.o.hashCode()) * 31;
        boolean r7 = this.p;
        ?? r8 = r7;
        if (r7 == false) goto L14;
        r8 = 1;
    L14:
        return r6 + r8;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("AppInfo(fileUrl=").append(this.f32587a).append(", fileMd5=").append(this.f32588b).append(", fileSize=").append(this.f32589c).append(", fileKind=").append(this.f32590d).append(", pkgName=").append(this.f32591e).append(", versionCode=").append(this.f).append(", versionName=").append(this.g).append(", apkIdentity=").append(this.h).append(", appId=").append(this.i).append(", appName=").append(this.j).append(", appTag=").append(this.k).append(", patchInfo=");
        r0.append(this.l).append(", taskId=").append(this.m).append(", updateModel=").append(this.n).append(", updateInfo=").append(this.o).append(", isDepended=").append(this.p).append(')');
        return r0.toString();
    }

    public a(String r11, String r12, long r13, int r15, String r16, long r17, String r19, String r20, String r21, String r22, b r23, h r24, long r25, int r27, String r28, boolean r29) {
        o.e(r11, "fileUrl");
        o.e(r12, "fileMd5");
        o.e(r16, "pkgName");
        o.e(r19, "versionName");
        o.e(r20, "apkIdentity");
        o.e(r21, "appId");
        o.e(r22, "appName");
        o.e(r28, "updateInfo");
        this.f32587a = r11;
        this.f32588b = r12;
        this.f32589c = r13;
        this.f32590d = r15;
        this.f32591e = r16;
        this.f = r17;
        this.g = r19;
        this.h = r20;
        this.i = r21;
        this.j = r22;
        this.k = r23;
        this.l = r24;
        this.m = r25;
        this.n = r27;
        this.o = r28;
        this.p = r29;
    }

    public /* synthetic */ a(String r21, String r22, long r23, int r25, String r26, long r27, String r29, String r30, String r31, String r32, b r33, h r34, long r35, int r37, String r38, boolean r39, int r40, d.h.b.h r41) {
        if ((r40 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r40 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r40 & 4) == 0) goto L13;
        long r7 = 0;
    L15:
        if ((r40 & 8) == 0) goto L17;
        int r4 = 0;
    L19:
        if ((r40 & 16) == 0) goto L21;
        String r10 = "";
    L23:
        if ((r40 & 32) == 0) goto L25;
        long r11 = 0;
    L27:
        if ((r40 & 64) == 0) goto L29;
        String r13 = "";
    L31:
        if ((r40 & 128) == 0) goto L33;
        String r14 = "";
    L35:
        if ((r40 & 256) == 0) goto L37;
        String r15 = "";
    L39:
        if ((r40 & 512) == 0) goto L41;
        String r5 = "";
    L42:
        h r16 = null;
        if ((r40 & 1024) == 0) goto L45;
        b r6 = null;
    L47:
        if ((r40 & 2048) != 0) goto L51;
        r16 = r34;
    L51:
        if ((r40 & 4096) == 0) goto L53;
        long r17 = 0;
    L55:
        if ((r40 & 8192) == 0) goto L57;
        int r9 = 0;
    L59:
        if ((r40 & 16384) == 0) goto L61;
        String r2 = "";
    L63:
        if ((r40 & 32768) == 0) goto L65;
        boolean r0 = false;
    L66:
        this(r1, r3, r7, r4, r10, r11, r13, r14, r15, r5, r6, r16, r17, r9, r2, r0);
        return;
    L65:
        r0 = r39;
        goto L66
    L61:
        r2 = r38;
        goto L63
    L57:
        r9 = r37;
        goto L59
    L53:
        r17 = r35;
        goto L55
    L45:
        r6 = r33;
        goto L47
    L41:
        r5 = r32;
        goto L42
    L37:
        r15 = r31;
        goto L39
    L33:
        r14 = r30;
        goto L35
    L29:
        r13 = r29;
        goto L31
    L25:
        r11 = r27;
        goto L27
    L21:
        r10 = r26;
        goto L23
    L17:
        r4 = r25;
        goto L19
    L13:
        r7 = r23;
        goto L15
    L9:
        r3 = r22;
        goto L11
    L5:
        r1 = r21;
        goto L7
    }

    public final String a() {
        return this.f32587a;
    }

    public final String b() {
        return this.f32588b;
    }

    public final long c() {
        return this.f;
    }

    public final String d() {
        return this.g;
    }

    public final long e() {
        return this.m;
    }

    public final int f() {
        return this.n;
    }

    public final String g() {
        return this.o;
    }
}
