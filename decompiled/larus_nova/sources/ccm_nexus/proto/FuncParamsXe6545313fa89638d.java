package ccm_nexus.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes28.dex */
public final class FuncParamsXe6545313fa89638d extends Message<FuncParamsXe6545313fa89638d, Builder> {
    public static final ProtoAdapter<FuncParamsXe6545313fa89638d> ADAPTER = null;
    public static final String DEFAULT_MODULE = "";
    public static final String DEFAULT_RAW_DATA = "";
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final String module;
    public final String raw_data;

    public static final class Builder extends Message.Builder<FuncParamsXe6545313fa89638d, Builder> {
        public ByteString _molten_ctx;
        public String module;
        public String raw_data;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXe6545313fa89638d build() {
            String r100 = this.raw_data;
            if (r100 == null) goto L7;
            return new FuncParamsXe6545313fa89638d(this.module, this.raw_data, this._molten_ctx, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, EventConstant.Key.RAW_DATA});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder _molten_ctx(ByteString r100) {
            this._molten_ctx = r100;
            return this;
        }

        public Builder module(String r100) {
            this.module = r100;
            return this;
        }

        public Builder raw_data(String r100) {
            this.raw_data = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXe6545313fa89638d extends ProtoAdapter<FuncParamsXe6545313fa89638d> {
        public ProtoAdapter_FuncParamsXe6545313fa89638d() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXe6545313fa89638d.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FuncParamsXe6545313fa89638d decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.module = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.raw_data = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 255) goto L11;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsXe6545313fa89638d r100) {
            String r101 = r100.module;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.raw_data);
            ByteString r105 = r100._molten_ctx;
            if (r105 == null) goto L10;
            r102 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXe6545313fa89638d decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXe6545313fa89638d r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXe6545313fa89638d r101) throws IOException {
            String r102 = r101.module;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.raw_data);
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXe6545313fa89638d r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXe6545313fa89638d();
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.module = this.module;
        r100.raw_data = this.raw_data;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXe6545313fa89638d.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXe6545313fa89638d(String r100, String r101, ByteString r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FuncParamsXe6545313fa89638d(String r100, String r101, ByteString r102, ByteString r103) {
        super(ADAPTER, r103);
        this.module = r100;
        this.raw_data = r101;
        this._molten_ctx = r102;
    }
}
