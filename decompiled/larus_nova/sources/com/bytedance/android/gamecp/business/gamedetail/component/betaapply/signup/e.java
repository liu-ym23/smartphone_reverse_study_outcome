package com.bytedance.android.gamecp.business.gamedetail.component.betaapply.signup;

import android.content.Context;
import com.bytedance.ies.sve_core.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f53815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f53816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f53817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f53818d;

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f53815a, r101.f53815a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f53816b, r101.f53816b) == true) goto L10;
        return false;
    L10:
        if (this.f53817c == r101.f53817c) goto L12;
        return false;
    L12:
        if (this.f53818d == r101.f53818d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final int hashCode() {
        Context r100 = this.f53815a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f53816b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f53817c;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (r105 + r108) * 31;
        boolean r110 = this.f53818d;
        if (r110 == true) goto L17;
        r107 = r110;
    L17:
        return r109 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BetaApplySignUpClickIntent(ctx=" + this.f53815a + ", applyUrl=" + this.f53816b + ", supportPlatform=" + this.f53817c + ", isApplied=" + this.f53818d + ")";
    }

    public e(Context r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f53815a = r100;
        this.f53816b = r101;
        this.f53817c = r102;
        this.f53818d = r103;
    }
}
