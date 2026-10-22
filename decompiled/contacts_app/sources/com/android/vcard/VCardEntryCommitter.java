package com.android.vcard;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class VCardEntryCommitter implements VCardEntryHandler {
    public static String LOG_TAG = "vCard";
    private boolean mAllowJoin;
    private final ContentResolver mContentResolver;
    private int mCounter;
    private final ArrayList<Uri> mCreatedUris;
    private ArrayList<ContentProviderOperation> mOperationList;
    private long mTimeToCommit;

    static {
    }

    @Override // com.android.vcard.VCardEntryHandler
    public void onStart() {
    }

    public VCardEntryCommitter(ContentResolver r2) {
        this.mCreatedUris = new ArrayList();
        this.mAllowJoin = true;
        this.mContentResolver = r2;
    }

    @Override // com.android.vcard.VCardEntryHandler
    public void onEnd() {
        ArrayList<ContentProviderOperation> r0 = this.mOperationList;
        if (r0 == null) goto L6;
        this.mCreatedUris.add(pushIntoContentResolver(r0));
    L6:
        if (VCardConfig.showPerformanceLog() == false) goto L9;
        Log.d(LOG_TAG, String.format("time to commit entries: %d ms", new Object[]{Long.valueOf(this.mTimeToCommit)}));
        return;
    }

    @Override // com.android.vcard.VCardEntryHandler
    public void onEntryCreated(VCardEntry r7) {
        long r0 = System.currentTimeMillis();
        ArrayList<ContentProviderOperation> r8 = r7.constructInsertOperations(this.mContentResolver, this.mOperationList, this.mAllowJoin);
        this.mOperationList = r8;
        this.mCounter++;
        if (r8 != null) goto L5;
    L7:
        this.mTimeToCommit += System.currentTimeMillis() - r0;
        return;
    L5:
        if (r8.size() < 450) goto L7;
        this.mCreatedUris.add(pushIntoContentResolver(this.mOperationList));
        this.mCounter = 0;
        this.mOperationList = null;
        goto L7
    }

    private Uri pushIntoContentResolver(ArrayList<ContentProviderOperation> r7) {
        ContentProviderResult[] r6 = this.mContentResolver.applyBatch("com.android.contacts", r7);     // Catch: OperationApplicationException -> L12 RemoteException -> L15
        if (r6 != null) goto L6;
        return null;
    L6:
        if (r6.length == 0) goto L21;
        ContentProviderResult r8 = r6[0];     // Catch: OperationApplicationException -> L12 RemoteException -> L15
        if (r8 == null) goto L22;
        return r8.uri;
    L22:
        return null;
    L21:
        return null;
    L12:
        e = move-exception;
        Log.e(LOG_TAG, String.format("%s: %s", new Object[]{e.toString(), e.getMessage()}));
        return null;
    L15:
        e = move-exception;
        Log.e(LOG_TAG, String.format("%s: %s", new Object[]{e.toString(), e.getMessage()}));
        return null;
    }

    public ArrayList<Uri> getCreatedUris() {
        return this.mCreatedUris;
    }

    public void setAllowJoin(boolean r1) {
        this.mAllowJoin = r1;
    }
}
