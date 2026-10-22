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

/* JADX INFO: compiled from: SubscribeWsMsgByCallBackResponse.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ap extends Message<ap, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<ap> f33371a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Boolean f33372b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("subscribeResult")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean f33373c;

    /* JADX INFO: compiled from: SubscribeWsMsgByCallBackResponse.java */
    public static final class a extends Message.Builder<ap, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f33374a;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33374a = false;
        }

        public a a(Boolean r1) {
            this.f33374a = r1;
            return this;
        }

        public ap a() {
            return new ap(this.f33374a, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: SubscribeWsMsgByCallBackResponse.java */
    private static final class b extends ProtoAdapter<ap> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ap decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, ap r4) {
            a(r3, (ap) ZeusTransformUtils.preCheckCast(r4, ap.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(ap r3) {
            return a((ap) ZeusTransformUtils.preCheckCast(r3, ap.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ap redact(ap r3) {
            return b((ap) ZeusTransformUtils.preCheckCast(r3, ap.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, ap.class);
        }

        public int a(ap r3) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, r3.f33373c) + r3.unknownFields().k();
        }

        public void a(ProtoWriter r3, ap r4) {
            ProtoAdapter.BOOL.encodeWithTag(r3, 1, r4.f33373c);
            r3.writeBytes(r4.unknownFields());
        }

        public ap a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.a((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r6), Boolean.class, "com.obric.aiagent.plugin"));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L9:
            r6.endMessage(r0);
            return r5.a();
        }

        public ap b(ap r1) {
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
        f33371a = new b();
        f33372b = false;
    }

    public ap(Boolean r2, e.h r3) {
        super(f33371a, r3);
        this.f33373c = r2;
    }

    public a a() {
        a r0 = new a();
        r0.f33374a = this.f33373c;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ap.class) == true) goto L8;
        return false;
    L8:
        ap r6 = (ap) ZeusTransformUtils.preCheckCast(r5, ap.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (Internal.equals(this.f33373c, r6.f33373c) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        Boolean r2 = this.f33373c;
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
        if (this.f33373c == null) goto L6;
        r0.append(", subscribeResult=").append(this.f33373c);
    L6:
        return r0.replace(0, 2, "SubscribeWsMsgByCallBackResponse{").append('}').toString();
    }
}
