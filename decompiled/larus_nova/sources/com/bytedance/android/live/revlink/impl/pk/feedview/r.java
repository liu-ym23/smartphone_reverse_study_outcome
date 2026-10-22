package com.bytedance.android.live.revlink.impl.pk.feedview;

import com.bytedance.android.livesdk.link.model.f4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f4 f96618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f96619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f4 f96620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f96621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f96622e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L16;
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f96618a, r101.f96618a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f96619b, r101.f96619b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f96620c, r101.f96620c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f96621d, r101.f96621d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f96622e, r101.f96622e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        f4 r100 = this.f96618a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f96619b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        f4 r107 = this.f96620c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f96621d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.f96622e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FeedPropCardData(leftEffectInfo=" + this.f96618a + ", leftPropCardShowing=" + this.f96619b + ", rightEffectInfo=" + this.f96620c + ", rightPropCardShowing=" + this.f96621d + ", isSelf=" + this.f96622e + ")";
    }

    public r(Boolean r100, Boolean r101, Boolean r102) {
        this.f96618a = null;
        this.f96619b = r100;
        this.f96620c = null;
        this.f96621d = r101;
        this.f96622e = r102;
    }
}
