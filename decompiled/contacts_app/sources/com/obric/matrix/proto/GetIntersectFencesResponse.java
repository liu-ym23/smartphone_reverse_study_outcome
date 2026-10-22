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
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class GetIntersectFencesResponse extends Message<GetIntersectFencesResponse, Builder> {
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

    public static final class Builder extends Message.Builder<GetIntersectFencesResponse, Builder> {
        public List<Fence> fences;
        public List<Double> overlap_froms;
        public List<Double> overlap_targets;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.fences = Internal.newMutableList();
            this.overlap_froms = Internal.newMutableList();
            this.overlap_targets = Internal.newMutableList();
        }

        public Builder fences(List<Fence> r1) {
            Internal.checkElementsNotNull(r1);
            this.fences = r1;
            return this;
        }

        public Builder overlap_froms(List<Double> r1) {
            Internal.checkElementsNotNull(r1);
            this.overlap_froms = r1;
            return this;
        }

        public Builder overlap_targets(List<Double> r1) {
            Internal.checkElementsNotNull(r1);
            this.overlap_targets = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public GetIntersectFencesResponse build() {
            return new GetIntersectFencesResponse(this.fences, this.overlap_froms, this.overlap_targets, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_GetIntersectFencesResponse extends ProtoAdapter<GetIntersectFencesResponse> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetIntersectFencesResponse decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, GetIntersectFencesResponse r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetIntersectFencesResponse r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetIntersectFencesResponse redact(GetIntersectFencesResponse r1) {
            return redact2(r1);
        }

        public ProtoAdapter_GetIntersectFencesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetIntersectFencesResponse.class);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetIntersectFencesResponse r4) {
            return ((Fence.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.fences) + ProtoAdapter.DOUBLE.asRepeated().encodedSizeWithTag(2, r4.overlap_froms)) + ProtoAdapter.DOUBLE.asRepeated().encodedSizeWithTag(3, r4.overlap_targets)) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, GetIntersectFencesResponse r4) throws IOException {
            Fence.ADAPTER.asRepeated().encodeWithTag(r3, 1, r4.fences);
            ProtoAdapter.DOUBLE.asRepeated().encodeWithTag(r3, 2, r4.overlap_froms);
            ProtoAdapter.DOUBLE.asRepeated().encodeWithTag(r3, 3, r4.overlap_targets);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetIntersectFencesResponse decode(ProtoReader r6) throws IOException {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L15;
            if (r2 != 1) goto L8;
            r5.fences.add(Fence.ADAPTER.decode(r6));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.overlap_froms.add(ProtoAdapter.DOUBLE.decode(r6));
            goto L3
        L10:
            if (r2 != 3) goto L11;
            r5.overlap_targets.add(ProtoAdapter.DOUBLE.decode(r6));
            goto L3
        L11:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L15:
            r6.endMessage(r0);
            return r5.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public GetIntersectFencesResponse redact2(GetIntersectFencesResponse r2) {
            Builder r1 = r2.newBuilder();
            Internal.redactElements(r1.fences, Fence.ADAPTER);
            r1.clearUnknownFields();
            return r1.build();
        }
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    static {
        ADAPTER = new ProtoAdapter_GetIntersectFencesResponse();
    }

    public GetIntersectFencesResponse(List<Fence> r2, List<Double> r3, List<Double> r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public GetIntersectFencesResponse(List<Fence> r2, List<Double> r3, List<Double> r4, ByteString r5) {
        super(ADAPTER, r5);
        this.fences = Internal.immutableCopyOf("fences", r2);
        this.overlap_froms = Internal.immutableCopyOf("overlap_froms", r3);
        this.overlap_targets = Internal.immutableCopyOf("overlap_targets", r4);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.fences = Internal.copyOf("fences", this.fences);
        r0.overlap_froms = Internal.copyOf("overlap_froms", this.overlap_froms);
        r0.overlap_targets = Internal.copyOf("overlap_targets", this.overlap_targets);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof GetIntersectFencesResponse) == true) goto L8;
        return false;
    L8:
        GetIntersectFencesResponse r6 = (GetIntersectFencesResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L18;
        if (this.fences.equals(r6.fences) == false) goto L18;
        if (this.overlap_froms.equals(r6.overlap_froms) == false) goto L18;
        if (this.overlap_targets.equals(r6.overlap_targets) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (((((unknownFields().hashCode() * 37) + this.fences.hashCode()) * 37) + this.overlap_froms.hashCode()) * 37) + this.overlap_targets.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        List<Fence> r1 = this.fences;
        if (r1 != null) goto L5;
    L7:
        List<Double> r2 = this.overlap_froms;
        if (r2 != null) goto L10;
    L12:
        List<Double> r3 = this.overlap_targets;
        if (r3 == null) goto L18;
        if (r3.isEmpty() == true) goto L18;
        r0.append(", overlap_targets=").append(this.overlap_targets);
    L18:
        return r0.replace(0, 2, "GetIntersectFencesResponse{").append('}').toString();
    L10:
        if (r2.isEmpty() == true) goto L12;
        r0.append(", overlap_froms=").append(this.overlap_froms);
        goto L12
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", fences=").append(this.fences);
        goto L7
    }
}
