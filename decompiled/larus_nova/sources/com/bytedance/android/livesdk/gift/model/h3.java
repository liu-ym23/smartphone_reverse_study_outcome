package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.message.a5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f126384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a5 f126385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f126386c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h3) == false) goto L12;
        h3 r101 = (h3) r100;
        if (this.f126384a == r101.f126384a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f126385b, r101.f126385b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f126386c, r101.f126386c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f126384a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        a5 r102 = this.f126385b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f126386c;
        if (r106 == null) goto L10;
        r103 = r106.hashCode();
    L10:
        return r105 + r103;
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "SendGiftInfo(consumeDiamonds=" + this.f126384a + ", displayText=" + this.f126385b + ", logId=" + this.f126386c + ")";
    }

    public h3(long r100, a5 r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "displayText");
        this.f126384a = r100;
        this.f126385b = r101;
        this.f126386c = r102;
    }
}
