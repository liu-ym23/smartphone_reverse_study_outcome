package com.bytedance.android.livesdkapi;

import android.content.Intent;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveActivityResultListener {

    public interface OnLiveActivityResultListener {
        void onActivityResult(int r100, int r101, Intent r102);
    }

    void setOnLiveActivityResultListener(OnLiveActivityResultListener r100);
}
