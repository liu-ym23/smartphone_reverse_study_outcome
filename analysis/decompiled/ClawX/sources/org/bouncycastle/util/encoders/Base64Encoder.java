package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class Base64Encoder implements Encoder {
    protected final byte[] encodingTable = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    protected byte padding = 61;
    protected final byte[] decodingTable = new byte[128];

    public Base64Encoder() {
        initialiseDecodingTable();
    }

    private int decodeLastBlock(OutputStream outputStream, char c3, char c8, char c9, char c10) throws IOException {
        char c11 = this.padding;
        if (c9 == c11) {
            if (c10 != c11) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            byte[] bArr = this.decodingTable;
            byte b9 = bArr[c3];
            byte b10 = bArr[c8];
            if ((b9 | b10) < 0) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            outputStream.write((b10 >> 4) | (b9 << 2));
            return 1;
        }
        byte[] bArr2 = this.decodingTable;
        if (c10 == c11) {
            byte b11 = bArr2[c3];
            byte b12 = bArr2[c8];
            byte b13 = bArr2[c9];
            if ((b11 | b12 | b13) < 0) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            outputStream.write((b11 << 2) | (b12 >> 4));
            outputStream.write((b13 >> 2) | (b12 << 4));
            return 2;
        }
        byte b14 = bArr2[c3];
        byte b15 = bArr2[c8];
        byte b16 = bArr2[c9];
        byte b17 = bArr2[c10];
        if ((b14 | b15 | b16 | b17) < 0) {
            throw new IOException("invalid characters encountered at end of base64 data");
        }
        outputStream.write((b14 << 2) | (b15 >> 4));
        outputStream.write((b15 << 4) | (b16 >> 2));
        outputStream.write(b17 | (b16 << 6));
        return 3;
    }

    private boolean ignore(char c3) {
        return c3 == '\n' || c3 == '\r' || c3 == '\t' || c3 == ' ';
    }

    private int nextI(String str, int i8, int i9) {
        while (i8 < i9 && ignore(str.charAt(i8))) {
            i8++;
        }
        return i8;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int decode(String str, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[54];
        int length = str.length();
        while (length > 0 && ignore(str.charAt(length - 1))) {
            length--;
        }
        if (length == 0) {
            return 0;
        }
        int i8 = length;
        int i9 = 0;
        while (i8 > 0 && i9 != 4) {
            if (!ignore(str.charAt(i8 - 1))) {
                i9++;
            }
            i8--;
        }
        int iNextI = nextI(str, 0, i8);
        int i10 = 0;
        int i11 = 0;
        while (iNextI < i8) {
            int i12 = iNextI + 1;
            byte b9 = this.decodingTable[str.charAt(iNextI)];
            int iNextI2 = nextI(str, i12, i8);
            int i13 = iNextI2 + 1;
            byte b10 = this.decodingTable[str.charAt(iNextI2)];
            int iNextI3 = nextI(str, i13, i8);
            int i14 = iNextI3 + 1;
            byte b11 = this.decodingTable[str.charAt(iNextI3)];
            int iNextI4 = nextI(str, i14, i8);
            int i15 = iNextI4 + 1;
            byte b12 = this.decodingTable[str.charAt(iNextI4)];
            if ((b9 | b10 | b11 | b12) < 0) {
                throw new IOException("invalid characters encountered in base64 data");
            }
            bArr[i10] = (byte) ((b9 << 2) | (b10 >> 4));
            int i16 = i10 + 2;
            bArr[i10 + 1] = (byte) ((b10 << 4) | (b11 >> 2));
            i10 += 3;
            bArr[i16] = (byte) ((b11 << 6) | b12);
            i11 += 3;
            if (i10 == 54) {
                outputStream.write(bArr);
                i10 = 0;
            }
            iNextI = nextI(str, i15, i8);
        }
        if (i10 > 0) {
            outputStream.write(bArr, 0, i10);
        }
        int iNextI5 = nextI(str, iNextI, length);
        int iNextI6 = nextI(str, iNextI5 + 1, length);
        int iNextI7 = nextI(str, iNextI6 + 1, length);
        return i11 + decodeLastBlock(outputStream, str.charAt(iNextI5), str.charAt(iNextI6), str.charAt(iNextI7), str.charAt(nextI(str, iNextI7 + 1, length)));
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
            int iMin = Math.min(54, i11);
            Base64Encoder base64Encoder = this;
            outputStream.write(bArr2, 0, base64Encoder.encode(bArr, i10, iMin, bArr2, 0));
            i10 += iMin;
            i11 -= iMin;
            this = base64Encoder;
        }
        return ((i9 + 2) / 3) * 4;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int getEncodedLength(int i8) {
        return ((i8 + 2) / 3) * 4;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int getMaxDecodedLength(int i8) {
        return (i8 / 4) * 3;
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

    private int nextI(byte[] bArr, int i8, int i9) {
        while (i8 < i9 && ignore((char) bArr[i8])) {
            i8++;
        }
        return i8;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int decode(byte[] bArr, int i8, int i9, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[54];
        int i10 = i8 + i9;
        while (i10 > i8 && ignore((char) bArr[i10 - 1])) {
            i10--;
        }
        if (i10 == 0) {
            return 0;
        }
        int i11 = i10;
        int i12 = 0;
        while (i11 > i8 && i12 != 4) {
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
            if ((b9 | b10 | b11 | b12) < 0) {
                throw new IOException("invalid characters encountered in base64 data");
            }
            bArr2[i13] = (byte) ((b9 << 2) | (b10 >> 4));
            int i19 = i13 + 2;
            bArr2[i13 + 1] = (byte) ((b10 << 4) | (b11 >> 2));
            i13 += 3;
            bArr2[i19] = (byte) ((b11 << 6) | b12);
            if (i13 == 54) {
                outputStream.write(bArr2);
                i13 = 0;
            }
            i14 += 3;
            iNextI = nextI(bArr, i18, i11);
        }
        if (i13 > 0) {
            outputStream.write(bArr2, 0, i13);
        }
        int iNextI5 = nextI(bArr, iNextI, i10);
        int iNextI6 = nextI(bArr, iNextI5 + 1, i10);
        int iNextI7 = nextI(bArr, iNextI6 + 1, i10);
        return i14 + decodeLastBlock(outputStream, (char) bArr[iNextI5], (char) bArr[iNextI6], (char) bArr[iNextI7], (char) bArr[nextI(bArr, iNextI7 + 1, i10)]);
    }

    public int encode(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        int i11 = (i8 + i9) - 2;
        int i12 = i8;
        int i13 = i10;
        while (i12 < i11) {
            byte b9 = bArr[i12];
            int i14 = i12 + 2;
            int i15 = bArr[i12 + 1] & 255;
            i12 += 3;
            byte b10 = bArr[i14];
            byte[] bArr3 = this.encodingTable;
            bArr2[i13] = bArr3[(b9 >>> 2) & 63];
            bArr2[i13 + 1] = bArr3[((b9 << 4) | (i15 >>> 4)) & 63];
            int i16 = i13 + 3;
            bArr2[i13 + 2] = bArr3[((i15 << 2) | ((b10 & 255) >>> 6)) & 63];
            i13 += 4;
            bArr2[i16] = bArr3[b10 & 63];
        }
        int i17 = i9 - (i12 - i8);
        if (i17 == 1) {
            int i18 = bArr[i12] & 255;
            byte[] bArr4 = this.encodingTable;
            bArr2[i13] = bArr4[(i18 >>> 2) & 63];
            bArr2[i13 + 1] = bArr4[(i18 << 4) & 63];
            int i19 = i13 + 3;
            byte b11 = this.padding;
            bArr2[i13 + 2] = b11;
            i13 += 4;
            bArr2[i19] = b11;
        } else if (i17 == 2) {
            int i20 = bArr[i12] & 255;
            int i21 = bArr[i12 + 1] & 255;
            byte[] bArr5 = this.encodingTable;
            bArr2[i13] = bArr5[(i20 >>> 2) & 63];
            bArr2[i13 + 1] = bArr5[((i20 << 4) | (i21 >>> 4)) & 63];
            int i22 = i13 + 3;
            bArr2[i13 + 2] = bArr5[(i21 << 2) & 63];
            i13 += 4;
            bArr2[i22] = this.padding;
        }
        return i13 - i10;
    }
}
