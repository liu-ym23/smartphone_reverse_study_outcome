package com.android.contacts.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Patterns;
import com.GlobalProxyLancet;
import com.android.contacts.common.R;
import com.android.contacts.common.compat.PhoneNumberUtilsCompat;
import com.android.contacts.common.preference.ContactsPreferences;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class ContactDisplayUtils {
    public static final int INTERACTION_CALL = 1;
    public static final int INTERACTION_SMS = 2;
    private static final String TAG = "ContactDisplayUtils";

    static {
    }

    public ContactDisplayUtils() {
    }

    public static boolean isCustomPhoneType(Integer r1) {
        if (r1.intValue() != 0) goto L5;
    L8:
        return true;
    L5:
        if (r1.intValue() == 19) goto L8;
        return false;
    }

    public static CharSequence getLabelForCallOrSms(Integer r2, CharSequence r3, int r4, Context r5) {
        Preconditions.checkNotNull(r5);
        if (isCustomPhoneType(r2) == false) goto L8;
        if (r3 != null) goto L15;
        return "";
    L15:
        return r3;
    L8:
        if (r4 != 2) goto L10;
        int r6 = getSmsLabelResourceId(r2);
    L14:
        return r5.getResources().getText(r6);
    L10:
        r6 = getPhoneLabelResourceId(r2);
        if (r4 == 1) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Un-recognized interaction type: " + r4 + ". Defaulting to ContactDisplayUtils.INTERACTION_CALL.");
        goto L14
    }

    public static int getPhoneLabelResourceId(Integer r0) {
        if (r0 != null) goto L6;
        return R.string.call_other;
    L6:
        switch(r0.intValue()) {
            case 1: goto L48;
            case 2: goto L46;
            case 3: goto L44;
            case 4: goto L42;
            case 5: goto L40;
            case 6: goto L38;
            case 7: goto L36;
            case 8: goto L34;
            case 9: goto L32;
            case 10: goto L30;
            case 11: goto L28;
            case 12: goto L26;
            case 13: goto L24;
            case 14: goto L22;
            case 15: goto L20;
            case 16: goto L18;
            case 17: goto L16;
            case 18: goto L14;
            case 19: goto L12;
            case 20: goto L10;
            default: goto L8;
        };
    L8:
        return R.string.common_call_value;
    L10:
        return R.string.call_mms;
    L12:
        return R.string.common_call_value;
    L14:
        return R.string.call_work_pager;
    L16:
        return R.string.call_work_mobile;
    L18:
        return R.string.call_tty_tdd;
    L20:
        return R.string.call_telex;
    L22:
        return R.string.call_radio;
    L24:
        return R.string.call_other_fax;
    L26:
        return R.string.call_main;
    L28:
        return R.string.call_isdn;
    L30:
        return R.string.call_company_main;
    L32:
        return R.string.call_car;
    L34:
        return R.string.call_callback;
    L36:
        return R.string.call_other;
    L38:
        return R.string.call_pager;
    L40:
        return R.string.call_fax_home;
    L42:
        return R.string.call_fax_work;
    L44:
        return R.string.call_work;
    L46:
        return R.string.call_mobile;
    L48:
        return R.string.call_home;
    }

    public static int getSmsLabelResourceId(Integer r0) {
        if (r0 != null) goto L6;
        return R.string.common_send_sms;
    L6:
        switch(r0.intValue()) {
            case 1: goto L48;
            case 2: goto L46;
            case 3: goto L44;
            case 4: goto L42;
            case 5: goto L40;
            case 6: goto L38;
            case 7: goto L36;
            case 8: goto L34;
            case 9: goto L32;
            case 10: goto L30;
            case 11: goto L28;
            case 12: goto L26;
            case 13: goto L24;
            case 14: goto L22;
            case 15: goto L20;
            case 16: goto L18;
            case 17: goto L16;
            case 18: goto L14;
            case 19: goto L12;
            case 20: goto L10;
            default: goto L8;
        };
    L8:
        return R.string.sms_custom;
    L10:
        return R.string.sms_mms;
    L12:
        return R.string.sms_assistant;
    L14:
        return R.string.sms_work_pager;
    L16:
        return R.string.sms_work_mobile;
    L18:
        return R.string.sms_tty_tdd;
    L20:
        return R.string.sms_telex;
    L22:
        return R.string.sms_radio;
    L24:
        return R.string.sms_other_fax;
    L26:
        return R.string.sms_main;
    L28:
        return R.string.sms_isdn;
    L30:
        return R.string.sms_company_main;
    L32:
        return R.string.sms_car;
    L34:
        return R.string.sms_callback;
    L36:
        return R.string.common_send_sms;
    L38:
        return R.string.sms_pager;
    L40:
        return R.string.sms_fax_home;
    L42:
        return R.string.sms_fax_work;
    L44:
        return R.string.sms_work;
    L46:
        return R.string.sms_mobile;
    L48:
        return R.string.sms_home;
    }

    public static boolean isPossiblePhoneNumber(CharSequence r1) {
        if (r1 != null) goto L5;
        return false;
    L5:
        return Patterns.PHONE.matcher(r1.toString()).matches();
    }

    public static Spannable getTelephoneTtsSpannable(String r5, String r6) {
        if (r5 != null) goto L5;
        return null;
    L5:
        SpannableString r0 = new SpannableString(r5);
        if (r6 != null) goto L8;
        int r1 = -1;
    L9:
        if (r1 < 0) goto L11;
        int r2 = r6.length() + r1;
        r0.setSpan(PhoneNumberUtilsCompat.createTtsSpan(r6), r1, r2, 33);
        r1 = r5.indexOf(r6, r2);
        goto L9
    L11:
        return r0;
    L8:
        r1 = r5.indexOf(r6);
        goto L9
    }

    public static CharSequence getTtsSpannedPhoneNumber(Resources r2, int r3, String r4) {
        return getTelephoneTtsSpannable(r2.getString(r3, new Object[]{r4}), r4);
    }

    public static String getPreferredDisplayName(String r2, String r3, ContactsPreferences r4) {
        if (r4 != null) goto L8;
        if (r2 == null) goto L6;
        return r2;
    L6:
        return r3;
    L8:
        if (r4.getDisplayOrder() != 1) goto L11;
        return r2;
    L11:
        if (r4.getDisplayOrder() == 2) goto L13;
    L15:
        return r2;
    L13:
        if (TextUtils.isEmpty(r3) == true) goto L15;
        return r3;
    }

    public static String getPreferredSortName(String r2, String r3, ContactsPreferences r4) {
        if (r4 != null) goto L8;
        if (r2 == null) goto L6;
        return r2;
    L6:
        return r3;
    L8:
        if (r4.getSortOrder() != 1) goto L11;
        return r2;
    L11:
        if (r4.getSortOrder() == 2) goto L13;
    L15:
        return r2;
    L13:
        if (TextUtils.isEmpty(r3) == true) goto L15;
        return r3;
    }
}
