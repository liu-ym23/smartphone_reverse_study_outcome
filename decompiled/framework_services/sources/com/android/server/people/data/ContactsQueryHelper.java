package com.android.server.people.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
class ContactsQueryHelper {
    private static final String TAG = "ContactsQueryHelper";
    private Uri mContactUri;
    private final Context mContext;
    private boolean mIsStarred;
    private long mLastUpdatedTimestamp;
    private String mPhoneNumber;

    ContactsQueryHelper(Context context) {
        this.mContext = context;
    }

    boolean query(String contactUri) {
        if (TextUtils.isEmpty(contactUri) == false) goto L5;
        return false;
    L5:
        Uri uri = Uri.parse(contactUri);
        if ("tel".equals(uri.getScheme()) == false) goto L10;
        return queryWithPhoneNumber(uri.getSchemeSpecificPart());
    L10:
        if ("mailto".equals(uri.getScheme()) == false) goto L14;
        return queryWithEmail(uri.getSchemeSpecificPart());
    L14:
        if (contactUri.startsWith(ContactsContract.Contacts.CONTENT_LOOKUP_URI.toString()) == true) goto L16;
        return false;
    L16:
        return queryWithUri(uri);
    }

    boolean querySince(long sinceTime) {
        String[] projection = {"_id", "lookup", "starred", "has_phone_number", "contact_last_updated_timestamp"};
        String[] selectionArgs = {Long.toString(sinceTime)};
        return queryContact(ContactsContract.Contacts.CONTENT_URI, projection, "contact_last_updated_timestamp > ?", selectionArgs);
    }

    Uri getContactUri() {
        return this.mContactUri;
    }

    boolean isStarred() {
        return this.mIsStarred;
    }

    String getPhoneNumber() {
        return this.mPhoneNumber;
    }

    long getLastUpdatedTimestamp() {
        return this.mLastUpdatedTimestamp;
    }

    private boolean queryWithPhoneNumber(String phoneNumber) {
        Uri phoneUri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(phoneNumber));
        return queryWithUri(phoneUri);
    }

    private boolean queryWithEmail(String email) {
        Uri emailUri = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Email.CONTENT_LOOKUP_URI, Uri.encode(email));
        return queryWithUri(emailUri);
    }

    private boolean queryWithUri(Uri uri) {
        String[] projection = {"_id", "lookup", "starred", "has_phone_number"};
        return queryContact(uri, projection, null, null);
    }

    private boolean queryContact(Uri uri, String[] projection, String selection, String[] selectionArgs) {
        String lookupKey = null;
        boolean hasPhoneNumber = false;
        boolean found = false;
        Cursor cursor = this.mContext.getContentResolver().query(uri, projection, selection, selectionArgs, null);     // Catch: Exception -> L10 IllegalArgumentException -> L12 SQLiteException -> L14
        if (cursor != null) goto L20;
        Slog.w(TAG, "Cursor is null when querying contact.");     // Catch: Throwable -> L17
        if (cursor == null) goto L16;
        cursor.close();     // Catch: Exception -> L10 IllegalArgumentException -> L12 SQLiteException -> L14
    L16:
        return false;
    L20:
        if (cursor.moveToNext() == false) goto L33;
        int idIndex = cursor.getColumnIndex("_id");     // Catch: Throwable -> L17
        long contactId = cursor.getLong(idIndex);     // Catch: Throwable -> L17
        int lookupKeyIndex = cursor.getColumnIndex("lookup");     // Catch: Throwable -> L17
        lookupKey = cursor.getString(lookupKeyIndex);     // Catch: Throwable -> L17
        this.mContactUri = ContactsContract.Contacts.getLookupUri(contactId, lookupKey);     // Catch: Throwable -> L17
        int starredIndex = cursor.getColumnIndex("starred");     // Catch: Throwable -> L17
        boolean r13 = true;
        if (cursor.getInt(starredIndex) == 0) goto L24;
        boolean r12 = true;
    L25:
        this.mIsStarred = r12;     // Catch: Throwable -> L17
        int hasPhoneNumIndex = cursor.getColumnIndex("has_phone_number");     // Catch: Throwable -> L17
        if (cursor.getInt(hasPhoneNumIndex) != 0) goto L29;
        r13 = false;
    L29:
        hasPhoneNumber = r13;
        int lastUpdatedTimestampIndex = cursor.getColumnIndex("contact_last_updated_timestamp");     // Catch: Throwable -> L17
        if (lastUpdatedTimestampIndex < 0) goto L32;
        this.mLastUpdatedTimestamp = cursor.getLong(lastUpdatedTimestampIndex);     // Catch: Throwable -> L17
    L32:
        found = true;
        goto L20
    L24:
        r12 = false;
        goto L25
    L33:
        cursor.close();     // Catch: Exception -> L10 IllegalArgumentException -> L12 SQLiteException -> L14
    L51:
        if (found == false) goto L56;
        if (lookupKey == null) goto L56;
        if (hasPhoneNumber == false) goto L56;
        return queryPhoneNumber(lookupKey);
    L56:
        return found;
    L17:
        th = move-exception;
        if (cursor != null) goto L58;
        throw th;     // Catch: Exception -> L40 IllegalArgumentException -> L42 SQLiteException -> L44
    L44:
        exception = e;
        lookupKey = null;
        hasPhoneNumber = false;
        found = false;
    L50:
        Slog.w(TAG, "SQLite exception when querying contacts.", exception);
    L42:
        exception = e;
        lookupKey = null;
        hasPhoneNumber = false;
        found = false;
    L49:
        Slog.w(TAG, "Illegal Argument exception when querying contacts.", exception);
    L40:
        exception = e;
        lookupKey = null;
        hasPhoneNumber = false;
        found = false;
    L48:
        Slog.e(TAG, "Exception when querying contacts.", exception);
        goto L51
    L58:
        cursor.close();     // Catch: Throwable -> L38
    L66:
        throw th;     // Catch: Exception -> L40 IllegalArgumentException -> L42 SQLiteException -> L44
    L38:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L40 IllegalArgumentException -> L42 SQLiteException -> L44
        throw th;     // Catch: Exception -> L40 IllegalArgumentException -> L42 SQLiteException -> L44
    L14:
        exception = e;
    L12:
        exception = e;
    L10:
        exception = e;
        goto L48
    }

    private boolean queryPhoneNumber(String lookupKey) {
        String[] projection = {"data4"};
        String[] selectionArgs = {lookupKey};
        Cursor cursor = this.mContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, projection, "lookup = ?", selectionArgs, null);     // Catch: Exception -> L9
        if (cursor != null) goto L16;
        Slog.w(TAG, "Cursor is null when querying contact phone number.");     // Catch: Throwable -> L13
        if (cursor == null) goto L11;
        cursor.close();     // Catch: Exception -> L9
        return false;
    L11:
        return false;
    L16:
        if (cursor.moveToNext() == false) goto L21;
        int phoneNumIdx = cursor.getColumnIndex("data4");     // Catch: Throwable -> L13
        if (phoneNumIdx < 0) goto L16;
        this.mPhoneNumber = cursor.getString(phoneNumIdx);     // Catch: Throwable -> L13
        goto L16
    L21:
        cursor.close();     // Catch: Exception -> L9
        return true;
    L13:
        th = move-exception;
        if (cursor == null) goto L42;
        cursor.close();     // Catch: Throwable -> L26
    L43:
        throw th;     // Catch: Exception -> L9
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L9
        throw th;     // Catch: Exception -> L9
    L42:
        throw th;     // Catch: Exception -> L9
    L9:
        exception = move-exception;
        Slog.e(TAG, "Exception when querying contact phone number.", exception);
        return true;
    }
}
