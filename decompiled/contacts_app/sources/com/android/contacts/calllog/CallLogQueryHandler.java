package com.android.contacts.calllog;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.CallLog;
import android.provider.Settings;
import android.provider.VoicemailContract;
import android.text.TextUtils;
import bytedanceos.util.MultiSimAdapter;
import com.GlobalProxyLancet;
import com.android.common.io.MoreCloseables;
import com.android.contacts.ContactsUtils;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.voicemail.VoicemailStatusHelperImpl;
import com.google.android.collect.Lists;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class CallLogQueryHandler extends AsyncQueryHandler {
    private static final String[] EMPTY_STRING_ARRAY = null;
    private static final long FUTURE_SECTION_TIME_WINDOW = 0;
    private static final long NEW_SECTION_TIME_WINDOW = 0;
    private static final int QUERY_ALL_CALLS_TOKEN = 59;
    private static final int QUERY_CALLS_BY_IDS_TOKEN = 40;
    private static final int QUERY_CALLS_BY_NUMBER_TOKEN = 42;
    private static final int QUERY_CALLS_TOP_TOKEN = 41;
    private static final int QUERY_NEW_CALLS_TOKEN = 53;
    private static final int QUERY_OLD_CALLS_TOKEN = 54;
    private static final int QUERY_VOICEMAIL_STATUS_TOKEN = 58;
    public static final String SHOW_ALL_CALL_LOGS = "show_all_call_logs";
    private static final String TAG = "CallLogQueryHandler";
    private static final int UPDATE_MARK_AS_OLD_TOKEN = 55;
    private static final int UPDATE_MARK_MISSED_CALL_AS_READ_TOKEN = 57;
    private static final int UPDATE_MARK_VOICEMAILS_AS_OLD_TOKEN = 56;
    private static final int UPDATE_SHOW_SIM_ID_TOKEN = 60;
    ContentResolver mContentResolver;
    private final WeakReference<Listener> mListener;
    private Cursor mNewCallsCursor;
    private Cursor mOldCallsCursor;

    protected class CatchingWorkerHandler extends AsyncQueryHandler.WorkerHandler {
        final /* synthetic */ CallLogQueryHandler this$0;

        public CatchingWorkerHandler(CallLogQueryHandler r1, Looper r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // android.content.AsyncQueryHandler.WorkerHandler, android.os.Handler
        public void handleMessage(Message r3) {
            super.handleMessage(r3);     // Catch: IllegalArgumentException -> L5 SQLiteDatabaseCorruptException -> L7 SQLiteFullException -> L9 SQLiteDiskIOException -> L11
        L19:
            return;
        L7:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(CallLogQueryHandler.TAG, "Exception on background worker thread", e);
            return;
        L11:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(CallLogQueryHandler.TAG, "Exception on background worker thread", e);
            return;
        L9:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(CallLogQueryHandler.TAG, "Exception on background worker thread", e);
            return;
        L5:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(CallLogQueryHandler.TAG, "Exception on background worker thread", e);
        }
    }

    public interface Listener {
        void onCallsFetched(Cursor r1);

        void onVoicemailStatusFetched(Cursor r1);
    }

    static {
        EMPTY_STRING_ARRAY = new String[0];
        NEW_SECTION_TIME_WINDOW = TimeUnit.DAYS.toMillis(30);
        FUTURE_SECTION_TIME_WINDOW = TimeUnit.DAYS.toMillis(1);
    }

    @Override // android.content.AsyncQueryHandler
    protected Handler createHandler(Looper r2) {
        return new CatchingWorkerHandler(this, r2);
    }

    public CallLogQueryHandler(ContentResolver r1, Listener r2) {
        super(r1);
        this.mContentResolver = r1;
        this.mListener = new WeakReference(r2);
    }

    private Cursor createHeaderCursorFor(int r1) {
        return new MatrixCursor(CallLogQuery.EXTENDED_PROJECTION);
    }

    private Cursor createOldCallsHeaderCursor() {
        return createHeaderCursorFor(2);
    }

    private Cursor createNewCallsHeaderCursor() {
        return createHeaderCursorFor(0);
    }

    public void fetchAllCalls() {
        cancelFetch();
        invalidate();
        fetchAllCalls(59, false);
    }

    public void fetchContactCalls(String r3, List<String> r4) {
        cancelFetch();
        invalidate();
        fetchContactCalls(59, r3, r4, false);
    }

    public void fetchMissCalls() {
        cancelFetch();
        invalidate();
        fetchMissCalls(53, true, false);
        fetchMissCalls(54, false, false);
    }

    public void fetchSimCalls(int r11) {
        cancelFetch();
        invalidate();
        ArrayList r0 = Lists.newArrayList();
        if (Settings.Global.getInt(this.mContentResolver, SHOW_ALL_CALL_LOGS, 0) != 1) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L9;
        String r2 = String.format("%s > ? and %s < ?", new Object[]{"date", "date"});
        r0.add(Long.toString(System.currentTimeMillis() - NEW_SECTION_TIME_WINDOW));
        r0.add(String.valueOf(System.currentTimeMillis() + FUTURE_SECTION_TIME_WINDOW));
    L10:
        if (r2 != null) goto L12;
        String r3 = String.format("%s = ?", new Object[]{CallLogQuery.COLUMN_SUBSCRIPTION});
    L14:
        if (CallLogQuery.COLUMN_SUBSCRIPTION.equals("subscription_id") == false) goto L19;
        int r4 = MultiSimAdapter.slot2Sub(r11);
        if (ContactsUtils.DEBUG == false) goto L18;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Translate sim id " + r11 + " to subscription id " + r4 + " in Android 5.1");
    L18:
        r11 = r4;
    L19:
        r0.add(Integer.toString(r11));
        startQuery(59, null, CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, CallLogQuery._PROJECTION, withCallTypeLimitSelection(r3), (String[]) r0.toArray(EMPTY_STRING_ARRAY), "date DESC");
        return;
    L12:
        r3 = String.format("(%s) AND (%s = ?)", new Object[]{r2, CallLogQuery.COLUMN_SUBSCRIPTION});
        goto L14
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = false;
        goto L7
    }

    public void fetchVoicemailOnly() {
        cancelFetch();
        invalidate();
        fetchAllCalls(59, true);
    }

    public void fetchVoicemailStatus() {
        startQuery(58, null, VoicemailContract.Status.CONTENT_URI, VoicemailStatusHelperImpl.PROJECTION, null, null, null);
    }

    public void fetchCallsByNumber(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        cancelFetch();
        invalidate();
        startQuery(42, null, Uri.withAppendedPath(CallLog.Calls.CONTENT_FILTER_URI, r10), CallLogQuery._PROJECTION, null, null, "date DESC");
    }

    public void fetchCallsByIds(long[] r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.length == 0) goto L9;
        cancelFetch();
        invalidate();
        fetchCallsByIds(40, r2);
        return;
    }

    public void fetchTopCalls(int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        cancelFetch();
        invalidate();
        fetchTopCalls(41, r2);
    }

    private void fetchTopCalls(int r9, int r10) {
        startQuery(r9, null, CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, CallLogQuery._PROJECTION, "type IN (1, 7, 2, 3, 5) LIMIT " + r10, null, "date DESC");
    }

    private void fetchCallsByIds(int r10, long[] r11) {
        StringBuilder r0 = new StringBuilder("_id IN (");
        int r1 = 0;
    L4:
        if (r1 >= r11.length) goto L9;
        if (r1 != 0) goto L7;
        r0.append(r11[r1]);
    L8:
        r1 = r1 + 1;
        goto L4
    L7:
        r0.append(SimContactsConstants.EMAIL_SEP + r11[r1]);
        goto L8
    L9:
        r0.append(") AND type IN (1, 7, 2, 3, 5)");
        startQuery(r10, null, CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, CallLogQuery._PROJECTION, r0.toString(), null, "date DESC");
    }

    private String withCallTypeLimitSelection(String r1) {
        if (r1 != null) goto L5;
        return "type IN (1, 7, 2, 3, 5, 4)";
    L5:
        return r1 + " AND type IN (1, 7, 2, 3, 5, 4)";
    }

    private void fetchMissCalls(int r21, boolean r22, boolean r23) {
        ArrayList r1 = Lists.newArrayList(new String[]{Long.toString(System.currentTimeMillis() - NEW_SECTION_TIME_WINDOW)});
        r1.add(String.valueOf(System.currentTimeMillis() + FUTURE_SECTION_TIME_WINDOW));
        if (r22 == false) goto L5;
        String r2 = String.format("%s IS NOT NULL AND %s = 0 AND %s = 3", new Object[]{"is_read", "is_read", "type"});
    L6:
        String r11 = r2;
        if (Settings.Global.getInt(this.mContentResolver, SHOW_ALL_CALL_LOGS, 0) != 1) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L12;
        startQuery(r21, null, CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, CallLogQuery._PROJECTION, r11, null, "date DESC");
        return;
    L12:
        startQuery(r21, null, CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, CallLogQuery._PROJECTION, String.format("(%s) AND (%s > ?) AND (%s < ?) ", new Object[]{r11, "date", "date"}), (String[]) r1.toArray(EMPTY_STRING_ARRAY), "date DESC");
        return;
    L9:
        r6 = false;
        goto L10
    L5:
        r2 = String.format("(%s IS NOT NULL AND %s = 1 OR %s IS NULL) AND %s = 3", new Object[]{"is_read", "is_read", "is_read", "type"});
        goto L6
    }

    private void fetchCalls(int r12, boolean r13, boolean r14) {
        String r0 = String.format("%s IS NOT NULL AND %s = 0 AND %s > ?", new Object[]{"is_read", "is_read", "date"});
        ArrayList r2 = Lists.newArrayList(new String[]{Long.toString(System.currentTimeMillis() - NEW_SECTION_TIME_WINDOW)});
        if (r13 == true) goto L5;
        r0 = String.format("NOT (%s)", new Object[]{r0});
    L5:
        if (r14 == false) goto L7;
        r0 = String.format("(%s) AND (%s = ?)", new Object[]{r0, "type"});
        r2.add(Integer.toString(4));
    L7:
        startQuery(r12, null, CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, CallLogQuery._PROJECTION, withCallTypeLimitSelection(r0), (String[]) r2.toArray(EMPTY_STRING_ARRAY), "date DESC");
    }

    private void fetchAllCalls(int r13, boolean r14) {
        ArrayList r2 = Lists.newArrayList();
        if (Settings.Global.getInt(this.mContentResolver, SHOW_ALL_CALL_LOGS, 0) != 1) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == true) goto L9;
        String r7 = String.format("%s > ? and %s < ?", new Object[]{"date", "date"});
        r2.add(Long.toString(System.currentTimeMillis() - NEW_SECTION_TIME_WINDOW));
        r2.add(String.valueOf(System.currentTimeMillis() + FUTURE_SECTION_TIME_WINDOW));
    L10:
        if (r14 == true) goto L12;
    L16:
        String r5 = withCallTypeLimitSelection(r7);
        if (ContactsUtils.USER_LOG_ON == false) goto L19;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "fetchAllCalls showAll=" + r3 + ", voicemailOnly=" + r14);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "fetchAllCalls token: " + r13 + ", selection: " + r5 + ", args: " + r2);
    L19:
        startQuery(r13, null, CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, CallLogQuery._PROJECTION, r5, (String[]) r2.toArray(EMPTY_STRING_ARRAY), "date DESC");
        return;
    L12:
        if (r7 != null) goto L14;
        String r4 = String.format("%s = ?", new Object[]{"type"});
    L15:
        r7 = r4;
        r2.add(Integer.toString(4));
        goto L16
    L14:
        r4 = String.format("(%s) AND (%s = ?)", new Object[]{r7, "type"});
        goto L15
    L9:
        r7 = null;
        goto L10
    L5:
        r3 = false;
        goto L7
    }

    public void updateShowSimId() {
        ContentValues r4 = new ContentValues(1);
        r4.put(CallLogQuery.COLUMN_SHOW_SIM_ICON, 1);
        startUpdate(59, null, CallLog.Calls.CONTENT_URI, r4, null, null);
    }

    private void fetchContactCalls(int r10, String r11, List<String> r12, boolean r13) {
        ArrayList r0 = new ArrayList();
        String r4 = "1 = 1";
        if (r13 == false) goto L5;
        r4 = String.format("(%s) AND (%s = ?)", new Object[]{"1 = 1", "type"});
        r0.add(Integer.toString(4));
    L5:
        String r14 = String.format("(%s) AND ( %s )", new Object[]{r4, r11});
        if (r12 == null) goto L8;
        r0.addAll(r12);
    L8:
        startQuery(r10, null, CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, CallLogQuery._PROJECTION, withCallTypeLimitSelection(r14), (String[]) r0.toArray(EMPTY_STRING_ARRAY), "date DESC");
    }

    private void cancelFetch() {
        cancelOperation(53);
        cancelOperation(54);
        cancelOperation(59);
    }

    public void markNewCallsAsOld() {
        ContentValues r4 = new ContentValues(1);
        r4.put("new", "0");
        startUpdate(55, null, CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, r4, "new = 1", null);
    }

    public void markNewVoicemailsAsOld() {
        ContentValues r4 = new ContentValues(1);
        r4.put("new", "0");
        startUpdate(56, null, CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, r4, "new = 1 AND type = ?", new String[]{Integer.toString(4)});
    }

    public void markMissedCallsAsRead() {
        ContentValues r4 = new ContentValues(1);
        r4.put("is_read", "1");
        startUpdate(57, null, CallLog.Calls.CONTENT_URI, r4, "is_read = 0 AND type = 3", null);
    }

    private synchronized void invalidate() {
        monitor-enter(this);
        MoreCloseables.closeQuietly(this.mNewCallsCursor);     // Catch: Throwable -> L6
        MoreCloseables.closeQuietly(this.mOldCallsCursor);     // Catch: Throwable -> L6
        this.mNewCallsCursor = null;     // Catch: Throwable -> L6
        this.mOldCallsCursor = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.content.AsyncQueryHandler
    protected synchronized void onQueryComplete(int r5, Object r6, Cursor r7) {
        monitor-enter(this);
        if (r7 != null) goto L59;
        monitor-exit(this);
        return;
    L59:
    L56:
        th = move-exception;
        throw th;
    L8:
        if (ContactsUtils.USER_LOG_ON == false) goto L11;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "call log onQueryComplete: token=" + r5 + " count=" + r7.getCount());     // Catch: Throwable -> L56
    L11:
        if (r5 != 53) goto L14;
        this.mNewCallsCursor = new ExtendedCursor(r7, CallLogQuery.SECTION_NAME, 1);     // Catch: Throwable -> L56
    L17:
        if (this.mNewCallsCursor != null) goto L19;
    L21:
        monitor-exit(this);
        return;
    L19:
        if (this.mOldCallsCursor == null) goto L21;
        updateAdapterData(createMergedCursor());     // Catch: Throwable -> L56
        goto L21
    L14:
        if (r5 != 54) goto L24;
        this.mOldCallsCursor = new ExtendedCursor(r7, CallLogQuery.SECTION_NAME, 3);     // Catch: Throwable -> L56
        goto L17
    L24:
        if (r5 != 58) goto L29;
        updateVoicemailStatus(r7);     // Catch: Throwable -> L56
        monitor-exit(this);
        return;
    L29:
        if (r5 != 59) goto L39;
        if (r7.getColumnCount() > 0) goto L35;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("CursorError", "cursor columnCount = " + r7.getColumnCount());     // Catch: Throwable -> L56
        monitor-exit(this);
        return;
    L35:
        updateAdapterData(new ExtendedCursor(r7, CallLogQuery.SECTION_NAME, 3));     // Catch: Throwable -> L56
        monitor-exit(this);
        return;
    L39:
        if (r5 != 40) goto L44;
        updateAdapterData(r7);     // Catch: Throwable -> L56
        monitor-exit(this);
        return;
    L44:
        if (r5 != 41) goto L49;
        updateAdapterData(r7);     // Catch: Throwable -> L56
        monitor-exit(this);
        return;
    L49:
        if (r5 != 42) goto L53;
        updateAdapterData(r7);     // Catch: Throwable -> L56
        monitor-exit(this);
        return;
    L53:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Unknown query completed: ignoring: " + r5);     // Catch: Throwable -> L56
        monitor-exit(this);
    }

    private synchronized Cursor createMergedCursor() {
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L27:
        th = move-exception;
        this.mNewCallsCursor = null;     // Catch: Throwable -> L30
        this.mOldCallsCursor = null;     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L5:
        if (this.mNewCallsCursor.getCount() == 0) goto L7;
        boolean r1 = true;
    L9:
        if (this.mOldCallsCursor.getCount() == 0) goto L11;
        boolean r4 = true;
    L12:
        if (r1 == true) goto L18;
        MoreCloseables.closeQuietly(this.mNewCallsCursor);     // Catch: Throwable -> L27
        Cursor r2 = this.mOldCallsCursor;     // Catch: Throwable -> L27
        this.mNewCallsCursor = null;     // Catch: Throwable -> L30
        this.mOldCallsCursor = null;     // Catch: Throwable -> L30
        monitor-exit(this);
        return r2;
    L18:
        if (r4 == true) goto L23;
        MoreCloseables.closeQuietly(this.mOldCallsCursor);     // Catch: Throwable -> L27
        MergeCursor r5 = new MergeCursor(new Cursor[]{createNewCallsHeaderCursor(), this.mNewCallsCursor});     // Catch: Throwable -> L27
        this.mNewCallsCursor = null;     // Catch: Throwable -> L30
        this.mOldCallsCursor = null;     // Catch: Throwable -> L30
        monitor-exit(this);
        return r5;
    L23:
        MergeCursor r6 = new MergeCursor(new Cursor[]{createNewCallsHeaderCursor(), this.mNewCallsCursor, createOldCallsHeaderCursor(), this.mOldCallsCursor});     // Catch: Throwable -> L27
        this.mNewCallsCursor = null;     // Catch: Throwable -> L30
        this.mOldCallsCursor = null;     // Catch: Throwable -> L30
        monitor-exit(this);
        return r6;
    L11:
        r4 = false;
        goto L12
    L7:
        r1 = false;
        goto L9
    }

    private void updateAdapterData(Cursor r1) {
        Listener r0 = this.mListener.get();
        if (r0 == null) goto L6;
        r0.onCallsFetched(r1);
        return;
    }

    private void updateVoicemailStatus(Cursor r1) {
        Listener r0 = this.mListener.get();
        if (r0 == null) goto L6;
        r0.onVoicemailStatusFetched(r1);
        return;
    }
}
