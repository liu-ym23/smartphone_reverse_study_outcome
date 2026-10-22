package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class Fence extends Message<Fence, Builder> {
    public static final ProtoAdapter<Fence> ADAPTER = null;
    public static final String DEFAULT_FENCEID = "";
    public static final Integer DEFAULT_SHAPE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("circular")
    @WireField(adapter = "com.obric.matrix.proto.Circle#ADAPTER", tag = 3)
    public final Circle circular;

    @SerializedName("fenceid")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String fenceid;

    @SerializedName("multi_polygon")
    @WireField(adapter = "com.obric.matrix.proto.MultiPolygon#ADAPTER", label = WireField.Label.REPEATED, tag = 7)
    public final List<MultiPolygon> multi_polygon;

    @SerializedName("polygons")
    @WireField(adapter = "com.obric.matrix.proto.Polygon#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    public final List<Polygon> polygons;

    @SerializedName("properties")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final Map<String, String> properties;

    @SerializedName("shape")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer shape;

    @SerializedName("vertices")
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<Point> vertices;

    public static final class Builder extends Message.Builder<Fence, Builder> {
        public Circle circular;
        public String fenceid;
        public List<MultiPolygon> multi_polygon;
        public List<Polygon> polygons;
        public Map<String, String> properties;
        public Integer shape;
        public List<Point> vertices;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.fenceid = "";
            this.shape = 0;
            this.vertices = Internal.newMutableList();
            this.properties = Internal.newMutableMap();
            this.polygons = Internal.newMutableList();
            this.multi_polygon = Internal.newMutableList();
        }

        public Builder fenceid(String r1) {
            this.fenceid = r1;
            return this;
        }

        public Builder shape(Integer r1) {
            this.shape = r1;
            return this;
        }

        public Builder circular(Circle r1) {
            this.circular = r1;
            return this;
        }

        public Builder vertices(List<Point> r1) {
            Internal.checkElementsNotNull(r1);
            this.vertices = r1;
            return this;
        }

        public Builder properties(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.properties = r1;
            return this;
        }

        public Builder polygons(List<Polygon> r1) {
            Internal.checkElementsNotNull(r1);
            this.polygons = r1;
            return this;
        }

        public Builder multi_polygon(List<MultiPolygon> r1) {
            Internal.checkElementsNotNull(r1);
            this.multi_polygon = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public Fence build() {
            return new Fence(this.fenceid, this.shape, this.circular, this.vertices, this.properties, this.polygons, this.multi_polygon, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_Fence extends ProtoAdapter<Fence> {
        private final ProtoAdapter<Map<String, String>> properties;

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Fence decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Fence r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Fence r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Fence redact(Fence r1) {
            return redact2(r1);
        }

        public ProtoAdapter_Fence() {
            super(FieldEncoding.LENGTH_DELIMITED, Fence.class);
            this.properties = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Fence r5) {
            return ((((((ProtoAdapter.STRING.encodedSizeWithTag(1, r5.fenceid) + ProtoAdapter.INT32.encodedSizeWithTag(2, r5.shape)) + Circle.ADAPTER.encodedSizeWithTag(3, r5.circular)) + Point.ADAPTER.asRepeated().encodedSizeWithTag(4, r5.vertices)) + this.properties.encodedSizeWithTag(5, r5.properties)) + Polygon.ADAPTER.asRepeated().encodedSizeWithTag(6, r5.polygons)) + MultiPolygon.ADAPTER.asRepeated().encodedSizeWithTag(7, r5.multi_polygon)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r4, Fence r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.fenceid);
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r5.shape);
            Circle.ADAPTER.encodeWithTag(r4, 3, r5.circular);
            Point.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.vertices);
            this.properties.encodeWithTag(r4, 5, r5.properties);
            Polygon.ADAPTER.asRepeated().encodeWithTag(r4, 6, r5.polygons);
            MultiPolygon.ADAPTER.asRepeated().encodeWithTag(r4, 7, r5.multi_polygon);
            r4.writeBytes(r5.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Fence decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L14;
            switch(r3) {
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
            r0.multi_polygon.add(MultiPolygon.ADAPTER.decode(r7));
            goto L3
        L8:
            r0.polygons.add(Polygon.ADAPTER.decode(r7));
            goto L3
        L9:
            r0.properties.putAll(this.properties.decode(r7));
            goto L3
        L10:
            r0.vertices.add(Point.ADAPTER.decode(r7));
            goto L3
        L11:
            r0.circular(Circle.ADAPTER.decode(r7));
            goto L3
        L12:
            r0.shape(ProtoAdapter.INT32.decode(r7));
            goto L3
        L13:
            r0.fenceid(ProtoAdapter.STRING.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L14:
            r7.endMessage(r1);
            return r0.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Fence redact2(Fence r2) {
            Builder r1 = r2.newBuilder();
            if (r1.circular == null) goto L5;
            r1.circular = Circle.ADAPTER.redact(r1.circular);
        L5:
            Internal.redactElements(r1.vertices, Point.ADAPTER);
            Internal.redactElements(r1.polygons, Polygon.ADAPTER);
            Internal.redactElements(r1.multi_polygon, MultiPolygon.ADAPTER);
            r1.clearUnknownFields();
            return r1.build();
        }
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    static {
        ADAPTER = new ProtoAdapter_Fence();
        DEFAULT_SHAPE = 0;
    }

    public Fence(String r10, Integer r11, Circle r12, List<Point> r13, Map<String, String> r14, List<Polygon> r15, List<MultiPolygon> r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public Fence(String r2, Integer r3, Circle r4, List<Point> r5, Map<String, String> r6, List<Polygon> r7, List<MultiPolygon> r8, ByteString r9) {
        super(ADAPTER, r9);
        this.fenceid = r2;
        this.shape = r3;
        this.circular = r4;
        this.vertices = Internal.immutableCopyOf("vertices", r5);
        this.properties = Internal.immutableCopyOf("properties", r6);
        this.polygons = Internal.immutableCopyOf("polygons", r7);
        this.multi_polygon = Internal.immutableCopyOf("multi_polygon", r8);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.fenceid = this.fenceid;
        r0.shape = this.shape;
        r0.circular = this.circular;
        r0.vertices = Internal.copyOf("vertices", this.vertices);
        r0.properties = Internal.copyOf("properties", this.properties);
        r0.polygons = Internal.copyOf("polygons", this.polygons);
        r0.multi_polygon = Internal.copyOf("multi_polygon", this.multi_polygon);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Fence) == true) goto L8;
        return false;
    L8:
        Fence r6 = (Fence) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L26;
        if (Internal.equals(this.fenceid, r6.fenceid) == false) goto L26;
        if (Internal.equals(this.shape, r6.shape) == false) goto L26;
        if (Internal.equals(this.circular, r6.circular) == false) goto L26;
        if (this.vertices.equals(r6.vertices) == false) goto L26;
        if (this.properties.equals(r6.properties) == false) goto L26;
        if (this.polygons.equals(r6.polygons) == false) goto L26;
        if (this.multi_polygon.equals(r6.multi_polygon) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.fenceid;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.shape;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Circle r9 = this.circular;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = ((((((((r8 + r3) * 37) + this.vertices.hashCode()) * 37) + this.properties.hashCode()) * 37) + this.polygons.hashCode()) * 37) + this.multi_polygon.hashCode();
        this.hashCode = r10;
        return r10;
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L17:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.fenceid == null) goto L6;
        r0.append(", fenceid=").append(this.fenceid);
    L6:
        if (this.shape == null) goto L9;
        r0.append(", shape=").append(this.shape);
    L9:
        if (this.circular == null) goto L11;
        r0.append(", circular=").append(this.circular);
    L11:
        List<Point> r1 = this.vertices;
        if (r1 != null) goto L14;
    L16:
        Map<String, String> r2 = this.properties;
        if (r2 != null) goto L19;
    L21:
        List<Polygon> r3 = this.polygons;
        if (r3 != null) goto L24;
    L26:
        List<MultiPolygon> r4 = this.multi_polygon;
        if (r4 == null) goto L32;
        if (r4.isEmpty() == true) goto L32;
        r0.append(", multi_polygon=").append(this.multi_polygon);
    L32:
        return r0.replace(0, 2, "Fence{").append('}').toString();
    L24:
        if (r3.isEmpty() == true) goto L26;
        r0.append(", polygons=").append(this.polygons);
        goto L26
    L19:
        if (r2.isEmpty() == true) goto L21;
        r0.append(", properties=").append(this.properties);
        goto L21
    L14:
        if (r1.isEmpty() == true) goto L16;
        r0.append(", vertices=").append(this.vertices);
        goto L16
    }
}
