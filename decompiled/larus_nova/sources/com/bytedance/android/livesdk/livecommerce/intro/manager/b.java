package com.bytedance.android.livesdk.livecommerce.intro.manager;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f148380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f148381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f148382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Runnable f148383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f148384e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (this.f148380a == r101.f148380a) goto L8;
        return false;
    L8:
        if (this.f148381b == r101.f148381b) goto L10;
        return false;
    L10:
        if (this.f148382c == r101.f148382c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f148383d, r101.f148383d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f148384e, r101.f148384e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final int hashCode() {
        int r100 = this.f148380a * 31;
        boolean r101 = this.f148381b;
        ?? r102 = r101;
        if (r101 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = (((r100 + r102) * 31) + this.f148382c) * 31;
        Runnable r104 = this.f148383d;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        Runnable r108 = this.f148384e;
        if (r108 == null) goto L13;
        r105 = r108.hashCode();
    L13:
        return r107 + r105;
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "CardQueueParams(priority=" + this.f148380a + ", isInterruptible=" + this.f148381b + ", cardType=" + this.f148382c + ", showCardRunnable=" + this.f148383d + ", hideCardRunnable=" + this.f148384e + ")";
    }

    public b(int r100, m r101, n r102) {
        Intrinsics.checkNotNullParameter(r101, "showCardRunnable");
        Intrinsics.checkNotNullParameter(r102, "hideCardRunnable");
        this.f148380a = 100;
        this.f148381b = true;
        this.f148382c = r100;
        this.f148383d = r101;
        this.f148384e = r102;
    }
}
