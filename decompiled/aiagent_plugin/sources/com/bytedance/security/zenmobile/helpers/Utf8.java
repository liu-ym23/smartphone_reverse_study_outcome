package com.bytedance.security.zenmobile.helpers;

/* JADX INFO: loaded from: classes.dex */
public class Utf8 {
    public static int getByteClass(byte r1) {
        if ((r1 & 128) != 0) goto L7;
        return 1;
    L7:
        if ((r1 & 64) != 0) goto L11;
        return 0;
    L11:
        if ((r1 & 32) != 0) goto L15;
        return 2;
    L15:
        if ((r1 & 16) != 0) goto L19;
        return 3;
    L19:
        if ((r1 & 8) != 0) goto L22;
        return 4;
    L22:
        return -1;
    }

    public Utf8() {
    }
}
