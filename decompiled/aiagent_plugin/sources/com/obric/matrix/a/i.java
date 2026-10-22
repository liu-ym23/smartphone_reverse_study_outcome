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

/* JADX INFO: compiled from: GetIntersectFencesRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i extends Message<i, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<i> f33488a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Boolean f33489b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Boolean f33490c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Boolean f33491d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Boolean f33492e = null;

    @SerializedName("target_dataset")
    @WireField(adapter = "com.obric.matrix.proto.TargetDataset#ADAPTER", tag = 1)
    public final aw f;

    @SerializedName("properties_filter")
    @WireField(adapter = "com.obric.matrix.proto.StringArray#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, al> g;

    @SerializedName("fence_to_cal")
    @WireField(adapter = "com.obric.matrix.proto.Fence#ADAPTER", tag = 3)
    public final f h;

    @SerializedName("from_dataset")
    @WireField(adapter = "com.obric.matrix.proto.TargetDataset#ADAPTER", tag = 4)
    public final aw i;

    @SerializedName("from_fence_id_list")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 5)
    public final List<String> j;

    @SerializedName("with_border_info")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean k;

    @SerializedName("filter_adjacency")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean l;

    @SerializedName("with_overlap_from")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean m;

    @SerializedName("with_overlap_target")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean n;

    /* JADX INFO: compiled from: GetIntersectFencesRequest.java */
    public static final class a extends Message.Builder<i, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public aw f33493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, al> f33494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f f33495c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public aw f33496d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List<String> f33497e;
        public Boolean f;
        public Boolean g;
        public Boolean h;
        public Boolean i;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.f33494b = Internal.newMutableMap();
            this.f33497e = Internal.newMutableList();
        }

        public a a(aw r1) {
            this.f33493a = r1;
            return this;
        }

        public a a(f r1) {
            this.f33495c = r1;
            return this;
        }

        public a b(aw r1) {
            this.f33496d = r1;
            return this;
        }

        public a a(Boolean r1) {
            this.f = r1;
            return this;
        }

        public a b(Boolean r1) {
            this.g = r1;
            return this;
        }

        public a c(Boolean r1) {
            this.h = r1;
            return this;
        }

        public a d(Boolean r1) {
            this.i = r1;
            return this;
        }

        public i a() {
            return new i(this.f33493a, this.f33494b, this.f33495c, this.f33496d, this.f33497e, this.f, this.g, this.h, this.i, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: GetIntersectFencesRequest.java */
    private static final class b extends ProtoAdapter<i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, al>> f33498a;

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ i decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, i r4) {
            a(r3, (i) ZeusTransformUtils.preCheckCast(r4, i.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(i r3) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ i redact(i r3) {
            return b((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, i.class);
            this.f33498a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, al.f33346a);
        }

        public int a(i r4) {
            return ((((((((aw.f33417a.encodedSizeWithTag(1, r4.f) + this.f33498a.encodedSizeWithTag(2, r4.g)) + f.f33457a.encodedSizeWithTag(3, r4.h)) + aw.f33417a.encodedSizeWithTag(4, r4.i)) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(5, r4.j)) + ProtoAdapter.BOOL.encodedSizeWithTag(6, r4.k)) + ProtoAdapter.BOOL.encodedSizeWithTag(7, r4.l)) + ProtoAdapter.BOOL.encodedSizeWithTag(8, r4.m)) + ProtoAdapter.BOOL.encodedSizeWithTag(9, r4.n)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r4, i r5) {
            aw.f33417a.encodeWithTag(r4, 1, r5.f);
            this.f33498a.encodeWithTag(r4, 2, r5.g);
            f.f33457a.encodeWithTag(r4, 3, r5.h);
            aw.f33417a.encodeWithTag(r4, 4, r5.i);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 5, r5.j);
            ProtoAdapter.BOOL.encodeWithTag(r4, 6, r5.k);
            ProtoAdapter.BOOL.encodeWithTag(r4, 7, r5.l);
            ProtoAdapter.BOOL.encodeWithTag(r4, 8, r5.m);
            ProtoAdapter.BOOL.encodeWithTag(r4, 9, r5.n);
            r4.writeBytes(r5.unknownFields());
        }

        public i a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                default: goto L7;
            };
        L8:
            r0.d((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r8), Boolean.class, "com.obric.aiagent.plugin"));
            goto L3
        L9:
            r0.c((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r8), Boolean.class, "com.obric.aiagent.plugin"));
            goto L3
        L10:
            r0.b((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r8), Boolean.class, "com.obric.aiagent.plugin"));
            goto L3
        L11:
            r0.a((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r8), Boolean.class, "com.obric.aiagent.plugin"));
            goto L3
        L12:
            r0.f33497e.add((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L13:
            r0.b((aw) ZeusTransformUtils.preCheckCast(aw.f33417a.decode(r8), aw.class, "com.obric.aiagent.plugin"));
            goto L3
        L14:
            r0.a((f) ZeusTransformUtils.preCheckCast(f.f33457a.decode(r8), f.class, "com.obric.aiagent.plugin"));
            goto L3
        L15:
            r0.f33494b.putAll((Map) ZeusTransformUtils.preCheckCast(this.f33498a.decode(r8), Map.class, "com.obric.aiagent.plugin"));
            goto L3
        L16:
            r0.a((aw) ZeusTransformUtils.preCheckCast(aw.f33417a.decode(r8), aw.class, "com.obric.aiagent.plugin"));
            goto L3
        L7:
            FieldEncoding r4 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r8));
            goto L3
        L17:
            r8.endMessage(r1);
            return r0.a();
        }

        public i b(i r3) {
            a r2 = r3.a();
            if (r2.f33493a == null) goto L5;
            r2.f33493a = (aw) ZeusTransformUtils.preCheckCast(aw.f33417a.redact(r2.f33493a), aw.class, "com.obric.aiagent.plugin");
        L5:
            Internal.redactElements(r2.f33494b, al.f33346a);
            if (r2.f33495c == null) goto L9;
            r2.f33495c = (f) ZeusTransformUtils.preCheckCast(f.f33457a.redact(r2.f33495c), f.class, "com.obric.aiagent.plugin");
        L9:
            if (r2.f33496d == null) goto L11;
            r2.f33496d = (aw) ZeusTransformUtils.preCheckCast(aw.f33417a.redact(r2.f33496d), aw.class, "com.obric.aiagent.plugin");
        L11:
            r2.clearUnknownFields();
            return r2.a();
        }
    }

    @Override // com.squareup.wire.Message
    public /* synthetic */ Message.Builder newBuilder() {
        return a();
    }

    static {
        f33488a = new b();
        f33489b = false;
        f33490c = false;
        f33491d = false;
        f33492e = false;
    }

    public i(aw r3, Map<String, al> r4, f r5, aw r6, List<String> r7, Boolean r8, Boolean r9, Boolean r10, Boolean r11, e.h r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        super(f33488a, r12);
        this.f = r3;
        this.g = Internal.immutableCopyOf("properties_filter", r13);
        this.h = r5;
        this.i = r6;
        this.j = Internal.immutableCopyOf("from_fence_id_list", r14);
        this.k = r8;
        this.l = r9;
        this.m = r10;
        this.n = r11;
    }

    public a a() {
        a r0 = new a();
        r0.f33493a = this.f;
        r0.f33494b = Internal.copyOf("properties_filter", this.g);
        r0.f33495c = this.h;
        r0.f33496d = this.i;
        r0.f33497e = Internal.copyOf("from_fence_id_list", this.j);
        r0.f = this.k;
        r0.g = this.l;
        r0.h = this.m;
        r0.i = this.n;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L30;
        if (Internal.equals(this.f, r6.f) == false) goto L30;
        if (this.g.equals(r6.g) == false) goto L30;
        if (Internal.equals(this.h, r6.h) == false) goto L30;
        if (Internal.equals(this.i, r6.i) == false) goto L30;
        if (this.j.equals(r6.j) == false) goto L30;
        if (Internal.equals(this.k, r6.k) == false) goto L30;
        if (Internal.equals(this.l, r6.l) == false) goto L30;
        if (Internal.equals(this.m, r6.m) == false) goto L30;
        if (Internal.equals(this.n, r6.n) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L33;
        int r1 = unknownFields().hashCode() * 37;
        aw r2 = this.f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (((r1 + r4) * 37) + this.g.hashCode()) * 37;
        f r6 = this.h;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        aw r9 = this.i;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (((r8 + r10) * 37) + this.j.hashCode()) * 37;
        Boolean r12 = this.k;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Boolean r15 = this.l;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        Boolean r18 = this.m;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        Boolean r21 = this.n;
        if (r21 == null) goto L31;
        r3 = r21.hashCode();
    L31:
        int r22 = r20 + r3;
        this.hashCode = r22;
        return r22;
    L27:
        r19 = 0;
        goto L28
    L23:
        r16 = 0;
        goto L24
    L19:
        r13 = 0;
        goto L20
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L33:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f == null) goto L5;
        r0.append(", target_dataset=").append(this.f);
    L5:
        Map<String, al> r1 = this.g;
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.append(", properties_filter=").append(this.g);
    L11:
        if (this.h == null) goto L14;
        r0.append(", fence_to_cal=").append(this.h);
    L14:
        if (this.i == null) goto L16;
        r0.append(", from_dataset=").append(this.i);
    L16:
        List<String> r2 = this.j;
        if (r2 == null) goto L22;
        if (r2.isEmpty() == true) goto L22;
        r0.append(", from_fence_id_list=").append(this.j);
    L22:
        if (this.k == null) goto L25;
        r0.append(", with_border_info=").append(this.k);
    L25:
        if (this.l == null) goto L28;
        r0.append(", filter_adjacency=").append(this.l);
    L28:
        if (this.m == null) goto L31;
        r0.append(", with_overlap_from=").append(this.m);
    L31:
        if (this.n == null) goto L34;
        r0.append(", with_overlap_target=").append(this.n);
    L34:
        return r0.replace(0, 2, "GetIntersectFencesRequest{").append('}').toString();
    }
}
