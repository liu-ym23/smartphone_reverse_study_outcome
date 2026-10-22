package com.baidu.platform.comapi.bmsdk;

import androidx.camera.video.AudioStats;
import com.baidu.mapapi.map.GroundOverlay;
import com.baidu.platform.comapi.bmsdk.style.BmDrawableResource;

/* JADX INFO: loaded from: classes39.dex */
public class BmGround extends BmDrawItem {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private BmDrawableResource f32776i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private GroundOverlay f32777j;

    private static native long nativeCreate();

    private static native boolean nativeSetAnchorX(long r100, float r101);

    private static native boolean nativeSetAnchorY(long r100, float r101);

    private static native boolean nativeSetDrawableResource(long r100, long r101);

    private static native boolean nativeSetHeight(long r100, double r101);

    private static native boolean nativeSetPosition(long r100, double r101, double r102, double r103);

    private static native boolean nativeSetWidth(long r100, double r101);

    public BmGround() {
        super(22, nativeCreate());
    }

    @Override // com.baidu.platform.comapi.bmsdk.BmDrawItem, com.baidu.platform.comapi.bmsdk.BmObject, java.lang.AutoCloseable
    public void close() throws Exception {
        super.close();
        BmDrawableResource r100 = this.f32776i;     // Catch: Exception -> L7
        if (r100 == null) goto L10;
        r100.close();     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    public GroundOverlay c() {
        return this.f32777j;
    }

    public boolean a(BmDrawableResource r100) {
        BmDrawableResource r101 = this.f32776i;     // Catch: Exception -> L6
        if (r101 == null) goto L7;
        r101.close();     // Catch: Exception -> L6
    L7:
        this.f32776i = r100;
        if (r100 == null) goto L12;
        return nativeSetDrawableResource(this.nativeInstance, r100.getNativeInstance());
    L12:
        return nativeSetDrawableResource(this.nativeInstance, 0);
    }

    public boolean b(double r100) {
        return nativeSetWidth(this.nativeInstance, r100);
    }

    public boolean c(float r100) {
        return nativeSetAnchorY(this.nativeInstance, r100);
    }

    public boolean a(b r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return nativeSetPosition(this.nativeInstance, r100.f32817a, r100.f32818b, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public boolean b(float r100) {
        return nativeSetAnchorX(this.nativeInstance, r100);
    }

    public boolean a(double r100) {
        return nativeSetHeight(this.nativeInstance, r100);
    }

    public void a(GroundOverlay r100) {
        this.f32777j = r100;
    }
}
