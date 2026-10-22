package com.ttnet.org.chromium.url;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.net.IDN;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("url::android")
public class IDNStringUtil {
    @CalledByNative
    private static String idnToASCII(String r10) {
        return IDN.toASCII(r10, 2);
    L5:
        return null;
    }
}
