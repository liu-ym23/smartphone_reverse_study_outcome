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
public final class GetUserASSettingResponse extends Message<GetUserASSettingResponse, Builder> {
    public static final ProtoAdapter<GetUserASSettingResponse> ADAPTER = null;
    public static final ProtoAdapter_GetUserASSettingResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final UserASSetting setting;

    public static final class Builder extends Message.Builder<GetUserASSettingResponse, Builder> implements d<GetUserASSettingResponse> {
        public UserASSetting setting;

        @Override // com.squareup.wire.Message.Builder
        public GetUserASSettingResponse build() {
            UserASSetting r100 = this.setting;
            if (r100 == null) goto L7;
            return new GetUserASSettingResponse(this.setting, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "setting"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder setting(UserASSetting r100) {
            this.setting = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUserASSettingResponse extends ProtoAdapter<GetUserASSettingResponse> implements c<GetUserASSettingResponse> {
        public ProtoAdapter_GetUserASSettingResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUserASSettingResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUserASSettingResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.setting = UserASSetting.ADAPTER.decode(r100);
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
        public int encodedSize2(GetUserASSettingResponse r100) {
            return UserASSetting.ADAPTER.encodedSizeWithTag(1, r100.setting) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUserASSettingResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUserASSettingResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUserASSettingResponse r101) throws IOException {
            UserASSetting.ADAPTER.encodeWithTag(r100, 1, r101.setting);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUserASSettingResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUserASSettingResponse r100 = new ProtoAdapter_GetUserASSettingResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.setting = this.setting;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUserASSettingResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUserASSettingResponse(UserASSetting r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetUserASSettingResponse(UserASSetting r100, ByteString r101) {
        super(ADAPTER, r101);
        this.setting = r100;
    }
}
