package com.alibaba.fastjson.util;

import androidx.collection.SieveCacheKt;
import com.alibaba.fastjson.JSONException;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.NamedPipe;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
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
import java.security.AccessController;
import java.util.Arrays;
import java.util.Properties;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public class IOUtils {
    public static final char[] ASCII_CHARS = null;
    public static final char[] CA = null;
    public static final Properties DEFAULT_PROPERTIES = null;
    public static final char[] DIGITS = null;
    static final char[] DigitOnes = null;
    static final char[] DigitTens = null;
    public static final String FASTJSON_COMPATIBLEWITHFIELDNAME = "fastjson.compatibleWithFieldName";
    public static final String FASTJSON_COMPATIBLEWITHJAVABEAN = "fastjson.compatibleWithJavaBean";
    public static final String FASTJSON_PROPERTIES = "fastjson.properties";
    public static final int[] IA = null;
    public static final Charset UTF8 = null;
    static final char[] digits = null;
    public static final boolean[] firstIdentifierFlags = null;
    public static final boolean[] identifierFlags = null;
    public static final char[] replaceChars = null;
    static final int[] sizeTable = null;
    public static final byte[] specicalFlags_doubleQuotes = null;
    public static final boolean[] specicalFlags_doubleQuotesFlags = null;
    public static final byte[] specicalFlags_singleQuotes = null;
    public static final boolean[] specicalFlags_singleQuotesFlags = null;

    public IOUtils() {
    }

    public static int stringSize(long r100) {
        int r101 = 1;
        long r102 = 10;
    L4:
        if (r101 >= 19) goto L9;
        if (r100 < r102) goto L7;
        r102 = r102 * 10;
        r101 = r101 + 1;
        goto L4
    L7:
        return r101;
    L9:
        return 19;
    }

    static {
        DEFAULT_PROPERTIES = new Properties();
        UTF8 = Charset.forName("UTF-8");
        DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        firstIdentifierFlags = new boolean[256];
        identifierFlags = new boolean[256];
        char r100 = 0;
    L3:
        boolean[] r101 = firstIdentifierFlags;
        if (r100 >= r101.length) goto L18;
        if (r100 < 'A') goto L8;
        if (r100 > 'Z') goto L8;
        r101[r100] = true;
    L17:
        r100 = (char) (r100 + 1);
    L8:
        if (r100 < 'a') goto L13;
        if (r100 > 'z') goto L13;
        r101[r100] = true;
    L13:
        if (r100 != '_') goto L15;
    L16:
        r101[r100] = true;
        goto L17
    L15:
        if (r100 != '$') goto L17;
    L18:
        char r102 = 0;
    L19:
        boolean[] r103 = identifierFlags;
        if (r102 >= r103.length) goto L63;
        if (r102 < 'A') goto L24;
        if (r102 > 'Z') goto L24;
        r103[r102] = true;
    L36:
        r102 = (char) (r102 + 1);
    L24:
        if (r102 < 'a') goto L29;
        if (r102 > 'z') goto L29;
        r103[r102] = true;
    L29:
        if (r102 != '_') goto L32;
        r103[r102] = true;
        goto L36
    L32:
        if (r102 < '0') goto L36;
        if (r102 > '9') goto L36;
        r103[r102] = true;
        goto L36
    L63:
        loadPropertiesFromFile();     // Catch: Throwable -> L62
    L38:
        byte[] r104 = new byte[161];
        specicalFlags_doubleQuotes = r104;
        byte[] r105 = new byte[161];
        specicalFlags_singleQuotes = r105;
        specicalFlags_doubleQuotesFlags = new boolean[161];
        specicalFlags_singleQuotesFlags = new boolean[161];
        replaceChars = new char[93];
        r104[0] = 4;
        r104[1] = 4;
        r104[2] = 4;
        r104[3] = 4;
        r104[4] = 4;
        r104[5] = 4;
        r104[6] = 4;
        r104[7] = 4;
        r104[8] = 1;
        r104[9] = 1;
        r104[10] = 1;
        r104[11] = 4;
        r104[12] = 1;
        r104[13] = 1;
        r104[34] = 1;
        r104[92] = 1;
        r105[0] = 4;
        r105[1] = 4;
        r105[2] = 4;
        r105[3] = 4;
        r105[4] = 4;
        r105[5] = 4;
        r105[6] = 4;
        r105[7] = 4;
        r105[8] = 1;
        r105[9] = 1;
        r105[10] = 1;
        r105[11] = 4;
        r105[12] = 1;
        r105[13] = 1;
        r105[92] = 1;
        r105[39] = 1;
        int r106 = 14;
    L40:
        if (r106 > 31) goto L42;
        specicalFlags_doubleQuotes[r106] = 4;
        specicalFlags_singleQuotes[r106] = 4;
        r106 = r106 + 1;
        goto L40
    L42:
        int r107 = 127;
    L44:
        if (r107 >= 160) goto L46;
        specicalFlags_doubleQuotes[r107] = 4;
        specicalFlags_singleQuotes[r107] = 4;
        r107 = r107 + 1;
        goto L44
    L46:
        int r108 = 0;
    L47:
        if (r108 >= 161) goto L57;
        boolean[] r109 = specicalFlags_doubleQuotesFlags;
        if (specicalFlags_doubleQuotes[r108] == 0) goto L51;
        boolean r210 = true;
    L52:
        r109[r108] = r210;
        boolean[] r110 = specicalFlags_singleQuotesFlags;
        if (specicalFlags_singleQuotes[r108] == 0) goto L55;
        boolean r211 = true;
    L56:
        r110[r108] = r211;
        r108 = r108 + 1;
        goto L47
    L55:
        r211 = false;
        goto L56
    L51:
        r210 = false;
        goto L52
    L57:
        char[] r111 = replaceChars;
        r111[0] = '0';
        r111[1] = '1';
        r111[2] = '2';
        r111[3] = '3';
        r111[4] = '4';
        r111[5] = '5';
        r111[6] = '6';
        r111[7] = '7';
        r111[8] = BlockDevice.UNIX_ID;
        r111[9] = OthersPermission.STICKY_E;
        r111[10] = 'n';
        r111[11] = 'v';
        r111[12] = 'f';
        r111[13] = Permission.READ;
        r111[34] = Typography.quote;
        r111[39] = '\'';
        r111[47] = '/';
        r111[92] = '\\';
        ASCII_CHARS = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
        digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f', 'g', 'h', 'i', 'j', 'k', Symlink.UNIX_ID, 'm', 'n', 'o', NamedPipe.UNIX_ID, 'q', Permission.READ, 's', OthersPermission.STICKY_E, 'u', 'v', Permission.WRITE, Permission.EXECUTE, 'y', 'z'};
        DigitTens = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        DigitOnes = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        sizeTable = new int[]{9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        char[] r112 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = r112;
        int[] r113 = new int[256];
        IA = r113;
        Arrays.fill(r113, -1);
        int r114 = r112.length;
        int r115 = 0;
    L58:
        if (r115 >= r114) goto L60;
        IA[CA[r115]] = r115;
        r115 = r115 + 1;
        goto L58
    L60:
        IA[61] = 0;
    }

    public static void loadPropertiesFromFile() {
        InputStream r100 = (InputStream) AccessController.doPrivileged(new AnonymousClass1());
        if (r100 == null) goto L9;
        DEFAULT_PROPERTIES.load(r100);     // Catch: IOException -> L6
        r100.close();     // Catch: IOException -> L6
        return;
    L10:
        return;
    }

    public static void close(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Exception -> L5
        return;
    L9:
        return;
    }

    public static byte[] decodeBase64(String r110) {
        int r100 = r110.length();
        int r101 = 0;
        if (r100 == 0) goto L5;
        int r102 = r100 - 1;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L11;
        if (IA[r110.charAt(r103) & 255] >= 0) goto L11;
        r103 = r103 + 1;
    L11:
        if (r102 <= 0) goto L16;
        if (IA[r110.charAt(r102) & 255] >= 0) goto L16;
        r102 = r102 - 1;
    L16:
        if (r110.charAt(r102) == '=') goto L18;
        int r104 = 0;
    L22:
        int r105 = (r102 - r103) + 1;
        if (r100 > 76) goto L25;
        int r106 = 0;
    L30:
        int r107 = (((r105 - r106) * 6) >> 3) - r104;
        byte[] r108 = new byte[r107];
        int r109 = (r107 / 3) * 3;
        int r111 = 0;
        int r112 = 0;
    L31:
        if (r111 >= r109) goto L39;
        int[] r113 = IA;
        int r114 = r103 + 1;
        int r115 = r114 + 1;
        int r116 = (r113[r110.charAt(r103)] << 18) | (r113[r110.charAt(r114)] << 12);
        int r117 = r115 + 1;
        int r118 = r116 | (r113[r110.charAt(r115)] << 6);
        int r119 = r117 + 1;
        int r120 = r118 | r113[r110.charAt(r117)];
        int r121 = r111 + 1;
        r108[r111] = (byte) (r120 >> 16);
        int r122 = r121 + 1;
        r108[r121] = (byte) (r120 >> 8);
        int r123 = r122 + 1;
        r108[r122] = (byte) r120;
        if (r106 <= 0) goto L37;
        r112 = r112 + 1;
        if (r112 != 19) goto L37;
        r103 = r119 + 2;
        r112 = 0;
    L38:
        r111 = r123;
    L37:
        r103 = r119;
        goto L38
    L39:
        if (r111 >= r107) goto L47;
        int r124 = 0;
    L42:
        if (r103 > (r102 - r104)) goto L44;
        r101 = r101 | (IA[r110.charAt(r103)] << (18 - (r124 * 6)));
        r124 = r124 + 1;
        r103 = r103 + 1;
        goto L42
    L44:
        int r125 = 16;
    L45:
        if (r111 >= r107) goto L47;
        r108[r111] = (byte) (r101 >> r125);
        r125 = r125 - 8;
        r111 = r111 + 1;
    L47:
        return r108;
    L25:
        if (r110.charAt(76) != '\r') goto L27;
        int r126 = r105 / 78;
    L28:
        r106 = r126 << 1;
        goto L30
    L27:
        r126 = 0;
        goto L28
    L18:
        if (r110.charAt(r102 - 1) != '=') goto L20;
        r104 = 2;
        goto L22
    L20:
        r104 = 1;
        goto L22
    L5:
        return new byte[0];
    }

    public static boolean firstIdentifier(char r100) {
        boolean[] r101 = firstIdentifierFlags;
        if (r100 < r101.length) goto L5;
    L7:
        return false;
    L5:
        if (r101[r100] == false) goto L7;
        return true;
    }

    public static String getStringProperty(String r100) {
        String r101 = System.getProperty(r100);     // Catch: SecurityException -> L4
    L5:
        if (r101 == null) goto L7;
        return r101;
    L7:
        return DEFAULT_PROPERTIES.getProperty(r100);
    L4:
        r101 = null;
        goto L5
    }

    public static boolean isIdent(char r100) {
        boolean[] r101 = identifierFlags;
        if (r100 < r101.length) goto L5;
    L7:
        return false;
    L5:
        if (r101[r100] == false) goto L7;
        return true;
    }

    public static boolean isValidJsonpQueryParam(String r100) {
        if (r100 != null) goto L5;
    L17:
        return false;
    L5:
        if (r100.length() == 0) goto L17;
        int r101 = r100.length();
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L15;
        char r103 = r100.charAt(r102);
        if (r103 == '.') goto L14;
        if (isIdent(r103) == true) goto L14;
        return false;
    L14:
        r102 = r102 + 1;
        goto L8
    L15:
        return true;
    }

    public static String readAll(Reader r100) {
        StringBuilder r101 = new StringBuilder();
        char[] r102 = new char[2048];     // Catch: Exception -> L10
    L4:
        int r103 = r100.read(r102, 0, 2048);     // Catch: Exception -> L10
        if (r103 < 0) goto L7;
        r101.append(r102, 0, r103);     // Catch: Exception -> L10
        goto L4
    L7:
        return r101.toString();
    L10:
        e = move-exception;
        throw new JSONException("read string from reader error", e);
    }

    public static int stringSize(int r100) {
        int r101 = 0;
    L4:
        if (r100 <= sizeTable[r101]) goto L6;
        r101 = r101 + 1;
        goto L4
    L6:
        return r101 + 1;
    }

    public static void decode(CharsetDecoder r100, ByteBuffer r101, CharBuffer r102) {
        CoderResult r103 = r100.decode(r101, r102, true);     // Catch: CharacterCodingException -> L10
        if (r103.isUnderflow() == true) goto L6;
        r103.throwException();     // Catch: CharacterCodingException -> L10
    L6:
        CoderResult r104 = r100.flush(r102);     // Catch: CharacterCodingException -> L10
        if (r104.isUnderflow() == true) goto L15;
        r104.throwException();     // Catch: CharacterCodingException -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        throw new JSONException("utf8 decode error, " + e.getMessage(), e);
    }

    public static byte[] decodeBase64(String r110, int r111, int r112) {
        int r100 = 0;
        if (r112 == 0) goto L5;
        int r101 = (r111 + r112) - 1;
    L7:
        if (r111 >= r101) goto L11;
        if (IA[r110.charAt(r111)] >= 0) goto L11;
        r111 = r111 + 1;
    L11:
        if (r101 <= 0) goto L16;
        if (IA[r110.charAt(r101)] >= 0) goto L16;
        r101 = r101 - 1;
    L16:
        if (r110.charAt(r101) == '=') goto L18;
        int r102 = 0;
    L22:
        int r103 = (r101 - r111) + 1;
        if (r112 > 76) goto L25;
        int r113 = 0;
    L30:
        int r104 = (((r103 - r113) * 6) >> 3) - r102;
        byte[] r105 = new byte[r104];
        int r106 = (r104 / 3) * 3;
        int r107 = 0;
        int r108 = 0;
    L31:
        if (r107 >= r106) goto L39;
        int[] r109 = IA;
        int r114 = r111 + 1;
        int r115 = r114 + 1;
        int r116 = (r109[r110.charAt(r111)] << 18) | (r109[r110.charAt(r114)] << 12);
        int r117 = r115 + 1;
        int r118 = r116 | (r109[r110.charAt(r115)] << 6);
        int r119 = r117 + 1;
        int r120 = r118 | r109[r110.charAt(r117)];
        int r121 = r107 + 1;
        r105[r107] = (byte) (r120 >> 16);
        int r122 = r121 + 1;
        r105[r121] = (byte) (r120 >> 8);
        int r123 = r122 + 1;
        r105[r122] = (byte) r120;
        if (r113 <= 0) goto L37;
        r108 = r108 + 1;
        if (r108 != 19) goto L37;
        r111 = r119 + 2;
        r108 = 0;
    L38:
        r107 = r123;
    L37:
        r111 = r119;
        goto L38
    L39:
        if (r107 >= r104) goto L47;
        int r124 = 0;
    L42:
        if (r111 > (r101 - r102)) goto L44;
        r100 = r100 | (IA[r110.charAt(r111)] << (18 - (r124 * 6)));
        r124 = r124 + 1;
        r111 = r111 + 1;
        goto L42
    L44:
        int r125 = 16;
    L45:
        if (r107 >= r104) goto L47;
        r105[r107] = (byte) (r100 >> r125);
        r125 = r125 - 8;
        r107 = r107 + 1;
    L47:
        return r105;
    L25:
        if (r110.charAt(76) != '\r') goto L27;
        int r126 = r103 / 78;
    L28:
        r113 = r126 << 1;
        goto L30
    L27:
        r126 = 0;
        goto L28
    L18:
        if (r110.charAt(r101 - 1) != '=') goto L20;
        r102 = 2;
        goto L22
    L20:
        r102 = 1;
        goto L22
    L5:
        return new byte[0];
    }

    public static void getChars(long r100, int r101, char[] r110) {
        if (r100 >= 0) goto L5;
        r100 = -r100;
        char r102 = '-';
    L7:
        if (r100 <= SieveCacheKt.NodeLinkMask) goto L9;
        long r103 = r100 / 100;
        int r104 = (int) (r100 - (((r103 << 6) + (r103 << 5)) + (r103 << 2)));
        int r105 = r101 - 1;
        r110[r105] = DigitOnes[r104];
        r101 = r105 - 1;
        r110[r101] = DigitTens[r104];
        r100 = r103;
        goto L7
    L9:
        int r106 = (int) r100;
    L11:
        if (r106 < 65536) goto L13;
        int r107 = r106 / 100;
        int r108 = r106 - (((r107 << 6) + (r107 << 5)) + (r107 << 2));
        int r109 = r101 - 1;
        r110[r109] = DigitOnes[r108];
        r101 = r109 - 1;
        r110[r101] = DigitTens[r108];
        r106 = r107;
    L13:
        int r111 = (52429 * r106) >>> 19;
        r101 = r101 - 1;
        r110[r101] = digits[r106 - ((r111 << 3) + (r111 << 1))];
        if (r111 == 0) goto L15;
        r106 = r111;
        goto L13
    L15:
        if (r102 == 0) goto L23;
        r110[r101 - 1] = r102;
        return;
    L23:
        return;
    L5:
        r102 = 0;
        goto L7
    }

    public static byte[] decodeBase64(char[] r110, int r111, int r112) {
        int r100 = 0;
        if (r112 == 0) goto L5;
        int r101 = (r111 + r112) - 1;
    L7:
        if (r111 >= r101) goto L11;
        if (IA[r110[r111]] >= 0) goto L11;
        r111 = r111 + 1;
    L11:
        if (r101 <= 0) goto L16;
        if (IA[r110[r101]] >= 0) goto L16;
        r101 = r101 - 1;
    L16:
        if (r110[r101] == '=') goto L18;
        int r102 = 0;
    L22:
        int r103 = (r101 - r111) + 1;
        if (r112 > 76) goto L25;
        int r113 = 0;
    L30:
        int r104 = (((r103 - r113) * 6) >> 3) - r102;
        byte[] r105 = new byte[r104];
        int r106 = (r104 / 3) * 3;
        int r107 = 0;
        int r108 = 0;
    L31:
        if (r107 >= r106) goto L39;
        int[] r109 = IA;
        int r114 = r111 + 1;
        int r115 = r114 + 1;
        int r116 = (r109[r110[r111]] << 18) | (r109[r110[r114]] << 12);
        int r117 = r115 + 1;
        int r118 = r116 | (r109[r110[r115]] << 6);
        int r119 = r117 + 1;
        int r120 = r118 | r109[r110[r117]];
        int r121 = r107 + 1;
        r105[r107] = (byte) (r120 >> 16);
        int r122 = r121 + 1;
        r105[r121] = (byte) (r120 >> 8);
        int r123 = r122 + 1;
        r105[r122] = (byte) r120;
        if (r113 <= 0) goto L37;
        r108 = r108 + 1;
        if (r108 != 19) goto L37;
        r111 = r119 + 2;
        r108 = 0;
    L38:
        r107 = r123;
    L37:
        r111 = r119;
        goto L38
    L39:
        if (r107 >= r104) goto L47;
        int r124 = 0;
    L42:
        if (r111 > (r101 - r102)) goto L44;
        r100 = r100 | (IA[r110[r111]] << (18 - (r124 * 6)));
        r124 = r124 + 1;
        r111 = r111 + 1;
        goto L42
    L44:
        int r125 = 16;
    L45:
        if (r107 >= r104) goto L47;
        r105[r107] = (byte) (r100 >> r125);
        r125 = r125 - 8;
        r107 = r107 + 1;
    L47:
        return r105;
    L25:
        if (r110[76] != '\r') goto L27;
        int r126 = r103 / 78;
    L28:
        r113 = r126 << 1;
        goto L30
    L27:
        r126 = 0;
        goto L28
    L18:
        if (r110[r101 - 1] != '=') goto L20;
        r102 = 2;
        goto L22
    L20:
        r102 = 1;
        goto L22
    L5:
        return new byte[0];
    }

    public static void getChars(int r100, int r101, char[] r102) {
        if (r100 >= 0) goto L4;
        r100 = -r100;
        char r103 = '-';
    L6:
        if (r100 < 65536) goto L8;
        int r104 = r100 / 100;
        int r105 = r100 - (((r104 << 6) + (r104 << 5)) + (r104 << 2));
        int r106 = r101 - 1;
        r102[r106] = DigitOnes[r105];
        r101 = r106 - 1;
        r102[r101] = DigitTens[r105];
        r100 = r104;
    L8:
        int r107 = (52429 * r100) >>> 19;
        r101 = r101 - 1;
        r102[r101] = digits[r100 - ((r107 << 3) + (r107 << 1))];
        if (r107 == 0) goto L10;
        r100 = r107;
        goto L8
    L10:
        if (r103 == 0) goto L17;
        r102[r101 - 1] = r103;
        return;
    L17:
        return;
    L4:
        r103 = 0;
        goto L6
    }

    public static void getChars(byte r100, int r101, char[] r102) {
        if (r100 >= 0) goto L4;
        char r103 = '-';
        int r104 = -r100;
    L5:
        int r105 = (52429 * r104) >>> 19;
        r101 = r101 - 1;
        r102[r101] = digits[r104 - ((r105 << 3) + (r105 << 1))];
        if (r105 == 0) goto L7;
        r104 = r105;
        goto L5
    L7:
        if (r103 == 0) goto L13;
        r102[r101 - 1] = r103;
        return;
    L13:
        return;
    L4:
        r103 = 0;
        r104 = r100;
        goto L5
    }

    public static int decodeUTF8(byte[] r100, int r110, int r111, char[] r112) {
        int r101 = r110 + r111;
        int r113 = Math.min(r111, r112.length);
        int r102 = 0;
    L3:
        if (r102 >= r113) goto L7;
        byte r103 = r100[r110];
        if (r103 < 0) goto L7;
        r110 = r110 + 1;
        r112[r102] = (char) r103;
        r102 = r102 + 1;
    L7:
        if (r110 >= r101) goto L61;
        int r114 = r110 + 1;
        byte r115 = r100[r110];
        if (r115 >= 0) goto L10;
        if ((r115 >> 5) != (-2)) goto L22;
        if ((r115 & 30) == 0) goto L22;
        if (r114 >= r101) goto L20;
        int r104 = r114 + 1;
        byte r116 = r100[r114];
        if ((r116 & 192) != 128) goto L18;
        r112[r102] = (char) (((r115 << 6) ^ r116) ^ 3968);
        r110 = r104;
        r102 = r102 + 1;
        goto L7
    L18:
        return -1;
    L20:
        return -1;
    L22:
        if ((r115 >> 4) == (-2)) goto L23;
        if ((r115 >> 3) != (-2)) goto L60;
        if ((r114 + 2) >= r101) goto L60;
        int r105 = r114 + 1;
        byte r117 = r100[r114];
        int r106 = r105 + 1;
        byte r107 = r100[r105];
        int r108 = r106 + 1;
        byte r109 = r100[r106];
        int r118 = (((r115 << 18) ^ (r117 << 12)) ^ (r107 << 6)) ^ (3678080 ^ r109);
        if ((r117 & 192) != 128) goto L60;
        if ((r107 & 192) != 128) goto L60;
        if ((r109 & 192) != 128) goto L60;
        if (r118 < 65536) goto L60;
        if (r118 >= 1114112) goto L60;
        int r119 = r102 + 1;
        r112[r102] = (char) ((r118 >>> 10) + 55232);
        r102 = r119 + 1;
        r112[r119] = (char) ((r118 & 1023) + 56320);
        r110 = r108;
    L60:
        return -1;
    L23:
        int r120 = r114 + 1;
        if (r120 >= r101) goto L43;
        byte r121 = r100[r114];
        int r122 = r120 + 1;
        byte r123 = r100[r120];
        if (r115 != (-32)) goto L30;
        if ((r121 & 224) == 128) goto L43;
    L30:
        if ((r121 & 192) != 128) goto L43;
        if ((r123 & 192) != 128) goto L43;
        char r124 = (char) (((r115 << 12) ^ (r121 << 6)) ^ ((-123008) ^ r123));
        if (r124 >= 55296) goto L37;
    L39:
        boolean r125 = false;
    L40:
        if (r125 == true) goto L41;
        r112[r102] = r124;
        r102 = r102 + 1;
        r110 = r122;
        goto L7
    L41:
        return -1;
    L37:
        if (r124 >= 57344) goto L39;
        r125 = true;
    L43:
        return -1;
    L10:
        r112[r102] = (char) r115;
        r110 = r114;
        r102 = r102 + 1;
        goto L7
    L61:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v16, types: [int] */
    /* JADX WARN: Type inference failed for: r10v25, types: [int] */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v3, types: [char, int] */
    public static int encodeUTF8(char[] r100, int r110, int r111, byte[] r112) {
        int r101 = r110 + r111;
        int r102 = 0;
        int r113 = Math.min(r111, r112.length) + 0;
    L4:
        if (r102 >= r113) goto L8;
        char r103 = r100[r110];
        if (r103 >= 128) goto L8;
        r110 = r110 + 1;
        r112[r102] = (byte) r103;
        r102 = r102 + 1;
    L8:
        if (r110 >= r101) goto L40;
        int r114 = r110 + 1;
        char r115 = r100[r110];
        if (r115 < 128(0x80, float:1.8E-43)) goto L11;
        if (r115 < 2048(0x800, float:2.87E-42)) goto L15;
        if (r115 < 55296(0xd800, float:7.7486E-41)) goto L39;
        if (r115 >= 57344(0xe000, float:8.0356E-41)) goto L39;
        int r104 = r114 - 1;
        if (r115 < 55296(0xd800, float:7.7486E-41)) goto L31;
        if (r115 >= 56320(0xdc00, float:7.8921E-41)) goto L31;
        if ((r101 - r104) >= 2) goto L26;
        r115 = -1;
    L36:
        if (r115 >= 0) goto L38;
        int r116 = r102 + 1;
        r112[r102] = 63;
    L34:
        r102 = r116;
    L35:
        r110 = r114;
        goto L8
    L38:
        int r105 = r102 + 1;
        r112[r102] = (byte) ((r115 >> 18) | 240);
        int r106 = r105 + 1;
        r112[r105] = (byte) (((r115 >> 12) & 63) | 128);
        int r107 = r106 + 1;
        r112[r106] = (byte) ((63 & (r115 >> 6)) | 128);
        r112[r107] = (byte) ((r115 & 63) | 128);
        r114 = r114 + 1;
        r116 = r107 + 1;
        goto L34
    L26:
        char r108 = r100[r104 + 1];
        if (r108 < 56320) goto L30;
        if (r108 >= 57344) goto L30;
        r115 = ((r115 << 10) + r108) - 56613888;
    L30:
        r116 = r102 + 1;
        r112[r102] = 63;
    L31:
        if (r115 < 56320(0xdc00, float:7.8921E-41)) goto L36;
        if (r115 >= 57344(0xe000, float:8.0356E-41)) goto L36;
        r116 = r102 + 1;
        r112[r102] = 63;
    L39:
        int r109 = r102 + 1;
        r112[r102] = (byte) ((r115 >> 12) | 224);
        int r117 = r109 + 1;
        r112[r109] = (byte) ((63 & (r115 >> 6)) | 128);
        int r118 = r117 + 1;
        r112[r117] = (byte) ((r115 & 63) | 128);
    L12:
        r110 = r114;
        r102 = r118;
        goto L8
    L15:
        int r119 = r102 + 1;
        r112[r102] = (byte) ((r115 >> 6) | 192);
        r102 = r119 + 1;
        r112[r119] = (byte) ((r115 & 63) | 128);
        goto L35
    L11:
        r118 = r102 + 1;
        r112[r102] = (byte) r115;
        goto L12
    L40:
        return r102;
    }
}
