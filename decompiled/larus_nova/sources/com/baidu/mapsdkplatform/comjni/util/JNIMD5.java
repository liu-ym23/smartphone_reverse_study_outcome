package com.baidu.mapsdkplatform.comjni.util;

/* JADX INFO: loaded from: classes39.dex */
public class JNIMD5 {
    public static native String decodeCoordHash(String r100);

    public static native String encodeCoordHash(double r100, double r101);

    public static native String encodeUrlParamsValue(String r100);

    public static native String getSignMD5String(String r100);

    public static native String getSignMD5StringUTF8(String r100);

    public static native String getUrlNeedInfo();

    public JNIMD5() {
    }
}
