package com.android.contacts.common.util;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.contacts.common.R;
import com.android.contacts.common.list.ContactListFilter;

/* JADX INFO: loaded from: classes.dex */
public class AccountFilterUtil {
    private static final String TAG = "AccountFilterUtil";

    static {
    }

    public AccountFilterUtil() {
    }

    public static boolean updateAccountFilterTitleForPeople(View r1, ContactListFilter r2, boolean r3) {
        return updateAccountFilterTitle(r1, r2, r3, false);
    }

    public static boolean updateAccountFilterTitleForPhone(View r1, ContactListFilter r2, boolean r3) {
        return updateAccountFilterTitle(r1, r2, r3, true);
    }

    private static boolean updateAccountFilterTitle(View r7, ContactListFilter r8, boolean r9, boolean r10) {
        Context r0 = r7.getContext();
        TextView r11 = (TextView) r7.findViewById(R.id.account_filter_header);
        if (r8 != null) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Filter is null.");
        return false;
    L5:
        if (r10 == false) goto L18;
        if (r8.filterType != (-2)) goto L11;
        if (r9 == false) goto L34;
        r11.setText(R.string.list_filter_phones);
    L37:
        return true;
    L34:
        return false;
    L11:
        if (r8.filterType != 0) goto L14;
        r11.setText(r0.getString(R.string.listAllContactsInAccount, new Object[]{r8.accountName}));
        goto L37
    L14:
        if (r8.filterType != (-3)) goto L16;
        r11.setText(R.string.listCustomView);
        goto L37
    L16:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Filter type \"" + r8.filterType + "\" isn't expected.");
        return false;
    L18:
        if (r8.filterType != (-2)) goto L22;
        if (r9 == false) goto L36;
        r11.setText(R.string.common_all_contacts);
        goto L37
    L36:
        return false;
    L22:
        if (r8.filterType != 0) goto L26;
        r11.setText(r0.getString(R.string.listAllContactsInAccount, new Object[]{r8.accountName}));
        goto L37
    L26:
        if (r8.filterType != (-3)) goto L29;
        r11.setText(R.string.listCustomView);
        goto L37
    L29:
        if (r8.filterType != (-6)) goto L31;
        r11.setText(R.string.listSingleContact);
        goto L37
    L31:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Filter type \"" + r8.filterType + "\" isn't expected.");
        return false;
    }
}
