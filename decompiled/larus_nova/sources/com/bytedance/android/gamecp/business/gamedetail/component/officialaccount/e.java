package com.bytedance.android.gamecp.business.gamedetail.component.officialaccount;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements com.bytedance.ies.sve_core.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f54713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f54715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f54716d;

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return false;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (this.f54713a == r101.f54713a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54714b, r101.f54714b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f54715c, r101.f54715c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f54716d, r101.f54716d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r100 = this.f54713a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f54714b;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f54715c;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f54716d;
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
        return "FollowUserIntent(isFollow=" + this.f54713a + ", followUserId=" + this.f54714b + ", name=" + this.f54715c + ", fansNum=" + this.f54716d + ")";
    }

    public e(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "followUserId");
        Intrinsics.checkNotNullParameter("", "name");
        Intrinsics.checkNotNullParameter("", "fansNum");
        this.f54713a = r100;
        this.f54714b = r101;
        this.f54715c = "";
        this.f54716d = "";
    }
}
