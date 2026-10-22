package com.obric.oui.privacy;

import com.tmall.wireless.tangram.dataparser.concrete.Card;
import java.util.List;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f16390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f16391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f16392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f16393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f16394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f16395i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f16396j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f16397k;

    public d(String r10, String r11, String r12, List r13, String r14, List r15, String r16, String r17, boolean r18, boolean r19, boolean r110) {
        q.g(r11, "appName");
        q.g(r13, Card.KEY_ITEMS);
        q.g(r15, "privacyPolicyLinkTexts");
        this.f16387a = r10;
        this.f16388b = r11;
        this.f16389c = r12;
        this.f16390d = r13;
        this.f16391e = r14;
        this.f16392f = r15;
        this.f16393g = r16;
        this.f16394h = r17;
        this.f16395i = r18;
        this.f16396j = r19;
        this.f16397k = r110;
    }

    public final String a() {
        return this.f16393g;
    }

    public final String b() {
        return this.f16389c;
    }

    public final String c() {
        return this.f16387a;
    }

    public final String d() {
        return this.f16388b;
    }

    public final boolean e() {
        return this.f16396j;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (q.b(this.f16387a, r11.f16387a) == true) goto L12;
        return false;
    L12:
        if (q.b(this.f16388b, r11.f16388b) == true) goto L15;
        return false;
    L15:
        if (q.b(this.f16389c, r11.f16389c) == true) goto L18;
        return false;
    L18:
        if (q.b(this.f16390d, r11.f16390d) == true) goto L21;
        return false;
    L21:
        if (q.b(this.f16391e, r11.f16391e) == true) goto L24;
        return false;
    L24:
        if (q.b(this.f16392f, r11.f16392f) == true) goto L27;
        return false;
    L27:
        if (q.b(this.f16393g, r11.f16393g) == true) goto L30;
        return false;
    L30:
        if (q.b(this.f16394h, r11.f16394h) == true) goto L33;
        return false;
    L33:
        if (this.f16395i == r11.f16395i) goto L36;
        return false;
    L36:
        if (this.f16396j == r11.f16396j) goto L39;
        return false;
    L39:
        if (this.f16397k == r11.f16397k) goto L41;
        return false;
    L41:
        return true;
    }

    public final boolean f() {
        return this.f16395i;
    }

    public final boolean g() {
        return this.f16397k;
    }

    public final String h() {
        return this.f16394h;
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
        String r10 = this.f16387a;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = ((r12 * 31) + this.f16388b.hashCode()) * 31;
        String r14 = this.f16389c;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (((r13 + r15) * 31) + this.f16390d.hashCode()) * 31;
        String r17 = this.f16391e;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (((r16 + r18) * 31) + this.f16392f.hashCode()) * 31;
        String r20 = this.f16393g;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.f16394h;
        if (r23 == null) goto L22;
        r11 = r23.hashCode();
    L22:
        int r24 = (r22 + r11) * 31;
        boolean r25 = this.f16395i;
        ?? r26 = 1;
        ?? r27 = r25;
        if (r25 == false) goto L25;
        r27 = 1;
    L25:
        int r28 = (r24 + r27) * 31;
        boolean r29 = this.f16396j;
        ?? r30 = r29;
        if (r29 == false) goto L28;
        r30 = 1;
    L28:
        int r31 = (r28 + r30) * 31;
        boolean r32 = this.f16397k;
        if (r32 == true) goto L33;
        r26 = r32;
    L33:
        return r31 + r26;
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final List i() {
        return this.f16390d;
    }

    public final List j() {
        return this.f16392f;
    }

    public final String k() {
        return this.f16391e;
    }

    public String toString() {
        return "OPrivacySheetConfig(appIconPackageName=" + this.f16387a + ", appName=" + this.f16388b + ", appDescription=" + this.f16389c + ", items=" + this.f16390d + ", privacyPolicyText=" + this.f16391e + ", privacyPolicyLinkTexts=" + this.f16392f + ", agreeButtonText=" + this.f16393g + ", exitButtonText=" + this.f16394h + ", enableDim=" + this.f16395i + ", cancelable=" + this.f16396j + ", enableEnterAnim=" + this.f16397k + ')';
    }
}
