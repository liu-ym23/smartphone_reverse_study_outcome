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
public final class DecodeLocationResponse extends Message<DecodeLocationResponse, a> {
    public static final ProtoAdapter<DecodeLocationResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("locationInfo")
    @WireField(adapter = "com.obric.matrix.proto.LocationInfo#ADAPTER", tag = 1)
    public final LocationInfo locationInfo;

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LocationInfo f11980a;

        public a() {
        }

        public DecodeLocationResponse a() {
            return new DecodeLocationResponse(this.f11980a, super.buildUnknownFields());
        }

        public a b(LocationInfo r10) {
            this.f11980a = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, DecodeLocationResponse.class);
        }

        public DecodeLocationResponse a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L9;
            if (r13 != 1) goto L7;
            r11.b(LocationInfo.ADAPTER.decode(r10));
            goto L3
        L7:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L9:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, DecodeLocationResponse r11) {
            LocationInfo.ADAPTER.encodeWithTag(r10, 1, r11.locationInfo);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(DecodeLocationResponse r10) {
            return LocationInfo.ADAPTER.encodedSizeWithTag(1, r10.locationInfo) + r10.unknownFields().size();
        }

        public DecodeLocationResponse d(DecodeLocationResponse r10) {
            a r11 = r10.newBuilder();
            LocationInfo r12 = r11.f11980a;
            if (r12 == null) goto L5;
            r11.f11980a = LocationInfo.ADAPTER.redact(r12);
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
            b(r10, (DecodeLocationResponse) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((DecodeLocationResponse) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((DecodeLocationResponse) r10);
        }
    }

    static {
        ADAPTER = new b();
    }

    public DecodeLocationResponse(LocationInfo r10) {
        this(r10, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof DecodeLocationResponse) == true) goto L8;
        return false;
    L8:
        DecodeLocationResponse r11 = (DecodeLocationResponse) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L14;
        if (Internal.equals(this.locationInfo, r11.locationInfo) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L10;
        int r11 = unknownFields().hashCode() * 37;
        LocationInfo r12 = this.locationInfo;
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
        if (this.locationInfo == null) goto L5;
        r10.append(", locationInfo");
    L5:
        StringBuilder r11 = r10.replace(0, 2, "DecodeLocationResponse{");
        r11.append('}');
        return r11.toString();
    }

    public DecodeLocationResponse(LocationInfo r10, ByteString r11) {
        super(ADAPTER, r11);
        this.locationInfo = r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f11980a = this.locationInfo;
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
