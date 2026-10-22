package com.stepos.core.ota.data;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DownloadState {
    public static final DownloadState INSTANCE = new DownloadState();
    public static final int STATUS_CHECKING = 5;
    public static final int STATUS_CTA_REJECTED = 14;
    public static final int STATUS_ERROR = 3;
    public static final int STATUS_FINISHED = 6;
    public static final int STATUS_INSUFFICIENT_SPACE = 18;
    public static final int STATUS_LOW_BATTERY = 19;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_NO_NETWORK = 17;
    public static final int STATUS_PAUSED = 4;
    public static final int STATUS_REMOVED = 7;
    public static final int STATUS_SERVICE_DISABLED = 16;
    public static final int STATUS_STARTED = 2;
    public static final int STATUS_USER_CANCELLED = 15;
    public static final int STATUS_USER_CONFIRMED = 13;
    public static final int STATUS_WAITING = 1;
    public static final int STATUS_WAITING_USER_ACTION = 10;

    private DownloadState() {
    }

    public final boolean isActive(int i10) {
        return i10 == 1 || i10 == 2 || i10 == 5;
    }

    public final boolean isTerminal(int i10) {
        return i10 == 6 || i10 == 3 || i10 == 7;
    }

    public final boolean isUserCancelled(int i10) {
        return i10 == 15;
    }

    public final boolean isUserInteractionState(int i10) {
        return i10 == 10 || i10 == 13;
    }
}
