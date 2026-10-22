package org.apache.http.impl;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import org.apache.http.config.ConnectionConfig;

/* JADX INFO: loaded from: classes4.dex */
public final class ConnSupport {
    public ConnSupport() {
    }

    public static CharsetDecoder createDecoder(ConnectionConfig r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        Charset r11 = r10.getCharset();
        CodingErrorAction r12 = r10.getMalformedInputAction();
        CodingErrorAction r13 = r10.getUnmappableInputAction();
        if (r11 == null) goto L17;
        CharsetDecoder r14 = r11.newDecoder();
        if (r12 != null) goto L11;
        r12 = CodingErrorAction.REPORT;
    L11:
        CharsetDecoder r15 = r14.onMalformedInput(r12);
        if (r13 != null) goto L16;
        r13 = CodingErrorAction.REPORT;
    L16:
        return r15.onUnmappableCharacter(r13);
    L17:
        return null;
    }

    public static CharsetEncoder createEncoder(ConnectionConfig r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        Charset r11 = r10.getCharset();
        if (r11 == null) goto L17;
        CodingErrorAction r12 = r10.getMalformedInputAction();
        CodingErrorAction r13 = r10.getUnmappableInputAction();
        CharsetEncoder r14 = r11.newEncoder();
        if (r12 != null) goto L11;
        r12 = CodingErrorAction.REPORT;
    L11:
        CharsetEncoder r15 = r14.onMalformedInput(r12);
        if (r13 != null) goto L16;
        r13 = CodingErrorAction.REPORT;
    L16:
        return r15.onUnmappableCharacter(r13);
    L17:
        return null;
    }
}
