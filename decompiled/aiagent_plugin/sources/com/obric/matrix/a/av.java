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

/* JADX INFO: compiled from: SubscribeWsStatusResponse.java */
/* JADX INFO: loaded from: classes4.dex */
public final class av extends Message<av, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<av> f33408a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Integer f33409b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Integer f33410c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Integer f33411d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Boolean f33412e = null;

    @SerializedName("channelType")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer f;

    @SerializedName("connectionState")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer g;

    @SerializedName("channelId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer h;

    @SerializedName("isConnected")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 4)
    public final Boolean i;

    /* JADX INFO: compiled from: SubscribeWsStatusResponse.java */
    public static final class a extends Message.Builder<av, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f33413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f33414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f33415c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f33416d;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33413a = 0;
            this.f33414b = 0;
            this.f33415c = 0;
            this.f33416d = false;
        }

        public a a(Integer r1) {
            this.f33413a = r1;
            return this;
        }

        public a b(Integer r1) {
            this.f33414b = r1;
            return this;
        }

        public a c(Integer r1) {
            this.f33415c = r1;
            return this;
        }

        public a a(Boolean r1) {
            this.f33416d = r1;
            return this;
        }

        public av a() {
            return new av(this.f33413a, this.f33414b, this.f33415c, this.f33416d, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: SubscribeWsStatusResponse.java */
    private static final class b extends ProtoAdapter<av> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ av decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, av r4) {
            a(r3, (av) ZeusTransformUtils.preCheckCast(r4, av.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(av r3) {
            return a((av) ZeusTransformUtils.preCheckCast(r3, av.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ av redact(av r3) {
            return b((av) ZeusTransformUtils.preCheckCast(r3, av.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, av.class);
        }

        public int a(av r4) {
            return (((ProtoAdapter.INT32.encodedSizeWithTag(1, r4.f) + ProtoAdapter.INT32.encodedSizeWithTag(2, r4.g)) + ProtoAdapter.INT32.encodedSizeWithTag(3, r4.h)) + ProtoAdapter.BOOL.encodedSizeWithTag(4, r4.i)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r3, av r4) {
            ProtoAdapter.INT32.encodeWithTag(r3, 1, r4.f);
            ProtoAdapter.INT32.encodeWithTag(r3, 2, r4.g);
            ProtoAdapter.INT32.encodeWithTag(r3, 3, r4.h);
            ProtoAdapter.BOOL.encodeWithTag(r3, 4, r4.i);
            r3.writeBytes(r4.unknownFields());
        }

        public av a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L18;
            if (r2 != 1) goto L8;
            r5.a((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r6), Integer.class, "com.obric.aiagent.plugin"));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.b((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r6), Integer.class, "com.obric.aiagent.plugin"));
            goto L3
        L10:
            if (r2 != 3) goto L12;
            r5.c((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r6), Integer.class, "com.obric.aiagent.plugin"));
            goto L3
        L12:
            if (r2 != 4) goto L13;
            r5.a((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r6), Boolean.class, "com.obric.aiagent.plugin"));
            goto L3
        L13:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L18:
            r6.endMessage(r0);
            return r5.a();
        }

        public av b(av r1) {
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
        f33408a = new b();
        f33409b = 0;
        f33410c = 0;
        f33411d = 0;
        f33412e = false;
    }

    public av(Integer r2, Integer r3, Integer r4, Boolean r5, e.h r6) {
        super(f33408a, r6);
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
    }

    public a a() {
        a r0 = new a();
        r0.f33413a = this.f;
        r0.f33414b = this.g;
        r0.f33415c = this.h;
        r0.f33416d = this.i;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, av.class) == true) goto L8;
        return false;
    L8:
        av r6 = (av) ZeusTransformUtils.preCheckCast(r5, av.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L20;
        if (Internal.equals(this.f, r6.f) == false) goto L20;
        if (Internal.equals(this.g, r6.g) == false) goto L20;
        if (Internal.equals(this.h, r6.h) == false) goto L20;
        if (Internal.equals(this.i, r6.i) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.g;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Integer r9 = this.h;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Boolean r12 = this.i;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = r11 + r3;
        this.hashCode = r13;
        return r13;
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L21:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.f == null) goto L6;
        r0.append(", channelType=").append(this.f);
    L6:
        if (this.g == null) goto L9;
        r0.append(", connectionState=").append(this.g);
    L9:
        if (this.h == null) goto L12;
        r0.append(", channelId=").append(this.h);
    L12:
        if (this.i == null) goto L15;
        r0.append(", isConnected=").append(this.i);
    L15:
        return r0.replace(0, 2, "SubscribeWsStatusResponse{").append('}').toString();
    }
}
