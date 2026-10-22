package com.bytedance.android.livesdk.ktvapi.model.mv;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f142329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MusicPanel f142330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f142331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f142332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f142333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f142334f;

    public final int hashCode() {
        long r100 = this.f142333e;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f142334f;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public final String toString() {
        return "MvSongInfo(mId=" + this.f142333e + ", singerId=" + this.f142334f + ")";
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof k) == true) goto L5;
        return false;
    L5:
        k r101 = (k) r100;
        if (r101.f142333e == this.f142333e) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f142334f, r101.f142334f) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public k(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "singerId");
        this.f142333e = r100;
        this.f142334f = r101;
    }
}
