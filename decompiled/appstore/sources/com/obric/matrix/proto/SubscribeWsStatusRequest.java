package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class SubscribeWsStatusRequest extends Message<SubscribeWsStatusRequest, a> {
    public static final ProtoAdapter<SubscribeWsStatusRequest> ADAPTER = null;
    public static final Integer DEFAULT_OPT = null;
    public static final String DEFAULT_PACKAGENAME = "";
    private static final long serialVersionUID = 0;

    @SerializedName("opt")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer opt;

    @SerializedName("packageName")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String packageName;

    public static final class a extends Message.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f12177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12178b;

        public a() {
            this.f12177a = 0;
            this.f12178b = "";
        }

        public SubscribeWsStatusRequest a() {
            return new SubscribeWsStatusRequest(this.f12177a, this.f12178b, super.buildUnknownFields());
        }

        public a b(Integer r10) {
            this.f12177a = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(String r10) {
            this.f12178b = r10;
            return this;
        }
    }

    public static final class b extends ProtoAdapter {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsStatusRequest.class);
        }

        public SubscribeWsStatusRequest a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L12;
            if (r13 != 1) goto L8;
            r11.b(ProtoAdapter.INT32.decode(r10));
            goto L3
        L8:
            if (r13 != 2) goto L9;
            r11.c(ProtoAdapter.STRING.decode(r10));
            goto L3
        L9:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L12:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, SubscribeWsStatusRequest r11) {
            ProtoAdapter.INT32.encodeWithTag(r10, 1, r11.opt);
            ProtoAdapter.STRING.encodeWithTag(r10, 2, r11.packageName);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(SubscribeWsStatusRequest r10) {
            return (ProtoAdapter.INT32.encodedSizeWithTag(1, r10.opt) + ProtoAdapter.STRING.encodedSizeWithTag(2, r10.packageName)) + r10.unknownFields().size();
        }

        public SubscribeWsStatusRequest d(SubscribeWsStatusRequest r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) {
            b(r10, (SubscribeWsStatusRequest) r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
            return c((SubscribeWsStatusRequest) r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r10) {
            return d((SubscribeWsStatusRequest) r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_OPT = 0;
    }

    public SubscribeWsStatusRequest(Integer r10, String r11) {
        this(r10, r11, ByteString.EMPTY);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof SubscribeWsStatusRequest) == true) goto L8;
        return false;
    L8:
        SubscribeWsStatusRequest r11 = (SubscribeWsStatusRequest) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L16;
        if (Internal.equals(this.opt, r11.opt) == false) goto L16;
        if (Internal.equals(this.packageName, r11.packageName) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L13;
        int r11 = unknownFields().hashCode() * 37;
        Integer r12 = this.opt;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        String r16 = this.packageName;
        if (r16 == null) goto L11;
        r13 = r16.hashCode();
    L11:
        int r17 = r15 + r13;
        this.hashCode = r17;
        return r17;
    L7:
        r14 = 0;
        goto L8
    L13:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.opt == null) goto L6;
        r10.append(", opt=");
        r10.append(this.opt);
    L6:
        if (this.packageName == null) goto L8;
        r10.append(", packageName=");
        r10.append(this.packageName);
    L8:
        StringBuilder r11 = r10.replace(0, 2, "SubscribeWsStatusRequest{");
        r11.append('}');
        return r11.toString();
    }

    public SubscribeWsStatusRequest(Integer r10, String r11, ByteString r12) {
        super(ADAPTER, r12);
        this.opt = r10;
        this.packageName = r11;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f12177a = this.opt;
        r10.f12178b = this.packageName;
        r10.addUnknownFields(unknownFields());
        return r10;
    }
}
