package com.baidu.platform.comapi.util;

import com.baidu.platform.comjni.JNIBaseApi;

/* JADX INFO: loaded from: classes39.dex */
public final class URLEncodeUtils extends JNIBaseApi {
    private static native String nativeGetUrlParamsSign(String r100);

    private static native String nativeMD5Sign(String r100);

    private static native String nativeOperSign(String r100);

    private static native String nativeUrlEncode(String r100);

    private static native String nativeWebSign(String r100);

    public URLEncodeUtils() {
    }

    public static String getMD5String(String r100) {
        return MD5.getMD5String(r100);
    }

    public static String getUrlParamsSign(String r100) {
        return nativeGetUrlParamsSign(r100);
    }

    public static String urlEncode(String r100) {
        return nativeUrlEncode(r100);
    }

    public static String generateSign(int r100, String r101) {
        if (r100 != 1) goto L7;
        return nativeMD5Sign(r101);
    L7:
        if (r100 != 2) goto L11;
        return nativeWebSign(r101);
    L11:
        if (r100 == 3) goto L13;
        return "";
    L13:
        return nativeOperSign(r101);
    }
}
