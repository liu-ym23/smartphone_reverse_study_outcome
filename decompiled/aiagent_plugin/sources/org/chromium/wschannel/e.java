package org.chromium.wschannel;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.ttnet.org.chromium.net.ae;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* JADX INFO: compiled from: WebSocketCallbackImpl.java */
/* JADX INFO: loaded from: classes5.dex */
final class e extends ae.b {
    private static final String TAG = "CronetFrontierConnection";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IWsChannelClient f40562a;

    private static int a(int r2) {
        if (r2 == (-1)) goto L9;
        if (r2 == 0) goto L12;
        if (r2 != 1) goto L13;
        return 6;
    L13:
        return r2;
    L12:
        return 1;
    L9:
        return 0;
    }

    public e(IWsChannelClient r3) {
        this.f40562a = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r3, IWsChannelClient.class, "com.obric.aiagent.plugin");
    }

    @Override // com.ttnet.org.chromium.net.ae.b
    public void a(ae r1, ByteBuffer r2, int r3) {
        byte[] r4 = new byte[r2.capacity()];
        r2.get(r4);     // Catch: Throwable -> L5
        this.f40562a.onMessage(r4);     // Catch: Throwable -> L5
        return;
    }

    @Override // com.ttnet.org.chromium.net.ae.b
    public void a(ae r3, int r4, String r5) {
        int r6 = a(r4);
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "WS onConnectionStateChanged state:" + r6 + " url:" + r5);
    L8:
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L7
        r7.put("type", 1);     // Catch: Throwable -> L7
        r7.put("state", r6);     // Catch: Throwable -> L7
        r7.put("url", r5);     // Catch: Throwable -> L7
        this.f40562a.onConnection(r7);     // Catch: Throwable -> L7
        return;
    }

    @Override // com.ttnet.org.chromium.net.ae.b
    public void a(ae r4, int r5, String r6, String r7) {
        int r8 = a(r5);
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "WS onConnectionError state:" + r8 + " url:" + r6 + " error:" + r7);
    L13:
        JSONObject r9 = new JSONObject();     // Catch: Throwable -> L12
        r9.put("type", 0);     // Catch: Throwable -> L12
        r9.put("state", r8);     // Catch: Throwable -> L12
        r9.put("url", r6);     // Catch: Throwable -> L12
        r9.put(WsConstants.KEY_CONNECTION_ERROR, r7);     // Catch: Throwable -> L12
        if (b.a(r7, true) == false) goto L10;
        r9.put("error_code", -192);     // Catch: Throwable -> L12
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "WS connection timeout.");     // Catch: Throwable -> L12
    L10:
        this.f40562a.onConnection(r9);     // Catch: Throwable -> L12
        return;
    }

    @Override // com.ttnet.org.chromium.net.ae.b
    public void a(ae r8, String r9, long r10, long r12, boolean r14) {
        d.a().a(r9, r10, r12, r14);     // Catch: Throwable -> L4
        return;
    }
}
