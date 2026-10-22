package com.byted.cast.common;

import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.ttvideoengine.net.DNSParser;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes39.dex */
public final class StringUtil {
    private static final String TAG = "StringUtil";
    private static String zhPattern = "[一-龥。；，：“”（）、？《》\\s+]+";

    private StringUtil() {
    }

    public static String base64(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return null;
    L8:
        return Base64.encodeToString(r100.getBytes(), 2);
    L10:
        return null;
    }

    public static String filterSpecChinese(String r100) {
        return encode(r100, "UTF-8");
    L4:
        e = move-exception;
        Logger.w(TAG, "UnsupportedEncoding:" + e);
        return r100;
    }

    public static String getNonEmptyString(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        return r100;
    }

    public static boolean hasData(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.length() > 0) goto L8;
        return false;
    L8:
        return true;
    }

    public static boolean isEmpty(String r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length() == 0) goto L7;
        return false;
    }

    public static boolean isNumeric(String r100) {
        return PatternProtector.compile("-?[0-9]*").matcher(r100).matches();
    L4:
        e = move-exception;
        Logger.e(e.getMessage());
        return false;
    }

    public static int toInteger(String r100) {
        return CastIntegerProtector.parseInt(r100);
    L4:
        e = move-exception;
        Logger.e(e.getMessage());
        return 0;
    }

    public static long toLong(String r100) {
        return CastLongProtector.parseLong(r100);
    L4:
        e = move-exception;
        Logger.e(e.getMessage());
        return 0;
    }

    public static String transMapToString(Map r100) {
        StringBuffer r101 = new StringBuffer("{");
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L24;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = r103.getKey().toString();
        if (r103.getValue() != null) goto L8;
        String r105 = "";
    L10:
        if (TextUtils.equals(DNSParser.DNS_RESULT_IP, r104) == true) goto L12;
    L18:
        r101.append(r104);
        r101.append(":");
        r101.append(r105);
        if (r102.hasNext() == false) goto L21;
        String r106 = i.f25853b;
    L22:
        r101.append(r106);
        goto L4
    L21:
        r106 = i.f25855d;
        goto L22
    L12:
        if (TextUtils.equals("overseasPlug", "internal") == false) goto L14;
    L17:
        r105 = "xxx.xxx.xxx.xxx";
        goto L18
    L14:
        if (TextUtils.equals("overseas", "internal") == true) goto L17;
        r105 = base64(r105);
        goto L18
    L8:
        r105 = r103.getValue().toString();
        goto L10
    L24:
        return r101.toString();
    }

    private static String encode(String r100, String r101) throws UnsupportedEncodingException {
        Matcher r102 = PatternProtector.compile(zhPattern).matcher(r100);
        StringBuffer r103 = new StringBuffer();
    L4:
        if (r102.find() == false) goto L6;
        r102.appendReplacement(r103, URLEncoder.encode(r102.group(0), r101));
        goto L4
    L6:
        r102.appendTail(r103);
        return r103.toString();
    }

    public static int findFirstNotOf(String r100, String r101) {
        return findOf(r100, r101, 0, r100.length() - 1, 1, false);
    }

    public static int findFirstOf(String r100, String r101) {
        return findOf(r100, r101, 0, r100.length() - 1, 1, true);
    }

    public static int findLastNotOf(String r100, String r101) {
        return findOf(r100, r101, r100.length() - 1, 0, -1, false);
    }

    public static int findLastOf(String r100, String r101) {
        return findOf(r100, r101, r100.length() - 1, 0, -1, true);
    }

    public static String trim(String r100, String r101) {
        int r102 = findFirstNotOf(r100, r101);
        if (r102 >= 0) goto L5;
        return r100;
    L5:
        String r103 = r100.substring(r102, r100.length());
        int r104 = findLastNotOf(r103, r101);
        if (r104 >= 0) goto L9;
        return r103;
    L9:
        return r103.substring(0, r104 + 1);
    }

    public static int findOf(String r100, String r101, int r102, int r103, int r110, boolean r111) {
        if (r110 != 0) goto L5;
        return -1;
    L5:
        int r104 = r101.length();
    L6:
        if (r110 <= 0) goto L9;
        if (r103 < r102) goto L10;
    L11:
        char r105 = r100.charAt(r102);
        int r106 = 0;
        int r107 = 0;
    L12:
        if (r106 >= r104) goto L22;
        char r108 = r101.charAt(r106);
        if (r111 == false) goto L17;
        if (r105 != r108) goto L21;
        return r102;
    L21:
        r106 = r106 + 1;
        goto L12
    L17:
        if (r105 == r108) goto L19;
        r107 = r107 + 1;
    L19:
        if (r107 != r104) goto L21;
        return r102;
    L22:
        r102 = r102 + r110;
    L10:
        return -1;
    L9:
        if (r102 >= r103) goto L11;
        goto L11
    }
}
