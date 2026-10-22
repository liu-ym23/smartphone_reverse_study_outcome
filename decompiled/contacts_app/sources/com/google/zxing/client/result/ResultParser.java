package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class ResultParser {
    private static final Pattern AMPERSAND = null;
    private static final String BYTE_ORDER_MARK = "\ufeff";
    private static final Pattern DIGITS = null;
    private static final Pattern EQUALS = null;
    private static final ResultParser[] PARSERS = null;

    protected static String[] maybeWrap(String r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new String[]{r2};
    }

    protected static int parseHexDigit(char r2) {
        if (r2 >= '0') goto L5;
    L8:
        char r0 = 'a';
        if (r2 >= 'a') goto L11;
    L14:
        r0 = 'A';
        if (r2 >= 'A') goto L17;
        return -1;
    L17:
        if (r2 <= 'F') goto L13;
        return -1;
    L13:
        return (r2 - r0) + 10;
    L11:
        if (r2 > 'f') goto L14;
    L5:
        if (r2 > '9') goto L8;
        return r2 - '0';
    }

    public abstract ParsedResult parse(Result r1);

    public ResultParser() {
    }

    static {
        PARSERS = new ResultParser[]{new BookmarkDoCoMoResultParser(), new AddressBookDoCoMoResultParser(), new EmailDoCoMoResultParser(), new AddressBookAUResultParser(), new VCardResultParser(), new BizcardResultParser(), new VEventResultParser(), new EmailAddressResultParser(), new SMTPResultParser(), new TelResultParser(), new SMSMMSResultParser(), new SMSTOMMSTOResultParser(), new GeoResultParser(), new WifiResultParser(), new URLTOResultParser(), new URIResultParser(), new ISBNResultParser(), new ProductResultParser(), new ExpandedProductResultParser(), new VINResultParser()};
        DIGITS = Pattern.compile("\\d+");
        AMPERSAND = Pattern.compile("&");
        EQUALS = Pattern.compile("=");
    }

    protected static String getMassagedText(Result r1) {
        String r2 = r1.getText();
        if (r2.startsWith(BYTE_ORDER_MARK) == true) goto L5;
        return r2;
    L5:
        return r2.substring(1);
    }

    public static ParsedResult parseResult(Result r4) {
        ResultParser[] r0 = PARSERS;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        ParsedResult r3 = r0[r2].parse(r4);
        if (r3 != null) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        return new TextParsedResult(r4.getText(), null);
    }

    protected static void maybeAppend(String r1, StringBuilder r2) {
        if (r1 == null) goto L5;
        r2.append('\n');
        r2.append(r1);
        return;
    }

    protected static void maybeAppend(String[] r4, StringBuilder r5) {
        if (r4 == null) goto L6;
        int r0 = r4.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L8;
        String r2 = r4[r1];
        r5.append('\n');
        r5.append(r2);
        r1 = r1 + 1;
        goto L4
    L8:
        return;
    }

    protected static String unescapeBackslash(String r7) {
        int r1 = r7.indexOf(92);
        if (r1 >= 0) goto L5;
        return r7;
    L5:
        int r2 = r7.length();
        StringBuilder r3 = new StringBuilder(r2 - 1);
        r3.append(r7.toCharArray(), 0, r1);
        boolean r4 = false;
    L6:
        if (r1 >= r2) goto L15;
        char r6 = r7.charAt(r1);
        if (r4 == true) goto L12;
        if (r6 != '\\') goto L12;
        r4 = true;
    L13:
        r1 = r1 + 1;
    L12:
        r3.append(r6);
        r4 = false;
        goto L13
    L15:
        return r3.toString();
    }

    protected static boolean isStringOfDigits(CharSequence r1, int r2) {
        if (r1 == null) goto L10;
        if (r2 > 0) goto L5;
        return false;
    L5:
        if (r2 == r1.length()) goto L7;
        return false;
    L7:
        if (DIGITS.matcher(r1).matches() == false) goto L14;
        return true;
    L14:
        return false;
    L10:
        return false;
    }

    protected static boolean isSubstringOfDigits(CharSequence r2, int r3, int r4) {
        if (r2 == null) goto L12;
        if (r4 <= 0) goto L12;
        int r5 = r4 + r3;
        if (r2.length() < r5) goto L12;
        if (DIGITS.matcher(r2.subSequence(r3, r5)).matches() == false) goto L12;
        return true;
    L12:
        return false;
    }

    static Map<String, String> parseNameValuePairs(String r4) {
        int r0 = r4.indexOf(63);
        if (r0 >= 0) goto L6;
        return null;
    L6:
        HashMap r1 = new HashMap(3);
        String[] r5 = AMPERSAND.split(r4.substring(r0 + 1));
        int r2 = r5.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        appendKeyValue(r5[r3], r1);
        r3 = r3 + 1;
        goto L7
    L9:
        return r1;
    }

    private static void appendKeyValue(CharSequence r2, Map<String, String> r3) {
        String[] r4 = EQUALS.split(r2, 2);
        if (r4.length != 2) goto L10;
        String r0 = r4[0];
        r3.put(r0, urlDecode(r4[1]));     // Catch: IllegalArgumentException -> L7
        return;
    L11:
        return;
    }

    static String urlDecode(String r1) {
        return URLDecoder.decode(r1, "UTF-8");
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    static String[] matchPrefixedField(String r8, String r9, char r10, boolean r11) {
        int r0 = r9.length();
        ArrayList r4 = null;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L25;
        int r5 = r9.indexOf(r8, r3);
        if (r5 < 0) goto L25;
        int r6 = r5 + r8.length();
        boolean r7 = true;
        ArrayList r12 = r4;
        int r13 = r6;
    L7:
        if (r7 == false) goto L24;
        int r14 = r9.indexOf(r10, r13);
        if (r14 < 0) goto L10;
        if ((countPrecedingBackslashes(r9, r14) % 2) == 0) goto L15;
        r13 = r14 + 1;
        goto L7
    L15:
        if (r12 != null) goto L17;
        r12 = new ArrayList(3);
    L17:
        String r15 = unescapeBackslash(r9.substring(r6, r14));
        if (r11 == false) goto L21;
        r15 = r15.trim();
    L21:
        if (r15.isEmpty() == true) goto L23;
        r12.add(r15);
    L23:
        r13 = r14 + 1;
    L11:
        r7 = false;
        goto L7
    L10:
        r13 = r9.length();
        goto L11
    L24:
        r3 = r13;
        r4 = r12;
    L25:
        if (r4 != null) goto L27;
    L31:
        return null;
    L27:
        if (r4.isEmpty() == true) goto L31;
        return (String[]) r4.toArray(new String[r4.size()]);
    }

    private static int countPrecedingBackslashes(CharSequence r3, int r4) {
        int r5 = r4 - 1;
        int r0 = 0;
    L3:
        if (r5 < 0) goto L7;
        if (r3.charAt(r5) != '\\') goto L7;
        r0 = r0 + 1;
        r5 = r5 - 1;
    L7:
        return r0;
    }

    static String matchSinglePrefixedField(String r0, String r1, char r2, boolean r3) {
        String[] r4 = matchPrefixedField(r0, r1, r2, r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4[0];
    }
}
