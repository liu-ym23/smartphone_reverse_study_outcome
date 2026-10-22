package com.android.server.people.data;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.provider.Telephony;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Slog;
import android.util.SparseIntArray;
import com.android.server.voiceinteraction.DatabaseHelper;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
class MmsQueryHelper {
    private static final long MILLIS_PER_SECONDS = 1000;
    private static final SparseIntArray MSG_BOX_TO_EVENT_TYPE = null;
    private static final String TAG = "MmsQueryHelper";
    private final Context mContext;
    private String mCurrentCountryIso;
    private final BiConsumer<String, Event> mEventConsumer;
    private long mLastMessageTimestamp;

    static {
        MSG_BOX_TO_EVENT_TYPE = new SparseIntArray();
        MSG_BOX_TO_EVENT_TYPE.put(1, 9);
        MSG_BOX_TO_EVENT_TYPE.put(2, 8);
    }

    MmsQueryHelper(Context context, BiConsumer<String, Event> eventConsumer) {
        this.mContext = context;
        this.mEventConsumer = eventConsumer;
        this.mCurrentCountryIso = Utils.getCurrentCountryIso(this.mContext);
    }

    boolean querySince(long sinceTime) {
        String r3 = "date";
        String r4 = "msg_box";
        String[] projection = {"_id", "date", "msg_box"};
        long r12 = 1000;
        String[] selectionArgs = {Long.toString(sinceTime / 1000)};
        boolean hasResults = false;
        Binder.allowBlockingForCurrentThread();
        Cursor cursor = this.mContext.getContentResolver().query(Telephony.Mms.CONTENT_URI, projection, "date > ?", selectionArgs, null);     // Catch: Throwable -> L9 Exception -> L11
        if (cursor != null) goto L18;
        Slog.w(TAG, "Cursor is null when querying MMS table.");     // Catch: Throwable -> L15
        if (cursor == null) goto L13;
        cursor.close();     // Catch: Throwable -> L9 Exception -> L11
    L13:
        Binder.defaultBlockingForCurrentThread();
        return false;
    L18:
        if (cursor.moveToNext() == false) goto L25;
        int msgIdIndex = cursor.getColumnIndex("_id");     // Catch: Throwable -> L15
        String msgId = cursor.getString(msgIdIndex);     // Catch: Throwable -> L15
        int dateIndex = cursor.getColumnIndex(r3);     // Catch: Throwable -> L15
        long r17 = r12;
        long date = cursor.getLong(dateIndex) * r17;     // Catch: Throwable -> L15
        int msgBoxIndex = cursor.getColumnIndex(r4);     // Catch: Throwable -> L15
        int msgBox = cursor.getInt(msgBoxIndex);     // Catch: Throwable -> L15
        String r16 = r3;
        String r20 = r4;
        this.mLastMessageTimestamp = Math.max(this.mLastMessageTimestamp, date);     // Catch: Throwable -> L15
        String address = getMmsAddress(msgId, msgBox);     // Catch: Throwable -> L15
        if (address == null) goto L24;
        if (addEvent(address, date, msgBox) == false) goto L24;
        hasResults = true;
    L24:
        r3 = r16;
        r12 = r17;
        r4 = r20;
        goto L18
    L25:
        cursor.close();     // Catch: Throwable -> L9 Exception -> L11
    L26:
        Binder.defaultBlockingForCurrentThread();
        return hasResults;
    L15:
        th = move-exception;
        if (cursor == null) goto L49;
        cursor.close();     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L9 Exception -> L11
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L9 Exception -> L11
        throw th;     // Catch: Throwable -> L9 Exception -> L11
    L49:
        throw th;     // Catch: Throwable -> L9 Exception -> L11
    L11:
        e = move-exception;
        Slog.e(TAG, "Exception when querying MMS table.", e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Binder.defaultBlockingForCurrentThread();
        throw th;
    }

    long getLastMessageTimestamp() {
        return this.mLastMessageTimestamp;
    }

    private String getMmsAddress(String msgId, int msgBox) {
        Uri addressUri = Telephony.Mms.Addr.getAddrUriForMessage(msgId);
        String[] projection = {"address", DatabaseHelper.SoundModelContract.KEY_TYPE};
        String address = null;
        Cursor cursor = this.mContext.getContentResolver().query(addressUri, projection, null, null, null);     // Catch: Exception -> L9
        if (cursor != null) goto L15;
        Slog.w(TAG, "Cursor is null when querying MMS address table.");     // Catch: Throwable -> L12
        if (cursor == null) goto L11;
        cursor.close();     // Catch: Exception -> L9
    L11:
        return null;
    L15:
        if (cursor.moveToNext() == false) goto L27;
        int typeIndex = cursor.getColumnIndex(DatabaseHelper.SoundModelContract.KEY_TYPE);     // Catch: Throwable -> L12
        int type = cursor.getInt(typeIndex);     // Catch: Throwable -> L12
        if (msgBox != 1) goto L21;
        if (type != 137) goto L21;
    L24:
        int addrIndex = cursor.getColumnIndex("address");     // Catch: Throwable -> L12
        address = cursor.getString(addrIndex);     // Catch: Throwable -> L12
    L21:
        if (msgBox != 2) goto L15;
        if (type != 151) goto L15;
    L27:
        cursor.close();     // Catch: Exception -> L9
    L38:
        if (Telephony.Mms.isPhoneNumber(address) == true) goto L41;
        return null;
    L41:
        return PhoneNumberUtils.formatNumberToE164(address, this.mCurrentCountryIso);
    L12:
        th = move-exception;
        if (cursor == null) goto L54;
        cursor.close();     // Catch: Throwable -> L32
    L55:
        throw th;     // Catch: Exception -> L9
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L9
        throw th;     // Catch: Exception -> L9
    L54:
        throw th;     // Catch: Exception -> L9
    L9:
        e = move-exception;
        Slog.e(TAG, "Exception when querying MMS address table.", e);
        goto L38
    }

    private boolean addEvent(String phoneNumber, long date, int msgBox) {
        if (validateEvent(phoneNumber, date, msgBox) == true) goto L6;
        return false;
    L6:
        int eventType = MSG_BOX_TO_EVENT_TYPE.get(msgBox);
        this.mEventConsumer.accept(phoneNumber, new Event(date, eventType));
        return true;
    }

    private boolean validateEvent(String phoneNumber, long date, int msgBox) {
        if (TextUtils.isEmpty(phoneNumber) == false) goto L5;
    L9:
        return false;
    L5:
        if (date <= 0) goto L9;
        if (MSG_BOX_TO_EVENT_TYPE.indexOfKey(msgBox) < 0) goto L9;
        return true;
    }
}
