package annotation;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes28.dex */
public final class OptionsExt extends Message<OptionsExt, Builder> {
    public static final ProtoAdapter<OptionsExt> ADAPTER = null;
    public static final Boolean DEFAULT_ITER = null;
    public static final Boolean DEFAULT_SERDE = null;
    private static final long serialVersionUID = 0;
    public final Boolean iter;
    public final Boolean serde;

    public static final class Builder extends Message.Builder<OptionsExt, Builder> {
        public Boolean iter;
        public Boolean serde;

        @Override // com.squareup.wire.Message.Builder
        public OptionsExt build() {
            return new OptionsExt(this.serde, this.iter, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder iter(Boolean r100) {
            this.iter = r100;
            return this;
        }

        public Builder serde(Boolean r100) {
            this.serde = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OptionsExt extends ProtoAdapter<OptionsExt> {
        public ProtoAdapter_OptionsExt() {
            super(FieldEncoding.LENGTH_DELIMITED, OptionsExt.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OptionsExt decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.serde = r102;
            r101.iter = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L12;
            if (r104 != 1) goto L8;
            r101.serde = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L9;
            r101.iter = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(OptionsExt r100) {
            Boolean r101 = r100.serde;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.iter;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OptionsExt decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OptionsExt r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OptionsExt r101) throws IOException {
            Boolean r102 = r101.serde;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.iter;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OptionsExt r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OptionsExt();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_SERDE = r100;
        DEFAULT_ITER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.serde = this.serde;
        r100.iter = this.iter;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OptionsExt.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OptionsExt(Boolean r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public OptionsExt(Boolean r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.serde = r100;
        this.iter = r101;
    }
}
