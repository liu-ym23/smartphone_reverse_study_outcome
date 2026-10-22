package as_setting;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes28.dex */
public final class FeatureSetting extends Message<FeatureSetting, Builder> {
    public static final ProtoAdapter<FeatureSetting> ADAPTER = null;
    public static final Boolean DEFAULT_IS_ENABLED = null;
    public static final Boolean DEFAULT_IS_TENANT_ENABLED = null;
    private static final long serialVersionUID = 0;
    public final SceneSetting docs_setting;
    public final Boolean is_enabled;
    public final Boolean is_tenant_enabled;
    public final SceneSetting mail_setting;
    public final SceneSetting messenger_setting;

    public static final class Builder extends Message.Builder<FeatureSetting, Builder> {
        public SceneSetting docs_setting;
        public Boolean is_enabled;
        public Boolean is_tenant_enabled;
        public SceneSetting mail_setting;
        public SceneSetting messenger_setting;

        @Override // com.squareup.wire.Message.Builder
        public FeatureSetting build() {
            return new FeatureSetting(this.is_enabled, this.messenger_setting, this.mail_setting, this.docs_setting, this.is_tenant_enabled, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder docs_setting(SceneSetting r100) {
            this.docs_setting = r100;
            return this;
        }

        public Builder is_enabled(Boolean r100) {
            this.is_enabled = r100;
            return this;
        }

        public Builder is_tenant_enabled(Boolean r100) {
            this.is_tenant_enabled = r100;
            return this;
        }

        public Builder mail_setting(SceneSetting r100) {
            this.mail_setting = r100;
            return this;
        }

        public Builder messenger_setting(SceneSetting r100) {
            this.messenger_setting = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FeatureSetting extends ProtoAdapter<FeatureSetting> {
        public ProtoAdapter_FeatureSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, FeatureSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FeatureSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.is_enabled = r102;
            r101.is_tenant_enabled = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L21;
            if (r104 != 1) goto L8;
            r101.is_enabled = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.messenger_setting = SceneSetting.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.mail_setting = SceneSetting.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L14;
            r101.docs_setting = SceneSetting.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r104 != 5) goto L15;
            r101.is_tenant_enabled = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FeatureSetting r100) {
            Boolean r101 = r100.is_enabled;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            SceneSetting r104 = r100.messenger_setting;
            if (r104 == null) goto L9;
            int r105 = SceneSetting.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            SceneSetting r107 = r100.mail_setting;
            if (r107 == null) goto L13;
            int r108 = SceneSetting.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            SceneSetting r110 = r100.docs_setting;
            if (r110 == null) goto L17;
            int r111 = SceneSetting.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.is_tenant_enabled;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ FeatureSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeatureSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeatureSetting r101) throws IOException {
            Boolean r102 = r101.is_enabled;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            SceneSetting r103 = r101.messenger_setting;
            if (r103 == null) goto L8;
            SceneSetting.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            SceneSetting r104 = r101.mail_setting;
            if (r104 == null) goto L11;
            SceneSetting.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            SceneSetting r105 = r101.docs_setting;
            if (r105 == null) goto L14;
            SceneSetting.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.is_tenant_enabled;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeatureSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeatureSetting();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_ENABLED = r100;
        DEFAULT_IS_TENANT_ENABLED = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_enabled = this.is_enabled;
        r100.messenger_setting = this.messenger_setting;
        r100.mail_setting = this.mail_setting;
        r100.docs_setting = this.docs_setting;
        r100.is_tenant_enabled = this.is_tenant_enabled;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeatureSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeatureSetting(Boolean r100, SceneSetting r101, SceneSetting r110, SceneSetting r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public FeatureSetting(Boolean r100, SceneSetting r101, SceneSetting r102, SceneSetting r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.is_enabled = r100;
        this.messenger_setting = r101;
        this.mail_setting = r102;
        this.docs_setting = r103;
        this.is_tenant_enabled = r104;
    }
}
