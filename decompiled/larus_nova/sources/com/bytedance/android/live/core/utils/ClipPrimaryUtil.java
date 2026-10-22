package com.bytedance.android.live.core.utils;

import android.content.ClipData;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;

/* JADX INFO: loaded from: classes45.dex */
public class ClipPrimaryUtil {
    private static final Cert CERT = null;
    private static CharSequence perString;

    static {
        CERT = TokenCert.with("bpea-clipprimaryutil_clipboard");
    }

    private ClipPrimaryUtil() {
    }

    public static void setPrimaryText(CharSequence r100, Cert r101) throws Exception {
        perString = r100;
        g80.d.c(ClipData.newPlainText(r100, r100), r101);
    }
}
