package com.google.protobuf;

import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes3.dex */
final class TextFormatEscaper {

    public interface ByteSequence {
        byte byteAt(int r10);

        int size();
    }

    private TextFormatEscaper() {
    }

    public static String escapeBytes(ByteSequence r10) {
        StringBuilder r11 = new StringBuilder(r10.size());
        int r12 = 0;
    L4:
        if (r12 >= r10.size()) goto L30;
        byte r13 = r10.byteAt(r12);
        if (r13 != 34) goto L8;
        r11.append("\\\"");
    L28:
        r12 = r12 + 1;
        goto L4
    L8:
        if (r13 != 39) goto L10;
        r11.append("\\'");
        goto L28
    L10:
        if (r13 == 92) goto L25;
        switch(r13) {
            case 7: goto L24;
            case 8: goto L23;
            case 9: goto L22;
            case 10: goto L21;
            case 11: goto L20;
            case 12: goto L19;
            case 13: goto L18;
            default: goto L13;
        };
    L18:
        r11.append("\\r");
        goto L28
    L19:
        r11.append("\\f");
        goto L28
    L20:
        r11.append("\\v");
        goto L28
    L21:
        r11.append("\\n");
        goto L28
    L22:
        r11.append("\\t");
        goto L28
    L23:
        r11.append("\\b");
        goto L28
    L24:
        r11.append("\\a");
        goto L28
    L13:
        if (r13 >= 32) goto L15;
    L17:
        r11.append(TokenParser.ESCAPE);
        r11.append((char) (((r13 >>> 6) & 3) + 48));
        r11.append((char) (((r13 >>> 3) & 7) + 48));
        r11.append((char) ((r13 & 7) + 48));
        goto L28
    L15:
        if (r13 > 126) goto L17;
        r11.append((char) r13);
        goto L28
    L25:
        r11.append("\\\\");
        goto L28
    L30:
        return r11.toString();
    }

    public static String escapeDoubleQuotesAndBackslashes(String r10) {
        return r10.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    public static String escapeText(String r10) {
        return escapeBytes(ByteString.copyFromUtf8(r10));
    }

    public static String escapeBytes(final ByteString r10) {
        return escapeBytes(new AnonymousClass1(r10));
    }

    public static String escapeBytes(final byte[] r10) {
        return escapeBytes(new AnonymousClass2(r10));
    }
}
