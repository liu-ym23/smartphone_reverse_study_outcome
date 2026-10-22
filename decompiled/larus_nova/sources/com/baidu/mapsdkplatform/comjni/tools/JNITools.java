package com.baidu.mapsdkplatform.comjni.tools;

/* JADX INFO: loaded from: classes39.dex */
public class JNITools {
    public static native boolean CoordinateEncryptEx(float r100, float r101, String r102, Object r103);

    public static native boolean CoordinateEncryptMc(double r100, double r101, Object r102);

    public static native void GetDistanceByMC(Object r100);

    public static native String GetToken();

    public static native boolean TransGeoStr2ComplexPt(Object r100);

    public static native boolean TransGeoStr2Pt(Object r100);

    public static native void TransNodeStr2Pt(Object r100);

    public static native double[] baiduToGcj(double r100, double r101);

    public static native byte[] decryptPNKD(byte[] r100);

    public static native double[] gcjToBaidu(double r100, double r101);

    public static native String getAESSaltKey(String r100);

    public static native String getAESViKey(String r100);

    public static native String getProjectionPt(String r100);

    public static native int initClass(Object r100, int r101);

    public static native void openLogEnable(boolean r100, int r101);

    public static native double[] wgsToBaidu(double r100, double r101);

    public JNITools() {
    }
}
