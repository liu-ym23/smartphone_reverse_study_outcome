package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClientMsgParser.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends com.bytedance.common.wschannel.client.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, c> f6937b;

    /* JADX INFO: compiled from: ClientMsgParser.java */
    public interface a {
        void onReceive(WsChannelMsg r1);

        void onReceiveConnectEvent(com.bytedance.common.wschannel.b.b r1, JSONObject r2);

        void onReceiveServiceEvent(ServiceConnectEvent r1);

        void onSendResult(String r1, boolean r2);

        void replySendMsgResult(WsChannelMsg r1, boolean r2);

        void syncState(int r1, com.bytedance.common.wschannel.b.c r2, boolean r3);
    }

    public b(a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        super(r5);
        HashMap r0 = new HashMap();
        r0.put(WsConstants.RECEIVE_CONNECTION_ACTION, new d(r5));
        r0.put(WsConstants.SYNC_CONNECT_STATE, new i(r5));
        r0.put(WsConstants.RECEIVE_PROGRESS_ACTION, new f(r5));
        r0.put(WsConstants.RECEIVE_PAYLOAD_ACTION, new e(r5));
        r0.put(WsConstants.SEND_PAYLOAD_ACTION, new h(r5));
        r0.put(WsConstants.RECEIVE_SERVICE_ACTION, new g(r5));
        this.f6937b = Collections.unmodifiableMap(r0);
    }

    @Override // com.bytedance.common.wschannel.client.c
    public void a(Intent r4, com.bytedance.common.wschannel.model.a r5) {
        c r3 = (c) ZeusTransformUtils.preCheckCast(this.f6937b.get(r4.getAction()), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        if (r3 == null) goto L6;
        r3.a(r4, r5);     // Catch: Throwable -> L8
    L14:
    L11:
        if (Logger.debug() == false) goto L17;
        Logger.d(AbsWsClientService.TAG, "count = " + r4.getIntExtra(WsConstants.MSG_COUNT, -1));
        return;
    L17:
        return;
    L6:
        Logger.e("error action!");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Logger.e(AbsWsClientService.TAG, th.toString());
        goto L11
    }
}
