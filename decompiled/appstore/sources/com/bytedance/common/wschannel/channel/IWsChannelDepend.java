package com.bytedance.common.wschannel.channel;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface IWsChannelDepend {
    int getNetworkType(Context r10);

    void loadLibrary(Context r10, String r11);

    void loggerD(String r10, String r11);

    boolean loggerDebug();

    void setAdapter(IWsChannelDepend r10);
}
