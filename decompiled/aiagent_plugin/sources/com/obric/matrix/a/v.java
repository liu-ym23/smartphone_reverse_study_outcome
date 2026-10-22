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

/* JADX INFO: compiled from: OnePartyCommonNetworkResponse.java */
/* JADX INFO: loaded from: classes4.dex */
public final class v extends Message<v, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<v> f33567a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Boolean f33568b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("isSucceed")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean f33569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("body")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String f33570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("serverLogId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String f33571e;

    @SerializedName("extraMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> f;

    /* JADX INFO: compiled from: OnePartyCommonNetworkResponse.java */
    public static final class a extends Message.Builder<v, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f33572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f33573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f33574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, String> f33575d;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33572a = false;
            this.f33573b = "";
            this.f33574c = "";
            this.f33575d = Internal.newMutableMap();
        }

        public a a(Boolean r1) {
            this.f33572a = r1;
            return this;
        }

        public a a(String r1) {
            this.f33573b = r1;
            return this;
        }

        public a b(String r1) {
            this.f33574c = r1;
            return this;
        }

        public v a() {
            return new v(this.f33572a, this.f33573b, this.f33574c, this.f33575d, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: OnePartyCommonNetworkResponse.java */
    private static final class b extends ProtoAdapter<v> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f33576a;

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ v decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, v r4) {
            a(r3, (v) ZeusTransformUtils.preCheckCast(r4, v.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(v r3) {
            return a((v) ZeusTransformUtils.preCheckCast(r3, v.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ v redact(v r3) {
            return b((v) ZeusTransformUtils.preCheckCast(r3, v.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, v.class);
            this.f33576a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(v r5) {
            return (((ProtoAdapter.BOOL.encodedSizeWithTag(1, r5.f33569c) + ProtoAdapter.STRING.encodedSizeWithTag(2, r5.f33570d)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r5.f33571e)) + this.f33576a.encodedSizeWithTag(4, r5.f)) + r5.unknownFields().k();
        }

        public void a(ProtoWriter r4, v r5) {
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r5.f33569c);
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r5.f33570d);
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r5.f33571e);
            this.f33576a.encodeWithTag(r4, 4, r5.f);
            r4.writeBytes(r5.unknownFields());
        }

        public v a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.a((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r8), Boolean.class, "com.obric.aiagent.plugin"));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.f33575d.putAll((Map) ZeusTransformUtils.preCheckCast(this.f33576a.decode(r8), Map.class, "com.obric.aiagent.plugin"));
            goto L3
        L13:
            FieldEncoding r4 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r8));
            goto L3
        L18:
            r8.endMessage(r1);
            return r0.a();
        }

        public v b(v r1) {
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
        f33567a = new b();
        f33568b = false;
    }

    public v(Boolean r3, String r4, String r5, Map<String, String> r6, e.h r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        super(f33567a, r7);
        this.f33569c = r3;
        this.f33570d = r4;
        this.f33571e = r5;
        this.f = Internal.immutableCopyOf("extraMap", r8);
    }

    public a a() {
        a r0 = new a();
        r0.f33572a = this.f33569c;
        r0.f33573b = this.f33570d;
        r0.f33574c = this.f33571e;
        r0.f33575d = Internal.copyOf("extraMap", this.f);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, v.class) == true) goto L8;
        return false;
    L8:
        v r6 = (v) ZeusTransformUtils.preCheckCast(r5, v.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L20;
        if (Internal.equals(this.f33569c, r6.f33569c) == false) goto L20;
        if (Internal.equals(this.f33570d, r6.f33570d) == false) goto L20;
        if (Internal.equals(this.f33571e, r6.f33571e) == false) goto L20;
        if (this.f.equals(r6.f) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        Boolean r2 = this.f33569c;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f33570d;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.f33571e;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = ((r8 + r3) * 37) + this.f.hashCode();
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
        if (this.f33569c == null) goto L6;
        r0.append(", isSucceed=").append(this.f33569c);
    L6:
        if (this.f33570d == null) goto L9;
        r0.append(", body=").append(this.f33570d);
    L9:
        if (this.f33571e == null) goto L11;
        r0.append(", serverLogId=").append(this.f33571e);
    L11:
        Map<String, String> r1 = this.f;
        if (r1 == null) goto L17;
        if (r1.isEmpty() == true) goto L17;
        r0.append(", extraMap=").append(this.f);
    L17:
        return r0.replace(0, 2, "OnePartyCommonNetworkResponse{").append('}').toString();
    }
}
