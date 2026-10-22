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

/* JADX INFO: compiled from: LocationInfo.java */
/* JADX INFO: loaded from: classes4.dex */
public final class o extends Message<o, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<o> f33516a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Double f33517b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Double f33518c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("longitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 1)
    public final Double f33519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("latitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double f33520e;

    @SerializedName("country")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String f;

    @SerializedName("countryCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String g;

    @SerializedName("administrativeArea")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String h;

    @SerializedName("city")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String i;

    @SerializedName("district")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String j;

    @SerializedName("town")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String k;

    @SerializedName("street")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String l;

    @SerializedName("subAdministrativeArea")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String m;

    @SerializedName("locality")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String n;

    @SerializedName("subLocality")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String o;

    @SerializedName("addressLine")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    public final String p;

    /* JADX INFO: compiled from: LocationInfo.java */
    public static final class a extends Message.Builder<o, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Double f33521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Double f33522b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f33523c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f33524d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f33525e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            Double r0 = Double.valueOf(0.0d);
            this.f33521a = r0;
            this.f33522b = r0;
            this.f33523c = "";
            this.f33524d = "";
            this.f33525e = "";
            this.f = "";
            this.g = "";
            this.h = "";
            this.i = "";
            this.j = "";
            this.k = "";
            this.l = "";
            this.m = "";
        }

        public a a(Double r1) {
            this.f33521a = r1;
            return this;
        }

        public a b(Double r1) {
            this.f33522b = r1;
            return this;
        }

        public a a(String r1) {
            this.f33523c = r1;
            return this;
        }

        public a b(String r1) {
            this.f33524d = r1;
            return this;
        }

        public a c(String r1) {
            this.f33525e = r1;
            return this;
        }

        public a d(String r1) {
            this.f = r1;
            return this;
        }

        public a e(String r1) {
            this.g = r1;
            return this;
        }

        public a f(String r1) {
            this.h = r1;
            return this;
        }

        public a g(String r1) {
            this.i = r1;
            return this;
        }

        public a h(String r1) {
            this.j = r1;
            return this;
        }

        public a i(String r1) {
            this.k = r1;
            return this;
        }

        public a j(String r1) {
            this.l = r1;
            return this;
        }

        public a k(String r1) {
            this.m = r1;
            return this;
        }

        public o a() {
            return new o(this.f33521a, this.f33522b, this.f33523c, this.f33524d, this.f33525e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: LocationInfo.java */
    private static final class b extends ProtoAdapter<o> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ o decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, o r4) {
            a(r3, (o) ZeusTransformUtils.preCheckCast(r4, o.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(o r3) {
            return a((o) ZeusTransformUtils.preCheckCast(r3, o.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ o redact(o r3) {
            return b((o) ZeusTransformUtils.preCheckCast(r3, o.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, o.class);
        }

        public int a(o r4) {
            return ((((((((((((ProtoAdapter.DOUBLE.encodedSizeWithTag(1, r4.f33519d) + ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r4.f33520e)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r4.f)) + ProtoAdapter.STRING.encodedSizeWithTag(4, r4.g)) + ProtoAdapter.STRING.encodedSizeWithTag(5, r4.h)) + ProtoAdapter.STRING.encodedSizeWithTag(6, r4.i)) + ProtoAdapter.STRING.encodedSizeWithTag(7, r4.j)) + ProtoAdapter.STRING.encodedSizeWithTag(8, r4.k)) + ProtoAdapter.STRING.encodedSizeWithTag(9, r4.l)) + ProtoAdapter.STRING.encodedSizeWithTag(10, r4.m)) + ProtoAdapter.STRING.encodedSizeWithTag(11, r4.n)) + ProtoAdapter.STRING.encodedSizeWithTag(12, r4.o)) + ProtoAdapter.STRING.encodedSizeWithTag(13, r4.p)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r3, o r4) {
            ProtoAdapter.DOUBLE.encodeWithTag(r3, 1, r4.f33519d);
            ProtoAdapter.DOUBLE.encodeWithTag(r3, 2, r4.f33520e);
            ProtoAdapter.STRING.encodeWithTag(r3, 3, r4.f);
            ProtoAdapter.STRING.encodeWithTag(r3, 4, r4.g);
            ProtoAdapter.STRING.encodeWithTag(r3, 5, r4.h);
            ProtoAdapter.STRING.encodeWithTag(r3, 6, r4.i);
            ProtoAdapter.STRING.encodeWithTag(r3, 7, r4.j);
            ProtoAdapter.STRING.encodeWithTag(r3, 8, r4.k);
            ProtoAdapter.STRING.encodeWithTag(r3, 9, r4.l);
            ProtoAdapter.STRING.encodeWithTag(r3, 10, r4.m);
            ProtoAdapter.STRING.encodeWithTag(r3, 11, r4.n);
            ProtoAdapter.STRING.encodeWithTag(r3, 12, r4.o);
            ProtoAdapter.STRING.encodeWithTag(r3, 13, r4.p);
            r3.writeBytes(r4.unknownFields());
        }

        public o a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L21;
            switch(r2) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r5.k((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L9:
            r5.j((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L10:
            r5.i((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L11:
            r5.h((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L12:
            r5.g((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L13:
            r5.f((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L14:
            r5.e((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L15:
            r5.d((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L16:
            r5.c((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L17:
            r5.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L18:
            r5.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L19:
            r5.b((Double) ZeusTransformUtils.preCheckCast(ProtoAdapter.DOUBLE.decode(r6), Double.class, "com.obric.aiagent.plugin"));
            goto L3
        L20:
            r5.a((Double) ZeusTransformUtils.preCheckCast(ProtoAdapter.DOUBLE.decode(r6), Double.class, "com.obric.aiagent.plugin"));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L21:
            r6.endMessage(r0);
            return r5.a();
        }

        public o b(o r1) {
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
        f33516a = new b();
        Double r0 = Double.valueOf(0.0d);
        f33517b = r0;
        f33518c = r0;
    }

    public o(Double r2, Double r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, e.h r15) {
        super(f33516a, r15);
        this.f33519d = r2;
        this.f33520e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.k = r9;
        this.l = r10;
        this.m = r11;
        this.n = r12;
        this.o = r13;
        this.p = r14;
    }

    public a a() {
        a r0 = new a();
        r0.f33521a = this.f33519d;
        r0.f33522b = this.f33520e;
        r0.f33523c = this.f;
        r0.f33524d = this.g;
        r0.f33525e = this.h;
        r0.f = this.i;
        r0.g = this.j;
        r0.h = this.k;
        r0.i = this.l;
        r0.j = this.m;
        r0.k = this.n;
        r0.l = this.o;
        r0.m = this.p;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, o.class) == true) goto L8;
        return false;
    L8:
        o r6 = (o) ZeusTransformUtils.preCheckCast(r5, o.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L38;
        if (Internal.equals(this.f33519d, r6.f33519d) == false) goto L38;
        if (Internal.equals(this.f33520e, r6.f33520e) == false) goto L38;
        if (Internal.equals(this.f, r6.f) == false) goto L38;
        if (Internal.equals(this.g, r6.g) == false) goto L38;
        if (Internal.equals(this.h, r6.h) == false) goto L38;
        if (Internal.equals(this.i, r6.i) == false) goto L38;
        if (Internal.equals(this.j, r6.j) == false) goto L38;
        if (Internal.equals(this.k, r6.k) == false) goto L38;
        if (Internal.equals(this.l, r6.l) == false) goto L38;
        if (Internal.equals(this.m, r6.m) == false) goto L38;
        if (Internal.equals(this.n, r6.n) == false) goto L38;
        if (Internal.equals(this.o, r6.o) == false) goto L38;
        if (Internal.equals(this.p, r6.p) == false) goto L38;
        return true;
    L38:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L57;
        int r1 = unknownFields().hashCode() * 37;
        Double r2 = this.f33519d;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Double r6 = this.f33520e;
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
        String r18 = this.i;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.j;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        String r24 = this.k;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        String r27 = this.l;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        String r30 = this.m;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        String r33 = this.n;
        if (r33 == null) goto L47;
        int r34 = r33.hashCode();
    L48:
        int r35 = (r32 + r34) * 37;
        String r36 = this.o;
        if (r36 == null) goto L51;
        int r37 = r36.hashCode();
    L52:
        int r38 = (r35 + r37) * 37;
        String r39 = this.p;
        if (r39 == null) goto L55;
        r3 = r39.hashCode();
    L55:
        int r40 = r38 + r3;
        this.hashCode = r40;
        return r40;
    L51:
        r37 = 0;
        goto L52
    L47:
        r34 = 0;
        goto L48
    L43:
        r31 = 0;
        goto L44
    L39:
        r28 = 0;
        goto L40
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
    L57:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f33519d == null) goto L6;
        r0.append(", longitude=").append(this.f33519d);
    L6:
        if (this.f33520e == null) goto L9;
        r0.append(", latitude=").append(this.f33520e);
    L9:
        if (this.f == null) goto L12;
        r0.append(", country=").append(this.f);
    L12:
        if (this.g == null) goto L15;
        r0.append(", countryCode=").append(this.g);
    L15:
        if (this.h == null) goto L18;
        r0.append(", administrativeArea=").append(this.h);
    L18:
        if (this.i == null) goto L21;
        r0.append(", city=").append(this.i);
    L21:
        if (this.j == null) goto L24;
        r0.append(", district=").append(this.j);
    L24:
        if (this.k == null) goto L27;
        r0.append(", town=").append(this.k);
    L27:
        if (this.l == null) goto L30;
        r0.append(", street=").append(this.l);
    L30:
        if (this.m == null) goto L33;
        r0.append(", subAdministrativeArea=").append(this.m);
    L33:
        if (this.n == null) goto L36;
        r0.append(", locality=").append(this.n);
    L36:
        if (this.o == null) goto L39;
        r0.append(", subLocality=").append(this.o);
    L39:
        if (this.p == null) goto L42;
        r0.append(", addressLine=").append(this.p);
    L42:
        return r0.replace(0, 2, "LocationInfo{").append('}').toString();
    }
}
