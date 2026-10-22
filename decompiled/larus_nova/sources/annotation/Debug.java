package annotation;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes28.dex */
public final class Debug extends Message<Debug, Builder> {
    public static final ProtoAdapter<Debug> ADAPTER = null;
    public static final Boolean DEFAULT_LEN = null;
    public static final Integer DEFAULT_TRUNCATE = null;
    private static final long serialVersionUID = 0;
    public final Boolean len;
    public final Integer truncate;

    public static final class Builder extends Message.Builder<Debug, Builder> {
        public Boolean len;
        public Integer truncate;

        @Override // com.squareup.wire.Message.Builder
        public Debug build() {
            return new Debug(this.truncate, this.len, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder len(Boolean r100) {
            this.len = r100;
            return this;
        }

        public Builder truncate(Integer r100) {
            this.truncate = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Debug extends ProtoAdapter<Debug> {
        public ProtoAdapter_Debug() {
            super(FieldEncoding.LENGTH_DELIMITED, Debug.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Debug decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.truncate = 2;
            r101.len = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L11;
            if (r103 != 1) goto L7;
            r101.truncate = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L7:
            if (r103 != 2) goto L8;
            r101.len = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L11:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Debug r100) {
            Integer r101 = r100.truncate;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.UINT32.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.len;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Debug decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Debug r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Debug r101) throws IOException {
            Integer r102 = r101.truncate;
            if (r102 == null) goto L5;
            ProtoAdapter.UINT32.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.len;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Debug r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Debug();
        DEFAULT_TRUNCATE = 2;
        DEFAULT_LEN = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.truncate = this.truncate;
        r100.len = this.len;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Debug.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Debug(Integer r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public Debug(Integer r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.truncate = r100;
        this.len = r101;
    }
}
