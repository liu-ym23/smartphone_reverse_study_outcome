package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.SocketState;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class SyncConnectStateParse extends BaseIntentParse {
    public SyncConnectStateParse(ClientMsgParser.ParserListener r1) {
        super(r1);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent r3, ClientServiceTrace r4) {
        Logger.d(AbsWsClientService.TAG, "sync socket state");
        r3.setExtrasClassLoader(SocketState.class.getClassLoader());
        ArrayList r5 = r3.getParcelableArrayListExtra(WsConstants.KEY_CONNECTION);
        if (r5 == null) goto L10;
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L16;
        SocketState r7 = (SocketState) r6.next();
        if (r7 == null) goto L6;
        syncConnectState(r7.getChannelId(), r7.getConnectionState(), r7.isPrivateProtocolEnabled());
        goto L6
    L16:
        return;
    }
}
