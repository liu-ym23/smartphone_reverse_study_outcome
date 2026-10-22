package com.bytedance.common.wschannel.channel.impl.ok;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import java.io.UnsupportedEncodingException;
import okhttp3.Response;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements WsOkClient.WsStatusListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IWsChannelClient f6976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WsOkClient f6977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f6978c;

    public c(Context r10, WsOkClient r11, IWsChannelClient r12) {
        this.f6977b = r11;
        this.f6976a = r12;
        this.f6978c = r10;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsStatusListener
    public void onClosed(String r10, int r11, String r12) {
        Logger.d("WsChannelSdk_ok", "onClosed() : " + r12);
        if (this.f6976a == null) goto L12;
        JSONObject r13 = new JSONObject();
        r13.put("type", 0);     // Catch: Exception -> L7
        r13.put(WsConstants.KEY_CONNECTION_STATE, 3);     // Catch: Exception -> L7
        r13.put("url", r10);     // Catch: Exception -> L7
        r13.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        this.f6976a.onConnection(r13);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsStatusListener
    public void onConnecting(String r10) {
        if (this.f6976a == null) goto L12;
        JSONObject r11 = new JSONObject();
        r11.put("type", 1);     // Catch: Exception -> L7
        r11.put(WsConstants.KEY_CONNECTION_STATE, 1);     // Catch: Exception -> L7
        r11.put("url", r10);     // Catch: Exception -> L7
        r11.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        this.f6976a.onConnection(r11);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsStatusListener
    public void onFailure(String r10, int r11, String r12) {
        Logger.d("WsChannelSdk_ok", "onFailure() : " + r12);
        Bundle r13 = new Bundle();
        r13.putString("url", r10);
        r13.putInt(WsConstants.ERROR_CODE, r11);
        r13.putString("error_msg", r12);
        r13.putString("method", "onFailure");
        i4.a.a(this.f6978c, "WsChannelSdk_ok", r13);
        if (this.f6976a == null) goto L12;
        JSONObject r14 = new JSONObject();
        r14.put("type", 0);     // Catch: Exception -> L7
        r14.put(WsConstants.KEY_CONNECTION_STATE, 2);     // Catch: Exception -> L7
        r14.put("url", r10);     // Catch: Exception -> L7
        r14.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        r14.put("error", r12);     // Catch: Exception -> L7
        r14.put(WsConstants.ERROR_CODE, r11);     // Catch: Exception -> L7
        this.f6976a.onConnection(r14);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsStatusListener
    public void onMessage(ByteString r10) {
        Logger.d("WsChannelSdk_ok", "onMessage() : " + r10.toString());
        IWsChannelClient r11 = this.f6976a;
        if (r11 == null) goto L6;
        r11.onMessage(r10.toByteArray());
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsStatusListener
    public void onOpen(Response r10) {
        Logger.d("WsChannelSdk_ok", "onOpen(): " + r10.toString());
        if (this.f6976a == null) goto L12;
        JSONObject r11 = new JSONObject();
        r11.put("type", 1);     // Catch: Exception -> L7
        r11.put(WsConstants.KEY_CONNECTION_STATE, 4);     // Catch: Exception -> L7
        r11.put("url", r10.r().k().toString());     // Catch: Exception -> L7
        r11.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L7
        this.f6976a.onConnection(r11);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.WsOkClient.WsStatusListener
    public void onMessage(String r10) {
        Logger.d("WsChannelSdk_ok", "onMessage():" + r10);
        IWsChannelClient r11 = this.f6976a;
        if (r11 == null) goto L11;
        r11.onMessage(r10.getBytes("UTF-8"));     // Catch: UnsupportedEncodingException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
