package com.bytedance.android.btm.impl.page.unknown;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f42396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f42397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f42398c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (this.f42398c == ((a) r100).f42398c) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f42398c;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "DialogFragModel(isHybridContainer=" + this.f42398c + ")";
    }

    public a() {
        this.f42398c = true;
    }
}
