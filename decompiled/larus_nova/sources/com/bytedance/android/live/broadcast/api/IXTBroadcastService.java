package com.bytedance.android.live.broadcast.api;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdkapi.LiveActivityProxy;

/* JADX INFO: loaded from: classes45.dex */
public interface IXTBroadcastService {
    LiveActivityProxy createXTBroadcastBeforeActivityProxy(FragmentActivity r100);

    LiveActivityProxy createXTBroadcastResDownloadActivityProxy(FragmentActivity r100);
}
