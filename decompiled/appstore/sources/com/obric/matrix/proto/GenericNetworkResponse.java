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
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class GenericNetworkResponse extends Message<GenericNetworkResponse, a> {
    public static final ProtoAdapter<GenericNetworkResponse> ADAPTER = null;
    public static final String DEFAULT_BODY = "";
    public static final Boolean DEFAULT_ISSUCCEED = null;
    public static final String DEFAULT_SERVERLOGID = "";
    private static final long serialVersionUID = 0;

    @SerializedName(ServerElements.BODY)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
    public final String body;

    @SerializedName("isSucceed")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.REQUIRED, tag = 1)
    public final Boolean isSucceed;

    @SerializedName("serverLogId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 3)
    public final String serverLogId;

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f11998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f11999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f12000c;

        public a() {
            this.f11998a = Boolean.FALSE;
            this.f11999b = "";
            this.f12000c = "";
        }

        public a a(String r10) {
            this.f11999b = r10;
            return this;
        }

        public GenericNetworkResponse b() {
            Boolean r10 = this.f11998a;
            if (r10 == null) goto L11;
            if (this.f11999b == null) goto L11;
            if (this.f12000c == null) goto L11;
            return new GenericNetworkResponse(this.f11998a, this.f11999b, this.f12000c, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r10, "isSucceed", this.f11999b, ServerElements.BODY, this.f12000c, "serverLogId"});
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return b();
        }

        public a c(Boolean r10) {
            this.f11998a = r10;
            return this;
        }

        public a d(String r10) {
            this.f12000c = r10;
            return this;
        }
    }

    public static final class b extends ProtoAdapter {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, GenericNetworkResponse.class);
        }

        public GenericNetworkResponse a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L15;
            if (r13 != 1) goto L8;
            r11.c(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L8:
            if (r13 != 2) goto L10;
            r11.a(ProtoAdapter.STRING.decode(r10));
            goto L3
        L10:
            if (r13 != 3) goto L11;
            r11.d(ProtoAdapter.STRING.decode(r10));
            goto L3
        L11:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L15:
            r10.endMessage(r12);
            return r11.b();
        }

        public void b(ProtoWriter r10, GenericNetworkResponse r11) {
            ProtoAdapter.BOOL.encodeWithTag(r10, 1, r11.isSucceed);
            ProtoAdapter<String> r12 = ProtoAdapter.STRING;
            r12.encodeWithTag(r10, 2, r11.body);
            r12.encodeWithTag(r10, 3, r11.serverLogId);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(GenericNetworkResponse r10) {
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r10.isSucceed);
            ProtoAdapter<String> r12 = ProtoAdapter.STRING;
            return ((r11 + r12.encodedSizeWithTag(2, r10.body)) + r12.encodedSizeWithTag(3, r10.serverLogId)) + r10.unknownFields().size();
        }

        public GenericNetworkResponse d(GenericNetworkResponse r10) {
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
            b(r10, (GenericNetworkResponse) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((GenericNetworkResponse) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((GenericNetworkResponse) r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_ISSUCCEED = Boolean.FALSE;
    }

    public GenericNetworkResponse(Boolean r10, String r11, String r12) {
        this(r10, r11, r12, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof GenericNetworkResponse) == true) goto L8;
        return false;
    L8:
        GenericNetworkResponse r11 = (GenericNetworkResponse) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L18;
        if (this.isSucceed.equals(r11.isSucceed) == false) goto L18;
        if (this.body.equals(r11.body) == false) goto L18;
        if (this.serverLogId.equals(r11.serverLogId) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L6;
        int r11 = (((((unknownFields().hashCode() * 37) + this.isSucceed.hashCode()) * 37) + this.body.hashCode()) * 37) + this.serverLogId.hashCode();
        this.hashCode = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(", isSucceed=");
        r10.append(this.isSucceed);
        r10.append(", body=");
        r10.append(this.body);
        r10.append(", serverLogId=");
        r10.append(this.serverLogId);
        StringBuilder r11 = r10.replace(0, 2, "GenericNetworkResponse{");
        r11.append('}');
        return r11.toString();
    }

    public GenericNetworkResponse(Boolean r10, String r11, String r12, ByteString r13) {
        super(ADAPTER, r13);
        this.isSucceed = r10;
        this.body = r11;
        this.serverLogId = r12;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f11998a = this.isSucceed;
        r10.f11999b = this.body;
        r10.f12000c = this.serverLogId;
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
