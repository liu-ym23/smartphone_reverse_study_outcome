package com.bytedance.android.livesdk.focus;

import android.animation.TimeInterpolator;
import android.graphics.PointF;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements TimeInterpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f125316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f125317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f125318c;

    public static double a(double r110, double r111, double r112) {
        double r100 = ((double) 1) - r110;
        double r101 = r110 * r110;
        double r102 = r100 * r100;
        double r113 = 3;
        return ((((r102 * r100) * AudioStats.AUDIO_AMPLITUDE_NONE) + (((r102 * r113) * r110) * r111)) + (((r113 * r100) * r101) * r112)) + ((r101 * r110) * 1.0d);
    }

    public a() {
        this.f125317b = new PointF(0.75f, 0.0f);
        this.f125318c = new PointF(0.65f, 1.0f);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r110) {
        double r100 = r110;
        if (r100 <= 0.2d) goto L5;
        float r101 = 1.0f;
    L6:
        int r102 = this.f125316a;
        float r103 = r101;
    L8:
        if (r102 >= 4096) goto L13;
        r103 = (r102 * 1.0f) / 4096;
        if (a(r103, this.f125317b.x, this.f125318c.x) >= r101) goto L11;
        r102 = r102 + 1;
        goto L8
    L11:
        this.f125316a = r102;
    L13:
        double r104 = a(r103, this.f125317b.y, this.f125318c.y);
        if (r104 <= 0.999d) goto L17;
        this.f125316a = 0;
        r104 = 1.0d;
    L17:
        return (float) r104;
    L5:
        r101 = (float) (r100 / 0.2d);
        goto L6
    }
}
