package com.android.vcard;

import android.telephony.PhoneNumberUtils;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import com.android.contacts.common.list.DefaultContactListAdapter;
import com.android.vcard.exception.VCardException;
import com.obric.appintents.contacts.ContactsCreateIntent;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public class VCardUtils {
    private static final String LOG_TAG = "vCard";
    private static final int[] sEscapeIndicatorsV30 = null;
    private static final int[] sEscapeIndicatorsV40 = null;
    private static final Map<Integer, String> sKnownImPropNameMap_ItoS = null;
    private static final Map<String, Integer> sKnownPhoneTypeMap_StoI = null;
    private static final Map<Integer, String> sKnownPhoneTypesMap_ItoS = null;
    private static final Set<String> sMobilePhoneLabelSet = null;
    private static final Set<String> sPhoneTypesUnknownToContactsSet = null;
    private static final Set<Character> sUnAcceptableAsciiInV21WordSet = null;

    private static class DecoderException extends Exception {
        public DecoderException(String r1) {
            super(r1);
        }
    }

    public static class PhoneNumberUtilsPort {
        public PhoneNumberUtilsPort() {
        }

        public static String formatNumber(String r1, int r2) {
            SpannableStringBuilder r0 = new SpannableStringBuilder(r1);
            PhoneNumberUtils.formatNumber(r0, r2);
            return r0.toString();
        }
    }

    private static class QuotedPrintableCodecPort {
        private static byte ESCAPE_CHAR = 61;

        static {
        }

        private QuotedPrintableCodecPort() {
        }

        public static final byte[] decodeQuotedPrintable(byte[] r6) throws DecoderException {
            if (r6 != null) goto L6;
            return null;
        L6:
            ByteArrayOutputStream r1 = new ByteArrayOutputStream();
            int r2 = 0;
        L8:
            if (r2 >= r6.length) goto L23;
            byte r3 = r6[r2];
            if (r3 != ESCAPE_CHAR) goto L20;
            int r4 = r2 + 1;
            int r5 = Character.digit((char) r6[r4], 16);     // Catch: ArrayIndexOutOfBoundsException -> L18
            r2 = r4 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L18
            int r7 = Character.digit((char) r6[r2], 16);     // Catch: ArrayIndexOutOfBoundsException -> L18
            if (r5 == (-1)) goto L17;
            if (r7 == (-1)) goto L17;
            r1.write((char) ((r5 << 4) + r7));     // Catch: ArrayIndexOutOfBoundsException -> L18
        L21:
            r2 = r2 + 1;
        L17:
            throw new DecoderException("Invalid quoted-printable encoding");     // Catch: ArrayIndexOutOfBoundsException -> L18
        L19:
            throw new DecoderException("Invalid quoted-printable encoding");
        L20:
            r1.write(r3);
            goto L21
        L23:
            return r1.toByteArray();
        }
    }

    public static class TextUtilsPort {
        public static boolean isPrintableAscii(char r1) {
            if (' ' > r1) goto L7;
            if (r1 > '~') goto L7;
        L12:
            return true;
        L7:
            if (r1 == '\r') goto L12;
            if (r1 == '\n') goto L12;
            return false;
        }

        public TextUtilsPort() {
        }

        public static boolean isPrintableAsciiOnly(CharSequence r4) {
            int r0 = r4.length();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L8;
            if (isPrintableAscii(r4.charAt(r2)) == false) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return false;
        L8:
            return true;
        }
    }

    static {
        HashMap r0 = new HashMap();
        sKnownPhoneTypesMap_ItoS = r0;
        HashMap r1 = new HashMap();
        sKnownPhoneTypeMap_StoI = r1;
        r0.put(9, VCardConstants.PARAM_TYPE_CAR);
        r1.put(VCardConstants.PARAM_TYPE_CAR, 9);
        r0.put(6, VCardConstants.PARAM_TYPE_PAGER);
        r1.put(VCardConstants.PARAM_TYPE_PAGER, 6);
        r0.put(11, VCardConstants.PARAM_TYPE_ISDN);
        r1.put(VCardConstants.PARAM_TYPE_ISDN, 11);
        r1.put("HOME", 1);
        r1.put("WORK", 3);
        r1.put(VCardConstants.PARAM_TYPE_CELL, 2);
        r1.put(VCardConstants.PARAM_PHONE_EXTRA_TYPE_OTHER, 7);
        r1.put(VCardConstants.PARAM_PHONE_EXTRA_TYPE_CALLBACK, 8);
        r1.put(VCardConstants.PARAM_PHONE_EXTRA_TYPE_COMPANY_MAIN, 10);
        r1.put(VCardConstants.PARAM_PHONE_EXTRA_TYPE_RADIO, 14);
        r1.put(VCardConstants.PARAM_PHONE_EXTRA_TYPE_TTY_TDD, 16);
        r1.put(VCardConstants.PARAM_PHONE_EXTRA_TYPE_ASSISTANT, 19);
        r1.put(VCardConstants.PARAM_TYPE_VOICE, 7);
        HashSet r2 = new HashSet();
        sPhoneTypesUnknownToContactsSet = r2;
        r2.add(VCardConstants.PARAM_TYPE_MODEM);
        r2.add(VCardConstants.PARAM_TYPE_MSG);
        r2.add(VCardConstants.PARAM_TYPE_BBS);
        r2.add(VCardConstants.PARAM_TYPE_VIDEO);
        HashMap r3 = new HashMap();
        sKnownImPropNameMap_ItoS = r3;
        r3.put(0, VCardConstants.PROPERTY_X_AIM);
        r3.put(1, VCardConstants.PROPERTY_X_MSN);
        r3.put(2, VCardConstants.PROPERTY_X_YAHOO);
        r3.put(3, VCardConstants.PROPERTY_X_SKYPE_USERNAME);
        r3.put(5, VCardConstants.PROPERTY_X_GOOGLE_TALK);
        r3.put(6, VCardConstants.PROPERTY_X_ICQ);
        r3.put(7, VCardConstants.PROPERTY_X_JABBER);
        r3.put(4, VCardConstants.PROPERTY_X_QQ);
        r3.put(8, VCardConstants.PROPERTY_X_NETMEETING);
        sMobilePhoneLabelSet = new HashSet(Arrays.asList(new String[]{ContactsCreateIntent.CREATE_TEL_TYPE_MOBILE, "携帯電話", "携帯", "ケイタイ", "ｹｲﾀｲ"}));
        sUnAcceptableAsciiInV21WordSet = new HashSet(Arrays.asList(new Character[]{Character.valueOf(DefaultContactListAdapter.SNIPPET_START_MATCH), Character.valueOf(DefaultContactListAdapter.SNIPPET_END_MATCH), '=', ':', '.', ',', ' '}));
        sEscapeIndicatorsV30 = new int[]{58, 59, 44, 32};
        sEscapeIndicatorsV40 = new int[]{59, 58};
    }

    public static String getPhoneTypeString(Integer r1) {
        return sKnownPhoneTypesMap_ItoS.get(r1);
    }

    public static Object getPhoneTypeFromStrings(Collection<String> r11, String r12) {
        if (r12 != null) goto L4;
        r12 = "";
    L4:
        boolean r1 = false;
        int r3 = -1;
        String r4 = null;
        if (r11 == null) goto L39;
        Iterator<String> r13 = r11.iterator();
        boolean r5 = false;
        boolean r6 = false;
    L8:
        if (r13.hasNext() == false) goto L38;
        String r7 = r13.next();
        if (r7 == null) goto L8;
        String r8 = r7.toUpperCase();
        if (r8.equals(VCardConstants.PARAM_TYPE_PREF) == true) goto L14;
        if (r8.equals(VCardConstants.PARAM_TYPE_FAX) == true) goto L17;
        if (r8.startsWith("X-") == false) goto L23;
        if (r3 >= 0) goto L23;
        r7 = r7.substring(2);
    L23:
        if (r7.length() == 0) goto L8;
        Integer r9 = sKnownPhoneTypeMap_StoI.get(r7.toUpperCase());
        if (r9 != null) goto L27;
        if (r3 >= 0) goto L8;
        r3 = 0;
        r4 = r7;
        goto L8
    L27:
        int r10 = r9.intValue();
        int r14 = r12.indexOf("@");
        if (r10 != 6) goto L32;
        if (r14 <= 0) goto L32;
        if (r14 >= (r12.length() - 1)) goto L32;
    L35:
        r3 = r9.intValue();
    L32:
        if (r3 < 0) goto L35;
        if (r3 == 0) goto L35;
        if (r3 != 7) goto L8;
    L17:
        r5 = true;
        goto L8
    L14:
        r6 = true;
        goto L8
    L38:
        r1 = r6;
    L40:
        if (r3 >= 0) goto L44;
        if (r1 == false) goto L43;
        r3 = 12;
        goto L44
    L43:
        r3 = 1;
    L44:
        if (r5 == false) goto L52;
        if (r3 != 1) goto L48;
        r3 = 5;
        goto L52
    L48:
        if (r3 != 3) goto L50;
        r3 = 4;
        goto L52
    L50:
        if (r3 != 7) goto L52;
        r3 = 13;
    L52:
        if (r3 != 0) goto L55;
        return r4;
    L55:
        return Integer.valueOf(r3);
    L39:
        r5 = false;
        goto L40
    }

    public static boolean isMobilePhoneLabel(String r1) {
        if ("_AUTO_CELL".equals(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (sMobilePhoneLabelSet.contains(r1) == true) goto L8;
        return false;
    }

    public static boolean isValidInV21ButUnknownToContactsPhoteType(String r1) {
        return sPhoneTypesUnknownToContactsSet.contains(r1);
    }

    public static String getPropertyNameForIm(int r1) {
        return sKnownImPropNameMap_ItoS.get(Integer.valueOf(r1));
    }

    public static String[] sortNameElements(int r5, String r6, String r7, String r8) {
        String[] r0 = new String[3];
        int r9 = VCardConfig.getNameOrderType(r5);
        if (r9 != 4) goto L5;
        r0[0] = r7;
        r0[1] = r8;
        r0[2] = r6;
    L19:
        return r0;
    L5:
        if (r9 == 8) goto L13;
        if (containsOnlyPrintableAscii(new String[]{r6}) == true) goto L9;
    L11:
        r0[0] = r6;
        r0[1] = r7;
        r0[2] = r8;
        goto L19
    L9:
        if (containsOnlyPrintableAscii(new String[]{r8}) == false) goto L11;
        r0[0] = r8;
        r0[1] = r7;
        r0[2] = r6;
        goto L19
    L13:
        if (containsOnlyPrintableAscii(new String[]{r6}) == true) goto L15;
    L17:
        r0[0] = r6;
        r0[1] = r7;
        r0[2] = r8;
        goto L19
    L15:
        if (containsOnlyPrintableAscii(new String[]{r8}) == false) goto L17;
        r0[0] = r8;
        r0[1] = r7;
        r0[2] = r6;
        goto L19
    }

    public static int getPhoneNumberFormat(int r0) {
        if (VCardConfig.isJapaneseDevice(r0) == false) goto L6;
        return 2;
    L6:
        return 1;
    }

    public static String constructNameFromElements(int r6, String r7, String r8, String r9) {
        return constructNameFromElements(r6, r7, r8, r9, null, null);
    }

    public static String constructNameFromElements(int r4, String r5, String r6, String r7, String r8, String r9) {
        StringBuilder r0 = new StringBuilder();
        String[] r10 = sortNameElements(r4, r5, r6, r7);
        if (TextUtils.isEmpty(r8) == true) goto L5;
        r0.append(r8);
        boolean r11 = false;
    L6:
        int r12 = r10.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L17;
        String r2 = r10[r13];
        if (TextUtils.isEmpty(r2) == true) goto L15;
        if (r11 == false) goto L13;
        r11 = false;
    L14:
        r0.append(r2);
        goto L15
    L13:
        r0.append(' ');
    L15:
        r13 = r13 + 1;
        goto L8
    L17:
        if (TextUtils.isEmpty(r9) == true) goto L22;
        if (r11 == true) goto L20;
        r0.append(' ');
    L20:
        r0.append(r9);
    L22:
        return r0.toString();
    L5:
        r11 = true;
        goto L6
    }

    public static List<String> constructListFromValue(String r9, int r10) {
        ArrayList r0 = new ArrayList();
        StringBuilder r1 = new StringBuilder();
        int r2 = r9.length();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L26;
        char r4 = r9.charAt(r3);
        if (r4 != '\\') goto L22;
        if (r3 >= (r2 - 1)) goto L22;
        int r5 = r3 + 1;
        char r6 = r9.charAt(r5);
        if (VCardConfig.isVersion40(r10) == false) goto L12;
        String r7 = VCardParserImpl_V40.unescapeCharacter(r6);
    L18:
        if (r7 == null) goto L20;
        r1.append(r7);
        r3 = r5;
    L25:
        r3 = r3 + 1;
        goto L3
    L20:
        r1.append(r4);
        goto L25
    L12:
        if (VCardConfig.isVersion30(r10) == false) goto L15;
        r7 = VCardParserImpl_V30.unescapeCharacter(r6);
        goto L18
    L15:
        if (VCardConfig.isVersion21(r10) == true) goto L17;
        Log.w(LOG_TAG, "Unknown vCard type");
    L17:
        r7 = VCardParserImpl_V21.unescapeCharacter(r6);
    L22:
        if (r4 != ';') goto L24;
        r0.add(r1.toString());
        r1 = new StringBuilder();
        goto L25
    L24:
        r1.append(r4);
        goto L25
    L26:
        r0.add(r1.toString());
        return r0;
    }

    public static boolean containsOnlyPrintableAscii(String... r0) {
        if (r0 != null) goto L6;
        return true;
    L6:
        return containsOnlyPrintableAscii(Arrays.asList(r0));
    }

    public static boolean containsOnlyPrintableAscii(Collection<String> r3) {
        if (r3 != null) goto L5;
        return true;
    L5:
        Iterator<String> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L15;
        String r1 = r4.next();
        if (TextUtils.isEmpty(r1) == true) goto L7;
        if (TextUtilsPort.isPrintableAsciiOnly(r1) == true) goto L7;
        return false;
    L15:
        return true;
    }

    public static boolean containsOnlyNonCrLfPrintableAscii(String... r0) {
        if (r0 != null) goto L6;
        return true;
    L6:
        return containsOnlyNonCrLfPrintableAscii(Arrays.asList(r0));
    }

    public static boolean containsOnlyNonCrLfPrintableAscii(Collection<String> r7) {
        if (r7 != null) goto L5;
        return true;
    L5:
        Iterator<String> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L20;
        String r1 = r8.next();
        if (TextUtils.isEmpty(r1) == true) goto L7;
        int r2 = r1.length();
        int r4 = 0;
    L12:
        if (r4 >= r2) goto L7;
        int r5 = r1.codePointAt(r4);
        if (32 > r5) goto L19;
        if (r5 > 126) goto L19;
        r4 = r1.offsetByCodePoints(r4, 1);
    L19:
        return false;
    L20:
        return true;
    }

    public static boolean containsOnlyAlphaDigitHyphen(String... r0) {
        if (r0 != null) goto L6;
        return true;
    L6:
        return containsOnlyAlphaDigitHyphen(Arrays.asList(r0));
    }

    public static boolean containsOnlyAlphaDigitHyphen(Collection<String> r7) {
        if (r7 != null) goto L5;
        return true;
    L5:
        Iterator<String> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L29;
        String r1 = r8.next();
        if (TextUtils.isEmpty(r1) == true) goto L7;
        int r2 = r1.length();
        int r4 = 0;
    L12:
        if (r4 >= r2) goto L7;
        int r5 = r1.codePointAt(r4);
        if (97 > r5) goto L18;
        if (r5 >= 123) goto L18;
    L28:
        r4 = r1.offsetByCodePoints(r4, 1);
    L18:
        if (65 > r5) goto L22;
        if (r5 < 91) goto L28;
    L22:
        if (48 > r5) goto L26;
        if (r5 < 58) goto L28;
    L26:
        if (r5 == 45) goto L28;
        return false;
    L29:
        return true;
    }

    public static boolean containsOnlyWhiteSpaces(String... r0) {
        if (r0 != null) goto L6;
        return true;
    L6:
        return containsOnlyWhiteSpaces(Arrays.asList(r0));
    }

    public static boolean containsOnlyWhiteSpaces(Collection<String> r6) {
        if (r6 != null) goto L5;
        return true;
    L5:
        Iterator<String> r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L17;
        String r1 = r7.next();
        if (TextUtils.isEmpty(r1) == true) goto L7;
        int r2 = r1.length();
        int r4 = 0;
    L12:
        if (r4 >= r2) goto L7;
        if (Character.isWhitespace(r1.codePointAt(r4)) == false) goto L15;
        r4 = r1.offsetByCodePoints(r4, 1);
        goto L12
    L15:
        return false;
    L17:
        return true;
    }

    public static boolean isV21Word(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return true;
    L5:
        int r0 = r6.length();
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L16;
        int r4 = r6.codePointAt(r3);
        if (32 > r4) goto L15;
        if (r4 > 126) goto L15;
        if (sUnAcceptableAsciiInV21WordSet.contains(Character.valueOf((char) r4)) == true) goto L15;
        r3 = r6.offsetByCodePoints(r3, 1);
    L15:
        return false;
    L16:
        return true;
    }

    public static String toStringAsV30ParamValue(String r1) {
        return toStringAsParamValue(r1, sEscapeIndicatorsV30);
    }

    public static String toStringAsV40ParamValue(String r1) {
        return toStringAsParamValue(r1, sEscapeIndicatorsV40);
    }

    private static String toStringAsParamValue(String r11, int[] r12) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
        r11 = "";
    L5:
        StringBuilder r0 = new StringBuilder();
        int r2 = r11.length();
        int r4 = 0;
        boolean r5 = false;
    L7:
        if (r4 >= r2) goto L19;
        int r8 = r11.codePointAt(r4);
        if (r8 < 32) goto L18;
        if (r8 == 34) goto L18;
        r0.appendCodePoint(r8);
        int r6 = r12.length;
        int r9 = 0;
    L13:
        if (r9 >= r6) goto L18;
        if (r8 == r12[r9]) goto L16;
        r9 = r9 + 1;
        goto L13
    L16:
        r5 = true;
    L18:
        r4 = r11.offsetByCodePoints(r4, 1);
        goto L7
    L19:
        String r13 = r0.toString();
        if (r13.isEmpty() == false) goto L22;
        return "";
    L22:
        if (containsOnlyWhiteSpaces(new String[]{r13}) == true) goto L36;
        if (r5 == false) goto L27;
        return "\"" + r13 + Typography.quote;
    L27:
        return r13;
    L36:
        return "";
    }

    public static String toHalfWidthString(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return null;
    L6:
        StringBuilder r0 = new StringBuilder();
        int r1 = r5.length();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L14;
        char r3 = r5.charAt(r2);
        String r4 = JapaneseUtils.tryGetHalfWidthText(r3);
        if (r4 == null) goto L11;
        r0.append(r4);
    L12:
        r2 = r5.offsetByCodePoints(r2, 1);
        goto L7
    L11:
        r0.append(r3);
        goto L12
    L14:
        return r0.toString();
    }

    public static String guessImageType(byte[] r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        if (r8.length < 3) goto L16;
        if (r8[0] != 71) goto L16;
        if (r8[1] != 73) goto L16;
        if (r8[2] != 70) goto L16;
        return "GIF";
    L16:
        if (r8.length < 4) goto L28;
        if (r8[0] != (-119)) goto L28;
        if (r8[1] != 80) goto L28;
        if (r8[2] != 78) goto L28;
        if (r8[3] != 71) goto L28;
        return "PNG";
    L28:
        if (r8.length >= 2) goto L30;
    L35:
        return null;
    L30:
        if (r8[0] != (-1)) goto L35;
        if (r8[1] != (-40)) goto L35;
        return "JPEG";
    }

    public static boolean areAllEmpty(String... r5) {
        if (r5 != null) goto L5;
        return true;
    L5:
        int r1 = r5.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L11;
        if (TextUtils.isEmpty(r5[r3]) == false) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static boolean appearsLikeAndroidVCardQuotedPrintable(String r5) {
        int r0 = r5.length() % 3;
        if (r5.length() >= 2) goto L5;
    L16:
        return false;
    L5:
        if (r0 == 1) goto L8;
        if (r0 != 0) goto L16;
    L8:
        int r1 = 0;
    L10:
        if (r1 >= r5.length()) goto L15;
        if (r5.charAt(r1) != '=') goto L13;
        r1 = r1 + 3;
        goto L10
    L13:
        return false;
    L15:
        return true;
    }

    public static String parseQuotedPrintable(String r8, boolean r9, String r10, String r11) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r8.length();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L15;
        char r4 = r8.charAt(r3);
        if (r4 == '=') goto L7;
    L13:
        r0.append(r4);
    L14:
        r3 = r3 + 1;
        goto L3
    L7:
        if (r3 >= (r1 - 1)) goto L13;
        int r5 = r3 + 1;
        char r6 = r8.charAt(r5);
        if (r6 != ' ') goto L11;
    L12:
        r0.append(r6);
        r3 = r5;
        goto L14
    L11:
        if (r6 != '\t') goto L13;
    L15:
        String r12 = r0.toString();
        if (r9 == false) goto L18;
        String[] r13 = r12.split(VCardBuilder.VCARD_END_OF_LINE);
    L36:
        StringBuilder r14 = new StringBuilder();
        int r2 = r13.length;
        int r7 = 0;
    L37:
        if (r7 >= r2) goto L42;
        String r15 = r13[r7];
        if (r15.endsWith("=") == false) goto L41;
        r15 = r15.substring(0, r15.length() - 1);
    L41:
        r14.append(r15);
        r7 = r7 + 1;
        goto L37
    L42:
        String r16 = r14.toString();
        if (TextUtils.isEmpty(r16) == false) goto L57;
        Log.w(LOG_TAG, "Given raw string is empty.");
    L57:
        byte[] r17 = r16.getBytes(r10);     // Catch: UnsupportedEncodingException -> L47
    L55:
        r17 = QuotedPrintableCodecPort.decodeQuotedPrintable(r17);     // Catch: DecoderException -> L50
    L59:
        return new String(r17, r11);
    L53:
        Log.e(LOG_TAG, "Failed to encode: charset=" + r11);
        return new String(r17);
    L50:
        Log.e(LOG_TAG, "DecoderException is thrown.");
    L47:
        Log.w(LOG_TAG, "Failed to decode: " + r10);
        r17 = r16.getBytes();
        goto L55
    L18:
        StringBuilder r18 = new StringBuilder();
        int r19 = r12.length();
        ArrayList r20 = new ArrayList();
        int r21 = 0;
    L19:
        if (r21 >= r19) goto L32;
        char r22 = r12.charAt(r21);
        if (r22 != '\n') goto L24;
        r20.add(r18.toString());
        r18 = new StringBuilder();
    L31:
        r21 = r21 + 1;
        goto L19
    L24:
        if (r22 != '\r') goto L30;
        r20.add(r18.toString());
        r18 = new StringBuilder();
        if (r21 >= (r19 - 1)) goto L31;
        int r23 = r21 + 1;
        if (r12.charAt(r23) != '\n') goto L31;
        r21 = r23;
        goto L31
    L30:
        r18.append(r22);
        goto L31
    L32:
        String r24 = r18.toString();
        if (r24.length() <= 0) goto L35;
        r20.add(r24);
    L35:
        r13 = (String[]) r20.toArray(new String[0]);
        goto L36
    }

    public static final VCardParser getAppropriateParser(int r1) throws VCardException {
        if (VCardConfig.isVersion21(r1) == false) goto L7;
        return new VCardParser_V21();
    L7:
        if (VCardConfig.isVersion30(r1) == false) goto L11;
        return new VCardParser_V30();
    L11:
        if (VCardConfig.isVersion40(r1) == false) goto L15;
        return new VCardParser_V40();
    L15:
        throw new VCardException("Version is not specified");
    }

    public static final String convertStringCharset(String r1, String r2, String r3) {
        if (r2.equalsIgnoreCase(r3) == false) goto L5;
        return r1;
    L5:
        ByteBuffer r4 = Charset.forName(r2).encode(r1);
        byte[] r5 = new byte[r4.remaining()];
        r4.get(r5);
        return new String(r5, r3);
    L8:
        Log.e(LOG_TAG, "Failed to encode: charset=" + r3);
        return null;
    }

    private VCardUtils() {
    }
}
