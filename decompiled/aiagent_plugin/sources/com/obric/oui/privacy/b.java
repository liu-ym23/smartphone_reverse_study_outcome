package com.obric.oui.privacy;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: OPrivacySheetConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f36090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f36091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f36092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<d> f36093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f36094e;
    private final List<String> f;
    private final String g;
    private final String h;
    private final boolean i;
    private final boolean j;
    private final boolean k;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f36090a, r6.f36090a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f36091b, r6.f36091b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f36092c, r6.f36092c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f36093d, r6.f36093d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f36094e, r6.f36094e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (o.a(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (o.a(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L41;
        return false;
    L41:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    public int hashCode() {
        String r0 = this.f36090a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.f36091b.hashCode()) * 31;
        String r4 = this.f36092c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.f36093d.hashCode()) * 31;
        String r7 = this.f36094e;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r6 + r8) * 31) + this.f.hashCode()) * 31;
        String r10 = this.g;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.h;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        int r14 = (r12 + r1) * 31;
        boolean r15 = this.i;
        ?? r16 = 1;
        ?? r17 = r15;
        if (r15 == false) goto L25;
        r17 = 1;
    L25:
        int r18 = (r14 + r17) * 31;
        boolean r19 = this.j;
        ?? r20 = r19;
        if (r19 == false) goto L28;
        r20 = 1;
    L28:
        int r21 = (r18 + r20) * 31;
        boolean r22 = this.k;
        if (r22 == true) goto L33;
        r16 = r22;
    L33:
        return r21 + r16;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("OPrivacySheetConfig(appIconPackageName=").append(this.f36090a).append(", appName=").append(this.f36091b).append(", appDescription=").append(this.f36092c).append(", items=").append(this.f36093d).append(", privacyPolicyText=").append(this.f36094e).append(", privacyPolicyLinkTexts=").append(this.f).append(", agreeButtonText=").append(this.g).append(", exitButtonText=").append(this.h).append(", enableDim=").append(this.i).append(", cancelable=").append(this.j).append(", enableEnterAnim=").append(this.k).append(')');
        return r0.toString();
    }

    public b(String r3, String r4, String r5, List<? extends d> r6, String r7, List<String> r8, String r9, String r10, boolean r11, boolean r12, boolean r13) {
        List<d> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List<String> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "appName");
        o.e(r14, "items");
        o.e(r15, "privacyPolicyLinkTexts");
        this.f36090a = r3;
        this.f36091b = r4;
        this.f36092c = r5;
        this.f36093d = r14;
        this.f36094e = r7;
        this.f = r15;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
    }

    public final String a() {
        return this.f36090a;
    }

    public final String b() {
        return this.f36091b;
    }

    public final String c() {
        return this.f36092c;
    }

    public final List<d> d() {
        return this.f36093d;
    }

    public final String e() {
        return this.f36094e;
    }

    public final List<String> f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public final boolean i() {
        return this.i;
    }

    public final boolean j() {
        return this.j;
    }

    public final boolean k() {
        return this.k;
    }
}
