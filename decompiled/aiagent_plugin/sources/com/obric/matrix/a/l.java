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

/* JADX INFO: compiled from: GetLocationResponse.java */
/* JADX INFO: loaded from: classes4.dex */
public final class l extends Message<l, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<l> f33509a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("locationInfo")
    @WireField(adapter = "com.obric.matrix.proto.LocationInfo#ADAPTER", tag = 1)
    public final o f33510b;

    /* JADX INFO: compiled from: GetLocationResponse.java */
    public static final class a extends Message.Builder<l, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public o f33511a;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
        }

        public a a(o r1) {
            this.f33511a = r1;
            return this;
        }

        public l a() {
            return new l(this.f33511a, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: GetLocationResponse.java */
    private static final class b extends ProtoAdapter<l> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ l decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, l r4) {
            a(r3, (l) ZeusTransformUtils.preCheckCast(r4, l.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(l r3) {
            return a((l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ l redact(l r3) {
            return b((l) ZeusTransformUtils.preCheckCast(r3, l.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, l.class);
        }

        public int a(l r3) {
            return o.f33516a.encodedSizeWithTag(1, r3.f33510b) + r3.unknownFields().k();
        }

        public void a(ProtoWriter r3, l r4) {
            o.f33516a.encodeWithTag(r3, 1, r4.f33510b);
            r3.writeBytes(r4.unknownFields());
        }

        public l a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.a((o) ZeusTransformUtils.preCheckCast(o.f33516a.decode(r6), o.class, "com.obric.aiagent.plugin"));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L9:
            r6.endMessage(r0);
            return r5.a();
        }

        public l b(l r3) {
            a r2 = r3.a();
            if (r2.f33511a == null) goto L5;
            r2.f33511a = (o) ZeusTransformUtils.preCheckCast(o.f33516a.redact(r2.f33511a), o.class, "com.obric.aiagent.plugin");
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
        f33509a = new b();
    }

    public l(o r2, e.h r3) {
        super(f33509a, r3);
        this.f33510b = r2;
    }

    public a a() {
        a r0 = new a();
        r0.f33511a = this.f33510b;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, l.class) == true) goto L8;
        return false;
    L8:
        l r6 = (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (Internal.equals(this.f33510b, r6.f33510b) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        o r2 = this.f33510b;
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
        if (this.f33510b == null) goto L6;
        r0.append(", locationInfo=").append(this.f33510b);
    L6:
        return r0.replace(0, 2, "GetLocationResponse{").append('}').toString();
    }
}
