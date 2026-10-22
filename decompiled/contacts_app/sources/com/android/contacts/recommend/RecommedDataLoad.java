package com.android.contacts.recommend;

import android.net.Uri;
import android.provider.CallLog;
import android.provider.ContactsContract;
import com.android.contacts.calllog.CallLogQuery;
import com.android.contacts.calllog.blocked.BlockedCallAdapter;
import com.android.contacts.group.GroupSelectionActivity;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
class RecommedDataLoad {

    interface CallLogDataLoad {
        public static final int CACHED_FORMATTED_NUMBER = 11;
        public static final int CACHED_LOOKUP_URI = 7;
        public static final int CACHED_MATCHED_NUMBER = 8;
        public static final int CACHED_NAME = 4;
        public static final int CACHED_NORMALIZED_NUMBER = 9;
        public static final int CACHED_NUMBER_LABEL = 6;
        public static final int CACHED_NUMBER_TYPE = 5;
        public static final int CACHED_PHOTO_ID = 10;
        public static final int COUNTRY_ISO = 3;
        public static final int FEATURES = 14;
        public static final int ID = 0;
        public static final int NUMBER = 1;
        public static final String[] PROJECTION = null;
        public static final String SELECTION = "presentation=1 AND type IN (1, 7, 2, 3)";
        public static final int SLOT_ID = 13;
        public static final int SUBSCRIPTION = 12;
        public static final int TYPE = 2;
        public static final Uri URI = null;

        static {
            PROJECTION = new String[]{"_id", "number", "type", "countryiso", "name", "numbertype", "numberlabel", BlockedCallAdapter.KEY_LOOKUP_URI, "matched_number", "normalized_number", "photo_id", "formatted_number", CallLogQuery.COLUMN_SUBSCRIPTION, "sim_id", "features"};
            URI = CallLog.Calls.CONTENT_URI.buildUpon().appendPath("group_by_number").build();
        }
    }

    interface FavoriteDataLoad {
        public static final int CONTACT_ID = 10;
        public static final int CUSTOM_LABEL_RES = 3;
        public static final int DATA1 = 1;
        public static final int DATA4 = 4;
        public static final int DATA_ID = 6;
        public static final int DISPLAY_NAME = 9;
        public static final int INDEX = 5;
        public static final int LOOKUP_KEY = 8;
        public static final int PHONE_LABEL = 2;
        public static final int PHOTO_ID = 7;
        public static final int PHOTO_URI = 11;
        public static final String[] PROJECTION = null;
        public static final int RAW_CONTACT_ID = 0;
        public static final String SELECTION = "data15 = 1 AND mimetype='vnd.android.cursor.item/phone_v2'";
        public static final Uri URI = null;

        static {
            PROJECTION = new String[]{GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "data1", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data4", "data14", "_id", "photo_id", "lookup", "display_name", "contact_id", "photo_uri"};
            URI = ContactsContract.Data.CONTENT_URI.buildUpon().appendPath("groupby_data1").build();
        }

        static String[] getFavoriteProjection(int r2) {
            if (r2 != 2) goto L5;
            PROJECTION[9] = "display_name_alt";
        L7:
            return PROJECTION;
        L5:
            PROJECTION[9] = "display_name";
            goto L7
        }
    }

    interface FrequentDataLoad {
        public static final int CALLLOG_COUNT_PER_QUERY = 1000;
        public static final String CALLLOG_COUNT_SELECTION = "lookup_uri NOT NULL";
        public static final int CALLLOG_DATE = 3;
        public static final int CALLLOG_NUMBER = 0;
        public static final String[] CALLLOG_PROJECTION = null;
        public static final int CALLLOG_SLOT_ID = 2;
        public static final int CALLLOG_SUBSCRIPTION = 1;
        public static final Uri CALLLOG_URI = null;
        public static final int CONCTAC_ID = 0;
        public static final int LABEL = 4;
        public static final int LOOKUP_KEY = 7;
        public static final int NAME = 1;
        public static final int NORMALIZED_NUMBER = 5;
        public static final int NUMBER = 2;
        public static final int PHOTO_ID = 6;
        public static final int PHOTO_URI = 8;
        public static final String[] PROJECTION = null;
        public static final int TYPE = 3;
        public static final long VALID_TIME_MILLIS = 0;

        static {
            PROJECTION = new String[]{"contact_id", "display_name", "data1", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data4", "photo_id", "lookup", "photo_uri"};
            VALID_TIME_MILLIS = TimeUnit.DAYS.toMillis(90);
            CALLLOG_URI = CallLog.Calls.CONTENT_URI.buildUpon().appendQueryParameter("limit", String.valueOf(1000)).build();
            CALLLOG_PROJECTION = new String[]{"number", CallLogQuery.COLUMN_SUBSCRIPTION, "sim_id", "date"};
        }
    }

    RecommedDataLoad() {
    }
}
