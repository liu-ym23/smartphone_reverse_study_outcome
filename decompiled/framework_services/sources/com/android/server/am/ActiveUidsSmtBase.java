package com.android.server.am;

import com.android.server.SysOptBridge;

/* JADX INFO: loaded from: classes.dex */
public class ActiveUidsSmtBase {
    public static int ACTION_ADD;
    public static int ACTION_CLEAR;
    public static int ACTION_REMOVE;
    private IActiveUidsOptEx mOptEx;
    private ActiveUids mUids;

    static {
        ACTION_ADD = 1;
        ACTION_REMOVE = 2;
        ACTION_CLEAR = 3;
    }

    ActiveUidsSmtBase(ActiveUids uids) {
        this.mUids = uids;
        this.mOptEx = SysOptBridge.getFactory().getActiveUidsOptEx();
    }

    public void onUidEvent(int action, int uid, UidRecord record) {
        this.mOptEx.onUidEvent(action, uid, record);
    }
}
