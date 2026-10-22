package com.android.contacts.util;

import obric.api.TelephonySmt;

/* JADX INFO: loaded from: classes2.dex */
public class Constants {
    public static final String ACTION_IMS_REGISTERED = "com.android.phone.ACTION_IMS_REGISTERED";
    public static final String ADDRESS_BOOK_INDEX_EXTRAS = "address_book_index_extras";
    public static final int ADDRESS_EDIT_CONTEXT_MAX_LENGHT = 200;
    public static boolean ANDROID50 = false;
    public static boolean ANDROID60 = false;
    public static boolean ANDROID70 = false;
    public static boolean ANDROID80 = false;
    public static final String AUTH_TYPE_GOOGLE = "com.google";
    public static final int AVATAR_STANDARD_SIZE = 144;
    public static final int BIDIRECTIONAL = 3;
    public static final int BYTEDANCEOS_DISPLAY_PHOTO_DIM = 520;
    public static final String CLOUDSYNC_PACKAGE_NAME = "com.bytedanceos.cloudsync";
    public static final String CONTACTS_PACKAGE_NAME = "com.android.contacts";
    public static final String DEFERRED_SNIPPETING_KEY = "deferred_snippeting";
    public static final int DUMMY_CONTACT_ID = 0;
    public static final String DUMMY_LOOKUP_KEY_PREFIX = "***";
    public static final int DUMMY_TYPE_NONE = 0;
    public static final int DUMMY_TYPE_SAVED = 2;
    public static final int DUMMY_TYPE_UNSAVED = 1;
    public static final int EDIT_CONTEXT_MAX_LENGTH = 100;
    public static final int EDIT_CONTEXT_MAX_LENGTH_1 = 40;
    public static final String EMAIL_PACKAGE_NAME = "com.android.email";
    public static final String EXTRA_FROM_SETTINGS = "from_settings";
    public static final String EXTRA_REGISTERED = "imsRegistered";
    public static final String EXTRA_SOURCE_LAUNCH = "launch_source";
    public static final String EXTRA_START_CALL_WITH_VIDEO_STATE = "android.telecom.extra.START_CALL_WITH_VIDEO_STATE";
    public static int HANDMODE = 0;
    public static final int HAND_LEFT_MODE = 0;
    public static final int HAND_RIGHT_MODE = 1;
    public static final String LOCAL_MIXED_ACCOUNT_NAME = "mixed_account_name";
    public static final String LOCAL_MIXED_ACCOUNT_TYPE = "mixed_account_type";
    public static final long LOCAL_MIXED_RAW_CONTACT_ID = -115;
    public static final String LOOKUP_URI_ENCODED = "encoded";
    public static final String MIME_TYPE_VIDEO_CHAT = "vnd.android.cursor.item/video-chat-address";
    public static final String PACKAGE_MEDIA = "com.android.providers.media";
    public static final String PACKAGE_NAME_CAMARA = "com.obric.camera2";
    public static final String PACKAGE_NAME_GALLERY = "com.android.gallery3d";
    public static final String PERFORMANCE_TAG = "ContactsPerf";
    public static final String PHONE_PACKAGE_NAME = null;
    public static final String QUICK_ACCESS_CONTACTS_KEY = "quick_access_contacts";
    public static final int RX_ENABLED = 2;
    public static final String SCHEME_IMTO = "imto";
    public static final String SCHEME_MAILTO = "mailto";
    public static final String SCHEME_SIP = "sip";
    public static final String SCHEME_SMSTO = "smsto";
    public static final String SCHEME_TEL = "tel";
    public static final String SNIPPET = "snippet";
    public static final String SNIPPET_ARGS_PARAM_KEY = "snippet_args";
    public static final String SOURCE_LAUNCH_BY_MINUS_SCREEN = "launcher_left_screen";
    public static final String STRICT_MODE_TAG = "ContactsStrictMode";
    public static final int TX_ENABLED = 1;
    public static final String URI_CONTACT_DATA = "content://com.android.contacts/data/";
    public static final String WEIXIN_MIMETYPE = "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile";
    public static final String WEIXIN_PACKAGE_NAME = "com.tencent.mm";

    public class ContactsColumns {
        public static final String PHONEBOOK_BUCKET_ALTERNATIVE = "phonebook_bucket_alt";
        public static final String PHONEBOOK_BUCKET_PRIMARY = "phonebook_bucket";
        public static final String PHONEBOOK_LABEL_ALTERNATIVE = "phonebook_label_alt";
        public static final String PHONEBOOK_LABEL_PRIMARY = "phonebook_label";
        final /* synthetic */ Constants this$0;

        public ContactsColumns(Constants r1) {
            this.this$0 = r1;
        }
    }

    public interface ContactsTracker {
        public static final String CONTACTS_SORT_BY_COMPANY = "EVENT_CONTACTS_SORT_BY_COMPANY";
        public static final String CONTACTS_SORT_BY_FREQUENCY = "EVENT_CONTACTS_SORT_BY_FREQUENCY";
        public static final String CONTACTS_SORT_BY_LOCATION = "EVENT_CONTACTS_SORT_BY_LOCATION";
        public static final String CONTACTS_SORT_BY_NAME = "EVENT_CONTACTS_SORT_BY_NAME";
        public static final String CONTACTS_SORT_BY_SCAN = "EVENT_CONTACTS_SORT_BY_SCAN";
        public static final String CONTACTS_SORT_BY_TIME = "EVENT_CONTACTS_SORT_BY_TIME";
        public static final String CONTACTS_SORT_TYPE = "CONTACTS_SORT_TYPE";
        public static final String EVENT_ALL_CALL_LOG = "EVENT_ALL_CALL_LOG";
        public static final String EVENT_CALL = "EVENT_CALL";
        public static final String EVENT_CALL_BUTTON = "EVENT_CALL_BUTTON";
        public static final String EVENT_CALL_CALL_LOG = "EVENT_CALL_CALL_LOG";
        public static final String EVENT_CALL_CALL_LOG_ICON = "EVENT_CALL_CALL_LOG_ICON";
        public static final String EVENT_CALL_ICON = "EVENT_CALL_ICON";
        public static final String EVENT_CALL_SEARCH_RESULT_CALL_LOG = "EVENT_CALL_SEARCH_RESULT_CALL_LOG";
        public static final String EVENT_CALL_SEARCH_RESULT_CALL_LOG_ICON = "EVENT_CALL_SEARCH_RESULT_CALL_LOG_ICON";
        public static final String EVENT_CALL_SEARCH_RESULT_CONTACT = "EVENT_CALL_SEARCH_RESULT_CONTACT";
        public static final String EVENT_CALL_SEARCH_RESULT_CONTACT_ICON = "EVENT_CALL_SEARCH_RESULT_CONTACT_ICON";
        public static final String EVENT_CONTACTS_COMPANY_QUERY_CLICK = "EVENT_CONTACTS_COMPANY_QUERY_CLICK";
        public static final String EVENT_CONTACTS_IMPORT_EXPORT_COUNT = "EVENT_CONTACTS_IMPORT_EXPORT_COUNT";
        public static final String EVENT_DELETE_CALL_LOG = "EVENT_DELETE_CALL_LOG";
        public static final String EVENT_DELETE_CONTACTS = "EVENT_DELETE_CONTACTS";
        public static final String EVENT_DELETE_FAVORITE = "EVENT_DELETE_FAVORITE";
        public static final String EVENT_EDIT_ALL_CONTACTS = "EVENT_EDIT_ALL_CONTACTS";
        public static final String EVENT_EDIT_CALL_LOG = "EVENT_EDIT_CALL_LOG";
        public static final String EVENT_EDIT_FAVORITE = "EVENT_EDIT_FAVORITE";
        public static final String EVENT_FREE_CALL = "EVENT_FREE_CALL";
        public static final String EVENT_JOIN_BLACKLIST = "EVENT_JOIN_BLACKLIST";
        public static final String EVENT_JOIN_BLACKLIST_ICON = "EVENT_JOIN_BLACKLIST_ICON";
        public static final String EVENT_LAUNCH_YELLOW_PAGE = "EVENT_LAUNCH_YELLOW_PAGE";
        public static final String EVENT_MISSED_CALL_LOG = "EVENT_MISSED_CALL_LOG";
        public static final String EVENT_NEW_CONTACT = "EVENT_NEW_CONTACT";
        public static final String EVENT_NEW_GROUP = "EVENT_NEW_GROUP";
        public static final String EVENT_QR_CODE = "EVENT_QR_CODE";
        public static final String EVENT_QUICK_BAR_BUBBLE = "EVENT_QUICK_BAR_BUBBLE";
        public static final String EVENT_QUICK_BAR_GRID = "EVENT_QUICK_BAR_GRID";
        public static final String EVENT_QUICK_BAR_GRID_LONG_CLICK = "EVENT_QUICK_BAR_GRID_LONG_CLICK";
        public static final String EVENT_SEARCH_RESULT_ITEM = "EVENT_SEARCH_RESULT_ITEM";
        public static final String EVENT_SELECT_ALL_CONTACTS = "EVENT_SELECT_ALL_CONTACTS";
        public static final String EVENT_SEND_MMS = "EVENT_SEND_MMS";
        public static final String EVENT_SHARE = "EVENT_SHARE";
        public static final String EVENT_SORT_DISPLAY_COUNT = "EVENT_SORT_DISPLAY_COUNT";
        public static final String EVENT_STAR = "EVENT_STAR";
        public static final String EVENT_START_SEARCH = "EVENT_START_SEARCH";
        public static final String EVENT_WECHAT = "EVENT_WECHAT";
        public static final String EVENT_WECHAT_FROM_CONTACT_DETAIL = "EVENT_WECHAT_FROM_CONTACT_DETAIL";
        public static final String EXTRA_SOURCE_FOR_TRACKER = "EXTRA_SOURCE_FOR_TRACKER";
        public static final String FROM_SORT_BY_DATE = "_FROM_LIST_DATE";
        public static final String FROM_SORT_BY_FREQUENCY = "_FROM_LIST_FREQUENCY";
        public static final String FROM_SORT_BY_LOCATION = "_FROM_LIST_LOCATION";
        public static final String FROM_SORT_BY_NAME = "_FROM_LIST_NAME";
        public static final String QUICK_BAR = "QUICK_BAR";
        public static final String QUICK_BAR_SHAFT = "EVENT_QUICK_BAR_SHAFT";
        public static final String STATUS_HIDE_EMAIL_CONTACTS = "STATUS_HIDE_EMAIL_CONTACTS";
        public static final String SUFFIX_FROM_LIST_GROUP = "_FROM_LIST_GROUP";
        public static final String SUFFIX_FROM_LIST_SEARCH_RESULT_ITEM = "_FROM_LIST_SEARCH_RESULT_ITEM";
    }

    public static final class Preferences {
        public static final String DISPLAY_ORDER = "android.contacts.DISPLAY_ORDER";
        public static final int DISPLAY_ORDER_ALTERNATIVE = 2;
        public static final int DISPLAY_ORDER_PRIMARY = 1;
        public static final String SORT_ORDER = "android.contacts.SORT_ORDER";
        public static final int SORT_ORDER_ALTERNATIVE = 2;
        public static final int SORT_ORDER_PRIMARY = 1;

        public Preferences() {
        }
    }

    public Constants() {
    }

    static {
        ANDROID50 = true;
        ANDROID60 = true;
        ANDROID70 = true;
        ANDROID80 = true;
        if (ANDROID50 == false) goto L5;
        String r0 = TelephonySmt.MISSED_CALL_NOTIFICATION_PACKAGE_NAME;
    L6:
        PHONE_PACKAGE_NAME = r0;
        HANDMODE = 0;
        return;
    L5:
        r0 = TelephonySmt.DEFAULT_NOTIFICATION_PACKAGE_NAME;
        goto L6
    }
}
