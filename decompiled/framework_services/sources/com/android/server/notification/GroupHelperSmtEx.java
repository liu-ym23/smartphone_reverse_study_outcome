package com.android.server.notification;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class GroupHelperSmtEx {
    protected static final int AUTOGROUP_AT_CUSTOM_COUNT = 1;
    protected static final String AUTOGROUP_CUSTOM_KEY = "ranker_custom_group";
    private static final boolean DEBUG = false;
    private static final String TAG = "GroupHelperSmtEx";
    private GroupHelper mGroupHelper;

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public GroupHelperSmtEx(GroupHelper helper) {
        this.mGroupHelper = helper;
    }
}
