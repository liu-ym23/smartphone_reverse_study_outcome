package com.android.contacts;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class CootekManager {
    private static final boolean DBG = false;
    private static final boolean FEATURE_SMVOIP_SUPPORT = false;
    private static final String TAG = "CootekManager";
    private static CootekManager sCootekManager;
    private Context mContext;
    private boolean mVoipServiceConnected;

    private void ensureVoipConnected() {
    }

    public boolean[] areUsersExist(String[] r1) {
        return null;
    }

    public boolean hasRegisteredPhoneNumber() {
        return false;
    }

    public boolean isUserExist(String r1) {
        return false;
    }

    public static synchronized CootekManager getInstance() {
        monitor-enter(CootekManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sCootekManager != null) goto L7;
        sCootekManager = new CootekManager();     // Catch: Throwable -> L10
    L7:
        CootekManager r1 = sCootekManager;     // Catch: Throwable -> L10
        monitor-exit(CootekManager.class);
        return r1;
    }

    private CootekManager() {
        this.mVoipServiceConnected = false;
        this.mContext = ContactsApplication.getInstance().getApplicationContext();
    }
}
