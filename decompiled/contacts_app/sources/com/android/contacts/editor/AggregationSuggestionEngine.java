package com.android.contacts.editor;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.common.io.MoreCloseables;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.util.BytedanceContactContract;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.bytedance.librarian.LibrarianImpl;
import com.google.android.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import obric.api.ContactsContractSmt;

/* JADX INFO: loaded from: classes.dex */
public class AggregationSuggestionEngine extends HandlerThread {
    private static final int MAX_SUGGESTION_COUNT = 3;
    private static final int MESSAGE_DATA_CURSOR = 2;
    private static final int MESSAGE_NAME_CHANGE = 1;
    private static final int MESSAGE_RESET = 0;
    private static final long SUGGESTION_LOOKUP_DELAY_MILLIS = 300;
    public static final String TAG = "AggregationSuggestionEngine";
    private long mContactId;
    private ContentObserver mContentObserver;
    private final Context mContext;
    private Cursor mDataCursor;
    private Handler mHandler;
    private Listener mListener;
    private Handler mMainHandler;
    private long[] mSuggestedContactIds;
    private Uri mSuggestionsUri;

    private static final class DataQuery {
        public static final int ACCOUNT_NAME = 11;
        public static final int ACCOUNT_TYPE = 10;
        public static final String[] COLUMNS = null;
        public static final int CONTACT_ID = 1;
        public static final int DATA1 = 7;
        public static final int DATA_SET = 12;
        public static final int DISPLAY_NAME = 4;
        public static final int ID = 0;
        public static final int IS_SUPERPRIMARY = 8;
        public static final int LOOKUP_KEY = 2;
        public static final int MIMETYPE = 6;
        public static final int PHOTO = 9;
        public static final int PHOTO_ID = 3;
        public static final int RAW_CONTACT_ID = 5;
        public static final String SELECTION_PREFIX = "mimetype IN ('vnd.android.cursor.item/phone_v2','vnd.android.cursor.item/email_v2','vnd.android.cursor.item/name','vnd.android.cursor.item/nickname','vnd.android.cursor.item/photo') AND contact_id IN (";

        private DataQuery() {
        }

        static {
            COLUMNS = new String[]{"_id", "contact_id", "lookup", "photo_id", "display_name", GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "mimetype", "data1", "is_super_primary", BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG, "account_type", "account_name", "data_set"};
        }
    }

    public interface Listener {
        void onAggregationSuggestionChange();
    }

    public static final class RawContact {
        public String accountName;
        public String accountType;
        public String dataSet;
        public long rawContactId;

        public RawContact() {
        }

        public String toString() {
            return "ID: " + this.rawContactId + " account: " + this.accountType + LibrarianImpl.Constants.SEPARATOR + this.accountName + " dataSet: " + this.dataSet;
        }
    }

    public static final class Suggestion {
        public long contactId;
        public String emailAddress;
        public String lookupKey;
        public String name;
        public String nickname;
        public String phoneNumber;
        public byte[] photo;
        public List<RawContact> rawContacts;

        public Suggestion() {
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("ID: ").append(this.contactId).append(" rawContacts: ").append(this.rawContacts).append(" name: ").append(this.name).append(" phone: ").append(this.phoneNumber).append(" email: ").append(this.emailAddress).append(" nickname: ").append(this.nickname);
            if (this.photo == null) goto L5;
            String r3 = " [has photo]";
        L7:
            return r0.append(r3).toString();
        L5:
            r3 = "";
            goto L7
        }
    }

    private final class SuggestionContentObserver extends ContentObserver {
        final /* synthetic */ AggregationSuggestionEngine this$0;

        /* synthetic */ SuggestionContentObserver(AggregationSuggestionEngine r1, Handler r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private SuggestionContentObserver(AggregationSuggestionEngine r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1) {
            this.this$0.scheduleSuggestionLookup();
        }
    }

    public AggregationSuggestionEngine(Context r3) {
        super("AggregationSuggestions", 10);
        this.mSuggestedContactIds = new long[0];
        this.mContext = r3;
        this.mMainHandler = new AnonymousClass1(this);
    }

    protected Handler getHandler() {
        if (this.mHandler != null) goto L6;
        final Looper r1 = getLooper();
        this.mHandler = new AnonymousClass2(this, r1);
    L6:
        return this.mHandler;
    }

    public void setContactId(long r3) {
        if (r3 == this.mContactId) goto L6;
        this.mContactId = r3;
        reset();
        return;
    }

    public void setListener(Listener r1) {
        this.mListener = r1;
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        Cursor r0 = this.mDataCursor;
        if (r0 == null) goto L5;
        r0.close();
    L5:
        this.mDataCursor = null;
        if (this.mContentObserver == null) goto L9;
        this.mContext.getContentResolver().unregisterContentObserver(this.mContentObserver);
        this.mContentObserver = null;
    L9:
        return super.quit();
    }

    public void reset() {
        Handler r1 = getHandler();
        r1.removeMessages(1);
        r1.sendEmptyMessage(0);
    }

    public void onNameChange(EntityDelta.ValuesDelta r4) {
        Uri r5 = buildAggregationSuggestionUri(r4);
        this.mSuggestionsUri = r5;
        AnonymousClass1 r0 = null;
        if (r5 == null) goto L8;
        if (this.mContentObserver != null) goto L10;
        this.mContentObserver = new SuggestionContentObserver(this, getHandler(), r0);
        this.mContext.getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, this.mContentObserver);
    L10:
        scheduleSuggestionLookup();
        return;
    L8:
        if (this.mContentObserver == null) goto L10;
        this.mContext.getContentResolver().unregisterContentObserver(this.mContentObserver);
        this.mContentObserver = null;
        goto L10
    }

    protected void scheduleSuggestionLookup() {
        Handler r0 = getHandler();
        r0.removeMessages(1);
        Uri r4 = this.mSuggestionsUri;
        if (r4 != null) goto L5;
        r0.sendMessageDelayed(r0.obtainMessage(0), 300);
        return;
    L5:
        r0.sendMessageDelayed(r0.obtainMessage(1, r4), 300);
    }

    private Uri buildAggregationSuggestionUri(EntityDelta.ValuesDelta r5) {
        StringBuilder r0 = new StringBuilder();
        appendValue(r0, r5, "data4");
        appendValue(r0, r5, DBHelper.COL_DATA2);
        appendValue(r0, r5, "data5");
        appendValue(r0, r5, DBHelper.COL_DATA3);
        appendValue(r0, r5, "data6");
        if (r0.length() != 0) goto L5;
        appendValue(r0, r5, "data1");
    L5:
        StringBuilder r1 = new StringBuilder();
        appendValue(r1, r5, "data9");
        appendValue(r1, r5, "data8");
        appendValue(r1, r5, "data7");
        if (r0.length() == 0) goto L8;
    L11:
        ContactsContract.Contacts.AggregationSuggestions.Builder r4 = ContactsContract.Contacts.AggregationSuggestions.builder().setLimit(3).setContactId(this.mContactId);
        if (r0.length() == 0) goto L15;
        ContactsContractSmt.addParameterForAggregationSuggestions(r4, r0.toString());
    L15:
        if (r1.length() == 0) goto L18;
        ContactsContractSmt.addParameterForAggregationSuggestions(r4, r1.toString());
    L18:
        return r4.build();
    L8:
        if (r1.length() != 0) goto L11;
        return null;
    }

    private void appendValue(StringBuilder r1, EntityDelta.ValuesDelta r2, String r3) {
        String r0 = r2.getAsString(r3);
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return;
    L5:
        if (r1.length() <= 0) goto L7;
        r1.append(' ');
    L7:
        r1.append(r0);
    }

    protected void handleMessage(Message r3) {
        int r0 = r3.what;
        if (r0 != 0) goto L5;
        this.mSuggestedContactIds = new long[0];
        return;
    L5:
        if (r0 != 1) goto L11;
        loadAggregationSuggestions((Uri) r3.obj);
        return;
    }

    private void loadAggregationSuggestions(Uri r8) {
        ContentResolver r0 = this.mContext.getContentResolver();
        Cursor r9 = r0.query(r8, new String[]{"_id"}, null, null, null);
    L19:
        th = move-exception;
        MoreCloseables.closeQuietly(r9);
        throw th;
    L4:
        if (getHandler().hasMessages(1) == false) goto L8;
        MoreCloseables.closeQuietly(r9);
        return;
    L8:
        if (updateSuggestedContactIds(r9) == true) goto L11;
        MoreCloseables.closeQuietly(r9);
        return;
    L11:
        StringBuilder r1 = new StringBuilder(DataQuery.SELECTION_PREFIX);     // Catch: Throwable -> L19
        int r2 = this.mSuggestedContactIds.length;     // Catch: Throwable -> L19
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L16;
        if (r3 <= 0) goto L15;
        r1.append(',');     // Catch: Throwable -> L19
    L15:
        r1.append(this.mSuggestedContactIds[r3]);     // Catch: Throwable -> L19
        r3 = r3 + 1;     // Catch: Throwable -> L19
        goto L12
    L16:
        r1.append(')');     // Catch: Throwable -> L19
        Cursor r4 = r0.query(ContactsContract.Data.CONTENT_URI, DataQuery.COLUMNS, r1.toString(), null, "contact_id");     // Catch: Throwable -> L19
        Handler r7 = this.mMainHandler;     // Catch: Throwable -> L19
        r7.sendMessage(r7.obtainMessage(2, r4));     // Catch: Throwable -> L19
        MoreCloseables.closeQuietly(r9);
    }

    private boolean updateSuggestedContactIds(Cursor r8) {
        int r0 = r8.getCount();
        boolean r2 = true;
        if (r0 == this.mSuggestedContactIds.length) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
    L12:
        r2 = r1;
    L13:
        if (r2 == false) goto L21;
        this.mSuggestedContactIds = new long[r0];
        r8.moveToPosition(-1);
        int r3 = 0;
    L15:
        if (r3 >= r0) goto L20;
        if (r8.moveToNext() == false) goto L19;
        this.mSuggestedContactIds[r3] = r8.getLong(0);
    L19:
        r3 = r3 + 1;
        goto L15
    L20:
        Arrays.sort(this.mSuggestedContactIds);
    L21:
        return r2;
    L8:
        if (r8.moveToNext() == false) goto L12;
        if (Arrays.binarySearch(this.mSuggestedContactIds, r8.getLong(0)) >= 0) goto L8;
    L5:
        r1 = false;
        goto L6
    }

    protected void deliverNotification(Cursor r2) {
        Cursor r0 = this.mDataCursor;
        if (r0 == null) goto L5;
        r0.close();
    L5:
        this.mDataCursor = r2;
        Listener r1 = this.mListener;
        if (r1 == null) goto L9;
        r1.onAggregationSuggestionChange();
        return;
    }

    public int getSuggestedContactCount() {
        Cursor r0 = this.mDataCursor;
        if (r0 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r0.isClosed() == true) goto L7;
        return this.mDataCursor.getCount();
    }

    public List<Suggestion> getSuggestions() {
        ArrayList r0 = Lists.newArrayList();
        Cursor r1 = this.mDataCursor;
        if (r1 != null) goto L5;
    L47:
        return r0;
    L5:
        if (r1.isClosed() == true) goto L47;
        Suggestion r2 = new Suggestion();
        this.mDataCursor.moveToFirst();
        long r3 = -1;
        int r5 = 0;
    L48:
        if (r5 >= this.mDataCursor.getCount()) goto L47;
        long r6 = this.mDataCursor.getLong(1);     // Catch: Exception -> L45
        if (r6 == r3) goto L12;
        r2 = new Suggestion();     // Catch: Exception -> L45
        r2.contactId = r6;     // Catch: Exception -> L45
        r2.name = this.mDataCursor.getString(4);     // Catch: Exception -> L45
        r2.lookupKey = this.mDataCursor.getString(2);     // Catch: Exception -> L45
        r2.rawContacts = Lists.newArrayList();     // Catch: Exception -> L45
        r0.add(r2);     // Catch: Exception -> L45
        r3 = r6;
    L12:
        long r7 = this.mDataCursor.getLong(5);     // Catch: Exception -> L45
        if (containsRawContact(r2, r7) == true) goto L15;
        RawContact r8 = new RawContact();     // Catch: Exception -> L45
        r8.rawContactId = r7;     // Catch: Exception -> L45
        r8.accountName = this.mDataCursor.getString(11);     // Catch: Exception -> L45
        r8.accountType = this.mDataCursor.getString(10);     // Catch: Exception -> L45
        r8.dataSet = this.mDataCursor.getString(12);     // Catch: Exception -> L45
        r2.rawContacts.add(r8);     // Catch: Exception -> L45
    L15:
        String r9 = this.mDataCursor.getString(6);     // Catch: Exception -> L45
        if ("vnd.android.cursor.item/phone_v2".equals(r9) == false) goto L24;
        String r10 = this.mDataCursor.getString(7);     // Catch: Exception -> L45
        int r11 = this.mDataCursor.getInt(8);     // Catch: Exception -> L45
        if (TextUtils.isEmpty(r10) == true) goto L43;
        if (r11 == 0) goto L21;
    L22:
        r2.phoneNumber = r10;     // Catch: Exception -> L45
        goto L43
    L21:
        if (r2.phoneNumber == null) goto L22;
    L43:
        this.mDataCursor.moveToNext();     // Catch: Exception -> L45
        r5 = r5 + 1;
        goto L48
    L24:
        if ("vnd.android.cursor.item/email_v2".equals(r9) == false) goto L32;
        String r12 = this.mDataCursor.getString(7);     // Catch: Exception -> L45
        int r13 = this.mDataCursor.getInt(8);     // Catch: Exception -> L45
        if (TextUtils.isEmpty(r12) == true) goto L43;
        if (r13 == 0) goto L29;
    L30:
        r2.emailAddress = r12;     // Catch: Exception -> L45
        goto L43
    L29:
        if (r2.emailAddress != null) goto L43;
    L32:
        if ("vnd.android.cursor.item/nickname".equals(r9) == false) goto L37;
        String r14 = this.mDataCursor.getString(7);     // Catch: Exception -> L45
        if (TextUtils.isEmpty(r14) == true) goto L43;
        r2.nickname = r14;     // Catch: Exception -> L45
        goto L43
    L37:
        if ("vnd.android.cursor.item/photo".equals(r9) == false) goto L43;
        if (this.mDataCursor.getLong(0) != this.mDataCursor.getLong(3)) goto L43;
        if (this.mDataCursor.isNull(9) == true) goto L43;
        r2.photo = this.mDataCursor.getBlob(9);     // Catch: Exception -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
        goto L47
    }

    public boolean containsRawContact(Suggestion r5, long r6) {
        if (r5 != null) goto L5;
    L13:
        return false;
    L5:
        if (r5.rawContacts == null) goto L13;
        int r0 = r5.rawContacts.size();
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L13;
        if (r5.rawContacts.get(r1).rawContactId == r6) goto L10;
        r1 = r1 + 1;
        goto L7
    L10:
        return true;
    }
}
