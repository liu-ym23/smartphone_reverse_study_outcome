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

/* JADX INFO: compiled from: GetTTNetParametersResponse.java */
/* JADX INFO: loaded from: classes4.dex */
public final class n extends Message<n, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<n> f33513a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("parameters")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
    public final String f33514b;

    /* JADX INFO: compiled from: GetTTNetParametersResponse.java */
    public static final class a extends Message.Builder<n, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f33515a;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33515a = "";
        }

        public a a(String r1) {
            this.f33515a = r1;
            return this;
        }

        public n a() {
            String r0 = this.f33515a;
            if (r0 == null) goto L7;
            return new n(this.f33515a, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "parameters"});
        }
    }

    /* JADX INFO: compiled from: GetTTNetParametersResponse.java */
    private static final class b extends ProtoAdapter<n> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ n decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, n r4) {
            a(r3, (n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(n r3) {
            return a((n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ n redact(n r3) {
            return b((n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, n.class);
        }

        public int a(n r3) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r3.f33514b) + r3.unknownFields().k();
        }

        public void a(ProtoWriter r3, n r4) {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.f33514b);
            r3.writeBytes(r4.unknownFields());
        }

        public n a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L9:
            r6.endMessage(r0);
            return r5.a();
        }

        public n b(n r1) {
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
        f33513a = new b();
    }

    public n(String r2, e.h r3) {
        super(f33513a, r3);
        this.f33514b = r2;
    }

    public a a() {
        a r0 = new a();
        r0.f33515a = this.f33514b;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, n.class) == true) goto L8;
        return false;
    L8:
        n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this.f33514b.equals(r6.f33514b) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.f33514b.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(", parameters=").append(this.f33514b);
        return r0.replace(0, 2, "GetTTNetParametersResponse{").append('}').toString();
    }
}
