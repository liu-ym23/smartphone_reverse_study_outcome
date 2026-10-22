package org.brotli.dec;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class Dictionary {
    static final int MAX_DICTIONARY_WORD_LENGTH = 31;
    static final int MIN_DICTIONARY_WORD_LENGTH = 4;
    private static ByteBuffer data;
    static final int[] offsets = null;
    static final int[] sizeBits = null;

    private static class DataLoader {
        static final boolean OK = false;

        private DataLoader() {
        }

        static {
            boolean ok = true;
            Class.forName(Dictionary.class.getPackage().getName() + ".DictionaryData");     // Catch: Throwable -> L5
        L7:
            OK = ok;
            return;
        L6:
            ok = false;
            goto L7
        }
    }

    public Dictionary() {
    }

    static {
        offsets = new int[32];
        sizeBits = new int[32];
    }

    public static void setData(ByteBuffer data2, int[] sizeBits2) {
        if (data2.isDirect() == false) goto L44;
        if (data2.isReadOnly() == false) goto L44;
        if (sizeBits2.length > 31) goto L42;
        int i = 0;
    L10:
        if (i >= 4) goto L16;
        if (sizeBits2[i] != 0) goto L15;
        i = i + 1;
        goto L10
    L15:
        throw new BrotliRuntimeException("first 4 must be 0");
    L16:
        int[] dictionaryOffsets = offsets;
        int[] dictionarySizeBits = sizeBits;
        System.arraycopy(sizeBits2, 0, dictionarySizeBits, 0, sizeBits2.length);
        int pos = 0;
        int limit = data2.capacity();
        int i2 = 0;
    L18:
        if (i2 >= sizeBits2.length) goto L31;
        dictionaryOffsets[i2] = pos;
        int bits = dictionarySizeBits[i2];
        if (bits == 0) goto L30;
        if (bits >= 31) goto L29;
        pos = pos + (i2 << bits);
        if (pos <= 0) goto L27;
        if (pos <= limit) goto L30;
    L27:
        throw new BrotliRuntimeException("sizeBits is inconsistent: overflow");
    L29:
        throw new BrotliRuntimeException("sizeBits values must be less than 31");
    L30:
        i2 = i2 + 1;
        goto L18
    L31:
        int i3 = sizeBits2.length;
    L33:
        if (i3 >= 32) goto L36;
        dictionaryOffsets[i3] = pos;
        i3 = i3 + 1;
        goto L33
    L36:
        if (pos != limit) goto L40;
        data = data2;
        return;
    L40:
        throw new BrotliRuntimeException("sizeBits is inconsistent: underflow");
    L42:
        throw new BrotliRuntimeException("sizeBits length must be at most 31");
    L44:
        throw new BrotliRuntimeException("data must be a direct read-only byte buffer");
    }

    public static ByteBuffer getData() {
        if (data == null) goto L7;
        return data;
    L7:
        if (DataLoader.OK == false) goto L11;
        return data;
    L11:
        throw new BrotliRuntimeException("brotli dictionary is not set");
    }
}
