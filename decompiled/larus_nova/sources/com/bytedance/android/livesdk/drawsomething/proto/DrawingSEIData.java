package com.bytedance.android.livesdk.drawsomething.proto;

import com.alibaba.gaiax.template.GXTemplateKey;
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
public final class DrawingSEIData extends Message<DrawingSEIData, Builder> {
    public static final ProtoAdapter<DrawingSEIData> ADAPTER = null;
    public static final Integer DEFAULT_CANVASHEIGHT = null;
    public static final Integer DEFAULT_CANVASWIDTH = null;
    public static final Integer DEFAULT_DURATION = null;
    public static final Integer DEFAULT_STATE = null;
    public static final Integer DEFAULT_TIME = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    public final Integer canvasHeight;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    public final Integer canvasWidth;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer duration;

    @WireField(adapter = "webcast.sei.DrawingExtra#ADAPTER", tag = 4)
    public final DrawingExtra extra;

    @WireField(adapter = "webcast.sei.DrawingLine#ADAPTER", label = WireField.Label.REPEATED, tag = 3)
    public final List<DrawingLine> lines;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer state;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer time;

    public static final class Builder extends Message.Builder<DrawingSEIData, Builder> {
        public Integer canvasHeight;
        public Integer canvasWidth;
        public Integer duration;
        public DrawingExtra extra;
        public List<DrawingLine> lines;
        public Integer state;
        public Integer time;

        @Override // com.squareup.wire.Message.Builder
        public DrawingSEIData build() {
            return new DrawingSEIData(this.state, this.time, this.lines, this.extra, this.duration, this.canvasWidth, this.canvasHeight, super.buildUnknownFields());
        }

        public Builder() {
            this.lines = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder canvasHeight(Integer r100) {
            this.canvasHeight = r100;
            return this;
        }

        public Builder canvasWidth(Integer r100) {
            this.canvasWidth = r100;
            return this;
        }

        public Builder duration(Integer r100) {
            this.duration = r100;
            return this;
        }

        public Builder extra(DrawingExtra r100) {
            this.extra = r100;
            return this;
        }

        public Builder lines(List<DrawingLine> r100) {
            Internal.checkElementsNotNull(r100);
            this.lines = r100;
            return this;
        }

        public Builder state(Integer r100) {
            this.state = r100;
            return this;
        }

        public Builder time(Integer r100) {
            this.time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DrawingSEIData extends ProtoAdapter<DrawingSEIData> {
        public ProtoAdapter_DrawingSEIData() {
            super(FieldEncoding.LENGTH_DELIMITED, DrawingSEIData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DrawingSEIData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.canvasHeight(ProtoAdapter.INT32.decode(r100));
            goto L3
        L8:
            r101.canvasWidth(ProtoAdapter.INT32.decode(r100));
            goto L3
        L9:
            r101.duration(ProtoAdapter.INT32.decode(r100));
            goto L3
        L10:
            r101.extra(DrawingExtra.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.lines.add(DrawingLine.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.time(ProtoAdapter.INT32.decode(r100));
            goto L3
        L13:
            r101.state(ProtoAdapter.INT32.decode(r100));
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DrawingSEIData r100) {
            Integer r101 = r100.state;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.time;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = (r103 + r105) + DrawingLine.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.lines);
            DrawingExtra r107 = r100.extra;
            if (r107 == null) goto L13;
            int r108 = DrawingExtra.ADAPTER.encodedSizeWithTag(4, r107);
        L14:
            int r109 = r106 + r108;
            Integer r110 = r100.duration;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(5, r110);
        L18:
            int r112 = r109 + r111;
            Integer r113 = r100.canvasWidth;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(6, r113);
        L22:
            int r115 = r112 + r114;
            Integer r116 = r100.canvasHeight;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(7, r116);
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

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public DrawingSEIData redact2(DrawingSEIData r100) {
            Builder r101 = r100.newBuilder();
            Internal.redactElements(r101.lines, DrawingLine.ADAPTER);
            DrawingExtra r102 = r101.extra;
            if (r102 == null) goto L5;
            r101.extra = DrawingExtra.ADAPTER.redact(r102);
        L5:
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DrawingSEIData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DrawingSEIData r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DrawingSEIData redact(DrawingSEIData r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DrawingSEIData r101) throws IOException {
            Integer r102 = r101.state;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            DrawingLine.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.lines);
            DrawingExtra r104 = r101.extra;
            if (r104 == null) goto L11;
            DrawingExtra.ADAPTER.encodeWithTag(r100, 4, r104);
        L11:
            Integer r105 = r101.duration;
            if (r105 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r105);
        L14:
            Integer r106 = r101.canvasWidth;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r106);
        L17:
            Integer r107 = r101.canvasHeight;
            if (r107 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DrawingSEIData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DrawingSEIData();
        DEFAULT_STATE = 0;
        DEFAULT_TIME = 0;
        DEFAULT_DURATION = 0;
        DEFAULT_CANVASWIDTH = 0;
        DEFAULT_CANVASHEIGHT = 0;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L29;
        int r101 = unknownFields().hashCode() * 37;
        Integer r102 = this.state;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Integer r106 = this.time;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (((r105 + r107) * 37) + this.lines.hashCode()) * 37;
        DrawingExtra r109 = this.extra;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        Integer r112 = this.duration;
        if (r112 == null) goto L19;
        int r113 = r112.hashCode();
    L20:
        int r114 = (r111 + r113) * 37;
        Integer r115 = this.canvasWidth;
        if (r115 == null) goto L23;
        int r116 = r115.hashCode();
    L24:
        int r117 = (r114 + r116) * 37;
        Integer r118 = this.canvasHeight;
        if (r118 == null) goto L27;
        r103 = r118.hashCode();
    L27:
        int r119 = r117 + r103;
        this.hashCode = r119;
        return r119;
    L23:
        r116 = 0;
        goto L24
    L19:
        r113 = 0;
        goto L20
    L15:
        r110 = 0;
        goto L16
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L29:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.state = this.state;
        r100.time = this.time;
        r100.lines = Internal.copyOf(GXTemplateKey.STYLE_FONT_LINES, this.lines);
        r100.extra = this.extra;
        r100.duration = this.duration;
        r100.canvasWidth = this.canvasWidth;
        r100.canvasHeight = this.canvasHeight;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.state == null) goto L6;
        r100.append(", state=");
        r100.append(this.state);
    L6:
        if (this.time == null) goto L9;
        r100.append(", time=");
        r100.append(this.time);
    L9:
        if (this.lines.isEmpty() == true) goto L12;
        r100.append(", lines=");
        r100.append(this.lines);
    L12:
        if (this.extra == null) goto L15;
        r100.append(", extra=");
        r100.append(this.extra);
    L15:
        if (this.duration == null) goto L18;
        r100.append(", duration=");
        r100.append(this.duration);
    L18:
        if (this.canvasWidth == null) goto L21;
        r100.append(", canvasWidth=");
        r100.append(this.canvasWidth);
    L21:
        if (this.canvasHeight == null) goto L23;
        r100.append(", canvasHeight=");
        r100.append(this.canvasHeight);
    L23:
        StringBuilder r101 = r100.replace(0, 2, "DrawingSEIData{");
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
        if ((r100 instanceof DrawingSEIData) == true) goto L8;
        return false;
    L8:
        DrawingSEIData r101 = (DrawingSEIData) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L25:
        return false;
    L11:
        if (Internal.equals(this.state, r101.state) == false) goto L25;
        if (Internal.equals(this.time, r101.time) == false) goto L25;
        if (this.lines.equals(r101.lines) == false) goto L25;
        if (Internal.equals(this.extra, r101.extra) == false) goto L25;
        if (Internal.equals(this.duration, r101.duration) == false) goto L25;
        if (Internal.equals(this.canvasWidth, r101.canvasWidth) == false) goto L25;
        if (Internal.equals(this.canvasHeight, r101.canvasHeight) == false) goto L25;
        return true;
    }

    public DrawingSEIData(Integer r110, Integer r111, List<DrawingLine> r112, DrawingExtra r113, Integer r114, Integer r115, Integer r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public DrawingSEIData(Integer r100, Integer r101, List<DrawingLine> r102, DrawingExtra r103, Integer r104, Integer r105, Integer r106, ByteString r107) {
        super(ADAPTER, r107);
        this.state = r100;
        this.time = r101;
        this.lines = Internal.immutableCopyOf(GXTemplateKey.STYLE_FONT_LINES, r102);
        this.extra = r103;
        this.duration = r104;
        this.canvasWidth = r105;
        this.canvasHeight = r106;
    }
}
