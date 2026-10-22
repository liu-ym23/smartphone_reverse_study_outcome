package com.android.contacts;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class EmergencyContactProvider extends ContentProvider {
    private static final String AUTHORITY = "com.android.contacts.emergency";
    private static final int MATCH_CONTACT = 1;
    private static final UriMatcher URI_MATCHER = null;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    public EmergencyContactProvider() {
    }

    static {
        UriMatcher r0 = new UriMatcher(-1);
        URI_MATCHER = r0;
        r0.addURI(AUTHORITY, "contact", 1);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r2, String[] r3, String r4, String[] r5, String r6) {
        if (URI_MATCHER.match(r2) != 1) goto L13;
        if (getContext() != null) goto L8;
        return null;
    L8:
        ContentValues r1 = ContactsUtils.getEmergencyContactInfos(getContext());
        MatrixCursor r7 = new MatrixCursor(new String[]{"display_name", "data1"}, 1);
        if (r1 == null) goto L11;
        r7.addRow(new Object[]{r1.getAsString("display_name"), r1.getAsString("data1")});
    L11:
        return r7;
    L13:
        throw new IllegalArgumentException("Unsupported uri: " + r2);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r3) {
        if (URI_MATCHER.match(r3) != 1) goto L7;
        return "vnd.android.cursor.item/emergency_contact";
    L7:
        throw new IllegalArgumentException("Unsupported uri: " + r3);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r2, ContentValues r3) {
        throw new UnsupportedOperationException("Insert is not supported: " + r2);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        throw new UnsupportedOperationException("Delete is not supported: " + r1);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        throw new UnsupportedOperationException("Update is not supported: " + r1);
    }
}
