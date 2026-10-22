package com.bytedance.android.gamecp.business.gamedetail.page.comment;

import com.bytedance.ies.sve_core.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f55340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f55341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f55342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f55343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f55344f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f55339a, r101.f55339a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55340b, r101.f55340b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f55341c, r101.f55341c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f55342d, r101.f55342d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f55343e, r101.f55343e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f55344f, r101.f55344f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f55339a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f55340b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f55341c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f55342d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f55343e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.f55344f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "GameCommentTabProps(tabId=" + this.f55339a + ", tabName=" + this.f55340b + ", gameId=" + this.f55341c + ", gameName=" + this.f55342d + ", packageName=" + this.f55343e + ", enableInternalEntrance=" + this.f55344f + ")";
    }

    public c(String r100, String r101, String r102, String r103, String r104, Boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "tabId");
        Intrinsics.checkNotNullParameter(r101, "tabName");
        this.f55339a = r100;
        this.f55340b = r101;
        this.f55341c = r102;
        this.f55342d = r103;
        this.f55343e = r104;
        this.f55344f = r105;
    }
}
