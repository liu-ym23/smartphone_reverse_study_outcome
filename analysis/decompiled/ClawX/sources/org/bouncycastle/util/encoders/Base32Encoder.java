package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* loaded from: classes.dex */
public class Base32Encoder implements Encoder {
    private static final byte[] DEAULT_ENCODING_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};
    private static final byte DEFAULT_PADDING = 61;
    private final byte[] decodingTable;
    private final byte[] encodingTable;
    private final byte padding;

    public Base32Encoder() {
        this.decodingTable = new byte[128];
        this.encodingTable = DEAULT_ENCODING_TABLE;
        this.padding = DEFAULT_PADDING;
        initialiseDecodingTable();
    }

    private int decodeLastBlock(OutputStream outputStream, char c3, char c8, char c9, char c10, char c11, char c12, char c13, char c14) throws IOException {
        char c15 = this.padding;
        if (c14 != c15) {
            byte[] bArr = this.decodingTable;
            byte b9 = bArr[c3];
            byte b10 = bArr[c8];
            byte b11 = bArr[c9];
            byte b12 = bArr[c10];
            byte b13 = bArr[c11];
            byte b14 = bArr[c12];
            byte b15 = bArr[c13];
            byte b16 = bArr[c14];
            if ((b9 | b10 | b11 | b12 | b13 | b14 | b15 | b16) < 0) {
                throw new IOException("invalid characters encountered at end of base32 data");
            }
            outputStream.write((b9 << 3) | (b10 >> 2));
            outputStream.write((b10 << 6) | (b11 << 1) | (b12 >> 4));
            outputStream.write((b12 << 4) | (b13 >> 1));
            outputStream.write((b13 << 7) | (b14 << 2) | (b15 >> 3));
            outputStream.write(b16 | (b15 << 5));
            return 5;
        }
        if (c13 != c15) {
            byte[] bArr2 = this.decodingTable;
            byte b17 = bArr2[c3];
            byte b18 = bArr2[c8];
            byte b19 = bArr2[c9];
            byte b20 = bArr2[c10];
            byte b21 = bArr2[c11];
            byte b22 = bArr2[c12];
            byte b23 = bArr2[c13];
            if ((b17 | b18 | b19 | b20 | b21 | b22 | b23) < 0) {
                throw new IOException("invalid characters encountered at end of base32 data");
            }
            outputStream.write((b17 << 3) | (b18 >> 2));
            outputStream.write((b18 << 6) | (b19 << 1) | (b20 >> 4));
            outputStream.write((b20 << 4) | (b21 >> 1));
            outputStream.write((b23 >> 3) | (b21 << 7) | (b22 << 2));
            return 4;
        }
        if (c12 != c15) {
            throw new IOException("invalid characters encountered at end of base32 data");
        }
        if (c11 != c15) {
            byte[] bArr3 = this.decodingTable;
            byte b24 = bArr3[c3];
            byte b25 = bArr3[c8];
            byte b26 = bArr3[c9];
            byte b27 = bArr3[c10];
            byte b28 = bArr3[c11];
            if ((b24 | b25 | b26 | b27 | b28) < 0) {
                throw new IOException("invalid characters encountered at end of base32 data");
            }
            outputStream.write((b24 << 3) | (b25 >> 2));
            outputStream.write((b25 << 6) | (b26 << 1) | (b27 >> 4));
            outputStream.write((b28 >> 1) | (b27 << 4));
            return 3;
        }
        if (c10 == c15) {
            if (c9 != c15) {
                throw new IOException("invalid characters encountered at end of base32 data");
            }
            byte[] bArr4 = this.decodingTable;
            byte b29 = bArr4[c3];
            byte b30 = bArr4[c8];
            if ((b29 | b30) < 0) {
                throw new IOException("invalid characters encountered at end of base32 data");
            }
            outputStream.write((b30 >> 2) | (b29 << 3));
            return 1;
        }
        byte[] bArr5 = this.decodingTable;
        byte b31 = bArr5[c3];
        byte b32 = bArr5[c8];
        byte b33 = bArr5[c9];
        byte b34 = bArr5[c10];
        if ((b31 | b32 | b33 | b34) < 0) {
            throw new IOException("invalid characters encountered at end of base32 data");
        }
        outputStream.write((b31 << 3) | (b32 >> 2));
        outputStream.write((b34 >> 4) | (b32 << 6) | (b33 << 1));
        return 2;
    }

    private void encodeBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        byte b9 = bArr[i8];
        int i10 = bArr[i8 + 1] & 255;
        int i11 = bArr[i8 + 2] & 255;
        int i12 = bArr[i8 + 3] & 255;
        byte b10 = bArr[i8 + 4];
        byte[] bArr3 = this.encodingTable;
        bArr2[i9] = bArr3[(b9 >>> 3) & 31];
        bArr2[i9 + 1] = bArr3[((b9 << 2) | (i10 >>> 6)) & 31];
        bArr2[i9 + 2] = bArr3[(i10 >>> 1) & 31];
        bArr2[i9 + 3] = bArr3[((i10 << 4) | (i11 >>> 4)) & 31];
        bArr2[i9 + 4] = bArr3[((i11 << 1) | (i12 >>> 7)) & 31];
        bArr2[i9 + 5] = bArr3[(i12 >>> 2) & 31];
        bArr2[i9 + 6] = bArr3[(((b10 & 255) >>> 5) | (i12 << 3)) & 31];
        bArr2[i9 + 7] = bArr3[b10 & 31];
    }

    private boolean ignore(char c3) {
        return c3 == '\n' || c3 == '\r' || c3 == '\t' || c3 == ' ';
    }

    private int nextI(byte[] bArr, int i8, int i9) {
        while (i8 < i9 && ignore((char) bArr[i8])) {
            i8++;
        }
        return i8;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int decode(String str, OutputStream outputStream) {
        byte[] byteArray = Strings.toByteArray(str);
        return decode(byteArray, 0, byteArray.length, outputStream);
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int encode(byte[] bArr, int i8, int i9, OutputStream outputStream) throws IOException {
        if (i9 < 0) {
            return 0;
        }
        byte[] bArr2 = new byte[72];
        int i10 = i8;
        int i11 = i9;
        while (i11 > 0) {
            int iMin = Math.min(45, i11);
            Base32Encoder base32Encoder = this;
            outputStream.write(bArr2, 0, base32Encoder.encode(bArr, i10, iMin, bArr2, 0));
            i10 += iMin;
            i11 -= iMin;
            this = base32Encoder;
        }
        return ((i9 + 2) / 3) * 4;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int getEncodedLength(int i8) {
        return ((i8 + 4) / 5) * 8;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int getMaxDecodedLength(int i8) {
        return (i8 / 8) * 5;
    }

    public void initialiseDecodingTable() {
        int i8 = 0;
        int i9 = 0;
        while (true) {
            byte[] bArr = this.decodingTable;
            if (i9 >= bArr.length) {
                break;
            }
            bArr[i9] = -1;
            i9++;
        }
        while (true) {
            byte[] bArr2 = this.encodingTable;
            if (i8 >= bArr2.length) {
                return;
            }
            this.decodingTable[bArr2[i8]] = (byte) i8;
            i8++;
        }
    }

    public Base32Encoder(byte[] bArr, byte b9) {
        this.decodingTable = new byte[128];
        if (bArr.length != 32) {
            throw new IllegalArgumentException("encoding table needs to be length 32");
        }
        this.encodingTable = Arrays.clone(bArr);
        this.padding = b9;
        initialiseDecodingTable();
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int decode(byte[] bArr, int i8, int i9, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[55];
        int i10 = i8 + i9;
        while (i10 > i8 && ignore((char) bArr[i10 - 1])) {
            i10--;
        }
        if (i10 == 0) {
            return 0;
        }
        int i11 = i10;
        int i12 = 0;
        while (i11 > i8 && i12 != 8) {
            if (!ignore((char) bArr[i11 - 1])) {
                i12++;
            }
            i11--;
        }
        int iNextI = nextI(bArr, i8, i11);
        int i13 = 0;
        int i14 = 0;
        while (iNextI < i11) {
            int i15 = iNextI + 1;
            byte b9 = this.decodingTable[bArr[iNextI]];
            int iNextI2 = nextI(bArr, i15, i11);
            int i16 = iNextI2 + 1;
            byte b10 = this.decodingTable[bArr[iNextI2]];
            int iNextI3 = nextI(bArr, i16, i11);
            int i17 = iNextI3 + 1;
            byte b11 = this.decodingTable[bArr[iNextI3]];
            int iNextI4 = nextI(bArr, i17, i11);
            int i18 = iNextI4 + 1;
            byte b12 = this.decodingTable[bArr[iNextI4]];
            int iNextI5 = nextI(bArr, i18, i11);
            int i19 = iNextI5 + 1;
            byte b13 = this.decodingTable[bArr[iNextI5]];
            int iNextI6 = nextI(bArr, i19, i11);
            int i20 = iNextI6 + 1;
            byte b14 = this.decodingTable[bArr[iNextI6]];
            int iNextI7 = nextI(bArr, i20, i11);
            int i21 = iNextI7 + 1;
            byte b15 = this.decodingTable[bArr[iNextI7]];
            int iNextI8 = nextI(bArr, i21, i11);
            int i22 = iNextI8 + 1;
            byte b16 = this.decodingTable[bArr[iNextI8]];
            if ((b9 | b10 | b11 | b12 | b13 | b14 | b15 | b16) < 0) {
                throw new IOException("invalid characters encountered in base32 data");
            }
            bArr2[i13] = (byte) ((b9 << 3) | (b10 >> 2));
            bArr2[i13 + 1] = (byte) ((b10 << 6) | (b11 << 1) | (b12 >> 4));
            bArr2[i13 + 2] = (byte) ((b12 << 4) | (b13 >> 1));
            int i23 = i13 + 4;
            bArr2[i13 + 3] = (byte) ((b14 << 2) | (b13 << 7) | (b15 >> 3));
            i13 += 5;
            bArr2[i23] = (byte) ((b15 << 5) | b16);
            if (i13 == 55) {
                outputStream.write(bArr2);
                i13 = 0;
            }
            i14 += 5;
            iNextI = nextI(bArr, i22, i11);
        }
        if (i13 > 0) {
            outputStream.write(bArr2, 0, i13);
        }
        int iNextI9 = nextI(bArr, iNextI, i10);
        int iNextI10 = nextI(bArr, iNextI9 + 1, i10);
        int iNextI11 = nextI(bArr, iNextI10 + 1, i10);
        int iNextI12 = nextI(bArr, iNextI11 + 1, i10);
        int iNextI13 = nextI(bArr, iNextI12 + 1, i10);
        int iNextI14 = nextI(bArr, iNextI13 + 1, i10);
        int iNextI15 = nextI(bArr, iNextI14 + 1, i10);
        return i14 + decodeLastBlock(outputStream, (char) bArr[iNextI9], (char) bArr[iNextI10], (char) bArr[iNextI11], (char) bArr[iNextI12], (char) bArr[iNextI13], (char) bArr[iNextI14], (char) bArr[iNextI15], (char) bArr[nextI(bArr, iNextI15 + 1, i10)]);
    }

    public int encode(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        int i11 = (i8 + i9) - 4;
        int i12 = i8;
        int i13 = i10;
        while (i12 < i11) {
            encodeBlock(bArr, i12, bArr2, i13);
            i12 += 5;
            i13 += 8;
        }
        int i14 = i9 - (i12 - i8);
        if (i14 > 0) {
            byte[] bArr3 = new byte[5];
            System.arraycopy(bArr, i12, bArr3, 0, i14);
            encodeBlock(bArr3, 0, bArr2, i13);
            if (i14 == 1) {
                byte b9 = this.padding;
                bArr2[i13 + 2] = b9;
                bArr2[i13 + 3] = b9;
                bArr2[i13 + 4] = b9;
                bArr2[i13 + 5] = b9;
                bArr2[i13 + 6] = b9;
                bArr2[i13 + 7] = b9;
            } else if (i14 == 2) {
                byte b10 = this.padding;
                bArr2[i13 + 4] = b10;
                bArr2[i13 + 5] = b10;
                bArr2[i13 + 6] = b10;
                bArr2[i13 + 7] = b10;
            } else if (i14 == 3) {
                byte b11 = this.padding;
                bArr2[i13 + 5] = b11;
                bArr2[i13 + 6] = b11;
                bArr2[i13 + 7] = b11;
            } else if (i14 == 4) {
                bArr2[i13 + 7] = this.padding;
            }
            i13 += 8;
        }
        return i13 - i10;
    }
}
