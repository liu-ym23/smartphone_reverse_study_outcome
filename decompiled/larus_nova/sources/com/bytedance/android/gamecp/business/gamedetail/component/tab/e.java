package com.bytedance.android.gamecp.business.gamedetail.component.tab;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements m56.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f55069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f55070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f55071d;

    public final int hashCode() {
        String r100 = this.f55068a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f55069b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f55070c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        a r110 = this.f55071d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameTabInfo(tabId=" + this.f55068a + ", tabName=" + this.f55069b + ", tabType=" + this.f55070c + ", bottomBar=" + this.f55071d + ")";
    }

    @Override // m56.a
    public final String getTabId() {
        return this.f55068a;
    }

    @Override // m56.a
    public final String getTabName() {
        return this.f55069b;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f55068a, r101.f55068a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55069b, r101.f55069b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f55070c, r101.f55070c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f55071d, r101.f55071d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public e(String r100, String r101, String r102, a r103) {
        Intrinsics.checkNotNullParameter(r100, "tabId");
        Intrinsics.checkNotNullParameter(r101, "tabName");
        Intrinsics.checkNotNullParameter(r102, "tabType");
        Intrinsics.checkNotNullParameter(r103, "bottomBar");
        this.f55068a = r100;
        this.f55069b = r101;
        this.f55070c = r102;
        this.f55071d = r103;
    }
}
