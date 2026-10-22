package com.bytedance.common.wschannel.client;

import android.content.Context;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.ServiceParcelable;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.server.MainChannelManager;

/* JADX INFO: loaded from: classes2.dex */
public class WsChannelSingleProcessImpl implements WsChannelApi {
    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onTrimMemory(Context r1, int r2) {
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void tryStartPushProcess(Context r1, boolean r2) {
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void tryStartPushProcess(Context r1, boolean r2, boolean r3) {
    }

    public WsChannelSingleProcessImpl() {
    }

    private void sendAppState(Context r2, int r3) {
        if (r2 == null) goto L15;
        if (r3 > 0) goto L5;
        return;
    L5:
        if (r3 <= 3) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L11;
        Logger.d("WsChannelSdk", "sendAppState appState = " + r3);
    L11:
        if (WsChannelSettings.inst(r2).isEnable() == true) goto L13;
        return;
    L13:
        Message r1 = new Message();
        r1.what = 2;
        r1.arg1 = r3;
        MainChannelManager.inst(r2).handleMsg(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onEnterToForeground(Context r2) {
        sendAppState(r2, 1);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void sendPayload(Context r3, WsChannelMsg r4) {
        WsChannelApi.ServiceHolder r0 = new WsChannelApi.ServiceHolder();
        r0.key = "payload";
        r0.obj = r4;
        r0.what = 5;
        sendMsg(r3, r0);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void registerApp(Context r3, SsWsApp r4) {
        WsChannelApi.ServiceHolder r0 = new WsChannelApi.ServiceHolder();
        r0.key = WsConstants.KEY_WS_APP;
        r0.obj = r4;
        r0.what = 0;
        sendMsg(r3, r0);
    }

    private void sendMsg(Context r3, WsChannelApi.ServiceHolder r4) {
        Message r2 = Message.obtain();
        r2.what = r4.what;
        r2.getData().putParcelable(r4.key, r4.obj);
        MainChannelManager.inst(r3).handleMsg(r2);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void unRegisterApp(Context r3, int r4) {
        WsChannelApi.ServiceHolder r0 = new WsChannelApi.ServiceHolder();
        r0.key = WsConstants.KEY_WS_APP;
        r0.obj = new IntegerParcelable(r4);
        r0.what = 1;
        sendMsg(r3, r0);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onParameterChange(Context r3, SsWsApp r4) {
        if (WsChannelSettings.inst(r3).isEnable() == true) goto L5;
        return;
    L5:
        WsChannelApi.ServiceHolder r0 = new WsChannelApi.ServiceHolder();
        r0.key = WsConstants.KEY_WS_APP;
        r0.obj = r4;
        r0.what = 4;
        sendMsg(r3, r0);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onEnterToBackground(Context r2) {
        sendAppState(r2, 2);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void registerServiceId(Context r3, int r4, int r5) {
        WsChannelApi.ServiceHolder r0 = new WsChannelApi.ServiceHolder();
        r0.key = WsConstants.KEY_WS_APP;
        r0.obj = new ServiceParcelable(r4, r5);
        r0.what = 12;
        sendMsg(r3, r0);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void unregisterServiceId(Context r3, int r4, int r5) {
        WsChannelApi.ServiceHolder r0 = new WsChannelApi.ServiceHolder();
        r0.key = WsConstants.KEY_WS_APP;
        r0.obj = new ServiceParcelable(r4, r5);
        r0.what = 13;
        sendMsg(r3, r0);
    }
}
