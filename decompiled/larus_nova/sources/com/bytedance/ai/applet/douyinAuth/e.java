package com.bytedance.ai.applet.douyinAuth;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f34625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34626b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f34625a == r101.f34625a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34626b, r101.f34626b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f34625a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f34626b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "DouyinGeneralAuthStatusResult(isAuthorized=" + this.f34625a + ", errorMsg=" + this.f34626b + ')';
    }

    public e(boolean r100, String r101) {
        this.f34625a = r100;
        this.f34626b = r101;
    }
}
