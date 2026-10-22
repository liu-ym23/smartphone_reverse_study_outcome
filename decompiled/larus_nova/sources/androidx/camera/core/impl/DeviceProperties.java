package androidx.camera.core.impl;

import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DeviceProperties {
    public DeviceProperties() {
    }

    public abstract String manufacturer();

    public abstract String model();

    public abstract int sdkVersion();

    public static DeviceProperties create() {
        return create(Build.MANUFACTURER, Build.MODEL, Build.VERSION.SDK_INT);
    }

    public static DeviceProperties create(String r100, String r101, int r102) {
        return new AutoValue_DeviceProperties(r100, r101, r102);
    }
}
