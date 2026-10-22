package com.bytedance.android.shopping.deepfeed.viewmodel;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f173991a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (this.f173991a == ((a) r100).f173991a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f173991a;
    }

    public final String toString() {
        return "DeeFeedEnterDetailStatus(position=" + this.f173991a + ")";
    }

    public a(int r100) {
        this.f173991a = r100;
    }
}
