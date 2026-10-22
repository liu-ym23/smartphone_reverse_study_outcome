package cl8;

import jl8.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f24130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f24131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f24132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f24133d;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f24130a, r101.f24130a) == true) goto L12;
        return false;
    L12:
        if (this.f24131b == r101.f24131b) goto L15;
        return false;
    L15:
        if (this.f24132c == r101.f24132c) goto L18;
        return false;
    L18:
        if (this.f24133d == r101.f24133d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f24130a.hashCode() * 31;
        int r101 = 1231;
        if (this.f24131b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f24132c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f24133d == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "FileOperateViewInput(header=" + this.f24130a + ", hasCode=" + this.f24131b + ", isFold=" + this.f24132c + ", enableHeaderClick=" + this.f24133d + ')';
    }

    public /* synthetic */ a(int r110) {
        this(new f(null, null, null, null, null, null, 0, null, false, false, false, 0, 0, 0, 16383), false, false, false);
    }

    public a(f r100, boolean r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "header");
        this.f24130a = r100;
        this.f24131b = r101;
        this.f24132c = r102;
        this.f24133d = r103;
    }
}
