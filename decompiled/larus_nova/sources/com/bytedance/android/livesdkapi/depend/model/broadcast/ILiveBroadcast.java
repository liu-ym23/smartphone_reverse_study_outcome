package com.bytedance.android.livesdkapi.depend.model.broadcast;

import com.bytedance.android.livesdkapi.IStartLiveInterceptor;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveBroadcast {
    public static final int IMAGE_PICKER_STATS_END = 10001;
    public static final int IMAGE_PICKER_STATS_START = 10000;
    public static final int RESULT_DEFAULT = 120;

    public interface ImagePickerStatsListener {
        void onStatsChange(int r100);
    }

    public interface OnStartLiveInterceptListener {
        void addInterceptor(IStartLiveInterceptor r100, int r101);

        void removeInterceptor(IStartLiveInterceptor r100);
    }
}
