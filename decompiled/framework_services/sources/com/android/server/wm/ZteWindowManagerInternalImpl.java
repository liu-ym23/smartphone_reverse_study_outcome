package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
public class ZteWindowManagerInternalImpl implements IZteWindowManagerInternal {
    private static final String TAG = "ZteWindowManagerInternal";
    private static final String ZTE_FINGERPRINT_SENSOR_ICON_WINDOW_TAG = "SingleMode_Fingerprint_SensorView";
    private final RootWindowContainer mRoot;

    ZteWindowManagerInternalImpl(RootWindowContainer root) {
        this.mRoot = root;
    }

    @Override // com.android.server.wm.IZteWindowManagerInternal
    public boolean isFingerprintSensorIconShowing() {
        return true;
    }
}
