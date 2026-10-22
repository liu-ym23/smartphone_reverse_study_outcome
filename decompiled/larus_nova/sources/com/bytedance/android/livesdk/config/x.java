package com.bytedance.android.livesdk.config;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f121565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f121566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f121567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f121568d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x) == false) goto L14;
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f121565a, r101.f121565a) == true) goto L8;
        return false;
    L8:
        if (this.f121566b == r101.f121566b) goto L10;
        return false;
    L10:
        if (this.f121567c == r101.f121567c) goto L12;
        return false;
    L12:
        if (this.f121568d == r101.f121568d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f121565a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = ((r101 * 31) + this.f121566b) * 31;
        long r103 = this.f121567c;
        return ((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f121568d;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorBwProbeResolutionResult(lastProbeResolution=" + this.f121565a + ", probeTimes=" + this.f121566b + ", probeTimestamp=" + this.f121567c + ", expireTime=" + this.f121568d + ")";
    }

    public x() {
        Intrinsics.checkNotNullParameter("", "lastProbeResolution");
        this.f121565a = "";
        this.f121566b = 0;
        this.f121567c = 0;
        this.f121568d = 0;
    }
}
