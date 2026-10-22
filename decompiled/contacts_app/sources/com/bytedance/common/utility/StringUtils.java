package com.bytedance.common.utility;

import android.text.TextUtils;
import android.util.Base64;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.util.HanziToPinyin;
import com.android.vcard.VCardConstants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class StringUtils {
    private static final int CHAR_12288 = 12288;
    private static final int CHAR_127 = 127;
    private static final int CHAR_32 = 32;
    private static final int CHAR_65248 = 65248;
    private static final int CHAR_65280 = 65280;
    private static final int CHAR_65375 = 65375;
    private static final int CHAR_MAX = 31;
    public static final String EMPTY = "";
    private static final long G = 1073741824;
    private static final long K = 1024;
    private static final long M = 1048576;
    private static final int STRING_MAX_NUM = 255;
    private static final long T = 1099511627776L;
    private static final int XOR_MASK = 5;

    private StringUtils() {
    }

    public static boolean isEmpty(String r0) {
        if (r0 != null) goto L4;
        return true;
    L4:
        if (r0.length() == 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean equal(String r1, String r2) {
        if (isEmpty(r1) == true) goto L5;
    L6:
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.equals(r2) == false) goto L10;
    L9:
        return true;
    L5:
        if (isEmpty(r2) == true) goto L9;
        goto L6
    }

    public static String ellipsize(String r5, int r6) {
        if (r5 != null) goto L5;
        return "";
    L5:
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= r5.length()) goto L18;
        char r3 = r5.charAt(r1);
        if (r3 > 0) goto L11;
    L13:
        r2 = r2 + 2;
    L14:
        if (r2 > r6) goto L15;
        r0.append(r3);
        r1 = r1 + 1;
        goto L7
    L15:
        r0.append("...");
        goto L18
    L11:
        if (r3 > 255) goto L13;
        r2 = r2 + 1;
    L18:
        return r0.toString();
    }

    public static void escapeEcmaScript(StringBuilder r8, String r9, boolean r10) {
        if (r10 == false) goto L5;
        r8.append("\"");
    L5:
        int r1 = r9.length();
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L31;
        char r4 = r9.charAt(r3);
        if (r4 != '\f') goto L10;
        r8.append("\\f");
    L30:
        r3 = r3 + 1;
        goto L6
    L10:
        if (r4 != '\r') goto L12;
        r8.append("\\r");
        goto L30
    L12:
        if (r4 == '\"') goto L27;
        if (r4 == '\\') goto L27;
        if (r4 != 8232) goto L17;
    L26:
        r8.append(String.format("\\u%04x", new Object[]{Integer.valueOf(r4)}));
        goto L30
    L17:
        if (r4 == 8233) goto L26;
        switch(r4) {
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            default: goto L20;
        };
    L23:
        r8.append("\\n");
        goto L30
    L24:
        r8.append("\\t");
        goto L30
    L25:
        r8.append("\\b");
        goto L30
    L20:
        if (r4 > 31) goto L22;
        r8.append(String.format("\\u%04x", new Object[]{Integer.valueOf(r4)}));
        goto L30
    L22:
        r8.append(r4);
    L27:
        r8.append('\\').append(r4);
        goto L30
    L31:
        if (r10 == false) goto L44;
        r8.append("\"");
        return;
    }

    public static String removeBlank(String r4) {
        if (isEmpty(r4) == false) goto L6;
        return "";
    L6:
        StringBuffer r0 = new StringBuffer();
        int r1 = 0;
    L8:
        if (r1 >= r4.length()) goto L16;
        if (r4.charAt(r1) < '0') goto L14;
        if (r4.charAt(r1) > '9') goto L14;
        r0.append(r4.charAt(r1));
    L14:
        r1 = r1 + 1;
        goto L8
    L16:
        return r0.toString();
    }

    public static HashMap<String, String> parseResponse(String r7) {
        String[] r8 = r7.substring(r7.indexOf(123) + 1, r7.lastIndexOf(125)).split(SimContactsConstants.EMAIL_SEP);
        int r1 = 0;
    L4:
        if (r1 >= r8.length) goto L6;
        r8[r1] = r8[r1].trim();
        r1 = r1 + 1;
        goto L4
    L6:
        HashMap<String, String> r2 = new HashMap();
        int r3 = 0;
    L8:
        if (r3 >= r8.length) goto L10;
        String[] r4 = r8[r3].split(SimContactsConstants.ANR_SEP, 2);
        r2.put(clean(r4[0]), clean(r4[1]));
        r3 = r3 + 1;
        goto L8
    L10:
        return r2;
    }

    public static String clean(String r2) {
        int r1 = r2.indexOf(34);
        int r0 = r2.lastIndexOf(34);
        if (r1 < 0) goto L7;
        if (r0 > r1) goto L6;
        return r2;
    L6:
        return r2.substring(r1 + 1, r0).trim();
    L7:
        return r2;
    }

    public static String getShortDateTime(String r2) {
        int r0 = r2.indexOf(45) + 1;
        int r1 = r2.lastIndexOf(58);
        if (r0 <= 0) goto L7;
        if (r1 > 0) goto L6;
        return r2;
    L6:
        return r2.substring(r0, r1);
    L7:
        return r2;
    }

    public static String toSBC(String r4) {
        char[] r5 = r4.toCharArray();
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L14;
        char r1 = r5[r0];
        if (r1 != ' ') goto L9;
        r5[r0] = 12288;
    L12:
        r0 = r0 + 1;
        goto L4
    L9:
        if (r1 >= 127) goto L12;
        if (r1 <= ' ') goto L12;
        r5[r0] = (char) (r1 + CHAR_65248);
        goto L12
    L14:
        return new String(r5);
    }

    public static String toDBC(String r3) {
        char[] r4 = r3.toCharArray();
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L18;
        if (isChinese(r4[r0]) == false) goto L16;
        char r1 = r4[r0];
        if (r1 != CHAR_12288) goto L12;
        r4[r0] = ' ';
        goto L16
    L12:
        if (r1 <= 65280) goto L16;
        if (r1 >= CHAR_65375) goto L16;
        r4[r0] = (char) (r1 - CHAR_65248);
    L16:
        r0 = r0 + 1;
        goto L4
    L18:
        return new String(r4);
    }

    public static boolean isChinese(char r1) {
        Character.UnicodeBlock r2 = Character.UnicodeBlock.of(r1);
        if (r2 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) goto L5;
        return true;
    L5:
        if (r2 != Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) goto L7;
        return true;
    L7:
        if (r2 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) goto L9;
        return true;
    L9:
        if (r2 != Character.UnicodeBlock.GENERAL_PUNCTUATION) goto L11;
        return true;
    L11:
        if (r2 != Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) goto L13;
        return true;
    L13:
        if (r2 == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) goto L23;
        return false;
    L23:
        return true;
    }

    public static String handleAdClickTrackUrl(String r4) {
        if (isEmpty(r4) == true) goto L11;
        return r4.replace("[ss_random]", String.valueOf(new Random().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
    L6:
        e = move-exception;
        e.printStackTrace();
        return r4;
    L11:
        return r4;
    }

    private static String format(long r2, long r4, String r6) {
        double r3 = r2;
        if (r4 <= 1) goto L6;
        r3 = r3 / r4;
    L6:
        return new DecimalFormat("#.##").format(r3) + HanziToPinyin.Token.SEPARATOR + r6;
    }

    public static String bytesToHuman(long r7) {
        long[] r1 = {T, G, 1048576, 1024, 1};
        String[] r2 = {"TB", "GB", "MB", "KB", VCardConstants.PARAM_ENCODING_B};
        if (r7 < 1) goto L5;
        int r3 = 0;
    L7:
        if (r3 >= 5) goto L12;
        long r4 = r1[r3];
        if (r7 >= r4) goto L16;
        r3 = r3 + 1;
        goto L7
    L16:
        return format(r7, r4, r2[r3]);
    L12:
        return null;
    L5:
        return "0 " + r2[4];
    }

    public static String mapToString(Map<String, String> r6) {
        if (r6 != null) goto L17;
        return null;
    L17:
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L16
        Iterator<String> r2 = r6.keySet().iterator();     // Catch: Exception -> L16
    L7:
        if (r2.hasNext() == false) goto L14;
        String r3 = r2.next();     // Catch: Exception -> L16
        String r4 = r6.get(r3);     // Catch: Exception -> L16
        if (isEmpty(r3) == true) goto L7;
        if (isEmpty(r4) == true) goto L7;
        r1.put(r3, r4);     // Catch: Exception -> L16
        goto L7
    L14:
        return r1.toString();
    L16:
        return null;
    }

    public static Map<String, String> stringToMap(String r4, Map<String, String> r5) {
        if (isEmpty(r4) == true) goto L18;
        if (r5 == null) goto L32;
        JSONObject r0 = new JSONObject(r4);     // Catch: Exception -> L20
        Iterator<String> r6 = r0.keys();     // Catch: Exception -> L20
    L8:
        if (r6.hasNext() == false) goto L17;
        String r1 = r6.next();     // Catch: Exception -> L20
        String r2 = r0.getString(r1);     // Catch: Exception -> L20
        if (isEmpty(r1) == true) goto L8;
        if (isEmpty(r2) == true) goto L8;
        r5.put(r1, r2);     // Catch: Exception -> L20
    L17:
        return r5;
    L32:
        return null;
    L18:
        return null;
    }

    public static String strEncode(String r1) {
        if (isEmpty(r1) == true) goto L9;
        return URLEncoder.encode(r1, "UTF-8");
    L10:
        return r1;
    L9:
        return r1;
    }

    public static String encryptWithXor(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return null;
    L6:
        byte[] r0 = r4.getBytes("UTF-8");     // Catch: Exception -> L12
        int r2 = 0;
    L8:
        if (r2 >= r0.length) goto L10;
        r0[r2] = (byte) (r0[r2] ^ 5);     // Catch: Exception -> L12
        r2 = r2 + 1;     // Catch: Exception -> L12
        goto L8
    L10:
        return DigestUtils.toHexString(r0, 0, r0.length);
    L16:
        return r4;
    }

    public static String decryptWithXor(String r4, Boolean... r5) {
    L20:
        return r4;
    L3:
        if (TextUtils.isEmpty(r4) == false) goto L7;
        return null;
    L7:
        if (r5 != null) goto L9;
    L13:
        byte[] r6 = DigestUtils.hexStringToBytes(r4);     // Catch: Exception -> L20
    L14:
        int r1 = 0;
    L16:
        if (r1 >= r6.length) goto L18;
        r6[r1] = (byte) (r6[r1] ^ 5);     // Catch: Exception -> L20
        r1 = r1 + 1;     // Catch: Exception -> L20
        goto L16
    L18:
        return new String(r6, 0, r6.length, "UTF-8");
    L9:
        if (r5.length <= 0) goto L13;
        if (r5[0].booleanValue() == false) goto L13;
        r6 = Base64.decode(r4, 0);     // Catch: Exception -> L20
        goto L14
    }

    public static String trimString(String r1) {
        if (r1 != null) goto L4;
        return r1;
    L4:
        if (r1.length() != 0) goto L7;
        return r1;
    L7:
        return r1.trim();
    }

    public static String compressWithGzip(String r5) throws IOException {
        if (isEmpty(r5) == false) goto L37;
        return null;
    L37:
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(r5.length());     // Catch: Throwable -> L14
        GZIPOutputStream r2 = new GZIPOutputStream(r0);     // Catch: Throwable -> L12
        r2.write(r5.getBytes());     // Catch: Throwable -> L10
        r2.close();     // Catch: Throwable -> L10
        byte[] r6 = r0.toByteArray();     // Catch: Throwable -> L10
        String r7 = DigestUtils.toHexString(r6, 0, r6.length);     // Catch: Throwable -> L10
        r2.close();     // Catch: Throwable -> L28
        r0.close();     // Catch: Throwable -> L28
    L9:
        return r7;
    L10:
        th = th;
    L43:
        Logger.d("Thread", th.getMessage());     // Catch: Throwable -> L22
        if (r2 != null) goto L41;
    L19:
        if (r0 == null) goto L21;
        r0.close();     // Catch: Throwable -> L29
    L21:
        return null;
    L41:
        r2.close();     // Catch: Throwable -> L29
    L22:
        th = move-exception;
        if (r2 != null) goto L39;
    L25:
        if (r0 == null) goto L27;
        r0.close();     // Catch: Throwable -> L30
    L27:
        throw th;
    L39:
        r2.close();     // Catch: Throwable -> L30
    L12:
        th = th;
        r2 = null;
    L14:
        th = th;
        r0 = null;
        r2 = null;
        goto L43
    }

    public static String decompressWithGzip(String r5) throws IOException {
        if (isEmpty(r5) == false) goto L52;
        return null;
    L52:
        ByteArrayInputStream r0 = new ByteArrayInputStream(DigestUtils.hexStringToBytes(r5));     // Catch: Throwable -> L21
        GZIPInputStream r6 = new GZIPInputStream(r0);     // Catch: Throwable -> L19
        BufferedReader r2 = new BufferedReader(new InputStreamReader(r6, "UTF-8"));     // Catch: Throwable -> L17
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L15
    L9:
        String r4 = r2.readLine();     // Catch: Throwable -> L15
        if (r4 == null) goto L12;
        r3.append(r4);     // Catch: Throwable -> L15
        goto L9
    L12:
        String r1 = r3.toString();     // Catch: Throwable -> L15
        r2.close();     // Catch: Throwable -> L39
        r6.close();     // Catch: Throwable -> L39
        r0.close();     // Catch: Throwable -> L39
    L14:
        return r1;
    L15:
        th = th;
    L50:
        Logger.d("Thread", th.getMessage());     // Catch: Throwable -> L31
        if (r2 != null) goto L44;
    L26:
        if (r6 == null) goto L28;
        r6.close();     // Catch: Throwable -> L40
    L28:
        if (r0 == null) goto L30;
        r0.close();     // Catch: Throwable -> L40
    L30:
        return null;
    L44:
        r2.close();     // Catch: Throwable -> L40
    L31:
        th = move-exception;
        if (r2 != null) goto L48;
    L34:
        if (r6 == null) goto L36;
        r6.close();     // Catch: Throwable -> L41
    L36:
        if (r0 == null) goto L38;
        r0.close();     // Catch: Throwable -> L41
    L38:
        throw th;
    L48:
        r2.close();     // Catch: Throwable -> L41
    L17:
        th = th;
        r2 = null;
    L19:
        th = th;
        r6 = null;
        r2 = null;
    L21:
        th = th;
        r6 = null;
        r0 = null;
        r2 = null;
        goto L50
    }
}
