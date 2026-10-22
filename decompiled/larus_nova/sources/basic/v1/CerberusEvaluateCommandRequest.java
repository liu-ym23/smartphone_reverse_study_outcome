package basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes28.dex */
public final class CerberusEvaluateCommandRequest extends Message<CerberusEvaluateCommandRequest, Builder> {
    public static final ProtoAdapter<CerberusEvaluateCommandRequest> ADAPTER = null;
    public static final String DEFAULT_COMMAND = "";
    public static final Boolean DEFAULT_DEBUG_MODE = null;
    public static final ProtoAdapter_CerberusEvaluateCommandRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String command;
    public final Boolean debug_mode;

    public static final class Builder extends Message.Builder<CerberusEvaluateCommandRequest, Builder> implements b<CerberusEvaluateCommandRequest> {
        public String command;
        public Boolean debug_mode;

        @Override // com.squareup.wire.Message.Builder
        public CerberusEvaluateCommandRequest build() {
            String r100 = this.command;
            if (r100 == null) goto L7;
            return new CerberusEvaluateCommandRequest(this.command, this.debug_mode, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "command"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder command(String r100) {
            this.command = r100;
            return this;
        }

        public Builder debug_mode(Boolean r100) {
            this.debug_mode = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CerberusEvaluateCommandRequest extends ProtoAdapter<CerberusEvaluateCommandRequest> implements a<CerberusEvaluateCommandRequest> {
        public ProtoAdapter_CerberusEvaluateCommandRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CerberusEvaluateCommandRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CerberusEvaluateCommandRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.command = "";
            r101.debug_mode = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.command = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.debug_mode = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CerberusEvaluateCommandRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.command);
            Boolean r102 = r100.debug_mode;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CerberusEvaluateCommandRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CerberusEvaluateCommandRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CerberusEvaluateCommandRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.command);
            Boolean r102 = r101.debug_mode;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CerberusEvaluateCommandRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CerberusEvaluateCommandRequest r100 = new ProtoAdapter_CerberusEvaluateCommandRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_DEBUG_MODE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.command = this.command;
        r100.debug_mode = this.debug_mode;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CerberusEvaluateCommandRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CerberusEvaluateCommandRequest(String r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CerberusEvaluateCommandRequest(String r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.command = r100;
        this.debug_mode = r101;
    }
}
