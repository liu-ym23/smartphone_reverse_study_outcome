package ccm_nexus.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes28.dex */
public final class FuncParamsXb3ce1a48a9c21ec4 extends Message<FuncParamsXb3ce1a48a9c21ec4, Builder> {
    public static final ProtoAdapter<FuncParamsXb3ce1a48a9c21ec4> ADAPTER = null;
    public static final Long DEFAULT_USER_ID = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final Long user_id;

    public static final class Builder extends Message.Builder<FuncParamsXb3ce1a48a9c21ec4, Builder> {
        public ByteString _molten_ctx;
        public Long user_id;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXb3ce1a48a9c21ec4 build() {
            Long r100 = this.user_id;
            if (r100 == null) goto L7;
            return new FuncParamsXb3ce1a48a9c21ec4(this.user_id, this._molten_ctx, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "user_id"});
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

        public Builder user_id(Long r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXb3ce1a48a9c21ec4 extends ProtoAdapter<FuncParamsXb3ce1a48a9c21ec4> {
        public ProtoAdapter_FuncParamsXb3ce1a48a9c21ec4() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXb3ce1a48a9c21ec4.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FuncParamsXb3ce1a48a9c21ec4 decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.user_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L8:
            if (r103 != 255) goto L9;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
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
        public int encodedSize2(FuncParamsXb3ce1a48a9c21ec4 r100) {
            int r101 = ProtoAdapter.UINT64.encodedSizeWithTag(1, r100.user_id);
            ByteString r102 = r100._molten_ctx;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXb3ce1a48a9c21ec4 decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXb3ce1a48a9c21ec4 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXb3ce1a48a9c21ec4 r101) throws IOException {
            ProtoAdapter.UINT64.encodeWithTag(r100, 1, r101.user_id);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXb3ce1a48a9c21ec4 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXb3ce1a48a9c21ec4();
        DEFAULT_USER_ID = 0L;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXb3ce1a48a9c21ec4.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXb3ce1a48a9c21ec4(Long r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FuncParamsXb3ce1a48a9c21ec4(Long r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.user_id = r100;
        this._molten_ctx = r101;
    }
}
