package com.bytedance.common.wschannel.converter;

import android.text.TextUtils;
import com.bytedance.common.wschannel.model.Frame;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
class WireConverter implements MsgConverter {
    WireConverter() {
    }

    @Override // com.bytedance.common.wschannel.converter.MsgConverter
    public WsChannelMsg decode(byte[] r13) throws IOException {
        Frame r12 = Frame.ADAPTER.decode(r13);
        long r0 = ((Long) Wire.get(r12.seqid, Frame.DEFAULT_SEQID)).longValue();
        long r2 = ((Long) Wire.get(r12.logid, Frame.DEFAULT_LOGID)).longValue();
        int r14 = ((Integer) Wire.get(r12.service, Frame.DEFAULT_SERVICE)).intValue();
        int r4 = ((Integer) Wire.get(r12.method, Frame.DEFAULT_METHOD)).intValue();
        List r5 = (List) Wire.get(r12.headers, Collections.emptyList());
        String r6 = (String) Wire.get(r12.payload_encoding, "");
        String r8 = (String) Wire.get(r12.payload_type, "");
        byte[] r9 = ((ByteString) Wire.get(r12.payload, Frame.DEFAULT_PAYLOAD)).toByteArray();
        String r10 = (String) Wire.get(r12.serverTiming, "");
        String r15 = (String) Wire.get(r12.msgId, "");
        WsChannelMsg r11 = new WsChannelMsg();
        r11.setLogId(r2);
        r11.setSeqId(r0);
        r11.setService(r14);
        r11.setMethod(r4);
        if (r5 != null) goto L5;
    L11:
        r11.setPayloadEncoding(r6);
        r11.setPayloadType(r8);
        r11.setPayload(r9);
        String r16 = appendServerTiming(r10);
        if (TextUtils.isEmpty(r16) == true) goto L14;
        r10 = r16;
    L14:
        r11.setServerTiming(r10);
        r11.setMsgId(r15);
        return r11;
    L5:
        if (r5.size() < 0) goto L11;
        ArrayList r17 = new ArrayList();
        Iterator r1 = r5.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        Frame.ExtendedEntry r3 = (Frame.ExtendedEntry) r1.next();
        WsChannelMsg.MsgHeader r7 = new WsChannelMsg.MsgHeader();
        r7.setKey((String) Wire.get(r3.key, ""));
        r7.setValue((String) Wire.get(r3.value, ""));
        r17.add(r7);
        goto L8
    L10:
        r11.setMsgHeaders(r17);
        goto L11
    }

    private static String appendServerTiming(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return null;
    L5:
        StringBuilder r0 = new StringBuilder(r4);
        int r5 = r0.indexOf("ttnet;");
        if (r5 >= 0) goto L8;
        return null;
    L8:
        r0.insert(r5 + 6, "recv_time=" + System.currentTimeMillis() + ";");
        return r0.toString();
    }

    @Override // com.bytedance.common.wschannel.converter.MsgConverter
    public byte[] encode(WsChannelMsg r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.getPayload() == null) goto L8;
        ByteString r4 = ByteString.of(r5.getPayload());
    L9:
        Frame.Builder r6 = new Frame.Builder().logid(Long.valueOf(r5.getLogId())).seqid(Long.valueOf(r5.getSeqId())).service(Integer.valueOf(r5.getService())).payload_encoding(r5.getPayloadEncoding()).payload_type(r5.getPayloadType()).payload(r4).method(Integer.valueOf(r5.getMethod()));
        List<WsChannelMsg.MsgHeader> r7 = r5.getMsgHeaders();
        ArrayList r0 = new ArrayList();
        if (r7 == null) goto L16;
        Iterator<WsChannelMsg.MsgHeader> r8 = r7.iterator();
    L13:
        if (r8.hasNext() == false) goto L16;
        WsChannelMsg.MsgHeader r1 = r8.next();
        r0.add(new Frame.ExtendedEntry.Builder().key(r1.getKey()).value(r1.getValue()).build());
    L16:
        if (r0.isEmpty() == true) goto L19;
        r6.headers(r0);
    L19:
        return Frame.ADAPTER.encode(r6.build());
    L8:
        r4 = ByteString.EMPTY;
        goto L9
    }
}
