package ai.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class MobileComposerSetting extends Message<MobileComposerSetting, Builder> {
    public static final ProtoAdapter<MobileComposerSetting> ADAPTER = null;
    public static final Boolean DEFAULT_IS_DOCS_ENABLED = null;
    public static final Boolean DEFAULT_IS_MAIL_ENABLED = null;
    public static final Boolean DEFAULT_IS_MESSENGER_ENABLED = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_docs_enabled;
    public final Boolean is_mail_enabled;
    public final Boolean is_messenger_enabled;

    public static final class Builder extends Message.Builder<MobileComposerSetting, Builder> {
        public Boolean is_docs_enabled;
        public Boolean is_mail_enabled;
        public Boolean is_messenger_enabled;

        @Override // com.squareup.wire.Message.Builder
        public MobileComposerSetting build() {
            return new MobileComposerSetting(this.is_messenger_enabled, this.is_docs_enabled, this.is_mail_enabled, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_docs_enabled(Boolean r100) {
            this.is_docs_enabled = r100;
            return this;
        }

        public Builder is_mail_enabled(Boolean r100) {
            this.is_mail_enabled = r100;
            return this;
        }

        public Builder is_messenger_enabled(Boolean r100) {
            this.is_messenger_enabled = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MobileComposerSetting extends ProtoAdapter<MobileComposerSetting> {
        public ProtoAdapter_MobileComposerSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, MobileComposerSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MobileComposerSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.is_messenger_enabled = r102;
            r101.is_docs_enabled = r102;
            r101.is_mail_enabled = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L15;
            if (r104 != 1) goto L8;
            r101.is_messenger_enabled = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.is_docs_enabled = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L11;
            r101.is_mail_enabled = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MobileComposerSetting r100) {
            Boolean r101 = r100.is_messenger_enabled;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.is_docs_enabled;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.is_mail_enabled;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ MobileComposerSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MobileComposerSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MobileComposerSetting r101) throws IOException {
            Boolean r102 = r101.is_messenger_enabled;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.is_docs_enabled;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.is_mail_enabled;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MobileComposerSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MobileComposerSetting();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_MESSENGER_ENABLED = r100;
        DEFAULT_IS_DOCS_ENABLED = r100;
        DEFAULT_IS_MAIL_ENABLED = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_messenger_enabled = this.is_messenger_enabled;
        r100.is_docs_enabled = this.is_docs_enabled;
        r100.is_mail_enabled = this.is_mail_enabled;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MobileComposerSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MobileComposerSetting(Boolean r100, Boolean r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public MobileComposerSetting(Boolean r100, Boolean r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.is_messenger_enabled = r100;
        this.is_docs_enabled = r101;
        this.is_mail_enabled = r102;
    }
}
