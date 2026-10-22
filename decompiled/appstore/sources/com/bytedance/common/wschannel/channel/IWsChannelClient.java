package com.bytedance.common.wschannel.channel;

import android.content.Context;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IWsChannelClient {
    void destroy();

    void init(Context r10, IWsChannelClient r11);

    boolean isConnected();

    void onAppStateChanged(int r10);

    void onConnection(JSONObject r10);

    void onMessage(byte[] r10);

    void onNetworkStateChanged(int r10);

    void onParameterChange(Map<String, Object> r10, List<String> r11);

    void openConnection(Map<String, Object> r10, List<String> r11);

    boolean sendMessage(byte[] r10);

    void stopConnection();
}
