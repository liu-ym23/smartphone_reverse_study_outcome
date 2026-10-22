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

/* JADX INFO: compiled from: SendWsMessageRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ah extends Message<ah, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<ah> f33314a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("wsMessageInfo")
    @WireField(adapter = "com.obric.matrix.proto.WsMessageInfo#ADAPTER", tag = 1)
    public final ax f33315b;

    /* JADX INFO: compiled from: SendWsMessageRequest.java */
    public static final class a extends Message.Builder<ah, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ax f33316a;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
        }

        public a a(ax r1) {
            this.f33316a = r1;
            return this;
        }

        public ah a() {
            return new ah(this.f33316a, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: SendWsMessageRequest.java */
    private static final class b extends ProtoAdapter<ah> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ah decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, ah r4) {
            a(r3, (ah) ZeusTransformUtils.preCheckCast(r4, ah.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(ah r3) {
            return a((ah) ZeusTransformUtils.preCheckCast(r3, ah.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ah redact(ah r3) {
            return b((ah) ZeusTransformUtils.preCheckCast(r3, ah.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, ah.class);
        }

        public int a(ah r3) {
            return ax.f33426a.encodedSizeWithTag(1, r3.f33315b) + r3.unknownFields().k();
        }

        public void a(ProtoWriter r3, ah r4) {
            ax.f33426a.encodeWithTag(r3, 1, r4.f33315b);
            r3.writeBytes(r4.unknownFields());
        }

        public ah a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.a((ax) ZeusTransformUtils.preCheckCast(ax.f33426a.decode(r6), ax.class, "com.obric.aiagent.plugin"));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L9:
            r6.endMessage(r0);
            return r5.a();
        }

        public ah b(ah r3) {
            a r2 = r3.a();
            if (r2.f33316a == null) goto L5;
            r2.f33316a = (ax) ZeusTransformUtils.preCheckCast(ax.f33426a.redact(r2.f33316a), ax.class, "com.obric.aiagent.plugin");
        L5:
            r2.clearUnknownFields();
            return r2.a();
        }
    }

    @Override // com.squareup.wire.Message
    public /* synthetic */ Message.Builder newBuilder() {
        return a();
    }

    static {
        f33314a = new b();
    }

    public ah(ax r2, e.h r3) {
        super(f33314a, r3);
        this.f33315b = r2;
    }

    public a a() {
        a r0 = new a();
        r0.f33316a = this.f33315b;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ah.class) == true) goto L8;
        return false;
    L8:
        ah r6 = (ah) ZeusTransformUtils.preCheckCast(r5, ah.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (Internal.equals(this.f33315b, r6.f33315b) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        ax r2 = this.f33315b;
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
        if (this.f33315b == null) goto L6;
        r0.append(", wsMessageInfo=").append(this.f33315b);
    L6:
        return r0.replace(0, 2, "SendWsMessageRequest{").append('}').toString();
    }
}
