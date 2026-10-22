package com.android.common.contacts;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import android.util.Log;
import com.android.contacts.common.SimContactsConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class DataUsageStatUpdater {
    private static final String TAG = "DataUsageStatUpdater";
    private final ContentResolver mResolver;

    public static final class DataUsageFeedback {
        static final Uri FEEDBACK_URI = null;
        static final String USAGE_TYPE = "type";
        public static final String USAGE_TYPE_CALL = "call";
        public static final String USAGE_TYPE_LONG_TEXT = "long_text";
        public static final String USAGE_TYPE_SHORT_TEXT = "short_text";

        public DataUsageFeedback() {
        }

        static {
            FEEDBACK_URI = Uri.withAppendedPath(ContactsContract.Data.CONTENT_URI, "usagefeedback");
        }
    }

    static {
    }

    public DataUsageStatUpdater(Context r1) {
        this.mResolver = r1.getContentResolver();
    }

    public boolean updateWithRfc822Address(Collection<CharSequence> r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        HashSet r1 = new HashSet();
        Iterator<CharSequence> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L12;
        Rfc822Token[] r2 = Rfc822Tokenizer.tokenize(r8.next().toString().trim());
        int r3 = r2.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L7;
        r1.add(r2[r4].getAddress());
        r4 = r4 + 1;
        goto L9
    L12:
        return updateWithAddress(r1);
    }

    public boolean updateWithAddress(Collection<String> r12) {
        String r0 = TAG;
        if (Log.isLoggable(r0, 3) == false) goto L6;
        Log.d(r0, "updateWithAddress: " + Arrays.toString(r12.toArray()));
    L6:
        if (r12 != null) goto L8;
    L23:
        return false;
    L8:
        if (r12.isEmpty() == true) goto L23;
        ArrayList r2 = new ArrayList();
        StringBuilder r3 = new StringBuilder("data1 IN (");
        String[] r4 = new String[r12.size()];
        r2.addAll(r12);
        Arrays.fill(r4, "?");
        r3.append(TextUtils.join(SimContactsConstants.EMAIL_SEP, r4)).append(")");
        Cursor r13 = this.mResolver.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, new String[]{"contact_id", "_id"}, r3.toString(), (String[]) r2.toArray(new String[0]), null);
        if (r13 != null) goto L12;
        Log.w(r0, "Cursor for Email.CONTENT_URI became null.");
        goto L23
    L12:
        HashSet r1 = new HashSet(r13.getCount());
        HashSet r5 = new HashSet(r13.getCount());
        r13.move(-1);     // Catch: Throwable -> L20
    L15:
        if (r13.moveToNext() == false) goto L18;
        r1.add(Long.valueOf(r13.getLong(0)));     // Catch: Throwable -> L20
        r5.add(Long.valueOf(r13.getLong(1)));     // Catch: Throwable -> L20
        goto L15
    L18:
        r13.close();
        return update(r1, r5, DataUsageFeedback.USAGE_TYPE_LONG_TEXT);
    L20:
        th = move-exception;
        r13.close();
        throw th;
    }

    public boolean updateWithPhoneNumber(Collection<String> r12) {
        String r0 = TAG;
        if (Log.isLoggable(r0, 3) == false) goto L6;
        Log.d(r0, "updateWithPhoneNumber: " + Arrays.toString(r12.toArray()));
    L6:
        if (r12 != null) goto L8;
    L23:
        return false;
    L8:
        if (r12.isEmpty() == true) goto L23;
        ArrayList r2 = new ArrayList();
        StringBuilder r3 = new StringBuilder("data1 IN (");
        String[] r4 = new String[r12.size()];
        r2.addAll(r12);
        Arrays.fill(r4, "?");
        r3.append(TextUtils.join(SimContactsConstants.EMAIL_SEP, r4)).append(")");
        Cursor r13 = this.mResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"contact_id", "_id"}, r3.toString(), (String[]) r2.toArray(new String[0]), null);
        if (r13 != null) goto L12;
        Log.w(r0, "Cursor for Phone.CONTENT_URI became null.");
        goto L23
    L12:
        HashSet r1 = new HashSet(r13.getCount());
        HashSet r5 = new HashSet(r13.getCount());
        r13.move(-1);     // Catch: Throwable -> L20
    L15:
        if (r13.moveToNext() == false) goto L18;
        r1.add(Long.valueOf(r13.getLong(0)));     // Catch: Throwable -> L20
        r5.add(Long.valueOf(r13.getLong(1)));     // Catch: Throwable -> L20
        goto L15
    L18:
        r13.close();
        return update(r1, r5, DataUsageFeedback.USAGE_TYPE_SHORT_TEXT);
    L20:
        th = move-exception;
        r13.close();
        throw th;
    }

    private boolean update(Collection<Long> r4, Collection<Long> r5, String r6) {
        System.currentTimeMillis();
        if (r5.isEmpty() == false) goto L8;
        String r3 = TAG;
        if (Log.isLoggable(r3, 3) == false) goto L14;
        Log.d(r3, "Given list for data IDs is null. Ignoring.");
        return false;
    L14:
        return false;
    L8:
        if (this.mResolver.update(DataUsageFeedback.FEEDBACK_URI.buildUpon().appendPath(TextUtils.join(SimContactsConstants.EMAIL_SEP, r5)).appendQueryParameter("type", r6).build(), new ContentValues(), null, null) <= 0) goto L10;
        return true;
    L10:
        String r7 = TAG;
        if (Log.isLoggable(r7, 3) == false) goto L17;
        Log.d(r7, "update toward data rows " + r5 + " failed");
        return false;
    L17:
        return false;
    }
}
