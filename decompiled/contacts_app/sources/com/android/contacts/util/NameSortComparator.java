package com.android.contacts.util;

import android.os.SystemClock;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.list.ContactBaseData;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.Comparator;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class NameSortComparator implements Comparator<ContactBaseData> {
    private static final String SECTION_RULES = "&amp < a = A < b = B < c = C < d = D < e = E< f = F < g = G < h = H < i = I < j = J < k = K < l = L< m = M < n = N < o = O < p = P < q = Q < r = R < s = S< t = T < u = U < v = V < w = W < x = X < y = Y < z = Z< '#'";
    private static final String SECTION_RULES_JAPAN = "&amp < あ < か < さ < た < な < は < ま < や < ら < わ< a = A < b = B < c = C < d = D < e = E< f = F < g = G < h = H < i = I < j = J < k = K < l = L< m = M < n = N < o = O < p = P < q = Q < r = R < s = S< t = T < u = U < v = V < w = W < x = X < y = Y < z = Z< '#'";
    private static final String SECTION_RULES_KOREA = "&amp < ㄱ < ㄴ < ㄷ < ㄹ < ㅁ < ㅂ < ㅅ < ㅇ < ㅈ < ㅊ < ㅋ < ㅌ < ㅍ < ㅎ< a = A < b = B < c = C < d = D < e = E< f = F < g = G < h = H < i = I < j = J < k = K < l = L< m = M < n = N < o = O < p = P < q = Q < r = R < s = S< t = T < u = U < v = V < w = W < x = X < y = Y < z = Z< '#'";
    private static final String SECTION_RULES_RUSSIAN = "&amp < А = а < Б = б < В = в < Г = г < Д = д < Е = е = Ё = ё < Ж = ж < З = з < И = и < Й = й < К = к < Л = л < М = м < Н = н < О = о < П = п < Р = р < С = с < Т = т < У = у < Ф = ф < Х = х < Ц = ц < Ч = ч < Ш = ш < Щ = щ < Ъ = ъ < Ы = ы < Ь = ь < Э = э < Ю = ю < Я = я < a = A < b = B < c = C < d = D < e = E< f = F < g = G < h = H < i = I < j = J < k = K < l = L< m = M < n = N < o = O < p = P < q = Q < r = R < s = S< t = T < u = U < v = V < w = W < x = X < y = Y < z = Z< '#'";
    private static final String TAG = "NameSortComparator";
    protected static volatile RuleBasedCollator mCollator;
    protected NumberSortComparator mNumberSortComparator;

    public static class NumberSortComparator implements Comparator<ContactBaseData> {
        public NumberSortComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(ContactBaseData r1, ContactBaseData r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(ContactBaseData r5, ContactBaseData r6) {
            if (r5.hasname == false) goto L8;
            if (r6.hasname == true) goto L8;
            return 1;
        L8:
            if (r5.hasname == true) goto L13;
            if (r6.hasname == false) goto L13;
        L54:
            return -1;
        L13:
            if (r5.hasname == false) goto L53;
            if (r6.hasname == false) goto L53;
            if (ContactsUtils.isPhoneNumber(r5.name) == false) goto L19;
        L22:
            boolean r4 = true;
        L24:
            if (ContactsUtils.isPhoneNumber(r6.name) == false) goto L26;
        L29:
            boolean r3 = true;
        L30:
            if (r4 == true) goto L33;
            if (r3 == true) goto L54;
        L33:
            if (r4 == false) goto L37;
            if (r3 == true) goto L37;
            return 1;
        L37:
            if (r5.sortkey != null) goto L42;
            if (r6.sortkey == null) goto L53;
        L42:
            if (r5.sortkey == null) goto L47;
            if (r6.sortkey != null) goto L47;
            return 1;
        L47:
            if (r5.sortkey != null) goto L55;
            if (r6.sortkey != null) goto L54;
        L55:
            return r5.sortkey.compareToIgnoreCase(r6.sortkey);
        L26:
            if (ContactsUtils.isStartWithPhoneNumber(r6.name) == true) goto L29;
            r3 = false;
            goto L30
        L19:
            if (ContactsUtils.isStartWithPhoneNumber(r5.name) == true) goto L22;
            r4 = false;
        L53:
            return 0;
        }
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(ContactBaseData r1, ContactBaseData r2) {
        return compare2(r1, r2);
    }

    public NameSortComparator() {
        this.mNumberSortComparator = new NumberSortComparator();
        ensureCollatorForCurrentLocale();
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(ContactBaseData r4, ContactBaseData r5) {
        int r0 = mCollator.compare(r4.group, r5.group);
        if (r0 == 0) goto L5;
        return r0;
    L5:
        int r1 = mCollator.compare(r4.section, r5.section);
        if (r1 == 0) goto L9;
        return r1;
    L9:
        if (r5.section.equals(ContactsUtils.CHAR_POUND) == false) goto L12;
        return this.mNumberSortComparator.compare2(r4, r5);
    L12:
        return r4.sortkey.compareToIgnoreCase(r5.sortkey);
    }

    private void ensureCollatorForCurrentLocale() {
        String r1 = Locale.getDefault().getLanguage();
        RuleBasedCollator r0 = mCollator;
        if (r0 != null) goto L5;
    L6:
        updateCollator();
        return;
    L5:
        if (getRulesForLanguage(r1).equals(r0.getRules()) == false) goto L6;
    }

    private static String getRulesForLanguage(String r1) {
        if (Locale.KOREA.getLanguage().equals(r1) == false) goto L6;
        return SECTION_RULES_KOREA;
    L6:
        if (Locale.JAPAN.getLanguage().equals(r1) == false) goto L9;
        return SECTION_RULES_JAPAN;
    L9:
        if ("ru".equals(r1) == false) goto L11;
        return SECTION_RULES_RUSSIAN;
    L11:
        return SECTION_RULES;
    }

    public static synchronized void updateCollator() {
        monitor-enter(NameSortComparator.class);
        String r2 = Locale.getDefault().getLanguage();     // Catch: Throwable -> L19
        String r3 = getRulesForLanguage(r2);     // Catch: Throwable -> L19
        if (mCollator != null) goto L7;
    L23:
        long r4 = SystemClock.elapsedRealtime();     // Catch: IllegalArgumentException -> L13 ParseException -> L15 Throwable -> L19
        mCollator = new RuleBasedCollator(r3);     // Catch: IllegalArgumentException -> L13 ParseException -> L15 Throwable -> L19
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "updateCollator language=" + r2 + " cost=" + (SystemClock.elapsedRealtime() - r4) + "ms");     // Catch: IllegalArgumentException -> L13 ParseException -> L15 Throwable -> L19
    L17:
        monitor-exit(NameSortComparator.class);
        return;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
        goto L17
    L7:
        if (r3.equals(mCollator.getRules()) == false) goto L23;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "same rule, no need to updateCollator");     // Catch: Throwable -> L19
        monitor-exit(NameSortComparator.class);
        return;
    L19:
        th = move-exception;
        throw th;
    }
}
