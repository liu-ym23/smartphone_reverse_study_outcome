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
public final class DrawingPoint extends Message<DrawingPoint, Builder> {
    public static final ProtoAdapter<DrawingPoint> ADAPTER = null;
    public static final Integer DEFAULT_X = null;
    public static final Integer DEFAULT_Y = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer f122767x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer f122768y;

    public static final class Builder extends Message.Builder<DrawingPoint, Builder> {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public Integer f122769x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public Integer f122770y;

        @Override // com.squareup.wire.Message.Builder
        public DrawingPoint build() {
            return new DrawingPoint(this.f122769x, this.f122770y, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder x(Integer r100) {
            this.f122769x = r100;
            return this;
        }

        public Builder y(Integer r100) {
            this.f122770y = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DrawingPoint extends ProtoAdapter<DrawingPoint> {
        public ProtoAdapter_DrawingPoint() {
            super(FieldEncoding.LENGTH_DELIMITED, DrawingPoint.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DrawingPoint decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.x(ProtoAdapter.INT32.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.y(ProtoAdapter.INT32.decode(r100));
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
        public int encodedSize2(DrawingPoint r100) {
            Integer r101 = r100.f122767x;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.f122768y;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public DrawingPoint redact2(DrawingPoint r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DrawingPoint decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DrawingPoint r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DrawingPoint redact(DrawingPoint r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DrawingPoint r101) throws IOException {
            Integer r102 = r101.f122767x;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.f122768y;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DrawingPoint r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DrawingPoint();
        DEFAULT_X = 0;
        DEFAULT_Y = 0;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L13;
        int r101 = unknownFields().hashCode() * 37;
        Integer r102 = this.f122767x;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Integer r106 = this.f122768y;
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
        r100.f122769x = this.f122767x;
        r100.f122770y = this.f122768y;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.f122767x == null) goto L6;
        r100.append(", x=");
        r100.append(this.f122767x);
    L6:
        if (this.f122768y == null) goto L8;
        r100.append(", y=");
        r100.append(this.f122768y);
    L8:
        StringBuilder r101 = r100.replace(0, 2, "DrawingPoint{");
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
        if ((r100 instanceof DrawingPoint) == true) goto L8;
        return false;
    L8:
        DrawingPoint r101 = (DrawingPoint) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.f122767x, r101.f122767x) == false) goto L15;
        if (Internal.equals(this.f122768y, r101.f122768y) == false) goto L15;
        return true;
    }

    public DrawingPoint(Integer r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DrawingPoint(Integer r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.f122767x = r100;
        this.f122768y = r101;
    }
}
