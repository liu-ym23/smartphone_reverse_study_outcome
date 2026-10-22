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

/* JADX INFO: compiled from: GetIntersectFencesResponse.java */
/* JADX INFO: loaded from: classes4.dex */
public final class j extends Message<j, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<j> f33499a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("fences")
    @WireField(adapter = "com.obric.matrix.proto.Fence#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<f> f33500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("overlap_froms")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", label = WireField.Label.REPEATED, tag = 2)
    public final List<Double> f33501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("overlap_targets")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", label = WireField.Label.REPEATED, tag = 3)
    public final List<Double> f33502d;

    /* JADX INFO: compiled from: GetIntersectFencesResponse.java */
    public static final class a extends Message.Builder<j, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<f> f33503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<Double> f33504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<Double> f33505c;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33503a = Internal.newMutableList();
            this.f33504b = Internal.newMutableList();
            this.f33505c = Internal.newMutableList();
        }

        public j a() {
            return new j(this.f33503a, this.f33504b, this.f33505c, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: GetIntersectFencesResponse.java */
    private static final class b extends ProtoAdapter<j> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ j decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, j r4) {
            a(r3, (j) ZeusTransformUtils.preCheckCast(r4, j.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(j r3) {
            return a((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ j redact(j r3) {
            return b((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, j.class);
        }

        public int a(j r4) {
            return ((f.f33457a.asRepeated().encodedSizeWithTag(1, r4.f33500b) + ProtoAdapter.DOUBLE.asRepeated().encodedSizeWithTag(2, r4.f33501c)) + ProtoAdapter.DOUBLE.asRepeated().encodedSizeWithTag(3, r4.f33502d)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r3, j r4) {
            f.f33457a.asRepeated().encodeWithTag(r3, 1, r4.f33500b);
            ProtoAdapter.DOUBLE.asRepeated().encodeWithTag(r3, 2, r4.f33501c);
            ProtoAdapter.DOUBLE.asRepeated().encodeWithTag(r3, 3, r4.f33502d);
            r3.writeBytes(r4.unknownFields());
        }

        public j a(ProtoReader r7) {
            a r6 = new a();
            long r0 = r7.beginMessage();
        L3:
            int r2 = r7.nextTag();
            if (r2 == (-1)) goto L15;
            if (r2 != 1) goto L8;
            r6.f33503a.add((f) ZeusTransformUtils.preCheckCast(f.f33457a.decode(r7), f.class, "com.obric.aiagent.plugin"));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r6.f33504b.add((Double) ZeusTransformUtils.preCheckCast(ProtoAdapter.DOUBLE.decode(r7), Double.class, "com.obric.aiagent.plugin"));
            goto L3
        L10:
            if (r2 != 3) goto L11;
            r6.f33505c.add((Double) ZeusTransformUtils.preCheckCast(ProtoAdapter.DOUBLE.decode(r7), Double.class, "com.obric.aiagent.plugin"));
            goto L3
        L11:
            FieldEncoding r3 = r7.peekFieldEncoding();
            r6.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r0);
            return r6.a();
        }

        public j b(j r2) {
            a r1 = r2.a();
            Internal.redactElements(r1.f33503a, f.f33457a);
            r1.clearUnknownFields();
            return r1.a();
        }
    }

    @Override // com.squareup.wire.Message
    public /* synthetic */ Message.Builder newBuilder() {
        return a();
    }

    static {
        f33499a = new b();
    }

    public j(List<f> r3, List<Double> r4, List<Double> r5, e.h r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        super(f33499a, r6);
        this.f33500b = Internal.immutableCopyOf("fences", r7);
        this.f33501c = Internal.immutableCopyOf("overlap_froms", r8);
        this.f33502d = Internal.immutableCopyOf("overlap_targets", r9);
    }

    public a a() {
        a r0 = new a();
        r0.f33503a = Internal.copyOf("fences", this.f33500b);
        r0.f33504b = Internal.copyOf("overlap_froms", this.f33501c);
        r0.f33505c = Internal.copyOf("overlap_targets", this.f33502d);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L18;
        if (this.f33500b.equals(r6.f33500b) == false) goto L18;
        if (this.f33501c.equals(r6.f33501c) == false) goto L18;
        if (this.f33502d.equals(r6.f33502d) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (((((unknownFields().hashCode() * 37) + this.f33500b.hashCode()) * 37) + this.f33501c.hashCode()) * 37) + this.f33502d.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        List<f> r1 = this.f33500b;
        if (r1 != null) goto L5;
    L7:
        List<Double> r2 = this.f33501c;
        if (r2 != null) goto L10;
    L12:
        List<Double> r3 = this.f33502d;
        if (r3 == null) goto L18;
        if (r3.isEmpty() == true) goto L18;
        r0.append(", overlap_targets=").append(this.f33502d);
    L18:
        return r0.replace(0, 2, "GetIntersectFencesResponse{").append('}').toString();
    L10:
        if (r2.isEmpty() == true) goto L12;
        r0.append(", overlap_froms=").append(this.f33501c);
        goto L12
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", fences=").append(this.f33500b);
        goto L7
    }
}
