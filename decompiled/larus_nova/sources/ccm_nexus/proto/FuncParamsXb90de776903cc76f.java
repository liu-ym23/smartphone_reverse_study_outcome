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
public final class FuncParamsXb90de776903cc76f extends Message<FuncParamsXb90de776903cc76f, Builder> {
    public static final ProtoAdapter<FuncParamsXb90de776903cc76f> ADAPTER = null;
    public static final String DEFAULT_ENTITY_TOKEN = "";
    public static final Long DEFAULT_OBJ_TYPE = null;
    public static final Long DEFAULT_USER_ID = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final String entity_token;
    public final Long obj_type;
    public final MoltenFfiInstanceMsg push_callback;
    public final Long user_id;

    public static final class Builder extends Message.Builder<FuncParamsXb90de776903cc76f, Builder> {
        public ByteString _molten_ctx;
        public String entity_token;
        public Long obj_type;
        public MoltenFfiInstanceMsg push_callback;
        public Long user_id;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsXb90de776903cc76f build() {
            Long r100 = this.user_id;
            if (r100 == null) goto L11;
            if (this.entity_token == null) goto L11;
            if (this.obj_type == null) goto L11;
            return new FuncParamsXb90de776903cc76f(this.user_id, this.entity_token, this.obj_type, this.push_callback, this._molten_ctx, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "user_id", this.entity_token, "entity_token", this.obj_type, "obj_type"});
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

        public Builder entity_token(String r100) {
            this.entity_token = r100;
            return this;
        }

        public Builder obj_type(Long r100) {
            this.obj_type = r100;
            return this;
        }

        public Builder push_callback(MoltenFfiInstanceMsg r100) {
            this.push_callback = r100;
            return this;
        }

        public Builder user_id(Long r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsXb90de776903cc76f extends ProtoAdapter<FuncParamsXb90de776903cc76f> {
        public ProtoAdapter_FuncParamsXb90de776903cc76f() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsXb90de776903cc76f.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FuncParamsXb90de776903cc76f decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.user_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.entity_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.obj_type = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.push_callback = MoltenFfiInstanceMsg.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 255) goto L15;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsXb90de776903cc76f r100) {
            int r101 = (ProtoAdapter.UINT64.encodedSizeWithTag(1, r100.user_id) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.entity_token)) + ProtoAdapter.INT64.encodedSizeWithTag(3, r100.obj_type);
            MoltenFfiInstanceMsg r102 = r100.push_callback;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = MoltenFfiInstanceMsg.ADAPTER.encodedSizeWithTag(4, r102);
        L6:
            int r105 = r101 + r104;
            ByteString r106 = r100._molten_ctx;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsXb90de776903cc76f decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsXb90de776903cc76f r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsXb90de776903cc76f r101) throws IOException {
            ProtoAdapter.UINT64.encodeWithTag(r100, 1, r101.user_id);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.entity_token);
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r101.obj_type);
            MoltenFfiInstanceMsg r102 = r101.push_callback;
            if (r102 == null) goto L5;
            MoltenFfiInstanceMsg.ADAPTER.encodeWithTag(r100, 4, r102);
        L5:
            ByteString r103 = r101._molten_ctx;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsXb90de776903cc76f r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsXb90de776903cc76f();
        DEFAULT_USER_ID = 0L;
        DEFAULT_OBJ_TYPE = 0L;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100.entity_token = this.entity_token;
        r100.obj_type = this.obj_type;
        r100.push_callback = this.push_callback;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsXb90de776903cc76f.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsXb90de776903cc76f(Long r100, String r101, Long r110, MoltenFfiInstanceMsg r111, ByteString r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public FuncParamsXb90de776903cc76f(Long r100, String r101, Long r102, MoltenFfiInstanceMsg r103, ByteString r104, ByteString r105) {
        super(ADAPTER, r105);
        this.user_id = r100;
        this.entity_token = r101;
        this.obj_type = r102;
        this.push_callback = r103;
        this._molten_ctx = r104;
    }
}
