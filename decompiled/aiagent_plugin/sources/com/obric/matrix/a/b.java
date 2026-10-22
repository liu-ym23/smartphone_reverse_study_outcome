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

/* JADX INFO: compiled from: BizExampleResponse.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends Message<b, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<b> f33437a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("strParam")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String f33438b;

    /* JADX INFO: compiled from: BizExampleResponse.java */
    public static final class a extends Message.Builder<b, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f33439a;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33439a = "";
        }

        public a a(String r1) {
            this.f33439a = r1;
            return this;
        }

        public b a() {
            return new b(this.f33439a, super.buildUnknownFields());
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BizExampleResponse.java */
    private static final class C0906b extends ProtoAdapter<b> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ b decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, b r4) {
            a(r3, (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(b r3) {
            return a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ b redact(b r3) {
            return b((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin"));
        }

        public C0906b() {
            super(FieldEncoding.LENGTH_DELIMITED, b.class);
        }

        public int a(b r3) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r3.f33438b) + r3.unknownFields().k();
        }

        public void a(ProtoWriter r3, b r4) {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.f33438b);
            r3.writeBytes(r4.unknownFields());
        }

        public b a(ProtoReader r6) {
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

        public b b(b r1) {
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
        f33437a = new C0906b();
    }

    public b(String r2, e.h r3) {
        super(f33437a, r3);
        this.f33438b = r2;
    }

    public a a() {
        a r0 = new a();
        r0.f33439a = this.f33438b;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (Internal.equals(this.f33438b, r6.f33438b) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f33438b;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = r1 + r3;
        this.hashCode = r4;
        return r4;
    L7:
        r3 = 0;
        goto L8
    L10:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f33438b == null) goto L6;
        r0.append(", strParam=").append(this.f33438b);
    L6:
        return r0.replace(0, 2, "BizExampleResponse{").append('}').toString();
    }
}
