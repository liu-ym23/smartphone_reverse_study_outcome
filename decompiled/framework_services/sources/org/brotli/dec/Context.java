package org.brotli.dec;

import com.android.server.usb.descriptors.UsbTerminalTypes;

/* JADX INFO: loaded from: classes3.dex */
final class Context {
    static final int[] LOOKUP = null;
    private static final String UTF_MAP = "         !!  !                  \"#$##%#$&'##(#)#++++++++++((&*'##,---,---,-----,-----,-----&#'###.///.///./////./////./////&#'# ";
    private static final String UTF_RLE = "A/*  ':  & : $  \u0081 @";

    Context() {
    }

    static {
        LOOKUP = new int[2048];
        unpackLookupTable(LOOKUP, UTF_MAP, UTF_RLE);
    }

    private static void unpackLookupTable(int[] lookup, String map, String rle) {
        int i = 0;
    L4:
        if (i >= 256) goto L6;
        lookup[i] = i & 63;
        lookup[i + 512] = i >> 2;
        lookup[i + UsbTerminalTypes.TERMINAL_EMBED_UNDEFINED] = (i >> 6) + 2;
        i = i + 1;
        goto L4
    L6:
        int i2 = 0;
    L8:
        if (i2 >= 128) goto L10;
        lookup[i2 + 1024] = (map.charAt(i2) - ' ') * 4;
        i2 = i2 + 1;
        goto L8
    L10:
        int i3 = 0;
    L12:
        if (i3 >= 64) goto L14;
        lookup[i3 + 1152] = i3 & 1;
        lookup[i3 + 1216] = (i3 & 1) + 2;
        i3 = i3 + 1;
        goto L12
    L14:
        int offset = 1280;
        int k = 0;
    L16:
        if (k >= 19) goto L21;
        int value = k & 3;
        int rep = rle.charAt(k) - ' ';
        int i4 = 0;
    L18:
        if (i4 >= rep) goto L20;
        lookup[offset] = value;
        i4 = i4 + 1;
        offset = offset + 1;
        goto L18
    L20:
        k = k + 1;
        goto L16
    L21:
        int i5 = 0;
    L23:
        if (i5 >= 16) goto L25;
        lookup[i5 + UsbTerminalTypes.TERMINAL_EMBED_UNDEFINED] = 1;
        lookup[i5 + 2032] = 6;
        i5 = i5 + 1;
        goto L23
    L25:
        lookup[1792(0x700, float:2.511E-42)] = 0;
        lookup[2047(0x7ff, float:2.868E-42)] = 7;
        int i6 = 0;
    L26:
        if (i6 >= 256) goto L29;
        lookup[i6 + 1536] = lookup[i6 + UsbTerminalTypes.TERMINAL_EMBED_UNDEFINED] << 3;
        i6 = i6 + 1;
        goto L26
    }
}
