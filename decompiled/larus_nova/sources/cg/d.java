package cg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f23570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f23571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f23572c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f23570a, r101.f23570a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f23571b, r101.f23571b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f23572c, r101.f23572c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        i r100 = this.f23570a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        b r104 = this.f23571b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        l r107 = this.f23572c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GroupTitleOptimizeVO(specTitleVO=" + this.f23570a + ", chartEntryVO=" + this.f23571b + ", switchModeOptimizeVO=" + this.f23572c + ")";
    }

    public d(i r100, b r101, l r102) {
        this.f23570a = r100;
        this.f23571b = r101;
        this.f23572c = r102;
    }
}
