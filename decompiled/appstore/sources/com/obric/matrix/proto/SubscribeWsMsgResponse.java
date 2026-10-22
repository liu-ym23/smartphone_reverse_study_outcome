package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class SubscribeWsMsgResponse extends Message<SubscribeWsMsgResponse, a> {
    public static final ProtoAdapter<SubscribeWsMsgResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("wsMessageInfo")
    @WireField(adapter = "com.obric.matrix.proto.WsMessageInfo#ADAPTER", tag = 1)
    public final WsMessageInfo wsMessageInfo;

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WsMessageInfo f12176a;

        public a() {
        }

        public SubscribeWsMsgResponse a() {
            return new SubscribeWsMsgResponse(this.f12176a, super.buildUnknownFields());
        }

        public a b(WsMessageInfo r10) {
            this.f12176a = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsMsgResponse.class);
        }

        public SubscribeWsMsgResponse a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L9;
            if (r13 != 1) goto L7;
            r11.b(WsMessageInfo.ADAPTER.decode(r10));
            goto L3
        L7:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L9:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, SubscribeWsMsgResponse r11) {
            WsMessageInfo.ADAPTER.encodeWithTag(r10, 1, r11.wsMessageInfo);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(SubscribeWsMsgResponse r10) {
            return WsMessageInfo.ADAPTER.encodedSizeWithTag(1, r10.wsMessageInfo) + r10.unknownFields().size();
        }

        public SubscribeWsMsgResponse d(SubscribeWsMsgResponse r10) {
            a r11 = r10.newBuilder();
            WsMessageInfo r12 = r11.f12176a;
            if (r12 == null) goto L5;
            r11.f12176a = WsMessageInfo.ADAPTER.redact(r12);
        L5:
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) {
            b(r10, (SubscribeWsMsgResponse) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((SubscribeWsMsgResponse) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((SubscribeWsMsgResponse) r10);
        }
    }

    static {
        ADAPTER = new b();
    }

    public SubscribeWsMsgResponse(WsMessageInfo r10) {
        this(r10, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof SubscribeWsMsgResponse) == true) goto L8;
        return false;
    L8:
        SubscribeWsMsgResponse r11 = (SubscribeWsMsgResponse) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L14;
        if (Internal.equals(this.wsMessageInfo, r11.wsMessageInfo) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L10;
        int r11 = unknownFields().hashCode() * 37;
        WsMessageInfo r12 = this.wsMessageInfo;
        if (r12 == null) goto L7;
        int r13 = r12.hashCode();
    L8:
        int r14 = r11 + r13;
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
        if (this.wsMessageInfo == null) goto L5;
        r10.append(", wsMessageInfo=");
        r10.append(this.wsMessageInfo);
    L5:
        StringBuilder r11 = r10.replace(0, 2, "SubscribeWsMsgResponse{");
        r11.append('}');
        return r11.toString();
    }

    public SubscribeWsMsgResponse(WsMessageInfo r10, ByteString r11) {
        super(ADAPTER, r11);
        this.wsMessageInfo = r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f12176a = this.wsMessageInfo;
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
