package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class SendApplogEventRequest extends Message<SendApplogEventRequest, a> {
    public static final ProtoAdapter<SendApplogEventRequest> ADAPTER = null;
    public static final String DEFAULT_APPID = "";
    private static final long serialVersionUID = 0;

    @SerializedName("appid")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String appid;

    @SerializedName("eventMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, String> eventMap;

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f12145b;

        public a() {
            this.f12144a = "";
            this.f12145b = Internal.newMutableMap();
        }

        public a a(String r10) {
            this.f12144a = r10;
            return this;
        }

        public SendApplogEventRequest b() {
            return new SendApplogEventRequest(this.f12144a, this.f12145b, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return b();
        }
    }

    public static final class b extends ProtoAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ProtoAdapter f12146a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SendApplogEventRequest.class);
            ProtoAdapter<String> r10 = ProtoAdapter.STRING;
            this.f12146a = ProtoAdapter.newMapAdapter(r10, r10);
        }

        public SendApplogEventRequest a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L12;
            if (r13 != 1) goto L8;
            r11.a(ProtoAdapter.STRING.decode(r10));
            goto L3
        L8:
            if (r13 != 2) goto L9;
            r11.f12145b.putAll((Map) this.f12146a.decode(r10));
            goto L3
        L9:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L12:
            r10.endMessage(r12);
            return r11.b();
        }

        public void b(ProtoWriter r10, SendApplogEventRequest r11) {
            ProtoAdapter.STRING.encodeWithTag(r10, 1, r11.appid);
            this.f12146a.encodeWithTag(r10, 2, r11.eventMap);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(SendApplogEventRequest r10) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r10.appid) + this.f12146a.encodedSizeWithTag(2, r10.eventMap)) + r10.unknownFields().size();
        }

        public SendApplogEventRequest d(SendApplogEventRequest r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.b();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) {
            b(r10, (SendApplogEventRequest) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((SendApplogEventRequest) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((SendApplogEventRequest) r10);
        }
    }

    static {
        ADAPTER = new b();
    }

    public SendApplogEventRequest(String r10, Map<String, String> r11) {
        this(r10, r11, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof SendApplogEventRequest) == true) goto L8;
        return false;
    L8:
        SendApplogEventRequest r11 = (SendApplogEventRequest) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L16;
        if (Internal.equals(this.appid, r11.appid) == false) goto L16;
        if (this.eventMap.equals(r11.eventMap) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L10;
        int r11 = unknownFields().hashCode() * 37;
        String r12 = this.appid;
        if (r12 == null) goto L7;
        int r13 = r12.hashCode();
    L8:
        int r14 = ((r11 + r13) * 37) + this.eventMap.hashCode();
        this.hashCode = r14;
        return r14;
    L7:
        r13 = 0;
        goto L8
    L10:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.appid == null) goto L5;
        r10.append(", appid=");
        r10.append(this.appid);
    L5:
        Map<String, String> r11 = this.eventMap;
        if (r11 != null) goto L8;
    L10:
        StringBuilder r12 = r10.replace(0, 2, "SendApplogEventRequest{");
        r12.append('}');
        return r12.toString();
    L8:
        if (r11.isEmpty() == true) goto L10;
        r10.append(", eventMap=");
        r10.append(this.eventMap);
        goto L10
    }

    public SendApplogEventRequest(String r10, Map<String, String> r11, ByteString r12) {
        super(ADAPTER, r12);
        this.appid = r10;
        this.eventMap = Internal.immutableCopyOf("eventMap", r11);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f12144a = this.appid;
        r10.f12145b = Internal.copyOf("eventMap", this.eventMap);
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
