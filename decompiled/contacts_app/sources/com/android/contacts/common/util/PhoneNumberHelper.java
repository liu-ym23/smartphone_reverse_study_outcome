package com.android.contacts.common.util;

import android.telephony.PhoneNumberUtils;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes.dex */
public class PhoneNumberHelper {
    private static final String KOREA_ISO_COUNTRY_CODE = "KR";
    private static final String LOG_TAG = "PhoneNumberHelper";

    static {
    }

    public PhoneNumberHelper() {
    }

    public static boolean isUriNumber(String r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.contains("@") == false) goto L6;
    L7:
        return true;
    L6:
        if (r1.contains("%40") == false) goto L8;
        goto L7
    }

    public static String normalizeNumber(String r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L23;
        char r3 = r6.charAt(r2);
        int r4 = Character.digit(r3, 10);
        if (r4 == (-1)) goto L7;
        r0.append(r4);
    L21:
        r2 = r2 + 1;
        goto L3
    L7:
        if (r2 != 0) goto L12;
        if (r3 != '+') goto L12;
        r0.append(r3);
    L12:
        if (r3 < 'a') goto L16;
        if (r3 > 'z') goto L16;
    L20:
        return normalizeNumber(PhoneNumberUtils.convertKeypadLettersToDigits(r6));
    L16:
        if (r3 < 'A') goto L21;
        if (r3 > 'Z') goto L21;
    L23:
        return r0.toString();
    }

    public static String getUsernameFromUriNumber(String r3) {
        int r0 = r3.indexOf(64);
        if (r0 >= 0) goto L5;
        r0 = r3.indexOf("%40");
    L5:
        if (r0 >= 0) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "getUsernameFromUriNumber: no delimiter found in SIP addr '" + r3 + "'");
        return r3;
    L9:
        return r3.substring(0, r0);
    }
}
