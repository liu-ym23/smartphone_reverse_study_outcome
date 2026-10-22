package com.android.contacts.common.list;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.loader.content.CursorLoader;
import com.google.common.collect.Lists;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ProfileAndContactsLoader extends CursorLoader {
    private String[] mExtraProjection;
    private String mExtraSelection;
    private String[] mExtraSelectionArgs;
    private Uri mExtraUri;
    private boolean mLoadProfile;
    private boolean mMergeExtraContactsAfterPrimary;
    private String[] mProjection;

    @Override // androidx.loader.content.CursorLoader, androidx.loader.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ Cursor loadInBackground() {
        return loadInBackground();
    }

    public ProfileAndContactsLoader(Context r1) {
        super(r1);
    }

    public void setLoadProfile(boolean r1) {
        this.mLoadProfile = r1;
    }

    @Override // androidx.loader.content.CursorLoader
    public void setProjection(String[] r1) {
        super.setProjection(r1);
        this.mProjection = r1;
    }

    public void setLoadExtraContactsFirst(Uri r1, String[] r2) {
        this.mExtraUri = r1;
        this.mExtraProjection = r2;
        this.mMergeExtraContactsAfterPrimary = false;
    }

    public void setLoadExtraContactsLast(Uri r1, String[] r2, String r3, String[] r4) {
        this.mExtraUri = r1;
        this.mExtraProjection = r2;
        this.mExtraSelection = r3;
        this.mExtraSelectionArgs = r4;
        this.mMergeExtraContactsAfterPrimary = true;
    }

    private boolean canLoadExtraContacts() {
        if (this.mExtraUri != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mExtraProjection == null) goto L7;
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.loader.content.CursorLoader, androidx.loader.content.AsyncTaskLoader
    public Cursor loadInBackground() {
        ArrayList r0 = Lists.newArrayList();
        if (this.mLoadProfile == false) goto L6;
        r0.add(loadProfile());
    L6:
        if (canLoadExtraContacts() == true) goto L8;
    L20:
        final Cursor r1 = super.loadInBackground();     // Catch: Throwable -> L12
    L13:
        r0.add(r1);
        if (canLoadExtraContacts() == true) goto L16;
    L18:
        final Cursor[] r2 = (Cursor[]) r0.toArray(new Cursor[r0.size()]);
        return new AnonymousClass1(this, r2, r1);
    L16:
        if (this.mMergeExtraContactsAfterPrimary == false) goto L18;
        r0.add(loadExtraContacts());
    L12:
        r1 = null;
        goto L13
    L8:
        if (this.mMergeExtraContactsAfterPrimary == true) goto L20;
        r0.add(loadExtraContacts());
        goto L20
    }

    private MatrixCursor loadProfile() {
        Cursor r0 = getContext().getContentResolver().query(ContactsContract.Profile.CONTENT_URI, this.mProjection, null, null, null);
        if (r0 != null) goto L19;
        return null;
    L19:
        MatrixCursor r1 = new MatrixCursor(this.mProjection);     // Catch: Throwable -> L16
        int r7 = this.mProjection.length;     // Catch: Throwable -> L16
        Object[] r2 = new Object[r7];     // Catch: Throwable -> L16
    L7:
        if (r0.moveToNext() == false) goto L14;
        int r3 = 0;
    L10:
        if (r3 >= r7) goto L12;
        r2[r3] = r0.getString(r3);     // Catch: Throwable -> L16
        r3 = r3 + 1;     // Catch: Throwable -> L16
        goto L10
    L12:
        r1.addRow(r2);     // Catch: Throwable -> L16
        goto L7
    L14:
        r0.close();
        return r1;
    L16:
        th = move-exception;
        r0.close();
        throw th;
    }

    private Cursor loadExtraContacts() {
        return getContext().getContentResolver().query(this.mExtraUri, this.mExtraProjection, this.mExtraSelection, this.mExtraSelectionArgs, null);
    }
}
