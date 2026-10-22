package com.android.server.contentcapture;

import android.util.EventLog;

/* JADX INFO: loaded from: classes.dex */
public class EventLogTags {
    public static final int CC_CONNECT_STATE_CHANGED = 53200;
    public static final int CC_CURRENT_ALLOWLIST = 53202;
    public static final int CC_SET_ALLOWLIST = 53201;
    public static final int CC_UPDATE_OPTIONS = 53203;

    private EventLogTags() {
    }

    public static void writeCcConnectStateChanged(int user, int type, int packageCount) {
        EventLog.writeEvent(CC_CONNECT_STATE_CHANGED, new Object[]{Integer.valueOf(user), Integer.valueOf(type), Integer.valueOf(packageCount)});
    }

    public static void writeCcSetAllowlist(int user, int packageCount, int activityCount) {
        EventLog.writeEvent(CC_SET_ALLOWLIST, new Object[]{Integer.valueOf(user), Integer.valueOf(packageCount), Integer.valueOf(activityCount)});
    }

    public static void writeCcCurrentAllowlist(int user, int count) {
        EventLog.writeEvent(CC_CURRENT_ALLOWLIST, new Object[]{Integer.valueOf(user), Integer.valueOf(count)});
    }

    public static void writeCcUpdateOptions(int user, int count) {
        EventLog.writeEvent(CC_UPDATE_OPTIONS, new Object[]{Integer.valueOf(user), Integer.valueOf(count)});
    }
}
