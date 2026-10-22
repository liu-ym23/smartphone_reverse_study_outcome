package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class Circle extends Message<Circle, a> {
    public static final ProtoAdapter<Circle> ADAPTER = null;
    public static final Double DEFAULT_RADIUS = null;
    private static final long serialVersionUID = 0;

    @SerializedName("center")
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", tag = 1)
    public final Point center;

    @SerializedName("radius")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double radius;

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Point f11975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f11976b;

        public a() {
            this.f11976b = Double.valueOf(0.0d);
        }

        public Circle a() {
            return new Circle(this.f11975a, this.f11976b, super.buildUnknownFields());
        }

        public a b(Point r10) {
            this.f11975a = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Double r10) {
            this.f11976b = r10;
            return this;
        }
    }

    public static final class b extends ProtoAdapter {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, Circle.class);
        }

        public Circle a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L12;
            if (r13 != 1) goto L8;
            r11.b(Point.ADAPTER.decode(r10));
            goto L3
        L8:
            if (r13 != 2) goto L9;
            r11.c(ProtoAdapter.DOUBLE.decode(r10));
            goto L3
        L9:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L12:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, Circle r11) {
            Point.ADAPTER.encodeWithTag(r10, 1, r11.center);
            ProtoAdapter.DOUBLE.encodeWithTag(r10, 2, r11.radius);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(Circle r10) {
            return (Point.ADAPTER.encodedSizeWithTag(1, r10.center) + ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r10.radius)) + r10.unknownFields().size();
        }

        public Circle d(Circle r10) {
            a r11 = r10.newBuilder();
            Point r12 = r11.f11975a;
            if (r12 == null) goto L5;
            r11.f11975a = Point.ADAPTER.redact(r12);
        L5:
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) {
            b(r10, (Circle) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((Circle) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((Circle) r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_RADIUS = Double.valueOf(0.0d);
    }

    public Circle(Point r10, Double r11) {
        this(r10, r11, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Circle) == true) goto L8;
        return false;
    L8:
        Circle r11 = (Circle) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L16;
        if (Internal.equals(this.center, r11.center) == false) goto L16;
        if (Internal.equals(this.radius, r11.radius) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L13;
        int r11 = unknownFields().hashCode() * 37;
        Point r12 = this.center;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        Double r16 = this.radius;
        if (r16 == null) goto L11;
        r13 = r16.hashCode();
    L11:
        int r17 = r15 + r13;
        this.hashCode = r17;
        return r17;
    L7:
        r14 = 0;
        goto L8
    L13:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.center == null) goto L6;
        r10.append(", center=");
        r10.append(this.center);
    L6:
        if (this.radius == null) goto L8;
        r10.append(", radius=");
        r10.append(this.radius);
    L8:
        StringBuilder r11 = r10.replace(0, 2, "Circle{");
        r11.append('}');
        return r11.toString();
    }

    public Circle(Point r10, Double r11, ByteString r12) {
        super(ADAPTER, r12);
        this.center = r10;
        this.radius = r11;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f11975a = this.center;
        r10.f11976b = this.radius;
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
