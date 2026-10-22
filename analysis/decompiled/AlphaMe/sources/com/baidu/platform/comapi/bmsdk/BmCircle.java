package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Circle;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class BmCircle extends BmDrawItem {

    /* renamed from: i, reason: collision with root package name */
    private Circle f8622i;

    public BmCircle() {
        super(11, nativeCreate());
    }

    private static native boolean nativeAddHoleGeoElement(long j4, long j5);

    private static native boolean nativeClearGeoElements(long j4);

    private static native boolean nativeClearGradientColors(long j4);

    private static native long nativeCreate();

    private static native boolean nativeDelGradientColors(long j4, int i4);

    private static native boolean nativeSetBloomAlpha(long j4, float f4);

    private static native boolean nativeSetBloomBlurTimes(long j4, int i4);

    private static native boolean nativeSetBloomGradientASpeed(long j4, float f4);

    private static native boolean nativeSetBloomWidth(long j4, float f4);

    private static native boolean nativeSetCenter(long j4, double d4, double d5, double d6);

    private static native boolean nativeSetGradientColorWeight(long j4, float f4);

    private static native boolean nativeSetGradientColors(long j4, int i4, int[] iArr, int i5);

    private static native boolean nativeSetGradientRadiusWeight(long j4, float f4);

    private static native boolean nativeSetIsGradientCircle(long j4, boolean z4);

    private static native boolean nativeSetLineBloomDirection(long j4, int i4);

    private static native boolean nativeSetLineBloomMode(long j4, int i4);

    private static native boolean nativeSetLineStyle(long j4, long j5);

    private static native boolean nativeSetPixelRadius(long j4, int i4);

    private static native boolean nativeSetRadius(long j4, double d4);

    private static native boolean nativeSetSurfaceStyle(long j4, long j5);

    private static native boolean nativeSetTrackBy(long j4, int i4);

    public void a(Circle circle) {
        this.f8622i = circle;
    }

    public boolean b(float f4) {
        return nativeSetBloomAlpha(this.nativeInstance, f4);
    }

    public boolean c(boolean z4) {
        return nativeSetIsGradientCircle(this.nativeInstance, z4);
    }

    public boolean d() {
        return nativeClearGradientColors(this.nativeInstance);
    }

    public Circle e() {
        return this.f8622i;
    }

    public boolean f(float f4) {
        return nativeSetGradientRadiusWeight(this.nativeInstance, f4);
    }

    public boolean g(int i4) {
        return nativeSetLineBloomMode(this.nativeInstance, i4);
    }

    public boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        return nativeSetCenter(this.nativeInstance, bVar.f8679a, bVar.f8680b, 0.0d);
    }

    public boolean c() {
        return nativeClearGeoElements(this.nativeInstance);
    }

    public boolean d(float f4) {
        return nativeSetBloomWidth(this.nativeInstance, f4);
    }

    public boolean e(float f4) {
        return nativeSetGradientColorWeight(this.nativeInstance, f4);
    }

    public boolean f(int i4) {
        return nativeSetLineBloomDirection(this.nativeInstance, i4);
    }

    public boolean a(double d4) {
        return nativeSetRadius(this.nativeInstance, d4);
    }

    public boolean c(float f4) {
        return nativeSetBloomGradientASpeed(this.nativeInstance, f4);
    }

    public boolean e(int i4) {
        return nativeSetBloomBlurTimes(this.nativeInstance, i4);
    }

    public void a(BmLineStyle bmLineStyle) {
        if (bmLineStyle != null) {
            nativeSetLineStyle(this.nativeInstance, bmLineStyle.nativeInstance);
        } else {
            nativeSetLineStyle(this.nativeInstance, 0L);
        }
    }

    public void a(BmSurfaceStyle bmSurfaceStyle) {
        if (bmSurfaceStyle != null) {
            nativeSetSurfaceStyle(this.nativeInstance, bmSurfaceStyle.nativeInstance);
        } else {
            nativeSetSurfaceStyle(this.nativeInstance, 0L);
        }
    }

    public boolean a(int i4, List<Integer> list) {
        int[] iArr;
        int i5 = 0;
        if (list == null || list.size() <= 0) {
            iArr = null;
        } else {
            iArr = new int[list.size()];
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                iArr[i5] = com.baidu.platform.comapi.bmsdk.style.a.a(it.next().intValue());
                i5++;
            }
        }
        return nativeSetGradientColors(this.nativeInstance, i4, iArr, i5);
    }

    public boolean a(BmGeoElement bmGeoElement) {
        return nativeAddHoleGeoElement(this.nativeInstance, bmGeoElement.getNativeInstance());
    }
}
