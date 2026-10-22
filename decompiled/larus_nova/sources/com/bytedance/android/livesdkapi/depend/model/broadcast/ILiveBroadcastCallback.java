package com.bytedance.android.livesdkapi.depend.model.broadcast;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveBroadcastCallback {
    void registerReceiver(BroadcastReceiver r100, IntentFilter r101);

    void unregisterReceiver(BroadcastReceiver r100);
}
