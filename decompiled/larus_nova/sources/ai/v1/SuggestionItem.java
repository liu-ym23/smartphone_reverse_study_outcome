package ai.v1;

import androidx.camera.video.AudioStats;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class SuggestionItem extends Message<SuggestionItem, Builder> {
    public static final ProtoAdapter<SuggestionItem> ADAPTER = null;
    public static final Double DEFAULT_CONFIDENCE = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_REASON = "";
    public static final String DEFAULT_SUGGESTION = "";
    private static final long serialVersionUID = 0;
    public final Double confidence;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f3716id;
    public final String reason;
    public final String suggestion;

    public static final class Builder extends Message.Builder<SuggestionItem, Builder> {
        public Double confidence;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f3717id;
        public String reason;
        public String suggestion;

        @Override // com.squareup.wire.Message.Builder
        public SuggestionItem build() {
            String r100 = this.suggestion;
            if (r100 == null) goto L9;
            if (this.f3717id == null) goto L9;
            return new SuggestionItem(this.suggestion, this.f3717id, this.confidence, this.reason, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "suggestion", this.f3717id, "id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder confidence(Double r100) {
            this.confidence = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f3717id = r100;
            return this;
        }

        public Builder reason(String r100) {
            this.reason = r100;
            return this;
        }

        public Builder suggestion(String r100) {
            this.suggestion = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SuggestionItem extends ProtoAdapter<SuggestionItem> {
        public ProtoAdapter_SuggestionItem() {
            super(FieldEncoding.LENGTH_DELIMITED, SuggestionItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SuggestionItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.suggestion = "";
            r101.f3717id = "";
            r101.confidence = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            r101.reason = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.suggestion = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.f3717id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.confidence = ProtoAdapter.DOUBLE.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.reason = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SuggestionItem r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.suggestion) + r101.encodedSizeWithTag(2, r100.f3716id);
            Double r103 = r100.confidence;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.DOUBLE.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.reason;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(4, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SuggestionItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SuggestionItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SuggestionItem r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.suggestion);
            r102.encodeWithTag(r100, 2, r101.f3716id);
            Double r103 = r101.confidence;
            if (r103 == null) goto L5;
            ProtoAdapter.DOUBLE.encodeWithTag(r100, 3, r103);
        L5:
            String r104 = r101.reason;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SuggestionItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SuggestionItem();
        DEFAULT_CONFIDENCE = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.suggestion = this.suggestion;
        r100.f3717id = this.f3716id;
        r100.confidence = this.confidence;
        r100.reason = this.reason;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SuggestionItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SuggestionItem(String r100, String r101, Double r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public SuggestionItem(String r100, String r101, Double r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.suggestion = r100;
        this.f3716id = r101;
        this.confidence = r102;
        this.reason = r103;
    }
}
