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
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class MultiPolygon extends Message<MultiPolygon, a> {
    public static final ProtoAdapter<MultiPolygon> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("polygons")
    @WireField(adapter = "com.obric.matrix.proto.Polygon#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<Polygon> polygons;

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f12035a;

        public a() {
            this.f12035a = Internal.newMutableList();
        }

        public MultiPolygon a() {
            return new MultiPolygon(this.f12035a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, MultiPolygon.class);
        }

        public MultiPolygon a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L9;
            if (r13 != 1) goto L7;
            r11.f12035a.add(Polygon.ADAPTER.decode(r10));
            goto L3
        L7:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L9:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, MultiPolygon r11) {
            Polygon.ADAPTER.asRepeated().encodeWithTag(r10, 1, r11.polygons);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(MultiPolygon r10) {
            return Polygon.ADAPTER.asRepeated().encodedSizeWithTag(1, r10.polygons) + r10.unknownFields().size();
        }

        public MultiPolygon d(MultiPolygon r10) {
            a r11 = r10.newBuilder();
            Internal.redactElements(r11.f12035a, Polygon.ADAPTER);
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) {
            b(r10, (MultiPolygon) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((MultiPolygon) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((MultiPolygon) r10);
        }
    }

    static {
        ADAPTER = new b();
    }

    public MultiPolygon(List<Polygon> r10) {
        this(r10, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof MultiPolygon) == true) goto L8;
        return false;
    L8:
        MultiPolygon r11 = (MultiPolygon) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L14;
        if (this.polygons.equals(r11.polygons) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L6;
        int r11 = (unknownFields().hashCode() * 37) + this.polygons.hashCode();
        this.hashCode = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        List<Polygon> r11 = this.polygons;
        if (r11 != null) goto L5;
    L7:
        StringBuilder r12 = r10.replace(0, 2, "MultiPolygon{");
        r12.append('}');
        return r12.toString();
    L5:
        if (r11.isEmpty() == true) goto L7;
        r10.append(", polygons=");
        r10.append(this.polygons);
        goto L7
    }

    public MultiPolygon(List<Polygon> r10, ByteString r11) {
        super(ADAPTER, r11);
        this.polygons = Internal.immutableCopyOf("polygons", r10);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f12035a = Internal.copyOf("polygons", this.polygons);
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
