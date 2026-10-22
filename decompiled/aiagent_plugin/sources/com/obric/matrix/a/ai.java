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

/* JADX INFO: compiled from: SendWsMessageResponse.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ai extends Message<ai, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<ai> f33317a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Boolean f33318b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("result")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean f33319c;

    /* JADX INFO: compiled from: SendWsMessageResponse.java */
    public static final class a extends Message.Builder<ai, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f33320a;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33320a = false;
        }

        public a a(Boolean r1) {
            this.f33320a = r1;
            return this;
        }

        public ai a() {
            return new ai(this.f33320a, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: SendWsMessageResponse.java */
    private static final class b extends ProtoAdapter<ai> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ai decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, ai r4) {
            a(r3, (ai) ZeusTransformUtils.preCheckCast(r4, ai.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(ai r3) {
            return a((ai) ZeusTransformUtils.preCheckCast(r3, ai.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ai redact(ai r3) {
            return b((ai) ZeusTransformUtils.preCheckCast(r3, ai.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, ai.class);
        }

        public int a(ai r3) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, r3.f33319c) + r3.unknownFields().k();
        }

        public void a(ProtoWriter r3, ai r4) {
            ProtoAdapter.BOOL.encodeWithTag(r3, 1, r4.f33319c);
            r3.writeBytes(r4.unknownFields());
        }

        public ai a(ProtoReader r6) {
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

        public ai b(ai r1) {
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
        f33317a = new b();
        f33318b = false;
    }

    public ai(Boolean r2, e.h r3) {
        super(f33317a, r3);
        this.f33319c = r2;
    }

    public a a() {
        a r0 = new a();
        r0.f33320a = this.f33319c;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ai.class) == true) goto L8;
        return false;
    L8:
        ai r6 = (ai) ZeusTransformUtils.preCheckCast(r5, ai.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (Internal.equals(this.f33319c, r6.f33319c) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        Boolean r2 = this.f33319c;
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
        if (this.f33319c == null) goto L6;
        r0.append(", result=").append(this.f33319c);
    L6:
        return r0.replace(0, 2, "SendWsMessageResponse{").append('}').toString();
    }
}
