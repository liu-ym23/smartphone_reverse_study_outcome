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
public final class PushComposerSetting extends Message<PushComposerSetting, Builder> {
    public static final ProtoAdapter<PushComposerSetting> ADAPTER = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final ProtoAdapter_PushComposerSetting RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ComposerSetting composer_setting;
    public final Long update_time;

    public static final class Builder extends Message.Builder<PushComposerSetting, Builder> implements d<PushComposerSetting> {
        public ComposerSetting composer_setting;
        public Long update_time;

        @Override // com.squareup.wire.Message.Builder
        public PushComposerSetting build() {
            return new PushComposerSetting(this.composer_setting, this.update_time, super.buildUnknownFields());
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

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushComposerSetting extends ProtoAdapter<PushComposerSetting> implements c<PushComposerSetting> {
        public ProtoAdapter_PushComposerSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, PushComposerSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushComposerSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.update_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.composer_setting = ComposerSetting.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.update_time = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(PushComposerSetting r100) {
            ComposerSetting r101 = r100.composer_setting;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ComposerSetting.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.update_time;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushComposerSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushComposerSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushComposerSetting r101) throws IOException {
            ComposerSetting r102 = r101.composer_setting;
            if (r102 == null) goto L5;
            ComposerSetting.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.update_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushComposerSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushComposerSetting r100 = new ProtoAdapter_PushComposerSetting();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_UPDATE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.composer_setting = this.composer_setting;
        r100.update_time = this.update_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushComposerSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushComposerSetting(ComposerSetting r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PushComposerSetting(ComposerSetting r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.composer_setting = r100;
        this.update_time = r101;
    }
}
