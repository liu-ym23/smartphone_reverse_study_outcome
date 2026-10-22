package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ClientMsgParser extends BaseIntentParse {
    private final Map<String, IntentParse> parseMap;

    public interface ParserListener {
        void onReceive(WsChannelMsg r1);

        void onReceiveConnectEvent(ConnectEvent r1, JSONObject r2);

        void onReceiveServiceEvent(ServiceConnectEvent r1);

        void onSendResult(String r1, boolean r2);

        void replySendMsgResult(WsChannelMsg r1, boolean r2);

        void syncState(int r1, ConnectionState r2, boolean r3);
    }

    public ClientMsgParser(ParserListener r4) {
        super(r4);
        HashMap r0 = new HashMap();
        r0.put(WsConstants.RECEIVE_CONNECTION_ACTION, new ReceiveConnectionActionParse(r4));
        r0.put(WsConstants.SYNC_CONNECT_STATE, new SyncConnectStateParse(r4));
        r0.put(WsConstants.RECEIVE_PROGRESS_ACTION, new ReceiveProgressParse(r4));
        r0.put(WsConstants.RECEIVE_PAYLOAD_ACTION, new ReceivePayloadParse(r4));
        r0.put(WsConstants.SEND_PAYLOAD_ACTION, new SendPayloadParse(r4));
        r0.put(WsConstants.RECEIVE_SERVICE_ACTION, new ReceiveServiceActionParse(r4));
        this.parseMap = Collections.unmodifiableMap(r0);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent r3, ClientServiceTrace r4) {
        IntentParse r2 = this.parseMap.get(r3.getAction());     // Catch: Throwable -> L8
        if (r2 == null) goto L6;
        r2.parse(r3, r4);     // Catch: Throwable -> L8
    L14:
    L11:
        if (Logger.debug() == false) goto L17;
        Logger.d(AbsWsClientService.TAG, "count = " + r3.getIntExtra(WsConstants.MSG_COUNT, -1));
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
