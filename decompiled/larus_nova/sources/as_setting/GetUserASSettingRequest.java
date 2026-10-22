package as_setting;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes28.dex */
public final class GetUserASSettingRequest extends Message<GetUserASSettingRequest, Builder> {
    public static final ProtoAdapter<GetUserASSettingRequest> ADAPTER = null;
    public static final FeatureType DEFAULT_FEATURE_TYPE = null;
    public static final ProtoAdapter_GetUserASSettingRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final FeatureType feature_type;

    public static final class Builder extends Message.Builder<GetUserASSettingRequest, Builder> implements d<GetUserASSettingRequest> {
        public FeatureType feature_type;

        @Override // com.squareup.wire.Message.Builder
        public GetUserASSettingRequest build() {
            FeatureType r100 = this.feature_type;
            if (r100 == null) goto L7;
            return new GetUserASSettingRequest(this.feature_type, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "feature_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder feature_type(FeatureType r100) {
            this.feature_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUserASSettingRequest extends ProtoAdapter<GetUserASSettingRequest> implements c<GetUserASSettingRequest> {
        public ProtoAdapter_GetUserASSettingRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUserASSettingRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUserASSettingRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.feature_type = FeatureType.DEFAULT;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.feature_type = FeatureType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetUserASSettingRequest r100) {
            return FeatureType.ADAPTER.encodedSizeWithTag(1, r100.feature_type) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUserASSettingRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUserASSettingRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUserASSettingRequest r101) throws IOException {
            FeatureType.ADAPTER.encodeWithTag(r100, 1, r101.feature_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUserASSettingRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUserASSettingRequest r100 = new ProtoAdapter_GetUserASSettingRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_FEATURE_TYPE = FeatureType.DEFAULT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.feature_type = this.feature_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUserASSettingRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUserASSettingRequest(FeatureType r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetUserASSettingRequest(FeatureType r100, ByteString r101) {
        super(ADAPTER, r101);
        this.feature_type = r100;
    }
}
