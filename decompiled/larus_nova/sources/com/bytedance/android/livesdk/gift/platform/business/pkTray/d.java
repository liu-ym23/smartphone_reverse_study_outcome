package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f130040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final py.k f130041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f130042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f130043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f130044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f130045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f130046g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L20;
        d r101 = (d) r100;
        if (this.f130040a == r101.f130040a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f130041b, r101.f130041b) == true) goto L10;
        return false;
    L10:
        if (this.f130042c == r101.f130042c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f130043d, r101.f130043d) == true) goto L14;
        return false;
    L14:
        if (this.f130044e == r101.f130044e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f130045f, r101.f130045f) == true) goto L18;
        return false;
    L18:
        if (this.f130046g == r101.f130046g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f130040a * 31;
        py.k r101 = this.f130041b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((r100 + r103) * 31) + this.f130042c) * 31;
        String r105 = this.f130043d;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        long r107 = this.f130044e;
        int r108 = (((r104 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        String r109 = this.f130045f;
        if (r109 == null) goto L13;
        r102 = r109.hashCode();
    L13:
        int r110 = (r108 + r102) * 31;
        long r111 = this.f130046g;
        return r110 + ((int) (r111 ^ (r111 >>> 32)));
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "CrossRoomTrayData(price=" + this.f130040a + ", icon=" + this.f130041b + ", comboCount=" + this.f130042c + ", toUserId=" + this.f130043d + ", giftId=" + this.f130044e + ", toRoomId=" + this.f130045f + ", duration=" + this.f130046g + ")";
    }

    public d(int r100, py.k r101, int r102, String r103, long r104, String r105, long r106) {
        Intrinsics.checkNotNullParameter(r101, "icon");
        Intrinsics.checkNotNullParameter(r103, "toUserId");
        Intrinsics.checkNotNullParameter(r105, "toRoomId");
        this.f130040a = r100;
        this.f130041b = r101;
        this.f130042c = r102;
        this.f130043d = r103;
        this.f130044e = r104;
        this.f130045f = r105;
        this.f130046g = r106;
    }
}
