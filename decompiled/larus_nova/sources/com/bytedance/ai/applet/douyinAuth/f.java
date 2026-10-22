package com.bytedance.ai.applet.douyinAuth;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f34629c;

    public f() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f34627a, r101.f34627a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34628b, r101.f34628b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f34629c, r101.f34629c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f34627a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f34628b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f34629c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DouyinGeneralAuthTokenResult(openId=" + this.f34627a + ", accessToken=" + this.f34628b + ", errorMsg=" + this.f34629c + ')';
    }

    public /* synthetic */ f(String r100, int r101) {
        if ((r101 & 4) == 0) goto L5;
        r100 = null;
    L5:
        this(null, null, r100);
    }

    public f(String r100, String r101, String r102) {
        this.f34627a = r100;
        this.f34628b = r101;
        this.f34629c = r102;
    }
}
