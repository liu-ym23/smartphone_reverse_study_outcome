package com.bytedance.android.gamecp.business.comment.edit.help;

/* JADX INFO: loaded from: classes44.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f52140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f52141b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (this.f52140a == r101.f52140a) goto L8;
        return false;
    L8:
        if (this.f52141b == r101.f52141b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f52140a * 31) + this.f52141b;
    }

    public final String toString() {
        return "InputPanelLocationInfo(originHeight=" + this.f52140a + ", originBottom=" + this.f52141b + ")";
    }

    public e(int r100, int r101) {
        this.f52140a = r100;
        this.f52141b = r101;
    }
}
