package com.bytedance.android.live.profile.ui.base;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f86322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f86323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f86324c;

    public c() {
        this(0, 0, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (this.f86322a == r101.f86322a) goto L8;
        return false;
    L8:
        if (this.f86323b == r101.f86323b) goto L10;
        return false;
    L10:
        if (this.f86324c == r101.f86324c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.f86322a * 31) + this.f86323b) * 31) + this.f86324c;
    }

    public final String toString() {
        return "ContainerConfig(containerId=" + this.f86322a + ", bottomDependenceId=" + this.f86323b + ", topDependenceId=" + this.f86324c + ")";
    }

    public c(int r100, int r101, int r102) {
        int r103 = -1;
        if ((r102 & 1) == 0) goto L6;
        r100 = -1;
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = -1;
    L9:
        if ((r102 & 4) != 0) goto L12;
        r103 = 0;
    L12:
        this.f86322a = r100;
        this.f86323b = r101;
        this.f86324c = r103;
    }
}
