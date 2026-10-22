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

/* JADX INFO: compiled from: MultiPolygon.java */
/* JADX INFO: loaded from: classes4.dex */
public final class r extends Message<r, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<r> f33541a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("polygons")
    @WireField(adapter = "com.obric.matrix.proto.Polygon#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<y> f33542b;

    /* JADX INFO: compiled from: MultiPolygon.java */
    public static final class a extends Message.Builder<r, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<y> f33543a;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33543a = Internal.newMutableList();
        }

        public r a() {
            return new r(this.f33543a, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: MultiPolygon.java */
    private static final class b extends ProtoAdapter<r> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ r decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, r r4) {
            a(r3, (r) ZeusTransformUtils.preCheckCast(r4, r.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(r r3) {
            return a((r) ZeusTransformUtils.preCheckCast(r3, r.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ r redact(r r3) {
            return b((r) ZeusTransformUtils.preCheckCast(r3, r.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, r.class);
        }

        public int a(r r3) {
            return y.f33591a.asRepeated().encodedSizeWithTag(1, r3.f33542b) + r3.unknownFields().k();
        }

        public void a(ProtoWriter r3, r r4) {
            y.f33591a.asRepeated().encodeWithTag(r3, 1, r4.f33542b);
            r3.writeBytes(r4.unknownFields());
        }

        public r a(ProtoReader r7) {
            a r6 = new a();
            long r0 = r7.beginMessage();
        L3:
            int r2 = r7.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r6.f33543a.add((y) ZeusTransformUtils.preCheckCast(y.f33591a.decode(r7), y.class, "com.obric.aiagent.plugin"));
            goto L3
        L7:
            FieldEncoding r3 = r7.peekFieldEncoding();
            r6.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r0);
            return r6.a();
        }

        public r b(r r2) {
            a r1 = r2.a();
            Internal.redactElements(r1.f33543a, y.f33591a);
            r1.clearUnknownFields();
            return r1.a();
        }
    }

    @Override // com.squareup.wire.Message
    public /* synthetic */ Message.Builder newBuilder() {
        return a();
    }

    static {
        f33541a = new b();
    }

    public r(List<y> r3, e.h r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        super(f33541a, r4);
        this.f33542b = Internal.immutableCopyOf("polygons", r5);
    }

    public a a() {
        a r0 = new a();
        r0.f33543a = Internal.copyOf("polygons", this.f33542b);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, r.class) == true) goto L8;
        return false;
    L8:
        r r6 = (r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this.f33542b.equals(r6.f33542b) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.f33542b.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        List<y> r1 = this.f33542b;
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        r0.append(", polygons=").append(this.f33542b);
    L8:
        return r0.replace(0, 2, "MultiPolygon{").append('}').toString();
    }
}
