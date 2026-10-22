package com.bytedance.android.gamecp.business.gamedetail.component.intro;

import com.bytedance.ies.sve_core.s;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f54390b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f54391a;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == true) goto L6;
        return false;
    L6:
        if (this.f54391a == ((g) r100).f54391a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f54391a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "IntroExpandState(expand=" + this.f54391a + ")";
    }

    public g(boolean r100) {
        this.f54391a = r100;
    }
}
