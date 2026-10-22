package com.bytedance.android.live.ktv.common.karaokestation.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f69572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f69573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f69574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f69575d;

    public x() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x) == false) goto L14;
        x r101 = (x) r100;
        if (this.f69572a == r101.f69572a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f69573b, r101.f69573b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f69574c, r101.f69574c) == true) goto L12;
        return false;
    L12:
        if (this.f69575d == r101.f69575d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public final int hashCode() {
        long r100 = this.f69572a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f69573b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f69574c;
        if (r106 == null) goto L9;
        r103 = r106.hashCode();
    L9:
        int r107 = (r105 + r103) * 31;
        boolean r108 = this.f69575d;
        ?? r109 = r108;
        if (r108 == false) goto L13;
        r109 = 1;
    L13:
        return r107 + r109;
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "RoomInfo(roomId=" + this.f69572a + ", anchorId=" + this.f69573b + ", currentUserId=" + this.f69574c + ", isAnchor=" + this.f69575d + ")";
    }

    public /* synthetic */ x(int r100) {
        this(0, "", "", false);
    }

    public x(long r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "anchorId");
        Intrinsics.checkNotNullParameter(r102, "currentUserId");
        this.f69572a = r100;
        this.f69573b = r101;
        this.f69574c = r102;
        this.f69575d = r103;
    }
}
