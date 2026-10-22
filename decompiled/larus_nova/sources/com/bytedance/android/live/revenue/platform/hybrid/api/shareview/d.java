package com.bytedance.android.live.revenue.platform.hybrid.api.shareview;

import android.net.Uri;
import androidx.camera.video.AudioStats;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f91397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f91398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f91399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f91400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Pair<Integer, Integer> f91401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f91402f;

    public d() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L18;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f91397a, r101.f91397a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f91398b, r101.f91398b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f91399c, r101.f91399c) == true) goto L12;
        return false;
    L12:
        if (this.f91400d == r101.f91400d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f91401e, r101.f91401e) == true) goto L16;
        return false;
    L16:
        if (Double.compare(this.f91402f, r101.f91402f) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public final int hashCode() {
        Uri r100 = this.f91397a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.f91398b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        f r107 = this.f91399c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f91400d;
        ?? r111 = r110;
        if (r110 == false) goto L17;
        r111 = 1;
    L17:
        int r112 = (r109 + r111) * 31;
        Pair<Integer, Integer> r113 = this.f91401e;
        if (r113 == null) goto L20;
        r101 = r113.hashCode();
    L20:
        int r114 = (r112 + r101) * 31;
        long r115 = Double.doubleToLongBits(this.f91402f);
        return r114 + ((int) (r115 ^ (r115 >>> 32)));
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
        return "LoadConfig(url=" + this.f91397a + ", initData=" + this.f91398b + ", lifecycle=" + this.f91399c + ", allowFallback=" + this.f91400d + ", initSize=" + this.f91401e + ", startTime=" + this.f91402f + ")";
    }

    public d(Uri r100, Map r101, f r102, Pair r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 16) == 0) goto L11;
        r103 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f91397a = r100;
        this.f91398b = r101;
        this.f91399c = r102;
        this.f91400d = false;
        this.f91401e = r103;
        this.f91402f = AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
