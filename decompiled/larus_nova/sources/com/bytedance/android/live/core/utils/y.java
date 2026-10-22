package com.bytedance.android.live.core.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IRoom f66427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f66428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f66429c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y) == false) goto L12;
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.f66427a, r101.f66427a) == true) goto L8;
        return false;
    L8:
        if (this.f66428b == r101.f66428b) goto L10;
        return false;
    L10:
        if (this.f66429c == r101.f66429c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        IRoom r100 = this.f66427a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f66428b;
        ?? r104 = 1;
        ?? r105 = r103;
        if (r103 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r102 + r105) * 31;
        boolean r107 = this.f66429c;
        if (r107 == true) goto L14;
        r104 = r107;
    L14:
        return r106 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "DataCenterCommonFields(room=" + this.f66427a + ", isPortrait=" + this.f66428b + ", isAnchor=" + this.f66429c + ")";
    }

    public y(IRoom r100, boolean r101, boolean r102) {
        this.f66427a = r100;
        this.f66428b = r101;
        this.f66429c = r102;
    }
}
