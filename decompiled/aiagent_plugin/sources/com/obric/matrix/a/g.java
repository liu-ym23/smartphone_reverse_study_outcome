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

/* JADX INFO: compiled from: GenericNetworkRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g extends Message<g, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<g> f33468a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f33469b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e.h f33470c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Boolean f33471d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName(DownloadConstants.PATH_KEY)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    public final String f33472e;

    @SerializedName("method")
    @WireField(adapter = "com.obric.matrix.proto.NETWORK_METHOD#ADAPTER", label = WireField.Label.REQUIRED, tag = 2)
    public final s f;

    @SerializedName("headerParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, String> g;

    @SerializedName("queryParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> h;

    @SerializedName("body")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 5)
    public final e.h i;

    @SerializedName("needAccessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean j;

    @SerializedName("accessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String k;

    /* JADX INFO: compiled from: GenericNetworkRequest.java */
    public static final class a extends Message.Builder<g, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f33473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public s f33474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, String> f33475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, String> f33476d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public e.h f33477e;
        public Boolean f;
        public String g;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33473a = "";
            this.f33474b = s.f33544a;
            this.f33477e = e.h.f38723b;
            this.f = false;
            this.g = "";
            this.f33475c = Internal.newMutableMap();
            this.f33476d = Internal.newMutableMap();
        }

        public a a(String r1) {
            this.f33473a = r1;
            return this;
        }

        public a a(s r1) {
            this.f33474b = r1;
            return this;
        }

        public a a(e.h r1) {
            this.f33477e = r1;
            return this;
        }

        public a a(Boolean r1) {
            this.f = r1;
            return this;
        }

        public a b(String r1) {
            this.g = r1;
            return this;
        }

        public g a() {
            String r0 = this.f33473a;
            if (r0 == null) goto L9;
            if (this.f33474b == null) goto L9;
            return new g(this.f33473a, this.f33474b, this.f33475c, this.f33476d, this.f33477e, this.f, this.g, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, DownloadConstants.PATH_KEY, this.f33474b, "method"});
        }
    }

    /* JADX INFO: compiled from: GenericNetworkRequest.java */
    private static final class b extends ProtoAdapter<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f33478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f33479b;

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ g decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, g r4) {
            a(r3, (g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(g r3) {
            return a((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ g redact(g r3) {
            return b((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, g.class);
            this.f33478a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
            this.f33479b = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(g r5) {
            return ((((((ProtoAdapter.STRING.encodedSizeWithTag(1, r5.f33472e) + s.f33546c.encodedSizeWithTag(2, r5.f)) + this.f33478a.encodedSizeWithTag(3, r5.g)) + this.f33479b.encodedSizeWithTag(4, r5.h)) + ProtoAdapter.BYTES.encodedSizeWithTag(5, r5.i)) + ProtoAdapter.BOOL.encodedSizeWithTag(6, r5.j)) + ProtoAdapter.STRING.encodedSizeWithTag(7, r5.k)) + r5.unknownFields().k();
        }

        public void a(ProtoWriter r4, g r5) {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.f33472e);
            s.f33546c.encodeWithTag(r4, 2, r5.f);
            this.f33478a.encodeWithTag(r4, 3, r5.g);
            this.f33479b.encodeWithTag(r4, 4, r5.h);
            ProtoAdapter.BYTES.encodeWithTag(r4, 5, r5.i);
            ProtoAdapter.BOOL.encodeWithTag(r4, 6, r5.j);
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r5.k);
            r4.writeBytes(r5.unknownFields());
        }

        public g a(ProtoReader r9) {
            a r0 = new a();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            switch(r3) {
                case 1: goto L17;
                case 2: goto L20;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                default: goto L7;
            };
        L20:
            r0.a((s) ZeusTransformUtils.preCheckCast(s.f33546c.decode(r9), s.class, "com.obric.aiagent.plugin"));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            r0.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r9), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L9:
            r0.a((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r9), Boolean.class, "com.obric.aiagent.plugin"));
            goto L3
        L10:
            r0.a((e.h) ZeusTransformUtils.preCheckCast(ProtoAdapter.BYTES.decode(r9), e.h.class, "com.obric.aiagent.plugin"));
            goto L3
        L11:
            r0.f33476d.putAll((Map) ZeusTransformUtils.preCheckCast(this.f33479b.decode(r9), Map.class, "com.obric.aiagent.plugin"));
            goto L3
        L12:
            r0.f33475c.putAll((Map) ZeusTransformUtils.preCheckCast(this.f33478a.decode(r9), Map.class, "com.obric.aiagent.plugin"));
            goto L3
        L17:
            r0.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r9), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L7:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.a();
        }

        public g b(g r1) {
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
        f33468a = new b();
        f33469b = s.f33544a;
        f33470c = e.h.f38723b;
        f33471d = false;
    }

    public g(String r3, s r4, Map<String, String> r5, Map<String, String> r6, e.h r7, Boolean r8, String r9, e.h r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        super(f33468a, r10);
        this.f33472e = r3;
        this.f = r4;
        this.g = Internal.immutableCopyOf("headerParams", r11);
        this.h = Internal.immutableCopyOf("queryParams", r12);
        this.i = r7;
        this.j = r8;
        this.k = r9;
    }

    public a a() {
        a r0 = new a();
        r0.f33473a = this.f33472e;
        r0.f33474b = this.f;
        r0.f33475c = Internal.copyOf("headerParams", this.g);
        r0.f33476d = Internal.copyOf("queryParams", this.h);
        r0.f33477e = this.i;
        r0.f = this.j;
        r0.g = this.k;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L26;
        if (this.f33472e.equals(r6.f33472e) == false) goto L26;
        if (this.f.equals(r6.f) == false) goto L26;
        if (this.g.equals(r6.g) == false) goto L26;
        if (this.h.equals(r6.h) == false) goto L26;
        if (Internal.equals(this.i, r6.i) == false) goto L26;
        if (Internal.equals(this.j, r6.j) == false) goto L26;
        if (Internal.equals(this.k, r6.k) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = ((((((((unknownFields().hashCode() * 37) + this.f33472e.hashCode()) * 37) + this.f.hashCode()) * 37) + this.g.hashCode()) * 37) + this.h.hashCode()) * 37;
        e.h r2 = this.i;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Boolean r6 = this.j;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.k;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = r8 + r3;
        this.hashCode = r10;
        return r10;
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L17:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(", path=").append(this.f33472e);
        r0.append(", method=").append(this.f);
        Map<String, String> r1 = this.g;
        if (r1 != null) goto L5;
    L7:
        Map<String, String> r2 = this.h;
        if (r2 == null) goto L13;
        if (r2.isEmpty() == true) goto L13;
        r0.append(", queryParams=").append(this.h);
    L13:
        if (this.i == null) goto L16;
        r0.append(", body=").append(this.i);
    L16:
        if (this.j == null) goto L19;
        r0.append(", needAccessToken=").append(this.j);
    L19:
        if (this.k == null) goto L22;
        r0.append(", accessToken=").append(this.k);
    L22:
        return r0.replace(0, 2, "GenericNetworkRequest{").append('}').toString();
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", headerParams=").append(this.g);
        goto L7
    }
}
