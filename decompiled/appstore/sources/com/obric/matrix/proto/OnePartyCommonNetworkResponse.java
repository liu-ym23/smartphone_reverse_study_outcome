package com.obric.matrix.proto;

import com.bytedanceos.common.toolbox.ServerElements;
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
public final class OnePartyCommonNetworkResponse extends Message<OnePartyCommonNetworkResponse, a> {
    public static final ProtoAdapter<OnePartyCommonNetworkResponse> ADAPTER = null;
    public static final String DEFAULT_BODY = "";
    public static final Boolean DEFAULT_ISSUCCEED = null;
    public static final String DEFAULT_SERVERLOGID = "";
    private static final long serialVersionUID = 0;

    @SerializedName(ServerElements.BODY)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String body;

    @SerializedName("extraMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> extraMap;

    @SerializedName("isSucceed")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean isSucceed;

    @SerializedName("serverLogId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String serverLogId;

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f12051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f12053c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map f12054d;

        public a() {
            this.f12051a = Boolean.FALSE;
            this.f12052b = "";
            this.f12053c = "";
            this.f12054d = Internal.newMutableMap();
        }

        public a a(String r10) {
            this.f12052b = r10;
            return this;
        }

        public OnePartyCommonNetworkResponse b() {
            return new OnePartyCommonNetworkResponse(this.f12051a, this.f12052b, this.f12053c, this.f12054d, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return b();
        }

        public a c(Boolean r10) {
            this.f12051a = r10;
            return this;
        }

        public a d(String r10) {
            this.f12053c = r10;
            return this;
        }
    }

    public static final class b extends ProtoAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ProtoAdapter f12055a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, OnePartyCommonNetworkResponse.class);
            ProtoAdapter<String> r10 = ProtoAdapter.STRING;
            this.f12055a = ProtoAdapter.newMapAdapter(r10, r10);
        }

        public OnePartyCommonNetworkResponse a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L18;
            if (r13 != 1) goto L8;
            r11.c(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L8:
            if (r13 != 2) goto L10;
            r11.a(ProtoAdapter.STRING.decode(r10));
            goto L3
        L10:
            if (r13 != 3) goto L12;
            r11.d(ProtoAdapter.STRING.decode(r10));
            goto L3
        L12:
            if (r13 != 4) goto L13;
            r11.f12054d.putAll((Map) this.f12055a.decode(r10));
            goto L3
        L13:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L18:
            r10.endMessage(r12);
            return r11.b();
        }

        public void b(ProtoWriter r10, OnePartyCommonNetworkResponse r11) {
            ProtoAdapter.BOOL.encodeWithTag(r10, 1, r11.isSucceed);
            ProtoAdapter<String> r12 = ProtoAdapter.STRING;
            r12.encodeWithTag(r10, 2, r11.body);
            r12.encodeWithTag(r10, 3, r11.serverLogId);
            this.f12055a.encodeWithTag(r10, 4, r11.extraMap);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(OnePartyCommonNetworkResponse r10) {
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r10.isSucceed);
            ProtoAdapter<String> r12 = ProtoAdapter.STRING;
            return (((r11 + r12.encodedSizeWithTag(2, r10.body)) + r12.encodedSizeWithTag(3, r10.serverLogId)) + this.f12055a.encodedSizeWithTag(4, r10.extraMap)) + r10.unknownFields().size();
        }

        public OnePartyCommonNetworkResponse d(OnePartyCommonNetworkResponse r10) {
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
            b(r10, (OnePartyCommonNetworkResponse) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((OnePartyCommonNetworkResponse) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((OnePartyCommonNetworkResponse) r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_ISSUCCEED = Boolean.FALSE;
    }

    public OnePartyCommonNetworkResponse(Boolean r10, String r11, String r12, Map<String, String> r13) {
        this(r10, r11, r12, r13, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof OnePartyCommonNetworkResponse) == true) goto L8;
        return false;
    L8:
        OnePartyCommonNetworkResponse r11 = (OnePartyCommonNetworkResponse) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L20;
        if (Internal.equals(this.isSucceed, r11.isSucceed) == false) goto L20;
        if (Internal.equals(this.body, r11.body) == false) goto L20;
        if (Internal.equals(this.serverLogId, r11.serverLogId) == false) goto L20;
        if (this.extraMap.equals(r11.extraMap) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L17;
        int r11 = unknownFields().hashCode() * 37;
        Boolean r12 = this.isSucceed;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        String r16 = this.body;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        String r19 = this.serverLogId;
        if (r19 == null) goto L15;
        r13 = r19.hashCode();
    L15:
        int r20 = ((r18 + r13) * 37) + this.extraMap.hashCode();
        this.hashCode = r20;
        return r20;
    L11:
        r17 = 0;
        goto L12
    L7:
        r14 = 0;
        goto L8
    L17:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.isSucceed == null) goto L6;
        r10.append(", isSucceed=");
        r10.append(this.isSucceed);
    L6:
        if (this.body == null) goto L9;
        r10.append(", body=");
        r10.append(this.body);
    L9:
        if (this.serverLogId == null) goto L11;
        r10.append(", serverLogId=");
        r10.append(this.serverLogId);
    L11:
        Map<String, String> r11 = this.extraMap;
        if (r11 != null) goto L14;
    L16:
        StringBuilder r12 = r10.replace(0, 2, "OnePartyCommonNetworkResponse{");
        r12.append('}');
        return r12.toString();
    L14:
        if (r11.isEmpty() == true) goto L16;
        r10.append(", extraMap=");
        r10.append(this.extraMap);
        goto L16
    }

    public OnePartyCommonNetworkResponse(Boolean r10, String r11, String r12, Map<String, String> r13, ByteString r14) {
        super(ADAPTER, r14);
        this.isSucceed = r10;
        this.body = r11;
        this.serverLogId = r12;
        this.extraMap = Internal.immutableCopyOf("extraMap", r13);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f12051a = this.isSucceed;
        r10.f12052b = this.body;
        r10.f12053c = this.serverLogId;
        r10.f12054d = Internal.copyOf("extraMap", this.extraMap);
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
