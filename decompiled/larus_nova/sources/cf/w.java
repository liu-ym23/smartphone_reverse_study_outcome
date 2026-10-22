package cf;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f23493c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof w) == false) goto L12;
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f23491a, r101.f23491a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f23492b, r101.f23492b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f23493c, r101.f23493c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f23491a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f23492b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f23493c;
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
        return "RoomInfo(roomId=" + this.f23491a + ", anchorId=" + this.f23492b + ", isEcLive=" + this.f23493c + ")";
    }

    public w(String r100, String r101, Boolean r102) {
        this.f23491a = r100;
        this.f23492b = r101;
        this.f23493c = r102;
    }
}
