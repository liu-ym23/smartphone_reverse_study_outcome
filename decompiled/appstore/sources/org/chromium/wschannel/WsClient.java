package org.chromium.wschannel;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient;
import com.bytedance.ttnet.TTNetInit;
import com.ttnet.org.chromium.net.c;
import com.ttnet.org.chromium.net.w;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import org.chromium.CronetClient;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class WsClient implements IWsClient {
    private static final String TAG = "WsClient";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static c mCronetEngine;
    private a mCallback;
    private IMessageReceiveListener mListener;
    private w mWebsocketConnection;

    public class a extends w.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WsClient f23047a;

        public a(WsClient r10) {
            this.f23047a = r10;
        }

        @Override // com.ttnet.org.chromium.net.w.b
        public void a(w r10, int r11, String r12, String r13) {
            JSONObject r14 = new JSONObject();     // Catch: Throwable -> L6
            r14.put("url", r12);     // Catch: Throwable -> L6
            r14.put("error", r13);     // Catch: Throwable -> L6
            if (WsClient.access$000(this.f23047a) == null) goto L9;
            WsClient.access$000(this.f23047a).onConnection(r11, r12, r14);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // com.ttnet.org.chromium.net.w.b
        public void b(w r10, int r11, String r12) {
            JSONObject r13 = new JSONObject();     // Catch: Throwable -> L6
            r13.put(WsConstants.KEY_CONNECTION_STATE, WsClient.access$100(this.f23047a, r11));     // Catch: Throwable -> L6
            r13.put("url", r12);     // Catch: Throwable -> L6
            if (WsClient.access$000(this.f23047a) == null) goto L9;
            WsClient.access$000(this.f23047a).onConnection(r11, r12, r13);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // com.ttnet.org.chromium.net.w.b
        public void c(w r10, String r11) {
            if (WsClient.access$000(this.f23047a) == null) goto L6;
            WsClient.access$000(this.f23047a).onFeedBackLog(r11);
            return;
        }

        @Override // com.ttnet.org.chromium.net.w.b
        public void d(w r10, ByteBuffer r11, int r12) {
            byte[] r13 = new byte[r11.capacity()];
            if (r12 != 1) goto L5;
        L12:
            r11.get(r13);     // Catch: Throwable -> L11
            if (WsClient.access$000(this.f23047a) == null) goto L14;
            WsClient.access$000(this.f23047a).onMessage(r13, r12);     // Catch: Throwable -> L11
            return;
        L14:
            return;
        L15:
            return;
        L5:
            if (r12 == 2) goto L12;
            r12 = 0;
            goto L12
        }

        @Override // com.ttnet.org.chromium.net.w.b
        public void e(w r10, String r11, long r12, long r13, boolean r14) {
            hg.a.a().c(r11, r12, r13, r14);     // Catch: Throwable -> L4
            return;
        }
    }

    public WsClient(IMessageReceiveListener r10) throws NullPointerException {
        this.mCallback = new a(this);
        if (mCronetEngine != null) goto L5;
        mCronetEngine = getCronetEngine();
    L5:
        this.mListener = r10;
    }

    public static /* synthetic */ IMessageReceiveListener access$000(WsClient r10) {
        return r10.mListener;
    }

    public static /* synthetic */ int access$100(WsClient r10, int r11) {
        return r10.cronetToWsStateAdapter(r11);
    }

    private int cronetToWsStateAdapter(int r10) {
        if (r10 != (-1)) goto L5;
        return 0;
    L5:
        if (r10 == 0) goto L13;
        if (r10 != 1) goto L14;
        return 5;
    L14:
        return r10;
    L13:
        return 1;
    }

    private c getCronetEngine() {
        Logger.d(TAG, "Init cronet engine");
        loadCronetKernel();     // Catch: Throwable -> L5
    L8:
        return CronetClient.getCronetEngine();
    L5:
        th = move-exception;
        th.printStackTrace();
        Logger.d(TAG, "TTNet init failed, cronet engine is null.");
        goto L8
    }

    private static void loadCronetKernel() throws Exception {
        String r10 = TTNetInit.DOMAIN_HTTPDNS_KEY;
        Object r11 = TTNetInit.class.newInstance();
        Reflect.on(r11).call("getInitCompletedLatch");
        Reflect.on(r11).call("preInitCronetKernel");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public boolean isConnected() {
        w r10 = this.mWebsocketConnection;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.d();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public void onParameterChange(Map<String, String> r10, Map<String, String> r11, List<String> r12, boolean r13, boolean r14) {
        w r15 = this.mWebsocketConnection;
        if (r15 == null) goto L5;
        r15.f();
        this.mWebsocketConnection.c();
    L5:
        openConnection(r10, r11, r12, r13, r14);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public void openConnection(Map<String, String> r10, Map<String, String> r11, List<String> r12, boolean r13, boolean r14) {
        if (r12 == null) goto L17;
        if (r12.size() <= 0) goto L17;
        Logger.d(TAG, "openConnection url:" + r12.get(0));
        w.a r15 = mCronetEngine.d(this.mCallback, Executors.newSingleThreadExecutor());
        r15.l(r12);
        if (r10 != null) goto L8;
    L10:
        if (r11 != null) goto L12;
    L14:
        r15.k(r13);
        r15.m(r14);
        w r16 = r15.a();
        this.mWebsocketConnection = r16;
        r16.e();
        return;
    L12:
        if (r11.isEmpty() == true) goto L14;
        r15.e(r11);
        goto L14
    L8:
        if (r10.isEmpty() == true) goto L10;
        r15.f(r10);
    L17:
        throw new IllegalArgumentException("urls size <= 0 !!!");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public boolean sendMessage(byte[] r10, int r11) throws Exception {
        Logger.d(TAG, "sendMessage data:" + r10);
        if (this.mWebsocketConnection != null) goto L7;
        return false;
    L7:
        if (r11 != 2) goto L9;
        ByteBuffer r12 = ByteBuffer.allocateDirect(r10.length);
        r12.put(r10);
        this.mWebsocketConnection.a(r12);
    L11:
        return true;
    L9:
        if (r11 != 1) goto L13;
        this.mWebsocketConnection.b(new String(r10, "UTF-8"));
        goto L11
    L13:
        throw new IllegalArgumentException("Unsupported message type: " + r11);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public void stopConnection() {
        w r10 = this.mWebsocketConnection;
        if (r10 == null) goto L6;
        r10.f();
        this.mWebsocketConnection.c();
        return;
    }
}
