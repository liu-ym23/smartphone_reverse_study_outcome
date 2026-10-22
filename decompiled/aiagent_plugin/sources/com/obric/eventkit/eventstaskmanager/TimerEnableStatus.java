package com.obric.eventkit.eventstaskmanager;

/* JADX INFO: loaded from: classes4.dex */
public final class TimerEnableStatus {
    public static final TimerEnableStatus INSTANCE = null;
    public static final int STATE_CLOSE = 2;
    public static final int STATE_DELETE = 3;
    public static final int STATE_DISABLED = 1;
    public static final int STATE_ENABLED = 0;

    static {
        INSTANCE = new TimerEnableStatus();
    }

    private TimerEnableStatus() {
    }
}
