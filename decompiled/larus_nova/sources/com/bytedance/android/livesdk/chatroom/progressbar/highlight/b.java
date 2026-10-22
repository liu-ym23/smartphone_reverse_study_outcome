package com.bytedance.android.livesdk.chatroom.progressbar.highlight;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f107759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f107760b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f107759a, r101.f107759a) == true) goto L8;
        return false;
    L8:
        if (this.f107760b == r101.f107760b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f107759a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f107760b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "HighlightTipsParams(tipsContent=" + this.f107759a + ", tipsDuration=" + this.f107760b + ")";
    }

    public b() {
        this(null, KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL);
    }

    public b(String r100, long r101) {
        this.f107759a = r100;
        this.f107760b = r101;
    }
}
