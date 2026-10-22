package ai.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes2.dex */
public final class GetComposerSettingResponse extends Message<GetComposerSettingResponse, Builder> {
    public static final ProtoAdapter<GetComposerSettingResponse> ADAPTER = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final ProtoAdapter_GetComposerSettingResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ComposerSetting composer_setting;
    public final MobileComposerSetting mobile_composer_setting;
    public final Long update_time;

    public static final class Builder extends Message.Builder<GetComposerSettingResponse, Builder> implements d<GetComposerSettingResponse> {
        public ComposerSetting composer_setting;
        public MobileComposerSetting mobile_composer_setting;
        public Long update_time;

        @Override // com.squareup.wire.Message.Builder
        public GetComposerSettingResponse build() {
            return new GetComposerSettingResponse(this.composer_setting, this.update_time, this.mobile_composer_setting, super.buildUnknownFields());
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

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetComposerSettingResponse extends ProtoAdapter<GetComposerSettingResponse> implements c<GetComposerSettingResponse> {
        public ProtoAdapter_GetComposerSettingResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetComposerSettingResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetComposerSettingResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.update_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.composer_setting = ComposerSetting.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mobile_composer_setting = MobileComposerSetting.ADAPTER.decode(r100);
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
        public int encodedSize2(GetComposerSettingResponse r100) {
            ComposerSetting r101 = r100.composer_setting;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ComposerSetting.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.update_time;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            MobileComposerSetting r107 = r100.mobile_composer_setting;
            if (r107 == null) goto L14;
            r102 = MobileComposerSetting.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetComposerSettingResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetComposerSettingResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetComposerSettingResponse r101) throws IOException {
            ComposerSetting r102 = r101.composer_setting;
            if (r102 == null) goto L5;
            ComposerSetting.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.update_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            MobileComposerSetting r104 = r101.mobile_composer_setting;
            if (r104 == null) goto L11;
            MobileComposerSetting.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetComposerSettingResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetComposerSettingResponse r100 = new ProtoAdapter_GetComposerSettingResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_UPDATE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.composer_setting = this.composer_setting;
        r100.update_time = this.update_time;
        r100.mobile_composer_setting = this.mobile_composer_setting;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetComposerSettingResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetComposerSettingResponse(ComposerSetting r100, Long r101, MobileComposerSetting r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetComposerSettingResponse(ComposerSetting r100, Long r101, MobileComposerSetting r102, ByteString r103) {
        super(ADAPTER, r103);
        this.composer_setting = r100;
        this.update_time = r101;
        this.mobile_composer_setting = r102;
    }
}
