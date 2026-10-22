package com.byted.cast.common.config;

import com.byted.cast.common.bean.MediaInfo;

/* JADX INFO: loaded from: classes39.dex */
public interface IMediaInfoListener {
    void onFail(int r100, String r101);

    void onSuccess(MediaInfo r100);
}
