package com.baidu.platform.comjni.util;

import com.baidu.platform.comjni.JNIBaseApi;

/* JADX INFO: loaded from: classes39.dex */
public class JNIMD5 extends JNIBaseApi {
    public static native String EncodeUrlParamsValue(String r100);

    public static native String GetSignMD5String(String r100);

    public static native String GetWebSignMD5String(String r100);

    public static native String SignOpra(String r100);

    public JNIMD5() {
    }
}
