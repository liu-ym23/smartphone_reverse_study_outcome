package com.android.contacts.list;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import android.provider.ContactsContract;
import com.android.contacts.util.Constants;
import obric.api.ContactsContractSmt;

/* JADX INFO: loaded from: classes2.dex */
public class ProviderStatusLoader extends ContentObserver {
    private static final String[] PROJECTION = null;
    private static final int UNKNOWN = -1;
    private final Context mContext;
    private Handler mHandler;
    private ProviderStatusListener mListener;
    private String mProviderData;
    private int mProviderStatus;

    public interface ProviderStatusListener {
        void onProviderStatusChange();
    }

    static /* synthetic */ ProviderStatusListener access$000(ProviderStatusLoader r0) {
        return r0.mListener;
    }

    static /* synthetic */ int access$102(ProviderStatusLoader r0, int r1) {
        r0.mProviderStatus = r1;
        return r1;
    }

    static {
        if (Constants.ANDROID60 == false) goto L5;
        PROJECTION = new String[]{"status"};
        return;
    L5:
        PROJECTION = new String[]{"status", ContactsContractSmt.get_ProviderStatus_DATA1()};
    }

    public ProviderStatusLoader(Context r2) {
        super(null);
        this.mProviderStatus = -1;
        this.mHandler = new Handler();
        this.mContext = r2;
    }

    public int getProviderStatus() {
        if (this.mProviderStatus != (-1)) goto L6;
        loadProviderStatus();
    L6:
        return this.mProviderStatus;
    }

    public String getProviderStatusData() {
        if (this.mProviderStatus != (-1)) goto L6;
        loadProviderStatus();
    L6:
        return this.mProviderData;
    }

    protected void loadProviderStatus() {
        this.mProviderStatus = 0;
        Cursor r1 = this.mContext.getContentResolver().query(ContactsContract.ProviderStatus.CONTENT_URI, PROJECTION, null, null, null);
        if (r1 != null) goto L14;
        return;
    L14:
    L10:
        th = move-exception;
        r1.close();
        throw th;
    L5:
        if (r1.moveToFirst() == false) goto L9;
        this.mProviderStatus = r1.getInt(0);     // Catch: Throwable -> L10
        if (Constants.ANDROID60 == true) goto L9;
        this.mProviderData = r1.getString(1);     // Catch: Throwable -> L10
    L9:
        r1.close();
    }

    public void setProviderStatusListener(ProviderStatusListener r3) {
        this.mListener = r3;
        ContentResolver r0 = this.mContext.getContentResolver();
        if (r3 == null) goto L5;
        this.mProviderStatus = -1;
        r0.registerContentObserver(ContactsContract.ProviderStatus.CONTENT_URI, false, this);
        return;
    L5:
        r0.unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r2) {
        this.mHandler.post(new AnonymousClass1(this));
    }

    public void retryUpgrade() {
        ContentValues r0 = new ContentValues();
        r0.put("status", Integer.valueOf(ContactsContractSmt.get_STATUS_UPGRADING()));
        this.mContext.getContentResolver().update(ContactsContract.ProviderStatus.CONTENT_URI, r0, null, null);
    }
}
