package com.android.contacts.recyclebin;

import android.net.Uri;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.pick.PickerFragment;
import com.android.contacts.util.BytedanceContactContract;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes2.dex */
public class RecycleBinConstants {
    public static final String AUTHORITY = "contacts_recycle_bin";
    private static String CALLING_APPLICATION_LABEL;
    public static String CALLING_PACKAGE;
    public static Uri DATA_URI;
    public static Uri RAW_CONTACTS_ID_URI;
    public static Uri RAW_CONTACTS_URI;
    private static String RECYCLE_DATE;

    public static class DataQuery {
        public static final int DATA1 = 6;
        public static final int DATA10 = 15;
        public static final int DATA11 = 16;
        public static final int DATA12 = 17;
        public static final int DATA13 = 18;
        public static final int DATA14 = 19;
        public static final int DATA15 = 20;
        public static final int DATA2 = 7;
        public static final int DATA3 = 8;
        public static final int DATA4 = 9;
        public static final int DATA5 = 10;
        public static final int DATA6 = 11;
        public static final int DATA7 = 12;
        public static final int DATA8 = 13;
        public static final int DATA9 = 14;
        public static final String[] DATA_PROJECTION = null;
        public static final int ID = 0;
        public static final int IS_PRIMARY = 4;
        public static final int IS_READ_ONLY = 3;
        public static final int IS_SUPER_PRIMARY = 5;
        public static final int MIMETYPE = 2;
        public static final int RAW_CONTACT_ID = 1;

        public DataQuery() {
        }

        static {
            DATA_PROJECTION = new String[]{"_id", GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "mimetype", "is_read_only", "is_primary", "is_super_primary", "data1", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data4", "data5", "data6", "data7", "data8", "data9", "data10", "data11", BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME, BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME_PINYIN, "data14", BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG};
        }
    }

    public static class RawContactQuery {
        public static final int CALLING_APPLICATION_LABEL_COL = 7;
        public static final int CALLING_PACKAGE_COL = 6;
        public static final String[] CONTACT_PROJECTION_ALTERNATIVE_ALTERNATIVE = null;
        public static final String[] CONTACT_PROJECTION_ALTERNATIVE_PRIMARY = null;
        public static final String[] CONTACT_PROJECTION_PRIMARY_ALTERNATIVE = null;
        public static final String[] CONTACT_PROJECTION_PRIMARY_PRIMARY = null;
        public static final int RAW_CONTACT_ACCOUNT_NAME = 3;
        public static final int RAW_CONTACT_ACCOUNT_TYPE = 4;
        public static final int RAW_CONTACT_DATA_SET = 5;
        public static final int RAW_CONTACT_DISPLAY_NAME = 1;
        public static final int RAW_CONTACT_ID = 0;
        public static final int RAW_CONTACT_SORT_KEY = 2;
        public static final int RECYCLE_DATE_COL = 8;

        public RawContactQuery() {
        }

        static {
            CONTACT_PROJECTION_PRIMARY_PRIMARY = new String[]{"_id", "display_name", PickerFragment.CONTACT_SORT_CNAME, "account_name", "account_type", "data_set", RecycleBinConstants.CALLING_PACKAGE, RecycleBinConstants.access$000(), RecycleBinConstants.access$100()};
            CONTACT_PROJECTION_PRIMARY_ALTERNATIVE = new String[]{"_id", "display_name", "sort_key_alt", "account_name", "account_type", "data_set", RecycleBinConstants.CALLING_PACKAGE, RecycleBinConstants.access$000(), RecycleBinConstants.access$100()};
            CONTACT_PROJECTION_ALTERNATIVE_PRIMARY = new String[]{"_id", "display_name_alt", PickerFragment.CONTACT_SORT_CNAME, "account_name", "account_type", "data_set", RecycleBinConstants.CALLING_PACKAGE, RecycleBinConstants.access$000(), RecycleBinConstants.access$100()};
            CONTACT_PROJECTION_ALTERNATIVE_ALTERNATIVE = new String[]{"_id", "display_name_alt", "sort_key_alt", "account_name", "account_type", "data_set", RecycleBinConstants.CALLING_PACKAGE, RecycleBinConstants.access$000(), RecycleBinConstants.access$100()};
        }
    }

    public RecycleBinConstants() {
    }

    static /* synthetic */ String access$000() {
        return CALLING_APPLICATION_LABEL;
    }

    static /* synthetic */ String access$100() {
        return RECYCLE_DATE;
    }

    static {
        RAW_CONTACTS_URI = Uri.parse("content://contacts_recycle_bin/raw_contacts");
        DATA_URI = Uri.parse("content://contacts_recycle_bin/data");
        RAW_CONTACTS_ID_URI = Uri.parse("content://contacts_recycle_bin/raw_contact");
        CALLING_PACKAGE = "calling_package";
        CALLING_APPLICATION_LABEL = "calling_application_label";
        RECYCLE_DATE = "recycle_date";
    }
}
