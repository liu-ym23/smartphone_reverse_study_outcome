package com.obric.matrix.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class SendApplogEventResponse extends Message<SendApplogEventResponse, a> {
    public static final ProtoAdapter<SendApplogEventResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class a extends Message.Builder {
        public a() {
        }

        public SendApplogEventResponse a() {
            return new SendApplogEventResponse(super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SendApplogEventResponse.class);
        }

        public SendApplogEventResponse a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L6;
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L6:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, SendApplogEventResponse r11) {
            r10.writeBytes(r11.unknownFields());
        }

        public int c(SendApplogEventResponse r10) {
            return r10.unknownFields().size();
        }

        public SendApplogEventResponse d(SendApplogEventResponse r10) {
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
            b(r10, (SendApplogEventResponse) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((SendApplogEventResponse) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((SendApplogEventResponse) r10);
        }
    }

    static {
        ADAPTER = new b();
    }

    public SendApplogEventResponse() {
        this(ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        return r10 instanceof SendApplogEventResponse;
    }

    public int hashCode() {
        return unknownFields().hashCode();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder().replace(0, 2, "SendApplogEventResponse{");
        r10.append('}');
        return r10.toString();
    }

    public SendApplogEventResponse(ByteString r10) {
        super(ADAPTER, r10);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
