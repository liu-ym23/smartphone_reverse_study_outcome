package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class Fence extends Message<Fence, a> {
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

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f11982b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Circle f11983c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f11984d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map f11985e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f11986f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f11987g;

        public a() {
            this.f11981a = "";
            this.f11982b = 0;
            this.f11984d = Internal.newMutableList();
            this.f11985e = Internal.newMutableMap();
            this.f11986f = Internal.newMutableList();
            this.f11987g = Internal.newMutableList();
        }

        public Fence a() {
            return new Fence(this.f11981a, this.f11982b, this.f11983c, this.f11984d, this.f11985e, this.f11986f, this.f11987g, super.buildUnknownFields());
        }

        public a b(Circle r10) {
            this.f11983c = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(String r10) {
            this.f11981a = r10;
            return this;
        }

        public a d(Integer r10) {
            this.f11982b = r10;
            return this;
        }
    }

    public static final class b extends ProtoAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ProtoAdapter f11988a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, Fence.class);
            ProtoAdapter<String> r10 = ProtoAdapter.STRING;
            this.f11988a = ProtoAdapter.newMapAdapter(r10, r10);
        }

        public Fence a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L14;
            switch(r13) {
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
            r11.f11987g.add(MultiPolygon.ADAPTER.decode(r10));
            goto L3
        L8:
            r11.f11986f.add(Polygon.ADAPTER.decode(r10));
            goto L3
        L9:
            r11.f11985e.putAll((Map) this.f11988a.decode(r10));
            goto L3
        L10:
            r11.f11984d.add(Point.ADAPTER.decode(r10));
            goto L3
        L11:
            r11.b(Circle.ADAPTER.decode(r10));
            goto L3
        L12:
            r11.d(ProtoAdapter.INT32.decode(r10));
            goto L3
        L13:
            r11.c(ProtoAdapter.STRING.decode(r10));
            goto L3
        L6:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L14:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, Fence r11) {
            ProtoAdapter.STRING.encodeWithTag(r10, 1, r11.fenceid);
            ProtoAdapter.INT32.encodeWithTag(r10, 2, r11.shape);
            Circle.ADAPTER.encodeWithTag(r10, 3, r11.circular);
            Point.ADAPTER.asRepeated().encodeWithTag(r10, 4, r11.vertices);
            this.f11988a.encodeWithTag(r10, 5, r11.properties);
            Polygon.ADAPTER.asRepeated().encodeWithTag(r10, 6, r11.polygons);
            MultiPolygon.ADAPTER.asRepeated().encodeWithTag(r10, 7, r11.multi_polygon);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(Fence r10) {
            return ((((((ProtoAdapter.STRING.encodedSizeWithTag(1, r10.fenceid) + ProtoAdapter.INT32.encodedSizeWithTag(2, r10.shape)) + Circle.ADAPTER.encodedSizeWithTag(3, r10.circular)) + Point.ADAPTER.asRepeated().encodedSizeWithTag(4, r10.vertices)) + this.f11988a.encodedSizeWithTag(5, r10.properties)) + Polygon.ADAPTER.asRepeated().encodedSizeWithTag(6, r10.polygons)) + MultiPolygon.ADAPTER.asRepeated().encodedSizeWithTag(7, r10.multi_polygon)) + r10.unknownFields().size();
        }

        public Fence d(Fence r10) {
            a r11 = r10.newBuilder();
            Circle r12 = r11.f11983c;
            if (r12 == null) goto L5;
            r11.f11983c = Circle.ADAPTER.redact(r12);
        L5:
            Internal.redactElements(r11.f11984d, Point.ADAPTER);
            Internal.redactElements(r11.f11986f, Polygon.ADAPTER);
            Internal.redactElements(r11.f11987g, MultiPolygon.ADAPTER);
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) {
            b(r10, (Fence) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((Fence) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((Fence) r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_SHAPE = 0;
    }

    public Fence(String r10, Integer r11, Circle r12, List<Point> r13, Map<String, String> r14, List<Polygon> r15, List<MultiPolygon> r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Fence) == true) goto L8;
        return false;
    L8:
        Fence r11 = (Fence) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L26;
        if (Internal.equals(this.fenceid, r11.fenceid) == false) goto L26;
        if (Internal.equals(this.shape, r11.shape) == false) goto L26;
        if (Internal.equals(this.circular, r11.circular) == false) goto L26;
        if (this.vertices.equals(r11.vertices) == false) goto L26;
        if (this.properties.equals(r11.properties) == false) goto L26;
        if (this.polygons.equals(r11.polygons) == false) goto L26;
        if (this.multi_polygon.equals(r11.multi_polygon) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L17;
        int r11 = unknownFields().hashCode() * 37;
        String r12 = this.fenceid;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        Integer r16 = this.shape;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        Circle r19 = this.circular;
        if (r19 == null) goto L15;
        r13 = r19.hashCode();
    L15:
        int r20 = ((((((((r18 + r13) * 37) + this.vertices.hashCode()) * 37) + this.properties.hashCode()) * 37) + this.polygons.hashCode()) * 37) + this.multi_polygon.hashCode();
        this.hashCode = r20;
        return r20;
    L11:
        r17 = 0;
        goto L12
    L7:
        r14 = 0;
        goto L8
    L17:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.fenceid == null) goto L6;
        r10.append(", fenceid=");
        r10.append(this.fenceid);
    L6:
        if (this.shape == null) goto L9;
        r10.append(", shape=");
        r10.append(this.shape);
    L9:
        if (this.circular == null) goto L11;
        r10.append(", circular=");
        r10.append(this.circular);
    L11:
        List<Point> r11 = this.vertices;
        if (r11 != null) goto L14;
    L16:
        Map<String, String> r12 = this.properties;
        if (r12 != null) goto L19;
    L21:
        List<Polygon> r13 = this.polygons;
        if (r13 != null) goto L24;
    L26:
        List<MultiPolygon> r14 = this.multi_polygon;
        if (r14 != null) goto L29;
    L31:
        StringBuilder r15 = r10.replace(0, 2, "Fence{");
        r15.append('}');
        return r15.toString();
    L29:
        if (r14.isEmpty() == true) goto L31;
        r10.append(", multi_polygon=");
        r10.append(this.multi_polygon);
        goto L31
    L24:
        if (r13.isEmpty() == true) goto L26;
        r10.append(", polygons=");
        r10.append(this.polygons);
        goto L26
    L19:
        if (r12.isEmpty() == true) goto L21;
        r10.append(", properties=");
        r10.append(this.properties);
        goto L21
    L14:
        if (r11.isEmpty() == true) goto L16;
        r10.append(", vertices=");
        r10.append(this.vertices);
        goto L16
    }

    public Fence(String r10, Integer r11, Circle r12, List<Point> r13, Map<String, String> r14, List<Polygon> r15, List<MultiPolygon> r16, ByteString r17) {
        super(ADAPTER, r17);
        this.fenceid = r10;
        this.shape = r11;
        this.circular = r12;
        this.vertices = Internal.immutableCopyOf("vertices", r13);
        this.properties = Internal.immutableCopyOf("properties", r14);
        this.polygons = Internal.immutableCopyOf("polygons", r15);
        this.multi_polygon = Internal.immutableCopyOf("multi_polygon", r16);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f11981a = this.fenceid;
        r10.f11982b = this.shape;
        r10.f11983c = this.circular;
        r10.f11984d = Internal.copyOf("vertices", this.vertices);
        r10.f11985e = Internal.copyOf("properties", this.properties);
        r10.f11986f = Internal.copyOf("polygons", this.polygons);
        r10.f11987g = Internal.copyOf("multi_polygon", this.multi_polygon);
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
