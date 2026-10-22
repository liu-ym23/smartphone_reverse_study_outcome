package com.bytedance.android.live.profit.lottery;

import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f88165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f88166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f88167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JsonObject f88168d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p0) == false) goto L14;
        p0 r101 = (p0) r100;
        if (this.f88165a == r101.f88165a) goto L8;
        return false;
    L8:
        if (this.f88166b == r101.f88166b) goto L10;
        return false;
    L10:
        if (this.f88167c == r101.f88167c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f88168d, r101.f88168d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        boolean r100 = this.f88165a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f88166b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f88167c;
        if (r107 == true) goto L12;
        r101 = r107;
    L12:
        int r108 = (r106 + r101) * 31;
        JsonObject r109 = this.f88168d;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L17:
        return r108 + r110;
    L15:
        r110 = 0;
        goto L17
    }

    public final String toString() {
        return "LotteryFinishInfo(isParticipated=" + this.f88165a + ", isLucky=" + this.f88166b + ')';
    }

    public p0(boolean r100, boolean r101, boolean r102, JsonObject r103) {
        Intrinsics.checkNotNullParameter(r103, "rawResponse");
        this.f88165a = r100;
        this.f88166b = r101;
        this.f88167c = r102;
        this.f88168d = r103;
    }
}
