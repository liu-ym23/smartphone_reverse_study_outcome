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

/* JADX INFO: compiled from: Polygon.java */
/* JADX INFO: loaded from: classes4.dex */
public final class y extends Message<y, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<y> f33591a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("vertices")
    @WireField(adapter = "com.obric.matrix.proto.Point#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<x> f33592b;

    /* JADX INFO: compiled from: Polygon.java */
    public static final class a extends Message.Builder<y, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<x> f33593a;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33593a = Internal.newMutableList();
        }

        public y a() {
            return new y(this.f33593a, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: Polygon.java */
    private static final class b extends ProtoAdapter<y> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ y decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, y r4) {
            a(r3, (y) ZeusTransformUtils.preCheckCast(r4, y.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(y r3) {
            return a((y) ZeusTransformUtils.preCheckCast(r3, y.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ y redact(y r3) {
            return b((y) ZeusTransformUtils.preCheckCast(r3, y.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, y.class);
        }

        public int a(y r3) {
            return x.f33584a.asRepeated().encodedSizeWithTag(1, r3.f33592b) + r3.unknownFields().k();
        }

        public void a(ProtoWriter r3, y r4) {
            x.f33584a.asRepeated().encodeWithTag(r3, 1, r4.f33592b);
            r3.writeBytes(r4.unknownFields());
        }

        public y a(ProtoReader r7) {
            a r6 = new a();
            long r0 = r7.beginMessage();
        L3:
            int r2 = r7.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r6.f33593a.add((x) ZeusTransformUtils.preCheckCast(x.f33584a.decode(r7), x.class, "com.obric.aiagent.plugin"));
            goto L3
        L7:
            FieldEncoding r3 = r7.peekFieldEncoding();
            r6.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r0);
            return r6.a();
        }

        public y b(y r2) {
            a r1 = r2.a();
            Internal.redactElements(r1.f33593a, x.f33584a);
            r1.clearUnknownFields();
            return r1.a();
        }
    }

    @Override // com.squareup.wire.Message
    public /* synthetic */ Message.Builder newBuilder() {
        return a();
    }

    static {
        f33591a = new b();
    }

    public y(List<x> r3, e.h r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        super(f33591a, r4);
        this.f33592b = Internal.immutableCopyOf("vertices", r5);
    }

    public a a() {
        a r0 = new a();
        r0.f33593a = Internal.copyOf("vertices", this.f33592b);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, y.class) == true) goto L8;
        return false;
    L8:
        y r6 = (y) ZeusTransformUtils.preCheckCast(r5, y.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this.f33592b.equals(r6.f33592b) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.f33592b.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        List<x> r1 = this.f33592b;
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        r0.append(", vertices=").append(this.f33592b);
    L8:
        return r0.replace(0, 2, "Polygon{").append('}').toString();
    }
}
