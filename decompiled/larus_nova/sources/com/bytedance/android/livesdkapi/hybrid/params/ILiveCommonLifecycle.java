package com.bytedance.android.livesdkapi.hybrid.params;

import android.view.View;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveCommonLifecycle {
    void onContainerError(View r100, int r101, String r102);

    void onLoadFail(View r100, String r101, String r102);

    void onLoadSuccess(View r100);

    void onRelease();
}
