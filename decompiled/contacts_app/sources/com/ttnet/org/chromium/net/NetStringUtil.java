package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.text.Normalizer;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("net::android")
public class NetStringUtil {
    public NetStringUtil() {
    }

    private static String convertToUnicode(ByteBuffer r0, String r1) {
        return Charset.forName(r1).newDecoder().decode(r0).toString();
    L4:
        return null;
    }

    private static String convertToUnicodeAndNormalize(ByteBuffer r0, String r1) {
        String r2 = convertToUnicode(r0, r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return Normalizer.normalize(r2, Normalizer.Form.NFC);
    }

    private static String convertToUnicodeWithSubstitutions(ByteBuffer r1, String r2) {
        CharsetDecoder r3 = Charset.forName(r2).newDecoder();     // Catch: Exception -> L4
        r3.onMalformedInput(CodingErrorAction.REPLACE);     // Catch: Exception -> L4
        r3.onUnmappableCharacter(CodingErrorAction.REPLACE);     // Catch: Exception -> L4
        r3.replaceWith("�");     // Catch: Exception -> L4
        return r3.decode(r1).toString();
    L4:
        return null;
    }

    private static String toUpperCase(String r1) {
        return r1.toUpperCase(Locale.getDefault());
    L4:
        return null;
    }
}
