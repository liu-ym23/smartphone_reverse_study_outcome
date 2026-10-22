package org.chromium.wschannel;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.ttnet.org.chromium.net.impl.CronetFrontierClient;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: PrivateProtocolCallbackImpl.java */
/* JADX INFO: loaded from: classes5.dex */
final class c implements CronetFrontierClient.b {
    private static final String TAG = "CronetFrontierConnection";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IWsChannelClient f40559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f40560b;

    private static int b(int r3) {
        if (r3 == 2) goto L10;
        if (r3 == 3) goto L12;
        if (r3 == 4) goto L11;
        return r3;
    L11:
        return 3;
    L12:
        return 2;
    L10:
        return 4;
    }

    public c(IWsChannelClient r3, a r4) {
        this.f40559a = (IWsChannelClient) ZeusTransformUtils.wrapperContextForParams(r3, IWsChannelClient.class, "com.obric.aiagent.plugin");
        this.f40560b = r4;
    }

    private boolean a(int r2) {
        if (r2 == 2) goto L9;
        if (r2 == 3) goto L9;
        if (r2 == 4) goto L9;
        return false;
    L9:
        if (this.f40560b.a() == true) goto L11;
        return false;
    L11:
        if (Logger.debug() == false) goto L17;
        Logger.d(TAG, "Wait fallback task running and ignore state:" + r2);
        return true;
    L17:
        return true;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.b
    public void a(int r4, String r5) {
        int r6 = b(r4);
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "PP onConnectionStateChanged state:" + r6 + " url:" + r5);
    L6:
        if (r6 != 4) goto L9;
        this.f40560b.a(false);
    L9:
        if (a(r6) == false) goto L14;
        return;
    L14:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L13
        r0.put("type", 1);     // Catch: Throwable -> L13
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 1);     // Catch: Throwable -> L13
        r0.put("state", r6);     // Catch: Throwable -> L13
        r0.put("url", r5);     // Catch: Throwable -> L13
        this.f40559a.onConnection(r0);     // Catch: Throwable -> L13
        return;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.b
    public void a(int r6, String r7, String r8) {
        int r9 = b(r6);
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "PP onConnectionError state:" + r9 + " url:" + r7 + " error:" + r8);
    L6:
        if (a(r9) == false) goto L16;
        return;
    L16:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L15
        r0.put("type", 0);     // Catch: Throwable -> L15
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 1);     // Catch: Throwable -> L15
        r0.put("state", r9);     // Catch: Throwable -> L15
        r0.put("url", r7);     // Catch: Throwable -> L15
        r0.put(WsConstants.KEY_CONNECTION_ERROR, r8);     // Catch: Throwable -> L15
        if (b.a(r8, false) == false) goto L13;
        r0.put("error_code", -192);     // Catch: Throwable -> L15
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "PP connection timeout.");     // Catch: Throwable -> L15
    L13:
        this.f40559a.onConnection(r0);     // Catch: Throwable -> L15
        return;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetFrontierClient.b
    public void a(String r8, long r9, long r11, boolean r13) {
        d.a().a(r8, r9, r11, r13);     // Catch: Throwable -> L4
        return;
    }
}
