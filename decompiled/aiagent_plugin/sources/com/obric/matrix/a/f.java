package com.obric.matrix.a;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Fence.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f extends Message<f, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<f> f33457a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Integer f33458b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("fenceid")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String f33459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("shape")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer f33460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("circular")
    @WireField(adapter = "com.obric.matrix.proto.Circle#ADAPTER", tag = 3)
    public final c f33461e;

    @SerializedName("vertices")
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<x> f;

    @SerializedName("properties")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final Map<String, String> g;

    @SerializedName("polygons")
    @WireField(adapter = "com.obric.matrix.proto.Polygon#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    public final List<y> h;

    @SerializedName("multi_polygon")
    @WireField(adapter = "com.obric.matrix.proto.MultiPolygon#ADAPTER", label = WireField.Label.REPEATED, tag = 7)
    public final List<r> i;

    /* JADX INFO: compiled from: Fence.java */
    public static final class a extends Message.Builder<f, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f33462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f33463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c f33464c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<x> f33465d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<String, String> f33466e;
        public List<y> f;
        public List<r> g;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33462a = "";
            this.f33463b = 0;
            this.f33465d = Internal.newMutableList();
            this.f33466e = Internal.newMutableMap();
            this.f = Internal.newMutableList();
            this.g = Internal.newMutableList();
        }

        public a a(String r1) {
            this.f33462a = r1;
            return this;
        }

        public a a(Integer r1) {
            this.f33463b = r1;
            return this;
        }

        public a a(c r1) {
            this.f33464c = r1;
            return this;
        }

        public f a() {
            return new f(this.f33462a, this.f33463b, this.f33464c, this.f33465d, this.f33466e, this.f, this.g, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: Fence.java */
    private static final class b extends ProtoAdapter<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f33467a;

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ f decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, f r4) {
            a(r3, (f) ZeusTransformUtils.preCheckCast(r4, f.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(f r3) {
            return a((f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ f redact(f r3) {
            return b((f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, f.class);
            this.f33467a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(f r5) {
            return ((((((ProtoAdapter.STRING.encodedSizeWithTag(1, r5.f33459c) + ProtoAdapter.INT32.encodedSizeWithTag(2, r5.f33460d)) + c.f33440a.encodedSizeWithTag(3, r5.f33461e)) + x.f33584a.asRepeated().encodedSizeWithTag(4, r5.f)) + this.f33467a.encodedSizeWithTag(5, r5.g)) + y.f33591a.asRepeated().encodedSizeWithTag(6, r5.h)) + r.f33541a.asRepeated().encodedSizeWithTag(7, r5.i)) + r5.unknownFields().k();
        }

        public void a(ProtoWriter r4, f r5) {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.f33459c);
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r5.f33460d);
            c.f33440a.encodeWithTag(r4, 3, r5.f33461e);
            x.f33584a.asRepeated().encodeWithTag(r4, 4, r5.f);
            this.f33467a.encodeWithTag(r4, 5, r5.g);
            y.f33591a.asRepeated().encodeWithTag(r4, 6, r5.h);
            r.f33541a.asRepeated().encodeWithTag(r4, 7, r5.i);
            r4.writeBytes(r5.unknownFields());
        }

        public f a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L15;
            switch(r3) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                default: goto L7;
            };
        L8:
            r0.g.add((r) ZeusTransformUtils.preCheckCast(r.f33541a.decode(r8), r.class, "com.obric.aiagent.plugin"));
            goto L3
        L9:
            r0.f.add((y) ZeusTransformUtils.preCheckCast(y.f33591a.decode(r8), y.class, "com.obric.aiagent.plugin"));
            goto L3
        L10:
            r0.f33466e.putAll((Map) ZeusTransformUtils.preCheckCast(this.f33467a.decode(r8), Map.class, "com.obric.aiagent.plugin"));
            goto L3
        L11:
            r0.f33465d.add((x) ZeusTransformUtils.preCheckCast(x.f33584a.decode(r8), x.class, "com.obric.aiagent.plugin"));
            goto L3
        L12:
            r0.a((c) ZeusTransformUtils.preCheckCast(c.f33440a.decode(r8), c.class, "com.obric.aiagent.plugin"));
            goto L3
        L13:
            r0.a((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.aiagent.plugin"));
            goto L3
        L14:
            r0.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L7:
            FieldEncoding r4 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r8));
            goto L3
        L15:
            r8.endMessage(r1);
            return r0.a();
        }

        public f b(f r3) {
            a r2 = r3.a();
            if (r2.f33464c == null) goto L5;
            r2.f33464c = (c) ZeusTransformUtils.preCheckCast(c.f33440a.redact(r2.f33464c), c.class, "com.obric.aiagent.plugin");
        L5:
            Internal.redactElements(r2.f33465d, x.f33584a);
            Internal.redactElements(r2.f, y.f33591a);
            Internal.redactElements(r2.g, r.f33541a);
            r2.clearUnknownFields();
            return r2.a();
        }
    }

    @Override // com.squareup.wire.Message
    public /* synthetic */ Message.Builder newBuilder() {
        return a();
    }

    static {
        f33457a = new b();
        f33458b = 0;
    }

    public f(String r3, Integer r4, c r5, List<x> r6, Map<String, String> r7, List<y> r8, List<r> r9, e.h r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        super(f33457a, r10);
        this.f33459c = r3;
        this.f33460d = r4;
        this.f33461e = r5;
        this.f = Internal.immutableCopyOf("vertices", r11);
        this.g = Internal.immutableCopyOf("properties", r12);
        this.h = Internal.immutableCopyOf("polygons", r13);
        this.i = Internal.immutableCopyOf("multi_polygon", r14);
    }

    public a a() {
        a r0 = new a();
        r0.f33462a = this.f33459c;
        r0.f33463b = this.f33460d;
        r0.f33464c = this.f33461e;
        r0.f33465d = Internal.copyOf("vertices", this.f);
        r0.f33466e = Internal.copyOf("properties", this.g);
        r0.f = Internal.copyOf("polygons", this.h);
        r0.g = Internal.copyOf("multi_polygon", this.i);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L26;
        if (Internal.equals(this.f33459c, r6.f33459c) == false) goto L26;
        if (Internal.equals(this.f33460d, r6.f33460d) == false) goto L26;
        if (Internal.equals(this.f33461e, r6.f33461e) == false) goto L26;
        if (this.f.equals(r6.f) == false) goto L26;
        if (this.g.equals(r6.g) == false) goto L26;
        if (this.h.equals(r6.h) == false) goto L26;
        if (this.i.equals(r6.i) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f33459c;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.f33460d;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        c r9 = this.f33461e;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = ((((((((r8 + r3) * 37) + this.f.hashCode()) * 37) + this.g.hashCode()) * 37) + this.h.hashCode()) * 37) + this.i.hashCode();
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
        if (this.f33459c == null) goto L6;
        r0.append(", fenceid=").append(this.f33459c);
    L6:
        if (this.f33460d == null) goto L9;
        r0.append(", shape=").append(this.f33460d);
    L9:
        if (this.f33461e == null) goto L11;
        r0.append(", circular=").append(this.f33461e);
    L11:
        List<x> r1 = this.f;
        if (r1 != null) goto L14;
    L16:
        Map<String, String> r2 = this.g;
        if (r2 != null) goto L19;
    L21:
        List<y> r3 = this.h;
        if (r3 != null) goto L24;
    L26:
        List<r> r4 = this.i;
        if (r4 == null) goto L32;
        if (r4.isEmpty() == true) goto L32;
        r0.append(", multi_polygon=").append(this.i);
    L32:
        return r0.replace(0, 2, "Fence{").append('}').toString();
    L24:
        if (r3.isEmpty() == true) goto L26;
        r0.append(", polygons=").append(this.h);
        goto L26
    L19:
        if (r2.isEmpty() == true) goto L21;
        r0.append(", properties=").append(this.g);
        goto L21
    L14:
        if (r1.isEmpty() == true) goto L16;
        r0.append(", vertices=").append(this.f);
        goto L16
    }
}
