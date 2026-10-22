package ai.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class ComposerSetting extends Message<ComposerSetting, Builder> {
    public static final ProtoAdapter<ComposerSetting> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_PERSONALIZE = null;
    public static final Boolean DEFAULT_IS_DOCS_ENABLED = null;
    public static final Boolean DEFAULT_IS_ENABLED = null;
    public static final Boolean DEFAULT_IS_MAIL_ENABLED = null;
    public static final Boolean DEFAULT_IS_MESSENGER_ENABLED = null;
    public static final Integer DEFAULT_TRIGGER_DELAY_MS = null;
    private static final long serialVersionUID = 0;
    public final Boolean can_personalize;
    public final Boolean is_docs_enabled;
    public final Boolean is_enabled;
    public final Boolean is_mail_enabled;
    public final Boolean is_messenger_enabled;
    public final Integer trigger_delay_ms;

    public static final class Builder extends Message.Builder<ComposerSetting, Builder> {
        public Boolean can_personalize;
        public Boolean is_docs_enabled;
        public Boolean is_enabled;
        public Boolean is_mail_enabled;
        public Boolean is_messenger_enabled;
        public Integer trigger_delay_ms;

        @Override // com.squareup.wire.Message.Builder
        public ComposerSetting build() {
            return new ComposerSetting(this.is_enabled, this.can_personalize, this.trigger_delay_ms, this.is_messenger_enabled, this.is_docs_enabled, this.is_mail_enabled, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder can_personalize(Boolean r100) {
            this.can_personalize = r100;
            return this;
        }

        public Builder is_docs_enabled(Boolean r100) {
            this.is_docs_enabled = r100;
            return this;
        }

        public Builder is_enabled(Boolean r100) {
            this.is_enabled = r100;
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

        public Builder trigger_delay_ms(Integer r100) {
            this.trigger_delay_ms = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ComposerSetting extends ProtoAdapter<ComposerSetting> {
        public ProtoAdapter_ComposerSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, ComposerSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ComposerSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.is_enabled = r102;
            r101.can_personalize = r102;
            r101.trigger_delay_ms = 100;
            r101.is_messenger_enabled = r102;
            r101.is_docs_enabled = r102;
            r101.is_mail_enabled = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L13;
            switch(r104) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.is_mail_enabled = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.is_docs_enabled = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.is_messenger_enabled = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.trigger_delay_ms = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.can_personalize = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.is_enabled = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ComposerSetting r100) {
            Boolean r101 = r100.is_enabled;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.can_personalize;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.trigger_delay_ms;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.is_messenger_enabled;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.is_docs_enabled;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.is_mail_enabled;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ComposerSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ComposerSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ComposerSetting r101) throws IOException {
            Boolean r102 = r101.is_enabled;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.can_personalize;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.trigger_delay_ms;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.is_messenger_enabled;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.is_docs_enabled;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.is_mail_enabled;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ComposerSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ComposerSetting();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_ENABLED = r100;
        DEFAULT_CAN_PERSONALIZE = r100;
        DEFAULT_TRIGGER_DELAY_MS = 100;
        DEFAULT_IS_MESSENGER_ENABLED = r100;
        DEFAULT_IS_DOCS_ENABLED = r100;
        DEFAULT_IS_MAIL_ENABLED = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_enabled = this.is_enabled;
        r100.can_personalize = this.can_personalize;
        r100.trigger_delay_ms = this.trigger_delay_ms;
        r100.is_messenger_enabled = this.is_messenger_enabled;
        r100.is_docs_enabled = this.is_docs_enabled;
        r100.is_mail_enabled = this.is_mail_enabled;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ComposerSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ComposerSetting(Boolean r100, Boolean r110, Integer r111, Boolean r112, Boolean r113, Boolean r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public ComposerSetting(Boolean r100, Boolean r101, Integer r102, Boolean r103, Boolean r104, Boolean r105, ByteString r106) {
        super(ADAPTER, r106);
        this.is_enabled = r100;
        this.can_personalize = r101;
        this.trigger_delay_ms = r102;
        this.is_messenger_enabled = r103;
        this.is_docs_enabled = r104;
        this.is_mail_enabled = r105;
    }
}
