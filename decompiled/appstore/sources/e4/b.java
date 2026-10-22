package e4;

import com.bytedance.common.wschannel.converter.MsgConverter;
import com.bytedance.common.wschannel.model.Frame;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
public class b implements MsgConverter {
    public b() {
    }

    @Override // com.bytedance.common.wschannel.converter.MsgConverter
    public WsChannelMsg decode(byte[] r11) {
        Frame r10 = Frame.ADAPTER.decode(r11);
        long r12 = ((Long) Wire.get(r10.seqid, Frame.DEFAULT_SEQID)).longValue();
        long r13 = ((Long) Wire.get(r10.logid, Frame.DEFAULT_LOGID)).longValue();
        int r14 = ((Integer) Wire.get(r10.service, Frame.DEFAULT_SERVICE)).intValue();
        int r15 = ((Integer) Wire.get(r10.method, Frame.DEFAULT_METHOD)).intValue();
        List r16 = (List) Wire.get(r10.headers, Collections.emptyList());
        String r17 = (String) Wire.get(r10.payload_encoding, "");
        String r18 = (String) Wire.get(r10.payload_type, "");
        byte[] r19 = ((ByteString) Wire.get(r10.payload, Frame.DEFAULT_PAYLOAD)).toByteArray();
        WsChannelMsg r20 = new WsChannelMsg();
        r20.setLogId(r13);
        r20.setSeqId(r12);
        r20.setService(r14);
        r20.setMethod(r15);
        if (r16 != null) goto L5;
    L11:
        r20.setPayloadEncoding(r17);
        r20.setPayloadType(r18);
        r20.setPayload(r19);
        return r20;
    L5:
        if (r16.size() < 0) goto L11;
        ArrayList r110 = new ArrayList();
        Iterator r21 = r16.iterator();
    L8:
        if (r21.hasNext() == false) goto L10;
        Frame.ExtendedEntry r22 = (Frame.ExtendedEntry) r21.next();
        WsChannelMsg.MsgHeader r23 = new WsChannelMsg.MsgHeader();
        r23.setKey((String) Wire.get(r22.key, ""));
        r23.setValue((String) Wire.get(r22.value, ""));
        r110.add(r23);
        goto L8
    L10:
        r20.setMsgHeaders(r110);
        goto L11
    }

    @Override // com.bytedance.common.wschannel.converter.MsgConverter
    public byte[] encode(WsChannelMsg r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.getPayload() == null) goto L8;
        ByteString r11 = ByteString.of(r10.getPayload());
    L9:
        Frame.a r12 = new Frame.a().c(Long.valueOf(r10.getLogId())).h(Long.valueOf(r10.getSeqId())).i(Integer.valueOf(r10.getService())).f(r10.getPayloadEncoding()).g(r10.getPayloadType()).e(r11).d(Integer.valueOf(r10.getMethod()));
        List<WsChannelMsg.MsgHeader> r13 = r10.getMsgHeaders();
        ArrayList r14 = new ArrayList();
        if (r13 == null) goto L16;
        Iterator<WsChannelMsg.MsgHeader> r15 = r13.iterator();
    L13:
        if (r15.hasNext() == false) goto L16;
        WsChannelMsg.MsgHeader r16 = r15.next();
        r14.add(new Frame.ExtendedEntry.a().b(r16.getKey()).c(r16.getValue()).a());
    L16:
        if (r14.isEmpty() == true) goto L19;
        r12.b(r14);
    L19:
        return Frame.ADAPTER.encode(r12.a());
    L8:
        r11 = ByteString.EMPTY;
        goto L9
    }
}
