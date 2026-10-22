package com.bytedance.android.livehostapi.business.depend;

import android.content.Context;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostReady {
    boolean isSDKReady();

    void tryPreload(Context r100, boolean r101, OnVerifyPluginPreloadListener r102);
}
