package com.bytedance.common.wschannel.a;

import android.text.TextUtils;
import com.bytedance.common.wschannel.model.Frame;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.squareup.wire.Wire;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import e.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: WireConverter.java */
/* JADX INFO: loaded from: classes.dex */
class c implements a {
    c() {
    }

    @Override // com.bytedance.common.wschannel.a.a
    public WsChannelMsg a(byte[] r14) {
        Frame r13 = (Frame) ZeusTransformUtils.preCheckCast(Frame.ADAPTER.decode(r14), Frame.class, "com.obric.aiagent.plugin");
        long r1 = ((Long) ZeusTransformUtils.preCheckCast(Wire.get(r13.seqid, Frame.DEFAULT_SEQID), Long.class, "com.obric.aiagent.plugin")).longValue();
        long r3 = ((Long) ZeusTransformUtils.preCheckCast(Wire.get(r13.logid, Frame.DEFAULT_LOGID), Long.class, "com.obric.aiagent.plugin")).longValue();
        int r15 = ((Integer) ZeusTransformUtils.preCheckCast(Wire.get(r13.service, Frame.DEFAULT_SERVICE), Integer.class, "com.obric.aiagent.plugin")).intValue();
        int r5 = ((Integer) ZeusTransformUtils.preCheckCast(Wire.get(r13.method, Frame.DEFAULT_METHOD), Integer.class, "com.obric.aiagent.plugin")).intValue();
        List r6 = (List) ZeusTransformUtils.preCheckCast(Wire.get(r13.headers, Collections.emptyList()), List.class, "com.obric.aiagent.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(Wire.get(r13.payload_encoding, ""), String.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(Wire.get(r13.payload_type, ""), String.class, "com.obric.aiagent.plugin");
        byte[] r10 = ((h) ZeusTransformUtils.preCheckCast(Wire.get(r13.payload, Frame.DEFAULT_PAYLOAD), h.class, "com.obric.aiagent.plugin")).m();
        String r11 = (String) ZeusTransformUtils.preCheckCast(Wire.get(r13.serverTiming, ""), String.class, "com.obric.aiagent.plugin");
        String r16 = (String) ZeusTransformUtils.preCheckCast(Wire.get(r13.msgId, ""), String.class, "com.obric.aiagent.plugin");
        WsChannelMsg r12 = new WsChannelMsg();
        r12.setLogId(r3);
        r12.setSeqId(r1);
        r12.setService(r15);
        r12.setMethod(r5);
        if (r6 != null) goto L5;
    L11:
        r12.setPayloadEncoding(r7);
        r12.setPayloadType(r9);
        r12.setPayload(r10);
        String r17 = a(r11);
        if (TextUtils.isEmpty(r17) == true) goto L14;
        r11 = r17;
    L14:
        r12.setServerTiming(r11);
        r12.setMsgId(r16);
        return r12;
    L5:
        if (r6.size() < 0) goto L11;
        ArrayList r18 = new ArrayList();
        Iterator r2 = r6.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        Frame.b r4 = (Frame.b) ZeusTransformUtils.preCheckCast(r2.next(), Frame.b.class, "com.obric.aiagent.plugin");
        WsChannelMsg.MsgHeader r8 = new WsChannelMsg.MsgHeader();
        r8.setKey((String) ZeusTransformUtils.preCheckCast(Wire.get(r4.f6989b, ""), String.class, "com.obric.aiagent.plugin"));
        r8.setValue((String) ZeusTransformUtils.preCheckCast(Wire.get(r4.f6990c, ""), String.class, "com.obric.aiagent.plugin"));
        r18.add(r8);
        goto L8
    L10:
        r12.setMsgHeaders(r18);
        goto L11
    }

    private static String a(String r4) {
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

    @Override // com.bytedance.common.wschannel.a.a
    public byte[] a(WsChannelMsg r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.getPayload() == null) goto L8;
        h r4 = h.a(r5.getPayload());
    L9:
        Frame.a r6 = new Frame.a().b(Long.valueOf(r5.getLogId())).a(Long.valueOf(r5.getSeqId())).a(Integer.valueOf(r5.getService())).a(r5.getPayloadEncoding()).b(r5.getPayloadType()).a(r4).b(Integer.valueOf(r5.getMethod()));
        List<WsChannelMsg.MsgHeader> r7 = r5.getMsgHeaders();
        ArrayList r0 = new ArrayList();
        if (r7 == null) goto L16;
        Iterator<WsChannelMsg.MsgHeader> r8 = r7.iterator();
    L13:
        if (r8.hasNext() == false) goto L16;
        WsChannelMsg.MsgHeader r1 = (WsChannelMsg.MsgHeader) ZeusTransformUtils.preCheckCast(r8.next(), WsChannelMsg.MsgHeader.class, "com.obric.aiagent.plugin");
        r0.add(new Frame.b.a().a(r1.getKey()).b(r1.getValue()).a());
    L16:
        if (r0.isEmpty() == true) goto L19;
        r6.a(r0);
    L19:
        return Frame.ADAPTER.encode(r6.a());
    L8:
        r4 = h.f38723b;
        goto L9
    }
}
