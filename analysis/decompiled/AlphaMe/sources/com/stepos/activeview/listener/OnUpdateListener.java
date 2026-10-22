package com.stepos.activeview.listener;

/* loaded from: classes.dex */
public interface OnUpdateListener {
    public static final int UPDATE_DOWNLOAD = 2;
    public static final int UPDATE_EXTRACT = 3;
    public static final int UPDATE_FINISHED = 7;
    public static final int UPDATE_LOADJSON = 4;
    public static final int UPDATE_LOAD_RESOURCES = 5;
    public static final int UPDATE_READY_NOT_ADDED = 8;
    public static final int UPDATE_STATE_FAIL = 0;
    public static final int UPDATE_STATE_SUCCESS = 1;
    public static final int UPDATE_VERSION_COMPATIBALE = 6;
    public static final int UPDATE_VIDEO_STATE_COMPLETION = 10;
    public static final int UPDATE_VIDEO_STATE_ONERROR = 11;
    public static final int UPDATE_VIDEO_STATE_ONINFO = 12;
    public static final int UPDATE_VIDEO_STATE_PREPARED = 9;

    void onUpdateFinished(int i4, int i5, String str);
}
