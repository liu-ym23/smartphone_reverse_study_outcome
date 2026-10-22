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
public final class PushUserASSetting extends Message<PushUserASSetting, Builder> {
    public static final ProtoAdapter<PushUserASSetting> ADAPTER = null;
    public static final FeatureType DEFAULT_FEATURE_TYPE = null;
    public static final ProtoAdapter_PushUserASSetting RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final FeatureType feature_type;
    public final UserASSetting setting;

    public static final class Builder extends Message.Builder<PushUserASSetting, Builder> implements d<PushUserASSetting> {
        public FeatureType feature_type;
        public UserASSetting setting;

        @Override // com.squareup.wire.Message.Builder
        public PushUserASSetting build() {
            UserASSetting r100 = this.setting;
            if (r100 == null) goto L9;
            if (this.feature_type == null) goto L9;
            return new PushUserASSetting(this.setting, this.feature_type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "setting", this.feature_type, "feature_type"});
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

        public Builder setting(UserASSetting r100) {
            this.setting = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushUserASSetting extends ProtoAdapter<PushUserASSetting> implements c<PushUserASSetting> {
        public ProtoAdapter_PushUserASSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, PushUserASSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushUserASSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.feature_type = FeatureType.DEFAULT;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.setting = UserASSetting.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.feature_type = FeatureType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushUserASSetting r100) {
            return (UserASSetting.ADAPTER.encodedSizeWithTag(1, r100.setting) + FeatureType.ADAPTER.encodedSizeWithTag(2, r100.feature_type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushUserASSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushUserASSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushUserASSetting r101) throws IOException {
            UserASSetting.ADAPTER.encodeWithTag(r100, 1, r101.setting);
            FeatureType.ADAPTER.encodeWithTag(r100, 2, r101.feature_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushUserASSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushUserASSetting r100 = new ProtoAdapter_PushUserASSetting();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_FEATURE_TYPE = FeatureType.DEFAULT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.setting = this.setting;
        r100.feature_type = this.feature_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushUserASSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushUserASSetting(UserASSetting r100, FeatureType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PushUserASSetting(UserASSetting r100, FeatureType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.setting = r100;
        this.feature_type = r101;
    }
}
