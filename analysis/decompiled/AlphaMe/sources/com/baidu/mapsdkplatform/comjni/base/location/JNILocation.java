package com.baidu.mapsdkplatform.comjni.base.location;

import android.os.Bundle;

/* loaded from: classes.dex */
public class JNILocation {
    public native boolean CoordinateEncryptEx(int i4, float f4, float f5, Bundle bundle, String str);

    public native int Create();

    public native int QueryInterface(int i4);

    public native int Release(int i4);
}
