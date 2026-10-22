package com.android.server.people.data;

import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import android.text.TextUtils;
import android.util.Slog;
import android.util.SparseIntArray;
import com.android.server.alwaysonrecord.RequestHolder;
import com.android.server.voiceinteraction.DatabaseHelper;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
class CallLogQueryHelper {
    private static final SparseIntArray CALL_TYPE_TO_EVENT_TYPE = null;
    private static final String TAG = "CallLogQueryHelper";
    private final Context mContext;
    private final BiConsumer<String, Event> mEventConsumer;
    private long mLastCallTimestamp;

    static {
        CALL_TYPE_TO_EVENT_TYPE = new SparseIntArray();
        CALL_TYPE_TO_EVENT_TYPE.put(1, 11);
        CALL_TYPE_TO_EVENT_TYPE.put(2, 10);
        CALL_TYPE_TO_EVENT_TYPE.put(3, 12);
    }

    CallLogQueryHelper(Context context, BiConsumer<String, Event> eventConsumer) {
        this.mContext = context;
        this.mEventConsumer = eventConsumer;
    }

    boolean querySince(long sinceTime) {
        CallLogQueryHelper r1 = this;
        String r0 = "normalized_number";
        String[] projection = {"normalized_number", "date", RequestHolder.KEY_DURATION, DatabaseHelper.SoundModelContract.KEY_TYPE};
        String[] selectionArgs = {Long.toString(sinceTime)};
        boolean hasResults = false;
        Cursor cursor = r1.mContext.getContentResolver().query(CallLog.Calls.CONTENT_URI, projection, "date > ?", selectionArgs, "date DESC");     // Catch: Exception -> L10 SecurityException -> L12
        if (cursor == null) goto L43;
        boolean hasResults2 = false;
    L45:
    L24:
        th = move-exception;
        Throwable r2 = th;
        hasResults = hasResults2;
    L32:
        if (cursor == null) goto L54;
        cursor.close();     // Catch: Throwable -> L35
    L55:
        throw r2;     // Catch: Exception -> L10 SecurityException -> L12
    L35:
        th = move-exception;
        r2.addSuppressed(th);     // Catch: Exception -> L10 SecurityException -> L12
        throw r2;     // Catch: Exception -> L10 SecurityException -> L12
    L54:
        throw r2;     // Catch: Exception -> L10 SecurityException -> L12
    L19:
        if (cursor.moveToNext() == false) goto L50;
        int numberIndex = cursor.getColumnIndex(r0);     // Catch: Throwable -> L24
        String phoneNumber = cursor.getString(numberIndex);     // Catch: Throwable -> L24
        int dateIndex = cursor.getColumnIndex("date");     // Catch: Throwable -> L24
        long date = cursor.getLong(dateIndex);     // Catch: Throwable -> L24
        int durationIndex = cursor.getColumnIndex(RequestHolder.KEY_DURATION);     // Catch: Throwable -> L24
        long durationSeconds = cursor.getLong(durationIndex);     // Catch: Throwable -> L24
        int typeIndex = cursor.getColumnIndex(DatabaseHelper.SoundModelContract.KEY_TYPE);     // Catch: Throwable -> L24
        String r17 = r0;
        int callType = cursor.getInt(typeIndex);     // Catch: Throwable -> L24
        r1.mLastCallTimestamp = Math.max(r1.mLastCallTimestamp, date);     // Catch: Throwable -> L24
        if (r1.addEvent(phoneNumber, date, durationSeconds, callType) == false) goto L23;
        hasResults2 = true;
    L23:
        r1 = this;
        r0 = r17;
        goto L45
    L50:
        cursor.close();     // Catch: Exception -> L28 SecurityException -> L30
    L56:
        return hasResults2;
    L30:
        ex = e;
    L41:
        Slog.e(TAG, "Query call log failed: " + ex);
        return false;
    L28:
        e = e;
        hasResults = hasResults2;
    L39:
        Slog.e(TAG, "Exception when querying call log.", e);
        return hasResults;
    L43:
        Slog.w(TAG, "Cursor is null when querying call log.");     // Catch: Throwable -> L15
        if (cursor == null) goto L14;
        cursor.close();     // Catch: Exception -> L10 SecurityException -> L12
    L14:
        return false;
    L15:
        th = move-exception;
        r2 = th;
    L12:
        ex = e;
    L10:
        e = e;
        goto L39
    }

    long getLastCallTimestamp() {
        return this.mLastCallTimestamp;
    }

    private boolean addEvent(String phoneNumber, long date, long durationSeconds, int callType) {
        if (validateEvent(phoneNumber, date, callType) == true) goto L6;
        return false;
    L6:
        int eventType = CALL_TYPE_TO_EVENT_TYPE.get(callType);
        Event event = new Event.Builder(date, eventType).setDurationSeconds((int) durationSeconds).build();
        this.mEventConsumer.accept(phoneNumber, event);
        return true;
    }

    private boolean validateEvent(String phoneNumber, long date, int callType) {
        if (TextUtils.isEmpty(phoneNumber) == false) goto L5;
    L9:
        return false;
    L5:
        if (date <= 0) goto L9;
        if (CALL_TYPE_TO_EVENT_TYPE.indexOfKey(callType) < 0) goto L9;
        return true;
    }
}
