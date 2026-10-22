package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Track;

/* JADX INFO: loaded from: classes39.dex */
public class BmTrack extends BmDrawItem {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Track f32797i;

    private static native boolean nativeAddGeoElement(long r100, long r101);

    private static native boolean nativeClearGeoElements(long r100);

    private static native long nativeCreate();

    private static native boolean nativeSetTrackMove(long r100, boolean r101);

    public BmTrack() {
        super(25, nativeCreate());
    }

    public boolean a(BmGeoElement r100) {
        return nativeAddGeoElement(this.nativeInstance, r100.getNativeInstance());
    }

    public boolean c(boolean r100) {
        return nativeSetTrackMove(this.nativeInstance, r100);
    }

    public void a(Track r100) {
        this.f32797i = r100;
    }
}
