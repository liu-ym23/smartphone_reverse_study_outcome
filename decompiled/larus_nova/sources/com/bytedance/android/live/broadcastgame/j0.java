package com.bytedance.android.live.broadcastgame;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f59637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f59638b;

    public static final class a {
    }

    static {
    }

    public /* synthetic */ j0() {
        this(0, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j0) == false) goto L10;
        j0 r101 = (j0) r100;
        if (this.f59637a == r101.f59637a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f59638b, r101.f59638b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f59637a * 31;
        String r101 = this.f59638b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "Status(statusCode=" + this.f59637a + ", errorMsg=" + this.f59638b + ")";
    }

    public j0(int r100, String r101) {
        this.f59637a = r100;
        this.f59638b = r101;
    }
}
