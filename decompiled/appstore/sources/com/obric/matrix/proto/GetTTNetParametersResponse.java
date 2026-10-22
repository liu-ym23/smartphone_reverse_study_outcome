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
public final class GetTTNetParametersResponse extends Message<GetTTNetParametersResponse, a> {
    public static final ProtoAdapter<GetTTNetParametersResponse> ADAPTER = null;
    public static final String DEFAULT_PARAMETERS = "";
    private static final long serialVersionUID = 0;

    @SerializedName("parameters")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    public final String parameters;

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12016a;

        public a() {
            this.f12016a = "";
        }

        public GetTTNetParametersResponse a() {
            String r10 = this.f12016a;
            if (r10 == null) goto L7;
            return new GetTTNetParametersResponse(this.f12016a, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r10, "parameters"});
        }

        public a b(String r10) {
            this.f12016a = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTTNetParametersResponse.class);
        }

        public GetTTNetParametersResponse a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L9;
            if (r13 != 1) goto L7;
            r11.b(ProtoAdapter.STRING.decode(r10));
            goto L3
        L7:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L9:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, GetTTNetParametersResponse r11) {
            ProtoAdapter.STRING.encodeWithTag(r10, 1, r11.parameters);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(GetTTNetParametersResponse r10) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r10.parameters) + r10.unknownFields().size();
        }

        public GetTTNetParametersResponse d(GetTTNetParametersResponse r10) {
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
            b(r10, (GetTTNetParametersResponse) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((GetTTNetParametersResponse) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((GetTTNetParametersResponse) r10);
        }
    }

    static {
        ADAPTER = new b();
    }

    public GetTTNetParametersResponse(String r10) {
        this(r10, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof GetTTNetParametersResponse) == true) goto L8;
        return false;
    L8:
        GetTTNetParametersResponse r11 = (GetTTNetParametersResponse) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L14;
        if (this.parameters.equals(r11.parameters) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L6;
        int r11 = (unknownFields().hashCode() * 37) + this.parameters.hashCode();
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
        r10.append(", parameters=");
        r10.append(this.parameters);
        StringBuilder r11 = r10.replace(0, 2, "GetTTNetParametersResponse{");
        r11.append('}');
        return r11.toString();
    }

    public GetTTNetParametersResponse(String r10, ByteString r11) {
        super(ADAPTER, r11);
        this.parameters = r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f12016a = this.parameters;
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
