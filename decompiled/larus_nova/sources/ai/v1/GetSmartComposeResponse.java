package ai.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes2.dex */
public final class GetSmartComposeResponse extends Message<GetSmartComposeResponse, Builder> {
    public static final ProtoAdapter<GetSmartComposeResponse> ADAPTER = null;
    public static final Boolean DEFAULT_FORCE_DISPLAY = null;
    public static final String DEFAULT_HIDDEN_STATE = "";
    public static final String DEFAULT_LANGUAGE = "";
    public static final Integer DEFAULT_MIN_DISPLAY_CHAR_LEN = null;
    public static final Integer DEFAULT_VID = null;
    public static final ProtoAdapter_GetSmartComposeResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean force_display;
    public final String hidden_state;
    public final String language;
    public final Integer min_display_char_len;
    public final List<SuggestionItem> suggestion;
    public final Integer vid;

    public static final class Builder extends Message.Builder<GetSmartComposeResponse, Builder> implements d<GetSmartComposeResponse> {
        public Boolean force_display;
        public String hidden_state;
        public String language;
        public Integer min_display_char_len;
        public List<SuggestionItem> suggestion;
        public Integer vid;

        @Override // com.squareup.wire.Message.Builder
        public GetSmartComposeResponse build() {
            return new GetSmartComposeResponse(this.hidden_state, this.suggestion, this.vid, this.language, this.force_display, this.min_display_char_len, super.buildUnknownFields());
        }

        public Builder() {
            this.suggestion = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder force_display(Boolean r100) {
            this.force_display = r100;
            return this;
        }

        public Builder hidden_state(String r100) {
            this.hidden_state = r100;
            return this;
        }

        public Builder language(String r100) {
            this.language = r100;
            return this;
        }

        public Builder min_display_char_len(Integer r100) {
            this.min_display_char_len = r100;
            return this;
        }

        public Builder suggestion(List<SuggestionItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.suggestion = r100;
            return this;
        }

        public Builder vid(Integer r100) {
            this.vid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSmartComposeResponse extends ProtoAdapter<GetSmartComposeResponse> implements c<GetSmartComposeResponse> {
        public ProtoAdapter_GetSmartComposeResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSmartComposeResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetSmartComposeResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.hidden_state = "";
            r101.vid = 0;
            r101.language = "";
            r101.force_display = Boolean.FALSE;
            r101.min_display_char_len = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.min_display_char_len = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            r101.force_display = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.vid = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.suggestion.add(SuggestionItem.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.hidden_state = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetSmartComposeResponse r100) {
            String r101 = r100.hidden_state;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + SuggestionItem.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.suggestion);
            Integer r105 = r100.vid;
            if (r105 == null) goto L9;
            int r106 = ProtoAdapter.INT32.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            String r108 = r100.language;
            if (r108 == null) goto L13;
            int r109 = ProtoAdapter.STRING.encodedSizeWithTag(4, r108);
        L14:
            int r110 = r107 + r109;
            Boolean r111 = r100.force_display;
            if (r111 == null) goto L17;
            int r112 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r111);
        L18:
            int r113 = r110 + r112;
            Integer r114 = r100.min_display_char_len;
            if (r114 == null) goto L22;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(6, r114);
        L22:
            return (r113 + r102) + r100.unknownFields().size();
        L17:
            r112 = 0;
            goto L18
        L13:
            r109 = 0;
            goto L14
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetSmartComposeResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetSmartComposeResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetSmartComposeResponse r101) throws IOException {
            String r102 = r101.hidden_state;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            SuggestionItem.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.suggestion);
            Integer r103 = r101.vid;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r103);
        L8:
            String r104 = r101.language;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
        L11:
            Boolean r105 = r101.force_display;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
        L14:
            Integer r106 = r101.min_display_char_len;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetSmartComposeResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetSmartComposeResponse r100 = new ProtoAdapter_GetSmartComposeResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_VID = 0;
        DEFAULT_FORCE_DISPLAY = Boolean.FALSE;
        DEFAULT_MIN_DISPLAY_CHAR_LEN = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.hidden_state = this.hidden_state;
        r100.suggestion = Internal.copyOf("suggestion", this.suggestion);
        r100.vid = this.vid;
        r100.language = this.language;
        r100.force_display = this.force_display;
        r100.min_display_char_len = this.min_display_char_len;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetSmartComposeResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetSmartComposeResponse(String r100, List<SuggestionItem> r110, Integer r111, String r112, Boolean r113, Integer r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public GetSmartComposeResponse(String r100, List<SuggestionItem> r101, Integer r102, String r103, Boolean r104, Integer r105, ByteString r106) {
        super(ADAPTER, r106);
        this.hidden_state = r100;
        this.suggestion = Internal.immutableCopyOf("suggestion", r101);
        this.vid = r102;
        this.language = r103;
        this.force_display = r104;
        this.min_display_char_len = r105;
    }
}
