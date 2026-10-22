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
public final class GetIntersectFencesRequest extends Message<GetIntersectFencesRequest, a> {
    public static final ProtoAdapter<GetIntersectFencesRequest> ADAPTER = null;
    public static final Boolean DEFAULT_FILTER_ADJACENCY = null;
    public static final Boolean DEFAULT_WITH_BORDER_INFO = null;
    public static final Boolean DEFAULT_WITH_OVERLAP_FROM = null;
    public static final Boolean DEFAULT_WITH_OVERLAP_TARGET = null;
    private static final long serialVersionUID = 0;

    @SerializedName("fence_to_cal")
    @WireField(adapter = "com.obric.matrix.proto.Fence#ADAPTER", tag = 3)
    public final Fence fence_to_cal;

    @SerializedName("filter_adjacency")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean filter_adjacency;

    @SerializedName("from_dataset")
    @WireField(adapter = "com.obric.matrix.proto.TargetDataset#ADAPTER", tag = 4)
    public final TargetDataset from_dataset;

    @SerializedName("from_fence_id_list")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 5)
    public final List<String> from_fence_id_list;

    @SerializedName("properties_filter")
    @WireField(adapter = "com.obric.matrix.proto.StringArray#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, StringArray> properties_filter;

    @SerializedName("target_dataset")
    @WireField(adapter = "com.obric.matrix.proto.TargetDataset#ADAPTER", tag = 1)
    public final TargetDataset target_dataset;

    @SerializedName("with_border_info")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean with_border_info;

    @SerializedName("with_overlap_from")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean with_overlap_from;

    @SerializedName("with_overlap_target")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean with_overlap_target;

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TargetDataset f12001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f12002b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Fence f12003c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TargetDataset f12004d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List f12005e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Boolean f12006f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Boolean f12007g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Boolean f12008h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Boolean f12009i;

        public a() {
            Boolean r10 = Boolean.FALSE;
            this.f12006f = r10;
            this.f12007g = r10;
            this.f12008h = r10;
            this.f12009i = r10;
            this.f12002b = Internal.newMutableMap();
            this.f12005e = Internal.newMutableList();
        }

        public GetIntersectFencesRequest a() {
            return new GetIntersectFencesRequest(this.f12001a, this.f12002b, this.f12003c, this.f12004d, this.f12005e, this.f12006f, this.f12007g, this.f12008h, this.f12009i, super.buildUnknownFields());
        }

        public a b(Fence r10) {
            this.f12003c = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Boolean r10) {
            this.f12007g = r10;
            return this;
        }

        public a d(TargetDataset r10) {
            this.f12004d = r10;
            return this;
        }

        public a e(TargetDataset r10) {
            this.f12001a = r10;
            return this;
        }

        public a f(Boolean r10) {
            this.f12006f = r10;
            return this;
        }

        public a g(Boolean r10) {
            this.f12008h = r10;
            return this;
        }

        public a h(Boolean r10) {
            this.f12009i = r10;
            return this;
        }
    }

    public static final class b extends ProtoAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ProtoAdapter f12010a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, GetIntersectFencesRequest.class);
            this.f12010a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, StringArray.ADAPTER);
        }

        public GetIntersectFencesRequest a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L16;
            switch(r13) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r11.h(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L8:
            r11.g(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L9:
            r11.c(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L10:
            r11.f(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L11:
            r11.f12005e.add(ProtoAdapter.STRING.decode(r10));
            goto L3
        L12:
            r11.d(TargetDataset.ADAPTER.decode(r10));
            goto L3
        L13:
            r11.b(Fence.ADAPTER.decode(r10));
            goto L3
        L14:
            r11.f12002b.putAll((Map) this.f12010a.decode(r10));
            goto L3
        L15:
            r11.e(TargetDataset.ADAPTER.decode(r10));
            goto L3
        L6:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L16:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, GetIntersectFencesRequest r11) {
            ProtoAdapter<TargetDataset> r12 = TargetDataset.ADAPTER;
            r12.encodeWithTag(r10, 1, r11.target_dataset);
            this.f12010a.encodeWithTag(r10, 2, r11.properties_filter);
            Fence.ADAPTER.encodeWithTag(r10, 3, r11.fence_to_cal);
            r12.encodeWithTag(r10, 4, r11.from_dataset);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r10, 5, r11.from_fence_id_list);
            ProtoAdapter<Boolean> r13 = ProtoAdapter.BOOL;
            r13.encodeWithTag(r10, 6, r11.with_border_info);
            r13.encodeWithTag(r10, 7, r11.filter_adjacency);
            r13.encodeWithTag(r10, 8, r11.with_overlap_from);
            r13.encodeWithTag(r10, 9, r11.with_overlap_target);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(GetIntersectFencesRequest r10) {
            ProtoAdapter<TargetDataset> r11 = TargetDataset.ADAPTER;
            int r12 = (((r11.encodedSizeWithTag(1, r10.target_dataset) + this.f12010a.encodedSizeWithTag(2, r10.properties_filter)) + Fence.ADAPTER.encodedSizeWithTag(3, r10.fence_to_cal)) + r11.encodedSizeWithTag(4, r10.from_dataset)) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(5, r10.from_fence_id_list);
            ProtoAdapter<Boolean> r13 = ProtoAdapter.BOOL;
            return ((((r12 + r13.encodedSizeWithTag(6, r10.with_border_info)) + r13.encodedSizeWithTag(7, r10.filter_adjacency)) + r13.encodedSizeWithTag(8, r10.with_overlap_from)) + r13.encodedSizeWithTag(9, r10.with_overlap_target)) + r10.unknownFields().size();
        }

        public GetIntersectFencesRequest d(GetIntersectFencesRequest r10) {
            a r11 = r10.newBuilder();
            TargetDataset r12 = r11.f12001a;
            if (r12 == null) goto L5;
            r11.f12001a = TargetDataset.ADAPTER.redact(r12);
        L5:
            Internal.redactElements(r11.f12002b, StringArray.ADAPTER);
            Fence r13 = r11.f12003c;
            if (r13 == null) goto L8;
            r11.f12003c = Fence.ADAPTER.redact(r13);
        L8:
            TargetDataset r14 = r11.f12004d;
            if (r14 == null) goto L11;
            r11.f12004d = TargetDataset.ADAPTER.redact(r14);
        L11:
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) {
            b(r10, (GetIntersectFencesRequest) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((GetIntersectFencesRequest) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((GetIntersectFencesRequest) r10);
        }
    }

    static {
        ADAPTER = new b();
        Boolean r10 = Boolean.FALSE;
        DEFAULT_WITH_BORDER_INFO = r10;
        DEFAULT_FILTER_ADJACENCY = r10;
        DEFAULT_WITH_OVERLAP_FROM = r10;
        DEFAULT_WITH_OVERLAP_TARGET = r10;
    }

    public GetIntersectFencesRequest(TargetDataset r12, Map<String, StringArray> r13, Fence r14, TargetDataset r15, List<String> r16, Boolean r17, Boolean r18, Boolean r19, Boolean r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof GetIntersectFencesRequest) == true) goto L8;
        return false;
    L8:
        GetIntersectFencesRequest r11 = (GetIntersectFencesRequest) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L30;
        if (Internal.equals(this.target_dataset, r11.target_dataset) == false) goto L30;
        if (this.properties_filter.equals(r11.properties_filter) == false) goto L30;
        if (Internal.equals(this.fence_to_cal, r11.fence_to_cal) == false) goto L30;
        if (Internal.equals(this.from_dataset, r11.from_dataset) == false) goto L30;
        if (this.from_fence_id_list.equals(r11.from_fence_id_list) == false) goto L30;
        if (Internal.equals(this.with_border_info, r11.with_border_info) == false) goto L30;
        if (Internal.equals(this.filter_adjacency, r11.filter_adjacency) == false) goto L30;
        if (Internal.equals(this.with_overlap_from, r11.with_overlap_from) == false) goto L30;
        if (Internal.equals(this.with_overlap_target, r11.with_overlap_target) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L33;
        int r11 = unknownFields().hashCode() * 37;
        TargetDataset r12 = this.target_dataset;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (((r11 + r14) * 37) + this.properties_filter.hashCode()) * 37;
        Fence r16 = this.fence_to_cal;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        TargetDataset r19 = this.from_dataset;
        if (r19 == null) goto L15;
        int r20 = r19.hashCode();
    L16:
        int r21 = (((r18 + r20) * 37) + this.from_fence_id_list.hashCode()) * 37;
        Boolean r22 = this.with_border_info;
        if (r22 == null) goto L19;
        int r23 = r22.hashCode();
    L20:
        int r24 = (r21 + r23) * 37;
        Boolean r25 = this.filter_adjacency;
        if (r25 == null) goto L23;
        int r26 = r25.hashCode();
    L24:
        int r27 = (r24 + r26) * 37;
        Boolean r28 = this.with_overlap_from;
        if (r28 == null) goto L27;
        int r29 = r28.hashCode();
    L28:
        int r30 = (r27 + r29) * 37;
        Boolean r31 = this.with_overlap_target;
        if (r31 == null) goto L31;
        r13 = r31.hashCode();
    L31:
        int r32 = r30 + r13;
        this.hashCode = r32;
        return r32;
    L27:
        r29 = 0;
        goto L28
    L23:
        r26 = 0;
        goto L24
    L19:
        r23 = 0;
        goto L20
    L15:
        r20 = 0;
        goto L16
    L11:
        r17 = 0;
        goto L12
    L7:
        r14 = 0;
        goto L8
    L33:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.target_dataset == null) goto L5;
        r10.append(", target_dataset=");
        r10.append(this.target_dataset);
    L5:
        Map<String, StringArray> r11 = this.properties_filter;
        if (r11 == null) goto L11;
        if (r11.isEmpty() == true) goto L11;
        r10.append(", properties_filter=");
        r10.append(this.properties_filter);
    L11:
        if (this.fence_to_cal == null) goto L14;
        r10.append(", fence_to_cal=");
        r10.append(this.fence_to_cal);
    L14:
        if (this.from_dataset == null) goto L16;
        r10.append(", from_dataset=");
        r10.append(this.from_dataset);
    L16:
        List<String> r12 = this.from_fence_id_list;
        if (r12 == null) goto L22;
        if (r12.isEmpty() == true) goto L22;
        r10.append(", from_fence_id_list=");
        r10.append(this.from_fence_id_list);
    L22:
        if (this.with_border_info == null) goto L25;
        r10.append(", with_border_info=");
        r10.append(this.with_border_info);
    L25:
        if (this.filter_adjacency == null) goto L28;
        r10.append(", filter_adjacency=");
        r10.append(this.filter_adjacency);
    L28:
        if (this.with_overlap_from == null) goto L31;
        r10.append(", with_overlap_from=");
        r10.append(this.with_overlap_from);
    L31:
        if (this.with_overlap_target == null) goto L33;
        r10.append(", with_overlap_target=");
        r10.append(this.with_overlap_target);
    L33:
        StringBuilder r13 = r10.replace(0, 2, "GetIntersectFencesRequest{");
        r13.append('}');
        return r13.toString();
    }

    public GetIntersectFencesRequest(TargetDataset r10, Map<String, StringArray> r11, Fence r12, TargetDataset r13, List<String> r14, Boolean r15, Boolean r16, Boolean r17, Boolean r18, ByteString r19) {
        super(ADAPTER, r19);
        this.target_dataset = r10;
        this.properties_filter = Internal.immutableCopyOf("properties_filter", r11);
        this.fence_to_cal = r12;
        this.from_dataset = r13;
        this.from_fence_id_list = Internal.immutableCopyOf("from_fence_id_list", r14);
        this.with_border_info = r15;
        this.filter_adjacency = r16;
        this.with_overlap_from = r17;
        this.with_overlap_target = r18;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f12001a = this.target_dataset;
        r10.f12002b = Internal.copyOf("properties_filter", this.properties_filter);
        r10.f12003c = this.fence_to_cal;
        r10.f12004d = this.from_dataset;
        r10.f12005e = Internal.copyOf("from_fence_id_list", this.from_fence_id_list);
        r10.f12006f = this.with_border_info;
        r10.f12007g = this.filter_adjacency;
        r10.f12008h = this.with_overlap_from;
        r10.f12009i = this.with_overlap_target;
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
