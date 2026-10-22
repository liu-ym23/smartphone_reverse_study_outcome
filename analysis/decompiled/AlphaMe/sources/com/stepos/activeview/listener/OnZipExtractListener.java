package com.stepos.activeview.listener;

/* loaded from: classes.dex */
public interface OnZipExtractListener {
    public static final int EXTRACT_FAIL = 0;
    public static final int EXTRACT_SUCESS = 1;

    void onExtractError(String str);

    void onExtractFinished(int i4, String str);

    void onExtractStart(String str);
}
