package ccm_nexus.proto;

import com.bytedance.ee.space.sync.PushRoute$EType;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes28.dex */
public final class FuncParamsX59f4a5708a791818 extends Message<FuncParamsX59f4a5708a791818, Builder> {
    public static final ProtoAdapter<FuncParamsX59f4a5708a791818> ADAPTER = null;
    public static final String DEFAULT_ENTITY_TOKEN = "";
    public static final String DEFAULT_RESOURCE_SUB_TYPE = "";
    public static final String DEFAULT_RESOURCE_TYPE = "";
    public static final String DEFAULT_ROUTE_KEY = "";
    public static final String DEFAULT_ROUTE_TYPE = "";
    public static final Long DEFAULT_USER_ID = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final String entity_token;
    public final MoltenFfiInstanceMsg push_callback;
    public final String resource_sub_type;
    public final String resource_type;
    public final String route_key;
    public final String route_type;
    public final Long user_id;

    public static final class Builder extends Message.Builder<FuncParamsX59f4a5708a791818, Builder> {
        public ByteString _molten_ctx;
        public String entity_token;
        public MoltenFfiInstanceMsg push_callback;
        public String resource_sub_type;
        public String resource_type;
        public String route_key;
        public String route_type;
        public Long user_id;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX59f4a5708a791818 build() {
            Long r100 = this.user_id;
            if (r100 == null) goto L15;
            if (this.entity_token == null) goto L15;
            if (this.resource_type == null) goto L15;
            if (this.route_type == null) goto L15;
            if (this.route_key == null) goto L15;
            return new FuncParamsX59f4a5708a791818(this.user_id, this.entity_token, this.resource_type, this.resource_sub_type, this.route_type, this.route_key, this.push_callback, this._molten_ctx, super.buildUnknownFields());
        L15:
            throw Internal.missingRequiredFields(new Object[]{r100, "user_id", this.entity_token, "entity_token", this.resource_type, "resource_type", this.route_type, PushRoute$EType.KEY_NAME, this.route_key, "route_key"});
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

        public Builder push_callback(MoltenFfiInstanceMsg r100) {
            this.push_callback = r100;
            return this;
        }

        public Builder resource_sub_type(String r100) {
            this.resource_sub_type = r100;
            return this;
        }

        public Builder resource_type(String r100) {
            this.resource_type = r100;
            return this;
        }

        public Builder route_key(String r100) {
            this.route_key = r100;
            return this;
        }

        public Builder route_type(String r100) {
            this.route_type = r100;
            return this;
        }

        public Builder user_id(Long r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX59f4a5708a791818 extends ProtoAdapter<FuncParamsX59f4a5708a791818> {
        public ProtoAdapter_FuncParamsX59f4a5708a791818() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX59f4a5708a791818.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FuncParamsX59f4a5708a791818 decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            if (r103 != 255) goto L7;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L7:
            switch(r103) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                default: goto L8;
            };
        L9:
            r101.push_callback = MoltenFfiInstanceMsg.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.route_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.route_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.resource_sub_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.resource_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.entity_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.user_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L8:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FuncParamsX59f4a5708a791818 r100) {
            int r101 = ProtoAdapter.UINT64.encodedSizeWithTag(1, r100.user_id);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = (r101 + r102.encodedSizeWithTag(2, r100.entity_token)) + r102.encodedSizeWithTag(3, r100.resource_type);
            String r104 = r100.resource_sub_type;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = r102.encodedSizeWithTag(4, r104);
        L6:
            int r107 = ((r103 + r106) + r102.encodedSizeWithTag(5, r100.route_type)) + r102.encodedSizeWithTag(6, r100.route_key);
            MoltenFfiInstanceMsg r108 = r100.push_callback;
            if (r108 == null) goto L9;
            int r109 = MoltenFfiInstanceMsg.ADAPTER.encodedSizeWithTag(7, r108);
        L10:
            int r110 = r107 + r109;
            ByteString r111 = r100._molten_ctx;
            if (r111 == null) goto L14;
            r105 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r111);
        L14:
            return (r110 + r105) + r100.unknownFields().size();
        L9:
            r109 = 0;
            goto L10
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX59f4a5708a791818 decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX59f4a5708a791818 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX59f4a5708a791818 r101) throws IOException {
            ProtoAdapter.UINT64.encodeWithTag(r100, 1, r101.user_id);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.entity_token);
            r102.encodeWithTag(r100, 3, r101.resource_type);
            String r103 = r101.resource_sub_type;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 4, r103);
        L5:
            r102.encodeWithTag(r100, 5, r101.route_type);
            r102.encodeWithTag(r100, 6, r101.route_key);
            MoltenFfiInstanceMsg r104 = r101.push_callback;
            if (r104 == null) goto L8;
            MoltenFfiInstanceMsg.ADAPTER.encodeWithTag(r100, 7, r104);
        L8:
            ByteString r105 = r101._molten_ctx;
            if (r105 == null) goto L11;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX59f4a5708a791818 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX59f4a5708a791818();
        DEFAULT_USER_ID = 0L;
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100.entity_token = this.entity_token;
        r100.resource_type = this.resource_type;
        r100.resource_sub_type = this.resource_sub_type;
        r100.route_type = this.route_type;
        r100.route_key = this.route_key;
        r100.push_callback = this.push_callback;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX59f4a5708a791818.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX59f4a5708a791818(Long r110, String r111, String r112, String r113, String r114, String r115, MoltenFfiInstanceMsg r116, ByteString r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public FuncParamsX59f4a5708a791818(Long r100, String r101, String r102, String r103, String r104, String r105, MoltenFfiInstanceMsg r106, ByteString r107, ByteString r110) {
        super(ADAPTER, r110);
        this.user_id = r100;
        this.entity_token = r101;
        this.resource_type = r102;
        this.resource_sub_type = r103;
        this.route_type = r104;
        this.route_key = r105;
        this.push_callback = r106;
        this._molten_ctx = r107;
    }
}
