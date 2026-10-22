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

/* JADX INFO: compiled from: BizExampleRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends Message<a, C0905a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<a> f33255a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("strParam")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String f33256b;

    /* JADX INFO: renamed from: com.obric.matrix.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BizExampleRequest.java */
    public static final class C0905a extends Message.Builder<a, C0905a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f33257a;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public C0905a() {
            this.f33257a = "";
        }

        public C0905a a(String r1) {
            this.f33257a = r1;
            return this;
        }

        public a a() {
            return new a(this.f33257a, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: BizExampleRequest.java */
    private static final class b extends ProtoAdapter<a> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ a decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, a r4) {
            a(r3, (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(a r3) {
            return a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ a redact(a r3) {
            return b((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, a.class);
        }

        public int a(a r3) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r3.f33256b) + r3.unknownFields().k();
        }

        public void a(ProtoWriter r3, a r4) {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.f33256b);
            r3.writeBytes(r4.unknownFields());
        }

        public a a(ProtoReader r6) {
            C0905a r5 = new C0905a();
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

        public a b(a r1) {
            C0905a r0 = r1.a();
            r0.clearUnknownFields();
            return r0.a();
        }
    }

    @Override // com.squareup.wire.Message
    public /* synthetic */ Message.Builder newBuilder() {
        return a();
    }

    static {
        f33255a = new b();
    }

    public a(String r2, e.h r3) {
        super(f33255a, r3);
        this.f33256b = r2;
    }

    public C0905a a() {
        C0905a r0 = new C0905a();
        r0.f33257a = this.f33256b;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (Internal.equals(this.f33256b, r6.f33256b) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f33256b;
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
        if (this.f33256b == null) goto L6;
        r0.append(", strParam=").append(this.f33256b);
    L6:
        return r0.replace(0, 2, "BizExampleRequest{").append('}').toString();
    }
}
