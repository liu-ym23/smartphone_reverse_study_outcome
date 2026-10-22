package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.x2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f96591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f96592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IBaseBattleSetting f96593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x2 f96594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f96595e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L16;
        s r101 = (s) r100;
        if (this.f96591a == r101.f96591a) goto L8;
        return false;
    L8:
        if (this.f96592b == r101.f96592b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f96593c, r101.f96593c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f96594d, r101.f96594d) == true) goto L14;
        return false;
    L14:
        if (this.f96595e == r101.f96595e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f96591a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f96592b) * 31;
        IBaseBattleSetting r102 = this.f96593c;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        x2 r106 = this.f96594d;
        if (r106 == null) goto L10;
        r103 = r106.hashCode();
    L10:
        return ((r105 + r103) * 31) + this.f96595e;
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "PenalInfo(startTimeMs=" + this.f96591a + ", duration=" + this.f96592b + ", setting=" + this.f96593c + ", skinConfig=" + this.f96594d + ", skinType=" + this.f96595e + ")";
    }

    public s(long r100, int r101, IBaseBattleSetting r102, x2 r103, int r104) {
        Intrinsics.checkNotNullParameter(r102, "setting");
        this.f96591a = r100;
        this.f96592b = r101;
        this.f96593c = r102;
        this.f96594d = r103;
        this.f96595e = r104;
    }
}
