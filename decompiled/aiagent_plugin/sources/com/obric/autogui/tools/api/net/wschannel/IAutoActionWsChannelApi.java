package com.obric.autogui.tools.api.net.wschannel;

import android.app.Application;
import d.h.a.q;
import d.x;

/* JADX INFO: compiled from: IAutoActionWsChannelApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionWsChannelApi {
    void connect();

    void disconnect();

    void init(Application r1);

    boolean isConnected();

    void registerOnReceiveCallback(a r1);

    void sendMessage(String r1, q<? super Boolean, ? super String, ? super Exception, x> r2);

    void unregisterOnReceiveCallback(a r1);
}
