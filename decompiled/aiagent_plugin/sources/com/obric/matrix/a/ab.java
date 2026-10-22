package com.obric.matrix.a;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: Request.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ab extends Message<ab, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<ab> f33265a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Integer f33266b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("cmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer f33267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("sequenceId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String f33268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("sdkVersion")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String f33269e;

    @SerializedName("appKey")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String f;

    @SerializedName("deviceId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String g;

    @SerializedName("channel")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String h;

    @SerializedName(DBDefinition.APP_VERSION_CODE)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String i;

    @SerializedName("extraParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final Map<String, String> j;

    @SerializedName("appPkg")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String k;

    @SerializedName("body")
    @WireField(adapter = "com.obric.matrix.proto.RequestBody#ADAPTER", tag = 11)
    public final ac l;

    @SerializedName("accessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String m;

    @SerializedName("monitorInfo")
    @WireField(adapter = "com.obric.matrix.proto.MonitorInfo#ADAPTER", tag = 13)
    public final q n;

    /* JADX INFO: compiled from: Request.java */
    public static final class a extends Message.Builder<ab, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f33270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f33271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f33272c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f33273d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f33274e;
        public String f;
        public String g;
        public Map<String, String> h;
        public String i;
        public ac j;
        public String k;
        public q l;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33270a = 0;
            this.f33271b = "";
            this.f33272c = "";
            this.f33273d = "";
            this.f33274e = "";
            this.f = "";
            this.g = "";
            this.i = "";
            this.k = "";
            this.h = Internal.newMutableMap();
        }

        public a a(Integer r1) {
            this.f33270a = r1;
            return this;
        }

        public a a(String r1) {
            this.f33271b = r1;
            return this;
        }

        public a b(String r1) {
            this.f33272c = r1;
            return this;
        }

        public a c(String r1) {
            this.f33273d = r1;
            return this;
        }

        public a d(String r1) {
            this.f33274e = r1;
            return this;
        }

        public a e(String r1) {
            this.f = r1;
            return this;
        }

        public a f(String r1) {
            this.g = r1;
            return this;
        }

        public a g(String r1) {
            this.i = r1;
            return this;
        }

        public a a(ac r1) {
            this.j = r1;
            return this;
        }

        public a h(String r1) {
            this.k = r1;
            return this;
        }

        public a a(q r1) {
            this.l = r1;
            return this;
        }

        public ab a() {
            return new ab(this.f33270a, this.f33271b, this.f33272c, this.f33273d, this.f33274e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: Request.java */
    private static final class b extends ProtoAdapter<ab> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f33275a;

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ab decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, ab r4) {
            a(r3, (ab) ZeusTransformUtils.preCheckCast(r4, ab.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(ab r3) {
            return a((ab) ZeusTransformUtils.preCheckCast(r3, ab.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ab redact(ab r3) {
            return b((ab) ZeusTransformUtils.preCheckCast(r3, ab.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, ab.class);
            this.f33275a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(ab r5) {
            return (((((((((((ProtoAdapter.INT32.encodedSizeWithTag(1, r5.f33267c) + ProtoAdapter.STRING.encodedSizeWithTag(2, r5.f33268d)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r5.f33269e)) + ProtoAdapter.STRING.encodedSizeWithTag(4, r5.f)) + ProtoAdapter.STRING.encodedSizeWithTag(5, r5.g)) + ProtoAdapter.STRING.encodedSizeWithTag(6, r5.h)) + ProtoAdapter.STRING.encodedSizeWithTag(7, r5.i)) + this.f33275a.encodedSizeWithTag(9, r5.j)) + ProtoAdapter.STRING.encodedSizeWithTag(10, r5.k)) + ac.f33276a.encodedSizeWithTag(11, r5.l)) + ProtoAdapter.STRING.encodedSizeWithTag(12, r5.m)) + q.f33531a.encodedSizeWithTag(13, r5.n)) + r5.unknownFields().k();
        }

        public void a(ProtoWriter r4, ab r5) {
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r5.f33267c);
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r5.f33268d);
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r5.f33269e);
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r5.f);
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r5.g);
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r5.h);
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r5.i);
            this.f33275a.encodeWithTag(r4, 9, r5.j);
            ProtoAdapter.STRING.encodeWithTag(r4, 10, r5.k);
            ac.f33276a.encodeWithTag(r4, 11, r5.l);
            ProtoAdapter.STRING.encodeWithTag(r4, 12, r5.m);
            q.f33531a.encodeWithTag(r4, 13, r5.n);
            r4.writeBytes(r5.unknownFields());
        }

        public ab a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L20;
            switch(r3) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L7;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r0.a((q) ZeusTransformUtils.preCheckCast(q.f33531a.decode(r8), q.class, "com.obric.aiagent.plugin"));
            goto L3
        L9:
            r0.h((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L10:
            r0.a((ac) ZeusTransformUtils.preCheckCast(ac.f33276a.decode(r8), ac.class, "com.obric.aiagent.plugin"));
            goto L3
        L11:
            r0.g((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L12:
            r0.h.putAll((Map) ZeusTransformUtils.preCheckCast(this.f33275a.decode(r8), Map.class, "com.obric.aiagent.plugin"));
            goto L3
        L13:
            r0.f((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L14:
            r0.e((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L15:
            r0.d((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L16:
            r0.c((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L17:
            r0.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L18:
            r0.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L19:
            r0.a((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.aiagent.plugin"));
            goto L3
        L7:
            FieldEncoding r4 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r8));
            goto L3
        L20:
            r8.endMessage(r1);
            return r0.a();
        }

        public ab b(ab r3) {
            a r2 = r3.a();
            if (r2.j == null) goto L6;
            r2.j = (ac) ZeusTransformUtils.preCheckCast(ac.f33276a.redact(r2.j), ac.class, "com.obric.aiagent.plugin");
        L6:
            if (r2.l == null) goto L8;
            r2.l = (q) ZeusTransformUtils.preCheckCast(q.f33531a.redact(r2.l), q.class, "com.obric.aiagent.plugin");
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
        f33265a = new b();
        f33266b = 0;
    }

    public ab(Integer r3, String r4, String r5, String r6, String r7, String r8, String r9, Map<String, String> r10, String r11, ac r12, String r13, q r14, e.h r15) {
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        super(f33265a, r15);
        this.f33267c = r3;
        this.f33268d = r4;
        this.f33269e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = Internal.immutableCopyOf("extraParams", r16);
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
    }

    public a a() {
        a r0 = new a();
        r0.f33270a = this.f33267c;
        r0.f33271b = this.f33268d;
        r0.f33272c = this.f33269e;
        r0.f33273d = this.f;
        r0.f33274e = this.g;
        r0.f = this.h;
        r0.g = this.i;
        r0.h = Internal.copyOf("extraParams", this.j);
        r0.i = this.k;
        r0.j = this.l;
        r0.k = this.m;
        r0.l = this.n;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ab.class) == true) goto L8;
        return false;
    L8:
        ab r6 = (ab) ZeusTransformUtils.preCheckCast(r5, ab.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L36;
        if (Internal.equals(this.f33267c, r6.f33267c) == false) goto L36;
        if (Internal.equals(this.f33268d, r6.f33268d) == false) goto L36;
        if (Internal.equals(this.f33269e, r6.f33269e) == false) goto L36;
        if (Internal.equals(this.f, r6.f) == false) goto L36;
        if (Internal.equals(this.g, r6.g) == false) goto L36;
        if (Internal.equals(this.h, r6.h) == false) goto L36;
        if (Internal.equals(this.i, r6.i) == false) goto L36;
        if (this.j.equals(r6.j) == false) goto L36;
        if (Internal.equals(this.k, r6.k) == false) goto L36;
        if (Internal.equals(this.l, r6.l) == false) goto L36;
        if (Internal.equals(this.m, r6.m) == false) goto L36;
        if (Internal.equals(this.n, r6.n) == false) goto L36;
        return true;
    L36:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L49;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f33267c;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f33268d;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f33269e;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        String r12 = this.f;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.g;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.h;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.i;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (((r20 + r22) * 37) + this.j.hashCode()) * 37;
        String r24 = this.k;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        ac r27 = this.l;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        String r30 = this.m;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        q r33 = this.n;
        if (r33 == null) goto L47;
        r3 = r33.hashCode();
    L47:
        int r34 = r32 + r3;
        this.hashCode = r34;
        return r34;
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
    L49:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f33267c == null) goto L6;
        r0.append(", cmd=").append(this.f33267c);
    L6:
        if (this.f33268d == null) goto L9;
        r0.append(", sequenceId=").append(this.f33268d);
    L9:
        if (this.f33269e == null) goto L12;
        r0.append(", sdkVersion=").append(this.f33269e);
    L12:
        if (this.f == null) goto L15;
        r0.append(", appKey=").append(this.f);
    L15:
        if (this.g == null) goto L18;
        r0.append(", deviceId=").append(this.g);
    L18:
        if (this.h == null) goto L21;
        r0.append(", channel=").append(this.h);
    L21:
        if (this.i == null) goto L23;
        r0.append(", appVersionCode=").append(this.i);
    L23:
        Map<String, String> r1 = this.j;
        if (r1 == null) goto L29;
        if (r1.isEmpty() == true) goto L29;
        r0.append(", extraParams=").append(this.j);
    L29:
        if (this.k == null) goto L32;
        r0.append(", appPkg=").append(this.k);
    L32:
        if (this.l == null) goto L35;
        r0.append(", body=").append(this.l);
    L35:
        if (this.m == null) goto L38;
        r0.append(", accessToken=").append(this.m);
    L38:
        if (this.n == null) goto L41;
        r0.append(", monitorInfo=").append(this.n);
    L41:
        return r0.replace(0, 2, "Request{").append('}').toString();
    }
}
