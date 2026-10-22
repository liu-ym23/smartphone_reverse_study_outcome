package com.bytedance.android.tools.superkv;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    public static long a(byte[] r100, int r101, int r102) {
        long r103 = 1;
        long r104 = 0;
        int r105 = r101;
    L4:
        if (r105 >= (r101 + r102)) goto L7;
        r103 = (r103 + ((long) r100[r105])) % 65521;
        r104 = (r104 + r103) % 65521;
        r105 = r105 + 1;
        goto L4
    L7:
        return (r104 << 16) + r103;
    }
}
