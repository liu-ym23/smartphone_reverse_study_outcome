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
public final class SubscribeWsMsgByProviderResponse extends Message<SubscribeWsMsgByProviderResponse, a> {
    public static final ProtoAdapter<SubscribeWsMsgByProviderResponse> ADAPTER = null;
    public static final String DEFAULT_EXT = "";
    public static final Boolean DEFAULT_SUBSCRIBERESULT = null;
    private static final long serialVersionUID = 0;

    @SerializedName("ext")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String ext;

    @SerializedName("subscribeResult")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean subscribeResult;

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f12170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12171b;

        public a() {
            this.f12170a = Boolean.FALSE;
            this.f12171b = "";
        }

        public SubscribeWsMsgByProviderResponse a() {
            return new SubscribeWsMsgByProviderResponse(this.f12170a, this.f12171b, super.buildUnknownFields());
        }

        public a b(String r10) {
            this.f12171b = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Boolean r10) {
            this.f12170a = r10;
            return this;
        }
    }

    public static final class b extends ProtoAdapter {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsMsgByProviderResponse.class);
        }

        public SubscribeWsMsgByProviderResponse a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L12;
            if (r13 != 1) goto L8;
            r11.c(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L8:
            if (r13 != 2) goto L9;
            r11.b(ProtoAdapter.STRING.decode(r10));
            goto L3
        L9:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L12:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, SubscribeWsMsgByProviderResponse r11) {
            ProtoAdapter.BOOL.encodeWithTag(r10, 1, r11.subscribeResult);
            ProtoAdapter.STRING.encodeWithTag(r10, 2, r11.ext);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(SubscribeWsMsgByProviderResponse r10) {
            return (ProtoAdapter.BOOL.encodedSizeWithTag(1, r10.subscribeResult) + ProtoAdapter.STRING.encodedSizeWithTag(2, r10.ext)) + r10.unknownFields().size();
        }

        public SubscribeWsMsgByProviderResponse d(SubscribeWsMsgByProviderResponse r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) {
            b(r10, (SubscribeWsMsgByProviderResponse) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((SubscribeWsMsgByProviderResponse) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((SubscribeWsMsgByProviderResponse) r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_SUBSCRIBERESULT = Boolean.FALSE;
    }

    public SubscribeWsMsgByProviderResponse(Boolean r10, String r11) {
        this(r10, r11, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof SubscribeWsMsgByProviderResponse) == true) goto L8;
        return false;
    L8:
        SubscribeWsMsgByProviderResponse r11 = (SubscribeWsMsgByProviderResponse) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L16;
        if (Internal.equals(this.subscribeResult, r11.subscribeResult) == false) goto L16;
        if (Internal.equals(this.ext, r11.ext) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L13;
        int r11 = unknownFields().hashCode() * 37;
        Boolean r12 = this.subscribeResult;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        String r16 = this.ext;
        if (r16 == null) goto L11;
        r13 = r16.hashCode();
    L11:
        int r17 = r15 + r13;
        this.hashCode = r17;
        return r17;
    L7:
        r14 = 0;
        goto L8
    L13:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.subscribeResult == null) goto L6;
        r10.append(", subscribeResult=");
        r10.append(this.subscribeResult);
    L6:
        if (this.ext == null) goto L8;
        r10.append(", ext=");
        r10.append(this.ext);
    L8:
        StringBuilder r11 = r10.replace(0, 2, "SubscribeWsMsgByProviderResponse{");
        r11.append('}');
        return r11.toString();
    }

    public SubscribeWsMsgByProviderResponse(Boolean r10, String r11, ByteString r12) {
        super(ADAPTER, r12);
        this.subscribeResult = r10;
        this.ext = r11;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f12170a = this.subscribeResult;
        r10.f12171b = this.ext;
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
