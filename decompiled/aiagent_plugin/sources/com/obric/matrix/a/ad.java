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
import java.util.Map;

/* JADX INFO: compiled from: Response.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ad extends Message<ad, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<ad> f33286a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Integer f33287b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Integer f33288c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("cmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer f33289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("statusCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer f33290e;

    @SerializedName("errorMsg")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String f;

    @SerializedName("logId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String g;

    @SerializedName("sequenceId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String h;

    @SerializedName("body")
    @WireField(adapter = "com.obric.matrix.proto.ResponseBody#ADAPTER", tag = 7)
    public final ae i;

    @SerializedName("accessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String j;

    @SerializedName("monitorInfo")
    @WireField(adapter = "com.obric.matrix.proto.MonitorInfo#ADAPTER", tag = 9)
    public final q k;

    @SerializedName("extraParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final Map<String, String> l;

    /* JADX INFO: compiled from: Response.java */
    public static final class a extends Message.Builder<ad, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f33291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f33292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f33293c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f33294d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f33295e;
        public ae f;
        public String g;
        public q h;
        public Map<String, String> i;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33291a = 0;
            this.f33292b = 0;
            this.f33293c = "";
            this.f33294d = "";
            this.f33295e = "";
            this.g = "";
            this.i = Internal.newMutableMap();
        }

        public a a(Integer r1) {
            this.f33291a = r1;
            return this;
        }

        public a b(Integer r1) {
            this.f33292b = r1;
            return this;
        }

        public a a(String r1) {
            this.f33293c = r1;
            return this;
        }

        public a b(String r1) {
            this.f33294d = r1;
            return this;
        }

        public a c(String r1) {
            this.f33295e = r1;
            return this;
        }

        public a a(ae r1) {
            this.f = r1;
            return this;
        }

        public a d(String r1) {
            this.g = r1;
            return this;
        }

        public a a(q r1) {
            this.h = r1;
            return this;
        }

        public ad a() {
            return new ad(this.f33291a, this.f33292b, this.f33293c, this.f33294d, this.f33295e, this.f, this.g, this.h, this.i, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: Response.java */
    private static final class b extends ProtoAdapter<ad> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f33296a;

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ad decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, ad r4) {
            a(r3, (ad) ZeusTransformUtils.preCheckCast(r4, ad.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(ad r3) {
            return a((ad) ZeusTransformUtils.preCheckCast(r3, ad.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ad redact(ad r3) {
            return b((ad) ZeusTransformUtils.preCheckCast(r3, ad.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, ad.class);
            this.f33296a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(ad r5) {
            return ((((((((ProtoAdapter.INT32.encodedSizeWithTag(1, r5.f33289d) + ProtoAdapter.INT32.encodedSizeWithTag(2, r5.f33290e)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r5.f)) + ProtoAdapter.STRING.encodedSizeWithTag(4, r5.g)) + ProtoAdapter.STRING.encodedSizeWithTag(6, r5.h)) + ae.f33297a.encodedSizeWithTag(7, r5.i)) + ProtoAdapter.STRING.encodedSizeWithTag(8, r5.j)) + q.f33531a.encodedSizeWithTag(9, r5.k)) + this.f33296a.encodedSizeWithTag(10, r5.l)) + r5.unknownFields().k();
        }

        public void a(ProtoWriter r4, ad r5) {
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r5.f33289d);
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r5.f33290e);
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r5.f);
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r5.g);
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r5.h);
            ae.f33297a.encodeWithTag(r4, 7, r5.i);
            ProtoAdapter.STRING.encodeWithTag(r4, 8, r5.j);
            q.f33531a.encodeWithTag(r4, 9, r5.k);
            this.f33296a.encodeWithTag(r4, 10, r5.l);
            r4.writeBytes(r5.unknownFields());
        }

        public ad a(ProtoReader r8) {
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
                case 5: goto L7;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                default: goto L7;
            };
        L8:
            r0.i.putAll((Map) ZeusTransformUtils.preCheckCast(this.f33296a.decode(r8), Map.class, "com.obric.aiagent.plugin"));
            goto L3
        L9:
            r0.a((q) ZeusTransformUtils.preCheckCast(q.f33531a.decode(r8), q.class, "com.obric.aiagent.plugin"));
            goto L3
        L10:
            r0.d((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L11:
            r0.a((ae) ZeusTransformUtils.preCheckCast(ae.f33297a.decode(r8), ae.class, "com.obric.aiagent.plugin"));
            goto L3
        L12:
            r0.c((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L13:
            r0.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L14:
            r0.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L15:
            r0.b((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.aiagent.plugin"));
            goto L3
        L16:
            r0.a((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.aiagent.plugin"));
            goto L3
        L7:
            FieldEncoding r4 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r8));
            goto L3
        L17:
            r8.endMessage(r1);
            return r0.a();
        }

        public ad b(ad r3) {
            a r2 = r3.a();
            if (r2.f == null) goto L6;
            r2.f = (ae) ZeusTransformUtils.preCheckCast(ae.f33297a.redact(r2.f), ae.class, "com.obric.aiagent.plugin");
        L6:
            if (r2.h == null) goto L8;
            r2.h = (q) ZeusTransformUtils.preCheckCast(q.f33531a.redact(r2.h), q.class, "com.obric.aiagent.plugin");
        L8:
            r2.clearUnknownFields();
            return r2.a();
        }
    }

    @Override // com.squareup.wire.Message
    public /* synthetic */ Message.Builder newBuilder() {
        return a();
    }

    static {
        f33286a = new b();
        f33287b = 0;
        f33288c = 0;
    }

    public ad(Integer r3, Integer r4, String r5, String r6, String r7, ae r8, String r9, q r10, Map<String, String> r11, e.h r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        super(f33286a, r12);
        this.f33289d = r3;
        this.f33290e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.k = r10;
        this.l = Internal.immutableCopyOf("extraParams", r13);
    }

    public a a() {
        a r0 = new a();
        r0.f33291a = this.f33289d;
        r0.f33292b = this.f33290e;
        r0.f33293c = this.f;
        r0.f33294d = this.g;
        r0.f33295e = this.h;
        r0.f = this.i;
        r0.g = this.j;
        r0.h = this.k;
        r0.i = Internal.copyOf("extraParams", this.l);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ad.class) == true) goto L8;
        return false;
    L8:
        ad r6 = (ad) ZeusTransformUtils.preCheckCast(r5, ad.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L30;
        if (Internal.equals(this.f33289d, r6.f33289d) == false) goto L30;
        if (Internal.equals(this.f33290e, r6.f33290e) == false) goto L30;
        if (Internal.equals(this.f, r6.f) == false) goto L30;
        if (Internal.equals(this.g, r6.g) == false) goto L30;
        if (Internal.equals(this.h, r6.h) == false) goto L30;
        if (Internal.equals(this.i, r6.i) == false) goto L30;
        if (Internal.equals(this.j, r6.j) == false) goto L30;
        if (Internal.equals(this.k, r6.k) == false) goto L30;
        if (this.l.equals(r6.l) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L37;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f33289d;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.f33290e;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        String r12 = this.g;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.h;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        ae r18 = this.i;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.j;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        q r24 = this.k;
        if (r24 == null) goto L35;
        r3 = r24.hashCode();
    L35:
        int r25 = ((r23 + r3) * 37) + this.l.hashCode();
        this.hashCode = r25;
        return r25;
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
    L37:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f33289d == null) goto L6;
        r0.append(", cmd=").append(this.f33289d);
    L6:
        if (this.f33290e == null) goto L9;
        r0.append(", statusCode=").append(this.f33290e);
    L9:
        if (this.f == null) goto L12;
        r0.append(", errorMsg=").append(this.f);
    L12:
        if (this.g == null) goto L15;
        r0.append(", logId=").append(this.g);
    L15:
        if (this.h == null) goto L18;
        r0.append(", sequenceId=").append(this.h);
    L18:
        if (this.i == null) goto L21;
        r0.append(", body=").append(this.i);
    L21:
        if (this.j == null) goto L24;
        r0.append(", accessToken=").append(this.j);
    L24:
        if (this.k == null) goto L26;
        r0.append(", monitorInfo=").append(this.k);
    L26:
        Map<String, String> r1 = this.l;
        if (r1 == null) goto L32;
        if (r1.isEmpty() == true) goto L32;
        r0.append(", extraParams=").append(this.l);
    L32:
        return r0.replace(0, 2, "Response{").append('}').toString();
    }
}
