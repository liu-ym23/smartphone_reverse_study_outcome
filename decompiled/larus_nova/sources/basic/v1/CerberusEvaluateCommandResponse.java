package basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes28.dex */
public final class CerberusEvaluateCommandResponse extends Message<CerberusEvaluateCommandResponse, Builder> {
    public static final ProtoAdapter<CerberusEvaluateCommandResponse> ADAPTER = null;
    public static final ProtoAdapter_CerberusEvaluateCommandResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> result;

    public static final class Builder extends Message.Builder<CerberusEvaluateCommandResponse, Builder> implements b<CerberusEvaluateCommandResponse> {
        public Map<String, String> result;

        @Override // com.squareup.wire.Message.Builder
        public CerberusEvaluateCommandResponse build() {
            return new CerberusEvaluateCommandResponse(this.result, super.buildUnknownFields());
        }

        public Builder() {
            this.result = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder result(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.result = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CerberusEvaluateCommandResponse extends ProtoAdapter<CerberusEvaluateCommandResponse> implements a<CerberusEvaluateCommandResponse> {
        private final ProtoAdapter<Map<String, String>> result;

        public ProtoAdapter_CerberusEvaluateCommandResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CerberusEvaluateCommandResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.result = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CerberusEvaluateCommandResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.result.putAll(this.result.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CerberusEvaluateCommandResponse r100) {
            return this.result.encodedSizeWithTag(1, r100.result) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CerberusEvaluateCommandResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CerberusEvaluateCommandResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CerberusEvaluateCommandResponse r101) throws IOException {
            this.result.encodeWithTag(r100, 1, r101.result);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CerberusEvaluateCommandResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CerberusEvaluateCommandResponse r100 = new ProtoAdapter_CerberusEvaluateCommandResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.result = Internal.copyOf("result", this.result);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CerberusEvaluateCommandResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CerberusEvaluateCommandResponse(Map<String, String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public CerberusEvaluateCommandResponse(Map<String, String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.result = Internal.immutableCopyOf("result", r100);
    }
}
