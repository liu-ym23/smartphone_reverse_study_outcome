package com.bytedance.common.wschannel.client;

import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes2.dex */
class SendPayloadParse extends BaseIntentParse {
    public SendPayloadParse(ClientMsgParser.ParserListener r1) {
        super(r1);
    }

    @Override // com.bytedance.common.wschannel.client.IntentParse
    public void parse(Intent r3, ClientServiceTrace r4) {
        r3.setExtrasClassLoader(WsChannelMsg.class.getClassLoader());
        String r5 = r3.getStringExtra(WsConstants.KEY_PAYLOAD_MD5);
        boolean r6 = r3.getBooleanExtra(WsConstants.KEY_SEND_RESULT, true);
        if (Logger.debug() == false) goto L5;
        Logger.d(AbsWsClientService.TAG, "get payloadMd5 = " + r5 + " sendResult = " + r6);
    L5:
        this.mListener.onSendResult(r5, r6);
    }
}
