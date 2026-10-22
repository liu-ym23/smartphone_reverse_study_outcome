package androidx.emoji2.text.flatbuffer;

import androidx.compose.foundation.b;
import androidx.emoji2.text.flatbuffer.Utf8;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class Utf8Safe extends Utf8 {

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i, int i6) {
            super(b.n(i, i6, "Unpaired surrogate at index ", " of "));
        }
    }

    private static int computeEncodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int iEncodedLengthGeneral = length;
        while (true) {
            if (i < length) {
                char cCharAt = charSequence.charAt(i);
                if (cCharAt >= 2048) {
                    iEncodedLengthGeneral += encodedLengthGeneral(charSequence, i);
                    break;
                }
                iEncodedLengthGeneral += (127 - cCharAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (iEncodedLengthGeneral >= length) {
            return iEncodedLengthGeneral;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (iEncodedLengthGeneral + 4294967296L));
    }

    public static String decodeUtf8Array(byte[] bArr, int i, int i6) throws IllegalArgumentException {
        if ((i | i6 | ((bArr.length - i) - i6)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i6)));
        }
        int i10 = i + i6;
        char[] cArr = new char[i6];
        int i11 = 0;
        while (i < i10) {
            byte b = bArr[i];
            if (!Utf8.DecodeUtil.isOneByte(b)) {
                break;
            }
            i++;
            Utf8.DecodeUtil.handleOneByte(b, cArr, i11);
            i11++;
        }
        int i12 = i11;
        while (i < i10) {
            int i13 = i + 1;
            byte b5 = bArr[i];
            if (Utf8.DecodeUtil.isOneByte(b5)) {
                int i14 = i12 + 1;
                Utf8.DecodeUtil.handleOneByte(b5, cArr, i12);
                int i15 = i13;
                while (i15 < i10) {
                    byte b10 = bArr[i15];
                    if (!Utf8.DecodeUtil.isOneByte(b10)) {
                        break;
                    }
                    i15++;
                    Utf8.DecodeUtil.handleOneByte(b10, cArr, i14);
                    i14++;
                }
                i12 = i14;
                i = i15;
            } else if (Utf8.DecodeUtil.isTwoBytes(b5)) {
                if (i13 >= i10) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                i += 2;
                Utf8.DecodeUtil.handleTwoBytes(b5, bArr[i13], cArr, i12);
                i12++;
            } else if (Utf8.DecodeUtil.isThreeBytes(b5)) {
                if (i13 >= i10 - 1) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i16 = i + 2;
                i += 3;
                Utf8.DecodeUtil.handleThreeBytes(b5, bArr[i13], bArr[i16], cArr, i12);
                i12++;
            } else {
                if (i13 >= i10 - 2) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                byte b11 = bArr[i13];
                int i17 = i + 3;
                byte b12 = bArr[i + 2];
                i += 4;
                Utf8.DecodeUtil.handleFourBytes(b5, b11, b12, bArr[i17], cArr, i12);
                i12 += 2;
            }
        }
        return new String(cArr, 0, i12);
    }

    public static String decodeUtf8Buffer(ByteBuffer byteBuffer, int i, int i6) throws IllegalArgumentException {
        if ((i | i6 | ((byteBuffer.limit() - i) - i6)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i6)));
        }
        int i10 = i + i6;
        char[] cArr = new char[i6];
        int i11 = 0;
        while (i < i10) {
            byte b = byteBuffer.get(i);
            if (!Utf8.DecodeUtil.isOneByte(b)) {
                break;
            }
            i++;
            Utf8.DecodeUtil.handleOneByte(b, cArr, i11);
            i11++;
        }
        int i12 = i11;
        while (i < i10) {
            int i13 = i + 1;
            byte b5 = byteBuffer.get(i);
            if (Utf8.DecodeUtil.isOneByte(b5)) {
                int i14 = i12 + 1;
                Utf8.DecodeUtil.handleOneByte(b5, cArr, i12);
                int i15 = i13;
                while (i15 < i10) {
                    byte b10 = byteBuffer.get(i15);
                    if (!Utf8.DecodeUtil.isOneByte(b10)) {
                        break;
                    }
                    i15++;
                    Utf8.DecodeUtil.handleOneByte(b10, cArr, i14);
                    i14++;
                }
                i12 = i14;
                i = i15;
            } else if (Utf8.DecodeUtil.isTwoBytes(b5)) {
                if (i13 >= i10) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                i += 2;
                Utf8.DecodeUtil.handleTwoBytes(b5, byteBuffer.get(i13), cArr, i12);
                i12++;
            } else if (Utf8.DecodeUtil.isThreeBytes(b5)) {
                if (i13 >= i10 - 1) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                int i16 = i + 2;
                i += 3;
                Utf8.DecodeUtil.handleThreeBytes(b5, byteBuffer.get(i13), byteBuffer.get(i16), cArr, i12);
                i12++;
            } else {
                if (i13 >= i10 - 2) {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
                byte b11 = byteBuffer.get(i13);
                int i17 = i + 3;
                byte b12 = byteBuffer.get(i + 2);
                i += 4;
                Utf8.DecodeUtil.handleFourBytes(b5, b11, b12, byteBuffer.get(i17), cArr, i12);
                i12 += 2;
            }
        }
        return new String(cArr, 0, i12);
    }

    private static int encodeUtf8Array(CharSequence charSequence, byte[] bArr, int i, int i6) {
        int i10;
        int i11;
        char cCharAt;
        int length = charSequence.length();
        int i12 = i6 + i;
        int i13 = 0;
        while (i13 < length && (i11 = i13 + i) < i12 && (cCharAt = charSequence.charAt(i13)) < 128) {
            bArr[i11] = (byte) cCharAt;
            i13++;
        }
        if (i13 == length) {
            return i + length;
        }
        int i14 = i + i13;
        while (i13 < length) {
            char cCharAt2 = charSequence.charAt(i13);
            if (cCharAt2 < 128 && i14 < i12) {
                bArr[i14] = (byte) cCharAt2;
                i14++;
            } else if (cCharAt2 < 2048 && i14 <= i12 - 2) {
                int i15 = i14 + 1;
                bArr[i14] = (byte) ((cCharAt2 >>> 6) | 960);
                i14 += 2;
                bArr[i15] = (byte) ((cCharAt2 & '?') | 128);
            } else {
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i14 > i12 - 3) {
                    if (i14 > i12 - 4) {
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i10 = i13 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i10)))) {
                            throw new UnpairedSurrogateException(i13, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i14);
                    }
                    int i16 = i13 + 1;
                    if (i16 != charSequence.length()) {
                        char cCharAt3 = charSequence.charAt(i16);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i14] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i14 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i17 = i14 + 3;
                            bArr[i14 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i14 += 4;
                            bArr[i17] = (byte) ((codePoint & 63) | 128);
                            i13 = i16;
                        } else {
                            i13 = i16;
                        }
                    }
                    throw new UnpairedSurrogateException(i13 - 1, length);
                }
                bArr[i14] = (byte) ((cCharAt2 >>> '\f') | 480);
                int i18 = i14 + 2;
                bArr[i14 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                i14 += 3;
                bArr[i18] = (byte) ((cCharAt2 & '?') | 128);
            }
            i13++;
        }
        return i14;
    }

    private static void encodeUtf8Buffer(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int length = charSequence.length();
        int iPosition = byteBuffer.position();
        int i6 = 0;
        while (i6 < length) {
            try {
                char cCharAt = charSequence.charAt(i6);
                if (cCharAt >= 128) {
                    break;
                }
                byteBuffer.put(iPosition + i6, (byte) cCharAt);
                i6++;
            } catch (IndexOutOfBoundsException unused) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i6) + " at index " + (Math.max(i6, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position()));
            }
        }
        if (i6 == length) {
            byteBuffer.position(iPosition + i6);
            return;
        }
        iPosition += i6;
        while (i6 < length) {
            char cCharAt2 = charSequence.charAt(i6);
            if (cCharAt2 < 128) {
                byteBuffer.put(iPosition, (byte) cCharAt2);
            } else if (cCharAt2 < 2048) {
                int i10 = iPosition + 1;
                try {
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> 6) | 192));
                    byteBuffer.put(i10, (byte) ((cCharAt2 & '?') | 128));
                    iPosition = i10;
                } catch (IndexOutOfBoundsException unused2) {
                    iPosition = i10;
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i6) + " at index " + (Math.max(i6, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position()));
                }
            } else {
                if (cCharAt2 >= 55296 && 57343 >= cCharAt2) {
                    int i11 = i6 + 1;
                    if (i11 != length) {
                        try {
                            char cCharAt3 = charSequence.charAt(i11);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                int i12 = iPosition + 1;
                                try {
                                    byteBuffer.put(iPosition, (byte) ((codePoint >>> 18) | 240));
                                    i = iPosition + 2;
                                } catch (IndexOutOfBoundsException unused3) {
                                    iPosition = i12;
                                    i6 = i11;
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i6) + " at index " + (Math.max(i6, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position()));
                                }
                                try {
                                    byteBuffer.put(i12, (byte) (((codePoint >>> 12) & 63) | 128));
                                    iPosition += 3;
                                    byteBuffer.put(i, (byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put(iPosition, (byte) ((codePoint & 63) | 128));
                                    i6 = i11;
                                } catch (IndexOutOfBoundsException unused4) {
                                    i6 = i11;
                                    iPosition = i;
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i6) + " at index " + (Math.max(i6, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position()));
                                }
                            } else {
                                i6 = i11;
                            }
                        } catch (IndexOutOfBoundsException unused5) {
                        }
                    }
                    throw new UnpairedSurrogateException(i6, length);
                }
                int i13 = iPosition + 1;
                byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> '\f') | 224));
                iPosition += 2;
                byteBuffer.put(i13, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                byteBuffer.put(iPosition, (byte) ((cCharAt2 & '?') | 128));
            }
            i6++;
            iPosition++;
        }
        byteBuffer.position(iPosition);
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i6 = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < 2048) {
                i6 += (127 - cCharAt) >>> 31;
            } else {
                i6 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) < 65536) {
                        throw new UnpairedSurrogateException(i, length);
                    }
                    i++;
                }
            }
            i++;
        }
        return i6;
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer byteBuffer, int i, int i6) throws IllegalArgumentException {
        return byteBuffer.hasArray() ? decodeUtf8Array(byteBuffer.array(), byteBuffer.arrayOffset() + i, i6) : decodeUtf8Buffer(byteBuffer, i, i6);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            encodeUtf8Buffer(charSequence, byteBuffer);
        } else {
            int iArrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(encodeUtf8Array(charSequence, byteBuffer.array(), byteBuffer.position() + iArrayOffset, byteBuffer.remaining()) - iArrayOffset);
        }
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence charSequence) {
        return computeEncodedLength(charSequence);
    }
}
