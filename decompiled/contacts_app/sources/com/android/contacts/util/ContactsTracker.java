package com.android.contacts.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import bytedanceos.util.LogTag;
import com.android.common.io.MoreCloseables;
import com.android.contacts.ContactsUtils;
import com.android.contacts.list.ContactListFilter;
import com.android.contacts.list.ContactListFilterController;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.model.BytedanceAccountType;
import com.android.contacts.preference.ContactsPreferences;
import com.android.contacts.recyclebin.RecycleBinConstants;
import com.bytedance.apm.constant.PerfConsts;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import obric.app.tracker.Agent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ContactsTracker {
    public static final int SETTINGS_OFF = 0;
    public static final int SETTINGS_ON = 1;
    private static final String TAG = "ContactsTracker";
    private static boolean isTracked = false;

    public static final class Favorite {
        private static final String EVENT_ID = "A230006";
        private static final String KEY_TRACKER_TIME = "favorite_tracker_time";
        private Calendar mCurDate;

        private final class FavoriteBackgroundTracker extends Thread {
            private HashMap<Long, ArrayList<String>> mContactNumberMap;
            private Context mContext;
            final /* synthetic */ Favorite this$0;

            public FavoriteBackgroundTracker(Favorite r1, Context r2) {
                this.this$0 = r1;
                this.mContactNumberMap = new HashMap();
                this.mContext = r2;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                if (shouldSubmitNewData() == true) goto L5;
                return;
            L5:
                int r2 = 0;
                Cursor r3 = null;
                r3 = this.mContext.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"contact_id", "data1"}, "data15 = 1 AND mimetype='vnd.android.cursor.item/phone_v2'", null, "CAST(data14 AS DECIMAL)");     // Catch: Throwable -> L20 Exception -> L22
                int r4 = 0;
            L8:
                if (r3 == null) goto L14;
            L18:
                e = e;
                r2 = r4;
            L23:
                LogTag.d(ContactsTracker.TAG, "Favorite#onEvent JSONException: " + e);     // Catch: Throwable -> L20
                MoreCloseables.closeQuietly(r3);
                StringBuilder r10 = new StringBuilder("Favorite#onEvent count=").append(r2);
            L25:
                LogTag.d(ContactsTracker.TAG, r10.toString());
                return;
            L16:
                th = th;
                r2 = r4;
            L27:
                MoreCloseables.closeQuietly(r3);
                LogTag.d(ContactsTracker.TAG, "Favorite#onEvent count=" + r2);
                throw th;
            L10:
                if (r3.moveToNext() == false) goto L14;
                if (hasExistInMap(r3.getLong(0), r3.getString(1)) == true) goto L8;
                r4 = r4 + 1;     // Catch: Throwable -> L16 Exception -> L18
            L14:
                JSONObject r11 = new JSONObject();     // Catch: Throwable -> L16 Exception -> L18
                r11.put("collection_quantity", r4);     // Catch: Throwable -> L16 Exception -> L18
                Agent.getInstance().onEvent(Favorite.EVENT_ID, r11.toString());     // Catch: Throwable -> L16 Exception -> L18
                MoreCloseables.closeQuietly(r3);
                r10 = new StringBuilder("Favorite#onEvent count=").append(r4);
                goto L25
            L22:
                e = e;
            L20:
                th = th;
                goto L27
            }

            private boolean shouldSubmitNewData() {
                SharedPreferences r0 = PreferenceManager.getDefaultSharedPreferences(this.mContext);
                Calendar r1 = Calendar.getInstance();
                r1.setTimeInMillis(r0.getLong(Favorite.KEY_TRACKER_TIME, 0));
                if (DateUtils.isSameDay(r1, Favorite.access$000(this.this$0)) == false) goto L6;
                return false;
            L6:
                r0.edit().putLong(Favorite.KEY_TRACKER_TIME, Favorite.access$000(this.this$0).getTimeInMillis()).commit();
                return true;
            }

            private boolean hasExistInMap(long r3, String r5) {
                ArrayList<String> r0 = this.mContactNumberMap.get(Long.valueOf(r3));
                if (r0 != null) goto L7;
                ArrayList<String> r1 = new ArrayList();
                r1.add(r5);
                this.mContactNumberMap.put(Long.valueOf(r3), r1);
                return false;
            L7:
                if (hasExist(r0, r5) == false) goto L10;
                return true;
            L10:
                r0.add(r5);
                return false;
            }

            private boolean hasExist(ArrayList<String> r2, String r3) {
                if (r2 != null) goto L5;
                return false;
            L5:
                if (r2.size() == 0) goto L18;
                Iterator<String> r4 = r2.iterator();
            L9:
                if (r4.hasNext() == false) goto L19;
                if (PhoneNumberUtils.compare(r4.next(), r3) == false) goto L9;
                return true;
            L19:
                return false;
            L18:
                return false;
            }
        }

        public Favorite() {
        }

        static /* synthetic */ Calendar access$000(Favorite r0) {
            return r0.mCurDate;
        }

        public static void onEvent(Context r1) {
            new Favorite().onBackgroundEvent(r1);
        }

        private final void onBackgroundEvent(Context r3) {
            Calendar r0 = Calendar.getInstance();
            if (r3 != null) goto L5;
            return;
        L5:
            if (DateUtils.isSameDay(this.mCurDate, r0) == true) goto L9;
            this.mCurDate = r0;
            new FavoriteBackgroundTracker(this, r3).start();
            return;
        }
    }

    public static final class Recommend {
        private static final String EVENT_ID = "A230007";

        public interface Source {
            public static final int CONTACTLIST = 0;
            public static final int DIALPAD = 1;
        }

        public Recommend() {
        }

        public static final void onEvent(int r3, int r4) {
            LogTag.d(ContactsTracker.TAG, "Recommend#onEvent: source=" + r3 + ", module=" + r4);
            JSONObject r0 = new JSONObject();
            r0.put("contents", r3);     // Catch: JSONException -> L5
            r0.put("module", r4);     // Catch: JSONException -> L5
            Agent.getInstance().onEvent(EVENT_ID, r0.toString());     // Catch: JSONException -> L5
            return;
        L5:
            e = move-exception;
            LogTag.d(ContactsTracker.TAG, "Recommend#onEvent JSONException: " + e);
        }
    }

    private static class TrackPoint {
        static final String TRACK_RECYCLE_BIN_OPERATION = "A130021";
        static final String TRACK_SETTINGS = "A131019";
        static final String TRACK_SORT_MODE_CHANGE = "A230003";

        private TrackPoint() {
        }
    }

    public static class TrackerEvent {
        private JSONObject data;

        public static class EventItem {

            public static class Id {
                public static final String MENU_EVENT = "A130005";
                public static final String SWITCH_EVENT = "A130004";

                public Id() {
                }
            }

            public static class Key {
                public static final String ID = "id";
                public static final String SWITCH_STATUS = "status";

                public Key() {
                }
            }

            public static class Value {
                public static final int OFF = 0;
                public static final int ON = 1;

                public Value() {
                }
            }

            public EventItem() {
            }
        }

        public TrackerEvent() {
            this.data = new JSONObject();
        }

        public TrackerEvent setString(String r2, String r3) {
            this.data.put(r2, r3);     // Catch: JSONException -> L4
        L6:
            return this;
        L4:
            e = move-exception;
            e.printStackTrace();
            goto L6
        }

        public TrackerEvent setInt(String r2, int r3) {
            this.data.put(r2, r3);     // Catch: JSONException -> L4
        L6:
            return this;
        L4:
            e = move-exception;
            e.printStackTrace();
            goto L6
        }

        public String toString() {
            return this.data.toString();
        }
    }

    static {
    }

    private static int boolean2Int(boolean r0) {
        return r0 ? 1 : 0;
    }

    public ContactsTracker() {
    }

    public static synchronized void trackContactsSettings(Context r2) {
        monitor-enter(ContactsTracker.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (isTracked == false) goto L18;
        monitor-exit(ContactsTracker.class);
        return;
    L18:
        trackContactsSettingsBackground(r2);     // Catch: Exception -> L10 Throwable -> L15
    L12:
        isTracked = true;     // Catch: Throwable -> L15
        monitor-exit(ContactsTracker.class);
        return;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L15
        goto L12
    }

    public static void trackRecycleBinOperation(boolean r4, int r5) {
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L5
        r2.put("type", String.valueOf(boolean2Int(r4)));     // Catch: JSONException -> L5
        r2.put(PerfConsts.PERF_DISK_FILE_NUM, r5);     // Catch: JSONException -> L5
        LogTag.d(TAG, "onEvent A130021 jsonObject:\n" + r2.toString());     // Catch: JSONException -> L5
        Agent.getInstance().onEvent("A130021", r2.toString());     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        LogTag.d(TAG, "trackRecycleBinOperation JSONException: " + e);
    }

    public static void trackSortModeChange(int r2) {
        onEvent("A230003", "list_page_sort", Integer.valueOf(r2));
    }

    private static void onEvent(String r2, String r3, Object r4) {
        LogTag.d(TAG, "onEvent " + r2);
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(r3, r4);
        onEvent(r2, r0);
    }

    private static void onEvent(String r2, LinkedHashMap<String, Object> r3) {
        JSONObject r4 = LinkedHashMapToJson(r3);
        if (r4 == null) goto L6;
        LogTag.d(TAG, "onEvent " + r2 + " jsonObject:\n" + r4.toString());
        Agent.getInstance().onEvent(r2, r4.toString());
        return;
    }

    private static void onEvent(String r2, TrackerEvent r3) {
        LogTag.d(TAG, "onEvent " + r2 + ", data = " + r3);
        Agent.getInstance().onEvent(r2, r3.toString());
    }

    public static void onSwitchEvent(int r2, int r3) {
        TrackerEvent r0 = new TrackerEvent();
        r0.setInt("id", r2);
        r0.setInt("status", r3);
        onEvent(TrackerEvent.EventItem.Id.SWITCH_EVENT, r0);
    }

    public static void onMenuEvent(int r2) {
        TrackerEvent r0 = new TrackerEvent();
        r0.setInt("id", r2);
        onEvent(TrackerEvent.EventItem.Id.MENU_EVENT, r0);
    }

    private static void trackContactsSettingsBackground(Context r9) {
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L13
        r2.put("only_phone", String.valueOf(boolean2Int(ContactsUtils.contactsWithPhoneOnly(r9))));     // Catch: JSONException -> L13
        ContactsPreferences r3 = new ContactsPreferences(r9);     // Catch: JSONException -> L13
        boolean r6 = true;
        if (r3.getDisplayOrder() != 2) goto L6;
        boolean r5 = true;
    L7:
        r2.put("name_sort", String.valueOf(boolean2Int(r5)));     // Catch: JSONException -> L13
        if (r3.getSortOrder() == 2) goto L11;
        r6 = false;
    L11:
        r2.put("list_sort", String.valueOf(boolean2Int(r6)));     // Catch: JSONException -> L13
        trackAccountFilters(r9, r2);     // Catch: JSONException -> L13
        trackRecycleBin(r9, r2);     // Catch: JSONException -> L13
        LogTag.d(TAG, "onStatus A131019 jsonObject:\n" + r2.toString());     // Catch: JSONException -> L13
        Agent.getInstance().onStatus("A131019", r2.toString());     // Catch: JSONException -> L13
        return;
    L6:
        r5 = false;
    L13:
        e = move-exception;
        LogTag.d(TAG, "trackContactsSettingsBackground JSONException: " + e);
    }

    private static void trackAccountFilters(Context r12, JSONObject r13) throws JSONException {
        ArrayList r0 = Lists.newArrayList();
        AccountTypeManager r1 = AccountTypeManager.getInstance(r12);
        if (ContactsUtils.FEATURE_CMCC == false) goto L5;
        List<AccountWithDataSet> r2 = r1.getAccountsIncludeSIM(false);
    L6:
        Iterator<AccountWithDataSet> r3 = r2.iterator();
    L7:
        String r4 = null;
        if (r3.hasNext() == false) goto L14;
        AccountWithDataSet r5 = r3.next();
        String r6 = r5.type;
        String r7 = r5.name;
        if ("com.android.sim".equals(r5.type) == true) goto L13;
        r4 = r5.dataSet;
    L13:
        r0.add(ContactListFilter.createAccountFilter(r6, r7, r4));
        goto L7
    L14:
        Iterator r8 = r0.iterator();
        boolean r9 = false;
    L16:
        if (r8.hasNext() == false) goto L20;
        if (BytedanceAccountType.ACCOUNT_TYPE.equals(((ContactListFilter) r8.next()).accountType) == false) goto L16;
        r9 = true;
        goto L16
    L20:
        if (r9 == true) goto L22;
        r0.add(ContactListFilter.createAccountFilter(ContactsUtils.LOCAL_ACCOUNT_TYPE, "default", null));
    L22:
        HashMap r10 = new HashMap();
        Iterator r11 = r0.iterator();
    L24:
        if (r11.hasNext() == false) goto L36;
        ContactListFilter r14 = (ContactListFilter) r11.next();
        Uri.Builder r15 = ContactsContract.Contacts.CONTENT_URI.buildUpon();
        r14.addAccountQueryParameterToUrl(r15);
        Cursor r16 = r12.getContentResolver().query(r15.build(), new String[]{"_count"}, null, null, null);
        if (r16 == null) goto L24;
        if (r16.moveToNext() == false) goto L30;
        int r17 = r16.getInt(0);     // Catch: Throwable -> L33
    L31:
        r10.put(r14, Integer.valueOf(r17));     // Catch: Throwable -> L33
        r16.close();
        goto L24
    L30:
        r17 = 0;
    L33:
        th = move-exception;
        r16.close();
        throw th;
    L36:
        Set<ContactListFilter> r18 = ContactListFilterController.getInstance(r12).getFilters();
        if (r18 != null) goto L39;
        r18 = new HashSet(r0);
    L39:
        Iterator r19 = r0.iterator();
    L41:
        if (r19.hasNext() == false) goto L47;
        ContactListFilter r20 = (ContactListFilter) r19.next();
        String r21 = r20.accountType;
        if (r10.get(r20) == null) goto L45;
        int r22 = ((Integer) r10.get(r20)).intValue();
    L46:
        r13.put(r21 + "_num", r22);
        r13.put(r21 + "_ischeck", String.valueOf(boolean2Int(r18.contains(r20))));
        goto L41
    L45:
        r22 = 0;
        goto L46
    L47:
        return;
    L5:
        r2 = r1.getAccounts(false);
        goto L6
    }

    private static void trackRecycleBin(Context r9, JSONObject r10) throws JSONException {
        JSONArray r0 = new JSONArray();
        Cursor r11 = r9.getContentResolver().query(RecycleBinConstants.RAW_CONTACTS_URI, new String[]{RecycleBinConstants.CALLING_PACKAGE, "COUNT(*)"}, "(1) GROUP BY " + RecycleBinConstants.CALLING_PACKAGE, null, null);
        long r1 = 0;
        if (r11 != null) goto L14;
    L12:
        r10.put("d_contacts_num", r1);
        r10.put("d_contacts_app", r0);
        return;
    L14:
    L9:
        th = move-exception;
        r11.close();
        throw th;
    L5:
        if (r11.moveToNext() == false) goto L8;
        r0.put(r11.getString(0));     // Catch: Throwable -> L9
        r1 = r1 + r11.getLong(1);
        goto L14
    L8:
        r11.close();
        goto L12
    }

    private static JSONObject LinkedHashMapToJson(LinkedHashMap<String, Object> r3) {
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        Map.Entry<String, Object> r1 = r4.next();
        r0.put(r1.getKey(), String.valueOf(r1.getValue()));     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        LogTag.d(TAG, "LinkedHashMapToJson catch JSONException " + e.getMessage());
        return null;
    L11:
        return r0;
    }
}
