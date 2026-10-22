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

/* JADX INFO: compiled from: GetLocationRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k extends Message<k, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<k> f33506a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("packageName")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String f33507b;

    /* JADX INFO: compiled from: GetLocationRequest.java */
    public static final class a extends Message.Builder<k, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f33508a;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33508a = "";
        }

        public a a(String r1) {
            this.f33508a = r1;
            return this;
        }

        public k a() {
            return new k(this.f33508a, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: GetLocationRequest.java */
    private static final class b extends ProtoAdapter<k> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ k decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, k r4) {
            a(r3, (k) ZeusTransformUtils.preCheckCast(r4, k.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(k r3) {
            return a((k) ZeusTransformUtils.preCheckCast(r3, k.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ k redact(k r3) {
            return b((k) ZeusTransformUtils.preCheckCast(r3, k.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, k.class);
        }

        public int a(k r3) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r3.f33507b) + r3.unknownFields().k();
        }

        public void a(ProtoWriter r3, k r4) {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.f33507b);
            r3.writeBytes(r4.unknownFields());
        }

        public k a(ProtoReader r6) {
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

        public k b(k r1) {
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
        f33506a = new b();
    }

    public k(String r2, e.h r3) {
        super(f33506a, r3);
        this.f33507b = r2;
    }

    public a a() {
        a r0 = new a();
        r0.f33508a = this.f33507b;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, k.class) == true) goto L8;
        return false;
    L8:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (Internal.equals(this.f33507b, r6.f33507b) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.f33507b;
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
        if (this.f33507b == null) goto L6;
        r0.append(", packageName=").append(this.f33507b);
    L6:
        return r0.replace(0, 2, "GetLocationRequest{").append('}').toString();
    }
}
