package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j2 f131614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j2 f131615b;

    public k2() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k2) == false) goto L10;
        k2 r101 = (k2) r100;
        if (Intrinsics.areEqual(this.f131614a, r101.f131614a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f131615b, r101.f131615b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        j2 r100 = this.f131614a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        j2 r104 = this.f131615b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftSendInfo(sendDetailForFirstScreen=" + this.f131614a + ", sendDetail=" + this.f131615b + ")";
    }

    public k2(int r100) {
        this.f131614a = null;
        this.f131615b = null;
    }
}
