package com.bytedance.android.gamecp.business.gamedetail.component.bottombar;

import com.bytedance.ies.sve_core.i;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f53838a;

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return false;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        if (this.f53838a == ((b) r100).f53838a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f53838a;
    }

    public final String toString() {
        return "BottomBarHeightChangeIntent(height=" + this.f53838a + ")";
    }

    public b(int r100) {
        this.f53838a = r100;
    }
}
