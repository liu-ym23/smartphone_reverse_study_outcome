package as_setting;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes28.dex */
public final class UserASSetting extends Message<UserASSetting, Builder> {
    public static final ProtoAdapter<UserASSetting> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final FeatureSetting nautilus_setting;

    public static final class Builder extends Message.Builder<UserASSetting, Builder> {
        public FeatureSetting nautilus_setting;

        @Override // com.squareup.wire.Message.Builder
        public UserASSetting build() {
            return new UserASSetting(this.nautilus_setting, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder nautilus_setting(FeatureSetting r100) {
            this.nautilus_setting = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserASSetting extends ProtoAdapter<UserASSetting> {
        public ProtoAdapter_UserASSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, UserASSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserASSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.nautilus_setting = FeatureSetting.ADAPTER.decode(r100);
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
        public int encodedSize2(UserASSetting r100) {
            FeatureSetting r101 = r100.nautilus_setting;
            if (r101 == null) goto L5;
            int r102 = FeatureSetting.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UserASSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserASSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserASSetting r101) throws IOException {
            FeatureSetting r102 = r101.nautilus_setting;
            if (r102 == null) goto L5;
            FeatureSetting.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserASSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserASSetting();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.nautilus_setting = this.nautilus_setting;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserASSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserASSetting(FeatureSetting r100) {
        this(r100, ByteString.EMPTY);
    }

    public UserASSetting(FeatureSetting r100, ByteString r101) {
        super(ADAPTER, r101);
        this.nautilus_setting = r100;
    }
}
