package com.stepos.appcenter.aidl;

/* loaded from: classes3.dex */
public interface DownloadState {
    public static final int DOWNLOAD_CANCLE = 15;
    public static final int DOWNLOAD_COMPLETED = 13;
    public static final int DOWNLOAD_PAUSED = 12;
    public static final int DOWNLOAD_PREPARING = 10;
    public static final int DOWNLOAD_REMOVED = 14;
    public static final int DOWNLOAD_STARTED = 11;
    public static final int ERROR_APP_NOT_FOUND = -11;
    public static final int ERROR_APP_SIGN = -12;
    public static final int ERROR_DOWNLOAD_CONNECTION = -14;
    public static final int ERROR_ERROR_IO = -16;
    public static final int ERROR_FETCH_URL = -13;
    public static final int ERROR_NO_SPACE = -15;
    public static final int ERROR_PARAMS = -1;
    public static final int ERROR_PATCHED = -17;
    public static final int INSTALL_FAILURE = -18;
    public static final int INSTALL_START = 20;
    public static final int INSTALL_SUCCESS = 21;
    public static final int LAUNCH_APP = 22;
}
