package com.google.zxing.datamatrix.encoder;

import com.android.contacts.common.list.DefaultContactListAdapter;

/* JADX INFO: loaded from: classes3.dex */
final class TextEncoder extends C40Encoder {
    @Override // com.google.zxing.datamatrix.encoder.C40Encoder, com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 2;
    }

    TextEncoder() {
    }

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder
    int encodeChar(char r5, StringBuilder r6) {
        if (r5 != ' ') goto L7;
        r6.append(3);
        return 1;
    L7:
        if (r5 < '0') goto L13;
        if (r5 > '9') goto L13;
        r6.append((char) ((r5 - '0') + 4));
        return 1;
    L13:
        if (r5 < 'a') goto L19;
        if (r5 > 'z') goto L19;
        r6.append((char) ((r5 - 'a') + 14));
        return 1;
    L19:
        if (r5 < 0) goto L25;
        if (r5 > 31) goto L25;
        r6.append(0);
        r6.append(r5);
        return 2;
    L25:
        if (r5 < '!') goto L31;
        if (r5 > '/') goto L31;
        r6.append(1);
        r6.append((char) (r5 - '!'));
        return 2;
    L31:
        if (r5 < ':') goto L37;
        if (r5 > '@') goto L37;
        r6.append(1);
        r6.append((char) ((r5 - ':') + 15));
        return 2;
    L37:
        if (r5 < '[') goto L43;
        if (r5 > '_') goto L43;
        r6.append(1);
        r6.append((char) ((r5 - DefaultContactListAdapter.SNIPPET_START_MATCH) + 22));
        return 2;
    L43:
        if (r5 != '`') goto L47;
        r6.append(2);
        r6.append((char) (r5 - '`'));
        return 2;
    L47:
        if (r5 < 'A') goto L53;
        if (r5 > 'Z') goto L53;
        r6.append(2);
        r6.append((char) ((r5 - 'A') + 1));
        return 2;
    L53:
        if (r5 < '{') goto L59;
        if (r5 > 127) goto L59;
        r6.append(2);
        r6.append((char) ((r5 - '{') + 27));
        return 2;
    L59:
        if (r5 < 128) goto L62;
        r6.append("\u0001\u001e");
        return encodeChar((char) (r5 - 128), r6) + 2;
    L62:
        HighLevelEncoder.illegalCharacter(r5);
        return -1;
    }
}
