package com.bytedance.android.live.broadcastgame.api.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f59338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReloadPanelType f59339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f59340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f59341d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f0) == false) goto L14;
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.f59338a, r101.f59338a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f59339b, r101.f59339b) == true) goto L10;
        return false;
    L10:
        if (this.f59340c == r101.f59340c) goto L12;
        return false;
    L12:
        if (this.f59341d == r101.f59341d) goto L22;
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
        String r100 = this.f59338a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ReloadPanelType r104 = this.f59339b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f59340c;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (r105 + r108) * 31;
        boolean r110 = this.f59341d;
        if (r110 == true) goto L17;
        r107 = r110;
    L17:
        return r109 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "id:" + this.f59338a + " reload:" + this.f59339b + " addRecentUsed:" + this.f59340c + " runningState:" + this.f59341d;
    }

    public f0(String r100, ReloadPanelType r101, boolean r102, boolean r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = ReloadPanelType.NOT_RELOAD;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = false;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = false;
    L11:
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "reloadPanel");
        this.f59338a = r100;
        this.f59339b = r101;
        this.f59340c = r102;
        this.f59341d = r103;
    }
}
