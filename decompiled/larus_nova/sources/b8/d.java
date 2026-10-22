package b8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f18004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f18005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b7.a f18006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f18007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f18008e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f18004a, r101.f18004a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f18005b, r101.f18005b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f18006c, r101.f18006c) == true) goto L18;
        return false;
    L18:
        if (this.f18007d == r101.f18007d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f18008e, r101.f18008e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        b r100 = this.f18004a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        b r104 = this.f18005b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        b7.a r107 = this.f18006c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        if (this.f18007d == false) goto L17;
        int r109 = 1231;
    L19:
        return ((r108 + r109) * 31) + this.f18008e.hashCode();
    L17:
        r109 = 1237;
        goto L19
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LogModel(aLogParam=" + this.f18004a + ", debugLog=" + this.f18005b + ", context=" + this.f18006c + ", allowDelay=" + this.f18007d + ", tag=" + this.f18008e + ')';
    }

    public final b7.a getContext() {
        return this.f18006c;
    }

    public d(b r100, b r101, boolean r102, String r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r102 = false;
    L11:
        Intrinsics.checkNotNullParameter(r103, "tag");
        this.f18004a = r100;
        this.f18005b = r101;
        this.f18006c = null;
        this.f18007d = r102;
        this.f18008e = r103;
    }
}
