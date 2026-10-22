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

/* JADX INFO: compiled from: RefreshLocationResponse.java */
/* JADX INFO: loaded from: classes4.dex */
public final class aa extends Message<aa, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProtoAdapter<aa> f33258a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Integer f33259b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Integer f33260c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("resultCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer f33261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("resultMsg")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer f33262e;

    /* JADX INFO: compiled from: RefreshLocationResponse.java */
    public static final class a extends Message.Builder<aa, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f33263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f33264b;

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a() {
            this.f33263a = 0;
            this.f33264b = 0;
        }

        public a a(Integer r1) {
            this.f33263a = r1;
            return this;
        }

        public a b(Integer r1) {
            this.f33264b = r1;
            return this;
        }

        public aa a() {
            return new aa(this.f33263a, this.f33264b, super.buildUnknownFields());
        }
    }

    /* JADX INFO: compiled from: RefreshLocationResponse.java */
    private static final class b extends ProtoAdapter<aa> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ aa decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, aa r4) {
            a(r3, (aa) ZeusTransformUtils.preCheckCast(r4, aa.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(aa r3) {
            return a((aa) ZeusTransformUtils.preCheckCast(r3, aa.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ aa redact(aa r3) {
            return b((aa) ZeusTransformUtils.preCheckCast(r3, aa.class, "com.obric.aiagent.plugin"));
        }

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, aa.class);
        }

        public int a(aa r4) {
            return (ProtoAdapter.INT32.encodedSizeWithTag(1, r4.f33261d) + ProtoAdapter.INT32.encodedSizeWithTag(2, r4.f33262e)) + r4.unknownFields().k();
        }

        public void a(ProtoWriter r3, aa r4) {
            ProtoAdapter.INT32.encodeWithTag(r3, 1, r4.f33261d);
            ProtoAdapter.INT32.encodeWithTag(r3, 2, r4.f33262e);
            r3.writeBytes(r4.unknownFields());
        }

        public aa a(ProtoReader r6) {
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
            r5.b((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r6), Integer.class, "com.obric.aiagent.plugin"));
            goto L3
        L9:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L12:
            r6.endMessage(r0);
            return r5.a();
        }

        public aa b(aa r1) {
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
        f33258a = new b();
        f33259b = 0;
        f33260c = 0;
    }

    public aa(Integer r2, Integer r3, e.h r4) {
        super(f33258a, r4);
        this.f33261d = r2;
        this.f33262e = r3;
    }

    public a a() {
        a r0 = new a();
        r0.f33263a = this.f33261d;
        r0.f33264b = this.f33262e;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, aa.class) == true) goto L8;
        return false;
    L8:
        aa r6 = (aa) ZeusTransformUtils.preCheckCast(r5, aa.class, "com.obric.aiagent.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.f33261d, r6.f33261d) == false) goto L16;
        if (Internal.equals(this.f33262e, r6.f33262e) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.f33261d;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.f33262e;
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
        if (this.f33261d == null) goto L6;
        r0.append(", resultCode=").append(this.f33261d);
    L6:
        if (this.f33262e == null) goto L9;
        r0.append(", resultMsg=").append(this.f33262e);
    L9:
        return r0.replace(0, 2, "RefreshLocationResponse{").append('}').toString();
    }
}
