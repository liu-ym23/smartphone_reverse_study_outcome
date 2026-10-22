package com.bytedance.android.live.revlink.impl.control;

import com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting;
import com.bytedance.android.livesdk.link.model.a9;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f92456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f92457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f92458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f92459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a9 f92460e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u) == false) goto L16;
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f92456a, r101.f92456a) == true) goto L8;
        return false;
    L8:
        if (this.f92457b == r101.f92457b) goto L10;
        return false;
    L10:
        if (this.f92458c == r101.f92458c) goto L12;
        return false;
    L12:
        if (this.f92459d == r101.f92459d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f92460e, r101.f92460e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f92456a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f92457b;
        int r104 = ((((((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f92458c) * 31) + this.f92459d) * 31;
        a9 r105 = this.f92460e;
        if (r105 == null) goto L10;
        r101 = r105.hashCode();
    L10:
        return r104 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("PKInfo{guestUserID=");
        r100.append(this.f92456a);
        r100.append(", channelId=");
        r100.append(this.f92457b);
        r100.append(", dimension=");
        r100.append(this.f92458c);
        r100.append(", layout=");
        r100.append(this.f92459d);
        r100.append(", battleSetting=");
        ILinkMicBattleSetting r101 = this.f92460e.getBattleSetting();
        if (r101 == null) goto L5;
        String r102 = ef2.a.c(r101);
    L6:
        r100.append(r102);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public u(String r100, long r101, int r102, int r103, a9 r104) {
        Intrinsics.checkNotNullParameter(r104, "roomLinkInfo");
        this.f92456a = r100;
        this.f92457b = r101;
        this.f92458c = r102;
        this.f92459d = r103;
        this.f92460e = r104;
    }
}
