package com.baidu.platform.comjni.map.dataengine;

import android.os.Bundle;
import com.baidu.platform.comjni.NativeComponent;

/* loaded from: classes.dex */
public class NADataEngine extends NativeComponent {
    private native void nativeCancelThumbImageRequest(long j4);

    private native long nativeCreate();

    private native String nativeGetCurrentStreetId(long j4);

    private native String nativeGetCurrentStreetInfo(long j4, Bundle bundle);

    private native boolean nativeGetHotMapCityInfo(long j4, Bundle bundle);

    private native boolean nativeGetStreetCityInfo(long j4, Bundle bundle);

    private native boolean nativeQueryThumbImage(long j4, String str);

    private native int nativeRelease(long j4);

    private native void nativeSetStreetPOIUID(long j4, String str);

    private native boolean nativeStreetSwitchByUID(long j4, String str, String str2);

    private native boolean nativeStreetSwitchToID(long j4, String str, int i4);

    private native boolean nativeStreetSwitchToIDFromReGeo(long j4, String str, String str2, long j5, long j6);

    private native boolean nativeStreetSwitchToIID(long j4, String str, String str2, boolean z4);

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        if (this.mNativePointer == 0) {
            return 0;
        }
        int iNativeRelease = nativeRelease(this.mNativePointer);
        this.mNativePointer = 0L;
        return iNativeRelease;
    }
}
