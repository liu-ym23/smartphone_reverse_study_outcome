package b30;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17118b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c0) == false) goto L10;
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f17117a, r101.f17117a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f17118b, r101.f17118b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f17117a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f17118b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ShowFansClubGuideEvent(content=" + this.f17117a + ", source=" + this.f17118b + ")";
    }

    public c0(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f17117a = r100;
        this.f17118b = r101;
    }
}
