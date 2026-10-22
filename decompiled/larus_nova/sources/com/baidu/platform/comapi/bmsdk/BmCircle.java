package com.baidu.platform.comapi.bmsdk;

import androidx.camera.video.AudioStats;
import com.baidu.mapapi.map.Circle;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class BmCircle extends BmDrawItem {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Circle f32760i;

    private static native boolean nativeAddHoleGeoElement(long r100, long r101);

    private static native boolean nativeClearGeoElements(long r100);

    private static native boolean nativeClearGradientColors(long r100);

    private static native long nativeCreate();

    private static native boolean nativeDelGradientColors(long r100, int r101);

    private static native boolean nativeSetBloomAlpha(long r100, float r101);

    private static native boolean nativeSetBloomBlurTimes(long r100, int r101);

    private static native boolean nativeSetBloomGradientASpeed(long r100, float r101);

    private static native boolean nativeSetBloomWidth(long r100, float r101);

    private static native boolean nativeSetCenter(long r100, double r101, double r102, double r103);

    private static native boolean nativeSetGradientColorWeight(long r100, float r101);

    private static native boolean nativeSetGradientColors(long r100, int r101, int[] r102, int r103);

    private static native boolean nativeSetGradientRadiusWeight(long r100, float r101);

    private static native boolean nativeSetIsGradientCircle(long r100, boolean r101);

    private static native boolean nativeSetLineBloomDirection(long r100, int r101);

    private static native boolean nativeSetLineBloomMode(long r100, int r101);

    private static native boolean nativeSetLineStyle(long r100, long r101);

    private static native boolean nativeSetPixelRadius(long r100, int r101);

    private static native boolean nativeSetRadius(long r100, double r101);

    private static native boolean nativeSetSurfaceStyle(long r100, long r101);

    private static native boolean nativeSetTrackBy(long r100, int r101);

    public boolean c() {
        return nativeClearGeoElements(this.nativeInstance);
    }

    public boolean d() {
        return nativeClearGradientColors(this.nativeInstance);
    }

    public BmCircle() {
        super(11, nativeCreate());
    }

    public Circle e() {
        return this.f32760i;
    }

    public void a(BmLineStyle r100) {
        if (r100 == null) goto L4;
        nativeSetLineStyle(this.nativeInstance, r100.nativeInstance);
        return;
    L4:
        nativeSetLineStyle(this.nativeInstance, 0);
    }

    public boolean b(float r100) {
        return nativeSetBloomAlpha(this.nativeInstance, r100);
    }

    public boolean c(float r100) {
        return nativeSetBloomGradientASpeed(this.nativeInstance, r100);
    }

    public boolean d(float r100) {
        return nativeSetBloomWidth(this.nativeInstance, r100);
    }

    public boolean e(float r100) {
        return nativeSetGradientColorWeight(this.nativeInstance, r100);
    }

    public boolean f(float r100) {
        return nativeSetGradientRadiusWeight(this.nativeInstance, r100);
    }

    public boolean g(int r100) {
        return nativeSetLineBloomMode(this.nativeInstance, r100);
    }

    public void a(BmSurfaceStyle r100) {
        if (r100 == null) goto L4;
        nativeSetSurfaceStyle(this.nativeInstance, r100.nativeInstance);
        return;
    L4:
        nativeSetSurfaceStyle(this.nativeInstance, 0);
    }

    public boolean c(boolean r100) {
        return nativeSetIsGradientCircle(this.nativeInstance, r100);
    }

    public boolean e(int r100) {
        return nativeSetBloomBlurTimes(this.nativeInstance, r100);
    }

    public boolean f(int r100) {
        return nativeSetLineBloomDirection(this.nativeInstance, r100);
    }

    public boolean a(b r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return nativeSetCenter(this.nativeInstance, r100.f32817a, r100.f32818b, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public boolean a(BmGeoElement r100) {
        return nativeAddHoleGeoElement(this.nativeInstance, r100.getNativeInstance());
    }

    public boolean a(double r100) {
        return nativeSetRadius(this.nativeInstance, r100);
    }

    public void a(Circle r100) {
        this.f32760i = r100;
    }

    public boolean a(int r100, List<Integer> r101) {
        int r102 = 0;
        if (r101 != null) goto L5;
    L10:
        int[] r103 = null;
    L12:
        return nativeSetGradientColors(this.nativeInstance, r100, r103, r102);
    L5:
        if (r101.size() <= 0) goto L10;
        r103 = new int[r101.size()];
        Iterator<Integer> r104 = r101.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        r103[r102] = com.baidu.platform.comapi.bmsdk.style.a.a(r104.next().intValue());
        r102 = r102 + 1;
        goto L8
    }
}
