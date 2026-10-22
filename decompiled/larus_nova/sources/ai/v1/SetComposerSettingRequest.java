package ai.v1;

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

/* JADX INFO: loaded from: classes2.dex */
public final class SetComposerSettingRequest extends Message<SetComposerSettingRequest, Builder> {
    public static final ProtoAdapter<SetComposerSettingRequest> ADAPTER = null;
    public static final ProtoAdapter_SetComposerSettingRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ComposerSetting composer_setting;
    public final MobileComposerSetting mobile_composer_setting;

    public static final class Builder extends Message.Builder<SetComposerSettingRequest, Builder> implements d<SetComposerSettingRequest> {
        public ComposerSetting composer_setting;
        public MobileComposerSetting mobile_composer_setting;

        @Override // com.squareup.wire.Message.Builder
        public SetComposerSettingRequest build() {
            ComposerSetting r100 = this.composer_setting;
            if (r100 == null) goto L7;
            return new SetComposerSettingRequest(this.composer_setting, this.mobile_composer_setting, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "composer_setting"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder composer_setting(ComposerSetting r100) {
            this.composer_setting = r100;
            return this;
        }

        public Builder mobile_composer_setting(MobileComposerSetting r100) {
            this.mobile_composer_setting = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetComposerSettingRequest extends ProtoAdapter<SetComposerSettingRequest> implements c<SetComposerSettingRequest> {
        public ProtoAdapter_SetComposerSettingRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetComposerSettingRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetComposerSettingRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.composer_setting = ComposerSetting.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mobile_composer_setting = MobileComposerSetting.ADAPTER.decode(r100);
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
        public int encodedSize2(SetComposerSettingRequest r100) {
            int r101 = ComposerSetting.ADAPTER.encodedSizeWithTag(1, r100.composer_setting);
            MobileComposerSetting r102 = r100.mobile_composer_setting;
            if (r102 == null) goto L5;
            int r103 = MobileComposerSetting.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetComposerSettingRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetComposerSettingRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetComposerSettingRequest r101) throws IOException {
            ComposerSetting.ADAPTER.encodeWithTag(r100, 1, r101.composer_setting);
            MobileComposerSetting r102 = r101.mobile_composer_setting;
            if (r102 == null) goto L5;
            MobileComposerSetting.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetComposerSettingRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetComposerSettingRequest r100 = new ProtoAdapter_SetComposerSettingRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.composer_setting = this.composer_setting;
        r100.mobile_composer_setting = this.mobile_composer_setting;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetComposerSettingRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetComposerSettingRequest(ComposerSetting r100, MobileComposerSetting r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SetComposerSettingRequest(ComposerSetting r100, MobileComposerSetting r101, ByteString r102) {
        super(ADAPTER, r102);
        this.composer_setting = r100;
        this.mobile_composer_setting = r101;
    }
}
