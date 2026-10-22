package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f79390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f79391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f79392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f79393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f79394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f79395f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L18;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f79390a, r101.f79390a) == true) goto L8;
        return false;
    L8:
        if (this.f79391b == r101.f79391b) goto L10;
        return false;
    L10:
        if (this.f79392c == r101.f79392c) goto L12;
        return false;
    L12:
        if (Float.compare(this.f79393d, r101.f79393d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f79394e, r101.f79394e) == 0) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f79395f, r101.f79395f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        PointF r100 = this.f79390a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((((((r102 * 31) + this.f79391b) * 31) + this.f79392c) * 31) + Float.floatToIntBits(this.f79393d)) * 31) + Float.floatToIntBits(this.f79394e)) * 31;
        Integer r104 = this.f79395f;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "offset:" + this.f79390a + ",dW:" + this.f79391b + ",dH:" + this.f79392c + ",aW:" + this.f79393d + ",aH:" + this.f79394e;
    }

    public n(PointF r100, int r101, int r102, float r103, float r104, Integer r105) {
        Intrinsics.checkNotNullParameter(r100, "mp4Offset");
        this.f79390a = r100;
        this.f79391b = r101;
        this.f79392c = r102;
        this.f79393d = r103;
        this.f79394e = r104;
        this.f79395f = r105;
    }
}
