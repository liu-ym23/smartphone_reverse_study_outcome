package com.bytedance.android.livesdkapi.ws;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class LiveWsMessage implements Parcelable {
    public static final Parcelable.Creator<LiveWsMessage> CREATOR = null;
    public static LiveWsMessage EMPTY = null;
    public static final int FROM_HOST_MESSAGE_WS_SEND = 4;
    public static final int FROM_HOST_WS_RECEIVE = 3;
    public static final int FROM_LIVE_MESSAGE_WS_RECEIVE = 1;
    public static final int FROM_LIVE_MESSAGE_WS_SEND = 2;
    public static final int FROM_UNKNOWN = 0;
    int channelId;
    int from;
    long logId;
    int method;
    List<MsgHeader> msgHeaders;
    byte[] payload;
    String payloadEncoding;
    String payloadType;
    public long receiveTime;
    ComponentName replayToComponentName;
    long seqId;
    int service;

    public static final class Builder {
        private int from;
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

        public LiveWsMessage build() {
            if (this.mChannelId <= 0) goto L23;
            if (this.service <= 0) goto L21;
            if (this.method <= 0) goto L19;
            if (this.payload == null) goto L17;
            ArrayList r100 = new ArrayList();
            Iterator<Map.Entry<String, String>> r101 = this.headers.entrySet().iterator();
        L12:
            if (r101.hasNext() == false) goto L15;
            Map.Entry<String, String> r102 = r101.next();
            MsgHeader r103 = new MsgHeader();
            r103.setKey(r102.getKey());
            r103.setValue(r102.getValue());
            r100.add(r103);
            goto L12
        L15:
            return new LiveWsMessage(this.mChannelId, this.seqId, this.logId, this.service, this.method, r100, this.payloadEncoding, this.payloadType, this.payload, this.from, this.replyComponentName);
        L17:
            throw new IllegalArgumentException("illegal payload");
        L19:
            throw new IllegalArgumentException("illegal method");
        L21:
            throw new IllegalArgumentException("illegal service");
        L23:
            throw new IllegalArgumentException("illegal channelId");
        }

        public Builder(int r100) {
            this.headers = new HashMap();
            this.payloadType = "";
            this.payloadEncoding = "";
            this.mChannelId = r100;
        }

        public static Builder create(int r100) {
            return new Builder(r100);
        }

        public Builder setFrom(int r100) {
            this.from = r100;
            return this;
        }

        public Builder setLogId(long r100) {
            this.logId = r100;
            return this;
        }

        public Builder setMethod(int r100) {
            this.method = r100;
            return this;
        }

        public Builder setPayload(byte[] r100) {
            this.payload = r100;
            return this;
        }

        public Builder setPayloadEncoding(String r100) {
            this.payloadEncoding = r100;
            return this;
        }

        public Builder setPayloadType(String r100) {
            this.payloadType = r100;
            return this;
        }

        public Builder setReplyComponentName(ComponentName r100) {
            this.replyComponentName = r100;
            return this;
        }

        public Builder setSeqId(long r100) {
            this.seqId = r100;
            return this;
        }

        public Builder setService(int r100) {
            this.service = r100;
            return this;
        }

        public Builder addMsgHeader(String r100, String r101) {
            this.headers.put(r100, r101);
            return this;
        }
    }

    public static class MsgHeader implements Parcelable {
        public static final Parcelable.Creator<MsgHeader> CREATOR = null;
        String key;
        String value;

        public MsgHeader() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public String toString() {
            return "MsgHeader{key='" + this.key + "', value='" + this.value + "'}";
        }

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }

        public void setKey(String r100) {
            this.key = r100;
        }

        public void setValue(String r100) {
            this.value = r100;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.key);
            r100.writeString(this.value);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
        EMPTY = new LiveWsMessage();
    }

    public byte[] getPayload() {
        if (this.payload != null) goto L6;
        this.payload = new byte[1];
    L6:
        return this.payload;
    }

    public String toString() {
        return "LiveWsMessage{, channelId = " + this.channelId + ", logId=" + this.logId + ", service=" + this.service + ", method=" + this.method + ", msgHeaders=" + this.msgHeaders + ", payloadEncoding='" + this.payloadEncoding + "', payloadType='" + this.payloadType + "', payload=" + Arrays.toString(this.payload) + ", from= " + this.from + ", replayToComponentName=" + this.replayToComponentName + '}';
    }

    public LiveWsMessage() {
        this.from = 0;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public int getFrom() {
        return this.from;
    }

    public long getLogId() {
        return this.logId;
    }

    public int getMethod() {
        return this.method;
    }

    public List<MsgHeader> getMsgHeaders() {
        return this.msgHeaders;
    }

    public String getPayloadEncoding() {
        return this.payloadEncoding;
    }

    public String getPayloadType() {
        return this.payloadType;
    }

    public ComponentName getReplayToComponentName() {
        return this.replayToComponentName;
    }

    public long getSeqId() {
        return this.seqId;
    }

    public int getService() {
        return this.service;
    }

    public LiveWsMessage(Parcel r100) {
        this.from = 0;
        this.seqId = r100.readLong();
        this.logId = r100.readLong();
        this.service = r100.readInt();
        this.method = r100.readInt();
        this.msgHeaders = r100.createTypedArrayList(MsgHeader.CREATOR);
        this.payloadEncoding = r100.readString();
        this.payloadType = r100.readString();
        this.payload = r100.createByteArray();
        this.replayToComponentName = (ComponentName) r100.readParcelable(ComponentName.class.getClassLoader());
        this.channelId = r100.readInt();
        this.from = r100.readInt();
    }

    public void setChannelId(int r100) {
        this.channelId = r100;
    }

    public void setFrom(int r100) {
        this.from = r100;
    }

    public void setLogId(long r100) {
        this.logId = r100;
    }

    public void setMethod(int r100) {
        this.method = r100;
    }

    public void setMsgHeaders(List<MsgHeader> r100) {
        this.msgHeaders = r100;
    }

    public void setPayload(byte[] r100) {
        this.payload = r100;
    }

    public void setPayloadEncoding(String r100) {
        this.payloadEncoding = r100;
    }

    public void setPayloadType(String r100) {
        this.payloadType = r100;
    }

    public void setReplayToComponentName(ComponentName r100) {
        this.replayToComponentName = r100;
    }

    public void setSeqId(long r100) {
        this.seqId = r100;
    }

    public void setService(int r100) {
        this.service = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.seqId);
        r100.writeLong(this.logId);
        r100.writeInt(this.service);
        r100.writeInt(this.method);
        r100.writeTypedList(this.msgHeaders);
        r100.writeString(this.payloadEncoding);
        r100.writeString(this.payloadType);
        r100.writeByteArray(this.payload);
        r100.writeParcelable(this.replayToComponentName, r101);
        r100.writeInt(this.channelId);
        r100.writeInt(this.from);
    }

    public LiveWsMessage(int r100, long r101, long r102, int r103, int r104, List<MsgHeader> r105, String r106, String r110, byte[] r111, int r112, ComponentName r113) {
        this.channelId = r100;
        this.seqId = r101;
        this.logId = r102;
        this.service = r103;
        this.method = r104;
        this.msgHeaders = r105;
        this.payloadEncoding = r106;
        this.payloadType = r110;
        this.payload = r111;
        this.from = r112;
        this.replayToComponentName = r113;
    }
}
