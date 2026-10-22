package com.stepos.activeview.listener;

/* loaded from: classes.dex */
public interface OnActiveViewUpgradeListener {
    public static final int UPGRADE_JAR_FILE_DOWNLOAD = 7;
    public static final int UPGRADE_STATE_FAIL = 0;
    public static final int UPGRADE_STATE_SUCCESS = 1;

    void onUpgradeFinished(int i4, int i5, String str);
}
