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

/* JADX INFO: compiled from: GenericNetworkResponse.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h extends Message<h, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<h> f33480a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Boolean f33481b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("isSucceed")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.REQUIRED, tag = 1)
    public final Boolean f33482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("body")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
    public final String f33483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("serverLogId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 3)
    public final String f33484e;

    /* JADX INFO: compiled from: GenericNetworkResponse.java */
    public static final class a extends Message.Builder<h, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f33485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f33486b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f33487c;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33485a = false;
            this.f33486b = "";
            this.f33487c = "";
        }

        public a a(Boolean r1) {
            this.f33485a = r1;
            return this;
        }

        public a a(String r1) {
            this.f33486b = r1;
            return this;
        }

        public a b(String r1) {
            this.f33487c = r1;
            return this;
        }

        public h a() {
            Boolean r0 = this.f33485a;
            if (r0 == null) goto L11;
            if (this.f33486b == null) goto L11;
            if (this.f33487c == null) goto L11;
            return new h(this.f33485a, this.f33486b, this.f33487c, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r0, "isSucceed", this.f33486b, "body", this.f33487c, "serverLogId"});
        }
    }

    /* JADX INFO: compiled from: GenericNetworkResponse.java */
    private static final class b extends ProtoAdapter<h> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ h decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, h r4) {
            a(r3, (h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(h r3) {
            return a((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ h redact(h r3) {
            return b((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, h.class);
        }

        public int a(h r4) {
            return ((ProtoAdapter.BOOL.encodedSizeWithTag(1, r4.f33482c) + ProtoAdapter.STRING.encodedSizeWithTag(2, r4.f33483d)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r4.f33484e)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r3, h r4) {
            ProtoAdapter.BOOL.encodeWithTag(r3, 1, r4.f33482c);
            ProtoAdapter.STRING.encodeWithTag(r3, 2, r4.f33483d);
            ProtoAdapter.STRING.encodeWithTag(r3, 3, r4.f33484e);
            r3.writeBytes(r4.unknownFields());
        }

        public h a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L15;
            if (r2 != 1) goto L8;
            r5.a((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r6), Boolean.class, "com.obric.aiagent.plugin"));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L10:
            if (r2 != 3) goto L11;
            r5.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L11:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L15:
            r6.endMessage(r0);
            return r5.a();
        }

        public h b(h r1) {
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
        f33480a = new b();
        f33481b = false;
    }

    public h(Boolean r2, String r3, String r4, e.h r5) {
        super(f33480a, r5);
        this.f33482c = r2;
        this.f33483d = r3;
        this.f33484e = r4;
    }

    public a a() {
        a r0 = new a();
        r0.f33485a = this.f33482c;
        r0.f33486b = this.f33483d;
        r0.f33487c = this.f33484e;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L18;
        if (this.f33482c.equals(r6.f33482c) == false) goto L18;
        if (this.f33483d.equals(r6.f33483d) == false) goto L18;
        if (this.f33484e.equals(r6.f33484e) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (((((unknownFields().hashCode() * 37) + this.f33482c.hashCode()) * 37) + this.f33483d.hashCode()) * 37) + this.f33484e.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(", isSucceed=").append(this.f33482c);
        r0.append(", body=").append(this.f33483d);
        r0.append(", serverLogId=").append(this.f33484e);
        return r0.replace(0, 2, "GenericNetworkResponse{").append('}').toString();
    }
}
