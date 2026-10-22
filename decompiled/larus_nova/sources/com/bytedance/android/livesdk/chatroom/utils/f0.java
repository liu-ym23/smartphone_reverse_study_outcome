package com.bytedance.android.livesdk.chatroom.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f114458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f114459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f114460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f114461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f114462e;

    public f0() {
        this(false, 0, "", null, "");
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f0) == false) goto L16;
        f0 r101 = (f0) r100;
        if (this.f114458a == r101.f114458a) goto L8;
        return false;
    L8:
        if (this.f114459b == r101.f114459b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f114460c, r101.f114460c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f114461d, r101.f114461d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f114462e, r101.f114462e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public final int hashCode() {
        boolean r100 = this.f114458a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((r101 * 31) + this.f114459b) * 31;
        String r103 = this.f114460c;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f114461d;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f114462e;
        if (r110 == null) goto L17;
        r104 = r110.hashCode();
    L17:
        return r109 + r104;
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "InnerDrawData(isDraw=" + this.f114458a + ", drawType=" + this.f114459b + ", url=" + this.f114460c + ", reqFromSetting=" + this.f114461d + ", sourceKey=" + this.f114462e + ")";
    }

    public f0(boolean r100, int r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(r104, "sourceKey");
        this.f114458a = r100;
        this.f114459b = r101;
        this.f114460c = r102;
        this.f114461d = r103;
        this.f114462e = r104;
    }
}
