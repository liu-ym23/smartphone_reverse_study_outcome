package org.chromium.wschannel;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.ttnet.org.chromium.net.impl.ai;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class MySelfChannelImpl implements WeakHandler.IHandler, IWsChannelClient {
    private static final String TAG = "MySelfChannelImpl";
    private static String WSCHANNEL_ACTION_BACK;
    private static String WSCHANNEL_ACTION_FORE;
    private static String sPackageName;
    private static volatile String sUserAgent;
    private Context mContext;
    private a mFrontierConnection;
    private IWsChannelClient mWsChannelClient;

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onNetworkStateChanged(int r1) {
    }

    public MySelfChannelImpl() {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void init(Context r4, IWsChannelClient r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        IWsChannelClient r7 = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r5, IWsChannelClient.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "MySelfChannelImpl init");
    L5:
        this.mContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        sPackageName = r6.getPackageName();
        this.mWsChannelClient = r7;
        this.mFrontierConnection = new a(this);
        if (TextUtils.isEmpty(sUserAgent) == true) goto L11;
    L8:
        WSCHANNEL_ACTION_BACK = this.mContext.getPackageName() + ".wschannel.APP_BACKGROUND";
        WSCHANNEL_ACTION_FORE = this.mContext.getPackageName() + ".wschannel.APP_FOREGROUND";
        return;
    L11:
        sUserAgent = ai.a(r6);     // Catch: Throwable -> L10
        goto L8
    }

    public static String getDefaultUserAgent() {
        return sUserAgent;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void destroy() {
        a r0 = this.mFrontierConnection;
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onAppStateChanged(int r3) {
        Intent r0 = new Intent();
        if (r3 != 1) goto L9;
        r0.setAction(WSCHANNEL_ACTION_FORE);
        if (TextUtils.isEmpty(sPackageName) == true) goto L7;
        r0.setPackage(sPackageName);
    L7:
        this.mContext.sendBroadcast(r0);
        return;
    L9:
        if (r3 != 2) goto L16;
        r0.setAction(WSCHANNEL_ACTION_BACK);
        if (TextUtils.isEmpty(sPackageName) == true) goto L13;
        r0.setPackage(sPackageName);
    L13:
        this.mContext.sendBroadcast(r0);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean isConnected() {
        a r0 = this.mFrontierConnection;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.f();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void openConnection(Map<String, Object> r3, List<String> r4) {
        Map<String, Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        a r2 = this.mFrontierConnection;
        if (r2 == null) goto L6;
        r2.a(r5, r6);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void stopConnection() {
        a r0 = this.mFrontierConnection;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onParameterChange(Map<String, Object> r3, List<String> r4) {
        Map<String, Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        a r0 = this.mFrontierConnection;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        openConnection(r5, r6);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(byte[] r3) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "WS sendMessage data:" + r3.toString());
    L5:
        a r0 = this.mFrontierConnection;
        if (r0 != null) goto L10;
        return false;
    L10:
        if (r0.b() == false) goto L16;
        if (this.mFrontierConnection.c() == false) goto L16;
        return this.mFrontierConnection.b(r3);
    L16:
        return this.mFrontierConnection.a(r3);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(WsChannelMsg r3) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "PP data:" + r3.toString());
    L5:
        a r2 = this.mFrontierConnection;
        if (r2 != null) goto L10;
        return false;
    L10:
        return r2.a(r3);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(byte[] r1) {
        IWsChannelClient r0 = this.mWsChannelClient;
        if (r0 == null) goto L6;
        r0.onMessage(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onConnection(JSONObject r3) {
        if (this.mWsChannelClient == null) goto L12;
        r3.put(WsConstants.KEY_CHANNEL_TYPE, 1);     // Catch: JSONException -> L6
    L8:
        this.mWsChannelClient.onConnection(r3);
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onServiceConnectEvent(int r1, boolean r2, String r3) {
        IWsChannelClient r0 = this.mWsChannelClient;
        if (r0 == null) goto L6;
        r0.onServiceConnectEvent(r1, r2, r3);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolEnabled() {
        a r0 = this.mFrontierConnection;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.b();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolProxyEnabled() {
        a r0 = this.mFrontierConnection;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.c();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(WsChannelMsg r1) {
        IWsChannelClient r0 = this.mWsChannelClient;
        if (r0 == null) goto L6;
        r0.onMessage(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void registerService(int r1) {
        a r0 = this.mFrontierConnection;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void unregisterService(int r1) {
        a r0 = this.mFrontierConnection;
        if (r0 == null) goto L6;
        r0.b(r1);
        return;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r2) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "handleMsg data:" + r2.toString());
        return;
    }
}
