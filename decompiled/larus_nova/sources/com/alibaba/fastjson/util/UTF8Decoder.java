package com.alibaba.fastjson.util;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.UByte;

/* JADX INFO: loaded from: classes28.dex */
public class UTF8Decoder extends CharsetDecoder {
    private static final Charset charset = null;

    private static boolean isMalformed2(int r100, int r101) {
        if ((r100 & 30) != 0) goto L5;
    L8:
        return true;
    L5:
        if ((r101 & 192) != 128) goto L8;
        return false;
    }

    private static boolean isMalformed3(int r100, int r101, int r102) {
        if (r100 != (-32)) goto L7;
        if ((r101 & 224) != 128) goto L7;
    L12:
        return true;
    L7:
        if ((r101 & 192) != 128) goto L12;
        if ((r102 & 192) != 128) goto L12;
        return false;
    }

    private static boolean isMalformed4(int r100, int r101, int r102) {
        if ((r100 & 192) == 128) goto L5;
    L10:
        return true;
    L5:
        if ((r101 & 192) != 128) goto L10;
        if ((r102 & 192) != 128) goto L10;
        return false;
    }

    private static boolean isNotContinuation(int r100) {
        if ((r100 & 192) == 128) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        charset = Charset.forName("UTF-8");
    }

    public UTF8Decoder() {
        super(charset, 1.0f, 1.0f);
    }

    private CoderResult decodeArrayLoop(ByteBuffer r110, CharBuffer r111) {
        byte[] r100 = r110.array();
        int r101 = r110.arrayOffset() + r110.position();
        int r102 = r110.arrayOffset() + r110.limit();
        char[] r103 = r111.array();
        int r104 = r111.arrayOffset() + r111.position();
        int r105 = r111.arrayOffset() + r111.limit();
        int r106 = Math.min(r102 - r101, r105 - r104) + r104;
    L3:
        if (r104 >= r106) goto L7;
        byte r107 = r100[r101];
        if (r107 < 0) goto L7;
        r101 = r101 + 1;
        r103[r104] = (char) r107;
        r104 = r104 + 1;
    L7:
        int r108 = r101;
    L8:
        int r109 = r104;
    L9:
        if (r108 >= r102) goto L65;
        byte r112 = r100[r108];
        if (r112 >= 0) goto L12;
        if ((r112 >> 5) != (-2)) goto L31;
        if ((r102 - r108) < 2) goto L29;
        if (r109 >= r105) goto L29;
        byte r113 = r100[r108 + 1];
        if (isMalformed2(r112, r113) == true) goto L25;
        int r114 = r109 + 1;
        r103[r109] = (char) (((r112 << 6) ^ r113) ^ 3968);
        r108 = r108 + 2;
    L27:
        r109 = r114;
        goto L9
    L25:
        return malformed(r110, r108, r111, r109, 2);
    L29:
        return xflow(r110, r108, r102, r111, r109, 2);
    L31:
        if ((r112 >> 4) != (-2)) goto L44;
        if ((r102 - r108) < 3) goto L42;
        if (r109 >= r105) goto L42;
        byte r115 = r100[r108 + 1];
        byte r116 = r100[r108 + 2];
        if (isMalformed3(r112, r115, r116) == true) goto L39;
        r114 = r109 + 1;
        r103[r109] = (char) ((((r112 << 12) ^ (r115 << 6)) ^ r116) ^ 8064);
        r108 = r108 + 3;
        goto L27
    L39:
        return malformed(r110, r108, r111, r109, 3);
    L42:
        return xflow(r110, r108, r102, r111, r109, 3);
    L44:
        if ((r112 >> 3) != (-2)) goto L63;
        if ((r102 - r108) < 4) goto L61;
        if ((r105 - r109) < 2) goto L61;
        byte r117 = r100[r108 + 1];
        byte r118 = r100[r108 + 2];
        byte r119 = r100[r108 + 3];
        int r120 = ((((r112 & 7) << 18) | ((r117 & 63) << 12)) | ((r118 & 63) << 6)) | (r119 & 63);
        if (isMalformed4(r117, r118, r119) == true) goto L59;
        if (r120 < 65536) goto L59;
        if (r120 > 1114111) goto L59;
        int r121 = r109 + 1;
        int r122 = r120 - 65536;
        r103[r109] = (char) (((r122 >> 10) & 1023) | 55296);
        r104 = r121 + 1;
        r103[r121] = (char) ((r122 & 1023) | 56320);
        r108 = r108 + 4;
    L59:
        return malformed(r110, r108, r111, r109, 4);
    L61:
        return xflow(r110, r108, r102, r111, r109, 4);
    L63:
        return malformed(r110, r108, r111, r109, 1);
    L12:
        if (r109 >= r105) goto L14;
        r104 = r109 + 1;
        r103[r109] = (char) r112;
        r108 = r108 + 1;
        goto L8
    L14:
        return xflow(r110, r108, r102, r111, r109, 1);
    L65:
        return xflow(r110, r108, r102, r111, r109, 0);
    }

    private static CoderResult lookupN(ByteBuffer r100, int r101) {
        int r102 = 1;
    L3:
        if (r102 >= r101) goto L10;
        if (isNotContinuation(r100.get()) == true) goto L7;
        r102 = r102 + 1;
        goto L3
    L7:
        return CoderResult.malformedForLength(r102);
    L10:
        return CoderResult.malformedForLength(r101);
    }

    public static CoderResult malformedN(ByteBuffer r100, int r101) {
        int r102 = 1;
        if (r101 != 1) goto L5;
        byte r103 = r100.get();
        if ((r103 >> 2) != (-2)) goto L54;
        if (r100.remaining() >= 4) goto L52;
        return CoderResult.UNDERFLOW;
    L52:
        return lookupN(r100, 5);
    L54:
        if ((r103 >> 1) != (-2)) goto L62;
        if (r100.remaining() >= 5) goto L60;
        return CoderResult.UNDERFLOW;
    L60:
        return lookupN(r100, 6);
    L62:
        return CoderResult.malformedForLength(1);
    L5:
        if (r101 == 2) goto L44;
        if (r101 == 3) goto L33;
        if (r101 != 4) goto L32;
        int r104 = r100.get() & UByte.MAX_VALUE;
        int r105 = r100.get() & UByte.MAX_VALUE;
        if (r104 > 244) goto L30;
        if (r104 == 240) goto L14;
    L17:
        if (r104 != 244) goto L21;
        if ((r105 & 240) != 128) goto L30;
    L21:
        if (isNotContinuation(r105) == true) goto L30;
        if (isNotContinuation(r100.get()) == false) goto L28;
        return CoderResult.malformedForLength(2);
    L28:
        return CoderResult.malformedForLength(3);
    L14:
        if (r105 < 144) goto L30;
        if (r105 <= 191) goto L17;
    L30:
        return CoderResult.malformedForLength(1);
    L32:
        throw new IllegalStateException();
    L33:
        byte r106 = r100.get();
        byte r107 = r100.get();
        if (r106 != (-32)) goto L38;
        if ((r107 & 224) != 128) goto L38;
    L42:
        return CoderResult.malformedForLength(r102);
    L38:
        if (isNotContinuation(r107) == true) goto L42;
        r102 = 2;
        goto L42
    L44:
        return CoderResult.malformedForLength(1);
    }

    @Override // java.nio.charset.CharsetDecoder
    public CoderResult decodeLoop(ByteBuffer r100, CharBuffer r101) {
        return decodeArrayLoop(r100, r101);
    }

    private static CoderResult malformed(ByteBuffer r100, int r101, CharBuffer r102, int r103, int r104) {
        r100.position(r101 - r100.arrayOffset());
        CoderResult r105 = malformedN(r100, r104);
        r100.position(r101);
        r102.position(r103);
        return r105;
    }

    private static CoderResult xflow(Buffer r100, int r101, int r102, Buffer r103, int r104, int r105) {
        r100.position(r101);
        r103.position(r104);
        if (r105 == 0) goto L9;
        if ((r102 - r101) < r105) goto L9;
        return CoderResult.OVERFLOW;
    L9:
        return CoderResult.UNDERFLOW;
    }
}
