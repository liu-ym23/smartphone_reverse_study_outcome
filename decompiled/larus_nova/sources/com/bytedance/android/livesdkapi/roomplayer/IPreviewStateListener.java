package com.bytedance.android.livesdkapi.roomplayer;

/* JADX INFO: loaded from: classes12.dex */
public interface IPreviewStateListener {
    public static final int PREVIEW_STATE_COMPLETE = 2;
    public static final int PREVIEW_STATE_START = 1;

    void onPlayError(String r100);

    void onStateChange(int r100);
}
