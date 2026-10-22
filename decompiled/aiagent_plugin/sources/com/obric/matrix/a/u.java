package com.obric.matrix.a;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: OnePartyCommonNetworkRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class u extends Message<u, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<u> f33553a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f33554b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e.h f33555c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Boolean f33556d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName(DownloadConstants.PATH_KEY)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String f33557e;

    @SerializedName("host")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String f;

    @SerializedName("method")
    @WireField(adapter = "com.obric.matrix.proto.NETWORK_METHOD#ADAPTER", label = WireField.Label.REQUIRED, tag = 3)
    public final s g;

    @SerializedName("headerParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> h;

    @SerializedName("queryParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final Map<String, String> i;

    @SerializedName("body")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 6)
    public final e.h j;

    @SerializedName("fieldMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final Map<String, String> k;

    @SerializedName("addCommonParam")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean l;

    @SerializedName("extraMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final Map<String, String> m;

    /* JADX INFO: compiled from: OnePartyCommonNetworkRequest.java */
    public static final class a extends Message.Builder<u, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f33558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f33559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public s f33560c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, String> f33561d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<String, String> f33562e;
        public e.h f;
        public Map<String, String> g;
        public Boolean h;
        public Map<String, String> i;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33558a = "";
            this.f33559b = "";
            this.f33560c = s.f33544a;
            this.f = e.h.f38723b;
            this.h = false;
            this.f33561d = Internal.newMutableMap();
            this.f33562e = Internal.newMutableMap();
            this.g = Internal.newMutableMap();
            this.i = Internal.newMutableMap();
        }

        public a a(String r1) {
            this.f33558a = r1;
            return this;
        }

        public a b(String r1) {
            this.f33559b = r1;
            return this;
        }

        public a a(s r1) {
            this.f33560c = r1;
            return this;
        }

        public a a(e.h r1) {
            this.f = r1;
            return this;
        }

        public a a(Boolean r1) {
            this.h = r1;
            return this;
        }

        public u a() {
            s r0 = this.f33560c;
            if (r0 == null) goto L7;
            return new u(this.f33558a, this.f33559b, this.f33560c, this.f33561d, this.f33562e, this.f, this.g, this.h, this.i, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "method"});
        }
    }

    /* JADX INFO: compiled from: OnePartyCommonNetworkRequest.java */
    private static final class b extends ProtoAdapter<u> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f33563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f33564b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f33565c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f33566d;

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ u decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, u r4) {
            a(r3, (u) ZeusTransformUtils.preCheckCast(r4, u.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(u r3) {
            return a((u) ZeusTransformUtils.preCheckCast(r3, u.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ u redact(u r3) {
            return b((u) ZeusTransformUtils.preCheckCast(r3, u.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, u.class);
            this.f33563a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
            this.f33564b = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
            this.f33565c = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
            this.f33566d = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(u r5) {
            return ((((((((ProtoAdapter.STRING.encodedSizeWithTag(1, r5.f33557e) + ProtoAdapter.STRING.encodedSizeWithTag(2, r5.f)) + s.f33546c.encodedSizeWithTag(3, r5.g)) + this.f33563a.encodedSizeWithTag(4, r5.h)) + this.f33564b.encodedSizeWithTag(5, r5.i)) + ProtoAdapter.BYTES.encodedSizeWithTag(6, r5.j)) + this.f33565c.encodedSizeWithTag(7, r5.k)) + ProtoAdapter.BOOL.encodedSizeWithTag(8, r5.l)) + this.f33566d.encodedSizeWithTag(9, r5.m)) + r5.unknownFields().k();
        }

        public void a(ProtoWriter r4, u r5) {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.f33557e);
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r5.f);
            s.f33546c.encodeWithTag(r4, 3, r5.g);
            this.f33563a.encodeWithTag(r4, 4, r5.h);
            this.f33564b.encodeWithTag(r4, 5, r5.i);
            ProtoAdapter.BYTES.encodeWithTag(r4, 6, r5.j);
            this.f33565c.encodeWithTag(r4, 7, r5.k);
            ProtoAdapter.BOOL.encodeWithTag(r4, 8, r5.l);
            this.f33566d.encodeWithTag(r4, 9, r5.m);
            r4.writeBytes(r5.unknownFields());
        }

        public u a(ProtoReader r9) {
            a r0 = new a();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L20;
            switch(r3) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L22;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                default: goto L7;
            };
        L22:
            r0.a((s) ZeusTransformUtils.preCheckCast(s.f33546c.decode(r9), s.class, "com.obric.aiagent.plugin"));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            r0.i.putAll((Map) ZeusTransformUtils.preCheckCast(this.f33566d.decode(r9), Map.class, "com.obric.aiagent.plugin"));
            goto L3
        L9:
            r0.a((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r9), Boolean.class, "com.obric.aiagent.plugin"));
            goto L3
        L10:
            r0.g.putAll((Map) ZeusTransformUtils.preCheckCast(this.f33565c.decode(r9), Map.class, "com.obric.aiagent.plugin"));
            goto L3
        L11:
            r0.a((e.h) ZeusTransformUtils.preCheckCast(ProtoAdapter.BYTES.decode(r9), e.h.class, "com.obric.aiagent.plugin"));
            goto L3
        L12:
            r0.f33562e.putAll((Map) ZeusTransformUtils.preCheckCast(this.f33564b.decode(r9), Map.class, "com.obric.aiagent.plugin"));
            goto L3
        L13:
            r0.f33561d.putAll((Map) ZeusTransformUtils.preCheckCast(this.f33563a.decode(r9), Map.class, "com.obric.aiagent.plugin"));
            goto L3
        L18:
            r0.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r9), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L19:
            r0.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r9), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L7:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L20:
            r9.endMessage(r1);
            return r0.a();
        }

        public u b(u r1) {
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
        f33553a = new b();
        f33554b = s.f33544a;
        f33555c = e.h.f38723b;
        f33556d = false;
    }

    public u(String r3, String r4, s r5, Map<String, String> r6, Map<String, String> r7, e.h r8, Map<String, String> r9, Boolean r10, Map<String, String> r11, e.h r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        super(f33553a, r12);
        this.f33557e = r3;
        this.f = r4;
        this.g = r5;
        this.h = Internal.immutableCopyOf("headerParams", r13);
        this.i = Internal.immutableCopyOf("queryParams", r14);
        this.j = r8;
        this.k = Internal.immutableCopyOf("fieldMap", r15);
        this.l = r10;
        this.m = Internal.immutableCopyOf("extraMap", r16);
    }

    public a a() {
        a r0 = new a();
        r0.f33558a = this.f33557e;
        r0.f33559b = this.f;
        r0.f33560c = this.g;
        r0.f33561d = Internal.copyOf("headerParams", this.h);
        r0.f33562e = Internal.copyOf("queryParams", this.i);
        r0.f = this.j;
        r0.g = Internal.copyOf("fieldMap", this.k);
        r0.h = this.l;
        r0.i = Internal.copyOf("extraMap", this.m);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, u.class) == true) goto L8;
        return false;
    L8:
        u r6 = (u) ZeusTransformUtils.preCheckCast(r5, u.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L30;
        if (Internal.equals(this.f33557e, r6.f33557e) == false) goto L30;
        if (Internal.equals(this.f, r6.f) == false) goto L30;
        if (this.g.equals(r6.g) == false) goto L30;
        if (this.h.equals(r6.h) == false) goto L30;
        if (this.i.equals(r6.i) == false) goto L30;
        if (Internal.equals(this.j, r6.j) == false) goto L30;
        if (this.k.equals(r6.k) == false) goto L30;
        if (Internal.equals(this.l, r6.l) == false) goto L30;
        if (this.m.equals(r6.m) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f33557e;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (((((((r5 + r7) * 37) + this.g.hashCode()) * 37) + this.h.hashCode()) * 37) + this.i.hashCode()) * 37;
        e.h r9 = this.j;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (((r8 + r10) * 37) + this.k.hashCode()) * 37;
        Boolean r12 = this.l;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = ((r11 + r3) * 37) + this.m.hashCode();
        this.hashCode = r13;
        return r13;
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L21:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f33557e == null) goto L6;
        r0.append(", path=").append(this.f33557e);
    L6:
        if (this.f == null) goto L8;
        r0.append(", host=").append(this.f);
    L8:
        r0.append(", method=").append(this.g);
        Map<String, String> r1 = this.h;
        if (r1 != null) goto L11;
    L13:
        Map<String, String> r2 = this.i;
        if (r2 == null) goto L19;
        if (r2.isEmpty() == true) goto L19;
        r0.append(", queryParams=").append(this.i);
    L19:
        if (this.j == null) goto L21;
        r0.append(", body=").append(this.j);
    L21:
        Map<String, String> r3 = this.k;
        if (r3 == null) goto L27;
        if (r3.isEmpty() == true) goto L27;
        r0.append(", fieldMap=").append(this.k);
    L27:
        if (this.l == null) goto L29;
        r0.append(", addCommonParam=").append(this.l);
    L29:
        Map<String, String> r4 = this.m;
        if (r4 == null) goto L35;
        if (r4.isEmpty() == true) goto L35;
        r0.append(", extraMap=").append(this.m);
    L35:
        return r0.replace(0, 2, "OnePartyCommonNetworkRequest{").append('}').toString();
    L11:
        if (r1.isEmpty() == true) goto L13;
        r0.append(", headerParams=").append(this.h);
        goto L13
    }
}
