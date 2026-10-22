package com.obric.matrix.a;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: WsMessageInfo.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ax extends Message<ax, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<ax> f33426a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Long f33427b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Long f33428c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Integer f33429d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Integer f33430e = null;
    public static final e.h f = null;
    public static final Integer g = null;
    public static final Integer h = null;

    @SerializedName("seqId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long i;

    @SerializedName("logId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long j;

    @SerializedName(WsConstants.KEY_SERVICE)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer k;

    @SerializedName("method")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer l;

    @SerializedName("payloadType")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String m;

    @SerializedName("payloadEncoding")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String n;

    @SerializedName("payload")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 8)
    public final e.h o;

    @SerializedName("cmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    public final Integer p;

    @SerializedName("channelId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 10)
    public final Integer q;

    @SerializedName("headers")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final Map<String, String> r;

    /* JADX INFO: compiled from: WsMessageInfo.java */
    public static final class a extends Message.Builder<ax, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f33431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f33432b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f33433c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f33434d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f33435e;
        public String f;
        public e.h g;
        public Integer h;
        public Integer i;
        public Map<String, String> j;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33431a = 0L;
            this.f33432b = 0L;
            this.f33433c = 0;
            this.f33434d = 0;
            this.f33435e = "";
            this.f = "";
            this.g = e.h.f38723b;
            this.h = 0;
            this.i = 0;
            this.j = Internal.newMutableMap();
        }

        public a a(Long r1) {
            this.f33431a = r1;
            return this;
        }

        public a b(Long r1) {
            this.f33432b = r1;
            return this;
        }

        public a a(Integer r1) {
            this.f33433c = r1;
            return this;
        }

        public a b(Integer r1) {
            this.f33434d = r1;
            return this;
        }

        public a a(String r1) {
            this.f33435e = r1;
            return this;
        }

        public a b(String r1) {
            this.f = r1;
            return this;
        }

        public a a(e.h r1) {
            this.g = r1;
            return this;
        }

        public a c(Integer r1) {
            this.h = r1;
            return this;
        }

        public a d(Integer r1) {
            this.i = r1;
            return this;
        }

        public ax a() {
            return new ax(this.f33431a, this.f33432b, this.f33433c, this.f33434d, this.f33435e, this.f, this.g, this.h, this.i, this.j, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: WsMessageInfo.java */
    private static final class b extends ProtoAdapter<ax> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f33436a;

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ax decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, ax r4) {
            a(r3, (ax) ZeusTransformUtils.preCheckCast(r4, ax.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(ax r3) {
            return a((ax) ZeusTransformUtils.preCheckCast(r3, ax.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ax redact(ax r3) {
            return b((ax) ZeusTransformUtils.preCheckCast(r3, ax.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, ax.class);
            this.f33436a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(ax r5) {
            return (((((((((ProtoAdapter.INT64.encodedSizeWithTag(1, r5.i) + ProtoAdapter.INT64.encodedSizeWithTag(2, r5.j)) + ProtoAdapter.INT32.encodedSizeWithTag(3, r5.k)) + ProtoAdapter.INT32.encodedSizeWithTag(4, r5.l)) + ProtoAdapter.STRING.encodedSizeWithTag(6, r5.m)) + ProtoAdapter.STRING.encodedSizeWithTag(7, r5.n)) + ProtoAdapter.BYTES.encodedSizeWithTag(8, r5.o)) + ProtoAdapter.INT32.encodedSizeWithTag(9, r5.p)) + ProtoAdapter.INT32.encodedSizeWithTag(10, r5.q)) + this.f33436a.encodedSizeWithTag(11, r5.r)) + r5.unknownFields().k();
        }

        public void a(ProtoWriter r4, ax r5) {
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r5.i);
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r5.j);
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r5.k);
            ProtoAdapter.INT32.encodeWithTag(r4, 4, r5.l);
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r5.m);
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r5.n);
            ProtoAdapter.BYTES.encodeWithTag(r4, 8, r5.o);
            ProtoAdapter.INT32.encodeWithTag(r4, 9, r5.p);
            ProtoAdapter.INT32.encodeWithTag(r4, 10, r5.q);
            this.f33436a.encodeWithTag(r4, 11, r5.r);
            r4.writeBytes(r5.unknownFields());
        }

        public ax a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L18;
            switch(r3) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L7;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                default: goto L7;
            };
        L8:
            r0.j.putAll((Map) ZeusTransformUtils.preCheckCast(this.f33436a.decode(r8), Map.class, "com.obric.aiagent.plugin"));
            goto L3
        L9:
            r0.d((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.aiagent.plugin"));
            goto L3
        L10:
            r0.c((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.aiagent.plugin"));
            goto L3
        L11:
            r0.a((e.h) ZeusTransformUtils.preCheckCast(ProtoAdapter.BYTES.decode(r8), e.h.class, "com.obric.aiagent.plugin"));
            goto L3
        L12:
            r0.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L13:
            r0.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L14:
            r0.b((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.aiagent.plugin"));
            goto L3
        L15:
            r0.a((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.aiagent.plugin"));
            goto L3
        L16:
            r0.b((Long) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT64.decode(r8), Long.class, "com.obric.aiagent.plugin"));
            goto L3
        L17:
            r0.a((Long) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT64.decode(r8), Long.class, "com.obric.aiagent.plugin"));
            goto L3
        L7:
            FieldEncoding r4 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r8));
            goto L3
        L18:
            r8.endMessage(r1);
            return r0.a();
        }

        public ax b(ax r1) {
            a r0 = r1.a();
            r0.clearUnknownFields();
            return r0.a();
        }
    }

    @Override // com.squareup.wire.Message
    public /* synthetic */ Message.Builder newBuilder() {
        return a();
    }

    static {
        f33426a = new b();
        f33427b = 0L;
        f33428c = 0L;
        f33429d = 0;
        f33430e = 0;
        f = e.h.f38723b;
        g = 0;
        h = 0;
    }

    public ax(Long r3, Long r4, Integer r5, Integer r6, String r7, String r8, e.h r9, Integer r10, Integer r11, Map<String, String> r12, e.h r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        super(f33426a, r13);
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.l = r6;
        this.m = r7;
        this.n = r8;
        this.o = r9;
        this.p = r10;
        this.q = r11;
        this.r = Internal.immutableCopyOf("headers", r14);
    }

    public a a() {
        a r0 = new a();
        r0.f33431a = this.i;
        r0.f33432b = this.j;
        r0.f33433c = this.k;
        r0.f33434d = this.l;
        r0.f33435e = this.m;
        r0.f = this.n;
        r0.g = this.o;
        r0.h = this.p;
        r0.i = this.q;
        r0.j = Internal.copyOf("headers", this.r);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ax.class) == true) goto L8;
        return false;
    L8:
        ax r6 = (ax) ZeusTransformUtils.preCheckCast(r5, ax.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L32;
        if (Internal.equals(this.i, r6.i) == false) goto L32;
        if (Internal.equals(this.j, r6.j) == false) goto L32;
        if (Internal.equals(this.k, r6.k) == false) goto L32;
        if (Internal.equals(this.l, r6.l) == false) goto L32;
        if (Internal.equals(this.m, r6.m) == false) goto L32;
        if (Internal.equals(this.n, r6.n) == false) goto L32;
        if (Internal.equals(this.o, r6.o) == false) goto L32;
        if (Internal.equals(this.p, r6.p) == false) goto L32;
        if (Internal.equals(this.q, r6.q) == false) goto L32;
        if (this.r.equals(r6.r) == false) goto L32;
        return true;
    L32:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L41;
        int r1 = unknownFields().hashCode() * 37;
        Long r2 = this.i;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Long r6 = this.j;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Integer r9 = this.k;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Integer r12 = this.l;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.m;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.n;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        e.h r21 = this.o;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        Integer r24 = this.p;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        Integer r27 = this.q;
        if (r27 == null) goto L39;
        r3 = r27.hashCode();
    L39:
        int r28 = ((r26 + r3) * 37) + this.r.hashCode();
        this.hashCode = r28;
        return r28;
    L35:
        r25 = 0;
        goto L36
    L31:
        r22 = 0;
        goto L32
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
    L41:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.i == null) goto L6;
        r0.append(", seqId=").append(this.i);
    L6:
        if (this.j == null) goto L9;
        r0.append(", logId=").append(this.j);
    L9:
        if (this.k == null) goto L12;
        r0.append(", service=").append(this.k);
    L12:
        if (this.l == null) goto L15;
        r0.append(", method=").append(this.l);
    L15:
        if (this.m == null) goto L18;
        r0.append(", payloadType=").append(this.m);
    L18:
        if (this.n == null) goto L21;
        r0.append(", payloadEncoding=").append(this.n);
    L21:
        if (this.o == null) goto L24;
        r0.append(", payload=").append(this.o);
    L24:
        if (this.p == null) goto L27;
        r0.append(", cmd=").append(this.p);
    L27:
        if (this.q == null) goto L29;
        r0.append(", channelId=").append(this.q);
    L29:
        Map<String, String> r1 = this.r;
        if (r1 == null) goto L35;
        if (r1.isEmpty() == true) goto L35;
        r0.append(", headers=").append(this.r);
    L35:
        return r0.replace(0, 2, "WsMessageInfo{").append('}').toString();
    }
}
