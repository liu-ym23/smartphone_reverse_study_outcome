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

/* JADX INFO: compiled from: SubscribeWsMsgResponse.java */
/* JADX INFO: loaded from: classes4.dex */
public final class at extends Message<at, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<at> f33399a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("wsMessageInfo")
    @WireField(adapter = "com.obric.matrix.proto.WsMessageInfo#ADAPTER", tag = 1)
    public final ax f33400b;

    /* JADX INFO: compiled from: SubscribeWsMsgResponse.java */
    public static final class a extends Message.Builder<at, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ax f33401a;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
        }

        public a a(ax r1) {
            this.f33401a = r1;
            return this;
        }

        public at a() {
            return new at(this.f33401a, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: SubscribeWsMsgResponse.java */
    private static final class b extends ProtoAdapter<at> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ at decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, at r4) {
            a(r3, (at) ZeusTransformUtils.preCheckCast(r4, at.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(at r3) {
            return a((at) ZeusTransformUtils.preCheckCast(r3, at.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ at redact(at r3) {
            return b((at) ZeusTransformUtils.preCheckCast(r3, at.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, at.class);
        }

        public int a(at r3) {
            return ax.f33426a.encodedSizeWithTag(1, r3.f33400b) + r3.unknownFields().k();
        }

        public void a(ProtoWriter r3, at r4) {
            ax.f33426a.encodeWithTag(r3, 1, r4.f33400b);
            r3.writeBytes(r4.unknownFields());
        }

        public at a(ProtoReader r6) {
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

        public at b(at r3) {
            a r2 = r3.a();
            if (r2.f33401a == null) goto L5;
            r2.f33401a = (ax) ZeusTransformUtils.preCheckCast(ax.f33426a.redact(r2.f33401a), ax.class, "com.obric.aiagent.plugin");
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
        f33399a = new b();
    }

    public at(ax r2, e.h r3) {
        super(f33399a, r3);
        this.f33400b = r2;
    }

    public a a() {
        a r0 = new a();
        r0.f33401a = this.f33400b;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, at.class) == true) goto L8;
        return false;
    L8:
        at r6 = (at) ZeusTransformUtils.preCheckCast(r5, at.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (Internal.equals(this.f33400b, r6.f33400b) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        ax r2 = this.f33400b;
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
        if (this.f33400b == null) goto L6;
        r0.append(", wsMessageInfo=").append(this.f33400b);
    L6:
        return r0.replace(0, 2, "SubscribeWsMsgResponse{").append('}').toString();
    }
}
