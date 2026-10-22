package com.bytedance.android.gamecp.base.gamedetail;

/* JADX INFO: loaded from: classes44.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f51606a;

    public j0() {
        this(false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j0) == true) goto L6;
        return false;
    L6:
        if (this.f51606a == ((j0) r100).f51606a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f51606a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "GameDetailInfoTabUIStyle(skipDrawDecoration=" + this.f51606a + ")";
    }

    public j0(boolean r100) {
        this.f51606a = r100;
    }
}
