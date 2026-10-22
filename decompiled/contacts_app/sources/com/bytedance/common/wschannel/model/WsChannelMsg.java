package com.bytedance.common.wschannel.model;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.utility.StringEncryptUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.MessageAckEvent;
import com.bytedance.common.wschannel.utils.Utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class WsChannelMsg implements Parcelable {
    public static final Parcelable.Creator<WsChannelMsg> CREATOR = null;
    public static WsChannelMsg EMPTY;
    private int channelId;
    private boolean isAckMsg;
    private long logId;
    private String logInfo;
    private int method;
    private List<MsgHeader> msgHeaders;
    private String msgId;
    private NewMsgTimeHolder newMsgTimeHolder;
    private byte[] payload;
    private String payloadEncoding;
    private String payloadType;
    public transient long receiveDataFromIpcTs;
    private ComponentName replayToComponentName;
    private long seqId;
    private String serverTiming;
    private int service;
    private MessageAckEvent.MessageState state;
    private String uuid;

    public static final class Builder {
        private Map<String, String> headers;
        private long logId;
        private final int mChannelId;
        private int method;
        private byte[] payload;
        private String payloadEncoding;
        private String payloadType;
        private ComponentName replyComponentName;
        private long seqId;
        private int service;

        public Builder(int r2) {
            this.headers = new HashMap();
            this.payloadType = "";
            this.payloadEncoding = "";
            this.mChannelId = r2;
        }

        public static Builder create(int r1) {
            return new Builder(r1);
        }

        public Builder addMsgHeader(String r2, String r3) {
            this.headers.put(r2, r3);
            return this;
        }

        public Builder setLogId(long r1) {
            this.logId = r1;
            return this;
        }

        public Builder setService(int r1) {
            this.service = r1;
            return this;
        }

        public Builder setSeqId(long r1) {
            this.seqId = r1;
            return this;
        }

        public Builder setMethod(int r1) {
            this.method = r1;
            return this;
        }

        public Builder setPayload(byte[] r1) {
            this.payload = r1;
            return this;
        }

        public Builder setPayloadType(String r1) {
            this.payloadType = r1;
            return this;
        }

        public Builder setPayloadEncoding(String r1) {
            this.payloadEncoding = r1;
            return this;
        }

        public Builder setReplyComponentName(ComponentName r1) {
            this.replyComponentName = r1;
            return this;
        }

        public WsChannelMsg build() {
            if (this.mChannelId <= 0) goto L23;
            if (this.service < 0) goto L21;
            if (this.method <= 0) goto L19;
            if (this.payload == null) goto L17;
            ArrayList r9 = new ArrayList();
            Iterator<Map.Entry<String, String>> r0 = this.headers.entrySet().iterator();
        L12:
            if (r0.hasNext() == false) goto L15;
            Map.Entry<String, String> r1 = r0.next();
            MsgHeader r2 = new MsgHeader();
            r2.setKey(r1.getKey());
            r2.setValue(r1.getValue());
            r9.add(r2);
            goto L12
        L15:
            return new WsChannelMsg(this.mChannelId, this.seqId, this.logId, this.service, this.method, r9, this.payloadEncoding, this.payloadType, this.payload, this.replyComponentName);
        L17:
            throw new IllegalArgumentException("illegal payload");
        L19:
            throw new IllegalArgumentException("illegal method");
        L21:
            throw new IllegalArgumentException("illegal service");
        L23:
            throw new IllegalArgumentException("illegal channelId");
        }
    }

    public static class MsgHeader implements Parcelable {
        public static final Parcelable.Creator<MsgHeader> CREATOR = null;
        String key;
        String value;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public MsgHeader() {
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public String getKey() {
            return this.key;
        }

        public void setKey(String r1) {
            this.key = r1;
        }

        public String getValue() {
            return this.value;
        }

        public void setValue(String r1) {
            this.value = r1;
        }

        public String toString() {
            return "MsgHeader{key='" + this.key + "', value='" + this.value + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeString(this.key);
            r1.writeString(this.value);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
        EMPTY = new WsChannelMsg();
    }

    @Deprecated
    public WsChannelMsg() {
        this.state = MessageAckEvent.MessageState.Default;
    }

    public WsChannelMsg(int r2, int r3, int r4, String r5, boolean r6) {
        this.state = MessageAckEvent.MessageState.Default;
        this.channelId = r2;
        this.service = r3;
        this.method = r4;
        this.uuid = r5;
        this.isAckMsg = r6;
    }

    public WsChannelMsg(int r2, long r3, long r5, int r7, int r8, List<MsgHeader> r9, String r10, String r11, byte[] r12, ComponentName r13) {
        this.state = MessageAckEvent.MessageState.Default;
        this.channelId = r2;
        this.seqId = r3;
        this.logId = r5;
        this.service = r7;
        this.method = r8;
        this.msgHeaders = r9;
        this.payloadEncoding = r10;
        this.payloadType = r11;
        this.payload = r12;
        this.replayToComponentName = r13;
    }

    protected WsChannelMsg(WsChannelMsg r3) {
        this.state = MessageAckEvent.MessageState.Default;
        setSeqId(r3.getSeqId());
        setLogId(r3.getLogId());
        setService(r3.getService());
        setMethod(r3.getMethod());
        setMsgHeaders(r3.getMsgHeaders());
        setPayload(r3.getPayload());
        setPayloadEncoding(r3.getPayloadEncoding());
        setPayloadType(r3.getPayloadType());
        setChannelId(r3.getChannelId());
        setReplayToComponentName(r3.getReplayToComponentName());
        setNewMsgTimeHolder(r3.getNewMsgTimeHolder());
        setIsAckMsg(r3.isAckMsg());
        setUUID(r3.getUUID());
        setState(r3.getState());
        setLogInfo(r3.logInfo);
        setServerTiming(r3.serverTiming);
        setMsgId(r3.msgId);
    }

    public String getUUID() {
        return this.uuid;
    }

    public void setUUID(String r1) {
        this.uuid = r1;
    }

    public boolean isAckMsg() {
        return this.isAckMsg;
    }

    public void setIsAckMsg(boolean r1) {
        this.isAckMsg = r1;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public void setMsgId(String r1) {
        this.msgId = r1;
    }

    public String getServerTiming() {
        return this.serverTiming;
    }

    public void setServerTiming(String r1) {
        this.serverTiming = r1;
    }

    public String getLogInfo() {
        return this.logInfo;
    }

    public void setLogInfo(String r1) {
        this.logInfo = r1;
    }

    public MessageAckEvent.MessageState getState() {
        return this.state;
    }

    public void setState(MessageAckEvent.MessageState r1) {
        this.state = r1;
    }

    public long getSeqId() {
        return this.seqId;
    }

    public void setSeqId(long r1) {
        this.seqId = r1;
    }

    public long getLogId() {
        return this.logId;
    }

    public void setLogId(long r1) {
        this.logId = r1;
    }

    public int getService() {
        return this.service;
    }

    public void setService(int r1) {
        this.service = r1;
    }

    public int getMethod() {
        return this.method;
    }

    public void setMethod(int r1) {
        this.method = r1;
    }

    public List<MsgHeader> getMsgHeaders() {
        return this.msgHeaders;
    }

    public void setMsgHeaders(List<MsgHeader> r1) {
        this.msgHeaders = r1;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public void setChannelId(int r1) {
        this.channelId = r1;
    }

    public String getPayloadEncoding() {
        return this.payloadEncoding;
    }

    public void setPayloadEncoding(String r1) {
        this.payloadEncoding = r1;
    }

    public String getPayloadType() {
        return this.payloadType;
    }

    public void setPayloadType(String r1) {
        this.payloadType = r1;
    }

    public byte[] getPayload() {
        if (this.payload != null) goto L6;
        this.payload = new byte[1];
    L6:
        return this.payload;
    }

    public void setPayload(byte[] r1) {
        this.payload = r1;
    }

    public ComponentName getReplayToComponentName() {
        return this.replayToComponentName;
    }

    public void setReplayToComponentName(ComponentName r1) {
        this.replayToComponentName = r1;
    }

    public NewMsgTimeHolder getNewMsgTimeHolder() {
        return this.newMsgTimeHolder;
    }

    public void setNewMsgTimeHolder(NewMsgTimeHolder r1) {
        this.newMsgTimeHolder = r1;
    }

    public String toString() {
        return "WsChannelMsg{, channelId = " + this.channelId + ", logId=" + this.logId + ", service=" + this.service + ", method=" + this.method + ", msgHeaders=" + this.msgHeaders + ", payloadEncoding='" + this.payloadEncoding + "', payloadType='" + this.payloadType + "', payload=" + Arrays.toString(this.payload) + ", replayToComponentName=" + this.replayToComponentName + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeLong(this.seqId);
        r3.writeLong(this.logId);
        r3.writeInt(this.service);
        r3.writeInt(this.method);
        r3.writeTypedList(this.msgHeaders);
        r3.writeString(this.payloadEncoding);
        r3.writeString(this.payloadType);
        r3.writeByteArray(this.payload);
        r3.writeParcelable(this.replayToComponentName, r4);
        r3.writeInt(this.channelId);
        r3.writeString(this.uuid);
        r3.writeByte(this.isAckMsg ? 1 : 0);
        r3.writeInt(this.state.getTypeValue());
        r3.writeParcelable(this.newMsgTimeHolder, r4);
        r3.writeString(this.logInfo);
        r3.writeString(this.serverTiming);
        r3.writeString(this.msgId);
    }

    protected WsChannelMsg(Parcel r3) {
        this.state = MessageAckEvent.MessageState.Default;
        this.seqId = r3.readLong();
        this.logId = r3.readLong();
        this.service = r3.readInt();
        this.method = r3.readInt();
        this.msgHeaders = r3.createTypedArrayList(MsgHeader.CREATOR);
        this.payloadEncoding = r3.readString();
        this.payloadType = r3.readString();
        this.payload = r3.createByteArray();
        this.replayToComponentName = (ComponentName) r3.readParcelable(ComponentName.class.getClassLoader());
        this.channelId = r3.readInt();
        this.uuid = r3.readString();
        if (r3.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.isAckMsg = r0;
        this.state = MessageAckEvent.MessageState.valueOf(r3.readInt());
        this.newMsgTimeHolder = (NewMsgTimeHolder) r3.readParcelable(NewMsgTimeHolder.class.getClassLoader());
        this.logInfo = r3.readString();
        this.serverTiming = r3.readString();
        this.msgId = r3.readString();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public Map<String, String> toMap() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("seqId", String.valueOf(this.seqId));
        r0.put("logId", String.valueOf(this.logId));
        r0.put("service", String.valueOf(this.service));
        r0.put("method", String.valueOf(this.method));
        r0.put("payloadEncoding", this.payloadEncoding);
        r0.put("payloadType", this.payloadType);
        r0.put(WsConstants.KEY_PAYLOAD_MD5, Utils.byte2HexStr(MessageDigest.getInstance(StringEncryptUtils.MD5).digest(this.payload), ""));     // Catch: NoSuchAlgorithmException -> L5
    L7:
        r0.put("channelId", String.valueOf(this.channelId));
        Iterator<MsgHeader> r3 = this.msgHeaders.iterator();
    L9:
        if (r3.hasNext() == false) goto L11;
        MsgHeader r1 = r3.next();
        r0.put(r1.key, r1.value);
        goto L9
    L11:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void addHeader(String r2, String r3) {
        MsgHeader r0 = new MsgHeader();
        r0.setKey(r2);
        r0.setValue(r3);
        this.msgHeaders.add(r0);
    }
}
