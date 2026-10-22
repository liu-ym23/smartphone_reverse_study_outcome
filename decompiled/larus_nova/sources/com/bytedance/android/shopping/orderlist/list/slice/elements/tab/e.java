package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f180310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f180311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f180312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f180313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f180314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f180315f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L18;
        e r101 = (e) r100;
        if (this.f180310a == r101.f180310a) goto L8;
        return false;
    L8:
        if (this.f180311b == r101.f180311b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f180312c, r101.f180312c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f180313d, r101.f180313d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f180314e, r101.f180314e) == true) goto L16;
        return false;
    L16:
        if (this.f180315f == r101.f180315f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    public final int hashCode() {
        int r100 = this.f180310a * 31;
        boolean r101 = this.f180311b;
        ?? r102 = r101;
        if (r101 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = (r100 + r102) * 31;
        String r104 = this.f180312c;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        Long r108 = this.f180313d;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        Boolean r111 = this.f180314e;
        if (r111 == null) goto L17;
        r105 = r111.hashCode();
    L17:
        return ((r110 + r105) * 31) + this.f180315f;
    L12:
        r109 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "OrderListTabBubbleEvent(tabId=" + this.f180310a + ", visible=" + this.f180311b + ", text=" + this.f180312c + ", autoCloseTimeMs=" + this.f180313d + ", clickToClose=" + this.f180314e + ", backgroundColor=" + this.f180315f + ")";
    }

    public e(int r100, boolean r101, String r102, Long r103, Boolean r104, int r105) {
        this.f180310a = r100;
        this.f180311b = r101;
        this.f180312c = r102;
        this.f180313d = r103;
        this.f180314e = r104;
        this.f180315f = r105;
    }
}
