package com.baidu.platform.comapi.bmsdk;

import androidx.camera.video.AudioStats;
import com.baidu.mapapi.map.Arc;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;

/* JADX INFO: loaded from: classes39.dex */
public class BmArc extends BmDrawItem {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Arc f32743i;

    private static native long nativeCreate();

    private static native boolean nativeSetCenter(long r100, double r101, double r102, double r103);

    private static native boolean nativeSetClockwise(long r100, boolean r101);

    private static native boolean nativeSetEndRadian(long r100, double r101);

    private static native boolean nativeSetLineStyle(long r100, long r101);

    private static native boolean nativeSetPixelRadius(long r100, int r101);

    private static native boolean nativeSetRadius(long r100, double r101);

    private static native boolean nativeSetStartRadian(long r100, double r101);

    private static native boolean nativeSetTrackBy(long r100, int r101);

    public BmArc() {
        super(12, nativeCreate());
    }

    public Arc c() {
        return this.f32743i;
    }

    public void a(BmLineStyle r100) {
        if (r100 == null) goto L4;
        nativeSetLineStyle(this.nativeInstance, r100.nativeInstance);
        return;
    L4:
        nativeSetLineStyle(this.nativeInstance, 0);
    }

    public boolean b(double r100) {
        return nativeSetRadius(this.nativeInstance, r100);
    }

    public boolean c(double r100) {
        return nativeSetStartRadian(this.nativeInstance, r100);
    }

    public boolean a(b r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return nativeSetCenter(this.nativeInstance, r100.f32817a, r100.f32818b, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public boolean c(boolean r100) {
        return nativeSetClockwise(this.nativeInstance, r100);
    }

    public boolean a(double r100) {
        return nativeSetEndRadian(this.nativeInstance, r100);
    }

    public void a(Arc r100) {
        this.f32743i = r100;
    }
}
