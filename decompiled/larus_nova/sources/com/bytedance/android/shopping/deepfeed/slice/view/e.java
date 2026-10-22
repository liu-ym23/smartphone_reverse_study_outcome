package com.bytedance.android.shopping.deepfeed.slice.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f173519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f173520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f173521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f173522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f173523e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f173524f;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L18;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f173519a, r101.f173519a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f173520b, r101.f173520b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f173521c, r101.f173521c) == true) goto L12;
        return false;
    L12:
        if (this.f173522d == r101.f173522d) goto L14;
        return false;
    L14:
        if (this.f173523e == r101.f173523e) goto L16;
        return false;
    L16:
        if (this.f173524f == r101.f173524f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final int hashCode() {
        String r100 = this.f173519a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f173520b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f173521c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.f173522d;
        ?? r110 = 1;
        ?? r111 = r109;
        if (r109 == false) goto L16;
        r111 = 1;
    L16:
        int r112 = (r108 + r111) * 31;
        boolean r113 = this.f173523e;
        ?? r114 = r113;
        if (r113 == false) goto L19;
        r114 = 1;
    L19:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.f173524f;
        if (r116 == true) goto L24;
        r110 = r116;
    L24:
        return r115 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveViewData(roomId=" + this.f173519a + ", streamData=" + this.f173520b + ", coverUrl=" + this.f173521c + ", muted=" + this.f173522d + ", visible=" + this.f173523e + ", isPlaying=" + this.f173524f + ")";
    }

    public /* synthetic */ e(int r100) {
        this("", "", "", true, true, false);
    }

    public e(String r100, String r101, String r102, boolean r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "streamData");
        Intrinsics.checkNotNullParameter(r102, "coverUrl");
        this.f173519a = r100;
        this.f173520b = r101;
        this.f173521c = r102;
        this.f173522d = r103;
        this.f173523e = r104;
        this.f173524f = r105;
    }
}
