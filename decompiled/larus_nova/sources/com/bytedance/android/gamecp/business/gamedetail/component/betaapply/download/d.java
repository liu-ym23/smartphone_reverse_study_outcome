package com.bytedance.android.gamecp.business.gamedetail.component.betaapply.download;

import android.content.Context;
import com.bytedance.ies.sve_core.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f53787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f53788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f53789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f53790d;

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L14;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f53787a, r101.f53787a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f53788b, r101.f53788b) == true) goto L10;
        return false;
    L10:
        if (this.f53789c == r101.f53789c) goto L12;
        return false;
    L12:
        if (this.f53790d == r101.f53790d) goto L22;
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
        Context r100 = this.f53787a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f53788b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f53789c;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (r105 + r108) * 31;
        boolean r110 = this.f53790d;
        if (r110 == true) goto L17;
        r107 = r110;
    L17:
        return r109 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BetaApplyDownloadClickIntent(ctx=" + this.f53787a + ", openScheme=" + this.f53788b + ", isAutoDownload=" + this.f53789c + ", supportPlatform=" + this.f53790d + ")";
    }

    public d(Context r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f53787a = r100;
        this.f53788b = r101;
        this.f53789c = r102;
        this.f53790d = r103;
    }
}
