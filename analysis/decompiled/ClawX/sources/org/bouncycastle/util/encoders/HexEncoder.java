package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class HexEncoder implements Encoder {
    protected final byte[] encodingTable = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    protected final byte[] decodingTable = new byte[128];

    public HexEncoder() {
        initialiseDecodingTable();
    }

    private static boolean ignore(char c3) {
        return c3 == '\n' || c3 == '\r' || c3 == '\t' || c3 == ' ';
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int decode(String str, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[36];
        int length = str.length();
        while (length > 0 && ignore(str.charAt(length - 1))) {
            length--;
        }
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < length) {
            while (i8 < length && ignore(str.charAt(i8))) {
                i8++;
            }
            int i11 = i8 + 1;
            byte b9 = this.decodingTable[str.charAt(i8)];
            while (i11 < length && ignore(str.charAt(i11))) {
                i11++;
            }
            int i12 = i11 + 1;
            byte b10 = this.decodingTable[str.charAt(i11)];
            if ((b9 | b10) < 0) {
                throw new IOException("invalid characters encountered in Hex string");
            }
            int i13 = i9 + 1;
            bArr[i9] = (byte) ((b9 << 4) | b10);
            if (i13 == 36) {
                outputStream.write(bArr);
                i9 = 0;
            } else {
                i9 = i13;
            }
            i10++;
            i8 = i12;
        }
        if (i9 > 0) {
            outputStream.write(bArr, 0, i9);
        }
        return i10;
    }

    public byte[] decodeStrict(String str, int i8, int i9) throws IOException {
        if (str == null) {
            throw new NullPointerException("'str' cannot be null");
        }
        if (i8 < 0 || i9 < 0 || i8 > str.length() - i9) {
            throw new IndexOutOfBoundsException("invalid offset and/or length specified");
        }
        if ((i9 & 1) != 0) {
            throw new IOException("a hexadecimal encoding must have an even number of characters");
        }
        int i10 = i9 >>> 1;
        byte[] bArr = new byte[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = i8 + 1;
            byte b9 = this.decodingTable[str.charAt(i8)];
            i8 += 2;
            int i13 = (b9 << 4) | this.decodingTable[str.charAt(i12)];
            if (i13 < 0) {
                throw new IOException("invalid characters encountered in Hex string");
            }
            bArr[i11] = (byte) i13;
        }
        return bArr;
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
            int iMin = Math.min(36, i11);
            HexEncoder hexEncoder = this;
            outputStream.write(bArr2, 0, hexEncoder.encode(bArr, i10, iMin, bArr2, 0));
            i10 += iMin;
            i11 -= iMin;
            this = hexEncoder;
        }
        return i9 * 2;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int getEncodedLength(int i8) {
        return i8 * 2;
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int getMaxDecodedLength(int i8) {
        return i8 / 2;
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
                byte[] bArr3 = this.decodingTable;
                bArr3[65] = bArr3[97];
                bArr3[66] = bArr3[98];
                bArr3[67] = bArr3[99];
                bArr3[68] = bArr3[100];
                bArr3[69] = bArr3[101];
                bArr3[70] = bArr3[102];
                return;
            }
            this.decodingTable[bArr2[i8]] = (byte) i8;
            i8++;
        }
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    public int decode(byte[] bArr, int i8, int i9, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[36];
        int i10 = i9 + i8;
        while (i10 > i8 && ignore((char) bArr[i10 - 1])) {
            i10--;
        }
        int i11 = 0;
        int i12 = 0;
        while (i8 < i10) {
            while (i8 < i10 && ignore((char) bArr[i8])) {
                i8++;
            }
            int i13 = i8 + 1;
            byte b9 = this.decodingTable[bArr[i8]];
            while (i13 < i10 && ignore((char) bArr[i13])) {
                i13++;
            }
            int i14 = i13 + 1;
            byte b10 = this.decodingTable[bArr[i13]];
            if ((b9 | b10) < 0) {
                throw new IOException("invalid characters encountered in Hex data");
            }
            int i15 = i11 + 1;
            bArr2[i11] = (byte) ((b9 << 4) | b10);
            if (i15 == 36) {
                outputStream.write(bArr2);
                i11 = 0;
            } else {
                i11 = i15;
            }
            i12++;
            i8 = i14;
        }
        if (i11 > 0) {
            outputStream.write(bArr2, 0, i11);
        }
        return i12;
    }

    public int encode(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        int i11 = i9 + i8;
        int i12 = i10;
        while (i8 < i11) {
            int i13 = i8 + 1;
            byte b9 = bArr[i8];
            int i14 = i12 + 1;
            byte[] bArr3 = this.encodingTable;
            bArr2[i12] = bArr3[(b9 & 255) >>> 4];
            i12 += 2;
            bArr2[i14] = bArr3[b9 & 15];
            i8 = i13;
        }
        return i12 - i10;
    }
}
