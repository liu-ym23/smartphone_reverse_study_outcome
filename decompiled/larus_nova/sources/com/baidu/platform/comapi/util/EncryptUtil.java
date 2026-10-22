package com.baidu.platform.comapi.util;

import com.baidu.platform.comjni.JNIBaseApi;

/* JADX INFO: loaded from: classes39.dex */
public final class EncryptUtil extends JNIBaseApi {
    private static native String nativeDecrypt(String r100, String r101);

    private static native String nativeEncrypt(String r100, String r101);

    public EncryptUtil() {
    }
}
