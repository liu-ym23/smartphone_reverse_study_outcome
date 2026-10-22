package com.bytedance.android.livesdk.drawsomething.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes8.dex */
public final class DrawingLine extends Message<DrawingLine, Builder> {
    public static final ProtoAdapter<DrawingLine> ADAPTER = null;
    public static final Long DEFAULT_COLOR = null;
    public static final Integer DEFAULT_LINEWIDTH = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long color;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer lineWidth;

    @WireField(adapter = "webcast.sei.DrawingPoint#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<DrawingPoint> points;

    public static final class Builder extends Message.Builder<DrawingLine, Builder> {
        public Long color;
        public Integer lineWidth;
        public List<DrawingPoint> points;

        @Override // com.squareup.wire.Message.Builder
        public DrawingLine build() {
            return new DrawingLine(this.points, this.color, this.lineWidth, super.buildUnknownFields());
        }

        public Builder() {
            this.points = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder color(Long r100) {
            this.color = r100;
            return this;
        }

        public Builder lineWidth(Integer r100) {
            this.lineWidth = r100;
            return this;
        }

        public Builder points(List<DrawingPoint> r100) {
            Internal.checkElementsNotNull(r100);
            this.points = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DrawingLine extends ProtoAdapter<DrawingLine> {
        public ProtoAdapter_DrawingLine() {
            super(FieldEncoding.LENGTH_DELIMITED, DrawingLine.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DrawingLine decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.points.add(DrawingPoint.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.color(ProtoAdapter.INT64.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.lineWidth(ProtoAdapter.INT32.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DrawingLine r100) {
            int r101 = DrawingPoint.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.points);
            Long r102 = r100.color;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT64.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Integer r106 = r100.lineWidth;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.INT32.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public DrawingLine redact2(DrawingLine r100) {
            Builder r101 = r100.newBuilder();
            Internal.redactElements(r101.points, DrawingPoint.ADAPTER);
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DrawingLine decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DrawingLine r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DrawingLine redact(DrawingLine r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DrawingLine r101) throws IOException {
            DrawingPoint.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.points);
            Long r102 = r101.color;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r102);
        L5:
            Integer r103 = r101.lineWidth;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DrawingLine r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DrawingLine();
        DEFAULT_COLOR = 0L;
        DEFAULT_LINEWIDTH = 0;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L13;
        int r101 = ((unknownFields().hashCode() * 37) + this.points.hashCode()) * 37;
        Long r102 = this.color;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Integer r106 = this.lineWidth;
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
        r100.points = Internal.copyOf("points", this.points);
        r100.color = this.color;
        r100.lineWidth = this.lineWidth;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.points.isEmpty() == true) goto L6;
        r100.append(", points=");
        r100.append(this.points);
    L6:
        if (this.color == null) goto L9;
        r100.append(", color=");
        r100.append(this.color);
    L9:
        if (this.lineWidth == null) goto L11;
        r100.append(", lineWidth=");
        r100.append(this.lineWidth);
    L11:
        StringBuilder r101 = r100.replace(0, 2, "DrawingLine{");
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
        if ((r100 instanceof DrawingLine) == true) goto L8;
        return false;
    L8:
        DrawingLine r101 = (DrawingLine) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L17:
        return false;
    L11:
        if (this.points.equals(r101.points) == false) goto L17;
        if (Internal.equals(this.color, r101.color) == false) goto L17;
        if (Internal.equals(this.lineWidth, r101.lineWidth) == false) goto L17;
        return true;
    }

    public DrawingLine(List<DrawingPoint> r100, Long r101, Integer r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public DrawingLine(List<DrawingPoint> r100, Long r101, Integer r102, ByteString r103) {
        super(ADAPTER, r103);
        this.points = Internal.immutableCopyOf("points", r100);
        this.color = r101;
        this.lineWidth = r102;
    }
}
