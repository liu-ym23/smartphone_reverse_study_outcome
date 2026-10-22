package org.chromium.wschannel;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient;
import com.ttnet.org.chromium.net.ae;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import org.chromium.CronetClient;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class WsClient implements IWsClient {
    private static final String TAG = "WsClient";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static com.ttnet.org.chromium.net.d mCronetEngine;
    private a mCallback;
    private IMessageReceiveListener mListener;
    private ae mWebsocketConnection;

    class a extends ae.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WsClient f40544a;

        a(WsClient r1) {
            this.f40544a = r1;
        }

        @Override // com.ttnet.org.chromium.net.ae.b
        public void a(ae r2, ByteBuffer r3, int r4) {
            byte[] r5 = new byte[r3.capacity()];
            if (r4 != 1) goto L5;
        L12:
            r3.get(r5);     // Catch: Throwable -> L11
            if (WsClient.access$000(this.f40544a) == null) goto L14;
            WsClient.access$000(this.f40544a).onMessage(r5, r4);     // Catch: Throwable -> L11
            return;
        L14:
            return;
        L15:
            return;
        L5:
            if (r4 == 2) goto L12;
            r4 = 0;
            goto L12
        }

        @Override // com.ttnet.org.chromium.net.ae.b
        public void a(ae r3, int r4, String r5) {
            JSONObject r6 = new JSONObject();     // Catch: Throwable -> L6
            r6.put("state", WsClient.access$100(this.f40544a, r4));     // Catch: Throwable -> L6
            r6.put("url", r5);     // Catch: Throwable -> L6
            if (WsClient.access$000(this.f40544a) == null) goto L9;
            WsClient.access$000(this.f40544a).onConnection(r4, r5, r6);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // com.ttnet.org.chromium.net.ae.b
        public void a(ae r2, int r3, String r4, String r5) {
            JSONObject r6 = new JSONObject();     // Catch: Throwable -> L6
            r6.put("url", r4);     // Catch: Throwable -> L6
            r6.put(WsConstants.KEY_CONNECTION_ERROR, r5);     // Catch: Throwable -> L6
            if (WsClient.access$000(this.f40544a) == null) goto L9;
            WsClient.access$000(this.f40544a).onConnection(r3, r4, r6);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // com.ttnet.org.chromium.net.ae.b
        public void a(ae r1, String r2) {
            if (WsClient.access$000(this.f40544a) == null) goto L6;
            WsClient.access$000(this.f40544a).onFeedBackLog(r2);
            return;
        }

        @Override // com.ttnet.org.chromium.net.ae.b
        public void a(ae r8, String r9, long r10, long r12, boolean r14) {
            d.a().a(r9, r10, r12, r14);     // Catch: Throwable -> L4
            return;
        }
    }

    private int cronetToWsStateAdapter(int r2) {
        if (r2 == (-1)) goto L9;
        if (r2 == 0) goto L12;
        if (r2 != 1) goto L13;
        return 5;
    L13:
        return r2;
    L12:
        return 1;
    L9:
        return 0;
    }

    static /* synthetic */ IMessageReceiveListener access$000(WsClient r0) {
        return r0.mListener;
    }

    static /* synthetic */ int access$100(WsClient r0, int r1) {
        return r0.cronetToWsStateAdapter(r1);
    }

    public WsClient(IMessageReceiveListener r3) {
        IMessageReceiveListener r4 = (IMessageReceiveListener) ZeusTransformUtils.wrapperContextForParams(r3, IMessageReceiveListener.class, "com.obric.aiagent.plugin");
        this.mCallback = new a(this);
        if (mCronetEngine != null) goto L5;
        mCronetEngine = getCronetEngine();
    L5:
        this.mListener = r4;
    }

    private com.ttnet.org.chromium.net.d getCronetEngine() {
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "Init cronet engine");
    L13:
        loadCronetKernel();     // Catch: Throwable -> L7
    L12:
        return CronetClient.getCronetEngine();
    L7:
        th = move-exception;
        th.printStackTrace();
        if (Logger.debug() == false) goto L12;
        Logger.d(TAG, "TTNet init failed, cronet engine is null.");
        goto L12
    }

    private static void loadCronetKernel() {
        Object r0 = ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.aiagent.plugin").newInstance();
        Reflect.on(r0).call("getInitCompletedLatch");
        Reflect.on(r0).call("preInitCronetKernel");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public boolean isConnected() {
        ae r0 = this.mWebsocketConnection;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.c();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public void openConnection(Map<String, String> r5, Map<String, String> r6, List<String> r7, boolean r8, boolean r9) {
        Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        Map<String, String> r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L21;
        if (r12.size() <= 0) goto L21;
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "openConnection url:" + ((String) ZeusTransformUtils.preCheckCast(r12.get(0), String.class, "com.obric.aiagent.plugin")));
    L9:
        ae.a r0 = mCronetEngine.a(this.mCallback, Executors.newSingleThreadExecutor());
        r0.a(r12);
        if (r10 != null) goto L12;
    L14:
        if (r11 != null) goto L16;
    L18:
        r0.a(r8);
        r0.b(r9);
        ae r13 = r0.a();
        this.mWebsocketConnection = r13;
        r13.a();
        return;
    L16:
        if (r11.isEmpty() == true) goto L18;
        r0.b(r11);
        goto L18
    L12:
        if (r10.isEmpty() == true) goto L14;
        r0.a(r10);
    L21:
        throw new IllegalArgumentException("urls size <= 0 !!!");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public void stopConnection() {
        ae r0 = this.mWebsocketConnection;
        if (r0 == null) goto L6;
        r0.b();
        this.mWebsocketConnection.d();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public void onParameterChange(Map<String, String> r9, Map<String, String> r10, List<String> r11, boolean r12, boolean r13) {
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        ae r14 = this.mWebsocketConnection;
        if (r14 == null) goto L5;
        r14.b();
        this.mWebsocketConnection.d();
    L5:
        openConnection(r3, r4, r5, r12, r13);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient
    public boolean sendMessage(byte[] r3, int r4) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "sendMessage data:" + r3);
    L6:
        if (this.mWebsocketConnection != null) goto L10;
        return false;
    L10:
        if (r4 != 2) goto L12;
        ByteBuffer r5 = ByteBuffer.allocateDirect(r3.length);
        r5.put(r3);
        this.mWebsocketConnection.a(r5);
    L14:
        return true;
    L12:
        if (r4 != 1) goto L16;
        this.mWebsocketConnection.a(new String(r3, "UTF-8"));
        goto L14
    L16:
        throw new IllegalArgumentException("Unsupported message type: " + r4);
    }
}
