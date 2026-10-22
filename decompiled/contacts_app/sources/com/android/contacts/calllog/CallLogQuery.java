package com.android.contacts.calllog;

import android.database.Cursor;
import com.GlobalProxyLancet;
import com.android.contacts.DSUtils;
import com.android.contacts.calllog.blocked.BlockedCallAdapter;
import com.android.contacts.util.Constants;

/* JADX INFO: loaded from: classes.dex */
public final class CallLogQuery {
    public static final int CACHED_FORMATTED_NUMBER = 15;
    public static final int CACHED_LOOKUP_URI = 11;
    public static final int CACHED_MATCHED_NUMBER = 12;
    public static final int CACHED_NAME = 8;
    public static final int CACHED_NORMALIZED_NUMBER = 13;
    public static final int CACHED_NUMBER_LABEL = 10;
    public static final int CACHED_NUMBER_TYPE = 9;
    public static final int CACHED_PHOTO_ID = 14;
    public static final int CALL_TYPE = 4;
    public static final String COLUMN_SHOW_SIM_ICON = "show_sim_icon";
    public static final String COLUMN_SIM_ID = "sim_id";
    public static final String COLUMN_SUBSCRIPTION = null;
    public static final int COUNTRY_ISO = 5;
    public static final int DATE = 2;
    public static final int DURATION = 3;
    public static final String[] EXTENDED_PROJECTION = null;
    public static final int FEATURES = 0;
    public static final int GEOCODED_LOCATION = 7;
    public static final int ID = 0;
    public static final int IS_BLOCKED = 29;
    public static final int IS_READ = 16;
    public static final int NUMBER = 1;
    public static final int PRESENTATION = 17;
    public static final String[] PROJECTION_N = null;
    public static final int RECORD_URI = 30;
    public static final int SECTION = 0;
    public static final String SECTION_NAME = "section";
    public static final int SECTION_NEW_HEADER = 0;
    public static final int SECTION_NEW_ITEM = 1;
    public static final int SECTION_OLD_HEADER = 2;
    public static final int SECTION_OLD_ITEM = 3;
    public static final int SHOW_SIM_ICON = 27;
    public static final int SIM_ID = 28;
    public static final int SUBSCRIPTION = 18;
    private static final String TAG = "CallLogQuery";
    public static final int VOICEMAIL_URI = 6;
    public static final String[] _PROJECTION = null;
    public static final String[] _PROJECTION_ANDROID44 = null;
    public static final String[] _PROJECTION_ANDROID50 = null;

    public static boolean isSectionHeader(Cursor r0) {
        return false;
    }

    public CallLogQuery() {
    }

    static {
        if (Constants.ANDROID50 == false) goto L5;
        String r0 = "subscription_id";
    L6:
        COLUMN_SUBSCRIPTION = r0;
        int r1 = 23;
        _PROJECTION_ANDROID44 = new String[]{"_id", "number", "date", "duration", "type", "countryiso", "voicemail_uri", "geocoded_location", "name", "numbertype", "numberlabel", BlockedCallAdapter.KEY_LOOKUP_URI, "matched_number", "normalized_number", "photo_id", "formatted_number", "is_read", "presentation", r0, COLUMN_SHOW_SIM_ICON, "sim_id", "is_blocked", "record_uri"};
        _PROJECTION_ANDROID50 = new String[]{"_id", "number", "date", "duration", "type", "countryiso", "voicemail_uri", "geocoded_location", "name", "numbertype", "numberlabel", BlockedCallAdapter.KEY_LOOKUP_URI, "matched_number", "normalized_number", "photo_id", "formatted_number", "is_read", "presentation", r0, COLUMN_SHOW_SIM_ICON, "sim_id", "is_blocked", "record_uri", "features"};
        String[] r2 = {"_id", "number", "date", "duration", "type", "countryiso", "voicemail_uri", "geocoded_location", "name", "numbertype", "numberlabel", BlockedCallAdapter.KEY_LOOKUP_URI, "matched_number", "normalized_number", "photo_id", "formatted_number", "is_read", "presentation", "subscription_component_name", "subscription_id", "features", "data_usage", "transcription", "photo_uri", "post_dial_digits", "via_number", r0, COLUMN_SHOW_SIM_ICON, "sim_id", "is_blocked", "record_uri", "features"};
        PROJECTION_N = r2;
        _PROJECTION = r2;
        if (Constants.ANDROID50 == false) goto L9;
        int r3 = 31;
    L10:
        FEATURES = r3;
        if (Constants.ANDROID50 == false) goto L13;
        r1 = 24;
    L13:
        SECTION = r1;
        String[] r4 = new String[r2.length + 1];
        EXTENDED_PROJECTION = r4;
        System.arraycopy(r2, 0, r4, 0, r2.length);
        r4[r2.length] = SECTION_NAME;
        return;
    L9:
        r3 = -1;
        goto L10
    L5:
        r0 = DSUtils.SUBSCRIPTION_KEY;
        goto L6
    }

    public static boolean isNewSection(Cursor r1) {
        int r2 = r1.getInt(SECTION);
        if (r2 == 1) goto L8;
        if (r2 == 0) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    public static int getSubscription(Cursor r5) {
        if (r5 == null) goto L21;
        int r1 = r5.getColumnIndex(COLUMN_SUBSCRIPTION);
        if (r1 != (-1)) goto L7;
        return -1;
    L7:
        if (r5.isNull(r1) == true) goto L23;
        int r2 = r5.getType(r1);
        if (r2 != 1) goto L12;
        return r5.getInt(r1);
    L12:
        if (r2 == 3) goto L19;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Subscription has invalid type.");
        return -1;
    L19:
        return Integer.valueOf(r5.getString(r1)).intValue();
    L15:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Subscription has invalid value." + e.getMessage());
        return -1;
    L23:
        return -1;
    L21:
        return -1;
    }

    public static boolean isVideoCall(Cursor r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        int r1 = FEATURES;
        if (r1 != (-1)) goto L8;
    L11:
        return false;
    L8:
        if ("1".equals(r3.getString(r1)) == false) goto L11;
        return true;
    }
}
