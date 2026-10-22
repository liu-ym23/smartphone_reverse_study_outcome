package annotation;

import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes28.dex */
public final class Test extends Message<Test, Builder> {
    public static final ProtoAdapter<Test> ADAPTER = null;
    public static final Boolean DEFAULT_TEST1 = null;
    public static final Boolean DEFAULT_TEST2 = null;
    public static final Boolean DEFAULT_TEST3 = null;
    public static final Boolean DEFAULT_TEST4 = null;
    public static final Boolean DEFAULT_TEST6 = null;
    public static final FieldOptions FIELD_OPTIONS_TEST1 = null;
    public static final FieldOptions FIELD_OPTIONS_TEST2 = null;
    public static final FieldOptions FIELD_OPTIONS_TEST3 = null;
    public static final FieldOptions FIELD_OPTIONS_TEST4 = null;
    public static final FieldOptions FIELD_OPTIONS_TEST6 = null;
    private static final long serialVersionUID = 0;
    public final Boolean test1;
    public final Boolean test2;
    public final Boolean test3;
    public final Boolean test4;
    public final Boolean test6;

    public static final class Builder extends Message.Builder<Test, Builder> {
        public Boolean test1;
        public Boolean test2;
        public Boolean test3;
        public Boolean test4;
        public Boolean test6;

        @Override // com.squareup.wire.Message.Builder
        public Test build() {
            return new Test(this.test1, this.test2, this.test3, this.test4, this.test6, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder test1(Boolean r100) {
            this.test1 = r100;
            return this;
        }

        public Builder test2(Boolean r100) {
            this.test2 = r100;
            return this;
        }

        public Builder test3(Boolean r100) {
            this.test3 = r100;
            return this;
        }

        public Builder test4(Boolean r100) {
            this.test4 = r100;
            return this;
        }

        public Builder test6(Boolean r100) {
            this.test6 = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Test extends ProtoAdapter<Test> {
        public ProtoAdapter_Test() {
            super(FieldEncoding.LENGTH_DELIMITED, Test.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Test decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.test1 = r102;
            r101.test2 = r102;
            r101.test3 = r102;
            r101.test4 = r102;
            r101.test6(r102);
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L21;
            if (r104 != 1) goto L8;
            r101.test1 = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.test2 = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.test3 = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L14;
            r101.test4 = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            if (r104 != 5) goto L15;
            r101.test6(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L15:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Test r100) {
            Boolean r101 = r100.test1;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.test2;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.test3;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.test4;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.test6;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Test decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Test r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Test r101) throws IOException {
            Boolean r102 = r101.test1;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.test2;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.test3;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.test4;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.test6;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Test r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Test();
        FIELD_OPTIONS_TEST1 = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_TEST2 = new FieldOptions.Builder().debug(new Debug.Builder().len(Boolean.TRUE).build()).build();
        FIELD_OPTIONS_TEST3 = new FieldOptions.Builder().debug(new Debug.Builder().truncate(10).build()).build();
        FIELD_OPTIONS_TEST4 = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_TEST6 = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_TEST1 = r100;
        DEFAULT_TEST2 = r100;
        DEFAULT_TEST3 = r100;
        DEFAULT_TEST4 = r100;
        DEFAULT_TEST6 = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.test1 = this.test1;
        r100.test2 = this.test2;
        r100.test3 = this.test3;
        r100.test4 = this.test4;
        r100.test6 = this.test6;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Test.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Test(Boolean r100, Boolean r101, Boolean r110, Boolean r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public Test(Boolean r100, Boolean r101, Boolean r102, Boolean r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.test1 = r100;
        this.test2 = r101;
        this.test3 = r102;
        this.test4 = r103;
        this.test6 = r104;
    }
}
