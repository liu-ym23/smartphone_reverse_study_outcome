package com.bytedance.android.livesdk.interactivity.like.utils;

import android.animation.TimeInterpolator;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClosedFloatingPointRange<Float> f137718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f137719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f137720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f137721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f137722e;

    public final float a(float r100, TimeInterpolator r101) {
        float r102 = this.f137721d;
        float r103 = (r100 - r102) / (this.f137722e - r102);
        if (r101 == null) goto L5;
        r101.getInterpolation(r103);
    L5:
        float r104 = this.f137719b;
        return r104 + ((this.f137720c - r104) * r103);
    }

    public a(float r100, float r101, float r102, float r103) {
        this.f137719b = r100;
        this.f137720c = r101;
        this.f137721d = r102;
        this.f137722e = r103;
        this.f137718a = RangesKt.rangeTo(r102, r103);
    }
}
