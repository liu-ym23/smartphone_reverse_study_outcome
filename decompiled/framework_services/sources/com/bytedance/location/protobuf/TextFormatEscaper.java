package com.bytedance.location.protobuf;

/* JADX INFO: loaded from: classes3.dex */
final class TextFormatEscaper {

    private interface ByteSequence {
        byte byteAt(int r1);

        int size();
    }

    private TextFormatEscaper() {
    }

    static String escapeBytes(ByteSequence input) {
        StringBuilder builder = new StringBuilder(input.size());
        int i = 0;
    L4:
        if (i >= input.size()) goto L25;
        byte b = input.byteAt(i);
        switch(b) {
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            case 11: goto L18;
            case 12: goto L17;
            case 13: goto L16;
            case 34: goto L15;
            case 39: goto L14;
            case 92: goto L13;
            default: goto L8;
        };
    L13:
        builder.append("\\\\");
    L23:
        i = i + 1;
        goto L4
    L14:
        builder.append("\\'");
        goto L23
    L15:
        builder.append("\\\"");
        goto L23
    L16:
        builder.append("\\r");
        goto L23
    L17:
        builder.append("\\f");
        goto L23
    L18:
        builder.append("\\v");
        goto L23
    L19:
        builder.append("\\n");
        goto L23
    L20:
        builder.append("\\t");
        goto L23
    L21:
        builder.append("\\b");
        goto L23
    L22:
        builder.append("\\a");
        goto L23
    L8:
        if (b >= 32) goto L10;
    L12:
        builder.append('\\');
        builder.append((char) (((b >>> 6) & 3) + 48));
        builder.append((char) (((b >>> 3) & 7) + 48));
        builder.append((char) ((b & 7) + 48));
        goto L23
    L10:
        if (b > 126) goto L12;
        builder.append((char) b);
        goto L23
    L25:
        return builder.toString();
    }

    static String escapeBytes(final ByteString input) {
        return escapeBytes(new AnonymousClass1(input));
    }

    static String escapeBytes(final byte[] input) {
        return escapeBytes(new AnonymousClass2(input));
    }

    static String escapeText(String input) {
        return escapeBytes(ByteString.copyFromUtf8(input));
    }

    static String escapeDoubleQuotesAndBackslashes(String input) {
        return input.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
