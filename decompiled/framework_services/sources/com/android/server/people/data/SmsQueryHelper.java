package com.android.server.people.data;

import android.content.Context;
import android.database.Cursor;
import android.os.Binder;
import android.provider.Telephony;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Slog;
import android.util.SparseIntArray;
import com.android.server.voiceinteraction.DatabaseHelper;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
class SmsQueryHelper {
    private static final SparseIntArray SMS_TYPE_TO_EVENT_TYPE = null;
    private static final String TAG = "SmsQueryHelper";
    private final Context mContext;
    private final String mCurrentCountryIso;
    private final BiConsumer<String, Event> mEventConsumer;
    private long mLastMessageTimestamp;

    static {
        SMS_TYPE_TO_EVENT_TYPE = new SparseIntArray();
        SMS_TYPE_TO_EVENT_TYPE.put(1, 9);
        SMS_TYPE_TO_EVENT_TYPE.put(2, 8);
    }

    SmsQueryHelper(Context context, BiConsumer<String, Event> eventConsumer) {
        this.mContext = context;
        this.mEventConsumer = eventConsumer;
        this.mCurrentCountryIso = Utils.getCurrentCountryIso(this.mContext);
    }

    boolean querySince(long sinceTime) {
        String address = "_id";
        String r3 = "date";
        String r4 = DatabaseHelper.SoundModelContract.KEY_TYPE;
        String[] projection = {"_id", "date", DatabaseHelper.SoundModelContract.KEY_TYPE, "address"};
        String[] selectionArgs = {Long.toString(sinceTime)};
        boolean hasResults = false;
        Binder.allowBlockingForCurrentThread();
        Cursor cursor = this.mContext.getContentResolver().query(Telephony.Sms.CONTENT_URI, projection, "date > ?", selectionArgs, null);     // Catch: Throwable -> L9 Exception -> L11
        if (cursor != null) goto L18;
        Slog.w(TAG, "Cursor is null when querying SMS table.");     // Catch: Throwable -> L15
        if (cursor == null) goto L13;
        cursor.close();     // Catch: Throwable -> L9 Exception -> L11
    L13:
        Binder.defaultBlockingForCurrentThread();
        return false;
    L18:
        if (cursor.moveToNext() == false) goto L26;
        int msgIdIndex = cursor.getColumnIndex(address);     // Catch: Throwable -> L15
        cursor.getString(msgIdIndex);     // Catch: Throwable -> L15
        int dateIndex = cursor.getColumnIndex(r3);     // Catch: Throwable -> L15
        long date = cursor.getLong(dateIndex);     // Catch: Throwable -> L15
        int typeIndex = cursor.getColumnIndex(r4);     // Catch: Throwable -> L15
        String r16 = address;
        int type = cursor.getInt(typeIndex);     // Catch: Throwable -> L15
        int addressIndex = cursor.getColumnIndex("address");     // Catch: Throwable -> L15
        String r19 = r3;
        String address2 = PhoneNumberUtils.formatNumberToE164(cursor.getString(addressIndex), this.mCurrentCountryIso);     // Catch: Throwable -> L15
        String r21 = r4;
        this.mLastMessageTimestamp = Math.max(this.mLastMessageTimestamp, date);     // Catch: Throwable -> L15
        if (address2 == null) goto L25;
        if (addEvent(address2, date, type) == false) goto L25;
        hasResults = true;
    L25:
        address = r16;
        r3 = r19;
        r4 = r21;
        goto L18
    L26:
        cursor.close();     // Catch: Throwable -> L9 Exception -> L11
    L27:
        Binder.defaultBlockingForCurrentThread();
        return hasResults;
    L15:
        th = move-exception;
        if (cursor == null) goto L50;
        cursor.close();     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L9 Exception -> L11
    L31:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L9 Exception -> L11
        throw th;     // Catch: Throwable -> L9 Exception -> L11
    L50:
        throw th;     // Catch: Throwable -> L9 Exception -> L11
    L11:
        e = move-exception;
        Slog.e(TAG, "Exception when querying SMS table.", e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Binder.defaultBlockingForCurrentThread();
        throw th;
    }

    long getLastMessageTimestamp() {
        return this.mLastMessageTimestamp;
    }

    private boolean addEvent(String phoneNumber, long date, int type) {
        if (validateEvent(phoneNumber, date, type) == true) goto L6;
        return false;
    L6:
        int eventType = SMS_TYPE_TO_EVENT_TYPE.get(type);
        this.mEventConsumer.accept(phoneNumber, new Event(date, eventType));
        return true;
    }

    private boolean validateEvent(String phoneNumber, long date, int type) {
        if (TextUtils.isEmpty(phoneNumber) == false) goto L5;
    L9:
        return false;
    L5:
        if (date <= 0) goto L9;
        if (SMS_TYPE_TO_EVENT_TYPE.indexOfKey(type) < 0) goto L9;
        return true;
    }
}
