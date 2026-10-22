package com.bytedance.android.live.room.api.messagewindow.monitor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f98998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f98999b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f98998a, r101.f98998a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f98999b, r101.f98999b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f98998a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Throwable r104 = this.f98999b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CardAlogParams(msg=" + this.f98998a + ", error=" + this.f98999b + ")";
    }

    public a(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        this.f98998a = r100;
        this.f98999b = r101;
    }
}
