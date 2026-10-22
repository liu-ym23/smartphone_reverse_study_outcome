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

/* JADX INFO: compiled from: SubscribeWsStatusRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class au extends Message<au, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<au> f33402a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Integer f33403b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("opt")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer f33404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("packageName")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String f33405d;

    /* JADX INFO: compiled from: SubscribeWsStatusRequest.java */
    public static final class a extends Message.Builder<au, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f33406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f33407b;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33406a = 0;
            this.f33407b = "";
        }

        public a a(Integer r1) {
            this.f33406a = r1;
            return this;
        }

        public a a(String r1) {
            this.f33407b = r1;
            return this;
        }

        public au a() {
            return new au(this.f33406a, this.f33407b, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: SubscribeWsStatusRequest.java */
    private static final class b extends ProtoAdapter<au> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ au decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, au r4) {
            a(r3, (au) ZeusTransformUtils.preCheckCast(r4, au.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(au r3) {
            return a((au) ZeusTransformUtils.preCheckCast(r3, au.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ au redact(au r3) {
            return b((au) ZeusTransformUtils.preCheckCast(r3, au.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, au.class);
        }

        public int a(au r4) {
            return (ProtoAdapter.INT32.encodedSizeWithTag(1, r4.f33404c) + ProtoAdapter.STRING.encodedSizeWithTag(2, r4.f33405d)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r3, au r4) {
            ProtoAdapter.INT32.encodeWithTag(r3, 1, r4.f33404c);
            ProtoAdapter.STRING.encodeWithTag(r3, 2, r4.f33405d);
            r3.writeBytes(r4.unknownFields());
        }

        public au a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.a((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r6), Integer.class, "com.obric.aiagent.plugin"));
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

        public au b(au r1) {
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
        f33402a = new b();
        f33403b = 0;
    }

    public au(Integer r2, String r3, e.h r4) {
        super(f33402a, r4);
        this.f33404c = r2;
        this.f33405d = r3;
    }

    public a a() {
        a r0 = new a();
        r0.f33406a = this.f33404c;
        r0.f33407b = this.f33405d;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, au.class) == true) goto L8;
        return false;
    L8:
        au r6 = (au) ZeusTransformUtils.preCheckCast(r5, au.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f33404c, r6.f33404c) == false) goto L16;
        if (Internal.equals(this.f33405d, r6.f33405d) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f33404c;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.f33405d;
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
        if (this.f33404c == null) goto L6;
        r0.append(", opt=").append(this.f33404c);
    L6:
        if (this.f33405d == null) goto L9;
        r0.append(", packageName=").append(this.f33405d);
    L9:
        return r0.replace(0, 2, "SubscribeWsStatusRequest{").append('}').toString();
    }
}
