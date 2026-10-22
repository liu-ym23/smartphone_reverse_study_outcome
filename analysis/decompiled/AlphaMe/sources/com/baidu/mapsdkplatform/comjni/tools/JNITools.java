package com.baidu.mapsdkplatform.comjni.tools;

/* loaded from: classes.dex */
public class JNITools {
    public static native boolean CoordinateEncryptEx(float f4, float f5, String str, Object obj);

    public static native boolean CoordinateEncryptMc(float f4, float f5, Object obj);

    public static native void GetDistanceByMC(Object obj);

    public static native String GetToken();

    public static native boolean TransGeoStr2ComplexPt(Object obj);

    public static native boolean TransGeoStr2Pt(Object obj);

    public static native void TransNodeStr2Pt(Object obj);

    public static native double[] baiduToGcj(double d4, double d5);

    public static native byte[] decryptPNKD(byte[] bArr);

    public static native double[] gcjToBaidu(double d4, double d5);

    public static native String getAESSaltKey(String str);

    public static native String getAESViKey(String str);

    public static native String getProjectionPt(String str);

    public static native int initClass(Object obj, int i4);

    public static native void openLogEnable(boolean z4, int i4);

    public static native double[] wgsToBaidu(double d4, double d5);
}
