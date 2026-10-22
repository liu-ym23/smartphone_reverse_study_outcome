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
public final class GetIntersectFencesResponse extends Message<GetIntersectFencesResponse, a> {
    public static final ProtoAdapter<GetIntersectFencesResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("fences")
    @WireField(adapter = "com.obric.matrix.proto.Fence#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<Fence> fences;

    @SerializedName("overlap_froms")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", label = WireField.Label.REPEATED, tag = 2)
    public final List<Double> overlap_froms;

    @SerializedName("overlap_targets")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", label = WireField.Label.REPEATED, tag = 3)
    public final List<Double> overlap_targets;

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f12011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List f12012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f12013c;

        public a() {
            this.f12011a = Internal.newMutableList();
            this.f12012b = Internal.newMutableList();
            this.f12013c = Internal.newMutableList();
        }

        public GetIntersectFencesResponse a() {
            return new GetIntersectFencesResponse(this.f12011a, this.f12012b, this.f12013c, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends ProtoAdapter {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, GetIntersectFencesResponse.class);
        }

        public GetIntersectFencesResponse a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L15;
            if (r13 != 1) goto L8;
            r11.f12011a.add(Fence.ADAPTER.decode(r10));
            goto L3
        L8:
            if (r13 != 2) goto L10;
            r11.f12012b.add(ProtoAdapter.DOUBLE.decode(r10));
            goto L3
        L10:
            if (r13 != 3) goto L11;
            r11.f12013c.add(ProtoAdapter.DOUBLE.decode(r10));
            goto L3
        L11:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L15:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, GetIntersectFencesResponse r11) {
            Fence.ADAPTER.asRepeated().encodeWithTag(r10, 1, r11.fences);
            ProtoAdapter<Double> r12 = ProtoAdapter.DOUBLE;
            r12.asRepeated().encodeWithTag(r10, 2, r11.overlap_froms);
            r12.asRepeated().encodeWithTag(r10, 3, r11.overlap_targets);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(GetIntersectFencesResponse r10) {
            int r11 = Fence.ADAPTER.asRepeated().encodedSizeWithTag(1, r10.fences);
            ProtoAdapter<Double> r12 = ProtoAdapter.DOUBLE;
            return ((r11 + r12.asRepeated().encodedSizeWithTag(2, r10.overlap_froms)) + r12.asRepeated().encodedSizeWithTag(3, r10.overlap_targets)) + r10.unknownFields().size();
        }

        public GetIntersectFencesResponse d(GetIntersectFencesResponse r10) {
            a r11 = r10.newBuilder();
            Internal.redactElements(r11.f12011a, Fence.ADAPTER);
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) {
            b(r10, (GetIntersectFencesResponse) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((GetIntersectFencesResponse) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((GetIntersectFencesResponse) r10);
        }
    }

    static {
        ADAPTER = new b();
    }

    public GetIntersectFencesResponse(List<Fence> r10, List<Double> r11, List<Double> r12) {
        this(r10, r11, r12, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof GetIntersectFencesResponse) == true) goto L8;
        return false;
    L8:
        GetIntersectFencesResponse r11 = (GetIntersectFencesResponse) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L18;
        if (this.fences.equals(r11.fences) == false) goto L18;
        if (this.overlap_froms.equals(r11.overlap_froms) == false) goto L18;
        if (this.overlap_targets.equals(r11.overlap_targets) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L6;
        int r11 = (((((unknownFields().hashCode() * 37) + this.fences.hashCode()) * 37) + this.overlap_froms.hashCode()) * 37) + this.overlap_targets.hashCode();
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
        List<Fence> r11 = this.fences;
        if (r11 != null) goto L5;
    L7:
        List<Double> r12 = this.overlap_froms;
        if (r12 != null) goto L10;
    L12:
        List<Double> r13 = this.overlap_targets;
        if (r13 != null) goto L15;
    L17:
        StringBuilder r14 = r10.replace(0, 2, "GetIntersectFencesResponse{");
        r14.append('}');
        return r14.toString();
    L15:
        if (r13.isEmpty() == true) goto L17;
        r10.append(", overlap_targets=");
        r10.append(this.overlap_targets);
        goto L17
    L10:
        if (r12.isEmpty() == true) goto L12;
        r10.append(", overlap_froms=");
        r10.append(this.overlap_froms);
        goto L12
    L5:
        if (r11.isEmpty() == true) goto L7;
        r10.append(", fences=");
        r10.append(this.fences);
        goto L7
    }

    public GetIntersectFencesResponse(List<Fence> r10, List<Double> r11, List<Double> r12, ByteString r13) {
        super(ADAPTER, r13);
        this.fences = Internal.immutableCopyOf("fences", r10);
        this.overlap_froms = Internal.immutableCopyOf("overlap_froms", r11);
        this.overlap_targets = Internal.immutableCopyOf("overlap_targets", r12);
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f12011a = Internal.copyOf("fences", this.fences);
        r10.f12012b = Internal.copyOf("overlap_froms", this.overlap_froms);
        r10.f12013c = Internal.copyOf("overlap_targets", this.overlap_targets);
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
