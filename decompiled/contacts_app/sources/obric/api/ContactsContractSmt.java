package obric.api;

import android.provider.ContactsContract;
import com.android.contacts.obricsync.SyncContractKt;
import com.android.contacts.util.BytedanceContactContract;

/* JADX INFO: loaded from: classes5.dex */
public class ContactsContractSmt {
    public static final String EXTRA_PHONE_IDS = "com.android.contacts.extra.PHONE_IDS";
    public static final int PROTOCOL_MOMO = 101;
    public static final int PROTOCOL_WANGWANG = 102;
    public static final int PROTOCOL_WECHAT = 100;
    public static final int TYPE_CLASS_MATE = 101;
    public static final int TYPE_WORK_MATE = 100;

    public static String get_BASE_URI() {
        return ContactContantsSmt.BASE_URI;
    }

    public static String get_EXTRA_PHONE_IDS() {
        return "com.android.contacts.extra.PHONE_IDS";
    }

    public static int get_IM_PROTOCOL_MOMO() {
        return 101;
    }

    public static int get_IM_PROTOCOL_WANGWANG() {
        return 102;
    }

    public static int get_IM_PROTOCOL_WECHAT() {
        return 100;
    }

    public static String get_INSERT_ACCOUNT() {
        return "com.android.contacts.extra.ACCOUNT";
    }

    public static String get_INSERT_DATA_SET() {
        return "com.android.contacts.extra.DATA_SET";
    }

    public static String get_INSERT_WEBSITE() {
        return SyncContractKt.COLUMN_WEBSITE;
    }

    public static String get_LAST_MODIFY_TIME() {
        return BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME_PINYIN;
    }

    public static String get_NAME_VERIFIED() {
        return "name_verified";
    }

    public static String get_ProviderStatus_DATA1() {
        return "data1";
    }

    public static int get_RELATION_TYPE_CLASS_MATE() {
        return 101;
    }

    public static int get_RELATION_TYPE_WORK_MATE() {
        return 100;
    }

    public static int get_STATUS_CHANGING_LOCALE() {
        return 3;
    }

    public static int get_STATUS_NO_ACCOUNTS_NO_CONTACTS() {
        return 4;
    }

    public static int get_STATUS_UPGRADE_OUT_OF_MEMORY() {
        return 2;
    }

    public static int get_STATUS_UPGRADING() {
        return 1;
    }

    public static String get_UI_FILTER_CONTACTS_ACTION() {
        return "com.android.contacts.action.FILTER_CONTACTS";
    }

    public static String get_UI_FILTER_TEXT_EXTRA_KEY() {
        return "com.android.contacts.extra.FILTER_TEXT";
    }

    public static String get_UI_LIST_ALL_CONTACTS_ACTION() {
        return "com.android.contacts.action.LIST_ALL_CONTACTS";
    }

    public static String get_UI_LIST_CONTACTS_WITH_PHONES_ACTION() {
        return "com.android.contacts.action.LIST_CONTACTS_WITH_PHONES";
    }

    public static String get_UI_LIST_DEFAULT() {
        return "com.android.contacts.action.LIST_DEFAULT";
    }

    public static String get_UI_LIST_FREQUENT_ACTION() {
        return "com.android.contacts.action.LIST_FREQUENT";
    }

    public static String get_UI_LIST_GROUP_ACTION() {
        return "com.android.contacts.action.LIST_GROUP";
    }

    public static String get_UI_LIST_STARRED_ACTION() {
        return "com.android.contacts.action.LIST_STARRED";
    }

    public static String get_UI_LIST_STREQUENT_ACTION() {
        return "com.android.contacts.action.LIST_STREQUENT";
    }

    public static String get_UI_TITLE_EXTRA_KEY() {
        return "com.android.contacts.extra.TITLE_EXTRA";
    }

    public ContactsContractSmt() {
    }

    public static void addParameterForAggregationSuggestions(ContactsContract.Contacts.AggregationSuggestions.Builder r0, String r1) {
        ContactsContractBuilderApi.addNameParamater(r0, r1);
    }
}
