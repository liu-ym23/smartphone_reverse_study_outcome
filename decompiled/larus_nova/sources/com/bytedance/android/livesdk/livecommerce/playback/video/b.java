package com.bytedance.android.livesdk.livecommerce.playback.video;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements com.bytedance.android.ec.core.arch.state.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f150006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f150007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f150008c;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f150006a, r101.f150006a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f150007b, r101.f150007b) == true) goto L10;
        return false;
    L10:
        if (Float.compare(this.f150008c, r101.f150008c) == 0) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f150006a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f150007b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + Float.floatToIntBits(this.f150008c);
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ExplainPlaybackVideoState(currentTime=" + this.f150006a + ", maxTime=" + this.f150007b + ", speedFloat=" + this.f150008c + ")";
    }

    public /* synthetic */ b(int r100) {
        this(null, null, 1.0f);
    }

    public b(Integer r100, Integer r101, float r102) {
        this.f150006a = r100;
        this.f150007b = r101;
        this.f150008c = r102;
    }
}
