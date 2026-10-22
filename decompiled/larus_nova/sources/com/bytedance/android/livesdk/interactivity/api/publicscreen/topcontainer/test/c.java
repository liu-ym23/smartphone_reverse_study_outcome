package com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f133553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f133554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f133555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f133556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f133557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f133558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f133559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f133560h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ConflictStrategy f133561i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConflictStrategy f133562j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ConflictStrategy f133563k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f133564l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L30;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f133553a, r101.f133553a) == true) goto L8;
        return false;
    L8:
        if (this.f133554b == r101.f133554b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f133555c, r101.f133555c) == true) goto L12;
        return false;
    L12:
        if (this.f133556d == r101.f133556d) goto L14;
        return false;
    L14:
        if (this.f133557e == r101.f133557e) goto L16;
        return false;
    L16:
        if (this.f133558f == r101.f133558f) goto L18;
        return false;
    L18:
        if (this.f133559g == r101.f133559g) goto L20;
        return false;
    L20:
        if (this.f133560h == r101.f133560h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f133561i, r101.f133561i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f133562j, r101.f133562j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f133563k, r101.f133563k) == true) goto L28;
        return false;
    L28:
        if (this.f133564l == r101.f133564l) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.f133553a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f133554b) * 31;
        String r104 = this.f133555c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f133556d;
        int r108 = (((((((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.f133557e) * 31) + this.f133558f) * 31) + this.f133559g) * 31;
        long r109 = this.f133560h;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        ConflictStrategy r111 = this.f133561i;
        if (r111 == null) goto L13;
        int r112 = r111.hashCode();
    L14:
        int r113 = (r110 + r112) * 31;
        ConflictStrategy r114 = this.f133562j;
        if (r114 == null) goto L17;
        int r115 = r114.hashCode();
    L18:
        int r116 = (r113 + r115) * 31;
        ConflictStrategy r117 = this.f133563k;
        if (r117 == null) goto L21;
        r101 = r117.hashCode();
    L21:
        int r118 = (r116 + r101) * 31;
        boolean r119 = this.f133564l;
        ?? r120 = r119;
        if (r119 == false) goto L25;
        r120 = 1;
    L25:
        return r118 + r120;
    L17:
        r115 = 0;
        goto L18
    L13:
        r112 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "InsertPSTopViewEvent(id=" + this.f133553a + ", priority=" + this.f133554b + ", content=" + this.f133555c + ", startTimestamp=" + this.f133556d + ", allowExceedTime=" + this.f133557e + ", delayTime=" + this.f133558f + ", duration=" + this.f133559g + ", endTimestamp=" + this.f133560h + ", priorityLowerStrategy=" + this.f133561i + ", priorityEqualStrategy=" + this.f133562j + ", priorityHigherStrategy=" + this.f133563k + ", isAssemble=" + this.f133564l + ")";
    }

    public c() {
        ConflictStrategy r100 = ConflictStrategy.QUEUE;
        ConflictStrategy r101 = ConflictStrategy.INTERRUPT;
        Intrinsics.checkNotNullParameter(r100, "priorityLowerStrategy");
        Intrinsics.checkNotNullParameter(r100, "priorityEqualStrategy");
        Intrinsics.checkNotNullParameter(r101, "priorityHigherStrategy");
        this.f133553a = null;
        this.f133554b = 0;
        this.f133555c = null;
        this.f133556d = 0;
        this.f133557e = 0;
        this.f133558f = 0;
        this.f133559g = 30;
        this.f133560h = 0;
        this.f133561i = r100;
        this.f133562j = r100;
        this.f133563k = r101;
        this.f133564l = false;
    }
}
