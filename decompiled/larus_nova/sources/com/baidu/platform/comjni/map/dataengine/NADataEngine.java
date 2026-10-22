package com.baidu.platform.comjni.map.dataengine;

import android.os.Bundle;
import com.baidu.platform.comjni.NativeComponent;

/* JADX INFO: loaded from: classes39.dex */
public class NADataEngine extends NativeComponent {
    private native void nativeCancelThumbImageRequest(long r100);

    private native long nativeCreate();

    private native String nativeGetCurrentStreetId(long r100);

    private native String nativeGetCurrentStreetInfo(long r100, Bundle r101);

    private native boolean nativeGetHotMapCityInfo(long r100, Bundle r101);

    private native boolean nativeGetStreetCityInfo(long r100, Bundle r101);

    private native boolean nativeQueryThumbImage(long r100, String r101);

    private native int nativeRelease(long r100);

    private native void nativeSetStreetPOIUID(long r100, String r101);

    private native boolean nativeStreetSwitchByUID(long r100, String r101, String r102);

    private native boolean nativeStreetSwitchToID(long r100, String r101, int r102);

    private native boolean nativeStreetSwitchToIDFromReGeo(long r100, String r101, String r102, long r103, long r104);

    private native boolean nativeStreetSwitchToIID(long r100, String r101, String r102, boolean r103);

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        if (this.mNativePointer == 0) goto L6;
        int r100 = nativeRelease(this.mNativePointer);
        this.mNativePointer = 0;
        return r100;
    L6:
        return 0;
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    public NADataEngine() {
    }
}
