package org.chromium.wschannel;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.ttnet.org.chromium.net.c;
import com.ttnet.org.chromium.net.w;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.CronetClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class MySelfChannelImpl implements IWsChannelClient, WeakHandler.IHandler {
    private static final String CLIENT_KEY_MANAGER_CLASS = "com.bytedance.ttnet.clientkey.ClientKeyManager";
    private static final String TAG = "MySelfChannelImpl";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static String WSCHANNEL_ACTION_BACK;
    private static String WSCHANNEL_ACTION_FORE;
    private static c mCronetEngine;
    private static volatile int sChannelID;
    private static volatile AtomicInteger sFirstConnection;
    private static String sPackageName;
    private a mCallback;
    private Context mContext;
    private w mWebsocketConnection;
    private IWsChannelClient mWsChannelClient;
    private boolean sharedConnection;

    public class a extends w.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MySelfChannelImpl f23046a;

        public a(MySelfChannelImpl r10) {
            this.f23046a = r10;
        }

        @Override // com.ttnet.org.chromium.net.w.b
        public void a(w r10, int r11, String r12, String r13) {
            JSONObject r14 = new JSONObject();     // Catch: Throwable -> L4
            r14.put("type", 0);     // Catch: Throwable -> L4
            r14.put(WsConstants.KEY_CONNECTION_STATE, MySelfChannelImpl.access$000(this.f23046a, r11));     // Catch: Throwable -> L4
            r14.put("url", r12);     // Catch: Throwable -> L4
            r14.put("error", r13);     // Catch: Throwable -> L4
            this.f23046a.onConnection(r14);     // Catch: Throwable -> L4
            return;
        }

        @Override // com.ttnet.org.chromium.net.w.b
        public void b(w r10, int r11, String r12) {
            JSONObject r13 = new JSONObject();     // Catch: Throwable -> L4
            r13.put("type", 1);     // Catch: Throwable -> L4
            r13.put(WsConstants.KEY_CONNECTION_STATE, MySelfChannelImpl.access$000(this.f23046a, r11));     // Catch: Throwable -> L4
            r13.put("url", r12);     // Catch: Throwable -> L4
            this.f23046a.onConnection(r13);     // Catch: Throwable -> L4
            return;
        }

        @Override // com.ttnet.org.chromium.net.w.b
        public void d(w r10, ByteBuffer r11, int r12) {
            byte[] r13 = new byte[r11.capacity()];
            r11.get(r13);     // Catch: Throwable -> L5
            this.f23046a.onMessage(r13);     // Catch: Throwable -> L5
            return;
        }

        @Override // com.ttnet.org.chromium.net.w.b
        public void e(w r10, String r11, long r12, long r13, boolean r14) {
            hg.a.a().c(r11, r12, r13, r14);     // Catch: Throwable -> L4
            return;
        }
    }

    static {
        sFirstConnection = new AtomicInteger(0);
        sChannelID = -1;
    }

    public MySelfChannelImpl() {
        this.mCallback = new a(this);
        this.sharedConnection = true;
    }

    public static /* synthetic */ int access$000(MySelfChannelImpl r10, int r11) {
        return r10.cronetToWsStateAdapter(r11);
    }

    private int cronetToWsStateAdapter(int r10) {
        if (r10 != (-1)) goto L5;
        return 0;
    L5:
        if (r10 == 0) goto L13;
        if (r10 != 1) goto L14;
        return 6;
    L14:
        return r10;
    L13:
        return 1;
    }

    private Map<String, String> getClientKeyHeaders() {
        ClientKeyManager r10 = ClientKeyManager.f8142g;     // Catch: Throwable -> L5
        return (Map) ClientKeyManager.class.getMethod("getClientKeyHeaders", null).invoke(null, null);
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static void loadCronetKernel() throws Exception {
        String r10 = TTNetInit.DOMAIN_HTTPDNS_KEY;
        Object r11 = TTNetInit.class.newInstance();
        Reflect.on(r11).call("getInitCompletedLatch");
        Reflect.on(r11).call("preInitCronetKernel");
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void destroy() {
        w r10 = this.mWebsocketConnection;
        if (r10 == null) goto L6;
        r10.f();
        this.mWebsocketConnection.c();
        return;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
        Logger.d(TAG, "handleMsg data:" + r10.toString());
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void init(Context r10, IWsChannelClient r11) {
        Logger.d(TAG, "MySelfChannelImpl init");
        if (sFirstConnection.incrementAndGet() <= 1) goto L5;
        this.sharedConnection = false;
    L5:
        this.mContext = r10;
        sPackageName = r10.getPackageName();
        this.mWsChannelClient = r11;
        loadCronetKernel();     // Catch: Throwable -> L8
    L10:
        mCronetEngine = CronetClient.getCronetEngine();
        WSCHANNEL_ACTION_BACK = this.mContext.getPackageName() + ".wschannel.APP_BACKGROUND";
        WSCHANNEL_ACTION_FORE = this.mContext.getPackageName() + ".wschannel.APP_FOREGROUND";
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
        Logger.d(TAG, "TTNet init failed, cronet engine is null.");
        goto L10
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean isConnected() {
        w r10 = this.mWebsocketConnection;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.d();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onAppStateChanged(int r10) {
        Intent r11 = new Intent();
        if (r10 != 1) goto L9;
        r11.setAction(WSCHANNEL_ACTION_FORE);
        if (TextUtils.isEmpty(sPackageName) == true) goto L7;
        r11.setPackage(sPackageName);
    L7:
        this.mContext.sendBroadcast(r11);
        return;
    L9:
        if (r10 != 2) goto L16;
        r11.setAction(WSCHANNEL_ACTION_BACK);
        if (TextUtils.isEmpty(sPackageName) == true) goto L13;
        r11.setPackage(sPackageName);
    L13:
        this.mContext.sendBroadcast(r11);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onConnection(JSONObject r10) {
        if (this.mWsChannelClient == null) goto L12;
        r10.put(WsConstants.KEY_CHANNEL_TYPE, 1);     // Catch: JSONException -> L6
    L8:
        this.mWsChannelClient.onConnection(r10);
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(byte[] r10) {
        IWsChannelClient r11 = this.mWsChannelClient;
        if (r11 == null) goto L6;
        r11.onMessage(r10);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onNetworkStateChanged(int r10) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onParameterChange(Map<String, Object> r10, List<String> r11) {
        w r12 = this.mWebsocketConnection;
        if (r12 == null) goto L5;
        r12.f();
        this.mWebsocketConnection.c();
    L5:
        openConnection(r10, r11);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void openConnection(Map<String, Object> r11, List<String> r12) {
        if (r12 == null) goto L66;
        if (r12.size() <= 0) goto L66;
        Logger.d(TAG, "openConnection url:" + r12.get(0));
        if (r11 == null) goto L64;
        if (r11.isEmpty() == true) goto L64;
        Object r10 = r11.get(WsConstants.KEY_CHANNEL_ID);
        if (r10 != null) goto L13;
        int r13 = -1;
    L15:
        if (sChannelID != (-1)) goto L20;
        if (r13 <= 0) goto L20;
        if (sFirstConnection.get() != 1) goto L20;
        sChannelID = r13;
    L20:
        w.a r14 = mCronetEngine.d(this.mCallback, Executors.newSingleThreadExecutor());
        r14.l(r12);     // Catch: Throwable -> L26
        r14.c(String.valueOf(r11.get(WsConstants.KEY_APP_KEY)));     // Catch: Throwable -> L26
        r14.h(((Integer) r11.get(WsConstants.KEY_FPID)).intValue());     // Catch: Throwable -> L26
        r14.d(((Integer) r11.get("app_version")).intValue());     // Catch: Throwable -> L26
        r14.b(((Integer) r11.get("aid")).intValue());     // Catch: Throwable -> L26
        r14.g(Long.parseLong((String) r11.get("device_id")));     // Catch: Throwable -> L26
        r14.i(Long.parseLong((String) r11.get(WsConstants.KEY_INSTALL_ID)));     // Catch: Throwable -> L26
        if (r13 > 0) goto L24;
    L28:
        r14.k(this.sharedConnection);     // Catch: Throwable -> L26
        if (r11.containsKey("sid") == false) goto L31;
        r14.j((String) r11.get("sid"));     // Catch: Throwable -> L26
    L31:
        String r15 = (String) r11.get(WsConstants.KEY_EXTRA);     // Catch: Throwable -> L26
        HashMap r16 = new HashMap();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r15) == true) goto L41;
        String[] r17 = r15.split("&");     // Catch: Throwable -> L26
        int r18 = r17.length;     // Catch: Throwable -> L26
        int r19 = 0;
    L34:
        if (r19 >= r18) goto L41;
        String r20 = r17[r19];     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r20) == true) goto L40;
        String[] r21 = r20.split("=");     // Catch: Throwable -> L26
        if (r21.length != 2) goto L40;
        r16.put(r21[0], r21[1]);     // Catch: Throwable -> L26
    L40:
        r19 = r19 + 1;     // Catch: Throwable -> L26
    L41:
        r14.f(r16);     // Catch: Throwable -> L26
        HashMap r110 = new HashMap();     // Catch: Throwable -> L47
        Map<String, String> r22 = getClientKeyHeaders();     // Catch: Throwable -> L47
        Logger.d(TAG, "Client key: " + r22);     // Catch: Throwable -> L47
        if (r22 != null) goto L45;
    L49:
        Map r111 = (Map) r11.get("custom_headers");     // Catch: Throwable -> L47
        if (r111 == null) goto L55;
        if (r111.isEmpty() == true) goto L55;
        r110.putAll(r111);     // Catch: Throwable -> L47
    L55:
        if (r110.isEmpty() == true) goto L59;
        r14.e(r110);     // Catch: Throwable -> L47
    L59:
        w r112 = r14.a();
        this.mWebsocketConnection = r112;
        r112.e();
        return;
    L45:
        if (r22.isEmpty() == true) goto L49;
        r110.putAll(r22);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
        goto L59
    L24:
        if (r13 != sChannelID) goto L28;
        this.sharedConnection = true;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.printStackTrace();
        throw new IllegalArgumentException("configMap contain err params !!!");
    L13:
        r13 = ((Integer) r10).intValue();
    L64:
        throw new IllegalArgumentException("configMap is empty !!!");
    L66:
        throw new IllegalArgumentException("urls size <= 0 !!!");
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(byte[] r10) {
        Logger.d(TAG, "sendMessage data:" + r10);
        if (this.mWebsocketConnection != null) goto L6;
        return false;
    L6:
        ByteBuffer r11 = ByteBuffer.allocateDirect(r10.length);
        r11.put(r10);
        this.mWebsocketConnection.a(r11);
        return true;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void stopConnection() {
        w r10 = this.mWebsocketConnection;
        if (r10 == null) goto L6;
        r10.f();
        this.mWebsocketConnection.c();
        return;
    }
}
