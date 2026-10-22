package com.stepos.statsapp.v3.utils.log;

import com.fasterxml.jackson.core.JsonPointer;
import io.ktor.util.date.GMTDateParser;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public class EncryptBase64 {
    private static final char[] base64_table = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', GMTDateParser.MONTH, 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', GMTDateParser.YEAR, 'Z', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f', 'g', GMTDateParser.HOURS, 'i', 'j', 'k', 'l', GMTDateParser.MINUTES, 'n', 'o', 'p', 'q', 'r', GMTDateParser.SECONDS, 't', 'u', 'v', 'w', 'x', 'y', GMTDateParser.ZONE, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', JsonPointer.SEPARATOR};
    private static final char last2byte = (char) Integer.parseInt("00000011", 2);
    private static final char last4byte = (char) Integer.parseInt("00001111", 2);
    private static final char last6byte = (char) Integer.parseInt("00111111", 2);
    private char[] mBase64Table;
    private int offset;
    private char[] private_base64_table;
    private String private_key;

    public EncryptBase64() {
        this.offset = 0;
        this.mBase64Table = base64_table;
    }

    private int base64_to_256(byte b10) {
        if (b10 >= 65 && b10 <= 90) {
            char[] cArr = base64_table;
            return ((b10 - 65) + (cArr.length - this.offset)) % cArr.length;
        }
        if (b10 >= 97 && b10 <= 122) {
            char[] cArr2 = base64_table;
            return ((b10 - 71) + (cArr2.length - this.offset)) % cArr2.length;
        }
        if (b10 >= 48 && b10 <= 57) {
            char[] cArr3 = base64_table;
            return ((b10 + 4) + (cArr3.length - this.offset)) % cArr3.length;
        }
        if (b10 == 43) {
            char[] cArr4 = base64_table;
            return ((cArr4.length - this.offset) + 62) % cArr4.length;
        }
        if (b10 != 47) {
            return 64;
        }
        char[] cArr5 = base64_table;
        return ((cArr5.length - this.offset) + 63) % cArr5.length;
    }

    private void initPrivateTable() {
        this.private_base64_table = new char[base64_table.length];
        int i10 = 0;
        this.offset = this.private_key.charAt(0) % '\r';
        while (true) {
            char[] cArr = base64_table;
            if (i10 >= cArr.length) {
                this.mBase64Table = this.private_base64_table;
                return;
            } else {
                this.private_base64_table[i10] = cArr[(this.offset + i10) % cArr.length];
                i10++;
            }
        }
    }

    public String decode(byte[] bArr, String str) {
        int length = bArr.length;
        StringBuilder sb2 = new StringBuilder((length * 3) / 4);
        int[] iArr = new int[4];
        int i10 = 0;
        while (i10 < length) {
            int i11 = 0;
            while (i11 < 4) {
                iArr[i11] = base64_to_256(bArr[i10]);
                i11++;
                i10++;
            }
            sb2.append((char) ((iArr[0] << 2) | (iArr[1] >>> 4)));
            int i12 = iArr[2];
            if (i12 != 64) {
                sb2.append((char) ((i12 >>> 2) | ((iArr[1] & last4byte) << 4)));
            }
            int i13 = iArr[3];
            if (i13 != 64) {
                sb2.append((char) (i13 | ((iArr[2] & last2byte) << 6)));
            }
        }
        return new String(sb2.toString().getBytes(Charset.forName("ISO8859-1")), Charset.forName(str));
    }

    public String encode(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder(((bArr.length + 2) / 3) * 4);
        int length = bArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            int i11 = i10 + 1;
            int i12 = bArr[i10] & 255;
            if (i11 == length) {
                sb2.append(this.mBase64Table[i12 >>> 2]);
                sb2.append(this.mBase64Table[(last2byte & i12) << 4]);
                sb2.append("==");
                break;
            }
            int i13 = i10 + 2;
            int i14 = bArr[i11] & 255;
            if (i13 == length) {
                sb2.append(this.mBase64Table[i12 >>> 2]);
                sb2.append(this.mBase64Table[((last2byte & i12) << 4) | (i14 >>> 4)]);
                sb2.append(this.mBase64Table[(last4byte & i14) << 2]);
                sb2.append("=");
                break;
            }
            i10 += 3;
            int i15 = bArr[i13] & 255;
            sb2.append(this.mBase64Table[i12 >>> 2]);
            sb2.append(this.mBase64Table[((i12 & last2byte) << 4) | (i14 >>> 4)]);
            sb2.append(this.mBase64Table[((i14 & last4byte) << 2) | (i15 >>> 6)]);
            sb2.append(this.mBase64Table[last6byte & i15]);
        }
        return sb2.toString();
    }

    public EncryptBase64(String str) {
        this.offset = 0;
        this.private_key = str;
        initPrivateTable();
    }

    public byte[] decode(byte[] bArr, int i10) {
        StringBuilder sb2 = new StringBuilder((i10 * 3) / 4);
        int[] iArr = new int[4];
        int i11 = 0;
        while (i11 < i10) {
            int i12 = 0;
            while (i12 < 4) {
                iArr[i12] = base64_to_256(bArr[i11]);
                i12++;
                i11++;
            }
            sb2.append((char) ((iArr[0] << 2) | (iArr[1] >>> 4)));
            int i13 = iArr[2];
            if (i13 != 64) {
                sb2.append((char) ((i13 >>> 2) | ((iArr[1] & last4byte) << 4)));
            }
            int i14 = iArr[3];
            if (i14 != 64) {
                sb2.append((char) (i14 | ((iArr[2] & last2byte) << 6)));
            }
        }
        return sb2.toString().getBytes(Charset.forName("ISO8859-1"));
    }
}
