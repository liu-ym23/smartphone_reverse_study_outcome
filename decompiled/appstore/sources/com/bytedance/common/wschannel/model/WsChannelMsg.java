package com.bytedance.common.wschannel.model;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelMsg implements Parcelable {
    public static final Parcelable.Creator<WsChannelMsg> CREATOR = null;
    public static WsChannelMsg EMPTY;
    int channelId;
    long logId;
    int method;
    List<MsgHeader> msgHeaders;
    byte[] payload;
    String payloadEncoding;
    String payloadType;
    ComponentName replayToComponentName;
    long seqId;
    int service;

    public static class MsgHeader implements Parcelable {
        public static final Parcelable.Creator<MsgHeader> CREATOR = null;
        String key;
        String value;

        public static class a implements Parcelable.Creator {
            public a() {
            }

            public MsgHeader a(Parcel r10) {
                MsgHeader r11 = new MsgHeader();
                r11.key = r10.readString();
                r11.value = r10.readString();
                return r11;
            }

            public MsgHeader[] b(int r10) {
                return new MsgHeader[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public MsgHeader() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }

        public void setKey(String r10) {
            this.key = r10;
        }

        public void setValue(String r10) {
            this.value = r10;
        }

        public String toString() {
            return "MsgHeader{key='" + this.key + "', value='" + this.value + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            r10.writeString(this.key);
            r10.writeString(this.value);
        }
    }

    public static class a implements Parcelable.Creator {
        public a() {
        }

        public WsChannelMsg a(Parcel r10) {
            return new WsChannelMsg(r10);
        }

        public WsChannelMsg[] b(int r10) {
            return new WsChannelMsg[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f7052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f7053c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7054d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7055e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte[] f7056f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f7057g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f7058h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f7059i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public ComponentName f7060j;

        public b(int r10) {
            this.f7052b = new HashMap();
            this.f7057g = "";
            this.f7058h = "";
            this.f7051a = r10;
        }

        public static b c(int r10) {
            return new b(r10);
        }

        public b a(String r10, String r11) {
            this.f7052b.put(r10, r11);
            return this;
        }

        public WsChannelMsg b() {
            if (this.f7051a <= 0) goto L23;
            if (this.f7054d <= 0) goto L21;
            if (this.f7055e <= 0) goto L19;
            if (this.f7056f == null) goto L17;
            ArrayList r10 = new ArrayList();
            Iterator r11 = this.f7052b.entrySet().iterator();
        L12:
            if (r11.hasNext() == false) goto L15;
            Map.Entry r12 = (Map.Entry) r11.next();
            MsgHeader r13 = new MsgHeader();
            r13.setKey((String) r12.getKey());
            r13.setValue((String) r12.getValue());
            r10.add(r13);
            goto L12
        L15:
            return new WsChannelMsg(this.f7051a, this.f7059i, this.f7053c, this.f7054d, this.f7055e, r10, this.f7058h, this.f7057g, this.f7056f, this.f7060j);
        L17:
            throw new IllegalArgumentException("illegal payload");
        L19:
            throw new IllegalArgumentException("illegal method");
        L21:
            throw new IllegalArgumentException("illegal service");
        L23:
            throw new IllegalArgumentException("illegal channelId");
        }

        public b d(long r10) {
            this.f7053c = r10;
            return this;
        }

        public b e(int r10) {
            this.f7055e = r10;
            return this;
        }

        public b f(byte[] r10) {
            this.f7056f = r10;
            return this;
        }

        public b g(String r10) {
            this.f7058h = r10;
            return this;
        }

        public b h(String r10) {
            this.f7057g = r10;
            return this;
        }

        public b i(int r10) {
            this.f7054d = r10;
            return this;
        }
    }

    static {
        CREATOR = new a();
        EMPTY = new WsChannelMsg();
    }

    @Deprecated
    public WsChannelMsg() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getChannelId() {
        return this.channelId;
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

    public byte[] getPayload() {
        if (this.payload != null) goto L6;
        this.payload = new byte[1];
    L6:
        return this.payload;
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

    public void setChannelId(int r10) {
        this.channelId = r10;
    }

    public void setLogId(long r10) {
        this.logId = r10;
    }

    public void setMethod(int r10) {
        this.method = r10;
    }

    public void setMsgHeaders(List<MsgHeader> r10) {
        this.msgHeaders = r10;
    }

    public void setPayload(byte[] r10) {
        this.payload = r10;
    }

    public void setPayloadEncoding(String r10) {
        this.payloadEncoding = r10;
    }

    public void setPayloadType(String r10) {
        this.payloadType = r10;
    }

    public void setReplayToComponentName(ComponentName r10) {
        this.replayToComponentName = r10;
    }

    public void setSeqId(long r10) {
        this.seqId = r10;
    }

    public void setService(int r10) {
        this.service = r10;
    }

    public String toString() {
        return "WsChannelMsg{, channelId = " + this.channelId + ", logId=" + this.logId + ", service=" + this.service + ", method=" + this.method + ", msgHeaders=" + this.msgHeaders + ", payloadEncoding='" + this.payloadEncoding + "', payloadType='" + this.payloadType + "', payload=" + Arrays.toString(this.payload) + ", replayToComponentName=" + this.replayToComponentName + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeLong(this.seqId);
        r10.writeLong(this.logId);
        r10.writeInt(this.service);
        r10.writeInt(this.method);
        r10.writeTypedList(this.msgHeaders);
        r10.writeString(this.payloadEncoding);
        r10.writeString(this.payloadType);
        r10.writeByteArray(this.payload);
        r10.writeParcelable(this.replayToComponentName, r11);
        r10.writeInt(this.channelId);
    }

    public WsChannelMsg(int r10, long r11, long r12, int r13, int r14, List<MsgHeader> r15, String r16, String r17, byte[] r18, ComponentName r19) {
        this.channelId = r10;
        this.seqId = r11;
        this.logId = r12;
        this.service = r13;
        this.method = r14;
        this.msgHeaders = r15;
        this.payloadEncoding = r16;
        this.payloadType = r17;
        this.payload = r18;
        this.replayToComponentName = r19;
    }

    public WsChannelMsg(Parcel r10) {
        this.seqId = r10.readLong();
        this.logId = r10.readLong();
        this.service = r10.readInt();
        this.method = r10.readInt();
        this.msgHeaders = r10.createTypedArrayList(MsgHeader.CREATOR);
        this.payloadEncoding = r10.readString();
        this.payloadType = r10.readString();
        this.payload = r10.createByteArray();
        this.replayToComponentName = (ComponentName) r10.readParcelable(ComponentName.class.getClassLoader());
        this.channelId = r10.readInt();
    }
}
