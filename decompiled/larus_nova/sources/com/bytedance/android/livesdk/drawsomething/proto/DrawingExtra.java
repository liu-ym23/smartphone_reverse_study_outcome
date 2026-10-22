package com.bytedance.android.livesdk.drawsomething.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes8.dex */
public final class DrawingExtra extends Message<DrawingExtra, Builder> {
    public static final ProtoAdapter<DrawingExtra> ADAPTER = null;
    public static final String DEFAULT_ANSWER = "";
    public static final String DEFAULT_HINT = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String answer;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String hint;

    public static final class Builder extends Message.Builder<DrawingExtra, Builder> {
        public String answer;
        public String hint;

        @Override // com.squareup.wire.Message.Builder
        public DrawingExtra build() {
            return new DrawingExtra(this.hint, this.answer, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder answer(String r100) {
            this.answer = r100;
            return this;
        }

        public Builder hint(String r100) {
            this.hint = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DrawingExtra extends ProtoAdapter<DrawingExtra> {
        public ProtoAdapter_DrawingExtra() {
            super(FieldEncoding.LENGTH_DELIMITED, DrawingExtra.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DrawingExtra decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.hint(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.answer(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(DrawingExtra r100) {
            String r101 = r100.hint;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.answer;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public DrawingExtra redact2(DrawingExtra r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DrawingExtra decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DrawingExtra r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DrawingExtra redact(DrawingExtra r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DrawingExtra r101) throws IOException {
            String r102 = r101.hint;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.answer;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DrawingExtra r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DrawingExtra();
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L13;
        int r101 = unknownFields().hashCode() * 37;
        String r102 = this.hint;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        String r106 = this.answer;
        if (r106 == null) goto L11;
        r103 = r106.hashCode();
    L11:
        int r107 = r105 + r103;
        this.hashCode = r107;
        return r107;
    L7:
        r104 = 0;
        goto L8
    L13:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.hint = this.hint;
        r100.answer = this.answer;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.hint == null) goto L6;
        r100.append(", hint=");
        r100.append(this.hint);
    L6:
        if (this.answer == null) goto L8;
        r100.append(", answer=");
        r100.append(this.answer);
    L8:
        StringBuilder r101 = r100.replace(0, 2, "DrawingExtra{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof DrawingExtra) == true) goto L8;
        return false;
    L8:
        DrawingExtra r101 = (DrawingExtra) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.hint, r101.hint) == false) goto L15;
        if (Internal.equals(this.answer, r101.answer) == false) goto L15;
        return true;
    }

    public DrawingExtra(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DrawingExtra(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.hint = r100;
        this.answer = r101;
    }
}
