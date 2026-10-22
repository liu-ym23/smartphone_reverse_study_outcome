package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Track;

/* loaded from: classes.dex */
public class BmTrack extends BmDrawItem {

    /* renamed from: i, reason: collision with root package name */
    private Track f8659i;

    public BmTrack() {
        super(25, nativeCreate());
    }

    private static native boolean nativeAddGeoElement(long j4, long j5);

    private static native boolean nativeClearGeoElements(long j4);

    private static native long nativeCreate();

    private static native boolean nativeSetTrackMove(long j4, boolean z4);

    public void a(Track track) {
        this.f8659i = track;
    }

    public boolean c(boolean z4) {
        return nativeSetTrackMove(this.nativeInstance, z4);
    }

    public boolean a(BmGeoElement bmGeoElement) {
        return nativeAddGeoElement(this.nativeInstance, bmGeoElement.getNativeInstance());
    }
}
