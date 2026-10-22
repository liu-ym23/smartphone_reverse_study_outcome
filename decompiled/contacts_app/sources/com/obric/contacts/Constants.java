package com.obric.contacts;

import android.R;
import com.android.contacts.util.BytedanceContactContract;
import obric.api.IntentSmt;

/* JADX INFO: loaded from: classes3.dex */
public class Constants {
    public static final String CONTACTS_WITH_PHONES_ONLY = "list_contacts_with_phones_only";
    public static final int[] ContactsDataKind = null;
    public static final int ContactsDataKind_allContactsName = 5;
    public static final int ContactsDataKind_detailColumn = 3;
    public static final int ContactsDataKind_detailSocialSummary = 4;
    public static final int ContactsDataKind_icon = 0;
    public static final int ContactsDataKind_mimeType = 1;
    public static final int ContactsDataKind_summaryColumn = 2;
    public static final String FUZZY_TONES_ENABLED = "fuzzy_tones_enabled";
    public static final String HARDWARE_DETAIL_INFO = "hardware_detail_info";
    public static final int PROTOCOL_WECHAT = 100;
    public static final int[] ViewGroup_Layout = null;
    public static final int ViewGroup_Layout_layout_height = 1;
    public static final int ViewGroup_Layout_layout_width = 0;

    public static final String get_EXTRA_BYTEDANCE_ANIM_RESOURCE_ID() {
        return IntentSmt.EXTRA_BYTEDANCE_ANIM_RESOURCE_ID;
    }

    public static String get_INSERT_ACCOUNT() {
        return "com.android.contacts.extra.ACCOUNT";
    }

    public static String get_INSERT_DATA_SET() {
        return "com.android.contacts.extra.DATA_SET";
    }

    public static String get_LAST_MODIFY_TIME() {
        return BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME_PINYIN;
    }

    public Constants() {
    }

    static {
        ContactsDataKind = new int[]{R.attr.icon, R.attr.mimeType, R.attr.summaryColumn, R.attr.detailColumn, R.attr.detailSocialSummary, R.attr.allContactsName};
        ViewGroup_Layout = new int[]{R.attr.layout_width, R.attr.layout_height};
    }
}
