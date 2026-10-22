package com.bytedance.android.live.revlink.impl.control.launchcontext;

import com.bytedance.android.livesdk.link.model.a6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements sc0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f92435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.audience.c f92436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f92437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a6 f92438d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (this.f92435a == r101.f92435a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f92436b, r101.f92436b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f92437c, r101.f92437c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f92438d, r101.f92438d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f92435a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        com.bytedance.android.live.revlink.impl.audience.c r102 = this.f92436b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f92437c;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        a6 r109 = this.f92438d;
        if (r109 == null) goto L14;
        r103 = r109.hashCode();
    L14:
        return r108 + r103;
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "MultiLinkAudienceLaunchContext(channelID=" + this.f92435a + ", source=" + this.f92436b + ", rawSei=" + this.f92437c + ", enterContent=" + this.f92438d + ")";
    }

    public b(long r100, com.bytedance.android.live.revlink.impl.audience.c r101, String r102, a6 r103) {
        Intrinsics.checkNotNullParameter(r101, "source");
        this.f92435a = r100;
        this.f92436b = r101;
        this.f92437c = r102;
        this.f92438d = r103;
    }
}
