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

/* JADX INFO: compiled from: SubscribeWsMsgByProviderResponse.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ar extends Message<ar, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<ar> f33384a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Boolean f33385b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("subscribeResult")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean f33386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("ext")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String f33387d;

    /* JADX INFO: compiled from: SubscribeWsMsgByProviderResponse.java */
    public static final class a extends Message.Builder<ar, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f33388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f33389b;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33388a = false;
            this.f33389b = "";
        }

        public a a(Boolean r1) {
            this.f33388a = r1;
            return this;
        }

        public a a(String r1) {
            this.f33389b = r1;
            return this;
        }

        public ar a() {
            return new ar(this.f33388a, this.f33389b, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: SubscribeWsMsgByProviderResponse.java */
    private static final class b extends ProtoAdapter<ar> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ar decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, ar r4) {
            a(r3, (ar) ZeusTransformUtils.preCheckCast(r4, ar.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(ar r3) {
            return a((ar) ZeusTransformUtils.preCheckCast(r3, ar.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ar redact(ar r3) {
            return b((ar) ZeusTransformUtils.preCheckCast(r3, ar.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, ar.class);
        }

        public int a(ar r4) {
            return (ProtoAdapter.BOOL.encodedSizeWithTag(1, r4.f33386c) + ProtoAdapter.STRING.encodedSizeWithTag(2, r4.f33387d)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r3, ar r4) {
            ProtoAdapter.BOOL.encodeWithTag(r3, 1, r4.f33386c);
            ProtoAdapter.STRING.encodeWithTag(r3, 2, r4.f33387d);
            r3.writeBytes(r4.unknownFields());
        }

        public ar a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.a((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r6), Boolean.class, "com.obric.aiagent.plugin"));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            r5.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.aiagent.plugin"));
            goto L3
        L9:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L12:
            r6.endMessage(r0);
            return r5.a();
        }

        public ar b(ar r1) {
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
        f33384a = new b();
        f33385b = false;
    }

    public ar(Boolean r2, String r3, e.h r4) {
        super(f33384a, r4);
        this.f33386c = r2;
        this.f33387d = r3;
    }

    public a a() {
        a r0 = new a();
        r0.f33388a = this.f33386c;
        r0.f33389b = this.f33387d;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ar.class) == true) goto L8;
        return false;
    L8:
        ar r6 = (ar) ZeusTransformUtils.preCheckCast(r5, ar.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f33386c, r6.f33386c) == false) goto L16;
        if (Internal.equals(this.f33387d, r6.f33387d) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Boolean r2 = this.f33386c;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f33387d;
        if (r6 == null) goto L11;
        r3 = r6.hashCode();
    L11:
        int r7 = r5 + r3;
        this.hashCode = r7;
        return r7;
    L7:
        r4 = 0;
        goto L8
    L13:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f33386c == null) goto L6;
        r0.append(", subscribeResult=").append(this.f33386c);
    L6:
        if (this.f33387d == null) goto L9;
        r0.append(", ext=").append(this.f33387d);
    L9:
        return r0.replace(0, 2, "SubscribeWsMsgByProviderResponse{").append('}').toString();
    }
}
