package com.android.contacts.common.compat;

import android.telephony.PhoneNumberUtils;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.TtsSpan;
import com.android.contacts.util.HanziToPinyin;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

/* JADX INFO: loaded from: classes.dex */
public class PhoneNumberUtilsCompat {
    private PhoneNumberUtilsCompat() {
    }

    public static String normalizeNumber(String r1) {
        if (CompatUtils.isLollipopCompatible() == false) goto L7;
        return PhoneNumberUtils.normalizeNumber(r1);
    L7:
        return normalizeNumberInternal(r1);
    }

    private static String normalizeNumberInternal(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L6;
        return "";
    L6:
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L28;
        char r3 = r6.charAt(r2);
        int r4 = Character.digit(r3, 10);
        if (r4 == (-1)) goto L12;
        r0.append(r4);
    L26:
        r2 = r2 + 1;
        goto L7
    L12:
        if (r0.length() != 0) goto L17;
        if (r3 != '+') goto L17;
        r0.append(r3);
    L17:
        if (r3 < 'a') goto L21;
        if (r3 > 'z') goto L21;
    L25:
        return normalizeNumber(PhoneNumberUtils.convertKeypadLettersToDigits(r6));
    L21:
        if (r3 < 'A') goto L26;
        if (r3 > 'Z') goto L26;
    L28:
        return r0.toString();
    }

    public static String formatNumber(String r1, String r2, String r3) {
        if (CompatUtils.isLollipopCompatible() == false) goto L7;
        return PhoneNumberUtils.formatNumber(r1, r2, r3);
    L7:
        return PhoneNumberUtils.formatNumber(r1);
    }

    public static CharSequence createTtsSpannable(CharSequence r1) {
        if (CompatUtils.isMarshmallowCompatible() == false) goto L7;
        return PhoneNumberUtils.createTtsSpannable(r1);
    L7:
        return createTtsSpannableInternal(r1);
    }

    public static TtsSpan createTtsSpan(String r1) {
        if (CompatUtils.isMarshmallowCompatible() == false) goto L7;
        return PhoneNumberUtils.createTtsSpan(r1);
    L7:
        if (CompatUtils.isLollipopCompatible() == true) goto L9;
        return null;
    L9:
        return createTtsSpanLollipop(r1);
    }

    private static CharSequence createTtsSpannableInternal(CharSequence r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Spannable r3 = Spannable.Factory.getInstance().newSpannable(r2);
        addTtsSpanInternal(r3, 0, r3.length());
        return r3;
    }

    public static void addTtsSpan(Spannable r1, int r2, int r3) {
        if (CompatUtils.isMarshmallowCompatible() == false) goto L5;
        PhoneNumberUtils.addTtsSpan(r1, r2, r3);
        return;
    L5:
        addTtsSpanInternal(r1, r2, r3);
    }

    private static void addTtsSpanInternal(Spannable r2, int r3, int r4) {
        r2.setSpan(createTtsSpan(r2.subSequence(r3, r4).toString()), r3, r4, 33);
    }

    private static TtsSpan createTtsSpanLollipop(String r4) {
        Phonenumber.PhoneNumber r0 = null;
        if (r4 != null) goto L17;
        return null;
    L17:
        r0 = PhoneNumberUtil.getInstance().parse(r4, null);     // Catch: NumberParseException -> L16
    L7:
        TtsSpan.TelephoneBuilder r1 = new TtsSpan.TelephoneBuilder();
        if (r0 != null) goto L11;
        r1.setNumberParts(splitAtNonNumerics(r4));
    L15:
        return r1.build();
    L11:
        if (r0.hasCountryCode() == false) goto L13;
        r1.setCountryCode(Integer.toString(r0.getCountryCode()));
    L13:
        r1.setNumberParts(Long.toString(r0.getNationalNumber()));
        goto L15
    }

    private static String splitAtNonNumerics(CharSequence r4) {
        StringBuilder r0 = new StringBuilder(r4.length());
        int r1 = 0;
    L3:
        int r2 = r4.length();
        Object r3 = HanziToPinyin.Token.SEPARATOR;
        if (r1 >= r2) goto L10;
        if (PhoneNumberUtils.isISODigit(r4.charAt(r1)) == false) goto L8;
        r3 = Character.valueOf(r4.charAt(r1));
    L8:
        r0.append(r3);
        r1 = r1 + 1;
        goto L3
    L10:
        return r0.toString().replaceAll(" +", HanziToPinyin.Token.SEPARATOR).trim();
    }
}
