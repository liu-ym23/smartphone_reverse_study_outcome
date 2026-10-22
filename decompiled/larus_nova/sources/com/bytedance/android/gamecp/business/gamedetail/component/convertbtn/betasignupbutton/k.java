package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betasignupbutton;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class k implements com.bytedance.ies.sve_core.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f54131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f54133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f54134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f54135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f54136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f54137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f54138h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f54139i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f54140j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f54141k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f54142l;

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L30;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f54131a, r101.f54131a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54132b, r101.f54132b) == true) goto L10;
        return false;
    L10:
        if (this.f54133c == r101.f54133c) goto L12;
        return false;
    L12:
        if (this.f54134d == r101.f54134d) goto L14;
        return false;
    L14:
        if (this.f54135e == r101.f54135e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f54136f, r101.f54136f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f54137g, r101.f54137g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f54138h, r101.f54138h) == true) goto L22;
        return false;
    L22:
        if (this.f54139i == r101.f54139i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f54140j, r101.f54140j) == true) goto L26;
        return false;
    L26:
        if (this.f54141k == r101.f54141k) goto L28;
        return false;
    L28:
        if (this.f54142l == r101.f54142l) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final int hashCode() {
        Context r100 = this.f54131a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f54132b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f54133c;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        boolean r109 = this.f54134d;
        ?? r110 = 1;
        ?? r111 = r109;
        if (r109 == false) goto L13;
        r111 = 1;
    L13:
        int r112 = (r108 + r111) * 31;
        boolean r113 = this.f54135e;
        ?? r114 = r113;
        if (r113 == false) goto L16;
        r114 = 1;
    L16:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f54136f;
        if (r116 == null) goto L19;
        int r117 = r116.hashCode();
    L20:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f54137g;
        if (r119 == null) goto L23;
        int r120 = r119.hashCode();
    L24:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f54138h;
        if (r122 == null) goto L27;
        int r123 = r122.hashCode();
    L28:
        int r124 = (((r121 + r123) * 31) + this.f54139i) * 31;
        String r125 = this.f54140j;
        if (r125 == null) goto L31;
        r101 = r125.hashCode();
    L31:
        int r126 = (((r124 + r101) * 31) + this.f54141k) * 31;
        boolean r127 = this.f54142l;
        if (r127 == true) goto L36;
        r110 = r127;
    L36:
        return r126 + r110;
    L27:
        r123 = 0;
        goto L28
    L23:
        r120 = 0;
        goto L24
    L19:
        r117 = 0;
        goto L20
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RegisterJSIntent(ctx=" + this.f54131a + ", applyUrl=" + this.f54132b + ", supportPlatform=" + this.f54133c + ", isSupportAndroid=" + this.f54134d + ", isApplied=" + this.f54135e + ", planId=" + this.f54136f + ", successToastForNative=" + this.f54137g + ", signResultForLynx=" + this.f54138h + ", reservedStatus=" + this.f54139i + ", applySuccessSchema=" + this.f54140j + ", gameStage=" + this.f54141k + ", isPC=" + this.f54142l + ")";
    }

    public k(Context r100, String r101, long r102, boolean r103, boolean r104, String r105, String r106, String r110, int r111, String r112, int r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f54131a = r100;
        this.f54132b = r101;
        this.f54133c = r102;
        this.f54134d = r103;
        this.f54135e = r104;
        this.f54136f = r105;
        this.f54137g = r106;
        this.f54138h = r110;
        this.f54139i = r111;
        this.f54140j = r112;
        this.f54141k = r113;
        this.f54142l = r114;
    }
}
