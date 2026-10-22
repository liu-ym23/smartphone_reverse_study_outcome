package com.alibaba.fastjson.util;

import com.alibaba.fastjson.asm.Opcodes;
import com.stepos.activeview.utils.Constants;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.UByte;

/* loaded from: classes.dex */
public class UTF8Decoder extends CharsetDecoder {
    private static final Charset charset = Charset.forName(Constants.UTF_8_CODE);

    public static class Surrogate {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final int UCS4_MAX = 1114111;
        public static final int UCS4_MIN = 65536;

        private Surrogate() {
        }

        public static char high(int i4) {
            return (char) ((((i4 - UCS4_MIN) >> 10) & 1023) | 55296);
        }

        public static char low(int i4) {
            return (char) (((i4 - UCS4_MIN) & 1023) | 56320);
        }

        public static boolean neededFor(int i4) {
            return i4 >= 65536 && i4 <= 1114111;
        }
    }

    public UTF8Decoder() {
        super(charset, 1.0f, 1.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0091, code lost:
    
        return xflow(r12, r1, r5, r13, r7, 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c9, code lost:
    
        return xflow(r12, r1, r5, r13, r7, 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0123, code lost:
    
        return xflow(r12, r1, r5, r13, r7, 4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.nio.charset.CoderResult decodeArrayLoop(java.nio.ByteBuffer r12, java.nio.CharBuffer r13) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.UTF8Decoder.decodeArrayLoop(java.nio.ByteBuffer, java.nio.CharBuffer):java.nio.charset.CoderResult");
    }

    private static boolean isMalformed2(int i4, int i5) {
        return (i4 & 30) == 0 || (i5 & Opcodes.CHECKCAST) != 128;
    }

    private static boolean isMalformed3(int i4, int i5, int i6) {
        return ((i4 != -32 || (i5 & 224) != 128) && (i5 & Opcodes.CHECKCAST) == 128 && (i6 & Opcodes.CHECKCAST) == 128) ? false : true;
    }

    private static boolean isMalformed4(int i4, int i5, int i6) {
        return ((i4 & Opcodes.CHECKCAST) == 128 && (i5 & Opcodes.CHECKCAST) == 128 && (i6 & Opcodes.CHECKCAST) == 128) ? false : true;
    }

    private static boolean isNotContinuation(int i4) {
        return (i4 & Opcodes.CHECKCAST) != 128;
    }

    private static CoderResult lookupN(ByteBuffer byteBuffer, int i4) {
        for (int i5 = 1; i5 < i4; i5++) {
            if (isNotContinuation(byteBuffer.get())) {
                return CoderResult.malformedForLength(i5);
            }
        }
        return CoderResult.malformedForLength(i4);
    }

    private static CoderResult malformed(ByteBuffer byteBuffer, int i4, CharBuffer charBuffer, int i5, int i6) {
        byteBuffer.position(i4 - byteBuffer.arrayOffset());
        CoderResult coderResultMalformedN = malformedN(byteBuffer, i6);
        updatePositions(byteBuffer, i4, charBuffer, i5);
        return coderResultMalformedN;
    }

    public static CoderResult malformedN(ByteBuffer byteBuffer, int i4) {
        int i5 = 1;
        if (i4 == 1) {
            byte b4 = byteBuffer.get();
            return (b4 >> 2) == -2 ? byteBuffer.remaining() < 4 ? CoderResult.UNDERFLOW : lookupN(byteBuffer, 5) : (b4 >> 1) == -2 ? byteBuffer.remaining() < 5 ? CoderResult.UNDERFLOW : lookupN(byteBuffer, 6) : CoderResult.malformedForLength(1);
        }
        if (i4 == 2) {
            return CoderResult.malformedForLength(1);
        }
        if (i4 != 3) {
            if (i4 != 4) {
                throw new IllegalStateException();
            }
            int i6 = byteBuffer.get() & UByte.MAX_VALUE;
            byte b5 = byteBuffer.get();
            int i7 = b5 & UByte.MAX_VALUE;
            return (i6 > 244 || (i6 == 240 && (i7 < 144 || i7 > 191)) || ((i6 == 244 && (b5 & 240) != 128) || isNotContinuation(i7))) ? CoderResult.malformedForLength(1) : isNotContinuation(byteBuffer.get()) ? CoderResult.malformedForLength(2) : CoderResult.malformedForLength(3);
        }
        byte b6 = byteBuffer.get();
        byte b7 = byteBuffer.get();
        if ((b6 != -32 || (b7 & 224) != 128) && !isNotContinuation(b7)) {
            i5 = 2;
        }
        return CoderResult.malformedForLength(i5);
    }

    public static void updatePositions(Buffer buffer, int i4, Buffer buffer2, int i5) {
        buffer.position(i4);
        buffer2.position(i5);
    }

    private static CoderResult xflow(Buffer buffer, int i4, int i5, Buffer buffer2, int i6, int i7) {
        updatePositions(buffer, i4, buffer2, i6);
        return (i7 == 0 || i5 - i4 < i7) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
    }

    @Override // java.nio.charset.CharsetDecoder
    public CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        return decodeArrayLoop(byteBuffer, charBuffer);
    }
}
