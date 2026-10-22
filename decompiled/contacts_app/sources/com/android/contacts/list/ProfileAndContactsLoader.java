package com.android.contacts.list;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.google.android.collect.Lists;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ProfileAndContactsLoader extends CursorLoader {
    private final boolean DEBUG;
    private String TAG;
    private boolean isCityMode;
    private boolean mLoadProfile;
    private String[] mProjection;

    @Override // android.content.CursorLoader, android.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ Cursor loadInBackground() {
        return loadInBackground();
    }

    public ProfileAndContactsLoader(Context r2) {
        super(r2);
        this.isCityMode = false;
        this.TAG = "ProfileAndContactsLoader";
        this.DEBUG = false;
    }

    public void setLoadProfile(boolean r1) {
        this.mLoadProfile = r1;
    }

    @Override // android.content.CursorLoader
    public void setProjection(String[] r1) {
        super.setProjection(r1);
        this.mProjection = r1;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.content.CursorLoader, android.content.AsyncTaskLoader
    public Cursor loadInBackground() {
        ArrayList r0 = Lists.newArrayList();
        if (this.mLoadProfile == false) goto L5;
        r0.add(loadProfile());
    L5:
        final Cursor r1 = super.loadInBackground();
        r0.add(r1);
        final Cursor[] r2 = (Cursor[]) r0.toArray(new Cursor[r0.size()]);
        return new AnonymousClass1(this, r2, r1);
    }

    private MatrixCursor loadProfile() {
        if (this.isCityMode == false) goto L5;
        Uri r2 = Uri.parse("content://com.android.contacts/contacts_city");
        Cursor r0 = getContext().getContentResolver().query(r2, this.mProjection, null, null, null);
    L19:
        MatrixCursor r1 = new MatrixCursor(this.mProjection);     // Catch: Throwable -> L16
        int r7 = this.mProjection.length;     // Catch: Throwable -> L16
        Object[] r3 = new Object[r7];     // Catch: Throwable -> L16
    L7:
        if (r0.moveToNext() == false) goto L14;
        int r4 = 0;
    L10:
        if (r4 >= r7) goto L12;
        r3[r4] = r0.getString(r4);     // Catch: Throwable -> L16
        r4 = r4 + 1;     // Catch: Throwable -> L16
        goto L10
    L12:
        r1.addRow(r3);     // Catch: Throwable -> L16
        goto L7
    L14:
        r0.close();
        return r1;
    L16:
        th = move-exception;
        r0.close();
        throw th;
    L5:
        r0 = getContext().getContentResolver().query(ContactsContract.Profile.CONTENT_URI, this.mProjection, null, null, null);
        goto L19
    }
}
