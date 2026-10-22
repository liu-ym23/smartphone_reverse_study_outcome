package com.bytedanceos.appstore.download.utils;

/* JADX INFO: loaded from: classes2.dex */
public final enum AppDownloadState extends Enum<AppDownloadState> {
    private static final /* synthetic */ AppDownloadState[] $VALUES = null;
    public static final AppDownloadState CANCEL = null;
    private static final int DB_DOWNLOAD_APP_STATE_CANCEL = 6;
    private static final int DB_DOWNLOAD_APP_STATE_DELETE = 7;
    private static final int DB_DOWNLOAD_APP_STATE_DOWNLOADING = 1;
    private static final int DB_DOWNLOAD_APP_STATE_FAILED = 4;
    private static final int DB_DOWNLOAD_APP_STATE_INSTALLING = 2;
    private static final int DB_DOWNLOAD_APP_STATE_PAUSED = 5;
    private static final int DB_DOWNLOAD_APP_STATE_SUCCESS = 3;
    private static final int DB_DOWNLOAD_APP_STATE_WAIT = 0;
    public static final AppDownloadState DELETE = null;
    public static final AppDownloadState DOWNLOAD = null;
    public static final AppDownloadState FAILED = null;
    public static final AppDownloadState FINISH = null;
    public static final AppDownloadState INSTALL = null;
    public static final AppDownloadState PAUSED = null;
    public static final AppDownloadState WAIT = null;

    private static /* synthetic */ AppDownloadState[] $values() {
        return new AppDownloadState[]{WAIT, DOWNLOAD, INSTALL, FINISH, FAILED, PAUSED, CANCEL, DELETE};
    }

    static {
        WAIT = new AppDownloadState("WAIT", 0);
        DOWNLOAD = new AppDownloadState("DOWNLOAD", 1);
        INSTALL = new AppDownloadState("INSTALL", 2);
        FINISH = new AppDownloadState("FINISH", 3);
        FAILED = new AppDownloadState("FAILED", 4);
        PAUSED = new AppDownloadState("PAUSED", 5);
        CANCEL = new AppDownloadState("CANCEL", 6);
        DELETE = new AppDownloadState("DELETE", 7);
        $VALUES = $values();
    }

    private AppDownloadState(String r10, int r11) {
        super(r10, r11);
    }

    public static AppDownloadState restore(int r10) {
        switch(r10) {
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L4;
        };
    L4:
        return WAIT;
    L6:
        return DELETE;
    L8:
        return CANCEL;
    L10:
        return PAUSED;
    L12:
        return FAILED;
    L14:
        return FINISH;
    L16:
        return INSTALL;
    L18:
        return DOWNLOAD;
    L20:
        return WAIT;
    }

    public static AppDownloadState valueOf(String r10) {
        return (AppDownloadState) Enum.valueOf(AppDownloadState.class, r10);
    }

    public static AppDownloadState[] values() {
        return (AppDownloadState[]) $VALUES.clone();
    }
}
