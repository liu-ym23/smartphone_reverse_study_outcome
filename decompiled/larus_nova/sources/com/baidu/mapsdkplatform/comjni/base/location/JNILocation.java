package com.baidu.mapsdkplatform.comjni.base.location;

import android.os.Bundle;

/* JADX INFO: loaded from: classes39.dex */
public class JNILocation {
    public native boolean CoordinateEncryptEx(int r100, float r101, float r102, Bundle r103, String r104);

    public native int Create();

    public native int QueryInterface(int r100);

    public native int Release(int r100);

    public JNILocation() {
    }
}
