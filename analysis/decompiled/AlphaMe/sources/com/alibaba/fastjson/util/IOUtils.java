package com.alibaba.fastjson.util;

import androidx.room.A;
import ch.qos.logback.core.CoreConstants;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.asm.Opcodes;
import com.stepos.activeview.utils.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.MalformedInputException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Properties;

/* loaded from: classes.dex */
public class IOUtils {
    public static final char[] ASCII_CHARS;
    public static final char[] CA;
    static final char[] DigitOnes;
    static final char[] DigitTens;
    public static final String FASTJSON_COMPATIBLEWITHFIELDNAME = "fastjson.compatibleWithFieldName";
    public static final String FASTJSON_COMPATIBLEWITHJAVABEAN = "fastjson.compatibleWithJavaBean";
    public static final String FASTJSON_PROPERTIES = "fastjson.properties";
    public static final int[] IA;
    static final char[] digits;
    public static final boolean[] identifierFlags;
    public static final char[] replaceChars;
    static final int[] sizeTable;
    public static final byte[] specicalFlags_doubleQuotes;
    public static final boolean[] specicalFlags_doubleQuotesFlags;
    public static final byte[] specicalFlags_singleQuotes;
    public static final boolean[] specicalFlags_singleQuotesFlags;
    public static final Properties DEFAULT_PROPERTIES = new Properties();
    public static final Charset UTF8 = Charset.forName(Constants.UTF_8_CODE);
    public static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final boolean[] firstIdentifierFlags = new boolean[256];

    static {
        char c4 = 0;
        while (true) {
            boolean[] zArr = firstIdentifierFlags;
            if (c4 >= zArr.length) {
                break;
            }
            if (c4 >= 'A' && c4 <= 'Z') {
                zArr[c4] = true;
            } else if (c4 >= 'a' && c4 <= 'z') {
                zArr[c4] = true;
            } else if (c4 == '_') {
                zArr[c4] = true;
            }
            c4 = (char) (c4 + 1);
        }
        identifierFlags = new boolean[256];
        char c5 = 0;
        while (true) {
            boolean[] zArr2 = identifierFlags;
            if (c5 < zArr2.length) {
                if (c5 >= 'A' && c5 <= 'Z') {
                    zArr2[c5] = true;
                } else if (c5 >= 'a' && c5 <= 'z') {
                    zArr2[c5] = true;
                } else if (c5 == '_') {
                    zArr2[c5] = true;
                } else if (c5 >= '0' && c5 <= '9') {
                    zArr2[c5] = true;
                }
                c5 = (char) (c5 + 1);
            } else {
                try {
                    break;
                } catch (Throwable unused) {
                }
            }
        }
        loadPropertiesFromFile();
        byte[] bArr = new byte[161];
        specicalFlags_doubleQuotes = bArr;
        byte[] bArr2 = new byte[161];
        specicalFlags_singleQuotes = bArr2;
        specicalFlags_doubleQuotesFlags = new boolean[161];
        specicalFlags_singleQuotesFlags = new boolean[161];
        replaceChars = new char[93];
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i4 = 14; i4 <= 31; i4++) {
            specicalFlags_doubleQuotes[i4] = 4;
            specicalFlags_singleQuotes[i4] = 4;
        }
        for (int i5 = 127; i5 < 160; i5++) {
            specicalFlags_doubleQuotes[i5] = 4;
            specicalFlags_singleQuotes[i5] = 4;
        }
        for (int i6 = 0; i6 < 161; i6++) {
            specicalFlags_doubleQuotesFlags[i6] = specicalFlags_doubleQuotes[i6] != 0;
            specicalFlags_singleQuotesFlags[i6] = specicalFlags_singleQuotes[i6] != 0;
        }
        char[] cArr = replaceChars;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = CoreConstants.ESCAPE_CHAR;
        ASCII_CHARS = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
        digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        DigitTens = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        DigitOnes = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        sizeTable = new int[]{9, 99, A.MAX_BIND_PARAMETER_CNT, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i7 = 0; i7 < length; i7++) {
            IA[CA[i7]] = i7;
        }
        IA[61] = 0;
    }

    public static void close(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void decode(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer) throws CharacterCodingException {
        try {
            CoderResult coderResultDecode = charsetDecoder.decode(byteBuffer, charBuffer, true);
            if (!coderResultDecode.isUnderflow()) {
                coderResultDecode.throwException();
            }
            CoderResult coderResultFlush = charsetDecoder.flush(charBuffer);
            if (coderResultFlush.isUnderflow()) {
                return;
            }
            coderResultFlush.throwException();
        } catch (CharacterCodingException e4) {
            throw new JSONException("utf8 decode error, " + e4.getMessage(), e4);
        }
    }

    public static byte[] decodeBase64(char[] cArr, int i4, int i5) {
        int i6;
        int i7 = 0;
        if (i5 == 0) {
            return new byte[0];
        }
        int i8 = (i4 + i5) - 1;
        int i9 = i4;
        while (i9 < i8 && IA[cArr[i9]] < 0) {
            i9++;
        }
        while (i8 > 0 && IA[cArr[i8]] < 0) {
            i8--;
        }
        int i10 = cArr[i8] == '=' ? cArr[i8 + (-1)] == '=' ? 2 : 1 : 0;
        int i11 = (i8 - i9) + 1;
        if (i5 > 76) {
            i6 = (cArr[76] == '\r' ? i11 / 78 : 0) << 1;
        } else {
            i6 = 0;
        }
        int i12 = (((i11 - i6) * 6) >> 3) - i10;
        byte[] bArr = new byte[i12];
        int i13 = (i12 / 3) * 3;
        int i14 = 0;
        int i15 = 0;
        while (i14 < i13) {
            int[] iArr = IA;
            int i16 = i9 + 4;
            int i17 = iArr[cArr[i9 + 3]] | (iArr[cArr[i9 + 1]] << 12) | (iArr[cArr[i9]] << 18) | (iArr[cArr[i9 + 2]] << 6);
            bArr[i14] = (byte) (i17 >> 16);
            int i18 = i14 + 2;
            bArr[i14 + 1] = (byte) (i17 >> 8);
            i14 += 3;
            bArr[i18] = (byte) i17;
            if (i6 <= 0 || (i15 = i15 + 1) != 19) {
                i9 = i16;
            } else {
                i9 += 6;
                i15 = 0;
            }
        }
        if (i14 < i12) {
            int i19 = 0;
            while (i9 <= i8 - i10) {
                i7 |= IA[cArr[i9]] << (18 - (i19 * 6));
                i19++;
                i9++;
            }
            int i20 = 16;
            while (i14 < i12) {
                bArr[i14] = (byte) (i7 >> i20);
                i20 -= 8;
                i14++;
            }
        }
        return bArr;
    }

    public static int decodeUTF8(byte[] bArr, int i4, int i5, char[] cArr) {
        int i6 = i4 + i5;
        int iMin = Math.min(i5, cArr.length);
        int i7 = 0;
        while (i7 < iMin) {
            byte b4 = bArr[i4];
            if (b4 < 0) {
                break;
            }
            i4++;
            cArr[i7] = (char) b4;
            i7++;
        }
        while (i4 < i6) {
            int i8 = i4 + 1;
            byte b5 = bArr[i4];
            if (b5 >= 0) {
                cArr[i7] = (char) b5;
                i7++;
                i4 = i8;
            } else {
                if ((b5 >> 5) != -2 || (b5 & 30) == 0) {
                    if ((b5 >> 4) == -2) {
                        int i9 = i4 + 2;
                        if (i9 < i6) {
                            byte b6 = bArr[i8];
                            i4 += 3;
                            byte b7 = bArr[i9];
                            if ((b5 != -32 || (b6 & 224) != 128) && (b6 & 192) == 128 && (b7 & 192) == 128) {
                                char c4 = (char) (((b6 << 6) ^ (b5 << 12)) ^ ((-123008) ^ b7));
                                if (c4 >= 55296 && c4 < 57344) {
                                    return -1;
                                }
                                cArr[i7] = c4;
                                i7++;
                            }
                        }
                        return -1;
                    }
                    if ((b5 >> 3) == -2 && i4 + 3 < i6) {
                        byte b8 = bArr[i8];
                        int i10 = i4 + 3;
                        byte b9 = bArr[i4 + 2];
                        i4 += 4;
                        byte b10 = bArr[i10];
                        int i11 = (((b5 << 18) ^ (b8 << 12)) ^ (b9 << 6)) ^ (3678080 ^ b10);
                        if ((b8 & 192) == 128 && (b9 & 192) == 128 && (b10 & 192) == 128 && Character.isSupplementaryCodePoint(i11)) {
                            int i12 = i7 + 1;
                            cArr[i7] = (char) ((i11 >>> 10) + 55232);
                            i7 += 2;
                            cArr[i12] = (char) ((i11 & 1023) + 56320);
                        }
                    }
                    return -1;
                }
                if (i8 >= i6) {
                    return -1;
                }
                i4 += 2;
                byte b11 = bArr[i8];
                if ((b11 & 192) != 128) {
                    return -1;
                }
                cArr[i7] = (char) ((b11 ^ (b5 << 6)) ^ 3968);
                i7++;
            }
        }
        return i7;
    }

    public static int encodeUTF8(char[] cArr, int i4, int i5, byte[] bArr) {
        int codePoint;
        int i6;
        char c4;
        int i7 = i4 + i5;
        int iMin = Math.min(i5, bArr.length);
        int i8 = 0;
        while (i8 < iMin && (c4 = cArr[i4]) < 128) {
            i4++;
            bArr[i8] = (byte) c4;
            i8++;
        }
        while (i4 < i7) {
            int i9 = i4 + 1;
            char c5 = cArr[i4];
            if (c5 < 128) {
                i6 = i8 + 1;
                bArr[i8] = (byte) c5;
            } else {
                if (c5 < 2048) {
                    int i10 = i8 + 1;
                    bArr[i8] = (byte) ((c5 >> 6) | Opcodes.CHECKCAST);
                    i8 += 2;
                    bArr[i10] = (byte) ((c5 & '?') | 128);
                } else if (c5 < 55296 || c5 >= 57344) {
                    bArr[i8] = (byte) ((c5 >> '\f') | 224);
                    int i11 = i8 + 2;
                    bArr[i8 + 1] = (byte) ((63 & (c5 >> 6)) | 128);
                    i8 += 3;
                    bArr[i11] = (byte) ((c5 & '?') | 128);
                } else {
                    if (!Character.isHighSurrogate(c5)) {
                        boolean zIsLowSurrogate = Character.isLowSurrogate(c5);
                        codePoint = c5;
                        if (zIsLowSurrogate) {
                            throw new JSONException("encodeUTF8 error", new MalformedInputException(1));
                        }
                    } else if (i7 - i4 < 2) {
                        codePoint = -1;
                    } else {
                        char c6 = cArr[i4 + 1];
                        if (!Character.isLowSurrogate(c6)) {
                            throw new JSONException("encodeUTF8 error", new MalformedInputException(1));
                        }
                        codePoint = Character.toCodePoint(c5, c6);
                    }
                    if (codePoint < 0) {
                        i6 = i8 + 1;
                        bArr[i8] = 63;
                    } else {
                        bArr[i8] = (byte) ((codePoint >> 18) | 240);
                        bArr[i8 + 1] = (byte) (((codePoint >> 12) & 63) | 128);
                        bArr[i8 + 2] = (byte) ((63 & (codePoint >> 6)) | 128);
                        bArr[i8 + 3] = (byte) ((codePoint & 63) | 128);
                        i9 = i4 + 2;
                        i6 = i8 + 4;
                    }
                }
                i4 = i9;
            }
            i8 = i6;
            i4 = i9;
        }
        return i8;
    }

    public static boolean firstIdentifier(char c4) {
        boolean[] zArr = firstIdentifierFlags;
        return c4 < zArr.length && zArr[c4];
    }

    public static void getChars(long j4, int i4, char[] cArr) {
        char c4;
        if (j4 < 0) {
            j4 = -j4;
            c4 = CoreConstants.DASH_CHAR;
        } else {
            c4 = 0;
        }
        while (j4 > 2147483647L) {
            long j5 = j4 / 100;
            int i5 = (int) (j4 - (((j5 << 6) + (j5 << 5)) + (j5 << 2)));
            cArr[i4 - 1] = DigitOnes[i5];
            i4 -= 2;
            cArr[i4] = DigitTens[i5];
            j4 = j5;
        }
        int i6 = (int) j4;
        while (i6 >= 65536) {
            int i7 = i6 / 100;
            int i8 = i6 - (((i7 << 6) + (i7 << 5)) + (i7 << 2));
            cArr[i4 - 1] = DigitOnes[i8];
            i4 -= 2;
            cArr[i4] = DigitTens[i8];
            i6 = i7;
        }
        while (true) {
            int i9 = (52429 * i6) >>> 19;
            int i10 = i4 - 1;
            cArr[i10] = digits[i6 - ((i9 << 3) + (i9 << 1))];
            if (i9 == 0) {
                break;
            }
            i6 = i9;
            i4 = i10;
        }
        if (c4 != 0) {
            cArr[i4 - 2] = c4;
        }
    }

    public static String getStringProperty(String str) {
        String property;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        return property == null ? DEFAULT_PROPERTIES.getProperty(str) : property;
    }

    public static boolean isIdent(char c4) {
        boolean[] zArr = identifierFlags;
        return c4 < zArr.length && zArr[c4];
    }

    public static boolean isValidJsonpQueryParam(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char cCharAt = str.charAt(i4);
            if (cCharAt != '.' && !isIdent(cCharAt)) {
                return false;
            }
        }
        return true;
    }

    public static void loadPropertiesFromFile() throws IOException {
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>() { // from class: com.alibaba.fastjson.util.IOUtils.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public InputStream run() {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                return contextClassLoader != null ? contextClassLoader.getResourceAsStream(IOUtils.FASTJSON_PROPERTIES) : ClassLoader.getSystemResourceAsStream(IOUtils.FASTJSON_PROPERTIES);
            }
        });
        if (inputStream != null) {
            try {
                DEFAULT_PROPERTIES.load(inputStream);
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String readAll(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            char[] cArr = new char[2048];
            while (true) {
                int i4 = reader.read(cArr, 0, 2048);
                if (i4 < 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, i4);
            }
        } catch (Exception e4) {
            throw new JSONException("read string from reader error", e4);
        }
    }

    public static int stringSize(long j4) {
        long j5 = 10;
        for (int i4 = 1; i4 < 19; i4++) {
            if (j4 < j5) {
                return i4;
            }
            j5 *= 10;
        }
        return 19;
    }

    public static int stringSize(int i4) {
        int i5 = 0;
        while (i4 > sizeTable[i5]) {
            i5++;
        }
        return i5 + 1;
    }

    public static void getChars(int i4, int i5, char[] cArr) {
        char c4;
        if (i4 < 0) {
            i4 = -i4;
            c4 = CoreConstants.DASH_CHAR;
        } else {
            c4 = 0;
        }
        while (i4 >= 65536) {
            int i6 = i4 / 100;
            int i7 = i4 - (((i6 << 6) + (i6 << 5)) + (i6 << 2));
            cArr[i5 - 1] = DigitOnes[i7];
            i5 -= 2;
            cArr[i5] = DigitTens[i7];
            i4 = i6;
        }
        while (true) {
            int i8 = (52429 * i4) >>> 19;
            int i9 = i5 - 1;
            cArr[i9] = digits[i4 - ((i8 << 3) + (i8 << 1))];
            if (i8 == 0) {
                break;
            }
            i4 = i8;
            i5 = i9;
        }
        if (c4 != 0) {
            cArr[i5 - 2] = c4;
        }
    }

    public static byte[] decodeBase64(String str, int i4, int i5) {
        int i6;
        if (i5 == 0) {
            return new byte[0];
        }
        int i7 = (i4 + i5) - 1;
        int i8 = i4;
        while (i8 < i7 && IA[str.charAt(i8)] < 0) {
            i8++;
        }
        while (i7 > 0 && IA[str.charAt(i7)] < 0) {
            i7--;
        }
        int i9 = str.charAt(i7) == '=' ? str.charAt(i7 + (-1)) == '=' ? 2 : 1 : 0;
        int i10 = (i7 - i8) + 1;
        if (i5 > 76) {
            i6 = (str.charAt(76) == '\r' ? i10 / 78 : 0) << 1;
        } else {
            i6 = 0;
        }
        int i11 = (((i10 - i6) * 6) >> 3) - i9;
        byte[] bArr = new byte[i11];
        int i12 = (i11 / 3) * 3;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i12) {
            int[] iArr = IA;
            int i15 = i8 + 4;
            int i16 = iArr[str.charAt(i8 + 3)] | (iArr[str.charAt(i8 + 1)] << 12) | (iArr[str.charAt(i8)] << 18) | (iArr[str.charAt(i8 + 2)] << 6);
            bArr[i13] = (byte) (i16 >> 16);
            int i17 = i13 + 2;
            bArr[i13 + 1] = (byte) (i16 >> 8);
            i13 += 3;
            bArr[i17] = (byte) i16;
            if (i6 <= 0 || (i14 = i14 + 1) != 19) {
                i8 = i15;
            } else {
                i8 += 6;
                i14 = 0;
            }
        }
        if (i13 < i11) {
            int i18 = 0;
            int i19 = 0;
            while (i8 <= i7 - i9) {
                i18 |= IA[str.charAt(i8)] << (18 - (i19 * 6));
                i19++;
                i8++;
            }
            int i20 = 16;
            while (i13 < i11) {
                bArr[i13] = (byte) (i18 >> i20);
                i20 -= 8;
                i13++;
            }
        }
        return bArr;
    }

    public static void getChars(byte b4, int i4, char[] cArr) {
        char c4;
        int i5;
        if (b4 < 0) {
            c4 = CoreConstants.DASH_CHAR;
            i5 = -b4;
        } else {
            c4 = 0;
            i5 = b4;
        }
        while (true) {
            int i6 = (52429 * i5) >>> 19;
            int i7 = i4 - 1;
            cArr[i7] = digits[i5 - ((i6 << 3) + (i6 << 1))];
            if (i6 == 0) {
                break;
            }
            i5 = i6;
            i4 = i7;
        }
        if (c4 != 0) {
            cArr[i4 - 2] = c4;
        }
    }

    public static byte[] decodeBase64(String str) {
        int i4;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i5 = length - 1;
        int i6 = 0;
        while (i6 < i5 && IA[str.charAt(i6) & 255] < 0) {
            i6++;
        }
        while (i5 > 0 && IA[str.charAt(i5) & 255] < 0) {
            i5--;
        }
        int i7 = str.charAt(i5) == '=' ? str.charAt(i5 + (-1)) == '=' ? 2 : 1 : 0;
        int i8 = (i5 - i6) + 1;
        if (length > 76) {
            i4 = (str.charAt(76) == '\r' ? i8 / 78 : 0) << 1;
        } else {
            i4 = 0;
        }
        int i9 = (((i8 - i4) * 6) >> 3) - i7;
        byte[] bArr = new byte[i9];
        int i10 = (i9 / 3) * 3;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            int[] iArr = IA;
            int i13 = i6 + 4;
            int i14 = iArr[str.charAt(i6 + 3)] | (iArr[str.charAt(i6 + 1)] << 12) | (iArr[str.charAt(i6)] << 18) | (iArr[str.charAt(i6 + 2)] << 6);
            bArr[i11] = (byte) (i14 >> 16);
            int i15 = i11 + 2;
            bArr[i11 + 1] = (byte) (i14 >> 8);
            i11 += 3;
            bArr[i15] = (byte) i14;
            if (i4 <= 0 || (i12 = i12 + 1) != 19) {
                i6 = i13;
            } else {
                i6 += 6;
                i12 = 0;
            }
        }
        if (i11 < i9) {
            int i16 = 0;
            int i17 = 0;
            while (i6 <= i5 - i7) {
                i16 |= IA[str.charAt(i6)] << (18 - (i17 * 6));
                i17++;
                i6++;
            }
            int i18 = 16;
            while (i11 < i9) {
                bArr[i11] = (byte) (i16 >> i18);
                i18 -= 8;
                i11++;
            }
        }
        return bArr;
    }
}
