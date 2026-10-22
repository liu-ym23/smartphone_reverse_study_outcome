package ai.v1;

import com.bytedance.lark.pb.basic.v1.RichText;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class ContextItem extends Message<ContextItem, Builder> {
    public static final ProtoAdapter<ContextItem> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_FROM_ID = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_MESSAGE_LANGUAGE = "";
    public static final com.bytedance.lark.pb.basic.v1.Message.Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String content;
    public final Long create_time;
    public final String from_id;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f3714id;
    public final String message_language;
    public final RichText rich_text;
    public final com.bytedance.lark.pb.basic.v1.Message.Type type;

    public static final class Builder extends Message.Builder<ContextItem, Builder> {
        public String content;
        public Long create_time;
        public String from_id;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f3715id;
        public String message_language;
        public RichText rich_text;
        public com.bytedance.lark.pb.basic.v1.Message.Type type;

        @Override // com.squareup.wire.Message.Builder
        public ContextItem build() {
            return new ContextItem(this.f3715id, this.type, this.from_id, this.create_time, this.message_language, this.content, this.rich_text, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder content(String r100) {
            this.content = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder from_id(String r100) {
            this.from_id = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f3715id = r100;
            return this;
        }

        public Builder message_language(String r100) {
            this.message_language = r100;
            return this;
        }

        public Builder rich_text(RichText r100) {
            this.rich_text = r100;
            return this;
        }

        public Builder type(com.bytedance.lark.pb.basic.v1.Message.Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ContextItem extends ProtoAdapter<ContextItem> {
        public ProtoAdapter_ContextItem() {
            super(FieldEncoding.LENGTH_DELIMITED, ContextItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ContextItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f3715id = "";
            r101.type = com.bytedance.lark.pb.basic.v1.Message.Type.UNKNOWN;
            r101.from_id = "";
            r101.create_time = 0L;
            r101.message_language = "";
            r101.content = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L19;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r101.type = com.bytedance.lark.pb.basic.v1.Message.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.rich_text = RichText.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.message_language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.from_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.f3715id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ContextItem r100) {
            String r101 = r100.f3714id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            com.bytedance.lark.pb.basic.v1.Message.Type r104 = r100.type;
            if (r104 == null) goto L9;
            int r105 = com.bytedance.lark.pb.basic.v1.Message.Type.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.from_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.create_time;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.message_language;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.content;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            RichText r119 = r100.rich_text;
            if (r119 == null) goto L30;
            r102 = RichText.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ContextItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ContextItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ContextItem r101) throws IOException {
            String r102 = r101.f3714id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            com.bytedance.lark.pb.basic.v1.Message.Type r103 = r101.type;
            if (r103 == null) goto L8;
            com.bytedance.lark.pb.basic.v1.Message.Type.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.from_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.create_time;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.message_language;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.content;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            RichText r108 = r101.rich_text;
            if (r108 == null) goto L23;
            RichText.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContextItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ContextItem();
        DEFAULT_TYPE = com.bytedance.lark.pb.basic.v1.Message.Type.UNKNOWN;
        DEFAULT_CREATE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f3715id = this.f3714id;
        r100.type = this.type;
        r100.from_id = this.from_id;
        r100.create_time = this.create_time;
        r100.message_language = this.message_language;
        r100.content = this.content;
        r100.rich_text = this.rich_text;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ContextItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ContextItem(String r110, com.bytedance.lark.pb.basic.v1.Message.Type r111, String r112, Long r113, String r114, String r115, RichText r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public ContextItem(String r100, com.bytedance.lark.pb.basic.v1.Message.Type r101, String r102, Long r103, String r104, String r105, RichText r106, ByteString r107) {
        super(ADAPTER, r107);
        this.f3714id = r100;
        this.type = r101;
        this.from_id = r102;
        this.create_time = r103;
        this.message_language = r104;
        this.content = r105;
        this.rich_text = r106;
    }
}
