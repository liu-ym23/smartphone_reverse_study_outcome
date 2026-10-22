package com.google.zxing.client.result;

import com.android.contacts.common.SimContactsConstants;
import com.android.vcard.VCardConstants;
import com.google.zxing.Result;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class VCardResultParser extends ResultParser {
    private static final Pattern BEGIN_VCARD = null;
    private static final Pattern COMMA = null;
    private static final Pattern CR_LF_SPACE_TAB = null;
    private static final Pattern EQUALS = null;
    private static final Pattern NEWLINE_ESCAPE = null;
    private static final Pattern SEMICOLON = null;
    private static final Pattern SEMICOLON_OR_COMMA = null;
    private static final Pattern UNESCAPED_SEMICOLONS = null;
    private static final Pattern VCARD_ESCAPES = null;
    private static final Pattern VCARD_LIKE_DATE = null;

    public VCardResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    static {
        BEGIN_VCARD = Pattern.compile("BEGIN:VCARD", 2);
        VCARD_LIKE_DATE = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");
        CR_LF_SPACE_TAB = Pattern.compile("\r\n[ \t]");
        NEWLINE_ESCAPE = Pattern.compile("\\\\[nN]");
        VCARD_ESCAPES = Pattern.compile("\\\\([,;\\\\])");
        EQUALS = Pattern.compile("=");
        SEMICOLON = Pattern.compile(";");
        UNESCAPED_SEMICOLONS = Pattern.compile("(?<!\\\\);+");
        COMMA = Pattern.compile(SimContactsConstants.EMAIL_SEP);
        SEMICOLON_OR_COMMA = Pattern.compile("[;,]");
    }

    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result r24) {
        String r0 = getMassagedText(r24);
        Matcher r1 = BEGIN_VCARD.matcher(r0);
        if (r1.find() == true) goto L5;
    L31:
        return null;
    L5:
        if (r1.start() != 0) goto L31;
        List<List<String>> r2 = matchVCardPrefixedField(VCardConstants.PROPERTY_FN, r0, true, false);
        if (r2 != null) goto L10;
        r2 = matchVCardPrefixedField("N", r0, true, false);
        formatNames(r2);
    L10:
        List<String> r5 = matchSingleVCardPrefixedField(VCardConstants.PROPERTY_NICKNAME, r0, true, false);
        if (r5 != null) goto L13;
        String[] r8 = null;
    L14:
        List<List<String>> r6 = matchVCardPrefixedField(VCardConstants.PROPERTY_TEL, r0, true, false);
        List<List<String>> r13 = matchVCardPrefixedField(VCardConstants.PROPERTY_EMAIL, r0, true, false);
        List<String> r15 = matchSingleVCardPrefixedField(VCardConstants.PROPERTY_NOTE, r0, false, false);
        List<List<String>> r17 = matchVCardPrefixedField(VCardConstants.PROPERTY_ADR, r0, true, true);
        List<String> r18 = matchSingleVCardPrefixedField(VCardConstants.PROPERTY_ORG, r0, true, true);
        List<String> r7 = matchSingleVCardPrefixedField(VCardConstants.PROPERTY_BDAY, r0, true, false);
        if (r7 != null) goto L17;
    L19:
        List<String> r19 = r7;
    L20:
        List<String> r20 = matchSingleVCardPrefixedField(VCardConstants.PROPERTY_TITLE, r0, true, false);
        List<List<String>> r21 = matchVCardPrefixedField(VCardConstants.PROPERTY_URL, r0, true, false);
        List<String> r14 = matchSingleVCardPrefixedField(VCardConstants.PROPERTY_IMPP, r0, true, false);
        List<String> r3 = matchSingleVCardPrefixedField("GEO", r0, true, false);
        if (r3 != null) goto L23;
        String[] r4 = null;
    L24:
        if (r4 != null) goto L26;
    L28:
        String[] r22 = r4;
    L30:
        return new AddressBookParsedResult(toPrimaryValues(r2), r8, null, toPrimaryValues(r6), toTypes(r6), toPrimaryValues(r13), toTypes(r13), toPrimaryValue(r14), toPrimaryValue(r15), toPrimaryValues(r17), toTypes(r17), toPrimaryValue(r18), toPrimaryValue(r19), toPrimaryValue(r20), toPrimaryValues(r21), r22);
    L26:
        if (r4.length == 2) goto L28;
        r22 = null;
        goto L30
    L23:
        r4 = SEMICOLON_OR_COMMA.split(r3.get(0));
        goto L24
    L17:
        if (isLikeVCardDate(r7.get(0)) == true) goto L19;
        r19 = null;
        goto L20
    L13:
        r8 = COMMA.split(r5.get(0));
        goto L14
    }

    static List<List<String>> matchVCardPrefixedField(CharSequence r16, String r17, boolean r18, boolean r19) {
        int r1 = r17.length();
        int r3 = 0;
        int r4 = 0;
        ArrayList r5 = null;
    L3:
        if (r4 >= r1) goto L72;
        Matcher r6 = Pattern.compile("(?:^|\n)" + r16 + "(?:;([^:]*))?:", 2).matcher(r17);
        if (r4 <= 0) goto L8;
        r4 = r4 - 1;
    L8:
        if (r6.find(r4) == false) goto L72;
        int r7 = r6.end(r3);
        String r8 = r6.group(1);
        if (r8 == null) goto L27;
        String[] r9 = SEMICOLON.split(r8);
        int r10 = r9.length;
        int r11 = r3;
        int r13 = r11;
        ArrayList r12 = null;
        String r14 = null;
    L12:
        if (r11 >= r10) goto L28;
        String r15 = r9[r11];
        if (r12 != null) goto L16;
        r12 = new ArrayList(1);
    L16:
        r12.add(r15);
        String[] r2 = EQUALS.split(r15, 2);
        if (r2.length <= 1) goto L26;
        String r110 = r2[r3];
        String r20 = r2[1];
        if (VCardConstants.PARAM_ENCODING.equalsIgnoreCase(r110) == false) goto L24;
        if (VCardConstants.PARAM_ENCODING_QP.equalsIgnoreCase(r20) == false) goto L24;
        r13 = 1;
    L24:
        if (VCardConstants.PARAM_CHARSET.equalsIgnoreCase(r110) == false) goto L26;
        r14 = r20;
    L26:
        r11 = r11 + 1;
        r3 = 0;
    L28:
        int r21 = r7;
    L29:
        int r22 = r17.indexOf(10, r21);
        if (r22 < 0) goto L47;
        if (r22 >= (r17.length() - 1)) goto L38;
        int r23 = r22 + 1;
        if (r17.charAt(r23) == ' ') goto L37;
        if (r17.charAt(r23) != '\t') goto L38;
    L37:
        r21 = r22 + 2;
    L38:
        if (r13 == 0) goto L47;
        if (r22 > 0) goto L42;
    L43:
        if (r22 < 2) goto L47;
        if (r17.charAt(r22 - 2) != '=') goto L47;
    L46:
        r21 = r22 + 1;
        goto L29
    L42:
        if (r17.charAt(r22 - 1) == '=') goto L46;
    L47:
        if (r22 < 0) goto L48;
        if (r22 <= r7) goto L70;
        if (r5 != null) goto L52;
        r5 = new ArrayList(1);
    L52:
        if (r22 > 0) goto L54;
    L56:
        String r24 = r17.substring(r7, r22);
        if (r18 == false) goto L60;
        r24 = r24.trim();
    L60:
        if (r13 == 0) goto L64;
        String r25 = decodeQuotedPrintable(r24, r14);
        if (r19 == false) goto L67;
        r25 = UNESCAPED_SEMICOLONS.matcher(r25).replaceAll("\n").trim();
    L67:
        if (r12 != null) goto L69;
        ArrayList r26 = new ArrayList(1);
        r26.add(r25);
        r5.add(r26);
        goto L70
    L69:
        int r27 = 0;
        r12.add(0, r25);
        r5.add(r12);
    L71:
        r3 = r27;
        r4 = r22 + 1;
        goto L3
    L64:
        if (r19 == false) goto L66;
        r24 = UNESCAPED_SEMICOLONS.matcher(r24).replaceAll("\n").trim();
    L66:
        r25 = VCARD_ESCAPES.matcher(NEWLINE_ESCAPE.matcher(CR_LF_SPACE_TAB.matcher(r24).replaceAll("")).replaceAll("\n")).replaceAll("$1");
        goto L67
    L54:
        if (r17.charAt(r22 - 1) != '\r') goto L56;
        r22 = r22 - 1;
    L70:
        r27 = 0;
        goto L71
    L48:
        r4 = r1;
        r3 = 0;
        goto L3
    L27:
        r12 = null;
        r13 = 0;
        r14 = null;
    L72:
        return r5;
    }

    private static String decodeQuotedPrintable(CharSequence r8, String r9) {
        int r0 = r8.length();
        StringBuilder r1 = new StringBuilder(r0);
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L21;
        char r4 = r8.charAt(r3);
        if (r4 == '\n') goto L20;
        if (r4 == '\r') goto L20;
        if (r4 == '=') goto L12;
        maybeAppendFragment(r2, r9, r1);
        r1.append(r4);
        goto L20
    L12:
        if (r3 >= (r0 - 2)) goto L20;
        char r5 = r8.charAt(r3 + 1);
        if (r5 == '\r') goto L20;
        if (r5 == '\n') goto L20;
        r3 = r3 + 2;
        char r6 = r8.charAt(r3);
        int r7 = parseHexDigit(r5);
        int r10 = parseHexDigit(r6);
        if (r7 < 0) goto L20;
        if (r10 < 0) goto L20;
        r2.write((r7 << 4) + r10);
    L20:
        r3 = r3 + 1;
        goto L3
    L21:
        maybeAppendFragment(r2, r9, r1);
        return r1.toString();
    }

    private static void maybeAppendFragment(ByteArrayOutputStream r3, String r4, StringBuilder r5) {
        if (r3.size() <= 0) goto L14;
        byte[] r0 = r3.toByteArray();
        if (r4 != null) goto L12;
        String r6 = new String(r0, Charset.forName("UTF-8"));
    L10:
        r3.reset();
        r5.append(r6);
        return;
    L12:
        r6 = new String(r0, r4);     // Catch: UnsupportedEncodingException -> L9
    L9:
        r6 = new String(r0, Charset.forName("UTF-8"));
        goto L10
    }

    static List<String> matchSingleVCardPrefixedField(CharSequence r0, String r1, boolean r2, boolean r3) {
        List<List<String>> r4 = matchVCardPrefixedField(r0, r1, r2, r3);
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r4.isEmpty() == false) goto L8;
        return null;
    L8:
        return r4.get(0);
    }

    private static String toPrimaryValue(List<String> r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (r1.isEmpty() == false) goto L7;
        return null;
    L7:
        return r1.get(0);
    }

    private static String[] toPrimaryValues(Collection<List<String>> r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (r4.isEmpty() == true) goto L25;
        ArrayList r0 = new ArrayList(r4.size());
        Iterator<List<String>> r1 = r4.iterator();
    L8:
        if (r1.hasNext() == false) goto L15;
        String r2 = r1.next().get(0);
        if (r2 == null) goto L8;
        if (r2.isEmpty() == true) goto L8;
        r0.add(r2);
        goto L8
    L15:
        return (String[]) r0.toArray(new String[r4.size()]);
    L25:
        return null;
    }

    private static String[] toTypes(Collection<List<String>> r9) {
        if (r9 != null) goto L5;
    L24:
        return null;
    L5:
        if (r9.isEmpty() == true) goto L24;
        ArrayList r1 = new ArrayList(r9.size());
        Iterator<List<String>> r2 = r9.iterator();
    L9:
        if (r2.hasNext() == false) goto L23;
        List<String> r3 = r2.next();
        int r4 = 1;
    L12:
        if (r4 >= r3.size()) goto L20;
        String r5 = r3.get(r4);
        int r6 = r5.indexOf(61);
        if (r6 < 0) goto L21;
        if (VCardConstants.PARAM_TYPE.equalsIgnoreCase(r5.substring(0, r6)) == true) goto L18;
        r4 = r4 + 1;
        goto L12
    L18:
        r5 = r5.substring(r6 + 1);
    L21:
        r1.add(r5);
        goto L9
    L20:
        r5 = null;
        goto L21
    L23:
        return (String[]) r1.toArray(new String[r9.size()]);
    }

    private static boolean isLikeVCardDate(CharSequence r1) {
        if (r1 != null) goto L4;
        return true;
    L4:
        if (VCARD_LIKE_DATE.matcher(r1).matches() == true) goto L10;
        return false;
    L10:
        return true;
    }

    private static void formatNames(Iterable<List<String>> r8) {
        if (r8 == null) goto L13;
        Iterator<List<String>> r9 = r8.iterator();
    L5:
        if (r9.hasNext() == false) goto L17;
        List<String> r0 = r9.next();
        String r2 = r0.get(0);
        String[] r3 = new String[5];
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r4 >= 4) goto L12;
        int r7 = r2.indexOf(59, r5);
        if (r7 < 0) goto L12;
        r3[r4] = r2.substring(r5, r7);
        r4 = r4 + 1;
        r5 = r7 + 1;
    L12:
        r3[r4] = r2.substring(r5);
        StringBuilder r6 = new StringBuilder(100);
        maybeAppendComponent(r3, 3, r6);
        maybeAppendComponent(r3, 1, r6);
        maybeAppendComponent(r3, 2, r6);
        maybeAppendComponent(r3, 0, r6);
        maybeAppendComponent(r3, 4, r6);
        r0.set(0, r6.toString().trim());
        goto L5
    L17:
        return;
    }

    private static void maybeAppendComponent(String[] r1, int r2, StringBuilder r3) {
        String r0 = r1[r2];
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return;
    L7:
        if (r3.length() <= 0) goto L9;
        r3.append(' ');
    L9:
        r3.append(r1[r2]);
    }
}
