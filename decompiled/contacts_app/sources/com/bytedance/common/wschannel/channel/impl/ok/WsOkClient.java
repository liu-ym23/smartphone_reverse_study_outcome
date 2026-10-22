package com.bytedance.common.wschannel.channel.impl.ok;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.android.contacts.common.SimContactsConstants;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy;
import com.bytedance.common.wschannel.channel.impl.ok.ws.CustomHeartBeatRealWebSocket;
import com.bytedance.common.wschannel.channel.impl.ok.ws.CustomHeartBeatWebSocket;
import com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketListener;
import com.bytedance.common.wschannel.heartbeat.BaseHeartBeatPolicy;
import com.bytedance.common.wschannel.heartbeat.CompensateHeartBeatManager;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import com.bytedance.common.wschannel.heartbeat.normal.NormalHeartBeatMeta;
import com.bytedance.common.wschannel.heartbeat.normal.NormalHeartBeatPolicy;
import com.bytedance.common.wschannel.model.Frame;
import com.bytedance.common.wschannel.server.NetworkUtils;
import com.bytedance.common.wschannel.utils.Utils;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchResult;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLRequest;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.squareup.wire.Wire;
import java.io.Closeable;
import java.io.IOException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
class WsOkClient implements WeakHandler.IHandler {
    private static final int MSG_APP_STATE_CHANGED = 5;
    private static final int MSG_CONNECT = 2;
    private static final int MSG_DESTROY = 4;
    private static final int MSG_NETWORK_CHANGED = 3;
    private static final int MSG_PARAMETER_CHANGED = 7;
    private static final int MSG_RECONNECT = 1;
    private static final int MSG_RELEASE_PENDGING_SOCKET = 6;
    private boolean isManualClose;
    private CompensateHeartBeatManager mCompensateHeartBeatManager;
    private final Config mConfig;
    private Map<String, Object> mConfigMap;
    private final Context mContext;
    private CustomHeartBeatRealWebSocket mCurrentSocket;
    private int mCurrentStatus;
    private Handler mHandler;
    private BaseHeartBeatPolicy mHeartBeatPolicy;
    private WebSocketListener mListener;
    private OkHttpClient mOkHttpClient;
    private boolean mPendingConnectAfterClosed;
    private WsPolicy mPolicy;
    private Request mRequest;
    private WsStatusListener mWsStatusListener;

    public static final class Builder {
        private Context mContext;
        private BaseHeartBeatPolicy mHeartBeatPolicy;
        private OkHttpClient mOkHttpClient;
        private RetryPolicy mRetryPolicy;
        private List<String> wsUrls;

        Builder(Context r1) {
            this.mContext = r1;
        }

        Builder retryPolicy(RetryPolicy r1) {
            this.mRetryPolicy = r1;
            return this;
        }

        public Builder setUrls(List<String> r1) {
            this.wsUrls = r1;
            return this;
        }

        public Builder client(OkHttpClient r1) {
            this.mOkHttpClient = r1;
            return this;
        }

        Builder heartBeatPolicy(BaseHeartBeatPolicy r1) {
            if (r1 == null) goto L4;
            this.mHeartBeatPolicy = r1;
        L4:
            return this;
        }

        public WsOkClient build() {
            return new WsOkClient(new Config(this.mContext, this.wsUrls, this.mOkHttpClient, this.mRetryPolicy, this.mHeartBeatPolicy), null);
        }
    }

    static final class Config {
        private Context mContext;
        private BaseHeartBeatPolicy mHeartBeatPolicy;
        private OkHttpClient mOkHttpClient;
        private RetryPolicy mRetryPolicy;
        private List<String> wsUrls;

        static /* synthetic */ Context access$100(Config r0) {
            return r0.mContext;
        }

        static /* synthetic */ OkHttpClient access$200(Config r0) {
            return r0.mOkHttpClient;
        }

        static /* synthetic */ BaseHeartBeatPolicy access$300(Config r0) {
            return r0.mHeartBeatPolicy;
        }

        static /* synthetic */ List access$800(Config r0) {
            return r0.wsUrls;
        }

        static /* synthetic */ List access$802(Config r0, List r1) {
            r0.wsUrls = r1;
            return r1;
        }

        static /* synthetic */ RetryPolicy access$900(Config r0) {
            return r0.mRetryPolicy;
        }

        public String toString() {
            return "Config{mHeartBeatPolicy=" + this.mHeartBeatPolicy + ", mContext=" + this.mContext + ", wsUrls=" + this.wsUrls + ", mOkHttpClient=" + this.mOkHttpClient + ", mRetryPolicy=" + this.mRetryPolicy + '}';
        }

        Config(Context r1, List<String> r2, OkHttpClient r3, RetryPolicy r4, BaseHeartBeatPolicy r5) {
            this.mContext = r1;
            this.wsUrls = r2;
            this.mOkHttpClient = r3;
            this.mRetryPolicy = r4;
            this.mHeartBeatPolicy = r5;
        }
    }

    private class WsListener extends WebSocketListener {
        final /* synthetic */ WsOkClient this$0;

        private boolean canRetry(int r1) {
            if (r1 > 0) goto L4;
        L13:
            return true;
        L4:
            if (r1 == 414) goto L13;
            if (r1 == 511) goto L13;
            if (r1 == 512) goto L13;
            if (r1 == 513) goto L13;
            return false;
        }

        private WsListener(WsOkClient r1) {
            this.this$0 = r1;
        }

        /* synthetic */ WsListener(WsOkClient r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ boolean access$2700(WsListener r0, int r1) {
            return r0.canRetry(r1);
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketListener
        public void onOpen(final CustomHeartBeatWebSocket r2, final Response r3) {
            Runnable r0 = new AnonymousClass1(this, r2, r3);
            WsOkClient.access$1700(this.this$0, r0);
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketListener
        public void onMessage(CustomHeartBeatWebSocket r2, final ByteString r3) {
            WsOkClient.access$1700(this.this$0, new AnonymousClass2(this, r3));
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketListener
        public void onMessage(CustomHeartBeatWebSocket r2, final String r3) {
            WsOkClient.access$1700(this.this$0, new AnonymousClass3(this, r3));
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketListener
        public void onClosing(CustomHeartBeatWebSocket r1, int r2, String r3) {
            super.onClosing(r1, r2, r3);
            WsOkClient.access$1700(this.this$0, new AnonymousClass4(this));
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketListener
        public void onClosed(final CustomHeartBeatWebSocket r9, final int r10, final String r11) {
            final String r4 = WsOkClient.access$1900(this.this$0, r9);
            WsOkClient.access$1700(this.this$0, new AnonymousClass5(this, r9, r4, r10, r11));
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketListener
        public void onFailure(final CustomHeartBeatWebSocket r9, Throwable r10, Response r11) {
            final String r3 = WsOkClient.access$1900(this.this$0, r9);
            final int r4 = WsOkClient.access$2400(this.this$0, r11);
            String r0 = WsOkClient.access$2500(this.this$0, r4);
            if (StringUtils.isEmpty(r0) == true) goto L5;
            final String r5 = r0;
        L10:
            final Pair<String, Long> r7 = WsOkClient.access$2100(this.this$0).getRetryUrlAndInterval(r11);
            WsOkClient.access$2600(this.this$0, r11);
            WsOkClient.access$1700(this.this$0, new AnonymousClass6(this, r3, r4, r5, r9, r7));
            return;
        L5:
            if (StringUtils.isEmpty(r10.getMessage()) == false) goto L7;
            String r12 = Log.getStackTraceString(r10);
        L8:
            r5 = r12;
            goto L10
        L7:
            r12 = r10.getMessage();
            goto L8
        }

        @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketListener
        public void onPong(final CustomHeartBeatWebSocket r2, ByteString r3) {
            WsOkClient.access$1700(this.this$0, new AnonymousClass7(this, r2));
        }
    }

    interface WsStatusListener {
        void onClosed(String r1, int r2, String r3);

        void onConnecting(String r1);

        void onFailure(String r1, int r2, String r3);

        void onMessage(String r1);

        void onMessage(ByteString r1);

        void onOpen(Response r1);
    }

    private static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder r0) {
        return r0;
    }

    private String getErrorReason(int r1) {
        if (r1 != 0) goto L5;
        return "success";
    L5:
        if (r1 != 404) goto L8;
        return "uri not found";
    L8:
        if (r1 != 409) goto L11;
        return "fpid not registered";
    L11:
        if (r1 != 410) goto L14;
        return "invalid device id";
    L14:
        if (r1 != 411) goto L17;
        return "appid not registered";
    L17:
        if (r1 != 412) goto L20;
        return "websocket protocol not support";
    L20:
        if (r1 != 413) goto L23;
        return "the device already connected";
    L23:
        if (r1 != 414) goto L26;
        return "server can't accept more connection,try again later";
    L26:
        if (r1 != 415) goto L29;
        return "device was blocked";
    L29:
        if (r1 != 416) goto L32;
        return "parameter error";
    L32:
        if (r1 != 417) goto L35;
        return "authentication failed";
    L35:
        if (r1 != 510) goto L38;
        return "server internal error";
    L38:
        if (r1 != 511) goto L41;
        return "server is busy，try again later";
    L41:
        if (r1 != 512) goto L44;
        return "server is shutting down";
    L44:
        if (r1 != 513) goto L47;
        return "auth server is error";
    L47:
        if (r1 != 514) goto L49;
        return "auth return error";
    L49:
        return "";
    }

    /* synthetic */ WsOkClient(Config r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ Handler access$1000(WsOkClient r0) {
        return r0.mHandler;
    }

    static /* synthetic */ CustomHeartBeatRealWebSocket access$1100(WsOkClient r0) {
        return r0.mCurrentSocket;
    }

    static /* synthetic */ CustomHeartBeatRealWebSocket access$1102(WsOkClient r0, CustomHeartBeatRealWebSocket r1) {
        r0.mCurrentSocket = r1;
        return r1;
    }

    static /* synthetic */ BaseHeartBeatPolicy access$1200(WsOkClient r0) {
        return r0.mHeartBeatPolicy;
    }

    static /* synthetic */ void access$1400(WsOkClient r0, int r1) {
        r0.setStatus(r1);
    }

    static /* synthetic */ void access$1500(WsOkClient r0) {
        r0.cancelReconnect();
    }

    static /* synthetic */ WsStatusListener access$1600(WsOkClient r0) {
        return r0.mWsStatusListener;
    }

    static /* synthetic */ void access$1700(WsOkClient r0, Runnable r1) {
        r0.runOnHandlerThread(r1);
    }

    static /* synthetic */ void access$1800(WsOkClient r0, byte[] r1) throws IOException {
        r0.sendMessageAckIfNeeded(r1);
    }

    static /* synthetic */ String access$1900(WsOkClient r0, WebSocket r1) {
        return r0.safeGetUrl(r1);
    }

    static /* synthetic */ boolean access$2000(WsOkClient r0) {
        return r0.mPendingConnectAfterClosed;
    }

    static /* synthetic */ boolean access$2002(WsOkClient r0, boolean r1) {
        r0.mPendingConnectAfterClosed = r1;
        return r1;
    }

    static /* synthetic */ WsPolicy access$2100(WsOkClient r0) {
        return r0.mPolicy;
    }

    static /* synthetic */ void access$2200(WsOkClient r0, String r1) {
        r0.tryConnect(r1);
    }

    static /* synthetic */ void access$2300(WsOkClient r0, long r1, String r3, boolean r4) {
        r0.tryReconnect(r1, r3, r4);
    }

    static /* synthetic */ int access$2400(WsOkClient r0, Response r1) {
        return r0.getErrorCode(r1);
    }

    static /* synthetic */ String access$2500(WsOkClient r0, int r1) {
        return r0.getErrorReason(r1);
    }

    static /* synthetic */ void access$2600(WsOkClient r0, Closeable r1) {
        r0.safeClose(r1);
    }

    static /* synthetic */ void access$2800(WsOkClient r0) {
        r0.resetPolicy();
    }

    static /* synthetic */ CompensateHeartBeatManager access$2900(WsOkClient r0) {
        return r0.mCompensateHeartBeatManager;
    }

    static /* synthetic */ void access$400(WsOkClient r0) {
        r0.reactOnHeartBeatTimeout();
    }

    static /* synthetic */ void access$500(WsOkClient r0) {
        r0.reactOnSendPing();
    }

    static /* synthetic */ boolean access$600(WsOkClient r0) {
        return r0.isManualClose;
    }

    static /* synthetic */ boolean access$602(WsOkClient r0, boolean r1) {
        r0.isManualClose = r1;
        return r1;
    }

    static /* synthetic */ void access$700(WsOkClient r0) {
        r0.stopConnectInternal();
    }

    private WsOkClient(Config r3) {
        this.mCurrentStatus = 3;
        this.mConfigMap = new ConcurrentHashMap();
        this.mHandler = new WeakHandler(Looper.myLooper(), this);
        this.mListener = new WsListener(this, null);
        this.mConfig = r3;
        this.mContext = Config.access$100(r3);
        this.mOkHttpClient = Config.access$200(r3);
        BaseHeartBeatPolicy r4 = Config.access$300(r3);
        this.mHeartBeatPolicy = r4;
        if (r4 != null) goto L5;
        this.mHeartBeatPolicy = new NormalHeartBeatPolicy(new NormalHeartBeatMeta().provideDefaultMeta());
    L5:
        this.mHeartBeatPolicy.init(new AnonymousClass1(this), this.mHandler);
        this.mCompensateHeartBeatManager = new CompensateHeartBeatManager(new AnonymousClass2(this), this.mHandler);
    }

    private void tryConnect(String r6) {
        if (isNetworkConnected(this.mContext) == true) goto L6;
        notifyFailedAndReset(r6, 1, "network error", true);
        return;
    L6:
        int r0 = getCurrentStatus();
        if (r0 == 4) goto L24;
        if (r0 == 1) goto L25;
        initAndConnect(r6);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        if (this.mWsStatusListener == null) goto L16;
        this.mWsStatusListener.onFailure(r6, 4, Log.getStackTraceString(th));
    L16:
        if (WsConstants.TTNET_TRAFFIC_CONTROL_DROP.equals(th.getMessage()) == false) goto L26;
        String r2 = this.mPolicy.getNextUrl();
        if (TextUtils.isEmpty(r2) == true) goto L20;
        Logger.d(OkChannelImpl.TAG, th.getMessage() + SimContactsConstants.ANR_SEP + r6 + ", try next url:" + r2);
        tryReconnect(0, r2, true);
        return;
    L20:
        Logger.d(OkChannelImpl.TAG, "All urls are dropped, stop retry.");
        this.mPolicy.reset();
        return;
    L26:
        return;
    L25:
        return;
    }

    private void tryReconnect(long r6, String r8, boolean r9) {
        this.mHandler.removeMessages(1);
        if (isNetworkConnected(this.mContext) == true) goto L7;
        notifyFailedAndReset(r8, 1, "network error", r9);
        Logger.d(OkChannelImpl.TAG, "network not available，cancel retry");
        return;
    L7:
        if (this.isManualClose == false) goto L11;
        Logger.d(OkChannelImpl.TAG, "close manually");
        return;
    L11:
        if (r6 != (-1)) goto L13;
    L16:
        Logger.d(OkChannelImpl.TAG, "retry finished ---> interval: " + r6 + " , url :" + r8);
        Logger.d(OkChannelImpl.TAG, "retry finished，waiting the next time to reconnect");
        Bundle r0 = new Bundle();
        r0.putString("method", "tryReconnect");
        r0.putLong("interval", r6);
        notifyFailedAndReset(r8, 2, "retry failed", r9);
        r8 = this.mPolicy.getUrl();
    L17:
        Logger.d(OkChannelImpl.TAG, "the next time to reconnect is " + Utils.getTimeFormat(System.currentTimeMillis() + r6));
        Message r10 = new Message();
        r10.what = 1;
        r10.obj = r8;
        this.mHandler.sendMessageDelayed(r10, r6);
        return;
    L13:
        if (StringUtils.isEmpty(r8) == true) goto L16;
        setStatus(5);
        goto L17
    }

    void stopConnect() {
        runOnHandlerThread(new AnonymousClass3(this));
    }

    private void stopConnectInternal() {
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(5);
        cancelReconnect();
        disconnect();
    }

    private void cancelReconnect() {
        resetPolicy();
        this.mHandler.removeMessages(1);
    }

    private boolean disconnect() {
        int r0 = getCurrentStatus();
        if (r0 != 3) goto L5;
        return true;
    L5:
        if (r0 != 2) goto L7;
        return true;
    L7:
        if (r0 == 5) goto L23;
        this.mHeartBeatPolicy.onDisconnected();
        CustomHeartBeatRealWebSocket r3 = this.mCurrentSocket;
        if (r3 == null) goto L22;
        Message r4 = this.mHandler.obtainMessage(6, r3);
        this.mHandler.sendMessageDelayed(r4, 1000);
        if (r0 != 4) goto L15;
        this.mCurrentSocket.close(1000, WsStatus.TIP.NORMAL_CLOSE);
        setStatus(6);
        return false;
    L15:
        this.mCurrentSocket.cancel();
        setStatus(3);
        if (r0 == 1) goto L19;
        return true;
    L19:
        return false;
    L22:
        return true;
    L23:
        return true;
    }

    private void initAndConnect(String r5) throws Exception {
        if (this.mOkHttpClient != null) goto L5;
        OkHttpClient.Builder r0 = new OkHttpClient.Builder();
        r0.protocols(Collections.singletonList(Protocol.HTTP_1_1));
        this.mOkHttpClient = enableTls12OnPreLollipop(r0).build();
    L5:
        Map<String, Object> r1 = this.mConfigMap;
        String r6 = createUrl(r5, r1);
        if (r1 == null) goto L8;
        Map r2 = (Map) r1.get(WsConstants.KEY_HEADERS);
    L10:
        if (StringUtils.isEmpty(r6) == false) goto L13;
        Logger.e(OkChannelImpl.TAG, "url is empty,cancel connect");
        return;
    L13:
        ensureWebSocketClosed();
        Logger.d(OkChannelImpl.TAG, "try tu open socket:" + r6);
        Request r3 = this.mRequest;
        if (r3 != null) goto L16;
    L17:
        Request.Builder r4 = new Request.Builder().addHeader("Sec-Websocket-Protocol", "pbbp").addHeader("x-support-ack", "1").url(r6);
        if (r2 == null) goto L23;
        Iterator r7 = r2.entrySet().iterator();
    L21:
        if (r7.hasNext() == false) goto L23;
        Map.Entry r8 = (Map.Entry) r7.next();
        r4.addHeader((String) r8.getKey(), (String) r8.getValue());
    L23:
        this.mRequest = r4.build();
    L24:
        setStatus(1);
        CustomHeartBeatRealWebSocket r9 = CustomHeartBeatRealWebSocket.create(this.mRequest, WsChannelSettings.inst(this.mContext).getSocketReadLimitSize(), this.mListener);
        this.mCurrentSocket = r9;
        r9.connect(this.mOkHttpClient);
        this.mCompensateHeartBeatManager.setWebSocket(this.mCurrentSocket);
        WsStatusListener r10 = this.mWsStatusListener;
        if (r10 == null) goto L29;
        r10.onConnecting(r6);
        return;
    L29:
        return;
    L16:
        if (r6.equals(r3.url().toString()) == true) goto L24;
    L8:
        r2 = null;
        goto L10
    }

    private void resetPolicy() {
        WsPolicy r0 = this.mPolicy;
        if (r0 == null) goto L6;
        r0.reset();
        return;
    }

    private String doUrlDispatch(String r2) throws Exception {
        if (URLDispatcher.inst().isDispatchActionsEmpty() == true) goto L19;
        URLRequest r1 = new URLRequest(r2, HttpMethodContrants.GET);
        DispatchResult r3 = URLDispatcher.inst().getDispatchResultForUrl(r1);
        if (r3 != null) goto L7;
    L24:
        return r2;
    L7:
        if (r2.equals(r3.mDispatchedURL) == true) goto L24;
        if (r3.mDispatchedURL.isEmpty() == false) goto L16;
        if (r3.mActionRuleIdList.isEmpty() == true) goto L16;
        throw new Exception(WsConstants.TTNET_TRAFFIC_CONTROL_DROP);
    L16:
        if (UrlUtils.isValidUrl(r3.mDispatchedURL) == false) goto L24;
        return r3.mDispatchedURL;
    L19:
        Logger.d(OkChannelImpl.TAG, "fallback to host replace map");
        String r4 = URLDispatcher.inst().handleHostMapping(r2);
        if (r2.equals(r4) == true) goto L24;
        if (UrlUtils.isValidUrl(r4) == false) goto L24;
        return r4;
    }

    private String createUrl(String r9, Map<String, Object> r10) throws Exception {
        if (TextUtils.isEmpty(r9) == true) goto L44;
        if (r10 == null) goto L44;
        String r0 = Utils.md5(String.valueOf(r10.get(WsConstants.KEY_FPID)) + String.valueOf(r10.get(WsConstants.KEY_APP_KEY)) + String.valueOf(r10.get("device_id")) + WsConstants.SALT).toLowerCase();
        Uri.Builder r11 = Uri.parse(r9).buildUpon();
        Iterator<Map.Entry<String, Object>> r3 = r10.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L29;
        Map.Entry<String, Object> r4 = r3.next();
        if (r4 == null) goto L8;
        if (TextUtils.isEmpty(r4.getKey()) == true) goto L8;
        if (TextUtils.equals(r4.getKey(), WsConstants.KEY_HEADERS) == true) goto L8;
        if (r4.getValue() != null) goto L20;
        String r6 = "";
    L21:
        String r5 = r4.getKey();
        if (StringUtils.equal(WsConstants.KEY_APP_KEY, r5) == true) goto L8;
        if (StringUtils.equal(r5, "extra") == true) goto L8;
        if (StringUtils.equal("app_version", r5) == true) goto L27;
        r11.appendQueryParameter(r5, r6);
        goto L8
    L27:
        r11.appendQueryParameter("version_code", r6);
        goto L8
    L20:
        r6 = r4.getValue().toString();
        goto L21
    L29:
        String r12 = (String) r10.get("extra");
        if (StringUtils.isEmpty(r12) == true) goto L39;
        String[] r13 = r12.split("&");
        int r1 = r13.length;
        int r7 = 0;
    L32:
        if (r7 >= r1) goto L39;
        String r8 = r13[r7];
        if (TextUtils.isEmpty(r8) == true) goto L38;
        String[] r14 = r8.split("=");
        if (r14.length != 2) goto L38;
        r11.appendQueryParameter(r14[0], Uri.decode(r14[1]));
    L38:
        r7 = r7 + 1;
    L39:
        r11.appendQueryParameter("access_key", r0);
        r11.appendQueryParameter("ne", String.valueOf(networkType()));
        String r15 = r11.build().toString();
        Logger.d(OkChannelImpl.TAG, "origin url: " + r15);
        String r16 = doUrlDispatch(r15);     // Catch: Exception -> L42
        Logger.d(OkChannelImpl.TAG, "Dispatch final url: " + r16);     // Catch: Exception -> L42
        return r16;
    L42:
        e = move-exception;
        throw e;
    L44:
        return "";
    }

    private int networkType() {
        NetworkUtils.NetworkType r2 = NetworkUtils.getNetworkType(this.mContext);
        if (r2 != null) goto L6;
        return 0;
    L6:
        if (r2 != NetworkUtils.NetworkType.NONE) goto L9;
        return 0;
    L9:
        if (r2 != NetworkUtils.NetworkType.WIFI) goto L13;
        return 1;
    L13:
        if (r2 != NetworkUtils.NetworkType.MOBILE_2G) goto L17;
        return 2;
    L17:
        if (r2 != NetworkUtils.NetworkType.MOBILE_3G) goto L20;
        return 3;
    L20:
        return 4;
    }

    synchronized int getCurrentStatus() {
        monitor-enter(this);
        int r0 = this.mCurrentStatus;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    boolean isConnected() {
        if (getCurrentStatus() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    private synchronized void setStatus(int r4) {
        monitor-enter(this);
        this.mCurrentStatus = r4;     // Catch: Throwable -> L25
        String r1 = "";
        if (r4 != 1) goto L8;
        r1 = "connecting";
    L22:
        Logger.d(OkChannelImpl.TAG, "current status is :".concat(r1));     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L8:
        if (r4 != 2) goto L11;
        r1 = "connect failed";
        goto L22
    L11:
        if (r4 != 3) goto L14;
        r1 = "connection close ";
        goto L22
    L14:
        if (r4 != 4) goto L17;
        r1 = "connected";
        goto L22
    L17:
        if (r4 != 5) goto L20;
        r1 = "retry...";
        goto L22
    L20:
        if (r4 != 6) goto L22;
        r1 = "half-close status";
    L25:
        th = move-exception;
        throw th;
    }

    void setConfigMap(Map<String, Object> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.remove(WsConstants.KEY_CHANNEL_ID);
        this.mConfigMap.putAll(r2);
    }

    private boolean isNetworkConnected(Context r1) {
        return NetworkUtils.isNetworkAvailable(r1);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        int r0 = r6.what;
        if (r0 != 1) goto L11;
        if (isConnected() == false) goto L9;
        return;
    L9:
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        tryConnect((String) r6.obj);
        return;
    L11:
        if (r0 != 2) goto L17;
        this.mHandler.removeMessages(2);     // Catch: Throwable -> L14
        this.mHandler.removeMessages(1);     // Catch: Throwable -> L14
        Config.access$802(this.mConfig, (List) r6.obj);     // Catch: Throwable -> L14
        this.isManualClose = false;     // Catch: Throwable -> L14
        this.mPolicy = new WsPolicy(Config.access$800(this.mConfig), Config.access$900(this.mConfig));     // Catch: Throwable -> L14
        cancelReconnect();     // Catch: Throwable -> L14
        tryConnect(this.mPolicy.getUrl());     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L17:
        if (r0 != 3) goto L32;
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(1);
        if (isConnected() == false) goto L21;
        return;
    L21:
        cancelReconnect();
        if (isNetworkConnected(this.mContext) == true) goto L24;
        Logger.d(OkChannelImpl.TAG, "network changed! but the network is not available，do not retry");
        return;
    L24:
        if (disconnect() == false) goto L29;
        WsPolicy r7 = this.mPolicy;
        if (r7 != null) goto L28;
        return;
    L28:
        tryConnect(r7.getUrl());
        return;
    L29:
        this.mPendingConnectAfterClosed = true;
        return;
    L32:
        if (r0 != 5) goto L39;
        if (((Boolean) r6.obj).booleanValue() == false) goto L36;
        AppState r8 = AppState.STATE_FOREGROUND;
    L37:
        this.mCompensateHeartBeatManager.updateCurrentAppState(r8);
        this.mHeartBeatPolicy.onAppStateUpdate(r8);
        return;
    L36:
        r8 = AppState.STATE_BACKGROUND;
        goto L37
    L39:
        if (r0 != 7) goto L60;
        this.mHandler.removeMessages(2);     // Catch: Throwable -> L45
        this.mHandler.removeMessages(1);     // Catch: Throwable -> L45
        Config.access$802(this.mConfig, (List) r6.obj);     // Catch: Throwable -> L45
        this.isManualClose = false;     // Catch: Throwable -> L45
        this.mPolicy = new WsPolicy(Config.access$800(this.mConfig), Config.access$900(this.mConfig));     // Catch: Throwable -> L45
        cancelReconnect();     // Catch: Throwable -> L45
        if (disconnect() == false) goto L43;
        tryConnect(this.mPolicy.getUrl());     // Catch: Throwable -> L45
    L50:
        return;
    L43:
        this.mPendingConnectAfterClosed = true;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private void ensureWebSocketClosed() {
        CustomHeartBeatRealWebSocket r2 = this.mCurrentSocket;
        if (r2 == null) goto L6;
        r2.closeQuietly(1000, WsStatus.TIP.NORMAL_CLOSE);
        return;
    }

    void connect(final Map<String, Object> r2, final List<String> r3) {
        if (r3.isEmpty() == false) goto L6;
        Logger.e(OkChannelImpl.TAG, "error : no target ws url ,return");
        return;
    L6:
        runOnHandlerThread(new AnonymousClass4(this, r2, r3));
    }

    void onNetworkStateChanged(int r2) {
        this.mHandler.obtainMessage(3, Integer.valueOf(r2)).sendToTarget();
    }

    public boolean sendMessage(String r1) {
        return send(r1);
    }

    private boolean sendMessage(ByteString r1) {
        return send(r1);
    }

    private boolean send(Object r3) {
        Logger.d(OkChannelImpl.TAG, "send msg : " + r3);
        if (this.mCurrentSocket != null) goto L5;
    L12:
        return false;
    L5:
        if (isConnected() == false) goto L12;
        if ((r3 instanceof String) == false) goto L10;
        return this.mCurrentSocket.send((String) r3);
    L10:
        if ((r3 instanceof ByteString) == false) goto L12;
        return this.mCurrentSocket.send((ByteString) r3);
    }

    boolean sendMessage(byte[] r1) {
        return sendMessage(ByteString.of(r1));
    }

    void setWsStatusListener(WsStatusListener r1) {
        this.mWsStatusListener = r1;
    }

    private String safeGetUrl(WebSocket r1) {
        if (r1 == null) goto L9;
        Request r0 = r1.request();
        if (r0 == null) goto L11;
        HttpUrl r2 = r0.url();
        if (r2 != null) goto L8;
        return "";
    L8:
        return r2.toString();
    L11:
        return "";
    L9:
        return "";
    }

    void destroy() {
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(5);
        runOnHandlerThread(new AnonymousClass5(this));
    }

    void onAppStateChanged(boolean r2) {
        this.mHandler.obtainMessage(5, Boolean.valueOf(r2)).sendToTarget();
    }

    private int getErrorCode(Response r1) {
        if (r1 != null) goto L9;
        return -1;
    L9:
        return Integer.parseInt(r1.header("Handshake-Status"));
    L11:
        return -1;
    }

    private void safeClose(Closeable r1) {
        if (r1 == null) goto L8;
        r1.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    private void notifyFailedAndReset(String r2, int r3, String r4, boolean r5) {
        setStatus(2);
        resetPolicy();
        WsStatusListener r1 = this.mWsStatusListener;
        if (r1 == null) goto L7;
        if (r5 == false) goto L8;
        r1.onFailure(r2, r3, r4);
        return;
    L8:
        return;
    }

    private void reactOnHeartBeatTimeout() {
        Request r0 = this.mRequest;
        if (r0 == null) goto L7;
        WsStatusListener r1 = this.mWsStatusListener;
        if (r1 == null) goto L7;
        r1.onFailure(r0.url().toString(), 3, "heatbeat timeout");
    L7:
        Pair<String, Long> r2 = this.mPolicy.getRetryUrlAndInterval(null);
        stopConnectInternal();
        ensureWebSocketClosed();
        tryReconnect(0, (String) r2.first, true);
    }

    private void reactOnSendPing() {
        this.mHandler.post(new AnonymousClass6(this));
    }

    void onParameterChange(final Map<String, Object> r2, final List<String> r3) {
        if (r3.isEmpty() == false) goto L6;
        Logger.e(OkChannelImpl.TAG, "error : no target ws url ,return");
        return;
    L6:
        runOnHandlerThread(new AnonymousClass7(this, r2, r3));
    }

    private static OkHttpClient.Builder enableTls12WithTwoParamsMethod(OkHttpClient.Builder r3, SSLContext r4) throws Exception {
        TrustManagerFactory r0 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        KeyStore r2 = (KeyStore) null;
        r0.init(null);
        TrustManager[] r1 = r0.getTrustManagers();
        if (r1.length != 1) goto L9;
        TrustManager r5 = r1[0];
        if ((r5 instanceof X509TrustManager) == false) goto L9;
        r3.sslSocketFactory(new Tls12SocketFactory(r4.getSocketFactory()), (X509TrustManager) r5);
        return r3;
    L9:
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(r1));
    }

    private void runOnHandlerThread(Runnable r1) {
        this.mHandler.post(r1);
    }

    private void sendMessageAckIfNeeded(byte[] r9) throws IOException {
        Logger.d(OkChannelImpl.TAG, "enter sendMessageAckIfNeeded");
        Frame r10 = Frame.ADAPTER.decode(r9);
        List r0 = (List) Wire.get(r10.headers, Collections.emptyList());
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L41;
        Iterator r1 = r0.iterator();
        boolean r2 = false;
        String r3 = null;
    L9:
        if (r1.hasNext() == false) goto L23;
        Frame.ExtendedEntry r4 = (Frame.ExtendedEntry) r1.next();
        if (r4.key.equals(WsConstants.KEY_NEED_ACK) == false) goto L16;
        if (r4.value.equals("1") == false) goto L16;
        r2 = true;
    L16:
        if (r4.key.equals(WsConstants.KEY_FRONTIER_MSGID) == true) goto L18;
    L20:
        if (r2 == false) goto L9;
        if (TextUtils.isEmpty(r3) == true) goto L9;
    L18:
        if (TextUtils.isEmpty(r4.value) == true) goto L20;
        r3 = r4.value;
    L23:
        if (r2 == true) goto L25;
        return;
    L25:
        ArrayList r5 = new ArrayList();
        r5.add(new Frame.ExtendedEntry.Builder().key(WsConstants.KEY_IS_ACK).value("1").build());
        r5.add(new Frame.ExtendedEntry.Builder().key(WsConstants.KEY_ACK_ID).value((String) Wire.get(r10.logidnew, "")).build());
        r5.add(new Frame.ExtendedEntry.Builder().key(WsConstants.KEY_ACK_CODE).value("0").build());
        if (TextUtils.isEmpty(r3) == true) goto L28;
        r5.add(new Frame.ExtendedEntry.Builder().key(WsConstants.KEY_FRONTIER_MSGID).value(r3).build());
    L28:
        Frame.Builder r11 = new Frame.Builder().seqid((Long) Wire.get(r10.seqid, Frame.DEFAULT_SEQID)).logid((Long) Wire.get(r10.logid, Frame.DEFAULT_LOGID)).service((Integer) Wire.get(r10.service, Frame.DEFAULT_SERVICE)).method((Integer) Wire.get(r10.method, Frame.DEFAULT_METHOD)).logidnew((String) Wire.get(r10.logidnew, "")).headers(r5);
        sendMessage(Frame.ADAPTER.encode(r11.build()));
        return;
    }
}
